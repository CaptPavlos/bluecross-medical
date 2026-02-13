package h5;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public String f8679a;

    /* renamed from: b, reason: collision with root package name */
    public String f8680b;

    /* renamed from: c, reason: collision with root package name */
    public String f8681c;

    /* renamed from: d, reason: collision with root package name */
    public String f8682d;
    public String e;
    public String f;
    public String g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8683i;

    /* renamed from: j, reason: collision with root package name */
    public int f8684j;

    /* renamed from: k, reason: collision with root package name */
    public float f8685k;

    /* renamed from: l, reason: collision with root package name */
    public String f8686l;

    /* renamed from: m, reason: collision with root package name */
    public long f8687m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f8688n;

    /* renamed from: o, reason: collision with root package name */
    public String[] f8689o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f8690p;

    /* renamed from: q, reason: collision with root package name */
    public String f8691q;

    /* renamed from: r, reason: collision with root package name */
    public int f8692r;

    /* renamed from: s, reason: collision with root package name */
    public String f8693s;
    public int t;

    /* renamed from: u, reason: collision with root package name */
    public String f8694u;

    /* renamed from: v, reason: collision with root package name */
    public int f8695v;

    public static ArrayList c(ArrayList arrayList, Context context) {
        arrayList.getClass();
        context.getClass();
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
            systemAvailableFeatures.getClass();
            String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
            Iterator it = arrayList.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                String str = (String) next;
                boolean z9 = false;
                boolean zHasSystemFeature = false;
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    zHasSystemFeature = context.getPackageManager().hasSystemFeature(str);
                    if (!zHasSystemFeature && str.equalsIgnoreCase("android.hardware.ram.low")) {
                        zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.ram.normal");
                    }
                    if (zHasSystemFeature) {
                        break;
                    }
                }
                if (!zHasSystemFeature && systemSharedLibraryNames != null) {
                    int i10 = 0;
                    while (true) {
                        if (!(i10 < systemSharedLibraryNames.length)) {
                            break;
                        }
                        int i11 = i10 + 1;
                        try {
                            if (str.equalsIgnoreCase(systemSharedLibraryNames[i10])) {
                                z9 = true;
                                break;
                            }
                            i10 = i11;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            com.google.gson.internal.a.o(e.getMessage());
                            return null;
                        }
                    }
                }
                if (!zHasSystemFeature && !z9) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public final String a() {
        String string = this.f8679a + this.h;
        if (this.f8680b != null) {
            StringBuilder sbV = a3.a.v(string);
            sbV.append(this.f8680b);
            string = sbV.toString();
        }
        if (this.f8682d != null) {
            StringBuilder sbV2 = a3.a.v(string);
            sbV2.append(this.f8682d);
            string = sbV2.toString();
        }
        Charset charsetForName = Charset.forName(C.UTF8_NAME);
        charsetForName.getClass();
        byte[] bytes = string.getBytes(charsetForName);
        bytes.getClass();
        return l5.x(bytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r6) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r6)
            java.lang.String r6 = "success"
            boolean r1 = r0.isNull(r6)
            r2 = 0
            if (r1 != 0) goto L79
            int r6 = r0.optInt(r6)
            r1 = 1
            if (r6 != r1) goto L79
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r0.optJSONObject(r6)
            if (r6 == 0) goto L79
            java.lang.String r0 = "sdk"
            boolean r3 = r6.isNull(r0)
            if (r3 != 0) goto L2f
            int r3 = r5.h
            int r0 = r6.optInt(r0)
            if (r3 != r0) goto L2f
            r0 = r1
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 == 0) goto L78
            java.lang.String r0 = "userID"
            boolean r3 = r6.isNull(r0)
            r4 = 0
            if (r3 != 0) goto L47
            java.lang.String r0 = r6.optString(r0)
            java.lang.String r3 = "0"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L48
        L47:
            r0 = r4
        L48:
            java.lang.String r3 = r5.f8680b
            if (r0 != 0) goto L50
            if (r3 == 0) goto L50
        L4e:
            r0 = r2
            goto L59
        L50:
            if (r0 == 0) goto L55
            if (r3 != 0) goto L55
            goto L4e
        L55:
            boolean r0 = o7.u.Z(r0, r3, r1)
        L59:
            if (r0 == 0) goto L78
            java.lang.String r0 = "language"
            boolean r3 = r6.isNull(r0)
            if (r3 != 0) goto L67
            java.lang.String r4 = r6.optString(r0)
        L67:
            java.lang.String r6 = r5.f8682d
            if (r4 != 0) goto L6e
            if (r6 == 0) goto L6e
            goto L79
        L6e:
            if (r4 == 0) goto L73
            if (r6 != 0) goto L73
            goto L79
        L73:
            boolean r6 = o7.u.Z(r4, r6, r1)
            return r6
        L78:
            return r0
        L79:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.p.b(java.lang.String):boolean");
    }

    public final boolean d(q qVar) {
        List listU;
        String str = qVar.f8706k;
        if (str == null || this.f8688n == null) {
            return true;
        }
        Pattern patternCompile = Pattern.compile(",");
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listU = arrayList;
        } else {
            listU = a4.u(str.toString());
        }
        String[] strArr = (String[]) listU.toArray(new String[0]);
        String[] strArr2 = this.f8688n;
        strArr2.getClass();
        int length = strArr2.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (!o7.u.Z(strArr2[i10], "arm64-v8a", true)) {
                i10++;
            } else if (Build.VERSION.SDK_INT > 34) {
                boolean z9 = false;
                for (String str2 : strArr) {
                    if (o7.u.Z(str2, "arm64-v8a", true)) {
                        z9 = true;
                    }
                }
                return z9;
            }
        }
        String[] strArr3 = this.f8688n;
        strArr3.getClass();
        boolean z10 = false;
        for (String str3 : strArr3) {
            if (z10) {
                break;
            }
            for (String str4 : strArr) {
                if (o7.u.Z(str4, "universal", true) || o7.u.Z(str3, str4, true)) {
                    z10 = true;
                    break;
                }
            }
        }
        return z10;
    }

    public final boolean e(q qVar) {
        ArrayList arrayList = qVar.f8711p;
        if (arrayList == null || arrayList.size() <= 0) {
            return true;
        }
        ArrayList arrayList2 = qVar.f8711p;
        arrayList2.getClass();
        Iterator it = arrayList2.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            String str = (String) next;
            if (Integer.parseInt(str) == this.t || Integer.parseInt(str) == 65534 || Integer.parseInt(str) == 65535) {
                return true;
            }
        }
        return false;
    }

    public final void f(Context context) {
        context.getClass();
        this.f8679a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        e1 e1VarH = c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            this.f8680b = e1VarH.f8512a;
        } else {
            this.f8680b = null;
        }
        this.h = Build.VERSION.SDK_INT;
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                z9 = sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            this.f8692r = 1;
        }
    }

    public final void g(Context context) {
        context.getClass();
        f(context);
        this.f8683i = context.getResources().getDisplayMetrics().widthPixels;
        this.f8684j = context.getResources().getDisplayMetrics().heightPixels;
        this.f8685k = context.getResources().getDisplayMetrics().density;
        this.t = context.getResources().getDisplayMetrics().densityDpi;
        this.f8694u = context.getString(R.string.dpi_device);
        this.f8681c = Locale.getDefault().getCountry();
        this.f8682d = Locale.getDefault().getLanguage();
        this.e = Build.BRAND;
        this.g = Build.MANUFACTURER;
        this.f = Build.MODEL;
        Object systemService = context.getSystemService("phone");
        systemService.getClass();
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        this.f8686l = telephonyManager.getNetworkOperatorName();
        String str = this.f8681c;
        if (str == null || str.length() == 0) {
            this.f8681c = telephonyManager.getNetworkCountryIso();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService2 = context.getSystemService("activity");
            systemService2.getClass();
            ((ActivityManager) systemService2).getMemoryInfo(memoryInfo);
            this.f8687m = memoryInfo.totalMem;
        } catch (Error e) {
            e.getMessage();
        } catch (Exception e3) {
            e3.getMessage();
        }
        this.f8688n = Build.SUPPORTED_ABIS;
        this.f8689o = Build.SUPPORTED_32_BIT_ABIS;
        this.f8690p = Build.SUPPORTED_64_BIT_ABIS;
        this.f8691q = context.getString(R.string.version, context.getString(R.string.app_name), "7.04", "704");
        this.f8693s = Build.HARDWARE;
        float f = UptodownApp.E;
        if (k4.c.m(context)) {
            this.f8695v = 1;
        } else {
            this.f8695v = 0;
        }
    }

    public final JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.f8679a);
        jSONObject.put("userID", this.f8680b);
        jSONObject.put("country", this.f8681c);
        jSONObject.put("language", this.f8682d);
        jSONObject.put("brand", this.e);
        jSONObject.put("model", this.f);
        jSONObject.put("manufacturer", this.g);
        int i10 = this.h;
        if (i10 > 0) {
            jSONObject.put("sdk", i10);
        }
        int i11 = this.f8683i;
        if (i11 > 0) {
            jSONObject.put("displayWidth", i11);
        }
        int i12 = this.f8684j;
        if (i12 > 0) {
            jSONObject.put("displayHeight", i12);
        }
        float f = this.f8685k;
        if (f > 0.0f) {
            jSONObject.put("displayDensity", f);
        }
        String str = this.f8694u;
        if (str != null && str.length() > 0) {
            jSONObject.put("density", this.f8694u);
        }
        long j10 = this.f8687m;
        if (j10 > 0) {
            jSONObject.put("ram", j10);
        }
        jSONObject.put("operador", this.f8686l);
        String[] strArr = this.f8688n;
        if (strArr != null && strArr.length != 0) {
            JSONArray jSONArray = new JSONArray();
            int i13 = 0;
            while (true) {
                if (!(i13 < strArr.length)) {
                    break;
                }
                int i14 = i13 + 1;
                try {
                    jSONArray.put(strArr[i13]);
                    i13 = i14;
                } catch (ArrayIndexOutOfBoundsException e) {
                    com.google.gson.internal.a.o(e.getMessage());
                    return null;
                }
            }
            jSONObject.put("supportedABIs", jSONArray);
        }
        String[] strArr2 = this.f8689o;
        if (strArr2 != null && strArr2.length != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int i15 = 0;
            while (true) {
                if (!(i15 < strArr2.length)) {
                    break;
                }
                int i16 = i15 + 1;
                try {
                    jSONArray2.put(strArr2[i15]);
                    i15 = i16;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    com.google.gson.internal.a.o(e3.getMessage());
                    return null;
                }
            }
            jSONObject.put("supported32BitsABIs", jSONArray2);
        }
        String[] strArr3 = this.f8690p;
        if (strArr3 != null && strArr3.length != 0) {
            JSONArray jSONArray3 = new JSONArray();
            int i17 = 0;
            while (true) {
                if (!(i17 < strArr3.length)) {
                    break;
                }
                int i18 = i17 + 1;
                try {
                    jSONArray3.put(strArr3[i17]);
                    i17 = i18;
                } catch (ArrayIndexOutOfBoundsException e7) {
                    com.google.gson.internal.a.o(e7.getMessage());
                    return null;
                }
            }
            jSONObject.put("supported64BitsABIs", jSONArray3);
        }
        jSONObject.put("appVersion", this.f8691q);
        jSONObject.put("rooted", this.f8692r);
        jSONObject.put("isTV", this.f8695v);
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceInfo(identifier=");
        sb.append(this.f8679a);
        sb.append(", userId=");
        sb.append(this.f8680b);
        sb.append(", country=");
        sb.append(this.f8681c);
        sb.append(", language=");
        sb.append(this.f8682d);
        sb.append(", brand=");
        sb.append(this.e);
        sb.append(", model=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(this.g);
        sb.append(", sdk=");
        sb.append(this.h);
        sb.append(", displayWidth=");
        sb.append(this.f8683i);
        sb.append(", displayHeight=");
        sb.append(this.f8684j);
        sb.append(", displayDensity=");
        sb.append(this.f8685k);
        sb.append(", densityDpi=");
        sb.append(this.t);
        sb.append(", density=");
        sb.append(this.f8694u);
        sb.append(", operador=");
        sb.append(this.f8686l);
        sb.append(", ram=");
        sb.append(this.f8687m);
        sb.append(", supportedAbis=");
        String string = Arrays.toString(this.f8688n);
        string.getClass();
        sb.append(string);
        sb.append(", supported32BitsAbis=");
        String string2 = Arrays.toString(this.f8689o);
        string2.getClass();
        sb.append(string2);
        sb.append(", supported64BitsAbis=");
        String string3 = Arrays.toString(this.f8690p);
        string3.getClass();
        sb.append(string3);
        sb.append(", appVersion=");
        sb.append(this.f8691q);
        sb.append(", rooted=");
        sb.append(this.f8692r);
        sb.append(", hardware=");
        sb.append(this.f8693s);
        sb.append(", isTv=");
        return a3.a.k(sb, this.f8695v, ')');
    }
}
