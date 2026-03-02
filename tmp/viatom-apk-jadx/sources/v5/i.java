package v5;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.receivers.DownloadNotificationReceiver;
import com.uptodown.workers.DownloadWorker;
import h5.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.a0;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i {
    public static boolean a(Context context) {
        SharedPreferences sharedPreferences;
        context.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                try {
                    sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused) {
                }
                boolean z9 = sharedPreferences.contains("recibir_notificaciones") ? sharedPreferences.getBoolean("recibir_notificaciones", true) : true;
                if (z9) {
                }
            }
            return false;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("recibir_notificaciones")) {
                return sharedPreferences2.getBoolean("recibir_notificaciones", true);
            }
        } catch (Exception unused2) {
        }
        return true;
    }

    public static void b(Context context, int i10) {
        String groupKey;
        if (Build.VERSION.SDK_INT < 24 || i10 <= 0) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        NotificationManager notificationManager = (NotificationManager) systemService;
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        kotlin.jvm.internal.b bVarD = a0.d(activeNotifications);
        while (true) {
            if (!bVarD.hasNext()) {
                groupKey = null;
                break;
            }
            StatusBarNotification statusBarNotification = (StatusBarNotification) bVarD.next();
            if (i10 == statusBarNotification.getId()) {
                groupKey = statusBarNotification.getGroupKey();
                break;
            }
        }
        if (groupKey == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            if (!(i11 < activeNotifications.length)) {
                notificationManager.cancel(i10);
                return;
            }
            int i12 = i11 + 1;
            try {
                StatusBarNotification statusBarNotification2 = activeNotifications[i11];
                if (i10 != statusBarNotification2.getId() && kotlin.jvm.internal.l.a(statusBarNotification2.getGroupKey(), groupKey)) {
                    return;
                } else {
                    i11 = i12;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                com.google.gson.internal.a.o(e.getMessage());
                return;
            }
        }
    }

    public static void c(Context context) {
        Intent intent;
        String string;
        int i10;
        context.getClass();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        q qVar = DownloadWorker.f6738d;
        if (qVar != null) {
            g gVarL = g.f13148u.l(context);
            gVarL.a();
            ArrayList arrayListF = gVarL.F();
            gVarL.b();
            Iterator it = arrayListF.iterator();
            it.getClass();
            int i11 = 0;
            int i12 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                q qVar2 = (q) next;
                if (qVar2.o()) {
                    if (qVar2.i() == 0) {
                        i12++;
                    } else {
                        long j10 = qVar2.h;
                        q qVar3 = DownloadWorker.f6738d;
                        if (qVar3 != null && qVar3.h == j10) {
                            i11++;
                        }
                    }
                }
            }
            int i13 = i11 + i12;
            String str = qVar.f8709n;
            String str2 = context.getResources().getString(R.string.notification_line_downloading) + ' ' + ((str == null || str.length() == 0) ? qVar.f8701b : qVar.f8709n) + " (" + qVar.i() + context.getResources().getString(R.string.percent) + ')';
            String str3 = l1.b.M(context, qVar.j()) + '/' + l1.b.M(context, qVar.k());
            int i14 = qVar.i();
            builder.setOnlyAlertOnce(true);
            builder.setSmallIcon(R.drawable.vector_uptodown_notification);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            builder.setProgress(100, i14, false);
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.addLine(str3);
            if (i12 > 0) {
                String string2 = context.getString(R.string.queue_downloading_counter);
                string2.getClass();
                inboxStyle.addLine(String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i13)}, 1)));
                Intent intent2 = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent2.setAction("CANCEL_ALL");
                intent2.putExtra("download", qVar);
                intent2.putExtra("notificationID", 261);
                builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.dialog_update_all_button_cancel_all), PendingIntent.getBroadcast(context, 0, intent2, h()));
            }
            builder.setStyle(inboxStyle);
            builder.setContentTitle(str2);
            Intent intent3 = new Intent(context, (Class<?>) MyDownloads.class);
            TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(context);
            taskStackBuilderCreate.getClass();
            taskStackBuilderCreate.addParentStack(MyDownloads.class);
            taskStackBuilderCreate.addNextIntent(intent3);
            builder.setContentIntent(taskStackBuilderCreate.getPendingIntent(0, h()));
            if (DownloadWorker.f) {
                intent = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent.setAction("RESUME");
                string = context.getString(R.string.updates_button_resume);
                string.getClass();
                i10 = R.drawable.vector_play_resume;
            } else {
                intent = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent.setAction("PAUSE");
                string = context.getString(R.string.action_pause);
                string.getClass();
                i10 = R.drawable.vector_pause;
            }
            builder.addAction(i10, string, PendingIntent.getBroadcast(context, 0, intent, h()));
            Intent intent4 = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
            intent4.setAction("CANCEL");
            intent4.putExtra("download", qVar);
            intent4.putExtra("notificationID", 261);
            builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.option_button_cancel), PendingIntent.getBroadcast(context, 0, intent4, h()));
        } else {
            builder.setOnlyAlertOnce(true);
            builder.setSmallIcon(R.drawable.vector_uptodown_notification);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            String string3 = context.getString(R.string.preparing_update_download);
            string3.getClass();
            builder.setContentTitle(string3);
        }
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).notify(261, builder.build());
    }

    public static void d(Context context, File file, boolean z9, int i10) {
        Uri uriFromFile;
        ApplicationInfo applicationInfo;
        boolean z10;
        String str;
        Drawable drawableLoadIcon;
        SharedPreferences sharedPreferences;
        context.getClass();
        if (a(context)) {
            try {
                sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            } catch (Exception unused) {
            }
            boolean z11 = sharedPreferences.contains("search_apk_worker_active") ? sharedPreferences.getBoolean("search_apk_worker_active", true) : true;
            if (z11) {
                int i11 = i10 + 260;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(context.getPackageName());
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 24) {
                    uriFromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
                    uriFromFile.getClass();
                } else {
                    uriFromFile = Uri.fromFile(file);
                    uriFromFile.getClass();
                }
                intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                intent.putExtra("notificationId", i11);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i12 >= 31 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
                builder.setSmallIcon(R.drawable.vector_uptodown_notification);
                String name = file.getName();
                name.getClass();
                int i13 = 128;
                if (u.X(name, ".apk", false)) {
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        packageManager.getClass();
                        String absolutePath = file.getAbsolutePath();
                        absolutePath.getClass();
                        PackageInfo packageInfoD = l5.a.d(packageManager, absolutePath, 128);
                        if (packageInfoD != null && (applicationInfo = packageInfoD.applicationInfo) != null) {
                            Drawable drawableLoadIcon2 = applicationInfo.loadIcon(context.getPackageManager());
                            drawableLoadIcon2.getClass();
                            builder.setLargeIcon(f(drawableLoadIcon2));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String name2 = file.getName();
                    name2.getClass();
                    if (u.X(name2, ".xapk", true) || u.X(name2, ".apks", true) || u.X(name2, ".apkm", true)) {
                        Drawable drawable = (Drawable) x4.k.f13628a.get(file.getName());
                        if (drawable == null) {
                            File file2 = new File(context.getExternalFilesDir(null), "tmp");
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            String name3 = file.getName();
                            name3.getClass();
                            String name4 = file.getName();
                            name4.getClass();
                            File file3 = new File(file2, name3.substring(0, o7.m.m0(".", name4, 6)));
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                            if (t3.h.q(file, file3)) {
                                File[] fileArrListFiles = file3.listFiles();
                                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                                    int i14 = 0;
                                    while (i14 < fileArrListFiles.length) {
                                        int i15 = i14 + 1;
                                        try {
                                            File file4 = fileArrListFiles[i14];
                                            String absolutePath2 = file4.getAbsolutePath();
                                            absolutePath2.getClass();
                                            PackageManager packageManager2 = context.getPackageManager();
                                            packageManager2.getClass();
                                            PackageInfo packageInfoD2 = l5.a.d(packageManager2, absolutePath2, i13);
                                            if ((packageInfoD2 != null ? packageInfoD2.applicationInfo : null) != null) {
                                                ApplicationInfo applicationInfo2 = packageInfoD2.applicationInfo;
                                                applicationInfo2.getClass();
                                                applicationInfo2.sourceDir = absolutePath2;
                                                ApplicationInfo applicationInfo3 = packageInfoD2.applicationInfo;
                                                applicationInfo3.getClass();
                                                applicationInfo3.publicSourceDir = absolutePath2;
                                                ApplicationInfo applicationInfo4 = packageInfoD2.applicationInfo;
                                                applicationInfo4.getClass();
                                                drawableLoadIcon = applicationInfo4.loadIcon(context.getPackageManager());
                                            } else {
                                                drawableLoadIcon = null;
                                            }
                                            x4.k.f13628a.put(file.getName(), drawableLoadIcon);
                                            try {
                                                file4.delete();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            drawable = drawableLoadIcon;
                                            i14 = i15;
                                            i13 = 128;
                                        } catch (ArrayIndexOutOfBoundsException e7) {
                                            com.google.gson.internal.a.o(e7.getMessage());
                                            return;
                                        }
                                    }
                                }
                                if (file3.exists()) {
                                    l1.b.w(file3);
                                }
                            }
                        }
                        if (drawable != null) {
                            builder.setLargeIcon(f(drawable));
                        }
                    }
                }
                String name5 = file.getName();
                builder.setContentTitle(name5);
                if (z9) {
                    String string = context.getString(R.string.notification_installable_found);
                    string.getClass();
                    String absolutePath3 = file.getAbsolutePath();
                    absolutePath3.getClass();
                    String absolutePath4 = file.getAbsolutePath();
                    absolutePath4.getClass();
                    str = String.format(string, Arrays.copyOf(new Object[]{absolutePath3.substring(0, o7.m.m0("/", absolutePath4, 6))}, 1));
                    z10 = true;
                } else {
                    String string2 = context.getString(R.string.notification_installable_to_delete);
                    string2.getClass();
                    String absolutePath5 = file.getAbsolutePath();
                    absolutePath5.getClass();
                    String absolutePath6 = file.getAbsolutePath();
                    absolutePath6.getClass();
                    String strSubstring = absolutePath5.substring(0, o7.m.m0("/", absolutePath6, 6));
                    z10 = true;
                    str = String.format(string2, Arrays.copyOf(new Object[]{strSubstring}, 1));
                }
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
                builder.setContentText(str);
                builder.setAutoCancel(z10);
                builder.setGroup("com.uptodown.INSTALLABLE_FOUND");
                Intent intent2 = new Intent(context, (Class<?>) InstallerActivity.class);
                intent2.putExtra("realPath", file.getAbsolutePath());
                intent2.putExtra("action", "delete");
                intent2.putExtra("notificationId", i11);
                PendingIntent activity2 = PendingIntent.getActivity(context, i11, intent2, h());
                StringBuilder sb = new StringBuilder();
                if (z9) {
                    builder.addAction(R.drawable.vector_user_panel_my_apps, context.getString(R.string.option_button_install), activity);
                    builder.setContentIntent(activity);
                    sb.append("install;");
                }
                builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.option_button_delete), activity2);
                sb.append("delete");
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (Build.VERSION.SDK_INT >= 24) {
                    NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN").setContentTitle(str).setSmallIcon(R.drawable.vector_uptodown_notification).setGroup("com.uptodown.INSTALLABLE_FOUND").setAutoCancel(true).setGroupSummary(true);
                    groupSummary.getClass();
                    notificationManager.notify(5, groupSummary.build());
                }
                notificationManager.notify(i11, builder.build());
                k(name5, context, String.valueOf(System.currentTimeMillis()), str, sb.toString(), file.getAbsolutePath());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(android.content.Context r15, h5.h r16, int r17, android.graphics.Bitmap r18, h5.g0 r19) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.i.e(android.content.Context, h5.h, int, android.graphics.Bitmap, h5.g0):void");
    }

    public static Bitmap f(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                bitmap.getClass();
                return bitmap;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.getClass();
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.getClass();
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(android.content.Context r11) {
        /*
            t3.h r0 = v5.g.f13148u
            v5.g r11 = r0.l(r11)
            r11.a()
            r1 = 0
            r2 = 0
            java.lang.String r0 = "notificationId"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Exception -> L3e
            android.database.sqlite.SQLiteDatabase r3 = r11.f13150a     // Catch: java.lang.Exception -> L3e
            r3.getClass()     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = "active_notifications"
            r9 = 0
            r10 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L3e
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L40
            int r0 = r2.getInt(r1)     // Catch: java.lang.Exception -> L3e
        L2b:
            r3 = r0
        L2c:
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L3c
            int r0 = r2.getInt(r1)     // Catch: java.lang.Exception -> L39
            if (r0 <= r3) goto L2c
            goto L2b
        L39:
            r0 = move-exception
            r1 = r3
            goto L44
        L3c:
            r1 = r3
            goto L40
        L3e:
            r0 = move-exception
            goto L44
        L40:
            r2.close()     // Catch: java.lang.Exception -> L3e
            goto L52
        L44:
            r0.printStackTrace()
            if (r2 == 0) goto L52
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L52
            r2.close()
        L52:
            r11.b()
            if (r1 != 0) goto L5a
            r11 = 300(0x12c, float:4.2E-43)
            goto L5c
        L5a:
            int r11 = r1 + 1
        L5c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.i.g(android.content.Context):int");
    }

    public static int h() {
        return Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
    }

    public static void i(Context context, q qVar, String str) {
        String string;
        SharedPreferences sharedPreferences;
        context.getClass();
        if (a(context)) {
            try {
                sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused) {
            }
            boolean z9 = sharedPreferences.contains("download_notification") ? sharedPreferences.getBoolean("download_notification", true) : true;
            if (z9) {
                String str2 = null;
                String str3 = qVar != null ? qVar.f8709n : null;
                if (str3 == null || str3.length() == 0) {
                    String str4 = qVar != null ? qVar.f8701b : null;
                    if (str4 != null && str4.length() != 0) {
                        qVar.getClass();
                        str2 = qVar.f8701b;
                        str2.getClass();
                    }
                } else {
                    qVar.getClass();
                    str2 = qVar.f8709n;
                    str2.getClass();
                }
                String str5 = str2;
                if (str.length() == 0) {
                    string = context.getString(R.string.descarga_error);
                    string.getClass();
                } else {
                    string = context.getString(R.string.descarga_error) + str;
                }
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                NotificationManager notificationManager = (NotificationManager) systemService;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
                builder.setSmallIcon(R.drawable.vector_uptodown_notification);
                if (str5 != null && str5.length() != 0) {
                    builder.setContentTitle(str5);
                }
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string));
                builder.setContentText(string);
                builder.setAutoCancel(true);
                Intent intent = new Intent(context, (Class<?>) MainActivity.class);
                TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(context);
                taskStackBuilderCreate.getClass();
                taskStackBuilderCreate.addParentStack(MainActivity.class);
                taskStackBuilderCreate.addNextIntent(intent);
                builder.setContentIntent(taskStackBuilderCreate.getPendingIntent(0, h()));
                Intent intent2 = new Intent(context, (Class<?>) MyDownloads.class);
                TaskStackBuilder taskStackBuilderCreate2 = TaskStackBuilder.create(context);
                taskStackBuilderCreate2.getClass();
                taskStackBuilderCreate2.addParentStack(MyDownloads.class);
                taskStackBuilderCreate2.addNextIntent(intent2);
                builder.setContentIntent(taskStackBuilderCreate2.getPendingIntent(0, h()));
                notificationManager.notify(257, builder.build());
                k(str5, context, String.valueOf(System.currentTimeMillis()), str, null, null);
            }
        }
    }

    public static void j(Context context, Uri uri) {
        context.getClass();
        String string = context.getString(R.string.app_name);
        string.getClass();
        String string2 = context.getString(R.string.notification_msg_update_uptodown);
        string2.getClass();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(context.getPackageName());
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, h());
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        builder.setSmallIcon(R.drawable.vector_uptodown_notification);
        builder.setContentTitle(string);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string2));
        builder.setContentText(string2);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        ((NotificationManager) systemService).notify(259, builder.build());
        k(string, context, String.valueOf(System.currentTimeMillis()), string2, "update_uptodown", uri.getPath());
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(java.lang.String r3, android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4.getClass()
            t3.h r0 = v5.g.f13148u
            v5.g r4 = r0.l(r4)
            r4.a()
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "timestamp"
            r0.put(r1, r5)
            java.lang.String r5 = "title"
            r0.put(r5, r3)
            java.lang.String r3 = "msg"
            r0.put(r3, r6)
            java.lang.String r3 = "actions"
            r0.put(r3, r7)
            java.lang.String r3 = "extra_info"
            r0.put(r3, r8)
            android.database.sqlite.SQLiteDatabase r3 = r4.f13150a
            r3.getClass()
            java.lang.String r5 = "notifications"
            r6 = 0
            r3.insert(r5, r6, r0)
            r3 = 0
            android.database.sqlite.SQLiteDatabase r7 = r4.f13150a     // Catch: java.lang.Exception -> L59
            r7.getClass()     // Catch: java.lang.Exception -> L59
            java.lang.String r8 = "SELECT COUNT(id) AS count FROM notifications"
            android.database.Cursor r7 = r7.rawQuery(r8, r6)     // Catch: java.lang.Exception -> L59
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Exception -> L4c
            if (r8 == 0) goto L4f
            int r8 = r7.getInt(r3)     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r8 = move-exception
            r0 = r3
            goto L5c
        L4f:
            r8 = r3
        L50:
            r7.close()     // Catch: java.lang.Exception -> L54
            goto L6b
        L54:
            r0 = move-exception
            r2 = r0
            r0 = r8
            r8 = r2
            goto L5c
        L59:
            r8 = move-exception
            r0 = r3
            r7 = r6
        L5c:
            r8.printStackTrace()
            if (r7 == 0) goto L6a
            boolean r8 = r7.isClosed()
            if (r8 != 0) goto L6a
            r7.close()
        L6a:
            r8 = r0
        L6b:
            r7 = 100
            if (r8 <= r7) goto Lad
            android.database.sqlite.SQLiteDatabase r7 = r4.f13150a     // Catch: java.lang.Exception -> L85
            r7.getClass()     // Catch: java.lang.Exception -> L85
            java.lang.String r8 = "SELECT id FROM notifications ORDER BY id DESC LIMIT 100,1"
            android.database.Cursor r6 = r7.rawQuery(r8, r6)     // Catch: java.lang.Exception -> L85
            boolean r7 = r6.moveToFirst()     // Catch: java.lang.Exception -> L85
            if (r7 == 0) goto L87
            int r3 = r6.getInt(r3)     // Catch: java.lang.Exception -> L85
            goto L87
        L85:
            r7 = move-exception
            goto L8b
        L87:
            r6.close()     // Catch: java.lang.Exception -> L85
            goto L99
        L8b:
            r7.printStackTrace()
            if (r6 == 0) goto L99
            boolean r7 = r6.isClosed()
            if (r7 != 0) goto L99
            r6.close()
        L99:
            if (r3 <= 0) goto Lad
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String[] r3 = new java.lang.String[]{r3}
            android.database.sqlite.SQLiteDatabase r6 = r4.f13150a
            r6.getClass()
            java.lang.String r7 = "id<=?"
            r6.delete(r5, r7, r3)
        Lad:
            r4.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.i.k(java.lang.String, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067 A[PHI: r5
      0x0067: PHI (r5v1 long) = (r5v0 long), (r5v16 long) binds: [B:26:0x0056, B:31:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(android.content.Context r22) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.i.l(android.content.Context):void");
    }
}
