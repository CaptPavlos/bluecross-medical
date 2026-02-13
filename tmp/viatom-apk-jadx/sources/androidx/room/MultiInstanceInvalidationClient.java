package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import r7.w;
import r7.y;
import u7.b0;
import u7.h;
import u7.h0;
import u7.i;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private int clientId;
    private final w coroutineScope;
    private final b0 invalidatedTables;
    private final IMultiInstanceInvalidationCallback invalidationCallback;
    private IMultiInstanceInvalidationService invalidationService;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    private final MultiInstanceInvalidationClient$observer$1 observer;
    private final ServiceConnection serviceConnection;
    private final AtomicBoolean stopped;

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.room.MultiInstanceInvalidationClient$observer$1] */
    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker) {
        context.getClass();
        str.getClass();
        invalidationTracker.getClass();
        this.name = str;
        this.invalidationTracker = invalidationTracker;
        this.appContext = context.getApplicationContext();
        this.coroutineScope = invalidationTracker.getDatabase$room_runtime_release().getCoroutineScope();
        this.stopped = new AtomicBoolean(true);
        this.invalidatedTables = new h0(0);
        final String[] tableNames$room_runtime_release = invalidationTracker.getTableNames$room_runtime_release();
        this.observer = new InvalidationTracker.Observer(tableNames$room_runtime_release) { // from class: androidx.room.MultiInstanceInvalidationClient$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> set) {
                set.getClass();
                if (this.this$0.stopped.get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.this$0.invalidationService;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(this.this$0.clientId, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e) {
                    Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
                }
            }
        };
        this.invalidationCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] strArr) {
                strArr.getClass();
                y.q(this.this$0.coroutineScope, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(strArr, this.this$0, null), 3);
            }
        };
        this.serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                componentName.getClass();
                iBinder.getClass();
                this.this$0.invalidationService = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
                this.this$0.registerCallback();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                componentName.getClass();
                this.this$0.invalidationService = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerCallback() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
            if (iMultiInstanceInvalidationService != null) {
                this.clientId = iMultiInstanceInvalidationService.registerCallback(this.invalidationCallback, this.name);
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
        }
    }

    public final h createFlow(final String[] strArr) {
        strArr.getClass();
        final b0 b0Var = this.invalidatedTables;
        return new h() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
            /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ String[] $resolvedTableNames$inlined;
                final /* synthetic */ i $this_unsafeFlow;

                /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
                @e(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", l = {239}, m = "emit")
                /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends y6.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(w6.c cVar) {
                        super(cVar);
                    }

                    @Override // y6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, String[] strArr) {
                    this.$this_unsafeFlow = iVar;
                    this.$resolvedTableNames$inlined = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // u7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r10, w6.c r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r11
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.result
                        int r1 = r0.label
                        r2 = 1
                        if (r1 == 0) goto L2c
                        if (r1 != r2) goto L25
                        s6.a.e(r11)
                        goto L77
                    L25:
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.window.layout.c.g(r10)
                        r10 = 0
                        return r10
                    L2c:
                        s6.a.e(r11)
                        u7.i r11 = r9.$this_unsafeFlow
                        java.util.Set r10 = (java.util.Set) r10
                        u6.i r1 = new u6.i
                        r1.<init>()
                        java.lang.String[] r3 = r9.$resolvedTableNames$inlined
                        int r4 = r3.length
                        r5 = 0
                    L3c:
                        if (r5 >= r4) goto L5d
                        r6 = r3[r5]
                        java.util.Iterator r7 = r10.iterator()
                    L44:
                        boolean r8 = r7.hasNext()
                        if (r8 == 0) goto L5a
                        java.lang.Object r8 = r7.next()
                        java.lang.String r8 = (java.lang.String) r8
                        boolean r8 = o7.u.Z(r6, r8, r2)
                        if (r8 == 0) goto L44
                        r1.add(r6)
                        goto L44
                    L5a:
                        int r5 = r5 + 1
                        goto L3c
                    L5d:
                        u6.i r10 = l1.b.o(r1)
                        u6.f r1 = r10.f12969a
                        boolean r1 = r1.isEmpty()
                        if (r1 == 0) goto L6a
                        r10 = 0
                    L6a:
                        if (r10 == 0) goto L77
                        r0.label = r2
                        java.lang.Object r10 = r11.emit(r10, r0)
                        x6.a r11 = x6.a.f13718a
                        if (r10 != r11) goto L77
                        return r11
                    L77:
                        s6.w r10 = s6.w.f12711a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, w6.c):java.lang.Object");
                }
            }

            @Override // u7.h
            public Object collect(i iVar, w6.c cVar) {
                Object objCollect = b0Var.collect(new AnonymousClass2(iVar, strArr), cVar);
                return objCollect == x6.a.f13718a ? objCollect : s6.w.f12711a;
            }
        };
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final void start(Intent intent) {
        intent.getClass();
        if (this.stopped.compareAndSet(true, false)) {
            this.appContext.bindService(intent, this.serviceConnection, 1);
            this.invalidationTracker.addRemoteObserver$room_runtime_release(this.observer);
        }
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(this.observer);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.invalidationCallback, this.clientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
