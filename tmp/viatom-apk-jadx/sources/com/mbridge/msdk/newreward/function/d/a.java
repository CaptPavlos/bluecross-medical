package com.mbridge.msdk.newreward.function.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.DatabaseUtils;
import com.mbridge.msdk.newreward.function.common.JSONUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f4911a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4912b = new Object();

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f4911a = sQLiteDatabase;
    }

    private static List<com.mbridge.msdk.newreward.function.c.a.b> a(Cursor cursor) {
        List<com.mbridge.msdk.newreward.function.c.a.b> list;
        Cursor cursor2 = cursor;
        if (cursor2 == null || cursor2.getCount() <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int columnIndex = cursor2.getColumnIndex("ad_type");
            int columnIndex2 = cursor2.getColumnIndex(MBridgeConstans.APP_ID);
            int columnIndex3 = cursor2.getColumnIndex("placement_id");
            int columnIndex4 = cursor2.getColumnIndex(MBridgeConstans.PROPERTIES_UNIT_ID);
            int columnIndex5 = cursor2.getColumnIndex("request_id");
            int columnIndex6 = cursor2.getColumnIndex("local_id");
            int columnIndex7 = cursor2.getColumnIndex("bid_token");
            int columnIndex8 = cursor2.getColumnIndex("header_bidding");
            int columnIndex9 = cursor2.getColumnIndex("load_start_time");
            int columnIndex10 = cursor2.getColumnIndex("backup_id");
            int columnIndex11 = cursor2.getColumnIndex(MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex12 = cursor2.getColumnIndex("template");
            int columnIndex13 = cursor2.getColumnIndex("invalid_time");
            list = null;
            try {
                int columnIndex14 = cursor2.getColumnIndex("invalid_time_2");
                ArrayList arrayList2 = arrayList;
                int columnIndex15 = cursor2.getColumnIndex("invalid_time_backup");
                int columnIndex16 = cursor2.getColumnIndex("ecppv");
                int columnIndex17 = cursor2.getColumnIndex("session_id");
                int i10 = columnIndex14;
                int columnIndex18 = cursor2.getColumnIndex("system_id");
                int i11 = columnIndex13;
                int columnIndex19 = cursor2.getColumnIndex("show_count");
                int columnIndex20 = cursor2.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID);
                int columnIndex21 = cursor2.getColumnIndex(DataSchemeDataSource.SCHEME_DATA);
                int columnIndex22 = cursor2.getColumnIndex("token_rule");
                int columnIndex23 = cursor2.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX);
                int columnIndex24 = cursor2.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX);
                while (cursor2.moveToNext()) {
                    int i12 = columnIndex24;
                    int i13 = columnIndex;
                    int i14 = columnIndex2;
                    int i15 = columnIndex3;
                    int i16 = columnIndex4;
                    com.mbridge.msdk.newreward.function.c.a.b bVar = new com.mbridge.msdk.newreward.function.c.a.b(cursor2.getInt(columnIndex), cursor2.getString(columnIndex2), cursor2.getString(columnIndex3), cursor2.getString(columnIndex4));
                    bVar.a(cursor2.getString(columnIndex5));
                    bVar.b(cursor2.getString(columnIndex6));
                    String string = cursor2.getString(columnIndex7);
                    bVar.c(string);
                    boolean z9 = true;
                    if (cursor2.getInt(columnIndex8) != 1) {
                        z9 = false;
                    }
                    bVar.a(z9);
                    bVar.e(cursor2.getLong(columnIndex9));
                    bVar.d(cursor2.getString(columnIndex17));
                    bVar.e(cursor2.getString(columnIndex18));
                    bVar.f(cursor2.getString(columnIndex10));
                    bVar.c(cursor2.getInt(columnIndex11));
                    bVar.d(cursor2.getInt(columnIndex12));
                    int i17 = columnIndex18;
                    int i18 = columnIndex17;
                    int i19 = i11;
                    bVar.b(cursor2.getLong(i19));
                    i11 = i19;
                    int i20 = i10;
                    bVar.c(cursor2.getLong(i20));
                    i10 = i20;
                    int i21 = columnIndex15;
                    bVar.d(cursor2.getLong(i21));
                    columnIndex15 = i21;
                    int i22 = columnIndex16;
                    bVar.a(cursor2.getDouble(i22));
                    int i23 = columnIndex19;
                    bVar.e(cursor2.getInt(i23));
                    columnIndex16 = i22;
                    int i24 = columnIndex20;
                    bVar.g(cursor2.getString(i24));
                    int i25 = columnIndex22;
                    bVar.k(cursor2.getInt(i25));
                    columnIndex22 = i25;
                    int i26 = columnIndex23;
                    bVar.b(cursor2.getInt(i26));
                    columnIndex23 = i26;
                    bVar.a(cursor2.getInt(i12));
                    int i27 = columnIndex21;
                    JSONObject jSONObject = JSONUtils.parse(cursor2.getString(i27));
                    bVar.a(jSONObject);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(bVar);
                    CampaignUnit campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject, string);
                    if (campaignUnit == null) {
                        cursor2 = cursor;
                        arrayList2 = arrayList3;
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        ArrayList<CampaignEx> ads = campaignUnit.getAds();
                        if (ads == null) {
                            cursor2 = cursor;
                            arrayList2 = arrayList3;
                        } else {
                            arrayList2 = arrayList3;
                            MBridgeGlobalCommon.handlerCampaigns(bVar.g(), bVar, ads, arrayList4);
                            bVar.b(ads);
                            bVar.a(arrayList4);
                            cursor2 = cursor;
                        }
                    }
                    columnIndex21 = i27;
                    columnIndex20 = i24;
                    columnIndex18 = i17;
                    columnIndex17 = i18;
                    columnIndex24 = i12;
                    columnIndex = i13;
                    columnIndex3 = i15;
                    columnIndex4 = i16;
                    columnIndex19 = i23;
                    columnIndex2 = i14;
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                if (!MBridgeConstans.DEBUG) {
                    return list;
                }
                af.b("CampaignTable", "parseCampaignTable: ", e);
                return list;
            }
        } catch (Exception e3) {
            e = e3;
            list = null;
        }
    }

    public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        if (bVar == null) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "insert: mBridgeCampaigns is null");
                return;
            }
            return;
        }
        List<com.mbridge.msdk.newreward.function.c.a.a> listU = bVar.u();
        if (listU == null || listU.isEmpty()) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "insert: campaignList is null or empty");
                return;
            }
            return;
        }
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "insert: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f4912b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f4911a);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("request_id", bVar.f());
                    contentValues.put("session_id", bVar.k());
                    contentValues.put("system_id", bVar.l());
                    contentValues.put("backup_id", bVar.m());
                    contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(bVar.j()));
                    contentValues.put("template", Integer.valueOf(bVar.o()));
                    contentValues.put("invalid_time", Long.valueOf(bVar.p()));
                    contentValues.put("invalid_time_2", Long.valueOf(bVar.q()));
                    contentValues.put("invalid_time_backup", Long.valueOf(bVar.r()));
                    contentValues.put("show_count", Integer.valueOf(bVar.t()));
                    contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID, bVar.n());
                    contentValues.put("token_rule", Integer.valueOf(bVar.G()));
                    contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(bVar.b()));
                    contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(bVar.a()));
                    contentValues.put(DataSchemeDataSource.SCHEME_DATA, bVar.v().toString());
                    long jUpdate = this.f4911a.update("campaign", contentValues, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(bVar.c()), com.mbridge.msdk.foundation.controller.c.m().k(), bVar.d(), bVar.e(), bVar.g()});
                    if (MBridgeConstans.DEBUG) {
                        af.a("CampaignTable", "updateCampaign result:  " + jUpdate);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f4911a);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "updateCampaign: ", e);
                    }
                }
                DatabaseUtils.endTransaction(this.f4911a);
            } catch (Throwable th) {
                DatabaseUtils.endTransaction(this.f4911a);
                throw th;
            }
        }
    }

    public final void c(int i10, String str, String str2) {
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "clearLoadCheckCampaigns: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f4912b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f4911a);
                    int iDelete = this.f4911a.delete("campaign", "ad_type=? and app_id=? and placement_id=? and unit_id=? and state in (0,405,401,404);", new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2});
                    if (MBridgeConstans.DEBUG) {
                        af.a("CampaignTable", "clearLoadCheckCampaigns result:  " + iDelete);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f4911a);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "clearLoadCheckCampaigns: ", e);
                    }
                }
                DatabaseUtils.endTransaction(this.f4911a);
            } catch (Throwable th) {
                DatabaseUtils.endTransaction(this.f4911a);
                throw th;
            }
        }
    }

    public final void d(int i10, String str, String str2) {
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "clearUnInvalidCampaign: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f4912b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f4911a);
                    int iDelete = this.f4911a.delete("campaign", a(), new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(System.currentTimeMillis())});
                    if (MBridgeConstans.DEBUG) {
                        af.a("CampaignTable", "clearUnInvalidCampaign result:  " + iDelete);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f4911a);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "clearUnInvalidCampaign: ", e);
                    }
                }
                DatabaseUtils.endTransaction(this.f4911a);
            } catch (Throwable th) {
                DatabaseUtils.endTransaction(this.f4911a);
                throw th;
            }
        }
    }

    public final List<String> e(int i10, String str, String str2) {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        Cursor cursor = null;
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "database is not available");
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4912b) {
            try {
                try {
                    try {
                        cursorQuery = this.f4911a.query("campaign", null, a(), new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(System.currentTimeMillis())}, null, null, null, null);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } catch (Exception e) {
                    exc = e;
                }
                if (cursorQuery != null) {
                    try {
                    } catch (Exception e3) {
                        exc = e3;
                        cursor = cursorQuery;
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignTable", "find: ", exc);
                        }
                        DatabaseUtils.closeCursor(cursor);
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursorQuery;
                        DatabaseUtils.closeCursor(cursor);
                        throw th;
                    }
                    if (cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("local_id");
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                        DatabaseUtils.closeCursor(cursorQuery);
                        return arrayList;
                    }
                }
                DatabaseUtils.closeCursor(cursorQuery);
                return null;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void b(int i10, String str, String str2, String str3, boolean z9, String str4, long j10) {
        Cursor cursorQuery;
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "insert: database is not available");
                return;
            }
            return;
        }
        double d8 = com.mbridge.msdk.newreward.function.h.c.d(str4);
        synchronized (this.f4912b) {
            try {
                try {
                    cursorQuery = this.f4911a.query("campaign", null, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, str3}, null, null, null);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "insert: ", e);
                    }
                }
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    if (MBridgeConstans.DEBUG) {
                        af.a("CampaignTable", "insert:  already exist");
                    }
                    DatabaseUtils.closeCursor(cursorQuery);
                    DatabaseUtils.endTransaction(this.f4911a);
                    return;
                }
                DatabaseUtils.beginTransaction(this.f4911a);
                ContentValues contentValues = new ContentValues();
                contentValues.put("ad_type", Integer.valueOf(i10));
                contentValues.put(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
                contentValues.put("placement_id", str);
                contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                contentValues.put("local_id", str3);
                contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, (Integer) 0);
                contentValues.put("bid_token", str4);
                contentValues.put("invalid_time", Long.valueOf(j10));
                contentValues.put("header_bidding", Integer.valueOf(z9 ? 1 : 0));
                contentValues.put("load_start_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("ecppv", Double.valueOf(d8));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, (Integer) 0);
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, (Integer) 0);
                long jInsert = this.f4911a.insert("campaign", null, contentValues);
                if (MBridgeConstans.DEBUG) {
                    af.a("CampaignTable", "insert result:  " + jInsert);
                }
                DatabaseUtils.setTransactionSuccessful(this.f4911a);
                DatabaseUtils.endTransaction(this.f4911a);
            } catch (Throwable th) {
                DatabaseUtils.endTransaction(this.f4911a);
                throw th;
            }
        }
    }

    private Runnable b(final int i10, final String str, final String str2, final String str3, final int i11, final com.mbridge.msdk.newreward.function.c.a.b bVar) {
        return new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.5
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.newreward.function.c.a.b bVar2 = bVar;
                a aVar = a.this;
                if (bVar2 == null) {
                    aVar.b(i10, str, str2, str3, i11);
                    return;
                }
                List<com.mbridge.msdk.newreward.function.c.a.b> listA = aVar.a(bVar2.c(), bVar.d(), bVar.e(), bVar.i(), 0, bVar.g());
                if (bVar.a() <= 0 || listA == null || listA.isEmpty()) {
                    if (bVar.a() != 0 || listA == null || listA.isEmpty() || listA.get(0).t() <= 0) {
                        a.this.b(i10, str, str2, str3, i11);
                    }
                }
            }
        };
    }

    public final void b(int i10, String str, String str2, String str3, int i11) {
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "updateState: database is not available");
                return;
            }
            return;
        }
        synchronized (this.f4912b) {
            try {
                try {
                    DatabaseUtils.beginTransaction(this.f4911a);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(i11));
                    int iUpdate = this.f4911a.update("campaign", contentValues, "ad_type=? and app_id=? and placement_id=? and unit_id=? and local_id=?", new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, str3});
                    if (MBridgeConstans.DEBUG) {
                        af.a("CampaignTable", "updateState result:  " + iUpdate);
                    }
                    DatabaseUtils.setTransactionSuccessful(this.f4911a);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "updateState: ", e);
                    }
                }
                DatabaseUtils.endTransaction(this.f4911a);
            } catch (Throwable th) {
                DatabaseUtils.endTransaction(this.f4911a);
                throw th;
            }
        }
    }

    public final void b(final int i10, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.7
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(i10, str, str2);
            }
        });
    }

    public final void a(final int i10, final String str, final String str2, final boolean z9, final b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.3
            @Override // java.lang.Runnable
            public final void run() {
                List<com.mbridge.msdk.newreward.function.c.a.b> listA = a.this.a(i10, str, str2, z9);
                if (listA == null || listA.isEmpty()) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(listA);
                }
            }
        });
    }

    public final List<com.mbridge.msdk.newreward.function.c.a.b> a(int i10, String str, String str2, boolean z9) {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        Cursor cursor = null;
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "find: database is not available");
            }
            return null;
        }
        synchronized (this.f4912b) {
            try {
                cursorQuery = this.f4911a.query("campaign", null, "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state in (401,404,405)", new String[]{String.valueOf(i10), com.mbridge.msdk.foundation.controller.c.m().k(), str, str2, String.valueOf(z9 ? 1 : 0)}, null, null, "load_start_time desc");
                try {
                    try {
                        List<com.mbridge.msdk.newreward.function.c.a.b> listA = a(cursorQuery);
                        if (listA == null || listA.size() == 0) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("CampaignTable", "find: mBridgeCampaigns is null or empty");
                            }
                        }
                        DatabaseUtils.closeCursor(cursorQuery);
                        return listA;
                    } catch (Exception e) {
                        exc = e;
                        if (MBridgeConstans.DEBUG) {
                            af.b("CampaignTable", "find: ", exc);
                        }
                        DatabaseUtils.closeCursor(cursorQuery);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    DatabaseUtils.closeCursor(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                exc = e3;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                DatabaseUtils.closeCursor(cursor);
                throw th;
            }
        }
    }

    public final List<com.mbridge.msdk.newreward.function.c.a.b> a(int i10, String str, String str2, boolean z9, int i11, String str3) {
        Throwable th;
        Exception exc;
        Cursor cursor;
        String str4;
        String[] strArr;
        Cursor cursorQuery;
        Cursor cursor2 = null;
        if (!DatabaseUtils.isDatabaseAvailable(this.f4911a)) {
            if (MBridgeConstans.DEBUG) {
                af.b("CampaignTable", "find: database is not available");
            }
            return null;
        }
        synchronized (this.f4912b) {
            try {
                String strValueOf = String.valueOf(z9 ? 1 : 0);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (TextUtils.isEmpty(str3)) {
                    str4 = "ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state=? and invalid_time>?";
                    strArr = new String[]{String.valueOf(i10), strK, str, str2, strValueOf, String.valueOf(3), String.valueOf(jCurrentTimeMillis)};
                } else {
                    str4 = "local_id=? and ad_type=? and app_id=? and placement_id=? and unit_id=? and header_bidding=? and state=? and invalid_time>?";
                    strArr = new String[]{str3, String.valueOf(i10), strK, str, str2, strValueOf, String.valueOf(3), String.valueOf(jCurrentTimeMillis)};
                }
                cursorQuery = this.f4911a.query("campaign", null, str4, strArr, null, null, "load_start_time desc", String.valueOf(i11 <= 0 ? Integer.MAX_VALUE : i11));
            } catch (Exception e) {
                exc = e;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                List<com.mbridge.msdk.newreward.function.c.a.b> listA = a(cursorQuery);
                if (listA == null || listA.size() == 0) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "find: mBridgeCampaigns is null or empty");
                    }
                }
                DatabaseUtils.closeCursor(cursorQuery);
                return listA;
            } catch (Exception e3) {
                cursor = cursorQuery;
                exc = e3;
                try {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CampaignTable", "find: ", exc);
                    }
                    DatabaseUtils.closeCursor(cursor);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = cursor;
                    DatabaseUtils.closeCursor(cursor2);
                    throw th;
                }
            } catch (Throwable th4) {
                cursor2 = cursorQuery;
                th = th4;
                DatabaseUtils.closeCursor(cursor2);
                throw th;
            }
        }
    }

    public final void a(int i10, String str, String str2, String str3, int i11) {
        MBridgeTaskManager.campaignTableExecute(b(i10, str, str2, str3, i11, null));
    }

    public final void a(int i10, String str, String str2, String str3, int i11, com.mbridge.msdk.newreward.function.c.a.b bVar) {
        MBridgeTaskManager.campaignTableExecute(b(i10, str, str2, str3, i11, bVar));
    }

    private static String a() {
        return "ad_type=? and app_id=? and placement_id=? and unit_id=? and (state in (6,402,406,403,8,7) or invalid_time<? )";
    }

    public final void a(final com.mbridge.msdk.newreward.function.c.a.b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(bVar);
            }
        });
    }

    public final void a(final int i10, final String str, final String str2, final String str3, final boolean z9, final String str4, final long j10) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(i10, str, str2, str3, z9, str4, j10);
            }
        });
    }

    public final void a(final int i10, final String str, final String str2, final boolean z9, final int i11, final b bVar) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.4
            @Override // java.lang.Runnable
            public final void run() {
                List<com.mbridge.msdk.newreward.function.c.a.b> listA = a.this.a(i10, str, str2, z9, i11, "");
                if (listA == null || listA.size() == 0) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(listA);
                }
            }
        });
    }

    public final void a(final int i10, final String str, final String str2) {
        MBridgeTaskManager.campaignTableExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.d.a.6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.d(i10, str, str2);
            }
        });
    }
}
