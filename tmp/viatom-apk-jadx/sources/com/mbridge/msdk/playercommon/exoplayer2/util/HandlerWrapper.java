package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int i10);

    Message obtainMessage(int i10, int i11, int i12);

    Message obtainMessage(int i10, int i11, int i12, Object obj);

    Message obtainMessage(int i10, Object obj);

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j10);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i10);

    boolean sendEmptyMessage(int i10);

    boolean sendEmptyMessageAtTime(int i10, long j10);
}
