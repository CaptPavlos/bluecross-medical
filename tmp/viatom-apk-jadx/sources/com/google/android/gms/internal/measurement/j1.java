package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Activity f;
    public final /* synthetic */ k1 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, Activity activity, int i10) {
        super(k1Var.f2021a, true);
        this.e = i10;
        switch (i10) {
            case 1:
                this.f = activity;
                this.g = k1Var;
                super(k1Var.f2021a, true);
                break;
            case 2:
                this.f = activity;
                this.g = k1Var;
                super(k1Var.f2021a, true);
                break;
            case 3:
                this.f = activity;
                this.g = k1Var;
                super(k1Var.f2021a, true);
                break;
            case 4:
                this.f = activity;
                this.g = k1Var;
                super(k1Var.f2021a, true);
                break;
            default:
                this.f = activity;
                this.g = k1Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.g.f2021a.f;
                i0.y.g(l0Var);
                l0Var.onActivityStartedByScionActivityInfo(x0.b(this.f), this.f1977b);
                break;
            case 1:
                l0 l0Var2 = this.g.f2021a.f;
                i0.y.g(l0Var2);
                l0Var2.onActivityResumedByScionActivityInfo(x0.b(this.f), this.f1977b);
                break;
            case 2:
                l0 l0Var3 = this.g.f2021a.f;
                i0.y.g(l0Var3);
                l0Var3.onActivityPausedByScionActivityInfo(x0.b(this.f), this.f1977b);
                break;
            case 3:
                l0 l0Var4 = this.g.f2021a.f;
                i0.y.g(l0Var4);
                l0Var4.onActivityStoppedByScionActivityInfo(x0.b(this.f), this.f1977b);
                break;
            default:
                l0 l0Var5 = this.g.f2021a.f;
                i0.y.g(l0Var5);
                l0Var5.onActivityDestroyedByScionActivityInfo(x0.b(this.f), this.f1977b);
                break;
        }
    }
}
