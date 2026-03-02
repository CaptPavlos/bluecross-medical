package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.google.gson.internal.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        a.n("file == null");
        return null;
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.mbridge.msdk.thrid.okio.Okio.3
            @Override // com.mbridge.msdk.thrid.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink
            public void write(Buffer buffer, long j10) throws IOException {
                buffer.skip(j10);
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            a.n("socket == null");
            return null;
        }
        if (socket.getOutputStream() != null) {
            AsyncTimeout asyncTimeoutTimeout = timeout(socket);
            return asyncTimeoutTimeout.sink(sink(socket.getOutputStream(), asyncTimeoutTimeout));
        }
        a.m("socket's output stream == null");
        return null;
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            a.n("socket == null");
            return null;
        }
        if (socket.getInputStream() != null) {
            AsyncTimeout asyncTimeoutTimeout = timeout(socket);
            return asyncTimeoutTimeout.source(source(socket.getInputStream(), asyncTimeoutTimeout));
        }
        a.m("socket's input stream == null");
        return null;
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: com.mbridge.msdk.thrid.okio.Okio.4
            @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
            public IOException newTimeoutException(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
            public void timedOut() throws IOException {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!Okio.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (Exception e3) {
                    Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
                }
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            a.n("out == null");
            return null;
        }
        if (timeout != null) {
            return new Sink() { // from class: com.mbridge.msdk.thrid.okio.Okio.1
                @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink
                public void write(Buffer buffer, long j10) throws IOException {
                    Util.checkOffsetAndCount(buffer.size, 0L, j10);
                    while (j10 > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.head;
                        int iMin = (int) Math.min(j10, segment.limit - segment.pos);
                        outputStream.write(segment.data, segment.pos, iMin);
                        int i10 = segment.pos + iMin;
                        segment.pos = i10;
                        long j11 = iMin;
                        j10 -= j11;
                        buffer.size -= j11;
                        if (i10 == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        }
        a.n("timeout == null");
        return null;
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            a.n("in == null");
            return null;
        }
        if (timeout != null) {
            return new Source() { // from class: com.mbridge.msdk.thrid.okio.Okio.2
                @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.mbridge.msdk.thrid.okio.Source
                public long read(Buffer buffer, long j10) throws IOException {
                    if (j10 < 0) {
                        a.n(a3.a.h(j10, "byteCount < 0: "));
                        return 0L;
                    }
                    if (j10 == 0) {
                        return 0L;
                    }
                    try {
                        timeout.throwIfReached();
                        Segment segmentWritableSegment = buffer.writableSegment(1);
                        int i10 = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j10, 8192 - segmentWritableSegment.limit));
                        if (i10 == -1) {
                            return -1L;
                        }
                        segmentWritableSegment.limit += i10;
                        long j11 = i10;
                        buffer.size += j11;
                        return j11;
                    } catch (AssertionError e) {
                        if (Okio.isAndroidGetsocknameError(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    }
                }

                @Override // com.mbridge.msdk.thrid.okio.Source
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        a.n("timeout == null");
        return null;
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        a.n("file == null");
        return null;
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        a.n("file == null");
        return null;
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        a.n("path == null");
        return null;
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        a.n("path == null");
        return null;
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }
}
