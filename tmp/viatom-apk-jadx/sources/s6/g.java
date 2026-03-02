package s6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f12690a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f12691b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ g[] f12692c;

    /* JADX INFO: Fake field, exist only in values array */
    g EF0;

    static {
        g gVar = new g("SYNCHRONIZED", 0);
        g gVar2 = new g("PUBLICATION", 1);
        f12690a = gVar2;
        g gVar3 = new g("NONE", 2);
        f12691b = gVar3;
        f12692c = new g[]{gVar, gVar2, gVar3};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f12692c.clone();
    }
}
