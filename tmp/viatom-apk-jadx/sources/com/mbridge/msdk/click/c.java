package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static Handler f2795a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String string;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i10 = message.arg1;
                    int i11 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string2 = data.getString("rid");
                        String string3 = data.getString("rid_n");
                        string = data.getString("cid");
                        str = string2;
                        str2 = string3;
                    } else {
                        str = "";
                        str2 = str;
                        string = str2;
                    }
                    new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().c()).a(i10, i11, str, str2, string);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    };

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        r0 = r1.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
    
        return a(a(a(a(r5, r0.a(), java.lang.String.valueOf(com.mbridge.msdk.foundation.tools.ab.h(com.mbridge.msdk.foundation.controller.c.m().c()))), r0.b(), java.lang.String.valueOf(com.mbridge.msdk.foundation.tools.ab.j(com.mbridge.msdk.foundation.controller.c.m().c()))), r0.c(), r6), r0.d(), r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L9f
            if (r0 == 0) goto L8
            goto La1
        L8:
            android.net.Uri r0 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L9f
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L9f
            java.lang.String r2 = r2.k()     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.c.g r1 = r1.b(r2)     // Catch: java.lang.Exception -> L9f
            if (r1 == 0) goto La1
            java.util.Map r1 = r1.s()     // Catch: java.lang.Exception -> L9f
            if (r1 == 0) goto La1
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L9f
            if (r2 != 0) goto La1
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Exception -> L9f
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L9f
        L36:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L9f
            if (r3 == 0) goto La1
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L9f
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Exception -> L9f
            java.lang.Object r3 = r3.getKey()     // Catch: java.lang.Exception -> L9f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L9f
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L9f
            if (r4 != 0) goto L36
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Exception -> L9f
            if (r4 == 0) goto L36
            java.lang.Object r0 = r1.get(r3)     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.c.b$a r0 = (com.mbridge.msdk.c.b.a) r0     // Catch: java.lang.Exception -> L9f
            if (r0 == 0) goto La1
            java.util.List r1 = r0.a()     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L9f
            android.content.Context r2 = r2.c()     // Catch: java.lang.Exception -> L9f
            int r2 = com.mbridge.msdk.foundation.tools.ab.h(r2)     // Catch: java.lang.Exception -> L9f
            float r2 = (float) r2     // Catch: java.lang.Exception -> L9f
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L9f
            java.lang.String r5 = a(r5, r1, r2)     // Catch: java.lang.Exception -> L9f
            java.util.List r1 = r0.b()     // Catch: java.lang.Exception -> L9f
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L9f
            android.content.Context r2 = r2.c()     // Catch: java.lang.Exception -> L9f
            int r2 = com.mbridge.msdk.foundation.tools.ab.j(r2)     // Catch: java.lang.Exception -> L9f
            float r2 = (float) r2     // Catch: java.lang.Exception -> L9f
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L9f
            java.lang.String r5 = a(r5, r1, r2)     // Catch: java.lang.Exception -> L9f
            java.util.List r1 = r0.c()     // Catch: java.lang.Exception -> L9f
            java.lang.String r5 = a(r5, r1, r6)     // Catch: java.lang.Exception -> L9f
            java.util.List r6 = r0.d()     // Catch: java.lang.Exception -> L9f
            java.lang.String r5 = a(r5, r6, r7)     // Catch: java.lang.Exception -> L9f
            return r5
        L9f:
            r6 = move-exception
            goto La2
        La1:
            return r5
        La2:
            r6.printStackTrace()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.c.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void b(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> listQueryIntentActivities;
        ResolveInfo next;
        try {
            if (TextUtils.isEmpty(str) || !c(context, str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) == null || listQueryIntentActivities.size() <= 0 || (next = listQueryIntentActivities.iterator().next()) == null) {
                return;
            }
            ActivityInfo activityInfo = next.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            if (com.mbridge.msdk.e.b.a()) {
                Toast.makeText(context, "The app connot start up", 0).show();
            }
            e.printStackTrace();
        }
    }

    public static boolean c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void d(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean e(Context context, String str) {
        Intent intent;
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri uri = Uri.parse(str);
                if (uri.getScheme().equals("intent")) {
                    intent = Intent.parseUri(str, 1);
                } else if (uri.getScheme().equals("android-app")) {
                    intent = Intent.parseUri(str, 2);
                } else {
                    intent = new Intent("android.intent.action.VIEW", uri);
                    intent.setData(uri);
                }
                if (intent != null) {
                    intent.setComponent(null);
                    intent.setSelector(null);
                    if (a(context, intent)) {
                        return true;
                    }
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    public static void f(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            int i10 = MBCommonActivity.f2632d;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            intent.putExtra("url", str);
            if (!(context instanceof ContextThemeWrapper)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            af.b("CommonClickUtil", e.getMessage());
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage());
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        return true;
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z9 = listQueryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    a(context, "market://details?id=" + str.replace("https://play.google.com/store/apps/details?id=", ""));
                    return;
                }
                return;
            }
            if (!z9) {
                d(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""));
                return;
            }
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
            }
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
                d(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""));
            }
        } catch (Exception e) {
            af.b("CommonClickUtil", "Exception", e);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage(), th);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return true;
        }
        if (com.mbridge.msdk.foundation.controller.c.m().e() != null) {
            Context contextE = com.mbridge.msdk.foundation.controller.c.m().e();
            if (!(contextE instanceof Activity)) {
                return false;
            }
            contextE.startActivity(intent);
            return true;
        }
        return false;
    }

    public static void a(final Context context, int i10, final String str) {
        if (i10 == 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.click.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Method method = u.class.getMethod("mia", Context.class, String.class);
                        Context context2 = context;
                        if (context2 != null) {
                            method.invoke(null, context2, str);
                        } else {
                            af.b("CommonClickUtil", "Context is null");
                        }
                    } catch (Throwable th) {
                        af.b("CommonClickUtil", th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            af.b("CommonClickUtil", th.getMessage());
        }
    }
}
