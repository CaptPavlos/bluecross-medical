package com.mbridge.msdk.tracker;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class b extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f5329a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f5329a = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f5346a, this.f5329a));
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "create table error", e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f5347b, this.f5329a));
            sQLiteDatabase.execSQL(String.format(i.f5346a, this.f5329a));
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "downgrade table error", e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (y.a(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.f5347b, this.f5329a));
            sQLiteDatabase.execSQL(String.format(i.f5346a, this.f5329a));
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "upgrade table error", e);
            }
        }
    }
}
