package androidx.datastore.core;

import androidx.datastore.core.Message;
import g7.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import r7.l;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreImpl$writeActor$2 extends m implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    public DataStoreImpl$writeActor$2() {
        super(2);
    }

    public final void invoke(Message.Update<T> update, Throwable th) {
        update.getClass();
        l ack = update.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        r7.m mVar = (r7.m) ack;
        mVar.getClass();
        mVar.P(new r7.p(false, th));
    }

    @Override // g7.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return w.f12711a;
    }
}
