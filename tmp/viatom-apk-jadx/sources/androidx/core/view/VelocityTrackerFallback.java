package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j10;
        int i10;
        int i11 = this.mDataPointsBufferSize;
        if (i11 < 2) {
            return 0.0f;
        }
        int i12 = this.mDataPointsBufferLastUsedIndex;
        int i13 = ((i12 + 20) - (i11 - 1)) % 20;
        long j11 = this.mEventTimes[i12];
        while (true) {
            jArr = this.mEventTimes;
            j10 = jArr[i13];
            long j12 = j11 - j10;
            i10 = this.mDataPointsBufferSize;
            if (j12 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize = i10 - 1;
            i13 = (i13 + 1) % 20;
        }
        if (i10 < 2) {
            return 0.0f;
        }
        if (i10 == 2) {
            int i14 = (i13 + 1) % 20;
            if (j10 == jArr[i14]) {
                return 0.0f;
            }
            return this.mMovements[i14] / (r2 - j10);
        }
        float f = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < this.mDataPointsBufferSize - 1; i16++) {
            int i17 = i16 + i13;
            long[] jArr2 = this.mEventTimes;
            long j13 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j13) {
                i15++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f10 = this.mMovements[i18] / (this.mEventTimes[i18] - j13);
                float fAbs = (Math.abs(f10) * (f10 - fKineticEnergyToVelocity)) + f;
                if (i15 == 1) {
                    fAbs *= 0.5f;
                }
                f = fAbs;
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i10 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i10;
        int i11 = this.mDataPointsBufferSize;
        if (i11 != 20) {
            this.mDataPointsBufferSize = i11 + 1;
        }
        this.mMovements[i10] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i10, float f) {
        float currentVelocity = getCurrentVelocity() * i10;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }

    public float getAxisVelocity(int i10) {
        if (i10 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i10) {
        computeCurrentVelocity(i10, Float.MAX_VALUE);
    }
}
