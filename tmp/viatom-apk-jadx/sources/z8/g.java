package z8;

import com.google.android.gms.internal.measurement.l5;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14473a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f14474b;

    public /* synthetic */ g(k kVar, int i10) {
        this.f14473a = i10;
        this.f14474b = kVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        switch (this.f14473a) {
            case 0:
                return (int) Math.min(((i) this.f14474b).f14479b, Integer.MAX_VALUE);
            default:
                b0 b0Var = (b0) this.f14474b;
                if (!b0Var.f14458c) {
                    return (int) Math.min(b0Var.f14457b.f14479b, Integer.MAX_VALUE);
                }
                com.google.gson.internal.a.m("closed");
                return 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f14473a) {
            case 0:
                break;
            default:
                ((b0) this.f14474b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f14473a) {
            case 0:
                i iVar = (i) this.f14474b;
                if (iVar.f14479b > 0) {
                    return iVar.readByte() & 255;
                }
                return -1;
            default:
                b0 b0Var = (b0) this.f14474b;
                i iVar2 = b0Var.f14457b;
                if (b0Var.f14458c) {
                    com.google.gson.internal.a.m("closed");
                    return 0;
                }
                if (iVar2.f14479b == 0 && b0Var.f14456a.g(iVar2, 8192L) == -1) {
                    return -1;
                }
                return iVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f14473a) {
            case 0:
                return ((i) this.f14474b) + ".inputStream()";
            default:
                return ((b0) this.f14474b) + ".inputStream()";
        }
    }

    private final void a() {
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f14473a;
        bArr.getClass();
        switch (i12) {
            case 0:
                return ((i) this.f14474b).read(bArr, i10, i11);
            default:
                b0 b0Var = (b0) this.f14474b;
                i iVar = b0Var.f14457b;
                if (!b0Var.f14458c) {
                    l5.k(bArr.length, i10, i11);
                    if (iVar.f14479b == 0 && b0Var.f14456a.g(iVar, 8192L) == -1) {
                        return -1;
                    }
                    return iVar.read(bArr, i10, i11);
                }
                com.google.gson.internal.a.m("closed");
                return 0;
        }
    }
}
