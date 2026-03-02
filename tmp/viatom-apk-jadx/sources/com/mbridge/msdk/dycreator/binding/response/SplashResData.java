package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class SplashResData extends BaseRespData {

    /* renamed from: a, reason: collision with root package name */
    private a f3193a;

    /* renamed from: b, reason: collision with root package name */
    private EAction f3194b;

    public a getBaseViewData() {
        return this.f3193a;
    }

    public EAction geteAction() {
        return this.f3194b;
    }

    public void setBaseViewData(a aVar) {
        this.f3193a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f3194b = eAction;
    }
}
