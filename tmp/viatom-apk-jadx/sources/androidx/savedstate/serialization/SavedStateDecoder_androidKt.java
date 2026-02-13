package androidx.savedstate.serialization;

import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import com.google.android.gms.internal.measurement.a4;
import e8.e;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateDecoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T decodeFormatSpecificTypesOnPlatform(SavedStateDecoder savedStateDecoder, c8.a aVar) {
        savedStateDecoder.getClass();
        aVar.getClass();
        e descriptor = aVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return (T) CharSequenceSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return (T) DefaultParcelableSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return (T) DefaultJavaSerializableSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return (T) IBinderSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            return (T) CharSequenceArraySerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            return (T) CharSequenceListSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
            Parcelable[] parcelableArrDeserialize = ParcelableArraySerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
            return (T) Arrays.copyOf(parcelableArrDeserialize, parcelableArrDeserialize.length, a4.q(getArrayKClass(aVar)));
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            return (T) ParcelableArraySerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            return (T) ParcelableListSerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return (T) SparseParcelableArraySerializer.INSTANCE.deserialize((f8.e) savedStateDecoder);
        }
        return null;
    }

    private static final c getArrayKClass(c8.a aVar) {
        Object objDeserialize = aVar.deserialize(EmptyArrayDecoder.INSTANCE);
        objDeserialize.getClass();
        return y.a(objDeserialize.getClass());
    }
}
