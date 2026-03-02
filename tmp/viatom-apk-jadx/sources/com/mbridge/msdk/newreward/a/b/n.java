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
public final class n implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4578a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4579b;

    /* renamed from: c, reason: collision with root package name */
    private int f4580c = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.n$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4584a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4584a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4584a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i10, com.mbridge.msdk.newreward.function.c.a.a aVar, MBridgeError mBridgeError) {
        com.mbridge.msdk.newreward.function.command.c cVar = this.f4578a;
        if (cVar == null || this.f4579b == null) {
            return;
        }
        try {
            Map mapA = cVar.a("resource_type", 4, "scenes", 1, "url", aVar.d().j(), "resumed_breakpoint", "2", CampaignEx.JSON_KEY_READY_RATE, 100, "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
            int i11 = AnonymousClass2.f4584a[fVar.ordinal()];
            if (i11 == 1) {
                mapA.put("cache", Integer.valueOf(this.f4580c));
                this.f4578a.a(this.f4579b, fVar, mapA);
            } else if (i11 == 2 && this.f4580c == 2) {
                mapA.put("result", Integer.valueOf(i10));
                if (i10 != 1 && mBridgeError != null) {
                    mapA.put("reason", mBridgeError.getErrorMessage());
                }
                this.f4578a.a(this.f4579b, fVar, mapA);
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
        final com.mbridge.msdk.newreward.function.c.c.n nVarD = aVar.d();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f4578a = (com.mbridge.msdk.newreward.function.command.c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f4579b = (com.mbridge.msdk.newreward.a.e) aVar.i().H().get("adapter_model");
            }
        }
        if (nVarD == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (nVarD.f() == 1) {
            this.f4580c = 1;
        } else {
            this.f4580c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, 0, aVar, null);
        nVarD.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.n.1
            private void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar2, MBridgeError mBridgeError) {
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
                    if (nVarD.d()) {
                        return;
                    }
                    bVar3.reqFailed(com.mbridge.msdk.foundation.c.a.a(mBridgeError.getErrorCode(), 880004, mBridgeError.getErrorMessage()));
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("ReqVideoService", "doReq: ", e3);
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                n.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 1, aVar2, null);
                try {
                    if (bVar2.y()) {
                        bVar.reqSuccessful(aVar2);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("ReqVideoService", "doReq: ", e);
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                n.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 2, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError);
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                n.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 3, aVar2, mBridgeError);
                a(bVar2, bVar, aVar2, mBridgeError);
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
            }
        });
    }
}
