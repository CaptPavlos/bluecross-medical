package androidx.room.util;

import androidx.room.TransactionScope;
import g7.p;
import s6.a;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2$result$1", f = "DBUtil.kt", l = {59}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtilKt$internalPerform$2$result$1 extends i implements p {
    final /* synthetic */ p $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtilKt$internalPerform$2$result$1(p pVar, c cVar) {
        super(2, cVar);
        this.$block = pVar;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, cVar);
        dBUtil__DBUtilKt$internalPerform$2$result$1.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2$result$1;
    }

    @Override // g7.p
    public final Object invoke(TransactionScope<R> transactionScope, c cVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2$result$1) create(transactionScope, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        a.e(obj);
        TransactionScope transactionScope = (TransactionScope) this.L$0;
        p pVar = this.$block;
        this.label = 1;
        Object objInvoke = pVar.invoke(transactionScope, this);
        x6.a aVar = x6.a.f13718a;
        return objInvoke == aVar ? aVar : objInvoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke((TransactionScope) this.L$0, this);
    }
}
