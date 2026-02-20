package androidx.lifecycle;

import androidx.annotation.MainThread;
import g7.p;
import r7.i0;
import r7.k0;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class EmittedSource implements k0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return EmittedSource.this.new AnonymousClass1(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            EmittedSource.this.removeSource();
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.EmittedSource$disposeNow$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        int label;

        public AnonymousClass2(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return EmittedSource.this.new AnonymousClass2(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            EmittedSource.this.removeSource();
            return s6.w.f12711a;
        }
    }

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        liveData.getClass();
        mediatorLiveData.getClass();
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // r7.k0
    public void dispose() {
        y7.e eVar = i0.f12407a;
        y.q(y.a(n.f13548a.f12716c), null, null, new AnonymousClass1(null), 3);
    }

    public final Object disposeNow(w6.c cVar) {
        y7.e eVar = i0.f12407a;
        Object objZ = y.z(new AnonymousClass2(null), n.f13548a.f12716c, cVar);
        return objZ == x6.a.f13718a ? objZ : s6.w.f12711a;
    }
}
