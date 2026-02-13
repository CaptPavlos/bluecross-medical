package androidx.datastore.core;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import g7.p;
import r7.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$incrementCollector$2$1 extends i implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((DataStoreImpl$incrementCollector$2$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r5.collect(r0, r4) == r3) goto L15;
     */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.label
            r1 = 2
            r2 = 1
            x6.a r3 = x6.a.f13718a
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            s6.a.e(r5)
            goto L4b
        L10:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L17:
            s6.a.e(r5)
            goto L2d
        L1b:
            s6.a.e(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreImpl$InitDataStore r5 = androidx.datastore.core.DataStoreImpl.access$getReadAndInit$p(r5)
            r4.label = r2
            java.lang.Object r5 = r5.awaitComplete(r4)
            if (r5 != r3) goto L2d
            goto L4a
        L2d:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r5)
            u7.h r5 = r5.getUpdateNotifications()
            u7.h r5 = u7.i0.f(r5)
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1
            androidx.datastore.core.DataStoreImpl<T> r2 = r4.this$0
            r0.<init>()
            r4.label = r1
            java.lang.Object r5 = r5.collect(r0, r4)
            if (r5 != r3) goto L4b
        L4a:
            return r3
        L4b:
            s6.w r5 = s6.w.f12711a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
