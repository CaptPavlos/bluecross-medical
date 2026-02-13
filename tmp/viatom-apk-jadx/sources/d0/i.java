package d0;

import a3.m;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.preference.PreferenceManager;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import c1.a5;
import c1.c2;
import c1.d0;
import c1.j2;
import c1.n1;
import c1.u0;
import c1.u1;
import c1.v4;
import c1.w0;
import c5.x;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.y0;
import com.google.gson.internal.o;
import com.google.gson.reflect.TypeToken;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.workers.GetRemoteInstallWorker;
import e5.m1;
import g5.s;
import g5.w;
import h1.p;
import h5.c1;
import j4.l0;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import l4.a4;
import l4.p1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p8.v;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements c3.b, a5, h1.d, h1.f, s, SearchView.OnQueryTextListener, w {

    /* renamed from: c, reason: collision with root package name */
    public static i f6779c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6780a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6781b;

    public i(Context context, int i10) {
        long blockCountLong;
        String strD;
        this.f6780a = i10;
        switch (i10) {
            case 18:
                StringBuilder sb = l0.f9987a;
                File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    blockCountLong = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
                } catch (IllegalArgumentException unused) {
                    blockCountLong = 5242880;
                }
                long jMax = Math.max(Math.min(blockCountLong, 52428800L), 5242880L);
                v vVar = new v();
                vVar.f12164i = new p8.g(file, jMax);
                this.f6781b = new p8.w(vVar);
                break;
            default:
                b bVarA = b.a(context);
                this.f6781b = bVarA;
                bVarA.b();
                String strD2 = bVarA.d("defaultGoogleSignInAccount");
                if (!TextUtils.isEmpty(strD2) && (strD = bVarA.d(b.f("googleSignInOptions", strD2))) != null) {
                    try {
                        GoogleSignInOptions.b(strD);
                        break;
                    } catch (JSONException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    public static synchronized i E(Context context) {
        return H(context.getApplicationContext());
    }

    public static synchronized i H(Context context) {
        i iVar = f6779c;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(context, 0);
        f6779c = iVar2;
        return iVar2;
    }

    public static LinkedHashMap e(JSONObject jSONObject, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        itKeys.getClass();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                next.getClass();
                int iOptInt = jSONObjectOptJSONObject.optInt("id");
                String strOptString = jSONObjectOptJSONObject.optString(RewardPlus.NAME);
                strOptString.getClass();
                String strOptString2 = jSONObjectOptJSONObject.optString("description");
                strOptString2.getClass();
                linkedHashMap.put(next, new k8.b(iOptInt, strOptString, strOptString2, u(jSONObjectOptJSONObject, i10)));
            }
        }
        return linkedHashMap;
    }

    public static void r(i iVar, int i10, int i11, int i12) {
        iVar.getClass();
        if (i10 == 0 || i11 == 0 || i12 == 0) {
            throw null;
        }
        String str = "1" + com.mbridge.msdk.dycreator.baseview.a.d(i10) + com.mbridge.msdk.dycreator.baseview.a.d(i11) + com.mbridge.msdk.dycreator.baseview.a.d(i12);
        iVar.p(37, str);
        iVar.p(38, str);
    }

    public static String u(JSONObject jSONObject, int i10) {
        String string;
        if (i10 <= 2) {
            String strOptString = jSONObject.optString("descriptionLegal");
            strOptString.getClass();
            return strOptString;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("illustrations");
        if (jSONArrayOptJSONArray == null) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            int length = jSONArrayOptJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                sb.append(String.format("* %s", Arrays.copyOf(new Object[]{jSONArrayOptJSONArray.getString(i11)}, 1)));
                sb.append('\n');
            }
            string = sb.toString();
        }
        return string == null ? "" : string;
    }

    public static LinkedHashMap w(JSONObject jSONObject, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        itKeys.getClass();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                next.getClass();
                int iOptInt = jSONObjectOptJSONObject.optInt("id");
                String strOptString = jSONObjectOptJSONObject.optString(RewardPlus.NAME);
                strOptString.getClass();
                String strOptString2 = jSONObjectOptJSONObject.optString("description");
                strOptString2.getClass();
                linkedHashMap.put(next, new k8.f(iOptInt, strOptString, strOptString2, u(jSONObjectOptJSONObject, i10)));
            }
        }
        return linkedHashMap;
    }

    public static String x(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    public static i y(Object obj) {
        if (obj != null) {
            return new i(obj, 8);
        }
        androidx.window.layout.c.k("instance cannot be null");
        return null;
    }

    public void A(long j10, String str) {
        switch (this.f6780a) {
            case 11:
                m1 m1Var = (m1) this.f6781b;
                float f = UptodownApp.E;
                if (k4.c.s() && (m1Var.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity = m1Var.getActivity();
                    activity.getClass();
                    ((MainActivity) activity).Z(j10, str);
                    break;
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    ((FeedActivity) this.f6781b).Z(j10, str);
                    break;
                }
                break;
        }
    }

    public void B(long j10) {
        switch (this.f6780a) {
            case 11:
                m1 m1Var = (m1) this.f6781b;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    m1Var.a().e.setVisibility(0);
                    Context contextRequireContext = m1Var.requireContext();
                    contextRequireContext.getClass();
                    new x(contextRequireContext, LifecycleOwnerKt.getLifecycleScope(m1Var)).a(String.valueOf(j10), new y2.c(m1Var, 11));
                    break;
                }
                break;
            default:
                FeedActivity feedActivity = (FeedActivity) this.f6781b;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    int i10 = FeedActivity.L;
                    feedActivity.n0().f7198b.setVisibility(0);
                    new x(feedActivity, LifecycleOwnerKt.getLifecycleScope(feedActivity)).a(String.valueOf(j10), new y2.c(feedActivity, 24));
                    break;
                }
                break;
        }
    }

    public void C(o1.b bVar) {
        l1 l1Var = (l1) this.f6781b;
        ArrayList arrayList = l1Var.f2072c;
        synchronized (arrayList) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                try {
                    if (bVar.equals(((Pair) arrayList.get(i10)).first)) {
                        Log.w("FA", "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i1 i1Var = new i1(bVar);
            arrayList.add(new Pair(bVar, i1Var));
            if (l1Var.f != null) {
                try {
                    l1Var.f.registerOnMeasurementEventListener(i1Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w("FA", "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            l1Var.a(new y0(l1Var, i1Var, 5));
        }
    }

    public void D(int i10) {
        a4 a4Var = (a4) this.f6781b;
        TextView textView = a4Var.J;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1)));
        }
        ProgressBar progressBar = a4Var.H;
        if (progressBar != null) {
            progressBar.setProgress(i10);
        }
    }

    public synchronized void F() {
        b bVar = (b) this.f6781b;
        ReentrantLock reentrantLock = bVar.f6767a;
        reentrantLock.lock();
        try {
            bVar.f6768b.edit().clear().apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void I(int i10, String str, List list, boolean z9, boolean z10) {
        u0 u0Var;
        n1 n1Var = (n1) this.f6781b;
        int i11 = i10 - 1;
        if (i11 == 0) {
            w0 w0Var = n1Var.f1149a.f;
            u1.m(w0Var);
            u0Var = w0Var.f1544m;
        } else if (i11 != 1) {
            if (i11 == 3) {
                w0 w0Var2 = n1Var.f1149a.f;
                u1.m(w0Var2);
                u0Var = w0Var2.f1545n;
            } else if (i11 != 4) {
                w0 w0Var3 = n1Var.f1149a.f;
                u1.m(w0Var3);
                u0Var = w0Var3.f1543l;
            } else if (z9) {
                w0 w0Var4 = n1Var.f1149a.f;
                u1.m(w0Var4);
                u0Var = w0Var4.f1541j;
            } else if (z10) {
                w0 w0Var5 = n1Var.f1149a.f;
                u1.m(w0Var5);
                u0Var = w0Var5.f1540i;
            } else {
                w0 w0Var6 = n1Var.f1149a.f;
                u1.m(w0Var6);
                u0Var = w0Var6.f1542k;
            }
        } else if (z9) {
            w0 w0Var7 = n1Var.f1149a.f;
            u1.m(w0Var7);
            u0Var = w0Var7.g;
        } else if (z10) {
            w0 w0Var8 = n1Var.f1149a.f;
            u1.m(w0Var8);
            u0Var = w0Var8.f;
        } else {
            w0 w0Var9 = n1Var.f1149a.f;
            u1.m(w0Var9);
            u0Var = w0Var9.h;
        }
        int size = list.size();
        if (size == 1) {
            u0Var.c(list.get(0), str);
            return;
        }
        if (size == 2) {
            u0Var.d(list.get(0), str, list.get(1));
        } else if (size != 3) {
            u0Var.b(str);
        } else {
            u0Var.e(str, list.get(0), list.get(1), list.get(2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void J(c1.j2 r2, int r3) {
        /*
            r1 = this;
            r0 = -30
            if (r3 == r0) goto L1e
            r0 = -20
            if (r3 == r0) goto L1b
            r0 = -10
            if (r3 == r0) goto L18
            if (r3 == 0) goto L1b
            r0 = 30
            if (r3 == r0) goto L15
            c1.h r3 = c1.h.UNSET
            goto L20
        L15:
            c1.h r3 = c1.h.INITIALIZATION
            goto L20
        L18:
            c1.h r3 = c1.h.MANIFEST
            goto L20
        L1b:
            c1.h r3 = c1.h.API
            goto L20
        L1e:
            c1.h r3 = c1.h.TCF
        L20:
            java.lang.Object r0 = r1.f6781b
            java.util.EnumMap r0 = (java.util.EnumMap) r0
            r0.put(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.i.J(c1.j2, int):void");
    }

    public void K(j2 j2Var, c1.h hVar) {
        ((EnumMap) this.f6781b).put((EnumMap) j2Var, (j2) hVar);
    }

    public Object a(String str) throws NumberFormatException {
        switch (this.f6780a) {
            case 12:
                str.getClass();
                try {
                    this.f6781b = new JSONArray(str);
                    LinkedHashMap linkedHashMapD = d();
                    f6.d dVar = new f6.d();
                    dVar.f8073a = linkedHashMapD;
                    return dVar;
                } catch (JSONException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback != null) {
                        callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new f6.d();
                }
            default:
                str.getClass();
                try {
                    return f(new JSONObject(str));
                } catch (JSONException unused2) {
                    ChoiceCmpCallback callback2 = ChoiceCmp.INSTANCE.getCallback();
                    if (callback2 != null) {
                        callback2.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new k8.c();
                }
        }
    }

    @Override // c1.a5
    public void b(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        v4 v4Var = (v4) this.f6781b;
        if (!zIsEmpty) {
            v4Var.b().p(new c2(this, str, str2, bundle));
            return;
        }
        u1 u1Var = v4Var.f1525l;
        if (u1Var != null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(str2, "AppId not known when logging event");
        }
    }

    public String c(int i10, int i11) {
        String strT = t(38);
        return strT.length() > 0 ? strT.substring(i10, i11) : "";
    }

    public LinkedHashMap d() throws JSONException, NumberFormatException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = (JSONArray) this.f6781b;
        if (jSONArray == null) {
            kotlin.jvm.internal.l.i("googleVendorsJson");
            throw null;
        }
        int length = jSONArray.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            JSONArray jSONArray2 = (JSONArray) this.f6781b;
            if (jSONArray2 == null) {
                kotlin.jvm.internal.l.i("googleVendorsJson");
                throw null;
            }
            String string = jSONArray2.getString(i10);
            if (string == null) {
                string = "0";
            }
            JSONArray jSONArray3 = (JSONArray) this.f6781b;
            if (jSONArray3 == null) {
                kotlin.jvm.internal.l.i("googleVendorsJson");
                throw null;
            }
            JSONObject jSONObject = jSONArray3.getJSONObject(i10);
            String string2 = jSONObject.getString("provider_id");
            string2.getClass();
            int i12 = Integer.parseInt(string2);
            String string3 = jSONObject.getString("provider_name");
            string3.getClass();
            String string4 = jSONObject.getString("policy_url");
            string4.getClass();
            String string5 = jSONObject.getString("domains");
            string5.getClass();
            linkedHashMap.put(string, new f6.e(i12, string3, string4, string5));
            i10 = i11;
        }
        return linkedHashMap;
    }

    public k8.c f(JSONObject jSONObject) throws JSONException, ParseException {
        JSONObject jSONObject2;
        int i10;
        String str;
        LinkedHashMap linkedHashMap;
        String str2;
        LinkedHashMap linkedHashMap2;
        String str3;
        e2.c cVar;
        k8.c cVar2 = new k8.c();
        cVar2.f10081a = jSONObject.optInt("gvlSpecificationVersion");
        cVar2.f10082b = Integer.valueOf(jSONObject.optInt("vendorListVersion"));
        cVar2.f10083c = Integer.valueOf(jSONObject.optInt("tcfPolicyVersion"));
        String strOptString = jSONObject.optString("lastUpdated");
        strOptString.getClass();
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", (Locale) this.f6781b).parse(strOptString);
        if (date != null) {
            date.getTime();
        }
        String str4 = "purposes";
        JSONObject jSONObject3 = jSONObject.getJSONObject("purposes");
        jSONObject3.getClass();
        cVar2.f10084d = w(jSONObject3, cVar2.f10081a);
        String str5 = "specialPurposes";
        JSONObject jSONObject4 = jSONObject.getJSONObject("specialPurposes");
        jSONObject4.getClass();
        cVar2.e = w(jSONObject4, cVar2.f10081a);
        String str6 = "features";
        JSONObject jSONObject5 = jSONObject.getJSONObject("features");
        jSONObject5.getClass();
        cVar2.f = e(jSONObject5, cVar2.f10081a);
        JSONObject jSONObject6 = jSONObject.getJSONObject("specialFeatures");
        jSONObject6.getClass();
        cVar2.g = e(jSONObject6, cVar2.f10081a);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        JSONObject jSONObject7 = jSONObject.getJSONObject("stacks");
        Iterator<String> itKeys = jSONObject7.keys();
        itKeys.getClass();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject8 = jSONObject7.getJSONObject(next);
            next.getClass();
            int iOptInt = jSONObject8.optInt("id");
            String strOptString2 = jSONObject8.optString(RewardPlus.NAME);
            strOptString2.getClass();
            String strOptString3 = jSONObject8.optString("description");
            strOptString3.getClass();
            linkedHashMap3.put(next, new k8.g(iOptInt, strOptString2, strOptString3, new ArrayList(l1.b.d("purposes", jSONObject8)), new ArrayList(l1.b.d("specialFeatures", jSONObject8))));
        }
        cVar2.f10085i = linkedHashMap3;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("dataCategories");
        if (jSONObjectOptJSONObject != null) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
            itKeys2.getClass();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObject9 = jSONObjectOptJSONObject.getJSONObject(next2);
                next2.getClass();
                int iOptInt2 = jSONObject9.optInt("id");
                JSONObject jSONObject10 = jSONObjectOptJSONObject;
                String strOptString4 = jSONObject9.optString(RewardPlus.NAME);
                strOptString4.getClass();
                jSONObject9.optString("description").getClass();
                linkedHashMap4.put(next2, new k8.a(iOptInt2, strOptString4));
                jSONObjectOptJSONObject = jSONObject10;
            }
            cVar2.f10086j = linkedHashMap4;
        }
        int i11 = cVar2.f10081a;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("vendors");
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys3 = jSONObjectOptJSONObject2.keys();
            itKeys3.getClass();
            while (itKeys3.hasNext()) {
                String next3 = itKeys3.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next3);
                if (jSONObjectOptJSONObject3 != null) {
                    next3.getClass();
                    int iOptInt3 = jSONObjectOptJSONObject3.optInt("id");
                    String strOptString5 = jSONObjectOptJSONObject3.optString(RewardPlus.NAME);
                    Set setT0 = t6.l.t0(l1.b.d(str4, jSONObjectOptJSONObject3));
                    Set setT02 = t6.l.t0(l1.b.d("legIntPurposes", jSONObjectOptJSONObject3));
                    Set setT03 = t6.l.t0(l1.b.d("flexiblePurposes", jSONObjectOptJSONObject3));
                    Set setT04 = t6.l.t0(l1.b.d(str5, jSONObjectOptJSONObject3));
                    Set setT05 = t6.l.t0(l1.b.d(str6, jSONObjectOptJSONObject3));
                    Set setT06 = t6.l.t0(l1.b.d("specialFeatures", jSONObjectOptJSONObject3));
                    String strOptString6 = jSONObjectOptJSONObject3.optString("policyUrl", "");
                    String strOptString7 = jSONObjectOptJSONObject3.optString("deletedDate", "");
                    strOptString7.getClass();
                    LinkedHashSet linkedHashSet = null;
                    String str7 = strOptString7.length() == 0 ? null : strOptString7;
                    if (i11 > 2) {
                        jSONObjectOptJSONObject3.optInt("overflow");
                    } else {
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("overflow");
                        if (jSONObjectOptJSONObject4 != null) {
                            jSONObjectOptJSONObject4.optInt("httpGetLimit");
                        }
                    }
                    int iOptInt4 = jSONObjectOptJSONObject3.optInt("cookieMaxAgeSeconds");
                    jSONObjectOptJSONObject3.optBoolean("useCookies", false);
                    jSONObjectOptJSONObject3.optBoolean("cookieRefresh", false);
                    boolean zOptBoolean = jSONObjectOptJSONObject3.optBoolean("usesNonCookieAccess", false);
                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject("dataRetention");
                    if (jSONObjectOptJSONObject5 == null) {
                        jSONObject2 = jSONObjectOptJSONObject2;
                        str = str4;
                        i10 = i11;
                        str3 = str5;
                        str2 = str6;
                        cVar = null;
                    } else {
                        jSONObject2 = jSONObjectOptJSONObject2;
                        int iOptInt5 = jSONObjectOptJSONObject5.optInt("stdRetention");
                        i10 = i11;
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject(str4);
                        if (jSONObjectOptJSONObject6 == null) {
                            str = str4;
                            linkedHashMap = null;
                        } else {
                            str = str4;
                            linkedHashMap = new LinkedHashMap();
                            Iterator<String> itKeys4 = jSONObjectOptJSONObject6.keys();
                            itKeys4.getClass();
                            while (itKeys4.hasNext()) {
                                String str8 = str6;
                                String next4 = itKeys4.next();
                                next4.getClass();
                                linkedHashMap.put(next4, Integer.valueOf(jSONObjectOptJSONObject6.optInt(next4)));
                                jSONObjectOptJSONObject6 = jSONObjectOptJSONObject6;
                                str6 = str8;
                            }
                        }
                        str2 = str6;
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject(str5);
                        if (jSONObjectOptJSONObject7 == null) {
                            linkedHashMap2 = null;
                        } else {
                            linkedHashMap2 = new LinkedHashMap();
                            Iterator<String> itKeys5 = jSONObjectOptJSONObject7.keys();
                            itKeys5.getClass();
                            while (itKeys5.hasNext()) {
                                String str9 = str5;
                                String next5 = itKeys5.next();
                                next5.getClass();
                                linkedHashMap2.put(next5, Integer.valueOf(jSONObjectOptJSONObject7.optInt(next5)));
                                jSONObjectOptJSONObject7 = jSONObjectOptJSONObject7;
                                str5 = str9;
                            }
                        }
                        str3 = str5;
                        if (linkedHashMap2 == null) {
                            linkedHashMap2 = new LinkedHashMap();
                        }
                        cVar = new e2.c(iOptInt5, linkedHashMap, linkedHashMap2);
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("urls");
                    if (jSONArrayOptJSONArray != null) {
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                        int length = jSONArrayOptJSONArray.length();
                        for (int i12 = 0; i12 < length; i12++) {
                            JSONObject jSONObject11 = jSONArrayOptJSONArray.getJSONObject(i12);
                            jSONObject11.optString("langId").getClass();
                            jSONObject11.optString("privacy").getClass();
                            jSONObject11.optString("legIntClaim").getClass();
                            linkedHashSet2.add(new d0(19));
                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                        }
                        linkedHashSet = linkedHashSet2;
                    }
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    Set setT07 = t6.l.t0(l1.b.d("dataDeclaration", jSONObjectOptJSONObject3));
                    String strOptString8 = jSONObjectOptJSONObject3.optString("deviceStorageDisclosureUrl");
                    strOptString5.getClass();
                    strOptString6.getClass();
                    Boolean boolValueOf = Boolean.valueOf(zOptBoolean);
                    strOptString8.getClass();
                    linkedHashMap5.put(next3, new k8.h(iOptInt3, strOptString5, null, setT0, setT02, setT03, setT04, setT05, setT06, strOptString6, str7, iOptInt4, boolValueOf, setT07, cVar, linkedHashSet, strOptString8, 4));
                    jSONObjectOptJSONObject2 = jSONObject2;
                    i11 = i10;
                    str4 = str;
                    str6 = str2;
                    str5 = str3;
                }
            }
        }
        cVar2.h = linkedHashMap5;
        return cVar2;
    }

    @Override // g5.w
    public void g(ArrayList arrayList, int i10, boolean z9) {
        boolean zIsEmpty = arrayList.isEmpty();
        m0 m0Var = ((p1) this.f6781b).f10705a;
        if (zIsEmpty) {
            v5.l lVar = new v5.l(new l4.m1(new ArrayList(), 0));
            m0Var.getClass();
            m0Var.g(null, lVar);
        } else {
            v5.l lVar2 = new v5.l(new l4.m1(new ArrayList(arrayList), i10));
            m0Var.getClass();
            m0Var.g(null, lVar2);
        }
    }

    @Override // p6.a
    public Object get() {
        switch (this.f6780a) {
            case 1:
                return new m((q2.b) ((i) this.f6781b).f6781b);
            default:
                return this.f6781b;
        }
    }

    @Override // h1.f
    public void h(Object obj) {
        ((h1.i) ((y2.c) this.f6781b).f13781b).f8418a.m();
    }

    @Override // g5.v
    public void i() {
        m0 m0Var = ((p1) this.f6781b).f10705a;
        v5.l lVar = new v5.l(new l4.m1(new ArrayList(), 0));
        m0Var.getClass();
        m0Var.g(null, lVar);
    }

    @Override // g5.s
    public void j() {
        UptodownApp uptodownApp = (UptodownApp) this.f6781b;
        Context applicationContext = uptodownApp.getApplicationContext();
        applicationContext.getClass();
        if (c1.h(applicationContext) != null) {
            float f = UptodownApp.E;
            Context applicationContext2 = uptodownApp.getApplicationContext();
            applicationContext2.getClass();
            k4.c.A(applicationContext2);
            Context applicationContext3 = uptodownApp.getApplicationContext();
            applicationContext3.getClass();
            k4.c.B(applicationContext3);
            Context applicationContext4 = uptodownApp.getApplicationContext();
            applicationContext4.getClass();
            String string = null;
            try {
                SharedPreferences sharedPreferences = applicationContext4.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("fcmToken")) {
                    string = sharedPreferences.getString("fcmToken", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (string != null && string.length() != 0) {
                if (k4.c.o(applicationContext4, "GetRemoteInstallWorker")) {
                    WorkManager.Companion.getInstance(applicationContext4).cancelAllWorkByTag("GetRemoteInstallWorker");
                }
            } else {
                if (k4.c.o(applicationContext4, "GetRemoteInstallWorker")) {
                    return;
                }
                WorkManager.Companion.getInstance(applicationContext4).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetRemoteInstallWorker.class, 30L, TimeUnit.MINUTES).addTag("GetRemoteInstallWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
            }
        }
    }

    public void k(int i10) {
        if (i10 == 0) {
            throw null;
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.remove(com.mbridge.msdk.dycreator.baseview.a.c(i10));
        editorEdit.apply();
    }

    public void l(int i10, int i11) {
        if (i10 == 0) {
            throw null;
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.putInt(com.mbridge.msdk.dycreator.baseview.a.c(i10), i11);
        editorEdit.apply();
    }

    public void m(int i10, long j10) {
        if (i10 == 0) {
            throw null;
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.putLong(com.mbridge.msdk.dycreator.baseview.a.c(i10), j10);
        editorEdit.apply();
    }

    public void n(int i10, Vector vector) {
        if (i10 == 0) {
            throw null;
        }
        vector.getClass();
        com.google.gson.b bVar = new com.google.gson.b();
        StringBuilder sb = new StringBuilder();
        try {
            i3.b bVar2 = new i3.b(new o(sb));
            bVar2.m(bVar.g);
            bVar2.f8987i = bVar.f;
            bVar2.n(2);
            bVar2.f8989k = false;
            bVar.e(vector, Vector.class, bVar2);
            p(i10, sb.toString());
        } catch (IOException e) {
            throw new com.google.gson.e(e);
        }
    }

    @Override // h1.d
    public void o(p pVar) {
        ((CountDownLatch) this.f6781b).countDown();
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        str.getClass();
        l.d dVar = (l.d) this.f6781b;
        c.g gVar = dVar.f10155s;
        if (gVar == null) {
            kotlin.jvm.internal.l.i("switchAdapter");
            throw null;
        }
        l.e eVar = dVar.f10153q;
        if (eVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        ArrayList arrayListB = eVar.b(str);
        boolean z9 = str.length() > 0;
        gVar.f958a = arrayListB;
        if (!z9) {
            gVar.a();
        }
        gVar.notifyDataSetChanged();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    public void p(int i10, String str) {
        if (i10 == 0) {
            throw null;
        }
        str.getClass();
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.putString(com.mbridge.msdk.dycreator.baseview.a.c(i10), str);
        editorEdit.apply();
    }

    public void q(int i10, boolean z9) {
        if (i10 == 0) {
            throw null;
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.putBoolean(com.mbridge.msdk.dycreator.baseview.a.c(i10), z9);
        editorEdit.apply();
    }

    public void s(String str, String str2) {
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f6781b).edit();
        editorEdit.getClass();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public String t(int i10) {
        if (i10 == 0) {
            throw null;
        }
        String string = ((SharedPreferences) this.f6781b).getString(com.mbridge.msdk.dycreator.baseview.a.c(i10), "");
        return string == null ? "" : string;
    }

    public String toString() {
        switch (this.f6780a) {
            case 4:
                StringBuilder sb = new StringBuilder("1");
                for (j2 j2Var : j2.values()) {
                    c1.h hVar = (c1.h) ((EnumMap) this.f6781b).get(j2Var);
                    if (hVar == null) {
                        hVar = c1.h.UNSET;
                    }
                    sb.append(hVar.f1241a);
                }
                return sb.toString();
            case 9:
                return Collections.EMPTY_MAP.toString();
            default:
                return super.toString();
        }
    }

    public Vector v(int i10) {
        if (i10 == 0) {
            throw null;
        }
        try {
            return (Vector) new com.google.gson.b().b(t(i10), new TypeToken<Vector>() { // from class: com.inmobi.cmp.data.storage.SharedStorage$getVectorPreference$type$1
            }.f2600b);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.gson.internal.m z(com.google.gson.reflect.TypeToken r9, boolean r10) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.i.z(com.google.gson.reflect.TypeToken, boolean):com.google.gson.internal.m");
    }

    public i(int i10) {
        this.f6780a = i10;
        switch (i10) {
            case 9:
                Map map = Collections.EMPTY_MAP;
                this.f6781b = Collections.EMPTY_LIST;
                break;
            case 12:
                break;
            case 16:
                this.f6781b = new p();
                break;
            default:
                this.f6781b = new EnumMap(j2.class);
                break;
        }
    }

    public i(Application application) {
        this.f6780a = 17;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        defaultSharedPreferences.getClass();
        this.f6781b = defaultSharedPreferences;
    }

    public /* synthetic */ i(Object obj, int i10) {
        this.f6780a = i10;
        this.f6781b = obj;
    }

    public i(EnumMap enumMap) {
        this.f6780a = 4;
        EnumMap enumMap2 = new EnumMap(j2.class);
        this.f6781b = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
