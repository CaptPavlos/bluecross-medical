package androidx.constraintlayout.core.dsl;

import a3.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Constraint {
    public static final Constraint PARENT = new Constraint("parent");
    static int UNSET = Integer.MIN_VALUE;
    static Map<ChainMode, String> chainModeMap;
    private float mCircleAngle;
    private String mCircleConstraint;
    private int mCircleRadius;
    private boolean mConstrainedHeight;
    private boolean mConstrainedWidth;
    private String mDimensionRatio;
    private int mEditorAbsoluteX;
    private int mEditorAbsoluteY;
    private int mHeight;
    private Behaviour mHeightDefault;
    private int mHeightMax;
    private int mHeightMin;
    private float mHeightPercent;
    private float mHorizontalBias;
    private ChainMode mHorizontalChainStyle;
    private float mHorizontalWeight;
    private final String mId;
    private String[] mReferenceIds;
    private float mVerticalBias;
    private ChainMode mVerticalChainStyle;
    private float mVerticalWeight;
    private int mWidth;
    private Behaviour mWidthDefault;
    private int mWidthMax;
    private int mWidthMin;
    private float mWidthPercent;
    String helperType = null;
    String helperJason = null;
    private HAnchor mLeft = new HAnchor(HSide.LEFT);
    private HAnchor mRight = new HAnchor(HSide.RIGHT);
    private VAnchor mTop = new VAnchor(VSide.TOP);
    private VAnchor mBottom = new VAnchor(VSide.BOTTOM);
    private HAnchor mStart = new HAnchor(HSide.START);
    private HAnchor mEnd = new HAnchor(HSide.END);
    private VAnchor mBaseline = new VAnchor(VSide.BASELINE);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class Anchor {
        Anchor mConnection = null;
        int mGoneMargin = Integer.MIN_VALUE;
        int mMargin;
        final Side mSide;

        public Anchor(Side side) {
            this.mSide = side;
        }

        public void build(StringBuilder sb) {
            if (this.mConnection != null) {
                sb.append(this.mSide.toString().toLowerCase());
                sb.append(":");
                sb.append(this);
                sb.append(",\n");
            }
        }

        public String getId() {
            return Constraint.this.mId;
        }

        public Constraint getParent() {
            return Constraint.this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.mConnection != null) {
                sb.append("'");
                sb.append(this.mConnection.getId());
                sb.append("','");
                sb.append(this.mConnection.mSide.toString().toLowerCase());
                sb.append("'");
            }
            if (this.mMargin != 0) {
                sb.append(",");
                sb.append(this.mMargin);
            }
            if (this.mGoneMargin != Integer.MIN_VALUE) {
                if (this.mMargin == 0) {
                    sb.append(",0,");
                    sb.append(this.mGoneMargin);
                } else {
                    sb.append(",");
                    sb.append(this.mGoneMargin);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Behaviour {
        SPREAD,
        WRAP,
        PERCENT,
        RATIO,
        RESOLVED
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum ChainMode {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class HAnchor extends Anchor {
        public HAnchor(HSide hSide) {
            super(Side.valueOf(hSide.name()));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum HSide {
        LEFT,
        RIGHT,
        START,
        END
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        START,
        END,
        BASELINE
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class VAnchor extends Anchor {
        public VAnchor(VSide vSide) {
            super(Side.valueOf(vSide.name()));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum VSide {
        TOP,
        BOTTOM,
        BASELINE
    }

    static {
        HashMap map = new HashMap();
        chainModeMap = map;
        map.put(ChainMode.SPREAD, "spread");
        chainModeMap.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        chainModeMap.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String str) {
        int i10 = UNSET;
        this.mWidth = i10;
        this.mHeight = i10;
        this.mHorizontalBias = Float.NaN;
        this.mVerticalBias = Float.NaN;
        this.mDimensionRatio = null;
        this.mCircleConstraint = null;
        this.mCircleRadius = Integer.MIN_VALUE;
        this.mCircleAngle = Float.NaN;
        this.mEditorAbsoluteX = Integer.MIN_VALUE;
        this.mEditorAbsoluteY = Integer.MIN_VALUE;
        this.mVerticalWeight = Float.NaN;
        this.mHorizontalWeight = Float.NaN;
        this.mHorizontalChainStyle = null;
        this.mVerticalChainStyle = null;
        this.mWidthDefault = null;
        this.mHeightDefault = null;
        this.mWidthMax = i10;
        this.mHeightMax = i10;
        this.mWidthMin = i10;
        this.mHeightMin = i10;
        this.mWidthPercent = Float.NaN;
        this.mHeightPercent = Float.NaN;
        this.mReferenceIds = null;
        this.mConstrainedWidth = false;
        this.mConstrainedHeight = false;
        this.mId = str;
    }

    public void append(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(":");
        sb.append(f);
        sb.append(",\n");
    }

    public String convertStringArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i10 = 0;
        while (i10 < strArr.length) {
            sb.append(i10 == 0 ? "'" : ",'");
            sb.append(strArr[i10]);
            sb.append("'");
            i10++;
        }
        sb.append("]");
        return sb.toString();
    }

    public VAnchor getBaseline() {
        return this.mBaseline;
    }

    public VAnchor getBottom() {
        return this.mBottom;
    }

    public float getCircleAngle() {
        return this.mCircleAngle;
    }

    public String getCircleConstraint() {
        return this.mCircleConstraint;
    }

    public int getCircleRadius() {
        return this.mCircleRadius;
    }

    public String getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getEditorAbsoluteX() {
        return this.mEditorAbsoluteX;
    }

    public int getEditorAbsoluteY() {
        return this.mEditorAbsoluteY;
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Behaviour getHeightDefault() {
        return this.mHeightDefault;
    }

    public int getHeightMax() {
        return this.mHeightMax;
    }

    public int getHeightMin() {
        return this.mHeightMin;
    }

    public float getHeightPercent() {
        return this.mHeightPercent;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public ChainMode getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public float getHorizontalWeight() {
        return this.mHorizontalWeight;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public String[] getReferenceIds() {
        return this.mReferenceIds;
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public VAnchor getTop() {
        return this.mTop;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public ChainMode getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public float getVerticalWeight() {
        return this.mVerticalWeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public Behaviour getWidthDefault() {
        return this.mWidthDefault;
    }

    public int getWidthMax() {
        return this.mWidthMax;
    }

    public int getWidthMin() {
        return this.mWidthMin;
    }

    public float getWidthPercent() {
        return this.mWidthPercent;
    }

    public boolean isConstrainedHeight() {
        return this.mConstrainedHeight;
    }

    public boolean isConstrainedWidth() {
        return this.mConstrainedWidth;
    }

    public void linkToBaseline(VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mBaseline;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
    }

    public void linkToBottom(VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mBottom;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
    }

    public void linkToEnd(HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mEnd;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
    }

    public void linkToLeft(HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mLeft;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
    }

    public void linkToRight(HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mRight;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
    }

    public void linkToStart(HAnchor hAnchor, int i10, int i11) {
        HAnchor hAnchor2 = this.mStart;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i10;
        hAnchor2.mGoneMargin = i11;
    }

    public void linkToTop(VAnchor vAnchor, int i10, int i11) {
        VAnchor vAnchor2 = this.mTop;
        vAnchor2.mConnection = vAnchor;
        vAnchor2.mMargin = i10;
        vAnchor2.mGoneMargin = i11;
    }

    public void setCircleAngle(float f) {
        this.mCircleAngle = f;
    }

    public void setCircleConstraint(String str) {
        this.mCircleConstraint = str;
    }

    public void setCircleRadius(int i10) {
        this.mCircleRadius = i10;
    }

    public void setConstrainedHeight(boolean z9) {
        this.mConstrainedHeight = z9;
    }

    public void setConstrainedWidth(boolean z9) {
        this.mConstrainedWidth = z9;
    }

    public void setDimensionRatio(String str) {
        this.mDimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i10) {
        this.mEditorAbsoluteX = i10;
    }

    public void setEditorAbsoluteY(int i10) {
        this.mEditorAbsoluteY = i10;
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
    }

    public void setHeightDefault(Behaviour behaviour) {
        this.mHeightDefault = behaviour;
    }

    public void setHeightMax(int i10) {
        this.mHeightMax = i10;
    }

    public void setHeightMin(int i10) {
        this.mHeightMin = i10;
    }

    public void setHeightPercent(float f) {
        this.mHeightPercent = f;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalChainStyle(ChainMode chainMode) {
        this.mHorizontalChainStyle = chainMode;
    }

    public void setHorizontalWeight(float f) {
        this.mHorizontalWeight = f;
    }

    public void setReferenceIds(String[] strArr) {
        this.mReferenceIds = strArr;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalChainStyle(ChainMode chainMode) {
        this.mVerticalChainStyle = chainMode;
    }

    public void setVerticalWeight(float f) {
        this.mVerticalWeight = f;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public void setWidthDefault(Behaviour behaviour) {
        this.mWidthDefault = behaviour;
    }

    public void setWidthMax(int i10) {
        this.mWidthMax = i10;
    }

    public void setWidthMin(int i10) {
        this.mWidthMin = i10;
    }

    public void setWidthPercent(float f) {
        this.mWidthPercent = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a.o(new StringBuilder(), this.mId, ":{\n"));
        this.mLeft.build(sb);
        this.mRight.build(sb);
        this.mTop.build(sb);
        this.mBottom.build(sb);
        this.mStart.build(sb);
        this.mEnd.build(sb);
        this.mBaseline.build(sb);
        if (this.mWidth != UNSET) {
            sb.append("width:");
            sb.append(this.mWidth);
            sb.append(",\n");
        }
        if (this.mHeight != UNSET) {
            sb.append("height:");
            sb.append(this.mHeight);
            sb.append(",\n");
        }
        append(sb, "horizontalBias", this.mHorizontalBias);
        append(sb, "verticalBias", this.mVerticalBias);
        if (this.mDimensionRatio != null) {
            sb.append("dimensionRatio:'");
            sb.append(this.mDimensionRatio);
            sb.append("',\n");
        }
        if (this.mCircleConstraint != null && (!Float.isNaN(this.mCircleAngle) || this.mCircleRadius != Integer.MIN_VALUE)) {
            sb.append("circular:['");
            sb.append(this.mCircleConstraint);
            sb.append("'");
            if (!Float.isNaN(this.mCircleAngle)) {
                sb.append(",");
                sb.append(this.mCircleAngle);
            }
            if (this.mCircleRadius != Integer.MIN_VALUE) {
                if (Float.isNaN(this.mCircleAngle)) {
                    sb.append(",0,");
                    sb.append(this.mCircleRadius);
                } else {
                    sb.append(",");
                    sb.append(this.mCircleRadius);
                }
            }
            sb.append("],\n");
        }
        append(sb, "verticalWeight", this.mVerticalWeight);
        append(sb, "horizontalWeight", this.mHorizontalWeight);
        if (this.mHorizontalChainStyle != null) {
            sb.append("horizontalChainStyle:'");
            sb.append(chainModeMap.get(this.mHorizontalChainStyle));
            sb.append("',\n");
        }
        if (this.mVerticalChainStyle != null) {
            sb.append("verticalChainStyle:'");
            sb.append(chainModeMap.get(this.mVerticalChainStyle));
            sb.append("',\n");
        }
        if (this.mWidthDefault != null) {
            int i10 = this.mWidthMax;
            int i11 = UNSET;
            if (i10 == i11 && this.mWidthMin == i11) {
                sb.append("width:'");
                sb.append(this.mWidthDefault.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("width:{value:'");
                sb.append(this.mWidthDefault.toString().toLowerCase());
                sb.append("'");
                if (this.mWidthMax != UNSET) {
                    sb.append(",max:");
                    sb.append(this.mWidthMax);
                }
                if (this.mWidthMin != UNSET) {
                    sb.append(",min:");
                    sb.append(this.mWidthMin);
                }
                sb.append("},\n");
            }
        }
        if (this.mHeightDefault != null) {
            int i12 = this.mHeightMax;
            int i13 = UNSET;
            if (i12 == i13 && this.mHeightMin == i13) {
                sb.append("height:'");
                sb.append(this.mHeightDefault.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("height:{value:'");
                sb.append(this.mHeightDefault.toString().toLowerCase());
                sb.append("'");
                if (this.mHeightMax != UNSET) {
                    sb.append(",max:");
                    sb.append(this.mHeightMax);
                }
                if (this.mHeightMin != UNSET) {
                    sb.append(",min:");
                    sb.append(this.mHeightMin);
                }
                sb.append("},\n");
            }
        }
        if (!Double.isNaN(this.mWidthPercent)) {
            sb.append("width:'");
            sb.append((int) this.mWidthPercent);
            sb.append("%',\n");
        }
        if (!Double.isNaN(this.mHeightPercent)) {
            sb.append("height:'");
            sb.append((int) this.mHeightPercent);
            sb.append("%',\n");
        }
        if (this.mReferenceIds != null) {
            sb.append("referenceIds:");
            sb.append(convertStringArrayToString(this.mReferenceIds));
            sb.append(",\n");
        }
        if (this.mConstrainedWidth) {
            sb.append("constrainedWidth:");
            sb.append(this.mConstrainedWidth);
            sb.append(",\n");
        }
        if (this.mConstrainedHeight) {
            sb.append("constrainedHeight:");
            sb.append(this.mConstrainedHeight);
            sb.append(",\n");
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void linkToBaseline(VAnchor vAnchor, int i10) {
        linkToBaseline(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToBottom(VAnchor vAnchor, int i10) {
        linkToBottom(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToEnd(HAnchor hAnchor, int i10) {
        linkToEnd(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToLeft(HAnchor hAnchor, int i10) {
        linkToLeft(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToRight(HAnchor hAnchor, int i10) {
        linkToRight(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToStart(HAnchor hAnchor, int i10) {
        linkToStart(hAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToTop(VAnchor vAnchor, int i10) {
        linkToTop(vAnchor, i10, Integer.MIN_VALUE);
    }

    public void linkToBaseline(VAnchor vAnchor) {
        linkToBaseline(vAnchor, 0);
    }

    public void linkToBottom(VAnchor vAnchor) {
        linkToBottom(vAnchor, 0);
    }

    public void linkToEnd(HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToLeft(HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToRight(HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToStart(HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public void linkToTop(VAnchor vAnchor) {
        linkToTop(vAnchor, 0);
    }
}
