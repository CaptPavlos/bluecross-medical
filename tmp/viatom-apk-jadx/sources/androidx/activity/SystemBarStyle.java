package androidx.activity;

import androidx.annotation.ColorInt;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    private SystemBarStyle(int i10, int i11, int i12, l lVar) {
        this.lightScrim = i10;
        this.darkScrim = i11;
        this.nightMode = i12;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
        return Companion.auto(i10, i11);
    }

    public static final SystemBarStyle dark(@ColorInt int i10) {
        return Companion.dark(i10);
    }

    public static final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
        return Companion.light(i10, i11);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z9) {
        return z9 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z9) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z9 ? this.darkScrim : this.lightScrim;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i10, int i11, l lVar, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i10, i11, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, l lVar) {
            lVar.getClass();
            return new SystemBarStyle(i10, i11, 0, lVar, null);
        }

        public final SystemBarStyle dark(@ColorInt int i10) {
            return new SystemBarStyle(i10, i10, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        public final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
            return new SystemBarStyle(i10, i11, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
            return auto$default(this, i10, i11, null, 4, null);
        }
    }

    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, l lVar) {
        return Companion.auto(i10, i11, lVar);
    }

    public /* synthetic */ SystemBarStyle(int i10, int i11, int i12, l lVar, kotlin.jvm.internal.g gVar) {
        this(i10, i11, i12, lVar);
    }
}
