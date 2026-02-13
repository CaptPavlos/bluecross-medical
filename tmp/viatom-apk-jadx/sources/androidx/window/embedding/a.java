package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.view.WindowMetrics;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f652a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f653b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f652a = i10;
        this.f653b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i10 = this.f652a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f652a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i10 = this.f652a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f652a) {
            case 0:
                return EmbeddingAdapter.m228translateIntentPredicates$lambda8((Set) this.f653b, (Intent) obj);
            case 1:
                return EmbeddingAdapter.m227translateActivityPredicates$lambda6((Set) this.f653b, (Activity) obj);
            default:
                return EmbeddingAdapter.m229translateParentMetricsPredicate$lambda4((SplitRule) this.f653b, (WindowMetrics) obj);
        }
    }
}
