package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Row {
    private static final int FLAG_ID_USE_HEADER = 1;
    private static final int FLAG_ID_USE_ID = 0;
    private static final int FLAG_ID_USE_MASK = 1;
    private HeaderItem mHeaderItem;
    private int mFlags = 1;
    private long mId = -1;

    public Row(long j10, HeaderItem headerItem) {
        setId(j10);
        setHeaderItem(headerItem);
    }

    public final int getFlags() {
        return this.mFlags;
    }

    public final HeaderItem getHeaderItem() {
        return this.mHeaderItem;
    }

    public final long getId() {
        if ((this.mFlags & 1) != 1) {
            return this.mId;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem != null) {
            return headerItem.getId();
        }
        return -1L;
    }

    public boolean isRenderedAsRowView() {
        return true;
    }

    public final void setFlags(int i10, int i11) {
        this.mFlags = (i10 & i11) | (this.mFlags & (~i11));
    }

    public final void setHeaderItem(HeaderItem headerItem) {
        this.mHeaderItem = headerItem;
    }

    public final void setId(long j10) {
        this.mId = j10;
        setFlags(0, 1);
    }

    public Row(HeaderItem headerItem) {
        setHeaderItem(headerItem);
    }

    public Row() {
    }
}
