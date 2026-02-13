package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public interface BaseOnSliderTouchListener<S> {
    void onStartTrackingTouch(@NonNull S s9);

    void onStopTrackingTouch(@NonNull S s9);
}
