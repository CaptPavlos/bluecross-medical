package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.gms.internal.measurement.a4;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        savedStateRegistryOwner.getClass();
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        this.factory = application != null ? ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application) : new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        String str = (String) creationExtras.get(ViewModelProvider.VIEW_MODEL_KEY);
        if (str == null) {
            androidx.window.layout.c.g("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (creationExtras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null || creationExtras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) {
            if (this.lifecycle != null) {
                return (T) create(str, cls);
            }
            androidx.window.layout.c.g("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Constructor constructorFindMatchingConstructor = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
        return constructorFindMatchingConstructor == null ? (T) this.factory.create(cls, creationExtras) : (!zIsAssignableFrom || application == null) ? (T) SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(creationExtras)) : (T) SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        viewModel.getClass();
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            savedStateRegistry.getClass();
            Lifecycle lifecycle = this.lifecycle;
            lifecycle.getClass();
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
        savedStateRegistryOwner.getClass();
    }

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(m7.c cVar, CreationExtras creationExtras) {
        cVar.getClass();
        creationExtras.getClass();
        return (T) create(a4.q(cVar), creationExtras);
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        T t;
        Application application;
        str.getClass();
        cls.getClass();
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            Constructor constructorFindMatchingConstructor = (!zIsAssignableFrom || this.application == null) ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
            if (constructorFindMatchingConstructor == null) {
                return this.application != null ? (T) this.factory.create(cls) : (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(cls);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            savedStateRegistry.getClass();
            SavedStateHandleController savedStateHandleControllerCreate = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, str, this.defaultArgs);
            if (!zIsAssignableFrom || (application = this.application) == null) {
                t = (T) SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, savedStateHandleControllerCreate.getHandle());
            } else {
                application.getClass();
                t = (T) SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, savedStateHandleControllerCreate.getHandle());
            }
            t.addCloseable(LegacySavedStateHandleController.TAG_SAVED_STATE_HANDLE_CONTROLLER, savedStateHandleControllerCreate);
            return t;
        }
        a2.a.m("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        cls.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        com.google.gson.internal.a.n("Local and anonymous classes can not be ViewModels");
        return null;
    }
}
