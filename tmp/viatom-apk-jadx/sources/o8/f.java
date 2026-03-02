package o8;

import java.util.List;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11803a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11804b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11805c;

    public f(boolean z9, List list, List list2) {
        this.f11803a = z9;
        this.f11804b = list;
        this.f11805c = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11803a == fVar.f11803a && kotlin.jvm.internal.l.a(this.f11804b, fVar.f11804b) && kotlin.jvm.internal.l.a(this.f11805c, fVar.f11805c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    public final int hashCode() {
        boolean z9 = this.f11803a;
        ?? r02 = z9;
        if (z9) {
            r02 = 1;
        }
        return this.f11805c.hashCode() + m8.e.a(r02 * 31, this.f11804b);
    }

    public final String toString() {
        return "GBCConfig(enabled=" + this.f11803a + ", locations=" + this.f11804b + ", applicablePurposes=" + this.f11805c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ f() {
        t tVar = t.f12808a;
        this(false, tVar, tVar);
    }
}
