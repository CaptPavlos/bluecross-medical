package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import s6.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements g7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // g7.a
        public final ViewModelStore invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            fragmentActivityRequireActivity.getClass();
            ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
            viewModelStore.getClass();
            return viewModelStore;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends m implements g7.a {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // g7.a
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            fragmentActivityRequireActivity.getClass();
            return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01042 extends m implements g7.a {
        final /* synthetic */ g7.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01042(g7.a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        @Override // g7.a
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            viewModelStore.getClass();
            return viewModelStore;
        }
    }

    @MainThread
    public static final <VM extends ViewModel> f activityViewModels(Fragment fragment, g7.a aVar) {
        fragment.getClass();
        l.h();
        throw null;
    }

    public static f activityViewModels$default(Fragment fragment, g7.a aVar, int i10, Object obj) {
        fragment.getClass();
        l.h();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> f createViewModelLazy(Fragment fragment, m7.c cVar, g7.a aVar, g7.a aVar2) {
        fragment.getClass();
        cVar.getClass();
        aVar.getClass();
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(cVar, aVar, aVar2);
    }

    public static /* synthetic */ f createViewModelLazy$default(Fragment fragment, m7.c cVar, g7.a aVar, g7.a aVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, cVar, aVar, aVar2);
    }

    @MainThread
    public static final <VM extends ViewModel> f viewModels(Fragment fragment, g7.a aVar, g7.a aVar2) {
        fragment.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    public static f viewModels$default(Fragment fragment, g7.a aVar, g7.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = new C01031(fragment);
        }
        fragment.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01031 extends m implements g7.a {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01031(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        @Override // g7.a
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }
}
