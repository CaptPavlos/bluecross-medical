package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
class ResizingTextView extends TextView {
    public static final int TRIGGER_MAX_LINES = 1;
    private float mDefaultLineSpacingExtra;
    private int mDefaultPaddingBottom;
    private int mDefaultPaddingTop;
    private int mDefaultTextSize;
    private boolean mDefaultsInitialized;
    private boolean mIsResized;
    private boolean mMaintainLineSpacing;
    private int mResizedPaddingAdjustmentBottom;
    private int mResizedPaddingAdjustmentTop;
    private int mResizedTextSize;
    private int mTriggerConditions;

    @SuppressLint({"CustomViewStyleable"})
    public ResizingTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mIsResized = false;
        this.mDefaultsInitialized = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbResizingTextView, i10, i11);
        try {
            this.mTriggerConditions = typedArrayObtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbResizingTextView_resizeTrigger, 1);
            this.mResizedTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.leanback.R.styleable.lbResizingTextView_resizedTextSize, -1);
            this.mMaintainLineSpacing = typedArrayObtainStyledAttributes.getBoolean(androidx.leanback.R.styleable.lbResizingTextView_maintainLineSpacing, false);
            this.mResizedPaddingAdjustmentTop = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentTop, 0);
            this.mResizedPaddingAdjustmentBottom = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentBottom, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void resizeParamsChanged() {
        if (this.mIsResized) {
            requestLayout();
        }
    }

    private void setPaddingTopAndBottom(int i10, int i11) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i10, getPaddingEnd(), i11);
        } else {
            setPadding(getPaddingLeft(), i10, getPaddingRight(), i11);
        }
    }

    public boolean getMaintainLineSpacing() {
        return this.mMaintainLineSpacing;
    }

    public int getResizedPaddingAdjustmentBottom() {
        return this.mResizedPaddingAdjustmentBottom;
    }

    public int getResizedPaddingAdjustmentTop() {
        return this.mResizedPaddingAdjustmentTop;
    }

    public int getResizedTextSize() {
        return this.mResizedTextSize;
    }

    public int getTriggerConditions() {
        return this.mTriggerConditions;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1 A[PHI: r2
      0x00d1: PHI (r2v7 boolean) = (r2v2 boolean), (r2v9 boolean) binds: [B:41:0x00ce, B:27:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ResizingTextView.onMeasure(int, int):void");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setMaintainLineSpacing(boolean z9) {
        if (this.mMaintainLineSpacing != z9) {
            this.mMaintainLineSpacing = z9;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentBottom(int i10) {
        if (this.mResizedPaddingAdjustmentBottom != i10) {
            this.mResizedPaddingAdjustmentBottom = i10;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentTop(int i10) {
        if (this.mResizedPaddingAdjustmentTop != i10) {
            this.mResizedPaddingAdjustmentTop = i10;
            resizeParamsChanged();
        }
    }

    public void setResizedTextSize(int i10) {
        if (this.mResizedTextSize != i10) {
            this.mResizedTextSize = i10;
            resizeParamsChanged();
        }
    }

    public void setTriggerConditions(int i10) {
        if (this.mTriggerConditions != i10) {
            this.mTriggerConditions = i10;
            requestLayout();
        }
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public ResizingTextView(Context context) {
        this(context, null);
    }
}
