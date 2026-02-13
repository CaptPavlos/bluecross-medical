package androidx.savedstate.serialization;

import android.os.Bundle;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(c8.a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        aVar.getClass();
        bundle.getClass();
        savedStateConfiguration.getClass();
        return (T) new SavedStateDecoder(bundle, savedStateConfiguration).decodeSerializableValue(aVar);
    }

    public static Object decodeFromSavedState$default(Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> T decodeFromSavedState(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ Object decodeFromSavedState$default(c8.a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedState(aVar, bundle, savedStateConfiguration);
    }

    public static final <T> T decodeFromSavedState(c8.a aVar, Bundle bundle) {
        aVar.getClass();
        bundle.getClass();
        return (T) decodeFromSavedState$default(aVar, bundle, null, 4, null);
    }
}
