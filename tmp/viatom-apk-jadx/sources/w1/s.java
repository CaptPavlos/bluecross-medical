package w1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f13391a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.g f13392b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13393c;

    /* renamed from: d, reason: collision with root package name */
    public h1.i f13394d;
    public boolean e;
    public boolean f;
    public Boolean g;
    public final h1.i h;

    public s(l1.g gVar) {
        Boolean boolValueOf;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj = new Object();
        this.f13393c = obj;
        this.f13394d = new h1.i();
        this.e = false;
        this.f = false;
        this.h = new h1.i();
        gVar.a();
        Context context = gVar.f10177a;
        this.f13392b = gVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        this.f13391a = sharedPreferences;
        if (sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.f = false;
            boolValueOf = Boolean.valueOf(sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            try {
                packageManager = context.getPackageManager();
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("FirebaseCrashlytics", "Could not read data collection permission from manifest", e);
            }
            Boolean boolValueOf2 = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            if (boolValueOf2 == null) {
                this.f = false;
                boolValueOf = null;
            } else {
                this.f = true;
                boolValueOf = Boolean.valueOf(Boolean.TRUE.equals(boolValueOf2));
            }
        }
        this.g = boolValueOf;
        synchronized (obj) {
            try {
                if (a()) {
                    this.f13394d.c(null);
                    this.e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean a() {
        boolean zH;
        Boolean bool = this.g;
        if (bool != null) {
            zH = bool.booleanValue();
        } else {
            try {
                zH = this.f13392b.h();
            } catch (IllegalStateException unused) {
                zH = false;
            }
        }
        b(zH);
        return zH;
    }

    public final void b(boolean z9) {
        String str = "Crashlytics automatic data collection " + (z9 ? "ENABLED" : "DISABLED") + " by " + (this.g == null ? "global Firebase setting" : this.f ? "firebase_crashlytics_collection_enabled manifest flag" : "API") + ".";
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
