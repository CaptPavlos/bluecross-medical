package e4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f7645a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f7646b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f7647c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f7648d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f7649i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ b[] f7650j;

    static {
        b bVar = new b("UNKNOWN", 0);
        f7645a = bVar;
        b bVar2 = new b("RATE_0_25", 1);
        f7646b = bVar2;
        b bVar3 = new b("RATE_0_5", 2);
        f7647c = bVar3;
        b bVar4 = new b("RATE_0_75", 3);
        f7648d = bVar4;
        b bVar5 = new b("RATE_1", 4);
        e = bVar5;
        b bVar6 = new b("RATE_1_25", 5);
        f = bVar6;
        b bVar7 = new b("RATE_1_5", 6);
        g = bVar7;
        b bVar8 = new b("RATE_1_75", 7);
        h = bVar8;
        b bVar9 = new b("RATE_2", 8);
        f7649i = bVar9;
        f7650j = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f7650j.clone();
    }
}
