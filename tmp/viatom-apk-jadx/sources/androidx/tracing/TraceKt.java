package androidx.tracing;

import g7.a;
import g7.l;
import java.lang.reflect.InvocationTargetException;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TraceKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.tracing.TraceKt", f = "Trace.kt", l = {76}, m = "traceAsync")
    /* renamed from: androidx.tracing.TraceKt$traceAsync$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends c {
        int I$0;
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
            return TraceKt.traceAsync(null, 0, null, this);
        }
    }

    public static final <T> T trace(a aVar, a aVar2) {
        aVar.getClass();
        aVar2.getClass();
        boolean zIsEnabled = Trace.isEnabled();
        if (zIsEnabled) {
            Trace.beginSection((String) aVar.invoke());
        }
        try {
            return (T) aVar2.invoke();
        } finally {
            if (zIsEnabled) {
                Trace.endSection();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object traceAsync(java.lang.String r4, int r5, g7.l r6, w6.c r7) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L2b
            goto L49
        L2b:
            r6 = move-exception
            goto L4d
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L34:
            s6.a.e(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L2b
            r0.label = r2     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r7 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2b
            x6.a r6 = x6.a.f13718a
            if (r7 != r6) goto L49
            return r6
        L49:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            return r7
        L4d:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, g7.l, w6.c):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i10, l lVar, w6.c cVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Trace.beginAsyncSection(str, i10);
        try {
            return lVar.invoke(cVar);
        } finally {
            Trace.endAsyncSection(str, i10);
        }
    }

    public static final <T> T trace(String str, a aVar) {
        str.getClass();
        aVar.getClass();
        Trace.beginSection(str);
        try {
            return (T) aVar.invoke();
        } finally {
            Trace.endSection();
        }
    }

    public static final <T> T traceAsync(a aVar, a aVar2, a aVar3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        int iIntValue;
        aVar.getClass();
        aVar2.getClass();
        aVar3.getClass();
        if (Trace.isEnabled()) {
            str = (String) aVar.invoke();
            iIntValue = ((Number) aVar2.invoke()).intValue();
            Trace.beginAsyncSection(str, iIntValue);
        } else {
            str = null;
            iIntValue = 0;
        }
        try {
            return (T) aVar3.invoke();
        } finally {
            if (str != null) {
                Trace.endAsyncSection(str, iIntValue);
            }
        }
    }
}
