package androidx.core.graphics;

import android.graphics.Picture;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i10, int i11, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i10, i11));
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
