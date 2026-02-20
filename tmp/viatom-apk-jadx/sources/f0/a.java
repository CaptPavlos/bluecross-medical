package f0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.work.WorkRequest;
import i0.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7988a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f7989b = new LinkedBlockingQueue();

    public final IBinder a() throws TimeoutException {
        y.f("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f7988a) {
            androidx.window.layout.c.g("Cannot call get on this connection more than once");
            return null;
        }
        this.f7988a = true;
        IBinder iBinder = (IBinder) this.f7989b.poll(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7989b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
