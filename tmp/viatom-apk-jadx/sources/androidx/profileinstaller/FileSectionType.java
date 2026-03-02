package androidx.profileinstaller;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j10) {
        this.mValue = j10;
    }

    public static FileSectionType fromValue(long j10) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i10 = 0; i10 < fileSectionTypeArrValues.length; i10++) {
            if (fileSectionTypeArrValues[i10].getValue() == j10) {
                return fileSectionTypeArrValues[i10];
            }
        }
        com.google.gson.internal.a.n(a3.a.h(j10, "Unsupported FileSection Type "));
        return null;
    }

    public long getValue() {
        return this.mValue;
    }
}
