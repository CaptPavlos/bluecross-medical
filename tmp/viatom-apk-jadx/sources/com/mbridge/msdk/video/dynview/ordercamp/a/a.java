package com.mbridge.msdk.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5854a = false;

    /* renamed from: b, reason: collision with root package name */
    private C0066a f5855b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f5856c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.video.dynview.ordercamp.a.a$a, reason: collision with other inner class name */
    public static class C0066a {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f5860a;

        /* renamed from: b, reason: collision with root package name */
        MBRotationView f5861b;

        /* renamed from: c, reason: collision with root package name */
        MBridgeImageView f5862c;

        /* renamed from: d, reason: collision with root package name */
        RoundImageView f5863d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;

        /* renamed from: i, reason: collision with root package name */
        MBridgeLevelLayoutView f5864i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f5865j;

        /* renamed from: k, reason: collision with root package name */
        ImageView f5866k;

        /* renamed from: l, reason: collision with root package name */
        MBCusRoundImageView f5867l;

        /* renamed from: m, reason: collision with root package name */
        MBCusRoundImageView f5868m;

        /* renamed from: n, reason: collision with root package name */
        MBStarLevelLayoutView f5869n;

        /* renamed from: o, reason: collision with root package name */
        MBHeatLevelLayoutView f5870o;

        /* renamed from: p, reason: collision with root package name */
        MBFrameLayout f5871p;
    }

    public a(List<CampaignEx> list) {
        this.f5856c = list;
    }

    private View a(int i10) {
        View viewCreateDynamicView;
        String cMPTEntryUrl;
        String str;
        try {
            List<CampaignEx> list = this.f5856c;
            cMPTEntryUrl = "";
            if (list == null || list.get(i10) == null) {
                str = "501";
            } else {
                str = this.f5856c.get(i10).getMof_tplid() + "";
                cMPTEntryUrl = this.f5856c.get(i10).getCMPTEntryUrl();
            }
        } catch (Exception e) {
            af.b("OrderCampAdapter", e.getMessage());
            viewCreateDynamicView = null;
        }
        if (TextUtils.isEmpty(cMPTEntryUrl)) {
            return a();
        }
        int iS = ab.s(c.m().c());
        String strA = o.a(0, str, cMPTEntryUrl);
        if (TextUtils.isEmpty(strA)) {
            return a();
        }
        File file = new File(strA + File.separator + "template_config.json");
        if (file.isFile() && file.exists()) {
            List<String> listA = ad.a(strA, "template_" + str + "_" + iS + "_item");
            if (listA == null) {
                return a();
            }
            int iS2 = ab.s(c.m().c());
            h.a().b(c.m().k());
            viewCreateDynamicView = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(this.f5856c.get(i10)).fileDirs(listA).dyAdType(DyAdType.REWARD).orientation(iS2).adChoiceLink(ak.a(this.f5856c.get(i10))).build());
            if (viewCreateDynamicView != null) {
                this.f5854a = true;
                C0066a c0066a = new C0066a();
                this.f5855b = c0066a;
                c0066a.f5867l = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv"));
                this.f5855b.f5866k = (ImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv_burl"));
                this.f5855b.f5868m = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_icon_iv"));
                this.f5855b.f5869n = (MBStarLevelLayoutView) viewCreateDynamicView.findViewById(c("mbridge_lv_sv_starlevel"));
                this.f5855b.f5871p = (MBFrameLayout) viewCreateDynamicView.findViewById(c("mbridge_lv_ration"));
                viewCreateDynamicView.setTag(this.f5855b);
            }
            return this.f5854a ? viewCreateDynamicView : a();
        }
        return a();
    }

    private int b(String str) {
        return x.a(c.m().c().getApplicationContext(), str, "id");
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(String str) {
        return this.f5854a ? c(str) : b(str);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<CampaignEx> list = this.f5856c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f5856c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        List<CampaignEx> list = this.f5856c;
        if (list != null) {
            return list.get(i10);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        View viewA;
        try {
            if (view == null) {
                viewA = a(i10);
            } else {
                this.f5855b = (C0066a) view.getTag();
                viewA = view;
            }
        } catch (Exception e) {
            e = e;
            viewA = view;
        }
        try {
            this.f5855b.f5860a = (RelativeLayout) viewA.findViewById(d("mbridge_lv_item_rl"));
            this.f5855b.e = (TextView) viewA.findViewById(d("mbridge_lv_title_tv"));
            this.f5855b.g = (TextView) viewA.findViewById(d("mbridge_lv_tv_install"));
            this.f5855b.f5870o = (MBHeatLevelLayoutView) viewA.findViewById(d("mbridge_lv_sv_heat_level"));
            this.f5855b.f = (TextView) viewA.findViewById(d("mbridge_lv_desc_tv"));
            this.f5855b.f5865j = (ImageView) viewA.findViewById(d("mbridge_iv_flag"));
            this.f5855b.h = (TextView) viewA.findViewById(d("mbridge_order_viewed_tv"));
            boolean z9 = this.f5854a;
            List<CampaignEx> list = this.f5856c;
            double d8 = 5.0d;
            if (z9) {
                if (list != null && this.f5855b != null && list.size() != 0) {
                    MBCusRoundImageView mBCusRoundImageView = this.f5855b.f5867l;
                    if (mBCusRoundImageView != null) {
                        mBCusRoundImageView.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                        a(this.f5855b.f5867l, this.f5856c.get(i10).getImageUrl(), false);
                    }
                    ImageView imageView = this.f5855b.f5866k;
                    if (imageView != null) {
                        a(imageView, this.f5856c.get(i10).getImageUrl(), false);
                    }
                    MBCusRoundImageView mBCusRoundImageView2 = this.f5855b.f5868m;
                    if (mBCusRoundImageView2 != null) {
                        mBCusRoundImageView2.setBorder(50, 20, -1);
                        a(this.f5855b.f5868m, this.f5856c.get(i10).getIconUrl(), true);
                    }
                    double rating = this.f5856c.get(i10).getRating();
                    if (rating > 0.0d) {
                        d8 = rating;
                    }
                    MBStarLevelLayoutView mBStarLevelLayoutView = this.f5855b.f5869n;
                    if (mBStarLevelLayoutView != null) {
                        mBStarLevelLayoutView.setRating((int) d8);
                        this.f5855b.f5869n.setOrientation(0);
                    }
                    MBHeatLevelLayoutView mBHeatLevelLayoutView = this.f5855b.f5870o;
                    if (mBHeatLevelLayoutView != null) {
                        mBHeatLevelLayoutView.setHeatCount(this.f5856c.get(i10).getNumberRating());
                    }
                }
            } else if (list != null && this.f5855b != null && list.size() != 0) {
                MBridgeImageView mBridgeImageView = this.f5855b.f5862c;
                if (mBridgeImageView != null) {
                    a(mBridgeImageView, this.f5856c.get(i10).getImageUrl(), false);
                }
                ImageView imageView2 = this.f5855b.f5866k;
                if (imageView2 != null) {
                    a(imageView2, this.f5856c.get(i10).getImageUrl(), false);
                }
                RoundImageView roundImageView = this.f5855b.f5863d;
                if (roundImageView != null) {
                    roundImageView.setBorderRadius(25);
                    a(this.f5855b.f5863d, this.f5856c.get(i10).getIconUrl(), true);
                }
                double rating2 = this.f5856c.get(i10).getRating();
                if (rating2 > 0.0d) {
                    d8 = rating2;
                }
                MBridgeLevelLayoutView mBridgeLevelLayoutView = this.f5855b.f5864i;
                if (mBridgeLevelLayoutView != null) {
                    mBridgeLevelLayoutView.setRatingAndUser(d8, this.f5856c.get(i10).getNumberRating());
                    this.f5855b.f5864i.setOrientation(0);
                }
                MBRotationView mBRotationView = this.f5855b.f5861b;
                if (mBRotationView != null) {
                    mBRotationView.setWidthRatio(1.0f);
                    this.f5855b.f5861b.setHeightRatio(1.0f);
                    this.f5855b.f5861b.setAutoscroll(false);
                }
                MBridgeImageView mBridgeImageView2 = this.f5855b.f5862c;
                if (mBridgeImageView2 != null) {
                    mBridgeImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                }
            }
            C0066a c0066a = this.f5855b;
            if (c0066a != null) {
                if (c0066a.e != null) {
                    this.f5855b.e.setText(this.f5856c.get(i10).getAppName());
                }
                if (this.f5855b.f != null) {
                    this.f5855b.f.setText(this.f5856c.get(i10).getAppDesc());
                }
                if (this.f5855b.g != null) {
                    String adCall = this.f5856c.get(i10).getAdCall();
                    if (this.f5855b.g instanceof MBridgeTextView) {
                        ((MBridgeTextView) this.f5855b.g).setObjectAnimator(new b().c(this.f5855b.g));
                    }
                    this.f5855b.g.setText(adCall);
                }
                if (this.f5855b.f5865j != null) {
                    try {
                        String language = Locale.getDefault().getLanguage();
                        Context contextC = c.m().c();
                        if (contextC != null) {
                            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                                this.f5855b.f5865j.setImageDrawable(contextC.getResources().getDrawable(contextC.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", c.m().g())));
                            } else {
                                this.f5855b.f5865j.setImageDrawable(contextC.getResources().getDrawable(contextC.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", c.m().g())));
                            }
                        }
                    } catch (Exception e3) {
                        af.b("OrderCampAdapter", e3.getMessage());
                    }
                    ak.a(2, this.f5855b.f5865j, this.f5856c.get(i10), c.m().c(), false, null);
                }
                if (this.f5855b.h != null) {
                    try {
                        this.f5855b.h.setText(c.m().c().getResources().getString(c.m().c().getResources().getIdentifier("mbridge_reward_viewed_text_str", TypedValues.Custom.S_STRING, c.m().g())));
                        this.f5855b.h.setVisibility(0);
                    } catch (Exception e7) {
                        af.b("OrderCampAdapter", e7.getMessage());
                    }
                }
            }
        } catch (Exception e10) {
            e = e10;
            af.b("OrderCampAdapter", e.getMessage());
            return viewA;
        }
        return viewA;
    }

    private View a() {
        View viewInflate = LayoutInflater.from(c.m().c()).inflate(a("mbridge_order_layout_item"), (ViewGroup) null);
        C0066a c0066a = new C0066a();
        this.f5855b = c0066a;
        c0066a.f5862c = (MBridgeImageView) viewInflate.findViewById(b("mbridge_lv_iv"));
        this.f5855b.f5866k = (ImageView) viewInflate.findViewById(b("mbridge_lv_iv_burl"));
        this.f5855b.f5863d = (RoundImageView) viewInflate.findViewById(b("mbridge_lv_icon_iv"));
        this.f5855b.f5864i = (MBridgeLevelLayoutView) viewInflate.findViewById(b("mbridge_lv_sv_starlevel"));
        this.f5855b.f5861b = (MBRotationView) viewInflate.findViewById(b("mbridge_lv_ration"));
        viewInflate.setTag(this.f5855b);
        return viewInflate;
    }

    private void a(final ImageView imageView, String str, final boolean z9) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.ordercamp.a.a.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str2, String str3) {
                    if (z9) {
                        imageView.setVisibility(8);
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str2) {
                    try {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    } catch (Throwable th) {
                        af.b("OrderCampAdapter", th.getMessage());
                    }
                }
            });
        } else if (z9) {
            imageView.setVisibility(8);
        }
    }

    private int a(String str) {
        return x.a(c.m().c().getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }
}
