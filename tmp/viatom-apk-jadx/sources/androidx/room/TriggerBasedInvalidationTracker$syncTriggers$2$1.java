package androidx.room;

import androidx.room.ObservedTableStates;
import androidx.room.Transactor;
import g7.p;
import s6.w;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", l = {301, 309}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1", f = "InvalidationTracker.kt", l = {313, 314}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Transactor $connection;
        final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
                try {
                    iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, w6.c cVar) {
            super(2, cVar);
            this.$tablesToSync = observeOpArr;
            this.this$0 = triggerBasedInvalidationTracker;
            this.$connection = transactor;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass1(this.$tablesToSync, this.this$0, this.$connection, cVar);
        }

        @Override // g7.p
        public final Object invoke(TransactionScope<w> transactionScope, w6.c cVar) {
            return ((AnonymousClass1) create(transactionScope, cVar)).invokeSuspend(w.f12711a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r6.startTrackingTable(r12, r5, r11) == r9) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        
            r5 = r12;
            r4 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0081 -> B:28:0x0082). Please report as a decompilation issue!!! */
        @Override // y6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                int r0 = r11.label
                r1 = 2
                r2 = 1
                if (r0 == 0) goto L27
                if (r0 == r2) goto La
                if (r0 != r1) goto L20
            La:
                int r0 = r11.I$2
                int r3 = r11.I$1
                int r4 = r11.I$0
                java.lang.Object r5 = r11.L$2
                androidx.room.Transactor r5 = (androidx.room.Transactor) r5
                java.lang.Object r6 = r11.L$1
                androidx.room.TriggerBasedInvalidationTracker r6 = (androidx.room.TriggerBasedInvalidationTracker) r6
                java.lang.Object r7 = r11.L$0
                androidx.room.ObservedTableStates$ObserveOp[] r7 = (androidx.room.ObservedTableStates.ObserveOp[]) r7
                s6.a.e(r12)
                goto L65
            L20:
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                androidx.window.layout.c.g(r12)
            L25:
                r12 = 0
                return r12
            L27:
                s6.a.e(r12)
                androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
                androidx.room.TriggerBasedInvalidationTracker r0 = r11.this$0
                androidx.room.Transactor r3 = r11.$connection
                int r4 = r12.length
                r5 = 0
                r7 = r12
                r6 = r0
                r12 = r3
                r0 = r4
                r3 = r5
            L37:
                if (r3 >= r0) goto L84
                r4 = r7[r3]
                int r8 = r5 + 1
                int[] r9 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                int r4 = r4.ordinal()
                r4 = r9[r4]
                if (r4 == r2) goto L81
                x6.a r9 = x6.a.f13718a
                if (r4 == r1) goto L6c
                r10 = 3
                if (r4 != r10) goto L68
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r12
                r11.I$0 = r8
                r11.I$1 = r3
                r11.I$2 = r0
                r11.label = r1
                java.lang.Object r4 = androidx.room.TriggerBasedInvalidationTracker.access$stopTrackingTable(r6, r12, r5, r11)
                if (r4 != r9) goto L63
                goto L80
            L63:
                r5 = r12
                r4 = r8
            L65:
                r12 = r5
                r5 = r4
                goto L82
            L68:
                androidx.window.layout.c.b()
                goto L25
            L6c:
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r12
                r11.I$0 = r8
                r11.I$1 = r3
                r11.I$2 = r0
                r11.label = r2
                java.lang.Object r4 = androidx.room.TriggerBasedInvalidationTracker.access$startTrackingTable(r6, r12, r5, r11)
                if (r4 != r9) goto L63
            L80:
                return r9
            L81:
                r5 = r8
            L82:
                int r3 = r3 + r2
                goto L37
            L84:
                s6.w r12 = s6.w.f12711a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, w6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, cVar);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    @Override // g7.p
    public final Object invoke(Transactor transactor, w6.c cVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Transactor transactor;
        ObservedTableStates.ObserveOp[] tablesToSync$room_runtime_release;
        int i10 = this.label;
        w wVar = w.f12711a;
        x6.a aVar = x6.a.f13718a;
        if (i10 == 0) {
            s6.a.e(obj);
            transactor = (Transactor) this.L$0;
            this.L$0 = transactor;
            this.label = 1;
            obj = transactor.inTransaction(this);
            if (obj != aVar) {
            }
            return aVar;
        }
        if (i10 != 1) {
            if (i10 == 2) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        transactor = (Transactor) this.L$0;
        s6.a.e(obj);
        if (!((Boolean) obj).booleanValue() && (tablesToSync$room_runtime_release = this.this$0.observedTableStates.getTablesToSync$room_runtime_release()) != null) {
            Transactor.SQLiteTransactionType sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(tablesToSync$room_runtime_release, this.this$0, transactor, null);
            this.L$0 = null;
            this.label = 2;
            if (transactor.withTransaction(sQLiteTransactionType, anonymousClass1, this) == aVar) {
                return aVar;
            }
        }
        return wVar;
    }
}
