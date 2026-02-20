package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import c8.g;
import e8.e;
import e8.i;
import f8.b;
import f8.d;
import j8.f;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateEncoder extends b {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final f serializersModule;

    public SavedStateEncoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.key = "";
        this.serializersModule = savedStateConfiguration.getSerializersModule();
    }

    private final void checkDiscriminatorCollisions(Bundle bundle, String str) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean zM98containsimpl = SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            boolean zA = l.a(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (zM98containsimpl && zA) {
                androidx.core.view.accessibility.a.m("SavedStateEncoder for ", SavedStateReader.m168getStringimpl(SavedStateReader.m97constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), " has property '", str, "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
    }

    private final void encodeBooleanArray(boolean[] zArr) {
        SavedStateWriter.m190putBooleanArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, zArr);
    }

    private final void encodeCharArray(char[] cArr) {
        SavedStateWriter.m192putCharArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, cArr);
    }

    private final void encodeDoubleArray(double[] dArr) {
        SavedStateWriter.m197putDoubleArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, dArr);
    }

    private final void encodeFloatArray(float[] fArr) {
        SavedStateWriter.m199putFloatArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> boolean encodeFormatSpecificTypes(g gVar, T t) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, gVar, t)) {
            return true;
        }
        e descriptor = gVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            t.getClass();
            encodeIntList((List) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            t.getClass();
            encodeStringList((List) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            t.getClass();
            encodeBooleanArray((boolean[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            t.getClass();
            encodeCharArray((char[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            t.getClass();
            encodeDoubleArray((double[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            t.getClass();
            encodeFloatArray((float[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            t.getClass();
            encodeIntArray((int[]) t);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            t.getClass();
            encodeLongArray((long[]) t);
            return true;
        }
        if (!l.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return false;
        }
        t.getClass();
        encodeStringArray((String[]) t);
        return true;
    }

    private final void encodeIntArray(int[] iArr) {
        SavedStateWriter.m201putIntArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, iArr);
    }

    private final void encodeIntList(List<Integer> list) {
        SavedStateWriter.m202putIntListimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, list);
    }

    private final void encodeLongArray(long[] jArr) {
        SavedStateWriter.m205putLongArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, jArr);
    }

    private final void encodeStringArray(String[] strArr) {
        SavedStateWriter.m217putStringArrayimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, strArr);
    }

    private final void encodeStringList(List<String> list) {
        SavedStateWriter.m218putStringListimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, list);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, e eVar, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            if (l.a(eVar.getKind(), i.f7973c) || l.a(eVar.getKind(), i.f)) {
                SavedStateWriter.m216putStringimpl(SavedStateWriter.m183constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, eVar.a());
            }
        }
    }

    @Override // f8.b, f8.f
    public d beginStructure(e eVar) {
        eVar.getClass();
        if (l.a(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, eVar, this.savedState);
            return this;
        }
        s6.i[] iVarArr = new s6.i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((s6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleBundleOf);
        SavedStateWriter.m210putSavedStateimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, bundleBundleOf);
        putClassDiscriminatorIfRequired(this.configuration, eVar, bundleBundleOf);
        return new SavedStateEncoder(bundleBundleOf, this.configuration);
    }

    @Override // f8.b, f8.f
    public void encodeBoolean(boolean z9) {
        SavedStateWriter.m189putBooleanimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, z9);
    }

    @Override // f8.b, f8.f
    public void encodeByte(byte b10) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, b10);
    }

    @Override // f8.b, f8.f
    public void encodeChar(char c10) {
        SavedStateWriter.m191putCharimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, c10);
    }

    @Override // f8.b, f8.f
    public void encodeDouble(double d8) {
        SavedStateWriter.m196putDoubleimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, d8);
    }

    @Override // f8.b
    public boolean encodeElement(e eVar, int i10) {
        eVar.getClass();
        String strF = eVar.f(i10);
        this.key = strF;
        checkDiscriminatorCollisions(this.savedState, strF);
        return true;
    }

    public void encodeEnum(e eVar, int i10) {
        eVar.getClass();
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, i10);
    }

    @Override // f8.b, f8.f
    public void encodeFloat(float f) {
        SavedStateWriter.m198putFloatimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, f);
    }

    @Override // f8.b, f8.f
    public void encodeInt(int i10) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, i10);
    }

    @Override // f8.b, f8.f
    public void encodeLong(long j10) {
        SavedStateWriter.m204putLongimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, j10);
    }

    @Override // f8.f
    public void encodeNull() {
        SavedStateWriter.m206putNullimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key);
    }

    @Override // f8.b, f8.f
    public <T> void encodeSerializableValue(g gVar, T t) {
        gVar.getClass();
        if (encodeFormatSpecificTypes(gVar, t)) {
            return;
        }
        gVar.serialize(this, t);
    }

    @Override // f8.b, f8.f
    public void encodeShort(short s9) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, s9);
    }

    @Override // f8.b, f8.f
    public void encodeString(String str) {
        str.getClass();
        SavedStateWriter.m216putStringimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, str);
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // f8.f
    public f getSerializersModule() {
        return this.serializersModule;
    }

    @Override // f8.b, f8.d
    public boolean shouldEncodeElementDefault(e eVar, int i10) {
        eVar.getClass();
        return this.configuration.getEncodeDefaults();
    }
}
