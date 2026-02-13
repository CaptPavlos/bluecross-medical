package l1;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import c1.d0;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import i0.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import q1.m;
import r1.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f10175k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayMap f10176l = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f10177a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10178b;

    /* renamed from: c, reason: collision with root package name */
    public final i f10179c;

    /* renamed from: d, reason: collision with root package name */
    public final q1.f f10180d;
    public final m g;
    public final q2.b h;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f10181i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f10182j = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    public g(Context context, String str, i iVar) throws PackageManager.NameNotFoundException {
        ?? arrayList;
        int i10 = 0;
        this.f10177a = context;
        y.d(str);
        this.f10178b = str;
        this.f10179c = iVar;
        a aVar = FirebaseInitProvider.f2442a;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new q1.c((String) it.next(), i10));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        k kVar = k.f12340a;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        int i11 = 1;
        arrayList3.add(new q1.c(new FirebaseCommonRegistrar(), i11));
        arrayList3.add(new q1.c(new ExecutorsRegistrar(), i11));
        arrayList4.add(q1.a.c(context, Context.class, new Class[0]));
        arrayList4.add(q1.a.c(this, g.class, new Class[0]));
        arrayList4.add(q1.a.c(iVar, i.class, new Class[0]));
        d0 d0Var = new d0(5);
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.f2443b.get()) {
            arrayList4.add(q1.a.c(aVar, a.class, new Class[0]));
        }
        q1.f fVar = new q1.f(arrayList3, arrayList4, d0Var);
        this.f10180d = fVar;
        Trace.endSection();
        this.g = new m(new c(i10, this, context));
        this.h = fVar.c(o2.d.class);
        d dVar = new d(this);
        a();
        if (this.e.get()) {
            h0.c.e.f8355a.get();
        }
        this.f10181i.add(dVar);
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g c() {
        g gVar;
        synchronized (f10175k) {
            try {
                gVar = (g) f10176l.get("[DEFAULT]");
                if (gVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + n0.c.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((o2.d) gVar.h.get()).c();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g f(Context context) {
        synchronized (f10175k) {
            try {
                if (f10176l.containsKey("[DEFAULT]")) {
                    return c();
                }
                i iVarA = i.a(context);
                if (iVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return g(context, iVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g g(Context context, i iVar) {
        g gVar;
        AtomicReference atomicReference = e.f10172a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = e.f10172a;
            if (atomicReference2.get() == null) {
                e eVar = new e();
                while (true) {
                    if (atomicReference2.compareAndSet(null, eVar)) {
                        h0.c.b(application);
                        h0.c.e.a(eVar);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f10175k) {
            ArrayMap arrayMap = f10176l;
            y.i(!arrayMap.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            y.h(context, "Application context cannot be null.");
            gVar = new g(context, "[DEFAULT]", iVar);
            arrayMap.put("[DEFAULT]", gVar);
        }
        gVar.e();
        return gVar;
    }

    public final void a() {
        y.i(!this.f.get(), "FirebaseApp was deleted");
    }

    public final Object b(Class cls) {
        a();
        return this.f10180d.a(cls);
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f10178b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f10179c.f10188b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void e() {
        HashMap map;
        if (!UserManagerCompat.isUserUnlocked(this.f10177a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f10178b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f10177a;
            AtomicReference atomicReference = f.f10173b;
            if (atomicReference.get() == null) {
                f fVar = new f(context);
                while (!atomicReference.compareAndSet(null, fVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(fVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f10178b);
        Log.i("FirebaseApp", sb2.toString());
        q1.f fVar2 = this.f10180d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f10178b);
        AtomicReference atomicReference2 = fVar2.f;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (fVar2) {
                    map = new HashMap(fVar2.f12226a);
                }
                fVar2.g(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((o2.d) this.h.get()).c();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        gVar.a();
        return this.f10178b.equals(gVar.f10178b);
    }

    public final boolean h() {
        boolean z9;
        a();
        v2.a aVar = (v2.a) this.g.get();
        synchronized (aVar) {
            z9 = aVar.f13120a;
        }
        return z9;
    }

    public final int hashCode() {
        return this.f10178b.hashCode();
    }

    public final String toString() {
        i0.k kVar = new i0.k((Object) this);
        kVar.d(this.f10178b, RewardPlus.NAME);
        kVar.d(this.f10179c, "options");
        return kVar.toString();
    }
}
