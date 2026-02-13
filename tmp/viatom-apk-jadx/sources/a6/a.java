package a6;

import com.uptodown.workers.AppInstalledWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f242a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledWorker f243b;

    /* renamed from: c, reason: collision with root package name */
    public int f244c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppInstalledWorker appInstalledWorker, w6.c cVar) {
        super(cVar);
        this.f243b = appInstalledWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f242a = obj;
        this.f244c |= Integer.MIN_VALUE;
        return this.f243b.doWork(this);
    }
}
