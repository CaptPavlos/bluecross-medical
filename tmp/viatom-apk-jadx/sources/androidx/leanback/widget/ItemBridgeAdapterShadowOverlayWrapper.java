package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ItemBridgeAdapter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ItemBridgeAdapterShadowOverlayWrapper extends ItemBridgeAdapter.Wrapper {
    private final ShadowOverlayHelper mHelper;

    public ItemBridgeAdapterShadowOverlayWrapper(ShadowOverlayHelper shadowOverlayHelper) {
        this.mHelper = shadowOverlayHelper;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public View createWrapper(View view) {
        return this.mHelper.createShadowOverlayContainer(view.getContext());
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public void wrap(View view, View view2) {
        ((ShadowOverlayContainer) view).wrap(view2);
    }
}
