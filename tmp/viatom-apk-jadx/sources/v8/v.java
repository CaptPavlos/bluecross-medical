package v8;

import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends z8.d {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f13279m;

    public v(w wVar) {
        this.f13279m = wVar;
    }

    @Override // z8.d
    public final void j() {
        w wVar = this.f13279m;
        if (wVar.d(6)) {
            wVar.f13283d.j(wVar.f13282c, 6);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
