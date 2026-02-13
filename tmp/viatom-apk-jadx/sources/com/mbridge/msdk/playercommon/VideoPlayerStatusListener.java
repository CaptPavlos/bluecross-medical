package com.mbridge.msdk.playercommon;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(String str);

    void onPlayCompleted();

    void onPlayError(String str);

    void onPlayProgress(int i10, int i11);

    void onPlayProgressMS(int i10, int i11);

    void onPlaySetDataSourceError(String str);

    void onPlayStarted(int i10);
}
