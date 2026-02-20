package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.gson.internal.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i10, String str) {
        switch (i10) {
            case EX_PARCELABLE /* -9 */:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i10 + " msg " + str);
            case EX_UNSUPPORTED_OPERATION /* -7 */:
                return new UnsupportedOperationException(str);
            case EX_NETWORK_MAIN_THREAD /* -6 */:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        a.n(t.getClass().getName().concat(" cannot be VersionedParcelled"));
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsFindParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsFindParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s9) {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        if (i10 != 0) {
            int i11 = readInt();
            if (i10 < 0) {
                return null;
            }
            if (i11 == 1) {
                while (i10 > 0) {
                    s9.add(readVersionedParcelable());
                    i10--;
                }
            } else if (i11 == 2) {
                while (i10 > 0) {
                    s9.add(readParcelable());
                    i10--;
                }
            } else if (i11 == 3) {
                while (i10 > 0) {
                    s9.add(readSerializable());
                    i10--;
                }
            } else if (i11 == 4) {
                while (i10 > 0) {
                    s9.add(readString());
                    i10--;
                }
            } else if (i11 == 5) {
                while (i10 > 0) {
                    s9.add(readStrongBinder());
                    i10--;
                }
            }
        }
        return s9;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private void writeSerializable(Serializable serializable) throws IOException {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l(androidx.constraintlayout.core.widgets.analyzer.a.x("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
        }
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr) {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i10);
        if (i10 != 0) {
            int i11 = readInt();
            if (i10 < 0) {
                return null;
            }
            if (i11 == 1) {
                while (i10 > 0) {
                    arrayList.add(readVersionedParcelable());
                    i10--;
                }
            } else if (i11 == 2) {
                while (i10 > 0) {
                    arrayList.add(readParcelable());
                    i10--;
                }
            } else if (i11 == 3) {
                while (i10 > 0) {
                    arrayList.add(readSerializable());
                    i10--;
                }
            } else if (i11 == 4) {
                while (i10 > 0) {
                    arrayList.add(readString());
                    i10--;
                }
            } else if (i11 == 5) {
                while (i10 > 0) {
                    arrayList.add(readStrongBinder());
                    i10--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z9, int i10) {
        return !readField(i10) ? z9 : readBoolean();
    }

    public boolean[] readBooleanArray() {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        boolean[] zArr = new boolean[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            zArr[i11] = readInt() != 0;
        }
        return zArr;
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i10) {
        return !readField(i10) ? bundle : readBundle();
    }

    public byte readByte(byte b10, int i10) {
        return !readField(i10) ? b10 : (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i10) {
        return !readField(i10) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i10) {
        if (!readField(i10)) {
            return cArr;
        }
        int i11 = readInt();
        if (i11 < 0) {
            return null;
        }
        char[] cArr2 = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr2[i12] = (char) readInt();
        }
        return cArr2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i10) {
        return !readField(i10) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d8, int i10) {
        return !readField(i10) ? d8 : readDouble();
    }

    public double[] readDoubleArray() {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        double[] dArr = new double[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            dArr[i11] = readDouble();
        }
        return dArr;
    }

    public Exception readException(Exception exc, int i10) {
        int exceptionCode;
        return (readField(i10) && (exceptionCode = readExceptionCode()) != 0) ? readException(exceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i10);

    public abstract float readFloat();

    public float readFloat(float f, int i10) {
        return !readField(i10) ? f : readFloat();
    }

    public float[] readFloatArray() {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        float[] fArr = new float[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr[i11] = readFloat();
        }
        return fArr;
    }

    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered ClassNotFoundException", e);
            return null;
        } catch (IllegalAccessException e3) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered IllegalAccessException", e3);
            return null;
        } catch (NoSuchMethodException e7) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered NoSuchMethodException", e7);
            return null;
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e10.getCause());
            }
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered InvocationTargetException", e10);
            return null;
        }
    }

    public abstract int readInt();

    public int readInt(int i10, int i11) {
        return !readField(i11) ? i10 : readInt();
    }

    public int[] readIntArray() {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = readInt();
        }
        return iArr;
    }

    public <T> List<T> readList(List<T> list, int i10) {
        return !readField(i10) ? list : (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j10, int i10) {
        return !readField(i10) ? j10 : readLong();
    }

    public long[] readLongArray() {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        long[] jArr = new long[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = readLong();
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i10) {
        if (!readField(i10)) {
            return map;
        }
        int i11 = readInt();
        if (i11 < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (i11 != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            readCollection(arrayList);
            readCollection(arrayList2);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayMap.put(arrayList.get(i12), arrayList2.get(i12));
            }
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t, int i10) {
        return !readField(i10) ? t : (T) readParcelable();
    }

    public Serializable readSerializable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l(androidx.constraintlayout.core.widgets.analyzer.a.x("VersionedParcelable encountered IOException reading a Serializable object (name = ", string, ")"), e);
            return null;
        } catch (ClassNotFoundException e3) {
            androidx.privacysandbox.ads.adservices.adid.a.l(androidx.constraintlayout.core.widgets.analyzer.a.x("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", string, ")"), e3);
            return null;
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i10) {
        return !readField(i10) ? set : (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i10) {
        if (!readField(i10)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i10) {
        if (!readField(i10)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i10) {
        if (!readField(i10)) {
            return sparseBooleanArray;
        }
        int i11 = readInt();
        if (i11 < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i10) {
        return !readField(i10) ? str : readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i10) {
        return !readField(i10) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        return (T) readFromParcel(string, createSubParcel());
    }

    public abstract void setOutputField(int i10);

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i10 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i10 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i10]);
                    i10++;
                }
                return;
            }
            if (type == 2) {
                while (i10 < length) {
                    writeParcelable((Parcelable) tArr[i10]);
                    i10++;
                }
                return;
            }
            if (type == 3) {
                while (i10 < length) {
                    writeSerializable((Serializable) tArr[i10]);
                    i10++;
                }
            } else if (type == 4) {
                while (i10 < length) {
                    writeString((String) tArr[i10]);
                    i10++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i10 < length) {
                    writeStrongBinder((IBinder) tArr[i10]);
                    i10++;
                }
            }
        }
    }

    public abstract void writeBoolean(boolean z9);

    public void writeBoolean(boolean z9, int i10) {
        setOutputField(i10);
        writeBoolean(z9);
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(zArr.length);
        for (boolean z9 : zArr) {
            writeInt(z9 ? 1 : 0);
        }
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i10) {
        setOutputField(i10);
        writeBundle(bundle);
    }

    public void writeByte(byte b10, int i10) {
        setOutputField(i10);
        writeInt(b10);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i10) {
        setOutputField(i10);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i10, int i11);

    public void writeCharArray(char[] cArr, int i10) {
        setOutputField(i10);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c10 : cArr) {
            writeInt(c10);
        }
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i10) {
        setOutputField(i10);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d8);

    public void writeDouble(double d8, int i10) {
        setOutputField(i10);
        writeDouble(d8);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(dArr.length);
        for (double d8 : dArr) {
            writeDouble(d8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i10) {
        setOutputField(i10);
        if (exc == 0) {
            writeNoException();
            return;
        }
        int i11 = ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) ? EX_PARCELABLE : exc instanceof SecurityException ? -1 : exc instanceof BadParcelableException ? -2 : exc instanceof IllegalArgumentException ? -3 : exc instanceof NullPointerException ? -4 : exc instanceof IllegalStateException ? -5 : exc instanceof NetworkOnMainThreadException ? EX_NETWORK_MAIN_THREAD : exc instanceof UnsupportedOperationException ? EX_UNSUPPORTED_OPERATION : 0;
        writeInt(i11);
        if (i11 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            a.j(exc);
        } else {
            writeString(exc.getMessage());
            if (i11 != EX_PARCELABLE) {
                return;
            }
            writeParcelable((Parcelable) exc);
        }
    }

    public abstract void writeFloat(float f);

    public void writeFloat(float f, int i10) {
        setOutputField(i10);
        writeFloat(f);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(fArr.length);
        for (float f : fArr) {
            writeFloat(f);
        }
    }

    public abstract void writeInt(int i10);

    public void writeInt(int i10, int i11) {
        setOutputField(i11);
        writeInt(i10);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(iArr.length);
        for (int i10 : iArr) {
            writeInt(i10);
        }
    }

    public <T> void writeList(List<T> list, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        writeCollection(list, i10);
    }

    public abstract void writeLong(long j10);

    public void writeLong(long j10, int i10) {
        setOutputField(i10);
        writeLong(j10);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(jArr.length);
        for (long j10 : jArr) {
            writeLong(j10);
        }
    }

    public <K, V> void writeMap(Map<K, V> map, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        setOutputField(i10);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i10) {
        setOutputField(i10);
        writeParcelable(parcelable);
    }

    public <T> void writeSet(Set<T> set, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        writeCollection(set, i10);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i10) {
        setOutputField(i10);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i10) {
        setOutputField(i10);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i10) {
        setOutputField(i10);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            writeInt(sparseBooleanArray.keyAt(i11));
            writeBoolean(sparseBooleanArray.valueAt(i11));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i10) {
        setOutputField(i10);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i10) {
        setOutputField(i10);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i10) {
        setOutputField(i10);
        writeStrongInterface(iInterface);
    }

    public <T extends VersionedParcelable> void writeToParcel(T t, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            getWriteMethod(t.getClass()).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e3) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e7) {
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e10.getCause());
            }
            androidx.privacysandbox.ads.adservices.adid.a.l("VersionedParcel encountered InvocationTargetException", e10);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel versionedParcelCreateSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, versionedParcelCreateSubParcel);
        versionedParcelCreateSubParcel.closeField();
    }

    public void writeByteArray(byte[] bArr, int i10, int i11, int i12) {
        setOutputField(i12);
        writeByteArray(bArr, i10, i11);
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t, int i10) {
        return !readField(i10) ? t : (T) readVersionedParcelable();
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setOutputField(i10);
        writeVersionedParcelable(versionedParcelable);
    }

    private Exception readException(int i10, String str) {
        return createException(i10, str);
    }

    public double[] readDoubleArray(double[] dArr, int i10) {
        return !readField(i10) ? dArr : readDoubleArray();
    }

    public float[] readFloatArray(float[] fArr, int i10) {
        return !readField(i10) ? fArr : readFloatArray();
    }

    public int[] readIntArray(int[] iArr, int i10) {
        return !readField(i10) ? iArr : readIntArray();
    }

    public long[] readLongArray(long[] jArr, int i10) {
        return !readField(i10) ? jArr : readLongArray();
    }

    public void writeBooleanArray(boolean[] zArr, int i10) {
        setOutputField(i10);
        writeBooleanArray(zArr);
    }

    public void writeDoubleArray(double[] dArr, int i10) {
        setOutputField(i10);
        writeDoubleArray(dArr);
    }

    public void writeFloatArray(float[] fArr, int i10) {
        setOutputField(i10);
        writeFloatArray(fArr);
    }

    public void writeIntArray(int[] iArr, int i10) {
        setOutputField(i10);
        writeIntArray(iArr);
    }

    public void writeLongArray(long[] jArr, int i10) {
        setOutputField(i10);
        writeLongArray(jArr);
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i10) {
        return !readField(i10) ? zArr : readBooleanArray();
    }

    public void setSerializationFlags(boolean z9, boolean z10) {
    }

    public void writeSerializable(Serializable serializable, int i10) throws IOException {
        setOutputField(i10);
        writeSerializable(serializable);
    }

    public <T> void writeArray(T[] tArr, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        setOutputField(i10);
        writeArray(tArr);
    }

    public <T> T[] readArray(T[] tArr, int i10) {
        return !readField(i10) ? tArr : (T[]) readArray(tArr);
    }

    private <T> void writeCollection(Collection<T> collection, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        setOutputField(i10);
        writeCollection(collection);
    }
}
