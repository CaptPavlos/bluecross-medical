package h5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f8506a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f8507b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f8508c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e[] f8509d;

    static {
        e eVar = new e("OUTDATED", 0);
        f8506a = eVar;
        e eVar2 = new e("UPDATED", 1);
        f8507b = eVar2;
        e eVar3 = new e("UNAVAILABLE", 2);
        f8508c = eVar3;
        f8509d = new e[]{eVar, eVar2, eVar3};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f8509d.clone();
    }
}
