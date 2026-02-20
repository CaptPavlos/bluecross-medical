package androidx.datastore;

import android.content.Context;
import g7.a;
import kotlin.jvm.internal.m;
import t3.h;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreSingletonDelegate$getValue$1$1 extends m implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    @Override // g7.a
    public final z invoke() {
        String str = z.f14517b;
        Context context = this.$applicationContext;
        context.getClass();
        String absolutePath = DataStoreFile.dataStoreFile(context, ((DataStoreSingletonDelegate) this.this$0).fileName).getAbsolutePath();
        absolutePath.getClass();
        return h.i(absolutePath, false);
    }
}
