package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4557a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4558b;

    /* renamed from: c, reason: collision with root package name */
    private int f4559c = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.j$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4562a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4562a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4562a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i10, com.mbridge.msdk.newreward.function.c.a.a aVar, MBridgeError mBridgeError) {
        com.mbridge.msdk.newreward.function.command.c cVar = this.f4557a;
        if (cVar == null || this.f4558b == null) {
            return;
        }
        try {
            Map mapA = cVar.a("resource_type", 7, "url", aVar.e().j(), "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
            int i11 = AnonymousClass2.f4562a[fVar.ordinal()];
            if (i11 == 1) {
                mapA.put("cache", Integer.valueOf(this.f4559c));
                this.f4557a.a(this.f4558b, fVar, mapA);
            } else if (i11 == 2 && this.f4559c == 2) {
                mapA.put("result", Integer.valueOf(i10));
                if (i10 != 1 && mBridgeError != null) {
                    mapA.put("reason", mBridgeError.getErrorMessage());
                }
                this.f4557a.a(this.f4558b, fVar, mapA);
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
        com.mbridge.msdk.newreward.function.c.c.l lVarE = aVar.e();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f4557a = (com.mbridge.msdk.newreward.function.command.c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f4558b = (com.mbridge.msdk.newreward.a.e) aVar.i().H().get("adapter_model");
            }
        }
        if (lVarE == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (lVarE.f() == 1) {
            this.f4559c = 1;
        } else {
            this.f4559c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, 0, aVar, null);
        lVarE.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.j.1
            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                if (bVar2.y()) {
                    bVar.reqSuccessful(aVar2);
                }
                j.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 3, aVar2, mBridgeError);
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                if (bVar2.y()) {
                    bVar.reqSuccessful(aVar2);
                }
                j.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 1, aVar2, null);
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
            }

            @Override // com.mbridge.msdk.newreward.function.c.c.x
            public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                if (bVar2.y()) {
                    bVar.reqSuccessful(aVar2);
                }
                j.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 2, aVar2, mBridgeError);
            }
        });
    }
}
