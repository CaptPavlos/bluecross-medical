package androidx.lifecycle;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.Transformations;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f573a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f574b;

    public /* synthetic */ c(MediatorLiveData mediatorLiveData, int i10) {
        this.f573a = i10;
        this.f574b = mediatorLiveData;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f573a) {
            case 0:
                return CoroutineLiveDataKt.AnonymousClass2.invokeSuspend$lambda$0(this.f574b, obj);
            case 1:
                return Transformations.switchMap$lambda$3$lambda$2(this.f574b, obj);
            default:
                return Transformations.AnonymousClass2.onChanged$lambda$0(this.f574b, obj);
        }
    }
}
