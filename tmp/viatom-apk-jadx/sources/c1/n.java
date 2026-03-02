package c1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.j8;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends q4 {
    public static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    public static final String[] h = {TtmlNode.ATTR_TTS_ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f1336i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f1337j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f1338k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f1339l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f1340m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f1341n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f1342o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f1343p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: d, reason: collision with root package name */
    public final m f1344d;
    public final s0 e;

    public n(v4 v4Var) {
        super(v4Var);
        this.e = new s0(this.f1149a.f1481k);
        this.f1149a.getClass();
        this.f1344d = new m(this, this.f1149a.f1475a);
    }

    public static final String J(List list) {
        return list.isEmpty() ? "" : androidx.constraintlayout.core.widgets.analyzer.a.x(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    public static final void P(ContentValues contentValues, Object obj) {
        i0.y.d("value");
        i0.y.g(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
            return;
        }
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            com.google.gson.internal.a.n("Invalid value type");
        }
    }

    public final void A(String str, k4 k4Var) {
        g();
        h();
        i0.y.d(str);
        u1 u1Var = this.f1149a;
        n0.a aVar = u1Var.f1481k;
        w0 w0Var = u1Var.f;
        aVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        e0 e0Var = f0.f1204w0;
        long jLongValue = jCurrentTimeMillis - ((Long) e0Var.a(null)).longValue();
        long j10 = k4Var.f1309b;
        if (j10 < jLongValue || j10 > ((Long) e0Var.a(null)).longValue() + jCurrentTimeMillis) {
            u1.m(w0Var);
            w0Var.f1540i.e("Storing trigger URI outside of the max retention time span. appId, now, timestamp", w0.o(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j10));
        }
        u1.m(w0Var);
        w0Var.f1545n.b("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("trigger_uri", k4Var.f1308a);
        contentValues.put("source", Integer.valueOf(k4Var.f1310c));
        contentValues.put("timestamp_millis", Long.valueOf(j10));
        try {
            if (V().insert("trigger_uris", null, contentValues) == -1) {
                u1.m(w0Var);
                w0Var.f.c(w0.o(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e) {
            u1.m(w0Var);
            w0Var.f.d(w0.o(str), "Error storing trigger URI. appId", e);
        }
    }

    public final void B(String str, k2 k2Var) {
        i0.y.g(str);
        i0.y.g(k2Var);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("consent_state", k2Var.g());
        contentValues.put("consent_source", Integer.valueOf(k2Var.f1303b));
        D(contentValues);
    }

    public final String C(String str, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = V().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return "";
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                w0Var.f.d(str, "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void D(ContentValues contentValues) {
        u1 u1Var = this.f1149a;
        try {
            SQLiteDatabase sQLiteDatabaseV = V();
            if (contentValues.getAsString(MBridgeConstans.APP_ID) == null) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.h.c(w0.o(MBridgeConstans.APP_ID), "Value of the primary key is not set.");
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (sQLiteDatabaseV.update("consent_settings", contentValues, r6.toString(), new String[]{r5}) == 0 && sQLiteDatabaseV.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f.d(w0.o("consent_settings"), "Failed to insert/update table (got -1). key", w0.o(MBridgeConstans.APP_ID));
            }
        } catch (SQLiteException e) {
            w0 w0Var3 = u1Var.f;
            u1.m(w0Var3);
            w0Var3.f.e("Error storing into table. key", w0.o("consent_settings"), w0.o(MBridgeConstans.APP_ID), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.s E(java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.E(java.lang.String, java.lang.String, java.lang.String):c1.s");
    }

    public final void F(String str, s sVar) {
        u1 u1Var = this.f1149a;
        i0.y.g(sVar);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        String str2 = sVar.f1440a;
        contentValues.put(MBridgeConstans.APP_ID, str2);
        contentValues.put(RewardPlus.NAME, sVar.f1441b);
        contentValues.put("lifetime_count", Long.valueOf(sVar.f1442c));
        contentValues.put("current_bundle_count", Long.valueOf(sVar.f1443d));
        contentValues.put("last_fire_timestamp", Long.valueOf(sVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(sVar.g));
        contentValues.put("last_bundled_day", sVar.h);
        contentValues.put("last_sampled_complex_event_id", sVar.f1444i);
        contentValues.put("last_sampling_rate", sVar.f1445j);
        contentValues.put("current_session_count", Long.valueOf(sVar.e));
        Boolean bool = sVar.f1446k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (V().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f.c(w0.o(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.d(w0.o(str2), "Error storing event aggregates. appId", e);
        }
    }

    public final void G(String str, String str2) {
        i0.y.d(str2);
        g();
        h();
        try {
            V().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.d(w0.o(str2), "Error deleting snapshot. appId", e);
        }
    }

    public final x4 H(String str, long j10, byte[] bArr, String str2, String str3, int i10, int i11, long j11, long j12, long j13) {
        x4 x4Var;
        u1 u1Var;
        j3 j3Var;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        u1 u1Var2 = this.f1149a;
        if (zIsEmpty) {
            w0 w0Var = u1Var2.f;
            u1.m(w0Var);
            w0Var.f1544m.b("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.h3 h3Var = (com.google.android.gms.internal.measurement.h3) a1.T(com.google.android.gms.internal.measurement.i3.w(), bArr);
            j3[] j3VarArrValues = j3.values();
            int length = j3VarArrValues.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    j3Var = j3.UNKNOWN;
                    break;
                }
                j3Var = j3VarArrValues[i12];
                if (j3Var.f1294a == i10) {
                    break;
                }
                i12++;
            }
            j3 j3Var2 = j3Var;
            if (j3Var2 != j3.GOOGLE_SIGNAL && j3Var2 != j3.GOOGLE_SIGNAL_PENDING && i11 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.i3) h3Var.f2102b).p()).iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.j3 j3Var3 = (com.google.android.gms.internal.measurement.j3) ((com.google.android.gms.internal.measurement.k3) it.next()).i();
                    j3Var3.b();
                    ((com.google.android.gms.internal.measurement.k3) j3Var3.f2102b).T0(i11);
                    arrayList.add((com.google.android.gms.internal.measurement.k3) j3Var3.d());
                }
                h3Var.b();
                ((com.google.android.gms.internal.measurement.i3) h3Var.f2102b).B();
                h3Var.b();
                ((com.google.android.gms.internal.measurement.i3) h3Var.f2102b).A(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length2 = strArrSplit.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length2) {
                        break;
                    }
                    String str4 = strArrSplit[i13];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        w0 w0Var2 = u1Var2.f;
                        u1.m(w0Var2);
                        w0Var2.f.c(str4, "Invalid upload header: ");
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i13++;
                }
            }
            x4Var = null;
            u1Var = u1Var2;
            try {
                return new x4(j10, (com.google.android.gms.internal.measurement.i3) h3Var.d(), str2, map, j3Var2, j11, j12, j13, i11);
            } catch (IOException e) {
                e = e;
                w0 w0Var3 = u1Var.f;
                u1.m(w0Var3);
                w0Var3.f.d(str, "Failed to queued MeasurementBatch from upload_queue. appId", e);
                return x4Var;
            }
        } catch (IOException e3) {
            e = e3;
            x4Var = null;
            u1Var = u1Var2;
        }
    }

    public final String I() {
        this.f1149a.f1481k.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Long l10 = (Long) f0.T.a(null);
        l10.getClass();
        String str = "(upload_type = 1 AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + l10 + ")";
        String strL = a3.a.l(a3.a.x("(upload_type != 1 AND ABS(creation_timestamp - ", ") > ", jCurrentTimeMillis), ((Long) f0.S.a(null)).longValue(), ")");
        StringBuilder sb = new StringBuilder(str.length() + 5 + strL.length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(strL);
        sb.append(")");
        return sb.toString();
    }

    public final void K(String str, k2 k2Var) {
        i0.y.g(str);
        g();
        h();
        B(str, z(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("storage_consent_at_bundling", k2Var.g());
        D(contentValues);
    }

    public final k2 L(String str) {
        i0.y.g(str);
        g();
        h();
        return k2.c(100, C("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    public final s M(String str, com.google.android.gms.internal.measurement.c3 c3Var, String str2) {
        s sVarE = E("events", str, c3Var.s());
        if (sVarE != null) {
            long j10 = sVarE.e + 1;
            long j11 = sVarE.f1443d + 1;
            return new s(sVarE.f1440a, sVarE.f1441b, sVarE.f1442c + 1, j11, j10, sVarE.f, sVarE.g, sVarE.h, sVarE.f1444i, sVarE.f1445j, sVarE.f1446k);
        }
        u1 u1Var = this.f1149a;
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1540i.d(w0.o(str), "Event aggregate wasn't created during raw event logging. appId, event", u1Var.f1480j.a(str2));
        return new s(str, c3Var.s(), 1L, 1L, 1L, c3Var.u(), 0L, null, null, null, null);
    }

    public final boolean N() {
        return this.f1149a.f1475a.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[Catch: all -> 0x0077, SQLiteException -> 0x0079, TryCatch #0 {SQLiteException -> 0x0079, blocks: (B:19:0x006f, B:45:0x00cd, B:47:0x00f5, B:48:0x0107, B:49:0x010b, B:50:0x011b, B:52:0x0121, B:53:0x0131, B:56:0x0144, B:68:0x016b, B:71:0x0173, B:77:0x0192, B:61:0x015a, B:75:0x0184, B:76:0x018d, B:98:0x021e), top: B:111:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107 A[Catch: all -> 0x0077, SQLiteException -> 0x0079, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x0079, blocks: (B:19:0x006f, B:45:0x00cd, B:47:0x00f5, B:48:0x0107, B:49:0x010b, B:50:0x011b, B:52:0x0121, B:53:0x0131, B:56:0x0144, B:68:0x016b, B:71:0x0173, B:77:0x0192, B:61:0x015a, B:75:0x0184, B:76:0x018d, B:98:0x021e), top: B:111:0x006f }] */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.lang.String r21, long r22, long r24, c1.f1 r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.O(java.lang.String, long, long, c1.f1):void");
    }

    public final long Q(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = V().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                w0Var.f.d(str, "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long R(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = V().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j10 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                w0Var.f.d(str, "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void S() {
        h();
        V().beginTransaction();
    }

    public final void T() {
        h();
        V().setTransactionSuccessful();
    }

    public final void U() {
        h();
        V().endTransaction();
    }

    public final SQLiteDatabase V() {
        g();
        try {
            return this.f1344d.getWritableDatabase();
        } catch (SQLiteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error opening database");
            throw e;
        }
    }

    public final void W(String str) {
        s sVarE;
        G("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = V().query("events", (String[]) Collections.singletonList(RewardPlus.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (sVarE = E("events", str, string)) != null) {
                            F("events_snapshot", sVarE);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                w0Var.f.d(w0.o(str), "Error creating snapshot. appId", e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.X(java.lang.String):void");
    }

    public final void Y(String str, String str2) {
        i0.y.d(str);
        i0.y.d(str2);
        g();
        h();
        try {
            V().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            u1 u1Var = this.f1149a;
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.e("Error deleting user property. appId", w0.o(str), u1Var.f1480j.c(str2), e);
        }
    }

    public final boolean Z(z4 z4Var) {
        String str = z4Var.f1630b;
        g();
        h();
        String str2 = z4Var.f1629a;
        String str3 = z4Var.f1631c;
        z4 z4VarA0 = a0(str2, str3);
        u1 u1Var = this.f1149a;
        if (z4VarA0 == null) {
            if (b5.f0(str3)) {
                if (Q("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str2}) >= Math.max(Math.min(u1Var.f1478d.o(str2, f0.W), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str3)) {
                long jQ = Q("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str2, str});
                u1Var.getClass();
                if (jQ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str2);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, str);
        contentValues.put(RewardPlus.NAME, str3);
        contentValues.put("set_timestamp", Long.valueOf(z4Var.f1632d));
        P(contentValues, z4Var.e);
        try {
            if (V().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(w0.o(str2), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.d(w0.o(str2), "Error storing user property. appId", e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.z4 a0(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            c1.u1 r1 = r11.f1149a
            i0.y.d(r12)
            i0.y.d(r13)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.V()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r4 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r0 != 0) goto L34
            goto L92
        L34:
            r0 = 0
            long r8 = r3.getLong(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r0 = 1
            java.lang.Object r10 = r11.t(r3, r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r10 != 0) goto L41
            goto L92
        L41:
            r0 = 2
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            c1.z4 r4 = new c1.z4     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            boolean r12 = r3.moveToNext()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            if (r12 == 0) goto L6a
            c1.w0 r12 = r1.f     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            c1.u1.m(r12)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            c1.u0 r12 = r12.f     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            java.lang.String r13 = "Got multiple records for user property, expected one. appId"
            c1.v0 r0 = c1.w0.o(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            r12.c(r0, r13)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            goto L6a
        L64:
            r0 = move-exception
            r12 = r0
            goto L72
        L67:
            r0 = move-exception
        L68:
            r12 = r0
            goto L7c
        L6a:
            r3.close()
            return r4
        L6e:
            r0 = move-exception
            r5 = r12
            r7 = r13
            goto L68
        L72:
            r2 = r3
            goto L98
        L74:
            r0 = move-exception
            r12 = r0
            goto L98
        L77:
            r0 = move-exception
            r5 = r12
            r7 = r13
            r12 = r0
            r3 = r2
        L7c:
            c1.w0 r13 = r1.f     // Catch: java.lang.Throwable -> L64
            c1.u1.m(r13)     // Catch: java.lang.Throwable -> L64
            c1.u0 r13 = r13.f     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "Error querying user property. appId"
            c1.v0 r4 = c1.w0.o(r5)     // Catch: java.lang.Throwable -> L64
            c1.q0 r1 = r1.f1480j     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.c(r7)     // Catch: java.lang.Throwable -> L64
            r13.e(r0, r4, r1, r12)     // Catch: java.lang.Throwable -> L64
        L92:
            if (r3 == 0) goto L97
            r3.close()
        L97:
            return r2
        L98:
            if (r2 == 0) goto L9d
            r2.close()
        L9d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.a0(java.lang.String, java.lang.String):c1.z4");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b0(java.lang.String r13) {
        /*
            r12 = this;
            c1.u1 r1 = r12.f1149a
            i0.y.d(r13)
            r12.g()
            r12.h()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1000"
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.V()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r9 = "rowid"
            r1.getClass()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            boolean r2 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 == 0) goto L99
        L3c:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 1
            java.lang.String r2 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 != 0) goto L4a
            java.lang.String r2 = ""
        L4a:
            r5 = r2
            goto L4f
        L4c:
            r0 = move-exception
            r4 = r13
            goto L87
        L4f:
            r2 = 2
            long r7 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 3
            java.lang.Object r9 = r12.t(r11, r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r9 != 0) goto L70
            c1.w0 r2 = r1.f     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            c1.u1.m(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            c1.u0 r2 = r2.f     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            c1.v0 r4 = c1.w0.o(r13)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2.c(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            goto L79
        L6d:
            r0 = move-exception
            r13 = r0
            goto L9f
        L70:
            c1.z4 r3 = new c1.z4     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            r0.add(r3)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
        L79:
            boolean r13 = r11.moveToNext()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            if (r13 != 0) goto L80
            goto L99
        L80:
            r13 = r4
            goto L3c
        L82:
            r0 = move-exception
            goto L87
        L84:
            r0 = move-exception
            r4 = r13
            r13 = r0
        L87:
            c1.w0 r13 = r1.f     // Catch: java.lang.Throwable -> L6d
            c1.u1.m(r13)     // Catch: java.lang.Throwable -> L6d
            c1.u0 r13 = r13.f     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "Error querying user properties. appId"
            c1.v0 r2 = c1.w0.o(r4)     // Catch: java.lang.Throwable -> L6d
            r13.d(r2, r1, r0)     // Catch: java.lang.Throwable -> L6d
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L6d
        L99:
            if (r11 == 0) goto L9e
            r11.close()
        L9e:
            return r0
        L9f:
            if (r11 == 0) goto La4
            r11.close()
        La4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.b0(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00af, code lost:
    
        c1.u1.m(r13);
        r13.f.c(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List c0(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.c0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean d0(e eVar) {
        g();
        h();
        String str = eVar.f1134a;
        i0.y.g(str);
        z4 z4VarA0 = a0(str, eVar.f1136c.f1610b);
        u1 u1Var = this.f1149a;
        if (z4VarA0 == null) {
            long jQ = Q("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            u1Var.getClass();
            if (jQ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, eVar.f1135b);
        contentValues.put(RewardPlus.NAME, eVar.f1136c.f1610b);
        Object objB = eVar.f1136c.b();
        i0.y.g(objB);
        P(contentValues, objB);
        contentValues.put("active", Boolean.valueOf(eVar.e));
        contentValues.put("trigger_event_name", eVar.f);
        contentValues.put("trigger_timeout", Long.valueOf(eVar.h));
        v vVar = eVar.g;
        b5 b5Var = u1Var.f1479i;
        w0 w0Var = u1Var.f;
        u1.k(b5Var);
        contentValues.put("timed_out_event", b5.L(vVar));
        contentValues.put("creation_timestamp", Long.valueOf(eVar.f1137d));
        u1.k(b5Var);
        contentValues.put("triggered_event", b5.L(eVar.f1138i));
        contentValues.put("triggered_timestamp", Long.valueOf(eVar.f1136c.f1611c));
        contentValues.put("time_to_live", Long.valueOf(eVar.f1139j));
        contentValues.put("expired_event", b5.L(eVar.f1140k));
        try {
            if (V().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            u1.m(w0Var);
            w0Var.f.c(w0.o(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e) {
            u1.m(w0Var);
            w0Var.f.d(w0.o(str), "Error storing conditional user property", e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.e e0(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.e0(java.lang.String, java.lang.String):c1.e");
    }

    public final void f0(String str, String str2) {
        i0.y.d(str);
        i0.y.d(str2);
        g();
        h();
        try {
            V().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            u1 u1Var = this.f1149a;
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.e("Error deleting conditional property", w0.o(str), u1Var.f1480j.c(str2), e);
        }
    }

    public final List g0(String str, String str2, String str3) {
        i0.y.d(str);
        g();
        h();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return h0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:
    
        r3 = r2.f;
        c1.u1.m(r3);
        r3.f.c(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List h0(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.h0(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x03cc: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:973), block:B:116:0x03cc */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.b1 i0(java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.i0(java.lang.String):c1.b1");
    }

    public final void j0(b1 b1Var, boolean z9) {
        u1 u1Var = b1Var.f1035a;
        g();
        h();
        String strD = b1Var.D();
        i0.y.g(strD);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, strD);
        j2 j2Var = j2.ANALYTICS_STORAGE;
        v4 v4Var = this.f1335b;
        if (z9) {
            contentValues.put("app_instance_id", (String) null);
        } else if (v4Var.d(strD).i(j2Var)) {
            contentValues.put("app_instance_id", b1Var.E());
        }
        contentValues.put("gmp_app_id", b1Var.G());
        if (v4Var.d(strD).i(j2.AD_STORAGE)) {
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.g();
            contentValues.put("resettable_device_id_hash", b1Var.e);
        }
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.g();
        contentValues.put("last_bundle_index", Long.valueOf(b1Var.g));
        r1 r1Var3 = u1Var.g;
        u1.m(r1Var3);
        r1Var3.g();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b1Var.h));
        r1 r1Var4 = u1Var.g;
        u1.m(r1Var4);
        r1Var4.g();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b1Var.f1039i));
        contentValues.put("app_version", b1Var.N());
        r1 r1Var5 = u1Var.g;
        u1.m(r1Var5);
        r1Var5.g();
        contentValues.put("app_store", b1Var.f1042l);
        r1 r1Var6 = u1Var.g;
        u1.m(r1Var6);
        r1Var6.g();
        contentValues.put("gmp_version", Long.valueOf(b1Var.f1043m));
        r1 r1Var7 = u1Var.g;
        u1.m(r1Var7);
        r1Var7.g();
        contentValues.put("dev_cert_hash", Long.valueOf(b1Var.f1044n));
        r1 r1Var8 = u1Var.g;
        u1.m(r1Var8);
        r1Var8.g();
        contentValues.put("measurement_enabled", Boolean.valueOf(b1Var.f1045o));
        r1 r1Var9 = u1Var.g;
        r1 r1Var10 = u1Var.g;
        u1.m(r1Var9);
        r1Var9.g();
        contentValues.put("day", Long.valueOf(b1Var.J));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_public_events_count", Long.valueOf(b1Var.K));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_events_count", Long.valueOf(b1Var.L));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_conversions_count", Long.valueOf(b1Var.M));
        r1 r1Var11 = u1Var.g;
        u1.m(r1Var11);
        r1Var11.g();
        contentValues.put("config_fetched_time", Long.valueOf(b1Var.R));
        r1 r1Var12 = u1Var.g;
        u1.m(r1Var12);
        r1Var12.g();
        contentValues.put("failed_config_fetch_time", Long.valueOf(b1Var.S));
        contentValues.put("app_version_int", Long.valueOf(b1Var.P()));
        contentValues.put("firebase_instance_id", b1Var.J());
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_error_events_count", Long.valueOf(b1Var.N));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_realtime_events_count", Long.valueOf(b1Var.O));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("health_monitor_sample", b1Var.P);
        contentValues.put("android_id", (Long) 0L);
        r1 r1Var13 = u1Var.g;
        u1.m(r1Var13);
        r1Var13.g();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(b1Var.f1046p));
        contentValues.put("dynamite_version", Long.valueOf(b1Var.b()));
        if (v4Var.d(strD).i(j2Var)) {
            r1 r1Var14 = u1Var.g;
            u1.m(r1Var14);
            r1Var14.g();
            contentValues.put("session_stitching_token", b1Var.t);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(b1Var.y()));
        r1 r1Var15 = u1Var.g;
        u1.m(r1Var15);
        r1Var15.g();
        contentValues.put("target_os_version", Long.valueOf(b1Var.f1051v));
        r1 r1Var16 = u1Var.g;
        u1.m(r1Var16);
        r1Var16.g();
        contentValues.put("session_stitching_token_hash", Long.valueOf(b1Var.f1052w));
        j8.a();
        u1 u1Var2 = this.f1149a;
        g gVar = u1Var2.f1478d;
        w0 w0Var = u1Var2.f;
        if (gVar.q(strD, f0.Q0)) {
            r1 r1Var17 = u1Var.g;
            u1.m(r1Var17);
            r1Var17.g();
            contentValues.put("ad_services_version", Integer.valueOf(b1Var.f1053x));
            r1 r1Var18 = u1Var.g;
            u1.m(r1Var18);
            r1Var18.g();
            contentValues.put("attribution_eligibility_status", Long.valueOf(b1Var.B));
        }
        r1 r1Var19 = u1Var.g;
        u1.m(r1Var19);
        r1Var19.g();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(b1Var.y));
        contentValues.put("npa_metadata_value", b1Var.w());
        r1 r1Var20 = u1Var.g;
        u1.m(r1Var20);
        r1Var20.g();
        contentValues.put("bundle_delivery_index", Long.valueOf(b1Var.F));
        contentValues.put("sgtm_preview_key", b1Var.C());
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("dma_consent_state", Integer.valueOf(b1Var.D));
        u1.m(r1Var10);
        r1Var10.g();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(b1Var.E));
        contentValues.put("serialized_npa_metadata", b1Var.s());
        contentValues.put("client_upload_eligibility", Integer.valueOf(b1Var.t()));
        r1 r1Var21 = u1Var.g;
        u1.m(r1Var21);
        r1Var21.g();
        ArrayList arrayList = b1Var.f1049s;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                u1.m(w0Var);
                w0Var.f1540i.c(strD, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        if (u1Var2.f1478d.q(null, f0.L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        r1 r1Var22 = u1Var.g;
        u1.m(r1Var22);
        r1Var22.g();
        contentValues.put("unmatched_pfo", b1Var.f1054z);
        r1 r1Var23 = u1Var.g;
        u1.m(r1Var23);
        r1Var23.g();
        contentValues.put("unmatched_uwa", b1Var.A);
        r1 r1Var24 = u1Var.g;
        u1.m(r1Var24);
        r1Var24.g();
        contentValues.put("ad_campaign_info", b1Var.H);
        try {
            SQLiteDatabase sQLiteDatabaseV = V();
            if (sQLiteDatabaseV.update("apps", contentValues, "app_id = ?", new String[]{strD}) == 0 && sQLiteDatabaseV.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                u1.m(w0Var);
                w0Var.f.c(w0.o(strD), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e) {
            u1.m(w0Var);
            w0Var.f.d(w0.o(strD), "Error storing app. appId", e);
        }
    }

    public final long k(String str, com.google.android.gms.internal.measurement.i3 i3Var, String str2, Map map, j3 j3Var, Long l10) {
        int iDelete;
        g();
        h();
        i0.y.g(i3Var);
        i0.y.d(str);
        g();
        h();
        boolean zN = N();
        u1 u1Var = this.f1149a;
        if (zN) {
            v4 v4Var = this.f1335b;
            long jA = v4Var.f1522i.f.a();
            n0.a aVar = u1Var.f1481k;
            w0 w0Var = u1Var.f;
            aVar.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) f0.N.a(null)).longValue()) {
                v4Var.f1522i.f.b(jElapsedRealtime);
                g();
                h();
                if (N() && (iDelete = V().delete("upload_queue", I(), new String[0])) > 0) {
                    u1.m(w0Var);
                    w0Var.f1545n.c(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                i0.y.d(str);
                g();
                h();
                try {
                    int iO = u1Var.f1478d.o(str, f0.A);
                    if (iO > 0) {
                        V().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iO)});
                    }
                } catch (SQLiteException e) {
                    u1.m(w0Var);
                    w0Var.f.d(w0.o(str), "Error deleting over the limit queued batches. appId", e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrA = i3Var.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("measurement_batch", bArrA);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) "\r\n");
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(j3Var.f1294a));
        n0.a aVar2 = u1Var.f1481k;
        w0 w0Var2 = u1Var.f;
        aVar2.getClass();
        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long jInsert = V().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            u1.m(w0Var2);
            w0Var2.f.c(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e3) {
            u1.m(w0Var2);
            w0Var2.f.d(str, "Error storing MeasurementBatch to upload_queue. appId", e3);
            return -1L;
        }
    }

    public final j k0(long j10, String str, boolean z9, boolean z10, boolean z11, boolean z12) {
        return l0(j10, str, 1L, false, false, z9, false, z10, z11, z12);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l(java.lang.String r19, c1.o4 r20, int r21) {
        /*
            r18 = this;
            i0.y.d(r19)
            r18.g()
            r18.h()
            java.lang.String r0 = " AND NOT "
            java.lang.String r1 = "app_id=?"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r18.V()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r4 = "upload_queue"
            java.lang.String r5 = "rowId"
            java.lang.String r6 = "app_id"
            java.lang.String r7 = "measurement_batch"
            java.lang.String r8 = "upload_uri"
            java.lang.String r9 = "upload_headers"
            java.lang.String r10 = "upload_type"
            java.lang.String r11 = "retry_count"
            java.lang.String r12 = "creation_timestamp"
            java.lang.String r13 = "associated_row_id"
            java.lang.String r14 = "last_upload_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r6 = r20
            java.util.List r6 = r6.f1392a     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = J(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r7 = r18.I()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r6.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + 17
            int r9 = r7.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r7)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = r9.toString()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String[] r7 = new java.lang.String[]{r19}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r10 = "creation_timestamp ASC"
            if (r21 <= 0) goto L66
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r11 = r0
            goto L67
        L66:
            r11 = r2
        L67:
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
        L72:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto Lb9
            r1 = 0
            long r5 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 2
            byte[] r7 = r2.getBlob(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 3
            java.lang.String r8 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 4
            java.lang.String r9 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 5
            int r10 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 6
            int r11 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 7
            long r12 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 8
            long r14 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 9
            long r16 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r3 = r18
            r4 = r19
            c1.x4 r1 = r3.H(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto L72
            r0.add(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            goto L72
        Lb5:
            r0 = move-exception
            goto Lbc
        Lb7:
            r0 = move-exception
            goto Lbf
        Lb9:
            r3 = r18
            goto Ld3
        Lbc:
            r3 = r18
            goto Lda
        Lbf:
            r3 = r18
            c1.u1 r1 = r3.f1149a     // Catch: java.lang.Throwable -> Ld9
            c1.w0 r1 = r1.f     // Catch: java.lang.Throwable -> Ld9
            c1.u1.m(r1)     // Catch: java.lang.Throwable -> Ld9
            c1.u0 r1 = r1.f     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r5 = r19
            r1.d(r5, r4, r0)     // Catch: java.lang.Throwable -> Ld9
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Ld9
        Ld3:
            if (r2 == 0) goto Ld8
            r2.close()
        Ld8:
            return r0
        Ld9:
            r0 = move-exception
        Lda:
            if (r2 == 0) goto Ldf
            r2.close()
        Ldf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.l(java.lang.String, c1.o4, int):java.util.List");
    }

    public final j l0(long j10, String str, long j11, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        u1 u1Var = this.f1149a;
        i0.y.d(str);
        g();
        h();
        String[] strArr = {str};
        j jVar = new j();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseV = V();
                cursorQuery = sQLiteDatabaseV.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j10) {
                        jVar.f1282b = cursorQuery.getLong(1);
                        jVar.f1281a = cursorQuery.getLong(2);
                        jVar.f1283c = cursorQuery.getLong(3);
                        jVar.f1284d = cursorQuery.getLong(4);
                        jVar.e = cursorQuery.getLong(5);
                        jVar.f = cursorQuery.getLong(6);
                        jVar.g = cursorQuery.getLong(7);
                    }
                    if (z9) {
                        jVar.f1282b += j11;
                    }
                    if (z10) {
                        jVar.f1281a += j11;
                    }
                    if (z11) {
                        jVar.f1283c += j11;
                    }
                    if (z12) {
                        jVar.f1284d += j11;
                    }
                    if (z13) {
                        jVar.e += j11;
                    }
                    if (z14) {
                        jVar.f += j11;
                    }
                    if (z15) {
                        jVar.g += j11;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j10));
                    contentValues.put("daily_public_events_count", Long.valueOf(jVar.f1281a));
                    contentValues.put("daily_events_count", Long.valueOf(jVar.f1282b));
                    contentValues.put("daily_conversions_count", Long.valueOf(jVar.f1283c));
                    contentValues.put("daily_error_events_count", Long.valueOf(jVar.f1284d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(jVar.e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(jVar.f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(jVar.g));
                    sQLiteDatabaseV.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.f1540i.c(w0.o(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f.d(w0.o(str), "Error updating daily counts. appId", e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return jVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final boolean m(String str) {
        j3[] j3VarArr = {j3.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(j3VarArr[0].f1294a));
        String strJ = J(arrayList);
        String strI = I();
        StringBuilder sb = new StringBuilder(strJ.length() + 61 + strI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strJ);
        sb.append(" AND NOT ");
        sb.append(strI);
        return Q(sb.toString(), new String[]{str}) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a3.x m0(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            c1.u1 r1 = r11.f1149a
            i0.y.d(r12)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.V()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r4 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r0 != 0) goto L30
            goto L7f
        L30:
            r0 = 0
            byte[] r0 = r3.getBlob(r0)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r5 = 2
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            boolean r6 = r3.moveToNext()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r6 == 0) goto L5b
            c1.w0 r6 = r1.f     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            c1.u1.m(r6)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            c1.u0 r6 = r6.f     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            c1.v0 r8 = c1.w0.o(r12)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r6.c(r8, r7)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            goto L5b
        L56:
            r0 = move-exception
            r12 = r0
            goto L68
        L59:
            r0 = move-exception
            goto L6f
        L5b:
            if (r0 != 0) goto L5e
            goto L7f
        L5e:
            a3.x r6 = new a3.x     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r7 = 4
            r6.<init>(r0, r4, r5, r7)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r3.close()
            return r6
        L68:
            r2 = r3
            goto L85
        L6a:
            r0 = move-exception
            r12 = r0
            goto L85
        L6d:
            r0 = move-exception
            r3 = r2
        L6f:
            c1.w0 r1 = r1.f     // Catch: java.lang.Throwable -> L56
            c1.u1.m(r1)     // Catch: java.lang.Throwable -> L56
            c1.u0 r1 = r1.f     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "Error querying remote config. appId"
            c1.v0 r12 = c1.w0.o(r12)     // Catch: java.lang.Throwable -> L56
            r1.d(r12, r4, r0)     // Catch: java.lang.Throwable -> L56
        L7f:
            if (r3 == 0) goto L84
            r3.close()
        L84:
            return r2
        L85:
            if (r2 == 0) goto L8a
            r2.close()
        L8a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.m0(java.lang.String):a3.x");
    }

    public final void n(Long l10) {
        u1 u1Var = this.f1149a;
        g();
        h();
        try {
            if (V().delete("upload_queue", "rowid=?", new String[]{l10.toString()}) != 1) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.b("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(e, "Failed to delete a MeasurementBatch in a upload_queue table");
            throw e;
        }
    }

    public final void n0(com.google.android.gms.internal.measurement.k3 k3Var, boolean z9) {
        g();
        h();
        i0.y.d(k3Var.p());
        if (!k3Var.b2()) {
            p8.u.e();
            return;
        }
        q();
        u1 u1Var = this.f1149a;
        n0.a aVar = u1Var.f1481k;
        w0 w0Var = u1Var.f;
        aVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC2 = k3Var.c2();
        e0 e0Var = f0.S;
        if (jC2 < jCurrentTimeMillis - ((Long) e0Var.a(null)).longValue() || k3Var.c2() > ((Long) e0Var.a(null)).longValue() + jCurrentTimeMillis) {
            u1.m(w0Var);
            w0Var.f1540i.e("Storing bundle outside of the max uploading time span. appId, now, timestamp", w0.o(k3Var.p()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(k3Var.c2()));
        }
        byte[] bArrA = k3Var.a();
        try {
            a1 a1Var = this.f1335b.g;
            v4.U(a1Var);
            byte[] bArrS = a1Var.S(bArrA);
            u1.m(w0Var);
            w0Var.f1545n.c(Integer.valueOf(bArrS.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put(MBridgeConstans.APP_ID, k3Var.p());
            contentValues.put("bundle_end_timestamp", Long.valueOf(k3Var.c2()));
            contentValues.put(DataSchemeDataSource.SCHEME_DATA, bArrS);
            contentValues.put("has_realtime", Integer.valueOf(z9 ? 1 : 0));
            if (k3Var.p0()) {
                contentValues.put("retry_count", Integer.valueOf(k3Var.q0()));
            }
            try {
                if (V().insert("queue", null, contentValues) == -1) {
                    u1.m(w0Var);
                    w0Var.f.c(w0.o(k3Var.p()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e) {
                u1.m(w0Var);
                w0Var.f.d(w0.o(k3Var.p()), "Error storing bundle. appId", e);
            }
        } catch (IOException e3) {
            u1.m(w0Var);
            w0Var.f.d(w0.o(k3Var.p()), "Data loss. Failed to serialize bundle. appId", e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.V()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L35
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L22:
            r0 = move-exception
            goto L3b
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            c1.u1 r3 = r6.f1149a     // Catch: java.lang.Throwable -> L1a
            c1.w0 r3 = r3.f     // Catch: java.lang.Throwable -> L1a
            c1.u1.m(r3)     // Catch: java.lang.Throwable -> L1a
            c1.u0 r3 = r3.f     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.c(r2, r4)     // Catch: java.lang.Throwable -> L1a
        L35:
            if (r0 == 0) goto L3a
            r0.close()
        L3a:
            return r1
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.o():java.lang.String");
    }

    public final void p(long j10) {
        g();
        h();
        try {
            if (V().delete("queue", "rowid=?", new String[]{String.valueOf(j10)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.c(e, "Failed to delete a bundle in a queue table");
            throw e;
        }
    }

    public final void q() {
        g();
        h();
        if (N()) {
            v4 v4Var = this.f1335b;
            long jA = v4Var.f1522i.e.a();
            u1 u1Var = this.f1149a;
            u1Var.f1481k.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) f0.N.a(null)).longValue()) {
                v4Var.f1522i.e.b(jElapsedRealtime);
                g();
                h();
                if (N()) {
                    SQLiteDatabase sQLiteDatabaseV = V();
                    u1Var.f1481k.getClass();
                    int iDelete = sQLiteDatabaseV.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) f0.S.a(null)).longValue())});
                    if (iDelete > 0) {
                        w0 w0Var = u1Var.f;
                        u1.m(w0Var);
                        w0Var.f1545n.c(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    public final void r(ArrayList arrayList) throws SQLException {
        g();
        h();
        i0.y.g(arrayList);
        if (arrayList.size() == 0) {
            com.google.gson.internal.a.n("Given Integer is zero");
            return;
        }
        if (N()) {
            String strJoin = TextUtils.join(",", arrayList);
            String strY = androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(String.valueOf(strJoin).length() + 2), "(", strJoin, ")");
            long jQ = Q(androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(strY.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", strY, " AND retry_count =  2147483647 LIMIT 1"), null);
            u1 u1Var = this.f1149a;
            if (jQ > 0) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.b("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseV = V();
                StringBuilder sb = new StringBuilder(strY.length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(strY);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseV.execSQL(sb.toString());
            } catch (SQLiteException e) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f.c(e, "Error incrementing retry count. error");
            }
        }
    }

    public final void s(Long l10) {
        g();
        h();
        if (N()) {
            StringBuilder sb = new StringBuilder(l10.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l10);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            long jQ = Q(sb.toString(), null);
            u1 u1Var = this.f1149a;
            if (jQ > 0) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.b("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseV = V();
                u1Var.f1481k.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l10.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l10);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseV.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f.c(e, "Error incrementing retry count. error");
            }
        }
    }

    public final Object t(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        u1 u1Var = this.f1149a;
        if (type == 0) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
            return null;
        }
        w0 w0Var3 = u1Var.f;
        u1.m(w0Var3);
        w0Var3.f.b("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0091 A[Catch: all -> 0x006b, SQLiteException -> 0x00a2, TryCatch #0 {SQLiteException -> 0x00a2, blocks: (B:15:0x0070, B:17:0x0091, B:20:0x00a4), top: B:30:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4 A[Catch: all -> 0x006b, SQLiteException -> 0x00a2, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a2, blocks: (B:15:0x0070, B:17:0x0091, B:20:0x00a4), top: B:30:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long u(java.lang.String r14) {
        /*
            r13 = this;
            c1.u1 r0 = r13.f1149a
            java.lang.String r1 = "select first_open_count from app2 where app_id=?"
            i0.y.d(r14)
            java.lang.String r2 = "first_open_count"
            i0.y.d(r2)
            r13.g()
            r13.h()
            android.database.sqlite.SQLiteDatabase r3 = r13.V()
            r3.beginTransaction()
            r4 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = 48
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String[] r6 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = -1
            long r9 = r13.R(r1, r6, r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            java.lang.String r6 = "app2"
            java.lang.String r11 = "app_id"
            if (r1 != 0) goto L70
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r10 = "previous_install_count"
            r1.put(r10, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r10 = 5
            long r9 = r3.insertWithOnConflict(r6, r9, r1, r10)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 != 0) goto L6f
            c1.w0 r1 = r0.f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            c1.u1.m(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            c1.u0 r1 = r1.f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "Failed to insert column (got -1). appId"
            c1.v0 r9 = c1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.d(r9, r6, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            goto Lbb
        L6b:
            r14 = move-exception
            goto Lbf
        L6d:
            r1 = move-exception
            goto Laa
        L6f:
            r9 = r4
        L70:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r11 = 1
            long r11 = r11 + r9
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r2, r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r11 = "app_id = ?"
            java.lang.String[] r12 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = r3.update(r6, r1, r11, r12)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            long r11 = (long) r1     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 != 0) goto La4
            c1.w0 r1 = r0.f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            c1.u1.m(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            c1.u0 r1 = r1.f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r4 = "Failed to update column (got 0). appId"
            c1.v0 r5 = c1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.d(r5, r4, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            goto Lbb
        La2:
            r1 = move-exception
            goto La9
        La4:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r7 = r9
            goto Lbb
        La9:
            r4 = r9
        Laa:
            c1.w0 r0 = r0.f     // Catch: java.lang.Throwable -> L6b
            c1.u1.m(r0)     // Catch: java.lang.Throwable -> L6b
            c1.u0 r0 = r0.f     // Catch: java.lang.Throwable -> L6b
            java.lang.String r6 = "Error inserting column. appId"
            c1.v0 r14 = c1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b
            r0.e(r6, r14, r2, r1)     // Catch: java.lang.Throwable -> L6b
            r7 = r4
        Lbb:
            r3.endTransaction()
            return r7
        Lbf:
            r3.endTransaction()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.u(java.lang.String):long");
    }

    public final boolean v(String str, String str2) {
        return Q("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final long w(String str) {
        i0.y.d(str);
        return R("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final void x(String str, Long l10, long j10, com.google.android.gms.internal.measurement.c3 c3Var) {
        g();
        h();
        i0.y.g(c3Var);
        i0.y.d(str);
        byte[] bArrA = c3Var.a();
        u1 u1Var = this.f1149a;
        w0 w0Var = u1Var.f;
        w0 w0Var2 = u1Var.f;
        u1.m(w0Var);
        w0Var.f1545n.d(u1Var.f1480j.a(str), "Saving complex main event, appId, data size", Integer.valueOf(bArrA.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrA);
        try {
            if (V().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                u1.m(w0Var2);
                w0Var2.f.c(w0.o(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e) {
            u1.m(w0Var2);
            w0Var2.f.d(w0.o(str), "Error storing complex main event. appId", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0287 A[Catch: SQLiteException -> 0x02a3, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x02a3, blocks: (B:94:0x026c, B:96:0x0287), top: B:113:0x026c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.lang.String r25, java.lang.Long r26, java.lang.String r27, android.os.Bundle r28) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.y(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.k2 z(java.lang.String r5) {
        /*
            r4 = this;
            c1.u1 r0 = r4.f1149a
            i0.y.g(r5)
            r4.g()
            r4.h()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r1 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.V()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            android.database.Cursor r5 = r3.rawQuery(r1, r5)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            if (r1 != 0) goto L34
            c1.w0 r1 = r0.f     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            c1.u1.m(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            c1.u0 r1 = r1.f1545n     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            java.lang.String r3 = "No data found"
            r1.b(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
        L2c:
            r5.close()
            goto L5a
        L30:
            r0 = move-exception
            goto L43
        L32:
            r1 = move-exception
            goto L4b
        L34:
            r1 = 0
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            r3 = 1
            int r3 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            c1.k2 r2 = c1.k2.c(r3, r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            goto L2c
        L43:
            r2 = r5
            goto L60
        L45:
            r5 = move-exception
            r0 = r5
            goto L60
        L48:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L4b:
            c1.w0 r0 = r0.f     // Catch: java.lang.Throwable -> L30
            c1.u1.m(r0)     // Catch: java.lang.Throwable -> L30
            c1.u0 r0 = r0.f     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Error querying database."
            r0.c(r1, r3)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L5a
            goto L2c
        L5a:
            if (r2 != 0) goto L5f
            c1.k2 r5 = c1.k2.f1301c
            return r5
        L5f:
            return r2
        L60:
            if (r2 == 0) goto L65
            r2.close()
        L65:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n.z(java.lang.String):c1.k2");
    }

    @Override // c1.q4
    public final void j() {
    }
}
