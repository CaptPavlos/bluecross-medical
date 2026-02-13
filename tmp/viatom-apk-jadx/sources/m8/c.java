package m8;

import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11244a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11245b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11246c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f11247d;
    public final String e;
    public final ArrayList f;

    public c(Integer num, Integer num2, String str, String str2, ArrayList arrayList) {
        Boolean bool = Boolean.FALSE;
        this.f11244a = num;
        this.f11245b = num2;
        this.f11246c = str;
        this.f11247d = bool;
        this.e = str2;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11244a.equals(cVar.f11244a) && this.f11245b.equals(cVar.f11245b) && l.a(this.f11246c, cVar.f11246c) && l.a(this.f11247d, cVar.f11247d) && l.a(this.e, cVar.e) && this.f.equals(cVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.f11245b.hashCode() + (this.f11244a.hashCode() * 31)) * 31;
        String str = this.f11246c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f11247d;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.e;
        return this.f.hashCode() + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MSPASensitivePurpose(id=");
        sb.append(this.f11244a);
        sb.append(", order=");
        sb.append(this.f11245b);
        sb.append(", title=");
        sb.append((Object) this.f11246c);
        sb.append(", value=");
        sb.append(this.f11247d);
        sb.append(", description=");
        sb.append((Object) this.e);
        sb.append(", nationalIds=");
        return a3.a.p(sb, this.f, ')');
    }
}
