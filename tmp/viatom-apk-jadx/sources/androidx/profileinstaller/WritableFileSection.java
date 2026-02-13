package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i10, @NonNull byte[] bArr, boolean z9) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i10;
        this.mContents = bArr;
        this.mNeedsCompression = z9;
    }
}
