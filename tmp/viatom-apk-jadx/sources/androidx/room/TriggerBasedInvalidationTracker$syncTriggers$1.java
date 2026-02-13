package androidx.room;

import com.google.android.material.card.MaterialCardViewHelper;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION}, m = "syncTriggers$room_runtime_release")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$1 extends y6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, w6.c cVar) {
        super(cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.syncTriggers$room_runtime_release(this);
    }
}
