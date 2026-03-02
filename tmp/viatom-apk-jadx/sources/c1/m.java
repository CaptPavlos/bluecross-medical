package c1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.j8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1329a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e2 f1330b;

    public m(Context context, String str) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        switch (this.f1329a) {
            case 0:
                n nVar = (n) this.f1330b;
                u1 u1Var = nVar.f1149a;
                u1 u1Var2 = nVar.f1149a;
                u1Var.getClass();
                s0 s0Var = nVar.e;
                if (s0Var.f1447a != 0) {
                    ((n0.a) s0Var.f1448b).getClass();
                    if (SystemClock.elapsedRealtime() - s0Var.f1447a < 3600000) {
                        throw new SQLiteException("Database open failed");
                    }
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException unused) {
                    ((n0.a) s0Var.f1448b).getClass();
                    s0Var.f1447a = SystemClock.elapsedRealtime();
                    w0 w0Var = u1Var2.f;
                    u1.m(w0Var);
                    w0Var.f.b("Opening the database failed, dropping and recreating it");
                    if (!u1Var2.f1475a.getDatabasePath("google_app_measurement.db").delete()) {
                        w0 w0Var2 = u1Var2.f;
                        u1.m(w0Var2);
                        w0Var2.f.c("google_app_measurement.db", "Failed to delete corrupted db file");
                    }
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        s0Var.f1447a = 0L;
                        return writableDatabase;
                    } catch (SQLiteException e) {
                        w0 w0Var3 = u1Var2.f;
                        u1.m(w0Var3);
                        w0Var3.f.c(e, "Failed to open freshly created database");
                        throw e;
                    }
                }
            default:
                p0 p0Var = (p0) this.f1330b;
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e3) {
                    throw e3;
                } catch (SQLiteException unused2) {
                    u1 u1Var3 = p0Var.f1149a;
                    w0 w0Var4 = u1Var3.f;
                    u1.m(w0Var4);
                    w0Var4.f.b("Opening the local database failed, dropping and recreating it");
                    if (!u1Var3.f1475a.getDatabasePath("google_app_measurement_local.db").delete()) {
                        w0 w0Var5 = u1Var3.f;
                        u1.m(w0Var5);
                        w0Var5.f.c("google_app_measurement_local.db", "Failed to delete corrupted local db file");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e7) {
                        w0 w0Var6 = p0Var.f1149a.f;
                        u1.m(w0Var6);
                        w0Var6.f.c(e7, "Failed to open local database. Events will bypass local storage");
                        return null;
                    }
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.f1329a) {
            case 0:
                w0 w0Var = ((n) this.f1330b).f1149a.f;
                u1.m(w0Var);
                l2.f(w0Var, sQLiteDatabase);
                break;
            default:
                w0 w0Var2 = ((p0) this.f1330b).f1149a.f;
                u1.m(w0Var2);
                l2.f(w0Var2, sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        int i12 = this.f1329a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        switch (this.f1329a) {
            case 0:
                u1 u1Var = ((n) this.f1330b).f1149a;
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                l2.d(w0Var, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", n.f);
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "events_snapshot", "CREATE TABLE IF NOT EXISTS events_snapshot ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, last_bundled_timestamp INTEGER, last_bundled_day INTEGER, last_sampled_complex_event_id INTEGER, last_sampling_rate INTEGER, last_exempt_from_sampling INTEGER, current_session_count INTEGER, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp,last_bundled_timestamp,last_bundled_day,last_sampled_complex_event_id,last_sampling_rate,last_exempt_from_sampling,current_session_count", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", n.h);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", n.f1336i);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", n.f1338k);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", n.f1337j);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", n.f1339l);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", n.f1340m);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", n.f1341n);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", n.f1342o);
                j8.a();
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "trigger_uris", "CREATE TABLE IF NOT EXISTS trigger_uris ( app_id TEXT NOT NULL, trigger_uri TEXT NOT NULL, timestamp_millis INTEGER NOT NULL, source INTEGER NOT NULL);", "app_id,trigger_uri,source,timestamp_millis", n.f1343p);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "upload_queue", "CREATE TABLE IF NOT EXISTS upload_queue ( app_id TEXT NOT NULL, upload_uri TEXT NOT NULL, upload_headers TEXT NOT NULL, upload_type INTEGER NOT NULL, measurement_batch BLOB NOT NULL, retry_count INTEGER NOT NULL, creation_timestamp INTEGER NOT NULL );", "app_id,upload_uri,upload_headers,upload_type,measurement_batch,retry_count,creation_timestamp", n.g);
                u1.m(w0Var2);
                l2.d(w0Var2, sQLiteDatabase, "no_data_mode_events", "CREATE TABLE IF NOT EXISTS no_data_mode_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, data BLOB NOT NULL, timestamp_millis INTEGER NOT NULL);", "app_id,name,data,timestamp_millis", null);
                break;
            default:
                w0 w0Var3 = ((p0) this.f1330b).f1149a.f;
                u1.m(w0Var3);
                l2.d(w0Var3, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", p0.e);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        int i12 = this.f1329a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(p0 p0Var, Context context) {
        this(context, "google_app_measurement_local.db");
        this.f1329a = 1;
        this.f1330b = p0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Context context) {
        this(context, "google_app_measurement.db");
        this.f1329a = 0;
        this.f1330b = nVar;
    }

    private final void a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    private final void b(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    private final void d(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    private final void e(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
