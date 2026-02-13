package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@TargetApi(16)
/* loaded from: classes3.dex */
public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    private final boolean forceAllowInsecureDecoderComponents;
    private final MediaCrypto mediaCrypto;

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto, boolean z9) {
        this.mediaCrypto = (MediaCrypto) Assertions.checkNotNull(mediaCrypto);
        this.forceAllowInsecureDecoderComponents = z9;
    }

    public final MediaCrypto getWrappedMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto
    public final boolean requiresSecureDecoderComponent(String str) {
        return !this.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
    }

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto) {
        this(mediaCrypto, false);
    }
}
