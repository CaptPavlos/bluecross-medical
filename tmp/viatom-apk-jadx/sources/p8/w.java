package p8;

import com.google.android.gms.internal.measurement.l5;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements Cloneable {
    public static final List y = q8.c.l(x.HTTP_2, x.HTTP_1_1);

    /* renamed from: z, reason: collision with root package name */
    public static final List f12177z = q8.c.l(o.e, o.f);

    /* renamed from: a, reason: collision with root package name */
    public final i0.k f12178a;

    /* renamed from: b, reason: collision with root package name */
    public final List f12179b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12180c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12181d;
    public final List e;
    public final b f;
    public final ProxySelector g;
    public final b h;

    /* renamed from: i, reason: collision with root package name */
    public final g f12182i;

    /* renamed from: j, reason: collision with root package name */
    public final SocketFactory f12183j;

    /* renamed from: k, reason: collision with root package name */
    public final SSLSocketFactory f12184k;

    /* renamed from: l, reason: collision with root package name */
    public final l5 f12185l;

    /* renamed from: m, reason: collision with root package name */
    public final y8.c f12186m;

    /* renamed from: n, reason: collision with root package name */
    public final j f12187n;

    /* renamed from: o, reason: collision with root package name */
    public final b f12188o;

    /* renamed from: p, reason: collision with root package name */
    public final b f12189p;

    /* renamed from: q, reason: collision with root package name */
    public final m f12190q;

    /* renamed from: r, reason: collision with root package name */
    public final b f12191r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f12192s;
    public final boolean t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f12193u;

    /* renamed from: v, reason: collision with root package name */
    public final int f12194v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12195w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12196x;

    static {
        b.e = new b();
    }

    public w(v vVar) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        boolean z9;
        this.f12178a = vVar.f12160a;
        this.f12179b = vVar.f12161b;
        List list = vVar.f12162c;
        this.f12180c = list;
        this.f12181d = q8.c.k(vVar.f12163d);
        this.e = q8.c.k(vVar.e);
        this.f = vVar.f;
        this.g = vVar.g;
        this.h = vVar.h;
        this.f12182i = vVar.f12164i;
        this.f12183j = vVar.f12165j;
        Iterator it = list.iterator();
        loop0: while (true) {
            z9 = false;
            while (it.hasNext()) {
                z9 = (z9 || ((o) it.next()).f12135a) ? true : z9;
            }
        }
        if (z9) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        try {
                            x8.h hVar = x8.h.f13740a;
                            SSLContext sSLContextG = hVar.g();
                            sSLContextG.init(null, new TrustManager[]{x509TrustManager}, null);
                            this.f12184k = sSLContextG.getSocketFactory();
                            this.f12185l = hVar.c(x509TrustManager);
                        } catch (GeneralSecurityException e) {
                            throw q8.c.a("No System TLS", e);
                        }
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e3) {
                throw q8.c.a("No System TLS", e3);
            }
        }
        this.f12184k = null;
        this.f12185l = null;
        this.f12186m = vVar.f12166k;
        j jVar = vVar.f12167l;
        l5 l5Var = this.f12185l;
        this.f12187n = q8.c.i(jVar.f12114b, l5Var) ? jVar : new j(jVar.f12113a, l5Var);
        this.f12188o = vVar.f12168m;
        this.f12189p = vVar.f12169n;
        this.f12190q = vVar.f12170o;
        this.f12191r = vVar.f12171p;
        this.f12192s = vVar.f12172q;
        this.t = vVar.f12173r;
        this.f12193u = vVar.f12174s;
        this.f12194v = vVar.t;
        this.f12195w = vVar.f12175u;
        this.f12196x = vVar.f12176v;
        if (this.f12181d.contains(null)) {
            com.google.gson.internal.a.l(this.f12181d, "Null interceptor: ");
            throw null;
        }
        if (this.e.contains(null)) {
            com.google.gson.internal.a.l(this.e, "Null network interceptor: ");
            throw null;
        }
    }
}
