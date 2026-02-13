package androidx.leanback.graphics;

import android.graphics.Rect;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class BoundsRule {
    public ValueRule bottom;
    public ValueRule left;
    public ValueRule right;
    public ValueRule top;

    public BoundsRule(BoundsRule boundsRule) {
        ValueRule valueRule = boundsRule.left;
        this.left = valueRule != null ? new ValueRule(valueRule) : null;
        ValueRule valueRule2 = boundsRule.right;
        this.right = valueRule2 != null ? new ValueRule(valueRule2) : null;
        ValueRule valueRule3 = boundsRule.top;
        this.top = valueRule3 != null ? new ValueRule(valueRule3) : null;
        ValueRule valueRule4 = boundsRule.bottom;
        this.bottom = valueRule4 != null ? new ValueRule(valueRule4) : null;
    }

    private int doCalculate(int i10, ValueRule valueRule, int i11) {
        return i10 + valueRule.mAbsoluteValue + ((int) (valueRule.mFraction * i11));
    }

    public void calculateBounds(Rect rect, Rect rect2) {
        ValueRule valueRule = this.left;
        if (valueRule == null) {
            rect2.left = rect.left;
        } else {
            rect2.left = doCalculate(rect.left, valueRule, rect.width());
        }
        ValueRule valueRule2 = this.right;
        if (valueRule2 == null) {
            rect2.right = rect.right;
        } else {
            rect2.right = doCalculate(rect.left, valueRule2, rect.width());
        }
        ValueRule valueRule3 = this.top;
        if (valueRule3 == null) {
            rect2.top = rect.top;
        } else {
            rect2.top = doCalculate(rect.top, valueRule3, rect.height());
        }
        ValueRule valueRule4 = this.bottom;
        if (valueRule4 == null) {
            rect2.bottom = rect.bottom;
        } else {
            rect2.bottom = doCalculate(rect.top, valueRule4, rect.height());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ValueRule {
        int mAbsoluteValue;
        float mFraction;

        public ValueRule(ValueRule valueRule) {
            this.mFraction = valueRule.mFraction;
            this.mAbsoluteValue = valueRule.mAbsoluteValue;
        }

        public static ValueRule absoluteValue(int i10) {
            return new ValueRule(i10, 0.0f);
        }

        public static ValueRule inheritFromParent(float f) {
            return new ValueRule(0, f);
        }

        public static ValueRule inheritFromParentWithOffset(float f, int i10) {
            return new ValueRule(i10, f);
        }

        public int getAbsoluteValue() {
            return this.mAbsoluteValue;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public void setAbsoluteValue(int i10) {
            this.mAbsoluteValue = i10;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public ValueRule(int i10, float f) {
            this.mAbsoluteValue = i10;
            this.mFraction = f;
        }
    }

    public BoundsRule() {
    }
}
