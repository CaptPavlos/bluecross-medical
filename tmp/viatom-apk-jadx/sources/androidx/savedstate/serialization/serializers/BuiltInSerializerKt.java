package androidx.savedstate.serialization.serializers;

import f8.e;
import f8.f;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String str, e eVar) {
        str.getClass();
        eVar.getClass();
        return "Cannot deserialize " + str + " with '" + y.a(eVar.getClass()).c() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String str, f fVar) {
        str.getClass();
        fVar.getClass();
        return "Cannot serialize " + str + " with '" + y.a(fVar.getClass()).c() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
