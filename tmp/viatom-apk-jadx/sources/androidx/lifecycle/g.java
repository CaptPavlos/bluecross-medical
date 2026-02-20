package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import t7.s;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f580a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f581b;

    public /* synthetic */ g(Object obj, int i10) {
        this.f580a = i10;
        this.f581b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f580a) {
            case 0:
                LifecycleKt$eventFlow$1.invokeSuspend$lambda$0((s) this.f581b, lifecycleOwner, event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((m0) this.f581b, lifecycleOwner, event);
                break;
        }
    }
}
