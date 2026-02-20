package z5;

import com.uptodown.R;
import g5.t;
import g5.u;
import h5.q;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements g5.i, g5.g, t, u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14410a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f14411b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f14412c;

    public /* synthetic */ c(w wVar, d dVar, int i10) {
        this.f14410a = i10;
        this.f14412c = wVar;
        this.f14411b = dVar;
    }

    @Override // g5.g
    public void C(q qVar) {
        d dVar = this.f14411b;
        i0.k kVar = dVar.f14415c;
        dVar.f14413a.getClass();
        ((g7.a) kVar.f8923b).invoke();
    }

    @Override // g5.t
    public void G() {
        w wVar = this.f14412c;
        if (wVar.isFinishing()) {
            return;
        }
        d dVar = this.f14411b;
        if (dVar.f14414b.getVisibility() == 0) {
            dVar.g(wVar);
            String string = wVar.getString(R.string.action_added_to_wishlist, dVar.f14413a.f8567b);
            string.getClass();
            wVar.C(string);
        }
    }

    @Override // g5.u
    public void M() {
        w wVar = this.f14412c;
        if (wVar.isFinishing()) {
            return;
        }
        d dVar = this.f14411b;
        if (dVar.f14414b.getVisibility() == 0) {
            d.a(wVar, dVar);
        }
        String string = wVar.getString(R.string.action_removed_from_wishlist, dVar.f14413a.f8567b);
        string.getClass();
        wVar.C(string);
    }

    @Override // g5.g
    public void h(q qVar) {
        d dVar = this.f14411b;
        i0.k kVar = dVar.f14415c;
        dVar.f14413a.getClass();
        ((g7.a) kVar.f8923b).invoke();
    }

    @Override // g5.v
    public void i() {
        int i10 = this.f14410a;
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        d dVar = this.f14411b;
        dVar.f14413a = hVar;
        if (dVar.f14414b.getVisibility() == 0) {
            h5.h hVar2 = dVar.f14413a;
            w wVar = this.f14412c;
            dVar.c(hVar2, wVar);
            if (dVar.f14413a.z0 == 1) {
                dVar.g(wVar);
            } else {
                d.a(wVar, dVar);
            }
        }
    }

    @Override // g5.g
    public void onError(String str) {
        this.f14412c.N(str);
    }

    @Override // g5.g
    public void x(String str) {
        str.getClass();
        d dVar = this.f14411b;
        w wVar = this.f14412c;
        dVar.b(wVar);
        v5.c.e(wVar, str, null);
    }

    public /* synthetic */ c(d dVar, w wVar, int i10) {
        this.f14410a = i10;
        this.f14411b = dVar;
        this.f14412c = wVar;
    }

    private final void a() {
    }

    private final void b() {
    }

    @Override // g5.i
    public void f(int i10) {
    }
}
