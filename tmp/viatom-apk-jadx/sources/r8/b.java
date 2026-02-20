package r8;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import p8.a0;
import p8.b0;
import p8.t;
import p8.w;
import p8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12462a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12463b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f12462a = i10;
        this.f12463b = obj;
    }

    private final b0 b(t8.e eVar) {
        z zVar = eVar.f;
        s8.f fVar = eVar.f12867b;
        boolean z9 = !zVar.f12206b.equals(ShareTarget.METHOD_GET);
        w wVar = (w) this.f12463b;
        fVar.getClass();
        int i10 = eVar.f12870i;
        int i11 = eVar.f12871j;
        int i12 = eVar.f12872k;
        wVar.getClass();
        try {
            t8.b bVarI = fVar.d(i10, i11, i12, wVar.f12193u, z9).i(wVar, eVar, fVar);
            synchronized (fVar.f12739d) {
                fVar.f12743l = bVarI;
            }
            return eVar.b(zVar, fVar, bVarI, fVar.a());
        } catch (IOException e) {
            throw new s8.b(e);
        }
    }

    public static boolean c(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static b0 d(b0 b0Var) {
        if (b0Var == null || b0Var.g == null) {
            return b0Var;
        }
        a0 a0VarD = b0Var.d();
        a0VarD.g = null;
        return a0VarD.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0501 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0208  */
    @Override // p8.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p8.b0 a(t8.e r35) throws java.lang.InterruptedException, java.security.NoSuchAlgorithmException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.b.a(t8.e):p8.b0");
    }
}
