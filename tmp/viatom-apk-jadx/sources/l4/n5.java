package l4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import com.uptodown.workers.DownloadWorker;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n5 implements g5.c, g5.g, g5.w, g5.v, g5.x, g5.n, g5.d, g5.b, g5.q, g5.i, t4.a, j4.g, g5.l, u1.b, v1.a, h1.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10653a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10654b;

    public n5(int i10) {
        this.f10653a = i10;
        switch (i10) {
            case 23:
                break;
            case 26:
                this.f10654b = new int[2];
                break;
            default:
                this.f10654b = new ArrayList(20);
                break;
        }
    }

    public static void S(String str, String str2) {
        if (str == null) {
            androidx.window.layout.c.k("name == null");
            return;
        }
        if (str.isEmpty()) {
            com.google.gson.internal.a.n("name is empty");
            return;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i10), str};
                byte[] bArr = q8.c.f12289a;
                com.google.gson.internal.a.n(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", objArr));
                return;
            }
        }
        if (str2 == null) {
            androidx.window.layout.c.k(androidx.constraintlayout.core.widgets.analyzer.a.x("value for name ", str, " == null"));
            return;
        }
        int length2 = str2.length();
        for (int i11 = 0; i11 < length2; i11++) {
            char cCharAt2 = str2.charAt(i11);
            if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                Object[] objArr2 = {Integer.valueOf(cCharAt2), Integer.valueOf(i11), str, str2};
                byte[] bArr2 = q8.c.f12289a;
                com.google.gson.internal.a.n(String.format(Locale.US, "Unexpected char %#04x at %d in %s value: %s", objArr2));
                return;
            }
        }
    }

    public static boolean e0(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static void f0(String str) {
        v4.a aVar;
        c2.d dVar;
        str.getClass();
        v4.a aVar2 = o4.b.f11721u;
        aVar2.getClass();
        Socket socket = aVar2.e;
        if (socket == null || socket.isClosed()) {
            if (o4.b.t == null || (aVar = o4.b.f11721u) == null || (dVar = aVar.f13126b) == null) {
                return;
            }
            dVar.o();
            return;
        }
        Activity activity = o4.b.g;
        if (activity == null || !(activity instanceof p4.m0)) {
            return;
        }
        ((p4.m0) activity).H();
    }

    public static void g0(String str) {
        t1.c cVar;
        str.getClass();
        Activity activity = o4.b.g;
        String str2 = "File Transfer is correct!";
        if (activity == null || !(activity instanceof p4.m0)) {
            o4.b.f11723w = str;
            o4.b.f11724x = "File Transfer is correct!";
        } else {
            p4.m0 m0Var = (p4.m0) activity;
            m0Var.runOnUiThread(new androidx.work.impl.c(m0Var, str, str2, 4));
        }
        v4.a aVar = o4.b.f11721u;
        if (aVar == null || (cVar = aVar.f13127c) == null) {
            return;
        }
        new Thread(new a4.a(cVar, 24)).start();
    }

    public static void h0(u4.c cVar) {
        cVar.getClass();
        Activity activity = o4.b.g;
        if (activity == null || !(activity instanceof p4.m0)) {
            return;
        }
        p4.m0 m0Var = (p4.m0) activity;
        m0Var.runOnUiThread(new androidx.browser.trusted.c(17, m0Var, cVar));
    }

    public static void j0(u4.c cVar) {
        v4.a aVar;
        t1.c cVar2;
        cVar.getClass();
        File file = cVar.f12898a;
        if (file == null || (aVar = o4.b.f11721u) == null || (cVar2 = aVar.f13127c) == null) {
            return;
        }
        new Thread(new r5.a(3, cVar2, file)).start();
    }

    public static void n0(NsdServiceInfo nsdServiceInfo) {
        v4.a aVar = o4.b.f11721u;
        if (aVar != null) {
            Socket socket = aVar.f13128d;
            if (socket == null || socket.isClosed()) {
                ((o4.b) aVar.f13125a.f10654b).b();
            } else {
                t1.c cVar = aVar.f13127c;
                String str = o4.b.f11715n;
                if (str == null) {
                    kotlin.jvm.internal.l.i("myNsdServiceName");
                    throw null;
                }
                cVar.getClass();
                new Thread(new r5.a(4, cVar, str)).start();
            }
        }
        Activity activity = o4.b.g;
        if (activity == null || !(activity instanceof p4.m0)) {
            return;
        }
        p4.m0 m0Var = (p4.m0) activity;
        m0Var.runOnUiThread(new androidx.browser.trusted.c(16, m0Var, nsdServiceInfo));
    }

    public static String r0(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(RewardPlus.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public static String s0(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    @Override // g5.n
    public void B(int i10) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f10654b;
        float f = UptodownApp.E;
        if (k4.c.s()) {
            if (h5.c1.h(reviewsActivity) == null) {
                String string = reviewsActivity.getString(R.string.login_required_like_title);
                string.getClass();
                String string2 = reviewsActivity.getString(R.string.login_required_like_msg);
                string2.getClass();
                a.a.q(reviewsActivity, string, string2);
                return;
            }
            n4.i0 i0Var = reviewsActivity.J;
            w6.c cVar = null;
            h5.t0 t0Var = (i0Var == null || (arrayList = i0Var.f11374a) == null) ? null : (h5.t0) arrayList.get(i10);
            if (!k4.c.s() || t0Var == null) {
                return;
            }
            if (v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                return;
            }
            k8 k8VarP0 = reviewsActivity.p0();
            k8VarP0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(k8VarP0);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var, reviewsActivity, k8VarP0, cVar, 17), 2);
        }
    }

    @Override // g5.g
    public void C(h5.q qVar) {
        switch (this.f10653a) {
            case 1:
                ((PublicListActivity) this.f10654b).D0(qVar != null ? qVar.f8701b : null);
                break;
            default:
                ((WishlistActivity) this.f10654b).D0(qVar != null ? qVar.f8701b : null);
                break;
        }
    }

    @Override // t4.a
    public void D(File file) {
        file.getClass();
    }

    @Override // g5.d
    public void E(h5.h hVar, int i10) {
        hVar.getClass();
        t3.h hVar2 = v5.g.f13148u;
        SearchActivity searchActivity = (SearchActivity) this.f10654b;
        v5.g gVarL = hVar2.l(searchActivity);
        gVarL.a();
        String str = hVar.f8595w;
        str.getClass();
        h5.y0 y0VarM = gVarL.M(str);
        h5.q qVarA = y0VarM != null ? y0VarM.a(searchActivity) : null;
        if (qVarA == null) {
            String str2 = hVar.f8595w;
            str2.getClass();
            qVarA = gVarL.B(hVar.f8569d, str2);
        }
        if (qVarA == null) {
            String str3 = hVar.f8595w;
            str3.getClass();
            qVarA = gVarL.A(str3);
        }
        gVarL.b();
        if (qVarA != null) {
            long j10 = hVar.f8566a;
            h5.q qVar = DownloadWorker.f6738d;
            if (qVar != null && qVar.h == j10) {
                DownloadWorker.f = false;
                DownloadWorker.e = true;
            }
            qVarA.r(searchActivity);
            n4.l0 l0Var = searchActivity.K;
            if (l0Var != null) {
                l0Var.notifyItemChanged(i10);
            }
            if (y0VarM != null) {
                float f = UptodownApp.E;
                k4.c.w(y0VarM.f8795b);
            }
        }
    }

    @Override // u1.b
    public void H(Bundle bundle, String str) {
        w1.n nVar = (w1.n) this.f10654b;
        if (nVar != null) {
            try {
                String str2 = "$A$:" + r0(bundle, str);
                w1.p pVar = nVar.f13367a;
                pVar.f13382o.f13576a.a(new w1.o(pVar, System.currentTimeMillis() - pVar.f13375d, str2, 0));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // g5.x
    public void I(int i10) {
        n4.d1 d1Var;
        RecommendedActivity recommendedActivity = (RecommendedActivity) this.f10654b;
        float f = UptodownApp.E;
        if (!k4.c.s() || (d1Var = recommendedActivity.W) == null || d1Var.f11324a.isEmpty()) {
            return;
        }
        n4.d1 d1Var2 = recommendedActivity.W;
        d1Var2.getClass();
        Object obj = d1Var2.f11324a.get(i10);
        obj.getClass();
        h5.i1 i1Var = (h5.i1) obj;
        l1.b.p(i1Var.f8616a, recommendedActivity, i1Var.f8619d);
        n4.d1 d1Var3 = recommendedActivity.W;
        if (d1Var3 != null) {
            d1Var3.notifyItemChanged(i10);
        }
    }

    @Override // t4.a
    public void J(Object obj) {
        obj.getClass();
    }

    @Override // g5.n
    public void K(int i10) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f10654b;
        n4.i0 i0Var = reviewsActivity.J;
        h5.t0 t0Var = (i0Var == null || (arrayList = i0Var.f11374a) == null) ? null : (h5.t0) arrayList.get(i10);
        Intent intent = new Intent(reviewsActivity, (Class<?>) RepliesActivity.class);
        intent.putExtra("review", t0Var);
        h5.h hVar = (h5.h) reviewsActivity.p0().f10560i.getValue();
        intent.putExtra("appIconUrl", hVar != null ? hVar.f8575l : null);
        h5.h hVar2 = (h5.h) reviewsActivity.p0().f10560i.getValue();
        String str = hVar2 != null ? hVar2.f8567b : null;
        if (str != null && str.length() != 0) {
            Object value = reviewsActivity.p0().f10560i.getValue();
            value.getClass();
            intent.putExtra("appName", ((h5.h) value).f8567b);
        }
        float f = UptodownApp.E;
        reviewsActivity.startActivity(intent, k4.c.a(reviewsActivity));
    }

    @Override // t4.a
    public void L() {
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10654b;
        fileExplorerActivity.W = null;
        fileExplorerActivity.W();
        fileExplorerActivity.Y(true);
        AlertDialog alertDialog = fileExplorerActivity.f11942a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        fileExplorerActivity.f11942a = null;
    }

    @Override // g5.n
    public void O() {
        ((ReviewsActivity) this.f10654b).l0();
    }

    public JSONObject P(View view) {
        int[] iArr = (int[]) this.f10654b;
        if (view == null) {
            return z3.b.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(iArr);
        return z3.b.a(iArr[0], iArr[1], width, height);
    }

    public void Q(String str) {
        int iIndexOf = str.indexOf(":", 1);
        if (iIndexOf != -1) {
            R(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } else if (str.startsWith(":")) {
            R("", str.substring(1));
        } else {
            R("", str);
        }
    }

    public void R(String str, String str2) {
        ArrayList arrayList = (ArrayList) this.f10654b;
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    public String T(String str) {
        ArrayList arrayList = (ArrayList) this.f10654b;
        for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase((String) arrayList.get(size))) {
                return (String) arrayList.get(size + 1);
            }
        }
        return null;
    }

    public boolean U(String str) {
        String strC0 = c0(str);
        return "1".equals(strC0) || Boolean.parseBoolean(strC0);
    }

    public Integer V(String str) {
        String strC0 = c0(str);
        if (TextUtils.isEmpty(strC0)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strC0));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + s0(str) + "(" + strC0 + ") into an int");
            return null;
        }
    }

    public JSONArray W(String str) {
        String strC0 = c0(str);
        if (TextUtils.isEmpty(strC0)) {
            return null;
        }
        try {
            return new JSONArray(strC0);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + s0(str) + ": " + strC0 + ", falling back to default");
            return null;
        }
    }

    public int[] X() throws JSONException {
        JSONArray jSONArrayW = W("gcm.n.light_settings");
        if (jSONArrayW == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayW.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int color = Color.parseColor(jSONArrayW.optString(0));
            if (color == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = color;
            iArr[1] = jSONArrayW.optInt(1);
            iArr[2] = jSONArrayW.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayW + ". " + e.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayW + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Object[] Y(String str) {
        JSONArray jSONArrayW = W(str.concat("_loc_args"));
        if (jSONArrayW == null) {
            return null;
        }
        int length = jSONArrayW.length();
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = jSONArrayW.optString(i10);
        }
        return strArr;
    }

    public String Z(String str) {
        return c0(str.concat("_loc_key"));
    }

    @Override // g5.y, g5.b, g5.p
    public void a(int i10) {
        n4.d1 d1Var;
        String str;
        switch (this.f10653a) {
            case 4:
                RecommendedActivity recommendedActivity = (RecommendedActivity) this.f10654b;
                float f = UptodownApp.E;
                if (k4.c.s() && (d1Var = recommendedActivity.W) != null && !d1Var.f11324a.isEmpty()) {
                    n4.d1 d1Var2 = recommendedActivity.W;
                    d1Var2.getClass();
                    Object obj = d1Var2.f11324a.get(i10);
                    obj.getClass();
                    h5.i1 i1Var = (h5.i1) obj;
                    recommendedActivity.Z(i1Var.f8616a, i1Var.f8620i);
                    break;
                }
                break;
            case 9:
                SecurityActivity securityActivity = (SecurityActivity) this.f10654b;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    int i11 = SecurityActivity.Z;
                    n4.m0 m0Var = securityActivity.W;
                    m0Var.getClass();
                    if (m0Var.a().get(i10) instanceof h5.f) {
                        n4.m0 m0Var2 = securityActivity.W;
                        m0Var2.getClass();
                        Object obj2 = m0Var2.a().get(i10);
                        obj2.getClass();
                        h5.f fVar = (h5.f) obj2;
                        if (!securityActivity.isFinishing()) {
                            int i12 = 0;
                            View viewInflate = securityActivity.getLayoutInflater().inflate(R.layout.dialog_positive_selected, (ViewGroup) null, false);
                            int i13 = R.id.iv_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon);
                            if (imageView != null) {
                                i13 = R.id.rl_header;
                                if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_header)) != null) {
                                    i13 = R.id.tv_app_name;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name);
                                    if (textView != null) {
                                        i13 = R.id.tv_open_app_details_positive;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_open_app_details_positive);
                                        if (textView2 != null) {
                                            i13 = R.id.tv_rollback_positive;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_rollback_positive);
                                            if (textView3 != null) {
                                                i13 = R.id.tv_uninstall_positive;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_uninstall_positive);
                                                if (textView4 != null) {
                                                    i13 = R.id.tv_virus_report_positive;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_virus_report_positive);
                                                    if (textView5 != null) {
                                                        i13 = R.id.v_outside_header;
                                                        if (ViewBindings.findChildViewById(viewInflate, R.id.v_outside_header) != null) {
                                                            securityActivity.f10935w = new AlertDialog.Builder(securityActivity).setView((RelativeLayout) viewInflate).create();
                                                            textView.setTypeface(o4.b.f11719r);
                                                            textView.setText(fVar.f8525b);
                                                            ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
                                                            imageView.setImageDrawable(v5.n.c(securityActivity, fVar.f8526c));
                                                            int i14 = 1;
                                                            if (fVar.f8526c == null || fVar.f8531l == null || fVar.f8541w <= 0) {
                                                                textView2.setVisibility(8);
                                                                textView5.setVisibility(8);
                                                                textView3.setVisibility(8);
                                                            } else {
                                                                textView2.setTypeface(o4.b.f11720s);
                                                                textView2.setOnClickListener(new c9(securityActivity, fVar, i12));
                                                                textView5.setTypeface(o4.b.f11720s);
                                                                textView5.setOnClickListener(new c9(securityActivity, fVar, i14));
                                                                textView3.setTypeface(o4.b.f11720s);
                                                                textView3.setOnClickListener(new c9(securityActivity, fVar, 2));
                                                            }
                                                            if (o7.u.Z(securityActivity.getPackageName(), fVar.f8526c, true)) {
                                                                textView4.setVisibility(8);
                                                            } else {
                                                                textView4.setTypeface(o4.b.f11720s);
                                                                textView4.setOnClickListener(new c9(fVar, securityActivity));
                                                            }
                                                            if (!securityActivity.isFinishing()) {
                                                                AlertDialog alertDialog = securityActivity.f10935w;
                                                                alertDialog.getClass();
                                                                Window window = alertDialog.getWindow();
                                                                if (window != null) {
                                                                    a3.a.A(window, 0);
                                                                }
                                                                AlertDialog alertDialog2 = securityActivity.f10935w;
                                                                alertDialog2.getClass();
                                                                alertDialog2.show();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i13)));
                            break;
                        }
                    }
                }
                break;
            default:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) this.f10654b;
                n4.b1 b1Var = userDeviceDetailsActivity.J;
                if (b1Var != null && (str = ((h5.g1) b1Var.f11307a.get(i10)).f8563b) != null && str.length() != 0) {
                    n4.b1 b1Var2 = userDeviceDetailsActivity.J;
                    b1Var2.getClass();
                    String str2 = ((h5.g1) b1Var2.f11307a.get(i10)).f8563b;
                    str2.getClass();
                    new w2.r(userDeviceDetailsActivity, str2, userDeviceDetailsActivity.M, LifecycleOwnerKt.getLifecycleScope(userDeviceDetailsActivity));
                    break;
                }
                break;
        }
    }

    public Long a0() {
        String strC0 = c0("gcm.n.event_time");
        if (TextUtils.isEmpty(strC0)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strC0));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + s0("gcm.n.event_time") + "(" + strC0 + ") into a long");
            return null;
        }
    }

    @Override // g5.y
    public void b(View view, int i10) {
        n4.d1 d1Var;
        RecommendedActivity recommendedActivity = (RecommendedActivity) this.f10654b;
        float f = UptodownApp.E;
        if (!k4.c.s() || (d1Var = recommendedActivity.W) == null || d1Var.f11324a.isEmpty()) {
            return;
        }
        n4.d1 d1Var2 = recommendedActivity.W;
        d1Var2.getClass();
        Object obj = d1Var2.f11324a.get(i10);
        obj.getClass();
        h5.i1 i1Var = (h5.i1) obj;
        String string = recommendedActivity.getString(R.string.dialog_recommended_remove_msg, i1Var.f8617b);
        string.getClass();
        recommendedActivity.K(string, new w4(recommendedActivity, i10, i1Var, 1));
    }

    public String b0(Resources resources, String str, String str2) {
        String strC0 = c0(str2);
        if (!TextUtils.isEmpty(strC0)) {
            return strC0;
        }
        String strZ = Z(str2);
        if (TextUtils.isEmpty(strZ)) {
            return null;
        }
        int identifier = resources.getIdentifier(strZ, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            Log.w("NotificationParams", s0(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] objArrY = Y(str2);
        if (objArrY == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrY);
        } catch (MissingFormatArgumentException e) {
            Log.w("NotificationParams", "Missing format argument for " + s0(str2) + ": " + Arrays.toString(objArrY) + " Default value will be used.", e);
            return null;
        }
    }

    @Override // g5.l
    public void c(ArrayList arrayList) {
        TvOldVersionsFragment tvOldVersionsFragment = (TvOldVersionsFragment) this.f10654b;
        h5.h hVar = tvOldVersionsFragment.f6715a;
        hVar.getClass();
        hVar.C0 = arrayList;
        h5.h hVar2 = tvOldVersionsFragment.f6715a;
        hVar2.getClass();
        if (hVar2.C0 != null) {
            h5.h hVar3 = tvOldVersionsFragment.f6715a;
            hVar3.getClass();
            ArrayList arrayList2 = hVar3.C0;
            arrayList2.getClass();
            TvOldVersionsFragment.c(tvOldVersionsFragment, arrayList2);
        }
    }

    public String c0(String str) {
        Bundle bundle = (Bundle) this.f10654b;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    @Override // g5.b, g5.p
    public void d(int i10) {
        switch (this.f10653a) {
            case 9:
                SecurityActivity securityActivity = (SecurityActivity) this.f10654b;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    int i11 = SecurityActivity.Z;
                    n4.m0 m0Var = securityActivity.W;
                    m0Var.getClass();
                    if (m0Var.a().get(i10) instanceof h5.f) {
                        n4.m0 m0Var2 = securityActivity.W;
                        m0Var2.getClass();
                        Object obj = m0Var2.a().get(i10);
                        obj.getClass();
                        long j10 = ((h5.f) obj).f8541w;
                        if (j10 > 0) {
                            securityActivity.Y(j10);
                            break;
                        }
                    }
                }
                break;
        }
    }

    public long[] d0() throws JSONException {
        JSONArray jSONArrayW = W("gcm.n.vibrate_timings");
        if (jSONArrayW == null) {
            return null;
        }
        try {
            if (jSONArrayW.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayW.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = jSONArrayW.optLong(i10);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + jSONArrayW + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    @Override // g5.n
    public void e(int i10) {
        switch (this.f10653a) {
            case 6:
                RepliesActivity repliesActivity = (RepliesActivity) this.f10654b;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    if (h5.c1.h(repliesActivity) == null) {
                        String string = repliesActivity.getString(R.string.login_required_follow_title);
                        string.getClass();
                        String string2 = repliesActivity.getString(R.string.login_required_follow_msg);
                        string2.getClass();
                        a.a.q(repliesActivity, string, string2);
                        break;
                    } else {
                        if (i10 == -1 && repliesActivity.o0().f11039m.getValue() != null) {
                            Object value = repliesActivity.o0().f11039m.getValue();
                            value.getClass();
                            String str = ((h5.t0) value).f8740b;
                            if (str != null && str.length() != 0) {
                                y7 y7VarO0 = repliesActivity.o0();
                                Object value2 = repliesActivity.o0().f11039m.getValue();
                                value2.getClass();
                                int i11 = ((h5.t0) value2).f8749o;
                                Object value3 = repliesActivity.o0().f11039m.getValue();
                                value3.getClass();
                                String str2 = ((h5.t0) value3).f8740b;
                                str2.getClass();
                                y7VarO0.a(repliesActivity, i11, str2);
                                break;
                            }
                        }
                        if (repliesActivity.J != null) {
                            y7 y7VarO02 = repliesActivity.o0();
                            n4.h0 h0Var = repliesActivity.J;
                            h0Var.getClass();
                            int i12 = ((h5.m0) h0Var.f11363a.get(i10)).f8664l;
                            n4.h0 h0Var2 = repliesActivity.J;
                            h0Var2.getClass();
                            String str3 = ((h5.m0) h0Var2.f11363a.get(i10)).f8659c;
                            str3.getClass();
                            y7VarO02.a(repliesActivity, i12, str3);
                            break;
                        }
                    }
                }
                break;
            default:
                ReviewsActivity reviewsActivity = (ReviewsActivity) this.f10654b;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    if (h5.c1.h(reviewsActivity) == null) {
                        String string3 = reviewsActivity.getString(R.string.login_required_follow_title);
                        string3.getClass();
                        String string4 = reviewsActivity.getString(R.string.login_required_follow_msg);
                        string4.getClass();
                        a.a.q(reviewsActivity, string3, string4);
                        break;
                    } else {
                        n4.i0 i0Var = reviewsActivity.J;
                        w6.c cVar = null;
                        h5.t0 t0Var = i0Var != null ? (h5.t0) i0Var.f11374a.get(i10) : null;
                        if (t0Var != null) {
                            k8 k8VarP0 = reviewsActivity.p0();
                            int i13 = t0Var.f8749o;
                            String strValueOf = String.valueOf(t0Var.f8740b);
                            k8VarP0.getClass();
                            if (i13 != 1) {
                                r7.w viewModelScope = ViewModelKt.getViewModelScope(k8VarP0);
                                y7.e eVar = r7.i0.f12407a;
                                r7.y.q(viewModelScope, y7.d.f14116a, null, new j8(reviewsActivity, strValueOf, k8VarP0, cVar, 0), 2);
                                break;
                            } else {
                                r7.w viewModelScope2 = ViewModelKt.getViewModelScope(k8VarP0);
                                y7.e eVar2 = r7.i0.f12407a;
                                r7.y.q(viewModelScope2, y7.d.f14116a, null, new j8(reviewsActivity, strValueOf, k8VarP0, cVar, 1), 2);
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override // g5.w
    public void g(ArrayList arrayList, int i10, boolean z9) {
        switch (this.f10653a) {
            case 2:
                int size = arrayList.size();
                m6 m6Var = (m6) this.f10654b;
                u7.m0 m0Var = m6Var.f10626a;
                int i11 = m6Var.f;
                if (size > 0) {
                    m6Var.f = arrayList.size() + i11;
                    v5.l lVar = new v5.l(arrayList);
                    m0Var.getClass();
                    m0Var.g(null, lVar);
                } else if (i11 == 0) {
                    v5.l lVar2 = new v5.l(new ArrayList());
                    m0Var.getClass();
                    m0Var.g(null, lVar2);
                } else {
                    m6Var.f10629d = true;
                    m0Var.getClass();
                    m0Var.g(null, v5.k.f13167a);
                }
                m6Var.e = false;
                break;
            case 5:
                boolean zIsEmpty = arrayList.isEmpty();
                l7 l7Var = (l7) this.f10654b;
                u7.m0 m0Var2 = l7Var.f10596a;
                int i12 = l7Var.g;
                if (!zIsEmpty) {
                    l7Var.g = arrayList.size() + i12;
                    v5.l lVar3 = new v5.l(arrayList);
                    m0Var2.getClass();
                    m0Var2.g(null, lVar3);
                    u7.m0 m0Var3 = l7Var.f10598c;
                    Boolean boolValueOf = Boolean.valueOf(z9);
                    m0Var3.getClass();
                    m0Var3.g(null, boolValueOf);
                } else if (i12 == 0) {
                    v5.l lVar4 = new v5.l(new ArrayList());
                    m0Var2.getClass();
                    m0Var2.g(null, lVar4);
                } else {
                    l7Var.e = true;
                    m0Var2.getClass();
                    m0Var2.g(null, v5.k.f13167a);
                }
                l7Var.f = false;
                break;
            default:
                boolean zIsEmpty2 = arrayList.isEmpty();
                pc pcVar = (pc) this.f10654b;
                u7.m0 m0Var4 = pcVar.f10742a;
                int i13 = pcVar.e;
                if (!zIsEmpty2) {
                    pcVar.e = arrayList.size() + i13;
                    v5.l lVar5 = new v5.l(new oc(arrayList));
                    m0Var4.getClass();
                    m0Var4.g(null, lVar5);
                } else if (i13 == 0) {
                    v5.l lVar6 = new v5.l(new oc(new ArrayList()));
                    m0Var4.getClass();
                    m0Var4.g(null, lVar6);
                } else {
                    pcVar.f10744c = true;
                    m0Var4.getClass();
                    m0Var4.g(null, v5.k.f13167a);
                }
                pcVar.f10745d = false;
                break;
        }
    }

    @Override // g5.g
    public void h(h5.q qVar) {
        switch (this.f10653a) {
            case 1:
                float f = UptodownApp.E;
                File fileG = qVar.g();
                fileG.getClass();
                k4.c.p((PublicListActivity) this.f10654b, fileG, null);
                break;
            default:
                float f10 = UptodownApp.E;
                File fileG2 = qVar.g();
                fileG2.getClass();
                k4.c.p((WishlistActivity) this.f10654b, fileG2, null);
                break;
        }
    }

    @Override // g5.v
    public void i() {
        switch (this.f10653a) {
            case 2:
                m6 m6Var = (m6) this.f10654b;
                u7.m0 m0Var = m6Var.f10626a;
                m0Var.getClass();
                m0Var.g(null, v5.k.f13167a);
                m6Var.e = false;
                return;
            case 3:
                throw null;
            case 4:
            default:
                pc pcVar = (pc) this.f10654b;
                u7.m0 m0Var2 = pcVar.f10742a;
                v5.l lVar = new v5.l(new oc(new ArrayList()));
                m0Var2.getClass();
                m0Var2.g(null, lVar);
                pcVar.f10745d = false;
                return;
            case 5:
                l7 l7Var = (l7) this.f10654b;
                u7.m0 m0Var3 = l7Var.f10596a;
                v5.l lVar2 = new v5.l(new ArrayList());
                m0Var3.getClass();
                m0Var3.g(null, lVar2);
                l7Var.f = false;
                return;
        }
    }

    @Override // g5.x
    public void j(int i10) {
        n4.d1 d1Var;
        RecommendedActivity recommendedActivity = (RecommendedActivity) this.f10654b;
        float f = UptodownApp.E;
        if (!k4.c.s() || (d1Var = recommendedActivity.W) == null || d1Var.f11324a.isEmpty()) {
            return;
        }
        n4.d1 d1Var2 = recommendedActivity.W;
        d1Var2.getClass();
        new c1.l(recommendedActivity, ((h5.i1) d1Var2.f11324a.get(i10)).f8616a, new f7(recommendedActivity, i10), LifecycleOwnerKt.getLifecycleScope(recommendedActivity));
    }

    public void k0(int i10) {
        NsdManager nsdManager;
        o4.a aVar = ((o4.b) this.f10654b).f;
        try {
            v4.f fVar = o4.b.t;
            if (fVar != null && (nsdManager = fVar.f13135b) != null) {
                nsdManager.unregisterService(aVar);
            }
        } catch (Exception unused) {
        }
        v4.f fVar2 = o4.b.t;
        if (fVar2 != null) {
            aVar.getClass();
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setPort(i10);
            String str = o4.b.f11715n;
            if (str == null) {
                kotlin.jvm.internal.l.i("myNsdServiceName");
                throw null;
            }
            nsdServiceInfo.setServiceName(str);
            nsdServiceInfo.setServiceType("_nsduptodown._tcp.");
            try {
                fVar2.f13135b.registerService(nsdServiceInfo, 1, aVar);
            } catch (Exception unused2) {
                ((o4.b) fVar2.f13134a.f10654b).b();
            }
        }
        v4.f fVar3 = o4.b.t;
        if (fVar3 != null) {
            fVar3.b();
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        UserCommentsActivity userCommentsActivity = (UserCommentsActivity) this.f10654b;
        Intent intent = new Intent(userCommentsActivity, (Class<?>) AppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        float f = UptodownApp.E;
        userCommentsActivity.startActivity(intent, k4.c.a(userCommentsActivity));
    }

    public void l0(String str) {
        o4.b bVar = (o4.b) this.f10654b;
        Activity activity = o4.b.g;
        if (activity == null || !(activity instanceof p4.m0)) {
            o4.b.f11725z = str;
        } else {
            p4.m0 m0Var = (p4.m0) activity;
            m0Var.runOnUiThread(new p4.l0(m0Var, str, 0));
        }
        bVar.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    @Override // g5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(h5.h r11, int r12) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.n5.m(h5.h, int):void");
    }

    public void m0(String str) {
        ((o4.b) this.f10654b).b();
        Activity activity = o4.b.g;
        if (activity == null || !(activity instanceof p4.m0)) {
            o4.b.y = str;
        } else {
            p4.m0 m0Var = (p4.m0) activity;
            m0Var.runOnUiThread(new p4.l0(m0Var, str, 1));
        }
    }

    @Override // g5.x
    public void n(long j10, h5.k kVar) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            RecommendedActivity recommendedActivity = (RecommendedActivity) this.f10654b;
            if (j10 > 0) {
                new c1.l(recommendedActivity, j10, new i0.k(14, recommendedActivity, kVar), LifecycleOwnerKt.getLifecycleScope(recommendedActivity));
            } else {
                recommendedActivity.b0();
            }
        }
    }

    @Override // g5.n
    public void o(int i10) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f10654b;
        float f = UptodownApp.E;
        if (k4.c.s()) {
            n4.i0 i0Var = reviewsActivity.J;
            h5.t0 t0Var = (i0Var == null || (arrayList = i0Var.f11374a) == null) ? null : (h5.t0) arrayList.get(i10);
            if (t0Var != null) {
                c5.x xVar = new c5.x(reviewsActivity, LifecycleOwnerKt.getLifecycleScope(reviewsActivity));
                String str = t0Var.f8740b;
                str.getClass();
                xVar.a(str, new x4(reviewsActivity, 8));
            }
        }
    }

    public Bundle o0() {
        Bundle bundle = (Bundle) this.f10654b;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals(TypedValues.TransitionType.S_FROM)) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    @Override // g5.g
    public void onError(String str) {
        switch (this.f10653a) {
            case 1:
                ((PublicListActivity) this.f10654b).N(str);
                break;
            default:
                ((WishlistActivity) this.f10654b).N(str);
                break;
        }
    }

    @Override // j4.g
    public void onSuccess() {
        TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f10654b;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment), null, null, new s5.d(tvAppDetailFragment, null, 3), 3);
    }

    @Override // j4.g
    public void p(Exception exc) {
        exc.getClass();
    }

    public void p0(String str) {
        ArrayList arrayList = (ArrayList) this.f10654b;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i10))) {
                arrayList.remove(i10);
                arrayList.remove(i10);
                i10 -= 2;
            }
            i10 += 2;
        }
    }

    @Override // v1.a
    public void q(w1.n nVar) {
        this.f10654b = nVar;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    public void q0(String str) {
        NsdServiceInfo nsdServiceInfo;
        v4.a aVar = o4.b.f11721u;
        aVar.getClass();
        Socket socket = aVar.e;
        if (socket == null || socket.isClosed()) {
            v4.f fVar = o4.b.t;
            fVar.getClass();
            Iterator it = fVar.g.iterator();
            it.getClass();
            while (true) {
                if (!it.hasNext()) {
                    nsdServiceInfo = null;
                    break;
                }
                Object next = it.next();
                next.getClass();
                nsdServiceInfo = (NsdServiceInfo) next;
                if (str.equalsIgnoreCase(nsdServiceInfo.getServiceName())) {
                    break;
                }
            }
            if (nsdServiceInfo != null) {
                v4.f fVar2 = o4.b.t;
                fVar2.getClass();
                fVar2.d(nsdServiceInfo);
                return;
            }
            ((o4.b) this.f10654b).b();
            Activity activity = o4.b.g;
            if (activity == null || !(activity instanceof p4.m0)) {
                return;
            }
            p4.m0 m0Var = (p4.m0) activity;
            String string = r0.f.z().getString(R.string.error_nsd_service_not_found, str.substring(0, o7.m.k0(str, "_d:_", 0, false, 6)));
            string.getClass();
            m0Var.runOnUiThread(new p4.l0(m0Var, string, 0));
        }
    }

    @Override // g5.q
    public void r(h5.e1 e1Var) {
        UserActivity userActivity = (UserActivity) this.f10654b;
        Intent intent = new Intent(userActivity, (Class<?>) PublicProfileActivity.class);
        intent.putExtra("user", e1Var);
        float f = UptodownApp.E;
        userActivity.startActivity(intent, k4.c.a(userActivity));
    }

    @Override // t4.a
    public void s(Object obj, int i10, int i11, long j10) {
        obj.getClass();
        boolean z9 = obj instanceof File;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10654b;
        if (z9) {
            FileExplorerActivity.L(fileExplorerActivity, ((File) obj).getName(), i10, i11, j10);
        } else if (obj instanceof DocumentFile) {
            FileExplorerActivity.L(fileExplorerActivity, ((DocumentFile) obj).getName(), i10, i11, j10);
        } else {
            FileExplorerActivity.L(fileExplorerActivity, fileExplorerActivity.getString(R.string.copying), i10, i11, j10);
        }
    }

    @Override // t4.a
    public void t(File file) {
        file.getClass();
    }

    @Override // t4.a
    public void w(int i10, String str, long j10, long j11) {
        str.getClass();
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10654b;
        AlertDialog alertDialog = fileExplorerActivity.f11942a;
        if (alertDialog == null || alertDialog.findViewById(R.id.pb_dialog_copying) == null) {
            return;
        }
        AlertDialog alertDialog2 = fileExplorerActivity.f11942a;
        alertDialog2.getClass();
        ((ProgressBar) alertDialog2.findViewById(R.id.pb_dialog_copying)).setProgress(i10);
        AlertDialog alertDialog3 = fileExplorerActivity.f11942a;
        alertDialog3.getClass();
        ((TextView) alertDialog3.findViewById(R.id.tv_size_dialog_copying)).setText(fileExplorerActivity.getString(R.string.size_of_total_size, l1.b.L(j10), l1.b.L(j11)));
        AlertDialog alertDialog4 = fileExplorerActivity.f11942a;
        alertDialog4.getClass();
        ((TextView) alertDialog4.findViewById(R.id.tv_percentage_dialog_copying)).setText(i10 + fileExplorerActivity.getString(R.string.percentage));
        AlertDialog alertDialog5 = fileExplorerActivity.f11942a;
        alertDialog5.getClass();
        ((TextView) alertDialog5.findViewById(R.id.tv_files_dialog_copying)).setText(str);
    }

    @Override // g5.g
    public void x(String str) {
        int i10 = this.f10653a;
        str.getClass();
        switch (i10) {
            case 1:
                v5.c.e((PublicListActivity) this.f10654b, str, null);
                break;
            default:
                v5.c.e((WishlistActivity) this.f10654b, str, null);
                break;
        }
    }

    @Override // h1.h
    public h1.p y(Object obj) {
        e2.d dVar = (e2.d) obj;
        w1.l lVar = ((w1.j) this.f10654b).e;
        if (dVar != null) {
            return r0.f.M(Arrays.asList(w1.l.a(lVar), lVar.f13359m.n(lVar.e.f13576a, null)));
        }
        Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
        return r0.f.x(null);
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            ((OrganizationActivity) this.f10654b).Y(hVar.f8566a);
        }
    }

    @Override // g5.q
    public void F() {
    }

    @Override // g5.l
    public void u() {
    }

    private final void i0(int i10) {
    }

    @Override // g5.y
    public void N(int i10) {
    }

    @Override // g5.i
    public void f(int i10) {
    }

    @Override // t4.a
    public void k(DocumentFile documentFile) {
    }

    @Override // t4.a
    public void v(DocumentFile documentFile) {
    }

    public n5(Bundle bundle) {
        this.f10653a = 25;
        if (bundle != null) {
            this.f10654b = new Bundle(bundle);
        } else {
            androidx.window.layout.c.k(DataSchemeDataSource.SCHEME_DATA);
            throw null;
        }
    }

    public n5(w1.j jVar, String str) {
        this.f10653a = 24;
        this.f10654b = jVar;
    }

    public /* synthetic */ n5(Object obj, int i10) {
        this.f10653a = i10;
        this.f10654b = obj;
    }
}
