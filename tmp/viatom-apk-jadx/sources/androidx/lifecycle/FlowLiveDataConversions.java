package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.room.RoomLambdaTrackingLiveData;
import com.google.android.gms.internal.measurement.u6;
import g7.p;
import j$.time.Duration;
import r7.i0;
import r7.l1;
import r7.w;
import r7.y;
import t7.r;
import t7.s;
import u7.k0;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {105, 106, 108}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @y6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00091 extends y6.i implements p {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00091(LiveData<T> liveData, Observer<T> observer, w6.c cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // y6.a
            public final w6.c create(Object obj, w6.c cVar) {
                return new C00091(this.$this_asFlow, this.$observer, cVar);
            }

            @Override // g7.p
            public final Object invoke(w wVar, w6.c cVar) {
                return ((C00091) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            }

            @Override // y6.a
            public final Object invokeSuspend(Object obj) {
                if (this.label != 0) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return s6.w.f12711a;
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @y6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends y6.i implements p {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer, w6.c cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // y6.a
            public final w6.c create(Object obj, w6.c cVar) {
                return new AnonymousClass2(this.$this_asFlow, this.$observer, cVar);
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
                this.$this_asFlow.removeObserver(this.$observer);
                return s6.w.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, w6.c cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(s sVar, Object obj) {
            ((r) sVar).q(obj);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(s sVar, w6.c cVar) {
            return ((AnonymousClass1) create(sVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.Observer, int] */
        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Observer observer;
            ?? r02 = this.label;
            x6.a aVar = x6.a.f13718a;
            try {
            } catch (Throwable th) {
                y7.e eVar = i0.f12407a;
                w6.h hVarPlus = n.f13548a.f12716c.plus(l1.f12412a);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, r02, null);
                this.L$0 = th;
                this.label = 3;
                if (y.z(anonymousClass2, hVarPlus, this) != aVar) {
                    throw th;
                }
            }
            if (r02 == 0) {
                s6.a.e(obj);
                final s sVar = (s) this.L$0;
                observer = new Observer() { // from class: androidx.lifecycle.e
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        FlowLiveDataConversions.AnonymousClass1.invokeSuspend$lambda$0(sVar, obj2);
                    }
                };
                y7.e eVar2 = i0.f12407a;
                s7.c cVar = n.f13548a.f12716c;
                C00091 c00091 = new C00091(this.$this_asFlow, observer, null);
                this.L$0 = observer;
                this.label = 1;
                if (y.z(c00091, cVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (r02 != 1) {
                    if (r02 == 2) {
                        s6.a.e(obj);
                        throw new u6();
                    }
                    if (r02 != 3) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th2 = (Throwable) this.L$0;
                    s6.a.e(obj);
                    throw th2;
                }
                observer = (Observer) this.L$0;
                s6.a.e(obj);
            }
            this.L$0 = observer;
            this.label = 2;
            y.e(this);
            return aVar;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01061 extends y6.i implements p {
        final /* synthetic */ u7.h $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01061(u7.h hVar, w6.c cVar) {
            super(2, cVar);
            this.$this_asLiveData = hVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            C01061 c01061 = new C01061(this.$this_asLiveData, cVar);
            c01061.L$0 = obj;
            return c01061;
        }

        @Override // g7.p
        public final Object invoke(LiveDataScope<T> liveDataScope, w6.c cVar) {
            return ((C01061) create(liveDataScope, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                u7.h hVar = this.$this_asLiveData;
                u7.i iVar = new u7.i() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // u7.i
                    public final Object emit(T t, w6.c cVar) {
                        Object objEmit = liveDataScope.emit(t, cVar);
                        return objEmit == x6.a.f13718a ? objEmit : s6.w.f12711a;
                    }
                };
                this.label = 1;
                Object objCollect = hVar.collect(iVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objCollect == aVar) {
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

    public static final <T> u7.h asFlow(LiveData<T> liveData) {
        liveData.getClass();
        return u7.i0.f(u7.i0.d(new AnonymousClass1(liveData, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(u7.h hVar, w6.h hVar2, long j10) {
        hVar.getClass();
        hVar2.getClass();
        RoomLambdaTrackingLiveData roomLambdaTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(hVar2, j10, new C01061(hVar, null));
        if (hVar instanceof k0) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomLambdaTrackingLiveData.setValue(((k0) hVar).getValue());
                return roomLambdaTrackingLiveData;
            }
            roomLambdaTrackingLiveData.postValue(((k0) hVar).getValue());
        }
        return roomLambdaTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(u7.h hVar, w6.h hVar2, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar2 = w6.i.f13523a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return asLiveData(hVar, hVar2, j10);
    }

    public static /* synthetic */ LiveData asLiveData$default(u7.h hVar, Duration duration, w6.h hVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar2 = w6.i.f13523a;
        }
        return asLiveData(hVar, duration, hVar2);
    }

    public static final <T> LiveData<T> asLiveData(u7.h hVar, w6.h hVar2) {
        hVar.getClass();
        hVar2.getClass();
        return asLiveData$default(hVar, hVar2, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(u7.h hVar) {
        hVar.getClass();
        return asLiveData$default(hVar, (w6.h) null, 0L, 3, (Object) null);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(u7.h hVar, Duration duration, w6.h hVar2) {
        hVar.getClass();
        duration.getClass();
        hVar2.getClass();
        return asLiveData(hVar, hVar2, Api26Impl.INSTANCE.toMillis(duration));
    }
}
