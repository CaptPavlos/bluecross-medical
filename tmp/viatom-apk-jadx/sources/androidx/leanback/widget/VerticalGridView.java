package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class VerticalGridView extends BaseGridView {
    public VerticalGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLayoutManager.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        int[] iArr = R.styleable.lbVerticalGridView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        setColumnWidth(typedArrayObtainStyledAttributes);
        setNumColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setColumnWidth(TypedArray typedArray) {
        int i10 = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i10) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i10, 0));
        }
    }

    public void setNumColumns(int i10) {
        this.mLayoutManager.setNumRows(i10);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalGridView(Context context) {
        this(context, null);
    }

    public void setColumnWidth(int i10) {
        this.mLayoutManager.setRowHeight(i10);
        requestLayout();
    }
}
