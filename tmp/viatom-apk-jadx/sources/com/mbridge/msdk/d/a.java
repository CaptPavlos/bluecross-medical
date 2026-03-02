package com.mbridge.msdk.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f2877a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2878b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<i> f2879c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<i> f2880d;
    private int e;
    private int f;
    private e g;
    private com.mbridge.msdk.videocommon.d.a h;

    /* renamed from: i, reason: collision with root package name */
    private m f2881i;

    /* renamed from: j, reason: collision with root package name */
    private g f2882j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f2883k;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.d.a$a, reason: collision with other inner class name */
    public static class C0021a {

        /* renamed from: a, reason: collision with root package name */
        static a f2887a = new a();
    }

    private a() {
        this.f2878b = false;
        this.f2879c = new LinkedList<>();
        this.f2880d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.f2883k = new Handler() { // from class: com.mbridge.msdk.d.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (a.this) {
                    try {
                        int i10 = message.what;
                        if (i10 != 1) {
                            if (i10 == 2) {
                                a.c(a.this);
                            }
                        } else {
                            if (a.this.f2878b) {
                                return;
                            }
                            a aVar = a.this;
                            a.a(aVar, aVar.f2877a);
                            sendMessageDelayed(obtainMessage(1), a.this.f2877a);
                        }
                    } finally {
                    }
                }
            }
        };
    }

    public static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<i> linkedList = aVar.f2879c;
            if (linkedList != null && linkedList.size() > 0 && aVar.e < aVar.f2879c.size()) {
                i iVar = aVar.f2879c.get(aVar.e);
                aVar.e++;
                if (aVar.a(iVar)) {
                    aVar.a(iVar.a(), iVar.b(), false);
                    return;
                }
                return;
            }
            LinkedList<i> linkedList2 = aVar.f2880d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f >= aVar.f2880d.size()) {
                return;
            }
            i iVar2 = aVar.f2880d.get(aVar.f);
            aVar.f++;
            if (aVar.a(iVar2)) {
                aVar.a(iVar2.a(), iVar2.b(), true);
            }
        } catch (Throwable th) {
            af.b("LoopTimer", th.getMessage(), th);
        }
    }

    public final void a(long j10) {
        if (this.f2882j == null) {
            this.f2882j = g.a(c.m().c());
        }
        if (this.f2881i == null) {
            this.f2881i = m.a(this.f2882j);
        }
        List<i> listA = this.f2881i.a(287);
        if (listA != null) {
            this.f2880d.addAll(listA);
            for (i iVar : listA) {
                b(iVar.a(), iVar.b());
            }
        }
        List<i> listA2 = this.f2881i.a(94);
        if (listA2 != null) {
            this.f2879c.addAll(listA2);
            for (i iVar2 : listA2) {
                a(iVar2.a(), iVar2.b());
            }
        }
        if (this.g == null) {
            this.g = e.a(this.f2882j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.f2877a = j10;
        this.f2878b = false;
        Handler handler = this.f2883k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f2877a);
    }

    public final void b(String str, String str2) {
        if (this.f2880d.contains(str2)) {
            return;
        }
        this.f2880d.add(new i(str, str2, 287));
        m mVar = this.f2881i;
        if (mVar != null) {
            mVar.a(str, str2, 287);
        }
    }

    private boolean a(i iVar) {
        boolean z9 = false;
        if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
            String strB = iVar.b();
            try {
                if (this.g == null) {
                    return true;
                }
                com.mbridge.msdk.videocommon.d.a aVar = this.h;
                int iA = this.g.a(strB, aVar != null ? aVar.f() : 0L);
                if (iA != -1) {
                    if (iA == 1) {
                        return true;
                    }
                } else if (!TextUtils.isEmpty(strB)) {
                    LinkedList<i> linkedList = this.f2879c;
                    if (linkedList != null && linkedList.contains(strB)) {
                        this.f2879c.remove(strB);
                    } else {
                        LinkedList<i> linkedList2 = this.f2880d;
                        if (linkedList2 != null && linkedList2.contains(strB)) {
                            this.f2880d.remove(strB);
                        }
                    }
                    m mVar = this.f2881i;
                    if (mVar != null) {
                        mVar.a(strB);
                    }
                }
                try {
                    Handler handler = this.f2883k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    af.b("LoopTimer", th.getMessage(), th);
                    return z9;
                }
            } catch (Throwable th2) {
                th = th2;
                z9 = true;
            }
        }
        return z9;
    }

    private void a(String str, String str2, boolean z9) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return;
            }
            final com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(contextC, str, str2);
            cVar.b(z9);
            cVar.a(new com.mbridge.msdk.reward.adapter.a() { // from class: com.mbridge.msdk.d.a.2
                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
                    a.this.f2883k.sendMessage(a.this.f2883k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(String str3, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
                    a.this.f2883k.sendMessage(a.this.f2883k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }
            });
            com.mbridge.msdk.foundation.same.report.d.c cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar2.c(SameMD5.getMD5(ak.d()));
            cVar2.d(str2);
            if (z9) {
                cVar2.b(287);
            } else {
                cVar2.b(94);
            }
            cVar2.i("0");
            cVar2.b("1");
            cVar.a(1, 8000, false, cVar2);
        } catch (Exception e) {
            af.b("LoopTimer", e.getMessage(), e);
        }
    }

    public final void a(String str, String str2) {
        if (this.f2879c.contains(str2)) {
            return;
        }
        this.f2879c.add(new i(str, str2, 94));
        m mVar = this.f2881i;
        if (mVar != null) {
            mVar.a(str, str2, 94);
        }
    }

    public static /* synthetic */ void a(a aVar, long j10) {
        LinkedList<i> linkedList = aVar.f2879c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.e == 0 || aVar.f2879c.size() <= aVar.e) {
            LinkedList<i> linkedList2 = aVar.f2880d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f == 0 || aVar.f2880d.size() == aVar.f) {
                aVar.f = 0;
                aVar.e = 0;
                Handler handler = aVar.f2883k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }
}
