package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import y6.c;
import y6.e;
import z8.p;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final p fileSystem;
    private final z path;
    private final OkioSerializer<T> serializer;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {SubsamplingScaleImageView.ORIENTATION_180, 187}, m = "readData$suspendImpl")
    /* renamed from: androidx.datastore.core.okio.OkioReadScope$readData$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OkioReadScope<T> okioReadScope, w6.c cVar) {
            super(cVar);
            this.this$0 = okioReadScope;
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkioReadScope.readData$suspendImpl(this.this$0, this);
        }
    }

    public OkioReadScope(p pVar, z zVar, OkioSerializer<T> okioSerializer) {
        pVar.getClass();
        zVar.getClass();
        okioSerializer.getClass();
        this.fileSystem = pVar;
        this.path = zVar;
        this.serializer = okioSerializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f A[Catch: FileNotFoundException -> 0x0089, TryCatch #7 {FileNotFoundException -> 0x0089, blocks: (B:46:0x008f, B:47:0x0093, B:42:0x0085, B:39:0x0080), top: B:78:0x0080, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093 A[Catch: FileNotFoundException -> 0x0089, TRY_LEAVE, TryCatch #7 {FileNotFoundException -> 0x0089, blocks: (B:46:0x008f, B:47:0x0093, B:42:0x0085, B:39:0x0080), top: B:78:0x0080, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r7, w6.c r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, w6.c):java.lang.Object");
    }

    public final void checkClose() {
        if (this.closed.get()) {
            androidx.window.layout.c.g("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final p getFileSystem() {
        return this.fileSystem;
    }

    public final z getPath() {
        return this.path;
    }

    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(w6.c cVar) {
        return readData$suspendImpl(this, cVar);
    }
}
