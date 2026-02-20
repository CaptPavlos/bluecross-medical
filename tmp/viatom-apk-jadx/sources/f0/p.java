package f0;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.a4;
import i0.v;
import i0.w;
import i0.x;
import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final l f8025a;

    /* renamed from: b, reason: collision with root package name */
    public static final l f8026b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile x f8027c;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8028d;
    public static Context e;

    static {
        new l(m.J("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 0);
        new l(m.J("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 1);
        f8025a = new l(m.J("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 2);
        f8026b = new l(m.J("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 3);
        f8028d = new Object();
    }

    public static synchronized void a(Context context) {
        if (e != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            e = context.getApplicationContext();
        }
    }

    public static s b(String str, n nVar, boolean z9, boolean z10) {
        try {
            c();
            y.g(e);
            try {
                x xVar = f8027c;
                q0.b bVar = new q0.b(e.getPackageManager());
                v vVar = (v) xVar;
                Parcel parcelG = vVar.G();
                int i10 = x0.a.f13569a;
                boolean z11 = true;
                parcelG.writeInt(1);
                int I = a4.I(parcelG, 20293);
                a4.F(parcelG, 1, str);
                a4.D(parcelG, 2, nVar);
                a4.O(parcelG, 3, 4);
                parcelG.writeInt(z9 ? 1 : 0);
                a4.O(parcelG, 4, 4);
                parcelG.writeInt(z10 ? 1 : 0);
                a4.M(parcelG, I);
                x0.a.c(parcelG, bVar);
                Parcel parcelC = vVar.c(parcelG, 5);
                if (parcelC.readInt() == 0) {
                    z11 = false;
                }
                parcelC.recycle();
                return z11 ? s.f8033d : new r(new k(z9, str, nVar));
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                return new s(false, "module call", e3);
            }
        } catch (r0.b e7) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
            return new s(false, "module init: ".concat(String.valueOf(e7.getMessage())), e7);
        }
    }

    public static void c() {
        x vVar;
        if (f8027c != null) {
            return;
        }
        y.g(e);
        synchronized (f8028d) {
            try {
                if (f8027c == null) {
                    IBinder iBinderB = r0.e.c(e, r0.e.f12301d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i10 = w.f8955b;
                    if (iBinderB == null) {
                        vVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        vVar = iInterfaceQueryLocalInterface instanceof x ? (x) iInterfaceQueryLocalInterface : new v(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 3);
                    }
                    f8027c = vVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
