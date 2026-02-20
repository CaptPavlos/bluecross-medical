package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ l1 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(l1 l1Var, String str, int i10) {
        super(l1Var, true);
        this.e = i10;
        this.f = str;
        this.g = l1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.g.f;
                i0.y.g(l0Var);
                l0Var.beginAdUnitExposure(this.f, this.f1977b);
                break;
            default:
                l0 l0Var2 = this.g.f;
                i0.y.g(l0Var2);
                l0Var2.endAdUnitExposure(this.f, this.f1977b);
                break;
        }
    }
}
