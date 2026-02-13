package a3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public static final h1 f82a;

    /* renamed from: b, reason: collision with root package name */
    public static final h1 f83b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h1[] f84c;

    static {
        h1 h1Var = new h1("GENERAL", 0);
        f82a = h1Var;
        h1 h1Var2 = new h1("FALLBACK", 1);
        f83b = h1Var2;
        f84c = new h1[]{h1Var, h1Var2};
    }

    public static h1 valueOf(String str) {
        return (h1) Enum.valueOf(h1.class, str);
    }

    public static h1[] values() {
        return (h1[]) f84c.clone();
    }
}
