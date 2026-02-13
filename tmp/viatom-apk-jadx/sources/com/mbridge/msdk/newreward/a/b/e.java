package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4533a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4534b;

    /* renamed from: c, reason: collision with root package name */
    private int f4535c = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.e$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4539a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4539a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4539a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i10, com.mbridge.msdk.newreward.function.c.a.a aVar, MBridgeError mBridgeError) {
        com.mbridge.msdk.newreward.function.command.c cVar = this.f4533a;
        if (cVar == null || this.f4534b == null) {
            return;
        }
        try {
            Map mapA = cVar.a("resource_type", 2, "scenes", 1, "url", aVar.c().j(), "resumed_breakpoint", "2", CampaignEx.JSON_KEY_READY_RATE, 100, "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
            int i11 = AnonymousClass2.f4539a[fVar.ordinal()];
            if (i11 == 1) {
                mapA.put("cache", Integer.valueOf(this.f4535c));
                this.f4533a.a(this.f4534b, fVar, mapA);
            } else if (i11 == 2 && this.f4535c == 2) {
                mapA.put("result", Integer.valueOf(i10));
                if (i10 != 1 && mBridgeError != null) {
                    mapA.put("reason", mBridgeError.getErrorMessage());
                }
                this.f4533a.a(this.f4534b, fVar, mapA);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, final b bVar) throws IOException {
        com.mbridge.msdk.newreward.function.c.a.a aVar = (com.mbridge.msdk.newreward.function.c.a.a) obj;
        final com.mbridge.msdk.newreward.function.c.c.d<?> dVarC = aVar.c();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f4533a = (com.mbridge.msdk.newreward.function.command.c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f4534b = (com.mbridge.msdk.newreward.a.e) aVar.i().H().get("adapter_model");
            }
        }
        if (dVarC == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (dVarC.f() == 1) {
            this.f4535c = 1;
        } else {
            this.f4535c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, 0, aVar, null);
        dVarC.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.e.1
            private void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar2, MBridgeError mBridgeError, String str) {
                if (bVar2.y()) {
                    try {
                        bVar3.reqSuccessful(aVar2);
                        return;
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqVideoService", "doReq: ", e);
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (dVarC.d()) {
                        return;
                    }
                    bVar3.reqFailed(com.mbridge.msdk.foundation.c.a.a(mBridgeError.getErrorCode(), 880006, str + mBridgeError.getErrorMessage()));
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("ReqVideoService", "doReq: ", e3);
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                if (bVar2.y()) {
                    bVar.reqSuccessful(aVar2);
                }
                if (e.this.f4533a != null && aVar2 != null && aVar2.c() != null) {
                    if (aVar2.c().g()) {
                        return;
                    } else {
                        e.this.f4533a.i(e.this.f4533a.a("web_resource_action", 1, "parent_temple", null, "adapter_model", e.this.f4534b, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, e.this.f4534b.G(), "bridge_ids", aVar2.g()), com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_TEMPLATE);
                    }
                }
                e.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 1, aVar2, null);
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                e.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 3, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError, "errorCode: 3202 errorMessage: ");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                e.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 2, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError, "errorCode: 3401 errorMessage: ");
            }
        });
    }
}
