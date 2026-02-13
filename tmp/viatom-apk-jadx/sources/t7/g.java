package t7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final m f12833a = new m(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f12834b = w7.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* renamed from: c, reason: collision with root package name */
    public static final int f12835c = w7.a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* renamed from: d, reason: collision with root package name */
    public static final e2.a f12836d = new e2.a("BUFFERED");
    public static final e2.a e = new e2.a("SHOULD_BUFFER");
    public static final e2.a f = new e2.a("S_RESUMING_BY_RCV");
    public static final e2.a g = new e2.a("RESUMING_BY_EB");
    public static final e2.a h = new e2.a("POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final e2.a f12837i = new e2.a("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final e2.a f12838j = new e2.a("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final e2.a f12839k = new e2.a("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final e2.a f12840l = new e2.a("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final e2.a f12841m = new e2.a("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final e2.a f12842n = new e2.a("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final e2.a f12843o = new e2.a("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final e2.a f12844p = new e2.a("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final e2.a f12845q = new e2.a("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final e2.a f12846r = new e2.a("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final e2.a f12847s = new e2.a("NO_CLOSE_CAUSE");

    public static final boolean a(r7.f fVar, Object obj, g7.q qVar) {
        e2.a aVarF = fVar.f(obj, qVar);
        if (aVarF == null) {
            return false;
        }
        fVar.r(aVarF);
        return true;
    }
}
