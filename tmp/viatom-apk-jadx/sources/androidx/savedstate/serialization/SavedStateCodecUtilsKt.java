package androidx.savedstate.serialization;

import e8.e;
import g8.b0;
import g8.b1;
import g8.c;
import g8.c0;
import g8.f;
import g8.h0;
import g8.m;
import g8.q;
import g8.u0;
import g8.v;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateCodecUtilsKt {
    private static final e booleanArrayDescriptor;
    private static final e charArrayDescriptor;
    private static final e doubleArrayDescriptor;
    private static final e floatArrayDescriptor;
    private static final e intArrayDescriptor;
    private static final e intListDescriptor;
    private static final e longArrayDescriptor;
    private static final e stringArrayDescriptor;
    private static final e stringListDescriptor;

    static {
        c0 c0Var = c0.f8244a;
        u0 u0Var = c0.f8245b;
        u0Var.getClass();
        intListDescriptor = new c(u0Var, 1);
        b1 b1Var = b1.f8241a;
        u0 u0Var2 = b1.f8242b;
        u0Var2.getClass();
        stringListDescriptor = new c(u0Var2, 1);
        booleanArrayDescriptor = f.f8260c.f8330b;
        charArrayDescriptor = m.f8293c.f8330b;
        doubleArrayDescriptor = q.f8313c.f8330b;
        floatArrayDescriptor = v.f8335c.f8330b;
        intArrayDescriptor = b0.f8240c.f8330b;
        longArrayDescriptor = h0.f8271c.f8330b;
        y.a(String.class);
        e descriptor = b1Var.getDescriptor();
        descriptor.getClass();
        stringArrayDescriptor = new c(descriptor, 0);
    }

    public static final e getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final e getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final e getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final e getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final e getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final e getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final e getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final e getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static final e getStringListDescriptor() {
        return stringListDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }
}
