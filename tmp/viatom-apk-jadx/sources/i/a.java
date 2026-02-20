package i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8856a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f8857b;

    static {
        a aVar = new a("SDK_INIT_SUCCESS", 0);
        f8856a = aVar;
        f8857b = new a[]{aVar};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8857b.clone();
    }
}
