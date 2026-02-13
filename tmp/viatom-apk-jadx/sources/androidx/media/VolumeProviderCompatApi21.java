package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Delegate {
        void onAdjustVolume(int i10);

        void onSetVolumeTo(int i10);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i10, int i11, int i12, final Delegate delegate) {
        return new VolumeProvider(i10, i11, i12) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i13) {
                delegate.onAdjustVolume(i13);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i13) {
                delegate.onSetVolumeTo(i13);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i10) {
        ((VolumeProvider) obj).setCurrentVolume(i10);
    }
}
