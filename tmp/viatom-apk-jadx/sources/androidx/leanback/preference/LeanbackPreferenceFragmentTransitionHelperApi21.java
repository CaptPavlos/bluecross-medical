package androidx.leanback.preference;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.transition.FadeAndShortSlide;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class LeanbackPreferenceFragmentTransitionHelperApi21 {
    private LeanbackPreferenceFragmentTransitionHelperApi21() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void addTransitions(Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }

    public static void addTransitions(androidx.fragment.app.Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }
}
