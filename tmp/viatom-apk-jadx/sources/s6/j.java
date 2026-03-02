package s6;

import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f12695a;

    public j(Throwable th) {
        th.getClass();
        this.f12695a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.l.a(this.f12695a, ((j) obj).f12695a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12695a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f12695a + ')';
    }
}
