package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import g7.l;
import java.io.IOException;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final l produceNewData;

    public ReplaceFileCorruptionHandler(l lVar) {
        lVar.getClass();
        this.produceNewData = lVar;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, c cVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
