package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.RecyclerViewParallax;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class DetailsParallax extends RecyclerViewParallax {
    final Parallax.IntProperty mFrameBottom;
    final Parallax.IntProperty mFrameTop;

    public DetailsParallax() {
        RecyclerViewParallax.ChildPositionProperty childPositionPropertyAdapterPosition = addProperty("overviewRowTop").adapterPosition(0);
        int i10 = androidx.leanback.R.id.details_frame;
        this.mFrameTop = childPositionPropertyAdapterPosition.viewId(i10);
        this.mFrameBottom = addProperty("overviewRowBottom").adapterPosition(0).viewId(i10).fraction(1.0f);
    }

    public Parallax.IntProperty getOverviewRowBottom() {
        return this.mFrameBottom;
    }

    public Parallax.IntProperty getOverviewRowTop() {
        return this.mFrameTop;
    }
}
