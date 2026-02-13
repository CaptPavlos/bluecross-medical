package r1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements g, x.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12319b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f12320c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12321d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(v.h hVar, Iterable iterable, p.i iVar, long j10) {
        this.f12318a = 2;
        this.f12319b = hVar;
        this.e = iterable;
        this.f12321d = iVar;
        this.f12320c = j10;
    }

    @Override // r1.g
    public ScheduledFuture a(n5 n5Var) {
        switch (this.f12318a) {
            case 0:
                f fVar = (f) this.f12319b;
                Runnable runnable = (Runnable) this.e;
                return fVar.f12334b.schedule(new e(fVar, runnable, n5Var, 1), this.f12320c, (TimeUnit) this.f12321d);
            default:
                f fVar2 = (f) this.f12319b;
                Callable callable = (Callable) this.e;
                return fVar2.f12334b.schedule(new androidx.work.impl.b(fVar2, callable, n5Var, 1), this.f12320c, (TimeUnit) this.f12321d);
        }
    }

    @Override // x.b
    public Object execute() {
        v.h hVar = (v.h) this.f12319b;
        Iterable iterable = (Iterable) this.e;
        p.i iVar = (p.i) this.f12321d;
        w.h hVar2 = (w.h) hVar.f13113c;
        hVar2.getClass();
        if (iterable.iterator().hasNext()) {
            String strConcat = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ".concat(w.h.i(iterable));
            SQLiteDatabase sQLiteDatabaseA = hVar2.a();
            sQLiteDatabaseA.beginTransaction();
            try {
                sQLiteDatabaseA.compileStatement(strConcat).execute();
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        hVar2.f(cursorRawQuery.getInt(0), s.c.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseA.endTransaction();
            }
        }
        hVar2.d(new w.e(hVar.g.n() + this.f12320c, iVar));
        return null;
    }

    public /* synthetic */ b(f fVar, Object obj, long j10, TimeUnit timeUnit, int i10) {
        this.f12318a = i10;
        this.f12319b = fVar;
        this.e = obj;
        this.f12320c = j10;
        this.f12321d = timeUnit;
    }
}
