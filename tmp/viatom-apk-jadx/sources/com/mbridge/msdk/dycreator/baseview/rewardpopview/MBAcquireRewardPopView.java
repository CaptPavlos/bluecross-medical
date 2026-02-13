package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBAcquireRewardPopView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f3127a;

    /* renamed from: b, reason: collision with root package name */
    private AcquireRewardPopViewParameters f3128b;

    /* renamed from: c, reason: collision with root package name */
    private AnimationSet f3129c;

    /* renamed from: d, reason: collision with root package name */
    private float f3130d;
    private float e;
    private float f;
    private float g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3131i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3132j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f3133k;

    /* renamed from: l, reason: collision with root package name */
    private final View.OnClickListener f3134l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f3135m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f3136n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnTouchListener f3137o;

    /* renamed from: p, reason: collision with root package name */
    private final View.OnClickListener f3138p;

    /* renamed from: q, reason: collision with root package name */
    private final View.OnClickListener f3139q;

    public MBAcquireRewardPopView(Context context) {
        super(context);
        this.f3127a = "MBAcquireRewardPopView";
        this.f3130d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f3134l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f3135m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f3128b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                    if (zContains) {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                    } else {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView4 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView4.postDelayed(mBAcquireRewardPopView4.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f3135m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                int i10 = MBAcquireRewardPopView.this.h;
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                if (i10 > 0) {
                    MBAcquireRewardPopView.i(mBAcquireRewardPopView);
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f3135m, 1000L);
                } else {
                    if (mBAcquireRewardPopView.f3128b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f3131i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f3136n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f3131i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f3137o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f3130d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action == 1) {
                    float f = MBAcquireRewardPopView.this.f;
                    float f10 = MBAcquireRewardPopView.this.f3130d;
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    if (f <= f10) {
                        mBAcquireRewardPopView.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else if (Math.abs(mBAcquireRewardPopView.f - MBAcquireRewardPopView.this.f3130d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else {
                        if (MBAcquireRewardPopView.this.f3132j) {
                            return false;
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView2.removeCallbacks(mBAcquireRewardPopView2.f3135m);
                        MBAcquireRewardPopView.this.f3132j = true;
                        View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                        View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                        if (childAt != null) {
                            MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                        }
                        if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                            MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } else if (action == 2) {
                    MBAcquireRewardPopView.this.f = motionEvent.getX();
                    MBAcquireRewardPopView.this.g = motionEvent.getY();
                }
                return false;
            }
        };
        this.f3138p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.f3139q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f3131i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    private View a(ArrayList<String> arrayList) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f3128b;
        int i10 = acquireRewardPopViewParameters.viewBackLayerTopColor;
        int i11 = acquireRewardPopViewParameters.viewBackLayerBottomColor;
        int i12 = acquireRewardPopViewParameters.viewForegroundTopColor;
        int i13 = acquireRewardPopViewParameters.viewForegroundBottomColor;
        int[] iArr = {i10, i11};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable gradientDrawableA = a(iArr, orientation);
        gradientDrawableA.setCornerRadius(ak.a(getContext(), 12.0f));
        GradientDrawable gradientDrawableA2 = a(new int[]{i12, i13}, orientation);
        gradientDrawableA2.setCornerRadius(ak.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawableA, gradientDrawableA2});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        linearLayout.setBackground(layerDrawable);
        ImageView imageView = new ImageView(getContext());
        int iA = ak.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().g()));
        imageView.setOnClickListener(this.f3139q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int iA2 = ak.a(getContext(), 18.0f);
        layoutParams3.setMargins(iA2, 5, iA2, ak.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.f3128b.title);
        textView.setTextColor(this.f3128b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList != null && arrayList.size() > 1) {
            int iA3 = ak.a(getContext(), 8.0f);
            int iA4 = ak.a(getContext(), 24.0f);
            int iA5 = ak.a(getContext(), 30.0f);
            int iA6 = ak.a(getContext(), 12.0f);
            int iA7 = ak.a(getContext(), 40.0f);
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                boolean zContains = this.f3128b.rightAnswerList.contains(arrayList.get(i14));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(iA5, iA6, iA5, 0);
                textView2.setPadding(iA4, iA3, iA4, iA3);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList.get(i14));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList.get(i14));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f3128b;
                textView2.setTextColor(zContains ? acquireRewardPopViewParameters2.buttonTextLightColor : acquireRewardPopViewParameters2.buttonTextDarkColor);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f3128b;
                int i15 = zContains ? acquireRewardPopViewParameters3.buttonBackgroundLightColor : acquireRewardPopViewParameters3.buttonBackgroundDarkColor;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i15);
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(iA7);
                textView2.setBackground(gradientDrawable);
                textView2.setOnClickListener(this.f3134l);
                linearLayout.addView(textView2);
            }
        }
        this.f3133k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int iA8 = ak.a(getContext(), 16.0f);
        int iA9 = ak.a(getContext(), 18.0f);
        layoutParams5.setMargins(iA9, iA8, iA9, iA8);
        layoutParams5.gravity = 1;
        this.f3133k.setLayoutParams(layoutParams5);
        TextView textView3 = this.f3133k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f3128b;
        textView3.setText(String.format(acquireRewardPopViewParameters4.tips, Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)));
        this.f3133k.setTextColor(this.f3128b.tipTextColor);
        this.f3133k.setGravity(17);
        this.f3133k.setTextSize(12.0f);
        linearLayout.addView(this.f3133k);
        return linearLayout;
    }

    public static /* synthetic */ View e(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f3128b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = mBAcquireRewardPopView.f3128b;
        int i10 = acquireRewardPopViewParameters2.viewType;
        String str = i10 == 1 ? acquireRewardPopViewParameters2.successTitle : i10 == 2 ? acquireRewardPopViewParameters2.slideSuccessTitle : "";
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(" " + str + " ");
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable gradientDrawableA = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f3128b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = mBAcquireRewardPopView.f3128b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)));
        int iA = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int iA2 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(iA2, iA, iA2, iA);
        textView.setBackground(gradientDrawableA);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static /* synthetic */ View f(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f3128b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(" " + mBAcquireRewardPopView.f3128b.failTitle + " ");
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable gradientDrawableA = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f3128b.failTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.f3128b.failTip, ""));
        int iA = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int iA2 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(iA2, iA, iA2, iA);
        textView.setBackground(gradientDrawableA);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static /* synthetic */ int i(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i10 = mBAcquireRewardPopView.h;
        mBAcquireRewardPopView.h = i10 - 1;
        return i10;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        View viewA;
        if (acquireRewardPopViewParameters == null) {
            af.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.f3128b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f3128b;
            if (acquireRewardPopViewParameters2 != null) {
                Collection<? extends String> collection = acquireRewardPopViewParameters2.rightAnswerList;
                if (collection != null) {
                    arrayList.addAll(collection);
                }
                if (this.f3128b.wrongAnswerList != null) {
                    int iNextInt = new Random().nextInt(this.f3128b.wrongAnswerList.size());
                    if (iNextInt > this.f3128b.wrongAnswerList.size() - 1) {
                        iNextInt = 0;
                    }
                    arrayList.add(this.f3128b.wrongAnswerList.get(iNextInt));
                }
            }
            viewA = a(arrayList);
            if (this.f3128b.canClickMaskArea) {
                setOnClickListener(this.f3138p);
            }
        } else {
            viewA = null;
        }
        if (this.f3128b.viewType == 2) {
            int iA = ak.a(getContext(), 290.0f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f3128b;
            gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters3.successTitleGradientStartColor;
            gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters3.successTitleGradientEndColor;
            gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters3.successTitleShadowColor;
            gradientAndShadowParameters.textSize = 30;
            MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, ak.a(getContext(), 12.0f));
            layoutParams2.gravity = 1;
            mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
            mBGradientAndShadowTextView.setText(" " + this.f3128b.slideTitle + " ");
            mBGradientAndShadowTextView.setGravity(17);
            linearLayout.addView(mBGradientAndShadowTextView);
            GradientDrawable gradientDrawableA = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
            this.f3133k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, 0, 0, ak.a(getContext(), 25.0f));
            this.f3133k.setLayoutParams(layoutParams3);
            this.f3133k.setTextSize(12.0f);
            this.f3133k.setGravity(17);
            this.f3133k.setTextColor(this.f3128b.successTipTextColor);
            TextView textView = this.f3133k;
            AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f3128b;
            textView.setText(String.format(acquireRewardPopViewParameters4.slideTip, Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)));
            int iA2 = ak.a(getContext(), 6.0f);
            int iA3 = ak.a(getContext(), 32.0f);
            this.f3133k.setPadding(iA3, iA2, iA3, iA2);
            this.f3133k.setBackground(gradientDrawableA);
            linearLayout.addView(this.f3133k);
            View imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().g()));
            linearLayout.addView(imageView);
            View imageView2 = new ImageView(getContext());
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().g()));
            linearLayout.addView(imageView2);
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, view);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (MBAcquireRewardPopView.this.f3129c != null) {
                        MBAcquireRewardPopView.this.f3129c.cancel();
                    }
                }
            });
            linearLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.this.setLongClickable(true);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.f3137o);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
            viewA = linearLayout;
        }
        if (viewA != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.f3128b.containerBackgroundColor);
            addView(viewA);
            int i10 = this.f3128b.autoDismissTime;
            if (i10 > 0) {
                this.h = i10;
                post(this.f3135m);
                this.f3131i = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3135m);
    }

    public void onPause() {
        if (!this.f3131i || this.h <= 0) {
            return;
        }
        removeCallbacks(this.f3135m);
    }

    public void onResume() {
        if (!this.f3131i || this.h <= 0) {
            return;
        }
        post(this.f3135m);
    }

    public void onStop() {
        if (!this.f3131i || this.h <= 0) {
            return;
        }
        removeCallbacks(this.f3135m);
    }

    public void onTimeLessThanReduce(int i10) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f3128b;
        acquireRewardPopViewParameters.reduceTime = i10;
        TextView textView = this.f3133k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, Integer.valueOf(i10)));
        }
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3127a = "MBAcquireRewardPopView";
        this.f3130d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f3134l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f3135m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f3128b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                    if (zContains) {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                    } else {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView4 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView4.postDelayed(mBAcquireRewardPopView4.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f3135m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                int i10 = MBAcquireRewardPopView.this.h;
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                if (i10 > 0) {
                    MBAcquireRewardPopView.i(mBAcquireRewardPopView);
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f3135m, 1000L);
                } else {
                    if (mBAcquireRewardPopView.f3128b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f3131i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f3136n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f3131i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f3137o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f3130d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action == 1) {
                    float f = MBAcquireRewardPopView.this.f;
                    float f10 = MBAcquireRewardPopView.this.f3130d;
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    if (f <= f10) {
                        mBAcquireRewardPopView.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else if (Math.abs(mBAcquireRewardPopView.f - MBAcquireRewardPopView.this.f3130d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else {
                        if (MBAcquireRewardPopView.this.f3132j) {
                            return false;
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView2.removeCallbacks(mBAcquireRewardPopView2.f3135m);
                        MBAcquireRewardPopView.this.f3132j = true;
                        View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                        View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                        if (childAt != null) {
                            MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                        }
                        if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                            MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } else if (action == 2) {
                    MBAcquireRewardPopView.this.f = motionEvent.getX();
                    MBAcquireRewardPopView.this.g = motionEvent.getY();
                }
                return false;
            }
        };
        this.f3138p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.f3139q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f3131i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3127a = "MBAcquireRewardPopView";
        this.f3130d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f3134l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f3135m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f3128b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                    if (zContains) {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                    } else {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView4 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView4.postDelayed(mBAcquireRewardPopView4.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f3135m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                int i102 = MBAcquireRewardPopView.this.h;
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                if (i102 > 0) {
                    MBAcquireRewardPopView.i(mBAcquireRewardPopView);
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f3135m, 1000L);
                } else {
                    if (mBAcquireRewardPopView.f3128b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f3131i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f3136n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f3131i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f3137o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f3130d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action == 1) {
                    float f = MBAcquireRewardPopView.this.f;
                    float f10 = MBAcquireRewardPopView.this.f3130d;
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    if (f <= f10) {
                        mBAcquireRewardPopView.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else if (Math.abs(mBAcquireRewardPopView.f - MBAcquireRewardPopView.this.f3130d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else {
                        if (MBAcquireRewardPopView.this.f3132j) {
                            return false;
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView2.removeCallbacks(mBAcquireRewardPopView2.f3135m);
                        MBAcquireRewardPopView.this.f3132j = true;
                        View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                        View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                        if (childAt != null) {
                            MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                        }
                        if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                            MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } else if (action == 2) {
                    MBAcquireRewardPopView.this.f = motionEvent.getX();
                    MBAcquireRewardPopView.this.g = motionEvent.getY();
                }
                return false;
            }
        };
        this.f3138p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.f3139q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f3131i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    @RequiresApi(api = 21)
    public MBAcquireRewardPopView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3127a = "MBAcquireRewardPopView";
        this.f3130d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f3134l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f3135m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f3128b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                    if (zContains) {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                    } else {
                        mBAcquireRewardPopView3.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView4 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView4.postDelayed(mBAcquireRewardPopView4.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f3135m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                int i102 = MBAcquireRewardPopView.this.h;
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                if (i102 > 0) {
                    MBAcquireRewardPopView.i(mBAcquireRewardPopView);
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f3135m, 1000L);
                } else {
                    if (mBAcquireRewardPopView.f3128b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f3131i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f3136n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f3131i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f3137o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f3130d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action == 1) {
                    float f = MBAcquireRewardPopView.this.f;
                    float f10 = MBAcquireRewardPopView.this.f3130d;
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    if (f <= f10) {
                        mBAcquireRewardPopView.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else if (Math.abs(mBAcquireRewardPopView.f - MBAcquireRewardPopView.this.f3130d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                        MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                    } else {
                        if (MBAcquireRewardPopView.this.f3132j) {
                            return false;
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView2.removeCallbacks(mBAcquireRewardPopView2.f3135m);
                        MBAcquireRewardPopView.this.f3132j = true;
                        View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                        View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                        if (childAt != null) {
                            MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                        }
                        if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                            MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f3128b.reduceTime);
                        }
                        MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                        mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f3136n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } else if (action == 2) {
                    MBAcquireRewardPopView.this.f = motionEvent.getX();
                    MBAcquireRewardPopView.this.g = motionEvent.getY();
                }
                return false;
            }
        };
        this.f3138p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f3130d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.f3139q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f3128b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f3128b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f3131i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    public static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(true);
        mBAcquireRewardPopView.f3129c = animationSet;
        animationSet.addAnimation(translateAnimation);
        mBAcquireRewardPopView.f3129c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.f3129c);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        mBAcquireRewardPopView.f3129c.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(mBAcquireRewardPopView.f3129c);
    }

    public static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, View view, View view2) {
        mBAcquireRewardPopView.removeView(view);
        mBAcquireRewardPopView.addView(view2);
    }
}
