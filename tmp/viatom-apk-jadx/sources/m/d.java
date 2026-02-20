package m;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11154a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f11155b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f11156c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d[] f11157d;

    static {
        d dVar = new d("DEFAULT", 0);
        f11154a = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f11155b = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f11156c = dVar3;
        f11157d = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f11157d.clone();
    }
}
