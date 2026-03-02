package c1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class t1 implements e3 {

    /* renamed from: a, reason: collision with root package name */
    public final u1 f1464a;

    public /* synthetic */ t1(u1 u1Var) {
        this.f1464a = u1Var;
    }

    public void a(Bundle bundle, String str) {
        String string;
        u1 u1Var = this.f1464a;
        r1 r1Var = u1Var.g;
        h1 h1Var = u1Var.e;
        u1.m(r1Var);
        r1Var.g();
        if (u1Var.d()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        u1.k(h1Var);
        h1Var.f1259w.o(string);
        e1 e1Var = h1Var.f1260x;
        u1Var.f1481k.getClass();
        e1Var.b(System.currentTimeMillis());
    }

    public boolean b() {
        if (!d()) {
            return false;
        }
        u1 u1Var = this.f1464a;
        u1Var.f1481k.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        h1 h1Var = u1Var.e;
        u1.k(h1Var);
        return jCurrentTimeMillis - h1Var.f1260x.a() > u1Var.f1478d.n(null, f0.f1180k0);
    }

    @Override // c1.e3, c1.y0
    public /* synthetic */ void c(String str, int i10, Throwable th, byte[] bArr, Map map) {
        this.f1464a.i(i10, th, bArr);
    }

    public boolean d() {
        h1 h1Var = this.f1464a.e;
        u1.k(h1Var);
        return h1Var.f1260x.a() > 0;
    }
}
