package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends c {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6150a;

    /* renamed from: b, reason: collision with root package name */
    private MBridgeBTContainer f6151b;

    public j(Activity activity, MBridgeBTContainer mBridgeBTContainer) {
        this.f6150a = activity;
        this.f6151b = mBridgeBTContainer;
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.e
    public final void click(int i10, String str) {
        super.click(i10, str);
        MBridgeBTContainer mBridgeBTContainer = this.f6151b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.click(i10, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.e
    public final void handlerH5Exception(int i10, String str) {
        super.handlerH5Exception(i10, str);
        MBridgeBTContainer mBridgeBTContainer = this.f6151b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.handlerH5Exception(i10, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.c
    public final void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f6151b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reactDeveloper(obj, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.c
    public final void reportUrls(Object obj, String str) {
        super.reportUrls(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f6151b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reportUrls(obj, str);
        } else {
            com.mbridge.msdk.video.bt.a.d.c().b(obj, str);
        }
    }
}
