package com.mbridge.msdk.dycreator.baseview.cusview;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeSegmentsProgressBar extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f3081a;

    /* renamed from: b, reason: collision with root package name */
    private int f3082b;

    /* renamed from: c, reason: collision with root package name */
    private int f3083c;

    /* renamed from: d, reason: collision with root package name */
    private int f3084d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private List<ProgressBar> f3085i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f3086j;

    /* renamed from: k, reason: collision with root package name */
    private String f3087k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3088l;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
        this.f3081a = "MBridgeSegmentsProgressBar";
        this.f3083c = 1;
        this.f3084d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.f3085i = new ArrayList();
        this.f3088l = false;
    }

    private void a() {
        Drawable drawable;
        try {
            this.f3088l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.f3083c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f3087k)) {
                    this.f3087k = this.f3088l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f3083c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f3087k)) {
                    this.f3087k = this.f3088l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f3085i.clear();
            removeAllViews();
            setBackground(c());
            TextView textView = new TextView(getContext());
            this.f3086j = textView;
            textView.setTextColor(-1);
            this.f3086j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f3086j.setLayoutParams(layoutParams);
            if (this.f3083c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.f3086j;
                int i10 = this.f3084d;
                textView2.setPadding(i10 / 2, 15, i10 / 2, 5);
            }
            if (this.f3083c == 2) {
                this.f3086j.setGravity(16);
                TextView textView3 = this.f3086j;
                int i11 = this.f3084d;
                textView3.setPadding(i11 / 2, 0, i11 / 2, 0);
            }
            try {
                int iA = x.a(getContext(), "mbridge_reward_video_icon", "drawable");
                if (iA != 0 && (drawable = getContext().getResources().getDrawable(iA)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f3086j.setCompoundDrawables(drawable, null, null, null);
                    this.f3086j.setCompoundDrawablePadding(5);
                }
            } catch (Throwable th2) {
                af.b("MBridgeSegmentsProgressBar", th2.getMessage());
            }
            this.f3086j.setText(a(this.f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i12 = 0; i12 < this.f3082b; i12++) {
                ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(b());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
                int i13 = this.f3084d;
                layoutParams3.leftMargin = i13 / 2;
                layoutParams3.rightMargin = i13 / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.f3085i.add(progressBar);
            }
            int i14 = this.f3083c;
            if (i14 == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.f3086j);
                addView(linearLayout);
            } else {
                if (i14 != 2) {
                    addView(linearLayout);
                    return;
                }
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.f3086j);
            }
        } catch (Throwable th3) {
            af.b("MBridgeSegmentsProgressBar", th3.getMessage());
        }
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.e);
        gradientDrawable.setColor(this.g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.e);
        gradientDrawable2.setColor(this.h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    private GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f3082b = i10;
        this.f3083c = i11;
        this.h = i12;
        this.g = i13;
        this.f3084d = i14;
        this.e = i15;
        a();
    }

    public void setIndicatorText(String str) {
        this.f3087k = str;
    }

    public void setProgress(int i10, int i11) {
        try {
            if (this.f3085i.size() == 0) {
                return;
            }
            if (i11 < this.f3085i.size()) {
                this.f3085i.get(i11).setProgress(i10);
            }
            int i12 = i11 + 1;
            if (i12 > this.f) {
                this.f = i12;
                TextView textView = this.f3086j;
                if (textView != null) {
                    textView.setText(a(i12));
                }
            }
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
    }

    public void init(int i10, int i11, int i12, int i13) {
        this.f3082b = i10;
        this.f3083c = i11;
        this.h = i12;
        this.g = i13;
        a();
    }

    public void init(int i10, int i11) {
        this.f3082b = i10;
        this.f3083c = i11;
        a();
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3081a = "MBridgeSegmentsProgressBar";
        this.f3083c = 1;
        this.f3084d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.f3085i = new ArrayList();
        this.f3088l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3081a = "MBridgeSegmentsProgressBar";
        this.f3083c = 1;
        this.f3084d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.f3085i = new ArrayList();
        this.f3088l = false;
    }

    @RequiresApi(api = 21)
    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3081a = "MBridgeSegmentsProgressBar";
        this.f3083c = 1;
        this.f3084d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.f3085i = new ArrayList();
        this.f3088l = false;
    }

    private StringBuilder a(int i10) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format(this.f3087k, Integer.valueOf(i10), Integer.valueOf(this.f3082b)));
            return sb;
        } catch (Throwable th) {
            sb.append(this.f3082b);
            sb.append("videos, the");
            sb.append(i10);
            sb.append(" is playing.");
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
            return sb;
        }
    }
}
