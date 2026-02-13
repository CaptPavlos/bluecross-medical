package androidx.datastore.core;

import android.os.Build;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FileMoves_androidKt {
    public static final boolean atomicMoveTo(File file, File file2) {
        file.getClass();
        file2.getClass();
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.INSTANCE.move(file, file2) : file.renameTo(file2);
    }
}
