package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f620a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f621b;

    public /* synthetic */ b(int i10, int i11) {
        this.f620a = i11;
        this.f621b = i10;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f620a) {
            case 0:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaxSqlCacheSize$lambda$11(this.f621b, (SupportSQLiteDatabase) obj);
            case 1:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_version_$lambda$1(this.f621b, (SupportSQLiteDatabase) obj);
            case 2:
                return Boolean.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.needUpgrade$lambda$9(this.f621b, (SupportSQLiteDatabase) obj));
            case 3:
                return WorkSpecDao_Impl.getAllEligibleWorkSpecsForScheduling$lambda$29("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", this.f621b, (SQLiteConnection) obj);
            case 4:
                return WorkSpecDao_Impl.getEligibleWorkForScheduling$lambda$25("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", this.f621b, (SQLiteConnection) obj);
            default:
                ((Integer) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f621b + '.');
        }
    }
}
