package androidx.core.util;

import android.annotation.SuppressLint;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    Predicate<T> and(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> negate();

    @SuppressLint({"MissingNullability"})
    Predicate<T> or(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    boolean test(T t);
}
