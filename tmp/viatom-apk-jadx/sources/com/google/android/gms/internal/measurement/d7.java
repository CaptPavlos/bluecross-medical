package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
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
public final class d7 {

    /* renamed from: c, reason: collision with root package name */
    public static final d7 f1919c;

    /* renamed from: d, reason: collision with root package name */
    public static final d7 f1920d;
    public static final /* synthetic */ d7[] e;

    /* renamed from: a, reason: collision with root package name */
    public final e7 f1921a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1922b;

    /* JADX INFO: Fake field, exist only in values array */
    d7 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    d7 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    d7 EF2;

    static {
        d7 d7Var = new d7("DOUBLE", 0, e7.f1940d, 1);
        d7 d7Var2 = new d7("FLOAT", 1, e7.f1939c, 5);
        e7 e7Var = e7.f1938b;
        d7 d7Var3 = new d7("INT64", 2, e7Var, 0);
        d7 d7Var4 = new d7("UINT64", 3, e7Var, 0);
        e7 e7Var2 = e7.f1937a;
        d7 d7Var5 = new d7("INT32", 4, e7Var2, 0);
        d7 d7Var6 = new d7("FIXED64", 5, e7Var, 1);
        d7 d7Var7 = new d7("FIXED32", 6, e7Var2, 5);
        d7 d7Var8 = new d7("BOOL", 7, e7.e, 0);
        d7 d7Var9 = new d7("STRING", 8, e7.f, 2);
        f1919c = d7Var9;
        e7 e7Var3 = e7.f1941i;
        d7 d7Var10 = new d7("GROUP", 9, e7Var3, 3);
        f1920d = d7Var10;
        e = new d7[]{d7Var, d7Var2, d7Var3, d7Var4, d7Var5, d7Var6, d7Var7, d7Var8, d7Var9, d7Var10, new d7("MESSAGE", 10, e7Var3, 2), new d7("BYTES", 11, e7.g, 2), new d7("UINT32", 12, e7Var2, 0), new d7("ENUM", 13, e7.h, 0), new d7("SFIXED32", 14, e7Var2, 5), new d7("SFIXED64", 15, e7Var, 1), new d7("SINT32", 16, e7Var2, 0), new d7("SINT64", 17, e7Var, 0)};
    }

    public d7(String str, int i10, e7 e7Var, int i11) {
        this.f1921a = e7Var;
        this.f1922b = i11;
    }

    public static d7[] values() {
        return (d7[]) e.clone();
    }
}
