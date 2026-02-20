package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f4994a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.f.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4995a;

        static {
            int[] iArr = new int[f.values().length];
            f4995a = iArr;
            try {
                iArr[f.REQ_SETTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4995a[f.REQ_CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4995a[f.REQ_MORE_OFFER_CAMPAIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private c() {
    }

    public final <T extends a> a a(Object obj, f fVar) {
        int i10 = AnonymousClass1.f4995a[fVar.ordinal()];
        if (i10 == 1) {
            d dVar = new d();
            com.mbridge.msdk.newreward.function.command.b bVar = (com.mbridge.msdk.newreward.function.command.b) obj;
            if (bVar.b() instanceof Map) {
                Map map = (Map) bVar.b();
                dVar.a(((Integer) map.get("mb_ad_type")).intValue());
                dVar.a((String) map.get("mb_ad_unit_id"));
            }
            return dVar;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            b bVar2 = new b();
            if (obj instanceof Map) {
                bVar2.a((CampaignEx) ((Map) obj).get("campaign"));
            }
            return bVar2;
        }
        Map map2 = (Map) obj;
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map2.get("adapter_model");
        MBridgeOffsetManager mBridgeOffsetManager = (MBridgeOffsetManager) ((com.mbridge.msdk.newreward.function.command.c) map2.get("command_manager")).a((Object) null, f.CREATE_OFFSET);
        if (mBridgeOffsetManager == null) {
            eVar.a(0);
        } else {
            eVar.a(mBridgeOffsetManager.getOffset());
        }
        e eVar2 = new e(eVar.h(), eVar.C(), eVar.H(), !TextUtils.isEmpty(eVar.J()), eVar.J());
        eVar2.a(eVar.L());
        eVar2.e(eVar.G());
        eVar2.c(eVar.M());
        eVar2.b(eVar.N());
        eVar2.a(eVar.n());
        if (com.mbridge.msdk.e.b.a()) {
            eVar.H();
            com.mbridge.msdk.foundation.controller.c.m().c();
            TextUtils.isEmpty("");
            eVar2.c("");
        }
        String strA = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), eVar.H());
        if (TextUtils.isEmpty(strA)) {
            strA = "";
        }
        eVar2.a(strA);
        eVar2.b("");
        eVar2.d(TextUtils.isEmpty(MBridgeGlobalCommon.SESSION_ID) ? "" : MBridgeGlobalCommon.SESSION_ID);
        Object obj2 = map2.get("params_ext_map_key");
        if (obj2 instanceof Map) {
            eVar2.a((Map<String, String>) obj2);
        }
        return eVar2;
    }

    public static c a() {
        if (f4994a == null) {
            synchronized (c.class) {
                try {
                    if (f4994a == null) {
                        f4994a = new c();
                    }
                } finally {
                }
            }
        }
        return f4994a;
    }
}
