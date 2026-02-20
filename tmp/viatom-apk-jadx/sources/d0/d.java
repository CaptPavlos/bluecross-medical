package d0;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends AsyncTaskLoader {

    /* renamed from: a, reason: collision with root package name */
    public final Semaphore f6772a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f6773b;

    public d(Context context, Set set) {
        super(context);
        this.f6772a = new Semaphore(0);
        this.f6773b = set;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final Object loadInBackground() throws InterruptedException {
        Iterator it = this.f6773b.iterator();
        if (it.hasNext()) {
            ((g0.g) it.next()).getClass();
            u.p();
            return null;
        }
        try {
            this.f6772a.tryAcquire(0, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.f6772a.drainPermits();
        forceLoad();
    }
}
