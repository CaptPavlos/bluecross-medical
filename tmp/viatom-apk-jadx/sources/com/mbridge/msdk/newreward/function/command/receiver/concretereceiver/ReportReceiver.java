package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ReceiverAction(id = "ReportReceiver", type = com.mbridge.msdk.newreward.function.command.receiver.b.class)
/* loaded from: classes3.dex */
public class ReportReceiver implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4830a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.b.b f4831b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4832a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4832a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ReportReceiver(Object obj) {
        if (obj instanceof com.mbridge.msdk.newreward.a.e) {
            this.f4830a = (com.mbridge.msdk.newreward.a.e) obj;
        }
        if (obj instanceof com.mbridge.msdk.newreward.b.b) {
            this.f4831b = (com.mbridge.msdk.newreward.b.b) obj;
        }
    }

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        String str;
        com.mbridge.msdk.newreward.a.e eVar;
        str = "";
        if (!(obj instanceof com.mbridge.msdk.newreward.function.command.b)) {
            if (obj instanceof Map) {
                try {
                    Map map = (Map) obj;
                    if (map.get("adapter_model") instanceof com.mbridge.msdk.newreward.a.e) {
                        this.f4830a = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
                    }
                    Map<String, String> map2 = map.get("metrics_data") instanceof Map ? (Map) map.get("metrics_data") : null;
                    str = map.get("metrics_report_key") instanceof String ? (String) map.get("metrics_report_key") : "";
                    if (TextUtils.isEmpty(str) || (eVar = this.f4830a) == null) {
                        return;
                    }
                    eVar.z().a(this.f4830a, map2, str);
                    return;
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        com.mbridge.msdk.newreward.function.command.b bVar = (com.mbridge.msdk.newreward.function.command.b) obj;
        try {
            Map map3 = bVar.b() instanceof Map ? (Map) bVar.b() : null;
            com.mbridge.msdk.newreward.a.e eVar2 = this.f4830a;
            if (eVar2 == null || eVar2.z() == null) {
                if (this.f4831b != null) {
                    com.mbridge.msdk.newreward.function.e.c cVar = new com.mbridge.msdk.newreward.function.e.c();
                    com.mbridge.msdk.newreward.b.b bVar2 = this.f4831b;
                    if (map3 == null) {
                        map3 = new HashMap();
                    }
                    cVar.a(bVar2, map3, bVar.a());
                    return;
                }
                return;
            }
            int i10 = AnonymousClass1.f4832a[bVar.a().ordinal()];
            com.mbridge.msdk.newreward.a.e eVar3 = this.f4830a;
            if (i10 != 1) {
                com.mbridge.msdk.newreward.function.e.c cVarZ = eVar3.z();
                com.mbridge.msdk.newreward.a.e eVar4 = this.f4830a;
                if (map3 == null) {
                    map3 = new HashMap();
                }
                cVarZ.a(eVar4, map3, bVar.a());
                return;
            }
            eVar3.z();
            com.mbridge.msdk.newreward.a.e eVar5 = this.f4830a;
            if (eVar5 == null) {
                return;
            }
            try {
                if (eVar5.D() != null && eVar5.D().b() != null) {
                    str = eVar5.D().b().a() + "";
                }
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(eVar5.G(), str);
                if (cVarA == null) {
                    cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
                    cVarA.c(eVar5.G());
                    cVarA.b(eVar5.h());
                    com.mbridge.msdk.foundation.same.report.d.d.a().b().put(eVar5.G() + str, cVarA);
                }
                cVarA.d(eVar5.H());
                cVarA.e(eVar5.J());
                cVarA.i(eVar5.R() ? "1" : "0");
                com.mbridge.msdk.videocommon.d.a aVarA = eVar5.x().a();
                if (aVarA != null) {
                    cVarA.h(aVarA.b());
                    cVarA.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = eVar5.x().b();
                if (cVarB != null) {
                    cVarA.g(cVarB.l());
                    cVarA.n(cVarB.k());
                }
                cVarA.a("2000123");
                com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA.c(), cVarA, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                e7.printStackTrace();
            }
        }
    }

    public ReportReceiver() {
    }
}
