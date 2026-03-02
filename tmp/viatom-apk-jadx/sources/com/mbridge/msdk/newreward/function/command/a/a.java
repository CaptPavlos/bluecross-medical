package com.mbridge.msdk.newreward.function.command.a;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.h;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.k;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends com.mbridge.msdk.newreward.function.command.a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f4757a = new HashMap();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.a.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4758a;

        static {
            int[] iArr = new int[f.values().length];
            f4758a = iArr;
            try {
                iArr[f.CHECK_IS_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4758a[f.CHECK_CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4758a[f.CHECK_CAMPAIGN_EXCLUDE_INS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4758a[f.HANDLER_ALREADY_INSTALL_CAMPAIGN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4758a[f.CREATE_OFFSET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4758a[f.CREATE_DAILY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4758a[f.CREATE_BIDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4758a[f.SHOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4758a[f.CHECK_IS_REQUEST_CONTROL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4758a[f.UPDATE_CAM_TOKEN_RULE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4758a[f.START_LOAD_CHECK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4758a[f.CANDIDATE_LOAD_ACTION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4758a[f.REQ_SETTING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4758a[f.REQ_CAMPAIGN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4758a[f.REQ_DOWN_CAMPAIGN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4758a[f.RESTORE_DB.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4758a[f.SMART_LOAD.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4758a[f.NORMAL_LOAD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4758a[f.PRE_HANDLE_LOAD.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4758a[f.UNIT_INIT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mbridge.msdk.newreward.function.command.a
    public final e a(com.mbridge.msdk.newreward.function.command.b bVar) {
        List<CampaignEx> listA;
        com.mbridge.msdk.newreward.function.e.a aVarD;
        e eVar = new e();
        switch (AnonymousClass1.f4758a[bVar.a().ordinal()]) {
            case 1:
                eVar.a(((com.mbridge.msdk.newreward.a.e) bVar.b()).D().c());
                return eVar;
            case 2:
                Map map = (Map) bVar.b();
                try {
                    ((com.mbridge.msdk.newreward.a.e) map.get("adapter_model")).D().a((com.mbridge.msdk.newreward.function.c.a.b) map.get("campaign"), false);
                    eVar.a(true);
                    return eVar;
                } catch (MBridgeError e) {
                    eVar.a(false);
                    eVar.a(e);
                    break;
                }
            case 3:
                Map map2 = (Map) bVar.b();
                try {
                    ((com.mbridge.msdk.newreward.a.e) map2.get("adapter_model")).D().a((com.mbridge.msdk.newreward.function.c.a.b) map2.get("campaign"), true);
                    eVar.a(true);
                    return eVar;
                } catch (MBridgeError e3) {
                    eVar.a(false);
                    eVar.a(e3);
                    break;
                }
            case 4:
                Map map3 = (Map) bVar.b();
                ((com.mbridge.msdk.newreward.a.e) map3.get("adapter_model")).D().b((com.mbridge.msdk.newreward.function.c.a.b) map3.get("campaign"));
                return eVar;
            case 5:
                a(bVar, eVar, TypedValues.CycleType.S_WAVE_OFFSET);
                return eVar;
            case 6:
                a(bVar, eVar, "daily");
                return eVar;
            case 7:
                a(bVar, eVar, "bridge_ids");
                return eVar;
            case 8:
                new h().a(bVar);
                return eVar;
            case 9:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.f fVar = (com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.f) d.a().c(f.CHECK_IS_REQUEST_CONTROL);
                if (fVar != null) {
                    try {
                        eVar.a(fVar.a(bVar.b()));
                        return eVar;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                return eVar;
            case 10:
                if (((k) d.a().c(f.UPDATE_CAM_TOKEN_RULE)) != null) {
                    try {
                        Object objB = bVar.b();
                        Map map4 = null;
                        Map map5 = objB instanceof Map ? (Map) objB : null;
                        if (map5 != null) {
                            com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map5.get("adapter_model");
                            com.mbridge.msdk.newreward.function.e.a aVarD2 = ((com.mbridge.msdk.newreward.a.e) map5.get("queue_first_adapter_model")).D();
                            if (aVarD2 != null && (listA = aVarD2.a()) != null && listA.size() != 0) {
                                String encryptPrice = listA.get(0).getEncryptPrice();
                                if (!TextUtils.isEmpty(encryptPrice) && (aVarD = eVar2.D()) != null && aVarD.a() != null && aVarD.a().size() != 0) {
                                    List<CampaignEx> listA2 = eVar2.D().a();
                                    HashMap map6 = new HashMap();
                                    map6.put("encrypt_p=", "encrypt_p=" + encryptPrice);
                                    map6.put("irlfa=", "irlfa=1");
                                    for (CampaignEx campaignEx : listA2) {
                                        for (Map.Entry entry : map6.entrySet()) {
                                            String str = (String) entry.getKey();
                                            String str2 = (String) entry.getValue();
                                            if (campaignEx != null) {
                                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str, str2));
                                                campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll(str, str2));
                                            }
                                        }
                                    }
                                    map4 = map5;
                                }
                            }
                        }
                        eVar.a(map4);
                        return eVar;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                return eVar;
            case 11:
                ((com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.c) d.a().c(f.START_LOAD_CHECK)).a(bVar.b());
                return eVar;
            case 12:
                eVar.a(((com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.a) d.a().c(f.CANDIDATE_LOAD_ACTION)).a(bVar.b()));
                return eVar;
            default:
                return eVar;
        }
    }

    private void a(com.mbridge.msdk.newreward.function.command.b bVar, e eVar, String str) {
        if (bVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.b bVar2 = new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.b();
        Map map = (Map) bVar.b();
        if (map == null) {
            map = new HashMap();
        }
        map.put("obj_map", this.f4757a);
        map.put("result", eVar);
        map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        bVar2.a(map);
    }

    @Override // com.mbridge.msdk.newreward.function.command.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.a.e eVar = bVar.b() instanceof com.mbridge.msdk.newreward.a.e ? (com.mbridge.msdk.newreward.a.e) bVar.b() : null;
        switch (AnonymousClass1.f4758a[bVar.a().ordinal()]) {
            case 13:
                if (eVar == null) {
                    new com.mbridge.msdk.newreward.function.e.f().a(com.mbridge.msdk.newreward.function.f.c.a().a(bVar, bVar.a()), bVar2);
                    break;
                } else {
                    eVar.x().a(com.mbridge.msdk.newreward.function.f.c.a().a(bVar, bVar.a()), bVar2);
                    break;
                }
            case 14:
                com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) ((Map) bVar.b()).get("adapter_model");
                eVar2.D().a(eVar2, com.mbridge.msdk.newreward.function.f.c.a().a(bVar.b(), bVar.a()), bVar2);
                break;
            case 15:
                Map<? extends String, ? extends Object> map = (Map) bVar.b();
                com.mbridge.msdk.newreward.a.e eVar3 = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
                com.mbridge.msdk.newreward.function.c.a.b bVar3 = (com.mbridge.msdk.newreward.function.c.a.b) map.get("campaign");
                bVar3.H().putAll(map);
                eVar3.F().a(bVar3, bVar2);
                break;
            case 16:
                d.a().b(f.RESTORE_DB).a(bVar, bVar2);
                break;
            case 17:
                bVar.b();
                d.a().b(f.SMART_LOAD).a(bVar, bVar2);
                break;
            case 18:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d dVar = (com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d) d.a().b(f.NORMAL_LOAD);
                dVar.a(this);
                dVar.a(bVar, bVar2);
                break;
            case 19:
                d.a().b(f.PRE_HANDLE_LOAD).a(bVar, bVar2);
                break;
            case 20:
                d.a().b(f.UNIT_INIT).a(bVar, bVar2);
                break;
        }
    }
}
