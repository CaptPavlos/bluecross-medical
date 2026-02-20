package androidx.room;

import androidx.room.CoroutinesRoom;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.CoroutinesRoom$Companion", f = "CoroutinesRoom.android.kt", l = {48, 49}, m = "execute")
/* loaded from: classes.dex */
public final class CoroutinesRoom$Companion$execute$1<R> extends y6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutinesRoom.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$1(CoroutinesRoom.Companion companion, w6.c cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, false, null, this);
    }
}
