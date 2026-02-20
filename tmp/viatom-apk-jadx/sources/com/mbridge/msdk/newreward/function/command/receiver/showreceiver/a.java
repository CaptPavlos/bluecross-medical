package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.KeyEvent;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements com.mbridge.msdk.newreward.function.command.receiver.b {
    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        try {
            Map map = (Map) obj;
            String str = (String) map.get("life_cycle");
            ViewGroup viewGroup = map.get("parent_temple") instanceof ViewGroup ? (ViewGroup) map.get("parent_temple") : null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    KeyEvent.Callback childAt = viewGroup.getChildAt(i10);
                    if (childAt instanceof IBaseView) {
                        ((IBaseView) childAt).onActivityLifeCycleCallback(str);
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
