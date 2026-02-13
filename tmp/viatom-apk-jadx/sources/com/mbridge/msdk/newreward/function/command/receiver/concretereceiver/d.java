package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements a.InterfaceC0041a, com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.a.a f4835a;

    /* renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.b.b f4836b;

    /* renamed from: c, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.c f4837c;

    /* renamed from: d, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f4838d;
    com.mbridge.msdk.newreward.function.command.receiver.a.c e;

    /* renamed from: i, reason: collision with root package name */
    private Map f4839i;
    private String f = UUID.randomUUID().toString();
    private String g = UUID.randomUUID().toString();
    private long h = WorkRequest.MIN_BACKOFF_MILLIS;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f4840j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f4841k = false;

    /* renamed from: l, reason: collision with root package name */
    private final int f4842l = 1;

    /* renamed from: m, reason: collision with root package name */
    private final int f4843m = 1;

    /* renamed from: n, reason: collision with root package name */
    private final int f4844n = 2;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4845o = false;

    /* renamed from: p, reason: collision with root package name */
    private final Handler f4846p = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.1
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880049, "second request reason miss");
                try {
                    Object obj = message.obj;
                    if (obj instanceof com.mbridge.msdk.foundation.c.b) {
                        bVarB = (com.mbridge.msdk.foundation.c.b) obj;
                    }
                    if (message.arg1 == 2) {
                        com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f4838d.h(), d.this.f4838d.C(), d.this.f4838d.H(), d.this.f4838d.G(), MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
                    } else if (bVarB != null && bVarB.a((Object) "campaign_request_error_type") != null) {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f4838d.h(), d.this.f4838d.C(), d.this.f4838d.H(), d.this.f4838d.G(), ((Integer) bVarB.a((Object) "campaign_request_error_type")).intValue());
                    }
                } catch (Exception unused) {
                }
                d.this.f4836b.reqFailed(bVarB);
            }
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f4849b;

        /* renamed from: c, reason: collision with root package name */
        private final Map f4850c;

        public a(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f4849b = bVar;
            this.f4850c = map;
        }

        private void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            try {
                if (bVar.a() > 0) {
                    HashMap map = new HashMap();
                    map.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, bVar.a() + "");
                    map.put("invalid_ad_ids", d.this.f4838d.b());
                    this.f4850c.put("params_ext_map_key", map);
                    this.f4849b.a(this.f4850c);
                    int iA = bVar.a();
                    int iB = bVar.b();
                    int filterCallBackState = (bVar.E() == null || bVar.E().isEmpty()) ? 0 : bVar.E().get(0).getFilterCallBackState();
                    d dVar = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar.f4837c;
                    com.mbridge.msdk.newreward.a.e eVar = dVar.f4838d;
                    cVar.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_START, cVar.a("auto_load", Integer.valueOf(eVar.I() ? 2 : 1), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(d.this.f4838d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
                    com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
                    bVar2.a(this.f4849b);
                    d.this.f4845o = true;
                    d dVar2 = d.this;
                    dVar2.f4835a.a(bVar2, dVar2.new b(bVar2, this.f4850c));
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f4838d, dVar.f4837c, 1);
            if (d.this.e.a(eVar)) {
                d.this.e.a(eVar, this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
            if (d.this.f4840j) {
                return;
            }
            d.this.f4840j = true;
            try {
                d dVar2 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f4837c;
                com.mbridge.msdk.newreward.a.e eVar2 = dVar2.f4838d;
                cVar.a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_FAIL, cVar.a("auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), "result", Integer.valueOf(bVar.m() ? 1 : 2), "code", Integer.valueOf(bVar.i()), "reason", bVar.b(), "timeout", Integer.valueOf(d.this.f4838d.P()), "hst", bVar.j(), "err_desc", bVar.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((MBridgeOffsetManager) d.this.f4837c.a((Object) null, com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET)).resetOffset();
            if (bVar != null) {
                try {
                    if (bVar.a("campaign_request_error_type") != null) {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f4838d.h(), d.this.f4838d.C(), d.this.f4838d.H(), d.this.f4838d.G(), ((Integer) bVar.a("campaign_request_error_type")).intValue());
                    }
                } catch (Exception unused) {
                }
            }
            d.this.f4836b.reqFailed(bVar);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            int iA;
            int iB;
            int filterCallBackState;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.g);
            if (d.this.f4840j) {
                return;
            }
            d.this.f4840j = true;
            com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
            if (bVar != null) {
                iA = bVar.a();
                iB = bVar.b();
                filterCallBackState = (bVar.E() == null || bVar.E().isEmpty()) ? 0 : bVar.E().get(0).getFilterCallBackState();
            } else {
                iA = 0;
                iB = 0;
                filterCallBackState = 0;
            }
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.c cVar = dVar.f4837c;
            com.mbridge.msdk.newreward.a.e eVar = dVar.f4838d;
            cVar.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS, cVar.a("metrics_data", bVar, "auto_load", Integer.valueOf(eVar.I() ? 2 : 1), "result", 1, "cache", 2, "timeout", Integer.valueOf(d.this.f4838d.P()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState), "hst", bVar != null ? bVar.J() : ""));
            ((MBridgeOffsetManager) d.this.f4837c.a((Object) null, com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET)).increaseOffset(bVar.u().size());
            d dVar2 = d.this;
            com.mbridge.msdk.newreward.function.command.c cVar2 = dVar2.f4837c;
            cVar2.e(cVar2.a("adapter_model", dVar2.f4838d, "campaign", bVar));
            try {
                d dVar3 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar3 = dVar3.f4837c;
                cVar3.c(cVar3.a("adapter_model", dVar3.f4838d, "campaign", bVar));
            } catch (MBridgeError e) {
                com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
                if (e.getErrorMessage().contains("APP ALREADY INSTALLED")) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 403);
                    a(bVar);
                    d.this.f4836b.reqFailed(com.mbridge.msdk.foundation.c.a.a(e.getErrorCode(), 880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e.getErrorMessage()));
                    return;
                }
                if (!e.getErrorMessage().contains("FILTER BUT CALLBACK SUCCEED")) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 403);
                    d.this.f4836b.reqFailed(com.mbridge.msdk.foundation.c.a.a(e.getErrorCode(), 880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e.getErrorMessage()));
                    return;
                }
                a(bVar);
            }
            d dVar4 = d.this;
            dVar4.f4836b.reqSuccessful(dVar4.f4837c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1, "object", bVar));
            this.f4849b.a(com.mbridge.msdk.newreward.function.command.f.REQ_DOWN_CAMPAIGN);
            this.f4850c.put("campaign", bVar);
            this.f4849b.a(this.f4850c);
            d dVar5 = d.this;
            dVar5.f4835a.a(this.f4849b, new c());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class b implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f4852b;

        /* renamed from: c, reason: collision with root package name */
        private final Map f4853c;

        public b(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f4852b = bVar;
            this.f4853c = map;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f4838d, dVar.f4837c, 1);
            if (d.this.e.a(eVar)) {
                d.this.e.a(eVar, this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
            if (d.this.f4841k) {
                return;
            }
            d.this.f4841k = true;
            try {
                d dVar2 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f4837c;
                com.mbridge.msdk.newreward.a.e eVar2 = dVar2.f4838d;
                cVar.a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_FAIL, cVar.a("auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), "result", Integer.valueOf(bVar.m() ? 1 : 2), "code", Integer.valueOf(bVar.i()), "reason", bVar.b(), "timeout", Integer.valueOf(d.this.f4838d.P()), "hst", bVar.j(), "err_desc", bVar.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((MBridgeOffsetManager) d.this.f4837c.a((Object) null, com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET)).resetOffset();
            d.a(d.this, bVar, true, null);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            int iA;
            int iB;
            int filterCallBackState;
            com.mbridge.msdk.foundation.c.b bVarA;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.g);
            if (d.this.f4841k) {
                return;
            }
            d.this.f4841k = true;
            com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
            if (bVar != null) {
                iA = bVar.a();
                iB = bVar.b();
                filterCallBackState = (bVar.E() == null || bVar.E().isEmpty()) ? 0 : bVar.E().get(0).getFilterCallBackState();
            } else {
                iA = 0;
                iB = 0;
                filterCallBackState = 0;
            }
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.c cVar = dVar.f4837c;
            com.mbridge.msdk.newreward.a.e eVar = dVar.f4838d;
            cVar.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS, cVar.a("metrics_data", bVar, "auto_load", Integer.valueOf(eVar.I() ? 2 : 1), "result", 1, "cache", 2, "timeout", Integer.valueOf(d.this.f4838d.P()), "hst", bVar != null ? bVar.J() : "", com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
            ((MBridgeOffsetManager) d.this.f4837c.a((Object) null, com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET)).increaseOffset(bVar.u().size());
            d dVar2 = d.this;
            com.mbridge.msdk.newreward.function.command.c cVar2 = dVar2.f4837c;
            cVar2.e(cVar2.a("adapter_model", dVar2.f4838d, "campaign", bVar));
            try {
                d dVar3 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar3 = dVar3.f4837c;
                cVar3.d(cVar3.a("adapter_model", dVar3.f4838d, "campaign", bVar));
                d dVar4 = d.this;
                dVar4.f4836b.reqSuccessful(dVar4.f4837c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1, "object", bVar));
                this.f4852b.a(com.mbridge.msdk.newreward.function.command.f.REQ_DOWN_CAMPAIGN);
                this.f4853c.put("campaign", bVar);
                this.f4852b.a(this.f4853c);
                d dVar5 = d.this;
                dVar5.f4835a.a(this.f4852b, dVar5.new C0046d(bVar));
            } catch (MBridgeError e) {
                com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 403);
                if (e.getErrorMessage().contains("APP ALREADY INSTALLED")) {
                    bVarA = com.mbridge.msdk.foundation.c.a.a(e.getErrorCode(), 880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e.getErrorMessage());
                } else {
                    bVarA = com.mbridge.msdk.foundation.c.a.a(e.getErrorCode(), 880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e.getErrorMessage());
                }
                d.this.f4836b.reqFailed(bVarA);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class c implements com.mbridge.msdk.newreward.a.b.b {
        private c() {
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f4838d, dVar.f4837c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, null);
            } else {
                d.this.e.a(eVar, this);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            d.this.f4846p.removeMessages(1);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
            d dVar = d.this;
            dVar.f4836b.reqSuccessful(dVar.f4837c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2, "object", obj));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$d, reason: collision with other inner class name */
    public class C0046d implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.c.a.b f4856b;

        public C0046d(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            this.f4856b = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f4838d, dVar.f4837c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, this.f4856b);
            } else {
                d.this.e.a(eVar, this);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            d.this.f4846p.removeMessages(1);
            com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4856b;
            if (bVar != null && bVar.a() == 0) {
                this.f4856b.c(3);
                d.this.f4838d.D().a(this.f4856b);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4856b);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f);
            d dVar = d.this;
            dVar.f4836b.reqSuccessful(dVar.f4837c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2, "object", obj));
        }
    }

    private int b() {
        com.mbridge.msdk.newreward.function.e.f fVarX;
        com.mbridge.msdk.videocommon.d.c cVarB;
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.f4838d;
            return (eVar == null || (fVarX = eVar.x()) == null || (cVarB = fVarX.b()) == null) ? MBridgeCommon.DEFAULT_LOAD_TIMEOUT : cVarB.F() * 1000;
        } catch (Exception unused) {
            return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        }
    }

    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        try {
            this.f4836b = bVar2;
            int iB = b();
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f, iB, this);
            bVar.a(com.mbridge.msdk.newreward.function.command.f.REQ_CAMPAIGN);
            Map map = (Map) bVar.b();
            this.f4839i = map;
            this.f4837c = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) this.f4839i.get("adapter_model");
            this.f4838d = eVar;
            eVar.g(iB);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f4837c;
            com.mbridge.msdk.newreward.a.e eVar2 = this.f4838d;
            cVar.a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_START, cVar.a("auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(this.f4838d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
            this.f4835a.a(bVar, new a(bVar, this.f4839i));
            long jA = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_RETRY_TIMEOUT, 0);
            this.h = jA;
            if (jA > 0) {
                com.mbridge.msdk.newreward.a.c.a.a().a(this.g, this.h, this);
            }
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4838d.h(), this.f4838d.C(), this.f4838d.H(), this.f4838d.G(), !TextUtils.isEmpty(this.f4838d.J()), this.f4838d.J(), this.f4838d.T());
        } catch (Exception e) {
            af.b("LoadControllerReceiver", "action", e);
            if (this.f4838d != null) {
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4838d.h(), this.f4838d.C(), this.f4838d.H(), this.f4838d.G(), 8);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(this.g);
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f);
            if (bVar2 != null) {
                bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f4835a = aVar;
        this.e = new com.mbridge.msdk.newreward.function.command.receiver.a.c(aVar);
    }

    @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0041a
    public final void a(String str, long j10) {
        if (TextUtils.equals(str, this.f)) {
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4838d.h(), this.f4838d.C(), this.f4838d.H(), this.f4838d.G(), MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT);
            this.f4836b.reqFailed(new com.mbridge.msdk.foundation.c.b(880010, a3.a.i("errorCode: 3401 errorMessage: ", a())));
        } else {
            if (!TextUtils.equals(str, this.g) || this.e == null) {
                return;
            }
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(null, this.f4838d, this.f4837c, 3);
            com.mbridge.msdk.newreward.function.command.b bVar = new com.mbridge.msdk.newreward.function.command.b();
            bVar.a(com.mbridge.msdk.newreward.function.command.f.REQ_CAMPAIGN);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f4837c;
            bVar.a(cVar.a("adapter_model", this.f4838d, "command_manager", cVar));
            this.e.a(eVar, new a(bVar, this.f4839i));
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.f4838d;
            if (eVar != null && eVar.D() != null) {
                com.mbridge.msdk.newreward.function.c.a.b bVarB = this.f4838d.D().b();
                if (bVarB != null && bVarB.u() != null && bVarB.u().size() > 0) {
                    for (com.mbridge.msdk.newreward.function.c.a.a aVar : bVarB.u()) {
                        if (aVar != null) {
                            n nVarD = aVar.d();
                            if (nVarD != null && !nVarD.d()) {
                                sb.append(" video timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> dVarC = aVar.c();
                            if (dVarC != null && !dVarC.d()) {
                                sb.append(" video_template timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> dVarF = aVar.f();
                            if (dVarF != null && !dVarF.d()) {
                                sb.append(" ec_template timeout ");
                            }
                        }
                    }
                } else {
                    sb.append(" load timeout ");
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ void a(d dVar, com.mbridge.msdk.foundation.c.b bVar, boolean z9, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        com.mbridge.msdk.newreward.a.e eVar = dVar.f4838d;
        if (eVar != null && eVar.D() != null && dVar.f4838d.D().b() != null && dVar.f4838d.D().b().a() != 0 && dVar.f4845o) {
            if (!dVar.f4846p.hasMessages(1)) {
                Message messageObtainMessage = dVar.f4846p.obtainMessage(1);
                messageObtainMessage.obj = bVar;
                messageObtainMessage.arg1 = z9 ? 1 : 2;
                dVar.f4846p.sendMessageDelayed(messageObtainMessage, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                return;
            }
        }
        if (!z9) {
            if (bVar2 != null && bVar2.a() == 0) {
                dVar.f4838d.D().a(bVar2);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar2);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(dVar.f);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f4838d.h(), dVar.f4838d.C(), dVar.f4838d.H(), dVar.f4838d.G(), MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
        } else if (bVar != null) {
            try {
                if (bVar.a("campaign_request_error_type") != null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f4838d.h(), dVar.f4838d.C(), dVar.f4838d.H(), dVar.f4838d.G(), ((Integer) bVar.a("campaign_request_error_type")).intValue());
                }
            } catch (Exception unused) {
            }
        }
        dVar.f4836b.reqFailed(bVar);
    }
}
