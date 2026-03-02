package androidx.room.support;

import android.os.SystemClock;
import androidx.room.support.AutoCloser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AutoCloser.Watch {
    @Override // androidx.room.support.AutoCloser.Watch
    public final long getMillis() {
        return SystemClock.uptimeMillis();
    }
}
