package androidx.lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {226}, m = "clearSource$lifecycle_livedata_release")
/* loaded from: classes.dex */
public final class CoroutineLiveData$clearSource$1 extends y6.c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$clearSource$1(CoroutineLiveData<T> coroutineLiveData, w6.c cVar) {
        super(cVar);
        this.this$0 = coroutineLiveData;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_release(this);
    }
}
