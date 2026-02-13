package c1;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1563a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1564b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1565c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f1566d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public x1(n3 n3Var, Bundle bundle, k3 k3Var, k3 k3Var2, long j10) {
        this.f1563a = 2;
        this.f1564b = bundle;
        this.f1565c = k3Var;
        this.e = k3Var2;
        this.f1566d = j10;
        Objects.requireNonNull(n3Var);
        this.f = n3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1563a) {
            case 0:
                String str = (String) this.f1565c;
                d2 d2Var = (d2) this.f;
                String str2 = (String) this.f1564b;
                if (str2 != null) {
                    k3 k3Var = new k3((String) this.e, str2, this.f1566d);
                    v4 v4Var = d2Var.f1108a;
                    v4Var.b().g();
                    String str3 = v4Var.G;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    v4Var.G = str;
                    v4Var.F = k3Var;
                    break;
                } else {
                    v4 v4Var2 = d2Var.f1108a;
                    v4Var2.b().g();
                    String str4 = v4Var2.G;
                    if (str4 == null || str4.equals(str)) {
                        v4Var2.G = str;
                        v4Var2.F = null;
                        break;
                    }
                }
                break;
            case 1:
                c3 c3Var = (c3) this.f;
                String str5 = (String) this.f1564b;
                String str6 = (String) this.f1565c;
                c3Var.r(this.f1566d, this.e, str5, str6);
                break;
            default:
                n3 n3Var = (n3) this.f;
                Bundle bundle = (Bundle) this.f1564b;
                k3 k3Var2 = (k3) this.f1565c;
                k3 k3Var3 = (k3) this.e;
                n3Var.getClass();
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                b5 b5Var = n3Var.f1149a.f1479i;
                u1.k(b5Var);
                n3Var.q(k3Var2, k3Var3, this.f1566d, true, b5Var.o("screen_view", bundle, null, false));
                break;
        }
    }

    public /* synthetic */ x1(Object obj, String str, String str2, Object obj2, long j10, int i10) {
        this.f1563a = i10;
        this.f1564b = str;
        this.f1565c = str2;
        this.e = obj2;
        this.f1566d = j10;
        this.f = obj;
    }
}
