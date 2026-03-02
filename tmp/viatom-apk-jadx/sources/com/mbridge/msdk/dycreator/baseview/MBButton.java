package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBButton extends Button implements InterBase {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f2928a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Boolean> f2929b;

    /* renamed from: c, reason: collision with root package name */
    private String f2930c;

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        this.f2930c = "";
        this.f2928a = c.a(context, attributeSet);
        com.mbridge.msdk.dycreator.e.a.a(this, attributeSet);
        c.a(this.f2928a, this);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f2928a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f2928a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f2928a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f2928a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f2928a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f2928a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f2928a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f2928a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f2928a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f2928a.get("mbridgeStrategy");
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f2929b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f2929b.get("mbridgeAttached").booleanValue()) {
            a.i("mbridgeAttached").a(this.f2930c);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f2929b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f2929b.get("mbridgeDetached").booleanValue()) {
            a.i("mbridgeDetached").a(this.f2930c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f2929b = c.a(str);
        if (campaignEx != null) {
            this.f2930c = campaignEx.getCampaignUnitId();
        }
    }

    public MBButton(Context context) {
        super(context);
        this.f2930c = "";
    }

    public MBButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2930c = "";
    }
}
