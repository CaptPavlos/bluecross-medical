package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusECTemplateView;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ECPresenter704 extends ECTemplePresenter {
    ICusECTemplateView iCusECTemplateView;

    public ECPresenter704(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.iCusECTemplateView = (ICusECTemplateView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{ICusECTemplateView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
    }

    public void addMoreOfferView(ViewGroup viewGroup) {
        try {
            if (Integer.parseInt(aq.a(this.campaignEx.getendcard_url(), "mof")) == 1) {
                c cVar = this.commandManager;
                cVar.d(cVar.a("add_temple", 295, "parent_temple", viewGroup, "more_offer_type", 2, "command_type", f.SHOW_ADD_TEMPLE), new b() { // from class: com.mbridge.msdk.newreward.player.presenter.ECPresenter704.1
                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public void reqSuccessful(Object obj) {
                        try {
                            if (obj instanceof View) {
                                ((View) obj).setVisibility(0);
                                new com.mbridge.msdk.video.dynview.h.b().a((View) obj, 0, ak.f(com.mbridge.msdk.foundation.controller.c.m().c()), 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), 500L);
                            }
                            ICusECTemplateView iCusECTemplateView = ECPresenter704.this.iCusECTemplateView;
                            if (iCusECTemplateView != null) {
                                iCusECTemplateView.reSetEndCardWidthAndHeight(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f));
                            }
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
