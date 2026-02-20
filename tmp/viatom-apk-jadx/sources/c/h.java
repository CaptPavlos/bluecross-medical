package c;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final k8.d f964a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f965b;

    /* renamed from: c, reason: collision with root package name */
    public final int f966c;

    /* renamed from: d, reason: collision with root package name */
    public final int f967d;
    public final boolean e;
    public final String f;
    public final Integer g;

    public h(k8.d dVar, Boolean bool, int i10, int i11, String str, Integer num, int i12) {
        dVar = (i12 & 1) != 0 ? new k8.d() : dVar;
        bool = (i12 & 2) != 0 ? null : bool;
        i10 = (i12 & 4) != 0 ? 1 : i10;
        i11 = (i12 & 8) != 0 ? 1 : i11;
        boolean z9 = (i12 & 16) != 0;
        str = (i12 & 32) != 0 ? "" : str;
        num = (i12 & 64) != 0 ? null : num;
        dVar.getClass();
        if (i10 == 0 || i11 == 0) {
            throw null;
        }
        str.getClass();
        this.f964a = dVar;
        this.f965b = bool;
        this.f966c = i10;
        this.f967d = i11;
        this.e = z9;
        this.f = str;
        this.g = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return l.a(this.f964a, hVar.f964a) && l.a(this.f965b, hVar.f965b) && this.f966c == hVar.f966c && this.f967d == hVar.f967d && this.e == hVar.e && l.a(this.f, hVar.f) && l.a(this.g, hVar.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.f964a.hashCode() * 31;
        Boolean bool = this.f965b;
        int iC = (i.c(this.f967d) + ((i.c(this.f966c) + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31)) * 31)) * 31;
        boolean z9 = this.e;
        int i10 = z9;
        if (z9 != 0) {
            i10 = 1;
        }
        int iB = a.a.b(this.f, (iC + i10) * 31);
        Integer num = this.g;
        return iB + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SwitchItemData(value=");
        sb.append(this.f964a);
        sb.append(", selectedState=");
        sb.append(this.f965b);
        sb.append(", viewType=");
        int i10 = this.f966c;
        sb.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "null" : "NON_SWITCH" : "LABEL" : "DESCRIPTION" : "NORMAL");
        sb.append(", itemType=");
        sb.append(i.d(this.f967d));
        sb.append(", isTagEnabled=");
        sb.append(this.e);
        sb.append(", text=");
        sb.append(this.f);
        sb.append(", counter=");
        sb.append(this.g);
        sb.append(')');
        return sb.toString();
    }
}
