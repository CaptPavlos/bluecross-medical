package c1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w4 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1555a;

    public w4(Context context, int i10, boolean z9) {
        switch (i10) {
            case 3:
                context.getClass();
                this.f1555a = context;
                break;
            case 4:
                context.getClass();
                this.f1555a = context;
                break;
            case 5:
                context.getClass();
                this.f1555a = context;
                break;
            default:
                i0.y.g(context);
                Context applicationContext = context.getApplicationContext();
                i0.y.g(applicationContext);
                this.f1555a = applicationContext;
                break;
        }
    }

    public static ArrayList I(h5.p0 p0Var) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        if (!p0Var.b() && (jSONObject = p0Var.f8699d) != null) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            JSONObject jSONObject2 = p0Var.f8699d;
            jSONObject2.getClass();
            if (jSONObject2.optInt("success") == 1 && jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    jSONObjectOptJSONObject.getClass();
                    h5.h hVar = new h5.h();
                    hVar.a(null, jSONObjectOptJSONObject);
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public static String p(HashMap map) {
        StringBuilder sb = new StringBuilder();
        boolean z9 = true;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z9) {
                z9 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, C.UTF8_NAME));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, C.UTF8_NAME));
        }
        return sb.toString();
    }

    public h5.p0 A(int i10, int i11, String str) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i10));
        map.put("page[offset]", String.valueOf(i11));
        h5.p0 p0VarM = m(androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.uptodown.app:443/eapi/user/", str, "/comments"), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/user/userID/comments");
        return p0VarM;
    }

    public h5.p0 B(long j10) {
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/apps/" + j10 + "/video", ShareTarget.METHOD_GET, null);
        p0VarM.f8699d = k(p0VarM, "/eapi/apps/appId/video");
        return p0VarM;
    }

    public h5.p0 C(String str) {
        str.getClass();
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/v2/virus-total/" + str + "/report", ShareTarget.METHOD_GET, null);
        p0VarM.f8699d = k(p0VarM, "/eapi/v2/virus-total/fileId/report");
        return p0VarM;
    }

    public boolean D() {
        return g("storage_sdcard", false);
    }

    public void E(View view, float f) {
        SharedPreferences sharedPreferences;
        view.getClass();
        if (f == 1.0f) {
            view.setClickable(true);
        } else if (f == 0.3f) {
            view.setClickable(false);
        }
        Context context = this.f1555a;
        context.getClass();
        float f10 = UptodownApp.E;
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("animations") ? sharedPreferences.getBoolean("animations", true) : true;
        if (!z9) {
            view.setAlpha(f);
            return;
        }
        float f11 = UptodownApp.E;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(view.getAlpha(), f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.motion.c(view, 4));
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.start();
    }

    public void F(ImageView imageView) throws Resources.NotFoundException {
        imageView.getClass();
        Context context = this.f1555a;
        context.getClass();
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            float f10 = UptodownApp.E;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_heart_red));
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.like_bounce);
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.like_bounce_back);
            x5.d dVar = new x5.d();
            animationLoadAnimation.setInterpolator(dVar);
            animationLoadAnimation2.setInterpolator(dVar);
            animationLoadAnimation.setAnimationListener(new z5.i(imageView, animationLoadAnimation2));
            imageView.startAnimation(animationLoadAnimation);
        }
    }

    public void G(String str, String str2, long j10) {
        str2.getClass();
        HashMap map = new HashMap();
        map.put("appID", String.valueOf(j10));
        map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        map.put(TypedValues.TransitionType.S_FROM, str2);
        map.putAll(i());
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/promo-track"), ShareTarget.METHOD_POST, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/promo-track");
    }

    public h5.p0 H(String str, String str2) {
        HashMap map = new HashMap();
        map.put(NotificationCompat.CATEGORY_EMAIL, str);
        byte[] bytes = str2.getBytes(o7.a.f11749a);
        bytes.getClass();
        String strB = l5.B(bytes);
        strB.getClass();
        map.put("password", strB);
        Context context = this.f1555a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str3 = e1VarH.f8512a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (string != null) {
            map.put("deviceIdentifier", string);
        }
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/v2/user/login"), ShareTarget.METHOD_POST, map);
        if (p0VarM.b()) {
            p0VarM.f8699d = l(p0VarM, "/eapi/v2/user/login");
            return p0VarM;
        }
        p0VarM.f8699d = k(p0VarM, "/eapi/v2/user/login");
        return p0VarM;
    }

    public h5.p0 J(long j10, h5.t0 t0Var) {
        String str;
        Context context = this.f1555a;
        HashMap map = new HashMap();
        String str2 = t0Var.f;
        if (str2 != null && str2.length() > 0) {
            String str3 = t0Var.f;
            str3.getClass();
            map.put(MimeTypes.BASE_TYPE_TEXT, str3);
        }
        map.put(CampaignEx.JSON_KEY_STAR, String.valueOf(t0Var.g));
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String packageName = context.getPackageName();
            packageName.getClass();
            str = " " + l5.a.f(packageManager, packageName, 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        map.put("uagent", "uptodownandroid".concat(str));
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str4 = e1VarH.f8512a;
            str4.getClass();
            map.put("id_user", str4);
        }
        h5.p0 p0VarM = m(r1.i.d("https://www.uptodown.app:443/eapi/apps/", "/comments", j10), ShareTarget.METHOD_POST, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/apps/appId/comments/post");
        return p0VarM;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h5.p0 K(java.lang.String r18, java.util.ArrayList r19, boolean r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.w4.K(java.lang.String, java.util.ArrayList, boolean):h5.p0");
    }

    public h5.p0 L(int i10, int i11, String str) throws UnsupportedEncodingException {
        String strReplaceAll;
        UnsupportedEncodingException e;
        String strEncode;
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i10));
        map.put("page[offset]", String.valueOf(i11));
        try {
            Pattern patternCompile = Pattern.compile("\\n");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str).replaceAll(" ");
            strReplaceAll.getClass();
            try {
                int length = strReplaceAll.length() - 1;
                int i12 = 0;
                boolean z9 = false;
                while (i12 <= length) {
                    boolean z10 = kotlin.jvm.internal.l.c(strReplaceAll.charAt(!z9 ? i12 : length), 32) <= 0;
                    if (z9) {
                        if (!z10) {
                            break;
                        }
                        length--;
                    } else if (z10) {
                        i12++;
                    } else {
                        z9 = true;
                    }
                }
                strEncode = URLEncoder.encode(strReplaceAll.subSequence(i12, length + 1).toString(), C.UTF8_NAME);
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                e.printStackTrace();
                strEncode = strReplaceAll;
                h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/v2/apps/search/" + strEncode, ShareTarget.METHOD_GET, map);
                p0VarM.f8699d = k(p0VarM, "/eapi/v2/apps/search");
                return p0VarM;
            }
        } catch (UnsupportedEncodingException e7) {
            strReplaceAll = null;
            e = e7;
        }
        h5.p0 p0VarM2 = m("https://www.uptodown.app:443/eapi/v2/apps/search/" + strEncode, ShareTarget.METHOD_GET, map);
        p0VarM2.f8699d = k(p0VarM2, "/eapi/v2/apps/search");
        return p0VarM2;
    }

    public h5.p0 M(String str) {
        str.getClass();
        HashMap map = new HashMap();
        map.put("fcmToken", str);
        Context context = this.f1555a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str2 = e1VarH.f8512a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (string != null) {
            map.put("identifier", string);
        }
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/v3/device/fcm-token"), ShareTarget.METHOD_POST, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/v3/device/fcm-token");
        return p0VarM;
    }

    public void N(String str, boolean z9) {
        try {
            SharedPreferences.Editor editorEdit = this.f1555a.getSharedPreferences("CoreSettings", 0).edit();
            editorEdit.putBoolean(str, z9);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O() {
        N("sdcard_as_backup_storage", false);
    }

    public void P() {
        N("storage_sdcard", false);
    }

    public void Q(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.f1555a.getSharedPreferences("CoreSettings", 0).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void R(boolean z9) {
        N("user_asked_for_show_permissions", z9);
    }

    public h5.p0 S(String str) {
        str.getClass();
        HashMap map = new HashMap();
        map.put("provider", "google");
        map.put("accessToken", str);
        Context context = this.f1555a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str2 = e1VarH.f8512a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (string != null) {
            map.put("deviceIdentifier", string);
        }
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/user/usertokenSignup"), ShareTarget.METHOD_POST, map);
        if (p0VarM.b()) {
            p0VarM.f8699d = l(p0VarM, "/eapi/user/usertokenSignup");
            return p0VarM;
        }
        p0VarM.f8699d = k(p0VarM, "/eapi/user/usertokenSignup");
        return p0VarM;
    }

    public h5.p0 a(long j10) {
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/app/" + j10 + "/pre-register/add", ShareTarget.METHOD_POST, i());
        p0VarM.f8699d = k(p0VarM, "/eapi/app/appID/pre-register/add");
        return p0VarM;
    }

    public h5.p0 b(long j10) {
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/app/" + j10 + "/pre-register/cancel", ShareTarget.METHOD_POST, i());
        p0VarM.f8699d = k(p0VarM, "/eapi/app/appID/pre-register/cancel");
        return p0VarM;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(h5.p0 r10) {
        /*
            r9 = this;
            java.lang.String r0 = "seconds"
            boolean r1 = r10.b()
            r2 = 0
            if (r1 == 0) goto L6a
            int r1 = r10.f8697b
            r3 = 503(0x1f7, float:7.05E-43)
            if (r1 != r3) goto L69
            java.lang.String r1 = r10.f8696a
            if (r1 == 0) goto L33
            int r1 = r1.length()
            if (r1 != 0) goto L1a
            goto L33
        L1a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L2f
            java.lang.String r10 = r10.f8696a     // Catch: java.lang.Exception -> L2f
            r10.getClass()     // Catch: java.lang.Exception -> L2f
            r1.<init>(r10)     // Catch: java.lang.Exception -> L2f
            boolean r10 = r1.isNull(r0)     // Catch: java.lang.Exception -> L2f
            if (r10 != 0) goto L33
            long r0 = r1.optLong(r0)     // Catch: java.lang.Exception -> L2f
            goto L35
        L2f:
            r10 = move-exception
            r10.printStackTrace()
        L33:
            r0 = 7200(0x1c20, double:3.5573E-320)
        L35:
            android.content.Context r10 = r9.f1555a
            r10.getClass()
            java.lang.String r3 = "SharedPreferencesTracking"
            android.content.SharedPreferences r3 = r10.getSharedPreferences(r3, r2)     // Catch: java.lang.Exception -> L56
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = "maintenance_time"
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L56
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7     // Catch: java.lang.Exception -> L56
            long r0 = r0 * r7
            long r0 = r0 + r5
            r3.putLong(r4, r0)     // Catch: java.lang.Exception -> L56
            r3.apply()     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r0 = move-exception
            r0.printStackTrace()
        L5a:
            t3.h r0 = v5.g.f13148u
            v5.g r10 = r0.l(r10)
            r10.a()
            r10.n()
            r10.b()
        L69:
            return r2
        L6a:
            java.lang.String r10 = r10.f8696a
            r0 = 1
            if (r10 == 0) goto L75
            int r10 = r10.length()
            if (r10 != 0) goto L76
        L75:
            r2 = r0
        L76:
            r10 = r2 ^ 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.w4.c(h5.p0):boolean");
    }

    public h5.p0 d(String str) {
        str.getClass();
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/apps/byPackagename/" + str, ShareTarget.METHOD_GET, null);
        p0VarM.f8699d = k(p0VarM, "/eapi/apps/byPackagename");
        return p0VarM;
    }

    public Object e() {
        Uri uri;
        boolean zMatches;
        SharedPreferences sharedPreferences;
        Context context = this.f1555a;
        try {
            sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        String string = sharedPreferences.contains("outputdir") ? sharedPreferences.getString("outputdir", null) : null;
        if (string != null) {
            if (g("sdcard_as_backup_storage", false)) {
                context.getClass();
                List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
                persistedUriPermissions.getClass();
                Iterator<UriPermission> it = persistedUriPermissions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        uri = null;
                        break;
                    }
                    UriPermission next = it.next();
                    Uri uri2 = next.getUri();
                    uri2.getClass();
                    String path = uri2.getPath();
                    if (path != null) {
                        Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                        patternCompile.getClass();
                        zMatches = patternCompile.matcher(path).matches();
                    } else {
                        zMatches = false;
                    }
                    if (zMatches) {
                        uri = next.getUri();
                        break;
                    }
                }
                if (uri != null) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, uri);
                    if (documentFileFromTreeUri != null) {
                        for (String str : o7.m.s0(string, new String[]{"/"})) {
                            DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str);
                            if (documentFileFindFile == null) {
                                documentFileFromTreeUri = documentFileFromTreeUri.createDirectory(str);
                                if (documentFileFromTreeUri == null) {
                                    break;
                                }
                            } else {
                                documentFileFromTreeUri = documentFileFindFile;
                            }
                        }
                    }
                    if (documentFileFromTreeUri != null && documentFileFromTreeUri.exists()) {
                        return documentFileFromTreeUri;
                    }
                }
                O();
            }
            File file = new File(string);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
        }
        File fileA = x4.d.a(context);
        if (fileA == null) {
            return null;
        }
        Q("outputdir", fileA.getAbsolutePath());
        return fileA;
    }

    public String f() {
        SharedPreferences sharedPreferences;
        Context context = this.f1555a;
        try {
            sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        String string = sharedPreferences.contains("outputdir") ? sharedPreferences.getString("outputdir", null) : null;
        if (string != null) {
            return string;
        }
        File fileA = x4.d.a(context);
        if (fileA == null) {
            return null;
        }
        String absolutePath = fileA.getAbsolutePath();
        Q("outputdir", absolutePath);
        return absolutePath;
    }

    public boolean g(String str, boolean z9) {
        try {
            SharedPreferences sharedPreferences = this.f1555a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z9);
            }
        } catch (Exception unused) {
        }
        return z9;
    }

    public h5.p0 h(int i10) {
        String strG = a3.a.g(i10, "/eapi/v2/categories/", "/leaf-categories");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, null);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public HashMap i() {
        HashMap map = new HashMap();
        h5.p pVar = new h5.p();
        pVar.g(this.f1555a);
        String str = pVar.f8681c;
        if (str != null && str.length() != 0) {
            map.put("countryIsoCode", str);
        }
        return map;
    }

    public h5.p0 j(int i10) {
        HashMap map = new HashMap();
        String strG = a3.a.g(i10, "/eapi/category/", "/features");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public JSONObject k(h5.p0 p0Var, String str) {
        String str2;
        if (!p0Var.b() && (str2 = p0Var.f8696a) != null && str2.length() != 0) {
            try {
                String str3 = p0Var.f8696a;
                str3.getClass();
                return new JSONObject(str3);
            } catch (JSONException unused) {
                new t1.c(this.f1555a, 4).e(r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException", "url", str), "apiRead");
            }
        }
        return null;
    }

    public JSONObject l(h5.p0 p0Var, String str) {
        String str2 = p0Var.f8696a;
        if (str2 != null && str2.length() != 0) {
            try {
                String str3 = p0Var.f8696a;
                str3.getClass();
                return new JSONObject(str3);
            } catch (JSONException unused) {
                new t1.c(this.f1555a, 4).e(r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException", "url", str), "apiRead");
            }
        }
        return null;
    }

    public h5.p0 m(String str, String str2, HashMap map) {
        OutputStream outputStream;
        SharedPreferences sharedPreferences;
        h5.p0 p0Var = new h5.p0();
        if (map == null) {
            try {
                try {
                    map = new HashMap();
                } catch (Throwable th) {
                    throw th;
                }
            } catch (IllegalArgumentException unused) {
                p0Var.d("IllegalArgumentException");
            } catch (IllegalStateException unused2) {
                p0Var.d("IllegalStateException");
            } catch (NullPointerException unused3) {
                p0Var.d("NullPointerException");
            } catch (SecurityException unused4) {
                p0Var.d("SecurityException");
            } catch (MalformedURLException unused5) {
                p0Var.d("MalformedURLException");
            } catch (ProtocolException unused6) {
                p0Var.d("ProtocolException");
            } catch (SocketTimeoutException unused7) {
                p0Var.d("SocketTimeoutException");
            } catch (SSLHandshakeException unused8) {
                p0Var.d("SSLHandshakeException");
            } catch (IOException unused9) {
                p0Var.d("IOException");
            } catch (Exception unused10) {
                p0Var.d("Exception");
            }
        }
        boolean zContainsKey = map.containsKey("lang");
        String string = null;
        Context context = this.f1555a;
        if (!zContainsKey) {
            context.getClass();
            try {
                sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String string2 = sharedPreferences.contains("Language") ? sharedPreferences.getString("Language", null) : null;
            map.put("lang", l5.p(string2));
        }
        if (!map.containsKey("id_plataforma")) {
            map.put("id_plataforma", "13");
        }
        context.getClass();
        String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str3 = e1VarH.f8512a;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences2.contains("device_rooted")) {
                sharedPreferences2.getBoolean("device_rooted", false);
            }
        } catch (Exception unused11) {
        }
        if (!map.containsKey("identifier") && string3 != null) {
            map.put("identifier", string3);
        }
        if (o7.u.Z(str2, ShareTarget.METHOD_GET, true)) {
            str = str + '?' + p(map);
        } else if (o7.u.Z(str2, ShareTarget.METHOD_POST, true) && string3 != null) {
            HashMap map2 = new HashMap();
            map2.put("identifier", string3);
            str = str + '?' + p(map2);
        }
        if (!UptodownApp.X) {
            UptodownApp.X = true;
            try {
                d1.a.a(context);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        uRLConnectionOpenConnection.getClass();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setReadTimeout(30000);
        httpsURLConnection.setConnectTimeout(30000);
        httpsURLConnection.setRequestMethod(str2);
        httpsURLConnection.setDoInput(true);
        if (o7.u.Z(str2, ShareTarget.METHOD_POST, true)) {
            httpsURLConnection.setDoOutput(true);
        }
        try {
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences3.contains("UTOKEN")) {
                string = sharedPreferences3.getString("UTOKEN", null);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        String string4 = context.getSharedPreferences("SharedPreferencesUser", 0).getString("is_turbo", "");
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "704");
        if (string != null && string.length() != 0) {
            httpsURLConnection.setRequestProperty("UTOKEN", string);
        }
        if (string4 != null && string4.length() != 0) {
            httpsURLConnection.setRequestProperty("TURBOTOKEN", string4);
        }
        httpsURLConnection.setRequestProperty("APIKEY", v5.n.b());
        if (o7.u.Z(str2, ShareTarget.METHOD_POST, true) && (outputStream = httpsURLConnection.getOutputStream()) != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C.UTF8_NAME));
            bufferedWriter.write(p(map));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        int responseCode = httpsURLConnection.getResponseCode();
        p0Var.f8697b = responseCode;
        BufferedReader bufferedReader = (responseCode < 200 || responseCode >= 300) ? new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream())) : new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        p0Var.f8696a = sb.toString();
        p0Var.a(context);
        return p0Var;
    }

    public h5.p0 n(String str, HashMap map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        Context context = this.f1555a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        h5.e1 e1VarH = h5.c1.h(context);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str2 = e1VarH.f8512a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (string != null) {
            HashMap map2 = new HashMap();
            map2.put("identifier", string);
            str = str + '?' + p(map2);
        }
        h5.p0 p0Var = new h5.p0();
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            x0 x0Var = new x0();
            x0Var.k("lang", l5.p(z1.t1.A(context, "Language")));
            String string2 = jSONObject.toString();
            string2.getClass();
            byte[] bArrO = l5.o(string2);
            x0Var.h(strValueOf, bArrO);
            x0Var.j();
            x0Var.d(new URL(str), strValueOf);
            x0Var.c("lang", l5.p(z1.t1.A(context, "Language")));
            x0Var.a(strValueOf, bArrO);
            x0Var.e();
            p0Var = x0Var.f(true);
        } catch (Exception unused2) {
            p0Var.f8698c = "Exception";
        }
        p0Var.a(context);
        return p0Var;
    }

    public h5.p0 o(int i10, int i11) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i10));
        map.put("page[offset]", String.valueOf(i11));
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/apps/new-releases"), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/apps/new-releases");
        return p0VarM;
    }

    public h5.p0 q(long j10) throws JSONException {
        if (j10 == 0) {
            h5.p0 p0Var = new h5.p0();
            p0Var.f8697b = MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", 0);
            p0Var.f8696a = jSONObject.toString();
            return p0Var;
        }
        HashMap map = new HashMap();
        h5.p pVar = new h5.p();
        pVar.g(this.f1555a);
        String str = pVar.f8681c;
        if (str != null && str.length() != 0) {
            map.put("countryIsoCode", str);
        }
        return m("https://www.uptodown.app:443/eapi/v3/apps/" + j10 + "/device/" + pVar.f8679a, ShareTarget.METHOD_GET, map);
    }

    public h5.p0 r(int i10, int i11, int i12) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i11));
        map.put("page[offset]", String.valueOf(i12));
        String strG = a3.a.g(i10, "/eapi/categories/", "/apps/news");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public h5.p0 s(int i10, int i11, String str) {
        str.getClass();
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i10));
        map.put("page[offset]", String.valueOf(i11));
        h5.p0 p0VarM = m(androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.uptodown.app:443/eapi/user/", str, "/recommended-list"), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/user/" + str + "/recommended-list");
        return p0VarM;
    }

    public h5.p0 t(long j10) {
        h5.p0 p0VarM = m("https://www.uptodown.app:443/eapi/app/" + j10 + "/screenshots", ShareTarget.METHOD_GET, null);
        p0VarM.f8699d = k(p0VarM, "/eapi/app/appId/screenshots");
        return p0VarM;
    }

    public h5.p0 u(int i10, int i11) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i10));
        map.put("page[offset]", String.valueOf(i11));
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat("/eapi/v2/app/top-platform"), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, "/eapi/v2/app/top-platform");
        return p0VarM;
    }

    public h5.p0 v(int i10, int i11, int i12) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i11));
        map.put("page[offset]", String.valueOf(i12));
        String strG = a3.a.g(i10, "/eapi/category/", "/apps/top");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public h5.p0 w(int i10, int i11, int i12) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(i11));
        map.put("page[offset]", String.valueOf(i12));
        String strG = a3.a.g(i10, "/eapi/v3/leaf-category/", "/apps/top");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public h5.p0 x(int i10, int i11) {
        HashMap map = new HashMap();
        map.put("page[limit]", String.valueOf(75));
        map.put("page[offset]", String.valueOf(i11));
        String strG = a3.a.g(i10, "/eapi/floating-category/", "/apps-list");
        h5.p0 p0VarM = m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
        p0VarM.f8699d = k(p0VarM, strG);
        return p0VarM;
    }

    public h5.p0 y(int i10, String str, String str2) {
        str.getClass();
        str2.getClass();
        HashMap map = new HashMap();
        map.put("update", String.valueOf(i10));
        StringBuilder sb = new StringBuilder("https://www.uptodown.app:443/eapi/apps/");
        sb.append(str2);
        return m(androidx.constraintlayout.core.widgets.analyzer.a.y(sb, "/file/", str, "/downloadUrl"), ShareTarget.METHOD_GET, map);
    }

    public h5.p0 z(int i10, String str, String str2) {
        str.getClass();
        str2.getClass();
        HashMap map = new HashMap();
        map.put("update", String.valueOf(i10));
        StringBuilder sb = new StringBuilder("https://www.uptodown.app:443/eapi/apps/");
        sb.append(str2);
        return m(androidx.constraintlayout.core.widgets.analyzer.a.y(sb, "/file/", str, "/resumeDownloadURL"), ShareTarget.METHOD_GET, map);
    }

    public w4(Context context, int i10) {
        context.getClass();
        this.f1555a = context;
    }
}
