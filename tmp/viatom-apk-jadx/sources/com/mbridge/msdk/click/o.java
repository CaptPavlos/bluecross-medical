package com.mbridge.msdk.click;

import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aj;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {
    public static boolean a(String str, CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult) {
        if (campaignEx != null) {
            campaignEx.getLinkType();
        }
        if (!aj.a.b(str)) {
            jumpLoaderResult.setCode(2);
            jumpLoaderResult.setUrl(str);
            return false;
        }
        jumpLoaderResult.setCode(1);
        jumpLoaderResult.setUrl(str);
        jumpLoaderResult.setjumpDone(true);
        return true;
    }
}
