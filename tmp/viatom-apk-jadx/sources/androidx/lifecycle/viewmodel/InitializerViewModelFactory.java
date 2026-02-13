package androidx.lifecycle.viewmodel;

import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.y;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        viewModelInitializerArr.getClass();
        this.initializers = viewModelInitializerArr;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <VM extends ViewModel> VM create(Class<VM> cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        ViewModelProviders viewModelProviders = ViewModelProviders.INSTANCE;
        f fVarA = y.a(cls);
        ViewModelInitializer<?>[] viewModelInitializerArr = this.initializers;
        return (VM) viewModelProviders.createViewModelFromInitializers$lifecycle_viewmodel_release(fVarA, creationExtras, (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return a.c(this, cVar, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        cls.getClass();
        return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel_release();
    }
}
