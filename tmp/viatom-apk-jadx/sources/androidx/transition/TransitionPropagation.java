package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(@NonNull TransitionValues transitionValues);

    @Nullable
    @SuppressLint({"NullableCollection"})
    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2);
}
