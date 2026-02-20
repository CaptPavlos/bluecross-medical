package com.mbridge.msdk.newreward.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private Deque<e> f4593a;

    /* renamed from: c, reason: collision with root package name */
    private RewardVideoListener f4595c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.e.f f4596d;
    private com.mbridge.msdk.newreward.function.command.c e;
    private MBridgeIds f;
    private Map g;
    private com.mbridge.msdk.newreward.b.b h;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.g.c f4599k;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4594b = new Object();

    /* renamed from: i, reason: collision with root package name */
    private int f4597i = 1;

    /* renamed from: j, reason: collision with root package name */
    private int f4598j = 1;

    public d() {
        if (this.f4593a == null) {
            this.f4593a = new ConcurrentLinkedDeque();
        }
    }

    private void b(e eVar) {
        try {
            List<String> listE = com.mbridge.msdk.newreward.function.d.c.a().b().e(eVar.h(), eVar.C(), eVar.H());
            if (listE == null || listE.size() <= 0) {
                return;
            }
            String str = "";
            if (eVar.D() != null && eVar.D().b() != null) {
                str = eVar.D().b().a() + "";
            }
            Iterator<String> it = listE.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.foundation.same.report.d.d.a().b(it.next(), str);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void c(e eVar) {
        e next;
        if (eVar == null || TextUtils.isEmpty(eVar.k())) {
            return;
        }
        try {
            Deque<e> deque = this.f4593a;
            if (deque != null) {
                Iterator<e> it = deque.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (next != null && next.j() && (next.D() == null || !next.D().c())) {
                        if (eVar.k().equals(next.G())) {
                            break;
                        }
                    }
                }
                next = null;
            } else {
                next = null;
            }
            if (next != null) {
                com.mbridge.msdk.newreward.function.command.c cVar = this.e;
                cVar.c(cVar.a("adapter_model", eVar, "queue_first_adapter_model", next), com.mbridge.msdk.newreward.function.command.f.UPDATE_CAM_TOKEN_RULE);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: Exception -> 0x006c, TRY_ENTER, TryCatch #0 {Exception -> 0x006c, blocks: (B:19:0x0057, B:22:0x005d, B:25:0x006f, B:27:0x007b, B:32:0x008f), top: B:47:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:19:0x0057, B:22:0x005d, B:25:0x006f, B:27:0x007b, B:32:0x008f), top: B:47:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f A[Catch: Exception -> 0x0026, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0026, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000f, B:9:0x0019, B:11:0x0021, B:15:0x002b, B:17:0x0051, B:35:0x009f, B:38:0x00a7, B:40:0x00b1, B:41:0x00cc), top: B:49:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d(com.mbridge.msdk.newreward.a.e r9) {
        /*
            r8 = this;
            java.lang.String r0 = "error_code"
            r1 = 0
            java.util.Deque<com.mbridge.msdk.newreward.a.e> r2 = r8.f4593a     // Catch: java.lang.Exception -> L26
            if (r2 == 0) goto L29
            java.lang.Object r2 = r2.peek()     // Catch: java.lang.Exception -> L26
            com.mbridge.msdk.newreward.a.e r2 = (com.mbridge.msdk.newreward.a.e) r2     // Catch: java.lang.Exception -> L26
            if (r2 == 0) goto L29
            java.lang.String r3 = r2.i()     // Catch: java.lang.Exception -> L26
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L26
            if (r4 != 0) goto L29
            java.lang.String r4 = "-1"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L29
            long r2 = r2.g()     // Catch: java.lang.Exception -> L26
            goto L2b
        L26:
            r9 = move-exception
            goto Ld8
        L29:
            r2 = 0
        L2b:
            com.mbridge.msdk.newreward.function.command.c r4 = r8.e     // Catch: java.lang.Exception -> L26
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L26
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = "adapter_model"
            r3[r1] = r5     // Catch: java.lang.Exception -> L26
            r5 = 1
            r3[r5] = r9     // Catch: java.lang.Exception -> L26
            java.lang.String r6 = "last_response_empty_time"
            r7 = 2
            r3[r7] = r6     // Catch: java.lang.Exception -> L26
            r6 = 3
            r3[r6] = r2     // Catch: java.lang.Exception -> L26
            java.util.Map r2 = r4.a(r3)     // Catch: java.lang.Exception -> L26
            com.mbridge.msdk.newreward.function.command.f r3 = com.mbridge.msdk.newreward.function.command.f.CHECK_IS_REQUEST_CONTROL     // Catch: java.lang.Exception -> L26
            java.lang.Object r2 = r4.b(r2, r3)     // Catch: java.lang.Exception -> L26
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L26
            if (r2 == 0) goto L9d
            int r3 = r2.size()     // Catch: java.lang.Exception -> L26
            if (r3 <= 0) goto L9d
            com.mbridge.msdk.newout.RewardVideoListener r3 = r8.f4595c     // Catch: java.lang.Exception -> L6c
            java.lang.String r4 = "msg"
            if (r3 == 0) goto L6f
            com.mbridge.msdk.out.MBridgeIds r6 = new com.mbridge.msdk.out.MBridgeIds     // Catch: java.lang.Exception -> L6c
            r6.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.Object r7 = r2.get(r4)     // Catch: java.lang.Exception -> L6c
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L6c
            r3.onVideoLoadFail(r6, r7)     // Catch: java.lang.Exception -> L6c
            goto L6f
        L6c:
            r9 = move-exception
            r1 = r5
            goto Ld8
        L6f:
            java.lang.Object r3 = r2.get(r0)     // Catch: java.lang.Exception -> L6c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L6c
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L6c
            if (r3 != 0) goto L85
            java.lang.Object r0 = r2.get(r0)     // Catch: java.lang.Exception -> L6c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L6c
            int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L6c
        L85:
            r0 = -1
            if (r1 != r0) goto L8c
            r0 = 880018(0xd6d92, float:1.233168E-39)
            goto L8f
        L8c:
            r0 = 880002(0xd6d82, float:1.233145E-39)
        L8f:
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L6c
            com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r0, r2)     // Catch: java.lang.Exception -> L6c
            r8.a(r9, r0)     // Catch: java.lang.Exception -> L6c
            r1 = r5
        L9d:
            if (r1 == 0) goto Ld7
            com.mbridge.msdk.newreward.function.e.a r0 = r9.D()     // Catch: java.lang.Exception -> L26
            java.lang.String r2 = ""
            if (r0 == 0) goto Lcc
            com.mbridge.msdk.newreward.function.e.a r0 = r9.D()     // Catch: java.lang.Exception -> L26
            com.mbridge.msdk.newreward.function.c.a.b r0 = r0.b()     // Catch: java.lang.Exception -> L26
            if (r0 == 0) goto Lcc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r0.<init>()     // Catch: java.lang.Exception -> L26
            com.mbridge.msdk.newreward.function.e.a r3 = r9.D()     // Catch: java.lang.Exception -> L26
            com.mbridge.msdk.newreward.function.c.a.b r3 = r3.b()     // Catch: java.lang.Exception -> L26
            int r3 = r3.a()     // Catch: java.lang.Exception -> L26
            r0.append(r3)     // Catch: java.lang.Exception -> L26
            r0.append(r2)     // Catch: java.lang.Exception -> L26
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Exception -> L26
        Lcc:
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Exception -> L26
            java.lang.String r9 = r9.G()     // Catch: java.lang.Exception -> L26
            r0.b(r9, r2)     // Catch: java.lang.Exception -> L26
        Ld7:
            return r1
        Ld8:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto Ldf
            r9.printStackTrace()
        Ldf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.d.d(com.mbridge.msdk.newreward.a.e):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0115 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:19:0x005c, B:21:0x0062, B:25:0x0067, B:27:0x006f, B:30:0x0077, B:32:0x0081, B:34:0x008b, B:36:0x00cc, B:38:0x0100, B:40:0x0108, B:63:0x019f, B:41:0x0115, B:43:0x0135, B:46:0x013f, B:48:0x0149, B:50:0x0153, B:52:0x0159, B:54:0x0163, B:55:0x0173, B:56:0x0179, B:58:0x017f, B:60:0x018f, B:62:0x0195, B:64:0x01bd, B:65:0x01c3, B:67:0x01c9, B:69:0x01d9, B:71:0x01df, B:73:0x01ec, B:75:0x01f6, B:76:0x0213, B:77:0x021f, B:78:0x0222, B:81:0x022c, B:82:0x0230, B:83:0x023f), top: B:98:0x005c, outer: #1 }] */
    @Override // com.mbridge.msdk.newreward.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.mbridge.msdk.newreward.a.e r19, com.mbridge.msdk.newreward.a.b r20) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.d.a(com.mbridge.msdk.newreward.a.e, com.mbridge.msdk.newreward.a.b):void");
    }

    public final void b(Object obj) {
        for (com.mbridge.msdk.newreward.function.c.a.b bVar : (List) obj) {
            e eVar = new e(false, ((Integer) this.g.get("mb_ad_type")).intValue(), bVar.h(), bVar.e(), bVar.i());
            com.mbridge.msdk.newreward.function.e.a aVar = new com.mbridge.msdk.newreward.function.e.a();
            aVar.a(bVar);
            eVar.a(aVar);
            eVar.a(this.f4596d);
            eVar.f(bVar.g());
            eVar.c(2);
            eVar.a(this.f);
            eVar.f4604a = new g(this.e);
            eVar.a(this.f4595c);
            this.f4593a.add(eVar);
        }
    }

    private void c() {
        try {
            com.mbridge.msdk.newreward.b.b bVar = this.h;
            if (bVar != null) {
                e eVarA = bVar.a();
                com.mbridge.msdk.newreward.function.command.c cVar = this.e;
                if (eVarA != null) {
                    cVar.a(this.h.a(), com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START, (Object) null);
                } else {
                    cVar.a(this.h, com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START, (Object) null);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    @Nullable
    public final e b() {
        e eVarPeek;
        Deque<e> deque = this.f4593a;
        if (deque == null || deque.size() == 0 || (eVarPeek = this.f4593a.peek()) == null) {
            return null;
        }
        return eVarPeek;
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(Object obj) {
        try {
            this.f4595c = (RewardVideoListener) obj;
        } catch (Throwable unused) {
            this.f4595c = null;
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(Object... objArr) {
        this.e = (com.mbridge.msdk.newreward.function.command.c) objArr[0];
        this.h = (com.mbridge.msdk.newreward.b.b) objArr[1];
        com.mbridge.msdk.newreward.function.command.d.a().a(this.e);
        final Map mapA = this.e.a("mb_ad_type", Integer.valueOf(this.h.e()), "mb_ad_is_header_bidding", Boolean.valueOf(this.h.f()), "mb_ad_pid", this.h.d(), "mb_ad_unit_id", this.h.c());
        this.g = mapA;
        this.f = (MBridgeIds) this.e.a(mapA, com.mbridge.msdk.newreward.function.command.f.CREATE_BIDS);
        com.mbridge.msdk.newreward.function.command.c cVar = this.e;
        cVar.c(cVar.a("mb_ad_unit_id", this.h.c(), "command_type", com.mbridge.msdk.newreward.function.command.f.UNIT_INIT), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
            }
        });
        com.mbridge.msdk.newreward.function.d.c.a().b().a(this.h.e(), this.h.d(), this.h.c());
        this.e.a((Object) mapA, com.mbridge.msdk.newreward.function.command.f.REQ_SETTING, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.2
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                d.this.f4596d = (com.mbridge.msdk.newreward.function.e.f) obj;
                d.this.g = mapA;
                if (d.this.h != null) {
                    d.this.h.a(d.this.f4596d);
                }
                ((MBridgeDailyPlayModel) d.this.e.a(mapA, com.mbridge.msdk.newreward.function.command.f.CREATE_DAILY)).setMaxPlayCount(d.this.f4596d.b() == null ? 0 : d.this.f4596d.b().d());
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }
        });
        Map map = this.g;
        map.put("command_type", com.mbridge.msdk.newreward.function.command.f.RESTORE_DB);
        this.e.c(map, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.3
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                d.this.b(obj);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }
        });
        com.mbridge.msdk.newreward.function.command.c cVar2 = this.e;
        cVar2.f(cVar2.a("controller_model", this.h, "command_manager", cVar2, "adapter_manager", this));
        int iA = ah.a().a(MBridgeCommon.SharedPreference.KEY_LOADING_CAPACITY, 1);
        this.f4598j = iA;
        if (iA <= 0) {
            this.f4598j = 1;
        }
        this.f4599k = com.mbridge.msdk.newreward.function.g.a.a();
    }

    private void a(e eVar, com.mbridge.msdk.newreward.function.command.f fVar) {
        int iB;
        int iA;
        if (eVar == null) {
            return;
        }
        List<CampaignEx> listA = eVar.D() != null ? eVar.D().a() : null;
        try {
            if (eVar.D() == null || eVar.D().b() == null) {
                iB = 0;
                iA = 0;
            } else {
                com.mbridge.msdk.newreward.function.c.a.b bVarB = eVar.D().b();
                iA = bVarB.a();
                iB = bVarB.b();
            }
            int filterCallBackState = (listA == null || listA.isEmpty()) ? 0 : listA.get(0).getFilterCallBackState();
            com.mbridge.msdk.newreward.function.command.c cVar = this.e;
            cVar.a(eVar, fVar, cVar.a("metrics_data", listA, "auto_load", Integer.valueOf(eVar.I() ? 2 : 1), "cache", 1, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void a(e eVar, com.mbridge.msdk.foundation.c.b bVar) {
        int filterCallBackState;
        int iA;
        int iB;
        eVar.c(2);
        eVar.h(true);
        if (eVar.D() == null || eVar.D().b() == null) {
            filterCallBackState = 0;
            iA = 0;
            iB = 0;
        } else {
            com.mbridge.msdk.newreward.function.c.a.b bVarB = eVar.D().b();
            iA = bVarB.a();
            iB = bVarB.b();
            filterCallBackState = (bVarB.E() == null || bVarB.E().isEmpty()) ? 0 : bVarB.E().get(0).getFilterCallBackState();
        }
        com.mbridge.msdk.newreward.function.command.c cVar = this.e;
        cVar.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_FAILED, cVar.a("metrics_data", bVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(f fVar) {
        e eVarPeek;
        synchronized (this.f4594b) {
            try {
            } catch (Throwable th) {
                c();
                a("show exception: " + th.getMessage());
            }
            if (this.f4593a.isEmpty()) {
                this.h.a(com.mbridge.msdk.newreward.function.h.d.a(""));
                RewardVideoListener rewardVideoListener = this.f4595c;
                if (rewardVideoListener != null) {
                    rewardVideoListener.onShowFail(this.f, com.mbridge.msdk.foundation.c.a.a(890005));
                }
                c();
                a(com.mbridge.msdk.foundation.c.a.a(890005));
                return;
            }
            while (a(2) > this.f4597i) {
                this.f4593a.pollFirst();
            }
            ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
            while (true) {
                if (this.f4593a.isEmpty()) {
                    break;
                }
                try {
                    eVarPeek = this.f4593a.peek();
                } catch (Exception e) {
                    if (this.f4593a.size() == 1) {
                        this.h.a(com.mbridge.msdk.newreward.function.h.d.a(""));
                        RewardVideoListener rewardVideoListener2 = this.f4595c;
                        if (rewardVideoListener2 != null) {
                            rewardVideoListener2.onShowFail(this.f, e.getMessage());
                        }
                        a("show failed, exception is " + e.getMessage());
                    }
                }
                if (eVarPeek != null && eVarPeek.D() != null && eVarPeek.D().c()) {
                    if (eVarPeek.h() == 287 && ah.a().a("s_a_w_n_c", true) && !ak.l(com.mbridge.msdk.foundation.controller.c.m().c())) {
                        RewardVideoListener rewardVideoListener3 = this.f4595c;
                        if (rewardVideoListener3 != null) {
                            rewardVideoListener3.onShowFail(this.f, com.mbridge.msdk.foundation.c.a.a(890011));
                        }
                        a(eVarPeek, com.mbridge.msdk.foundation.c.a.a(890011));
                        this.f4593a.poll();
                    } else {
                        c(eVarPeek);
                        b bVar = eVarPeek.f4604a;
                        eVarPeek.a(fVar);
                        this.h.a(eVarPeek);
                        com.mbridge.msdk.newreward.function.command.d.a().a(eVarPeek);
                        bVar.b(eVarPeek);
                        this.f4593a.poll();
                    }
                } else if (eVarPeek != null && eVarPeek.y() == 2 && !eVarPeek.D().c()) {
                    if (this.f4593a.size() == 1) {
                        this.h.a(eVarPeek);
                        RewardVideoListener rewardVideoListener4 = this.f4595c;
                        if (rewardVideoListener4 != null) {
                            rewardVideoListener4.onShowFail(this.f, com.mbridge.msdk.foundation.c.a.a(890006));
                        }
                        a(eVarPeek, com.mbridge.msdk.foundation.c.a.a(890006));
                    }
                    this.f4593a.poll();
                } else {
                    if (this.f4593a.size() == 1) {
                        RewardVideoListener rewardVideoListener5 = this.f4595c;
                        if (rewardVideoListener5 != null) {
                            rewardVideoListener5.onShowFail(this.f, com.mbridge.msdk.foundation.c.a.a(890007));
                        }
                        a(eVarPeek, com.mbridge.msdk.foundation.c.a.a(890007));
                    }
                    concurrentLinkedDeque.push(this.f4593a.poll());
                }
            }
            while (!concurrentLinkedDeque.isEmpty()) {
                this.f4593a.push(concurrentLinkedDeque.poll());
            }
            c();
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final boolean a(boolean z9) {
        com.mbridge.msdk.newreward.function.c.a.b bVarB;
        Object obj = null;
        com.mbridge.msdk.newreward.function.c.a.b bVar = null;
        for (e eVar : this.f4593a) {
            if (eVar != null) {
                com.mbridge.msdk.newreward.function.e.a aVarD = eVar.D();
                if (aVarD == null || (bVarB = aVarD.b()) == null) {
                    obj = eVar;
                } else {
                    if (aVarD.c()) {
                        if (z9) {
                            a(true, eVar, bVarB);
                        }
                        return true;
                    }
                    obj = eVar;
                    bVar = bVarB;
                }
            }
        }
        if (z9) {
            if (obj == null) {
                obj = this.h;
            }
            a(false, obj, bVar);
        }
        return false;
    }

    private void a(boolean z9, Object obj, com.mbridge.msdk.newreward.function.c.a.b bVar) {
        if (this.e == null || obj == null) {
            return;
        }
        try {
            String strValueOf = z9 ? String.valueOf(1) : String.valueOf(2);
            String isReadyNotReadyReasonType = MBridgeGlobalCommon.getIsReadyNotReadyReasonType(bVar);
            com.mbridge.msdk.newreward.function.command.c cVar = this.e;
            if (z9) {
                cVar.a(obj, com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK, cVar.a("result", strValueOf));
            } else {
                cVar.a(obj, com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK, cVar.a("result", strValueOf, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, isReadyNotReadyReasonType));
            }
        } catch (Throwable th) {
            af.a("reportReadyCheck", th.getMessage());
        }
    }

    private int a(int i10) {
        int i11 = 0;
        if (this.f4593a.size() == 0) {
            return 0;
        }
        for (e eVar : this.f4593a) {
            if (i10 != 1) {
                if (i10 == 2 && eVar.D().c()) {
                    i11++;
                }
            } else if (eVar.y() == 1) {
                i11++;
            }
        }
        return i11;
    }

    private void a(String str) {
        try {
            com.mbridge.msdk.newreward.b.b bVar = this.h;
            if (bVar == null) {
                return;
            }
            com.mbridge.msdk.newreward.function.command.c cVar = this.e;
            cVar.a(bVar, com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_FAIL, cVar.a("reason", str));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void a(e eVar, String str) {
        int iA;
        int iB;
        if (eVar == null) {
            return;
        }
        try {
            int filterCallBackState = 0;
            CampaignEx campaignEx = (eVar.D() == null || eVar.D().a() == null || eVar.D().a().isEmpty()) ? null : eVar.D().a().get(0);
            if (campaignEx != null) {
                com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                if (eVar.D() == null || eVar.D().b() == null) {
                    iA = 0;
                    iB = 0;
                } else {
                    com.mbridge.msdk.newreward.function.c.a.b bVarB = eVar.D().b();
                    iA = bVarB.a();
                    iB = bVarB.b();
                    if (bVarB.E() != null && !bVarB.E().isEmpty()) {
                        filterCallBackState = bVarB.E().get(0).getFilterCallBackState();
                    }
                }
                eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState));
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA));
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB));
                eVar2.a("reason", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000131", campaignEx, eVar2);
                return;
            }
            a(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final List<e> a() {
        ArrayList arrayList = new ArrayList();
        Deque<e> deque = this.f4593a;
        if (deque != null && deque.size() != 0) {
            Iterator<e> it = this.f4593a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void a(e eVar) {
        Deque<e> deque;
        if (eVar == null || (deque = this.f4593a) == null) {
            return;
        }
        deque.addLast(eVar);
    }
}
