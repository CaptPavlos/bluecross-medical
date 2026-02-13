package androidx.datastore.core;

import g7.p;
import r7.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1", f = "DataStoreImpl.kt", l = {331}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$transformAndWrite$2$newData$1 extends i implements p {
    final /* synthetic */ Data<T> $curData;
    final /* synthetic */ p $transform;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2$newData$1(p pVar, Data<T> data, c cVar) {
        super(2, cVar);
        this.$transform = pVar;
        this.$curData = data;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, this.$curData, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((DataStoreImpl$transformAndWrite$2$newData$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        p pVar = this.$transform;
        Object value = this.$curData.getValue();
        this.label = 1;
        Object objInvoke = pVar.invoke(value, this);
        x6.a aVar = x6.a.f13718a;
        return objInvoke == aVar ? aVar : objInvoke;
    }
}
