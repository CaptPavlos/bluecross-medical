package androidx.datastore.preferences.core;

import g7.a;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStoreFactory$create$delegate$1 extends m implements a {
    final /* synthetic */ a $produceFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    @Override // g7.a
    public final File invoke() {
        File file = (File) this.$produceFile.invoke();
        file.getClass();
        String name = file.getName();
        name.getClass();
        int iLastIndexOf = name.lastIndexOf(46, o7.m.g0(name));
        if ((iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf + 1, name.length())).equals("preferences_pb")) {
            File absoluteFile = file.getAbsoluteFile();
            absoluteFile.getClass();
            return absoluteFile;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
