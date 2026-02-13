package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import g7.p;
import java.util.Set;
import s6.w;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1", f = "InvalidationTracker.kt", l = {413, TypedValues.CycleType.TYPE_EASING}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1", f = "InvalidationTracker.kt", l = {TypedValues.CycleType.TYPE_WAVE_SHAPE}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, w6.c cVar) {
            super(2, cVar);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(TransactionScope<Set<Integer>> transactionScope, w6.c cVar) {
            return ((AnonymousClass1) create(transactionScope, cVar)).invokeSuspend(w.f12711a);
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
            TransactionScope transactionScope = (TransactionScope) this.L$0;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
            this.label = 1;
            Object objCheckInvalidatedTables = triggerBasedInvalidationTracker.checkInvalidatedTables(transactionScope, this);
            x6.a aVar = x6.a.f13718a;
            return objCheckInvalidatedTables == aVar ? aVar : objCheckInvalidatedTables;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, w6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this.this$0, cVar);
        triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.L$0 = obj;
        return triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1;
    }

    @Override // g7.p
    public final Object invoke(Transactor transactor, w6.c cVar) {
        return ((TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1) create(transactor, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r8 == r4) goto L19;
     */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.label
            t6.v r1 = t6.v.f12810a
            r2 = 2
            r3 = 1
            x6.a r4 = x6.a.f13718a
            if (r0 == 0) goto L21
            if (r0 == r3) goto L19
            if (r0 != r2) goto L12
            s6.a.e(r8)     // Catch: android.database.SQLException -> L55
            goto L52
        L12:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            r8 = 0
            return r8
        L19:
            java.lang.Object r0 = r7.L$0
            androidx.room.Transactor r0 = (androidx.room.Transactor) r0
            s6.a.e(r8)
            goto L34
        L21:
            s6.a.e(r8)
            java.lang.Object r8 = r7.L$0
            r0 = r8
            androidx.room.Transactor r0 = (androidx.room.Transactor) r0
            r7.L$0 = r0
            r7.label = r3
            java.lang.Object r8 = r0.inTransaction(r7)
            if (r8 != r4) goto L34
            goto L51
        L34:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L3d
            return r1
        L3d:
            androidx.room.Transactor$SQLiteTransactionType r8 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE     // Catch: android.database.SQLException -> L55
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1     // Catch: android.database.SQLException -> L55
            androidx.room.TriggerBasedInvalidationTracker r5 = r7.this$0     // Catch: android.database.SQLException -> L55
            r6 = 0
            r3.<init>(r5, r6)     // Catch: android.database.SQLException -> L55
            r7.L$0 = r6     // Catch: android.database.SQLException -> L55
            r7.label = r2     // Catch: android.database.SQLException -> L55
            java.lang.Object r8 = r0.withTransaction(r8, r3, r7)     // Catch: android.database.SQLException -> L55
            if (r8 != r4) goto L52
        L51:
            return r4
        L52:
            java.util.Set r8 = (java.util.Set) r8     // Catch: android.database.SQLException -> L55
            return r8
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
