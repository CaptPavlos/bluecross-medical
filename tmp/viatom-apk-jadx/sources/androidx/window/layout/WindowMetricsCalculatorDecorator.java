package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
@RestrictTo({RestrictTo.Scope.TESTS})
/* loaded from: classes.dex */
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    WindowMetricsCalculator decorate(WindowMetricsCalculator windowMetricsCalculator);
}
