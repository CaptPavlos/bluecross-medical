package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i10, int i11, ByteBuffer byteBuffer) {
        __reset(i10, i11, byteBuffer);
        return this;
    }

    public Table get(Table table, int i10) {
        return Table.__union(table, __element(i10), this.bb);
    }
}
