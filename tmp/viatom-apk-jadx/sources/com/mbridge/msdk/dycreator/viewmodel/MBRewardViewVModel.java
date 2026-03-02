package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.f.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBRewardViewVModel implements BaseViewModel {

    /* renamed from: a, reason: collision with root package name */
    private d f3262a;

    /* renamed from: b, reason: collision with root package name */
    private c f3263b;

    /* renamed from: c, reason: collision with root package name */
    private f f3264c;

    /* renamed from: d, reason: collision with root package name */
    private h f3265d;
    private DynamicViewBackListener e;
    private DyOption f;

    public MBRewardViewVModel(DyOption dyOption) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f = dyOption;
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f3263b = cVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f3262a = dVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.e = dynamicViewBackListener;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f3264c = fVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setModelDataAndBind() {
        a aVar = new a(this.f);
        d dVar = this.f3262a;
        if (dVar != null) {
            dVar.a(aVar);
        }
        c cVar = this.f3263b;
        if (cVar != null) {
            cVar.a(aVar);
        }
        f fVar = this.f3264c;
        if (fVar != null) {
            fVar.a(aVar);
        }
        h hVar = this.f3265d;
        if (hVar != null) {
            hVar.a(aVar);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f3265d = hVar;
        }
    }
}
