package androidx.datastore.core;

import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t, int i10, int i11) {
        super(i11, null);
        this.value = t;
        this.hashCode = i10;
    }

    public final void checkHashCode() {
        T t = this.value;
        if ((t != null ? t.hashCode() : 0) == this.hashCode) {
            return;
        }
        c.g("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }
}
