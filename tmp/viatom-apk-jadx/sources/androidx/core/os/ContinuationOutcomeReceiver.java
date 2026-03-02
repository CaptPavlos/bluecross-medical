package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import s6.a;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(31)
/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {
    private final c continuation;

    public ContinuationOutcomeReceiver(c cVar) {
        super(false);
        this.continuation = cVar;
    }

    public void onError(E e) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(a.b(e));
        }
    }

    public void onResult(R r6) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(r6);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
