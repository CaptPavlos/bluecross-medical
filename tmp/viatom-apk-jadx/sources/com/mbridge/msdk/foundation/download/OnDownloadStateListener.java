package com.mbridge.msdk.foundation.download;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface OnDownloadStateListener<T> {
    void onCancelDownload(DownloadMessage<T> downloadMessage);

    void onDownloadComplete(DownloadMessage<T> downloadMessage);

    void onDownloadError(DownloadMessage<T> downloadMessage, DownloadError downloadError);

    void onDownloadStart(DownloadMessage<T> downloadMessage);
}
