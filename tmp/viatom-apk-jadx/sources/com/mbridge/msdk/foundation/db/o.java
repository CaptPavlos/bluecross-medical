package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import java.net.URLEncoder;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class o extends a<com.mbridge.msdk.foundation.entity.n> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3485a = "com.mbridge.msdk.foundation.db.o";

    /* renamed from: b, reason: collision with root package name */
    private static o f3486b;

    private o(f fVar) {
        super(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x033e A[Catch: all -> 0x0318, Exception -> 0x034a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x034a, blocks: (B:107:0x033e, B:99:0x0321), top: B:123:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0344 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.n> a(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.o.a(java.lang.String):java.util.List");
    }

    public final synchronized int a() {
        int i10;
        i10 = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from reward_report", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i10 = cursorRawQuery.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                }
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        return i10;
    }

    public static o a(f fVar) {
        if (f3486b == null) {
            synchronized (o.class) {
                try {
                    if (f3486b == null) {
                        f3486b = new o(fVar);
                    }
                } finally {
                }
            }
        }
        return f3486b;
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.n nVar) {
        try {
            if (nVar != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key", nVar.a());
                    contentValues.put("networkType", Integer.valueOf(nVar.k()));
                    contentValues.put("network_str", nVar.l());
                    contentValues.put("isCompleteView", Integer.valueOf(nVar.z()));
                    contentValues.put("watchedMillis", Integer.valueOf(nVar.A()));
                    contentValues.put("videoLength", Integer.valueOf(nVar.p()));
                    if (!TextUtils.isEmpty(nVar.r())) {
                        contentValues.put("offerUrl", nVar.r());
                    }
                    if (!TextUtils.isEmpty(nVar.h())) {
                        contentValues.put("reason", URLEncoder.encode(nVar.h(), "utf-8"));
                    }
                    contentValues.put("result", Integer.valueOf(nVar.m()));
                    contentValues.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                    contentValues.put("videoSize", Long.valueOf(nVar.o()));
                    contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                    String strS = nVar.s();
                    if (!TextUtils.isEmpty(strS)) {
                        contentValues.put(CampaignEx.ENDCARD_URL, strS);
                    }
                    String strQ = nVar.q();
                    if (!TextUtils.isEmpty(strQ)) {
                        contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, strQ);
                    }
                    String strF = nVar.f();
                    if (!TextUtils.isEmpty(strF)) {
                        contentValues.put("rid", strF);
                    }
                    String strG = nVar.g();
                    if (!TextUtils.isEmpty(strG)) {
                        contentValues.put("rid_n", strG);
                    }
                    String strD = nVar.D();
                    if (!TextUtils.isEmpty(strD)) {
                        contentValues.put("template_url", strD);
                    }
                    String strY = nVar.y();
                    if (!TextUtils.isEmpty(strY)) {
                        contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, strY);
                    }
                    String strD2 = nVar.d();
                    if (!TextUtils.isEmpty(strD2)) {
                        contentValues.put("ad_type", URLEncoder.encode(strD2, "utf-8"));
                    }
                    contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, nVar.c());
                    contentValues.put("campaignId", nVar.e());
                    if ("2000039".equals(nVar.a())) {
                        String strA = com.mbridge.msdk.foundation.same.report.n.a(nVar);
                        if (ap.b(strA)) {
                            contentValues.put("h5_click_data", strA);
                        }
                    }
                    String strB = nVar.b();
                    if (!TextUtils.isEmpty(strB)) {
                        contentValues.put("resource_type", URLEncoder.encode(strB, "utf-8"));
                    }
                    String strJ = nVar.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        contentValues.put("device_id", URLEncoder.encode(strJ, "utf-8"));
                    }
                    String strI = nVar.i();
                    if (!TextUtils.isEmpty(strI)) {
                        contentValues.put("creative", URLEncoder.encode(strI, "utf-8"));
                    }
                    contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(nVar.u()));
                    return getWritableDatabase().insert("reward_report", null, contentValues);
                } catch (Exception e) {
                    af.b(f3485a, e.getMessage());
                }
            }
            return -1L;
        } catch (Throwable th) {
            throw th;
        }
    }
}
