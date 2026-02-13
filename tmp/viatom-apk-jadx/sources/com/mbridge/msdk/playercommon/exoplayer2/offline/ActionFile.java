package com.mbridge.msdk.playercommon.exoplayer2.offline;

import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.util.AtomicFile;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ActionFile {
    static final int VERSION = 0;
    private final File actionFile;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.actionFile = file;
        this.atomicFile = new AtomicFile(file);
    }

    public final DownloadAction[] load(DownloadAction.Deserializer... deserializerArr) throws IOException {
        if (!this.actionFile.exists()) {
            return new DownloadAction[0];
        }
        try {
            InputStream inputStreamOpenRead = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(inputStreamOpenRead);
            int i10 = dataInputStream.readInt();
            if (i10 > 0) {
                throw new IOException("Unsupported action file version: " + i10);
            }
            int i11 = dataInputStream.readInt();
            DownloadAction[] downloadActionArr = new DownloadAction[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                downloadActionArr[i12] = DownloadAction.deserializeFromStream(deserializerArr, dataInputStream);
            }
            Util.closeQuietly(inputStreamOpenRead);
            return downloadActionArr;
        } catch (Throwable th) {
            Util.closeQuietly((Closeable) null);
            throw th;
        }
    }

    public final void store(DownloadAction... downloadActionArr) throws Throwable {
        DataOutputStream dataOutputStream;
        int i10;
        DataOutputStream dataOutputStream2 = null;
        try {
            dataOutputStream = new DataOutputStream(this.atomicFile.startWrite());
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(downloadActionArr.length);
            for (DownloadAction downloadAction : downloadActionArr) {
                DownloadAction.serializeToStream(downloadAction, dataOutputStream);
            }
            this.atomicFile.endWrite(dataOutputStream);
            Util.closeQuietly((Closeable) null);
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            Util.closeQuietly(dataOutputStream2);
            throw th;
        }
    }
}
