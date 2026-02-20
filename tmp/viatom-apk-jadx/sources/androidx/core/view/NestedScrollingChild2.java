package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i10, int i11, @Nullable int[] iArr, @Nullable int[] iArr2, int i12);

    boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14);

    boolean hasNestedScrollingParent(int i10);

    boolean startNestedScroll(int i10, int i11);

    void stopNestedScroll(int i10);
}
