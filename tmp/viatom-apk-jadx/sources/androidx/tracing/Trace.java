package androidx.tracing;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.internal.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Trace {
    static final int MAX_TRACE_LABEL_LENGTH = 127;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    public static void beginAsyncSection(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str), i10);
        } else {
            beginAsyncSectionFallback(truncatedTraceSectionLabel(str), i10);
        }
    }

    private static void beginAsyncSectionFallback(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e) {
            handleException("asyncTraceBegin", e);
        }
    }

    public static void beginSection(@NonNull String str) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(str));
    }

    public static void endAsyncSection(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i10);
        } else {
            endAsyncSectionFallback(truncatedTraceSectionLabel(str), i10);
        }
    }

    private static void endAsyncSectionFallback(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e) {
            handleException("asyncTraceEnd", e);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void forceEnableAppTracing() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                if (sHasAppTracingEnabled) {
                    return;
                }
                sHasAppTracingEnabled = true;
                android.os.Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, Boolean.TRUE);
            } catch (Exception e) {
                handleException("setAppTracingAllowed", e);
            }
        }
    }

    private static void handleException(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            a.j(cause);
            return;
        }
        Log.v(TAG, "Unable to call " + str + " via reflection", exc);
    }

    public static boolean isEnabled() {
        return Build.VERSION.SDK_INT >= 29 ? TraceApi29Impl.isEnabled() : isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e) {
            handleException("isTagEnabled", e);
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(truncatedTraceSectionLabel(str), i10);
        } else {
            setCounterFallback(truncatedTraceSectionLabel(str), i10);
        }
    }

    private static void setCounterFallback(@NonNull String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10));
        } catch (Exception e) {
            handleException("traceCounter", e);
        }
    }

    @NonNull
    private static String truncatedTraceSectionLabel(@NonNull String str) {
        return str.length() <= MAX_TRACE_LABEL_LENGTH ? str : str.substring(0, MAX_TRACE_LABEL_LENGTH);
    }
}
