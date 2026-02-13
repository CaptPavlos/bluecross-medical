package androidx.datastore.core;

import g7.l;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends i implements l {
    final /* synthetic */ DataMigration<T> $migration;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2$1$1(DataMigration<T> dataMigration, c cVar) {
        super(1, cVar);
        this.$migration = dataMigration;
    }

    @Override // y6.a
    public final c create(c cVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, cVar);
    }

    @Override // g7.l
    public final Object invoke(c cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            s6.a.e(obj);
            DataMigration<T> dataMigration = this.$migration;
            this.label = 1;
            Object objCleanUp = dataMigration.cleanUp(this);
            x6.a aVar = x6.a.f13718a;
            if (objCleanUp == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return w.f12711a;
    }
}
