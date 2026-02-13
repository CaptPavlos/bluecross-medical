package com.mbridge.msdk.playercommon.exoplayer2.drm;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i10, String str) {
        super(str);
        this.errorCode = i10;
    }
}
