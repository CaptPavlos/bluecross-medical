package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.StatusRunnable;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f628a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f629b;

    public /* synthetic */ e(String str, int i10) {
        this.f628a = i10;
        this.f629b = str;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f628a) {
            case 0:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(this.f629b, (SupportSQLiteDatabase) obj);
            case 1:
                return DependencyDao_Impl.getDependentWorkIds$lambda$3("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", this.f629b, (SQLiteConnection) obj);
            case 2:
                return Boolean.valueOf(DependencyDao_Impl.hasDependents$lambda$4("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", this.f629b, (SQLiteConnection) obj));
            case 3:
                return Boolean.valueOf(DependencyDao_Impl.hasCompletedAllPrerequisites$lambda$1("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", this.f629b, (SQLiteConnection) obj));
            case 4:
                return DependencyDao_Impl.getPrerequisites$lambda$2("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 5:
                return PreferenceDao_Impl.getObservableLongValue$lambda$2("SELECT long_value FROM Preference where `key`=?", this.f629b, (SQLiteConnection) obj);
            case 6:
                return PreferenceDao_Impl.getLongValue$lambda$1("SELECT long_value FROM Preference where `key`=?", this.f629b, (SQLiteConnection) obj);
            case 7:
                return SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$4("DELETE FROM SystemIdInfo where work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 8:
                return WorkNameDao_Impl.getWorkSpecIdsWithName$lambda$1("SELECT work_spec_id FROM workname WHERE name=?", this.f629b, (SQLiteConnection) obj);
            case 9:
                return WorkNameDao_Impl.getNamesForWorkSpecId$lambda$2("SELECT name FROM workname WHERE work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 10:
                return WorkProgressDao_Impl.getProgressForWorkSpecId$lambda$1("SELECT progress FROM WorkProgress WHERE work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 11:
                return WorkProgressDao_Impl.delete$lambda$2("DELETE from WorkProgress where work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 12:
                return WorkSpecDao_Impl.delete$lambda$37("DELETE FROM workspec WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 13:
                return WorkSpecDao_Impl.getWorkSpecIdAndStatesForName$lambda$4("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f629b, (SQLiteConnection) obj);
            case 14:
                return WorkSpecDao_Impl.getUnfinishedWorkWithName$lambda$20("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f629b, (SQLiteConnection) obj);
            case 15:
                return Integer.valueOf(WorkSpecDao_Impl.resetWorkSpecRunAttemptCount$lambda$44("UPDATE workspec SET run_attempt_count=0 WHERE id=?", this.f629b, (SQLiteConnection) obj));
            case 16:
                return WorkSpecDao_Impl.incrementPeriodCount$lambda$40("UPDATE workspec SET period_count=period_count+1 WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 17:
                return WorkSpecDao_Impl.getWorkSpec$lambda$3("SELECT * FROM workspec WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 18:
                return WorkSpecDao_Impl.getInputsFromPrerequisites$lambda$18("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", this.f629b, (SQLiteConnection) obj);
            case 19:
                return WorkSpecDao_Impl.incrementGeneration$lambda$50("UPDATE workspec SET generation=generation+1 WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 20:
                return Integer.valueOf(WorkSpecDao_Impl.setCancelledState$lambda$39("UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?", this.f629b, (SQLiteConnection) obj));
            case 21:
                return WorkSpecDao_Impl.getUnfinishedWorkWithTag$lambda$19("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f629b, (SQLiteConnection) obj);
            case 22:
                return Integer.valueOf(WorkSpecDao_Impl.incrementWorkSpecRunAttemptCount$lambda$43("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?", this.f629b, (SQLiteConnection) obj));
            case 23:
                return WorkSpecDao_Impl.getState$lambda$7("SELECT state FROM workspec WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 24:
                return WorkSpecDao_Impl.getScheduleRequestedAtLiveData$lambda$23("SELECT schedule_requested_at FROM workspec WHERE id=?", this.f629b, (SQLiteConnection) obj);
            case 25:
                return WorkTagDao_Impl.deleteByWorkSpecId$lambda$3("DELETE FROM worktag WHERE work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 26:
                return WorkTagDao_Impl.getTagsForWorkSpecId$lambda$2("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", this.f629b, (SQLiteConnection) obj);
            case 27:
                return WorkTagDao_Impl.getWorkSpecIdsWithTag$lambda$1("SELECT work_spec_id FROM worktag WHERE tag=?", this.f629b, (SQLiteConnection) obj);
            case 28:
                return StatusRunnable.forUniqueWork$lambda$3(this.f629b, (WorkDatabase) obj);
            default:
                return StatusRunnable.forTag$lambda$2(this.f629b, (WorkDatabase) obj);
        }
    }
}
