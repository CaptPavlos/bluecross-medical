package z8;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 implements k {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f14456a;

    /* renamed from: b, reason: collision with root package name */
    public final i f14457b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14458c;

    public b0(h0 h0Var) {
        h0Var.getClass();
        this.f14456a = h0Var;
        this.f14457b = new i();
    }

    public final boolean a(long j10, l lVar) {
        lVar.getClass();
        int iE = lVar.e();
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return false;
        }
        if (j10 >= 0 && iE >= 0 && lVar.e() >= iE) {
            for (int i10 = 0; i10 < iE; i10++) {
                long j11 = i10 + j10;
                if (request(1 + j11) && this.f14457b.b(j11) == lVar.j(i10)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f14458c) {
            return;
        }
        this.f14458c = true;
        this.f14456a.close();
        i iVar = this.f14457b;
        iVar.skip(iVar.f14479b);
    }

    public final boolean exhausted() {
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return false;
        }
        i iVar = this.f14457b;
        return iVar.exhausted() && this.f14456a.g(iVar, 8192L) == -1;
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) {
        iVar.getClass();
        if (j10 < 0) {
            f.b(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return 0L;
        }
        i iVar2 = this.f14457b;
        if (iVar2.f14479b == 0 && this.f14456a.g(iVar2, 8192L) == -1) {
            return -1L;
        }
        return iVar2.g(iVar, Math.min(j10, iVar2.f14479b));
    }

    public final long indexOf(byte b10, long j10, long j11) {
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return 0L;
        }
        if (0 > j11) {
            f.b(a3.a.h(j11, "fromIndex=0 toIndex="));
            return 0L;
        }
        long jMax = 0;
        while (jMax < j11) {
            i iVar = this.f14457b;
            byte b11 = b10;
            long j12 = j11;
            long jIndexOf = iVar.indexOf(b11, jMax, j12);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j13 = iVar.f14479b;
            if (j13 >= j12 || this.f14456a.g(iVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j13);
            b10 = b11;
            j11 = j12;
        }
        return -1L;
    }

    @Override // z8.k
    public final InputStream inputStream() {
        return new g(this, 1);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f14458c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        i iVar = this.f14457b;
        if (iVar.f14479b == 0 && this.f14456a.g(iVar, 8192L) == -1) {
            return -1;
        }
        return iVar.read(byteBuffer);
    }

    @Override // z8.k
    public final byte readByte() {
        require(1L);
        return this.f14457b.readByte();
    }

    @Override // z8.k
    public final l readByteString(long j10) {
        require(j10);
        return this.f14457b.readByteString(j10);
    }

    public final void readFully(byte[] bArr) throws EOFException {
        i iVar = this.f14457b;
        int i10 = 0;
        try {
            require(bArr.length);
            while (i10 < bArr.length) {
                int i11 = iVar.read(bArr, i10, bArr.length - i10);
                if (i11 == -1) {
                    p8.u.q();
                    return;
                }
                i10 += i11;
            }
        } catch (EOFException e) {
            while (true) {
                long j10 = iVar.f14479b;
                if (j10 <= 0) {
                    throw e;
                }
                int i12 = iVar.read(bArr, i10, (int) j10);
                if (i12 == -1) {
                    p8.u.m();
                    return;
                }
                i10 += i12;
            }
        }
    }

    @Override // z8.k
    public final long readHexadecimalUnsignedLong() {
        i iVar;
        byte b10;
        require(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            boolean zRequest = request(i11);
            iVar = this.f14457b;
            if (!zRequest) {
                break;
            }
            b10 = iVar.b(i10);
            if ((b10 < 48 || b10 > 57) && ((b10 < 97 || b10 > 102) && (b10 < 65 || b10 > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            t1.k(16);
            t1.k(16);
            String string = Integer.toString(b10, 16);
            string.getClass();
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return iVar.readHexadecimalUnsignedLong();
    }

    @Override // z8.k
    public final int readInt() {
        require(4L);
        return this.f14457b.readInt();
    }

    public final int readIntLe() {
        require(4L);
        int i10 = this.f14457b.readInt();
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public final long readLongLe() throws EOFException {
        char c10;
        char c11;
        char c12;
        char c13;
        long j10;
        require(8L);
        i iVar = this.f14457b;
        if (iVar.f14479b < 8) {
            p8.u.q();
            return 0L;
        }
        c0 c0Var = iVar.f14478a;
        c0Var.getClass();
        int i10 = c0Var.f14463b;
        int i11 = c0Var.f14464c;
        if (i11 - i10 < 8) {
            j10 = ((iVar.readInt() & 4294967295L) << 32) | (4294967295L & iVar.readInt());
            c12 = '8';
            c13 = '\b';
            c10 = 24;
            c11 = '(';
        } else {
            byte[] bArr = c0Var.f14462a;
            c10 = 24;
            c11 = '(';
            c12 = '8';
            c13 = '\b';
            int i12 = i10 + 7;
            long j11 = ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
            int i13 = i10 + 8;
            long j12 = j11 | (bArr[i12] & 255);
            iVar.f14479b -= 8;
            if (i13 == i11) {
                iVar.f14478a = c0Var.a();
                d0.a(c0Var);
            } else {
                c0Var.f14463b = i13;
            }
            j10 = j12;
        }
        return ((j10 & 255) << c12) | (((-72057594037927936L) & j10) >>> c12) | ((71776119061217280L & j10) >>> c11) | ((280375465082880L & j10) >>> c10) | ((1095216660480L & j10) >>> c13) | ((4278190080L & j10) << c13) | ((16711680 & j10) << c10) | ((65280 & j10) << c11);
    }

    @Override // z8.k
    public final short readShort() {
        require(2L);
        return this.f14457b.readShort();
    }

    public final short readShortLe() {
        require(2L);
        return this.f14457b.readShortLe();
    }

    public final String readUtf8(long j10) {
        require(j10);
        return this.f14457b.readString(j10, o7.a.f11749a);
    }

    @Override // z8.k
    public final String readUtf8LineStrict(long j10) {
        if (j10 < 0) {
            f.b(a3.a.h(j10, "limit < 0: "));
            return null;
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j11);
        i iVar = this.f14457b;
        if (jIndexOf != -1) {
            return a9.a.a(iVar, jIndexOf);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && iVar.b(j11 - 1) == 13 && request(j11 + 1) && iVar.b(j11) == 10) {
            return a9.a.a(iVar, j11);
        }
        i iVar2 = new i();
        iVar.a(iVar2, 0L, Math.min(32, iVar.f14479b));
        p8.u.g(Math.min(iVar.f14479b, j10), iVar2.readByteString(iVar2.f14479b).f());
        return null;
    }

    public final boolean request(long j10) {
        i iVar;
        if (j10 < 0) {
            f.b(a3.a.h(j10, "byteCount < 0: "));
            return false;
        }
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return false;
        }
        do {
            iVar = this.f14457b;
            if (iVar.f14479b >= j10) {
                return true;
            }
        } while (this.f14456a.g(iVar, 8192L) != -1);
        return false;
    }

    @Override // z8.k
    public final void require(long j10) {
        if (request(j10)) {
            return;
        }
        p8.u.q();
    }

    @Override // z8.k
    public final void skip(long j10) {
        if (this.f14458c) {
            androidx.window.layout.c.g("closed");
            return;
        }
        while (j10 > 0) {
            i iVar = this.f14457b;
            if (iVar.f14479b == 0 && this.f14456a.g(iVar, 8192L) == -1) {
                p8.u.q();
                return;
            } else {
                long jMin = Math.min(j10, iVar.f14479b);
                iVar.skip(jMin);
                j10 -= jMin;
            }
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f14456a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f14456a + ')';
    }

    @Override // z8.k
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }
}
