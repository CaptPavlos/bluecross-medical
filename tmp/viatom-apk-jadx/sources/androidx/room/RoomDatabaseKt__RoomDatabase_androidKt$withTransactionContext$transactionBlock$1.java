package androidx.room;

import g7.l;
import g7.p;
import r7.w;
import w6.f;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", f = "RoomDatabase.android.kt", l = {1984}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 extends i implements p {
    final /* synthetic */ l $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(l lVar, w6.c cVar) {
        super(2, cVar);
        this.$block = lVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.$block, cVar);
        roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.room.TransactionElement] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        TransactionElement transactionElement = this.label;
        try {
            if (transactionElement == 0) {
                s6.a.e(obj);
                f fVar = ((w) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                fVar.getClass();
                TransactionElement transactionElement2 = (TransactionElement) fVar;
                transactionElement2.acquire();
                l lVar = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                obj = lVar.invoke(this);
                x6.a aVar = x6.a.f13718a;
                transactionElement = transactionElement2;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (transactionElement != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                TransactionElement transactionElement3 = (TransactionElement) this.L$0;
                s6.a.e(obj);
                transactionElement = transactionElement3;
            }
            return obj;
        } finally {
            transactionElement.release();
        }
    }
}
