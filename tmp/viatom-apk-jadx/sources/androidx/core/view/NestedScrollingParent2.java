package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12);

    void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10, int i11);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10, int i11);

    void onStopNestedScroll(@NonNull View view, int i10);
}
