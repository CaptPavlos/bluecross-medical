package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3476a = "com.mbridge.msdk.foundation.db.h";

    /* renamed from: b, reason: collision with root package name */
    private static h f3477b;

    private h(f fVar) {
        super(fVar);
    }

    private synchronized boolean b(String str) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id= ?", new String[]{str});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void c(String str) {
        try {
        } catch (Throwable unused) {
            af.c(f3476a, "resetTimeAndTimestamp error");
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_insert_timestamp", (Integer) 0);
        contentValues.put("play_time", (Integer) 0);
        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = ?", new String[]{str});
    }

    public final synchronized void a(String str) {
        long j10;
        long j11;
        Cursor cursorRawQuery = null;
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                if (0 != 0) {
                }
            }
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b(str)) {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id = ?", new String[]{str});
                if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                    j10 = 0;
                    j11 = 0;
                } else {
                    cursorRawQuery.moveToFirst();
                    j10 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                    j11 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                    if (jCurrentTimeMillis - 86400000 > j10) {
                        c(str);
                        j11 = 0;
                    }
                }
                if (j10 == 0) {
                    contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                }
                contentValues.put("play_time", Long.valueOf(j11 + 1));
                getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = ?", new String[]{str});
            } else {
                contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                contentValues.put("play_time", (Long) 1L);
                contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                getWritableDatabase().insert("dailyplaycap", null, contentValues);
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static h a(f fVar) {
        if (f3477b == null) {
            synchronized (h.class) {
                try {
                    if (f3477b == null) {
                        f3477b = new h(fVar);
                    }
                } finally {
                }
            }
        }
        return f3477b;
    }

    public final boolean a(String str, int i10) {
        Cursor cursorRawQuery = null;
        boolean z9 = false;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id = ?", new String[]{str});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                long j10 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                long j11 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                if (j10 != 0) {
                    if (System.currentTimeMillis() - 86400000 > j10) {
                        c(str);
                    } else if (i10 > 0 && j11 >= i10) {
                        z9 = true;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                af.c(f3476a, "isOverCap is error" + th);
                if (cursorRawQuery != null) {
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Throwable unused2) {
            }
        }
        return z9;
    }
}
