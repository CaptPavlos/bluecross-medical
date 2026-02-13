package androidx.core.util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Predicate f514a;

    public /* synthetic */ b(Predicate predicate) {
        this.f514a = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.constraintlayout.core.widgets.analyzer.a.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        return new b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.constraintlayout.core.widgets.analyzer.a.e(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return !this.f514a.test(obj);
    }
}
