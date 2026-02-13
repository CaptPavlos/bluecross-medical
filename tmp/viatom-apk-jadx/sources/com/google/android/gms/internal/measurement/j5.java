package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j5 {

    /* renamed from: b, reason: collision with root package name */
    public static final j5 f2010b;

    /* renamed from: c, reason: collision with root package name */
    public static final j5 f2011c;

    /* renamed from: d, reason: collision with root package name */
    public static final j5[] f2012d;
    public static final /* synthetic */ j5[] e;

    /* renamed from: a, reason: collision with root package name */
    public final int f2013a;

    /* JADX INFO: Fake field, exist only in values array */
    j5 EF0;

    static {
        x5 x5Var = x5.e;
        j5 j5Var = new j5("DOUBLE", 0, 0, 1, x5Var);
        x5 x5Var2 = x5.f2264d;
        j5 j5Var2 = new j5("FLOAT", 1, 1, 1, x5Var2);
        x5 x5Var3 = x5.f2263c;
        j5 j5Var3 = new j5("INT64", 2, 2, 1, x5Var3);
        j5 j5Var4 = new j5("UINT64", 3, 3, 1, x5Var3);
        x5 x5Var4 = x5.f2262b;
        j5 j5Var5 = new j5("INT32", 4, 4, 1, x5Var4);
        j5 j5Var6 = new j5("FIXED64", 5, 5, 1, x5Var3);
        j5 j5Var7 = new j5("FIXED32", 6, 6, 1, x5Var4);
        x5 x5Var5 = x5.f;
        j5 j5Var8 = new j5("BOOL", 7, 7, 1, x5Var5);
        x5 x5Var6 = x5.g;
        j5 j5Var9 = new j5("STRING", 8, 8, 1, x5Var6);
        x5 x5Var7 = x5.f2266j;
        j5 j5Var10 = new j5("MESSAGE", 9, 9, 1, x5Var7);
        x5 x5Var8 = x5.h;
        j5 j5Var11 = new j5("BYTES", 10, 10, 1, x5Var8);
        j5 j5Var12 = new j5("UINT32", 11, 11, 1, x5Var4);
        x5 x5Var9 = x5.f2265i;
        j5 j5Var13 = new j5("ENUM", 12, 12, 1, x5Var9);
        j5 j5Var14 = new j5("SFIXED32", 13, 13, 1, x5Var4);
        j5 j5Var15 = new j5("SFIXED64", 14, 14, 1, x5Var3);
        j5 j5Var16 = new j5("SINT32", 15, 15, 1, x5Var4);
        j5 j5Var17 = new j5("SINT64", 16, 16, 1, x5Var3);
        j5 j5Var18 = new j5("GROUP", 17, 17, 1, x5Var7);
        j5 j5Var19 = new j5("DOUBLE_LIST", 18, 18, 2, x5Var);
        j5 j5Var20 = new j5("FLOAT_LIST", 19, 19, 2, x5Var2);
        j5 j5Var21 = new j5("INT64_LIST", 20, 20, 2, x5Var3);
        j5 j5Var22 = new j5("UINT64_LIST", 21, 21, 2, x5Var3);
        j5 j5Var23 = new j5("INT32_LIST", 22, 22, 2, x5Var4);
        j5 j5Var24 = new j5("FIXED64_LIST", 23, 23, 2, x5Var3);
        j5 j5Var25 = new j5("FIXED32_LIST", 24, 24, 2, x5Var4);
        j5 j5Var26 = new j5("BOOL_LIST", 25, 25, 2, x5Var5);
        j5 j5Var27 = new j5("STRING_LIST", 26, 26, 2, x5Var6);
        j5 j5Var28 = new j5("MESSAGE_LIST", 27, 27, 2, x5Var7);
        j5 j5Var29 = new j5("BYTES_LIST", 28, 28, 2, x5Var8);
        j5 j5Var30 = new j5("UINT32_LIST", 29, 29, 2, x5Var4);
        j5 j5Var31 = new j5("ENUM_LIST", 30, 30, 2, x5Var9);
        j5 j5Var32 = new j5("SFIXED32_LIST", 31, 31, 2, x5Var4);
        j5 j5Var33 = new j5("SFIXED64_LIST", 32, 32, 2, x5Var3);
        j5 j5Var34 = new j5("SINT32_LIST", 33, 33, 2, x5Var4);
        j5 j5Var35 = new j5("SINT64_LIST", 34, 34, 2, x5Var3);
        j5 j5Var36 = new j5("DOUBLE_LIST_PACKED", 35, 35, 3, x5Var);
        f2010b = j5Var36;
        j5 j5Var37 = new j5("FLOAT_LIST_PACKED", 36, 36, 3, x5Var2);
        j5 j5Var38 = new j5("INT64_LIST_PACKED", 37, 37, 3, x5Var3);
        j5 j5Var39 = new j5("UINT64_LIST_PACKED", 38, 38, 3, x5Var3);
        j5 j5Var40 = new j5("INT32_LIST_PACKED", 39, 39, 3, x5Var4);
        j5 j5Var41 = new j5("FIXED64_LIST_PACKED", 40, 40, 3, x5Var3);
        j5 j5Var42 = new j5("FIXED32_LIST_PACKED", 41, 41, 3, x5Var4);
        j5 j5Var43 = new j5("BOOL_LIST_PACKED", 42, 42, 3, x5Var5);
        j5 j5Var44 = new j5("UINT32_LIST_PACKED", 43, 43, 3, x5Var4);
        j5 j5Var45 = new j5("ENUM_LIST_PACKED", 44, 44, 3, x5Var9);
        j5 j5Var46 = new j5("SFIXED32_LIST_PACKED", 45, 45, 3, x5Var4);
        j5 j5Var47 = new j5("SFIXED64_LIST_PACKED", 46, 46, 3, x5Var3);
        j5 j5Var48 = new j5("SINT32_LIST_PACKED", 47, 47, 3, x5Var4);
        j5 j5Var49 = new j5("SINT64_LIST_PACKED", 48, 48, 3, x5Var3);
        f2011c = j5Var49;
        e = new j5[]{j5Var, j5Var2, j5Var3, j5Var4, j5Var5, j5Var6, j5Var7, j5Var8, j5Var9, j5Var10, j5Var11, j5Var12, j5Var13, j5Var14, j5Var15, j5Var16, j5Var17, j5Var18, j5Var19, j5Var20, j5Var21, j5Var22, j5Var23, j5Var24, j5Var25, j5Var26, j5Var27, j5Var28, j5Var29, j5Var30, j5Var31, j5Var32, j5Var33, j5Var34, j5Var35, j5Var36, j5Var37, j5Var38, j5Var39, j5Var40, j5Var41, j5Var42, j5Var43, j5Var44, j5Var45, j5Var46, j5Var47, j5Var48, j5Var49, new j5("GROUP_LIST", 49, 49, 2, x5Var7), new j5("MAP", 50, 50, 4, x5.f2261a)};
        j5[] j5VarArrValues = values();
        f2012d = new j5[j5VarArrValues.length];
        for (j5 j5Var50 : j5VarArrValues) {
            f2012d[j5Var50.f2013a] = j5Var50;
        }
    }

    public j5(String str, int i10, int i11, int i12, x5 x5Var) {
        this.f2013a = i11;
        int i13 = i12 - 1;
        if (i13 == 1 || i13 == 3) {
            x5Var.getClass();
        }
        if (i12 == 1) {
            x5 x5Var2 = x5.f2261a;
            x5Var.ordinal();
        }
    }

    public static j5[] values() {
        return (j5[]) e.clone();
    }
}
