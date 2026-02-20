package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ i0 f;
    public final /* synthetic */ l1 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(l1 l1Var, i0 i0Var, int i10) {
        super(l1Var, true);
        this.e = i10;
        this.f = i0Var;
        this.g = l1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.g.f;
                i0.y.g(l0Var);
                l0Var.getGmpAppId(this.f);
                break;
            case 1:
                l0 l0Var2 = this.g.f;
                i0.y.g(l0Var2);
                l0Var2.getCachedAppInstanceId(this.f);
                break;
            case 2:
                l0 l0Var3 = this.g.f;
                i0.y.g(l0Var3);
                l0Var3.generateEventId(this.f);
                break;
            case 3:
                l0 l0Var4 = this.g.f;
                i0.y.g(l0Var4);
                l0Var4.getCurrentScreenName(this.f);
                break;
            default:
                l0 l0Var5 = this.g.f;
                i0.y.g(l0Var5);
                l0Var5.getCurrentScreenClass(this.f);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void b() {
        switch (this.e) {
            case 0:
                this.f.u(null);
                break;
            case 1:
                this.f.u(null);
                break;
            case 2:
                this.f.u(null);
                break;
            case 3:
                this.f.u(null);
                break;
            default:
                this.f.u(null);
                break;
        }
    }
}
