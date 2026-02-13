package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Dimension {
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    String mRatioString;
    int mValue;
    private final int mWrapContent;
    public static final Object FIXED_DIMENSION = new String("FIXED_DIMENSION");
    public static final Object WRAP_DIMENSION = new String("WRAP_DIMENSION");
    public static final Object SPREAD_DIMENSION = new String("SPREAD_DIMENSION");
    public static final Object PARENT_DIMENSION = new String("PARENT_DIMENSION");
    public static final Object PERCENT_DIMENSION = new String("PERCENT_DIMENSION");
    public static final Object RATIO_DIMENSION = new String("RATIO_DIMENSION");

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    @Deprecated
    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    @Deprecated
    public static Dimension Parent() {
        return createParent();
    }

    @Deprecated
    public static Dimension Percent(Object obj, float f) {
        return createPercent(obj, f);
    }

    @Deprecated
    public static Dimension Ratio(String str) {
        return createRatio(str);
    }

    @Deprecated
    public static Dimension Spread() {
        return createSpread();
    }

    @Deprecated
    public static Dimension Suggested(int i10) {
        return createSuggested(i10);
    }

    @Deprecated
    public static Dimension Wrap() {
        return createWrap();
    }

    public static Dimension createFixed(int i10) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i10);
        return dimension;
    }

    public static Dimension createParent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension createPercent(Object obj, float f) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f);
        return dimension;
    }

    public static Dimension createRatio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension createSpread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension createSuggested(int i10) {
        Dimension dimension = new Dimension();
        dimension.suggested(i10);
        return dimension;
    }

    public static Dimension createWrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i10) {
        String str = this.mRatioString;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        boolean z9 = this.mIsSuggested;
        int i11 = 2;
        if (i10 == 0) {
            if (z9) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i11 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i11 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i11, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i12 = this.mMin;
            if (i12 > 0) {
                constraintWidget.setMinWidth(i12);
            }
            int i13 = this.mMax;
            if (i13 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i13);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                    return;
                }
                return;
            }
        }
        if (z9) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i11 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i11 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i11, this.mMin, this.mMax, this.mPercent);
            return;
        }
        int i14 = this.mMin;
        if (i14 > 0) {
            constraintWidget.setMinHeight(i14);
        }
        int i15 = this.mMax;
        if (i15 < Integer.MAX_VALUE) {
            constraintWidget.setMaxHeight(i15);
        }
        Object obj4 = this.mInitialValue;
        if (obj4 == WRAP_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == PARENT_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(this.mValue);
        }
    }

    public boolean equalsFixedValue(int i10) {
        return this.mInitialValue == null && this.mValue == i10;
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    public int getValue() {
        return this.mValue;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension percent(Object obj, float f) {
        this.mPercent = f;
        return this;
    }

    public Dimension ratio(String str) {
        this.mRatioString = str;
        return this;
    }

    public void setValue(int i10) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i10;
    }

    public Dimension suggested(int i10) {
        this.mIsSuggested = true;
        if (i10 >= 0) {
            this.mMax = i10;
        }
        return this;
    }

    @Deprecated
    public static Dimension Suggested(Object obj) {
        return createSuggested(obj);
    }

    public Dimension min(int i10) {
        if (i10 >= 0) {
            this.mMin = i10;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension createSuggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    @Deprecated
    public static Dimension Fixed(int i10) {
        return createFixed(i10);
    }

    public static Dimension createFixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public Dimension max(int i10) {
        if (this.mMax >= 0) {
            this.mMax = i10;
        }
        return this;
    }

    public Dimension fixed(int i10) {
        this.mInitialValue = null;
        this.mValue = i10;
        return this;
    }

    private Dimension(Object obj) {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }
}
