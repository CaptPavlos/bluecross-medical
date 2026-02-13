package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: b, reason: collision with root package name */
    protected Context f4422b;

    /* renamed from: c, reason: collision with root package name */
    protected Object f4423c;

    /* renamed from: d, reason: collision with root package name */
    protected WindVaneWebView f4424d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f4422b = context;
        this.f4424d = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f4423c = obj;
        this.f4424d = windVaneWebView;
    }
}
