package com.mbridge.msdk.thrid.okhttp.internal.io;

import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem.1
        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public Sink appendingSink(File file) throws FileNotFoundException {
            try {
                return Okio.appendingSink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.appendingSink(file);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            f.c(file, "failed to delete ");
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                f.c(file, "not a readable directory: ");
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    f.c(file2, "failed to delete ");
                    return;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            f.d(file, "failed to rename ", file2);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public Sink sink(File file) throws FileNotFoundException {
            try {
                return Okio.sink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.sink(file);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem
        public Source source(File file) throws FileNotFoundException {
            return Okio.source(file);
        }
    };

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
