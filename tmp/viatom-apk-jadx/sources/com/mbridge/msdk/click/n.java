package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import java.util.concurrent.Semaphore;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends e implements a.InterfaceC0029a {

    /* renamed from: a, reason: collision with root package name */
    private f f2863a;

    /* renamed from: b, reason: collision with root package name */
    private JumpLoaderResult f2864b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2866d;
    private Context e;
    private com.mbridge.msdk.foundation.same.e.b f;
    private com.mbridge.msdk.click.entity.a g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2865c = true;
    private Handler h = new Handler(Looper.getMainLooper());

    public n(Context context) {
        this.e = context;
        this.f = new com.mbridge.msdk.foundation.same.e.b(context, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, f fVar, boolean z9, String str2, String str3, CampaignEx campaignEx, boolean z10, boolean z11, int i10) {
        a aVar;
        this.f2863a = fVar;
        this.f2866d = z9;
        com.mbridge.msdk.click.entity.b bVar = new com.mbridge.msdk.click.entity.b();
        bVar.a(this.e);
        bVar.a(str);
        bVar.c(z9);
        bVar.b(str2);
        bVar.c(str3);
        bVar.a(campaignEx);
        bVar.a(z10);
        bVar.b(z11);
        bVar.a(i10);
        if (str.startsWith("tcp")) {
            k kVar = new k(bVar);
            kVar.a(this.f2863a);
            kVar.a(new j() { // from class: com.mbridge.msdk.click.n.1
                @Override // com.mbridge.msdk.click.j
                public final void a(JumpLoaderResult jumpLoaderResult) {
                    n.this.f2864b = jumpLoaderResult;
                }
            });
            aVar = kVar;
        } else {
            aVar = new a(this.e, str, str2, str3, campaignEx, z10, z11, i10);
        }
        this.f.a(aVar, this);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: c, reason: collision with root package name */
        private final Context f2871c;

        /* renamed from: d, reason: collision with root package name */
        private String f2872d;
        private String e;
        private String f;
        private CampaignEx g;
        private boolean h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2873i;

        /* renamed from: j, reason: collision with root package name */
        private int f2874j;

        /* renamed from: b, reason: collision with root package name */
        private final Semaphore f2870b = new Semaphore(0);

        /* renamed from: k, reason: collision with root package name */
        private m.a f2875k = new m.a() { // from class: com.mbridge.msdk.click.n.a.1
            @Override // com.mbridge.msdk.click.m.a
            public final void a(int i10, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    n.this.f2864b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    n.this.f2864b.setContent(str3);
                }
                a.a(a.this, str);
                a();
            }

            @Override // com.mbridge.msdk.click.m.a
            public final boolean b(String str) {
                boolean zA = a.a(a.this, str);
                if (zA) {
                    a();
                }
                return zA;
            }

            @Override // com.mbridge.msdk.click.m.a
            public final boolean c(String str) {
                return false;
            }

            @Override // com.mbridge.msdk.click.m.a
            public final void a(String str, boolean z9, String str2) {
                a.a(a.this, str);
                n.this.f2864b.setContent(str2);
                a();
            }

            @Override // com.mbridge.msdk.click.m.a
            public final boolean a(String str) {
                boolean zA = a.a(a.this, str);
                if (zA) {
                    a();
                }
                return zA;
            }

            private void a() {
                synchronized (n.this) {
                    n.this.f2864b.setSuccess(true);
                    a.a(a.this);
                }
            }
        };

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z9, boolean z10, int i10) {
            this.f2871c = context;
            this.f2872d = str;
            this.e = str2;
            this.f = str3;
            this.g = campaignEx;
            this.h = z9;
            this.f2873i = z10;
            this.f2874j = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01c9 A[EDGE_INSN: B:83:0x01c9->B:75:0x01c9 BREAK  A[LOOP:0: B:21:0x004a->B:74:0x01c2], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r14, boolean r15, boolean r16, com.mbridge.msdk.foundation.entity.CampaignEx r17, int r18) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.n.a.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.entity.JumpLoaderResult");
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            if (n.this.f2863a != null) {
                n.this.f2863a.a(null);
            }
            n.this.f2864b = new JumpLoaderResult();
            n.this.f2864b.setUrl(this.f2872d);
            n.this.f2864b = a(this.f2872d, this.h, this.f2873i, this.g, this.f2874j);
            if (!TextUtils.isEmpty(n.this.f2864b.getExceptionMsg())) {
                n.this.f2864b.setSuccess(true);
            }
            if (n.this.f2865c && n.this.f2864b.isSuccess()) {
                if (n.this.g != null) {
                    n.this.f2864b.setStatusCode(n.this.g.f);
                }
                CampaignEx campaignEx = this.g;
                JumpLoaderResult jumpLoaderResult = n.this.f2864b;
                com.mbridge.msdk.click.entity.a aVar = n.this.g;
                String str = this.e;
                String str2 = this.f;
                Context context = this.f2871c;
                m.a aVar2 = this.f2875k;
                Semaphore semaphore = this.f2870b;
                if (aj.a.b(jumpLoaderResult.getUrl()) || 200 != aVar.f || TextUtils.isEmpty(jumpLoaderResult.getContent()) || jumpLoaderResult.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (aVar != null) {
                        jumpLoaderResult.setType(1);
                        jumpLoaderResult.setExceptionMsg(aVar.h);
                        jumpLoaderResult.setStatusCode(aVar.f);
                        jumpLoaderResult.setHeader(aVar.a());
                        jumpLoaderResult.setContent(aVar.g);
                    }
                    o.a(jumpLoaderResult.getUrl(), campaignEx, jumpLoaderResult);
                    return;
                }
                jumpLoaderResult.setType(2);
                if (TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    try {
                        new m().a(str, str2, context, jumpLoaderResult.getUrl(), aVar2);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WebViewSpiderLoaderDiff", e.getMessage());
                        }
                    }
                } else {
                    new m().a(str, str2, context, jumpLoaderResult.getUrl(), jumpLoaderResult.getContent(), aVar2);
                }
                semaphore.acquireUninterruptibly();
            }
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z9) {
        }

        private boolean a(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        public static /* synthetic */ boolean a(a aVar, String str) {
            return o.a(str, aVar.g, n.this.f2864b);
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.f2870b.release();
        }
    }

    @Override // com.mbridge.msdk.click.e
    public final void a() {
        this.f2865c = false;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a.InterfaceC0029a
    public final void a(a.b bVar) {
        if (bVar == a.b.FINISH && this.f2865c) {
            this.h.post(new Runnable() { // from class: com.mbridge.msdk.click.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (n.this.f2863a != null) {
                        boolean zIsSuccess = n.this.f2864b.isSuccess();
                        n nVar = n.this;
                        if (zIsSuccess) {
                            nVar.f2863a.b(n.this.f2864b);
                        } else {
                            nVar.f2863a.a(n.this.f2864b, n.this.f2864b.getMsg());
                        }
                    }
                }
            });
        }
    }
}
