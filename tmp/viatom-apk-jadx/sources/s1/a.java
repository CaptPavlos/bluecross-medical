package s1;

import android.os.Bundle;
import android.util.Log;
import c1.d0;
import i0.k;
import java.util.ArrayList;
import l4.n5;
import l4.p2;
import l4.x4;
import w1.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements v1.a, u1.a, q2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f12513a;

    public /* synthetic */ a(b bVar) {
        this.f12513a = bVar;
    }

    @Override // q2.a
    public void b(q2.b bVar) {
        b bVar2 = this.f12513a;
        t1.d dVar = t1.d.f12753a;
        dVar.b("AnalyticsConnector now available.");
        n1.a aVar = (n1.a) bVar.get();
        x4 x4Var = new x4(aVar, 21);
        k kVar = new k(25, false);
        n1.b bVar3 = (n1.b) aVar;
        d0 d0VarB = bVar3.b("clx", kVar);
        if (d0VarB == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            }
            d0VarB = bVar3.b("crash", kVar);
            if (d0VarB != null) {
                Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if (d0VarB == null) {
            dVar.d("Could not register Firebase Analytics listener; a listener is already registered.", null);
            return;
        }
        dVar.b("Registered Firebase Analytics listener.");
        n5 n5Var = new n5(23);
        p2 p2Var = new p2(x4Var);
        synchronized (bVar2) {
            try {
                ArrayList arrayList = bVar2.f12516c;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    n5Var.q((n) obj);
                }
                kVar.f8924c = n5Var;
                kVar.f8923b = p2Var;
                bVar2.f12515b = n5Var;
                bVar2.f12514a = p2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // u1.a
    public void k(Bundle bundle) {
        this.f12513a.f12514a.k(bundle);
    }

    @Override // v1.a
    public void q(n nVar) {
        b bVar = this.f12513a;
        synchronized (bVar) {
            try {
                if (bVar.f12515b instanceof v1.b) {
                    bVar.f12516c.add(nVar);
                }
                bVar.f12515b.q(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
