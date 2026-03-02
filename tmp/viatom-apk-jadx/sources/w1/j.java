package w1;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13343a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f13344b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Thread f13345c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d5.n f13346d;
    public final /* synthetic */ l e;

    public j(l lVar, long j10, Throwable th, Thread thread, d5.n nVar) {
        this.e = lVar;
        this.f13343a = j10;
        this.f13344b = th;
        this.f13345c = thread;
        this.f13346d = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        c2.d dVar;
        String str;
        long j10 = this.f13343a;
        long j11 = j10 / 1000;
        l lVar = this.e;
        String strE = lVar.e();
        if (strE == null) {
            Log.e("FirebaseCrashlytics", "Tried to write a fatal exception while no session was open.", null);
            return r0.f.x(null);
        }
        lVar.f13353c.c();
        c2.d dVar2 = lVar.f13359m;
        dVar2.getClass();
        String strConcat = "Persisting fatal event for session ".concat(strE);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strConcat, null);
        }
        dVar2.j(this.f13344b, this.f13345c, "crash", new y1.c(strE, j11, t6.u.f12809a), true);
        try {
            dVar = lVar.g;
            str = ".ae" + j10;
            dVar.getClass();
        } catch (IOException e) {
            Log.w("FirebaseCrashlytics", "Could not create app exception marker file.", e);
        }
        if (!new File((File) dVar.f1643d, str).createNewFile()) {
            throw new IOException("Create new file failed.");
        }
        d5.n nVar = this.f13346d;
        lVar.b(false, nVar, false);
        lVar.c(new e().f13332a, Boolean.FALSE);
        return !lVar.f13352b.a() ? r0.f.x(null) : ((h1.i) ((AtomicReference) nVar.f7244j).get()).f8418a.j(lVar.e.f13576a, new n5(this, strE));
    }
}
