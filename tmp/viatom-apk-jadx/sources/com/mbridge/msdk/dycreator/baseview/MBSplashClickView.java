package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* renamed from: a, reason: collision with root package name */
    private final String f2981a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2982b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2983c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2984d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;

    /* renamed from: i, reason: collision with root package name */
    private final String f2985i;

    /* renamed from: j, reason: collision with root package name */
    private final String f2986j;

    /* renamed from: k, reason: collision with root package name */
    private final String f2987k;

    /* renamed from: l, reason: collision with root package name */
    private final String f2988l;

    /* renamed from: m, reason: collision with root package name */
    private String f2989m;

    /* renamed from: n, reason: collision with root package name */
    private int f2990n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f2991o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f2992p;

    /* renamed from: q, reason: collision with root package name */
    private final RectF f2993q;

    /* renamed from: r, reason: collision with root package name */
    private final Paint f2994r;

    /* renamed from: s, reason: collision with root package name */
    private final Paint f2995s;

    public MBSplashClickView(Context context) {
        super(context);
        this.f2981a = "浏览第三方应用";
        this.f2982b = "View";
        this.f2983c = "打开第三方应用";
        this.f2984d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.f2985i = "mbridge_splash_btn_finger";
        this.f2986j = "mbridge_splash_btn_go";
        this.f2987k = "mbridge_splash_btn_light";
        this.f2988l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f2993q = new RectF();
        this.f2994r = new Paint();
        this.f2995s = new Paint();
        a();
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = viewGroup.getChildAt(i10);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e) {
                af.b("MBSplashClickView", e.getMessage());
            }
        }
        return null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f2993q, this.f2995s, 31);
        canvas.drawRoundRect(this.f2993q, 200.0f, 200.0f, this.f2995s);
        canvas.saveLayer(this.f2993q, this.f2994r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.initView(java.lang.String):void");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i10 = this.f2990n;
        if (i10 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f2991o.startAnimation(scaleAnimation);
            return;
        }
        if (i10 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f2991o.setVisibility(4);
                    MBSplashClickView.this.f2991o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.f2991o.startAnimation(animation);
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f2991o.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.f2991o.startAnimation(translateAnimation);
            return;
        }
        if (i10 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(1000L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(400L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f2992p.setVisibility(4);
                    MBSplashClickView.this.f2992p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.f2992p.startAnimation(scaleAnimation3);
                        }
                    }, 1600L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f2992p.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.f2992p.setVisibility(4);
            this.f2991o.startAnimation(scaleAnimation2);
            this.f2992p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    MBSplashClickView.this.f2992p.startAnimation(scaleAnimation3);
                }
            }, 800L);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        super.onLayout(z9, i10, i11, i12, i13);
        this.f2993q.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    private void a() {
        this.f2994r.setAntiAlias(true);
        this.f2994r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f2995s.setAntiAlias(true);
        this.f2995s.setColor(-1);
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2981a = "浏览第三方应用";
        this.f2982b = "View";
        this.f2983c = "打开第三方应用";
        this.f2984d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.f2985i = "mbridge_splash_btn_finger";
        this.f2986j = "mbridge_splash_btn_go";
        this.f2987k = "mbridge_splash_btn_light";
        this.f2988l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f2993q = new RectF();
        this.f2994r = new Paint();
        this.f2995s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2981a = "浏览第三方应用";
        this.f2982b = "View";
        this.f2983c = "打开第三方应用";
        this.f2984d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.f2985i = "mbridge_splash_btn_finger";
        this.f2986j = "mbridge_splash_btn_go";
        this.f2987k = "mbridge_splash_btn_light";
        this.f2988l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f2993q = new RectF();
        this.f2994r = new Paint();
        this.f2995s = new Paint();
        a();
    }
}
