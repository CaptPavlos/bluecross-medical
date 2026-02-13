package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.leanback.widget.SearchOrbView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class TitleViewAdapter {
    public static final int BRANDING_VIEW_VISIBLE = 2;
    public static final int FULL_VIEW_VISIBLE = 6;
    public static final int SEARCH_VIEW_VISIBLE = 4;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Provider {
        TitleViewAdapter getTitleViewAdapter();
    }

    public Drawable getBadgeDrawable() {
        return null;
    }

    public SearchOrbView.Colors getSearchAffordanceColors() {
        return null;
    }

    public abstract View getSearchAffordanceView();

    public CharSequence getTitle() {
        return null;
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        View searchAffordanceView = getSearchAffordanceView();
        if (searchAffordanceView != null) {
            searchAffordanceView.setOnClickListener(onClickListener);
        }
    }

    public void setAnimationEnabled(boolean z9) {
    }

    public void setBadgeDrawable(Drawable drawable) {
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void updateComponentsVisibility(int i10) {
    }
}
