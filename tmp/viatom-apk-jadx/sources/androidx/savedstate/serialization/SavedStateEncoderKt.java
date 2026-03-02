package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateWriter;
import c8.g;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateEncoderKt {
    public static final <T> Bundle encodeToSavedState(g gVar, T t, SavedStateConfiguration savedStateConfiguration) {
        gVar.getClass();
        t.getClass();
        savedStateConfiguration.getClass();
        i[] iVarArr = new i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleBundleOf);
        new SavedStateEncoder(bundleBundleOf, savedStateConfiguration).encodeSerializableValue(gVar, t);
        return bundleBundleOf;
    }

    public static Bundle encodeToSavedState$default(Object obj, SavedStateConfiguration savedStateConfiguration, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        obj.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(g gVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedState(gVar, obj, savedStateConfiguration);
    }

    public static final <T> Bundle encodeToSavedState(T t, SavedStateConfiguration savedStateConfiguration) {
        t.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> Bundle encodeToSavedState(g gVar, T t) {
        gVar.getClass();
        t.getClass();
        return encodeToSavedState$default(gVar, t, null, 4, null);
    }
}
