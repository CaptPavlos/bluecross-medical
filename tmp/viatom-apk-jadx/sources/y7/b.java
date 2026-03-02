package y7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14105a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f14106b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f14107c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f14108d;
    public static final b e;
    public static final /* synthetic */ b[] f;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f14105a = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f14106b = bVar2;
        b bVar3 = new b("PARKING", 2);
        f14107c = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f14108d = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        e = bVar5;
        f = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f.clone();
    }
}
