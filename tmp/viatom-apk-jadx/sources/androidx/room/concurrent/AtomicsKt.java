package androidx.room.concurrent;

import androidx.annotation.RestrictTo;
import g7.l;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class AtomicsKt {
    public static final Void loop(AtomicInteger atomicInteger, l lVar) {
        atomicInteger.getClass();
        lVar.getClass();
        while (true) {
            lVar.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }
}
