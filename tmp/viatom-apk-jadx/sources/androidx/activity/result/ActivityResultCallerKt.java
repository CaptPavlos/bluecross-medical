package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import g7.l;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<w> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i10, ActivityResultRegistry activityResultRegistry, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new a(0, lVar)), activityResultContract, i10);
    }

    public static final <I, O> ActivityResultLauncher<w> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i10, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new a(1, lVar)), activityResultContract, i10);
    }
}
