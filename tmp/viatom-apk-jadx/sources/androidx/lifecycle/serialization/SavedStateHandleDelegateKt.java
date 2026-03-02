package androidx.lifecycle.serialization;

import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import i7.b;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateHandleDelegateKt {
    public static final <T> b saved(SavedStateHandle savedStateHandle, c8.b bVar, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar) {
        savedStateHandle.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateHandleDelegate(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }

    public static b saved$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> b saved(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar) {
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ b saved$default(SavedStateHandle savedStateHandle, c8.b bVar, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }
}
