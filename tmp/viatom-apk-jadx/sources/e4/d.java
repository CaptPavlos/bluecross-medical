package e4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f7655a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f7656b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f7657c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f7658d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final /* synthetic */ d[] h;

    static {
        d dVar = new d("UNKNOWN", 0);
        f7655a = dVar;
        d dVar2 = new d("UNSTARTED", 1);
        f7656b = dVar2;
        d dVar3 = new d("ENDED", 2);
        f7657c = dVar3;
        d dVar4 = new d("PLAYING", 3);
        f7658d = dVar4;
        d dVar5 = new d("PAUSED", 4);
        e = dVar5;
        d dVar6 = new d("BUFFERING", 5);
        f = dVar6;
        d dVar7 = new d("VIDEO_CUED", 6);
        g = dVar7;
        h = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) h.clone();
    }
}
