package h0;

import com.google.android.gms.internal.measurement.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f8376a;

    public l(e eVar) {
        this.f8376a = eVar;
    }

    @Override // h0.b
    public final void a(boolean z9) {
        h0 h0Var = this.f8376a.f8371m;
        h0Var.sendMessage(h0Var.obtainMessage(1, Boolean.valueOf(z9)));
    }
}
