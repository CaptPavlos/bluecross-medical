package androidx.datastore.core;

import a8.j;
import java.io.File;
import java.io.IOException;
import y6.c;
import y6.e;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final g7.a onClose;
    private final Serializer<T> serializer;
    private final a8.a transactionMutex;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {101}, m = "readScope")
    /* renamed from: androidx.datastore.core.FileStorageConnection$readScope$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileStorageConnection<T> fileStorageConnection, w6.c cVar) {
            super(cVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {214, androidx.constraintlayout.widget.R.styleable.ConstraintSet_polarRelativeTo}, m = "writeScope")
    /* renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00961 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00961(FileStorageConnection<T> fileStorageConnection, w6.c cVar) {
            super(cVar);
            this.this$0 = fileStorageConnection;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator interProcessCoordinator, g7.a aVar) {
        file.getClass();
        serializer.getClass();
        interProcessCoordinator.getClass();
        aVar.getClass();
        this.file = file;
        this.serializer = serializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = aVar;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = j.a();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            androidx.window.layout.c.g("StorageConnection has already been disposed.");
        }
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            f.c(file, "Unable to create parent directories of ");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077 A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0078, blocks: (B:32:0x0077, B:41:0x0087, B:40:0x0084, B:37:0x007f), top: B:53:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [g7.q] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object readScope(g7.q r7, w6.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.FileStorageConnection.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L39
            if (r1 != r2) goto L32
            boolean r7 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            s6.a.e(r8)     // Catch: java.lang.Throwable -> L30
            goto L67
        L30:
            r8 = move-exception
            goto L7f
        L32:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L39:
            s6.a.e(r8)
            r6.checkNotClosed()
            a8.a r8 = r6.transactionMutex
            boolean r8 = r8.tryLock(r3)
            androidx.datastore.core.FileReadScope r1 = new androidx.datastore.core.FileReadScope     // Catch: java.lang.Throwable -> L88
            java.io.File r4 = r6.file     // Catch: java.lang.Throwable -> L88
            androidx.datastore.core.Serializer<T> r5 = r6.serializer     // Catch: java.lang.Throwable -> L88
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L88
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L7a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L7a
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L7a
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L7a
            r0.label = r2     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r7 = r7.invoke(r1, r4, r0)     // Catch: java.lang.Throwable -> L7a
            x6.a r0 = x6.a.f13718a
            if (r7 != r0) goto L63
            return r0
        L63:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L67:
            r1.close()     // Catch: java.lang.Throwable -> L6c
            r1 = r3
            goto L6d
        L6c:
            r1 = move-exception
        L6d:
            if (r1 != 0) goto L77
            if (r7 == 0) goto L76
            a8.a r7 = r0.transactionMutex
            r7.unlock(r3)
        L76:
            return r8
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78
        L78:
            r8 = move-exception
            goto L8d
        L7a:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L7f:
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r1 = move-exception
            s6.a.a(r8, r1)     // Catch: java.lang.Throwable -> L78
        L87:
            throw r8     // Catch: java.lang.Throwable -> L78
        L88:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L8d:
            if (r7 == 0) goto L94
            a8.a r7 = r0.transactionMutex
            r7.unlock(r3)
        L94:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(g7.q, w6.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6 A[Catch: all -> 0x00e6, IOException -> 0x00e9, TRY_ENTER, TryCatch #8 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:34:0x00b6, B:36:0x00bc, B:39:0x00c5, B:40:0x00e5, B:47:0x00f2, B:54:0x00ff, B:53:0x00fc), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2 A[Catch: all -> 0x00e6, IOException -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:34:0x00b6, B:36:0x00bc, B:39:0x00c5, B:40:0x00e5, B:47:0x00f2, B:54:0x00ff, B:53:0x00fc), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [a8.a] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.File, java.lang.Object] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeScope(g7.p r10, w6.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(g7.p, w6.c):java.lang.Object");
    }
}
