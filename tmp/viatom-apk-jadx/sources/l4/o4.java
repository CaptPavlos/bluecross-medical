package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o4 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10686a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10687b;

    public o4(ArrayList arrayList, ArrayList arrayList2) {
        arrayList2.getClass();
        this.f10686a = arrayList;
        this.f10687b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o4)) {
            return false;
        }
        o4 o4Var = (o4) obj;
        return this.f10686a.equals(o4Var.f10686a) && kotlin.jvm.internal.l.a(this.f10687b, o4Var.f10687b);
    }

    public final int hashCode() {
        return this.f10687b.hashCode() + (this.f10686a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MyDownloadsData(downloads=");
        sb.append(this.f10686a);
        sb.append(", downloadsQueue=");
        return a3.a.p(sb, this.f10687b, ')');
    }
}
