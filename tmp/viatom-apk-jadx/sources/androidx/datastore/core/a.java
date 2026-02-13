package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import g7.l;
import r7.k0;
import r7.t1;
import s7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f537a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f538b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f539c;

    public /* synthetic */ a(int i10, Object obj, Object obj2) {
        this.f537a = i10;
        this.f538b = obj;
        this.f539c = obj2;
    }

    @Override // r7.k0
    public final void dispose() {
        switch (this.f537a) {
            case 0:
                MulticastFileObserver.Companion.observe$lambda$4((String) this.f538b, (l) this.f539c);
                break;
            default:
                c cVar = (c) this.f538b;
                cVar.f12714a.removeCallbacks((t1) this.f539c);
                break;
        }
    }
}
