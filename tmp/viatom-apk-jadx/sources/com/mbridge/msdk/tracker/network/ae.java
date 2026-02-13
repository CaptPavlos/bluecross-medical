package com.mbridge.msdk.tracker.network;

import android.util.Log;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    public static String f5387a = "TrackManager_Volley";

    /* renamed from: b, reason: collision with root package name */
    private static final String f5388b = "com.mbridge.msdk.tracker.network.ae";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<C0061a> f5389a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5390b;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        /* renamed from: com.mbridge.msdk.tracker.network.ae$a$a, reason: collision with other inner class name */
        public static class C0061a {

            /* renamed from: a, reason: collision with root package name */
            public final String f5391a;

            /* renamed from: b, reason: collision with root package name */
            public final long f5392b;

            /* renamed from: c, reason: collision with root package name */
            public final long f5393c;
        }

        public final void finalize() throws Throwable {
            if (this.f5390b) {
                return;
            }
            this.f5390b = true;
            long j10 = this.f5389a.size() == 0 ? 0L : ((C0061a) a3.a.e(1, this.f5389a)).f5393c - this.f5389a.get(0).f5393c;
            if (j10 > 0) {
                long j11 = this.f5389a.get(0).f5393c;
                ae.b("(%-4d ms) %s", Long.valueOf(j10), "Request on the loose");
                for (C0061a c0061a : this.f5389a) {
                    long j12 = c0061a.f5393c;
                    ae.b("(+%-4d) [%2d] %s", Long.valueOf(j12 - j11), Long.valueOf(c0061a.f5392b), c0061a.f5391a);
                    j11 = j12;
                }
            }
            ae.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f5387a, d(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f5387a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f5387a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String string;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i10 = 2;
        while (true) {
            if (i10 >= stackTrace.length) {
                string = "<unknown>";
                break;
            }
            if (!stackTrace[i10].getClassName().equals(f5388b)) {
                String className = stackTrace[i10].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder sbW = a3.a.w(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".");
                sbW.append(stackTrace[i10].getMethodName());
                string = sbW.toString();
                break;
            }
            i10++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(string);
        return a3.a.o(sb, ": ", str);
    }

    public static void a(String str, Object... objArr) {
    }
}
