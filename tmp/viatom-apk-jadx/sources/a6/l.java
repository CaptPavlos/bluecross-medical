package a6;

import com.uptodown.workers.MyAppUpdatedWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f269a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyAppUpdatedWorker f270b;

    /* renamed from: c, reason: collision with root package name */
    public int f271c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MyAppUpdatedWorker myAppUpdatedWorker, w6.c cVar) {
        super(cVar);
        this.f270b = myAppUpdatedWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f269a = obj;
        this.f271c |= Integer.MIN_VALUE;
        return this.f270b.doWork(this);
    }
}
