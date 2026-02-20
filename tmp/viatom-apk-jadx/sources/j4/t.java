package j4;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f10002a;

    /* renamed from: b, reason: collision with root package name */
    public long f10003b;

    /* renamed from: c, reason: collision with root package name */
    public long f10004c;

    /* renamed from: d, reason: collision with root package name */
    public long f10005d;
    public long e = -1;
    public boolean f = true;
    public final int g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedInputStream] */
    public t(z8.g gVar) {
        this.g = -1;
        this.f10002a = gVar.markSupported() ? gVar : new BufferedInputStream(gVar, 4096);
        this.g = 1024;
    }

    public final void a(long j10) throws IOException {
        if (this.f10003b > this.f10005d || j10 < this.f10004c) {
            com.google.gson.internal.a.m("Cannot reset");
            return;
        }
        this.f10002a.reset();
        d(this.f10004c, j10);
        this.f10003b = j10;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f10002a.available();
    }

    public final void b(long j10) throws IOException {
        try {
            long j11 = this.f10004c;
            long j12 = this.f10003b;
            InputStream inputStream = this.f10002a;
            if (j11 >= j12 || j12 > this.f10005d) {
                this.f10004c = j12;
                inputStream.mark((int) (j10 - j12));
            } else {
                inputStream.reset();
                inputStream.mark((int) (j10 - this.f10004c));
                d(this.f10004c, this.f10003b);
            }
            this.f10005d = j10;
        } catch (IOException e) {
            com.google.gson.internal.a.h(e, "Unable to mark: ");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f10002a.close();
    }

    public final void d(long j10, long j11) throws IOException {
        while (j10 < j11) {
            long jSkip = this.f10002a.skip(j11 - j10);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j10 += jSkip;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i10) throws IOException {
        long j10 = this.f10003b + i10;
        if (this.f10005d < j10) {
            b(j10);
        }
        this.e = this.f10003b;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f10002a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        if (!this.f) {
            long j10 = this.f10003b;
            if (bArr.length + j10 > this.f10005d) {
                b(j10 + bArr.length + this.g);
            }
        }
        int i10 = this.f10002a.read(bArr);
        if (i10 != -1) {
            this.f10003b += i10;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        a(this.e);
    }

    @Override // java.io.InputStream
    public final long skip(long j10) throws IOException {
        if (!this.f) {
            long j11 = this.f10003b + j10;
            if (j11 > this.f10005d) {
                b(j11 + this.g);
            }
        }
        long jSkip = this.f10002a.skip(j10);
        this.f10003b += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (!this.f) {
            long j10 = this.f10003b + 1;
            long j11 = this.f10005d;
            if (j10 > j11) {
                b(j11 + this.g);
            }
        }
        int i10 = this.f10002a.read();
        if (i10 != -1) {
            this.f10003b++;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.f) {
            long j10 = this.f10003b + i11;
            if (j10 > this.f10005d) {
                b(j10 + this.g);
            }
        }
        int i12 = this.f10002a.read(bArr, i10, i11);
        if (i12 != -1) {
            this.f10003b += i12;
        }
        return i12;
    }
}
