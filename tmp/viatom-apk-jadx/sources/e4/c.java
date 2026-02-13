package e4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f7651a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f7652b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f7653c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f7654d;
    public static final c e;
    public static final c f;
    public static final /* synthetic */ c[] g;

    static {
        c cVar = new c("UNKNOWN", 0);
        f7651a = cVar;
        c cVar2 = new c("INVALID_PARAMETER_IN_REQUEST", 1);
        f7652b = cVar2;
        c cVar3 = new c("HTML_5_PLAYER", 2);
        f7653c = cVar3;
        c cVar4 = new c("VIDEO_NOT_FOUND", 3);
        f7654d = cVar4;
        c cVar5 = new c("VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER", 4);
        e = cVar5;
        c cVar6 = new c("REQUEST_MISSING_HTTP_REFERER", 5);
        f = cVar6;
        g = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) g.clone();
    }
}
