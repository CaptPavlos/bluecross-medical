package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b4 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10242a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10243b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f10244c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f10245d;
    public final ArrayList e;
    public final ArrayList f;

    public b4(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
        this.f10242a = arrayList;
        this.f10243b = arrayList2;
        this.f10244c = arrayList3;
        this.f10245d = arrayList4;
        this.e = arrayList5;
        this.f = arrayList6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return this.f10242a.equals(b4Var.f10242a) && this.f10243b.equals(b4Var.f10243b) && this.f10244c.equals(b4Var.f10244c) && this.f10245d.equals(b4Var.f10245d) && this.e.equals(b4Var.e) && this.f.equals(b4Var.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + ((this.f10245d.hashCode() + ((this.f10244c.hashCode() + ((this.f10243b.hashCode() + (this.f10242a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MyAppsData(tmpAppUpdateData=");
        sb.append(this.f10242a);
        sb.append(", tmpUserApps=");
        sb.append(this.f10243b);
        sb.append(", tmpSystemApps=");
        sb.append(this.f10244c);
        sb.append(", tmpDisabledApps=");
        sb.append(this.f10245d);
        sb.append(", tmpSystemServices=");
        sb.append(this.e);
        sb.append(", tmpPositiveApps=");
        return a3.a.p(sb, this.f, ')');
    }
}
