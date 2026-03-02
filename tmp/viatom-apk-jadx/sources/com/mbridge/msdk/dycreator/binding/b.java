package com.mbridge.msdk.dycreator.binding;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBApkInfoView;
import com.mbridge.msdk.dycreator.baseview.MBFeedBack;
import com.mbridge.msdk.dycreator.baseview.MBLogoTextView;
import com.mbridge.msdk.dycreator.baseview.MBSplashClickView;
import com.mbridge.msdk.dycreator.baseview.MBSplashImageBgView;
import com.mbridge.msdk.dycreator.baseview.MBSplashPortView;
import com.mbridge.msdk.dycreator.baseview.MBSplashShakeView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.d.a;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.e;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.g;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.g.i;
import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f3168a;

    /* renamed from: b, reason: collision with root package name */
    private d f3169b = (d) com.mbridge.msdk.dycreator.d.a.a().a(a.EnumC0024a.VIEW_OBSERVER);

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.g.c f3170c = (com.mbridge.msdk.dycreator.g.c) com.mbridge.msdk.dycreator.d.a.a().a(a.EnumC0024a.CLICK_OBSERVER);

    /* renamed from: d, reason: collision with root package name */
    private f f3171d = (f) com.mbridge.msdk.dycreator.d.a.a().a(a.EnumC0024a.EFFECT_OBSERVER);
    private h e = (h) com.mbridge.msdk.dycreator.d.a.a().a(a.EnumC0024a.REPORT_OBSERVER);
    private BaseViewModel f;
    private com.mbridge.msdk.shake.b g;

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.shake.b a(final android.view.View r9, final com.mbridge.msdk.dycreator.bridge.MBSplashData r10) {
        /*
            r8 = this;
            if (r10 == 0) goto L37
            com.mbridge.msdk.dycreator.wrapper.DyOption r0 = r10.getDyOption()     // Catch: java.lang.Exception -> L2a
            if (r0 == 0) goto L37
            boolean r1 = r0.isShakeVisible()     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L37
            com.mbridge.msdk.shake.b r1 = r8.g     // Catch: java.lang.Exception -> L2a
            if (r1 != 0) goto L37
            com.mbridge.msdk.dycreator.binding.b$7 r2 = new com.mbridge.msdk.dycreator.binding.b$7     // Catch: java.lang.Exception -> L2a
            int r4 = r0.getShakeStrenght()     // Catch: java.lang.Exception -> L2a
            int r0 = r0.getShakeTime()     // Catch: java.lang.Exception -> L2a
            int r5 = r0 * 1000
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5)     // Catch: java.lang.Exception -> L27
            r3.g = r2     // Catch: java.lang.Exception -> L27
            goto L38
        L27:
            r0 = move-exception
        L28:
            r9 = r0
            goto L2d
        L2a:
            r0 = move-exception
            r3 = r8
            goto L28
        L2d:
            java.lang.String r10 = "MBDataBinding"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r9)
            goto L38
        L37:
            r3 = r8
        L38:
            com.mbridge.msdk.shake.b r9 = r3.g
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.binding.b.a(android.view.View, com.mbridge.msdk.dycreator.bridge.MBSplashData):com.mbridge.msdk.shake.b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(b bVar, InterBase interBase, Object obj) {
        int countDownTime;
        final boolean z9;
        if (interBase == 0 || obj == null) {
            return;
        }
        String effectDes = interBase.getEffectDes();
        if (TextUtils.isEmpty(effectDes)) {
            return;
        }
        try {
            if (interBase instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) interBase;
                com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                if (effectDes != null) {
                    if (effectDes.equals("wobble") && (viewGroup instanceof MBSplashShakeView)) {
                        if (aVar.getEffectData().isShakeVisible()) {
                            if (bVar.g != null) {
                                com.mbridge.msdk.shake.a.a().b(bVar.g);
                            }
                            com.mbridge.msdk.shake.a.a().a(bVar.a(viewGroup, (MBSplashData) aVar));
                        } else if (bVar.g != null) {
                            com.mbridge.msdk.shake.a.a().b(bVar.g);
                        }
                    }
                    if (effectDes.equals("visible") && (viewGroup instanceof MBApkInfoView)) {
                        if (!aVar.getEffectData().isApkInfoVisible()) {
                            viewGroup.setVisibility(8);
                        } else if (!(aVar instanceof MBSplashData) || TextUtils.isEmpty(((MBSplashData) aVar).getAppInfo())) {
                            viewGroup.setVisibility(4);
                        } else {
                            viewGroup.setVisibility(0);
                        }
                    }
                    effectDes.equals("anim");
                    return;
                }
                return;
            }
            if (interBase instanceof View) {
                final View view = (View) interBase;
                if (effectDes != null) {
                    com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                    if (effectDes.equals("countdown") && (view instanceof TextView)) {
                        final String str = (String) ((TextView) view).getText();
                        final String strT = ab.t(view.getContext());
                        DyOption effectData = aVar2.getEffectData();
                        if (effectData != null) {
                            boolean zIsCanSkip = effectData.isCanSkip();
                            countDownTime = effectData.getCountDownTime();
                            z9 = zIsCanSkip;
                        } else {
                            countDownTime = 5;
                            z9 = false;
                        }
                        ((TextView) view).setText(com.mbridge.msdk.dycreator.e.d.a(z9, countDownTime, str, strT));
                        ((com.mbridge.msdk.dycreator.f.a.a) obj).getEffectData().setDyCountDownListenerWrapper(new DyCountDownListenerWrapper() { // from class: com.mbridge.msdk.dycreator.binding.b.5
                            @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper
                            public final void getCountDownValue(int i10) {
                                if (i10 != 0) {
                                    ((TextView) view).setText(com.mbridge.msdk.dycreator.e.d.a(z9, i10, str, strT));
                                } else {
                                    SplashResData splashResData = new SplashResData();
                                    splashResData.seteAction(EAction.CLOSE);
                                    EventBus.getDefault().post(splashResData);
                                }
                            }
                        });
                    }
                    effectDes.equals("anim");
                    if (effectDes.equals("visible")) {
                        if (view instanceof MBFeedBack) {
                            if (com.mbridge.msdk.foundation.d.b.a().b()) {
                                view.setVisibility(0);
                            } else {
                                view.setVisibility(8);
                            }
                        }
                        if (!(view instanceof MBLogoTextView) || aVar2.getEffectData() == null || aVar2.getEffectData().isLogoVisible()) {
                            return;
                        }
                        ((MBLogoTextView) view).setCompoundDrawables(null, null, null, null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(b bVar, InterBase interBase, Object obj) {
        if (interBase == 0 || obj == null) {
            return;
        }
        String bindDataDes = interBase.getBindDataDes();
        if (TextUtils.isEmpty(bindDataDes)) {
            return;
        }
        try {
            Object objA = com.mbridge.msdk.dycreator.e.d.a(obj, bindDataDes);
            if (objA == null) {
                return;
            }
            if (interBase instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) interBase;
                com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                if (viewGroup instanceof MBSplashClickView) {
                    if (aVar.getEffectData() == null || !aVar.getEffectData().isClickButtonVisible() || aVar.getEffectData().isShakeVisible()) {
                        viewGroup.setVisibility(8);
                    } else if (!TextUtils.isEmpty(objA.toString())) {
                        viewGroup.setVisibility(0);
                        ((MBSplashClickView) viewGroup).initView(objA.toString());
                    }
                }
                if (viewGroup instanceof MBSplashShakeView) {
                    if (aVar.getEffectData() == null || !aVar.getEffectData().isShakeVisible()) {
                        viewGroup.setVisibility(8);
                        return;
                    } else {
                        if (TextUtils.isEmpty(objA.toString())) {
                            return;
                        }
                        viewGroup.setVisibility(0);
                        ((MBSplashShakeView) viewGroup).initView(objA.toString());
                        return;
                    }
                }
                return;
            }
            if (interBase instanceof View) {
                final View view = (View) interBase;
                final com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                try {
                    if (view instanceof TextView) {
                        try {
                            ((TextView) view).setText(String.valueOf(objA).replace("\\n", "\n"));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (view instanceof ImageView) {
                        if (objA instanceof Integer) {
                            ((ImageView) view).setImageResource(((Integer) objA).intValue());
                        }
                        if (objA instanceof String) {
                            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(objA.toString(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.binding.b.6
                                @Override // com.mbridge.msdk.foundation.same.c.c
                                public final void onFailedLoad(String str, String str2) {
                                    View view2 = view;
                                    if (view2 != null) {
                                        ((ImageView) view2).setBackgroundColor(-7829368);
                                    }
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // com.mbridge.msdk.foundation.same.c.c
                                public final void onSuccessLoad(Bitmap bitmap, String str) {
                                    if (bitmap != null) {
                                        try {
                                            if (!bitmap.isRecycled()) {
                                                boolean z9 = bitmap.getWidth() > bitmap.getHeight();
                                                if ((aVar2.getEffectData().getOrientation() == 1 ? view.getResources().getConfiguration().orientation : aVar2.getEffectData().getOrientation()) == 1) {
                                                    View view2 = view;
                                                    if (z9) {
                                                        if (view2 instanceof MBSplashPortView) {
                                                            if (view2.getParent() != null) {
                                                                ((ViewGroup) view.getParent()).setVisibility(8);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (view2 instanceof MBSplashImageBgView) {
                                                            view2.setVisibility(0);
                                                            Bitmap bitmapA = ae.a(bitmap);
                                                            ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                            ((MBSplashImageBgView) view).setImageBitmap(bitmapA);
                                                            return;
                                                        }
                                                    } else if (view2 instanceof MBSplashPortView) {
                                                        view2.setVisibility(0);
                                                        ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                                        ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                        return;
                                                    } else if (view2 instanceof MBSplashImageBgView) {
                                                        view2.setVisibility(8);
                                                        return;
                                                    } else if (view2 instanceof InterBase) {
                                                        String effectDes = ((InterBase) view2).getEffectDes();
                                                        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                                                        if (viewGroup2 != null) {
                                                            com.mbridge.msdk.dycreator.e.d.a(effectDes, viewGroup2, true);
                                                        }
                                                    }
                                                } else {
                                                    View view3 = view;
                                                    if (z9) {
                                                        if (view3 instanceof MBSplashPortView) {
                                                            view3.setVisibility(0);
                                                            ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_XY);
                                                            ((ImageView) view).setImageBitmap(bitmap);
                                                            return;
                                                        } else if (view3 instanceof MBSplashImageBgView) {
                                                            view3.setVisibility(8);
                                                            ((MBSplashImageBgView) view).setImageBitmap(ae.a(bitmap));
                                                            return;
                                                        } else if (view3 instanceof InterBase) {
                                                            String effectDes2 = ((InterBase) view3).getEffectDes();
                                                            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                                                            if (viewGroup3 != null) {
                                                                com.mbridge.msdk.dycreator.e.d.a(effectDes2, viewGroup3, true);
                                                            }
                                                        }
                                                    } else if (view3 instanceof MBSplashPortView) {
                                                        view3.setVisibility(0);
                                                        ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                        return;
                                                    } else {
                                                        if (view3 instanceof MBSplashImageBgView) {
                                                            view3.setVisibility(0);
                                                            Bitmap bitmapA2 = ae.a(bitmap);
                                                            ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                            ((MBSplashImageBgView) view).setImageBitmap(bitmapA2);
                                                            return;
                                                        }
                                                        if (view3 instanceof InterBase) {
                                                            String effectDes3 = ((InterBase) view3).getEffectDes();
                                                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                                                            if (viewGroup4 != null) {
                                                                com.mbridge.msdk.dycreator.e.d.a(effectDes3, viewGroup4, true);
                                                            }
                                                        }
                                                    }
                                                }
                                                ((ImageView) view).setImageBitmap(bitmap);
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            af.b("MBDataBinding", e3.getMessage());
                                            return;
                                        }
                                    }
                                    ((ImageView) view).setBackgroundColor(-7829368);
                                }
                            });
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(final View view) {
        if (view != 0) {
            try {
                if (view instanceof InterBase) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (TextUtils.isEmpty(actionDes)) {
                        return;
                    }
                    if (!actionDes.startsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                        if (!actionDes.equals("move") && !actionDes.equals("long_click")) {
                            actionDes.equals("wobble");
                            return;
                        }
                        return;
                    }
                    com.mbridge.msdk.dycreator.g.b bVar = new com.mbridge.msdk.dycreator.g.b() { // from class: com.mbridge.msdk.dycreator.binding.b.4
                        @Override // com.mbridge.msdk.dycreator.g.b
                        public final void a(Object obj) {
                            if (obj == null) {
                                return;
                            }
                            try {
                                if (com.mbridge.msdk.dycreator.e.d.a(view, (com.mbridge.msdk.dycreator.f.a.a) obj)) {
                                    b.a(b.this, view, obj);
                                }
                            } catch (Exception e) {
                                af.b("MBDataBinding", e.getMessage());
                            }
                        }
                    };
                    int id = view.getId();
                    com.mbridge.msdk.dycreator.g.c cVar = this.f3170c;
                    if (cVar != null) {
                        cVar.a(bVar, id);
                    }
                }
            } catch (Exception e) {
                af.b("MBDataBinding", e.getMessage());
            }
        }
    }

    public static b a() {
        if (f3168a == null) {
            synchronized (b.class) {
                try {
                    if (f3168a == null) {
                        f3168a = new b();
                    }
                } finally {
                }
            }
        }
        return f3168a;
    }

    public final void a(final View view) {
        g gVar = new g() { // from class: com.mbridge.msdk.dycreator.binding.b.1
            @Override // com.mbridge.msdk.dycreator.g.g
            public final void a(Object obj) {
                try {
                    KeyEvent.Callback callback = view;
                    if (callback instanceof InterBase) {
                        b.a(b.this, (InterBase) callback, obj);
                    }
                } catch (Exception e) {
                    af.b("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        h hVar = this.e;
        if (hVar != null) {
            hVar.a(gVar, id);
        }
    }

    public final void a(BaseViewModel baseViewModel) {
        this.f = baseViewModel;
        if (baseViewModel != null) {
            baseViewModel.setClickSubject(this.f3170c);
            this.f.setConcreteSubject(this.f3169b);
            this.f.setEffectSubject(this.f3171d);
            this.f.setReportSubject(this.e);
        }
    }

    public static /* synthetic */ void a(b bVar, InterBase interBase, Object obj) {
        if (interBase == null || obj == null) {
            return;
        }
        String reportDes = interBase.getReportDes();
        if (TextUtils.isEmpty(reportDes)) {
            return;
        }
        try {
            if (!(obj instanceof com.mbridge.msdk.dycreator.f.a.a) || ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData() == null) {
                return;
            }
            interBase.setDynamicReport(reportDes, ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void a(b bVar, View view, Object obj) {
        if (view == null || obj == null || !(obj instanceof com.mbridge.msdk.dycreator.f.a.a)) {
            return;
        }
        view.setOnClickListener(new a((com.mbridge.msdk.dycreator.f.a.a) obj));
    }

    public final void c(final View view) {
        i iVar = new i() { // from class: com.mbridge.msdk.dycreator.binding.b.3
            @Override // com.mbridge.msdk.dycreator.g.i
            public final void a(Object obj) {
                try {
                    KeyEvent.Callback callback = view;
                    if (callback instanceof InterBase) {
                        b.c(b.this, (InterBase) callback, obj);
                    }
                } catch (Exception e) {
                    af.b("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        d dVar = this.f3169b;
        if (dVar != null) {
            dVar.a(iVar, id);
        }
    }

    public final synchronized void b() {
        try {
            com.mbridge.msdk.dycreator.g.c cVar = this.f3170c;
            if (cVar != null) {
                cVar.a();
            }
            d dVar = this.f3169b;
            if (dVar != null) {
                dVar.a();
            }
            f fVar = this.f3171d;
            if (fVar != null) {
                fVar.a();
            }
            if (this.f != null) {
                this.f = null;
            }
            if (this.g != null) {
                this.g = null;
            }
            if (f3168a != null) {
                f3168a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(final View view) {
        e eVar = new e() { // from class: com.mbridge.msdk.dycreator.binding.b.2
            @Override // com.mbridge.msdk.dycreator.g.e
            public final void a(Object obj) {
                try {
                    KeyEvent.Callback callback = view;
                    if (callback instanceof InterBase) {
                        b.b(b.this, (InterBase) callback, obj);
                    }
                } catch (Exception e) {
                    af.b("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        f fVar = this.f3171d;
        if (fVar != null) {
            fVar.a(eVar, id);
        }
    }
}
