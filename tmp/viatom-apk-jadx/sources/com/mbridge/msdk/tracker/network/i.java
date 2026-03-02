package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i<T> extends u<T> {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f5410a = "i";

    /* renamed from: b, reason: collision with root package name */
    private final long f5411b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f5412c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f5413d;
    private z e;
    private boolean f;

    public i(int i10, String str, int i11, String str2, long j10) {
        super(i10, str, i11, str2);
        this.f = false;
        if (j10 > 0) {
            this.f5411b = j10;
        } else {
            this.f5411b = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
    }

    public final void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (this.f5412c == null) {
            this.f5412c = new HashMap();
        }
        try {
            this.f5412c.putAll(map);
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("addParams error: "), f5410a);
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final z b() {
        if (this.e == null) {
            this.e = new e(30000, this.f5411b, 3);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> c() {
        if (this.f5413d == null) {
            this.f5413d = new HashMap();
        }
        this.f5413d.put("Charset", C.UTF8_NAME);
        return this.f5413d;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final boolean d() {
        return this.f && com.mbridge.msdk.foundation.same.d.a(f(), k());
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f5413d == null) {
            this.f5413d = new HashMap();
        }
        try {
            this.f5413d.put(str, str2);
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("addHeader error: "), f5410a);
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> a() {
        if (this.f5412c == null) {
            this.f5412c = new HashMap();
        }
        return this.f5412c;
    }

    public final void a(boolean z9) {
        this.f = z9;
    }
}
