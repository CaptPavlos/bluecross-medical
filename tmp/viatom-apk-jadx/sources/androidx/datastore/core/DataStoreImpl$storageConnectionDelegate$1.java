package androidx.datastore.core;

import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreImpl$storageConnectionDelegate$1 extends m implements g7.a {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$storageConnectionDelegate$1(DataStoreImpl<T> dataStoreImpl) {
        super(0);
        this.this$0 = dataStoreImpl;
    }

    @Override // g7.a
    public final StorageConnection<T> invoke() {
        return ((DataStoreImpl) this.this$0).storage.createConnection();
    }
}
