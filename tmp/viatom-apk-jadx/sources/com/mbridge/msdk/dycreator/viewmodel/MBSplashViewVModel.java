package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.x;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBSplashViewVModel implements BaseViewModel {

    /* renamed from: a, reason: collision with root package name */
    private d f3266a;

    /* renamed from: b, reason: collision with root package name */
    private c f3267b;

    /* renamed from: c, reason: collision with root package name */
    private f f3268c;

    /* renamed from: d, reason: collision with root package name */
    private h f3269d;
    private DynamicViewBackListener e;
    private DyOption f;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3270a;

        static {
            int[] iArr = new int[EAction.values().length];
            f3270a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3270a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MBSplashViewVModel(DyOption dyOption) throws IllegalAccessException, Error, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f = dyOption;
        String campaignUnitId = (dyOption == null || dyOption.getCampaignEx() == null) ? "" : dyOption.getCampaignEx().getCampaignUnitId();
        if (TextUtils.isEmpty(campaignUnitId)) {
            EventBus.getDefault().register(this);
        } else {
            EventBus.getDefault().register(campaignUnitId, this);
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        if (this.e == null || splashResData == null) {
            return;
        }
        int i10 = AnonymousClass1.f3270a[splashResData.geteAction().ordinal()];
        if (i10 == 1 || i10 == 2) {
            try {
                String campaignUnitId = "";
                if (splashResData.getBaseViewData() != null && splashResData.getBaseViewData().getBindData() != null) {
                    campaignUnitId = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
                }
                if (TextUtils.isEmpty(campaignUnitId)) {
                    EventBus.getDefault().unregister(this);
                    b.a().b();
                } else {
                    EventBus.getDefault().unregister(campaignUnitId);
                    b.a().b();
                }
            } catch (Exception e) {
                e.printStackTrace();
                EventBus.getDefault().unregister(this);
                EventBus.getDefault().release();
                b.a().b();
            }
        }
        this.e.viewClicked(splashResData);
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f3267b = cVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f3266a = dVar;
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
            this.f3268c = fVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setModelDataAndBind() {
        MBSplashData mBSplashData = new MBSplashData(this.f);
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC != null) {
            DyOption dyOption = this.f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                mBSplashData.setCountDownText(contextC.getResources().getString(x.a(contextC, this.f.isCanSkip() ? "mbridge_splash_count_time_can_skip" : "mbridge_splash_count_time_can_skip_not", TypedValues.Custom.S_STRING)));
            }
            mBSplashData.setNoticeImage(x.a(contextC, "mbridge_splash_notice", "drawable"));
            String strT = ab.t(contextC);
            mBSplashData.setLogoText((TextUtils.isEmpty(strT) || !strT.contains("zh")) ? "AD" : "广告");
        }
        d dVar = this.f3266a;
        if (dVar != null) {
            dVar.a(mBSplashData);
        }
        c cVar = this.f3267b;
        if (cVar != null) {
            cVar.a(mBSplashData);
        }
        f fVar = this.f3268c;
        if (fVar != null) {
            fVar.a(mBSplashData);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f3269d = hVar;
        }
    }
}
