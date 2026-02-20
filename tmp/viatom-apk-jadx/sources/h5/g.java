package h5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8554a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f8555b;

    /* renamed from: c, reason: collision with root package name */
    public static final g f8556c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f8557d;
    public static final g e;
    public static final g f;
    public static final /* synthetic */ g[] g;

    static {
        g gVar = new g("UPDATE", 0);
        f8554a = gVar;
        g gVar2 = new g("PROMOTED", 1);
        f8555b = gVar2;
        g gVar3 = new g("LATEST", 2);
        f8556c = gVar3;
        g gVar4 = new g("EDITOR_CHOICE", 3);
        f8557d = gVar4;
        g gVar5 = new g("TRENDING", 4);
        e = gVar5;
        g gVar6 = new g("NONE", 5);
        f = gVar6;
        g = new g[]{gVar, gVar2, gVar3, gVar4, gVar5, gVar6};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) g.clone();
    }
}
