package a6;

import com.uptodown.workers.GetRemoteInstallWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f260a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetRemoteInstallWorker f261b;

    /* renamed from: c, reason: collision with root package name */
    public int f262c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(GetRemoteInstallWorker getRemoteInstallWorker, w6.c cVar) {
        super(cVar);
        this.f261b = getRemoteInstallWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f260a = obj;
        this.f262c |= Integer.MIN_VALUE;
        return this.f261b.doWork(this);
    }
}
