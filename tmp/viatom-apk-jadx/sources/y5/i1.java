package y5;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13889a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1 f13890b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.h f13891c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13892d;

    public /* synthetic */ i1(j1 j1Var, h5.h hVar, int i10, int i11) {
        this.f13889a = i11;
        this.f13890b = j1Var;
        this.f13891c = hVar;
        this.f13892d = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13889a) {
            case 0:
                this.f13890b.f13903c.m(this.f13891c, this.f13892d);
                break;
            case 1:
                int i10 = this.f13892d;
                j1 j1Var = this.f13890b;
                j1Var.f13903c.m(this.f13891c, i10);
                j1Var.j();
                break;
            case 2:
                this.f13890b.f13903c.E(this.f13891c, this.f13892d);
                break;
            default:
                this.f13890b.f13903c.m(this.f13891c, this.f13892d);
                break;
        }
    }
}
