package androidx.lifecycle;

import androidx.arch.core.util.Function;
import g7.l;
import kotlin.jvm.internal.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f588a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f589b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f590c;

    public /* synthetic */ j(MediatorLiveData mediatorLiveData, Object obj, int i10) {
        this.f588a = i10;
        this.f589b = mediatorLiveData;
        this.f590c = obj;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f588a) {
            case 0:
                return Transformations.map$lambda$0(this.f589b, (l) this.f590c, obj);
            case 1:
                return Transformations.distinctUntilChanged$lambda$4(this.f589b, (u) this.f590c, obj);
            default:
                return Transformations.map$lambda$1(this.f589b, (Function) this.f590c, obj);
        }
    }
}
