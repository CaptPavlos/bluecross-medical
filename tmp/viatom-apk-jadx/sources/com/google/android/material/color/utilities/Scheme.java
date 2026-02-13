package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Deprecated
/* loaded from: classes3.dex */
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38) {
        this.primary = i10;
        this.onPrimary = i11;
        this.primaryContainer = i12;
        this.onPrimaryContainer = i13;
        this.secondary = i14;
        this.onSecondary = i15;
        this.secondaryContainer = i16;
        this.onSecondaryContainer = i17;
        this.tertiary = i18;
        this.onTertiary = i19;
        this.tertiaryContainer = i20;
        this.onTertiaryContainer = i21;
        this.error = i22;
        this.onError = i23;
        this.errorContainer = i24;
        this.onErrorContainer = i25;
        this.background = i26;
        this.onBackground = i27;
        this.surface = i28;
        this.onSurface = i29;
        this.surfaceVariant = i30;
        this.onSurfaceVariant = i31;
        this.outline = i32;
        this.outlineVariant = i33;
        this.shadow = i34;
        this.scrim = i35;
        this.inverseSurface = i36;
        this.inverseOnSurface = i37;
        this.inversePrimary = i38;
    }

    public static Scheme dark(int i10) {
        return darkFromCorePalette(CorePalette.of(i10));
    }

    public static Scheme darkContent(int i10) {
        return darkFromCorePalette(CorePalette.contentOf(i10));
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f2318a1.tone(80)).withOnPrimary(corePalette.f2318a1.tone(20)).withPrimaryContainer(corePalette.f2318a1.tone(30)).withOnPrimaryContainer(corePalette.f2318a1.tone(90)).withSecondary(corePalette.f2319a2.tone(80)).withOnSecondary(corePalette.f2319a2.tone(20)).withSecondaryContainer(corePalette.f2319a2.tone(30)).withOnSecondaryContainer(corePalette.f2319a2.tone(90)).withTertiary(corePalette.f2320a3.tone(80)).withOnTertiary(corePalette.f2320a3.tone(20)).withTertiaryContainer(corePalette.f2320a3.tone(30)).withOnTertiaryContainer(corePalette.f2320a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.f2321n1.tone(10)).withOnBackground(corePalette.f2321n1.tone(90)).withSurface(corePalette.f2321n1.tone(10)).withOnSurface(corePalette.f2321n1.tone(90)).withSurfaceVariant(corePalette.f2322n2.tone(30)).withOnSurfaceVariant(corePalette.f2322n2.tone(80)).withOutline(corePalette.f2322n2.tone(60)).withOutlineVariant(corePalette.f2322n2.tone(30)).withShadow(corePalette.f2321n1.tone(0)).withScrim(corePalette.f2321n1.tone(0)).withInverseSurface(corePalette.f2321n1.tone(90)).withInverseOnSurface(corePalette.f2321n1.tone(20)).withInversePrimary(corePalette.f2318a1.tone(40));
    }

    public static Scheme light(int i10) {
        return lightFromCorePalette(CorePalette.of(i10));
    }

    public static Scheme lightContent(int i10) {
        return lightFromCorePalette(CorePalette.contentOf(i10));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f2318a1.tone(40)).withOnPrimary(corePalette.f2318a1.tone(100)).withPrimaryContainer(corePalette.f2318a1.tone(90)).withOnPrimaryContainer(corePalette.f2318a1.tone(10)).withSecondary(corePalette.f2319a2.tone(40)).withOnSecondary(corePalette.f2319a2.tone(100)).withSecondaryContainer(corePalette.f2319a2.tone(90)).withOnSecondaryContainer(corePalette.f2319a2.tone(10)).withTertiary(corePalette.f2320a3.tone(40)).withOnTertiary(corePalette.f2320a3.tone(100)).withTertiaryContainer(corePalette.f2320a3.tone(90)).withOnTertiaryContainer(corePalette.f2320a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.f2321n1.tone(99)).withOnBackground(corePalette.f2321n1.tone(10)).withSurface(corePalette.f2321n1.tone(99)).withOnSurface(corePalette.f2321n1.tone(10)).withSurfaceVariant(corePalette.f2322n2.tone(90)).withOnSurfaceVariant(corePalette.f2322n2.tone(30)).withOutline(corePalette.f2322n2.tone(50)).withOutlineVariant(corePalette.f2322n2.tone(80)).withShadow(corePalette.f2321n1.tone(0)).withScrim(corePalette.f2321n1.tone(0)).withInverseSurface(corePalette.f2321n1.tone(20)).withInverseOnSurface(corePalette.f2321n1.tone(95)).withInversePrimary(corePalette.f2318a1.tone(80));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary;
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((System.identityHashCode(this) * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }

    public void setBackground(int i10) {
        this.background = i10;
    }

    public void setError(int i10) {
        this.error = i10;
    }

    public void setErrorContainer(int i10) {
        this.errorContainer = i10;
    }

    public void setInverseOnSurface(int i10) {
        this.inverseOnSurface = i10;
    }

    public void setInversePrimary(int i10) {
        this.inversePrimary = i10;
    }

    public void setInverseSurface(int i10) {
        this.inverseSurface = i10;
    }

    public void setOnBackground(int i10) {
        this.onBackground = i10;
    }

    public void setOnError(int i10) {
        this.onError = i10;
    }

    public void setOnErrorContainer(int i10) {
        this.onErrorContainer = i10;
    }

    public void setOnPrimary(int i10) {
        this.onPrimary = i10;
    }

    public void setOnPrimaryContainer(int i10) {
        this.onPrimaryContainer = i10;
    }

    public void setOnSecondary(int i10) {
        this.onSecondary = i10;
    }

    public void setOnSecondaryContainer(int i10) {
        this.onSecondaryContainer = i10;
    }

    public void setOnSurface(int i10) {
        this.onSurface = i10;
    }

    public void setOnSurfaceVariant(int i10) {
        this.onSurfaceVariant = i10;
    }

    public void setOnTertiary(int i10) {
        this.onTertiary = i10;
    }

    public void setOnTertiaryContainer(int i10) {
        this.onTertiaryContainer = i10;
    }

    public void setOutline(int i10) {
        this.outline = i10;
    }

    public void setOutlineVariant(int i10) {
        this.outlineVariant = i10;
    }

    public void setPrimary(int i10) {
        this.primary = i10;
    }

    public void setPrimaryContainer(int i10) {
        this.primaryContainer = i10;
    }

    public void setScrim(int i10) {
        this.scrim = i10;
    }

    public void setSecondary(int i10) {
        this.secondary = i10;
    }

    public void setSecondaryContainer(int i10) {
        this.secondaryContainer = i10;
    }

    public void setShadow(int i10) {
        this.shadow = i10;
    }

    public void setSurface(int i10) {
        this.surface = i10;
    }

    public void setSurfaceVariant(int i10) {
        this.surfaceVariant = i10;
    }

    public void setTertiary(int i10) {
        this.tertiary = i10;
    }

    public void setTertiaryContainer(int i10) {
        this.tertiaryContainer = i10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Scheme{primary=");
        sb.append(this.primary);
        sb.append(", onPrimary=");
        sb.append(this.onPrimary);
        sb.append(", primaryContainer=");
        sb.append(this.primaryContainer);
        sb.append(", onPrimaryContainer=");
        sb.append(this.onPrimaryContainer);
        sb.append(", secondary=");
        sb.append(this.secondary);
        sb.append(", onSecondary=");
        sb.append(this.onSecondary);
        sb.append(", secondaryContainer=");
        sb.append(this.secondaryContainer);
        sb.append(", onSecondaryContainer=");
        sb.append(this.onSecondaryContainer);
        sb.append(", tertiary=");
        sb.append(this.tertiary);
        sb.append(", onTertiary=");
        sb.append(this.onTertiary);
        sb.append(", tertiaryContainer=");
        sb.append(this.tertiaryContainer);
        sb.append(", onTertiaryContainer=");
        sb.append(this.onTertiaryContainer);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", onError=");
        sb.append(this.onError);
        sb.append(", errorContainer=");
        sb.append(this.errorContainer);
        sb.append(", onErrorContainer=");
        sb.append(this.onErrorContainer);
        sb.append(", background=");
        sb.append(this.background);
        sb.append(", onBackground=");
        sb.append(this.onBackground);
        sb.append(", surface=");
        sb.append(this.surface);
        sb.append(", onSurface=");
        sb.append(this.onSurface);
        sb.append(", surfaceVariant=");
        sb.append(this.surfaceVariant);
        sb.append(", onSurfaceVariant=");
        sb.append(this.onSurfaceVariant);
        sb.append(", outline=");
        sb.append(this.outline);
        sb.append(", outlineVariant=");
        sb.append(this.outlineVariant);
        sb.append(", shadow=");
        sb.append(this.shadow);
        sb.append(", scrim=");
        sb.append(this.scrim);
        sb.append(", inverseSurface=");
        sb.append(this.inverseSurface);
        sb.append(", inverseOnSurface=");
        sb.append(this.inverseOnSurface);
        sb.append(", inversePrimary=");
        return a3.a.k(sb, this.inversePrimary, '}');
    }

    public Scheme withBackground(int i10) {
        this.background = i10;
        return this;
    }

    public Scheme withError(int i10) {
        this.error = i10;
        return this;
    }

    public Scheme withErrorContainer(int i10) {
        this.errorContainer = i10;
        return this;
    }

    public Scheme withInverseOnSurface(int i10) {
        this.inverseOnSurface = i10;
        return this;
    }

    public Scheme withInversePrimary(int i10) {
        this.inversePrimary = i10;
        return this;
    }

    public Scheme withInverseSurface(int i10) {
        this.inverseSurface = i10;
        return this;
    }

    public Scheme withOnBackground(int i10) {
        this.onBackground = i10;
        return this;
    }

    public Scheme withOnError(int i10) {
        this.onError = i10;
        return this;
    }

    public Scheme withOnErrorContainer(int i10) {
        this.onErrorContainer = i10;
        return this;
    }

    public Scheme withOnPrimary(int i10) {
        this.onPrimary = i10;
        return this;
    }

    public Scheme withOnPrimaryContainer(int i10) {
        this.onPrimaryContainer = i10;
        return this;
    }

    public Scheme withOnSecondary(int i10) {
        this.onSecondary = i10;
        return this;
    }

    public Scheme withOnSecondaryContainer(int i10) {
        this.onSecondaryContainer = i10;
        return this;
    }

    public Scheme withOnSurface(int i10) {
        this.onSurface = i10;
        return this;
    }

    public Scheme withOnSurfaceVariant(int i10) {
        this.onSurfaceVariant = i10;
        return this;
    }

    public Scheme withOnTertiary(int i10) {
        this.onTertiary = i10;
        return this;
    }

    public Scheme withOnTertiaryContainer(int i10) {
        this.onTertiaryContainer = i10;
        return this;
    }

    public Scheme withOutline(int i10) {
        this.outline = i10;
        return this;
    }

    public Scheme withOutlineVariant(int i10) {
        this.outlineVariant = i10;
        return this;
    }

    public Scheme withPrimary(int i10) {
        this.primary = i10;
        return this;
    }

    public Scheme withPrimaryContainer(int i10) {
        this.primaryContainer = i10;
        return this;
    }

    public Scheme withScrim(int i10) {
        this.scrim = i10;
        return this;
    }

    public Scheme withSecondary(int i10) {
        this.secondary = i10;
        return this;
    }

    public Scheme withSecondaryContainer(int i10) {
        this.secondaryContainer = i10;
        return this;
    }

    public Scheme withShadow(int i10) {
        this.shadow = i10;
        return this;
    }

    public Scheme withSurface(int i10) {
        this.surface = i10;
        return this;
    }

    public Scheme withSurfaceVariant(int i10) {
        this.surfaceVariant = i10;
        return this;
    }

    public Scheme withTertiary(int i10) {
        this.tertiary = i10;
        return this;
    }

    public Scheme withTertiaryContainer(int i10) {
        this.tertiaryContainer = i10;
        return this;
    }

    public Scheme() {
    }
}
