package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends m implements g7.a {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    @Override // g7.a
    public final ViewModelProvider.Factory invoke() {
        return this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
    }
}
