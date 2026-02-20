package a6;

import com.uptodown.workers.TrackingWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f290a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TrackingWorker f291b;

    /* renamed from: c, reason: collision with root package name */
    public int f292c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TrackingWorker trackingWorker, w6.c cVar) {
        super(cVar);
        this.f291b = trackingWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f290a = obj;
        this.f292c |= Integer.MIN_VALUE;
        return this.f291b.doWork(this);
    }
}
