package l4;

import android.app.AlertDialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.WishlistActivity;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x4 implements g5.i, g5.y, g5.x, g5.q, g5.g, g5.v, r.b, u1.a, h1.h, j4.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10986a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10987b;

    public x4(Context context) {
        boolean zIsEmpty;
        this.f10986a = 26;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f10987b = sharedPreferences;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                o();
            }
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e.getMessage());
            }
        }
    }

    public static String d(int i10, int i11, byte[] bArr) {
        if (i11 < 0) {
            return null;
        }
        int iQ = q((i11 * 4) + 36, bArr) + i10;
        int i12 = ((bArr[iQ + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[iQ] & 255);
        byte[] bArr2 = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            bArr2[i13] = bArr[(i13 * 2) + iQ + 2];
        }
        return new String(bArr2, o7.a.f11749a);
    }

    public static int q(int i10, byte[] bArr) {
        return (bArr[i10] & 255) | ((bArr[i10 + 3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i10 + 2] << 16) & 16711680) | ((bArr[i10 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    @Override // g5.g
    public void C(h5.q qVar) {
        ((RecommendedActivity) this.f10987b).D0(qVar != null ? qVar.f8701b : null);
    }

    public void D(int i10, String str) {
        String strConcat = "                                             ".substring(0, (int) Math.min(i10 * 2, 45)).concat(str);
        StringBuilder sb = (StringBuilder) this.f10987b;
        sb.append(strConcat);
        sb.append('\n');
    }

    public void E() {
        synchronized (((p8.g) this.f10987b)) {
        }
    }

    @Override // g5.q
    public void F() {
        int i10 = this.f10986a;
    }

    @Override // g5.x
    public void I(int i10) {
        n4.d1 d1Var;
        n4.d1 d1Var2;
        int i11 = this.f10986a;
        Object obj = this.f10987b;
        switch (i11) {
            case 3:
                PublicListActivity publicListActivity = (PublicListActivity) obj;
                float f = UptodownApp.E;
                if (k4.c.s() && (d1Var = publicListActivity.W) != null && !d1Var.f11324a.isEmpty()) {
                    n4.d1 d1Var3 = publicListActivity.W;
                    d1Var3.getClass();
                    Object obj2 = d1Var3.f11324a.get(i10);
                    obj2.getClass();
                    h5.i1 i1Var = (h5.i1) obj2;
                    l1.b.p(i1Var.f8616a, publicListActivity, i1Var.f8619d);
                    n4.d1 d1Var4 = publicListActivity.W;
                    if (d1Var4 != null) {
                        d1Var4.notifyItemChanged(i10);
                        break;
                    }
                }
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) obj;
                float f10 = UptodownApp.E;
                if (k4.c.s() && (d1Var2 = wishlistActivity.W) != null && !d1Var2.f11324a.isEmpty()) {
                    n4.d1 d1Var5 = wishlistActivity.W;
                    d1Var5.getClass();
                    Object obj3 = d1Var5.f11324a.get(i10);
                    obj3.getClass();
                    h5.i1 i1Var2 = (h5.i1) obj3;
                    l1.b.p(i1Var2.f8616a, wishlistActivity, i1Var2.f8619d);
                    n4.d1 d1Var6 = wishlistActivity.W;
                    if (d1Var6 != null) {
                        d1Var6.notifyItemChanged(i10);
                        break;
                    }
                }
                break;
        }
    }

    @Override // g5.y
    public void N(int i10) throws Resources.NotFoundException {
        switch (this.f10986a) {
            case 2:
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) this.f10987b;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    int i11 = 3;
                    if (h5.c1.h(preregistrationActivity) != null) {
                        n4.d0 d0Var = preregistrationActivity.J;
                        d0Var.getClass();
                        Object obj = d0Var.f11323c.get(i10);
                        obj.getClass();
                        h5.g0 g0Var = (h5.g0) obj;
                        if (!preregistrationActivity.isFinishing()) {
                            AlertDialog alertDialog = preregistrationActivity.f10935w;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            d5.j jVarG = d5.j.g(preregistrationActivity.getLayoutInflater());
                            TextView textView = (TextView) jVarG.f7136d;
                            TextView textView2 = (TextView) jVarG.f;
                            TextView textView3 = (TextView) jVarG.e;
                            TextView textView4 = (TextView) jVarG.f7135c;
                            textView2.setTypeface(o4.b.f11719r);
                            textView2.setText(preregistrationActivity.getString(R.string.cancel_registration));
                            textView.setTypeface(o4.b.f11720s);
                            String string = preregistrationActivity.getString(R.string.confirm_cancel_preregister, g0Var.f8559b);
                            string.getClass();
                            String str = g0Var.f8559b;
                            str.getClass();
                            SpannableString spannableString = new SpannableString(string);
                            int iK0 = o7.m.k0(string, str, 0, false, 6);
                            int length = str.length() + iK0;
                            if (iK0 != -1) {
                                float dimension = preregistrationActivity.getResources().getDimension(R.dimen.text_size_m);
                                Typeface typeface = o4.b.f11719r;
                                typeface.getClass();
                                spannableString.setSpan(new v5.e(dimension, typeface, ContextCompat.getColor(preregistrationActivity, R.color.text_primary)), iK0, length, 33);
                            }
                            textView.setText(spannableString);
                            textView4.setTypeface(o4.b.f11719r);
                            textView3.setTypeface(o4.b.f11719r);
                            textView3.setText(preregistrationActivity.getString(R.string.dialog_confirmation_verify_afirmative));
                            textView4.setVisibility(0);
                            textView4.setOnClickListener(new e6(preregistrationActivity, 4));
                            textView3.setOnClickListener(new f5(i11, preregistrationActivity, g0Var));
                            ((ImageView) jVarG.g).setOnClickListener(new e6(preregistrationActivity, 5));
                            AlertDialog.Builder builder = new AlertDialog.Builder(preregistrationActivity);
                            builder.setView((RelativeLayout) jVarG.f7134b);
                            builder.setCancelable(true);
                            AlertDialog alertDialogCreate = builder.create();
                            preregistrationActivity.f10935w = alertDialogCreate;
                            if (alertDialogCreate != null) {
                                Window window = alertDialogCreate.getWindow();
                                if (window != null) {
                                    a3.a.A(window, 0);
                                }
                                AlertDialog alertDialog2 = preregistrationActivity.f10935w;
                                alertDialog2.getClass();
                                alertDialog2.show();
                                break;
                            }
                        }
                    } else {
                        int i12 = PreregistrationActivity.M;
                        if (!preregistrationActivity.isFinishing()) {
                            AlertDialog alertDialog3 = preregistrationActivity.f10935w;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                            }
                            d5.j jVarG2 = d5.j.g(preregistrationActivity.getLayoutInflater());
                            TextView textView5 = (TextView) jVarG2.e;
                            ((TextView) jVarG2.f).setTypeface(o4.b.f11719r);
                            ((TextView) jVarG2.f7136d).setTypeface(o4.b.f11720s);
                            textView5.setTypeface(o4.b.f11719r);
                            textView5.setOnClickListener(new e6(preregistrationActivity, 2));
                            ((ImageView) jVarG2.g).setOnClickListener(new e6(preregistrationActivity, i11));
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(preregistrationActivity);
                            builder2.setView((RelativeLayout) jVarG2.f7134b);
                            builder2.setCancelable(true);
                            AlertDialog alertDialogCreate2 = builder2.create();
                            preregistrationActivity.f10935w = alertDialogCreate2;
                            if (alertDialogCreate2 != null) {
                                Window window2 = alertDialogCreate2.getWindow();
                                if (window2 != null) {
                                    a3.a.A(window2, 0);
                                }
                                AlertDialog alertDialog4 = preregistrationActivity.f10935w;
                                alertDialog4.getClass();
                                alertDialog4.show();
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override // g5.y, g5.b, g5.p
    public void a(int i10) {
        n4.d0 d0Var;
        n4.d1 d1Var;
        n4.d1 d1Var2;
        int i11 = this.f10986a;
        Object obj = this.f10987b;
        switch (i11) {
            case 2:
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) obj;
                float f = UptodownApp.E;
                if (k4.c.s() && (d0Var = preregistrationActivity.J) != null && !d0Var.f11323c.isEmpty()) {
                    n4.d0 d0Var2 = preregistrationActivity.J;
                    d0Var2.getClass();
                    Object obj2 = d0Var2.f11323c.get(i10);
                    obj2.getClass();
                    preregistrationActivity.Y(((h5.g0) obj2).f8558a);
                    break;
                }
                break;
            case 3:
                PublicListActivity publicListActivity = (PublicListActivity) obj;
                float f10 = UptodownApp.E;
                if (k4.c.s() && (d1Var = publicListActivity.W) != null && !d1Var.f11324a.isEmpty()) {
                    n4.d1 d1Var3 = publicListActivity.W;
                    d1Var3.getClass();
                    Object obj3 = d1Var3.f11324a.get(i10);
                    obj3.getClass();
                    h5.i1 i1Var = (h5.i1) obj3;
                    publicListActivity.Z(i1Var.f8616a, i1Var.f8620i);
                    break;
                }
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) obj;
                float f11 = UptodownApp.E;
                if (k4.c.s() && (d1Var2 = wishlistActivity.W) != null && !d1Var2.f11324a.isEmpty()) {
                    n4.d1 d1Var4 = wishlistActivity.W;
                    d1Var4.getClass();
                    Object obj4 = d1Var4.f11324a.get(i10);
                    obj4.getClass();
                    h5.i1 i1Var2 = (h5.i1) obj4;
                    wishlistActivity.Z(i1Var2.f8616a, i1Var2.f8620i);
                    break;
                }
                break;
        }
    }

    @Override // g5.y
    public void b(View view, int i10) {
        n4.d1 d1Var;
        switch (this.f10986a) {
            case 3:
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f10987b;
                float f = UptodownApp.E;
                if (k4.c.s() && (d1Var = wishlistActivity.W) != null && !d1Var.f11324a.isEmpty()) {
                    n4.d1 d1Var2 = wishlistActivity.W;
                    d1Var2.getClass();
                    Object obj = d1Var2.f11324a.get(i10);
                    obj.getClass();
                    h5.i1 i1Var = (h5.i1) obj;
                    String string = wishlistActivity.getString(R.string.dialog_wishlist_msg);
                    string.getClass();
                    wishlistActivity.K(String.format(string, Arrays.copyOf(new Object[]{i1Var.f8617b}, 1)), new w4(wishlistActivity, i10, i1Var, 2));
                    break;
                }
                break;
        }
    }

    public JSONObject c(View view) throws JSONException {
        int currentModeType;
        JSONObject jSONObjectA = z3.b.a(0, 0, 0, 0);
        UiModeManager uiModeManager = l1.b.f10167a;
        try {
            jSONObjectA.put("noOutputDevice", z3.a.f14401a[c.i.c((uiModeManager == null || (currentModeType = uiModeManager.getCurrentModeType()) == 1 || currentModeType != 4) ? 2 : r0.f.e)] == 1);
            return jSONObjectA;
        } catch (JSONException e) {
            Log.e("OMIDLIB", "Error with setting output device status", e);
            return jSONObjectA;
        }
    }

    public synchronized void e(p8.e0 e0Var) {
        ((LinkedHashSet) this.f10987b).remove(e0Var);
    }

    @Override // g5.i
    public void f(int i10) {
        switch (this.f10986a) {
            case 0:
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) this.f10987b;
                String string = notificationsRegistryActivity.getString(R.string.app_detail_not_found);
                string.getClass();
                notificationsRegistryActivity.C(string);
                break;
            default:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) this.f10987b;
                String string2 = userDeviceDetailsActivity.getString(R.string.msg_app_not_found);
                string2.getClass();
                userDeviceDetailsActivity.C(string2);
                break;
        }
    }

    @Override // p6.a
    public Object get() {
        switch (this.f10986a) {
            case 17:
                return new p2((Context) ((x4) this.f10987b).f10987b, new t3.h(17), new t3.h(16), 8);
            case 18:
                return this.f10987b;
            default:
                String packageName = ((Context) ((p6.a) this.f10987b).get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                androidx.window.layout.c.k("Cannot return null from a non-@Nullable @Provides method");
                return null;
        }
    }

    @Override // g5.g
    public void h(h5.q qVar) {
        float f = UptodownApp.E;
        File fileG = qVar.g();
        fileG.getClass();
        k4.c.p((RecommendedActivity) this.f10987b, fileG, null);
    }

    @Override // g5.x
    public void j(int i10) {
        switch (this.f10986a) {
            case 3:
                PublicListActivity publicListActivity = (PublicListActivity) this.f10987b;
                n4.d1 d1Var = publicListActivity.W;
                if (d1Var != null && !d1Var.f11324a.isEmpty()) {
                    n4.d1 d1Var2 = publicListActivity.W;
                    d1Var2.getClass();
                    new c1.l(publicListActivity, ((h5.i1) d1Var2.f11324a.get(i10)).f8616a, new h0.a0(publicListActivity, i10), LifecycleOwnerKt.getLifecycleScope(publicListActivity));
                    break;
                }
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f10987b;
                n4.d1 d1Var3 = wishlistActivity.W;
                if (d1Var3 != null && !d1Var3.f11324a.isEmpty()) {
                    n4.d1 d1Var4 = wishlistActivity.W;
                    d1Var4.getClass();
                    new c1.l(wishlistActivity, ((h5.i1) d1Var4.f11324a.get(i10)).f8616a, new kc(wishlistActivity, i10), LifecycleOwnerKt.getLifecycleScope(wishlistActivity));
                    break;
                }
                break;
        }
    }

    @Override // u1.a
    public void k(Bundle bundle) {
        ((n1.b) ((n1.a) this.f10987b)).a("clx", "_ae", bundle);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        int i10 = this.f10986a;
        Object obj = this.f10987b;
        switch (i10) {
            case 0:
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj;
                Intent intent = new Intent(notificationsRegistryActivity, (Class<?>) AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                float f = UptodownApp.E;
                notificationsRegistryActivity.startActivity(intent, k4.c.a(notificationsRegistryActivity));
                break;
            default:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj;
                if (!userDeviceDetailsActivity.isFinishing()) {
                    Intent intent2 = new Intent(userDeviceDetailsActivity, (Class<?>) AppDetailActivity.class);
                    intent2.putExtra("appInfo", hVar);
                    float f10 = UptodownApp.E;
                    userDeviceDetailsActivity.startActivity(intent2, k4.c.a(userDeviceDetailsActivity));
                    break;
                }
                break;
        }
    }

    public void m(byte[] bArr) {
        int iQ = (q(16, bArr) * 4) + 36;
        int iQ2 = q(12, bArr);
        int i10 = iQ2;
        while (true) {
            if (i10 >= bArr.length - 4) {
                break;
            }
            if (q(i10, bArr) == 1048834) {
                iQ2 = i10;
                break;
            }
            i10 += 4;
        }
        int i11 = 0;
        while (iQ2 < bArr.length) {
            int iQ3 = q(iQ2, bArr);
            int iQ4 = q(iQ2 + 20, bArr);
            switch (iQ3) {
                case 1048834:
                    int iQ5 = q(iQ2 + 28, bArr);
                    iQ2 += 36;
                    String strD = d(iQ, iQ4, bArr);
                    StringBuilder sb = new StringBuilder();
                    for (int i12 = 0; i12 < iQ5; i12++) {
                        int iQ6 = q(iQ2 + 4, bArr);
                        int iQ7 = q(iQ2 + 8, bArr);
                        int iQ8 = q(iQ2 + 16, bArr);
                        iQ2 += 20;
                        sb.append(" " + d(iQ, iQ6, bArr) + "=\"" + (iQ7 != -1 ? d(iQ, iQ7, bArr) : String.valueOf(iQ8)) + '\"');
                    }
                    D(i11, "<" + strD + ((Object) sb) + '>');
                    i11++;
                    break;
                case 1048835:
                    i11--;
                    iQ2 += 24;
                    D(i11, "</" + d(iQ, iQ4, bArr) + '>');
                    break;
                default:
                    return;
            }
        }
    }

    @Override // g5.x
    public void n(long j10, h5.k kVar) {
        int i10 = this.f10986a;
        Object obj = this.f10987b;
        switch (i10) {
            case 3:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    PublicListActivity publicListActivity = (PublicListActivity) obj;
                    if (j10 <= 0) {
                        publicListActivity.b0();
                        break;
                    } else {
                        new c1.l(publicListActivity, j10, new i0.k(13, publicListActivity, kVar), LifecycleOwnerKt.getLifecycleScope(publicListActivity));
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    WishlistActivity wishlistActivity = (WishlistActivity) obj;
                    if (j10 <= 0) {
                        wishlistActivity.b0();
                        break;
                    } else {
                        new c1.l(wishlistActivity, j10, new i0.k(17, wishlistActivity, kVar), LifecycleOwnerKt.getLifecycleScope(wishlistActivity));
                        break;
                    }
                }
                break;
        }
    }

    public synchronized void o() {
        ((SharedPreferences) this.f10987b).edit().clear().commit();
    }

    @Override // g5.g
    public void onError(String str) {
        ((RecommendedActivity) this.f10987b).N(str);
    }

    @Override // j4.g
    public void onSuccess() {
        ((z5.d) this.f10987b).f14425q = true;
    }

    @Override // j4.g
    public void p(Exception exc) {
        exc.getClass();
    }

    @Override // g5.q
    public void r(h5.e1 e1Var) {
        int i10 = this.f10986a;
        Object obj = this.f10987b;
        switch (i10) {
            case 4:
                int i11 = PublicProfileActivity.K;
                ((PublicProfileActivity) obj).q0(e1Var);
                break;
            case 7:
                RepliesActivity repliesActivity = (RepliesActivity) obj;
                Intent intent = new Intent(repliesActivity, (Class<?>) PublicProfileActivity.class);
                intent.putExtra("user", e1Var);
                float f = UptodownApp.E;
                repliesActivity.startActivity(intent, k4.c.a(repliesActivity));
                break;
            default:
                ReviewsActivity reviewsActivity = (ReviewsActivity) obj;
                Intent intent2 = new Intent(reviewsActivity, (Class<?>) PublicProfileActivity.class);
                intent2.putExtra("user", e1Var);
                float f10 = UptodownApp.E;
                reviewsActivity.startActivity(intent2, k4.c.a(reviewsActivity));
                break;
        }
    }

    public void u(int i10) {
        UserCommentsActivity userCommentsActivity = (UserCommentsActivity) this.f10987b;
        float f = UptodownApp.E;
        if (k4.c.s()) {
            n4.a1 a1Var = userCommentsActivity.J;
            a1Var.getClass();
            new c1.l(userCommentsActivity, ((h5.t0) a1Var.f11296a.get(i10)).e, new n5(userCommentsActivity, 11), LifecycleOwnerKt.getLifecycleScope(userCommentsActivity));
        }
    }

    public void w(d5.n nVar, Thread thread, Throwable th) {
        w1.l lVar = (w1.l) this.f10987b;
        synchronized (lVar) {
            String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            r0.f.I();
            try {
                w1.y.a(lVar.e.f13576a.b(new w1.j(lVar, System.currentTimeMillis(), th, thread, nVar)));
            } catch (TimeoutException unused) {
                Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
            } catch (Exception e) {
                Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e);
            }
        }
    }

    @Override // g5.g
    public void x(String str) {
        str.getClass();
        v5.c.e((RecommendedActivity) this.f10987b, str, null);
    }

    @Override // h1.h
    public h1.p y(Object obj) {
        e2.d dVar = (e2.d) obj;
        t1.c cVar = (t1.c) this.f10987b;
        if (dVar == null) {
            Log.w("FirebaseCrashlytics", "Received null app settings at app startup. Cannot send cached reports", null);
            return r0.f.x(null);
        }
        w1.l lVar = (w1.l) cVar.f12752c;
        w1.l.a(lVar);
        lVar.f13359m.n(lVar.e.f13576a, null);
        lVar.f13363q.c(null);
        return r0.f.x(null);
    }

    private final void A() {
    }

    private final void B() {
    }

    private final void z() {
    }

    private final void s(int i10) {
    }

    private final void t(int i10) {
    }

    private final void v(View view, int i10) {
    }

    public x4(d0.i iVar, i0.k kVar) {
        this.f10986a = 14;
        this.f10987b = kVar;
        iVar.C(new o1.b(this, 1));
    }

    public x4(int i10) {
        this.f10986a = i10;
        switch (i10) {
            case 28:
                this.f10987b = new StringBuilder();
                break;
            default:
                this.f10987b = new LinkedHashSet();
                break;
        }
    }

    public /* synthetic */ x4(Object obj, int i10) {
        this.f10986a = i10;
        this.f10987b = obj;
    }
}
