package w;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class h implements d, x.c, c {
    public static final m.c f = new m.c("proto");

    /* renamed from: a, reason: collision with root package name */
    public final j f13307a;

    /* renamed from: b, reason: collision with root package name */
    public final t3.h f13308b;

    /* renamed from: c, reason: collision with root package name */
    public final t3.h f13309c;

    /* renamed from: d, reason: collision with root package name */
    public final a f13310d;
    public final p6.a e;

    public h(t3.h hVar, t3.h hVar2, a aVar, j jVar, p6.a aVar2) {
        this.f13307a = jVar;
        this.f13308b = hVar;
        this.f13309c = hVar2;
        this.f13310d = aVar;
        this.e = aVar2;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, n nVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        p.i iVar = (p.i) nVar;
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.f11855a, String.valueOf(z.a.a(iVar.f11857c))));
        byte[] bArr = iVar.f11856b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String i(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f13300a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object j(Cursor cursor, f fVar) {
        try {
            return fVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        j jVar = this.f13307a;
        Objects.requireNonNull(jVar);
        t3.h hVar = this.f13309c;
        long jN = hVar.n();
        while (true) {
            try {
                return jVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (hVar.n() >= this.f13310d.f13298c + jN) {
                    throw new x.a("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f13307a.close();
    }

    public final Object d(f fVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = fVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList e(SQLiteDatabase sQLiteDatabase, p.i iVar, int i10) {
        ArrayList arrayList = new ArrayList();
        Long lB = b(sQLiteDatabase, iVar);
        if (lB == null) {
            return arrayList;
        }
        j(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", MRAIDCommunicatorUtil.PLACEMENT_INLINE, "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lB.toString()}, null, null, null, String.valueOf(i10)), new androidx.transition.a(this, arrayList, iVar, 5));
        return arrayList;
    }

    public final void f(long j10, s.c cVar, String str) {
        d(new t1.a(j10, str, cVar));
    }

    public final Object h(x.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        t3.h hVar = this.f13309c;
        long jN = hVar.n();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objExecute = bVar.execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (hVar.n() >= this.f13310d.f13298c + jN) {
                    throw new x.a("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
