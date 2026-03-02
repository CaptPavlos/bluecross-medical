package f0;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import i0.y;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class e extends f {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8000c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final e f8001d = new e();

    public static AlertDialog e(Activity activity, int i10, i0.q qVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(i0.p.b(activity, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i10 != 1 ? i10 != 2 ? i10 != 3 ? resources.getString(R.string.ok) : resources.getString(com.uptodown.R.string.common_google_play_services_enable_button) : resources.getString(com.uptodown.R.string.common_google_play_services_update_button) : resources.getString(com.uptodown.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, qVar);
        }
        String strC = i0.p.c(activity, i10);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", a3.a.f(i10, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                i iVar = new i();
                y.h(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                iVar.f8011a = alertDialog;
                if (onCancelListener != null) {
                    iVar.f8012b = onCancelListener;
                }
                iVar.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        y.h(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        cVar.f7994a = alertDialog;
        if (onCancelListener != null) {
            cVar.f7995b = onCancelListener;
        }
        cVar.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i10, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogE = e(googleApiActivity, i10, new i0.q(super.a(googleApiActivity, i10, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogE == null) {
            return;
        }
        f(googleApiActivity, alertDialogE, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void g(Context context, int i10, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i11;
        Log.w("GoogleApiAvailability", a3.a.g(i10, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i10 == 18) {
            new j(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i10 == 6 ? i0.p.e(context, "common_google_play_services_resolution_required_title") : i0.p.c(context, i10);
        if (strE == null) {
            strE = context.getResources().getString(com.uptodown.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i10 == 6 || i10 == 19) ? i0.p.d(context, "common_google_play_services_resolution_required_text", i0.p.a(context)) : i0.p.b(context, i10);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        y.g(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strE).setStyle(new NotificationCompat.BigTextStyle().bigText(strD));
        PackageManager packageManager = context.getPackageManager();
        if (n0.b.f11269c == null) {
            n0.b.f11269c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (n0.b.f11269c.booleanValue()) {
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (n0.b.c(context)) {
                style.addAction(com.uptodown.R.drawable.common_full_open_on_phone, resources.getString(com.uptodown.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(com.uptodown.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strD);
        }
        if (n0.b.a()) {
            if (!n0.b.a()) {
                u.e();
                return;
            }
            synchronized (f8000c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.uptodown.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification notificationBuild = style.build();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            g.f8004a.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, notificationBuild);
    }

    public final void h(Activity activity, h0.f fVar, int i10, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i10, new i0.q(super.a(activity, i10, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D), fVar, 1), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
