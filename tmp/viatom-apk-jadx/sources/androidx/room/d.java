package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f618a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f619b;

    public /* synthetic */ d(RoomDatabase roomDatabase, int i10) {
        this.f618a = i10;
        this.f619b = roomDatabase;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f618a) {
            case 0:
                return RoomDatabase.endTransaction$lambda$9(this.f619b, (SupportSQLiteDatabase) obj);
            case 1:
                return RoomDatabase.createConnectionManager$lambda$1(this.f619b, (DatabaseConfiguration) obj);
            default:
                return RoomDatabase.beginTransaction$lambda$8(this.f619b, (SupportSQLiteDatabase) obj);
        }
    }
}
