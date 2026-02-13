package com.mbridge.msdk.video.dynview.moffer;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.module.MBridgeNativeEndCardView;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5843a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, SoftReference<MOfferModel>> f5844b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private int f5845c = 500;

    private a() {
    }

    public static /* synthetic */ void a(a aVar, final MOfferModel mOfferModel, ViewGroup viewGroup, ViewGroup viewGroup2, CampaignUnit campaignUnit) throws Resources.NotFoundException {
        View viewFindViewById;
        int iB;
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;
        if (mOfferModel == null || viewGroup == null || viewGroup2 == null || campaignUnit == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        RelativeLayout.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.addRule(12, -1);
        int iA = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
        layoutParams2.setMargins(iA, iA, iA, iA);
        if (viewGroup2.getBackground() == null) {
            try {
                Drawable drawable = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getDrawable(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_more_offer_default_bg", "drawable"));
                if (drawable != null && (viewFindViewById = viewGroup2.findViewById(aVar.b("mbridge_moreoffer_hls"))) != null) {
                    viewFindViewById.setBackground(drawable);
                }
            } catch (Exception e) {
                af.b("MOfferEnergize", e.getMessage());
            }
        }
        viewGroup2.setLayoutParams(layoutParams2);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
        }
        if (mOfferModel.getECParentTemplateCode() == 1302) {
            try {
                if (mOfferModel.getmMainOfferCampaignEx() == null || mOfferModel.getmMainOfferCampaignEx().getRewardTemplateMode() == null) {
                    iB = 1;
                } else {
                    iB = mOfferModel.getmMainOfferCampaignEx().getRewardTemplateMode().b();
                    if (iB == 0) {
                        iB = ab.s(com.mbridge.msdk.foundation.controller.c.m().c());
                    }
                }
                if (iB != 1 && (viewGroup instanceof MBridgeNativeEndCardView)) {
                    ImageView imageView2 = ((MBridgeNativeEndCardView) viewGroup).isDyXmlSuccess() ? (ImageView) viewGroup.findViewById(-1803557032) : (ImageView) viewGroup.findViewById(aVar.b("mbridge_iv_adbanner"));
                    int iG = ak.g(com.mbridge.msdk.foundation.controller.c.m().c()) - ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 220.0f);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                    layoutParams3.height = iG;
                    layoutParams3.width = (iG * 16) / 9;
                    imageView2.setLayoutParams(layoutParams3);
                }
                if (viewGroup instanceof MBridgeNativeEndCardView) {
                    if (((MBridgeNativeEndCardView) viewGroup).isDyXmlSuccess()) {
                        relativeLayout = (RelativeLayout) viewGroup.findViewById(-1642631508);
                        imageView = (ImageView) viewGroup.findViewById(389008949);
                        textView = (TextView) viewGroup.findViewById(1561614848);
                    } else {
                        relativeLayout = (RelativeLayout) viewGroup.findViewById(aVar.b("mbridge_native_ec_layout"));
                        imageView = (ImageView) viewGroup.findViewById(aVar.b("mbridge_iv_flag"));
                        textView = (TextView) viewGroup.findViewById(aVar.b("mbridge_tv_flag"));
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(imageView);
                    arrayList.add(textView);
                    new com.mbridge.msdk.video.dynview.h.b().a(arrayList, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), aVar.f5845c);
                } else {
                    relativeLayout = null;
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
                layoutParams4.setMargins(0, 0, 0, 0);
                viewGroup2.setLayoutParams(layoutParams4);
                if (relativeLayout != null) {
                    relativeLayout.addView(viewGroup2);
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        } else {
            try {
                if (viewGroup instanceof MBridgeNativeEndCardView) {
                    RelativeLayout relativeLayout2 = ((MBridgeNativeEndCardView) viewGroup).isDyXmlSuccess() ? (RelativeLayout) viewGroup.findViewById(-1642631508) : (RelativeLayout) viewGroup.findViewById(aVar.b("mbridge_native_ec_layout"));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(relativeLayout2);
                    new com.mbridge.msdk.video.dynview.h.b().a(arrayList2, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), aVar.f5845c);
                }
                RelativeLayout relativeLayout3 = (RelativeLayout) viewGroup.findViewById(aVar.b("mbridge_reward_moreoffer_layout"));
                if (relativeLayout3 == null) {
                    relativeLayout3 = (RelativeLayout) viewGroup.findViewById(-82036151);
                }
                if (relativeLayout3 == null) {
                    viewGroup.addView(viewGroup2);
                } else if (viewGroup.isShown()) {
                    relativeLayout3.setVisibility(0);
                    relativeLayout3.addView(viewGroup2);
                }
            } catch (Exception e7) {
                af.b("MOfferEnergize", e7.getMessage());
            }
        }
        new com.mbridge.msdk.video.dynview.h.b().a(viewGroup2, 0, ak.f(com.mbridge.msdk.foundation.controller.c.m().c()), 0, com.mbridge.msdk.dycreator.baseview.a.e(100.0f), 0L);
        if (viewGroup instanceof MBridgeNativeEndCardView) {
            ((MBridgeNativeEndCardView) viewGroup).setMoreOfferCampaignUnit(campaignUnit);
        }
        viewGroup.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.dynview.moffer.a.2
            @Override // java.lang.Runnable
            public final void run() {
                MOfferModel mOfferModel2 = mOfferModel;
                if (mOfferModel2 != null) {
                    mOfferModel2.checkViewVisiableState();
                }
            }
        }, aVar.f5845c + 500);
    }

    public final void b() {
        MOfferModel mOfferModel;
        try {
            Map<String, SoftReference<MOfferModel>> map = this.f5844b;
            if (map != null) {
                for (SoftReference<MOfferModel> softReference : map.values()) {
                    if (softReference != null && (mOfferModel = softReference.get()) != null) {
                        mOfferModel.mofDestroy();
                    }
                }
                this.f5844b.clear();
            }
        } catch (Exception e) {
            af.b("MOfferEnergize", e.getMessage());
        }
    }

    private int b(String str) {
        return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }

    public final void a(final ViewGroup viewGroup, String str, com.mbridge.msdk.video.module.a.a aVar) {
        if (viewGroup == null || aVar == null || this.f5844b == null || TextUtils.isEmpty(str) || !this.f5844b.containsKey(str)) {
            return;
        }
        SoftReference<MOfferModel> softReference = this.f5844b.get(str);
        final MOfferModel mOfferModel = (softReference == null || softReference.get() == null) ? null : softReference.get();
        if (mOfferModel == null) {
            return;
        }
        mOfferModel.setMoreOfferListener(new g() { // from class: com.mbridge.msdk.video.dynview.moffer.a.1
            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(ViewGroup viewGroup2, CampaignUnit campaignUnit) {
                ViewGroup viewGroup3;
                if (viewGroup2 == null || (viewGroup3 = viewGroup) == null) {
                    return;
                }
                try {
                    a.a(a.this, mOfferModel, viewGroup3, viewGroup2, campaignUnit);
                } catch (Exception e) {
                    af.b("MOfferEnergize", e.getMessage());
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(int i10, String str2) {
                af.b("MOfferEnergize", str2);
            }
        }, aVar);
        mOfferModel.showView();
    }

    public final void a(CampaignEx campaignEx, int i10) {
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
        if (this.f5844b == null) {
            this.f5844b = new ConcurrentHashMap();
        }
        if (this.f5844b.containsKey(str)) {
            return;
        }
        try {
            MOfferModel mOfferModel = new MOfferModel();
            mOfferModel.setFromType(i10);
            SoftReference<MOfferModel> softReference = new SoftReference<>(mOfferModel);
            if (softReference.get() != null) {
                this.f5844b.put(str, softReference);
                softReference.get().buildMofferAd(campaignEx);
            }
        } catch (Exception e) {
            af.b("MOfferEnergize", e.getMessage());
        }
    }

    public final void a(CampaignEx campaignEx, final ViewGroup viewGroup, com.mbridge.msdk.video.module.a.a aVar, int i10) {
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
        if (this.f5844b == null) {
            this.f5844b = new ConcurrentHashMap();
        }
        try {
            MOfferModel mOfferModel = new MOfferModel();
            mOfferModel.setFromType(i10);
            SoftReference<MOfferModel> softReference = new SoftReference<>(mOfferModel);
            if (softReference.get() != null) {
                this.f5844b.put(str, softReference);
                final MOfferModel mOfferModel2 = softReference.get();
                mOfferModel2.setMoreOfferListener(new g() { // from class: com.mbridge.msdk.video.dynview.moffer.a.3
                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(ViewGroup viewGroup2, CampaignUnit campaignUnit) {
                        if (viewGroup2 == null || campaignUnit == null) {
                            return;
                        }
                        try {
                            a.a(a.this, mOfferModel2, viewGroup, viewGroup2, campaignUnit);
                        } catch (Exception e) {
                            af.b("MOfferEnergize", e.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(int i11, String str2) {
                    }
                }, aVar);
                mOfferModel2.setIsRetry(true);
                mOfferModel2.buildMofferAd(campaignEx);
            }
        } catch (Exception e) {
            af.b("MOfferEnergize", e.getMessage());
        }
    }

    public final boolean a(String str) {
        if (this.f5844b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f5844b.containsKey(str);
    }

    public static a a() {
        a aVar;
        if (f5843a == null) {
            synchronized (a.class) {
                try {
                    if (f5843a == null) {
                        f5843a = new a();
                    }
                    aVar = f5843a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return f5843a;
    }
}
