package android.support.v4.graphics.drawable;

import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(versionedParcel);
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat, versionedParcel);
    }
}
