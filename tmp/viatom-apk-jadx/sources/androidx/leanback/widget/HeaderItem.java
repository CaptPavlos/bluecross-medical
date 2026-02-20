package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class HeaderItem {
    private CharSequence mContentDescription;
    private CharSequence mDescription;
    private final long mId;
    private final String mName;

    public HeaderItem(long j10, String str) {
        this.mId = j10;
        this.mName = str;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public final long getId() {
        return this.mId;
    }

    public final String getName() {
        return this.mName;
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
    }

    public void setDescription(CharSequence charSequence) {
        this.mDescription = charSequence;
    }

    public HeaderItem(String str) {
        this(-1L, str);
    }
}
