package h8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends x {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8842a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8843b;

    public n(String str, boolean z9) {
        str.getClass();
        this.f8842a = z9;
        this.f8843b = str.toString();
    }

    @Override // h8.x
    public final String c() {
        return this.f8843b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f8842a == nVar.f8842a && kotlin.jvm.internal.l.a(this.f8843b, nVar.f8843b);
    }

    public final int hashCode() {
        return this.f8843b.hashCode() + ((this.f8842a ? 1231 : 1237) * 31);
    }

    @Override // h8.x
    public final String toString() {
        boolean z9 = this.f8842a;
        String str = this.f8843b;
        if (!z9) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        i8.w.a(sb, str);
        return sb.toString();
    }
}
