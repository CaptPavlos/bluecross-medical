package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import c8.g;
import e8.e;
import f8.f;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateEncoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder savedStateEncoder, g gVar, T t) {
        savedStateEncoder.getClass();
        gVar.getClass();
        e descriptor = gVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
            t.getClass();
            charSequenceSerializer.serialize((f) savedStateEncoder, (CharSequence) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
            t.getClass();
            defaultParcelableSerializer.serialize((f) savedStateEncoder, (SavedStateEncoder) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.INSTANCE;
            t.getClass();
            defaultJavaSerializableSerializer.serialize((f) savedStateEncoder, (SavedStateEncoder) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.INSTANCE;
            t.getClass();
            iBinderSerializer.serialize((f) savedStateEncoder, (IBinder) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.INSTANCE;
            t.getClass();
            charSequenceArraySerializer.serialize((f) savedStateEncoder, (CharSequence[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.INSTANCE;
            t.getClass();
            charSequenceListSerializer.serialize((f) savedStateEncoder, (List<? extends CharSequence>) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.INSTANCE;
            t.getClass();
            parcelableArraySerializer.serialize((f) savedStateEncoder, (Parcelable[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.INSTANCE;
            t.getClass();
            parcelableListSerializer.serialize((f) savedStateEncoder, (List<? extends Parcelable>) t);
            return true;
        }
        if (!l.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && !l.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return false;
        }
        SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.INSTANCE;
        t.getClass();
        sparseParcelableArraySerializer.serialize((f) savedStateEncoder, (SparseArray<Parcelable>) t);
        return true;
    }
}
