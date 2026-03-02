package h5;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import androidx.work.WorkManager;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.measurement.a4;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 {
    public static e1 a(JSONObject jSONObject) {
        e1 e1Var = new e1();
        if (!jSONObject.isNull("userID")) {
            e1Var.f8512a = jSONObject.optString("userID");
        }
        if (!jSONObject.isNull("username")) {
            e1Var.f8515d = jSONObject.optString("username");
        }
        if (!jSONObject.isNull("avatarURL")) {
            e1Var.f8514c = jSONObject.optString("avatarURL");
        }
        if (!jSONObject.isNull("isTurbo")) {
            e1Var.f8521n = jSONObject.optInt("isTurbo") == 1;
        }
        if (!jSONObject.isNull("usernameFormat")) {
            e1Var.f = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            e1Var.f8522o = jSONObject.optInt("isAuthorVerified") == 1;
        }
        if (!jSONObject.isNull("following")) {
            e1Var.f8516i = jSONObject.optInt("following");
        }
        return e1Var;
    }

    public static void b(Context context) {
        context.getClass();
        c(context);
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putString("UTOKEN", null);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        float f = UptodownApp.E;
        if (k4.c.o(context, "PreRegisterWorker")) {
            WorkManager.Companion.getInstance(context).cancelAllWorkByTag("PreRegisterWorker");
        }
        if (k4.c.o(context, "GetUserDataWorker")) {
            WorkManager.Companion.getInstance(context).cancelAllWorkByTag("GetUserDataWorker");
        }
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("preregistrations", null, null);
        gVarL.b();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f1832k;
        new HashSet();
        new HashMap();
        i0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f1839b);
        boolean z9 = googleSignInOptions.e;
        boolean z10 = googleSignInOptions.f;
        String str = googleSignInOptions.g;
        Account account = googleSignInOptions.f1840c;
        String str2 = googleSignInOptions.h;
        HashMap mapC = GoogleSignInOptions.c(googleSignInOptions.f1842i);
        String str3 = googleSignInOptions.f1843j;
        hashSet.add(GoogleSignInOptions.f1833l);
        i0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        i0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f1836o)) {
            Scope scope = GoogleSignInOptions.f1835n;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.f1834m);
        }
        a4.o(context, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, mapC, str3)).c();
    }

    public static void c(Context context) {
        context.getClass();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
        editorEdit.remove("user_id");
        editorEdit.remove("user_email");
        editorEdit.remove("user_name");
        editorEdit.remove("user_picture");
        editorEdit.remove("registered_timestamp");
        editorEdit.remove("is_turbo");
        editorEdit.remove("username_format");
        editorEdit.remove("background_image");
        editorEdit.remove("has_news_on_feed");
        editorEdit.apply();
        try {
            SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit2.putBoolean("welcome_popup_shown", false);
            editorEdit2.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String e(String str) {
        if (str != null) {
            return a3.a.o(a3.a.v(str), UptodownApp.G, ":webp");
        }
        return null;
    }

    public static ArrayList f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                jSONObjectOptJSONObject.getClass();
                arrayList.add(a(jSONObjectOptJSONObject));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static boolean g(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("SharedPreferencesUser", 0);
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
        return (string == null && sharedPreferences2.getString("is_turbo", null) == null) ? false : true;
    }

    public static e1 h(Context context) {
        e1 e1Var;
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesUser", 0);
        if (sharedPreferences.contains("user_id")) {
            e1Var = new e1();
            e1Var.f8512a = sharedPreferences.getString("user_id", null);
        } else {
            e1Var = null;
        }
        if (sharedPreferences.contains("user_email")) {
            if (e1Var == null) {
                e1Var = new e1();
            }
            e1Var.f8513b = sharedPreferences.getString("user_email", null);
        }
        if (sharedPreferences.contains("user_name")) {
            if (e1Var == null) {
                e1Var = new e1();
            }
            e1Var.f8515d = sharedPreferences.getString("user_name", null);
        }
        if (e1Var != null) {
            if (sharedPreferences.contains("user_picture")) {
                e1Var.f8514c = sharedPreferences.getString("user_picture", null);
            }
            if (sharedPreferences.contains("registered_timestamp")) {
                e1Var.e = sharedPreferences.getLong("registered_timestamp", -1L);
            }
            if (sharedPreferences.contains("is_turbo")) {
                e1Var.f8520m = sharedPreferences.getString("is_turbo", null);
            }
            if (sharedPreferences.contains("username_format")) {
                e1Var.f = sharedPreferences.getString("username_format", "type0");
            }
            if (sharedPreferences.contains("background_image")) {
                e1Var.g = sharedPreferences.getString("background_image", null);
            }
            if (sharedPreferences.contains("has_news_on_feed")) {
                e1Var.f8523p = sharedPreferences.getBoolean("has_news_on_feed", false);
            }
        }
        return e1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.Context r11, java.lang.String r12, y6.c r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof h5.z0
            if (r0 == 0) goto L13
            r0 = r13
            h5.z0 r0 = (h5.z0) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            h5.z0 r0 = new h5.z0
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8806d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f8805c
            kotlin.jvm.internal.v r12 = r0.f8804b
            java.lang.String r0 = r0.f8803a
            s6.a.e(r13)
            r7 = r12
            r12 = r0
            goto L61
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r11)
            r11 = 0
            return r11
        L34:
            s6.a.e(r13)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            y7.e r13 = r7.i0.f12407a
            y7.d r13 = y7.d.f14116a
            h5.a1 r3 = new h5.a1
            r8 = 0
            r9 = 0
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f8803a = r5
            r0.f8804b = r7
            r0.f8805c = r6
            r0.f = r2
            java.lang.Object r11 = r7.y.z(r3, r13, r0)
            x6.a r12 = x6.a.f13718a
            if (r11 != r12) goto L5f
            return r12
        L5f:
            r12 = r5
            r11 = r6
        L61:
            h5.d1 r13 = new h5.d1
            int r0 = r7.f10136a
            int r11 = r11.f10136a
            r13.<init>(r12, r0, r11, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.c1.d(android.content.Context, java.lang.String, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(android.content.Context r11, java.lang.String r12, y6.c r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof h5.b1
            if (r0 == 0) goto L13
            r0 = r13
            h5.b1 r0 = (h5.b1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            h5.b1 r0 = new h5.b1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8479d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f8478c
            kotlin.jvm.internal.v r12 = r0.f8477b
            java.lang.String r0 = r0.f8476a
            s6.a.e(r13)
            r7 = r12
            r12 = r0
            goto L61
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r11)
            r11 = 0
            return r11
        L34:
            s6.a.e(r13)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            y7.e r13 = r7.i0.f12407a
            y7.d r13 = y7.d.f14116a
            h5.a1 r3 = new h5.a1
            r8 = 0
            r9 = 1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f8476a = r5
            r0.f8477b = r7
            r0.f8478c = r6
            r0.f = r2
            java.lang.Object r11 = r7.y.z(r3, r13, r0)
            x6.a r12 = x6.a.f13718a
            if (r11 != r12) goto L5f
            return r12
        L5f:
            r12 = r5
            r11 = r6
        L61:
            h5.d1 r13 = new h5.d1
            int r0 = r7.f10136a
            int r11 = r11.f10136a
            r1 = 0
            r13.<init>(r12, r0, r11, r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.c1.i(android.content.Context, java.lang.String, y6.c):java.lang.Object");
    }
}
