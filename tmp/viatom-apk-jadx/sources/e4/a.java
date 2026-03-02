package e4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7640a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f7641b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f7642c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f7643d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f7644i;

    static {
        a aVar = new a("UNKNOWN", 0);
        f7640a = aVar;
        a aVar2 = new a("SMALL", 1);
        f7641b = aVar2;
        a aVar3 = new a("MEDIUM", 2);
        f7642c = aVar3;
        a aVar4 = new a("LARGE", 3);
        f7643d = aVar4;
        a aVar5 = new a("HD720", 4);
        e = aVar5;
        a aVar6 = new a("HD1080", 5);
        f = aVar6;
        a aVar7 = new a("HIGH_RES", 6);
        g = aVar7;
        a aVar8 = new a("DEFAULT", 7);
        h = aVar8;
        f7644i = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f7644i.clone();
    }
}
