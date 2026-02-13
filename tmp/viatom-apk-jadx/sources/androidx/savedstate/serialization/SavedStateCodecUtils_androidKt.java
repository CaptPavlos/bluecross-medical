package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import c8.d;
import e8.e;
import g8.c;
import java.io.Serializable;
import kotlin.jvm.internal.y;
import l1.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateCodecUtils_androidKt {
    private static final e charSequenceArrayDescriptor;
    private static final e charSequenceListDescriptor;
    private static final e nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final e parcelableArrayDescriptor;
    private static final e parcelableListDescriptor;
    private static final e polymorphicCharSequenceArrayDescriptor;
    private static final e polymorphicCharSequenceListDescriptor;
    private static final e polymorphicParcelableArrayDescriptor;
    private static final e polymorphicParcelableListDescriptor;
    private static final e polymorphicSparseParcelableArrayDescriptor;
    private static final e sparseParcelableArrayDescriptor;
    private static final e polymorphicCharSequenceDescriptor = new d(y.a(CharSequence.class)).getDescriptor();
    private static final e polymorphicParcelableDescriptor = new d(y.a(Parcelable.class)).getDescriptor();
    private static final e polymorphicJavaSerializableDescriptor = new d(y.a(Serializable.class)).getDescriptor();
    private static final e polymorphicIBinderDescriptor = new d(y.a(IBinder.class)).getDescriptor();

    static {
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
        y.a(Parcelable.class);
        defaultParcelableSerializer.getClass();
        e descriptor = defaultParcelableSerializer.getDescriptor();
        descriptor.getClass();
        parcelableArrayDescriptor = new c(descriptor, 0);
        d dVar = new d(y.a(Parcelable.class));
        y.a(Parcelable.class);
        e descriptor2 = dVar.getDescriptor();
        descriptor2.getClass();
        polymorphicParcelableArrayDescriptor = new c(descriptor2, 0);
        e descriptor3 = defaultParcelableSerializer.getDescriptor();
        descriptor3.getClass();
        parcelableListDescriptor = new c(descriptor3, 1);
        e descriptor4 = new d(y.a(Parcelable.class)).getDescriptor();
        descriptor4.getClass();
        polymorphicParcelableListDescriptor = new c(descriptor4, 1);
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
        y.a(CharSequence.class);
        charSequenceSerializer.getClass();
        e descriptor5 = charSequenceSerializer.getDescriptor();
        descriptor5.getClass();
        charSequenceArrayDescriptor = new c(descriptor5, 0);
        d dVar2 = new d(y.a(CharSequence.class));
        y.a(CharSequence.class);
        e descriptor6 = dVar2.getDescriptor();
        descriptor6.getClass();
        polymorphicCharSequenceArrayDescriptor = new c(descriptor6, 0);
        e descriptor7 = charSequenceSerializer.getDescriptor();
        descriptor7.getClass();
        charSequenceListDescriptor = new c(descriptor7, 1);
        e descriptor8 = new d(y.a(CharSequence.class)).getDescriptor();
        descriptor8.getClass();
        polymorphicCharSequenceListDescriptor = new c(descriptor8, 1);
        sparseParcelableArrayDescriptor = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new d(y.a(Parcelable.class))).getDescriptor();
        nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(b.B(new d(y.a(Parcelable.class)))).getDescriptor();
    }

    public static final e getCharSequenceArrayDescriptor() {
        return charSequenceArrayDescriptor;
    }

    public static final e getCharSequenceListDescriptor() {
        return charSequenceListDescriptor;
    }

    public static final e getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final e getParcelableArrayDescriptor() {
        return parcelableArrayDescriptor;
    }

    public static final e getParcelableListDescriptor() {
        return parcelableListDescriptor;
    }

    public static final e getPolymorphicCharSequenceArrayDescriptor() {
        return polymorphicCharSequenceArrayDescriptor;
    }

    public static final e getPolymorphicCharSequenceDescriptor() {
        return polymorphicCharSequenceDescriptor;
    }

    public static final e getPolymorphicCharSequenceListDescriptor() {
        return polymorphicCharSequenceListDescriptor;
    }

    public static final e getPolymorphicIBinderDescriptor() {
        return polymorphicIBinderDescriptor;
    }

    public static final e getPolymorphicJavaSerializableDescriptor() {
        return polymorphicJavaSerializableDescriptor;
    }

    public static final e getPolymorphicParcelableArrayDescriptor() {
        return polymorphicParcelableArrayDescriptor;
    }

    public static final e getPolymorphicParcelableDescriptor() {
        return polymorphicParcelableDescriptor;
    }

    public static final e getPolymorphicParcelableListDescriptor() {
        return polymorphicParcelableListDescriptor;
    }

    public static final e getPolymorphicSparseParcelableArrayDescriptor() {
        return polymorphicSparseParcelableArrayDescriptor;
    }

    public static final e getSparseParcelableArrayDescriptor() {
        return sparseParcelableArrayDescriptor;
    }

    public static /* synthetic */ void getCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getParcelableArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicParcelableArrayDescriptor$annotations() {
    }
}
