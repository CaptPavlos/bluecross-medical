package q1;

import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements q2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12225a;

    public /* synthetic */ e(int i10) {
        this.f12225a = i10;
    }

    @Override // q2.b
    public final Object get() {
        switch (this.f12225a) {
            case 0:
                return Collections.EMPTY_SET;
            case 1:
                return null;
            case 2:
                return ExecutorsRegistrar.a();
            case 3:
                m mVar = ExecutorsRegistrar.f2420a;
                return new r1.f(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new r1.a("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f2423d.get());
            case 4:
                m mVar2 = ExecutorsRegistrar.f2420a;
                return new r1.f(Executors.newCachedThreadPool(new r1.a("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f2423d.get());
            default:
                m mVar3 = ExecutorsRegistrar.f2420a;
                return Executors.newSingleThreadScheduledExecutor(new r1.a("Firebase Scheduler", 0, null));
        }
    }
}
