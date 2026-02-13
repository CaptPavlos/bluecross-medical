package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.a.a f4803a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f4804b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f4805c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f4806d = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.b$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4810a;

        static {
            int[] iArr = new int[f.values().length];
            f4810a = iArr;
            try {
                iArr[f.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4810a[f.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f4803a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, e eVar, String str, boolean z9) {
        if (eVar == null) {
            return;
        }
        if (this.f4806d == 0) {
            this.f4806d = System.currentTimeMillis();
        }
        com.mbridge.msdk.newreward.function.command.c cVarD = eVar.d();
        com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
        if (cVarD == null || eVarB == null) {
            return;
        }
        int i10 = 1;
        try {
            Map mapA = cVarD.a("retry_count", 1, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            int i11 = AnonymousClass2.f4810a[fVar.ordinal()];
            if (i11 == 1) {
                cVarD.a(eVarB, f.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i11 != 2) {
                return;
            }
            mapA.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.f4806d));
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

    public final boolean a() {
        return this.f4804b;
    }

    public final void a(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        a(f.REPORT_V3_RETRY_START, eVar, null, false);
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
        bVar2.a(f.REQ_CAMPAIGN);
        HashMap map = new HashMap();
        com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
        map.put("adapter_model", eVarB);
        map.put("command_manager", eVar.d());
        bVar2.a(map);
        eVarB.l();
        this.f4803a.a(bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.command.receiver.a.b.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar3) {
                b.this.a(f.REPORT_V3_RETRY_END, eVar, bVar3 != null ? bVar3.b() : "", false);
                b.this.f4804b = true;
                bVar.reqFailed(bVar3);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                b.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                bVar.reqSuccessful(obj);
            }
        });
    }
}
