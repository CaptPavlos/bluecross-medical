package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class m extends a<com.mbridge.msdk.foundation.entity.h> {

    /* renamed from: a, reason: collision with root package name */
    private static m f3483a;

    private m(f fVar) {
        super(fVar);
    }

    public final synchronized List<com.mbridge.msdk.foundation.entity.i> a(int i10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getReadableDatabase().rawQuery("select * from unit_id WHERE ad_type = ?", new String[]{String.valueOf(i10)});
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                arrayList = new ArrayList(cursorRawQuery.getCount());
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        arrayList.add(new com.mbridge.msdk.foundation.entity.i(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("placement_id")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID)), i10));
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorRawQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                            }
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
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
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

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i10) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("placement_id", str);
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
        contentValues.put("ad_type", Integer.valueOf(i10));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }

    public static m a(f fVar) {
        if (f3483a == null) {
            synchronized (m.class) {
                try {
                    if (f3483a == null) {
                        f3483a = new m(fVar);
                    }
                } finally {
                }
            }
        }
        return f3483a;
    }
}
