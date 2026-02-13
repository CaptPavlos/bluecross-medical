package androidx.room.support;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f622a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f623b;

    public /* synthetic */ c(long j10, int i10) {
        this.f622a = i10;
        this.f623b = j10;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f622a) {
            case 0:
                return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaximumSize$lambda$2(this.f623b, (SupportSQLiteDatabase) obj));
            case 1:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_pageSize_$lambda$3(this.f623b, (SupportSQLiteDatabase) obj);
            case 2:
                return WorkSpecDao_Impl.getRecentlyCompletedWork$lambda$35("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", this.f623b, (SQLiteConnection) obj);
            default:
                ((MutablePreferences) obj).set(o2.i.f11705b, Long.valueOf(this.f623b));
                return null;
        }
    }
}
