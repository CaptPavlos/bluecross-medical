package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ProfileTranscoder {
    private static final int FIRST_FLAG = 1;
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int LAST_FLAG = 4;
    static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    private ProfileTranscoder() {
    }

    private static int computeMethodFlags(@NonNull DexProfileData dexProfileData) {
        Iterator<Map.Entry<Integer, Integer>> it = dexProfileData.methods.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    @NonNull
    private static byte[] createCompressibleBody(@NonNull DexProfileData[] dexProfileDataArr, @NonNull byte[] bArr) throws IOException {
        int i10 = 0;
        int iUtf8Length = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            iUtf8Length += (dexProfileData.classSetSize * 2) + Encoding.utf8Length(generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr)) + 16 + dexProfileData.hotMethodRegionSize + getMethodBitmapStorageSize(dexProfileData.numMethodIds);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iUtf8Length);
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            int length = dexProfileDataArr.length;
            while (i10 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i10];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i10++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i10 < length2) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iUtf8Length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.error("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iUtf8Length);
    }

    private static WritableFileSection createCompressibleClassSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dexProfileDataArr.length; i11++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i11];
                Encoding.writeUInt16(byteArrayOutputStream, i11);
                Encoding.writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
                i10 = i10 + 4 + (dexProfileData.classSetSize * 2);
                writeClasses(byteArrayOutputStream, dexProfileData);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.error("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    private static WritableFileSection createCompressibleMethodsSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dexProfileDataArr.length; i11++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i11];
                int iComputeMethodFlags = computeMethodFlags(dexProfileData);
                byte[] bArrCreateMethodBitmapRegionForS = createMethodBitmapRegionForS(iComputeMethodFlags, dexProfileData);
                byte[] bArrCreateMethodsWithInlineCaches = createMethodsWithInlineCaches(dexProfileData);
                Encoding.writeUInt16(byteArrayOutputStream, i11);
                int length = bArrCreateMethodBitmapRegionForS.length + 2 + bArrCreateMethodsWithInlineCaches.length;
                Encoding.writeUInt32(byteArrayOutputStream, length);
                Encoding.writeUInt16(byteArrayOutputStream, iComputeMethodFlags);
                byteArrayOutputStream.write(bArrCreateMethodBitmapRegionForS);
                byteArrayOutputStream.write(bArrCreateMethodsWithInlineCaches);
                i10 = i10 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.error("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] createMethodBitmapRegionForS(int i10, @NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodBitmapForS(byteArrayOutputStream, i10, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] createMethodsWithInlineCaches(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    private static String enforceSeparator(@NonNull String str, @NonNull String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    @NonNull
    private static String extractKey(@NonNull String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    @Nullable
    private static DexProfileData findByDexName(@NonNull DexProfileData[] dexProfileDataArr, @NonNull String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String strExtractKey = extractKey(str);
        for (int i10 = 0; i10 < dexProfileDataArr.length; i10++) {
            if (dexProfileDataArr[i10].dexName.equals(strExtractKey)) {
                return dexProfileDataArr[i10];
            }
        }
        return null;
    }

    @NonNull
    private static String generateDexKey(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String strDexKeySeparator = ProfileVersion.dexKeySeparator(bArr);
        if (str.length() <= 0) {
            return enforceSeparator(str2, strDexKeySeparator);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return enforceSeparator(str2, strDexKeySeparator);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        StringBuilder sbV = a3.a.v(str);
        sbV.append(ProfileVersion.dexKeySeparator(bArr));
        sbV.append(str2);
        return sbV.toString();
    }

    private static int getMethodBitmapStorageSize(int i10) {
        return roundUpToByte(i10 * 2) / 8;
    }

    private static int getMethodBitmapStorageSizeForS(int i10, int i11) {
        return roundUpToByte(Integer.bitCount(i10 & (-2)) * i11) / 8;
    }

    private static int methodFlagBitmapIndex(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw Encoding.error("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw Encoding.error(a3.a.f(i10, "Unexpected flag: "));
    }

    private static int[] readClasses(@NonNull InputStream inputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int uInt16 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            uInt16 += Encoding.readUInt16(inputStream);
            iArr[i11] = uInt16;
        }
        return iArr;
    }

    private static int readFlagsFromBitmap(@NonNull BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(methodFlagBitmapIndex(2, i10, i11)) ? 2 : 0;
        return bitSet.get(methodFlagBitmapIndex(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] readHeader(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, Encoding.read(inputStream, bArr.length))) {
            return Encoding.read(inputStream, ProfileVersion.V010_P.length);
        }
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int iAvailable = inputStream.available() - dexProfileData.hotMethodRegionSize;
        int uInt16 = 0;
        while (inputStream.available() > iAvailable) {
            uInt16 += Encoding.readUInt16(inputStream);
            dexProfileData.methods.put(Integer.valueOf(uInt16), 1);
            for (int uInt162 = Encoding.readUInt16(inputStream); uInt162 > 0; uInt162--) {
                skipInlineCache(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw Encoding.error("Read too much data during profile line parse");
        }
    }

    @NonNull
    public static DexProfileData[] readMeta(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            if (Arrays.equals(ProfileVersion.V015_S, bArr2)) {
                throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return readMetadata001(inputStream, bArr, dexProfileDataArr);
        }
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V002)) {
            return readMetadataV002(inputStream, bArr2, dexProfileDataArr);
        }
        throw Encoding.error("Unsupported meta version");
    }

    @NonNull
    public static DexProfileData[] readMetadata001(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (!Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            throw Encoding.error("Unsupported meta version");
        }
        int uInt8 = Encoding.readUInt8(inputStream);
        byte[] compressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.error("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] metadataForNBody = readMetadataForNBody(byteArrayInputStream, uInt8, dexProfileDataArr);
            byteArrayInputStream.close();
            return metadataForNBody;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    private static DexProfileData[] readMetadataForNBody(@NonNull InputStream inputStream, int i10, DexProfileData[] dexProfileDataArr) throws IOException {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i10 != dexProfileDataArr.length) {
            throw Encoding.error("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int uInt16 = Encoding.readUInt16(inputStream);
            iArr[i11] = Encoding.readUInt16(inputStream);
            strArr[i11] = Encoding.readString(inputStream, uInt16);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            DexProfileData dexProfileData = dexProfileDataArr[i12];
            if (!dexProfileData.dexName.equals(strArr[i12])) {
                throw Encoding.error("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            dexProfileData.classSetSize = i13;
            dexProfileData.classes = readClasses(inputStream, i13);
        }
        return dexProfileDataArr;
    }

    @NonNull
    public static DexProfileData[] readMetadataV002(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int uInt16 = Encoding.readUInt16(inputStream);
        byte[] compressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.error("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] metadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr, uInt16, dexProfileDataArr);
            byteArrayInputStream.close();
            return metadataV002Body;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    private static DexProfileData[] readMetadataV002Body(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i10, DexProfileData[] dexProfileDataArr) throws IOException {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i10 != dexProfileDataArr.length) {
            throw Encoding.error("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Encoding.readUInt16(inputStream);
            String string = Encoding.readString(inputStream, Encoding.readUInt16(inputStream));
            long uInt32 = Encoding.readUInt32(inputStream);
            int uInt16 = Encoding.readUInt16(inputStream);
            DexProfileData dexProfileDataFindByDexName = findByDexName(dexProfileDataArr, string);
            if (dexProfileDataFindByDexName == null) {
                throw Encoding.error(a3.a.i("Missing profile key: ", string));
            }
            dexProfileDataFindByDexName.mTypeIdCount = uInt32;
            int[] classes = readClasses(inputStream, uInt16);
            if (Arrays.equals(bArr, ProfileVersion.V001_N)) {
                dexProfileDataFindByDexName.classSetSize = uInt16;
                dexProfileDataFindByDexName.classes = classes;
            }
        }
        return dexProfileDataArr;
    }

    private static void readMethodBitmap(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        BitSet bitSetValueOf = BitSet.valueOf(Encoding.read(inputStream, Encoding.bitsToBytes(dexProfileData.numMethodIds * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dexProfileData.numMethodIds;
            if (i10 >= i11) {
                return;
            }
            int flagsFromBitmap = readFlagsFromBitmap(bitSetValueOf, i10, i11);
            if (flagsFromBitmap != 0) {
                Integer num = dexProfileData.methods.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                dexProfileData.methods.put(Integer.valueOf(i10), Integer.valueOf(flagsFromBitmap | num.intValue()));
            }
            i10++;
        }
    }

    @NonNull
    public static DexProfileData[] readProfile(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (!Arrays.equals(bArr, ProfileVersion.V010_P)) {
            throw Encoding.error("Unsupported version");
        }
        int uInt8 = Encoding.readUInt8(inputStream);
        byte[] compressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.error("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] uncompressedBody = readUncompressedBody(byteArrayInputStream, str, uInt8);
            byteArrayInputStream.close();
            return uncompressedBody;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    private static DexProfileData[] readUncompressedBody(@NonNull InputStream inputStream, @NonNull String str, int i10) throws IOException {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int uInt16 = Encoding.readUInt16(inputStream);
            int uInt162 = Encoding.readUInt16(inputStream);
            dexProfileDataArr[i11] = new DexProfileData(str, Encoding.readString(inputStream, uInt16), Encoding.readUInt32(inputStream), 0L, uInt162, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream), new int[uInt162], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            DexProfileData dexProfileData = dexProfileDataArr[i12];
            readHotMethodRegion(inputStream, dexProfileData);
            dexProfileData.classes = readClasses(inputStream, dexProfileData.classSetSize);
            readMethodBitmap(inputStream, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static int roundUpToByte(int i10) {
        return (i10 + 7) & (-8);
    }

    private static void setMethodBitmapBit(@NonNull byte[] bArr, int i10, int i11, @NonNull DexProfileData dexProfileData) {
        int iMethodFlagBitmapIndex = methodFlagBitmapIndex(i10, i11, dexProfileData.numMethodIds);
        int i12 = iMethodFlagBitmapIndex / 8;
        bArr[i12] = (byte) ((1 << (iMethodFlagBitmapIndex % 8)) | bArr[i12]);
    }

    private static void skipInlineCache(@NonNull InputStream inputStream) throws IOException {
        Encoding.readUInt16(inputStream);
        int uInt8 = Encoding.readUInt8(inputStream);
        if (uInt8 == 6 || uInt8 == 7) {
            return;
        }
        while (uInt8 > 0) {
            Encoding.readUInt8(inputStream);
            for (int uInt82 = Encoding.readUInt8(inputStream); uInt82 > 0; uInt82--) {
                Encoding.readUInt16(inputStream);
            }
            uInt8--;
        }
    }

    public static boolean transcodeAndWriteBody(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V015_S)) {
            writeProfileForS(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            writeProfileForP(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.V005_O)) {
            writeProfileForO(outputStream, dexProfileDataArr);
            return true;
        }
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            writeProfileForO_MR1(outputStream, dexProfileDataArr);
            return true;
        }
        if (!Arrays.equals(bArr, ProfileVersion.V001_N)) {
            return false;
        }
        writeProfileForN(outputStream, dexProfileDataArr);
        return true;
    }

    private static void writeClasses(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int[] iArr = dexProfileData.classes;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            Encoding.writeUInt16(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    private static WritableFileSection writeDexFileSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            int i10 = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.writeUInt32(byteArrayOutputStream, dexProfileData.dexChecksum);
                Encoding.writeUInt32(byteArrayOutputStream, dexProfileData.mTypeIdCount);
                Encoding.writeUInt32(byteArrayOutputStream, dexProfileData.numMethodIds);
                String strGenerateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V015_S);
                int iUtf8Length = Encoding.utf8Length(strGenerateDexKey);
                Encoding.writeUInt16(byteArrayOutputStream, iUtf8Length);
                i10 = i10 + 14 + iUtf8Length;
                Encoding.writeString(byteArrayOutputStream, strGenerateDexKey);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.error("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void writeHeader(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(MAGIC_PROF);
        outputStream.write(bArr);
    }

    private static void writeLineData(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        writeMethodsWithInlineCaches(outputStream, dexProfileData);
        writeClasses(outputStream, dexProfileData);
        writeMethodBitmap(outputStream, dexProfileData);
    }

    private static void writeLineHeader(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData, @NonNull String str) throws IOException {
        Encoding.writeUInt16(outputStream, Encoding.utf8Length(str));
        Encoding.writeUInt16(outputStream, dexProfileData.classSetSize);
        Encoding.writeUInt32(outputStream, dexProfileData.hotMethodRegionSize);
        Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
        Encoding.writeUInt32(outputStream, dexProfileData.numMethodIds);
        Encoding.writeString(outputStream, str);
    }

    private static void writeMethodBitmap(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSize(dexProfileData.numMethodIds)];
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                setMethodBitmapBit(bArr, 2, iIntValue, dexProfileData);
            }
            if ((iIntValue2 & 4) != 0) {
                setMethodBitmapBit(bArr, 4, iIntValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    private static void writeMethodBitmapForS(@NonNull OutputStream outputStream, int i10, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSizeForS(i10, dexProfileData.numMethodIds)];
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int i11 = 0;
            for (int i12 = 1; i12 <= 4; i12 <<= 1) {
                if (i12 != 1 && (i12 & i10) != 0) {
                    if ((i12 & iIntValue2) == i12) {
                        int i13 = (dexProfileData.numMethodIds * i11) + iIntValue;
                        int i14 = i13 / 8;
                        bArr[i14] = (byte) ((1 << (i13 % 8)) | bArr[i14]);
                    }
                    i11++;
                }
            }
        }
        outputStream.write(bArr);
    }

    private static void writeMethodsWithInlineCaches(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                Encoding.writeUInt16(outputStream, iIntValue - i10);
                Encoding.writeUInt16(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    private static void writeProfileForN(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt16(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String strGenerateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V001_N);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(strGenerateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.methods.size());
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, strGenerateDexKey);
            Iterator<Integer> it = dexProfileData.methods.keySet().iterator();
            while (it.hasNext()) {
                Encoding.writeUInt16(outputStream, it.next().intValue());
            }
            for (int i10 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, i10);
            }
        }
    }

    private static void writeProfileForO(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            int size = dexProfileData.methods.size() * 4;
            String strGenerateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V005_O);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(strGenerateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, size);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, strGenerateDexKey);
            Iterator<Integer> it = dexProfileData.methods.keySet().iterator();
            while (it.hasNext()) {
                Encoding.writeUInt16(outputStream, it.next().intValue());
                Encoding.writeUInt16(outputStream, 0);
            }
            for (int i10 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, i10);
            }
        }
    }

    private static void writeProfileForO_MR1(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArrCreateCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, bArrCreateCompressibleBody);
    }

    private static void writeProfileForP(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArrCreateCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V010_P);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, bArrCreateCompressibleBody);
    }

    private static void writeProfileForS(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        writeProfileSections(outputStream, dexProfileDataArr);
    }

    private static void writeProfileSections(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(writeDexFileSection(dexProfileDataArr));
        arrayList.add(createCompressibleClassSection(dexProfileDataArr));
        arrayList.add(createCompressibleMethodsSection(dexProfileDataArr));
        long length2 = ProfileVersion.V015_S.length + MAGIC_PROF.length + 4 + (arrayList.size() * 16);
        Encoding.writeUInt32(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i10);
            Encoding.writeUInt32(outputStream, writableFileSection.mType.getValue());
            Encoding.writeUInt32(outputStream, length2);
            boolean z9 = writableFileSection.mNeedsCompression;
            byte[] bArr = writableFileSection.mContents;
            if (z9) {
                long length3 = bArr.length;
                byte[] bArrCompress = Encoding.compress(bArr);
                arrayList2.add(bArrCompress);
                Encoding.writeUInt32(outputStream, bArrCompress.length);
                Encoding.writeUInt32(outputStream, length3);
                length = bArrCompress.length;
            } else {
                arrayList2.add(bArr);
                Encoding.writeUInt32(outputStream, writableFileSection.mContents.length);
                Encoding.writeUInt32(outputStream, 0L);
                length = writableFileSection.mContents.length;
            }
            length2 += length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }
}
