package l4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p4 {

    /* renamed from: a, reason: collision with root package name */
    public static final p4 f10721a;

    /* renamed from: b, reason: collision with root package name */
    public static final p4 f10722b;

    /* renamed from: c, reason: collision with root package name */
    public static final p4 f10723c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ p4[] f10724d;

    static {
        p4 p4Var = new p4("NAME", 0);
        f10721a = p4Var;
        p4 p4Var2 = new p4("DATE", 1);
        f10722b = p4Var2;
        p4 p4Var3 = new p4("SIZE", 2);
        f10723c = p4Var3;
        f10724d = new p4[]{p4Var, p4Var2, p4Var3};
    }

    public static p4 valueOf(String str) {
        return (p4) Enum.valueOf(p4.class, str);
    }

    public static p4[] values() {
        return (p4[]) f10724d.clone();
    }
}
