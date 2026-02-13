package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@CheckReturnValue
/* loaded from: classes.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: androidx.datastore.preferences.protobuf.BufferAllocator.1
        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i10) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i10));
        }

        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int i10) {
            return AllocatedBuffer.wrap(new byte[i10]);
        }
    };

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i10);

    public abstract AllocatedBuffer allocateHeapBuffer(int i10);
}
