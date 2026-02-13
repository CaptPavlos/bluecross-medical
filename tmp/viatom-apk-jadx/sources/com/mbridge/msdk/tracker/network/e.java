package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements z {

    /* renamed from: a, reason: collision with root package name */
    private int f5398a;

    /* renamed from: b, reason: collision with root package name */
    private long f5399b;

    /* renamed from: c, reason: collision with root package name */
    private int f5400c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5401d;

    public e(int i10, long j10, int i11) {
        this.f5399b = j10;
        this.f5398a = i10;
        this.f5401d = i11;
    }

    @Override // com.mbridge.msdk.tracker.network.z
    public final boolean a(ad adVar) {
        int i10 = this.f5400c + 1;
        this.f5400c = i10;
        return i10 <= this.f5401d;
    }

    @Override // com.mbridge.msdk.tracker.network.z
    public final long b() {
        return this.f5399b;
    }

    @Override // com.mbridge.msdk.tracker.network.z
    public final int c() {
        return this.f5400c;
    }

    public e(int i10, int i11) {
        this(i10, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, i11);
    }

    public e() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1);
    }

    @Override // com.mbridge.msdk.tracker.network.z
    public final int a() {
        return this.f5398a;
    }
}
