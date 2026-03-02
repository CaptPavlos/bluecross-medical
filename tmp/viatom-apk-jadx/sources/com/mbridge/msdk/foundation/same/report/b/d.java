package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f3792b;

    /* renamed from: a, reason: collision with root package name */
    Handler f3793a = new Handler() { // from class: com.mbridge.msdk.foundation.same.report.b.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            HashMap map;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) d.this.f3794c.get()) != null) {
                Object obj = message.obj;
                if (!(obj instanceof HashMap) || (map = (HashMap) obj) == null) {
                    return;
                }
                new h(context).a((String) map.get("crashinfo"), (File) map.get("file"));
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<Context> f3794c;

    /* renamed from: d, reason: collision with root package name */
    private Throwable f3795d;
    private Thread.UncaughtExceptionHandler e;

    private d(Context context) {
        this.f3794c = new WeakReference<>(context);
    }

    private String a(Throwable th, String str) {
        try {
            JSONObject jSONObjectB = b(str);
            if (jSONObjectB == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            jSONObjectB.put("crashinfo", stringWriter.toString());
            String string = jSONObjectB.toString();
            StringBuffer stringBuffer = new StringBuffer("key=2000052");
            stringBuffer.append("&crash_first_index_from_mtg=");
            stringBuffer.append(c.b(th.getStackTrace()));
            stringBuffer.append("&exception=" + string);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> map = new HashMap<>();
        if (this.f3795d == null) {
            return null;
        }
        String strA = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
        File file = new File(a3.a.C(strA, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(strA + "/sdkcrash" + str + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.f3795d, str));
            printWriter.println("====");
            this.f3795d.printStackTrace(printWriter);
            printWriter.close();
            map.put("file", file2);
            map.put("time", str);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final JSONObject b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = this.f3794c.get();
        if (context == null) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long usableSpace = externalStorageDirectory.getUsableSpace();
        long totalSpace = externalStorageDirectory.getTotalSpace();
        String fileSize = Formatter.formatFileSize(context, usableSpace);
        String fileSize2 = Formatter.formatFileSize(context, totalSpace);
        jSONObject.put("max_memory", String.valueOf((float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d)));
        jSONObject.put("memoryby_app", String.valueOf((float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d)));
        jSONObject.put("remaining_memory", (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d));
        jSONObject.put("sdcard_remainder", fileSize);
        jSONObject.put("totalspacestr", fileSize2);
        jSONObject.put("crashtime", str);
        String strA = com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID);
        if (!TextUtils.isEmpty(strA)) {
            jSONObject.put("appid", strA);
        }
        try {
            jSONObject.put("osversion", Build.VERSION.SDK_INT);
            jSONObject.put("appversioncode", d(context));
            jSONObject.put("appversionname", b(context));
            jSONObject.put("appname", c(context));
            return jSONObject;
        } catch (Exception unused) {
            jSONObject.put("osversion", 0);
            jSONObject.put("appversioncode", "-1");
            jSONObject.put("appversionname", "-1");
            jSONObject.put("appname", "");
            return jSONObject;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws InterruptedException {
        f.a().b();
        try {
            this.f3795d = th;
            String strA = a();
            List<String> listA = a(strA);
            if (listA.size() <= 0) {
                a(a(th), strA, th, thread);
                return;
            }
            for (int i10 = 0; i10 < listA.size(); i10++) {
                a(a(th), listA.get(i10), th, thread);
            }
        } catch (Exception e) {
            a(thread, th);
            e.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (f3792b == null) {
            synchronized (d.class) {
                try {
                    if (f3792b == null) {
                        f3792b = new d(context);
                    }
                } finally {
                }
            }
        }
        return f3792b;
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static String a() {
        try {
            g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = i.a();
            }
            String strV = gVarB.V();
            return TextUtils.isEmpty(strV) ? "<mvpackage>mbridge</mvpackage>" : strV;
        } catch (Exception unused) {
            return "<mvpackage>mbridge</mvpackage>";
        }
    }

    public static List<String> a(String str) {
        try {
            List<String> listA = a(str, "<mvpackage>(.*?)</mvpackage>");
            return listA == null ? new ArrayList() : listA;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) throws InterruptedException {
        if (str.contains(str2)) {
            HashMap<String, Object> mapC = c();
            if (mapC == null || mapC.get("file") == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            HashMap map = new HashMap();
            map.put("crashinfo", a(th, (String) mapC.get("time")));
            map.put("file", mapC.get("file"));
            messageObtain.obj = map;
            messageObtain.what = 101;
            this.f3793a.sendMessage(messageObtain);
            a(thread, th);
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void a(Thread thread, Throwable th) throws InterruptedException {
        try {
            Thread.sleep(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    private String c(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("", e.getMessage());
            return "";
        }
    }

    public final void b() {
        this.e = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
}
