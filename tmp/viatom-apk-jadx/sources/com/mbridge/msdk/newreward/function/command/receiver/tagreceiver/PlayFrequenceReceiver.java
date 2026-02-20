package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ReceiverAction(id = "PlayFrequenceReceiver", type = b.class)
/* loaded from: classes3.dex */
public class PlayFrequenceReceiver implements b {

    /* renamed from: a, reason: collision with root package name */
    e f4908a;

    /* renamed from: b, reason: collision with root package name */
    CampaignEx f4909b;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            this.f4908a = eVar;
            this.f4909b = eVar.U();
        }
        if (this.f4908a != null) {
            if (this.f4909b != null) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.PlayFrequenceReceiver.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (PlayFrequenceReceiver.this.f4909b != null) {
                                j.a(g.a(c.m().c())).a(PlayFrequenceReceiver.this.f4909b.getId());
                            }
                        } catch (Throwable th) {
                            if (MBridgeConstans.DEBUG) {
                                th.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
            CampaignEx campaignEx = this.f4909b;
            if (campaignEx == null) {
                return;
            }
            try {
                if (com.mbridge.msdk.foundation.same.a.b.f3629j == null || TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.b.a(this.f4909b.getCampaignUnitId(), this.f4909b, "reward");
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
