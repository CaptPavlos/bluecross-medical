package e2;

import a3.x;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7625a;

    /* renamed from: b, reason: collision with root package name */
    public String f7626b;

    public a(String str) {
        this.f7625a = 3;
        this.f7626b = str;
    }

    public static void a(x xVar, e eVar) {
        String str = eVar.f7635a;
        if (str != null) {
            xVar.C("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        xVar.C("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        xVar.C("X-CRASHLYTICS-API-CLIENT-VERSION", "20.0.3");
        xVar.C("Accept", "application/json");
        xVar.C("X-CRASHLYTICS-DEVICE-MODEL", eVar.f7636b);
        String str2 = eVar.f7637c;
        if (str2 != null) {
            xVar.C("X-CRASHLYTICS-OS-BUILD-VERSION", str2);
        }
        String str3 = eVar.f7638d;
        if (str3 != null) {
            xVar.C("X-CRASHLYTICS-OS-DISPLAY-VERSION", str3);
        }
        String str4 = eVar.e.c().f13324a;
        if (str4 != null) {
            xVar.C("X-CRASHLYTICS-INSTALLATION-ID", str4);
        }
    }

    public static HashMap b(e eVar) {
        HashMap map = new HashMap();
        map.put("build_version", eVar.h);
        map.put("display_version", eVar.g);
        map.put("source", Integer.toString(eVar.f7639i));
        String str = eVar.f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject c(b2.a aVar) {
        String str = this.f7626b;
        int i10 = aVar.f824b;
        t1.d dVar = t1.d.f12753a;
        dVar.c("Settings response code was: " + i10);
        if (i10 == 200 || i10 == 201 || i10 == 202 || i10 == 203) {
            String str2 = aVar.f823a;
            try {
                return new JSONObject(str2);
            } catch (Exception e) {
                dVar.d("Failed to parse settings JSON from ".concat(str), e);
                dVar.d("Settings response " + str2, null);
                return null;
            }
        }
        String str3 = "Settings request failed; (status: " + i10 + ") from " + str;
        if (dVar.a(6)) {
            Log.e("FirebaseCrashlytics", str3, null);
        }
        return null;
    }

    public String toString() {
        switch (this.f7625a) {
            case 3:
                return a3.a.m(new StringBuilder("<"), this.f7626b, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i10) {
        this.f7625a = i10;
    }

    public a(String str, o2.e eVar) {
        this.f7625a = 0;
        this.f7626b = str;
    }
}
