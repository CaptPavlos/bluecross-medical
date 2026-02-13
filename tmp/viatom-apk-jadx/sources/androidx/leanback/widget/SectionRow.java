package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SectionRow extends Row {
    public SectionRow(long j10, String str) {
        super(new HeaderItem(j10, str));
    }

    @Override // androidx.leanback.widget.Row
    public final boolean isRenderedAsRowView() {
        return false;
    }

    public SectionRow(HeaderItem headerItem) {
        super(headerItem);
    }

    public SectionRow(String str) {
        super(new HeaderItem(str));
    }
}
