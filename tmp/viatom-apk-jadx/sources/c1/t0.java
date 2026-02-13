package c1;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1460a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f1461b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1462c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1463d;
    public final Object e;
    public final Object f;
    public final Object g;

    public /* synthetic */ t0(String str, y0 y0Var, int i10, IOException iOException, byte[] bArr, Map map) {
        i0.y.g(y0Var);
        this.f1463d = y0Var;
        this.f1461b = i10;
        this.e = iOException;
        this.f = bArr;
        this.f1462c = str;
        this.g = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1460a) {
            case 0:
                w0 w0Var = (w0) this.g;
                h1 h1Var = w0Var.f1149a.e;
                u1.k(h1Var);
                if (!h1Var.f1213b) {
                    Log.println(6, w0Var.q(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                if (w0Var.f1538c == 0) {
                    g gVar = w0Var.f1149a.f1478d;
                    if (gVar.e == null) {
                        synchronized (gVar) {
                            try {
                                if (gVar.e == null) {
                                    u1 u1Var = gVar.f1149a;
                                    ApplicationInfo applicationInfo = u1Var.f1475a.getApplicationInfo();
                                    String strA = n0.c.a();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        gVar.e = Boolean.valueOf(str != null && str.equals(strA));
                                    }
                                    if (gVar.e == null) {
                                        gVar.e = Boolean.TRUE;
                                        w0 w0Var2 = u1Var.f;
                                        u1.m(w0Var2);
                                        w0Var2.f.b("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (gVar.e.booleanValue()) {
                        w0Var.f1538c = 'C';
                    } else {
                        w0Var.f1538c = 'c';
                    }
                }
                if (w0Var.f1539d < 0) {
                    w0Var.f1149a.f1478d.l();
                    w0Var.f1539d = 133005L;
                }
                int i10 = this.f1461b;
                char c10 = w0Var.f1538c;
                long j10 = w0Var.f1539d;
                String str2 = this.f1462c;
                Object obj = this.f1463d;
                Object obj2 = this.e;
                Object obj3 = this.f;
                char cCharAt = "01VDIWEA?".charAt(i10);
                String strR = w0.r(true, str2, obj, obj2, obj3);
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 1 + String.valueOf(c10).length() + String.valueOf(j10).length() + 1 + strR.length());
                sb.append("2");
                sb.append(cCharAt);
                sb.append(c10);
                sb.append(j10);
                sb.append(":");
                sb.append(strR);
                String string = sb.toString();
                if (string.length() > 1024) {
                    string = str2.substring(0, 1024);
                }
                f1 f1Var = h1Var.e;
                if (f1Var != null) {
                    String str3 = (String) f1Var.f1212d;
                    h1 h1Var2 = (h1) f1Var.e;
                    h1Var2.g();
                    if (((h1) f1Var.e).k().getLong((String) f1Var.f1210b, 0L) == 0) {
                        f1Var.b();
                    }
                    SharedPreferences sharedPreferencesK = h1Var2.k();
                    String str4 = (String) f1Var.f1211c;
                    long j11 = sharedPreferencesK.getLong(str4, 0L);
                    if (j11 <= 0) {
                        SharedPreferences.Editor editorEdit = h1Var2.k().edit();
                        editorEdit.putString(str3, string);
                        editorEdit.putLong(str4, 1L);
                        editorEdit.apply();
                        return;
                    }
                    b5 b5Var = h1Var2.f1149a.f1479i;
                    u1.k(b5Var);
                    long jNextLong = b5Var.e0().nextLong() & Long.MAX_VALUE;
                    long j12 = j11 + 1;
                    long j13 = Long.MAX_VALUE / j12;
                    SharedPreferences.Editor editorEdit2 = h1Var2.k().edit();
                    if (jNextLong < j13) {
                        editorEdit2.putString(str3, string);
                    }
                    editorEdit2.putLong(str4, j12);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((y0) this.f1463d).c(this.f1462c, this.f1461b, (Throwable) this.e, (byte[]) this.f, (Map) this.g);
                return;
        }
    }

    public t0(w0 w0Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f1461b = i10;
        this.f1462c = str;
        this.f1463d = obj;
        this.e = obj2;
        this.f = obj3;
        this.g = w0Var;
    }
}
