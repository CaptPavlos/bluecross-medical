package l1;

import a3.z0;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements q2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10168a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10169b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10170c;

    public /* synthetic */ c(Context context, String str) {
        this.f10168a = 1;
        this.f10169b = context;
        this.f10170c = str;
    }

    @Override // q2.b
    public final Object get() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        switch (this.f10168a) {
            case 0:
                g gVar = (g) this.f10170c;
                Context contextCreateDeviceProtectedStorageContext = (Context) this.f10169b;
                String strD = gVar.d();
                v2.a aVar = new v2.a();
                if (Build.VERSION.SDK_INT >= 24) {
                    contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(contextCreateDeviceProtectedStorageContext);
                }
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:".concat(strD), 0);
                boolean z9 = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z9 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager = contextCreateDeviceProtectedStorageContext.getPackageManager();
                        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextCreateDeviceProtectedStorageContext.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                            z9 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                aVar.f13120a = z9;
                return aVar;
            case 1:
                return new o2.i((Context) this.f10169b, (String) this.f10170c);
            default:
                q1.f fVar = (q1.f) this.f10170c;
                q1.a aVar2 = (q1.a) this.f10169b;
                return aVar2.f.c(new z0(aVar2, fVar));
        }
    }

    public /* synthetic */ c(int i10, Object obj, Object obj2) {
        this.f10168a = i10;
        this.f10170c = obj;
        this.f10169b = obj2;
    }
}
