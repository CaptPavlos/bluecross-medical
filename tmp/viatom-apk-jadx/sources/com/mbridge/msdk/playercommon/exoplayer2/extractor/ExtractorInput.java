package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface ExtractorInput {
    void advancePeekPosition(int i10) throws InterruptedException, IOException;

    boolean advancePeekPosition(int i10, boolean z9) throws InterruptedException, IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i10, int i11) throws InterruptedException, IOException;

    boolean peekFully(byte[] bArr, int i10, int i11, boolean z9) throws InterruptedException, IOException;

    int read(byte[] bArr, int i10, int i11) throws InterruptedException, IOException;

    void readFully(byte[] bArr, int i10, int i11) throws InterruptedException, IOException;

    boolean readFully(byte[] bArr, int i10, int i11, boolean z9) throws InterruptedException, IOException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j10, E e) throws Throwable;

    int skip(int i10) throws InterruptedException, IOException;

    void skipFully(int i10) throws InterruptedException, IOException;

    boolean skipFully(int i10, boolean z9) throws InterruptedException, IOException;
}
