package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f551a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f552b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f551a = i10;
        this.f552b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f551a) {
            case 0:
                return ((FragmentActivity) this.f552b).lambda$init$0();
            case 1:
                return ((FragmentManager) this.f552b).lambda$attachController$4();
            default:
                return SavedStateHandleImpl.savedStateProvider$lambda$0((SavedStateHandleImpl) this.f552b);
        }
    }
}
