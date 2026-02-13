package androidx.core.content;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f471b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f470a = i10;
        this.f471b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i10 = this.f470a;
        return androidx.constraintlayout.core.widgets.analyzer.a.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        switch (this.f470a) {
        }
        return new androidx.core.util.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i10 = this.f470a;
        return androidx.constraintlayout.core.widgets.analyzer.a.e(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f470a) {
            case 0:
                return ((ComponentName) this.f471b).equals((ComponentName) obj);
            default:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.f471b, (Uri) obj);
        }
    }
}
