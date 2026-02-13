package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import y6.c;
import y6.e;
import z8.p;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", l = {216}, m = "writeData")
    /* renamed from: androidx.datastore.core.okio.OkioWriteScope$writeData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioWriteScope<T> okioWriteScope, w6.c cVar) {
            super(cVar);
            this.this$0 = okioWriteScope;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(p pVar, z zVar, OkioSerializer<T> okioSerializer) {
        super(pVar, zVar, okioSerializer);
        pVar.getClass();
        zVar.getClass();
        okioSerializer.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a A[Catch: all -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00a6, blocks: (B:46:0x009a, B:54:0x00a8, B:19:0x0055), top: B:73:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8 A[Catch: all -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00a6, blocks: (B:46:0x009a, B:54:0x00a8, B:19:0x0055), top: B:73:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeData(T r8, w6.c r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.writeData(java.lang.Object, w6.c):java.lang.Object");
    }
}
