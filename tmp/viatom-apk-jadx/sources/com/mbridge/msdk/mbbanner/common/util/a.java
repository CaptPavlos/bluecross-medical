package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbanner.common.b.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4286a = "a";

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4287b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private boolean f4288c;

    public final void a(final b bVar, final CampaignUnit campaignUnit, final String str) {
        af.b(f4286a, "postCampaignSuccess unitId=" + str);
        this.f4287b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(str, campaignUnit, a.this.f4288c);
                }
            }
        });
    }

    public final void b(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        af.b(f4286a, "postResourceFail unitId=" + bVar2);
        this.f4287b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f4288c);
                    bVar.b(bVar2);
                }
            }
        });
    }

    public final void a(boolean z9) {
        this.f4288c = z9;
    }

    public final void a(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        this.f4287b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f4288c);
                    bVar.a(bVar2);
                }
            }
        });
    }

    public final void a(final b bVar, final String str, final int i10) {
        af.b(f4286a, "postResourceSuccess unitId=" + str);
        this.f4287b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(str, i10, a.this.f4288c);
                }
            }
        });
    }
}
