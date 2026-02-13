package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, a> encoderMap;
    private q fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private final Map<String, g.b> data = new HashMap();
    private final Executor executor = new t();
    private final ArrayList<c> invalids = new ArrayList<>();
    private final b logger = r.f4030b;
    private boolean autoCommit = true;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                com.google.gson.internal.a.n("path is empty");
                throw null;
            }
            if (str2 == null || str2.isEmpty()) {
                com.google.gson.internal.a.n("name is empty");
                throw null;
            }
            this.path = str.endsWith("/") ? str : str.concat("/");
            this.name = str2;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            FastKV fastKV;
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV2 = map.get(str);
            if (fastKV2 != null) {
                return fastKV2;
            }
            synchronized (Builder.class) {
                try {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fastKV;
        }

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a<T> {
        T a(byte[] bArr, int i10, int i11);

        String a();

        byte[] a(T t);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c implements Comparable<c> {

        /* renamed from: a, reason: collision with root package name */
        int f3880a;

        /* renamed from: b, reason: collision with root package name */
        int f3881b;

        public c(int i10, int i11) {
            this.f3881b = i10;
            this.f3880a = i11;
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return this.f3881b - cVar.f3881b;
        }
    }

    static {
        int iA = ar.a();
        PAGE_SIZE = iA;
        int iMax = Math.max(iA << 1, 16384);
        DOUBLE_LIMIT = iMax;
        TRUNCATE_THRESHOLD = iMax << 1;
        TYPE_SIZE = new int[]{0, 1, 4, 4, 8, 8};
    }

    public FastKV(String str, String str2, a[] aVarArr, int i10) {
        this.path = str;
        this.name = str2;
        this.writingMode = i10;
        HashMap map = new HashMap();
        map.put("StringSet", ao.f3968a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String strA = aVar.a();
                if (map.containsKey(strA)) {
                    error(a3.a.i("duplicate encoder tag:", strA));
                } else {
                    map.put(strA, aVar);
                }
            }
        }
        this.encoderMap = map;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b10) {
        Object obj2;
        int length;
        g.b aVar;
        int iSaveArray = saveArray(str, bArr, b10);
        if (iSaveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z9 = str2 != null;
            if (z9) {
                this.tempExternalName = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b10 == 6) {
                aVar = new g.i(this.updateStart, iSaveArray, (String) obj2, length, z9);
            } else {
                int i10 = this.updateStart;
                aVar = b10 == 7 ? new g.a(i10, iSaveArray, obj2, length, z9) : new g.h(i10, iSaveArray, obj2, length, z9);
            }
            this.data.put(str, aVar);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, g.j jVar, byte b10) throws IOException {
        if (jVar == null) {
            addObject(str, obj, bArr, b10);
        } else if (jVar.f4011b || jVar.e != bArr.length) {
            updateObject(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.f4005a, bArr);
            jVar.f4013d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i10 = this.dataEnd;
        if (i10 <= 16384) {
            return 4096;
        }
        return i10 <= 65536 ? 8192 : 16384;
    }

    private void checkGC() throws IOException {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            com.google.gson.internal.a.n("key is empty");
        }
    }

    private void checkKeySize(int i10) {
        if (i10 <= 255) {
            return;
        }
        com.google.gson.internal.a.n("key's length must less than 256");
    }

    private void checkValueSize(int i10, boolean z9) {
        if (z9) {
            if (i10 == 32) {
                return;
            }
            androidx.window.layout.c.g("name size not match");
        } else if (i10 < 0 || i10 >= 2048) {
            androidx.window.layout.c.g("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        q qVar = this.fastBuffer;
        if (qVar == null || qVar.f4026a.length != PAGE_SIZE) {
            this.fastBuffer = new q(PAGE_SIZE);
        } else {
            qVar.b(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i10 = this.writingMode;
        if (i10 == 1) {
            this.executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.1
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.writeToCFile();
                }
            });
        } else if (i10 == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i10) throws IOException {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error(e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i10);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i10, int i11) {
        this.invalidBytes = (i11 - i10) + this.invalidBytes;
        this.invalids.add(new c(i10, i11));
    }

    private void deleteCFiles() {
        try {
            ar.a(new File(this.path, this.name + C_SUFFIX));
            ar.a(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e) {
            error(e);
        }
    }

    private void ensureSize(int i10) throws IOException {
        int length = this.fastBuffer.f4026a.length;
        int i11 = this.dataEnd + i10;
        if (i11 >= length) {
            int i12 = this.invalidBytes;
            if (i12 > i10 && i12 > bytesThreshold()) {
                gc(i10);
                return;
            }
            int newCapacity = getNewCapacity(length, i11);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f4026a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f4026a = bArr;
            if (this.writingMode == 0) {
                try {
                    FileChannel fileChannel = this.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j10 = newCapacity;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j10);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    this.fastBuffer.b(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, new Exception(str));
        }
    }

    private void fastPutString(String str, String str2, g.i iVar) throws IOException {
        int iA = q.a(str2);
        if (iVar == null) {
            int iA2 = q.a(str);
            checkKeySize(iA2);
            int i10 = iA2 + 4;
            this.updateSize = i10 + iA;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, iA2);
            putStringValue(str2, iA);
            Map<String, g.b> map = this.data;
            int i11 = this.updateStart;
            map.put(str, new g.i(i11, i10 + i11, str2, iA, false));
            updateChange();
        } else {
            int i12 = iVar.f4005a;
            int i13 = i12 - iVar.f4012c;
            int i14 = iVar.e;
            boolean z9 = false;
            if (i14 == iA) {
                this.checksum = this.fastBuffer.a(i12, i14) ^ this.checksum;
                int length = str2.length();
                q qVar = this.fastBuffer;
                if (iA == length) {
                    str2.getBytes(0, iA, qVar.f4026a, iVar.f4005a);
                } else {
                    qVar.f4027b = iVar.f4005a;
                    qVar.b(str2);
                }
                this.updateStart = iVar.f4005a;
                this.updateSize = iA;
            } else {
                this.updateSize = i13 + iA;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i15 = i13 - 3;
                q qVar2 = this.fastBuffer;
                byte[] bArr = qVar2.f4026a;
                System.arraycopy(bArr, iVar.f4012c + 1, bArr, qVar2.f4027b, i15);
                this.fastBuffer.f4027b += i15;
                putStringValue(str2, iA);
                remove((byte) 6, iVar.f4012c, iVar.f4005a + iVar.e);
                str = iVar.f4011b ? (String) iVar.f4013d : null;
                iVar.f4011b = false;
                int i16 = this.updateStart;
                iVar.f4012c = i16;
                iVar.f4005a = i16 + i13;
                iVar.e = iA;
                z9 = true;
            }
            iVar.f4013d = str2;
            updateChange();
            if (z9) {
                checkGC();
            }
            if (str != null) {
                ar.a(new File(this.path + this.name, str));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(g.a aVar) {
        try {
            byte[] bArrB = ar.b(new File(this.path + this.name, (String) aVar.f4013d));
            return bArrB != null ? bArrB : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i10, int i11) {
        if (i11 > DATA_SIZE_LIMIT) {
            androidx.window.layout.c.g("data size out of limit");
            return 0;
        }
        int i12 = PAGE_SIZE;
        if (i11 <= i12) {
            return i12;
        }
        while (i10 < i11) {
            int i13 = DOUBLE_LIMIT;
            i10 = i10 <= i13 ? i10 << 1 : i10 + i13;
        }
        return i10;
    }

    private Object getObjectFromFile(g.h hVar) {
        try {
            byte[] bArrB = ar.b(new File(this.path + this.name, (String) hVar.f4013d));
            if (bArrB == null) {
                warning(new Exception("Read object data failed"));
                return null;
            }
            int i10 = bArrB[0] & 255;
            String str = new String(bArrB, 1, i10, StandardCharsets.UTF_8);
            a aVar = this.encoderMap.get(str);
            if (aVar != null) {
                int i11 = i10 + 1;
                return aVar.a(bArrB, i11, bArrB.length - i11);
            }
            warning(new Exception("No encoder for tag:".concat(str)));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    private String getStringFromFile(g.i iVar) {
        try {
            byte[] bArrB = ar.b(new File(this.path + this.name, (String) iVar.f4013d));
            return (bArrB == null || bArrB.length == 0) ? "" : new String(bArrB, StandardCharsets.UTF_8);
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        q qVar = new q(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(qVar.f4026a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f4026a;
        byte[] bArr2 = qVar.f4026a;
        for (int i10 = 0; i10 < this.dataEnd; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        try {
            long jNanoTime = System.nanoTime();
            if (!loadFromCFile() && this.writingMode == 0) {
                loadFromABFile();
            }
            if (this.fastBuffer == null) {
                this.fastBuffer = new q(PAGE_SIZE);
            }
            if (this.logger != null) {
                info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void loadFromABFile() throws IOException {
        long j10;
        File file = new File(this.path, a3.a.o(new StringBuilder(), this.name, A_SUFFIX));
        File file2 = new File(this.path, a3.a.o(new StringBuilder(), this.name, B_SUFFIX));
        try {
            if (ar.c(file) && ar.c(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                try {
                    FileChannel fileChannel = this.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : PAGE_SIZE);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                    this.fastBuffer = new q(this.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        this.dataEnd = 12;
                        return;
                    }
                    int i10 = this.aBuffer.getInt();
                    long j11 = this.aBuffer.getLong();
                    int i11 = this.bBuffer.getInt();
                    long j12 = this.bBuffer.getLong();
                    if (i10 < 0) {
                        j10 = 12;
                    } else if (i10 <= length - 12) {
                        this.dataEnd = i10 + 12;
                        this.aBuffer.rewind();
                        j10 = 12;
                        this.aBuffer.get(this.fastBuffer.f4026a, 0, this.dataEnd);
                        if (j11 == this.fastBuffer.a(12, i10) && parseData() == 0) {
                            this.checksum = j11;
                            if (length == length2 && isABFileEqual()) {
                                return;
                            }
                            warning(new Exception("B file error"));
                            copyBuffer(this.aBuffer, this.bBuffer, this.dataEnd);
                            return;
                        }
                    } else {
                        j10 = 12;
                    }
                    if (i11 >= 0 && i11 <= length2 - j10) {
                        this.data.clear();
                        clearInvalid();
                        this.dataEnd = i11 + 12;
                        if (this.fastBuffer.f4026a.length != this.bBuffer.capacity()) {
                            this.fastBuffer = new q(this.bBuffer.capacity());
                        }
                        this.bBuffer.rewind();
                        this.bBuffer.get(this.fastBuffer.f4026a, 0, this.dataEnd);
                        if (j12 == this.fastBuffer.a(12, i11) && parseData() == 0) {
                            warning(new Exception("A file error"));
                            copyBuffer(this.bBuffer, this.aBuffer, this.dataEnd);
                            this.checksum = j12;
                            return;
                        }
                    }
                    error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e) {
                    error(e);
                    toBlockingMode();
                    tryBlockingIO(file, file2);
                    return;
                }
            }
            error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e3) {
            error(e3);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, a3.a.o(new StringBuilder(), this.name, C_SUFFIX));
        File file2 = new File(this.path, a3.a.o(new StringBuilder(), this.name, TEMP_SUFFIX));
        boolean z9 = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                }
                if (this.writingMode == 0) {
                    if (!writeToABFile(this.fastBuffer)) {
                        this.writingMode = 1;
                        return false;
                    }
                    info("recover from c file");
                    try {
                        deleteCFiles();
                        return true;
                    } catch (Exception e) {
                        e = e;
                        z9 = true;
                        error(e);
                        return z9;
                    }
                }
            } else if (this.writingMode != 0) {
                File file3 = new File(this.path, this.name + A_SUFFIX);
                File file4 = new File(this.path, this.name + B_SUFFIX);
                if (file3.exists() && file4.exists()) {
                    tryBlockingIO(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i10 = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i10);
            q qVar = this.fastBuffer;
            if (qVar == null || qVar.f4026a.length != newCapacity) {
                qVar = new q(new byte[newCapacity]);
                this.fastBuffer = qVar;
            } else {
                qVar.f4027b = 0;
            }
            ar.a(file, qVar.f4026a, i10);
            int iC = qVar.c();
            long jB = qVar.b();
            this.dataEnd = iC + 12;
            if (iC >= 0 && iC <= i10 - 12 && jB == qVar.a(12, iC) && parseData() == 0) {
                this.checksum = jB;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            int i10 = size - 1;
            c cVar2 = this.invalids.get(i10);
            if (cVar.f3881b == cVar2.f3880a) {
                cVar2.f3880a = cVar.f3880a;
                this.invalids.remove(size);
            }
            cVar = cVar2;
            size = i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x017d, code lost:
    
        throw new java.lang.Exception(com.mbridge.msdk.foundation.tools.FastKV.PARSE_DATA_FAILED);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseData() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.parseData():int");
    }

    private void preparePutBytes() throws IOException {
        ensureSize(this.updateSize);
        int i10 = this.dataEnd;
        this.updateStart = i10;
        this.dataEnd = this.updateSize + i10;
        this.fastBuffer.f4027b = i10;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i10) {
        this.fastBuffer.a((byte) i10);
        int length = str.length();
        q qVar = this.fastBuffer;
        if (i10 != length) {
            qVar.b(str);
            return;
        }
        str.getBytes(0, i10, qVar.f4026a, qVar.f4027b);
        this.fastBuffer.f4027b += i10;
    }

    private void putStringValue(String str, int i10) {
        this.fastBuffer.a((short) i10);
        int length = str.length();
        q qVar = this.fastBuffer;
        if (i10 == length) {
            str.getBytes(0, i10, qVar.f4026a, qVar.f4027b);
        } else {
            qVar.b(str);
        }
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int iCapacity = mappedByteBuffer.capacity();
        int i10 = PAGE_SIZE;
        if (iCapacity != i10) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate(i10);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i10);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        ar.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b10) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b10);
        }
        StringBuilder sbY = a3.a.y("large value, key: ", str, ", size: ");
        sbY.append(bArr.length);
        info(sbY.toString());
        String strB = ar.b();
        if (!ar.a(new File(this.path + this.name, strB), bArr)) {
            error("save large value failed");
            return 0;
        }
        this.tempExternalName = strB;
        byte[] bArr2 = new byte[32];
        strB.getBytes(0, 32, bArr2, 0);
        return wrapArray(str, bArr2, (byte) (b10 | 64));
    }

    private long shiftCheckSum(long j10, int i10) {
        int i11 = (i10 & 7) << 3;
        return (j10 >>> (64 - i11)) | (j10 << i11);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i10 = this.removeStart;
        if (i10 != 0) {
            mappedByteBuffer.put(i10, this.fastBuffer.f4026a[i10]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f4026a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        ar.a(this.aChannel);
        ar.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i10) throws IOException {
        int i11 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i11, i10 + i11);
        byte[] bArr = this.fastBuffer.f4026a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f4026a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j10 = newCapacity;
                this.aChannel.truncate(j10);
                FileChannel fileChannel = this.aChannel;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j10);
                MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j10);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e) {
                error(new Exception(MAP_FAILED, e));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e3) {
            warning(e3);
        }
        clearData();
    }

    private void updateBoolean(byte b10, int i10) {
        long jShiftCheckSum = this.checksum ^ shiftCheckSum(1L, i10);
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.put(i10, b10);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i10, b10);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.f4026a[i10] = b10;
    }

    private void updateBytes(int i10, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i10, length);
        q qVar = this.fastBuffer;
        qVar.f4027b = i10;
        qVar.a(bArr);
        long jA = this.checksum ^ this.fastBuffer.a(i10, length);
        this.checksum = jA;
        if (this.writingMode != 0) {
            this.fastBuffer.a(4, jA);
            return;
        }
        this.aBuffer.putInt(0, -1);
        this.aBuffer.putLong(4, this.checksum);
        this.aBuffer.position(i10);
        this.aBuffer.put(bArr);
        this.aBuffer.putInt(0, this.dataEnd - 12);
        this.bBuffer.putLong(4, this.checksum);
        this.bBuffer.position(i10);
        this.bBuffer.put(bArr);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i10, long j10, int i11) {
        long jShiftCheckSum = shiftCheckSum(j10, i11) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putInt(i11, i10);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i11, i10);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.b(i11, i10);
    }

    private void updateInt64(long j10, long j11, int i10) {
        long jShiftCheckSum = shiftCheckSum(j11, i10) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putLong(i10, j10);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i10, j10);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a(i10, j10);
    }

    private void updateObject(String str, Object obj, byte[] bArr, g.j jVar) throws IOException {
        int iSaveArray = saveArray(str, bArr, jVar.a());
        if (iSaveArray != 0) {
            String str2 = jVar.f4011b ? (String) jVar.f4013d : null;
            remove(jVar.a(), jVar.f4012c, jVar.f4005a + jVar.e);
            String str3 = this.tempExternalName;
            boolean z9 = str3 != null;
            jVar.f4012c = this.updateStart;
            jVar.f4005a = iSaveArray;
            jVar.f4011b = z9;
            if (z9) {
                jVar.f4013d = str3;
                jVar.e = 32;
                this.tempExternalName = null;
            } else {
                jVar.f4013d = obj;
                jVar.e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                ar.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i10, int[] iArr) {
        for (g.b bVar : this.data.values()) {
            int i11 = bVar.f4005a;
            if (i11 > i10) {
                int length = (iArr.length >> 1) - 1;
                int i12 = 0;
                while (true) {
                    if (i12 > length) {
                        break;
                    }
                    int i13 = (i12 + length) >>> 1;
                    int i14 = iArr[i13 << 1];
                    if (i14 >= i11) {
                        if (i14 <= i11) {
                            length = i13;
                            break;
                        }
                        length = i13 - 1;
                    } else {
                        i12 = i13 + 1;
                    }
                }
                int i15 = iArr[(length << 1) + 1];
                bVar.f4005a -= i15;
                if (bVar.a() >= 6) {
                    ((g.j) bVar).f4012c -= i15;
                }
            }
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b10) throws IOException {
        wrapHeader(str, b10, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        q qVar = this.fastBuffer;
        int i10 = qVar.f4027b;
        qVar.a(bArr);
        return i10;
    }

    private void wrapHeader(String str, byte b10, int i10) throws IOException {
        int iA = q.a(str);
        checkKeySize(iA);
        this.updateSize = iA + 2 + i10;
        preparePutBytes();
        this.fastBuffer.a(b10);
        putKey(str, iA);
    }

    private boolean writeToABFile(q qVar) throws Exception {
        int length = qVar.f4026a.length;
        File file = new File(this.path, a3.a.o(new StringBuilder(), this.name, A_SUFFIX));
        File file2 = new File(this.path, a3.a.o(new StringBuilder(), this.name, B_SUFFIX));
        try {
            if (!ar.c(file) || !ar.c(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j10 = length;
            randomAccessFile.setLength(j10);
            randomAccessFile2.setLength(j10);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.aChannel;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j10);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(qVar.f4026a, 0, this.dataEnd);
            this.bBuffer.put(qVar.f4026a, 0, this.dataEnd);
            return true;
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            try {
                File file = new File(this.path, this.name + TEMP_SUFFIX);
                if (ar.c(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.dataEnd);
                    randomAccessFile.write(this.fastBuffer.f4026a, 0, this.dataEnd);
                    randomAccessFile.close();
                    File file2 = new File(this.path, this.name + C_SUFFIX);
                    if (!file2.exists() || file2.delete()) {
                        if (file.renameTo(file2)) {
                            return true;
                        }
                        warning(new Exception("rename failed"));
                    }
                }
            } catch (Exception e) {
                error(e);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    public void gc(int i10) throws IOException {
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i11 = cVar.f3881b;
        int i12 = this.dataEnd;
        int i13 = i12 - this.invalidBytes;
        int i14 = i13 - 12;
        int i15 = i13 - i11;
        int i16 = i12 - i11;
        boolean z9 = true;
        boolean z10 = i14 < i16 + i15;
        if (!z10) {
            this.checksum ^= this.fastBuffer.a(i11, i16);
        }
        int size = this.invalids.size();
        int i17 = size - 1;
        int i18 = this.dataEnd - this.invalids.get(i17).f3880a;
        int[] iArr = new int[(i18 > 0 ? size : i17) << 1];
        int i19 = cVar.f3881b;
        int i20 = cVar.f3880a;
        int i21 = 1;
        while (i21 < size) {
            c cVar2 = this.invalids.get(i21);
            boolean z11 = z9;
            int i22 = cVar2.f3881b - i20;
            byte[] bArr = this.fastBuffer.f4026a;
            System.arraycopy(bArr, i20, bArr, i19, i22);
            int i23 = (i21 - 1) << 1;
            iArr[i23] = i20;
            iArr[i23 + 1] = i20 - i19;
            i19 += i22;
            i20 = cVar2.f3880a;
            i21++;
            z9 = z11;
        }
        if (i18 > 0) {
            byte[] bArr2 = this.fastBuffer.f4026a;
            System.arraycopy(bArr2, i20, bArr2, i19, i18);
            int i24 = i17 << 1;
            iArr[i24] = i20;
            iArr[i24 + 1] = i20 - i19;
        }
        clearInvalid();
        if (z10) {
            this.checksum = this.fastBuffer.a(12, i14);
        } else {
            this.checksum ^= this.fastBuffer.a(i11, i15);
        }
        this.dataEnd = i13;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i11);
            this.aBuffer.put(this.fastBuffer.f4026a, i11, i15);
            this.aBuffer.putInt(0, i14);
            this.bBuffer.putInt(0, i14);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i11);
            this.bBuffer.put(this.fastBuffer.f4026a, i11, i15);
        } else {
            this.fastBuffer.b(0, i14);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i11, iArr);
        int i25 = i13 + i10;
        if (this.fastBuffer.f4026a.length - i25 > TRUNCATE_THRESHOLD) {
            truncate(i25);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, g.b> entry : this.data.entrySet()) {
            String key = entry.getKey();
            g.b value = entry.getValue();
            switch (value.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((g.c) value).f4006b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((g.f) value).f4009b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((g.e) value).f4008b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((g.C0034g) value).f4010b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((g.d) value).f4007b);
                    break;
                case 6:
                    g.i iVar = (g.i) value;
                    if (iVar.f4011b) {
                        objValueOf = getStringFromFile(iVar);
                        break;
                    } else {
                        objValueOf = iVar.f4013d;
                        break;
                    }
                case 7:
                    g.a aVar = (g.a) value;
                    if (aVar.f4011b) {
                        objValueOf = getArrayFromFile(aVar);
                        break;
                    } else {
                        objValueOf = aVar.f4013d;
                        break;
                    }
                case 8:
                    g.h hVar = (g.h) value;
                    if (hVar.f4011b) {
                        objValueOf = getObjectFromFile(hVar);
                        break;
                    } else {
                        objValueOf = ((g.h) value).f4013d;
                        break;
                    }
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        try {
            g.a aVar = (g.a) this.data.get(str);
            if (aVar != null) {
                return aVar.f4011b ? getArrayFromFile(aVar) : (byte[]) aVar.f4013d;
            }
            return bArr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean getBoolean(String str, boolean z9) {
        g.c cVar = (g.c) this.data.get(str);
        if (cVar != null) {
            z9 = cVar.f4006b;
        }
        return z9;
    }

    public synchronized double getDouble(String str, double d8) {
        g.d dVar = (g.d) this.data.get(str);
        if (dVar != null) {
            d8 = dVar.f4007b;
        }
        return d8;
    }

    public synchronized float getFloat(String str, float f) {
        g.e eVar = (g.e) this.data.get(str);
        if (eVar != null) {
            f = eVar.f4008b;
        }
        return f;
    }

    public synchronized int getInt(String str, int i10) {
        g.f fVar = (g.f) this.data.get(str);
        if (fVar != null) {
            i10 = fVar.f4009b;
        }
        return i10;
    }

    public synchronized long getLong(String str) {
        g.C0034g c0034g;
        c0034g = (g.C0034g) this.data.get(str);
        return c0034g == null ? 0L : c0034g.f4010b;
    }

    public synchronized <T> T getObject(String str) {
        try {
            g.h hVar = (g.h) this.data.get(str);
            if (hVar != null) {
                return hVar.f4011b ? (T) getObjectFromFile(hVar) : (T) hVar.f4013d;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String getString(String str, String str2) {
        try {
            g.i iVar = (g.i) this.data.get(str);
            if (iVar != null) {
                return iVar.f4011b ? getStringFromFile(iVar) : (String) iVar.f4013d;
            }
            return str2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        putArray(key, (byte[]) value);
                    } else if (map2 != null) {
                        a aVar = map2.get(value.getClass());
                        if (aVar != null) {
                            putObject(key, value, aVar);
                        } else {
                            warning(new Exception("missing encoder for type:" + value.getClass()));
                        }
                    } else {
                        warning(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void putArray(String str, byte[] bArr) throws Throwable {
        Throwable th;
        try {
            try {
                checkKey(str);
                if (bArr == null) {
                    try {
                        remove(str);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    addOrUpdate(str, bArr, bArr, (g.a) this.data.get(str), (byte) 7);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized void putBoolean(String str, boolean z9) {
        try {
            checkKey(str);
            g.c cVar = (g.c) this.data.get(str);
            if (cVar == null) {
                wrapHeader(str, (byte) 1);
                q qVar = this.fastBuffer;
                int i10 = qVar.f4027b;
                qVar.a(z9 ? (byte) 1 : (byte) 0);
                updateChange();
                this.data.put(str, new g.c(i10, z9));
                checkIfCommit();
            } else if (cVar.f4006b != z9) {
                cVar.f4006b = z9;
                updateBoolean(z9 ? (byte) 1 : (byte) 0, cVar.f4005a);
                checkIfCommit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void putDouble(String str, double d8) throws Throwable {
        Throwable th;
        try {
            try {
                checkKey(str);
                g.d dVar = (g.d) this.data.get(str);
                if (dVar != null) {
                    if (dVar.f4007b != d8) {
                        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8);
                        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.f4007b) ^ jDoubleToRawLongBits;
                        dVar.f4007b = d8;
                        updateInt64(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.f4005a);
                        checkIfCommit();
                    }
                }
                try {
                    wrapHeader(str, (byte) 5);
                    q qVar = this.fastBuffer;
                    int i10 = qVar.f4027b;
                    qVar.a(Double.doubleToRawLongBits(d8));
                    updateChange();
                    this.data.put(str, new g.d(i10, d8));
                    checkIfCommit();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized void putFloat(String str, float f) {
        try {
            checkKey(str);
            g.e eVar = (g.e) this.data.get(str);
            if (eVar == null) {
                wrapHeader(str, (byte) 3);
                q qVar = this.fastBuffer;
                int i10 = qVar.f4027b;
                qVar.b(Float.floatToRawIntBits(f));
                updateChange();
                this.data.put(str, new g.e(i10, f));
                checkIfCommit();
            } else if (eVar.f4008b != f) {
                eVar.f4008b = f;
                updateInt32(Float.floatToRawIntBits(f), (Float.floatToRawIntBits(eVar.f4008b) ^ r6) & 4294967295L, eVar.f4005a);
                checkIfCommit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void putInt(String str, int i10) {
        try {
            checkKey(str);
            g.f fVar = (g.f) this.data.get(str);
            if (fVar == null) {
                wrapHeader(str, (byte) 2);
                q qVar = this.fastBuffer;
                int i11 = qVar.f4027b;
                qVar.b(i10);
                updateChange();
                this.data.put(str, new g.f(i11, i10));
                checkIfCommit();
            } else {
                if (fVar.f4009b != i10) {
                    fVar.f4009b = i10;
                    updateInt32(i10, (r6 ^ i10) & 4294967295L, fVar.f4005a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void putLong(String str, long j10) {
        Throwable th;
        try {
            try {
                checkKey(str);
                g.C0034g c0034g = (g.C0034g) this.data.get(str);
                if (c0034g != null) {
                    long j11 = c0034g.f4010b;
                    if (j11 != j10) {
                        long j12 = j10 ^ j11;
                        c0034g.f4010b = j10;
                        updateInt64(j10, j12, c0034g.f4005a);
                        checkIfCommit();
                    }
                }
                try {
                    wrapHeader(str, (byte) 4);
                    q qVar = this.fastBuffer;
                    int i10 = qVar.f4027b;
                    qVar.a(j10);
                    updateChange();
                    this.data.put(str, new g.C0034g(i10, j10));
                    checkIfCommit();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized <T> void putObject(String str, T t, a<T> aVar) throws Throwable {
        Throwable th;
        byte[] bArrA;
        try {
            try {
                checkKey(str);
                if (aVar == null) {
                    throw new IllegalArgumentException("Encoder is null");
                }
                String strA = aVar.a();
                if (strA == null || strA.isEmpty() || strA.length() > 50) {
                    throw new IllegalArgumentException("Invalid encoder tag:" + strA);
                }
                if (!this.encoderMap.containsKey(strA)) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                }
                try {
                    if (t == null) {
                        remove(str);
                        return;
                    }
                    try {
                        bArrA = aVar.a(t);
                    } catch (Exception e) {
                        error(e);
                        bArrA = null;
                    }
                    if (bArrA == null) {
                        remove(str);
                        return;
                    }
                    int iA = q.a(strA);
                    q qVar = new q(iA + 1 + bArrA.length);
                    qVar.a((byte) iA);
                    qVar.b(strA);
                    qVar.a(bArrA);
                    addOrUpdate(str, t, qVar.f4026a, (g.h) this.data.get(str), (byte) 8);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void putString(String str, String str2) {
        Throwable th;
        try {
            try {
                checkKey(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            th = th;
            throw th;
        }
        try {
            if (str2 == null) {
                remove(str);
            } else {
                g.i iVar = (g.i) this.data.get(str);
                if (str2.length() * 3 >= 2048) {
                    addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), iVar, (byte) 6);
                }
                fastPutString(str, str2, iVar);
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                putObject(str, set, ao.f3968a);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void remove(String str) {
        try {
            g.b bVar = this.data.get(str);
            if (bVar != null) {
                this.data.remove(str);
                byte bA = bVar.a();
                String str2 = null;
                if (bA <= 5) {
                    int iA = q.a(str);
                    int i10 = bVar.f4005a;
                    remove(bA, i10 - (iA + 2), i10 + TYPE_SIZE[bA]);
                } else {
                    g.j jVar = (g.j) bVar;
                    remove(bA, jVar.f4012c, jVar.f4005a + jVar.e);
                    if (jVar.f4011b) {
                        str2 = (String) jVar.f4013d;
                    }
                }
                byte b10 = (byte) (bA | (-128));
                if (this.writingMode == 0) {
                    this.aBuffer.putLong(4, this.checksum);
                    this.aBuffer.put(this.removeStart, b10);
                    this.bBuffer.putLong(4, this.checksum);
                    this.bBuffer.put(this.removeStart, b10);
                } else {
                    this.fastBuffer.a(4, this.checksum);
                }
                this.removeStart = 0;
                if (str2 != null) {
                    ar.a(new File(this.path + this.name, str2));
                }
                checkGC();
                checkIfCommit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void error(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str, long j10) {
        g.C0034g c0034g = (g.C0034g) this.data.get(str);
        if (c0034g != null) {
            j10 = c0034g.f4010b;
        }
        return j10;
    }

    private void wrapHeader(String str, byte b10) throws IOException {
        wrapHeader(str, b10, TYPE_SIZE[b10]);
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    private void remove(byte b10, int i10, int i11) {
        countInvalid(i10, i11);
        byte[] bArr = this.fastBuffer.f4026a;
        this.checksum = (((bArr[i10] ^ r9) & 255) << ((i10 & 7) << 3)) ^ this.checksum;
        bArr[i10] = (byte) (b10 | (-128));
        this.removeStart = i10;
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }
}
