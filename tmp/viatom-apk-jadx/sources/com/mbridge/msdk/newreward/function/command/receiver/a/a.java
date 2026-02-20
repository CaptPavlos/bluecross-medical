package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.a.a f4793a;

    /* renamed from: c, reason: collision with root package name */
    private long f4795c;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f4794b = false;

    /* renamed from: d, reason: collision with root package name */
    private int f4796d = 0;
    private long e = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.a$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4802a;

        static {
            int[] iArr = new int[f.values().length];
            f4802a = iArr;
            try {
                iArr[f.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4802a[f.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f4793a = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (((java.lang.Boolean) r9).booleanValue() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.mbridge.msdk.foundation.c.b r9, com.mbridge.msdk.newreward.function.command.receiver.a.e r10, com.mbridge.msdk.newreward.a.e r11) {
        /*
            r8 = this;
            r0 = 0
            if (r11 == 0) goto L86
            if (r9 == 0) goto L86
            if (r10 == 0) goto L86
            int r10 = r9.a()
            r1 = 2
            if (r10 != r1) goto L10
            goto L86
        L10:
            com.mbridge.msdk.foundation.tools.ah r10 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r1 = "campaign_request_interval"
            r2 = 3000(0xbb8, float:4.204E-42)
            java.lang.String r3 = "retry_strategy"
            int r10 = r10.a(r3, r1, r2)
            long r1 = (long) r10
            r8.f4795c = r1
            com.mbridge.msdk.foundation.tools.ah r10 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r1 = "campaign_request_max"
            int r10 = r10.a(r3, r1, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "campaignRequestRetryInvalidTime = "
            r1.<init>(r2)
            long r2 = r8.f4795c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CampaignRetryStrategy"
            com.mbridge.msdk.foundation.tools.af.a(r2, r1)
            long r1 = r8.f4795c
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L86
            if (r10 > 0) goto L4b
            goto L86
        L4b:
            java.lang.String r1 = "can_retry"
            java.lang.Object r9 = r9.a(r1)
            if (r9 == 0) goto L5c
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Exception -> L5b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Exception -> L5b
            if (r9 != 0) goto L5c
        L5b:
            return r0
        L5c:
            int r9 = r8.f4796d
            if (r9 != 0) goto L66
            long r1 = java.lang.System.currentTimeMillis()
            r8.e = r1
        L66:
            int r9 = r8.f4796d
            r1 = 1
            int r9 = r9 + r1
            r8.f4796d = r9
            long r2 = r11.p()
            int r9 = r11.P()
            long r4 = (long) r9
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r2
            long r2 = r8.f4795c
            long r4 = r4 - r2
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 >= 0) goto L86
            int r9 = r8.f4796d
            if (r9 > r10) goto L86
            return r1
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.a.a(com.mbridge.msdk.foundation.c.b, com.mbridge.msdk.newreward.function.command.receiver.a.e, com.mbridge.msdk.newreward.a.e):boolean");
    }

    public final void b(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        if (eVar == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
                bVar2.a(f.REQ_CAMPAIGN);
                HashMap map = new HashMap();
                final com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
                map.put("adapter_model", eVarB);
                map.put("command_manager", eVar.d());
                bVar2.a(map);
                eVarB.l();
                a.this.f4793a.a(bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.command.receiver.a.a.1.1
                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar3) {
                        af.a("CampaignRetryStrategy", "reqFailed，try retry");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        boolean zA = a.this.a(bVar3, eVar, eVarB);
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        if (zA) {
                            eVar.a(bVar3);
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            a.this.b(eVar, bVar);
                        } else {
                            a.this.f4794b = true;
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            a.this.a(f.REPORT_V3_RETRY_END, eVar, bVar3 != null ? bVar3.b() : "", false);
                            bVar.reqFailed(bVar3);
                        }
                    }

                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public final void reqSuccessful(Object obj) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                        bVar.reqSuccessful(obj);
                    }
                });
            }
        };
        af.a("CampaignRetryStrategy", "retryReqCampaign，retryReqCampaign: " + this.f4795c);
        MBridgeTaskManager.directorExecute(runnable, this.f4795c);
    }

    public final boolean a() {
        return this.f4794b;
    }

    public final void a(e eVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        a(f.REPORT_V3_RETRY_START, eVar, "", false);
        b(eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, e eVar, String str, boolean z9) {
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.c cVarD = eVar.d();
        com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
        if (cVarD == null || eVarB == null) {
            return;
        }
        try {
            int i10 = 1;
            Map mapA = cVarD.a("retry_count", Integer.valueOf(this.f4796d), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
            int i11 = AnonymousClass2.f4802a[fVar.ordinal()];
            if (i11 == 1) {
                cVarD.a(eVarB, f.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i11 != 2) {
                return;
            }
            mapA.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.e));
            if (z9) {
                mapA.put("reason", str);
            }
            if (!z9) {
                i10 = 2;
            }
            mapA.put("result", Integer.valueOf(i10));
            cVarD.a(eVarB, f.REPORT_V3_RETRY_END, mapA);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
