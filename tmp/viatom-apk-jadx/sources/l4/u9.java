package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u9 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10886a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10887b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f10888c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f10889d;
    public final t9 e;

    public u9(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, t9 t9Var) {
        arrayList.getClass();
        arrayList2.getClass();
        arrayList3.getClass();
        arrayList4.getClass();
        this.f10886a = arrayList;
        this.f10887b = arrayList2;
        this.f10888c = arrayList3;
        this.f10889d = arrayList4;
        this.e = t9Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u9)) {
            return false;
        }
        u9 u9Var = (u9) obj;
        return kotlin.jvm.internal.l.a(this.f10886a, u9Var.f10886a) && kotlin.jvm.internal.l.a(this.f10887b, u9Var.f10887b) && kotlin.jvm.internal.l.a(this.f10888c, u9Var.f10888c) && kotlin.jvm.internal.l.a(this.f10889d, u9Var.f10889d) && this.e.equals(u9Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.f10889d.hashCode() + ((this.f10888c.hashCode() + ((this.f10887b.hashCode() + (this.f10886a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "UpdatesData(updates=" + this.f10886a + ", disabled=" + this.f10887b + ", ignored=" + this.f10888c + ", recentlyUpdated=" + this.f10889d + ", downloadAllButtonData=" + this.e + ')';
    }
}
