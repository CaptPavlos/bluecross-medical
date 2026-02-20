package w1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f13369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f13370c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f13371d;

    public /* synthetic */ o(p pVar, long j10, String str, int i10) {
        this.f13368a = i10;
        this.f13369b = pVar;
        this.f13370c = j10;
        this.f13371d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13368a) {
            case 0:
                p pVar = this.f13369b;
                pVar.f13382o.f13577b.a(new o(pVar, this.f13370c, this.f13371d, 1));
                break;
            default:
                l lVar = this.f13369b.g;
                r rVar = lVar.f13360n;
                if (rVar == null || !rVar.e.get()) {
                    ((y1.d) lVar.f13355i.f13758b).e(this.f13370c, this.f13371d);
                    break;
                }
                break;
        }
    }
}
