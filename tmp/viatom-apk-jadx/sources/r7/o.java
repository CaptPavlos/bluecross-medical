package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12419a;

    /* renamed from: b, reason: collision with root package name */
    public final e f12420b;

    /* renamed from: c, reason: collision with root package name */
    public final g7.q f12421c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12422d;
    public final Throwable e;

    public /* synthetic */ o(Object obj, e eVar, g7.q qVar, Throwable th, int i10) {
        this(obj, (i10 & 2) != 0 ? null : eVar, (i10 & 4) != 0 ? null : qVar, (Object) null, (i10 & 16) != 0 ? null : th);
    }

    public static o a(o oVar, e eVar, Throwable th, int i10) {
        Object obj = oVar.f12419a;
        if ((i10 & 2) != 0) {
            eVar = oVar.f12420b;
        }
        e eVar2 = eVar;
        g7.q qVar = oVar.f12421c;
        Object obj2 = oVar.f12422d;
        if ((i10 & 16) != 0) {
            th = oVar.e;
        }
        return new o(obj, eVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.l.a(this.f12419a, oVar.f12419a) && kotlin.jvm.internal.l.a(this.f12420b, oVar.f12420b) && kotlin.jvm.internal.l.a(this.f12421c, oVar.f12421c) && kotlin.jvm.internal.l.a(this.f12422d, oVar.f12422d) && kotlin.jvm.internal.l.a(this.e, oVar.e);
    }

    public final int hashCode() {
        Object obj = this.f12419a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f12420b;
        int iHashCode2 = (iHashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        g7.q qVar = this.f12421c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f12422d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f12419a + ", cancelHandler=" + this.f12420b + ", onCancellation=" + this.f12421c + ", idempotentResume=" + this.f12422d + ", cancelCause=" + this.e + ')';
    }

    public o(Object obj, e eVar, g7.q qVar, Object obj2, Throwable th) {
        this.f12419a = obj;
        this.f12420b = eVar;
        this.f12421c = qVar;
        this.f12422d = obj2;
        this.e = th;
    }
}
