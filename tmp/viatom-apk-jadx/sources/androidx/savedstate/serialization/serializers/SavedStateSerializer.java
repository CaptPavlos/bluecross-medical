package androidx.savedstate.serialization.serializers;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import c8.b;
import e8.e;
import kotlin.jvm.internal.l;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateSerializer implements b {
    public static final SavedStateSerializer INSTANCE = new SavedStateSerializer();
    private static final e descriptor = a.a.i("androidx.savedstate.SavedState", new e[0]);

    private SavedStateSerializer() {
    }

    @Override // c8.a
    public Bundle deserialize(f8.e eVar) {
        eVar.getClass();
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return l.a(savedStateDecoder.getKey$savedstate_release(), "") ? savedStateDecoder.getSavedState$savedstate_release() : SavedStateReader.m154getSavedStateimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        f.b(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar));
        return null;
    }

    @Override // c8.g, c8.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public void serialize(f8.f fVar, Bundle bundle) {
        fVar.getClass();
        bundle.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            f.b(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar));
            return;
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
        if (l.a(savedStateEncoder.getKey$savedstate_release(), "")) {
            SavedStateWriter.m187putAllimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), bundle);
        } else {
            SavedStateWriter.m210putSavedStateimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), bundle);
        }
    }
}
