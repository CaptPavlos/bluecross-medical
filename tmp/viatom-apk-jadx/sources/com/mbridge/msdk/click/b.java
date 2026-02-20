package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static void a(Context context, String str, CampaignEx campaignEx, String str2, int i10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a.a(context, campaignEx, str, str2, true, false, com.mbridge.msdk.click.a.a.f2768i);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, JumpLoaderResult jumpLoaderResult, Boolean bool, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        aj.a(context, jumpLoaderResult.getUrl(), nativeTrackingListener, campaignEx, list);
    }
}
