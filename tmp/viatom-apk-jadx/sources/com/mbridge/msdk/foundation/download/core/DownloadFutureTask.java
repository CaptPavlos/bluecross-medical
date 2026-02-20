package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadPriority;
import java.util.concurrent.FutureTask;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DownloadFutureTask extends FutureTask<Downloader> implements Comparable<DownloadFutureTask> {
    private final Downloader downloader;

    public DownloadFutureTask(Downloader downloader) {
        super(downloader, null);
        this.downloader = downloader;
    }

    @Override // java.lang.Comparable
    public int compareTo(DownloadFutureTask downloadFutureTask) {
        Downloader downloader = this.downloader;
        DownloadPriority downloadPriority = downloader.downloadPriority;
        Downloader downloader2 = downloadFutureTask.downloader;
        DownloadPriority downloadPriority2 = downloader2.downloadPriority;
        return downloadPriority == downloadPriority2 ? downloader.sequence - downloader2.sequence : downloadPriority2.ordinal() - downloadPriority.ordinal();
    }
}
