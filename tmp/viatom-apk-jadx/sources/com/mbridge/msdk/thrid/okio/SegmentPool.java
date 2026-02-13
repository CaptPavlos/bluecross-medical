package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    public static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            f.a();
            return;
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                long j10 = byteCount;
                if (j10 + 8192 > MAX_SIZE) {
                    return;
                }
                byteCount = j10 + 8192;
                segment.next = next;
                segment.limit = 0;
                segment.pos = 0;
                next = segment;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Segment take() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = next;
                if (segment == null) {
                    return new Segment();
                }
                next = segment.next;
                segment.next = null;
                byteCount -= 8192;
                return segment;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
