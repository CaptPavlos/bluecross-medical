package p8;

import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final s f12205a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12206b;

    /* renamed from: c, reason: collision with root package name */
    public final r f12207c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12208d;
    public volatile i e;

    public z(w2.r rVar) {
        this.f12205a = (s) rVar.f13463c;
        this.f12206b = (String) rVar.f13462b;
        n5 n5Var = (n5) rVar.f13464d;
        n5Var.getClass();
        this.f12207c = new r(n5Var);
        Object obj = rVar.e;
        this.f12208d = obj == null ? this : obj;
    }

    public final w2.r a() {
        w2.r rVar = new w2.r(false);
        rVar.f13463c = this.f12205a;
        rVar.f13462b = this.f12206b;
        rVar.e = this.f12208d;
        rVar.f13464d = this.f12207c.c();
        return rVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f12206b);
        sb.append(", url=");
        sb.append(this.f12205a);
        sb.append(", tag=");
        Object obj = this.f12208d;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
