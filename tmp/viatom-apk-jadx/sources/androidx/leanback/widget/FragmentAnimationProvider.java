package androidx.leanback.widget;

import android.animation.Animator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface FragmentAnimationProvider {
    void onImeAppearing(List<Animator> list);

    void onImeDisappearing(List<Animator> list);
}
