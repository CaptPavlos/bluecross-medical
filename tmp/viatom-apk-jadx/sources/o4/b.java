package o4;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.nsd.NsdManager;
import android.os.Build;
import android.os.ResultReceiver;
import android.provider.Settings;
import androidx.multidex.MultiDexApplication;
import c1.y2;
import com.google.android.gms.internal.measurement.l5;
import i5.f;
import java.io.File;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import l4.n5;
import u4.c;
import u4.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b extends MultiDexApplication {
    public static Activity g;
    public static d h;

    /* renamed from: i, reason: collision with root package name */
    public static int f11710i;

    /* renamed from: j, reason: collision with root package name */
    public static Context f11711j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f11712k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f11713l;

    /* renamed from: m, reason: collision with root package name */
    public static int f11714m;

    /* renamed from: n, reason: collision with root package name */
    public static String f11715n;

    /* renamed from: o, reason: collision with root package name */
    public static f f11716o;

    /* renamed from: p, reason: collision with root package name */
    public static u4.a f11717p;

    /* renamed from: q, reason: collision with root package name */
    public static b2.a f11718q;

    /* renamed from: r, reason: collision with root package name */
    public static Typeface f11719r;

    /* renamed from: s, reason: collision with root package name */
    public static Typeface f11720s;
    public static v4.f t;

    /* renamed from: u, reason: collision with root package name */
    public static v4.a f11721u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f11722v;

    /* renamed from: w, reason: collision with root package name */
    public static String f11723w;

    /* renamed from: x, reason: collision with root package name */
    public static String f11724x;
    public static String y;

    /* renamed from: z, reason: collision with root package name */
    public static String f11725z;

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f11726a = new f(3, null);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f11727b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f11728c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f11729d = new AtomicBoolean(false);
    public final n5 e = new n5(this, 15);
    public final a f = new a(this);

    public static void c(File file) {
        file.getClass();
        c cVar = new c();
        cVar.f12898a = file;
        cVar.f12899b = file.getName();
        cVar.f12900c = l5.y(file.getAbsolutePath());
        cVar.e = file.length();
        cVar.f = Build.MANUFACTURER + ' ' + Build.MODEL;
        v4.a aVar = f11721u;
        aVar.getClass();
        Socket socket = aVar.f13128d;
        if (socket == null || socket.isClosed()) {
            ((b) aVar.f13125a.f10654b).b();
            return;
        }
        t1.c cVar2 = aVar.f13127c;
        cVar2.getClass();
        new Thread(new r5.a(5, cVar2, cVar)).start();
    }

    public final void a(Context context) {
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        string.getClass();
        if (string.length() > 16) {
            string = string.substring(0, 15);
        }
        int length = string.length();
        int i10 = 51 - length;
        String str = Build.MANUFACTURER;
        str.getClass();
        String str2 = Build.MODEL;
        str2.getClass();
        String strSubstring = str + ' ' + str2;
        if (strSubstring.length() > i10) {
            strSubstring = strSubstring.substring(0, 50 - length);
        }
        f11715n = strSubstring + "_d:_" + string + "_:d__t:_0";
        v4.f fVar = t;
        n5 n5Var = this.e;
        if (fVar == null) {
            t = new v4.f(context, n5Var);
        }
        f11721u = new v4.a(context, n5Var);
    }

    public final void b() {
        NsdManager nsdManager;
        if (this.f11727b.compareAndSet(false, true)) {
            try {
                v4.f fVar = t;
                if (fVar != null && (nsdManager = fVar.f13135b) != null) {
                    nsdManager.unregisterService(this.f);
                }
            } catch (Exception unused) {
            }
            v4.a aVar = f11721u;
            if (aVar != null) {
                aVar.e();
            }
            v4.f fVar2 = t;
            if (fVar2 != null) {
                fVar2.c();
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        AssetManager assets;
        super.onCreate();
        registerActivityLifecycleCallbacks(new y2(this, 2));
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        f11711j = r0.f.h(applicationContext);
        try {
            assets = getAssets();
        } catch (Exception e) {
            e.printStackTrace();
            assets = null;
        }
        if (assets != null) {
            f11719r = Typeface.createFromAsset(assets, "fonts/Geomanist-Medium.ttf");
            f11720s = Typeface.createFromAsset(assets, "fonts/Geomanist-Regular.ttf");
        } else {
            Typeface typeface = Typeface.DEFAULT;
            f11719r = typeface;
            f11720s = typeface;
        }
    }
}
