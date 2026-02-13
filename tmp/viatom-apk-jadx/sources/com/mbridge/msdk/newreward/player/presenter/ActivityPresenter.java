package com.mbridge.msdk.newreward.player.presenter;

import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ActivityPresenter {
    e adapterModel;
    c commandManager;
    d commandManagerGlobal;
    IMetaData mMetaData;

    public ActivityPresenter(IMetaData iMetaData, String str) {
        try {
            this.commandManagerGlobal = d.a();
            this.commandManager = d.a().b();
            this.adapterModel = this.commandManagerGlobal.a(str);
            IMetaData iMetaData2 = (IMetaData) Proxy.newProxyInstance(iMetaData.getClass().getClassLoader(), iMetaData.getClass().getInterfaces(), new com.mbridge.msdk.newreward.function.g.e(iMetaData, this.adapterModel, this.commandManager));
            this.mMetaData = iMetaData2;
            iMetaData2.setDate(this.adapterModel);
            this.mMetaData.activityReport("onCreate");
            this.commandManager.b((a) new com.mbridge.msdk.newreward.function.command.a.c());
            CampaignEx campaignExU = this.adapterModel.U();
            e eVar = this.adapterModel;
            String strAl = this.adapterModel.ak() ? this.adapterModel.al() : campaignExU == null ? String.valueOf(eVar.D().b().C()) : eVar.ai();
            setActivityOrientation(iMetaData);
            addTemplate(strAl, iMetaData.getRootViewGroup());
        } catch (Exception e) {
            IMetaData iMetaData3 = this.mMetaData;
            if (iMetaData3 != null) {
                iMetaData3.onShowFail(com.mbridge.msdk.foundation.c.a.a(890010), 890010);
            }
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void addTemplate(String str, ViewGroup viewGroup) {
        try {
            c cVar = this.commandManager;
            cVar.g(cVar.a("add_temple", str, "adapter_model", this.adapterModel, "template_type", 17, "parent_temple", viewGroup), f.SHOW_ADD_TEMPLE);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r0.equals("302") != false) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setActivityOrientation(com.mbridge.msdk.newreward.player.iview.IMetaData r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L4a
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L29
            com.mbridge.msdk.newreward.a.e r0 = r3.adapterModel     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = r0.ai()     // Catch: java.lang.Throwable -> L29
            int r1 = r0.hashCode()     // Catch: java.lang.Throwable -> L29
            r2 = 50549(0xc575, float:7.0834E-41)
            if (r1 == r2) goto L34
            r2 = 55354(0xd83a, float:7.7567E-41)
            if (r1 == r2) goto L2b
            r2 = 1213120338(0x484ebf52, float:211709.28)
            if (r1 == r2) goto L20
            goto L41
        L20:
            java.lang.String r1 = "5002010"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L41
            goto L3c
        L29:
            r4 = move-exception
            goto L4b
        L2b:
            java.lang.String r1 = "802"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L41
            goto L3c
        L34:
            java.lang.String r1 = "302"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L41
        L3c:
            r0 = 1
            r4.setRequestedOrientation(r0)     // Catch: java.lang.Throwable -> L29
            return
        L41:
            com.mbridge.msdk.newreward.a.e r0 = r3.adapterModel     // Catch: java.lang.Throwable -> L29
            int r0 = r0.am()     // Catch: java.lang.Throwable -> L29
            r4.setRequestedOrientation(r0)     // Catch: java.lang.Throwable -> L29
        L4a:
            return
        L4b:
            java.lang.String r0 = "ActivityPresenter"
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.presenter.ActivityPresenter.setActivityOrientation(com.mbridge.msdk.newreward.player.iview.IMetaData):void");
    }

    public void bindMethodName(String str) {
        try {
            c cVar = this.commandManager;
            ViewGroup rootViewGroup = this.mMetaData.getRootViewGroup();
            e eVar = this.adapterModel;
            cVar.h(cVar.a("life_cycle", str, "parent_temple", rootViewGroup, "is_dy", Boolean.valueOf(eVar != null && eVar.r())), f.SHOW_LIFE_CYCLE);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        if (str.equals("onDestroy") || str.equals("onCreate")) {
            this.mMetaData.activityReport(str);
        }
        if (str.equals("onDestroy")) {
            try {
                e eVar2 = this.adapterModel;
                if (eVar2 != null) {
                    d dVar = this.commandManagerGlobal;
                    if (dVar != null) {
                        dVar.b(eVar2.G());
                    }
                    com.mbridge.msdk.newreward.function.command.receiver.d.a().a(this.adapterModel.G());
                    com.mbridge.msdk.newreward.function.command.receiver.d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
