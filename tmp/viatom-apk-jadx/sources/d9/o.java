package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f7567a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7568b;

    public o(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.f7567a = str;
        this.f7568b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.l.a(this.f7567a, oVar.f7567a) && kotlin.jvm.internal.l.a(this.f7568b, oVar.f7568b);
    }

    public final int hashCode() {
        return this.f7568b.hashCode() + (this.f7567a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnersDisclosureLabels(disclosureLabel=");
        sb.append(this.f7567a);
        sb.append(", backLabel=");
        return a3.a.m(sb, this.f7568b, ')');
    }
}
