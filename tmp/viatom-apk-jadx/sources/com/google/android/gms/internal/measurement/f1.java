package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 extends h1 {
    public final /* synthetic */ int e = 1;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ l1 f1949i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1950j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(l1 l1Var, String str, String str2, Bundle bundle, boolean z9) {
        super(l1Var, true);
        this.f = str;
        this.g = str2;
        this.f1950j = bundle;
        this.h = z9;
        this.f1949i = l1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        switch (this.e) {
            case 0:
                l0 l0Var = this.f1949i.f;
                i0.y.g(l0Var);
                l0Var.getUserProperties(this.f, this.g, this.h, (i0) this.f1950j);
                break;
            default:
                long j10 = this.f1976a;
                l0 l0Var2 = this.f1949i.f;
                i0.y.g(l0Var2);
                l0Var2.logEvent(this.f, this.g, (Bundle) this.f1950j, this.h, true, j10);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void b() {
        switch (this.e) {
            case 0:
                ((i0) this.f1950j).u(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(l1 l1Var, String str, String str2, boolean z9, i0 i0Var) {
        super(l1Var, true);
        this.f = str;
        this.g = str2;
        this.h = z9;
        this.f1950j = i0Var;
        this.f1949i = l1Var;
    }
}
