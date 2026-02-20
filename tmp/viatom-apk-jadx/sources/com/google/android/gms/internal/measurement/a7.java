package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a7 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f1876a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f1877b;

    /* renamed from: c, reason: collision with root package name */
    public static final z6 f1878c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1879d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    static {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.a7.<clinit>():void");
    }

    public static void a(Class cls) {
        if (e) {
            f1878c.f2282a.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field declaredField;
        Field declaredField2;
        int i10 = w4.f2246a;
        try {
            declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            declaredField = null;
        }
        if (declaredField != null) {
            return declaredField;
        }
        try {
            declaredField2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField2 = null;
        }
        if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
            return null;
        }
        return declaredField2;
    }

    public static void c(Object obj, long j10, byte b10) {
        Unsafe unsafe = f1878c.f2282a;
        long j11 = (-4) & j10;
        int i10 = unsafe.getInt(obj, j11);
        int i11 = ((~((int) j10)) & 3) << 3;
        unsafe.putInt(obj, j11, ((255 & b10) << i11) | (i10 & (~(255 << i11))));
    }

    public static void d(Object obj, long j10, byte b10) {
        Unsafe unsafe = f1878c.f2282a;
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        unsafe.putInt(obj, j11, ((255 & b10) << i10) | (unsafe.getInt(obj, j11) & (~(255 << i10))));
    }

    public static Object e(Class cls) {
        try {
            return f1876a.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static int f(long j10, Object obj) {
        return f1878c.f2282a.getInt(obj, j10);
    }

    public static void g(Object obj, long j10, int i10) {
        f1878c.f2282a.putInt(obj, j10, i10);
    }

    public static long h(long j10, Object obj) {
        return f1878c.f2282a.getLong(obj, j10);
    }

    public static void i(Object obj, long j10, long j11) {
        f1878c.f2282a.putLong(obj, j10, j11);
    }

    public static Object j(long j10, Object obj) {
        return f1878c.f2282a.getObject(obj, j10);
    }

    public static void k(long j10, Object obj, Object obj2) {
        f1878c.f2282a.putObject(obj, j10, obj2);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new w6());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean m(Class cls) {
        int i10 = w4.f2246a;
        try {
            Class cls2 = f1877b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean n(long j10, Object obj) {
        return ((byte) ((f1878c.f2282a.getInt(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean o(long j10, Object obj) {
        return ((byte) ((f1878c.f2282a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }

    public static int p(Class cls) {
        if (e) {
            return f1878c.f2282a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
