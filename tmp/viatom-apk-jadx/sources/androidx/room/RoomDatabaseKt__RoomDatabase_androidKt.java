package androidx.room;

import g7.l;
import g7.p;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import r0.f;
import r7.g;
import r7.y;
import s6.w;
import w6.h;
import w7.v;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2", f = "RoomDatabase.android.kt", l = {1970}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements l {
        final /* synthetic */ l $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RoomDatabase roomDatabase, l lVar, w6.c cVar) {
            super(1, cVar);
            this.$this_withTransaction = roomDatabase;
            this.$block = lVar;
        }

        @Override // y6.a
        public final w6.c create(w6.c cVar) {
            return new AnonymousClass2(this.$this_withTransaction, this.$block, cVar);
        }

        @Override // g7.l
        public final Object invoke(w6.c cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    s6.a.e(obj);
                    this.$this_withTransaction.beginTransaction();
                    l lVar = this.$block;
                    this.label = 1;
                    obj = lVar.invoke(this);
                    x6.a aVar = x6.a.f13718a;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                this.$this_withTransaction.setTransactionSuccessful();
                return obj;
            } finally {
                this.$this_withTransaction.endTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, w6.e eVar) {
        TransactionElement transactionElement = new TransactionElement(eVar);
        return eVar.plus(transactionElement).plus(new v(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    public static final u7.h invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z9) {
        roomDatabase.getClass();
        strArr.getClass();
        return roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(strArr, strArr.length), z9);
    }

    public static /* synthetic */ u7.h invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z9 = true;
        }
        return RoomDatabaseKt.invalidationTrackerFlow(roomDatabase, strArr, z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(final RoomDatabase roomDatabase, final h hVar, final p pVar, w6.c cVar) {
        final g gVar = new g(1, f.F(cVar));
        gVar.s();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
                @e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2017}, m = "invokeSuspend")
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                public static final class AnonymousClass1 extends i implements p {
                    final /* synthetic */ r7.f $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ p $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RoomDatabase roomDatabase, r7.f fVar, p pVar, w6.c cVar) {
                        super(2, cVar);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = fVar;
                        this.$transactionBlock = pVar;
                    }

                    @Override // y6.a
                    public final w6.c create(Object obj, w6.c cVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, cVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // g7.p
                    public final Object invoke(r7.w wVar, w6.c cVar) {
                        return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(w.f12711a);
                    }

                    @Override // y6.a
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        w6.c cVar;
                        int i10 = this.label;
                        if (i10 == 0) {
                            s6.a.e(obj);
                            w6.f fVar = ((r7.w) this.L$0).getCoroutineContext().get(w6.d.f13522a);
                            fVar.getClass();
                            h hVarCreateTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt = RoomDatabaseKt__RoomDatabase_androidKt.createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(this.$this_startTransactionCoroutine, (w6.e) fVar);
                            cVar = this.$continuation;
                            p pVar = this.$transactionBlock;
                            this.L$0 = cVar;
                            this.label = 1;
                            obj = y.z(pVar, hVarCreateTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt, this);
                            x6.a aVar = x6.a.f13718a;
                            if (obj == aVar) {
                                return aVar;
                            }
                        } else {
                            if (i10 != 1) {
                                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            cVar = (w6.c) this.L$0;
                            s6.a.e(obj);
                        }
                        cVar.resumeWith(obj);
                        return w.f12711a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        y.u(hVar.minusKey(w6.d.f13522a), new AnonymousClass1(roomDatabase, gVar, pVar, null));
                    } catch (Throwable th) {
                        gVar.n(th);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            gVar.n(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        return gVar.q();
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, l lVar, w6.c cVar) {
        return RoomDatabaseKt.withTransactionContext(roomDatabase, new AnonymousClass2(roomDatabase, lVar, null), cVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, l lVar, w6.c cVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(lVar, null);
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
        w6.e transactionDispatcher$room_runtime_release = transactionElement != null ? transactionElement.getTransactionDispatcher$room_runtime_release() : null;
        return transactionDispatcher$room_runtime_release != null ? y.z(roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, transactionDispatcher$room_runtime_release, cVar) : startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, cVar.getContext(), roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, cVar);
    }
}
