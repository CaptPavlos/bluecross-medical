package androidx.work;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String str);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(String str) {
        str.getClass();
        InputMerger inputMergerCreateInputMerger = createInputMerger(str);
        return inputMergerCreateInputMerger == null ? InputMergerKt.fromClassName(str) : inputMergerCreateInputMerger;
    }
}
