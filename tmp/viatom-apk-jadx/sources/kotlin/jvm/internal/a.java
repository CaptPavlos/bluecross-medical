package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10124a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10125b = false;

    /* renamed from: c, reason: collision with root package name */
    public final int f10126c = 2;

    public a(Object obj) {
        this.f10124a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10125b == aVar.f10125b && this.f10126c == aVar.f10126c && l.a(this.f10124a, aVar.f10124a) && AtomicReference.class.equals(AtomicReference.class);
    }

    @Override // kotlin.jvm.internal.i
    public final int getArity() {
        return 2;
    }

    public final int hashCode() {
        return ((((((((((AtomicReference.class.hashCode() + ((this.f10124a != null ? r0.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + (this.f10125b ? 1231 : 1237)) * 31) + 2) * 31) + this.f10126c;
    }

    public final String toString() {
        y.f10139a.getClass();
        return z.a(this);
    }
}
