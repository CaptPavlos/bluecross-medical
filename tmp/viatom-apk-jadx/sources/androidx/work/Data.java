package androidx.work;

import a3.q;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.room.TypeConverter;
import g7.p;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Data {
    public static final Companion Companion = new Companion(null);
    public static final Data EMPTY = new Builder().build();

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    private static final String NULL_STRING_V1 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
    private static final short STREAM_MAGIC = -21521;
    private static final short STREAM_VERSION = 1;
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    private final Map<String, Object> values;

    public Data(Data data) {
        data.getClass();
        this.values = new HashMap(data.values);
    }

    @TypeConverter
    public static final Data fromByteArray(byte[] bArr) {
        return Companion.fromByteArray(bArr);
    }

    private final <T> T getOrDefault(String str, T t) {
        this.values.get(str);
        l.h();
        throw null;
    }

    private final <T, TArray> TArray getTypedArray(String str, p pVar) {
        if (!(this.values.get(str) instanceof Object[])) {
            return null;
        }
        l.h();
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV0(Data data) {
        return Companion.toByteArrayInternalV0(data);
    }

    @TypeConverter
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV1(Data data) {
        return Companion.toByteArrayInternalV1(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$7$lambda$6(Map.Entry entry) {
        entry.getClass();
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        StringBuilder sbW = a3.a.w(str, " : ");
        if (value instanceof Object[]) {
            value = Arrays.toString((Object[]) value);
            value.getClass();
        }
        sbW.append(value);
        return sbW.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L4
            return r0
        L4:
            r1 = 0
            if (r8 == 0) goto L6a
            java.lang.Class<androidx.work.Data> r2 = androidx.work.Data.class
            java.lang.Class r3 = r8.getClass()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L14
            goto L6a
        L14:
            androidx.work.Data r8 = (androidx.work.Data) r8
            java.util.Map<java.lang.String, java.lang.Object> r2 = r7.values
            java.util.Set r2 = r2.keySet()
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.values
            java.util.Set r3 = r3.keySet()
            boolean r3 = kotlin.jvm.internal.l.a(r2, r3)
            if (r3 != 0) goto L29
            return r1
        L29:
            java.util.Iterator r2 = r2.iterator()
        L2d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L69
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.values
            java.lang.Object r4 = r4.get(r3)
            java.util.Map<java.lang.String, java.lang.Object> r5 = r8.values
            java.lang.Object r3 = r5.get(r3)
            if (r4 == 0) goto L61
            if (r3 != 0) goto L4a
            goto L61
        L4a:
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L5c
            r5 = r4
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L5c
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            boolean r3 = t6.j.g0(r5, r3)
            goto L66
        L5c:
            boolean r3 = r4.equals(r3)
            goto L66
        L61:
            if (r4 != r3) goto L65
            r3 = r0
            goto L66
        L65:
            r3 = r1
        L66:
            if (r3 != 0) goto L2d
            return r1
        L69:
            return r0
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.equals(java.lang.Object):boolean");
    }

    public final boolean getBoolean(String str, boolean z9) {
        str.getClass();
        Object objValueOf = Boolean.valueOf(z9);
        Object obj = this.values.get(str);
        if (obj instanceof Boolean) {
            objValueOf = obj;
        }
        return ((Boolean) objValueOf).booleanValue();
    }

    public final boolean[] getBooleanArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getBooleanArray$$inlined$getTypedArray$1
            public final Boolean invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Boolean) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Boolean");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = ((Boolean) lVar.invoke(Integer.valueOf(i10))).booleanValue();
        }
        return zArr;
    }

    public final byte getByte(String str, byte b10) {
        str.getClass();
        Object objValueOf = Byte.valueOf(b10);
        Object obj = this.values.get(str);
        if (obj instanceof Byte) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).byteValue();
    }

    public final byte[] getByteArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getByteArray$$inlined$getTypedArray$1
            public final Byte invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Byte) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Byte");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = ((Number) lVar.invoke(Integer.valueOf(i10))).byteValue();
        }
        return bArr;
    }

    public final double getDouble(String str, double d8) {
        str.getClass();
        Object objValueOf = Double.valueOf(d8);
        Object obj = this.values.get(str);
        if (obj instanceof Double) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).doubleValue();
    }

    public final double[] getDoubleArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getDoubleArray$$inlined$getTypedArray$1
            public final Double invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Double) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Double");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = ((Number) lVar.invoke(Integer.valueOf(i10))).doubleValue();
        }
        return dArr;
    }

    public final float getFloat(String str, float f) {
        str.getClass();
        Object objValueOf = Float.valueOf(f);
        Object obj = this.values.get(str);
        if (obj instanceof Float) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float[] getFloatArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getFloatArray$$inlined$getTypedArray$1
            public final Float invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Float) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Float");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        float[] fArr = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr[i10] = ((Number) lVar.invoke(Integer.valueOf(i10))).floatValue();
        }
        return fArr;
    }

    public final int getInt(String str, int i10) {
        str.getClass();
        Object objValueOf = Integer.valueOf(i10);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).intValue();
    }

    public final int[] getIntArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getIntArray$$inlined$getTypedArray$1
            public final Integer invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Integer) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Int");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = ((Number) lVar.invoke(Integer.valueOf(i10))).intValue();
        }
        return iArr;
    }

    public final Map<String, Object> getKeyValueMap() {
        Map<String, Object> mapUnmodifiableMap = DesugarCollections.unmodifiableMap(this.values);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public final long getLong(String str, long j10) {
        str.getClass();
        Object objValueOf = Long.valueOf(j10);
        Object obj = this.values.get(str);
        if (obj instanceof Long) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).longValue();
    }

    public final long[] getLongArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getLongArray$$inlined$getTypedArray$1
            public final Long invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (Long) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.Long");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = ((Number) lVar.invoke(Integer.valueOf(i10))).longValue();
        }
        return jArr;
    }

    public final String getString(String str) {
        str.getClass();
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String[] getStringArray(String str) {
        str.getClass();
        final Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        int length = ((Object[]) obj).length;
        g7.l lVar = new g7.l() { // from class: androidx.work.Data$getStringArray$$inlined$getTypedArray$1
            public final String invoke(int i10) {
                Object obj2 = ((Object[]) obj)[i10];
                if (obj2 != null) {
                    return (String) obj2;
                }
                androidx.window.layout.c.k("null cannot be cast to non-null type kotlin.String");
                return null;
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }
        };
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = lVar.invoke(Integer.valueOf(i10));
        }
        return strArr;
    }

    public final <T> boolean hasKey$work_runtime_release(String str) {
        str.getClass();
        l.h();
        throw null;
    }

    public final <T> boolean hasKeyWithValueOfType(String str, Class<T> cls) {
        str.getClass();
        cls.getClass();
        Object obj = this.values.get(str);
        return obj != null && cls.isAssignableFrom(obj.getClass());
    }

    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry<String, Object> entry : this.values.entrySet()) {
            Object value = entry.getValue();
            iHashCode += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ Arrays.deepHashCode((Object[]) value) : entry.hashCode();
        }
        return iHashCode * 31;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final int size() {
        return this.values.size();
    }

    public final byte[] toByteArray() {
        return Companion.toByteArrayInternalV1(this);
    }

    public String toString() {
        return a3.a.o(new StringBuilder("Data {"), t6.l.h0(this.values.entrySet(), null, null, null, new q(5), 31), "}");
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private static final boolean fromByteArray$isObjectStream(ByteArrayInputStream byteArrayInputStream) throws IOException {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b10 = (byte) (-21267);
            boolean z9 = false;
            if (bArr[0] == ((byte) 16777132) && bArr[1] == b10) {
                z9 = true;
            }
            byteArrayInputStream.reset();
            return z9;
        }

        private static final void fromByteArray$readHeader(DataInputStream dataInputStream) throws IOException {
            short s9 = dataInputStream.readShort();
            if (s9 != -21521) {
                throw new IllegalStateException(a3.a.f(s9, "Magic number doesn't match: ").toString());
            }
            short s10 = dataInputStream.readShort();
            if (s10 != 1) {
                throw new IllegalStateException(a3.a.f(s10, "Unsupported version number: ").toString());
            }
        }

        private static final Object fromByteArray$readValue(DataInputStream dataInputStream, byte b10) throws IOException {
            if (b10 == 0) {
                return null;
            }
            if (b10 == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b10 == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b10 == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b10 == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b10 == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b10 == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b10 == 7) {
                return dataInputStream.readUTF();
            }
            int i10 = 0;
            if (b10 == 8) {
                int i11 = dataInputStream.readInt();
                Boolean[] boolArr = new Boolean[i11];
                while (i10 < i11) {
                    boolArr[i10] = Boolean.valueOf(dataInputStream.readBoolean());
                    i10++;
                }
                return boolArr;
            }
            if (b10 == 9) {
                int i12 = dataInputStream.readInt();
                Byte[] bArr = new Byte[i12];
                while (i10 < i12) {
                    bArr[i10] = Byte.valueOf(dataInputStream.readByte());
                    i10++;
                }
                return bArr;
            }
            if (b10 == 10) {
                int i13 = dataInputStream.readInt();
                Integer[] numArr = new Integer[i13];
                while (i10 < i13) {
                    numArr[i10] = Integer.valueOf(dataInputStream.readInt());
                    i10++;
                }
                return numArr;
            }
            if (b10 == 11) {
                int i14 = dataInputStream.readInt();
                Long[] lArr = new Long[i14];
                while (i10 < i14) {
                    lArr[i10] = Long.valueOf(dataInputStream.readLong());
                    i10++;
                }
                return lArr;
            }
            if (b10 == 12) {
                int i15 = dataInputStream.readInt();
                Float[] fArr = new Float[i15];
                while (i10 < i15) {
                    fArr[i10] = Float.valueOf(dataInputStream.readFloat());
                    i10++;
                }
                return fArr;
            }
            if (b10 == 13) {
                int i16 = dataInputStream.readInt();
                Double[] dArr = new Double[i16];
                while (i10 < i16) {
                    dArr[i10] = Double.valueOf(dataInputStream.readDouble());
                    i10++;
                }
                return dArr;
            }
            if (b10 != 14) {
                androidx.window.layout.c.g(a3.a.f(b10, "Unsupported type "));
                return null;
            }
            int i17 = dataInputStream.readInt();
            String[] strArr = new String[i17];
            while (i10 < i17) {
                String utf = dataInputStream.readUTF();
                if (l.a(utf, Data.NULL_STRING_V1)) {
                    utf = null;
                }
                strArr[i10] = utf;
                i10++;
            }
            return strArr;
        }

        private static final void toByteArrayInternalV1$writeArray(DataOutputStream dataOutputStream, Object[] objArr) throws IOException {
            int i10;
            f fVarA = y.a(objArr.getClass());
            if (fVarA.equals(y.a(Boolean[].class))) {
                i10 = 8;
            } else if (fVarA.equals(y.a(Byte[].class))) {
                i10 = 9;
            } else if (fVarA.equals(y.a(Integer[].class))) {
                i10 = 10;
            } else if (fVarA.equals(y.a(Long[].class))) {
                i10 = 11;
            } else if (fVarA.equals(y.a(Float[].class))) {
                i10 = 12;
            } else if (fVarA.equals(y.a(Double[].class))) {
                i10 = 13;
            } else {
                if (!fVarA.equals(y.a(String[].class))) {
                    androidx.window.layout.c.f(y.a(objArr.getClass()).b(), "Unsupported value type ");
                    return;
                }
                i10 = 14;
            }
            dataOutputStream.writeByte(i10);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                if (i10 == 8) {
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                } else if (i10 == 9) {
                    Byte b10 = obj instanceof Byte ? (Byte) obj : null;
                    dataOutputStream.writeByte(b10 != null ? b10.byteValue() : (byte) 0);
                } else if (i10 == 10) {
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                } else if (i10 == 11) {
                    Long l10 = obj instanceof Long ? (Long) obj : null;
                    dataOutputStream.writeLong(l10 != null ? l10.longValue() : 0L);
                } else if (i10 == 12) {
                    Float f = obj instanceof Float ? (Float) obj : null;
                    dataOutputStream.writeFloat(f != null ? f.floatValue() : 0.0f);
                } else if (i10 == 13) {
                    Double d8 = obj instanceof Double ? (Double) obj : null;
                    dataOutputStream.writeDouble(d8 != null ? d8.doubleValue() : 0.0d);
                } else if (i10 == 14) {
                    String str = obj instanceof String ? (String) obj : null;
                    if (str == null) {
                        str = Data.NULL_STRING_V1;
                    }
                    dataOutputStream.writeUTF(str);
                }
            }
        }

        private static final void toByteArrayInternalV1$writeEntry(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else {
                if (!(obj instanceof Object[])) {
                    androidx.window.layout.c.f(y.a(obj.getClass()).c(), "Unsupported value type ");
                    return;
                }
                toByteArrayInternalV1$writeArray(dataOutputStream, (Object[]) obj);
            }
            dataOutputStream.writeUTF(str);
        }

        private static final void toByteArrayInternalV1$writeHeader(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeShort(-21521);
            dataOutputStream.writeShort(1);
        }

        @TypeConverter
        public final Data fromByteArray(byte[] bArr) throws IOException {
            bArr.getClass();
            if (bArr.length > 10240) {
                androidx.window.layout.c.g("Data cannot occupy more than 10240 bytes when serialized");
                return null;
            }
            if (bArr.length == 0) {
                return Data.EMPTY;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                int i10 = 0;
                if (fromByteArray$isObjectStream(byteArrayInputStream)) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        int i11 = objectInputStream.readInt();
                        while (i10 < i11) {
                            linkedHashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                            i10++;
                        }
                        objectInputStream.close();
                    } finally {
                    }
                } else {
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    try {
                        fromByteArray$readHeader(dataInputStream);
                        int i12 = dataInputStream.readInt();
                        while (i10 < i12) {
                            linkedHashMap.put(dataInputStream.readUTF(), fromByteArray$readValue(dataInputStream, dataInputStream.readByte()));
                            i10++;
                        }
                        dataInputStream.close();
                    } finally {
                    }
                }
            } catch (IOException e) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#fromByteArray: ", e);
            } catch (ClassNotFoundException e3) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#fromByteArray: ", e3);
            }
            return new Data(linkedHashMap);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final byte[] toByteArrayInternalV0(Data data) throws IOException {
            data.getClass();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeInt(data.size());
                        for (Map.Entry entry : data.values.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            objectOutputStream.writeUTF(str);
                            objectOutputStream.writeObject(value);
                        }
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                        if (byteArrayOutputStream.size() > 10240) {
                            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArray.getClass();
                        return byteArray;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#toByteArray: ", e);
                return new byte[0];
            }
        }

        @TypeConverter
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final byte[] toByteArrayInternalV1(Data data) throws IOException {
            data.getClass();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    toByteArrayInternalV1$writeHeader(dataOutputStream);
                    dataOutputStream.writeInt(data.size());
                    for (Map.Entry entry : data.values.entrySet()) {
                        toByteArrayInternalV1$writeEntry(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    dataOutputStream.close();
                    byteArray.getClass();
                    return byteArray;
                } finally {
                }
            } catch (IOException e) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#toByteArray: ", e);
                return new byte[0];
            }
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.work.Data$getTypedArray$1, reason: invalid class name */
    public static final class AnonymousClass1 implements g7.l {
        final /* synthetic */ Object $value;

        public AnonymousClass1(Object obj) {
            this.$value = obj;
        }

        public final T invoke(int i10) {
            Object obj = ((Object[]) this.$value)[i10];
            l.h();
            throw null;
        }

        @Override // g7.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    public Data(Map<String, ?> map) {
        map.getClass();
        this.values = new HashMap(map);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private final Map<String, Object> values = new LinkedHashMap();

        private final Builder putDirect(String str, Object obj) {
            this.values.put(str, obj);
            return this;
        }

        public final Data build() throws IOException {
            Data data = new Data((Map<String, ?>) this.values);
            Data.Companion.toByteArrayInternalV1(data);
            return data;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder put(String str, Object obj) {
            str.getClass();
            Map<String, Object> map = this.values;
            if (obj == null) {
                obj = null;
            } else {
                f fVarA = y.a(obj.getClass());
                if (!fVarA.equals(y.a(Boolean.TYPE)) && !fVarA.equals(y.a(Byte.TYPE)) && !fVarA.equals(y.a(Integer.TYPE)) && !fVarA.equals(y.a(Long.TYPE)) && !fVarA.equals(y.a(Float.TYPE)) && !fVarA.equals(y.a(Double.TYPE)) && !fVarA.equals(y.a(String.class)) && !fVarA.equals(y.a(Boolean[].class)) && !fVarA.equals(y.a(Byte[].class)) && !fVarA.equals(y.a(Integer[].class)) && !fVarA.equals(y.a(Long[].class)) && !fVarA.equals(y.a(Float[].class)) && !fVarA.equals(y.a(Double[].class)) && !fVarA.equals(y.a(String[].class))) {
                    if (fVarA.equals(y.a(boolean[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((boolean[]) obj);
                    } else if (fVarA.equals(y.a(byte[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((byte[]) obj);
                    } else if (fVarA.equals(y.a(int[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((int[]) obj);
                    } else if (fVarA.equals(y.a(long[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((long[]) obj);
                    } else if (fVarA.equals(y.a(float[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((float[]) obj);
                    } else {
                        if (!fVarA.equals(y.a(double[].class))) {
                            androidx.window.layout.c.h("Key ", str, " has invalid type ", fVarA);
                            return null;
                        }
                        obj = Data_Kt.convertPrimitiveArray((double[]) obj);
                    }
                }
            }
            map.put(str, obj);
            return this;
        }

        public final Builder putAll(Map<String, ? extends Object> map) {
            map.getClass();
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public final Builder putBoolean(String str, boolean z9) {
            str.getClass();
            return putDirect(str, Boolean.valueOf(z9));
        }

        public final Builder putBooleanArray(String str, boolean[] zArr) {
            str.getClass();
            zArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(zArr));
            return this;
        }

        public final Builder putByte(String str, byte b10) {
            str.getClass();
            return putDirect(str, Byte.valueOf(b10));
        }

        public final Builder putByteArray(String str, byte[] bArr) {
            str.getClass();
            bArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(bArr));
            return this;
        }

        public final Builder putDouble(String str, double d8) {
            str.getClass();
            return putDirect(str, Double.valueOf(d8));
        }

        public final Builder putDoubleArray(String str, double[] dArr) {
            str.getClass();
            dArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(dArr));
            return this;
        }

        public final Builder putFloat(String str, float f) {
            str.getClass();
            return putDirect(str, Float.valueOf(f));
        }

        public final Builder putFloatArray(String str, float[] fArr) {
            str.getClass();
            fArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(fArr));
            return this;
        }

        public final Builder putInt(String str, int i10) {
            str.getClass();
            return putDirect(str, Integer.valueOf(i10));
        }

        public final Builder putIntArray(String str, int[] iArr) {
            str.getClass();
            iArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(iArr));
            return this;
        }

        public final Builder putLong(String str, long j10) {
            str.getClass();
            return putDirect(str, Long.valueOf(j10));
        }

        public final Builder putLongArray(String str, long[] jArr) {
            str.getClass();
            jArr.getClass();
            this.values.put(str, Data_Kt.convertPrimitiveArray(jArr));
            return this;
        }

        public final Builder putString(String str, String str2) {
            str.getClass();
            return putDirect(str, str2);
        }

        public final Builder putStringArray(String str, String[] strArr) {
            str.getClass();
            strArr.getClass();
            return putDirect(str, strArr);
        }

        public final Builder putAll(Data data) {
            data.getClass();
            putAll(data.values);
            return this;
        }
    }
}
