package androidx.work.impl.model;

import a3.q;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import g7.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import s6.w;
import t6.a0;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkSpec> __insertAdapterOfWorkSpec;
    private final EntityDeleteOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfWorkSpec = new EntityInsertAdapter<WorkSpec>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, WorkSpec workSpec) {
                sQLiteStatement.getClass();
                workSpec.getClass();
                sQLiteStatement.mo92bindText(1, workSpec.id);
                sQLiteStatement.mo90bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                sQLiteStatement.mo92bindText(3, workSpec.workerClassName);
                sQLiteStatement.mo92bindText(4, workSpec.inputMergerClassName);
                Data.Companion companion = Data.Companion;
                sQLiteStatement.mo88bindBlob(5, companion.toByteArrayInternalV1(workSpec.input));
                sQLiteStatement.mo88bindBlob(6, companion.toByteArrayInternalV1(workSpec.output));
                sQLiteStatement.mo90bindLong(7, workSpec.initialDelay);
                sQLiteStatement.mo90bindLong(8, workSpec.intervalDuration);
                sQLiteStatement.mo90bindLong(9, workSpec.flexDuration);
                sQLiteStatement.mo90bindLong(10, workSpec.runAttemptCount);
                sQLiteStatement.mo90bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                sQLiteStatement.mo90bindLong(12, workSpec.backoffDelayDuration);
                sQLiteStatement.mo90bindLong(13, workSpec.lastEnqueueTime);
                sQLiteStatement.mo90bindLong(14, workSpec.minimumRetentionDuration);
                sQLiteStatement.mo90bindLong(15, workSpec.scheduleRequestedAt);
                sQLiteStatement.mo90bindLong(16, workSpec.expedited ? 1L : 0L);
                sQLiteStatement.mo90bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                sQLiteStatement.mo90bindLong(18, workSpec.getPeriodCount());
                sQLiteStatement.mo90bindLong(19, workSpec.getGeneration());
                sQLiteStatement.mo90bindLong(20, workSpec.getNextScheduleTimeOverride());
                sQLiteStatement.mo90bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                sQLiteStatement.mo90bindLong(22, workSpec.getStopReason());
                String traceTag = workSpec.getTraceTag();
                if (traceTag == null) {
                    sQLiteStatement.mo91bindNull(23);
                } else {
                    sQLiteStatement.mo92bindText(23, traceTag);
                }
                Boolean backOffOnSystemInterruptions = workSpec.getBackOffOnSystemInterruptions();
                if ((backOffOnSystemInterruptions != null ? Integer.valueOf(backOffOnSystemInterruptions.booleanValue() ? 1 : 0) : null) == null) {
                    sQLiteStatement.mo91bindNull(24);
                } else {
                    sQLiteStatement.mo90bindLong(24, r0.intValue());
                }
                Constraints constraints = workSpec.constraints;
                sQLiteStatement.mo90bindLong(25, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                sQLiteStatement.mo88bindBlob(26, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat$work_runtime_release()));
                sQLiteStatement.mo90bindLong(27, constraints.requiresCharging() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(28, constraints.requiresDeviceIdle() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(29, constraints.requiresBatteryNotLow() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(30, constraints.requiresStorageNotLow() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(31, constraints.getContentTriggerUpdateDelayMillis());
                sQLiteStatement.mo90bindLong(32, constraints.getContentTriggerMaxDelayMillis());
                sQLiteStatement.mo88bindBlob(33, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`backoff_on_system_interruptions`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeleteOrUpdateAdapter<WorkSpec>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement sQLiteStatement, WorkSpec workSpec) {
                sQLiteStatement.getClass();
                workSpec.getClass();
                sQLiteStatement.mo92bindText(1, workSpec.id);
                sQLiteStatement.mo90bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                sQLiteStatement.mo92bindText(3, workSpec.workerClassName);
                sQLiteStatement.mo92bindText(4, workSpec.inputMergerClassName);
                Data.Companion companion = Data.Companion;
                sQLiteStatement.mo88bindBlob(5, companion.toByteArrayInternalV1(workSpec.input));
                sQLiteStatement.mo88bindBlob(6, companion.toByteArrayInternalV1(workSpec.output));
                sQLiteStatement.mo90bindLong(7, workSpec.initialDelay);
                sQLiteStatement.mo90bindLong(8, workSpec.intervalDuration);
                sQLiteStatement.mo90bindLong(9, workSpec.flexDuration);
                sQLiteStatement.mo90bindLong(10, workSpec.runAttemptCount);
                sQLiteStatement.mo90bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                sQLiteStatement.mo90bindLong(12, workSpec.backoffDelayDuration);
                sQLiteStatement.mo90bindLong(13, workSpec.lastEnqueueTime);
                sQLiteStatement.mo90bindLong(14, workSpec.minimumRetentionDuration);
                sQLiteStatement.mo90bindLong(15, workSpec.scheduleRequestedAt);
                sQLiteStatement.mo90bindLong(16, workSpec.expedited ? 1L : 0L);
                sQLiteStatement.mo90bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                sQLiteStatement.mo90bindLong(18, workSpec.getPeriodCount());
                sQLiteStatement.mo90bindLong(19, workSpec.getGeneration());
                sQLiteStatement.mo90bindLong(20, workSpec.getNextScheduleTimeOverride());
                sQLiteStatement.mo90bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                sQLiteStatement.mo90bindLong(22, workSpec.getStopReason());
                String traceTag = workSpec.getTraceTag();
                if (traceTag == null) {
                    sQLiteStatement.mo91bindNull(23);
                } else {
                    sQLiteStatement.mo92bindText(23, traceTag);
                }
                Boolean backOffOnSystemInterruptions = workSpec.getBackOffOnSystemInterruptions();
                if ((backOffOnSystemInterruptions != null ? Integer.valueOf(backOffOnSystemInterruptions.booleanValue() ? 1 : 0) : null) == null) {
                    sQLiteStatement.mo91bindNull(24);
                } else {
                    sQLiteStatement.mo90bindLong(24, r0.intValue());
                }
                Constraints constraints = workSpec.constraints;
                sQLiteStatement.mo90bindLong(25, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                sQLiteStatement.mo88bindBlob(26, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat$work_runtime_release()));
                sQLiteStatement.mo90bindLong(27, constraints.requiresCharging() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(28, constraints.requiresDeviceIdle() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(29, constraints.requiresBatteryNotLow() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(30, constraints.requiresStorageNotLow() ? 1L : 0L);
                sQLiteStatement.mo90bindLong(31, constraints.getContentTriggerUpdateDelayMillis());
                sQLiteStatement.mo90bindLong(32, constraints.getContentTriggerMaxDelayMillis());
                sQLiteStatement.mo88bindBlob(33, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
                sQLiteStatement.mo92bindText(34, workSpec.id);
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`backoff_on_system_interruptions` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }
        };
    }

    private final void __fetchRelationshipWorkProgressAsandroidxWorkData(SQLiteConnection sQLiteConnection, ArrayMap<String, List<Data>> arrayMap) {
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new h(this, sQLiteConnection, 0));
            return;
        }
        StringBuilder sbV = a3.a.v("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        StringUtil.appendPlaceholders(sbV, setKeySet.size());
        sbV.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbV.toString());
        Iterator<String> it = setKeySet.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo92bindText(i10, it.next());
            i10++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                List<Data> list = arrayMap.get(sQLiteStatementPrepare.getText(columnIndex));
                if (list != null) {
                    list.add(Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(0)));
                }
            }
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap);
        return w.f12711a;
    }

    private final void __fetchRelationshipWorkTagAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap<String, List<String>> arrayMap) {
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new h(this, sQLiteConnection, 1));
            return;
        }
        StringBuilder sbV = a3.a.v("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        StringUtil.appendPlaceholders(sbV, setKeySet.size());
        sbV.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbV.toString());
        Iterator<String> it = setKeySet.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo92bindText(i10, it.next());
            i10++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                List<String> list = arrayMap.get(sQLiteStatementPrepare.getText(columnIndex));
                if (list != null) {
                    list.add(sQLiteStatementPrepare.getText(0));
                }
            }
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w __fetchRelationshipWorkTagAsjavaLangString$lambda$52(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countNonFinishedContentUriTriggerWorkers$lambda$36(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w delete$lambda$37(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllEligibleWorkSpecsForScheduling$lambda$29(String str, int i10, SQLiteConnection sQLiteConnection) {
        int i11;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, i10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i12 = columnIndexOrThrow13;
                int i13 = columnIndexOrThrow14;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(i12);
                long j15 = sQLiteStatementPrepare.getLong(i13);
                int i17 = columnIndexOrThrow15;
                long j16 = sQLiteStatementPrepare.getLong(i17);
                columnIndexOrThrow15 = i17;
                int i18 = columnIndexOrThrow16;
                int i19 = columnIndexOrThrow3;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i20 = columnIndexOrThrow17;
                int i21 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i20));
                int i22 = columnIndexOrThrow18;
                int i23 = (int) sQLiteStatementPrepare.getLong(i22);
                int i24 = columnIndexOrThrow19;
                int i25 = (int) sQLiteStatementPrepare.getLong(i24);
                int i26 = columnIndexOrThrow20;
                long j17 = sQLiteStatementPrepare.getLong(i26);
                int i27 = columnIndexOrThrow21;
                int i28 = (int) sQLiteStatementPrepare.getLong(i27);
                columnIndexOrThrow21 = i27;
                int i29 = columnIndexOrThrow22;
                int i30 = (int) sQLiteStatementPrepare.getLong(i29);
                int i31 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i32)) {
                    i11 = i31;
                    columnIndexOrThrow22 = i29;
                    numValueOf = null;
                } else {
                    i11 = i31;
                    columnIndexOrThrow22 = i29;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i32));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                Boolean bool = boolValueOf;
                int i33 = columnIndexOrThrow25;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i34));
                int i35 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                int i36 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                int i37 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                columnIndexOrThrow29 = i37;
                int i38 = columnIndexOrThrow30;
                int i39 = columnIndexOrThrow31;
                int i40 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i39;
                int i41 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i38)) != 0, sQLiteStatementPrepare.getLong(i39), sQLiteStatementPrepare.getLong(i40), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i41))), i14, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25, j17, i28, i30, text4, bool));
                columnIndexOrThrow28 = i36;
                columnIndexOrThrow4 = i21;
                columnIndexOrThrow17 = i20;
                columnIndexOrThrow18 = i22;
                columnIndexOrThrow19 = i24;
                columnIndexOrThrow20 = i26;
                columnIndexOrThrow23 = i11;
                columnIndexOrThrow24 = i32;
                columnIndexOrThrow25 = i33;
                columnIndexOrThrow26 = i34;
                columnIndexOrThrow27 = i35;
                columnIndexOrThrow33 = i41;
                columnIndexOrThrow32 = i40;
                columnIndexOrThrow30 = i38;
                columnIndexOrThrow = i15;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow14 = i13;
                columnIndexOrThrow2 = i16;
                columnIndexOrThrow3 = i19;
                columnIndexOrThrow16 = i18;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllUnfinishedWork$lambda$21(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllWorkSpecIds$lambda$5(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllWorkSpecIdsLiveData$lambda$6(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getEligibleWorkForScheduling$lambda$25(String str, int i10, SQLiteConnection sQLiteConnection) {
        int i11;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, i10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i12 = columnIndexOrThrow13;
                int i13 = columnIndexOrThrow14;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(i12);
                long j15 = sQLiteStatementPrepare.getLong(i13);
                int i17 = columnIndexOrThrow15;
                long j16 = sQLiteStatementPrepare.getLong(i17);
                columnIndexOrThrow15 = i17;
                int i18 = columnIndexOrThrow16;
                int i19 = columnIndexOrThrow3;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i20 = columnIndexOrThrow17;
                int i21 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i20));
                int i22 = columnIndexOrThrow18;
                int i23 = (int) sQLiteStatementPrepare.getLong(i22);
                int i24 = columnIndexOrThrow19;
                int i25 = (int) sQLiteStatementPrepare.getLong(i24);
                int i26 = columnIndexOrThrow20;
                long j17 = sQLiteStatementPrepare.getLong(i26);
                int i27 = columnIndexOrThrow21;
                int i28 = (int) sQLiteStatementPrepare.getLong(i27);
                columnIndexOrThrow21 = i27;
                int i29 = columnIndexOrThrow22;
                int i30 = (int) sQLiteStatementPrepare.getLong(i29);
                int i31 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i32)) {
                    i11 = i31;
                    columnIndexOrThrow22 = i29;
                    numValueOf = null;
                } else {
                    i11 = i31;
                    columnIndexOrThrow22 = i29;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i32));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                Boolean bool = boolValueOf;
                int i33 = columnIndexOrThrow25;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i34));
                int i35 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                int i36 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                int i37 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                columnIndexOrThrow29 = i37;
                int i38 = columnIndexOrThrow30;
                int i39 = columnIndexOrThrow31;
                int i40 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i39;
                int i41 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i38)) != 0, sQLiteStatementPrepare.getLong(i39), sQLiteStatementPrepare.getLong(i40), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i41))), i14, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25, j17, i28, i30, text4, bool));
                columnIndexOrThrow28 = i36;
                columnIndexOrThrow4 = i21;
                columnIndexOrThrow17 = i20;
                columnIndexOrThrow18 = i22;
                columnIndexOrThrow19 = i24;
                columnIndexOrThrow20 = i26;
                columnIndexOrThrow23 = i11;
                columnIndexOrThrow24 = i32;
                columnIndexOrThrow25 = i33;
                columnIndexOrThrow26 = i34;
                columnIndexOrThrow27 = i35;
                columnIndexOrThrow33 = i41;
                columnIndexOrThrow32 = i40;
                columnIndexOrThrow30 = i38;
                columnIndexOrThrow = i15;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow14 = i13;
                columnIndexOrThrow2 = i16;
                columnIndexOrThrow3 = i19;
                columnIndexOrThrow16 = i18;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getEligibleWorkForSchedulingWithContentUris$lambda$27(String str, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i12 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i14 = columnIndexOrThrow2;
                int i15 = columnIndexOrThrow3;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                long j15 = sQLiteStatementPrepare.getLong(i12);
                int i16 = columnIndexOrThrow15;
                long j16 = sQLiteStatementPrepare.getLong(i16);
                int i17 = columnIndexOrThrow;
                int i18 = columnIndexOrThrow16;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = columnIndexOrThrow5;
                int i23 = (int) sQLiteStatementPrepare.getLong(i21);
                int i24 = columnIndexOrThrow19;
                int i25 = (int) sQLiteStatementPrepare.getLong(i24);
                int i26 = columnIndexOrThrow20;
                long j17 = sQLiteStatementPrepare.getLong(i26);
                int i27 = columnIndexOrThrow21;
                int i28 = (int) sQLiteStatementPrepare.getLong(i27);
                int i29 = columnIndexOrThrow22;
                int i30 = (int) sQLiteStatementPrepare.getLong(i29);
                int i31 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i32)) {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = null;
                } else {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i32));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                int i33 = columnIndexOrThrow25;
                Boolean bool = boolValueOf;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i34));
                columnIndexOrThrow25 = i33;
                columnIndexOrThrow26 = i34;
                int i35 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                columnIndexOrThrow27 = i35;
                int i36 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                int i37 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                columnIndexOrThrow29 = i37;
                int i38 = columnIndexOrThrow30;
                int i39 = columnIndexOrThrow31;
                int i40 = columnIndexOrThrow32;
                int i41 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i41;
                arrayList2.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i38)) != 0, sQLiteStatementPrepare.getLong(i39), sQLiteStatementPrepare.getLong(i40), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i41))), i13, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25, j17, i10, i30, text4, bool));
                columnIndexOrThrow30 = i38;
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i19;
                columnIndexOrThrow19 = i24;
                columnIndexOrThrow22 = i11;
                columnIndexOrThrow24 = i32;
                columnIndexOrThrow31 = i39;
                columnIndexOrThrow32 = i40;
                columnIndexOrThrow2 = i14;
                columnIndexOrThrow14 = i12;
                columnIndexOrThrow3 = i15;
                arrayList = arrayList2;
                columnIndexOrThrow = i17;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i18;
                columnIndexOrThrow20 = i26;
                columnIndexOrThrow21 = i27;
                columnIndexOrThrow23 = i31;
                columnIndexOrThrow28 = i36;
                columnIndexOrThrow5 = i22;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getInputsFromPrerequisites$lambda$18(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(0)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getRecentlyCompletedWork$lambda$35(String str, long j10, SQLiteConnection sQLiteConnection) {
        int i10;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, j10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i11 = columnIndexOrThrow13;
                int i12 = columnIndexOrThrow14;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i14 = columnIndexOrThrow;
                int i15 = columnIndexOrThrow2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j14 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j15 = sQLiteStatementPrepare.getLong(i11);
                long j16 = sQLiteStatementPrepare.getLong(i12);
                int i16 = columnIndexOrThrow15;
                long j17 = sQLiteStatementPrepare.getLong(i16);
                columnIndexOrThrow15 = i16;
                int i17 = columnIndexOrThrow16;
                int i18 = columnIndexOrThrow3;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = (int) sQLiteStatementPrepare.getLong(i21);
                int i23 = columnIndexOrThrow19;
                int i24 = (int) sQLiteStatementPrepare.getLong(i23);
                int i25 = columnIndexOrThrow20;
                long j18 = sQLiteStatementPrepare.getLong(i25);
                int i26 = columnIndexOrThrow21;
                int i27 = (int) sQLiteStatementPrepare.getLong(i26);
                columnIndexOrThrow21 = i26;
                int i28 = columnIndexOrThrow22;
                int i29 = (int) sQLiteStatementPrepare.getLong(i28);
                int i30 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i30) ? null : sQLiteStatementPrepare.getText(i30);
                int i31 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i31)) {
                    i10 = i30;
                    columnIndexOrThrow22 = i28;
                    numValueOf = null;
                } else {
                    i10 = i30;
                    columnIndexOrThrow22 = i28;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i31));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                Boolean bool = boolValueOf;
                int i32 = columnIndexOrThrow25;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i32));
                int i33 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i33));
                int i34 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i34)) != 0;
                int i35 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                int i36 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                columnIndexOrThrow29 = i36;
                int i37 = columnIndexOrThrow30;
                int i38 = columnIndexOrThrow31;
                int i39 = columnIndexOrThrow32;
                columnIndexOrThrow31 = i38;
                int i40 = columnIndexOrThrow33;
                arrayList.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j11, j12, j13, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i37)) != 0, sQLiteStatementPrepare.getLong(i38), sQLiteStatementPrepare.getLong(i39), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i40))), i13, backoffPolicyIntToBackoffPolicy, j14, j15, j16, j17, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i22, i24, j18, i27, i29, text4, bool));
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i19;
                columnIndexOrThrow18 = i21;
                columnIndexOrThrow19 = i23;
                columnIndexOrThrow20 = i25;
                columnIndexOrThrow23 = i10;
                columnIndexOrThrow24 = i31;
                columnIndexOrThrow25 = i32;
                columnIndexOrThrow26 = i33;
                columnIndexOrThrow27 = i34;
                columnIndexOrThrow28 = i35;
                columnIndexOrThrow33 = i40;
                columnIndexOrThrow32 = i39;
                columnIndexOrThrow30 = i37;
                columnIndexOrThrow = i14;
                columnIndexOrThrow13 = i11;
                columnIndexOrThrow14 = i12;
                columnIndexOrThrow2 = i15;
                columnIndexOrThrow3 = i18;
                columnIndexOrThrow16 = i17;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getRunningWork$lambda$33(String str, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i12 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i14 = columnIndexOrThrow2;
                int i15 = columnIndexOrThrow3;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                long j15 = sQLiteStatementPrepare.getLong(i12);
                int i16 = columnIndexOrThrow15;
                long j16 = sQLiteStatementPrepare.getLong(i16);
                int i17 = columnIndexOrThrow;
                int i18 = columnIndexOrThrow16;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = columnIndexOrThrow5;
                int i23 = (int) sQLiteStatementPrepare.getLong(i21);
                int i24 = columnIndexOrThrow19;
                int i25 = (int) sQLiteStatementPrepare.getLong(i24);
                int i26 = columnIndexOrThrow20;
                long j17 = sQLiteStatementPrepare.getLong(i26);
                int i27 = columnIndexOrThrow21;
                int i28 = (int) sQLiteStatementPrepare.getLong(i27);
                int i29 = columnIndexOrThrow22;
                int i30 = (int) sQLiteStatementPrepare.getLong(i29);
                int i31 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i32)) {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = null;
                } else {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i32));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                int i33 = columnIndexOrThrow25;
                Boolean bool = boolValueOf;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i34));
                columnIndexOrThrow25 = i33;
                columnIndexOrThrow26 = i34;
                int i35 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                columnIndexOrThrow27 = i35;
                int i36 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                int i37 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                columnIndexOrThrow29 = i37;
                int i38 = columnIndexOrThrow30;
                int i39 = columnIndexOrThrow31;
                int i40 = columnIndexOrThrow32;
                int i41 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i41;
                arrayList2.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i38)) != 0, sQLiteStatementPrepare.getLong(i39), sQLiteStatementPrepare.getLong(i40), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i41))), i13, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25, j17, i10, i30, text4, bool));
                columnIndexOrThrow30 = i38;
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i19;
                columnIndexOrThrow19 = i24;
                columnIndexOrThrow22 = i11;
                columnIndexOrThrow24 = i32;
                columnIndexOrThrow31 = i39;
                columnIndexOrThrow32 = i40;
                columnIndexOrThrow2 = i14;
                columnIndexOrThrow14 = i12;
                columnIndexOrThrow3 = i15;
                arrayList = arrayList2;
                columnIndexOrThrow = i17;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i18;
                columnIndexOrThrow20 = i26;
                columnIndexOrThrow21 = i27;
                columnIndexOrThrow23 = i31;
                columnIndexOrThrow28 = i36;
                columnIndexOrThrow5 = i22;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long getScheduleRequestedAtLiveData$lambda$23(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getScheduledWork$lambda$31(String str, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        Integer numValueOf;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                int i12 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                int i14 = columnIndexOrThrow2;
                int i15 = columnIndexOrThrow3;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                long j15 = sQLiteStatementPrepare.getLong(i12);
                int i16 = columnIndexOrThrow15;
                long j16 = sQLiteStatementPrepare.getLong(i16);
                int i17 = columnIndexOrThrow;
                int i18 = columnIndexOrThrow16;
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i19 = columnIndexOrThrow17;
                int i20 = columnIndexOrThrow4;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(i19));
                int i21 = columnIndexOrThrow18;
                int i22 = columnIndexOrThrow5;
                int i23 = (int) sQLiteStatementPrepare.getLong(i21);
                int i24 = columnIndexOrThrow19;
                int i25 = (int) sQLiteStatementPrepare.getLong(i24);
                int i26 = columnIndexOrThrow20;
                long j17 = sQLiteStatementPrepare.getLong(i26);
                int i27 = columnIndexOrThrow21;
                int i28 = (int) sQLiteStatementPrepare.getLong(i27);
                int i29 = columnIndexOrThrow22;
                int i30 = (int) sQLiteStatementPrepare.getLong(i29);
                int i31 = columnIndexOrThrow23;
                Boolean boolValueOf = null;
                String text4 = sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31);
                int i32 = columnIndexOrThrow24;
                if (sQLiteStatementPrepare.isNull(i32)) {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = null;
                } else {
                    i10 = i28;
                    i11 = i29;
                    numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(i32));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                int i33 = columnIndexOrThrow25;
                Boolean bool = boolValueOf;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow26;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i34));
                columnIndexOrThrow25 = i33;
                columnIndexOrThrow26 = i34;
                int i35 = columnIndexOrThrow27;
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(i35)) != 0;
                columnIndexOrThrow27 = i35;
                int i36 = columnIndexOrThrow28;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i36)) != 0;
                int i37 = columnIndexOrThrow29;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                columnIndexOrThrow29 = i37;
                int i38 = columnIndexOrThrow30;
                int i39 = columnIndexOrThrow31;
                int i40 = columnIndexOrThrow32;
                int i41 = columnIndexOrThrow33;
                columnIndexOrThrow33 = i41;
                arrayList2.add(new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z10, z11, z12, ((int) sQLiteStatementPrepare.getLong(i38)) != 0, sQLiteStatementPrepare.getLong(i39), sQLiteStatementPrepare.getLong(i40), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i41))), i13, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25, j17, i10, i30, text4, bool));
                columnIndexOrThrow30 = i38;
                columnIndexOrThrow4 = i20;
                columnIndexOrThrow17 = i19;
                columnIndexOrThrow19 = i24;
                columnIndexOrThrow22 = i11;
                columnIndexOrThrow24 = i32;
                columnIndexOrThrow31 = i39;
                columnIndexOrThrow32 = i40;
                columnIndexOrThrow2 = i14;
                columnIndexOrThrow14 = i12;
                columnIndexOrThrow3 = i15;
                arrayList = arrayList2;
                columnIndexOrThrow = i17;
                columnIndexOrThrow15 = i16;
                columnIndexOrThrow16 = i18;
                columnIndexOrThrow20 = i26;
                columnIndexOrThrow21 = i27;
                columnIndexOrThrow23 = i31;
                columnIndexOrThrow28 = i36;
                columnIndexOrThrow5 = i22;
                columnIndexOrThrow18 = i21;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkInfo.State getState$lambda$7(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            WorkInfo.State stateIntToState = null;
            if (sQLiteStatementPrepare.step()) {
                Integer numValueOf = sQLiteStatementPrepare.isNull(0) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(0));
                if (numValueOf != null) {
                    stateIntToState = WorkTypeConverters.intToState(numValueOf.intValue());
                }
            }
            return stateIntToState;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getUnfinishedWorkWithName$lambda$20(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getUnfinishedWorkWithTag$lambda$19(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkSpec getWorkSpec$lambda$3(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "worker_class_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input_merger_class_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "input");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "output");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "initial_delay");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interval_duration");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "flex_duration");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_policy");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "minimum_retention_duration");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "schedule_requested_at");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "run_in_foreground");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "out_of_quota_policy");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "period_count");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stop_reason");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trace_tag");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "backoff_on_system_interruptions");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_type");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "required_network_request");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_charging");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_uri_triggers");
            WorkSpec workSpec = null;
            Boolean boolValueOf = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Data.Companion companion = Data.Companion;
                Data dataFromByteArray = companion.fromByteArray(blob);
                Data dataFromByteArray2 = companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndexOrThrow6));
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                long j12 = sQLiteStatementPrepare.getLong(columnIndexOrThrow9);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j13 = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                long j14 = sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                long j15 = sQLiteStatementPrepare.getLong(columnIndexOrThrow14);
                long j16 = sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                boolean z9 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16)) != 0;
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow18);
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow19);
                long j17 = sQLiteStatementPrepare.getLong(columnIndexOrThrow20);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow21);
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow22);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24));
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                workSpec = new WorkSpec(text, stateIntToState, text2, text3, dataFromByteArray, dataFromByteArray2, j10, j11, j12, new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(columnIndexOrThrow26)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow28)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow29)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow30)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow31), sQLiteStatementPrepare.getLong(columnIndexOrThrow32), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(columnIndexOrThrow33))), i10, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z9, outOfQuotaPolicyIntToOutOfQuotaPolicy, i11, i12, j17, i13, i14, text4, boolValueOf);
            }
            sQLiteStatementPrepare.close();
            return workSpec;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkSpecIdAndStatesForName$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new WorkSpec.IdAndState(sQLiteStatementPrepare.getText(0), WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(1))));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowDataForIds$lambda$11(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i11 = 1;
            int i12 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo92bindText(i12, (String) it.next());
                i12++;
            }
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i13 = (int) sQLiteStatementPrepare.getLong(3);
                int i14 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<Data>> arrayMap3 = arrayMap2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i15 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i16 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                List list2 = (List) objF0;
                Object objF02 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i13, backoffPolicyIntToBackoffPolicy, j13, j14, i15, i14, j15, i16, list2, (List) objF02));
                arrayMap2 = arrayMap3;
                i11 = 1;
                i10 = 0;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowForName$lambda$17(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoFlowForTag$lambda$13(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkSpec.WorkInfoPojo getWorkStatusPojoForId$lambda$8(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        WorkSpec.WorkInfoPojo workInfoPojo;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            if (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(0);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(1));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i10 = (int) sQLiteStatementPrepare.getLong(3);
                int i11 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i12 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i13 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                workInfoPojo = new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i10, backoffPolicyIntToBackoffPolicy, j13, j14, i12, i11, j15, i13, (List) objF0, (List) objF02);
            } else {
                workInfoPojo = null;
            }
            sQLiteStatementPrepare.close();
            return workInfoPojo;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoForIds$lambda$9(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i11 = 1;
            int i12 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo92bindText(i12, (String) it.next());
                i12++;
            }
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i13 = (int) sQLiteStatementPrepare.getLong(3);
                int i14 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<Data>> arrayMap3 = arrayMap2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i15 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i16 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                List list2 = (List) objF0;
                Object objF02 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i13, backoffPolicyIntToBackoffPolicy, j13, j14, i15, i14, j15, i16, list2, (List) objF02));
                arrayMap2 = arrayMap3;
                i11 = 1;
                i10 = 0;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoForName$lambda$15(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoForTag$lambda$12(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForIds$lambda$10(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i11 = 1;
            int i12 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo92bindText(i12, (String) it.next());
                i12++;
            }
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i13 = (int) sQLiteStatementPrepare.getLong(3);
                int i14 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<Data>> arrayMap3 = arrayMap2;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i15 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i16 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                List list2 = (List) objF0;
                Object objF02 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i13, backoffPolicyIntToBackoffPolicy, j13, j14, i15, i14, j15, i16, list2, (List) objF02));
                arrayMap2 = arrayMap3;
                i11 = 1;
                i10 = 0;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForName$lambda$16(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkStatusPojoLiveDataForTag$lambda$14(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i11 = 1;
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (true) {
                i10 = 0;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(i10);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(i11));
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(2));
                int i12 = (int) sQLiteStatementPrepare.getLong(3);
                int i13 = (int) sQLiteStatementPrepare.getLong(4);
                long j10 = sQLiteStatementPrepare.getLong(14);
                long j11 = sQLiteStatementPrepare.getLong(15);
                long j12 = sQLiteStatementPrepare.getLong(16);
                ArrayMap<String, List<String>> arrayMap3 = arrayMap;
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(17));
                long j13 = sQLiteStatementPrepare.getLong(18);
                long j14 = sQLiteStatementPrepare.getLong(19);
                int i14 = (int) sQLiteStatementPrepare.getLong(20);
                long j15 = sQLiteStatementPrepare.getLong(21);
                int i15 = (int) sQLiteStatementPrepare.getLong(22);
                Constraints constraints = new Constraints(WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(6)), WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(5)), ((int) sQLiteStatementPrepare.getLong(7)) != 0, ((int) sQLiteStatementPrepare.getLong(8)) != 0, ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, sQLiteStatementPrepare.getLong(11), sQLiteStatementPrepare.getLong(12), WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(13)));
                Object objF0 = a0.f0(arrayMap3, sQLiteStatementPrepare.getText(0));
                objF0.getClass();
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(0));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i12, backoffPolicyIntToBackoffPolicy, j13, j14, i14, i13, j15, i15, (List) objF0, (List) objF02));
                arrayMap = arrayMap3;
                i10 = 0;
                i11 = 1;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasUnfinishedWorkFlow$lambda$22(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            boolean z9 = false;
            if (sQLiteStatementPrepare.step()) {
                if (((int) sQLiteStatementPrepare.getLong(0)) != 0) {
                    z9 = true;
                }
            }
            return z9;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w incrementGeneration$lambda$50(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w incrementPeriodCount$lambda$40(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int incrementWorkSpecRunAttemptCount$lambda$43(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w insertWorkSpec$lambda$0(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        workSpecDao_Impl.__insertAdapterOfWorkSpec.insert(sQLiteConnection, (SQLiteConnection) workSpec);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int markWorkSpecScheduled$lambda$47(String str, long j10, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, j10);
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int resetScheduledState$lambda$48(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w resetWorkSpecNextScheduleTimeOverride$lambda$46(String str, String str2, int i10, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.mo90bindLong(2, i10);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int resetWorkSpecRunAttemptCount$lambda$44(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int setCancelledState$lambda$39(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w setLastEnqueueTime$lambda$42(String str, long j10, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, j10);
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w setNextScheduleTimeOverride$lambda$45(String str, long j10, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, j10);
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w setOutput$lambda$41(String str, Data data, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo88bindBlob(1, Data.Companion.toByteArrayInternalV1(data));
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int setState$lambda$38(String str, WorkInfo.State state, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, WorkTypeConverters.stateToInt(state));
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w setStopReason$lambda$51(String str, int i10, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo90bindLong(1, i10);
            sQLiteStatementPrepare.mo92bindText(2, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w updateWorkSpec$lambda$1(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        workSpecDao_Impl.__updateAdapterOfWorkSpec.handle(sQLiteConnection, workSpec);
        return w.f12711a;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int countNonFinishedContentUriTriggerWorkers() {
        return ((Number) DBUtil.performBlocking(this.__db, true, false, new q(10))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 12));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i10) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.b(i10, 3));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(9));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(15));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, (l) new q(16));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int i10) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.b(i10, 4));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(18));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 18));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(long j10) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.c(j10, 2));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(17));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        str.getClass();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, (l) new androidx.room.support.e(str, 24));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(14));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String str) {
        str.getClass();
        return (WorkInfo.State) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 23));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 14));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 21));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String str) {
        str.getClass();
        return (WorkSpec) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 17));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 13));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public u7.h getWorkStatusPojoFlowDataForIds(List<String> list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec"}, new e(sb.toString(), list, this, 0));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public u7.h getWorkStatusPojoFlowForName(String str) {
        str.getClass();
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, new d(str, this, 4));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public u7.h getWorkStatusPojoFlowForTag(String str) {
        str.getClass();
        return FlowUtil.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, new d(str, this, 0));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String str) {
        str.getClass();
        return (WorkSpec.WorkInfoPojo) DBUtil.performBlocking(this.__db, true, true, new d(str, this, 5));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        return (List) DBUtil.performBlocking(this.__db, true, true, new e(sb.toString(), list, this, 2));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, true, new d(str, this, 3));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, true, new d(str, this, 1));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, (l) new e(sb.toString(), list, this, 1));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        str.getClass();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, (l) new d(str, this, 2));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        str.getClass();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, (l) new d(str, this, 6));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public u7.h hasUnfinishedWorkFlow() {
        return FlowUtil.createFlow(this.__db, false, new String[]{"workspec"}, new q(12));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 19));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 16));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String str) {
        str.getClass();
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 22))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        workSpec.getClass();
        DBUtil.performBlocking(this.__db, false, true, new f(this, workSpec, 1));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String str, long j10) {
        str.getClass();
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new g(1, j10, str))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        DBUtil.performBlocking(this.__db, false, true, new q(11));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new q(13))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void resetWorkSpecNextScheduleTimeOverride(String str, int i10) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new c(str, i10, 3));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String str) {
        str.getClass();
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 15))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setCancelledState(String str) {
        str.getClass();
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 20))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueueTime(String str, long j10) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new g(2, j10, str));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setNextScheduleTimeOverride(String str, long j10) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new g(0, j10, str));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String str, Data data) {
        str.getClass();
        data.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a8.d(6, data, str));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State state, String str) {
        state.getClass();
        str.getClass();
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new a8.d(7, state, str))).intValue();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setStopReason(String str, int i10) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new c(i10, str));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(WorkSpec workSpec) {
        workSpec.getClass();
        DBUtil.performBlocking(this.__db, false, true, new f(this, workSpec, 0));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<m7.c> getRequiredConverters() {
            return t.f12808a;
        }

        private Companion() {
        }
    }
}
