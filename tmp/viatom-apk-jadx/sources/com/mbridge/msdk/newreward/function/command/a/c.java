package com.mbridge.msdk.newreward.function.command.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.MoreOfferPreSendTrackingReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.DoReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.NewShowReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.OMSDKReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.PlayFrequenceReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.SharePreReceiver;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends com.mbridge.msdk.newreward.function.command.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f4760a = "ShowCommand";

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.receiver.c f4761b = new com.mbridge.msdk.newreward.function.command.receiver.c();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.a.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4762a;

        static {
            int[] iArr = new int[f.values().length];
            f4762a = iArr;
            try {
                iArr[f.TEMP_PLAYER_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4762a[f.TEMP_PLAY_START_COUNT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4762a[f.TEMP_PLAY_PROGRESS_COUNT_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4762a[f.CAMPAIGN_REDIRECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4762a[f.SHOW_ADD_TEMPLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4762a[f.SHOW_LIFE_CYCLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4762a[f.SHOW_OR_PRELOAD_WEB_EC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4762a[f.SHOW_OR_PRELOAD_WEB_TEMPLATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4762a[f.ADD_SHAKE_VIEW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4762a[f.ADD_BAIT_CLICK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4762a[f.REQ_MORE_OFFER_CAMPAIGN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4762a[f.BUILD_MORE_OFFER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mbridge.msdk.newreward.function.command.a
    public final <T extends e> T a(com.mbridge.msdk.newreward.function.command.b bVar) {
        Map map;
        T t = (T) new e();
        switch (AnonymousClass1.f4762a[bVar.a().ordinal()]) {
            case 1:
            case 2:
            case 3:
                com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f fVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f) d.a().c(bVar.a());
                if (fVar != null) {
                    try {
                        t.a(fVar.a(bVar.b()));
                        return t;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return t;
            case 4:
                d.a().a(f.CAMPAIGN_REDIRECT).a(bVar.b());
                return t;
            case 5:
                d.a().a(f.SHOW_ADD_TEMPLE).a(bVar.b());
                return t;
            case 6:
                d.a().a(f.SHOW_LIFE_CYCLE).a(bVar.b());
                return t;
            case 7:
                d.a().a(f.SHOW_OR_PRELOAD_WEB_EC).a(bVar.b());
                return t;
            case 8:
                try {
                    if ((bVar.b() instanceof Map) && (map = (Map) bVar.b()) != null && !map.isEmpty()) {
                        Object obj = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (obj instanceof String) {
                            d.a().a(f.SHOW_OR_PRELOAD_WEB_TEMPLATE, (String) obj).a(bVar.b());
                            return t;
                        }
                    }
                } catch (Throwable th) {
                    af.b("ShowCommand", th.getMessage());
                }
                return t;
            case 9:
            case 10:
                com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c cVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c) d.a().c(bVar.a());
                if (cVar != null) {
                    try {
                        t.a(cVar.a(bVar.b()));
                        return t;
                    } catch (Exception e3) {
                        af.b("ShowCommand", e3.getMessage());
                    }
                }
                return t;
            default:
                return t;
        }
    }

    @Override // com.mbridge.msdk.newreward.function.command.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e eVar;
        int i10 = AnonymousClass1.f4762a[bVar.a().ordinal()];
        if (i10 == 5) {
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d dVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d) d.a().b(bVar.a());
            if (dVar != null) {
                dVar.a(bVar, bVar2);
                return;
            }
            return;
        }
        if (i10 != 11) {
            if (i10 == 12 && (eVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e) d.a().b(bVar.a())) != null) {
                eVar.a(bVar, bVar2);
                return;
            }
            return;
        }
        Object objB = bVar.b();
        if (!(objB instanceof Map)) {
            if (bVar2 != null) {
                bVar2.reqFailed(com.mbridge.msdk.foundation.c.a.b(990001, com.mbridge.msdk.foundation.c.a.a(990001)));
            }
        } else {
            Map map = (Map) objB;
            com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            eVar2.E().a(((Integer) map.get("more_offer_type")).intValue(), eVar2, (CampaignEx) map.get("campaign"), com.mbridge.msdk.newreward.function.f.c.a().a(bVar.b(), bVar.a()), bVar2);
        }
    }

    @Override // com.mbridge.msdk.newreward.function.command.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, String str) {
        com.mbridge.msdk.newreward.function.command.receiver.b reportReceiver;
        super.a(bVar, str);
        if (str != null) {
            if ("SharePreReceiver".equals(str)) {
                reportReceiver = new SharePreReceiver();
            } else if ("NewShowReceiver".equals(str)) {
                reportReceiver = new NewShowReceiver();
            } else if ("PlayFrequenceReceiver".equals(str)) {
                reportReceiver = new PlayFrequenceReceiver();
            } else if ("DoReceiver".equals(str)) {
                reportReceiver = new DoReceiver();
            } else if ("OMSDKReceiver".equals(str)) {
                reportReceiver = new OMSDKReceiver();
            } else if ("MoreOfferPreSendTrackingReceiver".equals(str)) {
                reportReceiver = new MoreOfferPreSendTrackingReceiver();
            } else if ("ReportReceiver".equals(str)) {
                reportReceiver = new ReportReceiver();
            } else {
                com.google.gson.internal.a.n("Unknown id = ".concat(str));
                return;
            }
            reportReceiver.a(bVar.b());
            return;
        }
        com.google.gson.internal.a.n("id is null!");
    }
}
