package c1;

import com.google.android.gms.internal.measurement.a6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1314a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n1 f1315b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1316c;

    public /* synthetic */ l1(n1 n1Var, String str, int i10) {
        this.f1314a = i10;
        this.f1315b = n1Var;
        this.f1316c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1314a) {
            case 0:
                return new com.google.android.gms.internal.measurement.l4(new l1(this.f1315b, this.f1316c, 1));
            case 1:
                n1 n1Var = this.f1315b;
                n nVar = n1Var.f1335b.f1520c;
                v4.U(nVar);
                String str = this.f1316c;
                b1 b1VarI0 = nVar.i0(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, str);
                n1Var.f1149a.f1478d.l();
                map.put("gmp_version", 133005L);
                if (b1VarI0 != null) {
                    String strN = b1VarI0.N();
                    if (strN != null) {
                        map.put("app_version", strN);
                    }
                    map.put("app_version_int", Long.valueOf(b1VarI0.P()));
                    map.put("dynamite_version", Long.valueOf(b1VarI0.b()));
                }
                return map;
            default:
                a4.f fVar = new a4.f(3, this.f1315b, this.f1316c);
                a6 a6Var = new a6("internal.remoteConfig", 0);
                a6Var.f1974b.put("getValue", new com.google.android.gms.internal.measurement.l4(a6Var, fVar));
                return a6Var;
        }
    }
}
