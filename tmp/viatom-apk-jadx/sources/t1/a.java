package t1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import r1.i;
import v.h;
import w.f;
import z1.k1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements q2.a, x.b, f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f12744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12745b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12746c;

    public /* synthetic */ a(long j10, Object obj, Object obj2) {
        this.f12745b = obj;
        this.f12746c = obj2;
        this.f12744a = j10;
    }

    @Override // w.f
    public Object apply(Object obj) throws SQLException {
        String str = (String) this.f12745b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i10 = ((s.c) this.f12746c).f12500a;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i10)});
        try {
            boolean z9 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j10 = this.f12744a;
            if (z9) {
                sQLiteDatabase.execSQL(i.d("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ", " WHERE log_source = ? AND reason = ?", j10), new String[]{str, Integer.toString(i10)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i10));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // q2.a
    public void b(q2.b bVar) {
        ((b) bVar.get()).d((String) this.f12745b, this.f12744a, (k1) this.f12746c);
    }

    @Override // x.b
    public Object execute() {
        h hVar = (h) this.f12745b;
        p.i iVar = (p.i) this.f12746c;
        w.d dVar = hVar.f13113c;
        long jN = hVar.g.n() + this.f12744a;
        w.h hVar2 = (w.h) dVar;
        hVar2.getClass();
        hVar2.d(new w.e(jN, iVar));
        return null;
    }

    public /* synthetic */ a(String str, long j10, k1 k1Var) {
        this.f12745b = str;
        this.f12744a = j10;
        this.f12746c = k1Var;
    }
}
