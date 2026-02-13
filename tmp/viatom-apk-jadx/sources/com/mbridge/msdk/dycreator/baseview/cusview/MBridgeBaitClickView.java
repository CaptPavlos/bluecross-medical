package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;

    /* renamed from: a, reason: collision with root package name */
    private MBridgeDyImageView f3047a;

    /* renamed from: b, reason: collision with root package name */
    private MBridgeDyImageView f3048b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f3049c;

    /* renamed from: d, reason: collision with root package name */
    private String f3050d;
    private String e;
    private String f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f3051i;

    /* renamed from: j, reason: collision with root package name */
    private Animation f3052j;

    /* renamed from: k, reason: collision with root package name */
    private Animation f3053k;

    /* renamed from: l, reason: collision with root package name */
    private Animation f3054l;

    public MBridgeBaitClickView(@NonNull Context context) {
        super(context);
        this.f3050d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = 1342177280;
    }

    public void init() {
        try {
            setBackgroundColor(this.h);
            try {
                this.f = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "点击查看详情" : "Click now for details";
            } catch (Throwable th) {
                af.b("MBridgeAnimationClickView", th.getMessage());
            }
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int iA = ak.a(getContext(), 55.0f);
            int iA2 = ak.a(getContext(), 33.0f);
            this.f3048b = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
            layoutParams.setMargins(iA2, iA2, 0, 0);
            this.f3048b.setLayoutParams(layoutParams);
            final int iA3 = x.a(getContext(), "mbridge_icon_click_circle", "drawable");
            if (TextUtils.isEmpty(this.e)) {
                this.f3048b.setImageResource(iA3);
            } else {
                b.a(c.m().c()).a(this.f3050d, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.1
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f3048b.setImageResource(iA3);
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f3048b.setImageBitmap(bitmap);
                    }
                });
            }
            int iA4 = ak.a(getContext(), 108.0f);
            int iA5 = ak.a(getContext(), 35.0f);
            int iA6 = ak.a(getContext(), 43.0f);
            this.f3047a = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA4, iA4);
            layoutParams2.setMargins(iA5, iA6, 0, 0);
            this.f3047a.setLayoutParams(layoutParams2);
            final int iA7 = x.a(getContext(), "mbridge_icon_click_hand", "drawable");
            if (TextUtils.isEmpty(this.f3050d)) {
                this.f3047a.setImageResource(iA7);
            } else {
                b.a(c.m().c()).a(this.f3050d, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.2
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f3047a.setImageResource(iA7);
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f3047a.setImageBitmap(bitmap);
                    }
                });
            }
            relativeLayout.addView(this.f3048b);
            relativeLayout.addView(this.f3047a);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.f3049c = new TextView(getContext());
            this.f3049c.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f3049c.setText(this.f);
            this.f3049c.setTextColor(-1);
            this.f3049c.setGravity(14);
            linearLayout.addView(this.f3049c);
            addView(linearLayout);
        } catch (Throwable th2) {
            af.b("MBridgeAnimationClickView", th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.f3051i;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f3052j;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f3053k;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f3054l;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i10 = this.g;
        if (i10 == 2) {
            this.f3048b.setVisibility(4);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f3051i = scaleAnimation;
            scaleAnimation.setDuration(500L);
            this.f3051i.setRepeatCount(-1);
            this.f3051i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView = this.f3047a;
            if (mBridgeDyImageView != null) {
                mBridgeDyImageView.startAnimation(this.f3051i);
                return;
            }
            return;
        }
        if (i10 == 3) {
            MBridgeDyImageView mBridgeDyImageView2 = this.f3048b;
            if (mBridgeDyImageView2 != null) {
                mBridgeDyImageView2.setVisibility(4);
            }
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f3051i = scaleAnimation2;
            scaleAnimation2.setDuration(500L);
            this.f3051i.setRepeatCount(1);
            this.f3051i.setRepeatMode(2);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.f3052j = scaleAnimation3;
            scaleAnimation3.setDuration(1000L);
            this.f3052j.setRepeatCount(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f3053k = alphaAnimation;
            alphaAnimation.setDuration(1000L);
            this.f3053k.setRepeatCount(0);
            final AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(this.f3052j);
            animationSet.addAnimation(this.f3053k);
            this.f3052j.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (MBridgeBaitClickView.this.f3048b != null) {
                        MBridgeBaitClickView.this.f3048b.setVisibility(4);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (MBridgeBaitClickView.this.f3048b != null) {
                        MBridgeBaitClickView.this.f3048b.setVisibility(0);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.f3051i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f3047a != null) {
                                MBridgeBaitClickView.this.f3047a.startAnimation(MBridgeBaitClickView.this.f3051i);
                            }
                        }
                    }, 1000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f3048b != null) {
                                MBridgeBaitClickView.this.f3048b.startAnimation(animationSet);
                            }
                        }
                    }, 550L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            MBridgeDyImageView mBridgeDyImageView3 = this.f3047a;
            if (mBridgeDyImageView3 != null) {
                mBridgeDyImageView3.startAnimation(this.f3051i);
                return;
            }
            return;
        }
        if (i10 == 4) {
            this.f3048b.setVisibility(4);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.f3051i = scaleAnimation4;
            scaleAnimation4.setDuration(200L);
            this.f3051i.setRepeatCount(1);
            this.f3051i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f3047a != null) {
                                MBridgeBaitClickView.this.f3047a.startAnimation(MBridgeBaitClickView.this.f3051i);
                            }
                        }
                    }, 1000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            MBridgeDyImageView mBridgeDyImageView4 = this.f3047a;
            if (mBridgeDyImageView4 != null) {
                mBridgeDyImageView4.startAnimation(this.f3051i);
                return;
            }
            return;
        }
        if (i10 != 5) {
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f3051i = scaleAnimation5;
            scaleAnimation5.setDuration(200L);
            this.f3051i.setRepeatCount(-1);
            this.f3051i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView5 = this.f3047a;
            if (mBridgeDyImageView5 != null) {
                mBridgeDyImageView5.startAnimation(this.f3051i);
            }
            ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.f3052j = scaleAnimation6;
            scaleAnimation6.setDuration(400L);
            this.f3052j.setRepeatCount(-1);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.3f);
            this.f3053k = alphaAnimation2;
            alphaAnimation2.setDuration(400L);
            this.f3053k.setRepeatCount(-1);
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(this.f3052j);
            animationSet2.addAnimation(this.f3053k);
            MBridgeDyImageView mBridgeDyImageView6 = this.f3048b;
            if (mBridgeDyImageView6 != null) {
                mBridgeDyImageView6.startAnimation(animationSet2);
                return;
            }
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.f3054l = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.f3054l.setRepeatMode(2);
        this.f3054l.setRepeatCount(-1);
        ScaleAnimation scaleAnimation7 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f3052j = scaleAnimation7;
        scaleAnimation7.setDuration(600L);
        this.f3052j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        this.f3053k = alphaAnimation3;
        alphaAnimation3.setDuration(600L);
        this.f3053k.setRepeatCount(-1);
        AnimationSet animationSet3 = new AnimationSet(true);
        animationSet3.addAnimation(this.f3052j);
        animationSet3.addAnimation(this.f3053k);
        MBridgeDyImageView mBridgeDyImageView7 = this.f3047a;
        if (mBridgeDyImageView7 != null) {
            mBridgeDyImageView7.startAnimation(this.f3054l);
        }
        MBridgeDyImageView mBridgeDyImageView8 = this.f3048b;
        if (mBridgeDyImageView8 != null) {
            mBridgeDyImageView8.startAnimation(animationSet3);
        }
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3050d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = 1342177280;
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3050d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = 1342177280;
    }

    @RequiresApi(api = 21)
    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3050d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = 1342177280;
    }

    public void init(int i10, int i11) {
        this.h = i10;
        this.g = i11;
        init();
    }

    public void init(int i10, int i11, String str, String str2, String str3) {
        this.h = i10;
        this.g = i11;
        this.f3050d = str;
        this.e = str2;
        this.f = str3;
        init();
    }

    public void init(int i10) {
        this.g = i10;
        init();
    }
}
