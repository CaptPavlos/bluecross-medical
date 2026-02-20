package w8;

import java.io.File;
import java.io.IOException;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13568a = new a();

    public final void a(File file) throws IOException {
        if (file.delete() || !file.exists()) {
            return;
        }
        f.c(file, "failed to delete ");
    }

    public final void b(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            f.c(file, "not a readable directory: ");
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                f.c(file2, "failed to delete ");
                return;
            }
        }
    }

    public final void c(File file, File file2) throws IOException {
        a(file2);
        if (file.renameTo(file2)) {
            return;
        }
        f.d(file, "failed to rename ", file2);
    }
}
