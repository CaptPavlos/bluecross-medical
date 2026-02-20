package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import g7.l;
import h0.p;
import j8.d;
import j8.f;
import j8.h;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateConfigurationKt {
    private static final f DEFAULT_SERIALIZERS_MODULE;

    static {
        p pVar = new p();
        pVar.p(y.a(Bundle.class), SavedStateSerializer.INSTANCE);
        d dVarA = pVar.a();
        f defaultSerializersModuleOnPlatform = SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform();
        d dVar = h.f10036a;
        defaultSerializersModuleOnPlatform.getClass();
        p pVar2 = new p();
        dVarA.a(pVar2);
        defaultSerializersModuleOnPlatform.a(pVar2);
        DEFAULT_SERIALIZERS_MODULE = pVar2.a();
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration savedStateConfiguration, l lVar) {
        savedStateConfiguration.getClass();
        lVar.getClass();
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(savedStateConfiguration);
        lVar.invoke(builder);
        return builder.build$savedstate_release();
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, lVar);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(l lVar) {
        lVar.getClass();
        return SavedStateConfiguration$default(null, lVar, 1, null);
    }
}
