package androidx.lifecycle.viewmodel.internal;

import androidx.constraintlayout.core.state.b;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import com.google.gson.internal.a;
import g7.l;
import java.util.Arrays;
import java.util.Collection;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelProviders {
    public static final ViewModelProviders INSTANCE = new ViewModelProviders();
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    private ViewModelProviders() {
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(Collection<? extends ViewModelInitializer<?>> collection) {
        collection.getClass();
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) collection.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }

    public final <VM extends ViewModel> VM createViewModelFromInitializers$lifecycle_viewmodel_release(c cVar, CreationExtras creationExtras, ViewModelInitializer<?>... viewModelInitializerArr) {
        VM vm;
        ViewModelInitializer<?> viewModelInitializer;
        l initializer$lifecycle_viewmodel_release;
        cVar.getClass();
        creationExtras.getClass();
        viewModelInitializerArr.getClass();
        int length = viewModelInitializerArr.length;
        int i10 = 0;
        while (true) {
            vm = null;
            if (i10 >= length) {
                viewModelInitializer = null;
                break;
            }
            viewModelInitializer = viewModelInitializerArr[i10];
            if (kotlin.jvm.internal.l.a(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), cVar)) {
                break;
            }
            i10++;
        }
        if (viewModelInitializer != null && (initializer$lifecycle_viewmodel_release = viewModelInitializer.getInitializer$lifecycle_viewmodel_release()) != null) {
            vm = (VM) initializer$lifecycle_viewmodel_release.invoke(creationExtras);
        }
        if (vm != null) {
            return vm;
        }
        b.i(CanonicalName_jvmKt.getCanonicalName(cVar), "No initializer set for given class ");
        return null;
    }

    public final CreationExtras getDefaultCreationExtras$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
        viewModelStoreOwner.getClass();
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
    }

    public final ViewModelProvider.Factory getDefaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
        viewModelStoreOwner.getClass();
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : DefaultViewModelProviderFactory.INSTANCE;
    }

    public final <T extends ViewModel> String getDefaultKey$lifecycle_viewmodel_release(c cVar) {
        cVar.getClass();
        String canonicalName = CanonicalName_jvmKt.getCanonicalName(cVar);
        if (canonicalName != null) {
            return "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
        }
        a.n("Local and anonymous classes can not be ViewModels");
        return null;
    }

    public final <VM extends ViewModel> VM unsupportedCreateViewModel$lifecycle_viewmodel_release() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(ViewModelInitializer<?>... viewModelInitializerArr) {
        viewModelInitializerArr.getClass();
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
