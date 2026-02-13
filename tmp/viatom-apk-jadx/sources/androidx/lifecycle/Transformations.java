package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import g7.l;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Transformations {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.lifecycle.Transformations$switchMap$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Observer {
        final /* synthetic */ MediatorLiveData $result;
        final /* synthetic */ Function $switchMapFunction;
        private LiveData liveData;

        public AnonymousClass2(Function function, MediatorLiveData mediatorLiveData) {
            this.$switchMapFunction = function;
            this.$result = mediatorLiveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w onChanged$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return w.f12711a;
        }

        public final LiveData getLiveData() {
            return this.liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            LiveData liveData = (LiveData) this.$switchMapFunction.apply(obj);
            LiveData liveData2 = this.liveData;
            if (liveData2 == liveData) {
                return;
            }
            if (liveData2 != null) {
                this.$result.removeSource(liveData2);
            }
            this.liveData = liveData;
            if (liveData != null) {
                MediatorLiveData mediatorLiveData = this.$result;
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 2)));
            }
        }

        public final void setLiveData(LiveData liveData) {
            this.liveData = liveData;
        }
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        liveData.getClass();
        u uVar = new u();
        uVar.f10135a = true;
        if (liveData.isInitialized()) {
            uVar.f10135a = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, uVar, 1)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w distinctUntilChanged$lambda$4(MediatorLiveData mediatorLiveData, u uVar, Object obj) {
        T value = mediatorLiveData.getValue();
        if (uVar.f10135a || ((value == 0 && obj != null) || (value != 0 && !value.equals(obj)))) {
            uVar.f10135a = false;
            mediatorLiveData.setValue(obj);
        }
        return w.f12711a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, l lVar) {
        liveData.getClass();
        lVar.getClass();
        MediatorLiveData mediatorLiveData = liveData.isInitialized() ? new MediatorLiveData(lVar.invoke(liveData.getValue())) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, lVar, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w map$lambda$0(MediatorLiveData mediatorLiveData, l lVar, Object obj) {
        mediatorLiveData.setValue(lVar.invoke(obj));
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w map$lambda$1(MediatorLiveData mediatorLiveData, Function function, Object obj) {
        mediatorLiveData.setValue(function.apply(obj));
        return w.f12711a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, l lVar) {
        LiveData liveData2;
        liveData.getClass();
        lVar.getClass();
        x xVar = new x();
        MediatorLiveData mediatorLiveData = (liveData.isInitialized() && (liveData2 = (LiveData) lVar.invoke(liveData.getValue())) != null && liveData2.isInitialized()) ? new MediatorLiveData(liveData2.getValue()) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new i(lVar, xVar, mediatorLiveData, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w switchMap$lambda$3(l lVar, x xVar, MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) lVar.invoke(obj);
        Object obj2 = xVar.f10138a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                mediatorLiveData.removeSource((LiveData) obj2);
            }
            xVar.f10138a = liveData;
            if (liveData != null) {
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 1)));
            }
        }
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w switchMap$lambda$3$lambda$2(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return w.f12711a;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        liveData.getClass();
        function.getClass();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, function, 2)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function function) {
        liveData.getClass();
        function.getClass();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
