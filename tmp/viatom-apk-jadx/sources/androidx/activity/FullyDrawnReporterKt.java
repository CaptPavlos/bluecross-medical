package androidx.activity;

import g7.l;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
    /* renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
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
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r4, g7.l r5, w6.c r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            s6.w r2 = s6.w.f12711a
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            s6.a.e(r6)     // Catch: java.lang.Throwable -> L2b
            goto L4e
        L2b:
            r5 = move-exception
            goto L52
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L34:
            s6.a.e(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L41
            return r2
        L41:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.label = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L2b
            x6.a r6 = x6.a.f13718a
            if (r5 != r6) goto L4e
            return r6
        L4e:
            r4.removeReporter()
            return r2
        L52:
            r4.removeReporter()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, g7.l, w6.c):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, l lVar, w6.c cVar) {
        fullyDrawnReporter.addReporter();
        boolean zIsFullyDrawnReported = fullyDrawnReporter.isFullyDrawnReported();
        w wVar = w.f12711a;
        if (zIsFullyDrawnReported) {
            return wVar;
        }
        try {
            lVar.invoke(cVar);
            return wVar;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
