package com.mbridge.msdk.video.dynview.j;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.g.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f5767j = false;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.b f5769b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Bitmap> f5770c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f5771d;
    private String e = "#FFFFFFFF";
    private String f = "#60000000";
    private String g = "#FF5F5F5F";
    private String h = "#90ECECEC";

    /* renamed from: i, reason: collision with root package name */
    private volatile long f5772i = 0;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.a f5773k = null;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5774l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f5775m = 0;

    /* renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f5768a = new com.mbridge.msdk.video.dynview.d.a() { // from class: com.mbridge.msdk.video.dynview.j.a.1
        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void a() {
            if (!a.this.f5774l || a.this.f5769b == null) {
                return;
            }
            a.this.f5769b.a(a.this.f5775m * 1000, a.this.f5773k);
            a.this.f5774l = false;
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void b() {
            if (a.this.f5769b != null) {
                a.this.f5769b.b();
                a.this.f5774l = true;
            }
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void c() {
            if (a.this.f5769b != null) {
                a.this.f5769b.b();
                a.this.f5774l = true;
            }
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.video.dynview.j.a$9, reason: invalid class name */
    public class AnonymousClass9 implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5803a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f5804b;

        public AnonymousClass9(int i10, ImageView imageView) {
            this.f5803a = i10;
            this.f5804b = imageView;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            try {
                int iA = x.a(this.f5804b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f5804b.setBackgroundColor(Color.parseColor(a.this.g));
                this.f5804b.setImageResource(iA);
                this.f5804b.setScaleType(ImageView.ScaleType.CENTER);
            } catch (Exception e) {
                af.a("DataEnergizeWrapper", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                int iA = x.a(this.f5804b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f5804b.setBackgroundColor(Color.parseColor(a.this.g));
                this.f5804b.setImageResource(iA);
                this.f5804b.setScaleType(ImageView.ScaleType.CENTER);
                return;
            }
            int i10 = this.f5803a;
            if (i10 != 501 && i10 != 802) {
                this.f5804b.setImageBitmap(bitmap);
            } else {
                com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            final Bitmap bitmapA = p.a(bitmap, 10);
                            AnonymousClass9.this.f5804b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass9.this.f5804b.setImageBitmap(bitmapA);
                                }
                            });
                        } catch (Exception e) {
                            af.b("DataEnergizeWrapper", e.getMessage());
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.mbridge.msdk.video.dynview.c r36, android.view.View r37, final java.util.Map r38, com.mbridge.msdk.video.dynview.e.e r39) {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.a.a(com.mbridge.msdk.video.dynview.c, android.view.View, java.util.Map, com.mbridge.msdk.video.dynview.e.e):void");
    }

    public final void b(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            f5767j = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        boolean z9 = f5767j;
        LinearLayout linearLayout = z9 ? (LinearLayout) view.findViewById(a(z9, "mbridge_reward_heat_mllv")) : null;
        ImageView imageView = (ImageView) view.findViewById(a(f5767j, "mbridge_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a(f5767j, "mbridge_reward_title_tv"));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(a(f5767j, "mbridge_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a(f5767j, "mbridge_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a(f5767j, "mbridge_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a(f5767j, "mbridge_reward_desc_tv"));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(f5767j, "mbridge_reward_bottom_layout"));
        ArrayList arrayList = new ArrayList();
        List<CampaignEx> listG = cVar.g();
        if (listG == null || listG.size() <= 0) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        CampaignEx campaignEx = listG.get(0);
        if (campaignEx == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            if (!f5767j) {
                ((RoundImageView) imageView).setBorderRadius(10);
            } else if (imageView instanceof MBCusRoundImageView) {
                ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
            }
            a(campaignEx.getIconUrl(), imageView);
        }
        if (textView != null) {
            textView.setText(campaignEx.getAppName());
        }
        if (textView3 != null) {
            textView3.setText(campaignEx.getAppDesc());
        }
        if (linearLayout2 != null) {
            double rating = campaignEx.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            if (f5767j) {
                if (linearLayout2 instanceof MBStarLevelLayoutView) {
                    MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                    mBStarLevelLayoutView.setRating((int) rating);
                    mBStarLevelLayoutView.setOrientation(0);
                }
                if (linearLayout instanceof MBHeatLevelLayoutView) {
                    ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                }
            } else {
                ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
            }
        }
        if (textView2 != null) {
            textView2.setText(campaignEx.getAdCall());
        }
        int i10 = cVar.i();
        if (i10 == 102 || i10 == 202 || i10 == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (i10 == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, campaignEx.getImageUrl(), i10);
        } else if (i10 != 902) {
            if (i10 != 904) {
                if (i10 == 5002010) {
                    if (cVar.k() && relativeLayout != null && relativeLayout.getVisibility() == 0) {
                        arrayList.add(relativeLayout);
                    } else {
                        if (imageView != null) {
                            arrayList.add(imageView);
                        }
                        if (textView2 != null) {
                            arrayList.add(textView2);
                        }
                    }
                }
            } else if (cVar.k()) {
                arrayList.add(view);
            }
        } else if (TextUtils.isEmpty(cVar.o()) || !cVar.o().equals("dsp") || !TextUtils.isEmpty(campaignEx.getClickURL())) {
            arrayList.add(view);
        }
        eVar.a(view, arrayList);
    }

    public final void c(com.mbridge.msdk.video.dynview.c cVar, View view, final Map map, e eVar) {
        try {
            if (this.f5770c == null) {
                this.f5770c = new HashMap();
            }
            final List<CampaignEx> listG = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                f5767j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            for (CampaignEx campaignEx : listG) {
                if (campaignEx != null) {
                    campaignEx.setECTemplateRenderSucc(f5767j);
                }
            }
            ListView listView = (ListView) view.findViewById(a(f5767j, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(f5767j, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(f5767j, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.a.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.a.a(listG);
            if (cVar.e() == 1) {
                if (listView != null) {
                    try {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                            float fC = (cVar.c() - ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 720.0f)) / 2.0f;
                            int iA = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                            int i10 = (int) fC;
                            layoutParams.setMargins(iA, i10, iA, i10);
                            listView.setLayoutParams(layoutParams);
                        }
                    } catch (Exception e) {
                        af.b("DataEnergizeWrapper", e.getMessage());
                    }
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.6
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int i11, long j10) {
                            a.a(a.this, map, listG, i11);
                        }
                    });
                }
            } else if (gridView != null) {
                int iD = (int) cVar.d();
                int size = iD / listG.size();
                int i11 = size / 9;
                int i12 = i11 / 2;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams2.width = iD - (i11 * 2);
                gridView.setLayoutParams(layoutParams2);
                gridView.setColumnWidth((size - i11) - (i12 / 2));
                gridView.setHorizontalSpacing(i12);
                gridView.setStretchMode(0);
                gridView.setNumColumns(listG.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.7
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view2, int i13, long j10) {
                        a.a(a.this, map, listG, i13);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.a(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        com.mbridge.msdk.video.dynview.i.c.b bVar = this.f5769b;
        if (bVar != null) {
            bVar.b();
            this.f5769b = null;
        }
        com.mbridge.msdk.video.dynview.b.a.a().f5689a = null;
        if (this.f5768a != null) {
            this.f5768a = null;
        }
        Map<String, Bitmap> map = this.f5770c;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.f5770c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f5770c.clear();
        }
    }

    public static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                    ((d) map.get("choice_one_callback")).countDownClick();
                    aVar.b();
                }
            } catch (Exception e) {
                af.b("DataEnergizeWrapper", e.getMessage());
            }
        }
    }

    public final void a(com.mbridge.msdk.video.dynview.c cVar, View view, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner_bg", "id"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.h));
            }
            ImageView imageView2 = (ImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner", "id"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.h));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e) {
            af.a("DataEnergizeWrapper", e.getMessage());
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(ImageView imageView, String str, int i10) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new AnonymousClass9(i10, imageView));
    }

    private void a(final String str, final ImageView imageView, final com.mbridge.msdk.video.dynview.c cVar, final View view) {
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.j.a.10
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) throws Throwable {
                ImageView imageView2;
                if (bitmap == null || bitmap.isRecycled() || (imageView2 = imageView) == null) {
                    return;
                }
                imageView2.setImageBitmap(bitmap);
                if (a.this.f5770c != null) {
                    a.this.f5770c.put(SameMD5.getMD5(str), bitmap);
                    a.a(a.this, cVar, view);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
            }
        });
        try {
            Bitmap bitmapA = a();
            if (bitmapA == null || bitmapA.isRecycled()) {
                return;
            }
            a(cVar, view);
        } catch (Exception e) {
            af.b("DataEnergizeWrapper", e.getMessage());
        }
    }

    private int a(boolean z9, String str) {
        try {
            if (z9) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                return str.hashCode();
            }
            return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
        } catch (Exception e) {
            af.b("DataEnergizeWrapper", e.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmapCreateBitmap.eraseColor(Color.parseColor(this.h));
            return bitmapCreateBitmap;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return bitmapCreateBitmap;
        }
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, View view) {
        a.C0063a c0063aA = com.mbridge.msdk.video.dynview.g.a.a();
        c0063aA.a(cVar.e()).a(true);
        if (cVar.e() != 2 || cVar.d() > cVar.c()) {
            c0063aA.a(cVar.d()).b(cVar.c());
        } else {
            c0063aA.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackground(c0063aA.a());
        }
    }

    public static /* synthetic */ void a(a aVar, Map map, List list, int i10) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
            d dVar = (d) map.get("choice_one_callback");
            if (dVar != null) {
                dVar.itemClick((CampaignEx) list.get(i10));
                try {
                    CampaignEx campaignEx = (CampaignEx) list.get(i10);
                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar.a(CampaignEx.JSON_NATIVE_VIDEO_CLICK, "0");
                    eVar.a("time", Long.valueOf(aVar.f5772i));
                    eVar.a("choose_cid", campaignEx.getId());
                    eVar.a("position", Integer.valueOf(i10));
                    eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "choseFromTwoSelect");
                    com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx, eVar);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            aVar.b();
            return;
        }
        if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
            com.mbridge.msdk.video.dynview.e.c cVar = (com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback");
            if (cVar != null) {
                cVar.a((CampaignEx) list.get(i10), i10);
            }
            aVar.b();
        }
    }

    public static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                    ((com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback")).a();
                    aVar.b();
                }
            } catch (Exception e) {
                af.b("DataEnergizeWrapper", e.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(a aVar, com.mbridge.msdk.video.dynview.c cVar, View view) throws Throwable {
        Map<String, Bitmap> map = aVar.f5770c;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.mbridge.msdk.video.dynview.h.b();
        Map<String, Bitmap> map2 = aVar.f5770c;
        if (view != null) {
            com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }
}
