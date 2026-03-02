package androidx.savedstate.serialization.serializers;

import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import c8.b;
import e8.e;
import java.io.Serializable;
import kotlin.jvm.internal.y;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class JavaSerializableSerializer<T extends Serializable> implements b {
    private final e descriptor = a.a.i("java.io.Serializable", new e[0]);

    @Override // c8.a
    public final T deserialize(f8.e eVar) {
        eVar.getClass();
        if (!(eVar instanceof SavedStateDecoder)) {
            f.b(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.a(), eVar));
            return null;
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
        T t = (T) SavedStateReader.m135getJavaSerializableimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), y.a(Serializable.class));
        t.getClass();
        return t;
    }

    @Override // c8.g, c8.a
    public final e getDescriptor() {
        return this.descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, T t) {
        fVar.getClass();
        t.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            f.b(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.a(), fVar));
        } else {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m203putJavaSerializableimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), t);
        }
    }
}
