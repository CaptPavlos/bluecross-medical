package z8;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class w extends p {
    @Override // z8.p
    public void a(z zVar, z zVar2) throws IOException {
        zVar2.getClass();
        if (zVar.toFile().renameTo(zVar2.toFile())) {
            return;
        }
        f.d(zVar, "failed to move ", zVar2);
    }

    @Override // z8.p
    public final void b(z zVar) throws IOException {
        if (zVar.toFile().mkdir()) {
            return;
        }
        o oVarE = e(zVar);
        if (oVarE == null || !oVarE.f14498b) {
            f.c(zVar, "failed to create directory: ");
        }
    }

    @Override // z8.p
    public final void c(z zVar) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = zVar.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        f.c(zVar, "failed to delete ");
    }

    @Override // z8.p
    public o e(z zVar) {
        zVar.getClass();
        File file = zVar.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new o(zIsFile, zIsDirectory, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // z8.p
    public final v f(z zVar) {
        return new v(false, new RandomAccessFile(zVar.toFile(), CampaignEx.JSON_KEY_AD_R));
    }

    @Override // z8.p
    public final v g(z zVar) {
        return new v(true, new RandomAccessFile(zVar.toFile(), "rw"));
    }

    @Override // z8.p
    public final h0 h(z zVar) {
        zVar.getClass();
        return t1.S(zVar.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
