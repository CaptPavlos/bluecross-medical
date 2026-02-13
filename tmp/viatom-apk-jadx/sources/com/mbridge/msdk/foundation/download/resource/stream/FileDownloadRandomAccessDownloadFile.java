package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FileDownloadRandomAccessDownloadFile implements DownloadFileOutputStream {
    private final BufferedOutputStream bufferedOutputStream;
    private final FileDescriptor fileDescriptor;
    private final RandomAccessFile randomAccess;

    public FileDownloadRandomAccessDownloadFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.randomAccess = randomAccessFile;
        this.fileDescriptor = randomAccessFile.getFD();
        this.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public static DownloadFileOutputStream create(File file) throws IOException {
        return new FileDownloadRandomAccessDownloadFile(file);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void close() throws IOException {
        this.bufferedOutputStream.close();
        this.randomAccess.close();
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void flushAndSync() throws IOException {
        this.bufferedOutputStream.flush();
        this.fileDescriptor.sync();
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void seek(long j10) throws IOException {
        this.randomAccess.seek(j10);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void setLength(long j10) throws IOException {
        this.randomAccess.setLength(j10);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.bufferedOutputStream.write(bArr, i10, i11);
    }
}
