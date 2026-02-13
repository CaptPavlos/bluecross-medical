package androidx.leanback.widget.picker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PickerColumn {
    private int mCurrentValue;
    private String mLabelFormat;
    private int mMaxValue;
    private int mMinValue;
    private CharSequence[] mStaticLabels;

    public int getCount() {
        return (this.mMaxValue - this.mMinValue) + 1;
    }

    public int getCurrentValue() {
        return this.mCurrentValue;
    }

    public CharSequence getLabelFor(int i10) {
        CharSequence[] charSequenceArr = this.mStaticLabels;
        return charSequenceArr == null ? String.format(this.mLabelFormat, Integer.valueOf(i10)) : charSequenceArr[i10];
    }

    public String getLabelFormat() {
        return this.mLabelFormat;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public CharSequence[] getStaticLabels() {
        return this.mStaticLabels;
    }

    public void setCurrentValue(int i10) {
        this.mCurrentValue = i10;
    }

    public void setLabelFormat(String str) {
        this.mLabelFormat = str;
    }

    public void setMaxValue(int i10) {
        this.mMaxValue = i10;
    }

    public void setMinValue(int i10) {
        this.mMinValue = i10;
    }

    public void setStaticLabels(CharSequence[] charSequenceArr) {
        this.mStaticLabels = charSequenceArr;
    }
}
