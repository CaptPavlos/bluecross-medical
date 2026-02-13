package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class FlowReference extends HelperReference {
    protected float mFirstHorizontalBias;
    protected int mFirstHorizontalStyle;
    protected float mFirstVerticalBias;
    protected int mFirstVerticalStyle;
    protected Flow mFlow;
    protected int mHorizontalAlign;
    protected int mHorizontalGap;
    protected int mHorizontalStyle;
    protected float mLastHorizontalBias;
    protected int mLastHorizontalStyle;
    protected float mLastVerticalBias;
    protected int mLastVerticalStyle;
    protected HashMap<String, Float> mMapPostMargin;
    protected HashMap<String, Float> mMapPreMargin;
    protected HashMap<String, Float> mMapWeights;
    protected int mMaxElementsWrap;
    protected int mOrientation;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected int mVerticalAlign;
    protected int mVerticalGap;
    protected int mVerticalStyle;
    protected int mWrapMode;

    public FlowReference(State state, State.Helper helper) {
        super(state, helper);
        this.mWrapMode = 0;
        this.mVerticalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mVerticalAlign = 2;
        this.mHorizontalAlign = 2;
        this.mVerticalGap = 0;
        this.mHorizontalGap = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mFirstVerticalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        if (helper == State.Helper.VERTICAL_FLOW) {
            this.mOrientation = 1;
        }
    }

    public void addFlowElement(String str, float f, float f10, float f11) {
        super.add(str);
        if (!Float.isNaN(f)) {
            if (this.mMapWeights == null) {
                this.mMapWeights = new HashMap<>();
            }
            this.mMapWeights.put(str, Float.valueOf(f));
        }
        if (!Float.isNaN(f10)) {
            if (this.mMapPreMargin == null) {
                this.mMapPreMargin = new HashMap<>();
            }
            this.mMapPreMargin.put(str, Float.valueOf(f10));
        }
        if (Float.isNaN(f11)) {
            return;
        }
        if (this.mMapPostMargin == null) {
            this.mMapPostMargin = new HashMap<>();
        }
        this.mMapPostMargin.put(str, Float.valueOf(f11));
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        setConstraintWidget(this.mFlow);
        this.mFlow.setOrientation(this.mOrientation);
        this.mFlow.setWrapMode(this.mWrapMode);
        int i10 = this.mMaxElementsWrap;
        if (i10 != -1) {
            this.mFlow.setMaxElementsWrap(i10);
        }
        int i11 = this.mPaddingLeft;
        if (i11 != 0) {
            this.mFlow.setPaddingLeft(i11);
        }
        int i12 = this.mPaddingTop;
        if (i12 != 0) {
            this.mFlow.setPaddingTop(i12);
        }
        int i13 = this.mPaddingRight;
        if (i13 != 0) {
            this.mFlow.setPaddingRight(i13);
        }
        int i14 = this.mPaddingBottom;
        if (i14 != 0) {
            this.mFlow.setPaddingBottom(i14);
        }
        int i15 = this.mHorizontalGap;
        if (i15 != 0) {
            this.mFlow.setHorizontalGap(i15);
        }
        int i16 = this.mVerticalGap;
        if (i16 != 0) {
            this.mFlow.setVerticalGap(i16);
        }
        float f = this.mHorizontalBias;
        if (f != 0.5f) {
            this.mFlow.setHorizontalBias(f);
        }
        float f10 = this.mFirstHorizontalBias;
        if (f10 != 0.5f) {
            this.mFlow.setFirstHorizontalBias(f10);
        }
        float f11 = this.mLastHorizontalBias;
        if (f11 != 0.5f) {
            this.mFlow.setLastHorizontalBias(f11);
        }
        float f12 = this.mVerticalBias;
        if (f12 != 0.5f) {
            this.mFlow.setVerticalBias(f12);
        }
        float f13 = this.mFirstVerticalBias;
        if (f13 != 0.5f) {
            this.mFlow.setFirstVerticalBias(f13);
        }
        float f14 = this.mLastVerticalBias;
        if (f14 != 0.5f) {
            this.mFlow.setLastVerticalBias(f14);
        }
        int i17 = this.mHorizontalAlign;
        if (i17 != 2) {
            this.mFlow.setHorizontalAlign(i17);
        }
        int i18 = this.mVerticalAlign;
        if (i18 != 2) {
            this.mFlow.setVerticalAlign(i18);
        }
        int i19 = this.mVerticalStyle;
        if (i19 != -1) {
            this.mFlow.setVerticalStyle(i19);
        }
        int i20 = this.mFirstVerticalStyle;
        if (i20 != -1) {
            this.mFlow.setFirstVerticalStyle(i20);
        }
        int i21 = this.mLastVerticalStyle;
        if (i21 != -1) {
            this.mFlow.setLastVerticalStyle(i21);
        }
        int i22 = this.mHorizontalStyle;
        if (i22 != -1) {
            this.mFlow.setHorizontalStyle(i22);
        }
        int i23 = this.mFirstHorizontalStyle;
        if (i23 != -1) {
            this.mFlow.setFirstHorizontalStyle(i23);
        }
        int i24 = this.mLastHorizontalStyle;
        if (i24 != -1) {
            this.mFlow.setLastHorizontalStyle(i24);
        }
        applyBase();
    }

    public float getFirstHorizontalBias() {
        return this.mFirstHorizontalBias;
    }

    public int getFirstHorizontalStyle() {
        return this.mFirstHorizontalStyle;
    }

    public float getFirstVerticalBias() {
        return this.mFirstVerticalBias;
    }

    public int getFirstVerticalStyle() {
        return this.mFirstVerticalStyle;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mFlow == null) {
            this.mFlow = new Flow();
        }
        return this.mFlow;
    }

    public int getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public int getHorizontalGap() {
        return this.mHorizontalGap;
    }

    public int getHorizontalStyle() {
        return this.mHorizontalStyle;
    }

    public float getLastHorizontalBias() {
        return this.mLastHorizontalBias;
    }

    public int getLastHorizontalStyle() {
        return this.mLastHorizontalStyle;
    }

    public float getLastVerticalBias() {
        return this.mLastVerticalBias;
    }

    public int getLastVerticalStyle() {
        return this.mLastVerticalStyle;
    }

    public int getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public float getPostMargin(String str) {
        HashMap<String, Float> map = this.mMapPreMargin;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPreMargin.get(str).floatValue();
    }

    public float getPreMargin(String str) {
        HashMap<String, Float> map = this.mMapPostMargin;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPostMargin.get(str).floatValue();
    }

    public int getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public int getVerticalGap() {
        return this.mVerticalGap;
    }

    public int getVerticalStyle() {
        return this.mVerticalStyle;
    }

    public float getWeight(String str) {
        HashMap<String, Float> map = this.mMapWeights;
        if (map != null && map.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    public int getWrapMode() {
        return this.mWrapMode;
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i10) {
        this.mFirstHorizontalStyle = i10;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i10) {
        this.mFirstVerticalStyle = i10;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public void setHelperWidget(HelperWidget helperWidget) {
        if (helperWidget instanceof Flow) {
            this.mFlow = (Flow) helperWidget;
        } else {
            this.mFlow = null;
        }
    }

    public void setHorizontalAlign(int i10) {
        this.mHorizontalAlign = i10;
    }

    public void setHorizontalGap(int i10) {
        this.mHorizontalGap = i10;
    }

    public void setHorizontalStyle(int i10) {
        this.mHorizontalStyle = i10;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i10) {
        this.mLastHorizontalStyle = i10;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i10) {
        this.mLastVerticalStyle = i10;
    }

    public void setMaxElementsWrap(int i10) {
        this.mMaxElementsWrap = i10;
    }

    public void setOrientation(int i10) {
        this.mOrientation = i10;
    }

    public void setPaddingBottom(int i10) {
        this.mPaddingBottom = i10;
    }

    public void setPaddingLeft(int i10) {
        this.mPaddingLeft = i10;
    }

    public void setPaddingRight(int i10) {
        this.mPaddingRight = i10;
    }

    public void setPaddingTop(int i10) {
        this.mPaddingTop = i10;
    }

    public void setVerticalAlign(int i10) {
        this.mVerticalAlign = i10;
    }

    public void setVerticalGap(int i10) {
        this.mVerticalGap = i10;
    }

    public void setVerticalStyle(int i10) {
        this.mVerticalStyle = i10;
    }

    public void setWrapMode(int i10) {
        this.mWrapMode = i10;
    }
}
