package u7;

/* loaded from: classes3.dex */
public final class v extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public e5.e0 f13060a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13061b;

    /* renamed from: c, reason: collision with root package name */
    public int f13062c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e5.e0 f13063d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(e5.e0 e0Var, w6.c cVar) {
        super(cVar);
        this.f13063d = e0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13061b = obj;
        this.f13062c |= Integer.MIN_VALUE;
        return this.f13063d.emit(null, this);
    }
}
