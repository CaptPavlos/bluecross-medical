package p8;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {
    public static final o e;
    public static final o f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12135a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12136b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f12137c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f12138d;

    static {
        l[] lVarArr = {l.f12120k, l.f12122m, l.f12121l, l.f12123n, l.f12125p, l.f12124o, l.f12118i, l.f12119j, l.g, l.h, l.e, l.f, l.f12117d};
        n nVar = new n(true);
        String[] strArr = new String[13];
        for (int i10 = 0; i10 < 13; i10++) {
            strArr[i10] = lVarArr[i10].f12126a;
        }
        nVar.a(strArr);
        f0 f0Var = f0.TLS_1_0;
        f0[] f0VarArr = {f0.TLS_1_3, f0.TLS_1_2, f0.TLS_1_1, f0Var};
        boolean z9 = nVar.f12131a;
        if (z9) {
            String[] strArr2 = new String[f0VarArr.length];
            for (int i11 = 0; i11 < f0VarArr.length; i11++) {
                strArr2[i11] = f0VarArr[i11].f12095a;
            }
            nVar.b(strArr2);
        } else {
            androidx.window.layout.c.g("no TLS versions for cleartext connections");
        }
        if (!z9) {
            androidx.window.layout.c.g("no TLS extensions for cleartext connections");
            return;
        }
        nVar.f12134d = true;
        o oVar = new o(nVar);
        e = oVar;
        f0[] f0VarArr2 = {f0Var};
        boolean z10 = oVar.f12135a;
        if (!z10) {
            androidx.window.layout.c.g("no TLS versions for cleartext connections");
            return;
        }
        String[] strArr3 = new String[f0VarArr2.length];
        for (int i12 = 0; i12 < f0VarArr2.length; i12++) {
            strArr3[i12] = f0VarArr2[i12].f12095a;
        }
        if (!z10) {
            androidx.window.layout.c.g("no TLS versions for cleartext connections");
            return;
        }
        if (strArr3.length == 0) {
            com.google.gson.internal.a.n("At least one TLS version is required");
        } else if (z10) {
            f = new o(new n(false));
        } else {
            androidx.window.layout.c.g("no TLS extensions for cleartext connections");
        }
    }

    public o(n nVar) {
        this.f12135a = nVar.f12131a;
        this.f12137c = nVar.f12132b;
        this.f12138d = nVar.f12133c;
        this.f12136b = nVar.f12134d;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.f12135a) {
            return false;
        }
        String[] strArr = this.f12138d;
        if (strArr != null && !q8.c.o(q8.c.f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f12137c;
        return strArr2 == null || q8.c.o(l.f12115b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        o oVar = (o) obj;
        boolean z9 = oVar.f12135a;
        boolean z10 = this.f12135a;
        if (z10 != z9) {
            return false;
        }
        if (z10) {
            return Arrays.equals(this.f12137c, oVar.f12137c) && Arrays.equals(this.f12138d, oVar.f12138d) && this.f12136b == oVar.f12136b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f12135a) {
            return ((((527 + Arrays.hashCode(this.f12137c)) * 31) + Arrays.hashCode(this.f12138d)) * 31) + (!this.f12136b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String string;
        if (!this.f12135a) {
            return "ConnectionSpec()";
        }
        String string2 = "[all enabled]";
        String[] strArr = this.f12137c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(l.a(str));
            }
            string = DesugarCollections.unmodifiableList(arrayList).toString();
        } else {
            string = "[all enabled]";
        }
        String[] strArr2 = this.f12138d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                arrayList2.add(f0.a(str2));
            }
            string2 = DesugarCollections.unmodifiableList(arrayList2).toString();
        }
        return "ConnectionSpec(cipherSuites=" + string + ", tlsVersions=" + string2 + ", supportsTlsExtensions=" + this.f12136b + ")";
    }
}
