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
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4540a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4541b;

    /* renamed from: c, reason: collision with root package name */
    private int f4542c = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.f$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4546a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4546a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4546a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i10, com.mbridge.msdk.newreward.function.c.a.a aVar, MBridgeError mBridgeError) {
        if (this.f4540a == null || this.f4541b == null) {
            return;
        }
        try {
            Map mapA = this.f4540a.a("resource_type", 3, "scenes", 1, "url", aVar.f().j(), CampaignEx.JSON_KEY_READY_RATE, 100, "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
            int i11 = AnonymousClass2.f4546a[fVar.ordinal()];
            if (i11 == 1) {
                mapA.put("cache", Integer.valueOf(this.f4542c));
                this.f4540a.a(this.f4541b, fVar, mapA);
            } else if (i11 == 2 && this.f4542c == 2) {
                mapA.put("result", Integer.valueOf(i10));
                if (i10 != 1 && mBridgeError != null) {
                    mapA.put("reason", mBridgeError.getErrorMessage());
                }
                this.f4540a.a(this.f4541b, fVar, mapA);
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
        final com.mbridge.msdk.newreward.function.c.c.d<?> dVarF = aVar.f();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f4540a = (com.mbridge.msdk.newreward.function.command.c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f4541b = (com.mbridge.msdk.newreward.a.e) aVar.i().H().get("adapter_model");
            }
        }
        if (dVarF == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (dVarF.f() == 1) {
            this.f4542c = 1;
        } else {
            this.f4542c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, 0, aVar, null);
        dVarF.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.f.1
            private void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar2, MBridgeError mBridgeError, String str) {
                if (bVar2.y()) {
                    try {
                        bVar3.reqSuccessful(aVar2);
                        return;
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqEcService", "doReq: ", e);
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (dVarF.d()) {
                        return;
                    }
                    bVar3.reqFailed(com.mbridge.msdk.foundation.c.a.a(mBridgeError.getErrorCode(), 880007, str + mBridgeError.getErrorMessage()));
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("ReqEcService", "doReq: ", e3);
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 1, aVar2, null);
                if (dVarF.d()) {
                    bVar.reqSuccessful(aVar2);
                }
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 2, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError, "errorCode: 3401 errorMessage: ");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 3, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError, "errorCode: 3202 errorMessage: ");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
            }
        });
    }
}
