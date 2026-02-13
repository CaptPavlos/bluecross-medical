package androidx.datastore.core.okio;

import a9.c;
import g7.a;
import kotlin.jvm.internal.m;
import t3.h;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioStorage$canonicalPath$2 extends m implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorage$canonicalPath$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    @Override // g7.a
    public final z invoke() {
        z zVar = (z) ((OkioStorage) this.this$0).producePath.invoke();
        zVar.getClass();
        boolean z9 = c.a(zVar) != -1;
        OkioStorage<T> okioStorage = this.this$0;
        if (z9) {
            return h.i(zVar.f14518a.r(), true);
        }
        throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + ((OkioStorage) okioStorage).producePath + ", instead got " + zVar).toString());
    }
}
