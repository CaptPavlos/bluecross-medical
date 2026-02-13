package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBSplashShakeView extends MBLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f3007a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3008b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3009c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3010d;
    private final String e;
    private final String f;
    private ImageView g;
    private Animation h;

    public MBSplashShakeView(Context context) {
        super(context);
        this.f3007a = "浏览第三方应用";
        this.f3008b = "View";
        this.f3009c = "打开第三方应用";
        this.f3010d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashShakeView.initView(java.lang.String):void");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.h = rotateAnimation;
            rotateAnimation.setDuration(100L);
            this.h.setRepeatMode(2);
            this.h.setRepeatCount(-1);
            this.g.startAnimation(this.h);
        }
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3007a = "浏览第三方应用";
        this.f3008b = "View";
        this.f3009c = "打开第三方应用";
        this.f3010d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3007a = "浏览第三方应用";
        this.f3008b = "View";
        this.f3009c = "打开第三方应用";
        this.f3010d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }
}
