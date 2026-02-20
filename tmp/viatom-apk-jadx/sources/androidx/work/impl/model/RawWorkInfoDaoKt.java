package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import r7.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RawWorkInfoDaoKt {
    public static final u7.h getWorkInfoPojosFlow(RawWorkInfoDao rawWorkInfoDao, s sVar, SupportSQLiteQuery supportSQLiteQuery) {
        rawWorkInfoDao.getClass();
        sVar.getClass();
        supportSQLiteQuery.getClass();
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(supportSQLiteQuery), sVar);
    }
}
