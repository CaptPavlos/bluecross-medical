package androidx.leanback.widget;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface MultiActionsProvider {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MultiAction {
        private Drawable[] mDrawables;
        private long mId;
        private int mIndex = 0;

        public MultiAction(long j10) {
            this.mId = j10;
        }

        public Drawable getCurrentDrawable() {
            return this.mDrawables[this.mIndex];
        }

        public Drawable[] getDrawables() {
            return this.mDrawables;
        }

        public long getId() {
            return this.mId;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void incrementIndex() {
            int i10 = this.mIndex;
            setIndex(i10 < this.mDrawables.length + (-1) ? i10 + 1 : 0);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.mDrawables = drawableArr;
            if (this.mIndex > drawableArr.length - 1) {
                this.mIndex = drawableArr.length - 1;
            }
        }

        public void setIndex(int i10) {
            this.mIndex = i10;
        }
    }

    MultiAction[] getActions();
}
