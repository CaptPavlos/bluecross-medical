package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Handler {
        void ackSettings();

        void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10);

        void data(boolean z9, int i10, BufferedSource bufferedSource, int i11) throws IOException;

        void goAway(int i10, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z9, int i10, int i11, List<Header> list);

        void ping(boolean z9, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z9);

        void pushPromise(int i10, int i11, List<Header> list) throws IOException;

        void rstStream(int i10, ErrorCode errorCode);

        void settings(boolean z9, Settings settings);

        void windowUpdate(int i10, long j10);
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z9) {
        this.source = bufferedSource;
        this.client = z9;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i10, byte b10, short s9) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s9 <= i10) {
            return (short) (i10 - s9);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s9), Integer.valueOf(i10));
    }

    private void readData(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z9 = (b10 & 1) != 0;
        if ((b10 & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s9 = (b10 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z9, i11, this.source, lengthWithoutPadding(i10, b10, s9));
        this.source.skip(s9);
    }

    private void readGoAway(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i10 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i12 = this.source.readInt();
        int i13 = this.source.readInt();
        int i14 = i10 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i13);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i14 > 0) {
            byteString = this.source.readByteString(i14);
        }
        handler.goAway(i12, errorCodeFromHttp2, byteString);
    }

    private List<Header> readHeaderBlock(int i10, short s9, byte b10, int i11) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i10;
        continuationSource.length = i10;
        continuationSource.padding = s9;
        continuationSource.flags = b10;
        continuationSource.streamId = i11;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z9 = (b10 & 1) != 0;
        short s9 = (b10 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            readPriority(handler, i11);
            i10 -= 5;
        }
        handler.headers(z9, i11, -1, readHeaderBlock(lengthWithoutPadding(i10, b10, s9), s9, b10, i11));
    }

    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i10 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b10 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readPriority(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i10 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i11);
    }

    private void readPushPromise(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s9 = (b10 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i11, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i10 - 4, b10, s9), s9, b10, i11));
    }

    private void readRstStream(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i12 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i12);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
        }
        handler.rstStream(i11, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i10 % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        Settings settings = new Settings();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.source.readShort() & 65535;
            int i14 = this.source.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                }
            } else {
                if (i14 < 0) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i13 = 7;
            }
            settings.set(i13, i14);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long j10 = this.source.readInt() & 2147483647L;
        if (j10 == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(j10));
        }
        handler.windowUpdate(i11, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z9, Handler handler) throws IOException {
        try {
            this.source.require(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b10 = (byte) (this.source.readByte() & 255);
            if (z9 && b10 != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
            }
            byte b11 = (byte) (this.source.readByte() & 255);
            int i10 = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i10, medium, b10, b11));
            }
            switch (b10) {
                case 0:
                    readData(handler, medium, b11, i10);
                    return true;
                case 1:
                    readHeaders(handler, medium, b11, i10);
                    return true;
                case 2:
                    readPriority(handler, medium, b11, i10);
                    return true;
                case 3:
                    readRstStream(handler, medium, b11, i10);
                    return true;
                case 4:
                    readSettings(handler, medium, b11, i10);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b11, i10);
                    return true;
                case 6:
                    readPing(handler, medium, b11, i10);
                    return true;
                case 7:
                    readGoAway(handler, medium, b11, i10);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b11, i10);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION %s", byteString2.hex()));
        }
        if (!byteString.equals(byteString2)) {
            throw Http2.ioException("Expected a connection header but was %s", byteString2.utf8());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i10 = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b10 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.streamId, this.length, b10, this.flags));
            }
            int i11 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i11;
            if (b10 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            while (true) {
                int i10 = this.left;
                BufferedSource bufferedSource = this.source;
                if (i10 != 0) {
                    long j11 = bufferedSource.read(buffer, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - j11);
                    return j11;
                }
                bufferedSource.skip(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    private void readPriority(Handler handler, int i10) throws IOException {
        int i11 = this.source.readInt();
        handler.priority(i10, i11 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }
}
