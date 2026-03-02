package com.mbridge.msdk.video.dynview.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBTextView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f5810a = "mbridge_top_play_bg";

    /* renamed from: b, reason: collision with root package name */
    private String f5811b = "mbridge_top_finger_bg";

    /* renamed from: c, reason: collision with root package name */
    private String f5812c = "mbridge_bottom_play_bg";

    /* renamed from: d, reason: collision with root package name */
    private String f5813d = "mbridge_bottom_finger_bg";
    private String e = "mbridge_tv_count";
    private String f = "mbridge_sound_switch";
    private String g = "mbridge_top_control";
    private String h = "mbridge_tv_title";

    /* renamed from: i, reason: collision with root package name */
    private String f5814i = "mbridge_tv_desc";

    /* renamed from: j, reason: collision with root package name */
    private String f5815j = "mbridge_tv_install";

    /* renamed from: k, reason: collision with root package name */
    private String f5816k = "mbridge_sv_starlevel";

    /* renamed from: l, reason: collision with root package name */
    private String f5817l = "mbridge_sv_heat_count_level";

    /* renamed from: m, reason: collision with root package name */
    private String f5818m = "mbridge_tv_cta";

    /* renamed from: n, reason: collision with root package name */
    private String f5819n = "mbridge_native_ec_controller";

    /* renamed from: o, reason: collision with root package name */
    private String f5820o = "mbridge_reward_shape_choice_rl";

    /* renamed from: p, reason: collision with root package name */
    private String f5821p = "#FFFFFF";

    /* renamed from: q, reason: collision with root package name */
    private String f5822q = "#FF000000";

    /* renamed from: r, reason: collision with root package name */
    private String f5823r = "#40000000";

    /* renamed from: s, reason: collision with root package name */
    private String f5824s = "#CAEF79";
    private String t = "#2196F3";

    /* renamed from: u, reason: collision with root package name */
    private String f5825u = "#402196F3";

    /* renamed from: v, reason: collision with root package name */
    private String f5826v = "#8FC31F";

    /* renamed from: w, reason: collision with root package name */
    private String f5827w = "#03A9F4";

    /* renamed from: x, reason: collision with root package name */
    private String f5828x = "#FF89C120";
    private String y = "#FF2BAE5D";

    /* renamed from: z, reason: collision with root package name */
    private boolean f5829z = false;

    public final void a(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        TextView textView;
        TextView textView2;
        String str;
        String str2;
        float f;
        String str3;
        RelativeLayout.LayoutParams layoutParams;
        Context context = view != null ? view.getContext() : null;
        if (context == null || cVar == null) {
            return;
        }
        if (map == null || !map.containsKey("is_dy_success")) {
            textView = (TextView) view.findViewById(a(this.e));
            textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
        } else {
            boolean zBooleanValue = ((Boolean) map.get("is_dy_success")).booleanValue();
            this.f5829z = zBooleanValue;
            String str4 = this.e;
            if (zBooleanValue) {
                textView = (TextView) view.findViewById(b(str4));
                textView2 = (TextView) view.findViewById(b("mbridge_reward_click_tv"));
            } else {
                textView = (TextView) view.findViewById(a(str4));
                textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
            }
        }
        if (textView != null) {
            textView.setBackgroundResource(x.a(context, "mbridge_reward_shape_progress", "drawable"));
            textView.setTextColor(Color.parseColor(this.f5821p));
            textView.setTextSize(11.0f);
        }
        if (textView2 != null) {
            textView2.setTextSize(20.0f);
            if (textView2 instanceof MBridgeTextView) {
                ((MBridgeTextView) textView2).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView2));
            }
            if (textView2 instanceof MBTextView) {
                ((MBTextView) textView2).setAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView2));
            }
        }
        String str5 = this.f5822q;
        String str6 = this.f5824s;
        int i10 = cVar.i();
        float f10 = 1.0f;
        if (i10 == 302) {
            str = this.t;
            str2 = this.f5827w;
            str5 = this.f5821p;
            f = 10.0f;
            str3 = this.f5825u;
        } else if (i10 != 802) {
            str = this.f5826v;
            if (i10 != 5002010) {
                str2 = this.f5824s;
                str3 = str6;
                f = 5.0f;
            } else {
                str5 = this.f5821p;
                str2 = str;
                f = 10.0f;
                str3 = str2;
            }
        } else {
            str = this.f5821p;
            str5 = this.f5822q;
            f10 = 0.5f;
            str3 = this.f5823r;
            f = 25.0f;
            str2 = str;
        }
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor(str5));
            com.mbridge.msdk.video.dynview.i.b.a.a(textView2, f10, f, str3, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
        }
        if (cVar.f() != null && (layoutParams = (RelativeLayout.LayoutParams) cVar.f().getLayoutParams()) != null) {
            layoutParams.setMargins(0, 0, 0, 0);
            cVar.f().setLayoutParams(layoutParams);
        }
        boolean z9 = this.f5829z;
        String str7 = this.g;
        RelativeLayout relativeLayout = z9 ? (RelativeLayout) view.findViewById(b(str7)) : (RelativeLayout) view.findViewById(a(str7));
        if (relativeLayout != null) {
            if (com.mbridge.msdk.video.dynview.a.a.f5682a == 0 && com.mbridge.msdk.video.dynview.a.a.f5683b == 0 && com.mbridge.msdk.video.dynview.a.a.f5684c == 0 && com.mbridge.msdk.video.dynview.a.a.f5685d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    public final void b(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        LinearLayout linearLayout;
        View viewFindViewById;
        if (view == null || cVar == null) {
            return;
        }
        if (view.getContext() != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.f5829z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            boolean z9 = this.f5829z;
            String str = this.f5816k;
            if (z9) {
                linearLayout = (LinearLayout) view.findViewById(b(str));
                viewFindViewById = view.findViewById(b(this.f5818m));
            } else {
                linearLayout = (LinearLayout) view.findViewById(a(str));
                viewFindViewById = view.findViewById(a(this.f5818m));
            }
            if (linearLayout != null && (linearLayout instanceof MBridgeLevelLayoutView)) {
                if (cVar.e() == 1) {
                    linearLayout.setOrientation(1);
                } else {
                    linearLayout.setOrientation(0);
                }
            }
            if (linearLayout != null && (linearLayout instanceof MBStarLevelLayoutView)) {
                linearLayout.setOrientation(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f5819n));
            if (relativeLayout != null) {
                if (relativeLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin + com.mbridge.msdk.video.dynview.a.a.f5682a, layoutParams.topMargin + com.mbridge.msdk.video.dynview.a.a.f5684c, layoutParams.rightMargin + com.mbridge.msdk.video.dynview.a.a.f5683b, layoutParams.bottomMargin + com.mbridge.msdk.video.dynview.a.a.f5685d);
                    relativeLayout.setLayoutParams(layoutParams);
                }
                if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams2.setMargins(layoutParams2.leftMargin + com.mbridge.msdk.video.dynview.a.a.f5682a, layoutParams2.topMargin + com.mbridge.msdk.video.dynview.a.a.f5684c, layoutParams2.rightMargin + com.mbridge.msdk.video.dynview.a.a.f5683b, layoutParams2.bottomMargin + com.mbridge.msdk.video.dynview.a.a.f5685d);
                    relativeLayout.setLayoutParams(layoutParams2);
                }
            }
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof TextView) {
                    TextView textView = (TextView) viewFindViewById;
                    textView.setTextColor(Color.parseColor(this.f5821p));
                    textView.setTextSize(22.0f);
                    com.mbridge.msdk.video.dynview.i.b.a.a(viewFindViewById, 1.0f, cVar.i() == 1302 ? 25 : 5, this.f5824s, new String[]{this.f5828x, this.y}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
                try {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new com.mbridge.msdk.video.dynview.h.b().c(viewFindViewById));
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.video.dynview.j.b.1
                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                        }
                    });
                    if (view instanceof MBFrameLayout) {
                        ((MBFrameLayout) view).setAnimator(animatorSet);
                    }
                    if (view instanceof MBridgeFramLayout) {
                        ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                    }
                    if (view instanceof MBridgeRelativeLayout) {
                        ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new com.mbridge.msdk.video.dynview.h.b().c(view, 500L);
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public final void a(View view, Map<String, Object> map) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view == null || !(view instanceof MBridgeFramLayout)) {
            return;
        }
        MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
        AnimatorSet animatorSet = new AnimatorSet();
        if (view.getContext() != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.f5829z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            boolean z9 = this.f5829z;
            String str = this.f5810a;
            if (z9) {
                imageView = (ImageView) view.findViewById(b(str));
                imageView2 = (ImageView) view.findViewById(b(this.f5811b));
                imageView3 = (ImageView) view.findViewById(b(this.f5812c));
                imageView4 = (ImageView) view.findViewById(b(this.f5813d));
            } else {
                imageView = (ImageView) view.findViewById(a(str));
                imageView2 = (ImageView) view.findViewById(a(this.f5811b));
                imageView3 = (ImageView) view.findViewById(a(this.f5812c));
                imageView4 = (ImageView) view.findViewById(a(this.f5813d));
            }
            ObjectAnimator objectAnimatorA = imageView != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView) : null;
            ObjectAnimator objectAnimatorB = imageView2 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView2) : null;
            ObjectAnimator objectAnimatorA2 = imageView3 != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView3) : null;
            ObjectAnimator objectAnimatorB2 = imageView4 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView4) : null;
            if (objectAnimatorA == null || objectAnimatorA2 == null || objectAnimatorB == null || objectAnimatorB2 == null) {
                return;
            }
            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2, objectAnimatorB, objectAnimatorB2);
            mBridgeFramLayout.setAnimatorSet(animatorSet);
        }
    }

    public final void a(View view, com.mbridge.msdk.video.dynview.c cVar) {
        Context context;
        int iA;
        if (view == null || cVar == null || (context = view.getContext()) == null) {
            return;
        }
        if (cVar.e() == 1) {
            view.setBackground(context.getResources().getDrawable(x.a(context, this.f5820o, "drawable")));
            TextView textView = (TextView) view.findViewById(a(this.h));
            if (textView != null) {
                textView.setTextColor(Color.parseColor(this.f5822q));
            }
            TextView textView2 = (TextView) view.findViewById(a(this.f5814i));
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(this.f5822q));
            }
            iA = ak.a(context, 2.0f);
        } else {
            iA = ak.a(context, 10.0f);
            view.getBackground().setAlpha(100);
        }
        int iA2 = ak.a(context, 8.0f);
        View viewFindViewById = view.findViewById(a(this.f5815j));
        if (viewFindViewById != null) {
            if (cVar.f() != null && (cVar.f() instanceof MBridgeClickCTAView)) {
                ((MBridgeClickCTAView) cVar.f()).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(viewFindViewById));
            }
            if (viewFindViewById instanceof TextView) {
                TextView textView3 = (TextView) viewFindViewById;
                textView3.setTextColor(Color.parseColor(this.f5821p));
                textView3.setTextSize(15.0f);
                String str = this.f5826v;
                String str2 = this.f5824s;
                com.mbridge.msdk.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str2, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (view.getLayoutParams() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(iA, iA, iA, iA2);
            layoutParams.height = ak.a(context, 60.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    private int a(String str) {
        return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }
}
