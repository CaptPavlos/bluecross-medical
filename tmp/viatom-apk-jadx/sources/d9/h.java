package d9;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f7508a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7509b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7510c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7511d;
    public final ArrayList e;

    public h(String str, String str2, int i10, String str3, ArrayList arrayList) {
        this.f7508a = str;
        this.f7509b = str2;
        this.f7510c = i10;
        this.f7511d = str3;
        this.e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f7508a.equals(hVar.f7508a) && this.f7509b.equals(hVar.f7509b) && this.f7510c == hVar.f7510c && this.f7511d.equals(hVar.f7511d) && this.e.equals(hVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o((this.f7510c + androidx.constraintlayout.core.widgets.analyzer.a.o(this.f7508a.hashCode() * 31, 31, this.f7509b)) * 31, 31, this.f7511d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Disclosure(identifier=");
        sb.append(this.f7508a);
        sb.append(", type=");
        sb.append(this.f7509b);
        sb.append(", maxAgeSeconds=");
        sb.append(this.f7510c);
        sb.append(", domain=");
        sb.append(this.f7511d);
        sb.append(", purposes=");
        return a3.a.p(sb, this.e, ')');
    }
}
