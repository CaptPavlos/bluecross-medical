package com.mbridge.msdk.b.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements PreloadListener {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<PreloadListener> f2635a;

    /* renamed from: b, reason: collision with root package name */
    private int f2636b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2637c = false;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f2635a = new WeakReference<>(preloadListener);
        }
    }

    public final boolean a() {
        return this.f2637c;
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f2635a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f2635a.get().onPreloadFaild(str);
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f2635a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f2635a.get().onPreloadSucceed();
    }

    public final void a(boolean z9) {
        this.f2637c = z9;
    }
}
