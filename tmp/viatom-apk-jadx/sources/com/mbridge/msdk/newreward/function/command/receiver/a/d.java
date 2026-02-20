package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.f;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private int f4820a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f4821b = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.d$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4825a;

        static {
            int[] iArr = new int[f.values().length];
            f4825a = iArr;
            try {
                iArr[f.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4825a[f.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (((java.lang.Boolean) r2).booleanValue() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.mbridge.msdk.newreward.function.command.receiver.a.e r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L8b
            com.mbridge.msdk.foundation.c.b r1 = r11.a()
            if (r1 == 0) goto L8b
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            if (r1 == 0) goto L8b
            com.mbridge.msdk.foundation.c.b r1 = r11.a()
            int r1 = r1.a()
            r2 = 2
            if (r1 != r2) goto L1b
            goto L8b
        L1b:
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            com.mbridge.msdk.newreward.function.e.a r1 = r1.D()
            if (r1 != 0) goto L26
            return r0
        L26:
            com.mbridge.msdk.newreward.function.c.a.b r1 = r1.b()
            if (r1 != 0) goto L2d
            return r0
        L2d:
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            com.mbridge.msdk.newreward.function.e.e r1 = r1.F()
            if (r1 != 0) goto L38
            return r0
        L38:
            com.mbridge.msdk.foundation.tools.ah r1 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r2 = "retry_strategy"
            java.lang.String r3 = "download_retry_max"
            int r1 = r1.a(r2, r3, r0)
            if (r1 != 0) goto L47
            return r0
        L47:
            com.mbridge.msdk.foundation.c.b r2 = r11.a()
            java.lang.String r3 = "can_retry"
            java.lang.Object r2 = r2.a(r3)
            if (r2 == 0) goto L5c
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> L5b
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L5b
            if (r2 != 0) goto L5c
        L5b:
            return r0
        L5c:
            int r2 = r10.f4820a
            if (r2 != 0) goto L66
            long r2 = java.lang.System.currentTimeMillis()
            r10.f4821b = r2
        L66:
            int r2 = r10.f4820a
            r3 = 1
            int r2 = r2 + r3
            r10.f4820a = r2
            com.mbridge.msdk.newreward.a.e r2 = r11.b()
            int r2 = r2.Q()
            long r4 = (long) r2
            com.mbridge.msdk.newreward.a.e r11 = r11.b()
            long r6 = r11.o()
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r6
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 >= 0) goto L8b
            int r11 = r10.f4820a
            if (r11 > r1) goto L8b
            return r3
        L8b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.d.a(com.mbridge.msdk.newreward.function.command.receiver.a.e):boolean");
    }

    public final void a(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        com.mbridge.msdk.newreward.a.e eVarB;
        com.mbridge.msdk.newreward.function.c.a.b bVarB;
        if (eVar == null || (eVarB = eVar.b()) == null || eVarB.D() == null || (bVarB = eVarB.D().b()) == null) {
            return;
        }
        a(f.REPORT_V3_RETRY_START, eVar, "", false);
        eVarB.m();
        eVarB.F().a(bVarB, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.command.receiver.a.d.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar2) {
                if (bVar != null) {
                    d.this.a(f.REPORT_V3_RETRY_END, eVar, bVar2 != null ? bVar2.b() : "", false);
                    bVar.reqFailed(bVar2);
                }
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                if (bVar != null) {
                    d.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                    bVar.reqSuccessful(obj);
                }
            }
        });
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
            Map mapA = cVarD.a("retry_count", Integer.valueOf(this.f4820a), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
            int i11 = AnonymousClass2.f4825a[fVar.ordinal()];
            if (i11 == 1) {
                cVarD.a(eVarB, f.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i11 != 2) {
                return;
            }
            mapA.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.f4821b));
            if (!z9) {
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
