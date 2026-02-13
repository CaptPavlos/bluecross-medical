package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.k;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import androidx.window.layout.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    private static final Companion Companion = new Companion(null);
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final SynchronizedObject lock;
    private final g7.a onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, g7.a aVar) {
        savedStateRegistryOwner.getClass();
        aVar.getClass();
        this.owner = savedStateRegistryOwner;
        this.onAttach = aVar;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$12(SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistryImpl.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistryImpl.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        str.getClass();
        if (!this.isRestored) {
            c.g("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleM97constructorimpl = SavedStateReader.m97constructorimpl(bundle);
        Bundle bundleM154getSavedStateimpl = SavedStateReader.m98containsimpl(bundleM97constructorimpl, str) ? SavedStateReader.m154getSavedStateimpl(bundleM97constructorimpl, str) : null;
        SavedStateWriter.m219removeimpl(SavedStateWriter.m183constructorimpl(bundle), str);
        if (SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return bundleM154getSavedStateimpl;
    }

    public final g7.a getOnAttach$savedstate_release() {
        return this.onAttach;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String str) {
        SavedStateRegistry.SavedStateProvider savedStateProvider;
        str.getClass();
        synchronized (this.lock) {
            Iterator it = this.keyToProviders.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
                if (l.a(str2, str)) {
                    savedStateProvider = savedStateProvider2;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach() {
        if (this.owner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) {
            c.g("Restarter must be created only during owner's initialization stage");
        } else {
            if (this.attached) {
                c.g("SavedStateRegistry was already attached.");
                return;
            }
            this.onAttach.invoke();
            this.owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.internal.a
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistryImpl.performAttach$lambda$12(this.f638a, lifecycleOwner, event);
                }
            });
            this.attached = true;
        }
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle bundle) {
        if (!this.attached) {
            performAttach();
        }
        if (this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getCurrentState()).toString());
        }
        if (this.isRestored) {
            c.g("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundleM154getSavedStateimpl = null;
        if (bundle != null) {
            Bundle bundleM97constructorimpl = SavedStateReader.m97constructorimpl(bundle);
            if (SavedStateReader.m98containsimpl(bundleM97constructorimpl, SAVED_COMPONENTS_KEY)) {
                bundleM154getSavedStateimpl = SavedStateReader.m154getSavedStateimpl(bundleM97constructorimpl, SAVED_COMPONENTS_KEY);
            }
        }
        this.restoredState = bundleM154getSavedStateimpl;
        this.isRestored = true;
    }

    @MainThread
    public final void performSave$savedstate_release(Bundle bundle) {
        bundle.getClass();
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(new i[0], 0));
        Bundle bundleM183constructorimpl = SavedStateWriter.m183constructorimpl(bundleBundleOf);
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            SavedStateWriter.m187putAllimpl(bundleM183constructorimpl, bundle2);
        }
        synchronized (this.lock) {
            for (Map.Entry entry : this.keyToProviders.entrySet()) {
                SavedStateWriter.m210putSavedStateimpl(bundleM183constructorimpl, (String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
        }
        if (SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(bundleBundleOf))) {
            return;
        }
        SavedStateWriter.m210putSavedStateimpl(SavedStateWriter.m183constructorimpl(bundle), SAVED_COMPONENTS_KEY, bundleBundleOf);
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        str.getClass();
        savedStateProvider.getClass();
        synchronized (this.lock) {
            if (this.keyToProviders.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.keyToProviders.put(str, savedStateProvider);
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z9) {
        this.isAllowingSavingState = z9;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        str.getClass();
        synchronized (this.lock) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, g7.a aVar, int i10, g gVar) {
        this(savedStateRegistryOwner, (i10 & 2) != 0 ? new k(6) : aVar);
    }
}
