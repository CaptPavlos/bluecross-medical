package a6;

import com.uptodown.workers.GetUserDataWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f266a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetUserDataWorker f267b;

    /* renamed from: c, reason: collision with root package name */
    public int f268c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(GetUserDataWorker getUserDataWorker, w6.c cVar) {
        super(cVar);
        this.f267b = getUserDataWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f266a = obj;
        this.f268c |= Integer.MIN_VALUE;
        return this.f267b.doWork(this);
    }
}
