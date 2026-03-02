package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import java.util.Arrays;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ViewModel {
    private final ViewModelImpl impl;

    public ViewModel(w wVar, AutoCloseable... autoCloseableArr) {
        wVar.getClass();
        autoCloseableArr.getClass();
        this.impl = new ViewModelImpl(wVar, (AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        str.getClass();
        autoCloseable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(str, autoCloseable);
        }
    }

    @MainThread
    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.clear();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        str.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            return (T) viewModelImpl.getCloseable(str);
        }
        return null;
    }

    public void addCloseable(AutoCloseable autoCloseable) {
        autoCloseable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(autoCloseable);
        }
    }

    public /* synthetic */ void addCloseable(Closeable closeable) {
        closeable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(closeable);
        }
    }

    public void onCleared() {
    }

    public ViewModel(w wVar) {
        wVar.getClass();
        this.impl = new ViewModelImpl(wVar);
    }

    public ViewModel(AutoCloseable... autoCloseableArr) {
        autoCloseableArr.getClass();
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public ViewModel() {
        this.impl = new ViewModelImpl();
    }

    public /* synthetic */ ViewModel(Closeable... closeableArr) {
        closeableArr.getClass();
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(closeableArr, closeableArr.length));
    }
}
