package androidx.savedstate.serialization.serializers;

import android.util.SizeF;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import c8.b;
import e8.e;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SizeFSerializer implements b {
    public static final SizeFSerializer INSTANCE = new SizeFSerializer();
    private static final e descriptor = a.a.i("android.util.SizeF", new e[0]);

    private SizeFSerializer() {
    }

    @Override // c8.a
    public SizeF deserialize(f8.e eVar) {
        eVar.getClass();
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m161getSizeFimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release());
        }
        f.b(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar));
        return null;
    }

    @Override // c8.g, c8.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public void serialize(f8.f fVar, SizeF sizeF) {
        fVar.getClass();
        sizeF.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            f.b(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar));
        } else {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m214putSizeFimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), sizeF);
        }
    }
}
