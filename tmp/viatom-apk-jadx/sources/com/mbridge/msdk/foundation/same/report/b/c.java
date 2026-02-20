package com.mbridge.msdk.foundation.same.report.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f3787a;

    /* renamed from: b, reason: collision with root package name */
    private static long f3788b;

    public static /* synthetic */ void a(String str, StackTraceElement[] stackTraceElementArr) throws JSONException {
        try {
            JSONObject jSONObjectB = d.a(com.mbridge.msdk.foundation.controller.c.m().c()).b(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
            jSONObjectB.put("crashinfo", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", jSONObjectB.toString());
            jSONObject.put("crash_first_index_from_mtg", b(stackTraceElementArr));
            e eVar = new e("m_anr_report");
            eVar.a(jSONObject);
            eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
            eVar.a(0);
            eVar.b(1);
            f.a().d().a(eVar);
        } catch (JSONException e) {
            af.b("AnrMonitorManager", "reportANRByEventLibrary anr failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : d.a(d.a())) {
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean c(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.toString())) {
                        String string = stackTraceElement.toString();
                        if (TextUtils.isEmpty(string) || (!string.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !string.contains("com.google") && !string.contains("java.lang") && !string.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !string.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_APP))) {
                            arrayList.add(string);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return false;
                }
                return b((String) arrayList.get(0));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("AnrMonitorManager", "isMBridgeFirst exception", e);
                }
            }
        }
        return false;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements com.mbridge.msdk.foundation.same.report.b.a {
        @Override // com.mbridge.msdk.foundation.same.report.b.a
        public final void a(final String str, final StackTraceElement[] stackTraceElementArr) {
            if (MBridgeConstans.DEBUG) {
                androidx.constraintlayout.core.widgets.analyzer.a.E("onAnrHappened: ", str, "AnrMonitorManager");
            }
            if (!c.b(str)) {
                af.a("AnrMonitorManager", "onAnrHappened: can track false");
                return;
            }
            long unused = c.f3788b = System.currentTimeMillis();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.b.c.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c.a(str, stackTraceElementArr);
                    } catch (Exception e) {
                        af.b("AnrMonitorManager", "handler anr failed", e);
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.same.report.b.a
        public final void a() {
        }
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        return c(stackTraceElementArr) ? "1" : "0";
    }

    private static boolean b() {
        try {
            return ah.a().a("anr_monitor_available", false);
        } catch (Exception e) {
            af.b("AnrMonitorManager", "get anr monitor available failed", e);
            return false;
        }
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\r\n");
                    }
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void a() {
        if (!b()) {
            af.a("AnrMonitorManager", "anr monitor is not available");
            return;
        }
        try {
            b.a().a(c(), new a()).start();
        } catch (Exception e) {
            af.b("AnrMonitorManager", "start anr monitor failed", e);
        }
    }

    private static int c() {
        try {
            int iA = ah.a().a("anr_check_timeout", DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
            return iA <= 0 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS : iA;
        } catch (Exception e) {
            af.b("AnrMonitorManager", "get anr check timeout failed", e);
            return DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
        }
    }
}
