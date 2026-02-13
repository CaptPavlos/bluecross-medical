package androidx.datastore;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreFile {
    public static final File dataStoreFile(Context context, String str) {
        context.getClass();
        str.getClass();
        return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(str));
    }
}
