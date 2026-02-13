package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements g7.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // g7.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends m implements g7.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // g7.a
        public final CreationExtras invoke() {
            return this.$this_viewModels.getDefaultViewModelCreationExtras();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    public static final class AnonymousClass3 extends m implements g7.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // g7.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    public static final class AnonymousClass4 extends m implements g7.a {
        final /* synthetic */ g7.a $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(g7.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = aVar;
            this.$this_viewModels = componentActivity;
        }

        @Override // g7.a
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            g7.a aVar = this.$extrasProducer;
            return (aVar == null || (creationExtras = (CreationExtras) aVar.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    @MainThread
    public static final <VM extends ViewModel> s6.f viewModels(ComponentActivity componentActivity, g7.a aVar) {
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        l.h();
        throw null;
    }

    public static s6.f viewModels$default(ComponentActivity componentActivity, g7.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        l.h();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> s6.f viewModels(ComponentActivity componentActivity, g7.a aVar, g7.a aVar2) {
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        l.h();
        throw null;
    }

    public static s6.f viewModels$default(ComponentActivity componentActivity, g7.a aVar, g7.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar2 = null;
        }
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        l.h();
        throw null;
    }
}
