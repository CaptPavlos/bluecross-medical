package androidx.sqlite.db;

import java.io.Closeable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i10, byte[] bArr);

    void bindDouble(int i10, double d8);

    void bindLong(int i10, long j10);

    void bindNull(int i10);

    void bindString(int i10, String str);

    void clearBindings();
}
