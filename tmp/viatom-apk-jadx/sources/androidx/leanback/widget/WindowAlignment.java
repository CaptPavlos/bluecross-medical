package androidx.leanback.widget;

import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class WindowAlignment {
    public final Axis horizontal;
    private Axis mMainAxis;
    private int mOrientation = 0;
    private Axis mSecondAxis;
    public final Axis vertical;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Axis {
        private static final int PF_KEYLINE_OVER_HIGH_EDGE = 2;
        private static final int PF_KEYLINE_OVER_LOW_EDGE = 1;
        private int mMaxEdge;
        private int mMaxScroll;
        private int mMinEdge;
        private int mMinScroll;
        private int mPaddingMax;
        private int mPaddingMin;
        private boolean mReversedFlow;
        private int mSize;
        private int mPreferredKeyLine = 2;
        private int mWindowAlignment = 3;
        private int mWindowAlignmentOffset = 0;
        private float mWindowAlignmentOffsetPercent = 50.0f;

        public Axis(String str) {
            reset();
        }

        public int calculateKeyline() {
            boolean z9 = this.mReversedFlow;
            int i10 = this.mWindowAlignmentOffset;
            if (z9) {
                int i11 = i10 >= 0 ? this.mSize - i10 : -i10;
                float f = this.mWindowAlignmentOffsetPercent;
                return f != -1.0f ? i11 - ((int) ((this.mSize * f) / 100.0f)) : i11;
            }
            if (i10 < 0) {
                i10 += this.mSize;
            }
            float f10 = this.mWindowAlignmentOffsetPercent;
            return f10 != -1.0f ? i10 + ((int) ((this.mSize * f10) / 100.0f)) : i10;
        }

        public int calculateScrollToKeyLine(int i10, int i11) {
            return i10 - i11;
        }

        public int getClientSize() {
            return (this.mSize - this.mPaddingMin) - this.mPaddingMax;
        }

        public int getMaxScroll() {
            return this.mMaxScroll;
        }

        public int getMinScroll() {
            return this.mMinScroll;
        }

        public int getPaddingMax() {
            return this.mPaddingMax;
        }

        public int getPaddingMin() {
            return this.mPaddingMin;
        }

        public int getScroll(int i10) {
            int i11;
            int i12;
            int size = getSize();
            int iCalculateKeyline = calculateKeyline();
            boolean zIsMinUnknown = isMinUnknown();
            boolean zIsMaxUnknown = isMaxUnknown();
            if (!zIsMinUnknown) {
                int i13 = this.mPaddingMin;
                int i14 = iCalculateKeyline - i13;
                boolean z9 = this.mReversedFlow;
                int i15 = this.mWindowAlignment;
                if (z9 ? (i15 & 2) != 0 : (i15 & 1) != 0) {
                    int i16 = this.mMinEdge;
                    if (i10 - i16 <= i14) {
                        int i17 = i16 - i13;
                        return (zIsMaxUnknown || i17 <= (i12 = this.mMaxScroll)) ? i17 : i12;
                    }
                }
            }
            if (!zIsMaxUnknown) {
                int i18 = this.mPaddingMax;
                int i19 = (size - iCalculateKeyline) - i18;
                boolean z10 = this.mReversedFlow;
                int i20 = this.mWindowAlignment;
                if (z10 ? (i20 & 1) != 0 : (i20 & 2) != 0) {
                    int i21 = this.mMaxEdge;
                    if (i21 - i10 <= i19) {
                        int i22 = i21 - (size - i18);
                        return (zIsMinUnknown || i22 >= (i11 = this.mMinScroll)) ? i22 : i11;
                    }
                }
            }
            return calculateScrollToKeyLine(i10, iCalculateKeyline);
        }

        public int getSize() {
            return this.mSize;
        }

        public int getWindowAlignment() {
            return this.mWindowAlignment;
        }

        public int getWindowAlignmentOffset() {
            return this.mWindowAlignmentOffset;
        }

        public float getWindowAlignmentOffsetPercent() {
            return this.mWindowAlignmentOffsetPercent;
        }

        public void invalidateScrollMax() {
            this.mMaxEdge = Integer.MAX_VALUE;
            this.mMaxScroll = Integer.MAX_VALUE;
        }

        public void invalidateScrollMin() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMinScroll = Integer.MIN_VALUE;
        }

        public boolean isMaxUnknown() {
            return this.mMaxEdge == Integer.MAX_VALUE;
        }

        public boolean isMinUnknown() {
            return this.mMinEdge == Integer.MIN_VALUE;
        }

        public boolean isPreferKeylineOverHighEdge() {
            return (this.mPreferredKeyLine & 2) != 0;
        }

        public boolean isPreferKeylineOverLowEdge() {
            return (this.mPreferredKeyLine & 1) != 0;
        }

        public void reset() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMaxEdge = Integer.MAX_VALUE;
        }

        public void setPadding(int i10, int i11) {
            this.mPaddingMin = i10;
            this.mPaddingMax = i11;
        }

        public void setPreferKeylineOverHighEdge(boolean z9) {
            int i10 = this.mPreferredKeyLine;
            this.mPreferredKeyLine = z9 ? i10 | 2 : i10 & (-3);
        }

        public void setPreferKeylineOverLowEdge(boolean z9) {
            int i10 = this.mPreferredKeyLine;
            this.mPreferredKeyLine = z9 ? i10 | 1 : i10 & (-2);
        }

        public void setReversedFlow(boolean z9) {
            this.mReversedFlow = z9;
        }

        public void setSize(int i10) {
            this.mSize = i10;
        }

        public void setWindowAlignment(int i10) {
            this.mWindowAlignment = i10;
        }

        public void setWindowAlignmentOffset(int i10) {
            this.mWindowAlignmentOffset = i10;
        }

        public void setWindowAlignmentOffsetPercent(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                f.a();
            } else {
                this.mWindowAlignmentOffsetPercent = f;
            }
        }

        public String toString() {
            return " min:" + this.mMinEdge + " " + this.mMinScroll + " max:" + this.mMaxEdge + " " + this.mMaxScroll;
        }

        public void updateMinMax(int i10, int i11, int i12, int i13) {
            this.mMinEdge = i10;
            this.mMaxEdge = i11;
            int clientSize = getClientSize();
            int iCalculateKeyline = calculateKeyline();
            boolean zIsMinUnknown = isMinUnknown();
            boolean zIsMaxUnknown = isMaxUnknown();
            if (!zIsMinUnknown) {
                boolean z9 = this.mReversedFlow;
                int i14 = this.mWindowAlignment;
                if (z9 ? (i14 & 2) == 0 : (i14 & 1) == 0) {
                    this.mMinScroll = calculateScrollToKeyLine(i12, iCalculateKeyline);
                } else {
                    this.mMinScroll = this.mMinEdge - this.mPaddingMin;
                }
            }
            if (!zIsMaxUnknown) {
                boolean z10 = this.mReversedFlow;
                int i15 = this.mWindowAlignment;
                if (z10 ? (i15 & 1) == 0 : (i15 & 2) == 0) {
                    this.mMaxScroll = calculateScrollToKeyLine(i13, iCalculateKeyline);
                } else {
                    this.mMaxScroll = (this.mMaxEdge - this.mPaddingMin) - clientSize;
                }
            }
            if (zIsMaxUnknown || zIsMinUnknown) {
                return;
            }
            boolean z11 = this.mReversedFlow;
            int i16 = this.mWindowAlignment;
            if (z11) {
                if ((i16 & 1) != 0) {
                    if (isPreferKeylineOverLowEdge()) {
                        this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i12, iCalculateKeyline));
                    }
                    this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    return;
                } else {
                    if ((i16 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i13, iCalculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                        return;
                    }
                    return;
                }
            }
            if ((i16 & 1) != 0) {
                if (isPreferKeylineOverLowEdge()) {
                    this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i13, iCalculateKeyline));
                }
                this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
            } else if ((i16 & 2) != 0) {
                if (isPreferKeylineOverHighEdge()) {
                    this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i12, iCalculateKeyline));
                }
                this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
            }
        }
    }

    public WindowAlignment() {
        Axis axis = new Axis("vertical");
        this.vertical = axis;
        Axis axis2 = new Axis("horizontal");
        this.horizontal = axis2;
        this.mMainAxis = axis2;
        this.mSecondAxis = axis;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Axis mainAxis() {
        return this.mMainAxis;
    }

    public void reset() {
        mainAxis().reset();
    }

    public Axis secondAxis() {
        return this.mSecondAxis;
    }

    public void setOrientation(int i10) {
        this.mOrientation = i10;
        if (i10 == 0) {
            this.mMainAxis = this.horizontal;
            this.mSecondAxis = this.vertical;
        } else {
            this.mMainAxis = this.vertical;
            this.mSecondAxis = this.horizontal;
        }
    }

    public String toString() {
        return "horizontal=" + this.horizontal + "; vertical=" + this.vertical;
    }
}
