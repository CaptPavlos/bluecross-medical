package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class a7 {
    public static final a7 DOUBLE_VALUE;
    public static final a7 INT_VALUE;
    public static final a7 LONG_VALUE;
    public static final a7 REFERENCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a7[] f9516a;

    public static a7 valueOf(String str) {
        return (a7) Enum.valueOf(a7.class, str);
    }

    public static a7[] values() {
        return (a7[]) f9516a.clone();
    }

    static {
        a7 a7Var = new a7("REFERENCE", 0);
        REFERENCE = a7Var;
        a7 a7Var2 = new a7("INT_VALUE", 1);
        INT_VALUE = a7Var2;
        a7 a7Var3 = new a7("LONG_VALUE", 2);
        LONG_VALUE = a7Var3;
        a7 a7Var4 = new a7("DOUBLE_VALUE", 3);
        DOUBLE_VALUE = a7Var4;
        f9516a = new a7[]{a7Var, a7Var2, a7Var3, a7Var4};
    }
}
