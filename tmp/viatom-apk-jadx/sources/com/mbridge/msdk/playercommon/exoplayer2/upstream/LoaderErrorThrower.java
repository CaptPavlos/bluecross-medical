package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface LoaderErrorThrower {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public final void maybeThrowError(int i10) throws IOException {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public final void maybeThrowError() throws IOException {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i10) throws IOException;
}
