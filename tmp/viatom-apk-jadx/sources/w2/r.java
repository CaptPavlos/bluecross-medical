package w2;

import a3.d1;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c1.f0;
import c1.h1;
import c1.u1;
import c1.w0;
import c1.w4;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.c6;
import com.google.android.gms.internal.measurement.e1;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.x3;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadUpdatesWorker;
import e5.f1;
import h5.o0;
import h5.p0;
import j$.time.ZonedDateTime;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import l4.n5;
import l4.p2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r7.i0;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class r implements c3.b, a6.g, ViewBinding, r.b {
    public static r f;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13461a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13462b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13463c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13464d;
    public Object e;

    public r(int i10) {
        this.f13461a = i10;
        switch (i10) {
            case 8:
                com.google.android.gms.internal.measurement.t tVar = new com.google.android.gms.internal.measurement.t(0);
                this.f13462b = tVar;
                r rVar = new r((r) null, tVar);
                this.f13464d = rVar;
                this.f13463c = rVar.N();
                c6 c6Var = new c6(1);
                this.e = c6Var;
                rVar.P("require", new e9(c6Var));
                ((HashMap) c6Var.f1904a).put("internal.platform", e1.f1932a);
                rVar.P("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(0.0d)));
                break;
            case 21:
                this.f13462b = i9.a.e();
                this.f13463c = i9.a.h();
                this.f13464d = i9.a.j();
                this.e = new USRegulationData(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 524287, null);
                break;
            case 22:
                this.f13462b = ShareTarget.METHOD_GET;
                this.f13464d = new n5(18);
                break;
            case 23:
                break;
            default:
                this.f13462b = null;
                this.f13463c = null;
                this.f13464d = null;
                this.e = new ArrayDeque();
                break;
        }
    }

    public static r C(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_settings_options, (ViewGroup) null, false);
        int i10 = R.id.rg_dso;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(viewInflate, R.id.rg_dso);
        if (radioGroup != null) {
            i10 = R.id.tv_accept_dso;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_accept_dso);
            if (textView != null) {
                i10 = R.id.tv_title_dso;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dso);
                if (textView2 != null) {
                    return new r((LinearLayout) viewInflate, radioGroup, textView, textView2, 11);
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static r D(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.item_pending_install, (ViewGroup) null, false);
        int i10 = R.id.iv_app_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_app_icon);
        if (imageView != null) {
            i10 = R.id.tv_app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name);
            if (textView != null) {
                i10 = R.id.tv_app_version;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_version);
                if (textView2 != null) {
                    return new r((LinearLayout) viewInflate, imageView, textView, textView2, 12);
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static final String m(r rVar, Context context, String str, String str2) throws JSONException {
        w4 w4Var = new w4(context, 4, false);
        str.getClass();
        str2.getClass();
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", str);
        jSONObject.put("md5Signature", str2);
        map.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject.toString());
        p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/nativeapp/getappurlbypackagenamemd5signature"), ShareTarget.METHOD_POST, map);
        JSONObject jSONObjectK = w4Var.k(p0VarM, "/eapi/nativeapp/getappurlbypackagenamemd5signature");
        p0VarM.f8699d = jSONObjectK;
        if (jSONObjectK == null) {
            return null;
        }
        int iOptInt = !jSONObjectK.isNull("success") ? jSONObjectK.optInt("success") : 0;
        JSONObject jSONObjectOptJSONObject = jSONObjectK.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (iOptInt != 1 || jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.isNull("app_url")) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("app_url");
    }

    public static final o0 n(r rVar, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (jSONObject.optInt("success") != 1 || jSONObjectOptJSONObject == null) {
            return null;
        }
        o0 o0Var = new o0();
        o0Var.a(jSONObjectOptJSONObject);
        return o0Var;
    }

    public static final void o(r rVar, String str, String str2) {
        if (o7.u.X(str2, ".apk", false)) {
            HashMap map = x4.k.f13628a;
            if (map.containsKey(str2)) {
                return;
            }
            FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) rVar.f13464d;
            PackageManager packageManager = fileExplorerActivity.getPackageManager();
            packageManager.getClass();
            PackageInfo packageInfoD = l5.a.d(packageManager, str, 128);
            Drawable drawableLoadIcon = null;
            if ((packageInfoD != null ? packageInfoD.applicationInfo : null) != null) {
                ApplicationInfo applicationInfo = packageInfoD.applicationInfo;
                applicationInfo.getClass();
                applicationInfo.sourceDir = str;
                ApplicationInfo applicationInfo2 = packageInfoD.applicationInfo;
                applicationInfo2.getClass();
                applicationInfo2.publicSourceDir = str;
                ApplicationInfo applicationInfo3 = packageInfoD.applicationInfo;
                applicationInfo3.getClass();
                drawableLoadIcon = applicationInfo3.loadIcon(fileExplorerActivity.getPackageManager());
            }
            if (drawableLoadIcon != null) {
                map.put(str2, drawableLoadIcon);
            }
        }
    }

    public static synchronized r y() {
        try {
            if (f == null) {
                f = new r(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f;
    }

    public boolean A(Context context) {
        if (((Boolean) this.f13463c) == null) {
            this.f13463c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.f13463c).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f13463c).booleanValue();
    }

    public void B(String str, String str2) {
        n5 n5Var = (n5) this.f13464d;
        n5Var.getClass();
        n5.S(str, str2);
        n5Var.p0(str);
        n5Var.R(str, str2);
    }

    public void E(String str, t1 t1Var) {
        if (str == null) {
            androidx.window.layout.c.k("method == null");
            return;
        }
        if (str.length() == 0) {
            com.google.gson.internal.a.n("method.length() == 0");
            return;
        }
        if (str.equals(ShareTarget.METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("method ", str, " must have a request body."));
        } else {
            this.f13462b = str;
        }
    }

    public void F(String str) {
        ((n5) this.f13464d).p0(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        if (r7.y.z(r6, r9, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(y6.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof c5.l0
            if (r0 == 0) goto L13
            r0 = r9
            c5.l0 r0 = (c5.l0) r0
            int r1 = r0.f1722d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1722d = r1
            goto L18
        L13:
            c5.l0 r0 = new c5.l0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f1720b
            int r1 = r0.f1722d
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r9)
            goto L68
        L2b:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            return r4
        L31:
            kotlin.jvm.internal.x r1 = r0.f1719a
            s6.a.e(r9)
            goto L54
        L37:
            s6.a.e(r9)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            y7.e r9 = r7.i0.f12407a
            y7.d r9 = y7.d.f14116a
            c5.m0 r6 = new c5.m0
            r7 = 0
            r6.<init>(r8, r1, r4, r7)
            r0.f1719a = r1
            r0.f1722d = r3
            java.lang.Object r9 = r7.y.z(r6, r9, r0)
            if (r9 != r5) goto L54
            goto L67
        L54:
            y7.e r9 = r7.i0.f12407a
            s7.c r9 = w7.n.f13548a
            c5.m0 r6 = new c5.m0
            r6.<init>(r8, r1, r4, r3)
            r0.f1719a = r4
            r0.f1722d = r2
            java.lang.Object r9 = r7.y.z(r6, r9, r0)
            if (r9 != r5) goto L68
        L67:
            return r5
        L68:
            s6.w r9 = s6.w.f12711a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.G(y6.c):java.lang.Object");
    }

    public void H(String str) {
        if (str == null) {
            androidx.window.layout.c.k("url == null");
            return;
        }
        String strConcat = str.regionMatches(true, 0, "ws:", 0, 3) ? "http:".concat(str.substring(3)) : str.regionMatches(true, 0, "wss:", 0, 4) ? "https:".concat(str.substring(4)) : str;
        h5.c cVar = new h5.c(1);
        p8.s sVarA = cVar.b(null, strConcat) == 1 ? cVar.a() : null;
        if (sVarA != null) {
            this.f13463c = sVarA;
        } else {
            com.google.gson.internal.a.n("unexpected url: ".concat(strConcat));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc A[Catch: NumberFormatException | JSONException -> 0x0109, NumberFormatException | JSONException -> 0x0109, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0109, blocks: (B:10:0x002f, B:24:0x0063, B:24:0x0063, B:26:0x0070, B:26:0x0070, B:28:0x0082, B:28:0x0082, B:29:0x008b, B:29:0x008b, B:51:0x00fc, B:51:0x00fc, B:33:0x0098, B:33:0x0098, B:35:0x00a5, B:35:0x00a5, B:37:0x00b7, B:37:0x00b7, B:38:0x00c0, B:38:0x00c0, B:42:0x00cc, B:42:0x00cc, B:46:0x00dc, B:46:0x00dc, B:50:0x00f0, B:50:0x00f0), top: B:65:0x002f, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle I() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.I():android.os.Bundle");
    }

    public com.google.android.gms.internal.measurement.n J(com.google.android.gms.internal.measurement.n nVar) {
        return ((com.google.android.gms.internal.measurement.t) this.f13463c).c(this, nVar);
    }

    public com.google.android.gms.internal.measurement.n K(r rVar, x3... x3VarArr) {
        com.google.android.gms.internal.measurement.n nVarL = com.google.android.gms.internal.measurement.n.f2091a0;
        for (x3 x3Var : x3VarArr) {
            nVarL = a4.L(x3Var);
            a.a.e0((r) this.f13464d);
            if ((nVarL instanceof com.google.android.gms.internal.measurement.o) || (nVarL instanceof com.google.android.gms.internal.measurement.m)) {
                nVarL = ((com.google.android.gms.internal.measurement.t) this.f13462b).c(rVar, nVarL);
            }
        }
        return nVarL;
    }

    public com.google.android.gms.internal.measurement.n L(com.google.android.gms.internal.measurement.d dVar) {
        com.google.android.gms.internal.measurement.n nVarC = com.google.android.gms.internal.measurement.n.f2091a0;
        Iterator itN = dVar.n();
        while (itN.hasNext()) {
            nVarC = ((com.google.android.gms.internal.measurement.t) this.f13463c).c(this, dVar.p(((Integer) itN.next()).intValue()));
            if (nVarC instanceof com.google.android.gms.internal.measurement.f) {
                break;
            }
        }
        return nVarC;
    }

    public void M(Bundle bundle) {
        h1 h1Var = (h1) this.e;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences sharedPreferencesK = h1Var.k();
        u1 u1Var = h1Var.f1149a;
        SharedPreferences.Editor editorEdit = sharedPreferencesK.edit();
        int size = bundle2.size();
        String str = (String) this.f13462b;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        j8.a();
                        if (u1Var.f1478d.q(null, f0.R0)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                jSONObject.put("t", "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                jSONObject.put("t", "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                            } else {
                                w0 w0Var = u1Var.f;
                                u1.m(w0Var);
                                w0Var.f.c(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                            } else {
                                w0 w0Var2 = u1Var.f;
                                u1.m(w0Var2);
                                w0Var2.f.c(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        w0 w0Var3 = u1Var.f;
                        u1.m(w0Var3);
                        w0Var3.f.c(e, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f13464d = bundle2;
    }

    public r N() {
        return new r(this, (com.google.android.gms.internal.measurement.t) this.f13463c);
    }

    public boolean O(String str) {
        if (((HashMap) this.f13464d).containsKey(str)) {
            return true;
        }
        r rVar = (r) this.f13462b;
        if (rVar != null) {
            return rVar.O(str);
        }
        return false;
    }

    public void P(String str, com.google.android.gms.internal.measurement.n nVar) {
        r rVar;
        HashMap map = (HashMap) this.f13464d;
        if (!map.containsKey(str) && (rVar = (r) this.f13462b) != null && rVar.O(str)) {
            rVar.P(str, nVar);
        } else {
            if (((HashMap) this.e).containsKey(str)) {
                return;
            }
            if (nVar == null) {
                map.remove(str);
            } else {
                map.put(str, nVar);
            }
        }
    }

    public void Q(String str, com.google.android.gms.internal.measurement.n nVar) {
        if (((HashMap) this.e).containsKey(str)) {
            return;
        }
        HashMap map = (HashMap) this.f13464d;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public com.google.android.gms.internal.measurement.n R(String str) {
        HashMap map = (HashMap) this.f13464d;
        if (map.containsKey(str)) {
            return (com.google.android.gms.internal.measurement.n) map.get(str);
        }
        r rVar = (r) this.f13462b;
        if (rVar != null) {
            return rVar.R(str);
        }
        com.google.gson.internal.a.n(a3.a.C(str, " is not defined"));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(y6.c r18) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.a(y6.c):java.lang.Object");
    }

    @Override // a6.g
    public void b(long j10) {
        ((kotlin.jvm.internal.w) this.f13462b).f10137a = j10;
    }

    public String c(int i10) {
        if (i10 == 0) {
            throw null;
        }
        switch (c.i.c(i10)) {
            case 0:
                List list = p3.n.f11901a;
                return "SharingNotice";
            case 1:
                List list2 = p3.n.f11901a;
                return "SaleOptOutNotice";
            case 2:
                List list3 = p3.n.f11901a;
                return "SharingOptOutNotice";
            case 3:
                List list4 = p3.n.f11901a;
                return "TargetedAdvertisingOptOutNotice";
            case 4:
                List list5 = p3.n.f11901a;
                return "SensitiveDataProcessingOptOutNotice";
            case 5:
                List list6 = p3.n.f11901a;
                return "SensitiveDataLimitUseNotice";
            case 6:
            default:
                return "";
            case 7:
                List list7 = p3.n.f11901a;
                return "SaleOptOut";
            case 8:
                List list8 = p3.n.f11901a;
                return "SharingOptOut";
            case 9:
                List list9 = p3.n.f11901a;
                return "TargetedAdvertisingOptOut";
            case 10:
                List list10 = p3.n.f11901a;
                return "SensitiveDataProcessing";
            case 11:
                List list11 = p3.n.f11901a;
                return "KnownChildSensitiveDataConsents";
            case 12:
                List list12 = p3.n.f11901a;
                return "PersonalDataConsents";
            case 13:
                List list13 = p3.n.f11901a;
                return "MspaCoveredTransaction";
            case 14:
                List list14 = p3.n.f11901a;
                return "MspaOptOutOptionMode";
            case 15:
                List list15 = p3.n.f11901a;
                return "MspaServiceProviderMode";
        }
    }

    @Override // a6.g
    public void d(long j10) {
        ((kotlin.jvm.internal.w) this.f13463c).f10137a = j10;
    }

    @Override // a6.g
    public void e() {
        Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadUpdatesWorker downloadUpdatesWorker = (DownloadUpdatesWorker) this.f13464d;
        downloadUpdatesWorker.n(bundleF, downloadUpdatesWorker.f6741c, (h5.r) this.e);
    }

    public void f() throws h6.e, NoSuchAlgorithmException {
        f6.c cVar;
        f6.m mVar = (f6.m) this.f13463c;
        Vector vector = mVar.A;
        int i10 = 0;
        try {
            j3.a aVarE = i9.a.e();
            d0.i iVarJ = i9.a.j();
            List list = p3.f.f11884a;
            aVarE.h(Integer.valueOf(mVar.f8101i), "tcfeuv2", "Version");
            aVarE.h(Integer.valueOf(mVar.f8105m), "tcfeuv2", "CmpId");
            aVarE.h(Integer.valueOf(mVar.f8106n), "tcfeuv2", "CmpVersion");
            aVarE.h(Integer.valueOf(mVar.f8102j), "tcfeuv2", "ConsentScreen");
            aVarE.h(mVar.f8104l, "tcfeuv2", "ConsentLanguage");
            k8.c cVar2 = mVar.f8097a;
            Integer num = cVar2 == null ? null : cVar2.f10082b;
            aVarE.h(Integer.valueOf(num == null ? mVar.f8107o : num.intValue()), "tcfeuv2", "VendorListVersion");
            aVarE.h(Integer.valueOf(mVar.d()), "tcfeuv2", "PolicyVersion");
            aVarE.h(Boolean.valueOf(mVar.e), "tcfeuv2", "IsServiceSpecific");
            aVarE.h(Boolean.valueOf(mVar.f), "tcfeuv2", "UseNonStandardStacks");
            aVarE.h(r0.f.e(12, mVar.f8109q), "tcfeuv2", "SpecialFeatureOptins");
            aVarE.h(r0.f.e(24, mVar.f8110r), "tcfeuv2", "PurposeConsents");
            aVarE.h(r0.f.e(24, mVar.f8111s), "tcfeuv2", "PurposeLegitimateInterests");
            aVarE.h(Boolean.valueOf(mVar.g), "tcfeuv2", "PurposeOneTreatment");
            aVarE.h(mVar.h, "tcfeuv2", "PublisherCountryCode");
            aVarE.h(t6.l.r0(mVar.f8116z.getAcceptedItems()), "tcfeuv2", "VendorConsents");
            aVarE.h(t6.l.r0(mVar.C.getAcceptedItems()), "tcfeuv2", "VendorLegitimateInterests");
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : mVar.G.f8083c.entrySet()) {
                String str = (String) entry.getKey();
                Set set = (Set) entry.getValue();
                f6.g gVarA = t1.a(str);
                arrayList.add(new m3.f(gVarA.f8079a, gVarA.f8080b.f8088a, t6.l.r0(set)));
            }
            List list2 = p3.f.f11884a;
            aVarE.h(arrayList, "tcfeuv2", "PublisherRestrictions");
            aVarE.h(r0.f.e(24, mVar.f8113v), "tcfeuv2", "PublisherConsents");
            aVarE.h(r0.f.e(24, mVar.f8114w), "tcfeuv2", "PublisherLegitimateInterests");
            int i11 = mVar.f8108p;
            aVarE.h(Integer.valueOf(i11), "tcfeuv2", "NumCustomPurposes");
            aVarE.h(r0.f.e(i11, mVar.f8115x), "tcfeuv2", "PublisherCustomConsents");
            aVarE.h(r0.f.e(i11, mVar.y), "tcfeuv2", "PublisherCustomLegitimateInterests");
            aVarE.h(t6.l.r0(mVar.F.getAcceptedItems()), "tcfeuv2", "VendorsAllowed");
            aVarE.h(t6.l.r0(mVar.E.getAcceptedItems()), "tcfeuv2", "VendorsDisclosed");
            aVarE.d();
            iVarJ.p(61, String.valueOf(1));
            iVarJ.p(62, aVarE.f().toString());
            iVarJ.p(64, t6.l.h0(aVarE.f(), "_", null, null, null, 62));
            String strB0 = o7.u.b0("IABGPP_[SectionID]_String", "[SectionID]", String.valueOf(2), false);
            String strC = aVarE.e("tcfeuv2").c();
            strC.getClass();
            iVarJ.s(strB0, strC);
            ZonedDateTime zonedDateTime = mVar.f8100d;
            if (zonedDateTime != null) {
                aVarE.h(zonedDateTime, "tcfeuv2", "Created");
                aVarE.h(mVar.f8100d, "tcfeuv2", "LastUpdated");
            }
            i9.a.f9115o = aVarE;
            cVar = new f6.c(aVarE.c(), strC);
        } catch (Exception e) {
            d6.b.b("GPPString", kotlin.jvm.internal.l.g(e.getMessage(), "Error while encoding GPP String: "), e, 8);
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
            }
            cVar = new f6.c("", "");
        }
        d0.i iVar = (d0.i) this.f13462b;
        String str2 = cVar.f8071a;
        String str3 = str2 != null ? str2 : "";
        String strC2 = a4.c(vector);
        String strL = l1.b.l(vector.toString());
        String strC3 = a4.c(mVar.D);
        Set<Integer> acceptedItems = mVar.B.getAcceptedItems();
        acceptedItems.getClass();
        String strG = "1~";
        for (Object obj : acceptedItems) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                t6.m.U();
                throw null;
            }
            int iIntValue = ((Number) obj).intValue();
            strG = kotlin.jvm.internal.l.g(i10 != 0 ? kotlin.jvm.internal.l.g(Integer.valueOf(iIntValue), ".") : Integer.valueOf(iIntValue), strG);
            i10 = i12;
        }
        String strC4 = a4.c(mVar.f8116z);
        String strC5 = a4.c(mVar.C);
        String strC6 = a4.c(mVar.f8110r);
        String strC7 = a4.c(mVar.f8111s);
        String strC8 = a4.c(mVar.f8109q);
        String string = mVar.G.f8083c.toString();
        String strC9 = a4.c(mVar.f8113v);
        String strC10 = a4.c(mVar.f8114w);
        String strC11 = a4.c(mVar.f8115x);
        String strC12 = a4.c(mVar.y);
        strC2.getClass();
        strC3.getClass();
        strC4.getClass();
        strC5.getClass();
        strC6.getClass();
        strC7.getClass();
        strC8.getClass();
        string.getClass();
        strC9.getClass();
        strC10.getClass();
        strC11.getClass();
        strC12.getClass();
        iVar.p(63, str3);
        iVar.p(50, cVar.f8072b);
        iVar.p(35, strC2);
        iVar.p(23, l1.b.l(strL));
        iVar.p(36, strC3);
        iVar.p(22, kotlin.jvm.internal.l.g(iVar.t(24), iVar.t(23)));
        iVar.p(31, strG);
        iVar.p(51, strC4);
        iVar.p(52, strC5);
        iVar.p(53, strC6);
        iVar.p(54, strC7);
        iVar.p(55, strC8);
        iVar.p(56, string);
        iVar.p(57, strC9);
        iVar.p(58, strC10);
        iVar.p(59, strC11);
        iVar.p(60, strC12);
    }

    public void g(int i10, Object obj) {
        if (i10 == 0) {
            throw null;
        }
        try {
            ((j3.a) this.f13462b).h(obj, p(), c(i10));
        } catch (Exception unused) {
            d6.b.b(null, ChoiceError.ERROR_WHILE_SAVING_CONSENT.getMessage(), null, 5);
        }
    }

    @Override // p6.a
    public Object get() {
        switch (this.f13461a) {
            case 1:
                return new a3.p((l1.g) ((d0.i) this.f13462b).f6781b, (d3.j) ((p6.a) this.f13463c).get(), (w6.h) ((p6.a) this.f13464d).get(), (d1) ((c3.c) this.e).get());
            default:
                return new r((Executor) ((p6.a) this.f13462b).get(), (w.d) ((p6.a) this.f13463c).get(), (p2) ((p2) this.f13464d).get(), (x.c) ((p6.a) this.e).get(), 25);
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f13461a) {
        }
        return (RelativeLayout) this.f13462b;
    }

    public void h(int i10, boolean z9) {
        if (i10 == 0) {
            throw null;
        }
        List<Integer> listQ = z9 ? t6.m.Q(1, 1, 1) : t6.m.Q(2, 2, 2);
        g(i10, listQ);
        ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(listQ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.i(com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode, boolean, boolean):void");
    }

    public void j(Boolean bool, int i10) {
        if (i10 == 0) {
            throw null;
        }
        Boolean bool2 = Boolean.TRUE;
        int i11 = kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2;
        ((USRegulationData) this.e).setPersonalDataConsents(kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2);
        g(i10, Integer.valueOf(i11));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|189|3|4|(4:193|5|(2:8|6)|195)|12|(4:15|(1:199)(3:196|18|200)|198|13)|197|19|191|20|23|(2:24|(7:26|27|35|36|68|206|37)(24:201|121|(1:123)(1:124)|125|(1:127)(5:128|(1:130)(1:131)|132|(1:134)(1:135)|136)|(1:138)|139|(4:142|(3:215|144|218)(3:214|145|217)|216|140)|213|146|(2:147|(2:149|(2:220|151)(1:221))(2:219|152))|153|(3:159|(4:162|(3:224|164|227)(3:223|165|226)|225|160)|222)|166|185|167|170|187|171|172|174|(2:176|(1:178)(2:179|180))(1:181)|182|183))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c8, code lost:
    
        d6.b.b(null, com.inmobi.cmp.model.ChoiceError.ERROR_WHILE_SAVING_CONSENT.getMessage(), null, 5);
        r13 = "";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x026f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r31v0, types: [g7.l] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [t6.t] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v31, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(java.util.List r29, boolean r30, g7.l r31) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.k(java.util.List, boolean, g7.l):void");
    }

    public void l(boolean z9) {
        int i10 = z9 ? 1 : 2;
        g(6, Integer.valueOf(i10));
        ((USRegulationData) this.e).setSensitiveDataLimitUseNotice(i10);
    }

    public String p() {
        return "usnat";
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x0393, code lost:
    
        throw new h6.e("h.i: invalid language code: ".concat(r3));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04ed A[LOOP:4: B:226:0x04c4->B:236:0x04ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0504 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04eb A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q() throws h6.e, java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 1706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.r.q():void");
    }

    public void r(boolean z9) {
        int i10 = z9 ? 1 : 2;
        g(5, Integer.valueOf(i10));
        ((USRegulationData) this.e).setSensitiveDataProcessingOptOutNotice(i10);
    }

    public p8.z s() {
        if (((p8.s) this.f13463c) != null) {
            return new p8.z(this);
        }
        androidx.window.layout.c.g("url == null");
        return null;
    }

    public int t() {
        return 7;
    }

    public void u(boolean z9) {
        int i10 = z9 ? 1 : 2;
        g(1, Integer.valueOf(i10));
        ((USRegulationData) this.e).setSharingNotice(i10);
    }

    public void v(boolean z9) {
        int i10 = z9 ? 1 : 2;
        g(3, Integer.valueOf(i10));
        ((USRegulationData) this.e).setSharingOptOutNotice(i10);
    }

    public void w(boolean z9) {
        int i10 = z9 ? 1 : 2;
        g(4, Integer.valueOf(i10));
        ((USRegulationData) this.e).setTargetedAdvertisingOptOutNotice(i10);
    }

    public Object x(y6.i iVar) throws Throwable {
        Integer numU;
        String str = (String) this.f13464d;
        String str2 = (String) this.f13462b;
        int i10 = 0;
        x6.a aVar = x6.a.f13718a;
        w6.c cVar = null;
        s6.w wVar = s6.w.f12711a;
        if (str2 != null && (numU = o7.t.U(str2)) != null && numU.intValue() > 0) {
            y7.e eVar = i0.f12407a;
            Object objZ = r7.y.z(new c5.a0(this, str2, cVar, i10), y7.d.f14116a, iVar);
            if (objZ != aVar) {
                objZ = wVar;
            }
            if (objZ == aVar) {
                return objZ;
            }
        } else if (str == null || str.length() == 0) {
            y7.e eVar2 = i0.f12407a;
            Object objZ2 = r7.y.z(new c5.y(this, cVar, i10), w7.n.f13548a, iVar);
            if (objZ2 == aVar) {
                return objZ2;
            }
        } else {
            str.getClass();
            y7.e eVar3 = i0.f12407a;
            Object objZ3 = r7.y.z(new c5.a0(this, str, cVar, 1), y7.d.f14116a, iVar);
            if (objZ3 != aVar) {
                objZ3 = wVar;
            }
            if (objZ3 == aVar) {
                return objZ3;
            }
        }
        return wVar;
    }

    public boolean z(Context context) {
        if (((Boolean) this.f13464d) == null) {
            this.f13464d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.f13463c).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f13464d).booleanValue();
    }

    public /* synthetic */ r(boolean z9) {
        this.f13461a = 22;
    }

    public r(h1 h1Var, String str) {
        this.f13461a = 3;
        this.e = h1Var;
        i0.y.d(str);
        this.f13462b = str;
        this.f13463c = new Bundle();
    }

    public r(d0.i iVar, f6.m mVar, ChoiceCmpCallback choiceCmpCallback) {
        this.f13461a = 19;
        this.f13462b = iVar;
        this.f13463c = mVar;
        this.f13464d = choiceCmpCallback;
        this.e = new h6.f(t6.m.R(f6.j.CORE));
    }

    public r(r rVar, com.google.android.gms.internal.measurement.t tVar) {
        this.f13461a = 9;
        this.f13464d = new HashMap();
        this.e = new HashMap();
        this.f13462b = rVar;
        this.f13463c = tVar;
    }

    public r(Context context, String str, String str2, g5.z zVar) {
        this.f13461a = 6;
        this.f13463c = context;
        this.f13462b = str;
        this.f13464d = str2;
        this.e = zVar;
    }

    public r(Context context, String str, g5.i iVar, LifecycleCoroutineScope lifecycleCoroutineScope) {
        this.f13461a = 5;
        str.getClass();
        iVar.getClass();
        lifecycleCoroutineScope.getClass();
        this.f13463c = context;
        this.f13462b = str;
        this.f13464d = iVar;
        this.e = lifecycleCoroutineScope;
        r7.y.q(lifecycleCoroutineScope, null, null, new c5.w(this, null, 0), 3);
    }

    public r(DocumentFile documentFile, File file, FileExplorerActivity fileExplorerActivity, i0.k kVar) {
        this.f13461a = 24;
        this.f13462b = documentFile;
        this.f13463c = file;
        this.f13464d = fileExplorerActivity;
        this.e = kVar;
        y7.e eVar = i0.f12407a;
        r7.y.q(r7.y.a(y7.d.f14116a), null, null, new s4.p(this, null, 0), 3);
    }

    public r(Context context, f1 f1Var, h5.k kVar) {
        this.f13461a = 4;
        f1Var.getClass();
        kVar.getClass();
        this.f13462b = context;
        this.f13463c = f1Var;
        this.f13464d = kVar;
        this.e = new ArrayList();
    }

    public r(RelativeLayout relativeLayout, LinearLayout linearLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.f13461a = 10;
        this.f13462b = relativeLayout;
        this.f13463c = linearLayout;
        this.f13464d = progressBar;
        this.e = textView3;
    }

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f13461a = i10;
        this.f13462b = obj;
        this.f13463c = obj2;
        this.f13464d = obj3;
        this.e = obj4;
    }
}
