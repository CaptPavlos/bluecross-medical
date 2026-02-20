package v;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import h1.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import l4.p2;
import p.n;
import p8.u;
import w1.j;
import w2.b0;
import w2.r;
import w2.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements x.b, h1.a, h1.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13104b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f13103a = i10;
        this.f13104b = obj;
    }

    @Override // h1.a
    public Object a(p pVar) {
        switch (this.f13103a) {
            case 4:
                ((CountDownLatch) this.f13104b).countDown();
                return null;
            case 8:
                return (p) ((j) this.f13104b).call();
            default:
                ((Runnable) this.f13104b).run();
                return r0.f.x(null);
        }
    }

    @Override // x.b
    public Object execute() {
        SQLiteDatabase sQLiteDatabaseA;
        int i10 = this.f13103a;
        Object obj = this.f13104b;
        switch (i10) {
            case 0:
                w.h hVar = (w.h) ((w.c) obj);
                hVar.getClass();
                int i11 = s.a.e;
                r rVar = new r(23);
                rVar.f13463c = null;
                rVar.f13464d = new ArrayList();
                rVar.e = null;
                rVar.f13462b = "";
                HashMap map = new HashMap();
                sQLiteDatabaseA = hVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    s.a aVar = (s.a) w.h.j(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new androidx.transition.a(hVar, map, rVar, 6));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case 1:
                w.h hVar2 = (w.h) ((w.d) obj);
                long jN = hVar2.f13308b.n() - hVar2.f13310d.f13299d;
                sQLiteDatabaseA = hVar2.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(jN)};
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            hVar2.f(cursorRawQuery.getInt(0), s.c.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return Integer.valueOf(iDelete);
                } finally {
                }
            case 2:
                w.h hVar3 = (w.h) ((h) obj).f13115i;
                sQLiteDatabaseA = hVar3.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + hVar3.f13308b.n()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                r rVar2 = (r) obj;
                sQLiteDatabaseA = ((w.h) ((w.d) rVar2.f13463c)).a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    List list = (List) w.h.j(sQLiteDatabaseA.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new u(17));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((p2) rVar2.f13464d).g((n) it.next(), 1, false);
                    }
                    return null;
                } finally {
                }
        }
    }

    @Override // h1.d
    public void o(p pVar) {
        switch (this.f13103a) {
            case 5:
                z.c((Intent) this.f13104b);
                break;
            case 6:
                ((b0) this.f13104b).f13425b.c(null);
                break;
            default:
                ((ScheduledFuture) this.f13104b).cancel(false);
                break;
        }
    }
}
