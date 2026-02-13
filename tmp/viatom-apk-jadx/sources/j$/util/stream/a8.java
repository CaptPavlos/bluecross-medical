package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class a8 {
    public static final a8 MAYBE_MORE;
    public static final a8 NO_MORE;
    public static final a8 UNLIMITED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a8[] f9517a;

    static {
        a8 a8Var = new a8("NO_MORE", 0);
        NO_MORE = a8Var;
        a8 a8Var2 = new a8("MAYBE_MORE", 1);
        MAYBE_MORE = a8Var2;
        a8 a8Var3 = new a8("UNLIMITED", 2);
        UNLIMITED = a8Var3;
        f9517a = new a8[]{a8Var, a8Var2, a8Var3};
    }

    public static a8 valueOf(String str) {
        return (a8) Enum.valueOf(a8.class, str);
    }

    public static a8[] values() {
        return (a8[]) f9517a.clone();
    }
}
