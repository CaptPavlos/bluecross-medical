package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f635a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f636b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f637c;

    public /* synthetic */ i(int i10, Object obj, Object obj2) {
        this.f635a = i10;
        this.f636b = obj;
        this.f637c = obj2;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f635a) {
            case 0:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeWithRefCount$lambda$5((AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement) this.f636b, (l) this.f637c, (SupportSQLiteDatabase) obj);
            default:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$8((String) this.f636b, (Object[]) this.f637c, (SupportSQLiteDatabase) obj);
        }
    }
}
