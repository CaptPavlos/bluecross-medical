package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.layout.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    private View mViewInRemoveView;
    private int mRemoveStatus = 0;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i10) {
            if (i10 < 64) {
                this.mData &= ~(1 << i10);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i10 - 64);
            }
        }

        public int countOnesBefore(int i10) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                long j10 = this.mData;
                return i10 >= 64 ? Long.bitCount(j10) : Long.bitCount(((1 << i10) - 1) & j10);
            }
            if (i10 < 64) {
                return Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(i10 - 64);
        }

        public boolean get(int i10) {
            if (i10 < 64) {
                return (this.mData & (1 << i10)) != 0;
            }
            ensureNext();
            return this.mNext.get(i10 - 64);
        }

        public void insert(int i10, boolean z9) {
            if (i10 >= 64) {
                ensureNext();
                this.mNext.insert(i10 - 64, z9);
                return;
            }
            long j10 = this.mData;
            boolean z10 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.mData = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z9) {
                set(i10);
            } else {
                clear(i10);
            }
            if (z10 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z10);
            }
        }

        public boolean remove(int i10) {
            if (i10 >= 64) {
                ensureNext();
                return this.mNext.remove(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.mData;
            boolean z9 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.mData = j12;
            long j13 = j10 - 1;
            this.mData = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z9;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i10) {
            if (i10 < 64) {
                this.mData |= 1 << i10;
            } else {
                ensureNext();
                this.mNext.set(i10 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Callback {
        void addView(View view, int i10);

        void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i10);

        View getChildAt(int i10);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i10);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int iCountOnesBefore = i10 - (i11 - this.mBucket.countOnesBefore(i11));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iCountOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, int i10, boolean z9) {
        int childCount = i10 < 0 ? this.mCallback.getChildCount() : getOffset(i10);
        this.mBucket.insert(childCount, z9);
        if (z9) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    public void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z9) {
        int childCount = i10 < 0 ? this.mCallback.getChildCount() : getOffset(i10);
        this.mBucket.insert(childCount, z9);
        if (z9) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i10) {
        int offset = getOffset(i10);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i10) {
        int size = this.mHiddenViews.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.mHiddenViews.get(i11);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i10 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i10) {
        return this.mCallback.getChildAt(getOffset(i10));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i10) {
        return this.mCallback.getChildAt(i10);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            c.j(view, "view is not a child, cannot hide ");
        } else {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        }
    }

    public int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int size = this.mHiddenViews.size();
        while (true) {
            size--;
            Callback callback = this.mCallback;
            if (size < 0) {
                callback.removeAllViews();
                return;
            } else {
                callback.onLeftHiddenState(this.mHiddenViews.get(size));
                this.mHiddenViews.remove(size);
            }
        }
    }

    public void removeView(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 == 1) {
            c.g("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i10 == 2) {
            c.g("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            this.mRemoveStatus = 1;
            this.mViewInRemoveView = view;
            int iIndexOfChild = this.mCallback.indexOfChild(view);
            if (iIndexOfChild < 0) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                return;
            }
            if (this.mBucket.remove(iIndexOfChild)) {
                unhideViewInternal(view);
            }
            this.mCallback.removeViewAt(iIndexOfChild);
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        } catch (Throwable th) {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
            throw th;
        }
    }

    public void removeViewAt(int i10) {
        int i11 = this.mRemoveStatus;
        if (i11 == 1) {
            c.g("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i11 == 2) {
            c.g("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            int offset = getOffset(i10);
            View childAt = this.mCallback.getChildAt(offset);
            if (childAt == null) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                return;
            }
            this.mRemoveStatus = 1;
            this.mViewInRemoveView = childAt;
            if (this.mBucket.remove(offset)) {
                unhideViewInternal(childAt);
            }
            this.mCallback.removeViewAt(offset);
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        } catch (Throwable th) {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
            throw th;
        }
    }

    public boolean removeViewIfHidden(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            c.g("Cannot call removeViewIfHidden within removeView(At) for a different view");
            return false;
        }
        if (i10 == 2) {
            c.g("Cannot call removeViewIfHidden within removeViewIfHidden");
            return false;
        }
        try {
            this.mRemoveStatus = 2;
            int iIndexOfChild = this.mCallback.indexOfChild(view);
            if (iIndexOfChild == -1) {
                unhideViewInternal(view);
                return true;
            }
            if (!this.mBucket.get(iIndexOfChild)) {
                return false;
            }
            this.mBucket.remove(iIndexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(iIndexOfChild);
            return true;
        } finally {
            this.mRemoveStatus = 0;
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            c.j(view, "view is not a child, cannot hide ");
        } else if (!this.mBucket.get(iIndexOfChild)) {
            a.i(view, "trying to unhide a view that was not hidden");
        } else {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        }
    }

    public void addView(View view, boolean z9) {
        addView(view, -1, z9);
    }
}
