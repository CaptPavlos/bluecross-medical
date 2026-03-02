package androidx.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import androidx.annotation.MainThread;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder floatValueHolder, float f) {
        super(floatValueHolder);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(f);
    }

    private void sanityCheck() {
        SpringForce springForce = this.mSpring;
        if (springForce == null) {
            a2.a.m("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
            return;
        }
        double finalPosition = springForce.getFinalPosition();
        if (finalPosition > this.mMaxValue) {
            a2.a.m("Final position of the spring cannot be greater than the max value.");
        } else {
            if (finalPosition >= this.mMinValue) {
                return;
            }
            a2.a.m("Final position of the spring cannot be less than the min value.");
        }
    }

    public void animateToFinalPosition(float f) {
        if (isRunning()) {
            this.mPendingPosition = f;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f);
        }
        this.mSpring.setFinalPosition(f);
        start();
    }

    public boolean canSkipToEnd() {
        return this.mSpring.mDampingRatio > 0.0d;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    @MainThread
    public void cancel() {
        super.cancel();
        float f = this.mPendingPosition;
        if (f != Float.MAX_VALUE) {
            SpringForce springForce = this.mSpring;
            if (springForce == null) {
                this.mSpring = new SpringForce(f);
            } else {
                springForce.setFinalPosition(f);
            }
            this.mPendingPosition = Float.MAX_VALUE;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f, float f10) {
        return this.mSpring.getAcceleration(f, f10);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f, float f10) {
        return this.mSpring.isAtEquilibrium(f, f10);
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            a2.a.m("Spring animations can only come to an end when there is damping");
        } else {
            if (!getAnimationHandler().isCurrentThread()) {
                throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
            }
            if (this.mRunning) {
                this.mEndRequested = true;
            }
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    @MainThread
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold(getValueThreshold());
        super.start();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j10) {
        boolean z9 = this.mEndRequested;
        float f = this.mPendingPosition;
        if (z9) {
            if (f != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(f);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        SpringForce springForce = this.mSpring;
        if (f != Float.MAX_VALUE) {
            long j11 = j10 / 2;
            DynamicAnimation.MassState massStateUpdateValues = springForce.updateValues(this.mValue, this.mVelocity, j11);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            DynamicAnimation.MassState massStateUpdateValues2 = this.mSpring.updateValues(massStateUpdateValues.mValue, massStateUpdateValues.mVelocity, j11);
            this.mValue = massStateUpdateValues2.mValue;
            this.mVelocity = massStateUpdateValues2.mVelocity;
        } else {
            DynamicAnimation.MassState massStateUpdateValues3 = springForce.updateValues(this.mValue, this.mVelocity, j10);
            this.mValue = massStateUpdateValues3.mValue;
            this.mVelocity = massStateUpdateValues3.mVelocity;
        }
        float fMax = Math.max(this.mValue, this.mMinValue);
        this.mValue = fMax;
        float fMin = Math.min(fMax, this.mMaxValue);
        this.mValue = fMin;
        if (!isAtEquilibrium(fMin, this.mVelocity)) {
            return false;
        }
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f) {
    }

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f) {
        super(k10, floatPropertyCompat);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(f);
    }
}
