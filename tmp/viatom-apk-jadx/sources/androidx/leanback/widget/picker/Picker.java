package androidx.leanback.widget.picker;

import a3.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Picker extends FrameLayout {
    private int mAlphaAnimDuration;
    private final OnChildViewHolderSelectedListener mColumnChangeListener;
    final List<VerticalGridView> mColumnViews;
    ArrayList<PickerColumn> mColumns;
    private Interpolator mDecelerateInterpolator;
    private float mFocusedAlpha;
    private float mInvisibleColumnAlpha;
    private ArrayList<PickerValueListener> mListeners;
    private int mPickerItemLayoutId;
    private int mPickerItemTextViewId;
    private ViewGroup mPickerView;
    private int mSelectedColumn;
    private List<CharSequence> mSeparators;
    private float mUnfocusedAlpha;
    private float mVisibleColumnAlpha;
    private float mVisibleItems;
    private float mVisibleItemsActivated;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class PickerScrollArrayAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final int mColIndex;
        private PickerColumn mData;
        private final int mResource;
        private final int mTextViewResourceId;

        public PickerScrollArrayAdapter(int i10, int i11, int i12) {
            this.mResource = i10;
            this.mColIndex = i12;
            this.mTextViewResourceId = i11;
            this.mData = Picker.this.mColumns.get(i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            PickerColumn pickerColumn = this.mData;
            if (pickerColumn == null) {
                return 0;
            }
            return pickerColumn.getCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i10) {
            PickerColumn pickerColumn;
            TextView textView = viewHolder.textView;
            if (textView != null && (pickerColumn = this.mData) != null) {
                textView.setText(pickerColumn.getLabelFor(pickerColumn.getMinValue() + i10));
            }
            Picker picker = Picker.this;
            picker.setOrAnimateAlpha(viewHolder.itemView, picker.mColumnViews.get(this.mColIndex).getSelectedPosition() == i10, this.mColIndex, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.mResource, viewGroup, false);
            int i11 = this.mTextViewResourceId;
            return new ViewHolder(viewInflate, i11 != 0 ? (TextView) viewInflate.findViewById(i11) : (TextView) viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(ViewHolder viewHolder) {
            viewHolder.itemView.setFocusable(Picker.this.isActivated());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface PickerValueListener {
        void onValueChanged(Picker picker, int i10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        public ViewHolder(View view, TextView textView) {
            super(view);
            this.textView = textView;
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public Picker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mColumnViews = new ArrayList();
        this.mVisibleItemsActivated = 3.0f;
        this.mVisibleItems = 1.0f;
        this.mSelectedColumn = 0;
        this.mSeparators = new ArrayList();
        this.mColumnChangeListener = new OnChildViewHolderSelectedListener() { // from class: androidx.leanback.widget.picker.Picker.1
            @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
            public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i11, int i12) {
                int iIndexOf = Picker.this.mColumnViews.indexOf((VerticalGridView) recyclerView);
                Picker.this.updateColumnAlpha(iIndexOf, true);
                if (viewHolder != null) {
                    Picker.this.onColumnValueChanged(iIndexOf, Picker.this.mColumns.get(iIndexOf).getMinValue() + i11);
                }
            }
        };
        int[] iArr = R.styleable.lbPicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        this.mPickerItemLayoutId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemLayout, R.layout.lb_picker_item);
        this.mPickerItemTextViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemTextViewId, 0);
        typedArrayObtainStyledAttributes.recycle();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.mFocusedAlpha = 1.0f;
        this.mUnfocusedAlpha = 1.0f;
        this.mVisibleColumnAlpha = 0.5f;
        this.mInvisibleColumnAlpha = 0.0f;
        this.mAlphaAnimDuration = 200;
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.5f);
        this.mPickerView = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, (ViewGroup) this, true)).findViewById(R.id.picker);
    }

    private void notifyValueChanged(int i10) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onValueChanged(this, i10);
            }
        }
    }

    private void updateColumnSize(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) a.d(activatedVisibleItemCount, 1.0f, verticalGridView.getVerticalSpacing(), getPickerItemHeightPixels() * activatedVisibleItemCount);
        verticalGridView.setLayoutParams(layoutParams);
    }

    private void updateItemFocusable() {
        boolean zIsActivated = isActivated();
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            VerticalGridView verticalGridView = this.mColumnViews.get(i10);
            for (int i11 = 0; i11 < verticalGridView.getChildCount(); i11++) {
                verticalGridView.getChildAt(i11).setFocusable(zIsActivated);
            }
        }
    }

    public void addOnValueChangedListener(PickerValueListener pickerValueListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(pickerValueListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public float getActivatedVisibleItemCount() {
        return this.mVisibleItemsActivated;
    }

    public PickerColumn getColumnAt(int i10) {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i10);
    }

    public int getColumnsCount() {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    @LayoutRes
    public final int getPickerItemLayoutId() {
        return this.mPickerItemLayoutId;
    }

    @IdRes
    public final int getPickerItemTextViewId() {
        return this.mPickerItemTextViewId;
    }

    public int getSelectedColumn() {
        return this.mSelectedColumn;
    }

    @Deprecated
    public final CharSequence getSeparator() {
        return this.mSeparators.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.mSeparators;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void onColumnValueChanged(int i10, int i11) {
        PickerColumn pickerColumn = this.mColumns.get(i10);
        if (pickerColumn.getCurrentValue() != i11) {
            pickerColumn.setCurrentValue(i11);
            notifyValueChanged(i10);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn < 0 || selectedColumn >= this.mColumnViews.size()) {
            return false;
        }
        return this.mColumnViews.get(selectedColumn).requestFocus(i10, rect);
    }

    public void removeOnValueChangedListener(PickerValueListener pickerValueListener) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(pickerValueListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        for (int i10 = 0; i10 < this.mColumnViews.size(); i10++) {
            if (this.mColumnViews.get(i10).hasFocus()) {
                setSelectedColumn(i10);
            }
        }
    }

    @Override // android.view.View
    public void setActivated(boolean z9) {
        if (z9 == isActivated()) {
            super.setActivated(z9);
            return;
        }
        super.setActivated(z9);
        boolean zHasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z9 && zHasFocus && isFocusable()) {
            requestFocus();
        }
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            this.mColumnViews.get(i10).setFocusable(z9);
        }
        updateColumnSize();
        updateItemFocusable();
        if (z9 && zHasFocus && selectedColumn >= 0) {
            this.mColumnViews.get(selectedColumn).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f) {
        if (f <= 0.0f) {
            f.a();
        } else if (this.mVisibleItemsActivated != f) {
            this.mVisibleItemsActivated = f;
            if (isActivated()) {
                updateColumnSize();
            }
        }
    }

    public void setColumnAt(int i10, PickerColumn pickerColumn) {
        this.mColumns.set(i10, pickerColumn);
        VerticalGridView verticalGridView = this.mColumnViews.get(i10);
        PickerScrollArrayAdapter pickerScrollArrayAdapter = (PickerScrollArrayAdapter) verticalGridView.getAdapter();
        if (pickerScrollArrayAdapter != null) {
            pickerScrollArrayAdapter.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(pickerColumn.getCurrentValue() - pickerColumn.getMinValue());
    }

    public void setColumnValue(int i10, int i11, boolean z9) {
        PickerColumn pickerColumn = this.mColumns.get(i10);
        if (pickerColumn.getCurrentValue() != i11) {
            pickerColumn.setCurrentValue(i11);
            notifyValueChanged(i10);
            VerticalGridView verticalGridView = this.mColumnViews.get(i10);
            if (verticalGridView != null) {
                int minValue = i11 - this.mColumns.get(i10).getMinValue();
                if (z9) {
                    verticalGridView.setSelectedPositionSmooth(minValue);
                } else {
                    verticalGridView.setSelectedPosition(minValue);
                }
            }
        }
    }

    public void setColumns(List<PickerColumn> list) {
        List<CharSequence> list2;
        int size = this.mSeparators.size();
        List<CharSequence> list3 = this.mSeparators;
        if (size == 0) {
            throw new IllegalStateException("Separators size is: " + list3.size() + ". At least one separator must be provided");
        }
        int size2 = list3.size();
        List<CharSequence> list4 = this.mSeparators;
        if (size2 == 1) {
            CharSequence charSequence = list4.get(0);
            this.mSeparators.clear();
            this.mSeparators.add("");
            int i10 = 0;
            while (true) {
                int size3 = list.size() - 1;
                list2 = this.mSeparators;
                if (i10 >= size3) {
                    break;
                }
                list2.add(charSequence);
                i10++;
            }
            list2.add("");
        } else if (list4.size() != list.size() + 1) {
            androidx.core.view.accessibility.a.k("Separators size: ", this.mSeparators.size(), " mustequal the size of columns: ", list.size(), " + 1");
            return;
        }
        this.mColumnViews.clear();
        this.mPickerView.removeAllViews();
        ArrayList<PickerColumn> arrayList = new ArrayList<>(list);
        this.mColumns = arrayList;
        if (this.mSelectedColumn > arrayList.size() - 1) {
            this.mSelectedColumn = this.mColumns.size() - 1;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int columnsCount = getColumnsCount();
        if (!TextUtils.isEmpty(this.mSeparators.get(0))) {
            TextView textView = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
            textView.setText(this.mSeparators.get(0));
            this.mPickerView.addView(textView);
        }
        int i11 = 0;
        while (i11 < columnsCount) {
            VerticalGridView verticalGridView = (VerticalGridView) layoutInflaterFrom.inflate(R.layout.lb_picker_column, this.mPickerView, false);
            updateColumnSize(verticalGridView);
            verticalGridView.setWindowAlignment(0);
            verticalGridView.setHasFixedSize(false);
            verticalGridView.setFocusable(isActivated());
            verticalGridView.setItemViewCacheSize(0);
            this.mColumnViews.add(verticalGridView);
            this.mPickerView.addView(verticalGridView);
            int i12 = i11 + 1;
            if (!TextUtils.isEmpty(this.mSeparators.get(i12))) {
                TextView textView2 = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
                textView2.setText(this.mSeparators.get(i12));
                this.mPickerView.addView(textView2);
            }
            verticalGridView.setAdapter(new PickerScrollArrayAdapter(getPickerItemLayoutId(), getPickerItemTextViewId(), i11));
            verticalGridView.setOnChildViewHolderSelectedListener(this.mColumnChangeListener);
            i11 = i12;
        }
    }

    public void setOrAnimateAlpha(View view, boolean z9, int i10, boolean z10) {
        boolean z11 = i10 == this.mSelectedColumn || !hasFocus();
        if (z9) {
            if (z11) {
                setOrAnimateAlpha(view, z10, this.mFocusedAlpha, -1.0f, this.mDecelerateInterpolator);
                return;
            } else {
                setOrAnimateAlpha(view, z10, this.mUnfocusedAlpha, -1.0f, this.mDecelerateInterpolator);
                return;
            }
        }
        if (z11) {
            setOrAnimateAlpha(view, z10, this.mVisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        } else {
            setOrAnimateAlpha(view, z10, this.mInvisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        }
    }

    public final void setPickerItemLayoutId(@LayoutRes int i10) {
        this.mPickerItemLayoutId = i10;
    }

    public final void setPickerItemTextViewId(@IdRes int i10) {
        this.mPickerItemTextViewId = i10;
    }

    public void setSelectedColumn(int i10) {
        if (this.mSelectedColumn != i10) {
            this.mSelectedColumn = i10;
            for (int i11 = 0; i11 < this.mColumnViews.size(); i11++) {
                updateColumnAlpha(i11, true);
            }
        }
        VerticalGridView verticalGridView = this.mColumnViews.get(i10);
        if (!hasFocus() || verticalGridView.hasFocus()) {
            return;
        }
        verticalGridView.requestFocus();
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(charSequence));
    }

    public final void setSeparators(List<CharSequence> list) {
        this.mSeparators.clear();
        this.mSeparators.addAll(list);
    }

    public void setVisibleItemCount(float f) {
        if (f <= 0.0f) {
            f.a();
        } else if (this.mVisibleItems != f) {
            this.mVisibleItems = f;
            if (isActivated()) {
                return;
            }
            updateColumnSize();
        }
    }

    public void updateColumnAlpha(int i10, boolean z9) {
        VerticalGridView verticalGridView = this.mColumnViews.get(i10);
        int selectedPosition = verticalGridView.getSelectedPosition();
        int i11 = 0;
        while (i11 < verticalGridView.getAdapter().getItemCount()) {
            View viewFindViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i11);
            if (viewFindViewByPosition != null) {
                setOrAnimateAlpha(viewFindViewByPosition, selectedPosition == i11, i10, z9);
            }
            i11++;
        }
    }

    private void updateColumnSize() {
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            updateColumnSize(this.mColumnViews.get(i10));
        }
    }

    private void setOrAnimateAlpha(View view, boolean z9, float f, float f10, Interpolator interpolator) {
        view.animate().cancel();
        if (!z9) {
            view.setAlpha(f);
            return;
        }
        if (f10 >= 0.0f) {
            view.setAlpha(f10);
        }
        view.animate().alpha(f).setDuration(this.mAlphaAnimDuration).setInterpolator(interpolator).start();
    }

    public Picker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pickerStyle);
    }
}
