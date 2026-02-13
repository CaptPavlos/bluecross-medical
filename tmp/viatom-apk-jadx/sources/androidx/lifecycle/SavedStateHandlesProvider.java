package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.Arrays;
import java.util.Map;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final s6.f viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        savedStateRegistry.getClass();
        viewModelStoreOwner.getClass();
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new m(new b(viewModelStoreOwner, 1));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        str.getClass();
        performRestore();
        Bundle bundle = this.restoredState;
        if (bundle == null || !SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(bundle), str)) {
            return null;
        }
        Bundle bundleM159getSavedStateOrNullimpl = SavedStateReader.m159getSavedStateOrNullimpl(SavedStateReader.m97constructorimpl(bundle), str);
        if (bundleM159getSavedStateOrNullimpl == null) {
            s6.i[] iVarArr = new s6.i[0];
            bundleM159getSavedStateOrNullimpl = BundleKt.bundleOf((s6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
            SavedStateWriter.m183constructorimpl(bundleM159getSavedStateOrNullimpl);
        }
        SavedStateWriter.m219removeimpl(SavedStateWriter.m183constructorimpl(bundle), str);
        if (SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return bundleM159getSavedStateOrNullimpl;
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey(SavedStateHandleSupport.SAVED_STATE_KEY);
        s6.i[] iVarArr = new s6.i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((s6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        Bundle bundleM183constructorimpl = SavedStateWriter.m183constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m187putAllimpl(bundleM183constructorimpl, bundle);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            SavedStateWriter.m187putAllimpl(bundleM183constructorimpl, bundleConsumeRestoredStateForKey);
        }
        this.restoredState = bundleBundleOf;
        this.restored = true;
        getViewModel();
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle bundleBundleOf = BundleKt.bundleOf((s6.i[]) Arrays.copyOf(new s6.i[0], 0));
        Bundle bundleM183constructorimpl = SavedStateWriter.m183constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m187putAllimpl(bundleM183constructorimpl, bundle);
        }
        for (Map.Entry<String, SavedStateHandle> entry : getViewModel().getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle bundleSaveState = entry.getValue().savedStateProvider().saveState();
            if (!SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(bundleSaveState))) {
                SavedStateWriter.m210putSavedStateimpl(bundleM183constructorimpl, key, bundleSaveState);
            }
        }
        this.restored = false;
        return bundleBundleOf;
    }
}
