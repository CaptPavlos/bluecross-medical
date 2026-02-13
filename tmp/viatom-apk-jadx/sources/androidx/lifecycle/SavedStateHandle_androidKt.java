package androidx.lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateHandle_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String createMutuallyExclusiveErrorMessage(String str) {
        return androidx.constraintlayout.core.widgets.analyzer.a.x("StateFlow and LiveData are mutually exclusive for the same key. Please use either 'getMutableStateFlow' or 'getLiveData' for key '", str, "', but not both.");
    }
}
