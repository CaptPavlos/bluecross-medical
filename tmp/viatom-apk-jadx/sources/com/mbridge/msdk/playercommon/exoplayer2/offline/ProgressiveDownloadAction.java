package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ProgressiveDownloadAction extends DownloadAction {
    private static final int VERSION = 0;

    @Nullable
    public final String customCacheKey;
    private static final String TYPE = "progressive";
    public static final DownloadAction.Deserializer DESERIALIZER = new DownloadAction.Deserializer(TYPE, 0) { // from class: com.mbridge.msdk.playercommon.exoplayer2.offline.ProgressiveDownloadAction.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction.Deserializer
        public final ProgressiveDownloadAction readFromStream(int i10, DataInputStream dataInputStream) throws IOException {
            Uri uri = Uri.parse(dataInputStream.readUTF());
            boolean z9 = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            return new ProgressiveDownloadAction(uri, z9, bArr, dataInputStream.readBoolean() ? dataInputStream.readUTF() : null);
        }
    };

    public ProgressiveDownloadAction(Uri uri, boolean z9, @Nullable byte[] bArr, @Nullable String str) {
        super(TYPE, 0, uri, z9, bArr);
        this.customCacheKey = str;
    }

    private String getCacheKey() {
        String str = this.customCacheKey;
        return str != null ? str : CacheUtil.generateKey(this.uri);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final ProgressiveDownloader createDownloader(DownloaderConstructorHelper downloaderConstructorHelper) {
        return new ProgressiveDownloader(this.uri, this.customCacheKey, downloaderConstructorHelper);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj)) {
            return Util.areEqual(this.customCacheKey, ((ProgressiveDownloadAction) obj).customCacheKey);
        }
        return false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.customCacheKey;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final boolean isSameMedia(DownloadAction downloadAction) {
        return (downloadAction instanceof ProgressiveDownloadAction) && getCacheKey().equals(((ProgressiveDownloadAction) downloadAction).getCacheKey());
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        boolean z9 = this.customCacheKey != null;
        dataOutputStream.writeBoolean(z9);
        if (z9) {
            dataOutputStream.writeUTF(this.customCacheKey);
        }
    }
}
