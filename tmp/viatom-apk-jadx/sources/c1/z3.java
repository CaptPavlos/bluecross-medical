package c1;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z3 extends q4 {

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1626d;
    public final e1 e;
    public final e1 f;
    public final e1 g;
    public final e1 h;

    /* renamed from: i, reason: collision with root package name */
    public final e1 f1627i;

    /* renamed from: j, reason: collision with root package name */
    public final e1 f1628j;

    public z3(v4 v4Var) {
        super(v4Var);
        this.f1626d = new HashMap();
        h1 h1Var = this.f1149a.e;
        u1.k(h1Var);
        this.e = new e1(h1Var, "last_delete_stale", 0L);
        h1 h1Var2 = this.f1149a.e;
        u1.k(h1Var2);
        this.f = new e1(h1Var2, "last_delete_stale_batch", 0L);
        h1 h1Var3 = this.f1149a.e;
        u1.k(h1Var3);
        this.g = new e1(h1Var3, "backoff", 0L);
        h1 h1Var4 = this.f1149a.e;
        u1.k(h1Var4);
        this.h = new e1(h1Var4, "last_upload", 0L);
        h1 h1Var5 = this.f1149a.e;
        u1.k(h1Var5);
        this.f1627i = new e1(h1Var5, "last_upload_attempt", 0L);
        h1 h1Var6 = this.f1149a.e;
        u1.k(h1Var6);
        this.f1628j = new e1(h1Var6, "midnight_offset", 0L);
    }

    public final Pair k(String str) {
        a0.a aVarA;
        y3 y3Var;
        g();
        u1 u1Var = this.f1149a;
        n0.a aVar = u1Var.f1481k;
        g gVar = u1Var.f1478d;
        aVar.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.f1626d;
        y3 y3Var2 = (y3) map.get(str);
        if (y3Var2 != null && jElapsedRealtime < y3Var2.f1608c) {
            return new Pair(y3Var2.f1606a, Boolean.valueOf(y3Var2.f1607b));
        }
        long jN = gVar.n(str, f0.f1157b) + jElapsedRealtime;
        try {
            try {
                aVarA = a0.b.a(u1Var.f1475a);
            } catch (PackageManager.NameNotFoundException unused) {
                if (y3Var2 != null && jElapsedRealtime < y3Var2.f1608c + gVar.n(str, f0.f1159c)) {
                    return new Pair(y3Var2.f1606a, Boolean.valueOf(y3Var2.f1607b));
                }
                aVarA = null;
            }
        } catch (Exception e) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1544m.c(e, "Unable to get advertising id");
            y3Var = new y3(jN, false, "");
        }
        if (aVarA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = aVarA.f5b;
        y3Var = str2 != null ? new y3(jN, aVarA.f6c, str2) : new y3(jN, aVarA.f6c, "");
        map.put(str, y3Var);
        return new Pair(y3Var.f1606a, Boolean.valueOf(y3Var.f1607b));
    }

    public final String l(String str, boolean z9) throws NoSuchAlgorithmException {
        g();
        String str2 = z9 ? (String) k(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestX = b5.x();
        if (messageDigestX == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestX.digest(str2.getBytes())));
    }

    @Override // c1.q4
    public final void j() {
    }
}
