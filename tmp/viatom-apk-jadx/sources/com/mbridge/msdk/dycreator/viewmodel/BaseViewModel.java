package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface BaseViewModel {
    void setClickSubject(c cVar);

    void setConcreteSubject(d dVar);

    void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener);

    void setEffectSubject(f fVar);

    void setModelDataAndBind();

    void setReportSubject(h hVar);
}
