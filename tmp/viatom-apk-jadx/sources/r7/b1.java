package r7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient i1 f12390a;

    public b1(String str, Throwable th, i1 i1Var) {
        super(str);
        this.f12390a = i1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return kotlin.jvm.internal.l.a(b1Var.getMessage(), getMessage()) && kotlin.jvm.internal.l.a(b1Var.f12390a, this.f12390a) && kotlin.jvm.internal.l.a(b1Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        message.getClass();
        int iHashCode = (this.f12390a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f12390a;
    }
}
