package androidx.room;

import g7.p;
import java.util.Arrays;
import java.util.Set;
import r7.w;
import t6.j;
import u7.b0;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1 extends i implements p {
    final /* synthetic */ String[] $tables;
    Object L$0;
    int label;
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, w6.c cVar) {
        super(2, cVar);
        this.$tables = strArr;
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(this.$tables, this.this$0, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Set<String> setZ0;
        int i10 = this.label;
        if (i10 == 0) {
            s6.a.e(obj);
            String[] strArr = this.$tables;
            setZ0 = j.z0(Arrays.copyOf(strArr, strArr.length));
            b0 b0Var = this.this$0.invalidatedTables;
            this.L$0 = setZ0;
            this.label = 1;
            Object objEmit = b0Var.emit(setZ0, this);
            x6.a aVar = x6.a.f13718a;
            if (objEmit == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            setZ0 = (Set) this.L$0;
            s6.a.e(obj);
        }
        this.this$0.getInvalidationTracker().notifyObserversByTableNames$room_runtime_release(setZ0);
        return s6.w.f12711a;
    }
}
