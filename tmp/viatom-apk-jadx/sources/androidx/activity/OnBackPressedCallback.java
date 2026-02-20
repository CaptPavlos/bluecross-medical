package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private g7.a enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z9) {
        this.isEnabled = z9;
    }

    public final void addCancellable(Cancellable cancellable) {
        cancellable.getClass();
        this.cancellables.add(cancellable);
    }

    public final g7.a getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        backEventCompat.getClass();
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        backEventCompat.getClass();
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    public final void removeCancellable(Cancellable cancellable) {
        cancellable.getClass();
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z9) {
        this.isEnabled = z9;
        g7.a aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(g7.a aVar) {
        this.enabledChangedCallback = aVar;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }
}
