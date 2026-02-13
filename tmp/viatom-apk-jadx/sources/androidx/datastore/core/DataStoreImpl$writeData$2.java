package androidx.datastore.core;

import g7.p;
import kotlin.jvm.internal.v;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {352, 353}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$writeData$2 extends i implements p {
    final /* synthetic */ T $newData;
    final /* synthetic */ v $newVersion;
    final /* synthetic */ boolean $updateCache;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(v vVar, DataStoreImpl<T> dataStoreImpl, T t, boolean z9, c cVar) {
        super(2, cVar);
        this.$newVersion = vVar;
        this.this$0 = dataStoreImpl;
        this.$newData = t;
        this.$updateCache = z9;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.$newVersion, this.this$0, this.$newData, this.$updateCache, cVar);
        dataStoreImpl$writeData$2.L$0 = obj;
        return dataStoreImpl$writeData$2;
    }

    @Override // g7.p
    public final Object invoke(WriteScope<T> writeScope, c cVar) {
        return ((DataStoreImpl$writeData$2) create(writeScope, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r2.writeData(r7, r6) == r3) goto L16;
     */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.label
            r1 = 2
            r2 = 1
            x6.a r3 = x6.a.f13718a
            if (r0 == 0) goto L23
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            s6.a.e(r7)
            goto L5a
        L10:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L17:
            java.lang.Object r0 = r6.L$1
            kotlin.jvm.internal.v r0 = (kotlin.jvm.internal.v) r0
            java.lang.Object r2 = r6.L$0
            androidx.datastore.core.WriteScope r2 = (androidx.datastore.core.WriteScope) r2
            s6.a.e(r7)
            goto L42
        L23:
            s6.a.e(r7)
            java.lang.Object r7 = r6.L$0
            androidx.datastore.core.WriteScope r7 = (androidx.datastore.core.WriteScope) r7
            kotlin.jvm.internal.v r0 = r6.$newVersion
            androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
            androidx.datastore.core.InterProcessCoordinator r4 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r4)
            r6.L$0 = r7
            r6.L$1 = r0
            r6.label = r2
            java.lang.Object r2 = r4.incrementAndGetVersion(r6)
            if (r2 != r3) goto L3f
            goto L59
        L3f:
            r5 = r2
            r2 = r7
            r7 = r5
        L42:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r0.f10136a = r7
            T r7 = r6.$newData
            r0 = 0
            r6.L$0 = r0
            r6.L$1 = r0
            r6.label = r1
            java.lang.Object r7 = r2.writeData(r7, r6)
            if (r7 != r3) goto L5a
        L59:
            return r3
        L5a:
            boolean r7 = r6.$updateCache
            if (r7 == 0) goto L7a
            androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
            androidx.datastore.core.DataStoreInMemoryCache r7 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r7)
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r6.$newData
            if (r1 == 0) goto L6f
            int r2 = r1.hashCode()
            goto L70
        L6f:
            r2 = 0
        L70:
            kotlin.jvm.internal.v r3 = r6.$newVersion
            int r3 = r3.f10136a
            r0.<init>(r1, r2, r3)
            r7.tryUpdate(r0)
        L7a:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
