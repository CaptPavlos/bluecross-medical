package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class KeyCycle extends KeyAttribute {
    private static final String TAG = "KeyCycle";
    private float mWaveOffset;
    private float mWavePeriod;
    private float mWavePhase;
    private Wave mWaveShape;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Wave {
        SIN,
        SQUARE,
        TRIANGLE,
        SAW,
        REVERSE_SAW,
        COS
    }

    public KeyCycle(int i10, String str) {
        super(i10, str);
        this.mWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = Float.NaN;
        this.mWavePhase = Float.NaN;
        this.TYPE = "KeyCycle";
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttribute
    public void attributesToString(StringBuilder sb) {
        super.attributesToString(sb);
        if (this.mWaveShape != null) {
            sb.append("shape:'");
            sb.append(this.mWaveShape);
            sb.append("',\n");
        }
        append(sb, TypedValues.CycleType.S_WAVE_PERIOD, this.mWavePeriod);
        append(sb, TypedValues.CycleType.S_WAVE_OFFSET, this.mWaveOffset);
        append(sb, TypedValues.CycleType.S_WAVE_PHASE, this.mWavePhase);
    }

    public float getOffset() {
        return this.mWaveOffset;
    }

    public float getPeriod() {
        return this.mWavePeriod;
    }

    public float getPhase() {
        return this.mWavePhase;
    }

    public Wave getShape() {
        return this.mWaveShape;
    }

    public void setOffset(float f) {
        this.mWaveOffset = f;
    }

    public void setPeriod(float f) {
        this.mWavePeriod = f;
    }

    public void setPhase(float f) {
        this.mWavePhase = f;
    }

    public void setShape(Wave wave) {
        this.mWaveShape = wave;
    }
}
