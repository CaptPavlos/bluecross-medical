package androidx.transition;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.sqrt(Math.abs(f) * 2.0f) * Math.signum(f));
    }

    public void addDataPoint(long j10, float f) {
        int i10 = (this.mIndex + 1) % 20;
        this.mIndex = i10;
        this.mTimeSamples[i10] = j10;
        this.mDataSamples[i10] = f;
    }

    public float calculateVelocity() {
        int i10 = this.mIndex;
        if (i10 == 0 && this.mTimeSamples[i10] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j10 = this.mTimeSamples[i10];
        int i11 = 0;
        long j11 = j10;
        while (true) {
            long j12 = this.mTimeSamples[i10];
            if (j12 == Long.MIN_VALUE) {
                break;
            }
            float f = j10 - j12;
            float fAbs = Math.abs(j12 - j11);
            if (f > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i10 == 0) {
                i10 = 20;
            }
            i10--;
            i11++;
            if (i11 >= 20) {
                break;
            }
            j11 = j12;
        }
        if (i11 < 2) {
            return 0.0f;
        }
        int i12 = this.mIndex;
        if (i11 == 2) {
            int i13 = i12 == 0 ? 19 : i12 - 1;
            long[] jArr = this.mTimeSamples;
            float f10 = jArr[i12] - jArr[i13];
            if (f10 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            return ((fArr[i12] - fArr[i13]) / f10) * 1000.0f;
        }
        int i14 = ((i12 - i11) + 21) % 20;
        int i15 = (i12 + 21) % 20;
        long j13 = this.mTimeSamples[i14];
        float f11 = this.mDataSamples[i14];
        int i16 = i14 + 1;
        float f12 = 0.0f;
        for (int i17 = i16 % 20; i17 != i15; i17 = (i17 + 1) % 20) {
            long j14 = this.mTimeSamples[i17];
            float f13 = j14 - j13;
            if (f13 != 0.0f) {
                float f14 = this.mDataSamples[i17];
                float f15 = (f14 - f11) / f13;
                float fAbs2 = (Math.abs(f15) * (f15 - kineticEnergyToVelocity(f12))) + f12;
                if (i17 == i16) {
                    fAbs2 *= 0.5f;
                }
                f12 = fAbs2;
                f11 = f14;
                j13 = j14;
            }
        }
        return kineticEnergyToVelocity(f12) * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
