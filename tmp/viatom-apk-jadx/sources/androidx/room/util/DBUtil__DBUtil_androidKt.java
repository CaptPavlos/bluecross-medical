package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.TransactionElement;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import g7.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import r7.w;
import r7.y;
import s6.a;
import w6.c;
import w6.h;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class DBUtil__DBUtil_androidKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", l = {243}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ l $block;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ boolean $isReadOnly;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RoomDatabase roomDatabase, boolean z9, boolean z10, l lVar, c cVar) {
            super(2, cVar);
            this.$db = roomDatabase;
            this.$isReadOnly = z9;
            this.$inTransaction = z10;
            this.$block = lVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(this.$db, this.$isReadOnly, this.$inTransaction, this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
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
            RoomDatabase roomDatabase = this.$db;
            boolean z9 = this.$isReadOnly;
            DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1(this.$inTransaction, z9, roomDatabase, null, this.$block);
            this.label = 1;
            Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z9, dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1, this);
            x6.a aVar = x6.a.f13718a;
            return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2", f = "DBUtil.android.kt", l = {243}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements l {
        final /* synthetic */ l $block;
        final /* synthetic */ RoomDatabase $db;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RoomDatabase roomDatabase, l lVar, c cVar) {
            super(1, cVar);
            this.$db = roomDatabase;
            this.$block = lVar;
        }

        @Override // y6.a
        public final c create(c cVar) {
            return new AnonymousClass2(this.$db, this.$block, cVar);
        }

        @Override // g7.l
        public final Object invoke(c cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(s6.w.f12711a);
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
            RoomDatabase roomDatabase = this.$db;
            DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(true, false, roomDatabase, null, this.$block);
            this.label = 1;
            Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1, this);
            x6.a aVar = x6.a.f13718a;
            return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$3", f = "DBUtil.android.kt", l = {243}, m = "invokeSuspend")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ l $block;
        final /* synthetic */ RoomDatabase $db;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(RoomDatabase roomDatabase, l lVar, c cVar) {
            super(2, cVar);
            this.$db = roomDatabase;
            this.$block = lVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass3(this.$db, this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
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
            RoomDatabase roomDatabase = this.$db;
            DBUtil__DBUtil_androidKt$performInTransactionSuspending$3$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$3$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$3$invokeSuspend$$inlined$internalPerform$1(true, false, roomDatabase, null, this.$block);
            this.label = 1;
            Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$3$invokeSuspend$$inlined$internalPerform$1, this);
            x6.a aVar = x6.a.f13718a;
            return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {245, 247, 247}, m = "performSuspending")
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01341<R> extends y6.c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C01341(c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DBUtil.performSuspending(null, false, false, null, this);
        }
    }

    private static final <R> Object compatCoroutineExecute$DBUtil__DBUtil_androidKt(RoomDatabase roomDatabase, boolean z9, l lVar, c cVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release() && roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
            return lVar.invoke(cVar);
        }
        return y.z(new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(lVar, null), (h) DBUtil.getCoroutineContext(roomDatabase, z9, cVar), cVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        DBUtil.dropFtsSyncTriggers(new SupportSQLiteConnection(supportSQLiteDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        supportSQLiteDatabase.getClass();
        str.getClass();
        DBUtil.foreignKeyCheck(new SupportSQLiteConnection(supportSQLiteDatabase), str);
    }

    public static final Object getCoroutineContext(RoomDatabase roomDatabase, boolean z9, c cVar) {
        w6.e transactionDispatcher$room_runtime_release;
        h hVarPlus;
        if (!roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return roomDatabase.getCoroutineScope().getCoroutineContext();
        }
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
        return (transactionElement == null || (transactionDispatcher$room_runtime_release = transactionElement.getTransactionDispatcher$room_runtime_release()) == null || (hVarPlus = roomDatabase.getQueryContext().plus(transactionDispatcher$room_runtime_release)) == null) ? z9 ? roomDatabase.getTransactionContext$room_runtime_release() : roomDatabase.getQueryContext() : hVarPlus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> R performBlocking(RoomDatabase roomDatabase, boolean z9, boolean z10, l lVar) {
        roomDatabase.getClass();
        lVar.getClass();
        roomDatabase.assertNotMainThread();
        roomDatabase.assertNotSuspendingTransaction();
        return (R) RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new AnonymousClass1(roomDatabase, z9, z10, lVar, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> Object performInTransactionSuspending(RoomDatabase roomDatabase, l lVar, c cVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return RoomDatabaseKt.withTransactionContext(roomDatabase, new AnonymousClass2(roomDatabase, lVar, null), cVar);
        }
        return y.z(new AnonymousClass3(roomDatabase, lVar, null), roomDatabase.getCoroutineScope().getCoroutineContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object performSuspending(androidx.room.RoomDatabase r15, boolean r16, boolean r17, g7.l r18, w6.c r19) throws java.lang.Throwable {
        /*
            r0 = r19
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt.C01341
            if (r1 == 0) goto L16
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt.C01341) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.result
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r7 = 1
            x6.a r8 = x6.a.f13718a
            if (r1 == 0) goto L50
            if (r1 == r7) goto L4c
            if (r1 == r3) goto L38
            if (r1 != r2) goto L31
            s6.a.e(r0)
            return r0
        L31:
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r15)
            r15 = 0
            return r15
        L38:
            boolean r15 = r6.Z$1
            boolean r1 = r6.Z$0
            java.lang.Object r3 = r6.L$1
            g7.l r3 = (g7.l) r3
            java.lang.Object r4 = r6.L$0
            androidx.room.RoomDatabase r4 = (androidx.room.RoomDatabase) r4
            s6.a.e(r0)
            r13 = r15
            r14 = r3
            r11 = r4
        L4a:
            r12 = r1
            goto L9a
        L4c:
            s6.a.e(r0)
            return r0
        L50:
            s6.a.e(r0)
            boolean r0 = r15.inCompatibilityMode$room_runtime_release()
            if (r0 == 0) goto L7e
            boolean r0 = r15.isOpenInternal()
            if (r0 == 0) goto L7e
            boolean r0 = r15.inTransaction()
            if (r0 == 0) goto L7e
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r15
            r2 = r16
            r1 = r17
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r6.label = r7
            java.lang.Object r15 = r15.useConnection$room_runtime_release(r1, r2, r6)
            if (r15 != r8) goto L7d
            goto Laf
        L7d:
            return r15
        L7e:
            r1 = r16
            r4 = r17
            r6.L$0 = r15
            r5 = r18
            r6.L$1 = r5
            r6.Z$0 = r1
            r6.Z$1 = r4
            r6.label = r3
            java.lang.Object r3 = androidx.room.util.DBUtil.getCoroutineContext(r15, r4, r6)
            if (r3 != r8) goto L95
            goto Laf
        L95:
            r11 = r15
            r0 = r3
            r13 = r4
            r14 = r5
            goto L4a
        L9a:
            w6.h r0 = (w6.h) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r9 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r10 = 0
            r9.<init>(r10, r11, r12, r13, r14)
            r15 = 0
            r6.L$0 = r15
            r6.L$1 = r15
            r6.label = r2
            java.lang.Object r15 = r7.y.z(r9, r0, r6)
            if (r15 != r8) goto Lb0
        Laf:
            return r8
        Lb0:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.performSuspending(androidx.room.RoomDatabase, boolean, boolean, g7.l, w6.c):java.lang.Object");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9, CancellationSignal cancellationSignal) {
        roomDatabase.getClass();
        supportSQLiteQuery.getClass();
        Cursor cursorQuery = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z9 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int readVersion(File file) throws IOException {
        file.getClass();
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i10 = byteBufferAllocate.getInt();
            a4.j(channel, null);
            return i10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a4.j(channel, th);
                throw th2;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteConnection toSQLiteConnection(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        return new SupportSQLiteConnection(supportSQLiteDatabase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9) {
        roomDatabase.getClass();
        supportSQLiteQuery.getClass();
        return DBUtil.query(roomDatabase, supportSQLiteQuery, z9, null);
    }
}
