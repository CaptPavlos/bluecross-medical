package androidx.leanback.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ListRowHoverCardView extends LinearLayout {
    private final TextView mDescriptionView;
    private final TextView mTitleView;

    public ListRowHoverCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_list_row_hovercard, this);
        this.mTitleView = (TextView) findViewById(androidx.leanback.R.id.title);
        this.mDescriptionView = (TextView) findViewById(androidx.leanback.R.id.description);
    }

    public final CharSequence getDescription() {
        return this.mDescriptionView.getText();
    }

    public final CharSequence getTitle() {
        return this.mTitleView.getText();
    }

    public final void setDescription(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.mDescriptionView;
        if (zIsEmpty) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            this.mDescriptionView.setVisibility(0);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.mTitleView;
        if (zIsEmpty) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            this.mTitleView.setVisibility(0);
        }
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListRowHoverCardView(Context context) {
        this(context, null);
    }
}
