package androidx.transition;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.CancellationSignal;
import androidx.work.ListenableFutureKt;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import h1.h;
import h1.i;
import h1.p;
import h5.q0;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import l4.x4;
import p.k;
import r7.x;
import s.d;
import s.e;
import s.g;
import w.f;
import w2.j;
import w2.r;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CancellationSignal.OnCancelListener, CallbackToFutureAdapter.Resolver, x.b, f, h, h1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f646a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f647b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f648c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f649d;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f646a = 0;
        this.f647b = runnable;
        this.f649d = transition;
        this.f648c = runnable2;
    }

    @Override // h1.a
    public Object a(p pVar) {
        i iVar = (i) this.f647b;
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f648c;
        y2.c cVar = (y2.c) this.f649d;
        if (pVar.i()) {
            iVar.c(pVar.g());
        } else if (pVar.f() != null) {
            iVar.b(pVar.f());
        } else if (atomicBoolean.getAndSet(true)) {
            ((p) ((d0.i) cVar.f13781b).f6781b).n(null);
        }
        return r0.f.x(null);
    }

    @Override // w.f
    public Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        s.c cVar;
        s.c cVar2;
        int i10 = this.f646a;
        int i11 = 5;
        int i12 = 4;
        int i13 = 3;
        s.c cVar3 = s.c.CACHE_FULL;
        int i14 = 2;
        int i15 = 1;
        Object obj2 = this.f649d;
        Object obj3 = this.f648c;
        Object obj4 = this.f647b;
        int i16 = 0;
        switch (i10) {
            case 4:
                w.h hVar = (w.h) obj4;
                p.h hVar2 = (p.h) obj3;
                k kVar = hVar2.f11851c;
                String str = hVar2.f11849a;
                p.i iVar = (p.i) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = hVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * hVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                w.a aVar = hVar.f13310d;
                if (jSimpleQueryForLong >= aVar.f13296a) {
                    hVar.f(1L, cVar3, str);
                    return -1L;
                }
                Long lB = w.h.b(sQLiteDatabase, iVar);
                if (lB != null) {
                    jInsert = lB.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", iVar.f11855a);
                    contentValues.put("priority", Integer.valueOf(z.a.a(iVar.f11857c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = iVar.f11856b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i17 = aVar.e;
                byte[] bArr2 = kVar.f11863b;
                boolean z9 = bArr2.length <= i17;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(hVar2.f11852d));
                contentValues2.put("uptime_ms", Long.valueOf(hVar2.e));
                contentValues2.put("payload_encoding", kVar.f11862a.f11153a);
                contentValues2.put("code", hVar2.f11850b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put(MRAIDCommunicatorUtil.PLACEMENT_INLINE, Boolean.valueOf(z9));
                contentValues2.put("payload", z9 ? bArr2 : new byte[0]);
                contentValues2.put("product_id", hVar2.g);
                contentValues2.put("pseudonymous_id", hVar2.h);
                contentValues2.put("experiment_ids_clear_blob", hVar2.f11853i);
                contentValues2.put("experiment_ids_encrypted_blob", hVar2.f11854j);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z9) {
                    int iCeil = (int) Math.ceil(bArr2.length / i17);
                    for (int i18 = 1; i18 <= iCeil; i18++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i18 - 1) * i17, Math.min(i18 * i17, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i18));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : DesugarCollections.unmodifiableMap(hVar2.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put(RewardPlus.NAME, (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 5:
                w.h hVar3 = (w.h) obj4;
                ArrayList arrayList = (ArrayList) obj3;
                p.i iVar2 = (p.i) obj2;
                Cursor cursor2 = (Cursor) obj;
                while (true) {
                    if (cursor2.moveToNext()) {
                        long j10 = cursor2.getLong(0);
                        int i19 = cursor2.getInt(7) != 0 ? i15 : 0;
                        d5.h hVar4 = new d5.h();
                        hVar4.f7086j = new HashMap();
                        String string = cursor2.getString(i15);
                        if (string != null) {
                            hVar4.f7082b = string;
                            hVar4.h = Long.valueOf(cursor2.getLong(i14));
                            hVar4.f7085i = Long.valueOf(cursor2.getLong(3));
                            if (i19 != 0) {
                                String string2 = cursor2.getString(4);
                                hVar4.g = new k(string2 == null ? w.h.f : new m.c(string2), cursor2.getBlob(5));
                            } else {
                                String string3 = cursor2.getString(4);
                                m.c cVar4 = string3 == null ? w.h.f : new m.c(string3);
                                Cursor cursorQuery = hVar3.a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num");
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    int length = 0;
                                    while (cursorQuery.moveToNext()) {
                                        byte[] blob = cursorQuery.getBlob(0);
                                        arrayList2.add(blob);
                                        length += blob.length;
                                    }
                                    byte[] bArr3 = new byte[length];
                                    int i20 = 0;
                                    int length2 = 0;
                                    while (i20 < arrayList2.size()) {
                                        byte[] bArr4 = (byte[]) arrayList2.get(i20);
                                        cursor = cursorQuery;
                                        try {
                                            ArrayList arrayList3 = arrayList2;
                                            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                                            length2 += bArr4.length;
                                            i20++;
                                            cursorQuery = cursor;
                                            arrayList2 = arrayList3;
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor.close();
                                            throw th;
                                        }
                                    }
                                    cursorQuery.close();
                                    hVar4.g = new k(cVar4, bArr3);
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = cursorQuery;
                                }
                            }
                            if (!cursor2.isNull(6)) {
                                hVar4.f = Integer.valueOf(cursor2.getInt(6));
                            }
                            if (!cursor2.isNull(8)) {
                                hVar4.f7087k = Integer.valueOf(cursor2.getInt(8));
                            }
                            if (!cursor2.isNull(9)) {
                                hVar4.f7083c = cursor2.getString(9);
                            }
                            if (!cursor2.isNull(10)) {
                                hVar4.f7084d = cursor2.getBlob(10);
                            }
                            if (!cursor2.isNull(11)) {
                                hVar4.e = cursor2.getBlob(11);
                            }
                            arrayList.add(new w.b(j10, iVar2, hVar4.b()));
                            i14 = 2;
                            i15 = 1;
                        } else {
                            androidx.window.layout.c.k("Null transportName");
                        }
                    }
                }
                return null;
            default:
                w.h hVar5 = (w.h) obj4;
                HashMap map = (HashMap) obj3;
                r rVar = (r) obj2;
                ArrayList arrayList4 = (ArrayList) rVar.f13464d;
                Cursor cursor3 = (Cursor) obj;
                hVar5.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i16);
                    int i21 = cursor3.getInt(1);
                    s.c cVar5 = s.c.REASON_UNKNOWN;
                    if (i21 != 0) {
                        if (i21 == 1) {
                            cVar5 = s.c.MESSAGE_TOO_OLD;
                        } else if (i21 == 2) {
                            cVar = cVar3;
                            cVar2 = cVar;
                        } else if (i21 == i13) {
                            cVar5 = s.c.PAYLOAD_TOO_BIG;
                        } else if (i21 == i12) {
                            cVar5 = s.c.MAX_RETRIES_REACHED;
                        } else if (i21 == i11) {
                            cVar5 = s.c.INVALID_PAYLOD;
                        } else if (i21 == 6) {
                            cVar5 = s.c.SERVER_ERROR;
                        } else {
                            t1.l(Integer.valueOf(i21), "SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN");
                        }
                        cVar2 = cVar3;
                        cVar = cVar5;
                    } else {
                        cVar2 = cVar3;
                        cVar = cVar5;
                    }
                    long j11 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new d(j11, cVar));
                    cVar3 = cVar2;
                    i11 = 5;
                    i12 = 4;
                    i13 = 3;
                    i16 = 0;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i22 = e.f12503c;
                    new ArrayList();
                    arrayList4.add(new e((String) entry2.getKey(), DesugarCollections.unmodifiableList((List) entry2.getValue())));
                }
                long jN = hVar5.f13308b.n();
                SQLiteDatabase sQLiteDatabaseA = hVar5.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        g gVar = new g(cursorRawQuery.getLong(0), jN);
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        rVar.f13463c = gVar;
                        rVar.e = new s.b(new s.f(hVar5.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * hVar5.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), w.a.f.f13296a));
                        rVar.f13462b = (String) hVar5.e.get();
                        return new s.a((g) rVar.f13463c, DesugarCollections.unmodifiableList(arrayList4), (s.b) rVar.e, (String) rVar.f13462b);
                    } catch (Throwable th3) {
                        cursorRawQuery.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    sQLiteDatabaseA.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f646a) {
            case 1:
                return ListenableFutureKt.executeAsync$lambda$4((Executor) this.f647b, (String) this.f648c, (g7.a) this.f649d, completer);
            default:
                return ListenableFutureKt.launchFuture$lambda$1((w6.h) this.f647b, (x) this.f648c, (g7.p) this.f649d, completer);
        }
    }

    @Override // x.b
    public Object execute() {
        u.a aVar = (u.a) this.f647b;
        p.i iVar = (p.i) this.f648c;
        p.h hVar = (p.h) this.f649d;
        w.h hVar2 = (w.h) aVar.f12879d;
        hVar2.getClass();
        m.d dVar = iVar.f11857c;
        String str = hVar.f11849a;
        String str2 = iVar.f11855a;
        String strC = t1.C("SQLiteEventStore");
        if (Log.isLoggable(strC, 3)) {
            Log.d(strC, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) hVar2.d(new a(hVar2, hVar, iVar, 4))).longValue();
        aVar.f12876a.g(iVar, 1, false);
        return null;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f647b, (Transition) this.f649d, (Runnable) this.f648c);
    }

    @Override // h1.h
    public p y(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f647b;
        String str = (String) this.f648c;
        q0 q0Var = (q0) this.f649d;
        String str2 = (String) obj;
        x4 x4VarC = FirebaseMessaging.c(firebaseMessaging.f2434b);
        l1.g gVar = firebaseMessaging.f2433a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f10178b) ? "" : gVar.d();
        String strB = firebaseMessaging.h.b();
        synchronized (x4VarC) {
            String strB2 = q0.b(str2, strB, System.currentTimeMillis());
            if (strB2 != null) {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) x4VarC.f10987b).edit();
                editorEdit.putString(strD + "|T|" + str + "|*", strB2);
                editorEdit.commit();
            }
        }
        if (q0Var == null || !str2.equals(q0Var.f8717a)) {
            l1.g gVar2 = firebaseMessaging.f2433a;
            gVar2.a();
            if ("[DEFAULT]".equals(gVar2.f10178b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                    gVar2.a();
                    sb.append(gVar2.f10178b);
                    Log.d("FirebaseMessaging", sb.toString());
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new j(firebaseMessaging.f2434b).b(intent);
            }
        }
        return r0.f.x(str2);
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i10) {
        this.f646a = i10;
        this.f647b = obj;
        this.f648c = obj2;
        this.f649d = obj3;
    }
}
