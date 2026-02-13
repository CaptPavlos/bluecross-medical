package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleViewAdapter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class TitleView extends FrameLayout implements TitleViewAdapter.Provider {
    private int flags;
    private ImageView mBadgeView;
    private boolean mHasSearchListener;
    private SearchOrbView mSearchOrbView;
    private TextView mTextView;
    private final TitleViewAdapter mTitleViewAdapter;

    public TitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.flags = 6;
        this.mHasSearchListener = false;
        this.mTitleViewAdapter = new TitleViewAdapter() { // from class: androidx.leanback.widget.TitleView.1
            @Override // androidx.leanback.widget.TitleViewAdapter
            public Drawable getBadgeDrawable() {
                return TitleView.this.getBadgeDrawable();
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public SearchOrbView.Colors getSearchAffordanceColors() {
                return TitleView.this.getSearchAffordanceColors();
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public View getSearchAffordanceView() {
                return TitleView.this.getSearchAffordanceView();
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public CharSequence getTitle() {
                return TitleView.this.getTitle();
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setAnimationEnabled(boolean z9) {
                TitleView.this.enableAnimation(z9);
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setBadgeDrawable(Drawable drawable) {
                TitleView.this.setBadgeDrawable(drawable);
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
                TitleView.this.setOnSearchClickedListener(onClickListener);
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
                TitleView.this.setSearchAffordanceColors(colors);
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setTitle(CharSequence charSequence) {
                TitleView.this.setTitle(charSequence);
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void updateComponentsVisibility(int i11) {
                TitleView.this.updateComponentsVisibility(i11);
            }
        };
        View viewInflate = LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_title_view, this);
        this.mBadgeView = (ImageView) viewInflate.findViewById(androidx.leanback.R.id.title_badge);
        this.mTextView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.title_text);
        this.mSearchOrbView = (SearchOrbView) viewInflate.findViewById(androidx.leanback.R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void updateBadgeVisibility() {
        Drawable drawable = this.mBadgeView.getDrawable();
        ImageView imageView = this.mBadgeView;
        if (drawable != null) {
            imageView.setVisibility(0);
            this.mTextView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            this.mTextView.setVisibility(0);
        }
    }

    private void updateSearchOrbViewVisiblity() {
        int i10 = 4;
        if (this.mHasSearchListener && (this.flags & 4) == 4) {
            i10 = 0;
        }
        this.mSearchOrbView.setVisibility(i10);
    }

    public void enableAnimation(boolean z9) {
        SearchOrbView searchOrbView = this.mSearchOrbView;
        searchOrbView.enableOrbColorAnimation(z9 && searchOrbView.hasFocus());
    }

    public Drawable getBadgeDrawable() {
        return this.mBadgeView.getDrawable();
    }

    public SearchOrbView.Colors getSearchAffordanceColors() {
        return this.mSearchOrbView.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.mSearchOrbView;
    }

    public CharSequence getTitle() {
        return this.mTextView.getText();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter.Provider
    public TitleViewAdapter getTitleViewAdapter() {
        return this.mTitleViewAdapter;
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeView.setImageDrawable(drawable);
        updateBadgeVisibility();
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.mHasSearchListener = onClickListener != null;
        this.mSearchOrbView.setOnOrbClickedListener(onClickListener);
        updateSearchOrbViewVisiblity();
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        this.mSearchOrbView.setOrbColors(colors);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        updateBadgeVisibility();
    }

    public void updateComponentsVisibility(int i10) {
        this.flags = i10;
        if ((i10 & 2) == 2) {
            updateBadgeVisibility();
        } else {
            this.mBadgeView.setVisibility(8);
            this.mTextView.setVisibility(8);
        }
        updateSearchOrbViewVisiblity();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.browseTitleViewStyle);
    }

    public TitleView(Context context) {
        this(context, null);
    }
}
