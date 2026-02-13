package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.e;
import com.mbridge.msdk.video.signal.a.h;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a implements IJSFactory {

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.video.signal.b f6463a;

    /* renamed from: b, reason: collision with root package name */
    protected d f6464b;

    /* renamed from: c, reason: collision with root package name */
    protected j f6465c;

    /* renamed from: d, reason: collision with root package name */
    protected g f6466d;
    protected f e;
    protected i f;
    protected c g;

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        if (this.f6463a == null) {
            this.f6463a = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.f6463a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.video.signal.a.g();
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.g == null) {
            this.g = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        if (this.f6464b == null) {
            this.f6464b = new com.mbridge.msdk.video.signal.a.d();
        }
        return this.f6464b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        if (this.e == null) {
            this.e = new e();
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.f6466d == null) {
            this.f6466d = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f6466d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.f6465c == null) {
            this.f6465c = new h();
        }
        return this.f6465c;
    }
}
