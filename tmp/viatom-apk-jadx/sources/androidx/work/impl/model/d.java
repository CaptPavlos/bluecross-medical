package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f733a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f734b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f735c;

    public /* synthetic */ d(String str, WorkSpecDao_Impl workSpecDao_Impl, int i10) {
        this.f733a = i10;
        this.f734b = str;
        this.f735c = workSpecDao_Impl;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f733a) {
            case 0:
                return WorkSpecDao_Impl.getWorkStatusPojoFlowForTag$lambda$13("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
            case 1:
                return WorkSpecDao_Impl.getWorkStatusPojoForTag$lambda$12("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
            case 2:
                return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForName$lambda$16("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
            case 3:
                return WorkSpecDao_Impl.getWorkStatusPojoForName$lambda$15("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
            case 4:
                return WorkSpecDao_Impl.getWorkStatusPojoFlowForName$lambda$17("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
            case 5:
                return WorkSpecDao_Impl.getWorkStatusPojoForId$lambda$8("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?", this.f734b, this.f735c, (SQLiteConnection) obj);
            default:
                return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForTag$lambda$14("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f734b, this.f735c, (SQLiteConnection) obj);
        }
    }
}
