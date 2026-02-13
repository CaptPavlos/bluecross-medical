package a4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c1.c3;
import c1.d0;
import c1.f0;
import c1.k4;
import c1.p2;
import c1.u1;
import c1.w0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.l5;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import d5.n;
import d9.k;
import d9.q;
import d9.t;
import e0.m;
import e5.g1;
import e5.h1;
import e5.j0;
import e5.t1;
import g5.g;
import g5.i;
import h1.h;
import h1.p;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.l;
import l4.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r7.i0;
import r7.y;

/* loaded from: classes3.dex */
public final class f implements ViewBinding, h1.a, h, g, j4.g, NewInterstitialListener, i, f2.a, h1.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f217a;

    /* renamed from: b, reason: collision with root package name */
    public Object f218b;

    /* renamed from: c, reason: collision with root package name */
    public Object f219c;

    public f(IBinder iBinder) throws RemoteException {
        this.f217a = 14;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f218b = new Messenger(iBinder);
            this.f219c = null;
        } else {
            if (!Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
                Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
                throw new RemoteException();
            }
            this.f219c = new e0.g(iBinder);
            this.f218b = null;
        }
    }

    public static ArrayList d(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("customFooterLinks");
            int length = jSONArray.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                jSONObject2.getClass();
                String strOptString = jSONObject2.optString("label");
                strOptString.getClass();
                String strOptString2 = jSONObject2.optString("link");
                strOptString2.getClass();
                arrayList.add(new q(strOptString, strOptString2));
                i10 = i11;
            }
            return arrayList;
        } catch (Exception unused) {
            d6.b.a(3, "ChoiceCMP", "COP publisher link is null", null, Boolean.FALSE);
            return arrayList;
        }
    }

    public static f i(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_category);
        if (textView != null) {
            return new f((RelativeLayout) view, textView, 13, false);
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_preference_category)));
        return null;
    }

    @Override // g5.g
    public void C(h5.q qVar) {
        ((e5.d) this.f218b).b(((h5.h) this.f219c).f8595w);
    }

    @Override // h1.a
    public Object a(p pVar) {
        Bundle bundle;
        e0.b bVar = (e0.b) this.f218b;
        Bundle bundle2 = (Bundle) this.f219c;
        bVar.getClass();
        return (pVar.i() && (bundle = (Bundle) pVar.g()) != null && bundle.containsKey("google.messenger")) ? bVar.a(bundle2).j(e0.h.f7603c, e0.d.f7598d) : pVar;
    }

    public d9.a b() throws JSONException {
        try {
            JSONObject jSONObject = (JSONObject) this.f218b;
            if (jSONObject == null) {
                l.i("json");
                throw null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("advanced");
            String strOptString = jSONObject2.optString("initScreenSettingsButton");
            strOptString.getClass();
            String strOptString2 = jSONObject2.optString("initScreenRejectButton");
            strOptString2.getClass();
            String strOptString3 = jSONObject2.optString("privacyBody");
            strOptString3.getClass();
            String strOptString4 = jSONObject2.optString("privacyHeader");
            strOptString4.getClass();
            return new d9.a(strOptString, strOptString2, strOptString3, strOptString4, d(jSONObject2));
        } catch (JSONException unused) {
            d6.b.a(3, "ChoiceCMP", "Error in parsing AdvancedUILabels", null, Boolean.FALSE);
            return new d9.a();
        }
    }

    public Object c(String str) {
        str.getClass();
        try {
            this.f218b = new JSONObject(str);
            ((d0) this.f219c).getClass();
            return new t(d0.l(str), k(), j(), g(), b());
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new t();
        }
    }

    @Override // f2.a
    public StackTraceElement[] e(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        f2.a[] aVarArr = (f2.a[]) this.f218b;
        StackTraceElement[] stackTraceElementArrE = stackTraceElementArr;
        for (int i10 = 0; i10 < 1; i10++) {
            f2.a aVar = aVarArr[i10];
            if (stackTraceElementArrE.length <= 1024) {
                break;
            }
            stackTraceElementArrE = aVar.e(stackTraceElementArr);
        }
        return stackTraceElementArrE.length > 1024 ? ((d0) this.f219c).e(stackTraceElementArrE) : stackTraceElementArrE;
    }

    @Override // g5.i
    public void f(int i10) {
        switch (this.f217a) {
            case 20:
                h1 h1Var = (h1) this.f218b;
                if (h1Var.getActivity() != null && (h1Var.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity = h1Var.getActivity();
                    activity.getClass();
                    String string = h1Var.getString(R.string.app_detail_not_found);
                    string.getClass();
                    ((MainActivity) activity).C(string);
                    break;
                }
                break;
            default:
                t1 t1Var = (t1) this.f218b;
                if (t1Var.getActivity() != null && (t1Var.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity2 = t1Var.getActivity();
                    activity2.getClass();
                    String string2 = t1Var.getString(R.string.app_detail_not_found);
                    string2.getClass();
                    ((MainActivity) activity2).C(string2);
                    break;
                }
                break;
        }
    }

    public d9.e g() throws JSONException {
        try {
            JSONObject jSONObject = (JSONObject) this.f218b;
            if (jSONObject == null) {
                l.i("json");
                throw null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("consentOrPay");
            String strOptString = jSONObject2.optString("initScreenSettingsButton");
            strOptString.getClass();
            String strOptString2 = jSONObject2.optString("action1");
            strOptString2.getClass();
            String strOptString3 = jSONObject2.optString("action2");
            strOptString3.getClass();
            String strOptString4 = jSONObject2.optString("privacyBody");
            strOptString4.getClass();
            String strOptString5 = jSONObject2.optString("privacyHeader");
            strOptString5.getClass();
            return new d9.e(strOptString, strOptString2, strOptString3, strOptString4, strOptString5, d(jSONObject2));
        } catch (JSONException e) {
            d6.b.b("ChoiceCMP", "Error in parsing ConsentOrPayUILabels", e, 8);
            return new d9.e();
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f217a) {
            case 9:
                return (RelativeLayout) this.f218b;
            case 10:
                return (LinearLayout) this.f218b;
            case 11:
                return (TextView) this.f218b;
            case 12:
                return (LinearLayout) this.f218b;
            default:
                return (RelativeLayout) this.f218b;
        }
    }

    @Override // g5.g
    public void h(h5.q qVar) {
        e5.d dVar = (e5.d) this.f218b;
        if (dVar.getContext() != null) {
            float f = UptodownApp.E;
            File fileG = qVar.g();
            fileG.getClass();
            Context contextRequireContext = dVar.requireContext();
            contextRequireContext.getClass();
            k4.c.p(contextRequireContext, fileG, null);
        }
    }

    public k j() throws JSONException {
        JSONObject jSONObject = (JSONObject) this.f218b;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("mobileUiLabels");
        String strOptString = jSONObject2.optString("doneLabel");
        String strOptString2 = jSONObject2.optString("searchLabel");
        String strOptString3 = jSONObject2.optString("cancelLabel");
        String strOptString4 = jSONObject2.optString("consentLabel");
        String strOptString5 = jSONObject2.optString("flexPurposesLabel");
        String strOptString6 = jSONObject2.optString("cookieAccessBodyText");
        String strOptString7 = jSONObject2.optString("showVendorsLabel");
        String strOptString8 = jSONObject2.optString("showIabLabel");
        String strOptString9 = jSONObject2.optString("noneLabel");
        String strOptString10 = jSONObject2.optString("someLabel");
        String strOptString11 = jSONObject2.optString("allLabel");
        String strOptString12 = jSONObject2.optString("closeLabel");
        String strOptString13 = jSONObject2.optString("allVendorsLabel");
        ArrayList arrayListM = l1.b.m("summaryScreenBodyRejectService", jSONObject2);
        ArrayList arrayListM2 = l1.b.m("summaryScreenBodyTextReject", jSONObject2);
        ArrayList arrayListM3 = l1.b.m("summaryScreenBodyTextRejectNew", jSONObject2);
        strOptString.getClass();
        strOptString2.getClass();
        strOptString3.getClass();
        strOptString7.getClass();
        strOptString8.getClass();
        strOptString4.getClass();
        strOptString5.getClass();
        strOptString6.getClass();
        strOptString9.getClass();
        strOptString10.getClass();
        strOptString11.getClass();
        strOptString12.getClass();
        strOptString13.getClass();
        return new k(strOptString, strOptString2, strOptString3, strOptString7, strOptString8, strOptString4, strOptString5, strOptString6, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, arrayListM, arrayListM2, arrayListM3);
    }

    public d9.p k() throws JSONException {
        JSONObject jSONObject = (JSONObject) this.f218b;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumUiLabels");
        String strOptString = jSONObject2.optString("linksTitle");
        strOptString.getClass();
        String strOptString2 = jSONObject2.optString("nonIabVendorsLabel");
        strOptString2.getClass();
        String strOptString3 = jSONObject2.optString("uspDnsTitle");
        strOptString3.getClass();
        ArrayList arrayListM = l1.b.m("uspDnsText", jSONObject2);
        String strOptString4 = jSONObject2.optString("uspDoNotSellToggleText");
        strOptString4.getClass();
        String strOptString5 = jSONObject2.optString("uspPrivacyPolicyLinkText");
        strOptString5.getClass();
        String strOptString6 = jSONObject2.optString("uspDeleteDataLinkText");
        strOptString6.getClass();
        String strOptString7 = jSONObject2.optString("uspAccessDataLinkText");
        strOptString7.getClass();
        String strOptString8 = jSONObject2.optString("uspAcceptButton");
        strOptString8.getClass();
        return new d9.p(strOptString, strOptString2, strOptString3, arrayListM, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, null, 512);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        switch (this.f217a) {
            case 20:
                h1 h1Var = (h1) this.f218b;
                if (!h1Var.requireActivity().isFinishing()) {
                    hVar.f8592u0 = ((h5.h) this.f219c).f8592u0;
                    hVar.f8594v0 = "parentCategoryFeature";
                    long j10 = hVar.f8566a;
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(h1Var);
                    y7.e eVar = i0.f12407a;
                    y.q(lifecycleScope, y7.d.f14116a, null, new g1(h1Var, j10, CampaignEx.JSON_NATIVE_VIDEO_CLICK, (w6.c) null, 0), 2);
                    Intent intent = new Intent(h1Var.requireContext(), (Class<?>) AppDetailActivity.class);
                    intent.putExtra("appInfo", hVar);
                    float f = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity = h1Var.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    h1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                    break;
                }
                break;
            default:
                t1 t1Var = (t1) this.f218b;
                if (!t1Var.requireActivity().isFinishing()) {
                    hVar.f8592u0 = ((h5.h) this.f219c).f8592u0;
                    hVar.f8594v0 = "homeFeature";
                    long j11 = hVar.f8566a;
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(t1Var);
                    y7.e eVar2 = i0.f12407a;
                    y.q(lifecycleScope2, y7.d.f14116a, null, new g1(t1Var, j11, CampaignEx.JSON_NATIVE_VIDEO_CLICK, (w6.c) null, 1), 2);
                    Intent intent2 = new Intent(t1Var.requireContext(), (Class<?>) AppDetailActivity.class);
                    intent2.putExtra("appInfo", hVar);
                    float f10 = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity2 = t1Var.requireActivity();
                    fragmentActivityRequireActivity2.getClass();
                    t1Var.startActivity(intent2, k4.c.a(fragmentActivityRequireActivity2));
                    break;
                }
                break;
        }
    }

    public void m(Throwable th) {
        k4 k4Var = (k4) this.f218b;
        c3 c3Var = (c3) this.f219c;
        c3Var.g();
        c3Var.f1078i = false;
        u1 u1Var = c3Var.f1149a;
        c1.g gVar = u1Var.f1478d;
        w0 w0Var = u1Var.f;
        int i10 = 2;
        if (gVar.q(null, f0.U0)) {
            String message = th.getMessage();
            c3Var.f1083n = false;
            if (message != null) {
                if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                    if (message.contains("Background")) {
                        c3Var.f1083n = true;
                    }
                    i10 = 1;
                } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    i10 = 3;
                }
            }
        }
        int i11 = i10 - 1;
        if (i11 == 0) {
            u1.m(w0Var);
            w0Var.f1540i.d(w0.o(u1Var.r().m()), "registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", w0.o(th.toString()));
            c3Var.f1079j = 1;
            c3Var.E().add(k4Var);
            return;
        }
        if (i11 != 1) {
            u1.m(w0Var);
            w0Var.f.d(w0.o(u1Var.r().m()), "registerTriggerAsync failed. Dropping URI. App ID, Throwable", th);
            q();
            c3Var.f1079j = 1;
            c3Var.F();
            return;
        }
        c3Var.E().add(k4Var);
        if (c3Var.f1079j > ((Integer) f0.f1206x0.a(null)).intValue()) {
            c3Var.f1079j = 1;
            u1.m(w0Var);
            w0Var.f1540i.d(w0.o(u1Var.r().m()), "registerTriggerAsync failed. May try later. App ID, throwable", w0.o(th.toString()));
            return;
        }
        u1.m(w0Var);
        w0Var.f1540i.e("registerTriggerAsync failed. App ID, delay in seconds, throwable", w0.o(u1Var.r().m()), w0.o(String.valueOf(c3Var.f1079j)), w0.o(th.toString()));
        int i12 = c3Var.f1079j;
        if (c3Var.f1080k == null) {
            c3Var.f1080k = new p2(c3Var, u1Var, 1);
        }
        c3Var.f1080k.b(i12 * 1000);
        int i13 = c3Var.f1079j;
        c3Var.f1079j = i13 + i13;
    }

    public void n(boolean z9, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f218b)) {
            map = new HashMap((Map) this.f218b);
        }
        synchronized (((Map) this.f219c)) {
            map2 = new HashMap((Map) this.f219c);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z9 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).c(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z9 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((h1.i) entry2.getKey()).b(new m(status));
            }
        }
    }

    @Override // h1.d
    public void o(p pVar) {
        ((Map) ((f) this.f219c).f219c).remove((h1.i) this.f218b);
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdClicked(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "clicked");
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        mBridgeIds.getClass();
        rewardInfo.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "closed");
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        mBridgeIds.getClass();
        rewardInfo.getClass();
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdShow(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        j0 j0Var = (j0) this.f218b;
        if (j0Var.getContext() != null) {
            new t1.c(j0Var.getContext(), 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "show"), "mintegral_interstitial");
            Context contextRequireContext = j0Var.requireContext();
            contextRequireContext.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                SharedPreferences.Editor editorEdit = contextRequireContext.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit.putLong("mintegral_interstitial_last_shown", jCurrentTimeMillis);
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onEndcardShow(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // g5.g
    public void onError(String str) {
        e5.d dVar = (e5.d) this.f218b;
        if (dVar.getActivity() instanceof w) {
            FragmentActivity activity = dVar.getActivity();
            activity.getClass();
            ((w) activity).N(str);
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
        mBridgeIds.getClass();
        str.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "load_failed");
        if ((str.length() > 10 ? str.substring(0, 10) : str.length() > 0 ? str : null) != null) {
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
        }
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "loaded");
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
        MBNewInterstitialHandler mBNewInterstitialHandler = (MBNewInterstitialHandler) this.f219c;
        if (mBNewInterstitialHandler.isReady()) {
            mBNewInterstitialHandler.show();
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        mBridgeIds.getClass();
        str.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "show_failed");
        if ((str.length() > 10 ? str.substring(0, 10) : str.length() > 0 ? str : null) != null) {
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
        }
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
    }

    @Override // j4.g
    public void onSuccess() {
        j0 j0Var = (j0) this.f218b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        j0.f(j0Var, bVar.J.f6915b, (Context) this.f219c);
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onVideoComplete(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "video_completed");
        new t1.c(((j0) this.f218b).getContext(), 4).e(bundle, "mintegral_interstitial");
    }

    @Override // j4.g
    public void p(Exception exc) {
        exc.getClass();
        exc.printStackTrace();
        j0 j0Var = (j0) this.f218b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        j0.f(j0Var, bVar.J.f6915b, (Context) this.f219c);
    }

    public void q() {
        u1 u1Var = ((c3) this.f219c).f1149a;
        c1.h1 h1Var = u1Var.e;
        u1.k(h1Var);
        SparseArray sparseArrayM = h1Var.m();
        k4 k4Var = (k4) this.f218b;
        sparseArrayM.put(k4Var.f1310c, Long.valueOf(k4Var.f1309b));
        c1.h1 h1Var2 = u1Var.e;
        u1.k(h1Var2);
        int[] iArr = new int[sparseArrayM.size()];
        long[] jArr = new long[sparseArrayM.size()];
        for (int i10 = 0; i10 < sparseArrayM.size(); i10++) {
            iArr[i10] = sparseArrayM.keyAt(i10);
            jArr[i10] = ((Long) sparseArrayM.valueAt(i10)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        h1Var2.f1251n.M(bundle);
    }

    @Override // g5.g
    public void x(String str) {
        str.getClass();
        e5.d dVar = (e5.d) this.f218b;
        if (dVar.getActivity() instanceof w) {
            FragmentActivity fragmentActivityRequireActivity = dVar.requireActivity();
            fragmentActivityRequireActivity.getClass();
            v5.c.e((w) fragmentActivityRequireActivity, str, null);
        }
    }

    @Override // h1.h
    public p y(Object obj) throws Throwable {
        FileWriter fileWriter;
        n nVar = (n) this.f219c;
        JSONObject jSONObject = (JSONObject) ((x1.e) this.f218b).f13578c.f13571a.submit(new androidx.work.impl.utils.d(this, 1)).get();
        FileWriter fileWriter2 = null;
        if (jSONObject != null) {
            e2.d dVarA = ((y2.c) nVar.f7241c).A(jSONObject);
            y2.c cVar = (y2.c) nVar.e;
            long j10 = dVarA.f7633c;
            cVar.getClass();
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Writing settings to cache file...", null);
            }
            try {
                jSONObject.put("expires_at", j10);
                fileWriter = new FileWriter((File) cVar.f13781b);
                try {
                    try {
                        fileWriter.write(jSONObject.toString());
                        fileWriter.flush();
                    } catch (Throwable th) {
                        th = th;
                        fileWriter2 = fileWriter;
                        w1.g.b(fileWriter2, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                    w1.g.b(fileWriter, "Failed to close settings writer.");
                    n.m("Loaded settings: ", jSONObject);
                    String str = ((e2.e) nVar.f7243i).f;
                    SharedPreferences.Editor editorEdit = ((Context) nVar.f7240b).getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
                    editorEdit.putString("existing_instance_identifier", str);
                    editorEdit.apply();
                    ((AtomicReference) nVar.h).set(dVarA);
                    ((h1.i) ((AtomicReference) nVar.f7244j).get()).c(dVarA);
                    return r0.f.x(null);
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                w1.g.b(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
            w1.g.b(fileWriter, "Failed to close settings writer.");
            n.m("Loaded settings: ", jSONObject);
            String str2 = ((e2.e) nVar.f7243i).f;
            SharedPreferences.Editor editorEdit2 = ((Context) nVar.f7240b).getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
            editorEdit2.putString("existing_instance_identifier", str2);
            editorEdit2.apply();
            ((AtomicReference) nVar.h).set(dVarA);
            ((h1.i) ((AtomicReference) nVar.f7244j).get()).c(dVarA);
        }
        return r0.f.x(null);
    }

    public /* synthetic */ f(int i10, Object obj, Object obj2) {
        this.f217a = i10;
        this.f218b = obj2;
        this.f219c = obj;
    }

    public /* synthetic */ f(Object obj, int i10) {
        this.f217a = i10;
        this.f219c = obj;
    }

    public /* synthetic */ f(Object obj, Object obj2, int i10, boolean z9) {
        this.f217a = i10;
        this.f218b = obj;
        this.f219c = obj2;
    }

    public f() {
        this.f217a = 28;
        this.f218b = DesugarCollections.synchronizedMap(new WeakHashMap());
        this.f219c = DesugarCollections.synchronizedMap(new WeakHashMap());
    }

    public /* synthetic */ f(int i10) {
        this.f217a = i10;
    }

    public f(d0 d0Var) {
        this.f217a = 26;
        d0Var.getClass();
        this.f219c = d0Var;
    }

    public f(ChoiceColor choiceColor, ChoiceColor choiceColor2, d0 d0Var) {
        this.f217a = 23;
        this.f218b = choiceColor;
        this.f219c = choiceColor2;
    }

    public f(String str, l5 l5Var, d0 d0Var) {
        this.f217a = 25;
        this.f219c = str;
        this.f218b = l5Var;
    }

    public f(ArrayList arrayList, Context context) {
        this.f217a = 7;
        context.getClass();
        this.f218b = arrayList;
        this.f219c = context;
    }

    public f(f2.a[] aVarArr) {
        this.f217a = 22;
        this.f218b = aVarArr;
        this.f219c = new d0(7);
    }

    public f(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.f217a = 10;
        this.f218b = linearLayout;
        this.f219c = editText;
    }
}
