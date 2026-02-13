package c1;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public int f1471a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1472b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1473c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1474d;

    public u0(w0 w0Var, int i10, boolean z9, boolean z10) {
        this.f1474d = w0Var;
        this.f1471a = i10;
        this.f1472b = z9;
        this.f1473c = z10;
    }

    public p8.o a(SSLSocket sSLSocket) throws UnknownServiceException {
        boolean z9;
        p8.o oVar;
        int i10 = this.f1471a;
        List list = (List) this.f1474d;
        int size = list.size();
        while (true) {
            z9 = true;
            if (i10 >= size) {
                oVar = null;
                break;
            }
            oVar = (p8.o) list.get(i10);
            if (oVar.a(sSLSocket)) {
                this.f1471a = i10 + 1;
                break;
            }
            i10++;
        }
        if (oVar == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.f1473c);
            sb.append(", modes=");
            sb.append(list);
            String string = Arrays.toString(sSLSocket.getEnabledProtocols());
            sb.append(", supported protocols=");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i11 = this.f1471a;
        while (true) {
            if (i11 >= list.size()) {
                z9 = false;
                break;
            }
            if (((p8.o) list.get(i11)).a(sSLSocket)) {
                break;
            }
            i11++;
        }
        this.f1472b = z9;
        p8.b bVar = p8.b.e;
        boolean z10 = this.f1473c;
        bVar.getClass();
        String[] strArr = oVar.f12138d;
        String[] strArr2 = oVar.f12137c;
        String[] strArrM = strArr2 != null ? q8.c.m(p8.l.f12115b, sSLSocket.getEnabledCipherSuites(), strArr2) : sSLSocket.getEnabledCipherSuites();
        String[] strArrM2 = strArr != null ? q8.c.m(q8.c.f, sSLSocket.getEnabledProtocols(), strArr) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        p8.k kVar = p8.l.f12115b;
        byte[] bArr = q8.c.f12289a;
        int length = supportedCipherSuites.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = -1;
                break;
            }
            if (kVar.compare(supportedCipherSuites[i12], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i12++;
        }
        if (z10 && i12 != -1) {
            String str = supportedCipherSuites[i12];
            int length2 = strArrM.length;
            String[] strArr3 = new String[length2 + 1];
            System.arraycopy(strArrM, 0, strArr3, 0, strArrM.length);
            strArr3[length2] = str;
            strArrM = strArr3;
        }
        p8.n nVar = new p8.n(oVar);
        nVar.a(strArrM);
        nVar.b(strArrM2);
        p8.o oVar2 = new p8.o(nVar);
        String[] strArr4 = oVar2.f12138d;
        if (strArr4 != null) {
            sSLSocket.setEnabledProtocols(strArr4);
        }
        String[] strArr5 = oVar2.f12137c;
        if (strArr5 != null) {
            sSLSocket.setEnabledCipherSuites(strArr5);
        }
        return oVar;
    }

    public void b(String str) {
        ((w0) this.f1474d).p(this.f1471a, this.f1472b, this.f1473c, str, null, null, null);
    }

    public void c(Object obj, String str) {
        ((w0) this.f1474d).p(this.f1471a, this.f1472b, this.f1473c, str, obj, null, null);
    }

    public void d(Object obj, String str, Object obj2) {
        ((w0) this.f1474d).p(this.f1471a, this.f1472b, this.f1473c, str, obj, obj2, null);
    }

    public void e(String str, Object obj, Object obj2, Object obj3) {
        ((w0) this.f1474d).p(this.f1471a, this.f1472b, this.f1473c, str, obj, obj2, obj3);
    }

    public u0(List list) {
        this.f1471a = 0;
        this.f1474d = list;
    }
}
