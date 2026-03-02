package y1;

import com.google.android.gms.internal.measurement.p4;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements Closeable {
    public static final Logger g = Logger.getLogger(l.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f13767a;

    /* renamed from: b, reason: collision with root package name */
    public int f13768b;

    /* renamed from: c, reason: collision with root package name */
    public int f13769c;

    /* renamed from: d, reason: collision with root package name */
    public i f13770d;
    public i e;
    public final byte[] f;

    public l(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.f = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i10 = 0;
                for (int i11 = 0; i11 < 4; i11++) {
                    p(i10, iArr[i11], bArr2);
                    i10 += 4;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    com.google.gson.internal.a.m("Rename failed!");
                    throw null;
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f13767a = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int i12 = i(0, bArr);
        this.f13768b = i12;
        if (i12 <= randomAccessFile2.length()) {
            this.f13769c = i(4, bArr);
            int i13 = i(8, bArr);
            int i14 = i(12, bArr);
            this.f13770d = h(i13);
            this.e = h(i14);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f13768b + ", Actual length: " + randomAccessFile2.length());
    }

    public static int i(int i10, byte[] bArr) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    public static void p(int i10, int i11, byte[] bArr) {
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    public final void a(byte[] bArr) {
        int iN;
        int length = bArr.length;
        synchronized (this) {
            if (length >= 0) {
                if (length <= bArr.length) {
                    d(length);
                    boolean zF = f();
                    if (zF) {
                        iN = 16;
                    } else {
                        i iVar = this.e;
                        iN = n(iVar.f13762a + 4 + iVar.f13763b);
                    }
                    i iVar2 = new i(iN, length);
                    p(0, length, this.f);
                    l(iN, 4, this.f);
                    l(iN + 4, length, bArr);
                    o(this.f13768b, this.f13769c + 1, zF ? iN : this.f13770d.f13762a, iN);
                    this.e = iVar2;
                    this.f13769c++;
                    if (zF) {
                        this.f13770d = iVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public final synchronized void b() {
        o(4096, 0, 0, 0);
        this.f13769c = 0;
        i iVar = i.f13761c;
        this.f13770d = iVar;
        this.e = iVar;
        if (this.f13768b > 4096) {
            RandomAccessFile randomAccessFile = this.f13767a;
            randomAccessFile.setLength(4096);
            randomAccessFile.getChannel().force(true);
        }
        this.f13768b = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f13767a.close();
    }

    public final void d(int i10) throws IOException {
        int i11 = i10 + 4;
        int iM = this.f13768b - m();
        if (iM >= i11) {
            return;
        }
        int i12 = this.f13768b;
        do {
            iM += i12;
            i12 <<= 1;
        } while (iM < i11);
        RandomAccessFile randomAccessFile = this.f13767a;
        randomAccessFile.setLength(i12);
        randomAccessFile.getChannel().force(true);
        i iVar = this.e;
        int iN = n(iVar.f13762a + 4 + iVar.f13763b);
        if (iN < this.f13770d.f13762a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f13768b);
            long j10 = iN - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                u.h("Copied insufficient number of bytes!");
                return;
            }
        }
        int i13 = this.e.f13762a;
        int i14 = this.f13770d.f13762a;
        if (i13 < i14) {
            int i15 = (this.f13768b + i13) - 16;
            o(i12, this.f13769c, i14, i15);
            this.e = new i(i15, this.e.f13763b);
        } else {
            o(i12, this.f13769c, i14, i13);
        }
        this.f13768b = i12;
    }

    public final synchronized void e(k kVar) {
        int iN = this.f13770d.f13762a;
        for (int i10 = 0; i10 < this.f13769c; i10++) {
            i iVarH = h(iN);
            kVar.a(new j(this, iVarH), iVarH.f13763b);
            iN = n(iVarH.f13762a + 4 + iVarH.f13763b);
        }
    }

    public final synchronized boolean f() {
        return this.f13769c == 0;
    }

    public final i h(int i10) throws IOException {
        if (i10 == 0) {
            return i.f13761c;
        }
        RandomAccessFile randomAccessFile = this.f13767a;
        randomAccessFile.seek(i10);
        return new i(i10, randomAccessFile.readInt());
    }

    public final synchronized void j() {
        try {
            if (f()) {
                throw new NoSuchElementException();
            }
            if (this.f13769c == 1) {
                b();
            } else {
                i iVar = this.f13770d;
                int iN = n(iVar.f13762a + 4 + iVar.f13763b);
                k(iN, this.f, 0, 4);
                int i10 = i(0, this.f);
                o(this.f13768b, this.f13769c - 1, iN, this.e.f13762a);
                this.f13769c--;
                this.f13770d = new i(iN, i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iN = n(i10);
        int i13 = iN + i12;
        int i14 = this.f13768b;
        RandomAccessFile randomAccessFile = this.f13767a;
        if (i13 <= i14) {
            randomAccessFile.seek(iN);
            randomAccessFile.readFully(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iN;
        randomAccessFile.seek(iN);
        randomAccessFile.readFully(bArr, i11, i15);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i11 + i15, i12 - i15);
    }

    public final void l(int i10, int i11, byte[] bArr) throws IOException {
        int iN = n(i10);
        int i12 = iN + i11;
        int i13 = this.f13768b;
        RandomAccessFile randomAccessFile = this.f13767a;
        if (i12 <= i13) {
            randomAccessFile.seek(iN);
            randomAccessFile.write(bArr, 0, i11);
            return;
        }
        int i14 = i13 - iN;
        randomAccessFile.seek(iN);
        randomAccessFile.write(bArr, 0, i14);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i14, i11 - i14);
    }

    public final int m() {
        if (this.f13769c == 0) {
            return 16;
        }
        i iVar = this.e;
        int i10 = iVar.f13762a;
        int i11 = this.f13770d.f13762a;
        return i10 >= i11 ? (i10 - i11) + 4 + iVar.f13763b + 16 : (((i10 + 4) + iVar.f13763b) + this.f13768b) - i11;
    }

    public final int n(int i10) {
        int i11 = this.f13768b;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    public final void o(int i10, int i11, int i12, int i13) throws IOException {
        int[] iArr = {i10, i11, i12, i13};
        int i14 = 0;
        int i15 = 0;
        while (true) {
            byte[] bArr = this.f;
            if (i14 >= 4) {
                RandomAccessFile randomAccessFile = this.f13767a;
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                return;
            } else {
                p(i15, iArr[i14], bArr);
                i15 += 4;
                i14++;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(l.class.getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.f13768b);
        sb.append(", size=");
        sb.append(this.f13769c);
        sb.append(", first=");
        sb.append(this.f13770d);
        sb.append(", last=");
        sb.append(this.e);
        sb.append(", element lengths=[");
        try {
            e(new p4(sb));
        } catch (IOException e) {
            g.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }
}
