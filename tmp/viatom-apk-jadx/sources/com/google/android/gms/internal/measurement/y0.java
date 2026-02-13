package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ l1 f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(l1 l1Var, Boolean bool) {
        super(l1Var, true);
        this.e = 2;
        this.g = bool;
        Objects.requireNonNull(l1Var);
        this.f = l1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.f.f;
                i0.y.g(l0Var);
                l0Var.setUserProperty("fcm", "_ln", new q0.b(this.g), true, this.f1976a);
                break;
            case 1:
                l0 l0Var2 = this.f.f;
                i0.y.g(l0Var2);
                l0Var2.setConditionalUserProperty((Bundle) this.g, this.f1976a);
                break;
            case 2:
                l0 l0Var3 = this.f.f;
                i0.y.g(l0Var3);
                l0Var3.setMeasurementEnabled(((Boolean) this.g).booleanValue(), this.f1976a);
                break;
            case 3:
                l0 l0Var4 = this.f.f;
                i0.y.g(l0Var4);
                l0Var4.retrieveAndUploadBatches(new c1(this, (k1.a) this.g));
                break;
            case 4:
                l0 l0Var5 = this.f.f;
                i0.y.g(l0Var5);
                l0Var5.logHealthData(5, "Error with data collection. Data lost.", new q0.b((Exception) this.g), new q0.b(null), new q0.b(null));
                break;
            default:
                l0 l0Var6 = this.f.f;
                i0.y.g(l0Var6);
                l0Var6.registerOnMeasurementEventListener((i1) this.g);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(l1 l1Var, Object obj, int i10) {
        super(l1Var, true);
        this.e = i10;
        this.g = obj;
        this.f = l1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(l1 l1Var, Exception exc) {
        super(l1Var, false);
        this.e = 4;
        this.g = exc;
        this.f = l1Var;
    }
}
