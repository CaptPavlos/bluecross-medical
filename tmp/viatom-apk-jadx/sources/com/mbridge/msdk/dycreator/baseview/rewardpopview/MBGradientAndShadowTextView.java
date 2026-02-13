package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBGradientAndShadowTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f3154a;

    /* renamed from: b, reason: collision with root package name */
    private int f3155b;

    /* renamed from: c, reason: collision with root package name */
    private int f3156c;

    /* renamed from: d, reason: collision with root package name */
    private int f3157d;
    private LinearGradient e;
    public float mShadowDx;
    public float mShadowDy;
    public float mShadowRadius;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class GradientAndShadowParameters {
        public int gradientEndColor;
        public int gradientStartColor;
        public int shadowColor;
        public int textSize = 40;
        public float shadowRadius = 3.0f;
        public float shadowDx = 1.5f;
        public float shadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context, GradientAndShadowParameters gradientAndShadowParameters) {
        super(context);
        this.f3154a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f3155b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f3156c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f3157d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
        if (gradientAndShadowParameters != null) {
            this.f3154a = gradientAndShadowParameters.gradientStartColor;
            this.f3155b = gradientAndShadowParameters.gradientEndColor;
            this.f3156c = gradientAndShadowParameters.shadowColor;
            this.f3157d = gradientAndShadowParameters.textSize;
            this.mShadowRadius = gradientAndShadowParameters.shadowRadius;
            this.mShadowDx = gradientAndShadowParameters.shadowDx;
            this.mShadowDy = gradientAndShadowParameters.shadowDy;
        }
        a();
    }

    private void a() {
        setTextSize(this.f3157d);
        setTypeface(Typeface.defaultFromStyle(3));
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, getTextSize(), this.f3154a, this.f3155b, Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getPaint().setShader(null);
        getPaint().setShadowLayer(3.0f, 1.5f, 1.8f, this.f3156c);
        super.onDraw(canvas);
        getPaint().clearShadowLayer();
        getPaint().setShader(this.e);
        super.onDraw(canvas);
    }

    public MBGradientAndShadowTextView(Context context) {
        super(context);
        this.f3154a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f3155b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f3156c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f3157d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
        a();
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3154a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f3155b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f3156c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f3157d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3154a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f3155b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f3156c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f3157d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }

    @RequiresApi(api = 21)
    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3154a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f3155b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f3156c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f3157d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }
}
