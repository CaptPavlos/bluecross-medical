package androidx.datastore.core;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ReadException<T> extends State<T> {
    private final Throwable readException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadException(Throwable th, int i10) {
        super(i10, null);
        th.getClass();
        this.readException = th;
    }

    public final Throwable getReadException() {
        return this.readException;
    }
}
