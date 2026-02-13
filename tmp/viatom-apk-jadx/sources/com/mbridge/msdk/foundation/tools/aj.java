package com.mbridge.msdk.foundation.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class aj extends m {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f3945a = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3946b = false;

    /* renamed from: c, reason: collision with root package name */
    public static LinearLayout f3947c;

    public static void a(Campaign campaign, ViewGroup viewGroup, int i10, int i11) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() == 8 && campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                if (viewGroup == null) {
                    af.d("SDKUtil", "show linkType==8 loading view failed. viewGroup is null");
                    return;
                }
                try {
                    if (f3947c == null) {
                        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (contextC instanceof Activity) {
                            f3947c = (LinearLayout) LayoutInflater.from(contextC.getApplicationContext()).inflate(x.a(contextC.getApplicationContext(), "mbridge_cm_loading_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        } else {
                            f3947c = (LinearLayout) LayoutInflater.from(contextC).inflate(x.a(contextC, "mbridge_cm_loading_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        }
                    }
                    int iMin = Math.min(viewGroup.getWidth(), viewGroup.getHeight());
                    int iMin2 = Math.min(Math.max(iMin / 4, 70), iMin);
                    if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin2, iMin2);
                        layoutParams.gravity = 17;
                        at.a(f3947c);
                        viewGroup.addView(f3947c, layoutParams);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iMin2, iMin2);
                    if (i11 == 0 && i10 == 0) {
                        layoutParams2.addRule(13);
                    } else {
                        layoutParams2.leftMargin = i11;
                        layoutParams2.topMargin = i10;
                    }
                    at.a(f3947c);
                    viewGroup.addView(f3947c, layoutParams2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(Campaign campaign, ViewGroup viewGroup) {
        a(campaign, viewGroup, 0, 0);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {
        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> listA = a(context);
                if (listA != null && listA.size() > 0) {
                    if (!a(str)) {
                        str = c(str) ? "market://".concat(str.substring(str.indexOf("details?id="))) : null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    Intent intentB = b(context);
                    intentB.setData(Uri.parse(str));
                    intentB.addFlags(268435456);
                    Iterator<ResolveInfo> it = listA.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                            intentB.setPackage("com.android.vending");
                            break;
                        }
                    }
                    context.startActivity(intentB);
                    aj.a(nativeTrackingListener);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        public static boolean b(String str) {
            return a(str) || c(str);
        }

        private static boolean c(String str) {
            Uri uri;
            try {
                if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getHost())) {
                    return false;
                }
                if (uri.getHost().equals("play.google.com")) {
                    return true;
                }
                return uri.getHost().equals("market.android.com");
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        private static Intent b(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        private static List<ResolveInfo> a(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(b(context), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static boolean a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                af.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static void a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z9 = listQueryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    a(context, "market://details?id=" + str.replace("https://play.google.com/store/apps/details?id=", ""), nativeTrackingListener);
                    return;
                }
                return;
            }
            if (!z9) {
                a(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""), (BaseTrackingListener) nativeTrackingListener);
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
                a(nativeTrackingListener);
            } catch (Exception unused) {
                a(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""), (BaseTrackingListener) nativeTrackingListener);
            }
        } catch (Exception e) {
            af.b("SDKUtil", e.getMessage());
        }
    }

    public static void a(Campaign campaign, ViewGroup viewGroup) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() == 8 && campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                if (viewGroup == null) {
                    af.d("SDKUtil", "hide linkType==8 loading view failed. viewGroup is null");
                    return;
                }
                try {
                    LinearLayout linearLayout = f3947c;
                    if (linearLayout == null) {
                        return;
                    }
                    viewGroup.removeView(linearLayout);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener) {
        a(context, str, baseTrackingListener, (CampaignEx) null, new ArrayList());
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        Intent intent;
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        if (list != null) {
            list.add("web_view");
        }
        if (f3946b) {
            a(context, str, nativeTrackingListener, campaignEx, list);
            return;
        }
        try {
            int i10 = MBCommonActivity.f2632d;
            intent = new Intent(context, (Class<?>) MBCommonActivity.class);
        } catch (Exception unused) {
            eVar.a("result", 2);
            a(context, str, nativeTrackingListener, campaignEx, list);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a.a(str)) {
            str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
        }
        intent.putExtra("url", str);
        af.c("url", "webview url = " + str);
        intent.setFlags(268435456);
        intent.putExtra("mvcommon", campaignEx);
        context.startActivity(intent);
        eVar.a("result", 1);
        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
        if (list != null) {
            eVar.a("click_path", list.toString());
        }
        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000150", campaignEx, eVar);
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener, CampaignEx campaignEx, List<String> list) {
        if (str == null || context == null) {
            return;
        }
        if (list != null) {
            list.add("browser");
        }
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        try {
            if (a.a(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setComponent(null);
            intent.setSelector(null);
            intent.addFlags(268435456);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
            a(baseTrackingListener);
            eVar.a("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(baseTrackingListener);
                eVar.a("result", 1);
            } catch (Exception e3) {
                e3.printStackTrace();
                eVar.a("result", 2);
            }
        }
        try {
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 5);
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000150", campaignEx, eVar);
        } catch (Exception unused) {
        }
    }

    public static void a(BaseTrackingListener baseTrackingListener) {
        if (baseTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) baseTrackingListener).onLeaveApp();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r10, java.lang.String r11, com.mbridge.msdk.foundation.entity.CampaignEx r12, com.mbridge.msdk.click.a r13, com.mbridge.msdk.out.BaseTrackingListener r14, java.util.List<java.lang.String> r15) {
        /*
            java.lang.String r1 = "result"
            com.mbridge.msdk.foundation.same.report.d.e r2 = new com.mbridge.msdk.foundation.same.report.d.e
            r2.<init>()
            r0 = 9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "type"
            r2.a(r3, r0)
            com.mbridge.msdk.foundation.webview.BrowserView r8 = new com.mbridge.msdk.foundation.webview.BrowserView     // Catch: java.lang.Exception -> L47
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L47
            android.content.Context r0 = r0.c()     // Catch: java.lang.Exception -> L47
            r8.<init>(r0, r12)     // Catch: java.lang.Exception -> L47
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams     // Catch: java.lang.Exception -> L47
            int r3 = com.mbridge.msdk.foundation.tools.ab.j(r10)     // Catch: java.lang.Exception -> L47
            int r4 = com.mbridge.msdk.foundation.tools.ab.h(r10)     // Catch: java.lang.Exception -> L47
            r0.<init>(r3, r4)     // Catch: java.lang.Exception -> L47
            r8.setLayoutParams(r0)     // Catch: java.lang.Exception -> L47
            com.mbridge.msdk.foundation.webview.a r4 = new com.mbridge.msdk.foundation.webview.a     // Catch: java.lang.Exception -> L47
            r5 = r10
            r6 = r12
            r7 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L44
            r8.setListener(r4)     // Catch: java.lang.Exception -> L44
            r8.loadUrl(r11)     // Catch: java.lang.Exception -> L44
            java.lang.String r10 = "1"
            r2.a(r1, r10)     // Catch: java.lang.Exception -> L44
            goto L58
        L44:
            r0 = move-exception
        L45:
            r10 = r0
            goto L4a
        L47:
            r0 = move-exception
            r6 = r12
            goto L45
        L4a:
            java.lang.String r11 = "SDKUtil"
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r11, r10)
            java.lang.String r10 = "2"
            r2.a(r1, r10)
        L58:
            if (r15 == 0) goto L63
            java.lang.String r10 = "click_path"
            java.lang.String r11 = r15.toString()
            r2.a(r10, r11)
        L63:
            com.mbridge.msdk.foundation.same.report.d.d r10 = com.mbridge.msdk.foundation.same.report.d.d.a()
            java.lang.String r11 = "2000150"
            r10.a(r11, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.aj.a(android.content.Context, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.a, com.mbridge.msdk.out.BaseTrackingListener, java.util.List):void");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File fileB = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf("/") == -1) {
                str2 = str.hashCode() + "";
            } else {
                str2 = (str.substring(str.lastIndexOf("/") + 1).hashCode() + str.hashCode()) + "";
            }
        }
        return new File(fileB, str2).getAbsolutePath();
    }
}
