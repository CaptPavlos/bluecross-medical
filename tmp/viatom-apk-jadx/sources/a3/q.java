package a3;

import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.room.RoomRawQuery;
import androidx.room.TransactorKt;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.savedstate.serialization.SavedStateConfig_androidKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.PreferenceUtils;
import com.uptodown.activities.MainActivity;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class q implements g7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f153a;

    public /* synthetic */ q(int i10) {
        this.f153a = i10;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f153a) {
            case 0:
                CorruptionException corruptionException = (CorruptionException) obj;
                corruptionException.getClass();
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", corruptionException);
                return d3.h.f6820b;
            case 1:
                return RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
            case 2:
                return Boolean.valueOf(TransactorKt.execSQL$lambda$0((SQLiteStatement) obj));
            case 3:
                return TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj);
            case 4:
                return SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0((List) obj);
            case 5:
                return Data.toString$lambda$7$lambda$6((Map.Entry) obj);
            case 6:
                return WorkConstraintsTracker.areAllConstraintsMet$lambda$5((ConstraintController) obj);
            case 7:
                return SystemIdInfoDao_Impl.getWorkSpecIds$lambda$2("SELECT DISTINCT work_spec_id FROM SystemIdInfo", (SQLiteConnection) obj);
            case 8:
                return WorkProgressDao_Impl.deleteAll$lambda$3("DELETE FROM WorkProgress", (SQLiteConnection) obj);
            case 9:
                return WorkSpecDao_Impl.getAllUnfinishedWork$lambda$21("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", (SQLiteConnection) obj);
            case 10:
                return Integer.valueOf(WorkSpecDao_Impl.countNonFinishedContentUriTriggerWorkers$lambda$36("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", (SQLiteConnection) obj));
            case 11:
                return WorkSpecDao_Impl.pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))", (SQLiteConnection) obj);
            case 12:
                return Boolean.valueOf(WorkSpecDao_Impl.hasUnfinishedWorkFlow$lambda$22("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", (SQLiteConnection) obj));
            case 13:
                return Integer.valueOf(WorkSpecDao_Impl.resetScheduledState$lambda$48("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)", (SQLiteConnection) obj));
            case 14:
                return WorkSpecDao_Impl.getScheduledWork$lambda$31("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", (SQLiteConnection) obj);
            case 15:
                return WorkSpecDao_Impl.getAllWorkSpecIds$lambda$5("SELECT id FROM workspec", (SQLiteConnection) obj);
            case 16:
                return WorkSpecDao_Impl.getAllWorkSpecIdsLiveData$lambda$6("SELECT id FROM workspec", (SQLiteConnection) obj);
            case 17:
                return WorkSpecDao_Impl.getRunningWork$lambda$33("SELECT * FROM workspec WHERE state=1", (SQLiteConnection) obj);
            case 18:
                return WorkSpecDao_Impl.getEligibleWorkForSchedulingWithContentUris$lambda$27("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", (SQLiteConnection) obj);
            case 19:
                return PreferenceUtils.lambda$getLastCancelAllTimeMillisLiveData$0((Long) obj);
            case 20:
                o7.i iVar = (o7.i) obj;
                iVar.getClass();
                int i10 = iVar.b().f11084a;
                String str = (String) ((o7.h) iVar.a()).get(0);
                String str2 = (String) ((o7.h) iVar.a()).get(1);
                String strGroup = iVar.f11768a.group();
                strGroup.getClass();
                return new h5.o(i10, str, str2, strGroup);
            case 21:
                o7.i iVar2 = (o7.i) obj;
                iVar2.getClass();
                return (CharSequence) ((o7.h) iVar2.a()).get(1);
            case 22:
                o7.i iVar3 = (o7.i) obj;
                iVar3.getClass();
                return (CharSequence) ((o7.h) iVar3.a()).get(3);
            case 23:
                o7.i iVar4 = (o7.i) obj;
                iVar4.getClass();
                return (CharSequence) ((o7.h) iVar4.a()).get(2);
            case 24:
                e8.a aVar = (e8.a) obj;
                aVar.getClass();
                e8.a.a(aVar, "JsonPrimitive", new e8.j(new androidx.lifecycle.k(12)));
                e8.a.a(aVar, "JsonNull", new e8.j(new androidx.lifecycle.k(13)));
                e8.a.a(aVar, "JsonLiteral", new e8.j(new androidx.lifecycle.k(14)));
                e8.a.a(aVar, "JsonObject", new e8.j(new androidx.lifecycle.k(15)));
                e8.a.a(aVar, "JsonArray", new e8.j(new androidx.lifecycle.k(16)));
                return s6.w.f12711a;
            case 25:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                String str3 = (String) entry.getKey();
                h8.k kVar = (h8.k) entry.getValue();
                StringBuilder sb = new StringBuilder();
                i8.w.a(sb, str3);
                sb.append(':');
                sb.append(kVar);
                return sb.toString();
            case 26:
                return (CharSequence) ((o7.h) ((o7.i) obj).a()).get(1);
            case 27:
                o7.i iVar5 = (o7.i) obj;
                int i11 = MainActivity.B0;
                iVar5.getClass();
                return (CharSequence) ((o7.h) iVar5.a()).get(1);
            default:
                o7.i iVar6 = (o7.i) obj;
                int i12 = MainActivity.B0;
                iVar6.getClass();
                return (CharSequence) ((o7.h) iVar6.a()).get(1);
        }
    }
}
