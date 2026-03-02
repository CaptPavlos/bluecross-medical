package c1;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f0 {
    public static final e0 A;
    public static final e0 A0;
    public static final e0 B;
    public static final e0 B0;
    public static final e0 C;
    public static final e0 C0;
    public static final e0 D;
    public static final e0 D0;
    public static final e0 E;
    public static final e0 E0;
    public static final e0 F;
    public static final e0 F0;
    public static final e0 G;
    public static final e0 G0;
    public static final e0 H;
    public static final e0 H0;
    public static final e0 I;
    public static final e0 I0;
    public static final e0 J;
    public static final e0 J0;
    public static final e0 K;
    public static final e0 K0;
    public static final e0 L;
    public static final e0 L0;
    public static final e0 M;
    public static final e0 M0;
    public static final e0 N;
    public static final e0 N0;
    public static final e0 O;
    public static final e0 O0;
    public static final e0 P;
    public static final e0 P0;
    public static final e0 Q;
    public static final e0 Q0;
    public static final e0 R;
    public static final e0 R0;
    public static final e0 S;
    public static final e0 S0;
    public static final e0 T;
    public static final e0 T0;
    public static final e0 U;
    public static final e0 U0;
    public static final e0 V;
    public static final e0 V0;
    public static final e0 W;
    public static final e0 W0;
    public static final e0 X;
    public static final e0 X0;
    public static final e0 Y;
    public static final e0 Y0;
    public static final e0 Z;
    public static final e0 Z0;

    /* renamed from: a, reason: collision with root package name */
    public static final List f1154a = DesugarCollections.synchronizedList(new ArrayList());

    /* renamed from: a0, reason: collision with root package name */
    public static final e0 f1155a0;

    /* renamed from: a1, reason: collision with root package name */
    public static final e0 f1156a1;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f1157b;

    /* renamed from: b0, reason: collision with root package name */
    public static final e0 f1158b0;
    public static final e0 b1;

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f1159c;

    /* renamed from: c0, reason: collision with root package name */
    public static final e0 f1160c0;

    /* renamed from: c1, reason: collision with root package name */
    public static final e0 f1161c1;

    /* renamed from: d, reason: collision with root package name */
    public static final e0 f1162d;

    /* renamed from: d0, reason: collision with root package name */
    public static final e0 f1163d0;

    /* renamed from: d1, reason: collision with root package name */
    public static final e0 f1164d1;
    public static final e0 e;

    /* renamed from: e0, reason: collision with root package name */
    public static final e0 f1165e0;

    /* renamed from: e1, reason: collision with root package name */
    public static final e0 f1166e1;
    public static final e0 f;

    /* renamed from: f0, reason: collision with root package name */
    public static final e0 f1167f0;

    /* renamed from: f1, reason: collision with root package name */
    public static final e0 f1168f1;
    public static final e0 g;

    /* renamed from: g0, reason: collision with root package name */
    public static final e0 f1169g0;

    /* renamed from: g1, reason: collision with root package name */
    public static final e0 f1170g1;
    public static final e0 h;

    /* renamed from: h0, reason: collision with root package name */
    public static final e0 f1171h0;

    /* renamed from: h1, reason: collision with root package name */
    public static final e0 f1172h1;

    /* renamed from: i, reason: collision with root package name */
    public static final e0 f1173i;

    /* renamed from: i0, reason: collision with root package name */
    public static final e0 f1174i0;

    /* renamed from: i1, reason: collision with root package name */
    public static final e0 f1175i1;

    /* renamed from: j, reason: collision with root package name */
    public static final e0 f1176j;

    /* renamed from: j0, reason: collision with root package name */
    public static final e0 f1177j0;

    /* renamed from: j1, reason: collision with root package name */
    public static final e0 f1178j1;

    /* renamed from: k, reason: collision with root package name */
    public static final e0 f1179k;

    /* renamed from: k0, reason: collision with root package name */
    public static final e0 f1180k0;

    /* renamed from: k1, reason: collision with root package name */
    public static final e0 f1181k1;

    /* renamed from: l, reason: collision with root package name */
    public static final e0 f1182l;
    public static final e0 l0;

    /* renamed from: l1, reason: collision with root package name */
    public static final e0 f1183l1;

    /* renamed from: m, reason: collision with root package name */
    public static final e0 f1184m;

    /* renamed from: m0, reason: collision with root package name */
    public static final e0 f1185m0;

    /* renamed from: n, reason: collision with root package name */
    public static final e0 f1186n;

    /* renamed from: n0, reason: collision with root package name */
    public static final e0 f1187n0;

    /* renamed from: o, reason: collision with root package name */
    public static final e0 f1188o;

    /* renamed from: o0, reason: collision with root package name */
    public static final e0 f1189o0;

    /* renamed from: p, reason: collision with root package name */
    public static final e0 f1190p;

    /* renamed from: p0, reason: collision with root package name */
    public static final e0 f1191p0;

    /* renamed from: q, reason: collision with root package name */
    public static final e0 f1192q;

    /* renamed from: q0, reason: collision with root package name */
    public static final e0 f1193q0;

    /* renamed from: r, reason: collision with root package name */
    public static final e0 f1194r;

    /* renamed from: r0, reason: collision with root package name */
    public static final e0 f1195r0;

    /* renamed from: s, reason: collision with root package name */
    public static final e0 f1196s;

    /* renamed from: s0, reason: collision with root package name */
    public static final e0 f1197s0;
    public static final e0 t;

    /* renamed from: t0, reason: collision with root package name */
    public static final e0 f1198t0;

    /* renamed from: u, reason: collision with root package name */
    public static final e0 f1199u;

    /* renamed from: u0, reason: collision with root package name */
    public static final e0 f1200u0;

    /* renamed from: v, reason: collision with root package name */
    public static final e0 f1201v;

    /* renamed from: v0, reason: collision with root package name */
    public static final e0 f1202v0;

    /* renamed from: w, reason: collision with root package name */
    public static final e0 f1203w;

    /* renamed from: w0, reason: collision with root package name */
    public static final e0 f1204w0;

    /* renamed from: x, reason: collision with root package name */
    public static final e0 f1205x;

    /* renamed from: x0, reason: collision with root package name */
    public static final e0 f1206x0;
    public static final e0 y;

    /* renamed from: y0, reason: collision with root package name */
    public static final e0 f1207y0;

    /* renamed from: z, reason: collision with root package name */
    public static final e0 f1208z;
    public static final e0 z0;

    static {
        DesugarCollections.synchronizedSet(new HashSet());
        Long lValueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        f1157b = a("measurement.ad_id_cache_time", lValueOf, b0.D, false);
        f1159c = a("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, o2.e.h, false);
        f1162d = a("measurement.monitoring.sample_period_millis", 86400000L, o2.e.y, false);
        e = a("measurement.config.cache_time", 86400000L, y.f1586l, false);
        f = a("measurement.config.url_scheme", "https", y.f1596w, false);
        g = a("measurement.config.url_authority", "app-measurement.com", a0.f986d, false);
        h = a("measurement.upload.max_bundles", 100, a0.f993o, false);
        f1173i = a("measurement.upload.max_batch_size", 65536, a0.f1002z, false);
        f1176j = a("measurement.upload.max_bundle_size", 65536, b0.g, false);
        f1179k = a("measurement.upload.max_events_per_bundle", 1000, b0.f1027r, false);
        Integer numValueOf = Integer.valueOf(DefaultOggSeeker.MATCH_BYTE_RANGE);
        f1182l = a("measurement.upload.max_events_per_day", numValueOf, b0.C, false);
        f1184m = a("measurement.upload.max_error_events_per_day", 1000, o2.e.f11691o, false);
        f1186n = a("measurement.upload.max_public_events_per_day", Integer.valueOf(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS), o2.e.f11692p, false);
        f1188o = a("measurement.upload.max_conversions_per_day", 10000, o2.e.f11693q, false);
        f1190p = a("measurement.upload.max_realtime_events_per_day", 10, o2.e.f11694r, false);
        f1192q = a("measurement.store.max_stored_events_per_app", numValueOf, o2.e.f11695s, false);
        f1194r = a("measurement.upload.url", "https://app-measurement.com/a", o2.e.t, false);
        f1196s = a("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", o2.e.f11696u, false);
        t = a("measurement.sgtm.service_upload_apps_list", "", o2.e.f11697v, false);
        f1199u = a("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", o2.e.f11698w, false);
        Long lValueOf2 = Long.valueOf(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS);
        f1201v = a("measurement.sgtm.upload.retry_interval", lValueOf2, o2.e.f11699x, false);
        f1203w = a("measurement.sgtm.upload.retry_max_wait", 21600000L, y.f1580b, false);
        f1205x = a("measurement.sgtm.batch.retry_interval", 1800000L, y.f1581c, false);
        y = a("measurement.sgtm.batch.retry_max_wait", 21600000L, y.f1582d, false);
        f1208z = a("measurement.sgtm.batch.retry_max_count", 10, y.e, false);
        A = a("measurement.sgtm.upload.max_queued_batches", Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS), y.f, false);
        B = a("measurement.sgtm.upload.batches_retrieval_limit", 5, y.g, false);
        C = a("measurement.sgtm.upload.min_delay_after_startup", 5000L, y.h, false);
        D = a("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, y.f1583i, false);
        E = a("measurement.sgtm.upload.min_delay_after_background", lValueOf2, y.f1584j, false);
        F = a("measurement.sgtm.batch.long_queuing_threshold", 14400000L, y.f1585k, false);
        G = a("measurement.upload.backoff_period", 43200000L, y.f1587m, false);
        H = a("measurement.upload.window_interval", 3600000L, y.f1588n, false);
        I = a("measurement.upload.interval", 3600000L, y.f1589o, false);
        J = a("measurement.upload.realtime_upload_interval", lValueOf, y.f1590p, false);
        K = a("measurement.upload.debug_upload_interval", 1000L, y.f1591q, false);
        L = a("measurement.upload.minimum_delay", 500L, y.f1592r, false);
        M = a("measurement.alarm_manager.minimum_interval", Long.valueOf(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS), y.f1593s, false);
        N = a("measurement.upload.stale_data_deletion_interval", 86400000L, y.t, false);
        O = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, y.f1594u, false);
        P = a("measurement.upload.initial_upload_delay_time", 15000L, y.f1595v, false);
        Q = a("measurement.upload.retry_time", 1800000L, y.f1597x, false);
        R = a("measurement.upload.retry_count", 6, y.y, false);
        S = a("measurement.upload.max_queue_time", 518400000L, y.f1598z, false);
        T = a("measurement.upload.google_signal_max_queue_time", Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS), y.A, false);
        U = a("measurement.lifetimevalue.max_currency_tracked", 4, y.B, false);
        V = a("measurement.audience.filter_result_max_count", 200, y.C, false);
        W = a("measurement.upload.max_public_user_properties", 100, null, false);
        X = a("measurement.upload.max_event_name_cardinality", 2000, null, false);
        Y = a("measurement.upload.max_public_event_params", 100, null, false);
        Z = a("measurement.service_client.idle_disconnect_millis", 5000L, y.D, false);
        f1155a0 = a("measurement.service_client.reconnect_millis", 1000L, y.E, false);
        Boolean bool = Boolean.FALSE;
        f1158b0 = a("measurement.test.boolean_flag", bool, a0.f984b, false);
        f1160c0 = a("measurement.test.string_flag", "---", a0.f985c, false);
        f1163d0 = a("measurement.test.long_flag", -1L, a0.e, false);
        a("measurement.test.cached_long_flag", -1L, a0.f, true);
        f1165e0 = a("measurement.test.int_flag", -2, a0.g, false);
        f1167f0 = a("measurement.test.double_flag", Double.valueOf(-3.0d), a0.h, false);
        f1169g0 = a("measurement.experiment.max_ids", 50, a0.f987i, false);
        f1171h0 = a("measurement.upload.max_item_scoped_custom_parameters", 27, a0.f988j, false);
        f1174i0 = a("measurement.upload.max_event_parameter_value_length", 500, a0.f989k, true);
        f1177j0 = a("measurement.max_bundles_per_iteration", 100, a0.f990l, false);
        f1180k0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, a0.f991m, false);
        l0 = a("measurement.redaction.app_instance_id.ttl", 7200000L, a0.f992n, false);
        f1185m0 = a("measurement.rb.attribution.client.min_ad_services_version", 7, a0.f994p, false);
        f1187n0 = a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, a0.f995q, false);
        f1189o0 = a("measurement.rb.attribution.uri_scheme", "https", a0.f996r, false);
        f1191p0 = a("measurement.rb.attribution.uri_authority", "google-analytics.com", a0.f997s, false);
        f1193q0 = a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", a0.t, false);
        f1195r0 = a("measurement.session.engagement_interval", 3600000L, a0.f998u, false);
        f1197s0 = a("measurement.rb.attribution.app_allowlist", "", a0.f999v, false);
        f1198t0 = a("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", a0.f1000w, false);
        f1200u0 = a("measurement.rb.attribution.event_params", "value|currency", a0.f1001x, false);
        f1202v0 = a("measurement.rb.attribution.query_parameters_to_remove", "", a0.y, false);
        f1204w0 = a("measurement.rb.attribution.max_queue_time", 864000000L, a0.A, false);
        f1206x0 = a("measurement.rb.attribution.max_retry_delay_seconds", 16, a0.B, false);
        f1207y0 = a("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, a0.C, false);
        a("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, a0.D, false);
        z0 = a("measurement.rb.max_trigger_registrations_per_day", 1000, a0.E, false);
        Boolean bool2 = Boolean.TRUE;
        A0 = a("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, b0.f1015b, false);
        B0 = a("measurement.config.notify_trigger_uris_on_backgrounded", bool2, b0.f1016c, false);
        C0 = a("measurement.rb.attribution.notify_app_delay_millis", 3000, b0.f1017d, false);
        D0 = a("measurement.quality.checksum", bool, null, false);
        E0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, b0.e, false);
        F0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, b0.f, false);
        G0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, b0.h, true);
        H0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, b0.f1018i, false);
        I0 = a("measurement.integration.disable_firebase_instance_id", bool, b0.f1019j, false);
        J0 = a("measurement.collection.service.update_with_analytics_fix", bool, b0.f1020k, false);
        K0 = a("measurement.service.storage_consent_support_version", 203600, b0.f1021l, false);
        L0 = a("measurement.service.store_null_safelist", bool2, b0.f1022m, false);
        M0 = a("measurement.service.store_safelist", bool2, b0.f1023n, false);
        N0 = a("measurement.session_stitching_token_enabled", bool, b0.f1024o, false);
        O0 = a("measurement.sgtm.client.upload_on_backgrounded.dev", bool, b0.f1025p, true);
        P0 = a("measurement.gmscore_client_telemetry", bool, d0.f1100b, false);
        Q0 = a("measurement.rb.attribution.service", bool2, b0.f1026q, true);
        R0 = a("measurement.rb.attribution.client2", bool2, b0.f1028s, true);
        S0 = a("measurement.rb.attribution.uuid_generation", bool2, b0.t, false);
        T0 = a("measurement.rb.attribution.enable_trigger_redaction", bool2, b0.f1029u, false);
        a("measurement.rb.attribution.followup1.service", bool, b0.f1030v, false);
        U0 = a("measurement.rb.attribution.retry_disposition", bool, b0.f1031w, false);
        V0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, d0.f1102d, false);
        W0 = a("measurement.set_default_event_parameters_propagate_clear.service.dev", bool2, b0.f1032x, false);
        X0 = a("measurement.set_default_event_parameters_propagate_clear.client.dev", bool2, b0.y, false);
        Y0 = a("measurement.service.ad_impression.convert_value_to_double", bool2, b0.f1033z, false);
        a("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, b0.A, false);
        a("measurement.remove_conflicting_first_party_apis.dev", bool, b0.B, false);
        Z0 = a("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, o2.e.f11685i, false);
        f1156a1 = a("measurement.tcf.consent_fix", bool2, o2.e.f11686j, false);
        b1 = a("measurement.experiment.enable_phenotype_experiment_reporting", bool2, o2.e.f11687k, false);
        f1161c1 = a("measurement.set_default_event_parameters.fix_service_request_ordering", bool, o2.e.f11684d, false);
        f1164d1 = a("measurement.set_default_event_parameters.fix_app_update_logging", bool2, o2.e.f11683c, false);
        f1166e1 = a("measurement.service.fix_stop_bundling_bug", bool2, o2.e.g, false);
        f1168f1 = a("measurement.fix_params_logcat_spam", bool2, o2.e.f, false);
        f1170g1 = a("measurement.gbraid_campaign.stop_lgclid", bool, b0.E, false);
        f1172h1 = a("measurement.gbraid_compaign.compaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid", o2.e.f11688l, false);
        f1175i1 = a("measurement.edpb.service", bool, o2.e.e, false);
        f1178j1 = a("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp", o2.e.f11689m, false);
        f1181k1 = a("measurement.add_first_launch_logging_timestamp.service", bool, d0.f1101c, false);
        f1183l1 = a("measurement.overlapping_bundles_fix", bool, o2.e.f11690n, false);
    }

    public static e0 a(String str, Object obj, w wVar, boolean z9) {
        e0 e0Var = new e0(str, obj, wVar);
        if (z9) {
            f1154a.add(e0Var);
        }
        return e0Var;
    }
}
