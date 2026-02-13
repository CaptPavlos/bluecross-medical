package androidx.room;

import androidx.lifecycle.k;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import g7.l;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import o7.u;
import r0.f;
import r7.v;
import r7.y;
import t6.a0;
import u6.i;
import u7.e0;
import u7.h;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private final RoomDatabase database;
    private final ObservedTableStates observedTableStates;
    private final ObservedTableVersions observedTableVersions;
    private g7.a onAllowRefresh;
    private final l onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh;
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;
    public static final Companion Companion = new Companion(null);
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {440, 448}, m = "checkInvalidatedTables")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.checkInvalidatedTables(null, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {412}, m = "notifyInvalidation")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01151 extends y6.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01151(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.notifyInvalidation(this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {323, 328}, m = "startTrackingTable")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01161 extends y6.c {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C01161(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.startTrackingTable(null, 0, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {342}, m = "stopTrackingTable")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01171 extends y6.c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C01171(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.stopTrackingTable(null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, ? extends Set<String>> map2, String[] strArr, boolean z9, l lVar) {
        String lowerCase;
        roomDatabase.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        lVar.getClass();
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.useTempTable = z9;
        this.onInvalidatedTablesIds = lVar;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new k(5);
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i10));
            String str2 = this.shadowTablesMap.get(strArr[i10]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i10] = lowerCase2;
        }
        this.tablesNames = strArr2;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = value.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(locale2);
                lowerCase4.getClass();
                Map<String, Integer> map3 = this.tableIdLookup;
                map3.put(lowerCase4, a0.f0(map3, lowerCase3));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkInvalidatedTables(androidx.room.PooledConnection r6, w6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            x6.a r4 = x6.a.f13718a
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2e
            java.lang.Object r6 = r0.L$0
            java.util.Set r6 = (java.util.Set) r6
            s6.a.e(r7)
            return r6
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L35:
            java.lang.Object r6 = r0.L$0
            androidx.room.PooledConnection r6 = (androidx.room.PooledConnection) r6
            s6.a.e(r7)
            goto L53
        L3d:
            s6.a.e(r7)
            a3.q r7 = new a3.q
            r1 = 3
            r7.<init>(r1)
            r0.L$0 = r6
            r0.label = r3
            java.lang.String r1 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r7 = r6.usePrepared(r1, r7, r0)
            if (r7 != r4) goto L53
            goto L67
        L53:
            java.util.Set r7 = (java.util.Set) r7
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L68
            r0.L$0 = r7
            r0.label = r2
            java.lang.String r1 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r6 = androidx.room.TransactorKt.execSQL(r6, r1, r0)
            if (r6 != r4) goto L68
        L67:
            return r4
        L68:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.checkInvalidatedTables(androidx.room.PooledConnection, w6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        i iVar = new i();
        while (sQLiteStatement.step()) {
            iVar.add(Integer.valueOf((int) sQLiteStatement.getLong(0)));
        }
        return l1.b.o(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.room.concurrent.CloseBarrier] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyInvalidation(w6.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker.C01151
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.C01151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2f
            java.lang.Object r1 = r0.L$1
            androidx.room.concurrent.CloseBarrier r1 = (androidx.room.concurrent.CloseBarrier) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.TriggerBasedInvalidationTracker r0 = (androidx.room.TriggerBasedInvalidationTracker) r0
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L2d
            goto L7e
        L2d:
            r7 = move-exception
            goto L94
        L2f:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L36:
            s6.a.e(r7)
            androidx.room.RoomDatabase r7 = r6.database
            androidx.room.concurrent.CloseBarrier r1 = r7.getCloseBarrier$room_runtime_release()
            boolean r7 = r1.block$room_runtime_release()
            t6.v r3 = t6.v.f12810a
            if (r7 == 0) goto L98
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.pendingRefresh     // Catch: java.lang.Throwable -> L2d
            r4 = 0
            boolean r7 = r7.compareAndSet(r2, r4)     // Catch: java.lang.Throwable -> L2d
            if (r7 != 0) goto L54
            r1.unblock$room_runtime_release()
            return r3
        L54:
            g7.a r7 = r6.onAllowRefresh     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r7 = r7.invoke()     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L2d
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r7 != 0) goto L66
            r1.unblock$room_runtime_release()
            return r3
        L66:
            androidx.room.RoomDatabase r7 = r6.database     // Catch: java.lang.Throwable -> L2d
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            r3.<init>(r6, r5)     // Catch: java.lang.Throwable -> L2d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2d
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L2d
            r0.label = r2     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r7 = r7.useConnection$room_runtime_release(r4, r3, r0)     // Catch: java.lang.Throwable -> L2d
            x6.a r0 = x6.a.f13718a
            if (r7 != r0) goto L7d
            return r0
        L7d:
            r0 = r6
        L7e:
            java.util.Set r7 = (java.util.Set) r7     // Catch: java.lang.Throwable -> L2d
            boolean r2 = r7.isEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L90
            androidx.room.ObservedTableVersions r2 = r0.observedTableVersions     // Catch: java.lang.Throwable -> L2d
            r2.increment(r7)     // Catch: java.lang.Throwable -> L2d
            g7.l r0 = r0.onInvalidatedTablesIds     // Catch: java.lang.Throwable -> L2d
            r0.invoke(r7)     // Catch: java.lang.Throwable -> L2d
        L90:
            r1.unblock$room_runtime_release()
            return r7
        L94:
            r1.unblock$room_runtime_release()
            throw r7
        L98:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.notifyInvalidation(w6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    public static /* synthetic */ Object refreshInvalidation$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, g7.a aVar, g7.a aVar2, w6.c cVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new k(1);
        }
        if ((i10 & 4) != 0) {
            aVar2 = new k(2);
        }
        return triggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(strArr, aVar, aVar2, cVar);
    }

    public static /* synthetic */ void refreshInvalidationAsync$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, g7.a aVar, g7.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = new k(3);
        }
        if ((i10 & 2) != 0) {
            aVar2 = new k(4);
        }
        triggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release(aVar, aVar2);
    }

    private final String[] resolveViews(String[] strArr) {
        i iVar = new i();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                iVar.addAll(set);
            } else {
                iVar.add(str);
            }
        }
        return (String[]) l1.b.o(iVar).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ef, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r11, r3, r4) == r8) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ef -> B:29:0x00f2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startTrackingTable(androidx.room.PooledConnection r18, int r19, w6.c r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.startTrackingTable(androidx.room.PooledConnection, int, w6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:20:0x0081). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stopTrackingTable(androidx.room.PooledConnection r9, int r10, w6.c r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.room.TriggerBasedInvalidationTracker.C01171
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.C01171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L36
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r1 = r0.L$2
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.Object r3 = r0.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.L$0
            androidx.room.PooledConnection r4 = (androidx.room.PooledConnection) r4
            s6.a.e(r11)
            r11 = r3
            goto L81
        L36:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            r9 = 0
            return r9
        L3d:
            s6.a.e(r11)
            java.lang.String[] r11 = r8.tablesNames
            r10 = r11[r10]
            java.lang.String[] r11 = androidx.room.TriggerBasedInvalidationTracker.TRIGGERS
            int r1 = r11.length
            r3 = 0
            r7 = r10
            r10 = r9
            r9 = r1
            r1 = r11
            r11 = r7
        L4d:
            if (r3 >= r9) goto L85
            r4 = r1[r3]
            androidx.room.TriggerBasedInvalidationTracker$Companion r5 = androidx.room.TriggerBasedInvalidationTracker.Companion
            java.lang.String r4 = androidx.room.TriggerBasedInvalidationTracker.Companion.access$getTriggerName(r5, r11, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DROP TRIGGER IF EXISTS `"
            r5.<init>(r6)
            r5.append(r4)
            r4 = 96
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r1
            r0.I$0 = r3
            r0.I$1 = r9
            r0.label = r2
            java.lang.Object r4 = androidx.room.TransactorKt.execSQL(r10, r4, r0)
            x6.a r5 = x6.a.f13718a
            if (r4 != r5) goto L7f
            return r5
        L7f:
            r4 = r10
            r10 = r3
        L81:
            int r3 = r10 + 1
            r10 = r4
            goto L4d
        L85:
            s6.w r9 = s6.w.f12711a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.stopTrackingTable(androidx.room.PooledConnection, int, w6.c):java.lang.Object");
    }

    public final void configureConnection(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA query_only");
        try {
            sQLiteStatementPrepare.step();
            boolean z9 = sQLiteStatementPrepare.getBoolean(0);
            f.p(sQLiteStatementPrepare, null);
            if (z9) {
                return;
            }
            SQLite.execSQL(sQLiteConnection, "PRAGMA temp_store = MEMORY");
            SQLite.execSQL(sQLiteConnection, "PRAGMA recursive_triggers = 1");
            SQLite.execSQL(sQLiteConnection, DROP_TRACKING_TABLE_SQL);
            if (this.useTempTable) {
                SQLite.execSQL(sQLiteConnection, CREATE_TRACKING_TABLE_SQL);
            } else {
                SQLite.execSQL(sQLiteConnection, u.b0(CREATE_TRACKING_TABLE_SQL, "TEMP", "", false));
            }
            this.observedTableStates.forceNeedSync$room_runtime_release();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.p(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public final h createFlow$room_runtime_release(String[] strArr, int[] iArr, boolean z9) {
        strArr.getClass();
        iArr.getClass();
        return new e0(new TriggerBasedInvalidationTracker$createFlow$1(this, iArr, z9, strArr, null));
    }

    public final g7.a getOnAllowRefresh$room_runtime_release() {
        return this.onAllowRefresh;
    }

    public final boolean onObserverAdded$room_runtime_release(int[] iArr) {
        iArr.getClass();
        return this.observedTableStates.onObserverAdded$room_runtime_release(iArr);
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] iArr) {
        iArr.getClass();
        return this.observedTableStates.onObserverRemoved$room_runtime_release(iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshInvalidation$room_runtime_release(java.lang.String[] r6, g7.a r7, g7.a r8, w6.c r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L30
            java.lang.Object r6 = r0.L$1
            int[] r6 = (int[]) r6
            java.lang.Object r7 = r0.L$0
            r8 = r7
            g7.a r8 = (g7.a) r8
            s6.a.e(r9)     // Catch: java.lang.Throwable -> L2e
            goto L54
        L2e:
            r6 = move-exception
            goto L84
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L37:
            s6.a.e(r9)
            s6.i r6 = r5.validateTableNames$room_runtime_release(r6)
            java.lang.Object r6 = r6.f12694b
            int[] r6 = (int[]) r6
            r7.invoke()
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L2e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L2e
            r0.label = r2     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r9 = r5.notifyInvalidation(r0)     // Catch: java.lang.Throwable -> L2e
            x6.a r7 = x6.a.f13718a
            if (r9 != r7) goto L54
            return r7
        L54:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L2e
            int r7 = r6.length     // Catch: java.lang.Throwable -> L2e
            r0 = 0
            if (r7 != 0) goto L5c
            r7 = r2
            goto L5d
        L5c:
            r7 = r0
        L5d:
            if (r7 != 0) goto L76
            int r7 = r6.length     // Catch: java.lang.Throwable -> L2e
            r1 = r0
        L61:
            if (r1 >= r7) goto L74
            r3 = r6[r1]     // Catch: java.lang.Throwable -> L2e
            java.lang.Integer r4 = new java.lang.Integer     // Catch: java.lang.Throwable -> L2e
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2e
            boolean r3 = r9.contains(r4)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L71
            goto L7c
        L71:
            int r1 = r1 + 1
            goto L61
        L74:
            r2 = r0
            goto L7c
        L76:
            boolean r6 = r9.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L74
        L7c:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L2e
            r8.invoke()
            return r6
        L84:
            r8.invoke()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(java.lang.String[], g7.a, g7.a, w6.c):java.lang.Object");
    }

    public final void refreshInvalidationAsync$room_runtime_release(g7.a aVar, g7.a aVar2) {
        aVar.getClass();
        aVar2.getClass();
        if (this.pendingRefresh.compareAndSet(false, true)) {
            aVar.invoke();
            y.q(this.database.getCoroutineScope(), new v(), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, aVar2, null), 2);
        }
    }

    public final void resetSync$room_runtime_release() {
        this.observedTableStates.resetTriggerState$room_runtime_release();
    }

    public final void setOnAllowRefresh$room_runtime_release(g7.a aVar) {
        aVar.getClass();
        this.onAllowRefresh = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncTriggers$room_runtime_release(w6.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            java.lang.Object r0 = r0.L$0
            androidx.room.concurrent.CloseBarrier r0 = (androidx.room.concurrent.CloseBarrier) r0
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L29
            goto L58
        L29:
            r7 = move-exception
            goto L60
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L32:
            s6.a.e(r7)
            androidx.room.RoomDatabase r7 = r6.database
            androidx.room.concurrent.CloseBarrier r7 = r7.getCloseBarrier$room_runtime_release()
            boolean r1 = r7.block$room_runtime_release()
            if (r1 == 0) goto L64
            androidx.room.RoomDatabase r1 = r6.database     // Catch: java.lang.Throwable -> L5c
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch: java.lang.Throwable -> L5c
            r4 = 0
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L5c
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5c
            r0.label = r2     // Catch: java.lang.Throwable -> L5c
            r2 = 0
            java.lang.Object r0 = r1.useConnection$room_runtime_release(r2, r3, r0)     // Catch: java.lang.Throwable -> L5c
            x6.a r1 = x6.a.f13718a
            if (r0 != r1) goto L57
            return r1
        L57:
            r0 = r7
        L58:
            r0.unblock$room_runtime_release()
            goto L64
        L5c:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L60:
            r0.unblock$room_runtime_release()
            throw r7
        L64:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.syncTriggers$room_runtime_release(w6.c):java.lang.Object");
    }

    public final s6.i validateTableNames$room_runtime_release(String[] strArr) {
        strArr.getClass();
        String[] strArrResolveViews = resolveViews(strArr);
        int length = strArrResolveViews.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArrResolveViews[i10];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Integer num = map.get(lowerCase);
            if (num == null) {
                com.google.gson.internal.a.n("There is no table with name ".concat(str));
                return null;
            }
            iArr[i10] = num.intValue();
        }
        return new s6.i(strArrResolveViews, iArr);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }

        private Companion() {
        }
    }
}
