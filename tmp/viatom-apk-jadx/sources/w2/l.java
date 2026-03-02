package w2;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements h1.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f13451b;

    public /* synthetic */ l(FirebaseMessaging firebaseMessaging, int i10) {
        this.f13450a = i10;
        this.f13451b = firebaseMessaging;
    }

    @Override // h1.f
    public final void h(Object obj) throws NumberFormatException {
        boolean z9;
        switch (this.f13450a) {
            case 0:
                w wVar = (w) obj;
                if (!this.f13451b.e.i() || wVar.h.a() == null) {
                    return;
                }
                synchronized (wVar) {
                    z9 = wVar.g;
                }
                if (z9) {
                    return;
                }
                wVar.h(0L);
                return;
            default:
                FirebaseMessaging firebaseMessaging = this.f13451b;
                e0.a aVar = (e0.a) obj;
                if (aVar != null) {
                    z.f(aVar.f7588a);
                    firebaseMessaging.e();
                    return;
                }
                return;
        }
    }
}
