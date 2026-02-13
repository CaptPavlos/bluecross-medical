package g8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 implements e8.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8333a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.d f8334b;

    public u0(String str, e8.d dVar) {
        dVar.getClass();
        this.f8333a = str;
        this.f8334b = dVar;
    }

    @Override // e8.e
    public final String a() {
        return this.f8333a;
    }

    @Override // e8.e
    public final boolean c() {
        return false;
    }

    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // e8.e
    public final int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f8333a.equals(u0Var.f8333a) && kotlin.jvm.internal.l.a(this.f8334b, u0Var.f8334b);
    }

    @Override // e8.e
    public final String f(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // e8.e
    public final List g(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t6.t.f12808a;
    }

    @Override // e8.e
    public final a4 getKind() {
        return this.f8334b;
    }

    @Override // e8.e
    public final e8.e h(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final int hashCode() {
        return (this.f8334b.hashCode() * 31) + this.f8333a.hashCode();
    }

    @Override // e8.e
    public final boolean i(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // e8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return a3.a.m(new StringBuilder("PrimitiveDescriptor("), this.f8333a, ')');
    }
}
