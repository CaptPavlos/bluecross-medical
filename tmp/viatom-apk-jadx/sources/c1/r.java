package c1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String f1420a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1421b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1422c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1423d;
    public final long e;
    public final u f;

    public r(u1 u1Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        u uVar;
        i0.y.d(str2);
        i0.y.d(str3);
        this.f1420a = str2;
        this.f1421b = str3;
        this.f1422c = true == TextUtils.isEmpty(str) ? null : str;
        this.f1423d = j10;
        this.e = j11;
        if (j11 != 0 && j11 > j10) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1540i.c(w0.o(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            uVar = new u(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f.b("Param name can't be null");
                    it.remove();
                } else {
                    b5 b5Var = u1Var.f1479i;
                    u1.k(b5Var);
                    Object objN = b5Var.n(bundle2.get(next), next);
                    if (objN == null) {
                        w0 w0Var3 = u1Var.f;
                        u1.m(w0Var3);
                        w0Var3.f1540i.c(u1Var.f1480j.b(next), "Param value can't be null");
                        it.remove();
                    } else {
                        b5 b5Var2 = u1Var.f1479i;
                        u1.k(b5Var2);
                        b5Var2.v(objN, next, bundle2);
                    }
                }
            }
            uVar = new u(bundle2);
        }
        this.f = uVar;
    }

    public final r a(u1 u1Var, long j10) {
        return new r(u1Var, this.f1422c, this.f1420a, this.f1421b, this.f1423d, j10, this.f);
    }

    public final String toString() {
        String string = this.f.toString();
        String str = this.f1420a;
        int length = String.valueOf(str).length();
        String str2 = this.f1421b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        return androidx.constraintlayout.core.widgets.analyzer.a.y(sb, "', params=", string, "}");
    }

    public r(u1 u1Var, String str, String str2, String str3, long j10, long j11, u uVar) {
        i0.y.d(str2);
        i0.y.d(str3);
        i0.y.g(uVar);
        this.f1420a = str2;
        this.f1421b = str3;
        this.f1422c = true == TextUtils.isEmpty(str) ? null : str;
        this.f1423d = j10;
        this.e = j11;
        if (j11 != 0 && j11 > j10) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1540i.d(w0.o(str2), "Event created with reverse previous/current timestamps. appId, name", w0.o(str3));
        }
        this.f = uVar;
    }
}
