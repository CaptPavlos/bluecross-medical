package androidx.room;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import g7.p;
import r7.w;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.InvalidationTracker$syncBlocking$1", f = "InvalidationTracker.android.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class InvalidationTracker$syncBlocking$1 extends i implements p {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidationTracker$syncBlocking$1(InvalidationTracker invalidationTracker, w6.c cVar) {
        super(2, cVar);
        this.this$0 = invalidationTracker;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new InvalidationTracker$syncBlocking$1(this.this$0, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((InvalidationTracker$syncBlocking$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            s6.a.e(obj);
            InvalidationTracker invalidationTracker = this.this$0;
            this.label = 1;
            Object objSync$room_runtime_release = invalidationTracker.sync$room_runtime_release(this);
            x6.a aVar = x6.a.f13718a;
            if (objSync$room_runtime_release == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return s6.w.f12711a;
    }
}
