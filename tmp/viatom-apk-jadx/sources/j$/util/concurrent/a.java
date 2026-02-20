package j$.util.concurrent;

/* loaded from: classes2.dex */
public abstract class a extends p {

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f9370i;

    /* renamed from: j, reason: collision with root package name */
    public l f9371j;

    public a(l[] lVarArr, int i10, int i11, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i10, 0, i11);
        this.f9370i = concurrentHashMap;
        a();
    }

    public final boolean hasNext() {
        return this.f9390b != null;
    }

    public final boolean hasMoreElements() {
        return this.f9390b != null;
    }

    public final void remove() {
        l lVar = this.f9371j;
        if (lVar == null) {
            throw new IllegalStateException();
        }
        this.f9371j = null;
        this.f9370i.g(lVar.f9382b, null, null);
    }
}
