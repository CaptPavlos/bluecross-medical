package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import g7.p;
import j$.time.Duration;
import r7.i0;
import r7.y;
import s6.w;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, w6.c cVar) {
            super(2, cVar);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w invokeSuspend$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return w.f12711a;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, cVar);
        }

        @Override // g7.p
        public final Object invoke(r7.w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 0)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, w6.c cVar) {
        y7.e eVar = i0.f12407a;
        return y.z(new AnonymousClass2(mediatorLiveData, liveData, null), n.f13548a.f12716c, cVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, w6.h hVar, p pVar) {
        duration.getClass();
        hVar.getClass();
        pVar.getClass();
        return new CoroutineLiveData(hVar, Api26Impl.INSTANCE.toMillis(duration), pVar);
    }

    public static /* synthetic */ LiveData liveData$default(w6.h hVar, long j10, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = w6.i.f13523a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return liveData(hVar, j10, pVar);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, w6.h hVar, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = w6.i.f13523a;
        }
        return liveData(duration, hVar, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, p pVar) {
        duration.getClass();
        pVar.getClass();
        return liveData$default(duration, (w6.h) null, pVar, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(w6.h hVar, p pVar) {
        hVar.getClass();
        pVar.getClass();
        return liveData$default(hVar, 0L, pVar, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(w6.h hVar, long j10, p pVar) {
        hVar.getClass();
        pVar.getClass();
        return new CoroutineLiveData(hVar, j10, pVar);
    }

    public static final <T> LiveData<T> liveData(p pVar) {
        pVar.getClass();
        return liveData$default((w6.h) null, 0L, pVar, 3, (Object) null);
    }
}
