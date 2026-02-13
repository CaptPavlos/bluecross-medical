package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o7 {

    /* renamed from: a, reason: collision with root package name */
    public static final o4 f2122a;

    /* renamed from: b, reason: collision with root package name */
    public static final o4 f2123b;

    static {
        p4 p4Var = new p4(n4.a(), true, true);
        p4Var.l("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        p4Var.l("measurement.set_default_event_parameters_with_backfill.service", true);
        p4Var.k(0L, "measurement.id.set_default_event_parameters.fix_service_request_ordering");
        f2122a = p4Var.l("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f2123b = p4Var.l("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        p4Var.l("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }
}
