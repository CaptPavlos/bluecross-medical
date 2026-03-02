package z5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f14426a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ e[] f14427b;

    static {
        e eVar = new e("ALL", 0);
        f14426a = eVar;
        f14427b = new e[]{eVar, new e("TOP_LEFT", 1), new e("TOP_RIGHT", 2), new e("BOTTOM_LEFT", 3), new e("BOTTOM_RIGHT", 4), new e("TOP", 5), new e("BOTTOM", 6), new e("LEFT", 7), new e("RIGHT", 8), new e("OTHER_TOP_LEFT", 9), new e("OTHER_TOP_RIGHT", 10), new e("OTHER_BOTTOM_LEFT", 11), new e("OTHER_BOTTOM_RIGHT", 12), new e("DIAGONAL_FROM_TOP_LEFT", 13), new e("DIAGONAL_FROM_TOP_RIGHT", 14)};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f14427b.clone();
    }
}
