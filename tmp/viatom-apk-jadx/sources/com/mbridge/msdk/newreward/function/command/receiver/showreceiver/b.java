package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.player.view.Template102;
import com.mbridge.msdk.newreward.player.view.Template202;
import com.mbridge.msdk.newreward.player.view.Template302;
import com.mbridge.msdk.newreward.player.view.Template5002010;
import com.mbridge.msdk.newreward.player.view.Template802;
import com.mbridge.msdk.newreward.player.view.Template902;
import com.mbridge.msdk.newreward.player.view.Template904;
import com.mbridge.msdk.newreward.player.view.bigtemplate.Template201;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC1302;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC404;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC704;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateHalfEC;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateVastEC;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateEndCover;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateHalf;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements com.mbridge.msdk.newreward.function.command.receiver.b {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        Map map = (Map) obj;
        String strValueOf = String.valueOf(map.get("add_temple"));
        ViewGroup viewGroup = (ViewGroup) map.get("parent_temple");
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
        com.mbridge.msdk.newreward.function.command.c cVarB = com.mbridge.msdk.newreward.function.command.d.a().b();
        char c10 = 65535;
        switch (strValueOf.hashCode()) {
            case -1738448503:
                if (strValueOf.equals("WEB_EC")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1623688923:
                if (strValueOf.equals("WEB_TEMPLATE")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1517363552:
                if (strValueOf.equals("HALF_END_CARD")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1207348799:
                if (strValueOf.equals("ONLY_PLAYABLE")) {
                    c10 = 3;
                    break;
                }
                break;
            case -298533114:
                if (strValueOf.equals("HALF_TEMPLATE")) {
                    c10 = 4;
                    break;
                }
                break;
            case 48627:
                if (strValueOf.equals(MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE)) {
                    c10 = 5;
                    break;
                }
                break;
            case 49587:
                if (strValueOf.equals("201")) {
                    c10 = 6;
                    break;
                }
                break;
            case 49588:
                if (strValueOf.equals("202")) {
                    c10 = 7;
                    break;
                }
                break;
            case 50549:
                if (strValueOf.equals("302")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 51512:
                if (strValueOf.equals("404")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 54395:
                if (strValueOf.equals("704")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 55354:
                if (strValueOf.equals("802")) {
                    c10 = 11;
                    break;
                }
                break;
            case 56315:
                if (strValueOf.equals("902")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 56317:
                if (strValueOf.equals("904")) {
                    c10 = '\r';
                    break;
                }
                break;
            case 1510308:
                if (strValueOf.equals("1302")) {
                    c10 = 14;
                    break;
                }
                break;
            case 2627148:
                if (strValueOf.equals("VAST")) {
                    c10 = 15;
                    break;
                }
                break;
            case 563693366:
                if (strValueOf.equals("SHOW_CLICK_URL")) {
                    c10 = 16;
                    break;
                }
                break;
            case 1213120338:
                if (strValueOf.equals("5002010")) {
                    c10 = 17;
                    break;
                }
                break;
            case 1277364343:
                if (strValueOf.equals("HALF_TEMPLATE_EC")) {
                    c10 = 18;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                cVarB.i(cVarB.a("web_resource_action", 2, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", cVarB, "bridge_ids", eVar != null ? eVar.V() : ""), com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC);
                break;
            case 1:
                cVarB.i(cVarB.a("web_resource_action", 2, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", cVarB, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, eVar != null ? eVar.G() : "", "bridge_ids", eVar != null ? eVar.V() : ""), com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_TEMPLATE);
                break;
            case 2:
                new TemplateHalfEC(viewGroup.getContext()).show(viewGroup);
                break;
            case 3:
                cVarB.i(cVarB.a("web_resource_action", 3, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", cVarB, "bridge_ids", eVar != null ? eVar.V() : ""), com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC);
                break;
            case 4:
                new TemplateHalf(viewGroup.getContext()).show(viewGroup);
                break;
            case 5:
                new Template102(viewGroup.getContext()).show(viewGroup);
                break;
            case 6:
                new Template201(viewGroup.getContext()).show(viewGroup);
                break;
            case 7:
                new Template202(viewGroup.getContext()).show(viewGroup);
                break;
            case '\b':
                new Template302(viewGroup.getContext()).show(viewGroup);
                break;
            case '\t':
                new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                break;
            case '\n':
                new TemplateEC704(viewGroup.getContext()).show(viewGroup);
                break;
            case 11:
                new Template802(viewGroup.getContext()).show(viewGroup);
                break;
            case '\f':
                new Template902(viewGroup.getContext()).show(viewGroup);
                break;
            case '\r':
                new Template904(viewGroup.getContext()).show(viewGroup);
                break;
            case 14:
                new TemplateEC1302(viewGroup.getContext()).show(viewGroup);
                break;
            case 15:
                new TemplateVastEC(viewGroup.getContext()).show(viewGroup);
                break;
            case 16:
                cVarB.i(cVarB.a("web_resource_action", 4, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", cVarB, "bridge_ids", eVar != null ? eVar.V() : ""), com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC);
                break;
            case 17:
                new Template5002010(viewGroup.getContext()).show(viewGroup);
                break;
            case 18:
                new TemplateEndCover(viewGroup.getContext()).show(viewGroup);
                break;
            default:
                Object obj2 = map.get("template_type");
                if (obj2 instanceof Integer) {
                    int iIntValue = ((Integer) obj2).intValue();
                    if (iIntValue != 17) {
                        if (iIntValue == 18) {
                            new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                            break;
                        }
                    } else {
                        new Template904(viewGroup.getContext()).show(viewGroup);
                        break;
                    }
                }
                break;
        }
    }
}
