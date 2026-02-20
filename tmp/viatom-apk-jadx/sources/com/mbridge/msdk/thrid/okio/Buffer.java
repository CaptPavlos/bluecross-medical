package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import androidx.window.layout.c;
import androidx.work.WorkRequest;
import com.google.gson.internal.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;

    @Nullable
    Segment head;
    long size;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                c.g("not attached to a buffer");
                return;
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i10) {
            if (i10 <= 0) {
                a.n(a3.a.f(i10, "minByteCount <= 0: "));
                return 0L;
            }
            if (i10 > 8192) {
                a.n(a3.a.f(i10, "minByteCount > Segment.SIZE: "));
                return 0L;
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                c.g("not attached to a buffer");
                return 0L;
            }
            if (!this.readWrite) {
                c.g("expandBuffer() only permitted for read/write buffers");
                return 0L;
            }
            long j10 = buffer.size;
            Segment segmentWritableSegment = buffer.writableSegment(i10);
            int i11 = 8192 - segmentWritableSegment.limit;
            segmentWritableSegment.limit = 8192;
            long j11 = i11;
            this.buffer.size = j10 + j11;
            this.segment = segmentWritableSegment;
            this.offset = j10;
            this.data = segmentWritableSegment.data;
            this.start = 8192 - i11;
            this.end = 8192;
            return j11;
        }

        public final int next() {
            long j10 = this.offset;
            if (j10 != this.buffer.size) {
                return j10 == -1 ? seek(0L) : seek(j10 + (this.end - this.start));
            }
            u.e();
            return 0;
        }

        public final long resizeBuffer(long j10) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                c.g("not attached to a buffer");
                return 0L;
            }
            if (!this.readWrite) {
                c.g("resizeBuffer() only permitted for read/write buffers");
                return 0L;
            }
            long j11 = buffer.size;
            if (j10 <= j11) {
                if (j10 < 0) {
                    a.n(a3.a.h(j10, "newSize < 0: "));
                    return 0L;
                }
                long j12 = j11 - j10;
                while (true) {
                    if (j12 <= 0) {
                        break;
                    }
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.head.prev;
                    int i10 = segment.limit;
                    long j13 = i10 - segment.pos;
                    if (j13 > j12) {
                        segment.limit = (int) (i10 - j12);
                        break;
                    }
                    buffer2.head = segment.pop();
                    SegmentPool.recycle(segment);
                    j12 -= j13;
                }
                this.segment = null;
                this.offset = j10;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j10 > j11) {
                long j14 = j10 - j11;
                boolean z9 = true;
                while (j14 > 0) {
                    Segment segmentWritableSegment = this.buffer.writableSegment(1);
                    int iMin = (int) Math.min(j14, 8192 - segmentWritableSegment.limit);
                    int i11 = segmentWritableSegment.limit + iMin;
                    segmentWritableSegment.limit = i11;
                    j14 -= iMin;
                    if (z9) {
                        this.segment = segmentWritableSegment;
                        this.offset = j11;
                        this.data = segmentWritableSegment.data;
                        this.start = i11 - iMin;
                        this.end = i11;
                        z9 = false;
                    }
                }
            }
            this.buffer.size = j10;
            return j11;
        }

        public final int seek(long j10) {
            if (j10 >= -1) {
                Buffer buffer = this.buffer;
                long j11 = buffer.size;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.head;
                    Segment segmentPush = this.segment;
                    long j12 = 0;
                    if (segmentPush != null) {
                        long j13 = this.offset - (this.start - segmentPush.pos);
                        if (j13 > j10) {
                            segmentPush = segment;
                            segment = segmentPush;
                            j11 = j13;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        segmentPush = segment;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            int i10 = segmentPush.limit;
                            int i11 = segmentPush.pos;
                            if (j10 < (i10 - i11) + j12) {
                                break;
                            }
                            j12 += i10 - i11;
                            segmentPush = segmentPush.next;
                        }
                    } else {
                        while (j11 > j10) {
                            segment = segment.prev;
                            j11 -= segment.limit - segment.pos;
                        }
                        segmentPush = segment;
                        j12 = j11;
                    }
                    if (this.readWrite && segmentPush.shared) {
                        Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.head == segmentPush) {
                            buffer2.head = segmentUnsharedCopy;
                        }
                        segmentPush = segmentPush.push(segmentUnsharedCopy);
                        segmentPush.prev.pop();
                    }
                    this.segment = segmentPush;
                    this.offset = j10;
                    this.data = segmentPush.data;
                    int i12 = segmentPush.pos + ((int) (j10 - j12));
                    this.start = i12;
                    int i13 = segmentPush.limit;
                    this.end = i13;
                    return i13 - i12;
                }
            }
            long j14 = this.buffer.size;
            StringBuilder sbX = a3.a.x("offset=", " > size=", j10);
            sbX.append(j14);
            throw new ArrayIndexOutOfBoundsException(sbX.toString());
        }
    }

    private ByteString digest(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                messageDigest.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    messageDigest.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            u.m();
            return null;
        }
    }

    private ByteString hmac(String str, ByteString byteString) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                mac.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    mac.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            u.m();
            return null;
        }
    }

    private void readFrom(InputStream inputStream, long j10, boolean z9) throws IOException {
        if (inputStream == null) {
            a.n("in == null");
            return;
        }
        while (true) {
            if (j10 <= 0 && !z9) {
                return;
            }
            Segment segmentWritableSegment = writableSegment(1);
            int i10 = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j10, 8192 - segmentWritableSegment.limit));
            if (i10 == -1) {
                if (z9) {
                    return;
                }
                u.q();
                return;
            } else {
                segmentWritableSegment.limit += i10;
                long j11 = i10;
                this.size += j11;
                j10 -= j11;
            }
        }
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            u.h(e);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buffer m236clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segmentSharedCopy = this.head.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    public final long completeSegmentByteCount() {
        long j10 = this.size;
        if (j10 == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j10 : j10 - (r3 - segment.pos);
    }

    public final Buffer copyTo(Buffer buffer, long j10, long j11) {
        if (buffer == null) {
            a.n("out == null");
            return null;
        }
        long j12 = j10;
        Util.checkOffsetAndCount(this.size, j12, j11);
        if (j11 != 0) {
            buffer.size += j11;
            Segment segment = this.head;
            while (true) {
                int i10 = segment.limit;
                int i11 = segment.pos;
                if (j12 < i10 - i11) {
                    break;
                }
                j12 -= i10 - i11;
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j13 = j11;
            while (j13 > 0) {
                Segment segmentSharedCopy = segment2.sharedCopy();
                int i12 = (int) (segmentSharedCopy.pos + j12);
                segmentSharedCopy.pos = i12;
                segmentSharedCopy.limit = Math.min(i12 + ((int) j13), segmentSharedCopy.limit);
                Segment segment3 = buffer.head;
                if (segment3 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    buffer.head = segmentSharedCopy;
                } else {
                    segment3.prev.push(segmentSharedCopy);
                }
                j13 -= segmentSharedCopy.limit - segmentSharedCopy.pos;
                segment2 = segment2.next;
                j12 = 0;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j10 = this.size;
        if (j10 != buffer.size) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i10 = segment.pos;
        int i11 = segment2.pos;
        while (j11 < this.size) {
            long jMin = Math.min(segment.limit - i10, segment2.limit - i11);
            int i12 = 0;
            while (i12 < jMin) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (segment.data[i10] != segment2.data[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == segment.limit) {
                segment = segment.next;
                i10 = segment.pos;
            }
            if (i11 == segment2.limit) {
                segment2 = segment2.next;
                i11 = segment2.pos;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    public final byte getByte(long j10) {
        Util.checkOffsetAndCount(this.size, j10, 1L);
        long j11 = this.size;
        long j12 = j11 - j10;
        Segment segment = this.head;
        if (j12 > j10) {
            long j13 = j10;
            while (true) {
                int i10 = segment.limit;
                int i11 = segment.pos;
                long j14 = i10 - i11;
                if (j13 < j14) {
                    return segment.data[i11 + ((int) j13)];
                }
                j13 -= j14;
                segment = segment.next;
            }
        } else {
            long j15 = j10 - j11;
            Segment segment2 = segment.prev;
            while (true) {
                int i12 = segment2.limit;
                int i13 = segment2.pos;
                j15 += i12 - i13;
                if (j15 >= 0) {
                    return segment2.data[i13 + ((int) j15)];
                }
                segment2 = segment2.prev;
            }
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.limit;
            for (int i12 = segment.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.data[i12];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i10;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString, long j10) throws IOException {
        Buffer buffer = this;
        if (byteString.size() == 0) {
            a.n("bytes is empty");
            return 0L;
        }
        long j11 = 0;
        if (j10 < 0) {
            a.n("fromIndex < 0");
            return 0L;
        }
        Segment segment = buffer.head;
        long j12 = -1;
        if (segment == null) {
            return -1L;
        }
        long j13 = buffer.size;
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                segment = segment.prev;
                j13 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j14 = (segment.limit - segment.pos) + j11;
                if (j14 >= j10) {
                    break;
                }
                segment = segment.next;
                j11 = j14;
            }
            j13 = j11;
        }
        byte b10 = byteString.getByte(0);
        long j15 = j13;
        int size = byteString.size();
        long j16 = (buffer.size - size) + 1;
        Segment segment2 = segment;
        long j17 = j10;
        while (j15 < j16) {
            byte[] bArr = segment2.data;
            long j18 = j12;
            int iMin = (int) Math.min(segment2.limit, (segment2.pos + j16) - j15);
            int i10 = (int) ((segment2.pos + j17) - j15);
            while (i10 < iMin) {
                if (bArr[i10] == b10 && buffer.rangeEquals(segment2, i10 + 1, byteString, 1, size)) {
                    return (i10 - segment2.pos) + j15;
                }
                i10++;
                buffer = this;
            }
            j15 += segment2.limit - segment2.pos;
            segment2 = segment2.next;
            buffer = this;
            j17 = j15;
            j12 = j18;
        }
        return j12;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j10) {
        long j11 = 0;
        if (j10 < 0) {
            a.n("fromIndex < 0");
            return 0L;
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j12 = this.size;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                segment = segment.prev;
                j12 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j13 = (segment.limit - segment.pos) + j11;
                if (j13 >= j10) {
                    break;
                }
                segment = segment.next;
                j11 = j13;
            }
            j12 = j11;
        }
        if (byteString.size() == 2) {
            byte b10 = byteString.getByte(0);
            byte b11 = byteString.getByte(1);
            while (j12 < this.size) {
                byte[] bArr = segment.data;
                int i10 = segment.limit;
                for (int i11 = (int) ((segment.pos + j10) - j12); i11 < i10; i11++) {
                    byte b12 = bArr[i11];
                    if (b12 == b10 || b12 == b11) {
                        return (i11 - segment.pos) + j12;
                    }
                }
                j12 += segment.limit - segment.pos;
                segment = segment.next;
                j10 = j12;
            }
        } else {
            byte[] bArrInternalArray = byteString.internalArray();
            while (j12 < this.size) {
                byte[] bArr2 = segment.data;
                int i12 = segment.limit;
                for (int i13 = (int) ((segment.pos + j10) - j12); i13 < i12; i13++) {
                    byte b13 = bArr2[i13];
                    for (byte b14 : bArrInternalArray) {
                        if (b13 == b14) {
                            return (i13 - segment.pos) + j12;
                        }
                    }
                }
                j12 += segment.limit - segment.pos;
                segment = segment.next;
                j10 = j12;
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) {
                return Buffer.this.read(bArr, i10, i11);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(SameMD5.TAG);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.1
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) {
                Buffer.this.writeByte((int) ((byte) i10));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                Buffer.this.write(bArr, i10, i11);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }
        };
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.size - j10 < i11 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(i12 + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr, int i10, int i11) {
        Util.checkOffsetAndCount(bArr.length, i10, i11);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i11, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i10, iMin);
        int i12 = segment.pos + iMin;
        segment.pos = i12;
        this.size -= iMin;
        if (i12 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j10 = this.size;
        if (j10 > 0) {
            sink.write(this, j10);
        }
        return j10;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            c.g("already attached to a buffer");
            return null;
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte readByte() {
        long j10 = this.size;
        if (j10 == 0) {
            c.g("size == 0");
            return (byte) 0;
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        int i12 = i10 + 1;
        byte b10 = segment.data[i10];
        this.size = j10 - 1;
        if (i12 != i11) {
            segment.pos = i12;
            return b10;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return b10;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray(long j10) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j10);
        if (j10 > 2147483647L) {
            a.n(a3.a.h(j10, "byteCount > Integer.MAX_VALUE: "));
            return null;
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6 A[EDGE_INSN: B:48:0x00a6->B:38:0x00a6 BREAK  A[LOOP:0: B:5:0x000f->B:50:?], SYNTHETIC] */
    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb1
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        Lf:
            com.mbridge.msdk.thrid.okio.Segment r7 = r15.head
            byte[] r8 = r7.data
            int r9 = r7.pos
            int r10 = r7.limit
        L17:
            if (r9 >= r10) goto L92
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L66
            r12 = 57
            if (r11 > r12) goto L66
            int r12 = 48 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L3c
            if (r13 != 0) goto L36
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L36
            goto L3c
        L36:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L71
        L3c:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeDecimalLong(r3)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte(r11)
            if (r1 != 0) goto L4e
            r0.readByte()
        L4e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.readUtf8()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L66:
            r12 = 45
            r13 = 1
            if (r11 != r12) goto L76
            if (r0 != 0) goto L76
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L71:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L17
        L76:
            if (r0 == 0) goto L7a
            r2 = r13
            goto L92
        L7a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = java.lang.Integer.toHexString(r11)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r9 != r10) goto L9e
            com.mbridge.msdk.thrid.okio.Segment r8 = r7.pop()
            r15.head = r8
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r7)
            goto La0
        L9e:
            r7.pos = r9
        La0:
            if (r2 != 0) goto La6
            com.mbridge.msdk.thrid.okio.Segment r7 = r15.head
            if (r7 != 0) goto Lf
        La6:
            long r5 = r15.size
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.size = r5
            if (r1 == 0) goto Laf
            return r3
        Laf:
            long r0 = -r3
            return r0
        Lb1:
            java.lang.String r0 = "size == 0"
            androidx.window.layout.c.g(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readDecimalLong():long");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                u.q();
                return;
            }
            i10 += i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[EDGE_INSN: B:43:0x009c->B:37:0x009c BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La3
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.mbridge.msdk.thrid.okio.Segment r6 = r14.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L88
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6c
            r11 = 70
            if (r10 > r11) goto L6c
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.readUtf8()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L88
        L70:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L88:
            if (r8 != r9) goto L94
            com.mbridge.msdk.thrid.okio.Segment r7 = r6.pop()
            r14.head = r7
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6)
            goto L96
        L94:
            r6.pos = r8
        L96:
            if (r1 != 0) goto L9c
            com.mbridge.msdk.thrid.okio.Segment r6 = r14.head
            if (r6 != 0) goto Lb
        L9c:
            long r1 = r14.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.size = r1
            return r4
        La3:
            java.lang.String r0 = "size == 0"
            androidx.window.layout.c.g(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readInt() {
        long j10 = this.size;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.size = j10 - 4;
        if (i14 != i11) {
            segment.pos = i14;
            return i15;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i15;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLong() {
        long j10 = this.size;
        if (j10 < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        int i12 = i10 + 7;
        long j11 = ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j12 = j11 | (bArr[i12] & 255);
        this.size = j10 - 8;
        if (i13 != i11) {
            segment.pos = i13;
            return j12;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return j12;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShort() {
        long j10 = this.size;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.size = j10 - 2;
        if (i14 == i11) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i14;
        }
        return (short) i15;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(long j10, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j10);
        if (charset == null) {
            a.n("charset == null");
            return null;
        }
        if (j10 > 2147483647L) {
            a.n(a3.a.h(j10, "byteCount > Integer.MAX_VALUE: "));
            return null;
        }
        if (j10 == 0) {
            return "";
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        if (i10 + j10 > segment.limit) {
            return new String(readByteArray(j10), charset);
        }
        String str = new String(segment.data, i10, (int) j10, charset);
        int i11 = (int) (segment.pos + j10);
        segment.pos = i11;
        this.size -= j10;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            c.g("already attached to a buffer");
            return null;
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            u.h(e);
            return null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (this.size == 0) {
            u.q();
            return 0;
        }
        byte b10 = getByte(0L);
        if ((b10 & 128) == 0) {
            i10 = b10 & 127;
            i12 = 0;
            i11 = 1;
        } else if ((b10 & 224) == 192) {
            i10 = b10 & 31;
            i11 = 2;
            i12 = 128;
        } else if ((b10 & 240) == 224) {
            i10 = b10 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((b10 & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            }
            i10 = b10 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.size < j10) {
            StringBuilder sbR = a3.a.r(i11, "size < ", ": ");
            sbR.append(this.size);
            sbR.append(" (to read code point prefixed 0x");
            sbR.append(Integer.toHexString(b10));
            sbR.append(")");
            throw new EOFException(sbR.toString());
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte b11 = getByte(j11);
            if ((b11 & 192) != 128) {
                skip(j11);
                return REPLACEMENT_CHARACTER;
            }
            i10 = (i10 << 6) | (b11 & 63);
        }
        skip(j10);
        return i10 > 1114111 ? REPLACEMENT_CHARACTER : ((i10 < 55296 || i10 > 57343) && i10 >= i12) ? i10 : REPLACEMENT_CHARACTER;
    }

    public String readUtf8Line(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (getByte(j11) == 13) {
                String utf8 = readUtf8(j11);
                skip(2L);
                return utf8;
            }
        }
        String utf82 = readUtf8(j10);
        skip(1L);
        return utf82;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 < 0) {
            a.n(a3.a.h(j10, "limit < 0: "));
            return null;
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j11);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        if (j11 < size() && getByte(j11 - 1) == 13 && getByte(j11) == 10) {
            return readUtf8Line(j11);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        u.g(Math.min(size(), j10), buffer.readByteString().hex());
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean request(long j10) {
        return this.size >= j10;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void require(long j10) throws EOFException {
        if (this.size >= j10) {
            return;
        }
        u.q();
    }

    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int select(Options options) {
        int iSelectPrefix = selectPrefix(options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[iSelectPrefix].size());
            return iSelectPrefix;
        } catch (EOFException unused) {
            u.m();
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r19 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int selectPrefix(com.mbridge.msdk.thrid.okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            com.mbridge.msdk.thrid.okio.Segment r2 = r1.head
            r3 = -2
            if (r2 != 0) goto L13
            if (r19 == 0) goto Lc
            return r3
        Lc:
            com.mbridge.msdk.thrid.okio.ByteString r2 = com.mbridge.msdk.thrid.okio.ByteString.EMPTY
            int r0 = r0.indexOf(r2)
            return r0
        L13:
            byte[] r4 = r2.data
            int r5 = r2.pos
            int r6 = r2.limit
            int[] r0 = r0.trie
            r7 = 0
            r8 = -1
            r10 = r2
            r9 = r7
            r11 = r8
        L20:
            int r12 = r9 + 1
            r13 = r0[r9]
            int r9 = r9 + 2
            r12 = r0[r12]
            if (r12 == r8) goto L2b
            r11 = r12
        L2b:
            if (r10 != 0) goto L2e
            goto L55
        L2e:
            r12 = 0
            if (r13 >= 0) goto L71
            int r13 = r13 * (-1)
            int r14 = r13 + r9
        L35:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + 1
            r9 = r0[r9]
            if (r5 == r9) goto L42
            goto L7b
        L42:
            if (r15 != r14) goto L46
            r5 = 1
            goto L47
        L46:
            r5 = r7
        L47:
            if (r13 != r6) goto L61
            com.mbridge.msdk.thrid.okio.Segment r4 = r10.next
            int r6 = r4.pos
            byte[] r9 = r4.data
            int r10 = r4.limit
            if (r4 != r2) goto L5b
            if (r5 != 0) goto L58
        L55:
            if (r19 == 0) goto L7b
            return r3
        L58:
            r4 = r9
            r9 = r12
            goto L64
        L5b:
            r16 = r9
            r9 = r4
            r4 = r16
            goto L64
        L61:
            r9 = r10
            r10 = r6
            r6 = r13
        L64:
            if (r5 == 0) goto L6c
            r5 = r0[r15]
            r3 = r6
            r6 = r10
            r10 = r9
            goto L92
        L6c:
            r5 = r6
            r6 = r10
            r10 = r9
            r9 = r15
            goto L35
        L71:
            int r14 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + r13
        L79:
            if (r9 != r15) goto L7c
        L7b:
            return r11
        L7c:
            r3 = r0[r9]
            if (r5 != r3) goto L99
            int r9 = r9 + r13
            r5 = r0[r9]
            if (r14 != r6) goto L91
            com.mbridge.msdk.thrid.okio.Segment r10 = r10.next
            int r3 = r10.pos
            byte[] r4 = r10.data
            int r6 = r10.limit
            if (r10 != r2) goto L92
            r10 = r12
            goto L92
        L91:
            r3 = r14
        L92:
            if (r5 < 0) goto L95
            return r5
        L95:
            int r9 = -r5
            r5 = r3
            r3 = -2
            goto L20
        L99:
            int r9 = r9 + 1
            r3 = -2
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.selectPrefix(com.mbridge.msdk.thrid.okio.Options, boolean):int");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            if (this.head == null) {
                u.q();
                return;
            }
            int iMin = (int) Math.min(j10, r0.limit - r0.pos);
            long j11 = iMin;
            this.size -= j11;
            j10 -= j11;
            Segment segment = this.head;
            int i10 = segment.pos + iMin;
            segment.pos = i10;
            if (i10 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        long j10 = this.size;
        if (j10 <= 2147483647L) {
            return snapshot((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i10) {
        if (i10 < 1 || i10 > 8192) {
            f.a();
            return null;
        }
        Segment segment = this.head;
        if (segment != null) {
            Segment segment2 = segment.prev;
            return (segment2.limit + i10 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j10) {
        if (buffer == null) {
            a.n("source == null");
            return;
        }
        if (buffer == this) {
            a.n("source == this");
            return;
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.head;
            if (j10 < segment.limit - segment.pos) {
                Segment segment2 = this.head;
                Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((segment3.limit + j10) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                        segment.writeTo(segment3, (int) j10);
                        buffer.size -= j10;
                        this.size += j10;
                        return;
                    }
                }
                buffer.head = segment.split((int) j10);
            }
            Segment segment4 = buffer.head;
            long j11 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4).compact();
            }
            buffer.size -= j11;
            this.size += j11;
            j10 -= j11;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            a.n("source == null");
            return 0L;
        }
        long j10 = 0;
        while (true) {
            long j11 = source.read(this, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeByte(int i10) {
        Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        this.size++;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeDecimalLong(long j10) {
        boolean z9;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z9 = true;
        } else {
            z9 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < C.NANOS_PER_SECOND ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z9) {
            i10++;
        }
        Segment segmentWritableSegment = writableSegment(i10);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = DIGITS[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z9) {
            bArr[i11 - 1] = 45;
        }
        segmentWritableSegment.limit += i10;
        this.size += i10;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        Segment segmentWritableSegment = writableSegment(iNumberOfTrailingZeros);
        byte[] bArr = segmentWritableSegment.data;
        int i10 = segmentWritableSegment.limit;
        for (int i11 = (i10 + iNumberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = DIGITS[(int) (15 & j10)];
            j10 >>>= 4;
        }
        segmentWritableSegment.limit += iNumberOfTrailingZeros;
        this.size += iNumberOfTrailingZeros;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeInt(int i10) {
        Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        segmentWritableSegment.limit = i11 + 4;
        this.size += 4;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytesInt(i10));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLong(long j10) {
        Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i10 = segmentWritableSegment.limit;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        segmentWritableSegment.limit = i10 + 8;
        this.size += 8;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytesLong(j10));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShort(int i10) {
        Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        segmentWritableSegment.limit = i11 + 2;
        this.size += 2;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytesShort((short) i10));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            a.n("string == null");
            return null;
        }
        if (i10 < 0) {
            throw new IllegalAccessError(a3.a.f(i10, "beginIndex < 0: "));
        }
        if (i11 < i10) {
            a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "endIndex < beginIndex: ", " < "));
            return null;
        }
        if (i11 > str.length()) {
            StringBuilder sbR = a3.a.r(i11, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString());
        }
        if (charset == null) {
            a.n("charset == null");
            return null;
        }
        if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i10, i11);
        }
        byte[] bytes = str.substring(i10, i11).getBytes(charset);
        return write(bytes, 0, bytes.length);
    }

    public final Buffer writeTo(OutputStream outputStream, long j10) throws IOException {
        if (outputStream == null) {
            a.n("out == null");
            return null;
        }
        Util.checkOffsetAndCount(this.size, 0L, j10);
        Segment segment = this.head;
        long j11 = j10;
        while (j11 > 0) {
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            int i10 = segment.pos + iMin;
            segment.pos = i10;
            long j12 = iMin;
            this.size -= j12;
            j11 -= j12;
            if (i10 == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str, int i10, int i11) {
        if (str == null) {
            a.n("string == null");
            return null;
        }
        if (i10 < 0) {
            a.n(a3.a.f(i10, "beginIndex < 0: "));
            return null;
        }
        if (i11 < i10) {
            a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "endIndex < beginIndex: ", " < "));
            return null;
        }
        if (i11 > str.length()) {
            StringBuilder sbR = a3.a.r(i11, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString());
        }
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                Segment segmentWritableSegment = writableSegment(1);
                byte[] bArr = segmentWritableSegment.data;
                int i12 = segmentWritableSegment.limit - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt;
                while (i13 < iMin) {
                    char cCharAt2 = str.charAt(i13);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i13 + i12] = (byte) cCharAt2;
                    i13++;
                }
                int i14 = segmentWritableSegment.limit;
                int i15 = (i12 + i13) - i14;
                segmentWritableSegment.limit = i14 + i15;
                this.size += i15;
                i10 = i13;
            } else {
                if (cCharAt < 2048) {
                    writeByte((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                    writeByte((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f') | 224);
                    writeByte(((cCharAt >> 6) & 63) | 128);
                    writeByte((cCharAt & '?') | 128);
                } else {
                    int i16 = i10 + 1;
                    char cCharAt3 = i16 < i11 ? str.charAt(i16) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i10 = i16;
                    } else {
                        int i17 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i17 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        writeByte(((i17 >> 12) & 63) | 128);
                        writeByte(((i17 >> 6) & 63) | 128);
                        writeByte((i17 & 63) | 128);
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
            return this;
        }
        if (i10 < 2048) {
            writeByte((i10 >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i10 & 63) | 128);
            return this;
        }
        if (i10 < 65536) {
            if (i10 >= 55296 && i10 <= 57343) {
                writeByte(63);
                return this;
            }
            writeByte((i10 >> 12) | 224);
            writeByte(((i10 >> 6) & 63) | 128);
            writeByte((i10 & 63) | 128);
            return this;
        }
        if (i10 > 1114111) {
            c.f(Integer.toHexString(i10), "Unexpected code point: ");
            return null;
        }
        writeByte((i10 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
        writeByte(((i10 >> 12) & 63) | 128);
        writeByte(((i10 >> 6) & 63) | 128);
        writeByte((i10 & 63) | 128);
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString(long j10) throws EOFException {
        return new ByteString(readByteArray(j10));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8(long j10) throws EOFException {
        return readString(j10, Util.UTF_8);
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(Buffer buffer, long j10) throws EOFException {
        long j11 = this.size;
        if (j11 >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, j11);
            u.q();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource, com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            u.h(e);
            return null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf == -1) {
            long j10 = this.size;
            if (j10 != 0) {
                return readUtf8(j10);
            }
            return null;
        }
        return readUtf8Line(jIndexOf);
    }

    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i10);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString) {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    private boolean rangeEquals(Segment segment, int i10, ByteString byteString, int i11, int i12) {
        int i13 = segment.limit;
        byte[] bArr = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i10 = segment.pos;
                i13 = segment.limit;
            }
            if (bArr[i10] != byteString.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i10 = segment.pos + iMin;
        segment.pos = i10;
        this.size -= iMin;
        if (i10 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final Buffer readFrom(InputStream inputStream, long j10) throws IOException {
        if (j10 >= 0) {
            readFrom(inputStream, j10, false);
            return this;
        }
        a.n(a3.a.h(j10, "byteCount < 0: "));
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            a.n("sink == null");
            return 0L;
        }
        if (j10 >= 0) {
            long j11 = this.size;
            if (j11 == 0) {
                return -1L;
            }
            if (j10 > j11) {
                j10 = j11;
            }
            buffer.write(this, j10);
            return j10;
        }
        a.n(a3.a.h(j10, "byteCount < 0: "));
        return 0L;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            u.h(e);
            return null;
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream != null) {
            long j12 = j10;
            Util.checkOffsetAndCount(this.size, j12, j11);
            if (j11 != 0) {
                Segment segment = this.head;
                while (true) {
                    int i10 = segment.limit;
                    int i11 = segment.pos;
                    if (j12 < i10 - i11) {
                        break;
                    }
                    j12 -= i10 - i11;
                    segment = segment.next;
                }
                Segment segment2 = segment;
                long j13 = j11;
                while (j13 > 0) {
                    int i12 = (int) (segment2.pos + j12);
                    int iMin = (int) Math.min(segment2.limit - i12, j13);
                    outputStream.write(segment2.data, i12, iMin);
                    j13 -= iMin;
                    segment2 = segment2.next;
                    j12 = 0;
                }
            }
            return this;
        }
        a.n("out == null");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        a.n("byteString == null");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        a.n("source == null");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            long j10 = i11;
            Util.checkOffsetAndCount(bArr.length, i10, j10);
            int i12 = i11 + i10;
            while (i10 < i12) {
                Segment segmentWritableSegment = writableSegment(1);
                int iMin = Math.min(i12 - i10, 8192 - segmentWritableSegment.limit);
                System.arraycopy(bArr, i10, segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i10 += iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += j10;
            return this;
        }
        a.n("source == null");
        return null;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i10 = iRemaining;
            while (i10 > 0) {
                Segment segmentWritableSegment = writableSegment(1);
                int iMin = Math.min(i10, 8192 - segmentWritableSegment.limit);
                byteBuffer.get(segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i10 -= iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += iRemaining;
            return iRemaining;
        }
        a.n("source == null");
        return 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long j11 = source.read(this, j10);
            if (j11 == -1) {
                u.q();
                return null;
            }
            j10 -= j11;
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b10, long j10, long j11) {
        Segment segment;
        long j12 = j10;
        long j13 = j11;
        long j14 = 0;
        if (j12 >= 0 && j13 >= j12) {
            long j15 = this.size;
            if (j13 > j15) {
                j13 = j15;
            }
            if (j12 == j13 || (segment = this.head) == null) {
                return -1L;
            }
            if (j15 - j12 < j12) {
                while (j15 > j12) {
                    segment = segment.prev;
                    j15 -= segment.limit - segment.pos;
                }
            } else {
                while (true) {
                    long j16 = (segment.limit - segment.pos) + j14;
                    if (j16 >= j12) {
                        break;
                    }
                    segment = segment.next;
                    j14 = j16;
                }
                j15 = j14;
            }
            while (j15 < j13) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (segment.pos + j13) - j15);
                for (int i10 = (int) ((segment.pos + j12) - j15); i10 < iMin; i10++) {
                    if (bArr[i10] == b10) {
                        return (i10 - segment.pos) + j15;
                    }
                }
                j15 += segment.limit - segment.pos;
                segment = segment.next;
                j12 = j15;
            }
            return -1L;
        }
        StringBuilder sbX = a3.a.x("size=", " fromIndex=", this.size);
        sbX.append(j12);
        sbX.append(" toIndex=");
        sbX.append(j13);
        throw new IllegalArgumentException(sbX.toString());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b10) {
        return indexOf(b10, 0L, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }
}
