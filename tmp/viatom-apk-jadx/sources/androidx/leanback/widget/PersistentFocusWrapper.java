package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class PersistentFocusWrapper extends FrameLayout {
    private static final boolean DEBUG = false;
    private static final String TAG = "PersistentFocusWrapper";
    private boolean mPersistFocusVertical;
    private int mSelectedPosition;

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedPosition = -1;
        this.mPersistFocusVertical = true;
    }

    private boolean shouldPersistFocusFromDirection(int i10) {
        boolean z9 = this.mPersistFocusVertical;
        if (z9 && (i10 == 33 || i10 == 130)) {
            return true;
        }
        if (z9) {
            return false;
        }
        return i10 == 17 || i10 == 66;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (hasFocus() || getGrandChildCount() == 0 || !shouldPersistFocusFromDirection(i10)) {
            super.addFocusables(arrayList, i10, i11);
        } else {
            arrayList.add(this);
        }
    }

    public void clearSelection() {
        this.mSelectedPosition = -1;
        if (hasFocus()) {
            clearFocus();
        }
    }

    public int getGrandChildCount() {
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup == null) {
            return 0;
        }
        return viewGroup.getChildCount();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mSelectedPosition = savedState.mSelectedPosition;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mSelectedPosition = this.mSelectedPosition;
        return savedState;
    }

    public void persistFocusHorizontal() {
        this.mPersistFocusVertical = false;
    }

    public void persistFocusVertical() {
        this.mPersistFocusVertical = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        while (view2 != null && view2.getParent() != view) {
            view2 = (View) view2.getParent();
        }
        this.mSelectedPosition = view2 == null ? -1 : ((ViewGroup) view).indexOfChild(view2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        int i11;
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup == null || (i11 = this.mSelectedPosition) < 0 || i11 >= getGrandChildCount() || !viewGroup.getChildAt(this.mSelectedPosition).requestFocus(i10, rect)) {
            return super.requestFocus(i10, rect);
        }
        return true;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.leanback.widget.PersistentFocusWrapper.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        int mSelectedPosition;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mSelectedPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mSelectedPosition);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mSelectedPosition = -1;
        this.mPersistFocusVertical = true;
    }
}
