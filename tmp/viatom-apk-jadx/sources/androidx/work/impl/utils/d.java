package androidx.work.impl.utils;

import a3.x;
import android.util.Log;
import com.mbridge.msdk.foundation.download.Command;
import d5.n;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import w1.l;
import w1.p;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f762b;

    public /* synthetic */ d(Object obj, int i10) {
        this.f761a = i10;
        this.f762b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f761a) {
            case 0:
                return IdGenerator.nextAlarmManagerId$lambda$1((IdGenerator) this.f762b);
            case 1:
                n nVar = (n) ((a4.f) this.f762b).f219c;
                e2.a aVar = (e2.a) nVar.f;
                e2.e eVar = (e2.e) nVar.f7243i;
                String str = aVar.f7626b;
                x1.e.b();
                try {
                    HashMap mapB = e2.a.b(eVar);
                    x xVar = new x(str, mapB);
                    xVar.C(Command.HTTP_HEADER_USER_AGENT, "Crashlytics Android SDK/20.0.3");
                    xVar.C("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                    e2.a.a(xVar, eVar);
                    String strConcat = "Requesting settings from ".concat(str);
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", strConcat, null);
                    }
                    String str2 = "Settings query params were: " + mapB;
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", str2, null);
                    }
                    return aVar.c(xVar.A());
                } catch (IOException e) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e);
                    return null;
                }
            default:
                l lVar = ((p) this.f762b).g;
                lVar.getClass();
                x1.e.a();
                t1.c cVar = lVar.f13353c;
                c2.d dVar = (c2.d) cVar.f12752c;
                String str3 = (String) cVar.f12751b;
                dVar.getClass();
                boolean z9 = true;
                if (new File((File) dVar.f1643d, str3).exists()) {
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Found previous crash marker.", null);
                    }
                    c2.d dVar2 = (c2.d) cVar.f12752c;
                    dVar2.getClass();
                    new File((File) dVar2.f1643d, str3).delete();
                } else if (lVar.e() == null || !lVar.f13356j.c()) {
                    z9 = false;
                }
                return Boolean.valueOf(z9);
        }
    }
}
