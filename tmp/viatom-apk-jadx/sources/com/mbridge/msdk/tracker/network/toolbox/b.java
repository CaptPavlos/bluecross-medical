package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements com.mbridge.msdk.tracker.network.n {

    /* renamed from: a, reason: collision with root package name */
    protected final c f5447a;

    /* renamed from: b, reason: collision with root package name */
    private final a f5448b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private static q b(u<?> uVar) {
        if (uVar == null) {
            return null;
        }
        try {
            if (!uVar.d() || TextUtils.isEmpty(uVar.k())) {
                return null;
            }
            q qVar = new q(uVar.f(), uVar.i() == 0 ? ShareTarget.METHOD_GET : ShareTarget.METHOD_POST);
            qVar.d("queue");
            qVar.c(uVar.d("local_id"));
            qVar.b(uVar.d("ad_type"));
            qVar.a(uVar.v());
            uVar.a(qVar);
            return qVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014d  */
    @Override // com.mbridge.msdk.tracker.network.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.mbridge.msdk.tracker.network.r a(com.mbridge.msdk.tracker.network.u<?> r27) throws java.io.IOException, com.mbridge.msdk.tracker.network.ad {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.b.a(com.mbridge.msdk.tracker.network.u):com.mbridge.msdk.tracker.network.r");
    }

    private b(a aVar, c cVar) {
        this.f5448b = aVar;
        this.f5447a = cVar;
    }

    private static void a(q qVar, int i10, Exception exc) {
        if (qVar != null) {
            try {
                qVar.a(exc);
                qVar.b(i10);
            } catch (Exception unused) {
            }
        }
    }
}
