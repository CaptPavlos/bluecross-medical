package androidx.work.impl;

import androidx.work.impl.utils.CancelWorkRunnable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f708a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f709b;

    public /* synthetic */ h(WorkManagerImpl workManagerImpl, int i10) {
        this.f708a = i10;
        this.f709b = workManagerImpl;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f708a) {
            case 0:
                return this.f709b.lambda$rescheduleEligibleWork$0();
            default:
                return CancelWorkRunnable.forAll$lambda$7(this.f709b);
        }
    }
}
