package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.imodel.IModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseModel implements IModel {
    protected c commandManager;

    public BaseModel(c cVar) {
        this.commandManager = cVar;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IModel
    public boolean eventClickUrl(RedirectModel redirectModel) {
        if (this.commandManager == null) {
            return false;
        }
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.CLICK_URL));
        return true;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IModel
    public void eventNoticeUrl(RedirectModel redirectModel, int i10) {
        if (this.commandManager != null) {
            redirectModel.setRedirectType(RedirectType.NOTICE_URL);
            c cVar = this.commandManager;
            cVar.f(cVar.a("campaign_redirect", redirectModel, "click_scenario", Integer.valueOf(i10)), f.CAMPAIGN_REDIRECT);
        }
    }

    public void sendDirectEvent(RedirectModel redirectModel) {
        c cVar = this.commandManager;
        cVar.f(cVar.a("campaign_redirect", redirectModel), f.CAMPAIGN_REDIRECT);
    }
}
