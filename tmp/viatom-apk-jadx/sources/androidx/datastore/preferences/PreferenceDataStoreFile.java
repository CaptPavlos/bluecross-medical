package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStoreFile {
    public static final File preferencesDataStoreFile(Context context, String str) {
        context.getClass();
        str.getClass();
        return DataStoreFile.dataStoreFile(context, str.concat(".preferences_pb"));
    }
}
