package a6;

import com.uptodown.workers.AppUpdatedWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppUpdatedWorker f251b;

    /* renamed from: c, reason: collision with root package name */
    public int f252c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AppUpdatedWorker appUpdatedWorker, w6.c cVar) {
        super(cVar);
        this.f251b = appUpdatedWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f250a = obj;
        this.f252c |= Integer.MIN_VALUE;
        return this.f251b.doWork(this);
    }
}
