package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class RecyclerViewParallax extends Parallax<ChildPositionProperty> {
    boolean mIsVertical;
    RecyclerView mRecylerView;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.leanback.widget.RecyclerViewParallax.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            RecyclerViewParallax.this.updateValues();
        }
    };
    View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.leanback.widget.RecyclerViewParallax.2
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            RecyclerViewParallax.this.updateValues();
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ChildPositionProperty extends Parallax.IntProperty {
        int mAdapterPosition;
        float mFraction;
        int mOffset;
        int mViewId;

        public ChildPositionProperty(String str, int i10) {
            super(str, i10);
        }

        public ChildPositionProperty adapterPosition(int i10) {
            this.mAdapterPosition = i10;
            return this;
        }

        public ChildPositionProperty fraction(float f) {
            this.mFraction = f;
            return this;
        }

        public int getAdapterPosition() {
            return this.mAdapterPosition;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int getViewId() {
            return this.mViewId;
        }

        public ChildPositionProperty offset(int i10) {
            this.mOffset = i10;
            return this;
        }

        public void updateValue(RecyclerViewParallax recyclerViewParallax) {
            RecyclerView recyclerView = recyclerViewParallax.mRecylerView;
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView == null ? null : recyclerView.findViewHolderForAdapterPosition(this.mAdapterPosition);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                if (recyclerView == null || recyclerView.getLayoutManager().getChildCount() == 0) {
                    recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MAX_VALUE);
                    return;
                } else if (recyclerView.findContainingViewHolder(recyclerView.getLayoutManager().getChildAt(0)).getAbsoluteAdapterPosition() < this.mAdapterPosition) {
                    recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MAX_VALUE);
                    return;
                } else {
                    recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MIN_VALUE);
                    return;
                }
            }
            View viewFindViewById = viewHolderFindViewHolderForAdapterPosition.itemView.findViewById(this.mViewId);
            if (viewFindViewById == null) {
                return;
            }
            Rect rect = new Rect(0, 0, viewFindViewById.getWidth(), viewFindViewById.getHeight());
            recyclerView.offsetDescendantRectToMyCoords(viewFindViewById, rect);
            float f = 0.0f;
            float translationY = 0.0f;
            while (viewFindViewById != recyclerView && viewFindViewById != null) {
                if (viewFindViewById.getParent() != recyclerView || !recyclerView.isAnimating()) {
                    float translationX = viewFindViewById.getTranslationX() + f;
                    translationY = viewFindViewById.getTranslationY() + translationY;
                    f = translationX;
                }
                viewFindViewById = (View) viewFindViewById.getParent();
            }
            rect.offset((int) f, (int) translationY);
            if (recyclerViewParallax.mIsVertical) {
                recyclerViewParallax.setIntPropertyValue(getIndex(), rect.top + this.mOffset + ((int) (this.mFraction * rect.height())));
            } else {
                recyclerViewParallax.setIntPropertyValue(getIndex(), rect.left + this.mOffset + ((int) (this.mFraction * rect.width())));
            }
        }

        public ChildPositionProperty viewId(int i10) {
            this.mViewId = i10;
            return this;
        }
    }

    @Override // androidx.leanback.widget.Parallax
    public ChildPositionProperty createProperty(String str, int i10) {
        return new ChildPositionProperty(str, i10);
    }

    @Override // androidx.leanback.widget.Parallax
    public float getMaxValue() {
        if (this.mRecylerView == null) {
            return 0.0f;
        }
        return this.mIsVertical ? r0.getHeight() : r0.getWidth();
    }

    public RecyclerView getRecyclerView() {
        return this.mRecylerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecylerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.mOnScrollListener);
            this.mRecylerView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        this.mRecylerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.getLayoutManager();
            this.mIsVertical = RecyclerView.LayoutManager.getProperties(this.mRecylerView.getContext(), null, 0, 0).orientation == 1;
            this.mRecylerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecylerView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    @Override // androidx.leanback.widget.Parallax
    public void updateValues() {
        Iterator<ChildPositionProperty> it = getProperties().iterator();
        while (it.hasNext()) {
            it.next().updateValue(this);
        }
        super.updateValues();
    }
}
