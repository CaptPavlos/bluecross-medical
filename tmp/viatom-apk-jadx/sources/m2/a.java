package m2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final int f11162a;

    public a(int i10) {
        this.f11162a = i10;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return e.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f11162a == eVar.tag() && d.f11164a.equals(eVar.intEncoding());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.f11162a) + (d.f11164a.hashCode() ^ 2041407134);
    }

    @Override // m2.e
    public final d intEncoding() {
        return d.f11164a;
    }

    @Override // m2.e
    public final int tag() {
        return this.f11162a;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f11162a + "intEncoding=" + d.f11164a + ')';
    }
}
