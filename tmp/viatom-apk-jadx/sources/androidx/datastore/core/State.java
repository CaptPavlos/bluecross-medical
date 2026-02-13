package androidx.datastore.core;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class State<T> {
    private final int version;

    private State(int i10) {
        this.version = i10;
    }

    public final int getVersion() {
        return this.version;
    }

    public /* synthetic */ State(int i10, g gVar) {
        this(i10);
    }
}
