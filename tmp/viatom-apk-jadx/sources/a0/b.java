package a0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import e0.m;
import f0.f;
import i0.y;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public f0.a f7a;

    /* renamed from: b, reason: collision with root package name */
    public s0.d f8b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10d = new Object();
    public d e;
    public final Context f;
    public final long g;

    public b(Context context) {
        y.g(context);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : context;
        this.f9c = false;
        this.g = -1L;
    }

    public static a a(Context context) {
        b bVar = new b(context);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bVar.c();
            a aVarE = bVar.e();
            d(aVarE, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return aVarE;
        } finally {
        }
    }

    public static void d(a aVar, long j10, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (aVar != null) {
                map.put("limit_ad_tracking", true != aVar.f6c ? "0" : "1");
                String str = aVar.f5b;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j10));
            new c(map, 0).start();
        }
    }

    public final void b() {
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.f7a == null) {
                    return;
                }
                try {
                    if (this.f9c) {
                        m0.a.b().c(this.f, this.f7a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f9c = false;
                this.f8b = null;
                this.f7a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f9c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iB = f.f8003b.b(context, 12451000);
                    if (iB != 0 && iB != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    f0.a aVar = new f0.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!m0.a.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f7a = aVar;
                        try {
                            IBinder iBinderA = aVar.a();
                            int i10 = s0.c.f12512a;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f8b = iInterfaceQueryLocalInterface instanceof s0.d ? (s0.d) iInterfaceQueryLocalInterface : new s0.b(iBinderA);
                            this.f9c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new m();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final a e() {
        a aVar;
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f9c) {
                    synchronized (this.f10d) {
                        d dVar = this.e;
                        if (dVar == null || !dVar.f16d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f9c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                y.g(this.f7a);
                y.g(this.f8b);
                try {
                    s0.b bVar = (s0.b) this.f8b;
                    bVar.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z9 = true;
                    Parcel parcelA = bVar.a(parcelObtain, 1);
                    String string = parcelA.readString();
                    parcelA.recycle();
                    s0.b bVar2 = (s0.b) this.f8b;
                    bVar2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i10 = s0.a.f12510a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelA2 = bVar2.a(parcelObtain2, 2);
                    if (parcelA2.readInt() == 0) {
                        z9 = false;
                    }
                    parcelA2.recycle();
                    aVar = new a(0, string, z9);
                } catch (RemoteException e3) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return aVar;
    }

    public final void f() {
        synchronized (this.f10d) {
            d dVar = this.e;
            if (dVar != null) {
                dVar.f15c.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.g;
            if (j10 > 0) {
                this.e = new d(this, j10);
            }
        }
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
