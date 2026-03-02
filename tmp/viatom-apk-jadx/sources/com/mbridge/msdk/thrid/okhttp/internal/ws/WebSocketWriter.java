package com.mbridge.msdk.thrid.okhttp.internal.ws;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.IOException;
import java.util.Random;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                a.m("closed");
                return;
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                a.m("closed");
                return;
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (this.closed) {
                a.m("closed");
                return;
            }
            WebSocketWriter.this.buffer.write(buffer, j10);
            boolean z9 = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.size() > this.contentLength - 8192;
            long jCompleteSegmentByteCount = WebSocketWriter.this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount <= 0 || z9) {
                return;
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jCompleteSegmentByteCount, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    public WebSocketWriter(boolean z9, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            c.k("sink == null");
            throw null;
        }
        if (random == null) {
            c.k("random == null");
            throw null;
        }
        this.isClient = z9;
        this.sink = bufferedSink;
        this.sinkBuffer = bufferedSink.buffer();
        this.random = random;
        this.maskKey = z9 ? new byte[4] : null;
        this.maskCursor = z9 ? new Buffer.UnsafeCursor() : null;
    }

    private void writeControlFrame(int i10, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            a.m("closed");
            return;
        }
        int size = byteString.size();
        if (size > 125) {
            a.n("Payload size must be less than or equal to 125");
            return;
        }
        this.sinkBuffer.writeByte(i10 | 128);
        boolean z9 = this.isClient;
        Buffer buffer = this.sinkBuffer;
        if (z9) {
            buffer.writeByte(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            buffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    public Sink newMessageSink(int i10, long j10) {
        if (this.activeWriter) {
            c.g("Another message writer is active. Did you call close()?");
            return null;
        }
        this.activeWriter = true;
        FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i10;
        frameSink.contentLength = j10;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    public void writeClose(int i10, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i10 != 0 || byteString != null) {
            if (i10 != 0) {
                WebSocketProtocol.validateCloseCode(i10);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i10);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i10, long j10, boolean z9, boolean z10) throws IOException {
        if (this.writerClosed) {
            a.m("closed");
            return;
        }
        if (!z9) {
            i10 = 0;
        }
        if (z10) {
            i10 |= 128;
        }
        this.sinkBuffer.writeByte(i10);
        int i11 = this.isClient ? 128 : 0;
        if (j10 <= 125) {
            this.sinkBuffer.writeByte(((int) j10) | i11);
        } else {
            Buffer buffer = this.sinkBuffer;
            if (j10 <= 65535) {
                buffer.writeByte(i11 | 126);
                this.sinkBuffer.writeShort((int) j10);
            } else {
                buffer.writeByte(i11 | 127);
                this.sinkBuffer.writeLong(j10);
            }
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j10 > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j10);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j10);
        }
        this.sink.emit();
    }

    public void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    public void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }
}
