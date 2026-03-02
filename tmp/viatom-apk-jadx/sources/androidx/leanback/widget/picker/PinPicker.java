package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PinPicker extends Picker {
    private static final int DEFAULT_COLUMN_COUNT = 4;

    @SuppressLint({"CustomViewStyleable"})
    public PinPicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int[] iArr = R.styleable.lbPinPicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbPinPicker_columnCount, 4));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.leanback.widget.picker.Picker, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 1 || keyCode < 7 || keyCode > 16) {
            return super.dispatchKeyEvent(keyEvent);
        }
        setColumnValue(getSelectedColumn(), keyCode - 7, false);
        performClick();
        return true;
    }

    public String getPin() {
        StringBuilder sb = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i10 = 0; i10 < columnsCount; i10++) {
            sb.append(Integer.toString(getColumnAt(i10).getCurrentValue()));
        }
        return sb.toString();
    }

    @Override // android.view.View
    public boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    public void resetPin() {
        int columnsCount = getColumnsCount();
        for (int i10 = 0; i10 < columnsCount; i10++) {
            setColumnValue(i10, 0, false);
        }
        setSelectedColumn(0);
    }

    public void setNumberOfColumns(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            PickerColumn pickerColumn = new PickerColumn();
            pickerColumn.setMinValue(0);
            pickerColumn.setMaxValue(9);
            pickerColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            arrayList.add(pickerColumn);
        }
        setColumns(arrayList);
    }

    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }
}
