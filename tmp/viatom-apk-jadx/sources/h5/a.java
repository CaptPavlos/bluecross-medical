package h5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8457a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f8458b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ a[] f8459c;

    static {
        a aVar = new a("DOWNLOADED", 0);
        f8457a = aVar;
        a aVar2 = new a("INSTALLED", 1);
        f8458b = aVar2;
        f8459c = new a[]{aVar, aVar2};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8459c.clone();
    }
}
