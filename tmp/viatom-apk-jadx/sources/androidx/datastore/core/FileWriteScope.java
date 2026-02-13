package androidx.datastore.core;

import java.io.File;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.FileWriteScope", f = "FileStorage.kt", l = {201}, m = "writeData")
    /* renamed from: androidx.datastore.core.FileWriteScope$writeData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileWriteScope<T> fileWriteScope, w6.c cVar) {
            super(cVar);
            this.this$0 = fileWriteScope;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        file.getClass();
        serializer.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeData(T r5, w6.c r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.FileWriteScope.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2f
            java.lang.Object r5 = r0.L$1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            s6.a.e(r6)     // Catch: java.lang.Throwable -> L2d
            goto L5f
        L2d:
            r5 = move-exception
            goto L6f
        L2f:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L36:
            s6.a.e(r6)
            r4.checkNotClosed()
            java.io.FileOutputStream r6 = new java.io.FileOutputStream
            java.io.File r1 = r4.getFile()
            r6.<init>(r1)
            androidx.datastore.core.Serializer r1 = r4.getSerializer()     // Catch: java.lang.Throwable -> L6d
            androidx.datastore.core.UncloseableOutputStream r3 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L6d
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L6d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6d
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6d
            r0.label = r2     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r5 = r1.writeTo(r5, r3, r0)     // Catch: java.lang.Throwable -> L6d
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L5d
            return r0
        L5d:
            r5 = r6
            r0 = r5
        L5f:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L2d
            r5.sync()     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            com.google.android.gms.internal.measurement.a4.j(r0, r5)
            s6.w r5 = s6.w.f12711a
            return r5
        L6d:
            r5 = move-exception
            r0 = r6
        L6f:
            throw r5     // Catch: java.lang.Throwable -> L70
        L70:
            r6 = move-exception
            com.google.android.gms.internal.measurement.a4.j(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, w6.c):java.lang.Object");
    }
}
