package com.mbridge.msdk.newreward.player.redirect;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.f;
import com.mbridge.msdk.videocommon.b.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class RedirectModel {
    private CampaignEx campaignEx;
    public int clickSenario = 0;
    public Context context;
    private int currPercentAge;
    public f devExtraData;
    private int endScreenType;
    private int percentRate;
    public RedirectType redirectType;
    public c reward;
    public com.mbridge.msdk.newreward.function.e.f settingModel;
    public String unitId;
    private int videoSourceCompleteTime;
    public float xInScreen;
    public float yInScreen;

    public CampaignEx getCampaignEx() {
        return this.campaignEx;
    }

    public int getClickSenario() {
        return this.clickSenario;
    }

    public Context getContext() {
        return this.context;
    }

    public int getCurrPercentAge() {
        return this.currPercentAge;
    }

    public f getDevExtraData() {
        return this.devExtraData;
    }

    public int getEndScreenType() {
        return this.endScreenType;
    }

    public int getPercentRate() {
        return this.percentRate;
    }

    public RedirectType getRedirectType() {
        return this.redirectType;
    }

    public c getReward() {
        return this.reward;
    }

    public com.mbridge.msdk.newreward.function.e.f getSettingModel() {
        return this.settingModel;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public int getVideoSourceCompleteTime() {
        return this.videoSourceCompleteTime;
    }

    public int getxInScreen() {
        return ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.xInScreen);
    }

    public int getyInScreen() {
        return ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.yInScreen);
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.campaignEx = campaignEx;
    }

    public void setClickSenario(int i10) {
        this.clickSenario = i10;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setCurrPercentAge(int i10) {
        this.currPercentAge = i10;
    }

    public void setDevExtraData(f fVar) {
        this.devExtraData = fVar;
    }

    public void setEndScreenType(int i10) {
        this.endScreenType = i10;
    }

    public void setPercentRate(int i10) {
        this.percentRate = i10;
    }

    public RedirectModel setRedirectType(RedirectType redirectType) {
        this.redirectType = redirectType;
        return this;
    }

    public void setReward(c cVar) {
        this.reward = cVar;
    }

    public void setSettingModel(com.mbridge.msdk.newreward.function.e.f fVar) {
        this.settingModel = fVar;
        if (fVar == null || fVar.b() == null) {
            return;
        }
        setEndScreenType(fVar.b().q());
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void setVideoSourceCompleteTime(int i10) {
        this.videoSourceCompleteTime = i10;
    }

    public void setxInScreen(float f) {
        this.xInScreen = f;
    }

    public void setyInScreen(float f) {
        this.yInScreen = f;
    }
}
