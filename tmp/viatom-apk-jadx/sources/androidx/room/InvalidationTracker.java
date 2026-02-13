package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import g7.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import n7.k;
import r7.w;
import t6.a0;
import t6.u;
import u7.h;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class InvalidationTracker {
    public static final Companion Companion = new Companion(null);
    private AutoCloser autoCloser;
    private final RoomDatabase database;
    private final TriggerBasedInvalidationTracker implementation;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private Intent multiInstanceInvalidationIntent;
    private final Map<Observer, ObserverWrapper> observerMap;
    private final ReentrantLock observerMapLock;
    private final g7.a onRefreshCompleted;
    private final g7.a onRefreshScheduled;
    private final Map<String, String> shadowTablesMap;
    private final String[] tableNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class MultiInstanceClientInitState {
        private final Context context;
        private final String name;
        private final Intent serviceIntent;

        public MultiInstanceClientInitState(Context context, String str, Intent intent) {
            context.getClass();
            str.getClass();
            intent.getClass();
            this.context = context;
            this.name = str;
            this.serviceIntent = intent;
        }

        public static /* synthetic */ MultiInstanceClientInitState copy$default(MultiInstanceClientInitState multiInstanceClientInitState, Context context, String str, Intent intent, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                context = multiInstanceClientInitState.context;
            }
            if ((i10 & 2) != 0) {
                str = multiInstanceClientInitState.name;
            }
            if ((i10 & 4) != 0) {
                intent = multiInstanceClientInitState.serviceIntent;
            }
            return multiInstanceClientInitState.copy(context, str, intent);
        }

        public final Context component1() {
            return this.context;
        }

        public final String component2() {
            return this.name;
        }

        public final Intent component3() {
            return this.serviceIntent;
        }

        public final MultiInstanceClientInitState copy(Context context, String str, Intent intent) {
            context.getClass();
            str.getClass();
            intent.getClass();
            return new MultiInstanceClientInitState(context, str, intent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) obj;
            return l.a(this.context, multiInstanceClientInitState.context) && l.a(this.name, multiInstanceClientInitState.name) && l.a(this.serviceIntent, multiInstanceClientInitState.serviceIntent);
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getName() {
            return this.name;
        }

        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public int hashCode() {
            return this.serviceIntent.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(this.context.hashCode() * 31, 31, this.name);
        }

        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.context + ", name=" + this.name + ", serviceIntent=" + this.serviceIntent + ')';
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.InvalidationTracker$addObserver$1", f = "InvalidationTracker.android.kt", l = {253}, m = "invokeSuspend")
    /* renamed from: androidx.room.InvalidationTracker$addObserver$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return InvalidationTracker.this.new AnonymousClass1(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = InvalidationTracker.this.implementation;
                this.label = 1;
                Object objSyncTriggers$room_runtime_release = triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this);
                x6.a aVar = x6.a.f13718a;
                if (objSyncTriggers$room_runtime_release == aVar) {
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

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.InvalidationTracker$refreshVersionsSync$1", f = "InvalidationTracker.android.kt", l = {345}, m = "invokeSuspend")
    /* renamed from: androidx.room.InvalidationTracker$refreshVersionsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01101 extends i implements p {
        int label;

        public C01101(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return InvalidationTracker.this.new C01101(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01101) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                g7.a aVar = InvalidationTracker.this.onRefreshScheduled;
                g7.a aVar2 = InvalidationTracker.this.onRefreshCompleted;
                this.label = 1;
                Object objRefreshInvalidation$room_runtime_release = InvalidationTracker.this.implementation.refreshInvalidation$room_runtime_release(new String[0], aVar, aVar2, this);
                x6.a aVar3 = x6.a.f13718a;
                if (objRefreshInvalidation$room_runtime_release == aVar3) {
                    return aVar3;
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

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.InvalidationTracker$removeObserver$1", f = "InvalidationTracker.android.kt", l = {310}, m = "invokeSuspend")
    /* renamed from: androidx.room.InvalidationTracker$removeObserver$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01111 extends i implements p {
        int label;

        public C01111(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return InvalidationTracker.this.new C01111(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01111) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = InvalidationTracker.this.implementation;
                this.label = 1;
                Object objSyncTriggers$room_runtime_release = triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this);
                x6.a aVar = x6.a.f13718a;
                if (objSyncTriggers$room_runtime_release == aVar) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        roomDatabase.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.tableNames = strArr;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(roomDatabase, map, map2, strArr, roomDatabase.getUseTempTrackingTable$room_runtime_release(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        final int i10 = 0;
        this.onRefreshScheduled = new g7.a(this) { // from class: androidx.room.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f614b;

            {
                this.f614b = this;
            }

            @Override // g7.a
            public final Object invoke() {
                switch (i10) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(this.f614b);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(this.f614b);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(this.f614b));
                }
            }
        };
        final int i11 = 1;
        this.onRefreshCompleted = new g7.a(this) { // from class: androidx.room.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f614b;

            {
                this.f614b = this;
            }

            @Override // g7.a
            public final Object invoke() {
                switch (i11) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(this.f614b);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(this.f614b);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(this.f614b));
                }
            }
        };
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        this.trackerLock = new Object();
        final int i12 = 2;
        triggerBasedInvalidationTracker.setOnAllowRefresh$room_runtime_release(new g7.a(this) { // from class: androidx.room.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f614b;

            {
                this.f614b = this;
            }

            @Override // g7.a
            public final Object invoke() {
                switch (i12) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(this.f614b);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(this.f614b);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(this.f614b));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.database.inCompatibilityMode$room_runtime_release() || invalidationTracker.database.isOpenInternal();
    }

    private final boolean addObserverOnly(Observer observer) {
        s6.i iVarValidateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(observer.getTables$room_runtime_release());
        String[] strArr = (String[]) iVarValidateTableNames$room_runtime_release.f12693a;
        int[] iArr = (int[]) iVarValidateTableNames$room_runtime_release.f12694b;
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr);
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            boolean zContainsKey = this.observerMap.containsKey(observer);
            Map<Observer, ObserverWrapper> map = this.observerMap;
            ObserverWrapper observerWrapperPut = zContainsKey ? (ObserverWrapper) a0.f0(map, observer) : map.put(observer, observerWrapper);
            reentrantLock.unlock();
            return observerWrapperPut == null && this.implementation.onObserverAdded$room_runtime_release(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ h createFlow$default(InvalidationTracker invalidationTracker, String[] strArr, boolean z9, int i10, Object obj) {
        if (obj != null) {
            a2.a.m("Super calls with default arguments not supported in this target, function: createFlow");
            return null;
        }
        if ((i10 & 2) != 0) {
            z9 = true;
        }
        return invalidationTracker.createFlow(strArr, z9);
    }

    private final List<Observer> getAllObservers() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return t6.l.r0(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInvalidatedObservers(Set<Integer> set) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List listR0 = t6.l.r0(this.observerMap.values());
            reentrantLock.unlock();
            Iterator it = listR0.iterator();
            while (it.hasNext()) {
                ((ObserverWrapper) it.next()).notifyByTableIds$room_runtime_release(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    List<Observer> allObservers = getAllObservers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : allObservers) {
                        if (!((Observer) obj).isRemote$room_runtime_release()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.stop();
                    }
                }
                this.implementation.resetSync$room_runtime_release();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s6.w onRefreshCompleted$lambda$1(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.decrementCountAndScheduleClose();
        }
        return s6.w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s6.w onRefreshScheduled$lambda$0(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        return s6.w.f12711a;
    }

    private final boolean removeObserverOnly(Observer observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper observerWrapperRemove = this.observerMap.remove(observer);
            return observerWrapperRemove != null && this.implementation.onObserverRemoved$room_runtime_release(observerWrapperRemove.getTableIds$room_runtime_release());
        } finally {
            reentrantLock.unlock();
        }
    }

    @WorkerThread
    public void addObserver(Observer observer) {
        observer.getClass();
        if (addObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new AnonymousClass1(null));
        }
    }

    public final void addRemoteObserver$room_runtime_release(Observer observer) {
        observer.getClass();
        if (observer.isRemote$room_runtime_release()) {
            addObserverOnly(observer);
        } else {
            androidx.window.layout.c.g("isRemote was false of observer argument");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void addWeakObserver(Observer observer) {
        observer.getClass();
        addObserver(new WeakObserver(this, observer));
    }

    public final h createFlow(String[] strArr, boolean z9) {
        strArr.getClass();
        s6.i iVarValidateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(strArr);
        String[] strArr2 = (String[]) iVarValidateTableNames$room_runtime_release.f12693a;
        h hVarCreateFlow$room_runtime_release = this.implementation.createFlow$room_runtime_release(strArr2, (int[]) iVarValidateTableNames$room_runtime_release.f12694b, z9);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        h hVarCreateFlow = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.createFlow(strArr2) : null;
        if (hVarCreateFlow == null) {
            return hVarCreateFlow$room_runtime_release;
        }
        h[] hVarArr = {hVarCreateFlow$room_runtime_release, hVarCreateFlow};
        int i10 = u7.w.f13064a;
        return new u7.d(new k(hVarArr, 1), w6.i.f13523a, -2, t7.a.f12813a, 2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z9, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z9, callable);
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final String[] getTableNames$room_runtime_release() {
        return this.tableNames;
    }

    public final void initMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        context.getClass();
        str.getClass();
        intent.getClass();
        this.multiInstanceInvalidationIntent = intent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, this);
    }

    public final void internalInit$room_runtime_release(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        this.implementation.configureConnection(sQLiteConnection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.start(intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void notifyObserversByTableNames$room_runtime_release(Set<String> set) {
        set.getClass();
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> listR0 = t6.l.r0(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : listR0) {
                if (!observerWrapper.getObserver$room_runtime_release().isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(set);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object refresh(String[] strArr, w6.c cVar) {
        return this.implementation.refreshInvalidation$room_runtime_release(strArr, this.onRefreshScheduled, this.onRefreshCompleted, cVar);
    }

    public final void refreshAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void refreshVersionsAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new C01101(null));
    }

    @WorkerThread
    public void removeObserver(Observer observer) {
        observer.getClass();
        if (removeObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new C01111(null));
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        autoCloser.getClass();
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void stop$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
    }

    public final Object sync$room_runtime_release(w6.c cVar) {
        Object objSyncTriggers$room_runtime_release;
        boolean zInCompatibilityMode$room_runtime_release = this.database.inCompatibilityMode$room_runtime_release();
        s6.w wVar = s6.w.f12711a;
        return ((!zInCompatibilityMode$room_runtime_release || this.database.isOpenInternal()) && (objSyncTriggers$room_runtime_release = this.implementation.syncTriggers$room_runtime_release(cVar)) == x6.a.f13718a) ? objSyncTriggers$room_runtime_release : wVar;
    }

    @WorkerThread
    public final void syncBlocking$room_runtime_release() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$syncBlocking$1(this, null));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        return createLiveData(strArr, false, (Callable) callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> LiveData<T> createLiveData(String[] strArr, boolean z9, g7.l lVar) {
        strArr.getClass();
        lVar.getClass();
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z9, lVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String str, String... strArr) {
            str.getClass();
            strArr.getClass();
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(str);
            if (strArr.length > 0) {
                arrayList.ensureCapacity(arrayList.size() + strArr.length);
                Collections.addAll(arrayList, strArr);
            }
            this((String[]) arrayList.toArray(new String[arrayList.size()]));
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        public Observer(String[] strArr) {
            strArr.getClass();
            this.tables = strArr;
        }
    }

    public final h createFlow(String... strArr) {
        strArr.getClass();
        return createFlow$default(this, strArr, false, 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        roomDatabase.getClass();
        strArr.getClass();
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        u uVar = u.f12809a;
        this(roomDatabase, uVar, uVar, strArr2);
    }
}
