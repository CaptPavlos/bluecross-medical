package androidx.lifecycle.viewmodel.internal;

import androidx.annotation.MainThread;
import androidx.constraintlayout.core.widgets.analyzer.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import r7.w;
import t6.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelImpl {
    private final Set<AutoCloseable> closeables;
    private volatile boolean isCleared;
    private final Map<String, AutoCloseable> keyToCloseables;
    private final SynchronizedObject lock;

    public ViewModelImpl(w wVar, AutoCloseable... autoCloseableArr) {
        wVar.getClass();
        autoCloseableArr.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(wVar));
        r.Y(linkedHashSet, autoCloseableArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                a.C(autoCloseable);
            } catch (Exception e) {
                com.google.gson.internal.a.j(e);
            }
        }
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        str.getClass();
        autoCloseable.getClass();
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            autoCloseable2 = (AutoCloseable) this.keyToCloseables.put(str, autoCloseable);
        }
        closeWithRuntimeException(autoCloseable2);
    }

    @MainThread
    public final void clear() {
        if (this.isCleared) {
            return;
        }
        this.isCleared = true;
        synchronized (this.lock) {
            try {
                Iterator it = this.keyToCloseables.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException((AutoCloseable) it.next());
                }
                Iterator it2 = this.closeables.iterator();
                while (it2.hasNext()) {
                    closeWithRuntimeException((AutoCloseable) it2.next());
                }
                this.closeables.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        T t;
        str.getClass();
        synchronized (this.lock) {
            t = (T) this.keyToCloseables.get(str);
        }
        return t;
    }

    public final void addCloseable(AutoCloseable autoCloseable) {
        autoCloseable.getClass();
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            this.closeables.add(autoCloseable);
        }
    }

    public ViewModelImpl(w wVar) {
        wVar.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(wVar));
    }

    public ViewModelImpl(AutoCloseable... autoCloseableArr) {
        autoCloseableArr.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        r.Y(linkedHashSet, autoCloseableArr);
    }

    public ViewModelImpl() {
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }
}
