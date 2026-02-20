package com.mbridge.msdk.newreward.player;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import com.mbridge.msdk.newreward.player.presenter.ActivityPresenter;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBRewardVideoActivity extends BaseActivity implements IMetaData {
    Object data;
    ViewGroup viewGroup;

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public Object getDate() {
        return this.data;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public ViewGroup getRootViewGroup() {
        return this.viewGroup;
    }

    @Override // com.mbridge.msdk.newreward.player.BaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(x.a(getApplicationContext(), "mbridge_activity", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.viewGroup = viewGroup;
        setContentView(viewGroup);
        this.activityPresenter = new ActivityPresenter(this, getIntent().getStringExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public void onShowFail(@BridgeParameter(key = "reason") String str, @BridgeParameter(key = "code") int i10) {
        try {
            e eVarA = d.a().a(getIntent().getStringExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            if (eVarA != null && !eVarA.Y()) {
                eVarA.j(true);
                if (eVarA.K() != null) {
                    eVarA.K().onShowFail(eVarA.S(), str);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        finish();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public void setDate(Object obj) {
        this.data = obj;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public void activityReport(String str, com.mbridge.msdk.foundation.same.report.d.e eVar) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMetaData
    public void activityReport(String str) {
    }
}
