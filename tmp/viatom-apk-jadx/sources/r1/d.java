package r1;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12325a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f12326b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f12327c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f12328d;
    public final /* synthetic */ long e;
    public final /* synthetic */ TimeUnit f;

    public /* synthetic */ d(f fVar, Runnable runnable, long j10, long j11, TimeUnit timeUnit, int i10) {
        this.f12325a = i10;
        this.f12326b = fVar;
        this.f12327c = runnable;
        this.f12328d = j10;
        this.e = j11;
        this.f = timeUnit;
    }

    @Override // r1.g
    public final ScheduledFuture a(n5 n5Var) {
        switch (this.f12325a) {
            case 0:
                f fVar = this.f12326b;
                return fVar.f12334b.scheduleAtFixedRate(new e(fVar, this.f12327c, n5Var, 0), this.f12328d, this.e, this.f);
            default:
                f fVar2 = this.f12326b;
                return fVar2.f12334b.scheduleWithFixedDelay(new e(fVar2, this.f12327c, n5Var, 2), this.f12328d, this.e, this.f);
        }
    }
}
