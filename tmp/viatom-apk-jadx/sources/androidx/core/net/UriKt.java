package androidx.core.net;

import android.net.Uri;
import androidx.constraintlayout.core.state.b;
import java.io.File;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        if (!l.a(uri.getScheme(), "file")) {
            b.i(uri, "Uri lacks 'file' scheme: ");
            return null;
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        b.i(uri, "Uri path is null: ");
        return null;
    }

    public static final Uri toUri(String str) {
        return Uri.parse(str);
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile(file);
    }
}
