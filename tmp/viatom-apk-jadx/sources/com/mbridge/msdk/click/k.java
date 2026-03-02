package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
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
public final class k extends com.mbridge.msdk.foundation.same.e.a {

    /* renamed from: b, reason: collision with root package name */
    private Context f2822b;

    /* renamed from: c, reason: collision with root package name */
    private String f2823c;

    /* renamed from: d, reason: collision with root package name */
    private String f2824d;
    private String e;
    private CampaignEx f;
    private boolean g;
    private boolean h;

    /* renamed from: i, reason: collision with root package name */
    private int f2825i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2826j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f2827k;

    /* renamed from: l, reason: collision with root package name */
    private JumpLoaderResult f2828l;

    /* renamed from: m, reason: collision with root package name */
    private f f2829m;

    /* renamed from: n, reason: collision with root package name */
    private j f2830n;

    /* renamed from: a, reason: collision with root package name */
    private final Semaphore f2821a = new Semaphore(0);

    /* renamed from: o, reason: collision with root package name */
    private final m.a f2831o = new m.a() { // from class: com.mbridge.msdk.click.k.1
        private void a() {
            synchronized (this) {
                try {
                    k.this.f2828l.setSuccess(true);
                    if (k.this.f2830n != null) {
                        k.this.f2830n.a(k.this.f2828l);
                    }
                    k.c(k.this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.click.m.a
        public final boolean b(String str) {
            boolean zA = k.a(k.this, str);
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
            k.a(k.this, str);
            k.this.f2828l.setContent(str2);
            a();
        }

        @Override // com.mbridge.msdk.click.m.a
        public final boolean a(String str) {
            boolean zA = k.a(k.this, str);
            if (zA) {
                a();
            }
            return zA;
        }

        @Override // com.mbridge.msdk.click.m.a
        public final void a(int i10, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                k.this.f2828l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                k.this.f2828l.setContent(str3);
            }
            k.a(k.this, str);
            a();
        }
    };

    public k(com.mbridge.msdk.click.entity.b bVar) {
        this.f2822b = bVar.a();
        this.f2823c = bVar.b();
        this.f2824d = bVar.c();
        this.e = bVar.d();
        this.f = bVar.e();
        this.g = bVar.f();
        this.h = bVar.g();
        this.f2825i = bVar.i();
        this.f2826j = bVar.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0162 A[LOOP:0: B:16:0x003d->B:66:0x0162, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016a A[EDGE_INSN: B:73:0x016a->B:67:0x016a BREAK  A[LOOP:0: B:16:0x003d->B:66:0x0162], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.k.a(java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    private String b(String str) {
        if (this.f2826j) {
            String strA = com.mbridge.msdk.c.b.a(this.f2822b, str);
            if (!TextUtils.isEmpty(strA)) {
                str = a3.a.C(str, strA);
            }
        }
        com.mbridge.msdk.e.b.a();
        return str;
    }

    public static /* synthetic */ void c(k kVar) {
        kVar.f2821a.release();
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void runTask() {
        f fVar = this.f2829m;
        if (fVar != null) {
            fVar.a(null);
        }
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        this.f2828l = jumpLoaderResult;
        jumpLoaderResult.setUrl(this.f2823c);
        JumpLoaderResult jumpLoaderResultA = a(this.f2823c);
        this.f2828l = jumpLoaderResultA;
        if (jumpLoaderResultA != null && !TextUtils.isEmpty(jumpLoaderResultA.getExceptionMsg())) {
            this.f2828l.setSuccess(true);
        }
        if (this.mState != a.b.RUNNING) {
            j jVar = this.f2830n;
            if (jVar != null) {
                jVar.a(this.f2828l);
                return;
            }
            return;
        }
        if (!this.f2828l.isSuccess()) {
            j jVar2 = this.f2830n;
            if (jVar2 != null) {
                jVar2.a(this.f2828l);
                return;
            }
            return;
        }
        com.mbridge.msdk.click.entity.a aVar = this.f2827k;
        if (aVar != null) {
            this.f2828l.setStatusCode(aVar.f);
        }
        JumpLoaderResult jumpLoaderResult2 = this.f2828l;
        com.mbridge.msdk.click.entity.a aVar2 = this.f2827k;
        String str = this.f2824d;
        String str2 = this.e;
        Context context = this.f2822b;
        m.a aVar3 = this.f2831o;
        j jVar3 = this.f2830n;
        Semaphore semaphore = this.f2821a;
        if (!aj.a.b(jumpLoaderResult2.getUrl()) && 200 == aVar2.f && !TextUtils.isEmpty(jumpLoaderResult2.getContent()) && !jumpLoaderResult2.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
            jumpLoaderResult2.setType(2);
            if (TextUtils.isEmpty(jumpLoaderResult2.getContent())) {
                try {
                    new m().a(str, str2, context, jumpLoaderResult2.getUrl(), aVar3);
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("TAG", "webview spider start error");
                    }
                }
            } else {
                new m().a(str, str2, context, jumpLoaderResult2.getUrl(), jumpLoaderResult2.getContent(), aVar3);
            }
            semaphore.acquireUninterruptibly();
            return;
        }
        if (aVar2 != null) {
            jumpLoaderResult2.setType(1);
            jumpLoaderResult2.setExceptionMsg(aVar2.h);
            jumpLoaderResult2.setStatusCode(aVar2.f);
            jumpLoaderResult2.setHeader(aVar2.a());
            jumpLoaderResult2.setContent(aVar2.g);
        }
        String url = jumpLoaderResult2.getUrl();
        if (aj.a.b(url)) {
            jumpLoaderResult2.setCode(1);
            jumpLoaderResult2.setUrl(url);
            jumpLoaderResult2.setjumpDone(true);
        } else {
            jumpLoaderResult2.setCode(2);
            jumpLoaderResult2.setUrl(url);
        }
        if (jVar3 != null) {
            jVar3.a(jumpLoaderResult2);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void pauseTask(boolean z9) {
    }

    public final void a(f fVar) {
        this.f2829m = fVar;
    }

    public final void a(j jVar) {
        this.f2830n = jVar;
    }

    public static /* synthetic */ boolean a(k kVar, String str) {
        CampaignEx campaignEx = kVar.f;
        JumpLoaderResult jumpLoaderResult = kVar.f2828l;
        if (aj.a.b(jumpLoaderResult.getUrl())) {
            jumpLoaderResult.setCode(1);
            jumpLoaderResult.setUrl(str);
            jumpLoaderResult.setjumpDone(true);
            return true;
        }
        jumpLoaderResult.setCode(2);
        jumpLoaderResult.setUrl(str);
        return false;
    }
}
