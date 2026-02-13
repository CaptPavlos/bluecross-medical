package com.mbridge.msdk.foundation.download.core;

import a2.a;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadResponse;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class SynchronizeAvailableDirectorPath implements IDownloadTask {
    private int cacheDirectorPathType;
    private String cacheDirectoryPath;
    private String cacheDirectoryPathExternal;
    private String cacheDirectoryPathInternal;
    private DownloadRequest downloadRequest;

    public SynchronizeAvailableDirectorPath(DownloadRequest downloadRequest) {
        this.downloadRequest = downloadRequest;
    }

    public static IDownloadTask create(DownloadRequest downloadRequest) {
        return new SynchronizeAvailableDirectorPath(downloadRequest);
    }

    @Override // com.mbridge.msdk.foundation.download.core.IDownloadTask
    public DownloadResponse run() {
        String str;
        DownloadRequest downloadRequest;
        this.cacheDirectoryPathExternal = this.downloadRequest.getDirectoryPathExternal();
        String directoryPathInternal = this.downloadRequest.getDirectoryPathInternal();
        this.cacheDirectoryPathInternal = directoryPathInternal;
        if (TextUtils.isEmpty(directoryPathInternal)) {
            a.j("必须指定 cacheDirectoryPathInternal");
            return null;
        }
        try {
            try {
                if (!TextUtils.isEmpty(this.cacheDirectoryPathExternal) && Build.VERSION.SDK_INT <= 28) {
                    GlobalComponent.getInstance().getContext();
                    this.cacheDirectoryPath = this.cacheDirectoryPathInternal;
                    this.cacheDirectorPathType = 0;
                } else {
                    this.cacheDirectoryPath = this.cacheDirectoryPathInternal;
                    this.cacheDirectorPathType = 0;
                }
                downloadRequest = this.downloadRequest;
                str = this.cacheDirectoryPath;
            } catch (Exception unused) {
                str = this.cacheDirectoryPathInternal;
                this.cacheDirectoryPath = str;
                this.cacheDirectorPathType = 0;
                downloadRequest = this.downloadRequest;
            }
            downloadRequest.setCacheDirectoryPath(str);
            this.downloadRequest.setCacheDirectorPathType(this.cacheDirectorPathType);
            return null;
        } catch (Throwable th) {
            this.downloadRequest.setCacheDirectoryPath(this.cacheDirectoryPath);
            this.downloadRequest.setCacheDirectorPathType(this.cacheDirectorPathType);
            throw th;
        }
    }
}
