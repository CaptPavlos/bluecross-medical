package androidx.room.util;

import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.internal.measurement.a4;
import g7.p;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import o7.u;
import r0.f;
import s6.w;
import u6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class DBUtil__DBUtilKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", l = {56, 57, 59, 60, 65}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtilKt$internalPerform$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ boolean $isReadOnly;
        final /* synthetic */ RoomDatabase $this_internalPerform;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z9, boolean z10, RoomDatabase roomDatabase, p pVar, c cVar) {
            super(2, cVar);
            this.$inTransaction = z9;
            this.$isReadOnly = z10;
            this.$this_internalPerform = roomDatabase;
            this.$block = pVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // g7.p
        public final Object invoke(Transactor transactor, c cVar) {
            return ((AnonymousClass2) create(transactor, cVar)).invokeSuspend(w.f12711a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
        
            if (r9.sync$room_runtime_release(r8) == r6) goto L51;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[PHI: r0 r9
          0x00a5: PHI (r0v11 androidx.room.Transactor) = (r0v8 androidx.room.Transactor), (r0v20 androidx.room.Transactor) binds: [B:36:0x00a2, B:14:0x0027] A[DONT_GENERATE, DONT_INLINE]
          0x00a5: PHI (r9v13 java.lang.Object) = (r9v12 java.lang.Object), (r9v0 java.lang.Object) binds: [B:36:0x00a2, B:14:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c9 A[RETURN] */
        @Override // y6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtilKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Transactor transactor = (Transactor) this.L$0;
            if (!this.$inTransaction) {
                return this.$block.invoke(transactor, this);
            }
            boolean z9 = this.$isReadOnly;
            Transactor.SQLiteTransactionType sQLiteTransactionType = z9 ? Transactor.SQLiteTransactionType.DEFERRED : Transactor.SQLiteTransactionType.IMMEDIATE;
            if (!z9 && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().sync$room_runtime_release(this);
            }
            Object objWithTransaction = transactor.withTransaction(sQLiteTransactionType, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
            if (!this.$isReadOnly && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().refreshAsync();
            }
            return objWithTransaction;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        u6.c cVarL = a4.l();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (sQLiteStatementPrepare.step()) {
            try {
                cVarL.add(sQLiteStatementPrepare.getText(0));
            } finally {
            }
        }
        f.p(sQLiteStatementPrepare, null);
        ListIterator listIterator = a4.h(cVarL).listIterator(0);
        while (true) {
            a aVar = (a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String str = (String) aVar.next();
            if (u.c0(str, "room_fts_content_sync_", false)) {
                SQLite.execSQL(sQLiteConnection, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (sQLiteStatementPrepare.step()) {
                throw new SQLException(processForeignKeyCheckFailure$DBUtil__DBUtilKt(sQLiteStatementPrepare));
            }
            f.p(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public static final <R> Object internalPerform(RoomDatabase roomDatabase, boolean z9, boolean z10, p pVar, c cVar) {
        return roomDatabase.useConnection$room_runtime_release(z9, new AnonymousClass2(z10, z9, roomDatabase, pVar, null), cVar);
    }

    private static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        do {
            if (i10 == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i10++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(i10);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }
}
