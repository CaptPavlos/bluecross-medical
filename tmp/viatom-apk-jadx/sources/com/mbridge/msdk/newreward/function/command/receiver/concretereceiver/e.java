package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f4857a;

    /* renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.c f4858b;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) throws MBridgeError {
        com.mbridge.msdk.newreward.function.e.f fVarX;
        com.mbridge.msdk.videocommon.d.c cVarB;
        Queue<Integer> queueB;
        Integer numPoll;
        try {
            Map map = (Map) bVar.b();
            this.f4857a = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            this.f4858b = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            try {
                Map<String, Long> map2 = com.mbridge.msdk.foundation.same.a.b.f3630k;
                if (map2 != null && map2.size() > 0) {
                    com.mbridge.msdk.foundation.same.a.b.f3630k.clear();
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(this.f4857a.H());
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f4857a;
                if (eVar.A() == 2 && TextUtils.isEmpty(eVar.J())) {
                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880035, "errorCode: 3507 errorMessage: data load failed, errorMsg is bidToken null");
                    throw new MBridgeError(bVarB.a(), bVarB.b());
                }
                if (com.mbridge.msdk.system.a.map == null) {
                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is not init sdk");
                    throw new MBridgeError(bVarB2.a(), bVarB2.b());
                }
                if (((MBridgeDailyPlayModel) this.f4858b.a(new HashMap(), com.mbridge.msdk.newreward.function.command.f.CREATE_DAILY)).isOverDailyCap()) {
                    bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880019));
                    return;
                }
                com.mbridge.msdk.newreward.a.e eVar2 = this.f4857a;
                eVar2.f((eVar2 == null || (fVarX = eVar2.x()) == null || (cVarB = fVarX.b()) == null || (queueB = cVarB.B()) == null || queueB.size() == 0 || (numPoll = queueB.poll()) == null) ? 25000 : numPoll.intValue() * 1000);
                bVar2.reqSuccessful(null);
            } catch (MBridgeError e7) {
                bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(e7.getErrorCode(), e7.getErrorMessage()));
            }
        } catch (Exception e10) {
            bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e10.getMessage()));
        }
    }
}
