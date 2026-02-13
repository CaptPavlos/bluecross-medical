package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import e8.e;
import e8.i;
import f8.c;
import j8.f;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateDecoder extends f8.a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final f serializersModule;

    public SavedStateDecoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.key = "";
        this.serializersModule = savedStateConfiguration.getSerializersModule();
    }

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m107getBooleanArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m111getCharArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m121getDoubleArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder savedStateDecoder, e eVar, int i10) {
        return SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.savedState), eVar.f(i10));
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m125getFloatArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T decodeFormatSpecificTypes(c8.a aVar) {
        T t = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, aVar);
        if (t != null) {
            return t;
        }
        e descriptor = aVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            return (T) decodeIntList();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            return (T) decodeStringList();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            return (T) decodeBooleanArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            return (T) decodeCharArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            return (T) decodeDoubleArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            return (T) decodeFloatArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            return (T) decodeIntArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            return (T) decodeLongArray();
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return (T) decodeStringArray();
        }
        return null;
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m129getIntArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m131getIntListimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m139getLongArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m169getStringArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m171getStringListimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public c beginStructure(e eVar) {
        eVar.getClass();
        return l.a(this.key, "") ? this : new SavedStateDecoder(SavedStateReader.m154getSavedStateimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // f8.a, f8.e
    public boolean decodeBoolean() {
        return SavedStateReader.m106getBooleanimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public byte decodeByte() {
        return (byte) SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public char decodeChar() {
        return SavedStateReader.m110getCharimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public double decodeDouble() {
        return SavedStateReader.m120getDoubleimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.c
    public int decodeElementIndex(e eVar) {
        eVar.getClass();
        int iM177sizeimpl = (l.a(eVar.getKind(), i.f7974d) || l.a(eVar.getKind(), i.e)) ? SavedStateReader.m177sizeimpl(SavedStateReader.m97constructorimpl(this.savedState)) : eVar.e();
        while (true) {
            int i10 = this.index;
            if (i10 >= iM177sizeimpl || !eVar.i(i10) || decodeElementIndex$presentInEncoding(this, eVar, this.index)) {
                break;
            }
            this.index++;
        }
        int i11 = this.index;
        if (i11 >= iM177sizeimpl) {
            return -1;
        }
        this.key = eVar.f(i11);
        int i12 = this.index;
        this.index = i12 + 1;
        return i12;
    }

    @Override // f8.a
    public int decodeEnum(e eVar) {
        eVar.getClass();
        return SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public float decodeFloat() {
        return SavedStateReader.m124getFloatimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public int decodeInt() {
        return SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public long decodeLong() {
        return SavedStateReader.m138getLongimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m176isNullimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public <T> T decodeSerializableValue(c8.a aVar) {
        aVar.getClass();
        T t = (T) decodeFormatSpecificTypes(aVar);
        return t == null ? (T) super.decodeSerializableValue(aVar) : t;
    }

    @Override // f8.a, f8.e
    public short decodeShort() {
        return (short) SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // f8.a, f8.e
    public String decodeString() {
        return SavedStateReader.m168getStringimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // f8.c
    public f getSerializersModule() {
        return this.serializersModule;
    }
}
