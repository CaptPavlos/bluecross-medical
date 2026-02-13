package c1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class o2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1386a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c3 f1387b;

    public /* synthetic */ o2(c3 c3Var, int i10) {
        this.f1386a = i10;
        this.f1387b = c3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1386a) {
            case 0:
                this.f1387b.D();
                break;
            case 1:
                t1 t1Var = this.f1387b.f1087r;
                u1 u1Var = t1Var.f1464a;
                r1 r1Var = u1Var.g;
                c3 c3Var = u1Var.f1483m;
                h1 h1Var = u1Var.e;
                u1.m(r1Var);
                r1Var.g();
                if (t1Var.d()) {
                    if (t1Var.b()) {
                        u1.k(h1Var);
                        h1Var.f1259w.o(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        u1.l(c3Var);
                        c3Var.n("auto", "_cmpx", bundle);
                    } else {
                        u1.k(h1Var);
                        g1 g1Var = h1Var.f1259w;
                        String strN = g1Var.n();
                        if (TextUtils.isEmpty(strN)) {
                            w0 w0Var = u1Var.f;
                            u1.m(w0Var);
                            w0Var.g.b("Cache still valid but referrer not found");
                        } else {
                            long jA = h1Var.f1260x.a() / 3600000;
                            Uri uri = Uri.parse(strN);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(uri.getPath(), bundle2);
                            for (String str : uri.getQueryParameterNames()) {
                                bundle2.putString(str, uri.getQueryParameter(str));
                            }
                            ((Bundle) pair.second).putLong("_cc", (jA - 1) * 3600000);
                            Object obj = pair.first;
                            String str2 = obj == null ? MBridgeConstans.DYNAMIC_VIEW_WX_APP : (String) obj;
                            u1.l(c3Var);
                            c3Var.n(str2, "_cmp", (Bundle) pair.second);
                        }
                        g1Var.o(null);
                    }
                    u1.k(h1Var);
                    h1Var.f1260x.b(0L);
                    break;
                }
                break;
            case 2:
                c3 c3Var2 = this.f1387b;
                c3Var2.g();
                u1 u1Var2 = c3Var2.f1149a;
                h1 h1Var2 = u1Var2.e;
                w0 w0Var2 = u1Var2.f;
                u1.k(h1Var2);
                d1 d1Var = h1Var2.t;
                if (d1Var.a()) {
                    u1.m(w0Var2);
                    w0Var2.f1544m.b("Deferred Deep Link already retrieved. Not fetching again.");
                    break;
                } else {
                    e1 e1Var = h1Var2.f1257u;
                    long jA2 = e1Var.a();
                    e1Var.b(1 + jA2);
                    if (jA2 >= 5) {
                        u1.m(w0Var2);
                        w0Var2.f1540i.b("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        d1Var.b(true);
                        break;
                    } else {
                        if (c3Var2.t == null) {
                            c3Var2.t = new p2(c3Var2, u1Var2, 3);
                        }
                        c3Var2.t.b(0L);
                        break;
                    }
                }
            default:
                this.f1387b.D();
                break;
        }
    }
}
