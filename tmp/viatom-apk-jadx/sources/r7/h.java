package r7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends p {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f12401c = AtomicIntegerFieldUpdater.newUpdater(h.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public h(g gVar, Throwable th, boolean z9) {
        if (th == null) {
            th = new CancellationException("Continuation " + gVar + " was cancelled normally");
        }
        super(z9, th);
        this._resumed$volatile = 0;
    }
}
