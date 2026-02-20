package androidx.lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f571a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f572b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f571a = i10;
        this.f572b = obj;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f571a) {
            case 0:
                return CoroutineLiveData._init_$lambda$0((CoroutineLiveData) this.f572b);
            default:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) this.f572b);
        }
    }
}
