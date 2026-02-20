package androidx.lifecycle;

import android.annotation.SuppressLint;
import g7.p;
import r7.i0;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final w6.h coroutineContext;
    private CoroutineLiveData<T> target;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        final /* synthetic */ T $value;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LiveDataScopeImpl<T> liveDataScopeImpl, T t, w6.c cVar) {
            super(2, cVar);
            this.this$0 = liveDataScopeImpl;
            this.$value = t;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass2(this.this$0, this.$value, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
                this.label = 1;
                Object objClearSource$lifecycle_livedata_release = target$lifecycle_livedata_release.clearSource$lifecycle_livedata_release(this);
                x6.a aVar = x6.a.f13718a;
                if (objClearSource$lifecycle_livedata_release == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            this.this$0.getTarget$lifecycle_livedata_release().setValue(this.$value);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {92}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01092 extends y6.i implements p {
        final /* synthetic */ LiveData<T> $source;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01092(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, w6.c cVar) {
            super(2, cVar);
            this.this$0 = liveDataScopeImpl;
            this.$source = liveData;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new C01092(this.this$0, this.$source, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01092) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            LiveData<T> liveData = this.$source;
            this.label = 1;
            Object objEmitSource$lifecycle_livedata_release = target$lifecycle_livedata_release.emitSource$lifecycle_livedata_release(liveData, this);
            x6.a aVar = x6.a.f13718a;
            return objEmitSource$lifecycle_livedata_release == aVar ? aVar : objEmitSource$lifecycle_livedata_release;
        }
    }

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, w6.h hVar) {
        coroutineLiveData.getClass();
        hVar.getClass();
        this.target = coroutineLiveData;
        y7.e eVar = i0.f12407a;
        this.coroutineContext = hVar.plus(n.f13548a.f12716c);
    }

    @Override // androidx.lifecycle.LiveDataScope
    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t, w6.c cVar) throws Throwable {
        Object objZ = y.z(new AnonymousClass2(this, t, null), this.coroutineContext, cVar);
        return objZ == x6.a.f13718a ? objZ : s6.w.f12711a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, w6.c cVar) {
        return y.z(new C01092(this, liveData, null), this.coroutineContext, cVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_release(CoroutineLiveData<T> coroutineLiveData) {
        coroutineLiveData.getClass();
        this.target = coroutineLiveData;
    }
}
