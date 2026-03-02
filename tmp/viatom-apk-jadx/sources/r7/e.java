package r7;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12393a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12394b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f12393a = i10;
        this.f12394b = obj;
    }

    public final String toString() {
        switch (this.f12393a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f12394b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((g7.l) this.f12394b).getClass().getSimpleName() + '@' + y.m(this) + ']';
            default:
                return "DisposeOnCancel[" + ((k0) this.f12394b) + ']';
        }
    }
}
