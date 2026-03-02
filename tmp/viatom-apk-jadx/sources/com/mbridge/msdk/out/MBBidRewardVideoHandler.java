package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.video.bt.module.b.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBBidRewardVideoHandler implements BaseExtraInterfaceForHandler {
    private static final String REFACTOR_SWITCH_REWARD_VIDEO = "new_bridge_reward_video";
    private static final String TAG = "MBBidRewardVideoHandler";
    private String cancelText;
    private String confirmContent;
    private String confirmText;
    private String confirmTitle;
    private a controller;
    private d newController;
    private String placementId;
    private String unitId;
    private boolean refactorAvailable = false;
    private g listener = null;
    private int isSilent = 2;
    private boolean isRewardPlusOpen = false;
    private boolean isSetListenerNewController = false;
    private boolean isSetListenerController = false;
    private boolean isConfigAlertDialogTextController = false;
    private boolean isConfigAlertDialogTextNewController = false;

    public MBBidRewardVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.placementId = str;
        this.unitId = str2;
    }

    private void checkAndCreateController() {
        if (this.controller == null) {
            initMBBidRewardVideoHandler(this.placementId, this.unitId);
        }
        configController();
    }

    private void checkAndCreateNewController() {
        if (this.newController == null) {
            initMBNewBidRewardVideoHandler(this.placementId, this.unitId);
        }
        configNewController();
    }

    private void configController() {
        if (this.controller == null) {
            return;
        }
        if (this.isSetListenerController) {
            boolean zA = b.a();
            a aVar = this.controller;
            if (zA) {
                aVar.a(new com.mbridge.msdk.video.bt.module.b.a(this.listener, this.unitId, true));
            } else {
                aVar.a(new com.mbridge.msdk.video.bt.module.b.a(this.listener));
            }
            this.isSetListenerController = false;
        }
        this.controller.c(this.isRewardPlusOpen);
        this.controller.a(this.isSilent);
        if (this.isConfigAlertDialogTextController) {
            this.controller.a(this.confirmTitle, this.confirmContent, this.confirmText, this.cancelText);
            this.isConfigAlertDialogTextController = false;
        }
    }

    private void configNewController() {
        d dVar = this.newController;
        if (dVar == null) {
            return;
        }
        if (this.isSetListenerNewController) {
            dVar.a(new RewardVideoListenerWrapper(this.listener));
            this.isSetListenerNewController = false;
        }
        this.newController.b(this.isRewardPlusOpen);
        this.newController.a(this.isSilent);
        if (this.isConfigAlertDialogTextNewController) {
            MBridgeGlobalCommon.setAlertDialogText(this.unitId, this.confirmTitle, this.confirmContent, this.confirmText, this.cancelText);
            this.isConfigAlertDialogTextNewController = false;
        }
    }

    private void initMBBidRewardVideoHandler(String str, String str2) {
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
                this.controller.b(true);
                this.controller.b(str, str2);
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
    }

    private void initMBNewBidRewardVideoHandler(String str, String str2) {
        if (this.newController == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.newController = new d(94, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (this.refactorAvailable) {
            return;
        }
        try {
            if (this.controller != null) {
                ad.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.controller;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            return dVar != null ? dVar.b() : "";
        }
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFromBid(String str) {
        boolean zA = com.mbridge.msdk.foundation.same.b.a().a(REFACTOR_SWITCH_REWARD_VIDEO);
        this.refactorAvailable = zA;
        if (zA) {
            checkAndCreateNewController();
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        checkAndCreateController();
        if (this.controller != null) {
            this.controller.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 94, this.unitId, true, 2));
        }
    }

    public void playVideoMute(int i10) {
        this.isSilent = i10;
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(i10);
                return;
            }
            return;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.confirmTitle = str;
        this.confirmContent = str2;
        this.confirmText = str3;
        this.cancelText = str4;
        this.isConfigAlertDialogTextController = true;
        this.isConfigAlertDialogTextNewController = true;
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) throws JSONException {
        c.m().a(this.unitId, jSONObject);
    }

    public void setRewardPlus(boolean z9) {
        this.isRewardPlusOpen = z9;
    }

    public void setRewardVideoListener(g gVar) {
        this.listener = gVar;
        this.isSetListenerNewController = true;
        this.isSetListenerController = true;
    }

    public void showFromBid() {
        if (this.refactorAvailable) {
            checkAndCreateNewController();
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        checkAndCreateController();
        if (this.controller != null) {
            this.controller.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 94, this.unitId, false, -1));
        }
    }

    public void showFromBid(String str) {
        if (this.refactorAvailable) {
            checkAndCreateNewController();
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("", str, "");
                return;
            }
            return;
        }
        checkAndCreateController();
        if (this.controller != null) {
            this.controller.a((String) null, str, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 94, this.unitId, false, -1));
        }
    }

    public void showFromBid(String str, String str2) {
        if (this.refactorAvailable) {
            checkAndCreateNewController();
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("", str, str2);
                return;
            }
            return;
        }
        checkAndCreateController();
        if (this.controller != null) {
            this.controller.a((String) null, str, str2, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 94, this.unitId, false, -1));
        }
    }

    public MBBidRewardVideoHandler(String str, String str2) {
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.placementId = str;
        this.unitId = str2;
    }
}
