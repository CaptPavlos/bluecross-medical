package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
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
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
    }

    private final void __fetchRelationshipWorkProgressAsandroidxWorkData(SQLiteConnection sQLiteConnection, ArrayMap<String, List<Data>> arrayMap) {
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new a(this, sQLiteConnection, 0));
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
    public static final w __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$4(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap);
        return w.f12711a;
    }

    private final void __fetchRelationshipWorkTagAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap<String, List<String>> arrayMap) {
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new a(this, sQLiteConnection, 1));
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
    public static final w __fetchRelationshipWorkTagAsjavaLangString$lambda$3(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojos$lambda$0(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z9;
        int i20;
        boolean z10;
        int i21;
        boolean z11;
        int i22;
        int i23;
        int i24;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i25 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                int i26 = columnIndex11;
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i24 = columnIndex10;
                } else {
                    i24 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i26;
                columnIndex10 = i24;
            }
            int i27 = columnIndex10;
            int i28 = columnIndex11;
            sQLiteStatementPrepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = sQLiteStatementPrepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndex3));
                long j10 = columnIndex4 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex4);
                long j11 = columnIndex5 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex5);
                long j12 = columnIndex6 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex6);
                boolean z12 = false;
                int i29 = columnIndex7 == -1 ? 0 : (int) sQLiteStatementPrepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndex8));
                long j13 = columnIndex9 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex9);
                int i30 = i27;
                long j14 = i30 == -1 ? 0L : sQLiteStatementPrepare.getLong(i30);
                int i31 = i28;
                if (i31 == -1) {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = 0;
                } else {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = (int) sQLiteStatementPrepare.getLong(i31);
                }
                int i32 = i25;
                if (i32 == -1) {
                    i13 = columnIndex4;
                    i14 = 0;
                } else {
                    i13 = columnIndex4;
                    i14 = (int) sQLiteStatementPrepare.getLong(i32);
                }
                int i33 = columnIndex13;
                long j15 = i33 == -1 ? 0L : sQLiteStatementPrepare.getLong(i33);
                int i34 = columnIndex14;
                if (i34 == -1) {
                    i15 = i32;
                    i16 = i33;
                    i17 = 0;
                } else {
                    i15 = i32;
                    i16 = i33;
                    i17 = (int) sQLiteStatementPrepare.getLong(i34);
                }
                int i35 = columnIndex15;
                if (i35 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i35));
                int i36 = columnIndex16;
                if (i36 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i36));
                int i37 = columnIndex17;
                if (i37 == -1) {
                    i18 = i35;
                    i19 = i36;
                    z9 = false;
                } else {
                    i18 = i35;
                    i19 = i36;
                    z9 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex18;
                if (i38 == -1) {
                    i20 = i37;
                    z10 = false;
                } else {
                    i20 = i37;
                    z10 = ((int) sQLiteStatementPrepare.getLong(i38)) != 0;
                }
                int i39 = columnIndex19;
                if (i39 == -1) {
                    i21 = columnIndex5;
                    z11 = false;
                } else {
                    i21 = columnIndex5;
                    z11 = ((int) sQLiteStatementPrepare.getLong(i39)) != 0;
                }
                int i40 = columnIndex20;
                if (i40 == -1) {
                    i22 = i38;
                    i23 = i39;
                } else {
                    i22 = i38;
                    i23 = i39;
                    if (((int) sQLiteStatementPrepare.getLong(i40)) != 0) {
                        z12 = true;
                    }
                }
                int i41 = columnIndex21;
                boolean z13 = z12;
                long j16 = i41 == -1 ? 0L : sQLiteStatementPrepare.getLong(i41);
                int i42 = columnIndex22;
                long j17 = i42 == -1 ? 0L : sQLiteStatementPrepare.getLong(i42);
                columnIndex21 = i41;
                int i43 = columnIndex23;
                if (i43 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z9, z10, z11, z13, j16, j17, WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i43)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(columnIndex));
                objF0.getClass();
                List list = (List) objF0;
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(columnIndex));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i29, backoffPolicyIntToBackoffPolicy, j13, j14, i12, i14, j15, i17, list, (List) objF02));
                int i44 = i13;
                i25 = i15;
                columnIndex13 = i16;
                columnIndex14 = i34;
                columnIndex15 = i18;
                columnIndex17 = i20;
                columnIndex18 = i22;
                columnIndex5 = i21;
                columnIndex19 = i23;
                columnIndex20 = i40;
                columnIndex4 = i44;
                columnIndex23 = i43;
                columnIndex22 = i42;
                columnIndex2 = i10;
                columnIndex3 = i11;
                columnIndex16 = i19;
                i27 = i30;
                i28 = i31;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojosFlow$lambda$2(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z9;
        int i20;
        boolean z10;
        int i21;
        boolean z11;
        int i22;
        int i23;
        int i24;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i25 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                int i26 = columnIndex11;
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i24 = columnIndex10;
                } else {
                    i24 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i26;
                columnIndex10 = i24;
            }
            int i27 = columnIndex10;
            int i28 = columnIndex11;
            sQLiteStatementPrepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = sQLiteStatementPrepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndex3));
                long j10 = columnIndex4 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex4);
                long j11 = columnIndex5 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex5);
                long j12 = columnIndex6 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex6);
                boolean z12 = false;
                int i29 = columnIndex7 == -1 ? 0 : (int) sQLiteStatementPrepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndex8));
                long j13 = columnIndex9 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex9);
                int i30 = i27;
                long j14 = i30 == -1 ? 0L : sQLiteStatementPrepare.getLong(i30);
                int i31 = i28;
                if (i31 == -1) {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = 0;
                } else {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = (int) sQLiteStatementPrepare.getLong(i31);
                }
                int i32 = i25;
                if (i32 == -1) {
                    i13 = columnIndex4;
                    i14 = 0;
                } else {
                    i13 = columnIndex4;
                    i14 = (int) sQLiteStatementPrepare.getLong(i32);
                }
                int i33 = columnIndex13;
                long j15 = i33 == -1 ? 0L : sQLiteStatementPrepare.getLong(i33);
                int i34 = columnIndex14;
                if (i34 == -1) {
                    i15 = i32;
                    i16 = i33;
                    i17 = 0;
                } else {
                    i15 = i32;
                    i16 = i33;
                    i17 = (int) sQLiteStatementPrepare.getLong(i34);
                }
                int i35 = columnIndex15;
                if (i35 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i35));
                int i36 = columnIndex16;
                if (i36 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i36));
                int i37 = columnIndex17;
                if (i37 == -1) {
                    i18 = i35;
                    i19 = i36;
                    z9 = false;
                } else {
                    i18 = i35;
                    i19 = i36;
                    z9 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex18;
                if (i38 == -1) {
                    i20 = i37;
                    z10 = false;
                } else {
                    i20 = i37;
                    z10 = ((int) sQLiteStatementPrepare.getLong(i38)) != 0;
                }
                int i39 = columnIndex19;
                if (i39 == -1) {
                    i21 = columnIndex5;
                    z11 = false;
                } else {
                    i21 = columnIndex5;
                    z11 = ((int) sQLiteStatementPrepare.getLong(i39)) != 0;
                }
                int i40 = columnIndex20;
                if (i40 == -1) {
                    i22 = i38;
                    i23 = i39;
                } else {
                    i22 = i38;
                    i23 = i39;
                    if (((int) sQLiteStatementPrepare.getLong(i40)) != 0) {
                        z12 = true;
                    }
                }
                int i41 = columnIndex21;
                boolean z13 = z12;
                long j16 = i41 == -1 ? 0L : sQLiteStatementPrepare.getLong(i41);
                int i42 = columnIndex22;
                long j17 = i42 == -1 ? 0L : sQLiteStatementPrepare.getLong(i42);
                columnIndex21 = i41;
                int i43 = columnIndex23;
                if (i43 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z9, z10, z11, z13, j16, j17, WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i43)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(columnIndex));
                objF0.getClass();
                List list = (List) objF0;
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(columnIndex));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i29, backoffPolicyIntToBackoffPolicy, j13, j14, i12, i14, j15, i17, list, (List) objF02));
                int i44 = i13;
                i25 = i15;
                columnIndex13 = i16;
                columnIndex14 = i34;
                columnIndex15 = i18;
                columnIndex17 = i20;
                columnIndex18 = i22;
                columnIndex5 = i21;
                columnIndex19 = i23;
                columnIndex20 = i40;
                columnIndex4 = i44;
                columnIndex23 = i43;
                columnIndex22 = i42;
                columnIndex2 = i10;
                columnIndex3 = i11;
                columnIndex16 = i19;
                i27 = i30;
                i28 = i31;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojosLiveData$lambda$1(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z9;
        int i20;
        boolean z10;
        int i21;
        boolean z11;
        int i22;
        int i23;
        int i24;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i25 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                int i26 = columnIndex11;
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i24 = columnIndex10;
                } else {
                    i24 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i26;
                columnIndex10 = i24;
            }
            int i27 = columnIndex10;
            int i28 = columnIndex11;
            sQLiteStatementPrepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = sQLiteStatementPrepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState((int) sQLiteStatementPrepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data dataFromByteArray = Data.Companion.fromByteArray(sQLiteStatementPrepare.getBlob(columnIndex3));
                long j10 = columnIndex4 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex4);
                long j11 = columnIndex5 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex5);
                long j12 = columnIndex6 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex6);
                boolean z12 = false;
                int i29 = columnIndex7 == -1 ? 0 : (int) sQLiteStatementPrepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) sQLiteStatementPrepare.getLong(columnIndex8));
                long j13 = columnIndex9 == -1 ? 0L : sQLiteStatementPrepare.getLong(columnIndex9);
                int i30 = i27;
                long j14 = i30 == -1 ? 0L : sQLiteStatementPrepare.getLong(i30);
                int i31 = i28;
                if (i31 == -1) {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = 0;
                } else {
                    i10 = columnIndex2;
                    i11 = columnIndex3;
                    i12 = (int) sQLiteStatementPrepare.getLong(i31);
                }
                int i32 = i25;
                if (i32 == -1) {
                    i13 = columnIndex4;
                    i14 = 0;
                } else {
                    i13 = columnIndex4;
                    i14 = (int) sQLiteStatementPrepare.getLong(i32);
                }
                int i33 = columnIndex13;
                long j15 = i33 == -1 ? 0L : sQLiteStatementPrepare.getLong(i33);
                int i34 = columnIndex14;
                if (i34 == -1) {
                    i15 = i32;
                    i16 = i33;
                    i17 = 0;
                } else {
                    i15 = i32;
                    i16 = i33;
                    i17 = (int) sQLiteStatementPrepare.getLong(i34);
                }
                int i35 = columnIndex15;
                if (i35 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType((int) sQLiteStatementPrepare.getLong(i35));
                int i36 = columnIndex16;
                if (i36 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(sQLiteStatementPrepare.getBlob(i36));
                int i37 = columnIndex17;
                if (i37 == -1) {
                    i18 = i35;
                    i19 = i36;
                    z9 = false;
                } else {
                    i18 = i35;
                    i19 = i36;
                    z9 = ((int) sQLiteStatementPrepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex18;
                if (i38 == -1) {
                    i20 = i37;
                    z10 = false;
                } else {
                    i20 = i37;
                    z10 = ((int) sQLiteStatementPrepare.getLong(i38)) != 0;
                }
                int i39 = columnIndex19;
                if (i39 == -1) {
                    i21 = columnIndex5;
                    z11 = false;
                } else {
                    i21 = columnIndex5;
                    z11 = ((int) sQLiteStatementPrepare.getLong(i39)) != 0;
                }
                int i40 = columnIndex20;
                if (i40 == -1) {
                    i22 = i38;
                    i23 = i39;
                } else {
                    i22 = i38;
                    i23 = i39;
                    if (((int) sQLiteStatementPrepare.getLong(i40)) != 0) {
                        z12 = true;
                    }
                }
                int i41 = columnIndex21;
                boolean z13 = z12;
                long j16 = i41 == -1 ? 0L : sQLiteStatementPrepare.getLong(i41);
                int i42 = columnIndex22;
                long j17 = i42 == -1 ? 0L : sQLiteStatementPrepare.getLong(i42);
                columnIndex21 = i41;
                int i43 = columnIndex23;
                if (i43 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, networkTypeIntToNetworkType, z9, z10, z11, z13, j16, j17, WorkTypeConverters.byteArrayToSetOfTriggers(sQLiteStatementPrepare.getBlob(i43)));
                Object objF0 = a0.f0(arrayMap, sQLiteStatementPrepare.getText(columnIndex));
                objF0.getClass();
                List list = (List) objF0;
                Object objF02 = a0.f0(arrayMap2, sQLiteStatementPrepare.getText(columnIndex));
                objF02.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, stateIntToState, dataFromByteArray, j10, j11, j12, constraints, i29, backoffPolicyIntToBackoffPolicy, j13, j14, i12, i14, j15, i17, list, (List) objF02));
                int i44 = i13;
                i25 = i15;
                columnIndex13 = i16;
                columnIndex14 = i34;
                columnIndex15 = i18;
                columnIndex17 = i20;
                columnIndex18 = i22;
                columnIndex5 = i21;
                columnIndex19 = i23;
                columnIndex20 = i40;
                columnIndex4 = i44;
                columnIndex23 = i43;
                columnIndex22 = i42;
                columnIndex2 = i10;
                columnIndex3 = i11;
                columnIndex16 = i19;
                i27 = i30;
                i28 = i31;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return (List) DBUtil.performBlocking(this.__db, true, false, new b(roomRawQuery.getSql(), roomRawQuery, this, 0));
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public u7.h getWorkInfoPojosFlow(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return FlowUtil.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new b(roomRawQuery.getSql(), roomRawQuery, this, 1));
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, (l) new b(roomRawQuery.getSql(), roomRawQuery, this, 2));
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
