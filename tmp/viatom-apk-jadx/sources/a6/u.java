package a6;

import c1.w4;
import com.uptodown.workers.TrackingWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public h5.p f296a;

    /* renamed from: b, reason: collision with root package name */
    public w4 f297b;

    /* renamed from: c, reason: collision with root package name */
    public int f298c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f299d;
    public /* synthetic */ Object e;
    public final /* synthetic */ TrackingWorker f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TrackingWorker trackingWorker, y6.c cVar) {
        super(cVar);
        this.f = trackingWorker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.g(this);
    }
}
