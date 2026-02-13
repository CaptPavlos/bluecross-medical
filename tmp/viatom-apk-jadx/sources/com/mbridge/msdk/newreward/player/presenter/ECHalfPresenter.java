package com.mbridge.msdk.newreward.player.presenter;

import android.content.Context;
import android.widget.FrameLayout;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.video.dynview.a;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ECHalfPresenter extends ECTemplePresenter {
    IECTempleView iCusECTemplateView;

    public ECHalfPresenter(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.iCusECTemplateView = (IECTempleView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{IECTempleView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        c cVarB = new com.mbridge.msdk.video.dynview.j.c().b(this.context, this.campaignEx, -1, b.a() ? "cn_" : "en_");
        this.nLogo = cVarB.n();
        com.mbridge.msdk.video.dynview.b.a().a(cVarB, new h() { // from class: com.mbridge.msdk.newreward.player.presenter.ECHalfPresenter.1
            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterSuccess(a aVar) {
                ECHalfPresenter.this.initDataForView(aVar);
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
            }
        });
    }

    public void setHalfWH() {
        int iE;
        int iF;
        try {
            this.data.getRootViewGroup().setBackgroundColor(-1728053248);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.data.getRootViewGroup().getLayoutParams();
            layoutParams.gravity = 17;
            int iB = this.campaignEx.getRewardTemplateMode() != null ? this.campaignEx.getRewardTemplateMode().b() : x.a(this.context).getConfiguration().orientation;
            Context context = this.context;
            if (iB == 1) {
                iE = (int) (ak.e(context) * 0.55f);
                iF = (int) (ak.f(this.context) * 0.65f);
            } else {
                iE = (int) (ak.e(context) * 0.6f);
                iF = (int) (ak.f(this.context) * 0.6f);
            }
            layoutParams.height = iE;
            layoutParams.width = iF;
            this.data.getRootViewGroup().setLayoutParams(layoutParams);
        } catch (Throwable th) {
            af.b("ECHalfPresenter", th.getMessage());
        }
    }
}
