package w;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p.i f13304b;

    public /* synthetic */ e(long j10, p.i iVar) {
        this.f13303a = j10;
        this.f13304b = iVar;
    }

    @Override // w.f
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f13303a));
        p.i iVar = this.f13304b;
        String str = iVar.f11855a;
        m.d dVar = iVar.f11857c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(z.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", str);
            contentValues.put("priority", Integer.valueOf(z.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
