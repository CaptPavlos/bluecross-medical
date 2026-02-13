package c2;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1633a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f1633a) {
            case 0:
                return str.startsWith(NotificationCompat.CATEGORY_EVENT);
            case 1:
                return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
            case 2:
                return str.startsWith("aqs.");
            default:
                return str.startsWith(".ae");
        }
    }
}
