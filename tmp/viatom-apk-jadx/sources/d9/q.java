package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f7575a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7576b;

    public q(String str, String str2) {
        this.f7575a = str;
        this.f7576b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f7575a.equals(qVar.f7575a) && this.f7576b.equals(qVar.f7576b);
    }

    public final int hashCode() {
        return this.f7576b.hashCode() + (this.f7575a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PublisherCustomLink(label=");
        sb.append(this.f7575a);
        sb.append(", link=");
        return a3.a.m(sb, this.f7576b, ')');
    }
}
