package androidx.work.impl.workers;

import a3.a;
import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DiagnosticsWorkerKt {
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("DiagnosticsWrkr");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    private static final String workSpecRow(WorkSpec workSpec, String str, Integer num, String str2) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(workSpec.id);
        sb.append("\t ");
        sb.append(workSpec.workerClassName);
        sb.append("\t ");
        sb.append(num);
        sb.append("\t ");
        sb.append(workSpec.state.name());
        sb.append("\t ");
        sb.append(str);
        sb.append("\t ");
        return a.m(sb, str2, '\t');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        for (WorkSpec workSpec : list) {
            SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(WorkSpecKt.generationalId(workSpec));
            sb.append(workSpecRow(workSpec, l.h0(workNameDao.getNamesForWorkSpecId(workSpec.id), ",", null, null, null, 62), systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null, l.h0(workTagDao.getTagsForWorkSpecId(workSpec.id), ",", null, null, null, 62)));
        }
        return sb.toString();
    }
}
