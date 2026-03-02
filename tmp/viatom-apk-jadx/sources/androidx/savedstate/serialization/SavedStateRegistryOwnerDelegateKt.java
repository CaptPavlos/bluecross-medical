package androidx.savedstate.serialization;

import androidx.savedstate.SavedStateRegistryOwner;
import i7.b;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateRegistryOwnerDelegateKt {
    public static final <T> b saved(SavedStateRegistryOwner savedStateRegistryOwner, c8.b bVar, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar) {
        savedStateRegistryOwner.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateRegistryOwnerDelegate(savedStateRegistryOwner.getSavedStateRegistry(), bVar, str, savedStateConfiguration, aVar);
    }

    public static b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, c8.b bVar, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateRegistryOwner, bVar, str, savedStateConfiguration, aVar);
    }

    public static final <T> b saved(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar) {
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }
}
