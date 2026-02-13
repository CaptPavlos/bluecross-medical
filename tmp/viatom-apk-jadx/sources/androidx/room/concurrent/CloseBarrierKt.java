package androidx.room.concurrent;

import g7.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CloseBarrierKt {
    public static final void ifNotClosed(CloseBarrier closeBarrier, a aVar) {
        closeBarrier.getClass();
        aVar.getClass();
        if (closeBarrier.block$room_runtime_release()) {
            try {
                aVar.invoke();
            } finally {
                closeBarrier.unblock$room_runtime_release();
            }
        }
    }
}
