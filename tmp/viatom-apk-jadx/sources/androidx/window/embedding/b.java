package androidx.window.embedding;

import android.util.Pair;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f654a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f655b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f656c;

    public /* synthetic */ b(EmbeddingAdapter embeddingAdapter, Set set, int i10) {
        this.f654a = i10;
        this.f655b = embeddingAdapter;
        this.f656c = set;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i10 = this.f654a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f654a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i10 = this.f654a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f654a) {
            case 0:
                return EmbeddingAdapter.m226translateActivityPairPredicates$lambda1(this.f655b, this.f656c, (Pair) obj);
            default:
                return EmbeddingAdapter.m225translateActivityIntentPredicates$lambda3(this.f655b, this.f656c, (Pair) obj);
        }
    }
}
