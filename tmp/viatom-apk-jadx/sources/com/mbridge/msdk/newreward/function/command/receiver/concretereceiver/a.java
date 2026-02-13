package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements com.mbridge.msdk.newreward.function.command.receiver.e {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.b.a f4833a;

    public final Object a(Object obj) {
        if (obj != null) {
            Map map = (Map) obj;
            com.mbridge.msdk.foundation.c.b bVar = map.get("reason") != null ? (com.mbridge.msdk.foundation.c.b) map.get("reason") : null;
            com.mbridge.msdk.newreward.a.e eVar = map.get("adapter_model") != null ? (com.mbridge.msdk.newreward.a.e) map.get("adapter_model") : null;
            com.mbridge.msdk.newreward.function.command.c cVar = map.get("command_manager") != null ? (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager") : null;
            if (eVar != null && cVar != null) {
                int iIntValue = map.get("candidate_type") != null ? ((Integer) map.get("candidate_type")).intValue() : 0;
                if (this.f4833a == null) {
                    this.f4833a = new com.mbridge.msdk.newreward.function.b.a(eVar.H(), eVar.h() == 287, cVar);
                }
                com.mbridge.msdk.foundation.same.report.d.c cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar2.c(eVar.G());
                if (iIntValue == 0) {
                    String strJ = eVar.J();
                    if (!TextUtils.isEmpty(strJ)) {
                        try {
                            com.mbridge.msdk.newreward.function.a.b bVarA = this.f4833a.a(cVar2, bVar, eVar, 1);
                            this.f4833a.a(cVar2, strJ, bVarA, null, null, eVar, 3);
                            return bVarA;
                        } catch (Exception e) {
                            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("load error"), "CandidateReceiver");
                            return null;
                        }
                    }
                } else {
                    if (iIntValue == 1) {
                        String strJ2 = eVar.J();
                        if (TextUtils.isEmpty(strJ2)) {
                            return Boolean.FALSE;
                        }
                        try {
                            return Boolean.valueOf(this.f4833a.a(strJ2));
                        } catch (Exception e3) {
                            androidx.constraintlayout.core.widgets.analyzer.a.D(e3, new StringBuilder("loadCallBack error"), "CandidateReceiver");
                            return Boolean.FALSE;
                        }
                    }
                    if (iIntValue == 2) {
                        String strJ3 = eVar.J();
                        if (!TextUtils.isEmpty(strJ3)) {
                            try {
                                com.mbridge.msdk.newreward.function.a.b bVarA2 = this.f4833a.a(cVar2, bVar, eVar, 2);
                                com.mbridge.msdk.newreward.function.b.a aVar = this.f4833a;
                                if (aVar == null) {
                                    return bVarA2;
                                }
                                aVar.a(cVar2, strJ3, bVarA2, null, null, eVar, 1);
                                return bVarA2;
                            } catch (Exception e7) {
                                androidx.constraintlayout.core.widgets.analyzer.a.D(e7, new StringBuilder("loadCallBack error"), "CandidateReceiver");
                                return null;
                            }
                        }
                    } else if (!TextUtils.isEmpty(eVar.J())) {
                        try {
                            return this.f4833a.a(cVar2, bVar, eVar, 2);
                        } catch (Exception e10) {
                            androidx.constraintlayout.core.widgets.analyzer.a.D(e10, new StringBuilder("load error"), "CandidateReceiver");
                        }
                    }
                }
            }
        }
        return null;
    }
}
