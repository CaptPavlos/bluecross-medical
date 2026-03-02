package androidx.leanback.widget;

import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ItemAlignmentFacet {
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private ItemAlignmentDef[] mAlignmentDefs = {new ItemAlignmentDef()};

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ItemAlignmentDef {
        private boolean mAlignToBaseline;
        int mViewId = -1;
        int mFocusViewId = -1;
        int mOffset = 0;
        float mOffsetPercent = 50.0f;
        boolean mOffsetWithPadding = false;

        public final int getItemAlignmentFocusViewId() {
            int i10 = this.mFocusViewId;
            return i10 != -1 ? i10 : this.mViewId;
        }

        public final int getItemAlignmentOffset() {
            return this.mOffset;
        }

        public final float getItemAlignmentOffsetPercent() {
            return this.mOffsetPercent;
        }

        public final int getItemAlignmentViewId() {
            return this.mViewId;
        }

        public boolean isAlignedToTextViewBaseLine() {
            return this.mAlignToBaseline;
        }

        public final boolean isItemAlignmentOffsetWithPadding() {
            return this.mOffsetWithPadding;
        }

        public final void setAlignedToTextViewBaseline(boolean z9) {
            this.mAlignToBaseline = z9;
        }

        public final void setItemAlignmentFocusViewId(int i10) {
            this.mFocusViewId = i10;
        }

        public final void setItemAlignmentOffset(int i10) {
            this.mOffset = i10;
        }

        public final void setItemAlignmentOffsetPercent(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                f.a();
            } else {
                this.mOffsetPercent = f;
            }
        }

        public final void setItemAlignmentOffsetWithPadding(boolean z9) {
            this.mOffsetWithPadding = z9;
        }

        public final void setItemAlignmentViewId(int i10) {
            this.mViewId = i10;
        }
    }

    public ItemAlignmentDef[] getAlignmentDefs() {
        return this.mAlignmentDefs;
    }

    public boolean isMultiAlignment() {
        return this.mAlignmentDefs.length > 1;
    }

    public void setAlignmentDefs(ItemAlignmentDef[] itemAlignmentDefArr) {
        if (itemAlignmentDefArr == null || itemAlignmentDefArr.length < 1) {
            f.a();
        } else {
            this.mAlignmentDefs = itemAlignmentDefArr;
        }
    }
}
