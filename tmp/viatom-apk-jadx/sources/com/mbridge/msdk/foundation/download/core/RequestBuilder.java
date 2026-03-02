package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface RequestBuilder<T> {
    DownloadRequest<T> build();

    RequestBuilder<T> with(String str, String str2);

    RequestBuilder<T> withConnectTimeout(long j10);

    RequestBuilder<T> withDirectoryPathExternal(String str);

    RequestBuilder<T> withDirectoryPathInternal(String str);

    RequestBuilder<T> withDownloadPriority(DownloadPriority downloadPriority);

    RequestBuilder<T> withDownloadStateListener(OnDownloadStateListener onDownloadStateListener);

    RequestBuilder<T> withHeader(String str, String str2);

    RequestBuilder<T> withHttpRetryCounter(int i10);

    RequestBuilder<T> withProgressStateListener(OnProgressStateListener onProgressStateListener);

    RequestBuilder<T> withReadTimeout(long j10);

    RequestBuilder<T> withTimeout(long j10);

    RequestBuilder<T> withUserAgent(String str);

    RequestBuilder<T> withWriteTimeout(long j10);
}
