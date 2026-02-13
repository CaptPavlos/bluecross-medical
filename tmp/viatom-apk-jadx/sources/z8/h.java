package z8;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f14477b;

    public /* synthetic */ h(j jVar, int i10) {
        this.f14476a = i10;
        this.f14477b = jVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f14476a) {
            case 0:
                break;
            default:
                ((a0) this.f14477b).close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        switch (this.f14476a) {
            case 0:
                break;
            default:
                a0 a0Var = (a0) this.f14477b;
                if (!a0Var.f14452c) {
                    a0Var.flush();
                    break;
                }
                break;
        }
    }

    public final String toString() {
        switch (this.f14476a) {
            case 0:
                return ((i) this.f14477b) + ".outputStream()";
            default:
                return ((a0) this.f14477b) + ".outputStream()";
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f14476a;
        bArr.getClass();
        switch (i12) {
            case 0:
                ((i) this.f14477b).write(bArr, i10, i11);
                break;
            default:
                a0 a0Var = (a0) this.f14477b;
                if (!a0Var.f14452c) {
                    a0Var.f14451b.write(bArr, i10, i11);
                    a0Var.a();
                    break;
                } else {
                    com.google.gson.internal.a.m("closed");
                    break;
                }
        }
    }

    private final void a() {
    }

    private final void b() {
    }

    @Override // java.io.OutputStream
    public final void write(int i10) throws IOException {
        switch (this.f14476a) {
            case 0:
                ((i) this.f14477b).k(i10);
                break;
            default:
                a0 a0Var = (a0) this.f14477b;
                if (!a0Var.f14452c) {
                    a0Var.f14451b.k((byte) i10);
                    a0Var.a();
                    break;
                } else {
                    com.google.gson.internal.a.m("closed");
                    break;
                }
        }
    }
}
