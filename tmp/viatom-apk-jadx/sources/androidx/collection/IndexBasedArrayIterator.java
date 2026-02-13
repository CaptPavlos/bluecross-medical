package androidx.collection;

import androidx.window.layout.c;
import h7.a;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, a {
    private boolean canRemove;
    private int index;
    private int size;

    public IndexBasedArrayIterator(int i10) {
        this.size = i10;
    }

    public abstract T elementAt(int i10);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        T tElementAt = elementAt(this.index);
        this.index++;
        this.canRemove = true;
        return tElementAt;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            c.g("Call next() before removing an element.");
            return;
        }
        int i10 = this.index - 1;
        this.index = i10;
        removeAt(i10);
        this.size--;
        this.canRemove = false;
    }

    public abstract void removeAt(int i10);
}
