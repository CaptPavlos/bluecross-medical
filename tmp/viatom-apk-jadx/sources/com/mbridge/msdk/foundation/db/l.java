package com.mbridge.msdk.foundation.db;

import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: a, reason: collision with root package name */
    private static l f3482a;

    private l(f fVar) {
        super(fVar);
    }

    public final synchronized List<com.mbridge.msdk.foundation.entity.l> a(int i10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        cursor = null;
        try {
            try {
                b(5);
                Cursor cursorQuery = getReadableDatabase().query("reporterror", null, null, null, null, null, null, i10 + "");
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(DataSchemeDataSource.SCHEME_DATA));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("method"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        int i11 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                                        long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                                        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l(string, string3, string2, string4);
                                        lVar.a(i11 + 1);
                                        lVar.a(j10);
                                        arrayList.add(lVar);
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        arrayList2 = arrayList;
                                        return arrayList2;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e7) {
                e = e7;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList2;
    }

    public final synchronized int b() {
        int count;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null, null);
                count = cursorQuery.getCount();
                cursorQuery.close();
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        return count;
    }

    private synchronized int b(int i10) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return getWritableDatabase().rawQuery("DELETE FROM reporterror WHERE count >= ?", new String[]{String.valueOf(i10)}).getCount();
    }

    public final synchronized void a(String str, String str2, long j10) {
        if (str == null) {
            str = "";
        }
        try {
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().execSQL("DELETE from reporterror where url= ? and data= ? and time_stamp= ? or count > ?", new Object[]{str2, str, String.valueOf(j10), 5});
    }

    public final synchronized int a() {
        int i10;
        i10 = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i10 = cursorQuery.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return i10;
    }

    public static l a(f fVar) {
        if (f3482a == null) {
            synchronized (l.class) {
                try {
                    if (f3482a == null) {
                        f3482a = new l(fVar);
                    }
                } finally {
                }
            }
        }
        return f3482a;
    }

    public final synchronized int a(String str) {
        try {
            String[] strArr = {str};
            if (getWritableDatabase() == null) {
                return -1;
            }
            return getWritableDatabase().delete("reporterror", "url=?", strArr);
        } catch (Exception unused) {
            return -1;
        }
    }
}
