package com.mbridge.msdk.out;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IDownloadListener {
    void onEnd(int i10, int i11, String str);

    void onProgressUpdate(int i10);

    void onStart();

    void onStatus(int i10);
}
