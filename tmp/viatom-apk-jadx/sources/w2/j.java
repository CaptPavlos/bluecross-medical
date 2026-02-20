package w2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import l4.n5;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f13444c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static c0 f13445d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13446a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13447b;

    public j(n5 n5Var) throws JSONException {
        this.f13446a = n5Var.c0("gcm.n.title");
        n5Var.Z("gcm.n.title");
        Object[] objArrY = n5Var.Y("gcm.n.title");
        if (objArrY != null) {
            String[] strArr = new String[objArrY.length];
            for (int i10 = 0; i10 < objArrY.length; i10++) {
                strArr[i10] = String.valueOf(objArrY[i10]);
            }
        }
        this.f13447b = n5Var.c0("gcm.n.body");
        n5Var.Z("gcm.n.body");
        Object[] objArrY2 = n5Var.Y("gcm.n.body");
        if (objArrY2 != null) {
            String[] strArr2 = new String[objArrY2.length];
            for (int i11 = 0; i11 < objArrY2.length; i11++) {
                strArr2[i11] = String.valueOf(objArrY2[i11]);
            }
        }
        n5Var.c0("gcm.n.icon");
        if (TextUtils.isEmpty(n5Var.c0("gcm.n.sound2"))) {
            n5Var.c0("gcm.n.sound");
        }
        n5Var.c0("gcm.n.tag");
        n5Var.c0("gcm.n.color");
        n5Var.c0("gcm.n.click_action");
        n5Var.c0("gcm.n.android_channel_id");
        String strC0 = n5Var.c0("gcm.n.link_android");
        strC0 = TextUtils.isEmpty(strC0) ? n5Var.c0("gcm.n.link") : strC0;
        if (!TextUtils.isEmpty(strC0)) {
            Uri.parse(strC0);
        }
        n5Var.c0("gcm.n.image");
        n5Var.c0("gcm.n.ticker");
        n5Var.V("gcm.n.notification_priority");
        n5Var.V("gcm.n.visibility");
        n5Var.V("gcm.n.notification_count");
        n5Var.U("gcm.n.sticky");
        n5Var.U("gcm.n.local_only");
        n5Var.U("gcm.n.default_sound");
        n5Var.U("gcm.n.default_vibrate_timings");
        n5Var.U("gcm.n.default_light_settings");
        n5Var.a0();
        n5Var.X();
        n5Var.d0();
    }

    public static h1.p a(Context context, Intent intent, boolean z9) {
        c0 c0Var;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f13444c) {
            try {
                if (f13445d == null) {
                    f13445d = new c0(context);
                }
                c0Var = f13445d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z9) {
            return c0Var.b(intent).d(new androidx.arch.core.executor.a(2), new p8.u(21));
        }
        if (r.y().A(context)) {
            z.h(context, c0Var, intent);
        } else {
            c0Var.b(intent);
        }
        return r0.f.x(-1);
    }

    public h1.p b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = (Context) this.f13446a;
        androidx.arch.core.executor.a aVar = (androidx.arch.core.executor.a) this.f13447b;
        boolean z9 = n0.b.a() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z10 = (intent.getFlags() & 268435456) != 0;
        return (!z9 || z10) ? r0.f.m(aVar, new Callable() { // from class: w2.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i10;
                ComponentName componentNameStartService;
                Context context2 = context;
                Intent intent2 = intent;
                r rVarY = r.y();
                rVarY.getClass();
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Starting service");
                }
                ((ArrayDeque) rVarY.e).offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (rVarY) {
                    try {
                        str = (String) rVarY.f13462b;
                        if (str == null) {
                            ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                                Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                            } else {
                                if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                    if (str2.startsWith(".")) {
                                        rVarY.f13462b = context2.getPackageName() + serviceInfo.name;
                                    } else {
                                        rVarY.f13462b = serviceInfo.name;
                                    }
                                    str = (String) rVarY.f13462b;
                                }
                                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                            }
                            str = null;
                        }
                    } finally {
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (rVarY.A(context2)) {
                        componentNameStartService = z.j(context2, intent3);
                    } else {
                        componentNameStartService = context2.startService(intent3);
                        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
                    }
                    if (componentNameStartService == null) {
                        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                        i10 = MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR;
                    } else {
                        i10 = -1;
                    }
                } catch (IllegalStateException e) {
                    Log.e("FirebaseMessaging", "Failed to start service while in background: " + e);
                    i10 = 402;
                } catch (SecurityException e3) {
                    Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e3);
                    i10 = 401;
                }
                return Integer.valueOf(i10);
            }
        }).e(aVar, new h1.a() { // from class: w2.i
            @Override // h1.a
            public final Object a(h1.p pVar) {
                return (n0.b.a() && ((Integer) pVar.g()).intValue() == 402) ? j.a(context, intent, z10).d(new androidx.arch.core.executor.a(2), new p8.u(20)) : pVar;
            }
        }) : a(context, intent, z10);
    }

    public j(Context context) {
        this.f13446a = context;
        this.f13447b = new androidx.arch.core.executor.a(2);
    }

    public j(ExecutorService executorService) {
        this.f13447b = new ArrayMap();
        this.f13446a = executorService;
    }
}
