package com.google.android.gms.internal.measurement;

import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k7 {
    public static final o4 A;
    public static final o4 B;
    public static final o4 C;
    public static final o4 D;
    public static final o4 E;
    public static final o4 F;
    public static final o4 G;
    public static final o4 H;
    public static final o4 I;
    public static final o4 J;
    public static final o4 K;
    public static final o4 L;
    public static final o4 M;
    public static final o4 N;
    public static final o4 O;
    public static final o4 P;
    public static final o4 Q;
    public static final o4 R;
    public static final o4 S;
    public static final o4 T;
    public static final o4 U;
    public static final o4 V;
    public static final o4 W;
    public static final o4 X;
    public static final o4 Y;
    public static final o4 Z;

    /* renamed from: a, reason: collision with root package name */
    public static final o4 f2024a;

    /* renamed from: a0, reason: collision with root package name */
    public static final o4 f2025a0;

    /* renamed from: b, reason: collision with root package name */
    public static final o4 f2026b;

    /* renamed from: b0, reason: collision with root package name */
    public static final o4 f2027b0;

    /* renamed from: c, reason: collision with root package name */
    public static final o4 f2028c;

    /* renamed from: c0, reason: collision with root package name */
    public static final o4 f2029c0;

    /* renamed from: d, reason: collision with root package name */
    public static final o4 f2030d;

    /* renamed from: d0, reason: collision with root package name */
    public static final o4 f2031d0;
    public static final o4 e;

    /* renamed from: e0, reason: collision with root package name */
    public static final o4 f2032e0;
    public static final o4 f;

    /* renamed from: f0, reason: collision with root package name */
    public static final o4 f2033f0;
    public static final o4 g;

    /* renamed from: g0, reason: collision with root package name */
    public static final o4 f2034g0;
    public static final o4 h;

    /* renamed from: h0, reason: collision with root package name */
    public static final o4 f2035h0;

    /* renamed from: i, reason: collision with root package name */
    public static final o4 f2036i;

    /* renamed from: i0, reason: collision with root package name */
    public static final o4 f2037i0;

    /* renamed from: j, reason: collision with root package name */
    public static final o4 f2038j;

    /* renamed from: j0, reason: collision with root package name */
    public static final o4 f2039j0;

    /* renamed from: k, reason: collision with root package name */
    public static final o4 f2040k;

    /* renamed from: k0, reason: collision with root package name */
    public static final o4 f2041k0;

    /* renamed from: l, reason: collision with root package name */
    public static final o4 f2042l;
    public static final o4 l0;

    /* renamed from: m, reason: collision with root package name */
    public static final o4 f2043m;

    /* renamed from: m0, reason: collision with root package name */
    public static final o4 f2044m0;

    /* renamed from: n, reason: collision with root package name */
    public static final o4 f2045n;

    /* renamed from: n0, reason: collision with root package name */
    public static final o4 f2046n0;

    /* renamed from: o, reason: collision with root package name */
    public static final o4 f2047o;

    /* renamed from: o0, reason: collision with root package name */
    public static final o4 f2048o0;

    /* renamed from: p, reason: collision with root package name */
    public static final o4 f2049p;

    /* renamed from: p0, reason: collision with root package name */
    public static final o4 f2050p0;

    /* renamed from: q, reason: collision with root package name */
    public static final o4 f2051q;

    /* renamed from: q0, reason: collision with root package name */
    public static final o4 f2052q0;

    /* renamed from: r, reason: collision with root package name */
    public static final o4 f2053r;

    /* renamed from: r0, reason: collision with root package name */
    public static final o4 f2054r0;

    /* renamed from: s, reason: collision with root package name */
    public static final o4 f2055s;

    /* renamed from: s0, reason: collision with root package name */
    public static final o4 f2056s0;
    public static final o4 t;

    /* renamed from: t0, reason: collision with root package name */
    public static final o4 f2057t0;

    /* renamed from: u, reason: collision with root package name */
    public static final o4 f2058u;

    /* renamed from: u0, reason: collision with root package name */
    public static final o4 f2059u0;

    /* renamed from: v, reason: collision with root package name */
    public static final o4 f2060v;

    /* renamed from: v0, reason: collision with root package name */
    public static final o4 f2061v0;

    /* renamed from: w, reason: collision with root package name */
    public static final o4 f2062w;

    /* renamed from: w0, reason: collision with root package name */
    public static final o4 f2063w0;

    /* renamed from: x, reason: collision with root package name */
    public static final o4 f2064x;
    public static final o4 y;

    /* renamed from: z, reason: collision with root package name */
    public static final o4 f2065z;

    static {
        p4 p4Var = new p4(n4.a(), true, true);
        f2024a = p4Var.k(WorkRequest.MIN_BACKOFF_MILLIS, "measurement.ad_id_cache_time");
        f2026b = p4Var.k(3600000L, "measurement.app_uninstalled_additional_ad_id_cache_time");
        f2028c = p4Var.l("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f2030d = p4Var.k(100L, "measurement.max_bundles_per_iteration");
        e = p4Var.m("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        f = p4Var.k(86400000L, "measurement.config.cache_time");
        p4Var.m("measurement.log_tag", "FA");
        g = p4Var.m("measurement.config.url_authority", "app-measurement.com");
        h = p4Var.m("measurement.config.url_scheme", "https");
        f2036i = p4Var.k(1000L, "measurement.upload.debug_upload_interval");
        p4Var.l("measurement.config.default_flag_values", true);
        f2038j = p4Var.k(3600000L, "measurement.session.engagement_interval");
        f2040k = p4Var.m("measurement.rb.attribution.event_params", "value|currency");
        f2042l = p4Var.m("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        f2043m = p4Var.k(605000L, "measurement.upload.google_signal_max_queue_time");
        f2045n = p4Var.m("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        p4Var.k(0L, "measurement.id.upload.max_conversions_per_day");
        f2047o = p4Var.k(4L, "measurement.lifetimevalue.max_currency_tracked");
        f2049p = p4Var.k(1L, "measurement.dma_consent.max_daily_dcu_realtime_events");
        f2051q = p4Var.k(500L, "measurement.upload.max_event_parameter_value_length");
        f2053r = p4Var.k(100000L, "measurement.store.max_stored_events_per_app");
        f2055s = p4Var.k(50L, "measurement.experiment.max_ids");
        t = p4Var.k(200L, "measurement.audience.filter_result_max_count");
        f2058u = p4Var.k(27L, "measurement.upload.max_item_scoped_custom_parameters");
        f2060v = p4Var.k(1000L, "measurement.rb.max_trigger_registrations_per_day");
        f2062w = p4Var.k(0L, "measurement.rb.attribution.max_trigger_uris_queried_at_once");
        f2064x = p4Var.k(7L, "measurement.rb.attribution.client.min_ad_services_version");
        y = p4Var.k(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, "measurement.alarm_manager.minimum_interval");
        f2065z = p4Var.k(500L, "measurement.upload.minimum_delay");
        A = p4Var.k(86400000L, "measurement.monitoring.sample_period_millis");
        B = p4Var.k(3000L, "measurement.rb.attribution.notify_app_delay_millis");
        C = p4Var.l("measurement.config.notify_trigger_uris_on_backgrounded", true);
        D = p4Var.m("measurement.rb.attribution.app_allowlist", "");
        E = p4Var.k(WorkRequest.MIN_BACKOFF_MILLIS, "measurement.upload.realtime_upload_interval");
        F = p4Var.k(604800000L, "measurement.upload.refresh_blacklisted_config_interval");
        p4Var.k(3600000L, "measurement.config.cache_time.service");
        G = p4Var.k(5000L, "measurement.service_client.idle_disconnect_millis");
        p4Var.m("measurement.log_tag.service", "FA-SVC");
        H = p4Var.k(1000L, "measurement.service_client.reconnect_millis");
        p4Var.m("measurement.sgtm.app_allowlist", "*");
        I = p4Var.k(240000L, "measurement.sgtm.batch.long_queuing_threshold");
        J = p4Var.k(1800000L, "measurement.sgtm.batch.retry_interval");
        K = p4Var.k(10L, "measurement.sgtm.batch.retry_max_count");
        L = p4Var.k(21600000L, "measurement.sgtm.batch.retry_max_wait");
        M = p4Var.m("measurement.sgtm.service_upload_apps_list", "");
        N = p4Var.m("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        O = p4Var.k(5L, "measurement.sgtm.upload.batches_retrieval_limit");
        P = p4Var.k(5000L, "measurement.sgtm.upload.max_queued_batches");
        Q = p4Var.k(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS, "measurement.sgtm.upload.min_delay_after_background");
        R = p4Var.k(1000L, "measurement.sgtm.upload.min_delay_after_broadcast");
        S = p4Var.k(5000L, "measurement.sgtm.upload.min_delay_after_startup");
        T = p4Var.k(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS, "measurement.sgtm.upload.retry_interval");
        U = p4Var.k(21600000L, "measurement.sgtm.upload.retry_max_wait");
        V = p4Var.k(86400000L, "measurement.upload.stale_data_deletion_interval");
        W = p4Var.k(16L, "measurement.rb.attribution.max_retry_delay_seconds");
        X = p4Var.k(90L, "measurement.rb.attribution.client.min_time_after_boot_seconds");
        Y = p4Var.m("measurement.rb.attribution.uri_authority", "google-analytics.com");
        Z = p4Var.k(864000000L, "measurement.rb.attribution.max_queue_time");
        f2025a0 = p4Var.m("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        f2027b0 = p4Var.m("measurement.rb.attribution.query_parameters_to_remove", "");
        f2029c0 = p4Var.m("measurement.rb.attribution.uri_scheme", "https");
        f2031d0 = p4Var.k(604800000L, "measurement.sdk.attribution.cache.ttl");
        f2032e0 = p4Var.k(7200000L, "measurement.redaction.app_instance_id.ttl");
        f2033f0 = p4Var.k(43200000L, "measurement.upload.backoff_period");
        f2034g0 = p4Var.k(15000L, "measurement.upload.initial_upload_delay_time");
        f2035h0 = p4Var.k(3600000L, "measurement.upload.interval");
        f2037i0 = p4Var.k(65536L, "measurement.upload.max_bundle_size");
        f2039j0 = p4Var.k(100L, "measurement.upload.max_bundles");
        f2041k0 = p4Var.k(500L, "measurement.upload.max_conversions_per_day");
        l0 = p4Var.k(1000L, "measurement.upload.max_error_events_per_day");
        f2044m0 = p4Var.k(1000L, "measurement.upload.max_events_per_bundle");
        f2046n0 = p4Var.k(100000L, "measurement.upload.max_events_per_day");
        f2048o0 = p4Var.k(50000L, "measurement.upload.max_public_events_per_day");
        f2050p0 = p4Var.k(518400000L, "measurement.upload.max_queue_time");
        f2052q0 = p4Var.k(10L, "measurement.upload.max_realtime_events_per_day");
        f2054r0 = p4Var.k(65536L, "measurement.upload.max_batch_size");
        f2056s0 = p4Var.k(6L, "measurement.upload.retry_count");
        f2057t0 = p4Var.k(1800000L, "measurement.upload.retry_time");
        f2059u0 = p4Var.m("measurement.upload.url", "https://app-measurement.com/a");
        f2061v0 = p4Var.k(3600000L, "measurement.upload.window_interval");
        f2063w0 = p4Var.m("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }
}
