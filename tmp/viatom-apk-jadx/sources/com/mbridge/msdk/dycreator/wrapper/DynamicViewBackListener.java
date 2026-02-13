package com.mbridge.msdk.dycreator.wrapper;

import android.view.View;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface DynamicViewBackListener {
    void viewClicked(BaseRespData baseRespData);

    void viewCreateFail(a aVar);

    void viewCreatedSuccess(View view);
}
