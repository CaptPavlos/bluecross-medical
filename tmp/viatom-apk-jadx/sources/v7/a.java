package v7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object f13173a;

    public a(u7.i iVar) {
        super("Flow was aborted, no more elements needed");
        this.f13173a = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
