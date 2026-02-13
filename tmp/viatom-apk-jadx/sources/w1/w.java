package w1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.work.WorkRequest;
import j$.util.Objects;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {
    public static final Pattern g = Pattern.compile("[^\\p{Alnum}]");
    public static final String h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    public final e2.a f13400a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13401b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13402c;

    /* renamed from: d, reason: collision with root package name */
    public final r2.d f13403d;
    public final s e;
    public c f;

    public w(Context context, String str, r2.d dVar, s sVar) {
        if (context == null) {
            com.google.gson.internal.a.n("appContext must not be null");
            throw null;
        }
        if (str == null) {
            com.google.gson.internal.a.n("appIdentifier must not be null");
            throw null;
        }
        this.f13401b = context;
        this.f13402c = str;
        this.f13403d = dVar;
        this.e = sVar;
        this.f13400a = new e2.a(2);
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        String str2 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str2, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final v b(boolean z9) {
        String str;
        String str2 = null;
        if (!((Boolean) new x1.c(0, x1.e.f13575d, x1.d.class, "isNotMainThread", "isNotMainThread()Z", 0, 2).invoke()).booleanValue()) {
            String str3 = "Must not be called on a main thread, was called on " + Thread.currentThread().getName() + '.';
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str3, null);
            }
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        r2.d dVar = this.f13403d;
        if (z9) {
            try {
                str = ((r2.a) r0.f.j(((r2.c) dVar).e(), WorkRequest.MIN_BACKOFF_MILLIS, timeUnit)).f12343a;
            } catch (Exception e) {
                Log.w("FirebaseCrashlytics", "Error getting Firebase authentication token.", e);
            }
        } else {
            str = null;
        }
        try {
            str2 = (String) r0.f.j(((r2.c) dVar).d(), WorkRequest.MIN_BACKOFF_MILLIS, timeUnit);
        } catch (Exception e3) {
            Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", e3);
        }
        return new v(str2, str);
    }

    public final synchronized c c() {
        String str;
        c cVar = this.f;
        if (cVar != null && (cVar.f13325b != null || !this.e.a())) {
            return this.f;
        }
        t1.d dVar = t1.d.f12753a;
        dVar.c("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f13401b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        dVar.c("Cached Firebase Installation ID: " + string);
        if (this.e.a()) {
            v vVarB = b(false);
            dVar.c("Fetched Firebase Installation ID: " + vVarB.f13398a);
            if (vVarB.f13398a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                vVarB = new v(str, null);
            }
            if (Objects.equals(vVarB.f13398a, string)) {
                this.f = new c(sharedPreferences.getString("crashlytics.installation.id", null), vVarB.f13398a, vVarB.f13399b);
            } else {
                this.f = new c(a(sharedPreferences, vVarB.f13398a), vVarB.f13398a, vVarB.f13399b);
            }
        } else if (string == null || !string.startsWith("SYN_")) {
            this.f = new c(a(sharedPreferences, "SYN_" + UUID.randomUUID().toString()), null, null);
        } else {
            this.f = new c(sharedPreferences.getString("crashlytics.installation.id", null), null, null);
        }
        dVar.c("Install IDs: " + this.f);
        return this.f;
    }

    public final String d() {
        String str;
        e2.a aVar = this.f13400a;
        Context context = this.f13401b;
        synchronized (aVar) {
            try {
                if (aVar.f7626b == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    aVar.f7626b = installerPackageName;
                }
                str = "".equals(aVar.f7626b) ? null : aVar.f7626b;
            } finally {
            }
        }
        return str;
    }
}
