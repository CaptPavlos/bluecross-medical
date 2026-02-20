package z8;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f14450a;

    /* renamed from: b, reason: collision with root package name */
    public final i f14451b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14452c;

    public a0(f0 f0Var) {
        f0Var.getClass();
        this.f14450a = f0Var;
        this.f14451b = new i();
    }

    public final j a() {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        i iVar = this.f14451b;
        long j10 = iVar.f14479b;
        if (j10 == 0) {
            j10 = 0;
        } else {
            c0 c0Var = iVar.f14478a;
            c0Var.getClass();
            c0 c0Var2 = c0Var.g;
            c0Var2.getClass();
            if (c0Var2.f14464c < 8192 && c0Var2.e) {
                j10 -= r6 - c0Var2.f14463b;
            }
        }
        if (j10 > 0) {
            this.f14450a.c(iVar, j10);
        }
        return this;
    }

    public final j b(long j10) {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.l(j10);
        a();
        return this;
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) {
        iVar.getClass();
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
        } else {
            this.f14451b.c(iVar, j10);
            a();
        }
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f0 f0Var = this.f14450a;
        if (this.f14452c) {
            return;
        }
        try {
            i iVar = this.f14451b;
            long j10 = iVar.f14479b;
            if (j10 > 0) {
                f0Var.c(iVar, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            f0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f14452c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // z8.j, z8.f0, java.io.Flushable
    public final void flush() {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return;
        }
        i iVar = this.f14451b;
        long j10 = iVar.f14479b;
        f0 f0Var = this.f14450a;
        if (j10 > 0) {
            f0Var.c(iVar, j10);
        }
        f0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f14452c;
    }

    @Override // z8.j
    public final OutputStream outputStream() {
        return new h(this, 1);
    }

    @Override // z8.f0
    public final j0 timeout() {
        return this.f14450a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f14450a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return 0;
        }
        int iWrite = this.f14451b.write(byteBuffer);
        a();
        return iWrite;
    }

    @Override // z8.j
    public final j writeByte(int i10) {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.k(i10);
        a();
        return this;
    }

    @Override // z8.j
    public final j writeHexadecimalUnsignedLong(long j10) {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.m(j10);
        a();
        return this;
    }

    @Override // z8.j
    public final j writeInt(int i10) {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.n(i10);
        a();
        return this;
    }

    @Override // z8.j
    public final j writeShort(int i10) {
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.o(i10);
        a();
        return this;
    }

    @Override // z8.j
    public final j writeUtf8(String str) {
        str.getClass();
        if (this.f14452c) {
            androidx.window.layout.c.g("closed");
            return null;
        }
        this.f14451b.q(str);
        a();
        return this;
    }

    @Override // z8.j
    public final j write(byte[] bArr) {
        if (!this.f14452c) {
            this.f14451b.write(bArr, 0, bArr.length);
            a();
            return this;
        }
        androidx.window.layout.c.g("closed");
        return null;
    }
}
