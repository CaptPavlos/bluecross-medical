package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4526a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4527b;

    /* renamed from: c, reason: collision with root package name */
    private int f4528c = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.d$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4532a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4532a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4532a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, com.mbridge.msdk.newreward.function.c.a.b bVar, int i10, String str) {
        com.mbridge.msdk.newreward.function.command.c cVar = this.f4526a;
        if (cVar == null || this.f4527b == null) {
            return;
        }
        try {
            Map mapA = cVar.a("resource_type", 1, "url", bVar.w().j());
            int i11 = AnonymousClass2.f4532a[fVar.ordinal()];
            if (i11 == 1) {
                mapA.put("cache", Integer.valueOf(this.f4528c));
                this.f4526a.a(this.f4527b, fVar, mapA);
            } else if (i11 == 2 && this.f4528c == 2) {
                mapA.put("result", Integer.valueOf(i10));
                if (i10 != 1) {
                    mapA.put("reason", str);
                }
                this.f4526a.a(this.f4527b, fVar, mapA);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, final b bVar) throws IOException {
        com.mbridge.msdk.newreward.function.c.a.b bVar2 = (com.mbridge.msdk.newreward.function.c.a.b) obj;
        final com.mbridge.msdk.newreward.function.c.c.d<?> dVarW = bVar2.w();
        if (bVar2.H() != null) {
            if (bVar2.H().containsKey("command_manager")) {
                this.f4526a = (com.mbridge.msdk.newreward.function.command.c) bVar2.H().get("command_manager");
            }
            if (bVar2.H().containsKey("adapter_model")) {
                this.f4527b = (com.mbridge.msdk.newreward.a.e) bVar2.H().get("adapter_model");
            }
        }
        if (dVarW == null) {
            bVar.reqSuccessful(bVar2);
            return;
        }
        if (dVarW.f() == 1) {
            this.f4528c = 1;
        } else {
            this.f4528c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, bVar2, 0, "");
        dVarW.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.d.1
            private void a(com.mbridge.msdk.newreward.function.c.a.b bVar3, b bVar4, MBridgeError mBridgeError, String str) {
                int errorCode;
                String errorMessage;
                if (bVar3.y()) {
                    try {
                        bVar4.reqSuccessful(bVar3);
                        return;
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqDownBigTempleService", "doReq: ", e);
                            return;
                        }
                        return;
                    }
                }
                if (mBridgeError != null) {
                    try {
                        errorCode = mBridgeError.getErrorCode();
                        errorMessage = mBridgeError.getErrorMessage();
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqDownBigTempleService", "doReq: ", e3);
                            return;
                        }
                        return;
                    }
                } else {
                    errorMessage = "big temp load fail ";
                    errorCode = -1;
                }
                if (dVarW.d()) {
                    return;
                }
                bVar4.reqFailed(com.mbridge.msdk.foundation.c.a.a(errorCode, 880005, str + errorMessage));
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar, q qVar, MBridgeError mBridgeError) {
                d.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, bVar3, 2, mBridgeError != null ? mBridgeError.getErrorMessage() : "");
                a(bVar3, bVar, mBridgeError, "errorCode: 3401 errorMessage: ");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar, q qVar) {
                if (bVar3.y()) {
                    bVar.reqSuccessful(bVar3);
                }
                d.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, bVar3, 1, "");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar, q qVar, MBridgeError mBridgeError) {
                String errorMessage;
                if (mBridgeError != null) {
                    errorMessage = mBridgeError.getErrorMessage();
                } else {
                    errorMessage = "";
                }
                d.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, bVar3, 3, errorMessage);
                a(bVar3, bVar, mBridgeError, "errorCode: 3203 errorMessage:");
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar3, com.mbridge.msdk.newreward.function.c.a.a aVar, q qVar) {
            }
        });
    }
}
