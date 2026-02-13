package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ l1 h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f2276i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(l1 l1Var, x0 x0Var, String str, String str2) {
        super(l1Var, true);
        this.e = 2;
        this.f2276i = x0Var;
        this.f = str;
        this.g = str2;
        Objects.requireNonNull(l1Var);
        this.h = l1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.h.f;
                i0.y.g(l0Var);
                l0Var.clearConditionalUserProperty(this.f, this.g, (Bundle) this.f2276i);
                break;
            case 1:
                l0 l0Var2 = this.h.f;
                i0.y.g(l0Var2);
                l0Var2.getConditionalUserProperties(this.f, this.g, (i0) this.f2276i);
                break;
            default:
                l0 l0Var3 = this.h.f;
                i0.y.g(l0Var3);
                l0Var3.setCurrentScreenByScionActivityInfo((x0) this.f2276i, this.f, this.g, this.f1976a);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void b() {
        switch (this.e) {
            case 1:
                ((i0) this.f2276i).u(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(l1 l1Var, String str, String str2, Object obj, int i10) {
        super(l1Var, true);
        this.e = i10;
        this.f = str;
        this.g = str2;
        this.f2276i = obj;
        this.h = l1Var;
    }
}
