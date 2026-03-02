package d0;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import i0.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f6765c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static b f6766d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f6767a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f6768b;

    public b(Context context) {
        this.f6768b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        y.g(context);
        ReentrantLock reentrantLock = f6765c;
        reentrantLock.lock();
        try {
            if (f6766d == null) {
                f6766d = new b(context.getApplicationContext());
            }
            b bVar = f6766d;
            reentrantLock.unlock();
            return bVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String f(String str, String str2) {
        return a3.a.j(str, ":", str2);
    }

    public final GoogleSignInAccount b() {
        String strD;
        String strD2 = d("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strD2) && (strD = d(f("googleSignInAccount", strD2))) != null) {
            try {
                return GoogleSignInAccount.b(strD);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final void c(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) throws JSONException {
        y.g(googleSignInAccount);
        y.g(googleSignInOptions);
        String str = googleSignInAccount.f1827i;
        e("defaultGoogleSignInAccount", str);
        String strF = f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.f1824b;
            if (str2 != null) {
                jSONObject.put("id", str2);
            }
            String str3 = googleSignInAccount.f1825c;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.f1826d;
            if (str4 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, str4);
            }
            String str5 = googleSignInAccount.e;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.f1829k;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.f1830l;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.f;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.g;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.h);
            jSONObject.put("obfuscatedIdentifier", str);
            JSONArray jSONArray = new JSONArray();
            List list = googleSignInAccount.f1828j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c0.d.f977b);
            int i10 = 0;
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f1856b);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(strF, jSONObject.toString());
            String strF2 = f("googleSignInOptions", str);
            String str9 = googleSignInOptions.h;
            String str10 = googleSignInOptions.g;
            ArrayList arrayList = googleSignInOptions.f1839b;
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(arrayList, GoogleSignInOptions.f1837p);
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    jSONArray2.put(((Scope) obj).f1856b);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.f1840c;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f1841d);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.e);
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject2.put("serverClientId", str10);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("hostedDomain", str9);
                }
                e(strF2, jSONObject2.toString());
            } catch (JSONException e) {
                com.google.gson.internal.a.j(e);
            }
        } catch (JSONException e3) {
            com.google.gson.internal.a.j(e3);
        }
    }

    public final String d(String str) {
        ReentrantLock reentrantLock = this.f6767a;
        reentrantLock.lock();
        try {
            return this.f6768b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e(String str, String str2) {
        ReentrantLock reentrantLock = this.f6767a;
        reentrantLock.lock();
        try {
            this.f6768b.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
