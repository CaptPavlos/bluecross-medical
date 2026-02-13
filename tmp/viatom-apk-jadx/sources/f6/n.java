package f6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    public final String f8117a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8118b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8119c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, String str2) {
        super("invalid value " + str2 + " passed for " + str + " ");
        str2.getClass();
        this.f8117a = str;
        this.f8118b = str2;
        this.f8119c = "";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.l.a(this.f8117a, nVar.f8117a) && kotlin.jvm.internal.l.a(this.f8118b, nVar.f8118b) && kotlin.jvm.internal.l.a(this.f8119c, nVar.f8119c);
    }

    public final int hashCode() {
        return this.f8119c.hashCode() + a.a.b(this.f8118b, this.f8117a.hashCode() * 31);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder("TCModelError(fieldName=");
        sb.append(this.f8117a);
        sb.append(", fieldValue=");
        sb.append(this.f8118b);
        sb.append(", msg=");
        return a3.a.m(sb, this.f8119c, ')');
    }
}
