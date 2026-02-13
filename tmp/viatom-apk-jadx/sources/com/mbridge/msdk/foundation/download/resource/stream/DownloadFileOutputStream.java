package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface DownloadFileOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j10) throws IllegalAccessException, IOException;

    void setLength(long j10) throws IllegalAccessException, IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;
}
