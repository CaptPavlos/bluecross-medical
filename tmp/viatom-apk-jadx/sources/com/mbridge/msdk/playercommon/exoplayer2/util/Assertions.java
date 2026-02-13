package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.window.layout.c;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Assertions {
    private Assertions() {
    }

    public static void checkArgument(boolean z9, Object obj) {
        if (!z9) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkIndex(int i10, int i11, int i12) {
        if (i10 < i11 || i10 >= i12) {
            throw new IndexOutOfBoundsException();
        }
        return i10;
    }

    public static void checkMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        c.g("Not in applications main thread");
    }

    public static String checkNotEmpty(@Nullable String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static <T> T checkNotNull(@Nullable T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z9, Object obj) {
        if (!z9) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z9) {
        if (z9) {
            return;
        }
        f.a();
    }

    public static <T> T checkNotNull(@Nullable T t) {
        t.getClass();
        return t;
    }

    public static void checkState(boolean z9) {
        if (z9) {
            return;
        }
        u.e();
    }

    public static String checkNotEmpty(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        f.a();
        return null;
    }
}
