package j4;

import android.os.Message;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9983a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Message f9984b;

    public /* synthetic */ k(Message message, int i10) {
        this.f9983a = i10;
        this.f9984b = message;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9983a) {
            case 0:
                throw new AssertionError("Unknown handler message received: " + this.f9984b.what);
            default:
                throw new AssertionError("Unhandled stats message." + this.f9984b.what);
        }
    }
}
