package androidx.room;

import g7.p;
import java.util.concurrent.Callable;
import r7.f;
import r7.w;
import s6.j;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CoroutinesRoom$Companion$execute$4$job$1 extends i implements p {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ f $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, f fVar, w6.c cVar) {
        super(2, cVar);
        this.$callable = callable;
        this.$continuation = fVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        try {
            this.$continuation.resumeWith(this.$callable.call());
        } catch (Throwable th) {
            this.$continuation.resumeWith(new j(th));
        }
        return s6.w.f12711a;
    }
}
