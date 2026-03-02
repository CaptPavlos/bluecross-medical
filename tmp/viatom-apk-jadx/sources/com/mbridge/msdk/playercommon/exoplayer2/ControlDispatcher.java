package com.mbridge.msdk.playercommon.exoplayer2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int i10, long j10);

    boolean dispatchSetPlayWhenReady(Player player, boolean z9);

    boolean dispatchSetRepeatMode(Player player, int i10);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z9);

    boolean dispatchStop(Player player, boolean z9);
}
