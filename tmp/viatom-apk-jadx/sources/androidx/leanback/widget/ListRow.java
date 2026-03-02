package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ListRow extends Row {
    private final ObjectAdapter mAdapter;
    private CharSequence mContentDescription;

    public ListRow(HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(headerItem);
        this.mAdapter = objectAdapter;
        verify();
    }

    private void verify() {
        if (this.mAdapter != null) {
            return;
        }
        com.google.gson.internal.a.n("ObjectAdapter cannot be null");
    }

    public final ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public CharSequence getContentDescription() {
        CharSequence charSequence = this.mContentDescription;
        if (charSequence != null) {
            return charSequence;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem == null) {
            return null;
        }
        CharSequence contentDescription = headerItem.getContentDescription();
        return contentDescription != null ? contentDescription : headerItem.getName();
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
    }

    public ListRow(long j10, HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(j10, headerItem);
        this.mAdapter = objectAdapter;
        verify();
    }

    public ListRow(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        verify();
    }
}
