package n6;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11559a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11560b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11561c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11562d;

    public a(String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.f11559a = str;
        this.f11560b = str2;
        this.f11561c = str3;
        this.f11562d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l.a(this.f11559a, aVar.f11559a) && l.a(this.f11560b, aVar.f11560b) && l.a(this.f11561c, aVar.f11561c) && l.a(this.f11562d, aVar.f11562d);
    }

    public final int hashCode() {
        return this.f11562d.hashCode() + a.a.b(this.f11561c, a.a.b(this.f11560b, this.f11559a.hashCode() * 31));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Banner(title=");
        sb.append(this.f11559a);
        sb.append(", sectionTitle=");
        sb.append(this.f11560b);
        sb.append(", description=");
        sb.append(this.f11561c);
        sb.append(", confirm=");
        return a3.a.m(sb, this.f11562d, ')');
    }

    public /* synthetic */ a(String str, String str2, int i10) {
        this((i10 & 1) != 0 ? "" : str, "", (i10 & 4) != 0 ? "" : str2, "");
    }
}
