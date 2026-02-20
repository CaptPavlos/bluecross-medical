package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface ContentMetadata {
    public static final String INTERNAL_METADATA_NAME_PREFIX = "exo_";

    boolean contains(String str);

    long get(String str, long j10);

    String get(String str, String str2);

    byte[] get(String str, byte[] bArr);
}
