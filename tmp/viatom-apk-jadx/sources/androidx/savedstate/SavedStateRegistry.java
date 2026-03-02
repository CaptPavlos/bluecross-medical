package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.savedstate.Recreator;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private final SavedStateRegistryImpl impl;
    private Recreator.SavedStateProvider recreatorProvider;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl savedStateRegistryImpl) {
        savedStateRegistryImpl.getClass();
        this.impl = savedStateRegistryImpl;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        str.getClass();
        return this.impl.consumeRestoredStateForKey(str);
    }

    public final SavedStateProvider getSavedStateProvider(String str) {
        str.getClass();
        return this.impl.getSavedStateProvider(str);
    }

    @MainThread
    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        str.getClass();
        savedStateProvider.getClass();
        this.impl.registerSavedStateProvider(str, savedStateProvider);
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> cls) throws NoSuchMethodException, SecurityException {
        cls.getClass();
        if (!this.impl.isAllowingSavingState$savedstate_release()) {
            c.g("Can not perform this action after onSaveInstanceState");
            return;
        }
        Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.recreatorProvider = savedStateProvider;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
            if (savedStateProvider2 != null) {
                savedStateProvider2.add(cls.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        str.getClass();
        this.impl.unregisterSavedStateProvider(str);
    }
}
