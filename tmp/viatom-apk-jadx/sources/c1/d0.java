package c1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.android.gms.internal.measurement.e8;
import com.google.android.gms.internal.measurement.m8;
import com.google.android.gms.internal.measurement.u8;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d0 implements w, f2.a, c.b, n2.a, q1.d, r.b, r0.c, g5.f {
    public static volatile d0 e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1103a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d0 f1100b = new d0(0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d0 f1101c = new d0(1);

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d0 f1102d = new d0(2);
    public static final /* synthetic */ d0 f = new d0(22);
    public static final /* synthetic */ d0 g = new d0(23);

    public d0(TvAppDetailFragment tvAppDetailFragment) {
        this.f1103a = 29;
    }

    public static d9.g l(String str) {
        str.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("coreUiLabels");
            String strOptString = jSONObject.optString("initScreenTitle");
            strOptString.getClass();
            String strOptString2 = jSONObject.optString("agreeButton");
            strOptString2.getClass();
            String strOptString3 = jSONObject.optString("agreeAllButton");
            strOptString3.getClass();
            String strOptString4 = jSONObject.optString("initScreenRejectButton");
            strOptString4.getClass();
            String strOptString5 = jSONObject.optString("initScreenSettingsButton");
            strOptString5.getClass();
            ArrayList arrayListM = l1.b.m("summaryScreenBodyNoRejectService", jSONObject);
            ArrayList arrayListM2 = l1.b.m("summaryScreenBodyNoRejectGlobal", jSONObject);
            ArrayList arrayListM3 = l1.b.m("summaryScreenBodyNoRejectGroup", jSONObject);
            ArrayList arrayListM4 = l1.b.m("summaryScreenBodyRejectService", jSONObject);
            ArrayList arrayListM5 = l1.b.m("summaryScreenBodyRejectGlobal", jSONObject);
            ArrayList arrayListM6 = l1.b.m("summaryScreenBodyRejectGroup", jSONObject);
            String strOptString6 = jSONObject.optString("initScreenBodyGlobal");
            strOptString6.getClass();
            String strOptString7 = jSONObject.optString("initScreenBodyService");
            strOptString7.getClass();
            String strOptString8 = jSONObject.optString("initScreenBodyGroup");
            strOptString8.getClass();
            String strOptString9 = jSONObject.optString("specialPurposesAndFeatures");
            strOptString9.getClass();
            String strOptString10 = jSONObject.optString("saveAndExitButton");
            strOptString10.getClass();
            String strOptString11 = jSONObject.optString("purposeScreenVendorLink");
            strOptString11.getClass();
            String strOptString12 = jSONObject.optString("legitimateInterestLink");
            strOptString12.getClass();
            String strOptString13 = jSONObject.optString("specialPurposesLabel");
            strOptString13.getClass();
            String strOptString14 = jSONObject.optString("specialFeaturesLabel");
            strOptString14.getClass();
            String strOptString15 = jSONObject.optString("featuresLabel");
            strOptString15.getClass();
            String strOptString16 = jSONObject.optString("dataDeclarationLabel");
            strOptString16.getClass();
            String strOptString17 = jSONObject.optString("back");
            strOptString17.getClass();
            String strOptString18 = jSONObject.optString("onLabel");
            strOptString18.getClass();
            String strOptString19 = jSONObject.optString("offLabel");
            strOptString19.getClass();
            String strOptString20 = jSONObject.optString("multiLabel");
            strOptString20.getClass();
            String strOptString21 = jSONObject.optString("legalDescription");
            strOptString21.getClass();
            String strOptString22 = jSONObject.optString("showPartners");
            strOptString22.getClass();
            String strOptString23 = jSONObject.optString("hidePartners");
            strOptString23.getClass();
            String strOptString24 = jSONObject.optString("vendorScreenBody");
            strOptString24.getClass();
            String strOptString25 = jSONObject.optString("privacyPolicyLabel");
            strOptString25.getClass();
            String strOptString26 = jSONObject.optString("descriptionLabel");
            strOptString26.getClass();
            String strOptString27 = jSONObject.optString("legitimateScreenBody");
            strOptString27.getClass();
            String strOptString28 = jSONObject.optString("legitimateInterestPurposesLabel");
            strOptString28.getClass();
            String strOptString29 = jSONObject.optString("legitimateInterestVendorLabel");
            strOptString29.getClass();
            String strOptString30 = jSONObject.optString("legitimateScreenObject");
            strOptString30.getClass();
            String strOptString31 = jSONObject.optString("legitimateScreenObjected");
            strOptString31.getClass();
            String strOptString32 = jSONObject.optString("legitimateScreenAccept");
            strOptString32.getClass();
            String strOptString33 = jSONObject.optString("objectAllButton");
            strOptString33.getClass();
            String strOptString34 = jSONObject.optString("persistentConsentLinkLabel");
            strOptString34.getClass();
            String strOptString35 = jSONObject.optString("nonIabVendorsNotice");
            strOptString35.getClass();
            String strOptString36 = jSONObject.optString("googlePartners");
            strOptString36.getClass();
            String strOptString37 = jSONObject.optString("purposesLabel");
            strOptString37.getClass();
            String strOptString38 = jSONObject.optString("cookieMaxAgeLabel");
            strOptString38.getClass();
            String strOptString39 = jSONObject.optString("daysLabel");
            strOptString39.getClass();
            String strOptString40 = jSONObject.optString("secondsLabel");
            strOptString40.getClass();
            String strOptString41 = jSONObject.optString("cookieAccessLabel");
            strOptString41.getClass();
            String strOptString42 = jSONObject.optString("yesLabel");
            strOptString42.getClass();
            String strOptString43 = jSONObject.optString("noLabel");
            strOptString43.getClass();
            String strOptString44 = jSONObject.optString("storageDisclosureLabel");
            strOptString44.getClass();
            String strOptString45 = jSONObject.optString("dataRetentionDays");
            strOptString45.getClass();
            return new d9.g(strOptString, strOptString2, strOptString3, strOptString4, strOptString5, arrayListM, arrayListM2, arrayListM3, arrayListM4, arrayListM5, arrayListM6, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, strOptString15, strOptString16, strOptString17, strOptString18, strOptString19, strOptString20, strOptString21, strOptString22, strOptString23, strOptString24, strOptString25, strOptString26, strOptString27, strOptString28, strOptString29, strOptString30, strOptString31, strOptString32, strOptString33, strOptString34, strOptString35, strOptString36, strOptString37, strOptString38, strOptString39, strOptString40, strOptString41, strOptString42, strOptString43, strOptString44, strOptString45);
        } catch (JSONException unused) {
            return new d9.g();
        }
    }

    public static e2.d n(t3.h hVar) {
        return new e2.d(System.currentTimeMillis() + 3600000, new e2.c(8), new e2.b(true, false, false), 10.0d, 1.2d, 60);
    }

    public static h5.m0 o(JSONObject jSONObject) {
        h5.m0 m0Var = new h5.m0();
        if (!jSONObject.isNull("id")) {
            m0Var.f8657a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("userName")) {
            m0Var.f8658b = jSONObject.optString("userName");
            if (!jSONObject.isNull("userAvatar")) {
                m0Var.f8660d = jSONObject.optString("userAvatar");
            }
            if (!jSONObject.isNull("userID")) {
                m0Var.f8659c = jSONObject.optString("userID");
            }
        }
        if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
            m0Var.f = jSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        }
        if (!jSONObject.isNull("timeAgo")) {
            m0Var.g = jSONObject.optString("timeAgo");
        }
        if (!jSONObject.isNull("likes")) {
            m0Var.h = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            m0Var.f8661i = jSONObject.optInt("isAuthorVerified");
        }
        if (!jSONObject.isNull("isTurbo")) {
            m0Var.f8662j = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            m0Var.f8663k = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("following")) {
            m0Var.f8664l = jSONObject.optInt("following");
        }
        return m0Var;
    }

    public static h5.t0 p(JSONObject jSONObject) {
        h5.t0 t0Var = new h5.t0();
        if (!jSONObject.isNull("id")) {
            t0Var.f8739a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("userID")) {
            t0Var.f8740b = jSONObject.optString("userID");
            if (!jSONObject.isNull("userName")) {
                t0Var.f8741c = jSONObject.optString("userName");
            }
            if (!jSONObject.isNull("userAvatar")) {
                t0Var.f8742d = jSONObject.optString("userAvatar");
            }
        }
        if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
            t0Var.f = jSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        }
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
            t0Var.g = jSONObject.optInt(CampaignEx.JSON_KEY_STAR);
        }
        if (!jSONObject.isNull("totalAnswers")) {
            t0Var.h = jSONObject.optInt("totalAnswers");
        }
        if (!jSONObject.isNull("timeAgo")) {
            t0Var.f8743i = jSONObject.optString("timeAgo");
        }
        if (!jSONObject.isNull("likes")) {
            t0Var.f8744j = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            t0Var.f8745k = jSONObject.optInt("isAuthorVerified");
        }
        if (!jSONObject.isNull("isTurbo")) {
            t0Var.f8747m = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            t0Var.f8748n = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("following")) {
            t0Var.f8749o = jSONObject.optInt("following");
        }
        return t0Var;
    }

    public static boolean q(Context context, String str) {
        String strA = z1.t1.A(context, "last_review_text");
        String strA2 = z1.t1.A(context, "last_review_timestamp");
        if (strA2 == null) {
            strA2 = "0";
        }
        return str != null && str.equalsIgnoreCase(strA) && System.currentTimeMillis() - Long.parseLong(strA2) < RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS;
    }

    public static void u(Context context, String str, String str2) {
        if (context != null) {
            if (str != null && str.length() != 0) {
                try {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putString("last_review_text", str);
                    editorEdit.apply();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (str2 == null || str2.length() == 0) {
                return;
            }
            try {
                SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit2.putString("last_review_timestamp", str2);
                editorEdit2.apply();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public static h5.t0 w(JSONObject jSONObject) {
        h5.t0 t0Var = new h5.t0();
        if (!jSONObject.isNull("id")) {
            t0Var.f8739a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("appName")) {
            t0Var.f8746l = jSONObject.optString("appName");
        }
        if (!jSONObject.isNull("appID")) {
            t0Var.e = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull("appIcon")) {
            t0Var.f8742d = jSONObject.optString("appIcon");
        }
        if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
            t0Var.f = jSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        }
        if (!jSONObject.isNull("rate")) {
            t0Var.g = jSONObject.optInt("rate");
        }
        if (!jSONObject.isNull("publishedDate")) {
            t0Var.f8743i = jSONObject.optString("publishedDate");
        }
        if (!jSONObject.isNull("likes")) {
            t0Var.f8744j = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isTurbo")) {
            t0Var.f8747m = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            t0Var.f8748n = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("totalAnswers")) {
            t0Var.h = jSONObject.optInt("totalAnswers");
        }
        return t0Var;
    }

    @Override // c1.w
    public Object a() {
        switch (this.f1103a) {
            case 0:
                return new Boolean(((Boolean) e8.f1943a.b()).booleanValue());
            case 1:
                return new Boolean(((Boolean) m8.f2090a.b()).booleanValue());
            default:
                return new Boolean(((Boolean) u8.f2196a.b()).booleanValue());
        }
    }

    @Override // q1.d
    public /* synthetic */ Object c(a3.z0 z0Var) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(z0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // f2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.StackTraceElement[] e(java.lang.StackTraceElement[] r15) {
        /*
            r14 = this;
            int r0 = r14.f1103a
            switch(r0) {
                case 7: goto L70;
                default: goto L5;
            }
        L5:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r15.length
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r1]
            r2 = 0
            r3 = 1
            r4 = r2
            r5 = r4
            r6 = r3
        L12:
            int r7 = r15.length
            if (r4 >= r7) goto L66
            r7 = r15[r4]
            java.lang.Object r8 = r0.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L54
            int r9 = r8.intValue()
            int r10 = r4 - r9
            int r11 = r4 + r10
            int r12 = r15.length
            if (r11 <= r12) goto L2b
            goto L54
        L2b:
            r11 = r2
        L2c:
            if (r11 >= r10) goto L40
            int r12 = r9 + r11
            r12 = r15[r12]
            int r13 = r4 + r11
            r13 = r15[r13]
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L3d
            goto L54
        L3d:
            int r11 = r11 + 1
            goto L2c
        L40:
            int r8 = r8.intValue()
            int r8 = r4 - r8
            r9 = 10
            if (r6 >= r9) goto L50
            java.lang.System.arraycopy(r15, r4, r1, r5, r8)
            int r5 = r5 + r8
            int r6 = r6 + 1
        L50:
            int r8 = r8 + (-1)
            int r8 = r8 + r4
            goto L5c
        L54:
            r6 = r15[r4]
            r1[r5] = r6
            int r5 = r5 + 1
            r6 = r3
            r8 = r4
        L5c:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.put(r7, r4)
            int r4 = r8 + 1
            goto L12
        L66:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r5]
            java.lang.System.arraycopy(r1, r2, r0, r2, r5)
            int r1 = r15.length
            if (r5 >= r1) goto L6f
            r15 = r0
        L6f:
            return r15
        L70:
            int r0 = r15.length
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 > r1) goto L76
            goto L84
        L76:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r1]
            r1 = 0
            r2 = 512(0x200, float:7.17E-43)
            java.lang.System.arraycopy(r15, r1, r0, r1, r2)
            int r1 = r15.length
            int r1 = r1 - r2
            java.lang.System.arraycopy(r15, r1, r0, r2, r2)
            r15 = r0
        L84:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.e(java.lang.StackTraceElement[]):java.lang.StackTraceElement[]");
    }

    @Override // r0.c
    public int f(Context context, String str, boolean z9) {
        return r0.e.d(context, str, z9);
    }

    @Override // p6.a
    public Object get() {
        return new q2(Executors.newSingleThreadExecutor(), 2);
    }

    @Override // r0.c
    public int i(Context context, String str) {
        return r0.e.a(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r6, java.lang.String r7, y6.c r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof e9.d
            if (r0 == 0) goto L13
            r0 = r8
            e9.d r0 = (e9.d) r0
            int r1 = r0.f7987c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7987c = r1
            goto L18
        L13:
            e9.d r0 = new e9.d
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f7985a
            int r1 = r0.f7987c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            s6.a.e(r8)     // Catch: java.lang.Exception -> L26
            goto L47
        L26:
            r6 = move-exception
            goto L4a
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r2
        L2e:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a     // Catch: java.lang.Exception -> L26
            y7.d r8 = y7.d.f14116a     // Catch: java.lang.Exception -> L26
            a6.j r1 = new a6.j     // Catch: java.lang.Exception -> L26
            r4 = 16
            r1.<init>(r6, r7, r2, r4)     // Catch: java.lang.Exception -> L26
            r0.f7987c = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = r7.y.z(r1, r8, r0)     // Catch: java.lang.Exception -> L26
            x6.a r7 = x6.a.f13718a
            if (r6 != r7) goto L47
            return r7
        L47:
            s6.w r6 = s6.w.f12711a
            return r6
        L4a:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L4f
            goto L62
        L4f:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L54
            goto L62
        L54:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L59
            goto L62
        L59:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L5e
            goto L62
        L5e:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L65
        L62:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L6e
        L65:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L6c
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L6e
        L6c:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L6e:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L77
            goto L7a
        L77:
            r7.onCmpError(r6)
        L7a:
            d6.a r7 = new d6.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.j(java.lang.String, java.lang.String, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r6, y6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof e9.a
            if (r0 == 0) goto L13
            r0 = r7
            e9.a r0 = (e9.a) r0
            int r1 = r0.f7979c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7979c = r1
            goto L18
        L13:
            e9.a r0 = new e9.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f7977a
            int r1 = r0.f7979c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            s6.a.e(r7)     // Catch: java.lang.Exception -> L26
            goto L51
        L26:
            r6 = move-exception
            goto L54
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r2
        L2e:
            s6.a.e(r7)
            java.lang.String r7 = "Calling api"
            r6.getClass()     // Catch: java.lang.Exception -> L26
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L26
            r4 = 3
            d6.b.a(r4, r7, r6, r2, r1)     // Catch: java.lang.Exception -> L26
            y7.e r7 = r7.i0.f12407a     // Catch: java.lang.Exception -> L26
            y7.d r7 = y7.d.f14116a     // Catch: java.lang.Exception -> L26
            e9.b r1 = new e9.b     // Catch: java.lang.Exception -> L26
            r4 = 0
            r1.<init>(r6, r2, r4)     // Catch: java.lang.Exception -> L26
            r0.f7979c = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r7 = r7.y.z(r1, r7, r0)     // Catch: java.lang.Exception -> L26
            x6.a r6 = x6.a.f13718a
            if (r7 != r6) goto L51
            return r6
        L51:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L26
            return r7
        L54:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L59
            goto L6c
        L59:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L5e
            goto L6c
        L5e:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L63
            goto L6c
        L63:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L68
            goto L6c
        L68:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L6f
        L6c:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L78
        L6f:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L76
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L78
        L76:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L78:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L81
            goto L84
        L81:
            r7.onCmpError(r6)
        L84:
            d6.a r7 = new d6.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.k(java.lang.String, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(java.lang.String r5, y6.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof e9.c
            if (r0 == 0) goto L13
            r0 = r6
            e9.c r0 = (e9.c) r0
            int r1 = r0.f7984c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7984c = r1
            goto L18
        L13:
            e9.c r0 = new e9.c
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f7982a
            int r1 = r0.f7984c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            s6.a.e(r6)     // Catch: java.lang.Exception -> L26
            goto L45
        L26:
            r5 = move-exception
            goto L4b
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            return r2
        L2e:
            s6.a.e(r6)
            y7.e r6 = r7.i0.f12407a     // Catch: java.lang.Exception -> L26
            y7.d r6 = y7.d.f14116a     // Catch: java.lang.Exception -> L26
            e9.b r1 = new e9.b     // Catch: java.lang.Exception -> L26
            r1.<init>(r5, r2, r3)     // Catch: java.lang.Exception -> L26
            r0.f7984c = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = r7.y.z(r1, r6, r0)     // Catch: java.lang.Exception -> L26
            x6.a r5 = x6.a.f13718a
            if (r6 != r5) goto L45
            return r5
        L45:
            r6.getClass()     // Catch: java.lang.Exception -> L26
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6     // Catch: java.lang.Exception -> L26
            return r6
        L4b:
            boolean r6 = r5 instanceof java.security.cert.CertificateException
            if (r6 == 0) goto L50
            goto L63
        L50:
            boolean r6 = r5 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L55
            goto L63
        L55:
            boolean r6 = r5 instanceof java.net.SocketException
            if (r6 == 0) goto L5a
            goto L63
        L5a:
            boolean r6 = r5 instanceof java.net.MalformedURLException
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            boolean r6 = r5 instanceof java.lang.NullPointerException
            if (r6 == 0) goto L66
        L63:
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.FAILED_LOGO_DOWNLOAD
            goto L6f
        L66:
            boolean r5 = r5 instanceof java.io.FileNotFoundException
            if (r5 == 0) goto L6d
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L6f
        L6d:
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L6f:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()
            if (r6 != 0) goto L78
            goto L7b
        L78:
            r6.onCmpError(r5)
        L7b:
            d6.a r6 = new d6.a
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.m(java.lang.String, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(h5.m0 r11, android.content.Context r12, y6.c r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof h5.k0
            if (r0 == 0) goto L13
            r0 = r13
            h5.k0 r0 = (h5.k0) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            h5.k0 r0 = new h5.k0
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8639d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f8638c
            kotlin.jvm.internal.v r12 = r0.f8637b
            h5.m0 r0 = r0.f8636a
            s6.a.e(r13)
            r6 = r11
            r11 = r0
            goto L6c
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r11)
            r11 = 0
            return r11
        L34:
            s6.a.e(r13)
            long r3 = r11.f8657a
            java.util.ArrayList r13 = v5.n.e
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r13.add(r1)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            y7.e r13 = r7.i0.f12407a
            y7.d r13 = y7.d.f14116a
            c5.c r3 = new c5.c
            r8 = 0
            r9 = 5
            r5 = r11
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f8636a = r5
            r0.f8637b = r7
            r0.f8638c = r6
            r0.f = r2
            java.lang.Object r11 = r7.y.z(r3, r13, r0)
            x6.a r12 = x6.a.f13718a
            if (r11 != r12) goto L6a
            return r12
        L6a:
            r11 = r5
            r12 = r7
        L6c:
            h5.l0 r13 = new h5.l0
            int r12 = r12.f10136a
            int r0 = r6.f10136a
            r13.<init>(r11, r12, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.r(h5.m0, android.content.Context, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(h5.t0 r11, android.content.Context r12, y6.c r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof h5.r0
            if (r0 == 0) goto L13
            r0 = r13
            h5.r0 r0 = (h5.r0) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            h5.r0 r0 = new h5.r0
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8729d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f8728c
            kotlin.jvm.internal.v r12 = r0.f8727b
            h5.t0 r0 = r0.f8726a
            s6.a.e(r13)
            r6 = r11
            r11 = r0
            goto L6c
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r11)
            r11 = 0
            return r11
        L34:
            s6.a.e(r13)
            long r3 = r11.f8739a
            java.util.ArrayList r13 = v5.n.f13172d
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r13.add(r1)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            y7.e r13 = r7.i0.f12407a
            y7.d r13 = y7.d.f14116a
            c5.c r3 = new c5.c
            r8 = 0
            r9 = 6
            r5 = r11
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f8726a = r5
            r0.f8727b = r7
            r0.f8728c = r6
            r0.f = r2
            java.lang.Object r11 = r7.y.z(r3, r13, r0)
            x6.a r12 = x6.a.f13718a
            if (r11 != r12) goto L6a
            return r12
        L6a:
            r11 = r5
            r12 = r7
        L6c:
            h5.s0 r13 = new h5.s0
            int r12 = r12.f10136a
            int r0 = r6.f10136a
            r13.<init>(r11, r12, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.s(h5.t0, android.content.Context, y6.c):java.lang.Object");
    }

    public List t(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (q1.a aVar : componentRegistrar.getComponents()) {
            String str = aVar.f12219a;
            if (str != null) {
                aVar = new q1.a(str, aVar.f12220b, aVar.f12221c, aVar.f12222d, aVar.e, new androidx.privacysandbox.ads.adservices.java.internal.a(2, str, aVar), aVar.g);
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[PHI: r6
      0x004b: PHI (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:18:0x0044, B:20:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r0.d v(android.content.Context r5, java.lang.String r6, r0.c r7) {
        /*
            r4 = this;
            int r0 = r4.f1103a
            switch(r0) {
                case 26: goto L51;
                case 27: goto L30;
                default: goto L5;
            }
        L5:
            r0.d r0 = new r0.d
            r0.<init>()
            int r1 = r7.i(r5, r6)
            r0.f12296a = r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            int r5 = r7.f(r5, r6, r3)
            r0.f12297b = r5
            goto L21
        L1b:
            int r5 = r7.f(r5, r6, r2)
            r0.f12297b = r5
        L21:
            int r6 = r0.f12296a
            if (r6 != 0) goto L29
            if (r5 != 0) goto L2a
            r2 = r3
            goto L2d
        L29:
            r3 = r6
        L2a:
            if (r3 < r5) goto L2d
            r2 = -1
        L2d:
            r0.f12298c = r2
            return r0
        L30:
            r0.d r0 = new r0.d
            r0.<init>()
            int r1 = r7.i(r5, r6)
            r0.f12296a = r1
            r1 = 1
            int r5 = r7.f(r5, r6, r1)
            r0.f12297b = r5
            int r6 = r0.f12296a
            if (r6 != 0) goto L4b
            r6 = 0
            if (r5 != 0) goto L4b
            r1 = r6
            goto L4e
        L4b:
            if (r6 < r5) goto L4e
            r1 = -1
        L4e:
            r0.f12298c = r1
            return r0
        L51:
            r0.d r0 = new r0.d
            r0.<init>()
            int r1 = r7.i(r5, r6)
            r0.f12296a = r1
            if (r1 == 0) goto L62
            r5 = -1
            r0.f12298c = r5
            goto L6d
        L62:
            r1 = 1
            int r5 = r7.f(r5, r6, r1)
            r0.f12297b = r5
            if (r5 == 0) goto L6d
            r0.f12298c = r1
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d0.v(android.content.Context, java.lang.String, r0.c):r0.d");
    }

    public /* synthetic */ d0(int i10) {
        this.f1103a = i10;
    }

    @Override // g5.f
    public void b(long j10) {
    }

    @Override // g5.f
    public void d(h5.k kVar) {
    }

    @Override // c.b
    public void g(c.h hVar) {
    }

    @Override // c.b
    public void h(c.h hVar) {
    }
}
