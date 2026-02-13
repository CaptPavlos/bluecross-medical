package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2337a;

    public /* synthetic */ e(int i10) {
        this.f2337a = i10;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i10 = this.f2337a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2337a) {
            case 0:
                return dynamicScheme.neutralPalette;
            case 1:
                return MaterialDynamicColors.lambda$surfaceContainerLow$24(dynamicScheme);
            case 2:
                return dynamicScheme.secondaryPalette;
            case 3:
                return dynamicScheme.neutralPalette;
            case 4:
                return dynamicScheme.tertiaryPalette;
            case 5:
                return MaterialDynamicColors.lambda$onTertiaryFixed$138(dynamicScheme);
            case 6:
                return dynamicScheme.tertiaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5(dynamicScheme);
            case 8:
                return dynamicScheme.neutralPalette;
            case 9:
                return MaterialDynamicColors.lambda$controlHighlight$150(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$controlHighlight$151(dynamicScheme);
            case 11:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159(dynamicScheme);
            case 12:
                return dynamicScheme.primaryPalette;
            case 13:
                return dynamicScheme.neutralPalette;
            case 14:
                return MaterialDynamicColors.lambda$background$11(dynamicScheme);
            case 15:
                return dynamicScheme.neutralPalette;
            case 16:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28(dynamicScheme);
            case 17:
                return dynamicScheme.neutralPalette;
            case 18:
                return MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
            case 19:
                return dynamicScheme.tertiaryPalette;
            case 20:
                return dynamicScheme.neutralVariantPalette;
            case 21:
                return MaterialDynamicColors.lambda$outlineVariant$45(dynamicScheme);
            case 22:
                return dynamicScheme.neutralPalette;
            case 23:
                return MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
            case 24:
                return dynamicScheme.primaryPalette;
            case 25:
                return MaterialDynamicColors.lambda$onPrimary$56(dynamicScheme);
            case 26:
                return dynamicScheme.primaryPalette;
            case 27:
                return MaterialDynamicColors.lambda$inversePrimary$65(dynamicScheme);
            case 28:
                return MaterialDynamicColors.lambda$onTertiary$83(dynamicScheme);
            default:
                return dynamicScheme.secondaryPalette;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i10 = this.f2337a;
        return Function$CC.$default$compose(this, function);
    }
}
