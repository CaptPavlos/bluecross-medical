package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 4, byteBuffer);
        return this;
    }

    public int get(int i10) {
        return this.bb.getInt(__element(i10));
    }

    public long getAsUnsigned(int i10) {
        return get(i10) & 4294967295L;
    }
}
