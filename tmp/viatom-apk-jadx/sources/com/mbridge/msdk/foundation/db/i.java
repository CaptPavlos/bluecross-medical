package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends a<com.mbridge.msdk.foundation.entity.f> {

    /* renamed from: a, reason: collision with root package name */
    private static i f3478a;

    private i(f fVar) {
        super(fVar);
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.f fVar) {
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getWritableDatabase() == null) {
                return;
            }
            if (fVar != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", fVar.a());
                contentValues.put("time", Long.valueOf(fVar.b()));
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, fVar.d());
                contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(fVar.c()));
                if (a(fVar.d(), fVar.a())) {
                    getWritableDatabase().update("fq_info", contentValues, "id = ? AND unitId = ? ", new String[]{fVar.a(), fVar.d()});
                } else {
                    getWritableDatabase().insert("fq_info", null, contentValues);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(String str) {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 86400000), str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("fq_info", "time< ? and unitId=?", strArr);
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized i a(f fVar) {
        try {
            if (f3478a == null) {
                f3478a = new i(fVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3478a;
    }

    private synchronized boolean a(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("select id from fq_info where unitId= ?  and id= ? ", new String[]{str, str2});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
