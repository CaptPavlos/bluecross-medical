package com.mbridge.msdk.foundation.download;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DownloadError {
    private Exception exception;

    public DownloadError(Exception exc) {
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
