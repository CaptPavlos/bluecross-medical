package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.app.Activity;
import android.content.Intent;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.a;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.MBRewardVideoActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ReceiverAction(id = "NewShowReceiver", type = b.class)
/* loaded from: classes3.dex */
public class NewShowReceiver implements b {

    /* renamed from: a, reason: collision with root package name */
    e f4903a;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        e eVar = (e) obj;
        this.f4903a = eVar;
        if (eVar != null) {
            Intent intent = new Intent(c.m().c(), (Class<?>) MBRewardVideoActivity.class);
            intent.putExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, this.f4903a.G());
            if (this.f4903a.D() != null && this.f4903a.D().a() != null && this.f4903a.D().a().size() == 1) {
                e eVar2 = this.f4903a;
                eVar2.a(eVar2.D().a().get(0));
            }
            try {
                this.f4903a.p(a.b(c.m().c()));
            } catch (Throwable th) {
                af.b("NewShowReceiver", th.getMessage());
            }
            try {
                if (c.m() != null && c.m().e() != null) {
                    ((Activity) c.m().e()).startActivity(intent);
                    return;
                }
            } catch (Throwable th2) {
                af.b("NewShowReceiver", th2.getMessage());
            }
            intent.addFlags(268435456);
            c.m().c().startActivity(intent);
        }
    }
}
