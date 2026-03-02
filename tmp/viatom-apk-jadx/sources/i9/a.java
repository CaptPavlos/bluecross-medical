package i9;

import a3.x;
import a3.z0;
import a4.f;
import android.app.Application;
import android.net.ConnectivityManager;
import androidx.core.os.ConfigurationCompat;
import b9.h;
import c1.d0;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import d9.d;
import f6.m;
import f9.n;
import f9.p;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.l;
import o8.i;
import w2.r;
import y2.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {
    public static z0 A;
    public static p B;

    /* renamed from: a, reason: collision with root package name */
    public static Application f9105a;

    /* renamed from: b, reason: collision with root package name */
    public static c f9106b;

    /* renamed from: d, reason: collision with root package name */
    public static d9.c f9108d;
    public static d e;
    public static m f;
    public static i g;
    public static d0.i h;

    /* renamed from: i, reason: collision with root package name */
    public static d0 f9109i;

    /* renamed from: j, reason: collision with root package name */
    public static h f9110j;

    /* renamed from: k, reason: collision with root package name */
    public static n6.c f9111k;

    /* renamed from: l, reason: collision with root package name */
    public static m8.a f9112l;

    /* renamed from: o, reason: collision with root package name */
    public static j3.a f9115o;

    /* renamed from: p, reason: collision with root package name */
    public static d0 f9116p;

    /* renamed from: q, reason: collision with root package name */
    public static n f9117q;

    /* renamed from: r, reason: collision with root package name */
    public static r f9118r;

    /* renamed from: s, reason: collision with root package name */
    public static r f9119s;
    public static f t;

    /* renamed from: u, reason: collision with root package name */
    public static z0 f9120u;

    /* renamed from: v, reason: collision with root package name */
    public static d5.n f9121v;

    /* renamed from: w, reason: collision with root package name */
    public static x f9122w;

    /* renamed from: x, reason: collision with root package name */
    public static r f9123x;
    public static x y;

    /* renamed from: z, reason: collision with root package name */
    public static f f9124z;

    /* renamed from: c, reason: collision with root package name */
    public static ChoiceStyle f9107c = new ChoiceStyle();

    /* renamed from: m, reason: collision with root package name */
    public static String f9113m = "";

    /* renamed from: n, reason: collision with root package name */
    public static String f9114n = "";

    public static Locale a() {
        if (f9105a == null) {
            Locale locale = Locale.US;
            locale.getClass();
            return locale;
        }
        Locale locale2 = ConfigurationCompat.getLocales(b().getResources().getConfiguration()).get(0);
        if (locale2 == null) {
            locale2 = Locale.US;
        }
        locale2.getClass();
        return locale2;
    }

    public static Application b() {
        Application application = f9105a;
        if (application != null) {
            return application;
        }
        l.i(MimeTypes.BASE_TYPE_APPLICATION);
        throw null;
    }

    public static r c() {
        if (f9119s == null) {
            f9119s = new r(j(), k(), ChoiceCmp.INSTANCE.getCallback());
        }
        r rVar = f9119s;
        if (rVar != null) {
            return rVar;
        }
        l.i("consentRepository_");
        throw null;
    }

    public static f d() {
        if (t == null) {
            t = new f(j(), ChoiceCmp.INSTANCE.getCallback(), 24, false);
        }
        f fVar = t;
        if (fVar != null) {
            return fVar;
        }
        l.i("gbcConsentRepository_");
        throw null;
    }

    public static j3.a e() {
        if (f9115o == null) {
            j3.a aVar = new j3.a();
            aVar.f9911a = new HashMap();
            aVar.f9913c = false;
            aVar.f9914d = true;
            f9115o = aVar;
        }
        j3.a aVar2 = f9115o;
        if (aVar2 != null) {
            return aVar2;
        }
        l.i("gppModel");
        throw null;
    }

    public static m8.a f() {
        m8.a aVar = f9112l;
        return aVar != null ? aVar : new m8.a(15, null, null);
    }

    public static c g() {
        if (f9106b == null) {
            Object systemService = b().getSystemService("connectivity");
            if (systemService == null) {
                androidx.window.layout.c.k("null cannot be cast to non-null type android.net.ConnectivityManager");
                return null;
            }
            f9106b = new c((ConnectivityManager) systemService, 12);
        }
        c cVar = f9106b;
        if (cVar != null) {
            return cVar;
        }
        l.i("networkUtil_");
        throw null;
    }

    public static i h() {
        i iVar = g;
        return iVar != null ? iVar : new i(null, null, null, null, null, null, 0L, 255);
    }

    public static d0 i() {
        if (f9109i == null) {
            f9109i = new d0(6);
        }
        d0 d0Var = f9109i;
        if (d0Var != null) {
            return d0Var;
        }
        l.i("requestApi_");
        throw null;
    }

    public static d0.i j() {
        if (h == null) {
            h = new d0.i(b());
        }
        d0.i iVar = h;
        if (iVar != null) {
            return iVar;
        }
        l.i("storage_");
        throw null;
    }

    public static m k() {
        if (f == null) {
            f = new m();
        }
        m mVar = f;
        if (mVar != null) {
            return mVar;
        }
        l.i("tcModel");
        throw null;
    }

    public static h l() {
        if (f9110j == null) {
            m mVarK = k();
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            i portalConfig$app_release = choiceCmp.getPortalConfig$app_release();
            f9110j = new h(mVarK, portalConfig$app_release == null ? null : portalConfig$app_release.f11814b, g(), i(), choiceCmp.getCallback(), j(), choiceCmp.getAppPackageId());
        }
        h hVar = f9110j;
        if (hVar != null) {
            return hVar;
        }
        l.i("tracking");
        throw null;
    }

    public static d5.n m() {
        if (f9121v == null) {
            Locale localeA = a();
            c cVarG = g();
            d0.i iVarJ = j();
            d0 d0VarI = i();
            if (f9116p == null) {
                f9116p = new d0(12);
            }
            d0 d0Var = f9116p;
            if (d0Var == null) {
                l.i("coreUiLabelsResolver");
                throw null;
            }
            f9121v = new d5.n(localeA, cVarG, iVarJ, d0VarI, new f(d0Var));
        }
        d5.n nVar = f9121v;
        if (nVar != null) {
            return nVar;
        }
        l.i("translationsTextRepository_");
        throw null;
    }
}
