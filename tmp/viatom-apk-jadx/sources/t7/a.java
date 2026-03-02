package t7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12813a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f12814b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f12815c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f12816d;

    static {
        a aVar = new a("SUSPEND", 0);
        f12813a = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f12814b = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f12815c = aVar3;
        f12816d = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f12816d.clone();
    }
}
