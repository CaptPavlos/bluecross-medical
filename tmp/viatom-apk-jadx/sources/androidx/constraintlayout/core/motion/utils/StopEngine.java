package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface StopEngine {
    String debug(String str, float f);

    float getInterpolation(float f);

    float getVelocity();

    float getVelocity(float f);

    boolean isStopped();
}
