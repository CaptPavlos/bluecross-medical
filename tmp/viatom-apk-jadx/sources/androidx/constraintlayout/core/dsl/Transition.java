package androidx.constraintlayout.core.dsl;

import a3.a;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Transition {
    private String mConstraintSetEnd;
    private String mConstraintSetStart;
    private String mId;
    private OnSwipe mOnSwipe = null;
    final int UNSET = -1;
    private final int DEFAULT_DURATION = 400;
    private final float DEFAULT_STAGGER = 0.0f;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDefaultInterpolatorID = -1;
    private int mDuration = 400;
    private float mStagger = 0.0f;
    private KeyFrames mKeyFrames = new KeyFrames();

    public Transition(String str, String str2) {
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mId = MRAIDCommunicatorUtil.STATES_DEFAULT;
        this.mConstraintSetStart = str;
        this.mConstraintSetEnd = str2;
    }

    public String getId() {
        return this.mId;
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    public void setFrom(String str) {
        this.mConstraintSetStart = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setKeyFrames(Keys keys) {
        this.mKeyFrames.add(keys);
    }

    public void setOnSwipe(OnSwipe onSwipe) {
        this.mOnSwipe = onSwipe;
    }

    public void setStagger(float f) {
        this.mStagger = f;
    }

    public void setTo(String str) {
        this.mConstraintSetEnd = str;
    }

    public String toJson() {
        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mId);
        sb.append(":{\nfrom:'");
        sb.append(this.mConstraintSetStart);
        sb.append("',\nto:'");
        String strO = a.o(sb, this.mConstraintSetEnd, "',\n");
        if (this.mDuration != 400) {
            strO = a.n(a.w(strO, "duration:"), ",\n", this.mDuration);
        }
        if (this.mStagger != 0.0f) {
            StringBuilder sbW = a.w(strO, "stagger:");
            sbW.append(this.mStagger);
            sbW.append(",\n");
            strO = sbW.toString();
        }
        if (this.mOnSwipe != null) {
            StringBuilder sbV = a.v(strO);
            sbV.append(this.mOnSwipe.toString());
            strO = sbV.toString();
        }
        StringBuilder sbV2 = a.v(strO);
        sbV2.append(this.mKeyFrames.toString());
        return sbV2.toString().concat("},\n");
    }

    public Transition(String str, String str2, String str3) {
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mId = str;
        this.mConstraintSetStart = str2;
        this.mConstraintSetEnd = str3;
    }
}
