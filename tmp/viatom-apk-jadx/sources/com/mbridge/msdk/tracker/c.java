package com.mbridge.msdk.tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f5330a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5331b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5332c = new Object();

    public c(b bVar, String str) {
        this.f5330a = bVar;
        this.f5331b = str;
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "beginTransaction: ", e);
            }
        }
    }

    public final long a(i iVar) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            long jInsert = -1;
            if (y.a(this.f5330a)) {
                return -1L;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return -1L;
            }
            try {
                try {
                    d(writableDatabase);
                    ContentValues contentValues = new ContentValues(16);
                    e eVarC = iVar.c();
                    contentValues.put(RewardPlus.NAME, eVarC.a());
                    contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(eVarC.b()));
                    contentValues.put("time_stamp", Long.valueOf(eVarC.f()));
                    contentValues.put("properties", eVarC.d().toString());
                    contentValues.put("priority", Integer.valueOf(eVarC.c()));
                    contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(iVar.e()));
                    contentValues.put("report_count", Integer.valueOf(iVar.d()));
                    contentValues.put("uuid", eVarC.e());
                    contentValues.put("ignore_max_timeout", Integer.valueOf(!eVarC.j() ? 1 : 0));
                    contentValues.put("ignore_max_retry_times", Integer.valueOf(!eVarC.k() ? 1 : 0));
                    contentValues.put("invalid_time", Long.valueOf(iVar.g()));
                    jInsert = writableDatabase.insert(this.f5331b, null, contentValues);
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "insert: " + e3.getMessage());
                    }
                }
                return jInsert;
            } finally {
                b(writableDatabase);
            }
        }
    }

    public final void b(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            if (y.a(this.f5330a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "updateReportStateSuccess getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return;
                }
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, (Integer) 2);
                        writableDatabase.update(this.f5331b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "updateReportStateSuccess: " + e3.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th) {
                b(writableDatabase);
                throw th;
            }
        }
    }

    public final void c(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            if (y.a(this.f5330a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "updateReportStateFailed getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return;
                }
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(iVar.e()));
                        contentValues.put("report_count", Integer.valueOf(iVar.d()));
                        writableDatabase.update(this.f5331b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "updateReportStateFailed: " + e3.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th) {
                b(writableDatabase);
                throw th;
            }
        }
    }

    public final int b() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            int iDelete = -1;
            if (y.a(this.f5330a)) {
                return -1;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return -1;
            }
            try {
                try {
                    d(writableDatabase);
                    iDelete = writableDatabase.delete(this.f5331b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "deleteInvalidEvents: " + e3.getMessage());
                    }
                }
                return iDelete;
            } finally {
                b(writableDatabase);
            }
        }
    }

    public final void c() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            if (y.a(this.f5330a)) {
                return;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "updateReportStateForReporting getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return;
            }
            try {
                try {
                    d(writableDatabase);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, (Integer) 3);
                    writableDatabase.update(this.f5331b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "updateReportStateForReporting: " + e3.getMessage());
                    }
                }
            } finally {
                b(writableDatabase);
            }
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase) || !sQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "endTransaction: ", e);
            }
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "transactionSuccess: ", e);
            }
        }
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    public final List<i> a(int i10) {
        SQLiteDatabase writableDatabase;
        List<i> list;
        Cursor cursorQuery;
        synchronized (this.f5332c) {
            Cursor cursor = null;
            List<i> listB = null;
            cursor = null;
            if (y.a(this.f5330a)) {
                return null;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "getAvailable getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return null;
            }
            try {
                try {
                    d(writableDatabase);
                    cursorQuery = writableDatabase.query(this.f5331b, null, "state = ? OR state = ?", new String[]{String.valueOf(0), String.valueOf(3)}, null, null, "priority DESC", String.valueOf(i10));
                } catch (Exception e3) {
                    e = e3;
                    list = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                listB = y.b(cursorQuery);
                c(writableDatabase);
                b(writableDatabase);
                y.a(cursorQuery);
            } catch (Exception e7) {
                e = e7;
                List<i> list2 = listB;
                cursor = cursorQuery;
                list = list2;
                if (a.f5328a) {
                    Log.e("TrackManager", "getAvailable: " + e.getMessage());
                }
                b(writableDatabase);
                y.a(cursor);
                listB = list;
                return listB;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                b(writableDatabase);
                y.a(cursor);
                throw th;
            }
            return listB;
        }
    }

    public final int a() {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            int iMax = 0;
            if (y.a(this.f5330a)) {
                return 0;
            }
            Cursor cursorQuery = null;
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (a(writableDatabase)) {
                return 0;
            }
            try {
                try {
                    d(writableDatabase);
                    cursorQuery = writableDatabase.query(this.f5331b, null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToNext()) {
                        iMax = Math.max(cursorQuery.getCount(), 0);
                    }
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "getAvailableCount: " + e3.getMessage());
                    }
                }
                b(writableDatabase);
                y.a(cursorQuery);
                return iMax;
            } catch (Throwable th) {
                b(writableDatabase);
                y.a(cursorQuery);
                throw th;
            }
        }
    }

    public final void a(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.f5332c) {
            if (y.a(this.f5330a) || y.a((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5330a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "updateReportStateReporting getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (a(writableDatabase)) {
                    return;
                }
                try {
                    d(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(MRAIDCommunicatorUtil.KEY_STATE, (Integer) 1);
                        writableDatabase.update(this.f5331b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    c(writableDatabase);
                } catch (Exception e3) {
                    if (a.f5328a) {
                        Log.e("TrackManager", "updateReportStateReporting: " + e3.getMessage());
                    }
                }
                b(writableDatabase);
            } catch (Throwable th) {
                b(writableDatabase);
                throw th;
            }
        }
    }
}
