package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBSplashData implements a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f3195a;

    /* renamed from: b, reason: collision with root package name */
    private String f3196b;

    /* renamed from: c, reason: collision with root package name */
    private String f3197c;

    /* renamed from: d, reason: collision with root package name */
    private String f3198d;
    private String e;
    private CampaignEx f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private float f3199i;

    /* renamed from: j, reason: collision with root package name */
    private float f3200j;

    /* renamed from: k, reason: collision with root package name */
    private int f3201k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f3195a = dyOption;
        this.f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.f3197c;
    }

    public String getAppInfo() {
        return this.f3196b;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public CampaignEx getBindData() {
        return this.f;
    }

    public int getClickType() {
        return this.f3201k;
    }

    public String getCountDownText() {
        return this.f3198d;
    }

    public DyOption getDyOption() {
        return this.f3195a;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public DyOption getEffectData() {
        return this.f3195a;
    }

    public int getLogoImage() {
        return this.h;
    }

    public String getLogoText() {
        return this.e;
    }

    public int getNoticeImage() {
        return this.g;
    }

    public float getxInScreen() {
        return this.f3199i;
    }

    public float getyInScreen() {
        return this.f3200j;
    }

    public void setAdClickText(String str) {
        this.f3197c = str;
    }

    public void setAppInfo(String str) {
        this.f3196b = str;
    }

    public void setClickType(int i10) {
        this.f3201k = i10;
    }

    public void setCountDownText(String str) {
        this.f3198d = str;
    }

    public void setLogoImage(int i10) {
        this.h = i10;
    }

    public void setLogoText(String str) {
        this.e = str;
    }

    public void setNoticeImage(int i10) {
        this.g = i10;
    }

    public void setxInScreen(float f) {
        this.f3199i = f;
    }

    public void setyInScreen(float f) {
        this.f3200j = f;
    }
}
