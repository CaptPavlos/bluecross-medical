package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import s6.w;
import u7.i;
import u7.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity activity, View view, w6.c cVar) {
        Object objCollect = i0.d(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new i() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            @Override // u7.i
            public final Object emit(Rect rect, w6.c cVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return w.f12711a;
            }
        }, cVar);
        return objCollect == x6.a.f13718a ? objCollect : w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
