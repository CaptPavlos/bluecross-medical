package v5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.CustomWebView;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {
    public static AlertDialog a(AlertDialog alertDialog, FragmentActivity fragmentActivity) {
        SharedPreferences sharedPreferences;
        fragmentActivity.getClass();
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        boolean z9 = false;
        try {
            sharedPreferences = fragmentActivity.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences.contains("is_in_eea") ? sharedPreferences.getBoolean("is_in_eea", true) : true;
        if (!z10) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences2 = fragmentActivity.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("gdpr_tracking_allowed")) {
                z9 = sharedPreferences2.getBoolean("gdpr_tracking_allowed", false);
            }
        } catch (Exception unused2) {
        }
        if (z9) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        builder.setMessage(fragmentActivity.getString(R.string.tracking_disabled_warning_gdpr));
        builder.setPositiveButton(R.string.gdpr_set_up, new m4.k(fragmentActivity, 3));
        builder.setNegativeButton(android.R.string.cancel, new r5.c(12));
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        if (!fragmentActivity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }

    public static void b(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        try {
            if (str.equalsIgnoreCase(str2)) {
                Iterator it = r0.f.D(context).iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    File file = (File) next;
                    String name = file.getName();
                    name.getClass();
                    String strC = r0.f.C(name);
                    if (strC != null && strC.equalsIgnoreCase(str2)) {
                        String absolutePath = file.getAbsolutePath();
                        if (file.delete()) {
                            g gVarL = g.f13148u.l(context);
                            gVarL.a();
                            absolutePath.getClass();
                            SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                            sQLiteDatabase.getClass();
                            sQLiteDatabase.delete("deep_link_files", "path=?", new String[]{absolutePath});
                            gVarL.b();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String c(int i10) {
        if (i10 >= 1000000) {
            double d8 = i10 / 1000000.0d;
            int i11 = (int) d8;
            if (d8 != i11) {
                return u.b0(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1)), ",0", "", false).concat("M");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i11);
            sb.append('M');
            return sb.toString();
        }
        if (i10 < 1000) {
            return String.valueOf(i10);
        }
        double d10 = i10 / 1000.0d;
        int i12 = (int) d10;
        if (d10 != i12) {
            return u.b0(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1)), ",0", "", false).concat("K");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        sb2.append('K');
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.net.Uri r5) {
        /*
            java.lang.String r0 = r5.toString()
            r0.getClass()
            java.lang.String r1 = "utd://"
            r2 = 0
            boolean r1 = o7.u.c0(r0, r1, r2)
            r3 = 6
            if (r1 == 0) goto L16
            java.lang.String r5 = r0.substring(r3)
            return r5
        L16:
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "market://"
            boolean r1 = o7.u.c0(r1, r4, r2)
            if (r1 != 0) goto L43
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "http://play.google.com"
            boolean r1 = o7.u.c0(r1, r4, r2)
            if (r1 != 0) goto L43
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "https://play.google.com"
            boolean r1 = o7.u.c0(r1, r4, r2)
            if (r1 == 0) goto L6e
        L43:
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "details?id="
            boolean r1 = o7.m.d0(r1, r4, r2)
            if (r1 == 0) goto L6e
            int r5 = o7.m.k0(r0, r4, r2, r2, r3)
            int r5 = r5 + 11
            java.lang.String r1 = "&"
            boolean r4 = o7.m.d0(r0, r1, r2)
            if (r4 == 0) goto L69
            int r1 = o7.m.k0(r0, r1, r2, r2, r3)
            java.lang.String r5 = r0.substring(r5, r1)
            return r5
        L69:
            java.lang.String r5 = r0.substring(r5)
            return r5
        L6e:
            java.lang.String r5 = r5.toString()
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.c.d(android.net.Uri):java.lang.String");
    }

    public static void e(Activity activity, String str, String str2) {
        String strConcat;
        activity.getClass();
        str.getClass();
        if (o7.m.d0(str, ".uptodown.com/", false)) {
            strConcat = (o7.m.d0(str, "?", false) ? str.concat("&") : str.concat("?")).concat("userAgent=uptodownandroid");
        } else {
            strConcat = str;
        }
        try {
            new CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse(strConcat));
        } catch (Exception unused) {
            Intent intent = new Intent(activity, (Class<?>) CustomWebView.class);
            if (str2 != null) {
                intent.putExtra(CampaignEx.JSON_KEY_TITLE, str2);
            }
            intent.putExtra("url", strConcat);
            float f = UptodownApp.E;
            activity.startActivity(intent, k4.c.a(activity));
            Bundle bundle = new Bundle();
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "urlNotOpened");
            bundle.putString("url", str);
            new t1.c(activity, 4).e(bundle, "open_url");
        }
    }
}
