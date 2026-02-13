package androidx.core.view;

import android.view.ViewParent;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends kotlin.jvm.internal.k implements g7.l {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // g7.l
    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
