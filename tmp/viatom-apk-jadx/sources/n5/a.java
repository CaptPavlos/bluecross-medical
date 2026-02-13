package n5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11527a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11528b;

    public a(ArrayList arrayList, int i10) {
        this.f11527a = arrayList;
        this.f11528b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11527a.equals(aVar.f11527a) && this.f11528b == aVar.f11528b;
    }

    public final int hashCode() {
        return (this.f11527a.hashCode() * 31) + this.f11528b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChildTopsResult(tops=");
        sb.append(this.f11527a);
        sb.append(", errors=");
        return a3.a.k(sb, this.f11528b, ')');
    }
}
