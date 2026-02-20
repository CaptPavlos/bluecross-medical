package z8;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f14508a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f14509b;

    /* renamed from: c, reason: collision with root package name */
    public int f14510c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14511d;

    public u(b0 b0Var, Inflater inflater) {
        this.f14508a = b0Var;
        this.f14509b = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f14511d) {
            return;
        }
        this.f14509b.end();
        this.f14511d = true;
        this.f14508a.close();
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) throws DataFormatException, IOException {
        long j11;
        iVar.getClass();
        while (j10 >= 0) {
            if (this.f14511d) {
                androidx.window.layout.c.g("closed");
                return 0L;
            }
            b0 b0Var = this.f14508a;
            Inflater inflater = this.f14509b;
            if (j10 == 0) {
                j11 = 0;
            } else {
                try {
                    c0 c0VarH = iVar.h(1);
                    int iMin = (int) Math.min(j10, 8192 - c0VarH.f14464c);
                    if (inflater.needsInput() && !b0Var.exhausted()) {
                        c0 c0Var = b0Var.f14457b.f14478a;
                        c0Var.getClass();
                        int i10 = c0Var.f14464c;
                        int i11 = c0Var.f14463b;
                        int i12 = i10 - i11;
                        this.f14510c = i12;
                        inflater.setInput(c0Var.f14462a, i11, i12);
                    }
                    int iInflate = inflater.inflate(c0VarH.f14462a, c0VarH.f14464c, iMin);
                    int i13 = this.f14510c;
                    if (i13 != 0) {
                        int remaining = i13 - inflater.getRemaining();
                        this.f14510c -= remaining;
                        b0Var.skip(remaining);
                    }
                    if (iInflate > 0) {
                        c0VarH.f14464c += iInflate;
                        j11 = iInflate;
                        iVar.f14479b += j11;
                    } else {
                        if (c0VarH.f14463b == c0VarH.f14464c) {
                            iVar.f14478a = c0VarH.a();
                            d0.a(c0VarH);
                        }
                        j11 = 0;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            if (j11 > 0) {
                return j11;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (b0Var.exhausted()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        f.b(a3.a.h(j10, "byteCount < 0: "));
        return 0L;
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f14508a.f14456a.timeout();
    }
}
