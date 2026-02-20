package androidx.datastore.core.okio;

import a8.j;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import g7.a;
import y6.c;
import y6.e;
import z8.p;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final p fileSystem;
    private final a onClose;
    private final z path;
    private final OkioSerializer<T> serializer;
    private final a8.a transactionMutex;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {113}, m = "readScope")
    /* renamed from: androidx.datastore.core.okio.OkioStorageConnection$readScope$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioStorageConnection<T> okioStorageConnection, w6.c cVar) {
            super(cVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {236, 137}, m = "writeScope")
    /* renamed from: androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01001 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01001(OkioStorageConnection<T> okioStorageConnection, w6.c cVar) {
            super(cVar);
            this.this$0 = okioStorageConnection;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public OkioStorageConnection(p pVar, z zVar, OkioSerializer<T> okioSerializer, InterProcessCoordinator interProcessCoordinator, a aVar) {
        pVar.getClass();
        zVar.getClass();
        okioSerializer.getClass();
        interProcessCoordinator.getClass();
        aVar.getClass();
        this.fileSystem = pVar;
        this.path = zVar;
        this.serializer = okioSerializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = aVar;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = j.a();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            androidx.window.layout.c.g("StorageConnection has already been disposed.");
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
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079 A[Catch: all -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007a, blocks: (B:32:0x0079, B:41:0x0089, B:40:0x0086, B:37:0x0081), top: B:53:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [g7.q] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object readScope(g7.q r8, w6.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.okio.OkioStorageConnection.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L39
            if (r1 != r2) goto L32
            boolean r8 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            s6.a.e(r9)     // Catch: java.lang.Throwable -> L30
            goto L69
        L30:
            r9 = move-exception
            goto L81
        L32:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            r8 = 0
            return r8
        L39:
            s6.a.e(r9)
            r7.checkNotClosed()
            a8.a r9 = r7.transactionMutex
            boolean r9 = r9.tryLock(r3)
            androidx.datastore.core.okio.OkioReadScope r1 = new androidx.datastore.core.okio.OkioReadScope     // Catch: java.lang.Throwable -> L8a
            z8.p r4 = r7.fileSystem     // Catch: java.lang.Throwable -> L8a
            z8.z r5 = r7.path     // Catch: java.lang.Throwable -> L8a
            androidx.datastore.core.okio.OkioSerializer<T> r6 = r7.serializer     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L8a
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L7c
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7c
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L7c
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L7c
            r0.label = r2     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r8 = r8.invoke(r1, r4, r0)     // Catch: java.lang.Throwable -> L7c
            x6.a r0 = x6.a.f13718a
            if (r8 != r0) goto L65
            return r0
        L65:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L69:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            r1 = r3
            goto L6f
        L6e:
            r1 = move-exception
        L6f:
            if (r1 != 0) goto L79
            if (r8 == 0) goto L78
            a8.a r8 = r0.transactionMutex
            r8.unlock(r3)
        L78:
            return r9
        L79:
            throw r1     // Catch: java.lang.Throwable -> L7a
        L7a:
            r9 = move-exception
            goto L8f
        L7c:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L81:
            r1.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r1 = move-exception
            s6.a.a(r9, r1)     // Catch: java.lang.Throwable -> L7a
        L89:
            throw r9     // Catch: java.lang.Throwable -> L7a
        L8a:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L8f:
            if (r8 == 0) goto L96
            a8.a r8 = r0.transactionMutex
            r8.unlock(r3)
        L96:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(g7.q, w6.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: all -> 0x0105, IOException -> 0x0108, TRY_ENTER, TryCatch #9 {IOException -> 0x0108, all -> 0x0105, blocks: (B:45:0x00f5, B:47:0x00fd, B:55:0x0112, B:62:0x0120, B:61:0x011d), top: B:75:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0112 A[Catch: all -> 0x0105, IOException -> 0x0108, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x0108, all -> 0x0105, blocks: (B:45:0x00f5, B:47:0x00fd, B:55:0x0112, B:62:0x0120, B:61:0x011d), top: B:75:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, java.lang.Object, w6.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [z8.p] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, z8.p] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v8, types: [g7.p] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [a8.a] */
    /* JADX WARN: Type inference failed for: r11v7, types: [a8.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [z8.z] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, z8.z] */
    /* JADX WARN: Type inference failed for: r3v4, types: [z8.p] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeScope(g7.p r10, w6.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(g7.p, w6.c):java.lang.Object");
    }
}
