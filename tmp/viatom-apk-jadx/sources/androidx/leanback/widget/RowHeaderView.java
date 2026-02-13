package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public final class RowHeaderView extends TextView {
    public RowHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.rowHeaderStyle);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public RowHeaderView(Context context) {
        this(context, null);
    }

    public RowHeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
