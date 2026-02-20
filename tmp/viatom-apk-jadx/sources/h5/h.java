package h5;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements Parcelable {
    public static Parcelable.Creator<h> CREATOR = new g0.l(2);
    public long A;
    public int A0;
    public long B;
    public ArrayList B0;
    public int C;
    public transient ArrayList C0;
    public String D;
    public ArrayList D0;
    public String E;
    public h0 E0;
    public String F;
    public String F0;
    public String G;
    public int G0;
    public String H;
    public String I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public String M;
    public String N;
    public ArrayList O;
    public ArrayList P;
    public o0 Q;
    public String R;
    public String S;
    public String T;
    public int U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public long f8566a;

    /* renamed from: b, reason: collision with root package name */
    public String f8567b;

    /* renamed from: c, reason: collision with root package name */
    public String f8568c;

    /* renamed from: d, reason: collision with root package name */
    public long f8569d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public int f8570i;

    /* renamed from: j, reason: collision with root package name */
    public int f8571j;

    /* renamed from: j0, reason: collision with root package name */
    public String f8572j0;

    /* renamed from: k, reason: collision with root package name */
    public String f8573k;

    /* renamed from: k0, reason: collision with root package name */
    public long f8574k0;

    /* renamed from: l, reason: collision with root package name */
    public String f8575l;
    public String l0;

    /* renamed from: m, reason: collision with root package name */
    public String f8576m;

    /* renamed from: m0, reason: collision with root package name */
    public String f8577m0;

    /* renamed from: n, reason: collision with root package name */
    public String f8578n;

    /* renamed from: n0, reason: collision with root package name */
    public String f8579n0;

    /* renamed from: o, reason: collision with root package name */
    public String f8580o;

    /* renamed from: o0, reason: collision with root package name */
    public int f8581o0;

    /* renamed from: p, reason: collision with root package name */
    public int f8582p;

    /* renamed from: p0, reason: collision with root package name */
    public String f8583p0;

    /* renamed from: q, reason: collision with root package name */
    public int f8584q;

    /* renamed from: q0, reason: collision with root package name */
    public int f8585q0;

    /* renamed from: r, reason: collision with root package name */
    public int f8586r;

    /* renamed from: r0, reason: collision with root package name */
    public String f8587r0;

    /* renamed from: s, reason: collision with root package name */
    public int f8588s;

    /* renamed from: s0, reason: collision with root package name */
    public g f8589s0;
    public int t;

    /* renamed from: t0, reason: collision with root package name */
    public HashMap f8590t0;

    /* renamed from: u, reason: collision with root package name */
    public int f8591u;

    /* renamed from: u0, reason: collision with root package name */
    public int f8592u0;

    /* renamed from: v, reason: collision with root package name */
    public int f8593v;

    /* renamed from: v0, reason: collision with root package name */
    public String f8594v0;

    /* renamed from: w, reason: collision with root package name */
    public String f8595w;

    /* renamed from: w0, reason: collision with root package name */
    public int f8596w0;

    /* renamed from: x, reason: collision with root package name */
    public k f8597x;

    /* renamed from: x0, reason: collision with root package name */
    public int f8598x0;
    public int y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f8599y0;

    /* renamed from: z, reason: collision with root package name */
    public String f8600z;
    public int z0;

    public h(Parcel parcel) {
        this.f8569d = -1L;
        this.A = -1L;
        this.B = -1L;
        this.f8589s0 = g.f;
        this.f8590t0 = new HashMap();
        this.D0 = new ArrayList();
        this.G0 = 1;
        this.f8566a = parcel.readLong();
        this.f8567b = parcel.readString();
        this.f8568c = parcel.readString();
        this.f8569d = parcel.readLong();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.f8570i = parcel.readInt();
        this.f8571j = parcel.readInt();
        this.f8573k = parcel.readString();
        this.f8575l = parcel.readString();
        this.f8576m = parcel.readString();
        this.f8578n = parcel.readString();
        this.f8580o = parcel.readString();
        this.f8582p = parcel.readInt();
        this.f8584q = parcel.readInt();
        this.f8586r = parcel.readInt();
        this.f8588s = parcel.readInt();
        this.t = parcel.readInt();
        this.f8591u = parcel.readInt();
        this.f8593v = parcel.readInt();
        this.f8595w = parcel.readString();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            this.f8597x = (k) parcel.readParcelable(k.class.getClassLoader(), k.class);
        } else {
            this.f8597x = (k) parcel.readParcelable(k.class.getClassLoader());
        }
        this.y = parcel.readInt();
        this.f8600z = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.A = parcel.readLong();
        this.C = parcel.readInt();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.createStringArrayList();
        this.K = parcel.createStringArrayList();
        this.L = parcel.createStringArrayList();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.F = parcel.readString();
        this.U = parcel.readInt();
        this.X = parcel.readString();
        HashMap hashMap = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        hashMap.getClass();
        this.f8590t0 = hashMap;
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.f8572j0 = parcel.readString();
        this.f8574k0 = parcel.readLong();
        this.l0 = parcel.readString();
        this.f8581o0 = parcel.readInt();
        this.V = parcel.readString();
        this.T = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readString();
        this.f8577m0 = parcel.readString();
        this.f8579n0 = parcel.readString();
        this.f8583p0 = parcel.readString();
        this.f8585q0 = parcel.readInt();
        this.f8596w0 = parcel.readInt();
        this.f8598x0 = parcel.readInt();
        this.z0 = parcel.readInt();
        this.B0 = parcel.createStringArrayList();
        this.A0 = parcel.readInt();
        this.f8592u0 = parcel.readInt();
        this.f8594v0 = parcel.readString();
        parcel.readTypedList(this.D0, r.CREATOR);
        if (i10 >= 34) {
            this.E0 = (h0) parcel.readParcelable(h0.class.getClassLoader(), h0.class);
        } else {
            this.E0 = (h0) parcel.readParcelable(h0.class.getClassLoader());
        }
        this.F0 = parcel.readString();
        this.G0 = parcel.readInt();
    }

    public static long c(p0 p0Var) {
        JSONObject jSONObject;
        try {
            if (p0Var.b() || (jSONObject = p0Var.f8699d) == null) {
                return 0L;
            }
            int iOptInt = !jSONObject.isNull("success") ? jSONObject.optInt("success") : 0;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (iOptInt != 1 || jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.isNull("appID")) {
                return 0L;
            }
            return jSONObjectOptJSONObject.optLong("appID");
        } catch (JSONException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public final void a(Context context, JSONObject jSONObject) {
        if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (jSONObjectOptJSONObject != null) {
                n(context, jSONObjectOptJSONObject);
            }
        } else {
            n(context, jSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("videos");
        if (jSONArrayOptJSONArray != null) {
            this.P = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (jSONArrayOptJSONArray.get(i10) instanceof JSONObject) {
                    Object obj = jSONArrayOptJSONArray.get(i10);
                    obj.getClass();
                    JSONObject jSONObject2 = (JSONObject) obj;
                    l1 l1Var = new l1();
                    if (!jSONObject2.isNull("youtubeID")) {
                        l1Var.f8650a = jSONObject2.optString("youtubeID");
                    }
                    if (!jSONObject2.isNull("image")) {
                        l1Var.f8651b = jSONObject2.optString("image");
                    }
                    ArrayList arrayList = this.P;
                    arrayList.getClass();
                    arrayList.add(l1Var);
                }
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("screenshots");
        if (jSONArrayOptJSONArray2 != null) {
            this.O = new ArrayList();
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i11 = 0; i11 < length2; i11++) {
                if (jSONArrayOptJSONArray2.get(i11) instanceof JSONObject) {
                    Object obj2 = jSONArrayOptJSONArray2.get(i11);
                    obj2.getClass();
                    JSONObject jSONObject3 = (JSONObject) obj2;
                    u0 u0Var = new u0();
                    if (!jSONObject3.isNull("screenshotURL")) {
                        u0Var.f8754a = jSONObject3.optString("screenshotURL");
                    }
                    if (!jSONObject3.isNull("isVertical")) {
                        u0Var.f8757d = jSONObject3.optInt("isVertical");
                    }
                    ArrayList arrayList2 = this.O;
                    if (arrayList2 != null) {
                        arrayList2.add(u0Var);
                    }
                }
            }
        }
    }

    public final boolean b() {
        return (kotlin.jvm.internal.l.a(this.N, "ReadingMode") || kotlin.jvm.internal.l.a(this.N, "ExternalDownload") || this.f8581o0 <= 1 || kotlin.jvm.internal.l.a(this.N, "AppNotAvailableInThisCountry") || l()) ? false : true;
    }

    public final String d() {
        if (this.f8576m == null) {
            return null;
        }
        float f = UptodownApp.E;
        if (UptodownApp.Q <= 0) {
            return e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8576m);
        sb.append(':');
        return a3.a.n(sb, ":webp", UptodownApp.Q);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String e() {
        if (this.f8576m == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8576m);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.H, ":webp");
    }

    public final String f() {
        if (this.f8576m == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8576m);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.J, ":webp");
    }

    public final String g(int i10) {
        if (this.f8575l == null) {
            return null;
        }
        return androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(), this.f8575l, a3.a.f(i10, ":"), ":webp");
    }

    public final String h() {
        if (this.f8575l == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8575l);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.G, ":webp");
    }

    public final String i() {
        if (this.f8575l == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8575l);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.F, ":webp");
    }

    public final boolean j() {
        return this.A >= 0;
    }

    public final boolean k() {
        String str = this.N;
        return (str == null || str.equals("PreRegister") || str.equals("Discontinued") || str.equals("ExternalDownload") || str.equals("ReadingMode") || str.equals("AppNotAvailableInThisCountry")) ? false : true;
    }

    public final boolean l() {
        return kotlin.jvm.internal.l.a(this.N, "PreRegister");
    }

    public final boolean m() {
        return this.f8592u0 == 1;
    }

    public final void n(Context context, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        ArrayList arrayList;
        if (!jSONObject.isNull("appID")) {
            this.f8566a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f8567b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("license")) {
            this.h = jSONObject.optString("license");
        }
        if (!jSONObject.isNull("lastVersionCode")) {
            this.f8569d = jSONObject.optLong("lastVersionCode");
        }
        if (!jSONObject.isNull("shortDescription")) {
            this.f = jSONObject.optString("shortDescription");
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f8575l = jSONObject.optString("iconURL");
        } else if (!jSONObject.isNull(RewardPlus.ICON)) {
            this.f8575l = jSONObject.optString(RewardPlus.ICON);
        }
        if (!jSONObject.isNull("feature")) {
            this.f8576m = jSONObject.optString("feature");
        } else if (!jSONObject.isNull("imageURL")) {
            this.f8576m = jSONObject.optString("imageURL");
        }
        if (!jSONObject.isNull("author")) {
            this.f8578n = jSONObject.optString("author");
        }
        if (!jSONObject.isNull("size")) {
            this.g = jSONObject.optString("size");
        }
        if (!jSONObject.isNull("downloads")) {
            this.f8570i = jSONObject.optInt("downloads");
        }
        if (!jSONObject.isNull("weeklyDownloads")) {
            this.f8571j = jSONObject.optInt("weeklyDownloads");
        }
        if (!jSONObject.isNull("lastUpdate")) {
            this.f8573k = jSONObject.optString("lastUpdate");
        }
        if (!jSONObject.isNull("urlShare")) {
            this.e = jSONObject.optString("urlShare");
        } else if (!jSONObject.isNull("url")) {
            this.e = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("description")) {
            String strOptString = jSONObject.optString("description");
            strOptString.getClass();
            this.f8580o = o7.u.b0(strOptString, "\n", "<br />", false);
        }
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
            this.f8582p = jSONObject.optInt(CampaignEx.JSON_KEY_STAR);
        }
        if (!jSONObject.isNull("ratingCount")) {
            this.f8584q = jSONObject.optInt("ratingCount");
        }
        if (!jSONObject.isNull("ratingCount1")) {
            this.f8586r = jSONObject.optInt("ratingCount1");
        }
        if (!jSONObject.isNull("ratingCount2")) {
            this.f8588s = jSONObject.optInt("ratingCount2");
        }
        if (!jSONObject.isNull("ratingCount3")) {
            this.t = jSONObject.optInt("ratingCount3");
        }
        if (!jSONObject.isNull("ratingCount4")) {
            this.f8591u = jSONObject.optInt("ratingCount4");
        }
        if (!jSONObject.isNull("ratingCount5")) {
            this.f8593v = jSONObject.optInt("ratingCount5");
        }
        if (!jSONObject.isNull("packagename")) {
            this.f8595w = jSONObject.optString("packagename");
        } else if (!jSONObject.isNull("packageName")) {
            this.f8595w = jSONObject.optString("packageName");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("categoryData");
        if (jSONObjectOptJSONObject2 != null) {
            k kVar = new k(0, (String) null, 7);
            this.f8597x = kVar;
            if (!jSONObjectOptJSONObject2.isNull(RewardPlus.NAME)) {
                kVar.f8633b = jSONObjectOptJSONObject2.optString(RewardPlus.NAME);
            }
            if (!jSONObjectOptJSONObject2.isNull("id")) {
                kVar.f8632a = jSONObjectOptJSONObject2.optInt("id");
            }
            if (!jSONObjectOptJSONObject2.isNull("isGame")) {
                kVar.g = jSONObjectOptJSONObject2.optInt("isGame");
            }
        }
        if (!jSONObject.isNull("permissionCount")) {
            this.y = jSONObject.optInt("permissionCount");
        }
        if (!jSONObject.isNull("md5Signature")) {
            this.D = jSONObject.optString("md5Signature");
        }
        if (!jSONObject.isNull("activeADEX")) {
            this.C = jSONObject.optInt("activeADEX");
        }
        if (!jSONObject.isNull("pegi")) {
            this.F = jSONObject.optString("pegi");
        }
        if (!jSONObject.isNull("technicalData")) {
            this.H = jSONObject.optString("technicalData");
        }
        if (!jSONObject.isNull("versionRequired")) {
            this.I = jSONObject.optString("versionRequired");
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("compatibleFile");
        if (jSONObjectOptJSONObject3 != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("densities");
            if (jSONArrayOptJSONArray != null) {
                this.J = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    ArrayList arrayList2 = this.J;
                    if (arrayList2 != null) {
                        arrayList2.add(jSONArrayOptJSONArray.optString(i10));
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("abis");
            if (jSONArrayOptJSONArray2 != null) {
                this.K = new ArrayList();
                int length2 = jSONArrayOptJSONArray2.length();
                for (int i11 = 0; i11 < length2; i11++) {
                    ArrayList arrayList3 = this.K;
                    if (arrayList3 != null) {
                        arrayList3.add(jSONArrayOptJSONArray2.optString(i11));
                    }
                }
            }
            if (!jSONObjectOptJSONObject3.isNull("fileID")) {
                this.A = jSONObjectOptJSONObject3.optLong("fileID");
            }
            if (!jSONObjectOptJSONObject3.isNull("minSDK")) {
                this.f8600z = jSONObjectOptJSONObject3.optString("minSDK");
            }
            if (!jSONObjectOptJSONObject3.isNull("fileType")) {
                this.F0 = jSONObjectOptJSONObject3.optString("fileType");
            }
            if (!jSONObjectOptJSONObject3.isNull("version")) {
                this.f8568c = jSONObjectOptJSONObject3.optString("version");
            }
            if (!jSONObjectOptJSONObject3.isNull("versionCode")) {
                this.B = jSONObjectOptJSONObject3.optLong("versionCode");
            }
            if (!jSONObjectOptJSONObject3.isNull("sha256")) {
                this.G = jSONObjectOptJSONObject3.optString("sha256");
            }
            if (!jSONObjectOptJSONObject3.isNull("url_apk")) {
                this.E = jSONObjectOptJSONObject3.optString("url_apk");
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("requiredFeatures");
            if (jSONArrayOptJSONArray3 != null) {
                this.L = new ArrayList();
                int length3 = jSONArrayOptJSONArray3.length();
                int i12 = 0;
                while (true) {
                    arrayList = this.L;
                    if (i12 >= length3) {
                        break;
                    }
                    if (arrayList != null) {
                        arrayList.add(jSONArrayOptJSONArray3.optString(i12));
                    }
                    i12++;
                }
                arrayList.getClass();
                if (!arrayList.isEmpty() && context != null) {
                    ArrayList arrayList4 = this.L;
                    arrayList4.getClass();
                    ArrayList arrayListC = p.c(arrayList4, context);
                    if (!arrayListC.isEmpty()) {
                        Iterator it = arrayListC.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            Bundle bundle = new Bundle();
                            bundle.putInt("update", 0);
                            bundle.putString("feature", (String) next);
                            new t1.c(context, 4).e(bundle, "required_features_not_supported");
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("containedFiles");
            if (jSONArrayOptJSONArray4 != null) {
                this.D0 = new ArrayList();
                int length4 = jSONArrayOptJSONArray4.length();
                for (int i13 = 0; i13 < length4; i13++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray4.getJSONObject(i13);
                    jSONObject2.getClass();
                    r rVar = new r();
                    if (!jSONObject2.isNull("fileID")) {
                        rVar.f8722c = jSONObject2.optLong("fileID");
                    }
                    if (!jSONObject2.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                        rVar.f8723d = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    }
                    if (!jSONObject2.isNull("size")) {
                        rVar.e = jSONObject2.optLong("size");
                    }
                    if (!jSONObject2.isNull("sha256")) {
                        rVar.g = jSONObject2.optString("sha256");
                    }
                    this.D0.add(rVar);
                }
            }
        }
        if (!jSONObject.isNull("website")) {
            this.M = jSONObject.optString("website");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            String strOptString2 = jSONObject.optString("downloadStatus");
            this.N = strOptString2;
            if (o7.u.Z(strOptString2, "PreRegister", false) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("preRegister")) != null) {
                if (!jSONObjectOptJSONObject.isNull("date")) {
                    this.R = jSONObjectOptJSONObject.optString("date");
                }
                if (!jSONObjectOptJSONObject.isNull("countPreRegistered")) {
                    this.S = jSONObjectOptJSONObject.optString("countPreRegistered");
                }
            }
        }
        if (!jSONObject.isNull("newFeatures")) {
            this.T = jSONObject.optString("newFeatures");
        }
        if (!jSONObject.isNull("onBoard")) {
            this.U = jSONObject.optInt("onBoard");
        }
        if (!jSONObject.isNull("responsibilities")) {
            this.V = jSONObject.optString("responsibilities");
        }
        if (!jSONObject.isNull(TypedValues.CycleType.S_WAVE_PHASE)) {
            this.W = jSONObject.optString(TypedValues.CycleType.S_WAVE_PHASE);
        }
        if (!jSONObject.isNull("deviceType")) {
            this.X = jSONObject.optString("deviceType");
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("translations");
        if (jSONObjectOptJSONObject4 != null) {
            this.f8590t0 = new HashMap();
            if (!jSONObjectOptJSONObject4.isNull("try")) {
                HashMap map = this.f8590t0;
                map.getClass();
                map.put("try", jSONObjectOptJSONObject4.optString("try"));
            }
            if (!jSONObjectOptJSONObject4.isNull("supportedDevice")) {
                HashMap map2 = this.f8590t0;
                map2.getClass();
                map2.put("supportedDevice", jSONObjectOptJSONObject4.optString("supportedDevice"));
            }
        }
        if (!jSONObject.isNull("readingModeText")) {
            this.Y = jSONObject.optString("readingModeText");
        }
        if (!jSONObject.isNull("externalDownloadURL")) {
            this.Z = jSONObject.optString("externalDownloadURL");
        }
        if (!jSONObject.isNull("externalDownloadText")) {
            this.f8572j0 = jSONObject.optString("externalDownloadText");
        }
        if (!jSONObject.isNull("organizationID")) {
            this.f8574k0 = jSONObject.optLong("organizationID");
        }
        if (!jSONObject.isNull("editorNameNew")) {
            this.l0 = jSONObject.optString("editorNameNew");
        }
        if (!jSONObject.isNull("editorAvatar")) {
            this.f8577m0 = jSONObject.optString("editorAvatar");
        }
        if (!jSONObject.isNull("showReviewedBy")) {
            this.f8585q0 = jSONObject.optInt("showReviewedBy");
        }
        if (!jSONObject.isNull("editorJobTitle")) {
            this.f8579n0 = jSONObject.optString("editorJobTitle");
        }
        if (!jSONObject.isNull("totalVersions")) {
            this.f8581o0 = jSONObject.optInt("totalVersions");
        }
        if (!jSONObject.isNull("disclaimerText")) {
            this.f8583p0 = jSONObject.optString("disclaimerText");
        }
        if (!jSONObject.isNull("tagID")) {
            int iOptInt = jSONObject.optInt("tagID");
            if (iOptInt == 0) {
                this.f8589s0 = g.f;
            } else if (iOptInt == 1) {
                this.f8589s0 = g.e;
            } else if (iOptInt == 2) {
                this.f8589s0 = g.f8556c;
            } else if (iOptInt == 3) {
                this.f8589s0 = g.f8554a;
            } else if (iOptInt == 4) {
                this.f8589s0 = g.f8555b;
            } else if (iOptInt == 5) {
                this.f8589s0 = g.f8557d;
            }
            if (!jSONObject.isNull("tag")) {
                this.f8587r0 = jSONObject.optString("tag");
            }
        }
        if (!jSONObject.isNull("promoted")) {
            this.f8592u0 = jSONObject.optInt("promoted");
        }
        if (!jSONObject.isNull("containsAds")) {
            this.f8596w0 = jSONObject.optInt("containsAds");
        }
        if (!jSONObject.isNull("hasAlternatives")) {
            if (jSONObject.optBoolean("hasAlternatives")) {
                this.f8598x0 = 1;
            } else {
                this.f8598x0 = 0;
            }
        }
        if (!jSONObject.isNull("wishlist")) {
            this.z0 = jSONObject.optInt("wishlist");
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("userSays");
        if (jSONArrayOptJSONArray5 != null) {
            this.B0 = new ArrayList();
            int length5 = jSONArrayOptJSONArray5.length();
            for (int i14 = 0; i14 < length5; i14++) {
                ArrayList arrayList5 = this.B0;
                arrayList5.getClass();
                arrayList5.add(jSONArrayOptJSONArray5.getString(i14));
            }
        }
        if (!jSONObject.isNull("recommended-apps")) {
            this.A0 = jSONObject.optInt("recommended-apps");
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("ranking");
        if (jSONObjectOptJSONObject5 != null) {
            h0 h0Var = new h0();
            if (!jSONObjectOptJSONObject5.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                h0Var.f8601a = jSONObjectOptJSONObject5.optString(MimeTypes.BASE_TYPE_TEXT);
            }
            if (!jSONObjectOptJSONObject5.isNull("floatingCategoryID")) {
                h0Var.f8602b = jSONObjectOptJSONObject5.optInt("floatingCategoryID");
            }
            if (!jSONObjectOptJSONObject5.isNull("categoryID")) {
                h0Var.f8603c = jSONObjectOptJSONObject5.optInt("categoryID");
            }
            if (!jSONObjectOptJSONObject5.isNull(RewardPlus.NAME)) {
                h0Var.f8604d = jSONObjectOptJSONObject5.optString(RewardPlus.NAME);
            }
            if (!jSONObjectOptJSONObject5.isNull("parentCategoryID")) {
                h0Var.e = jSONObjectOptJSONObject5.optInt("parentCategoryID");
            }
            this.E0 = h0Var;
        }
        if (jSONObject.isNull(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) {
            return;
        }
        if (jSONObject.optBoolean(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) {
            this.G0 = 1;
        } else {
            this.G0 = 0;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppInfo(appID=");
        sb.append(this.f8566a);
        sb.append(", name=");
        sb.append(this.f8567b);
        sb.append(", versionName=");
        sb.append(this.f8568c);
        sb.append(", lastVersionCode=");
        sb.append(this.f8569d);
        sb.append(", urlShare=");
        sb.append(this.e);
        sb.append(", shortDescription=");
        sb.append(this.f);
        sb.append(", size=");
        sb.append(this.g);
        sb.append(", license=");
        sb.append(this.h);
        sb.append(", downloads=");
        sb.append(this.f8570i);
        sb.append(", weeklyDownloads=");
        sb.append(this.f8571j);
        sb.append(", lastUpdate=");
        sb.append(this.f8573k);
        sb.append(", icon=");
        sb.append(this.f8575l);
        sb.append(", feature=");
        sb.append(this.f8576m);
        sb.append(", author=");
        sb.append(this.f8578n);
        sb.append(", description=");
        sb.append(this.f8580o);
        sb.append(", rating=");
        sb.append(this.f8582p);
        sb.append(", ratingCount=");
        sb.append(this.f8584q);
        sb.append(", ratingCount1=");
        sb.append(this.f8586r);
        sb.append(", ratingCount2=");
        sb.append(this.f8588s);
        sb.append(", ratingCount3=");
        sb.append(this.t);
        sb.append(", ratingCount4=");
        sb.append(this.f8591u);
        sb.append(", ratingCount5=");
        sb.append(this.f8593v);
        sb.append(", packagename=");
        sb.append(this.f8595w);
        sb.append(", screenShots=");
        sb.append(this.O);
        sb.append(", category=");
        sb.append(this.f8597x);
        sb.append(", permissionCount=");
        sb.append(this.y);
        sb.append(", minsdk=");
        sb.append(this.f8600z);
        sb.append(", fileType=");
        sb.append(this.F0);
        sb.append(", md5signature=");
        sb.append(this.D);
        sb.append(", downloadUrl=");
        sb.append(this.E);
        sb.append(", fileID=");
        sb.append(this.A);
        sb.append(", oldVersions=");
        sb.append(this.C0);
        sb.append(", activeADEX=");
        sb.append(this.C);
        sb.append(", sha256=");
        sb.append(this.G);
        sb.append(", technicalData=");
        sb.append(this.H);
        sb.append(", versionRequired=");
        sb.append(this.I);
        sb.append(", webAuthor=");
        sb.append(this.M);
        sb.append(", downloadStatus=");
        sb.append(this.N);
        sb.append(", devOnBoard=");
        sb.append(this.U);
        sb.append(", responsibilities=");
        sb.append(this.V);
        sb.append(", phase=");
        sb.append(this.W);
        sb.append(", readingModeText=");
        sb.append(this.Y);
        sb.append(", externalDownloadUrl=");
        sb.append(this.Z);
        sb.append(", newFeatures=");
        sb.append(this.T);
        sb.append(", preRegisterDate=");
        sb.append(this.R);
        sb.append(", preRegistersCount=");
        sb.append(this.S);
        sb.append(", editorAvatar=");
        sb.append(this.f8577m0);
        sb.append(", editorJobTitle=");
        sb.append(this.f8579n0);
        sb.append(", showReviewedBy=");
        sb.append(this.f8585q0);
        sb.append(", containAds=");
        sb.append(this.f8596w0);
        sb.append(", hasAlternatives=");
        sb.append(this.f8598x0);
        sb.append(", wishlist=");
        sb.append(this.z0);
        sb.append(", deviceType=");
        sb.append(this.X);
        sb.append(", translations=");
        sb.append(this.f8590t0);
        sb.append(", supportedDensities=");
        sb.append(this.J);
        sb.append(", supportedAbis=");
        sb.append(this.K);
        sb.append(", requiredFeatures=");
        sb.append(this.L);
        sb.append(", pegi=");
        sb.append(this.F);
        sb.append(", externalDownloadText=");
        sb.append(this.f8572j0);
        sb.append(", organizationID=");
        sb.append(this.f8574k0);
        sb.append(", editorName=");
        sb.append(this.l0);
        sb.append(", totalVersions=");
        sb.append(this.f8581o0);
        sb.append(", disclaimerText=");
        sb.append(this.f8583p0);
        sb.append(", promoted=");
        sb.append(this.f8592u0);
        sb.append(", showAds=");
        sb.append(this.G0);
        sb.append(", promotedFrom=");
        return a3.a.m(sb, this.f8594v0, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8566a);
        parcel.writeString(this.f8567b);
        parcel.writeString(this.f8568c);
        parcel.writeLong(this.f8569d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.f8570i);
        parcel.writeInt(this.f8571j);
        parcel.writeString(this.f8573k);
        parcel.writeString(this.f8575l);
        parcel.writeString(this.f8576m);
        parcel.writeString(this.f8578n);
        parcel.writeString(this.f8580o);
        parcel.writeInt(this.f8582p);
        parcel.writeInt(this.f8584q);
        parcel.writeInt(this.f8586r);
        parcel.writeInt(this.f8588s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.f8591u);
        parcel.writeInt(this.f8593v);
        parcel.writeString(this.f8595w);
        parcel.writeParcelable(this.f8597x, i10);
        parcel.writeInt(this.y);
        parcel.writeString(this.f8600z);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeLong(this.A);
        parcel.writeInt(this.C);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeStringList(this.J);
        parcel.writeStringList(this.K);
        parcel.writeStringList(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.F);
        parcel.writeInt(this.U);
        parcel.writeString(this.X);
        parcel.writeMap(this.f8590t0);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeString(this.f8572j0);
        parcel.writeLong(this.f8574k0);
        parcel.writeString(this.l0);
        parcel.writeInt(this.f8581o0);
        parcel.writeString(this.V);
        parcel.writeString(this.T);
        parcel.writeString(this.R);
        parcel.writeString(this.S);
        parcel.writeString(this.f8577m0);
        parcel.writeString(this.f8579n0);
        parcel.writeString(this.f8583p0);
        parcel.writeInt(this.f8585q0);
        parcel.writeInt(this.f8596w0);
        parcel.writeInt(this.f8598x0);
        parcel.writeInt(this.z0);
        parcel.writeStringList(this.B0);
        parcel.writeInt(this.A0);
        parcel.writeInt(this.f8592u0);
        parcel.writeString(this.f8594v0);
        parcel.writeTypedList(this.D0);
        parcel.writeParcelable(this.E0, i10);
        parcel.writeString(this.F0);
        parcel.writeInt(this.G0);
    }

    public h() {
        this.f8569d = -1L;
        this.A = -1L;
        this.B = -1L;
        this.f8589s0 = g.f;
        this.f8590t0 = new HashMap();
        this.D0 = new ArrayList();
        this.G0 = 1;
    }
}
