package w2;

import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13409a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f13410b = new j2.c("projectNumber", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f13411c = new j2.c("messageId", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(2))));

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f13412d = new j2.c("instanceId", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(3))));
    public static final j2.c e = new j2.c("messageType", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(4))));
    public static final j2.c f = new j2.c("sdkPlatform", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(5))));
    public static final j2.c g = new j2.c("packageName", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(6))));
    public static final j2.c h = new j2.c("collapseKey", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(7))));

    /* renamed from: i, reason: collision with root package name */
    public static final j2.c f13413i = new j2.c("priority", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(8))));

    /* renamed from: j, reason: collision with root package name */
    public static final j2.c f13414j = new j2.c("ttl", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(9))));

    /* renamed from: k, reason: collision with root package name */
    public static final j2.c f13415k = new j2.c("topic", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(10))));

    /* renamed from: l, reason: collision with root package name */
    public static final j2.c f13416l = new j2.c("bulkId", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(11))));

    /* renamed from: m, reason: collision with root package name */
    public static final j2.c f13417m = new j2.c(NotificationCompat.CATEGORY_EVENT, com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(12))));

    /* renamed from: n, reason: collision with root package name */
    public static final j2.c f13418n = new j2.c("analyticsLabel", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(13))));

    /* renamed from: o, reason: collision with root package name */
    public static final j2.c f13419o = new j2.c("campaignId", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(14))));

    /* renamed from: p, reason: collision with root package name */
    public static final j2.c f13420p = new j2.c("composerLabel", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(m2.e.class, new m2.a(15))));

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        x2.d dVar = (x2.d) obj;
        j2.e eVar = (j2.e) obj2;
        eVar.e(f13410b, dVar.f13589a);
        eVar.a(f13411c, dVar.f13590b);
        eVar.a(f13412d, dVar.f13591c);
        eVar.a(e, dVar.f13592d);
        eVar.a(f, x2.c.ANDROID);
        eVar.a(g, dVar.e);
        eVar.a(h, dVar.f);
        eVar.d(f13413i, dVar.g);
        eVar.d(f13414j, dVar.h);
        eVar.a(f13415k, dVar.f13593i);
        eVar.e(f13416l, 0L);
        eVar.a(f13417m, x2.a.MESSAGE_DELIVERED);
        eVar.a(f13418n, dVar.f13594j);
        eVar.e(f13419o, 0L);
        eVar.a(f13420p, dVar.f13595k);
    }
}
