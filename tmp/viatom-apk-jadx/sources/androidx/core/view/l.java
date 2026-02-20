package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f529a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f530b;

    public /* synthetic */ l(ViewConfiguration viewConfiguration, int i10) {
        this.f529a = i10;
        this.f530b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f529a) {
            case 0:
                scaledMaximumFlingVelocity = this.f530b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.f530b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
