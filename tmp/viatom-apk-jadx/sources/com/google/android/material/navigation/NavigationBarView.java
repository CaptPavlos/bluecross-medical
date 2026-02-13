package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int ACTIVE_INDICATOR_WIDTH_MATCH_PARENT = -1;
    public static final int ACTIVE_INDICATOR_WIDTH_WRAP_CONTENT = -2;
    public static final int ITEM_GRAVITY_CENTER = 17;
    public static final int ITEM_GRAVITY_START_CENTER = 8388627;
    public static final int ITEM_GRAVITY_TOP_CENTER = 49;
    public static final int ITEM_ICON_GRAVITY_START = 1;
    public static final int ITEM_ICON_GRAVITY_TOP = 0;
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;

    @NonNull
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;

    @NonNull
    private final NavigationBarMenuView menuView;

    @NonNull
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ItemGravity {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ItemIconGravity {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationBarView(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, @androidx.annotation.AttrRes int r13, @androidx.annotation.StyleRes int r14) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarView.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z9) {
        this.menuView.setMeasurePaddingFromLabelBaseline(z9);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView createNavigationBarMenuView(@NonNull Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.menuView.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public BadgeDrawable getBadge(int i10) {
        return this.menuView.getBadge(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceActive() {
        return this.menuView.getHorizontalItemTextAppearanceActive();
    }

    @StyleRes
    public int getHorizontalItemTextAppearanceInactive() {
        return this.menuView.getHorizontalItemTextAppearanceInactive();
    }

    @Px
    public int getIconLabelHorizontalSpacing() {
        return this.menuView.getIconLabelHorizontalSpacing();
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorExpandedHeight() {
        return this.menuView.getItemActiveIndicatorExpandedHeight();
    }

    @Px
    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    @Px
    public int getItemActiveIndicatorExpandedWidth() {
        return this.menuView.getItemActiveIndicatorExpandedWidth();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.menuView.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.menuView.getItemIconGravity();
    }

    @Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelMaxLines(int i10) {
        return this.menuView.getLabelMaxLines();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.menuView;
    }

    @NonNull
    public ViewGroup getMenuViewGroup() {
        return this.menuView;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int i10) {
        return this.menuView.getOrCreateBadge(i10);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.menuView.getScaleLabelTextWithFont();
    }

    @IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int i10) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i10, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    public boolean isSubMenuSupported() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuPresenterState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeBadge(int i10) {
        this.menuView.removeBadge(i10);
    }

    public void setActiveIndicatorLabelPadding(@Px int i10) {
        this.menuView.setActiveIndicatorLabelPadding(i10);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setHorizontalItemTextAppearanceActive(@StyleRes int i10) {
        this.menuView.setHorizontalItemTextAppearanceActive(i10);
    }

    public void setHorizontalItemTextAppearanceInactive(@StyleRes int i10) {
        this.menuView.setHorizontalItemTextAppearanceInactive(i10);
    }

    public void setIconLabelHorizontalSpacing(@Px int i10) {
        this.menuView.setIconLabelHorizontalSpacing(i10);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z9) {
        this.menuView.setItemActiveIndicatorEnabled(z9);
    }

    public void setItemActiveIndicatorExpandedHeight(@Px int i10) {
        this.menuView.setItemActiveIndicatorExpandedHeight(i10);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(@Px int i10) {
        this.menuView.setItemActiveIndicatorExpandedMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorExpandedPadding(@Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        this.menuView.setItemActiveIndicatorExpandedPadding(i10, i11, i12, i13);
    }

    public void setItemActiveIndicatorExpandedWidth(@Px int i10) {
        this.menuView.setItemActiveIndicatorExpandedWidth(i10);
    }

    public void setItemActiveIndicatorHeight(@Px int i10) {
        this.menuView.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i10) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.menuView.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(@Px int i10) {
        this.menuView.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.menuView.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i10) {
        this.menuView.setItemBackgroundRes(i10);
    }

    public void setItemGravity(int i10) {
        if (this.menuView.getItemGravity() != i10) {
            this.menuView.setItemGravity(i10);
            this.presenter.updateMenuView(false);
        }
    }

    public void setItemIconGravity(int i10) {
        if (this.menuView.getItemIconGravity() != i10) {
            this.menuView.setItemIconGravity(i10);
            this.presenter.updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i10) {
        this.menuView.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(@DimenRes int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i10, @Nullable View.OnTouchListener onTouchListener) {
        this.menuView.setItemOnTouchListener(i10, onTouchListener);
    }

    public void setItemPaddingBottom(@Px int i10) {
        this.menuView.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(@Px int i10) {
        this.menuView.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@StyleRes int i10) {
        this.menuView.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z9) {
        this.menuView.setItemTextAppearanceActiveBoldEnabled(z9);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i10) {
        this.menuView.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z9) {
        this.menuView.setLabelFontScalingEnabled(z9);
    }

    public void setLabelMaxLines(int i10) {
        this.menuView.setLabelMaxLines(i10);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.menuView.getLabelVisibilityMode() != i10) {
            this.menuView.setLabelVisibilityMode(i10);
            this.presenter.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener onItemReselectedListener) {
        this.reselectedListener = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.selectedListener = onItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i10) {
        MenuItem menuItemFindItem = this.menu.findItem(i10);
        if (menuItemFindItem != null) {
            boolean zPerformItemAction = this.menu.performItemAction(menuItemFindItem, this.presenter, 0);
            if (menuItemFindItem.isCheckable()) {
                if (!zPerformItemAction || menuItemFindItem.isChecked()) {
                    this.menuView.setCheckedItem(menuItemFindItem);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldAddMenuView() {
        return false;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarView.SavedState.1
            @Override // android.os.Parcelable.Creator
            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        };

        @Nullable
        Bundle menuPresenterState;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        private void readFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.menuPresenterState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
