package v;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13095a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f13096b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f13097c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c[] f13098d;

    static {
        c cVar = new c("NETWORK_UNMETERED", 0);
        f13095a = cVar;
        c cVar2 = new c("DEVICE_IDLE", 1);
        f13096b = cVar2;
        c cVar3 = new c("DEVICE_CHARGING", 2);
        f13097c = cVar3;
        f13098d = new c[]{cVar, cVar2, cVar3};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f13098d.clone();
    }
}
