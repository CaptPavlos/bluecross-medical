package b3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f834a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f835b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d[] f836c;

    static {
        d dVar = new d("CRASHLYTICS", 0);
        f834a = dVar;
        d dVar2 = new d("PERFORMANCE", 1);
        f835b = dVar2;
        f836c = new d[]{dVar, dVar2, new d("MATT_SAYS_HI", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f836c.clone();
    }
}
