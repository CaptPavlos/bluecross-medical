package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface TransferListener<S> {
    void onBytesTransferred(S s9, int i10);

    void onTransferEnd(S s9);

    void onTransferStart(S s9, DataSpec dataSpec);
}
