package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes3.dex */
public interface VisibilityAnimatorProvider {
    @Nullable
    Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view);

    @Nullable
    Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view);
}
