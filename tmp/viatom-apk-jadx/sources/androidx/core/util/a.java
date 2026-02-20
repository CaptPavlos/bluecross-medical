package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f511a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f512b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f513c;

    public /* synthetic */ a(Class cls, Predicate predicate) {
        this.f511a = 2;
        this.f513c = cls;
        this.f512b = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i10 = this.f511a;
        return androidx.constraintlayout.core.widgets.analyzer.a.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        switch (this.f511a) {
        }
        return new b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i10 = this.f511a;
        return androidx.constraintlayout.core.widgets.analyzer.a.e(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f511a) {
            case 0:
                return this.f512b.test(obj) || ((Predicate) this.f513c).test(obj);
            case 1:
                return this.f512b.test(obj) && ((Predicate) this.f513c).test(obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.f513c, this.f512b, obj);
        }
    }

    public /* synthetic */ a(Predicate predicate, Predicate predicate2, int i10) {
        this.f511a = i10;
        this.f512b = predicate;
        this.f513c = predicate2;
    }
}
