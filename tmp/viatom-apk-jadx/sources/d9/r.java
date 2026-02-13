package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f7577a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7578b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7579c;

    public r(String str, int i10, String str2) {
        str.getClass();
        str2.getClass();
        this.f7577a = i10;
        this.f7578b = str;
        this.f7579c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f7577a == rVar.f7577a && kotlin.jvm.internal.l.a(this.f7578b, rVar.f7578b) && kotlin.jvm.internal.l.a(this.f7579c, rVar.f7579c);
    }

    public final int hashCode() {
        return this.f7579c.hashCode() + a.a.b(this.f7578b, this.f7577a * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StackInfo(id=");
        sb.append(this.f7577a);
        sb.append(", label=");
        sb.append(this.f7578b);
        sb.append(", state=");
        return a3.a.m(sb, this.f7579c, ')');
    }
}
