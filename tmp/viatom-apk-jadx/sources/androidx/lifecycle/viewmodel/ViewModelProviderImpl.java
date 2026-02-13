package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import kotlin.jvm.internal.f;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelProviderImpl {
    private final CreationExtras defaultExtras;
    private final ViewModelProvider.Factory factory;
    private final SynchronizedObject lock;
    private final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore viewModelStore, ViewModelProvider.Factory factory, CreationExtras creationExtras) {
        viewModelStore.getClass();
        factory.getClass();
        creationExtras.getClass();
        this.store = viewModelStore;
        this.factory = factory;
        this.defaultExtras = creationExtras;
        this.lock = new SynchronizedObject();
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel_release$default(ViewModelProviderImpl viewModelProviderImpl, c cVar, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel_release(cVar);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel_release(cVar, str);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel_release(c cVar, String str) {
        T t;
        cVar.getClass();
        str.getClass();
        synchronized (this.lock) {
            try {
                t = (T) this.store.get(str);
                if (((f) cVar).d(t)) {
                    if (this.factory instanceof ViewModelProvider.OnRequeryFactory) {
                        ViewModelProvider.OnRequeryFactory onRequeryFactory = (ViewModelProvider.OnRequeryFactory) this.factory;
                        t.getClass();
                        onRequeryFactory.onRequery(t);
                    }
                    t.getClass();
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultExtras);
                    mutableCreationExtras.set(ViewModelProvider.VIEW_MODEL_KEY, str);
                    t = (T) ViewModelProviderImpl_androidKt.createViewModel(this.factory, cVar, mutableCreationExtras);
                    this.store.put(str, t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }
}
