package androidx.collection;

import h7.a;
import java.util.Iterator;
import l1.b;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1<K> implements Iterator<K>, a {
    private int current = -1;
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = b.F(new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        int iIntValue = this.iterator.next().intValue();
        this.current = iIntValue;
        return (K) this.this$0.keys[iIntValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i10 = this.current;
        if (i10 >= 0) {
            this.this$0.removeValueAt(i10);
            this.current = -1;
        }
    }
}
