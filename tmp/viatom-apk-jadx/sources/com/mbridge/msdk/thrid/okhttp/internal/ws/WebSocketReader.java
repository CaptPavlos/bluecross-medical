package com.mbridge.msdk.thrid.okhttp.internal.ws;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class WebSocketReader {
    boolean closed;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final BufferedSource source;
    private final Buffer controlFrameBuffer = new Buffer();
    private final Buffer messageFrameBuffer = new Buffer();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z9, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            c.k("source == null");
            throw null;
        }
        if (frameCallback == null) {
            c.k("frameCallback == null");
            throw null;
        }
        this.isClient = z9;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
        this.maskKey = z9 ? null : new byte[4];
        this.maskCursor = z9 ? null : new Buffer.UnsafeCursor();
    }

    private void readControlFrame() throws IOException {
        short s9;
        String utf8;
        long j10 = this.frameLength;
        if (j10 > 0) {
            this.source.readFully(this.controlFrameBuffer, j10);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s9 = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s9);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s9 = 1005;
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s9, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws IOException {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (this.closed) {
            a.m("closed");
            return;
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            byte b10 = this.source.readByte();
            this.source.timeout().timeout(jTimeoutNanos, timeUnit);
            this.opcode = b10 & 15;
            boolean z9 = (b10 & 128) != 0;
            this.isFinalFrame = z9;
            boolean z10 = (b10 & 8) != 0;
            this.isControlFrame = z10;
            if (z10 && !z9) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z11 = (b10 & 64) != 0;
            boolean z12 = (b10 & 32) != 0;
            boolean z13 = (b10 & 16) != 0;
            if (z11 || z12 || z13) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            byte b11 = this.source.readByte();
            boolean z14 = (b11 & 128) != 0;
            if (z14 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j10 = b11 & 127;
            this.frameLength = j10;
            if (j10 == 126) {
                this.frameLength = this.source.readShort() & 65535;
            } else if (j10 == 127) {
                long j11 = this.source.readLong();
                this.frameLength = j11;
                if (j11 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z14) {
                this.source.readFully(this.maskKey);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, timeUnit);
            throw th;
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j10 = this.frameLength;
            if (j10 > 0) {
                this.source.readFully(this.messageFrameBuffer, j10);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
            }
        }
        a.m("closed");
    }

    private void readMessageFrame() throws IOException {
        int i10 = this.opcode;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i10));
        }
        readMessage();
        FrameCallback frameCallback = this.frameCallback;
        if (i10 == 1) {
            frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
