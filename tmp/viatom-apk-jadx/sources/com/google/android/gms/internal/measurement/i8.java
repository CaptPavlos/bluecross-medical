package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i8 {

    /* renamed from: a, reason: collision with root package name */
    public static final o4 f2002a;

    /* renamed from: b, reason: collision with root package name */
    public static final o4 f2003b;

    /* renamed from: c, reason: collision with root package name */
    public static final o4 f2004c;

    /* renamed from: d, reason: collision with root package name */
    public static final o4 f2005d;
    public static final o4 e;
    public static final o4 f;

    static {
        p4 p4Var = new p4(n4.a(), true, true);
        f2002a = p4Var.l("measurement.test.boolean_flag", false);
        f2003b = p4Var.k(-1L, "measurement.test.cached_long_flag");
        Double dValueOf = Double.valueOf(-3.0d);
        Object obj = o4.g;
        f2004c = new o4(p4Var, "measurement.test.double_flag", dValueOf, 2);
        f2005d = p4Var.k(-2L, "measurement.test.int_flag");
        e = p4Var.k(-1L, "measurement.test.long_flag");
        f = p4Var.m("measurement.test.string_flag", "---");
    }
}
