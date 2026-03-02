package y1;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f13764a;

    /* renamed from: b, reason: collision with root package name */
    public int f13765b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f13766c;

    public j(l lVar, i iVar) {
        this.f13766c = lVar;
        this.f13764a = lVar.n(iVar.f13762a + 4);
        this.f13765b = iVar.f13763b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        if (bArr == null) {
            androidx.window.layout.c.k("buffer");
            return 0;
        }
        if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f13765b;
        if (i12 <= 0) {
            return -1;
        }
        if (i11 > i12) {
            i11 = i12;
        }
        int i13 = this.f13764a;
        l lVar = this.f13766c;
        lVar.k(i13, bArr, i10, i11);
        this.f13764a = lVar.n(this.f13764a + i11);
        this.f13765b -= i11;
        return i11;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        l lVar = this.f13766c;
        RandomAccessFile randomAccessFile = lVar.f13767a;
        if (this.f13765b == 0) {
            return -1;
        }
        randomAccessFile.seek(this.f13764a);
        int i10 = randomAccessFile.read();
        this.f13764a = lVar.n(this.f13764a + 1);
        this.f13765b--;
        return i10;
    }
}
