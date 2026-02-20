package androidx.core.util;

import android.annotation.SuppressLint;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(i iVar) {
        return new android.util.Pair<>(iVar.f12693a, iVar.f12694b);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(i iVar) {
        return new Pair<>(iVar.f12693a, iVar.f12694b);
    }

    public static final <F, S> i toKotlinPair(Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> i toKotlinPair(android.util.Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }
}
