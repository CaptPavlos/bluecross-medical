package androidx.datastore.core;

import g7.l;
import g7.p;
import java.util.List;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$2 extends i implements p {
    final /* synthetic */ List<l> $cleanUps;
    final /* synthetic */ List<DataMigration<T>> $migrations;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$runMigrations$2(List<? extends DataMigration<T>> list, List<l> list2, c cVar) {
        super(2, cVar);
        this.$migrations = list;
        this.$cleanUps = list2;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, cVar);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    public final Object invoke(T t, c cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(t, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[RETURN] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.label
            r1 = 2
            r2 = 1
            x6.a r3 = x6.a.f13718a
            if (r0 == 0) goto L34
            if (r0 == r2) goto L1f
            if (r0 != r1) goto L18
            java.lang.Object r0 = r9.L$1
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r4 = r9.L$0
            java.util.List r4 = (java.util.List) r4
            s6.a.e(r10)
            goto L43
        L18:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r10)
            r10 = 0
            return r10
        L1f:
            java.lang.Object r0 = r9.L$3
            java.lang.Object r4 = r9.L$2
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r9.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r9.L$0
            java.util.List r6 = (java.util.List) r6
            s6.a.e(r10)
            r8 = r6
            r6 = r4
            r4 = r8
            goto L65
        L34:
            s6.a.e(r10)
            java.lang.Object r10 = r9.L$0
            java.util.List<androidx.datastore.core.DataMigration<T>> r0 = r9.$migrations
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List<g7.l> r4 = r9.$cleanUps
            java.util.Iterator r0 = r0.iterator()
        L43:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L8b
            java.lang.Object r5 = r0.next()
            androidx.datastore.core.DataMigration r5 = (androidx.datastore.core.DataMigration) r5
            r9.L$0 = r4
            r9.L$1 = r0
            r9.L$2 = r5
            r9.L$3 = r10
            r9.label = r2
            java.lang.Object r6 = r5.shouldMigrate(r10, r9)
            if (r6 != r3) goto L60
            goto L86
        L60:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r8
        L65:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L89
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r10 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r7 = 0
            r10.<init>(r6, r7)
            r4.add(r10)
            r9.L$0 = r4
            r9.L$1 = r5
            r9.L$2 = r7
            r9.L$3 = r7
            r9.label = r1
            java.lang.Object r10 = r6.migrate(r0, r9)
            if (r10 != r3) goto L87
        L86:
            return r3
        L87:
            r0 = r5
            goto L43
        L89:
            r10 = r0
            goto L87
        L8b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // g7.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((DataMigrationInitializer$Companion$runMigrations$2) obj, (c) obj2);
    }
}
