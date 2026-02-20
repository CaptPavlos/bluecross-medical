package androidx.room;

import g7.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r7.w;
import r7.y;
import y6.e;
import y6.i;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2", f = "RoomDatabase.kt", l = {468}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ RoomDatabase $this_useReaderConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RoomDatabase roomDatabase, p pVar, w6.c cVar) {
            super(2, cVar);
            this.$this_useReaderConnection = roomDatabase;
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass2(this.$this_useReaderConnection, this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
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
            RoomDatabase roomDatabase = this.$this_useReaderConnection;
            p pVar = this.$block;
            this.label = 1;
            Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(true, pVar, this);
            x6.a aVar = x6.a.f13718a;
            return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt", f = "RoomDatabase.kt", l = {496}, m = "useWriterConnection")
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends y6.c {
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
            return RoomDatabaseKt.useWriterConnection(null, null, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2", f = "RoomDatabase.kt", l = {496}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01122 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ RoomDatabase $this_useWriterConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01122(RoomDatabase roomDatabase, p pVar, w6.c cVar) {
            super(2, cVar);
            this.$this_useWriterConnection = roomDatabase;
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new C01122(this.$this_useWriterConnection, this.$block, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01122) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
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
            RoomDatabase roomDatabase = this.$this_useWriterConnection;
            p pVar = this.$block;
            this.label = 1;
            Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, pVar, this);
            x6.a aVar = x6.a.f13718a;
            return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
        }
    }

    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, p pVar, w6.c cVar) {
        return y.z(new AnonymousClass2(roomDatabase, pVar, null), roomDatabase.getCoroutineScope().getCoroutineContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object useWriterConnection(androidx.room.RoomDatabase r4, g7.p r5, w6.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r4 = r0.L$0
            androidx.room.RoomDatabase r4 = (androidx.room.RoomDatabase) r4
            s6.a.e(r6)
            goto L4e
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L30:
            s6.a.e(r6)
            r7.w r6 = r4.getCoroutineScope()
            w6.h r6 = r6.getCoroutineContext()
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 r1 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2
            r3 = 0
            r1.<init>(r4, r5, r3)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r6 = r7.y.z(r1, r6, r0)
            x6.a r5 = x6.a.f13718a
            if (r6 != r5) goto L4e
            return r5
        L4e:
            androidx.room.InvalidationTracker r4 = r4.getInvalidationTracker()
            r4.refreshAsync()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(androidx.room.RoomDatabase, g7.p, w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
    
        com.google.gson.internal.a.n("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void validateAutoMigrations(androidx.room.RoomDatabase r10, androidx.room.DatabaseConfiguration r11) {
        /*
            r10.getClass()
            r11.getClass()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r1 = r10.getRequiredAutoMigrationSpecClasses()
            int r2 = r1.size()
            boolean[] r3 = new boolean[r2]
            java.util.Iterator r1 = r1.iterator()
        L19:
            boolean r4 = r1.hasNext()
            r5 = -1
            if (r4 == 0) goto L66
            java.lang.Object r4 = r1.next()
            m7.c r4 = (m7.c) r4
            java.util.List<androidx.room.migration.AutoMigrationSpec> r6 = r11.autoMigrationSpecs
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r5
            if (r6 < 0) goto L4c
        L31:
            int r7 = r6 + (-1)
            java.util.List<androidx.room.migration.AutoMigrationSpec> r8 = r11.autoMigrationSpecs
            java.lang.Object r8 = r8.get(r6)
            r9 = r4
            kotlin.jvm.internal.f r9 = (kotlin.jvm.internal.f) r9
            boolean r8 = r9.d(r8)
            if (r8 == 0) goto L47
            r5 = 1
            r3[r6] = r5
            r5 = r6
            goto L4c
        L47:
            if (r7 >= 0) goto L4a
            goto L4c
        L4a:
            r6 = r7
            goto L31
        L4c:
            if (r5 < 0) goto L58
            java.util.List<androidx.room.migration.AutoMigrationSpec> r6 = r11.autoMigrationSpecs
            java.lang.Object r5 = r6.get(r5)
            r0.put(r4, r5)
            goto L19
        L58:
            kotlin.jvm.internal.f r4 = (kotlin.jvm.internal.f) r4
            java.lang.String r10 = r4.b()
            java.lang.String r11 = ") is missing in the database configuration."
            java.lang.String r0 = "A required auto migration spec ("
            androidx.core.view.accessibility.a.t(r10, r0, r11)
            return
        L66:
            java.util.List<androidx.room.migration.AutoMigrationSpec> r1 = r11.autoMigrationSpecs
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            int r1 = r1 + r5
            if (r1 < 0) goto L84
        L71:
            int r4 = r1 + (-1)
            if (r1 >= r2) goto L7e
            boolean r1 = r3[r1]
            if (r1 == 0) goto L7e
            if (r4 >= 0) goto L7c
            goto L84
        L7c:
            r1 = r4
            goto L71
        L7e:
            java.lang.String r10 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            com.google.gson.internal.a.n(r10)
            return
        L84:
            java.util.List r10 = r10.createAutoMigrations(r0)
            java.util.Iterator r10 = r10.iterator()
        L8c:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto Laa
            java.lang.Object r0 = r10.next()
            androidx.room.migration.Migration r0 = (androidx.room.migration.Migration) r0
            androidx.room.RoomDatabase$MigrationContainer r1 = r11.migrationContainer
            int r2 = r0.startVersion
            int r3 = r0.endVersion
            boolean r1 = r1.contains(r2, r3)
            if (r1 != 0) goto L8c
            androidx.room.RoomDatabase$MigrationContainer r1 = r11.migrationContainer
            r1.addMigration(r0)
            goto L8c
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        set.getClass();
        set2.getClass();
        if (set.isEmpty()) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (set2.contains(Integer.valueOf(iIntValue))) {
                f.b(a3.a.f(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: "));
                return;
            }
        }
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        roomDatabase.getClass();
        databaseConfiguration.getClass();
        Map<m7.c, List<m7.c>> requiredTypeConverterClassesMap$room_runtime_release = roomDatabase.getRequiredTypeConverterClassesMap$room_runtime_release();
        boolean[] zArr = new boolean[requiredTypeConverterClassesMap$room_runtime_release.size()];
        for (Map.Entry<m7.c, List<m7.c>> entry : requiredTypeConverterClassesMap$room_runtime_release.entrySet()) {
            m7.c key = entry.getKey();
            for (m7.c cVar : entry.getValue()) {
                int size = databaseConfiguration.typeConverters.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i10 = size - 1;
                        if (((kotlin.jvm.internal.f) cVar).d(databaseConfiguration.typeConverters.get(size))) {
                            zArr[size] = true;
                            break;
                        } else if (i10 < 0) {
                            break;
                        } else {
                            size = i10;
                        }
                    }
                    size = -1;
                } else {
                    size = -1;
                }
                if (size < 0) {
                    throw new IllegalArgumentException(("A required type converter (" + ((kotlin.jvm.internal.f) cVar).b() + ") for " + ((kotlin.jvm.internal.f) key).b() + " is missing in the database configuration.").toString());
                }
                roomDatabase.addTypeConverter$room_runtime_release(cVar, databaseConfiguration.typeConverters.get(size));
            }
        }
        int size2 = databaseConfiguration.typeConverters.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i11 = size2 - 1;
            if (!zArr[size2]) {
                androidx.core.view.accessibility.a.j(databaseConfiguration.typeConverters.get(size2), "Unexpected type converter ", ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                return;
            } else if (i11 < 0) {
                return;
            } else {
                size2 = i11;
            }
        }
    }
}
