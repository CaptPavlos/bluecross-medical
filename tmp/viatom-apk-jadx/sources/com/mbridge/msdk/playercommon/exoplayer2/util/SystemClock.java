package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SystemClock implements Clock {
    @Override // com.mbridge.msdk.playercommon.exoplayer2.util.Clock
    public final HandlerWrapper createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.util.Clock
    public final long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.util.Clock
    public final void sleep(long j10) {
        android.os.SystemClock.sleep(j10);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.util.Clock
    public final long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
