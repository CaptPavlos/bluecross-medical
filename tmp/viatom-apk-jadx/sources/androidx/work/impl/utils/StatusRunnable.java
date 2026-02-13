package androidx.work.impl.utils;

import a3.s;
import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import g7.l;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class StatusRunnable {
    public static final k1.b forStringIds(WorkDatabase workDatabase, TaskExecutor taskExecutor, List<String> list) {
        workDatabase.getClass();
        taskExecutor.getClass();
        list.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new s(list, 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forStringIds$lambda$0(List list, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> listApply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForIds(list));
        listApply.getClass();
        return listApply;
    }

    public static final k1.b forTag(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        workDatabase.getClass();
        taskExecutor.getClass();
        str.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.support.e(str, 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forTag$lambda$2(String str, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> listApply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForTag(str));
        listApply.getClass();
        return listApply;
    }

    public static final k1.b forUUID(WorkDatabase workDatabase, TaskExecutor taskExecutor, UUID uuid) {
        workDatabase.getClass();
        taskExecutor.getClass();
        uuid.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new s(uuid, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkInfo forUUID$lambda$1(UUID uuid, WorkDatabase workDatabase) {
        workDatabase.getClass();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        String string = uuid.toString();
        string.getClass();
        WorkSpec.WorkInfoPojo workStatusPojoForId = workSpecDao.getWorkStatusPojoForId(string);
        if (workStatusPojoForId != null) {
            return workStatusPojoForId.toWorkInfo();
        }
        return null;
    }

    public static final k1.b forUniqueWork(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        workDatabase.getClass();
        taskExecutor.getClass();
        str.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.support.e(str, 28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forUniqueWork$lambda$3(String str, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> listApply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForName(str));
        listApply.getClass();
        return listApply;
    }

    public static final k1.b forWorkQuerySpec(WorkDatabase workDatabase, TaskExecutor taskExecutor, WorkQuery workQuery) {
        workDatabase.getClass();
        taskExecutor.getClass();
        workQuery.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new s(workQuery, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forWorkQuerySpec$lambda$4(WorkQuery workQuery, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> listApply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(workQuery)));
        listApply.getClass();
        return listApply;
    }

    private static final <T> k1.b loadStatusFuture(WorkDatabase workDatabase, TaskExecutor taskExecutor, l lVar) {
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "loadStatusFuture", new c(1, lVar, workDatabase));
    }
}
