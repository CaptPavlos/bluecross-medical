package androidx.datastore.core;

import g7.p;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataMigrationInitializer<T> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0081 -> B:25:0x0064). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0084 -> B:25:0x0064). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <T> java.lang.Object runMigrations(java.util.List<? extends androidx.datastore.core.DataMigration<T>> r7, androidx.datastore.core.InitializerApi<T> r8, w6.c r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r6, r9)
            L18:
                java.lang.Object r9 = r0.result
                int r1 = r0.label
                r2 = 2
                r3 = 1
                x6.a r4 = x6.a.f13718a
                if (r1 == 0) goto L43
                if (r1 == r3) goto L3b
                if (r1 != r2) goto L34
                java.lang.Object r7 = r0.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.L$0
                kotlin.jvm.internal.x r8 = (kotlin.jvm.internal.x) r8
                s6.a.e(r9)     // Catch: java.lang.Throwable -> L32
                goto L64
            L32:
                r9 = move-exception
                goto L7d
            L34:
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                androidx.window.layout.c.g(r7)
                r7 = 0
                return r7
            L3b:
                java.lang.Object r7 = r0.L$0
                java.util.List r7 = (java.util.List) r7
                s6.a.e(r9)
                goto L59
            L43:
                java.util.ArrayList r9 = androidx.constraintlayout.core.widgets.analyzer.a.A(r9)
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r5 = 0
                r1.<init>(r7, r9, r5)
                r0.L$0 = r9
                r0.label = r3
                java.lang.Object r7 = r8.updateData(r1, r0)
                if (r7 != r4) goto L58
                goto L7c
            L58:
                r7 = r9
            L59:
                kotlin.jvm.internal.x r8 = new kotlin.jvm.internal.x
                r8.<init>()
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.Iterator r7 = r7.iterator()
            L64:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L8d
                java.lang.Object r9 = r7.next()
                g7.l r9 = (g7.l) r9
                r0.L$0 = r8     // Catch: java.lang.Throwable -> L32
                r0.L$1 = r7     // Catch: java.lang.Throwable -> L32
                r0.label = r2     // Catch: java.lang.Throwable -> L32
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L32
                if (r9 != r4) goto L64
            L7c:
                return r4
            L7d:
                java.lang.Object r1 = r8.f10138a
                if (r1 != 0) goto L84
                r8.f10138a = r9
                goto L64
            L84:
                r1.getClass()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                s6.a.a(r1, r9)
                goto L64
            L8d:
                java.lang.Object r7 = r8.f10138a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L96
                s6.w r7 = s6.w.f12711a
                return r7
            L96:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.runMigrations(java.util.List, androidx.datastore.core.InitializerApi, w6.c):java.lang.Object");
        }

        public final <T> p getInitializer(List<? extends DataMigration<T>> list) {
            list.getClass();
            return new DataMigrationInitializer$Companion$getInitializer$1(list, null);
        }

        private Companion() {
        }
    }
}
