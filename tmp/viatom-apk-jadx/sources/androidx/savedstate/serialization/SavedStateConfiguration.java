package androidx.savedstate.serialization;

import h0.p;
import j8.d;
import j8.f;
import j8.h;
import kotlin.jvm.internal.g;
import y2.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateConfiguration {
    public static final Companion Companion = new Companion(null);
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final f serializersModule;

    public /* synthetic */ SavedStateConfiguration(f fVar, int i10, boolean z9, int i11, g gVar) {
        this((i11 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : fVar, (i11 & 2) != 0 ? 2 : i10, (i11 & 4) != 0 ? false : z9);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final f getSerializersModule() {
        return this.serializersModule;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private f serializersModule;

        public Builder(SavedStateConfiguration savedStateConfiguration) {
            savedStateConfiguration.getClass();
            this.serializersModule = savedStateConfiguration.getSerializersModule();
            this.encodeDefaults = savedStateConfiguration.getEncodeDefaults();
            this.classDiscriminatorMode = savedStateConfiguration.getClassDiscriminatorMode();
        }

        public final SavedStateConfiguration build$savedstate_release() {
            f fVar = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
            f fVar2 = this.serializersModule;
            d dVar = h.f10036a;
            fVar.getClass();
            fVar2.getClass();
            p pVar = new p();
            fVar.a(pVar);
            fVar2.a(new c(pVar, 19));
            return new SavedStateConfiguration(pVar.a(), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final f getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int i10) {
            this.classDiscriminatorMode = i10;
        }

        public final void setEncodeDefaults(boolean z9) {
            this.encodeDefaults = z9;
        }

        public final void setSerializersModule(f fVar) {
            fVar.getClass();
            this.serializersModule = fVar;
        }

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }
    }

    private SavedStateConfiguration(f fVar, int i10, boolean z9) {
        this.serializersModule = fVar;
        this.classDiscriminatorMode = i10;
        this.encodeDefaults = z9;
    }

    public /* synthetic */ SavedStateConfiguration(f fVar, int i10, boolean z9, g gVar) {
        this(fVar, i10, z9);
    }
}
