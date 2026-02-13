package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class j extends a<com.mbridge.msdk.foundation.entity.g> {

    /* renamed from: a, reason: collision with root package name */
    private static j f3479a;

    private j(f fVar) {
        super(fVar);
    }

    private synchronized long b(com.mbridge.msdk.foundation.entity.g gVar) {
        try {
            com.mbridge.msdk.foundation.db.a.a.a().a(gVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", gVar.a());
            contentValues.put("fc_a", Integer.valueOf(gVar.c()));
            contentValues.put("fc_b", Integer.valueOf(gVar.d()));
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(gVar.f()));
            contentValues.put("impression_count", Integer.valueOf(gVar.e()));
            contentValues.put("click_count", Integer.valueOf(gVar.b()));
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(gVar.f()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            return getWritableDatabase().insert("frequence", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized void a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - 86400000;
            com.mbridge.msdk.foundation.db.a.a.a().a(jCurrentTimeMillis);
            String[] strArr = {String.valueOf(jCurrentTimeMillis)};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("frequence", "ts< ? ", strArr);
            }
        } catch (Exception unused) {
        }
    }

    public static j a(f fVar) {
        if (f3479a == null) {
            synchronized (j.class) {
                try {
                    if (f3479a == null) {
                        f3479a = new j(fVar);
                    }
                } finally {
                }
            }
        }
        return f3479a;
    }

    public final synchronized void a(String str) {
        com.mbridge.msdk.foundation.db.a.a.a().a(str);
        if (b(str) && getReadableDatabase() != null) {
            getReadableDatabase().execSQL("UPDATE frequence Set impression_count=impression_count+1 WHERE id= ?", new Object[]{str});
        }
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.g gVar) {
        if (!b(gVar.a())) {
            b(gVar);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final synchronized boolean b(String str) {
        Cursor cursor = null;
        try {
            try {
                synchronized (str) {
                    Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE id= ?", new String[]{str});
                    if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                        cursorRawQuery.close();
                        return true;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return false;
                }
            } catch (Exception unused) {
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
