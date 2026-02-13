package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.webview.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ProgressBar extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    Runnable f4057a;

    /* renamed from: b, reason: collision with root package name */
    private float f4058b;

    /* renamed from: c, reason: collision with root package name */
    private float f4059c;

    /* renamed from: d, reason: collision with root package name */
    private float f4060d;
    private Drawable e;
    private float f;
    private long g;
    private Handler h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f4061i;

    /* renamed from: j, reason: collision with root package name */
    private int f4062j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4063k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4064l;

    /* renamed from: m, reason: collision with root package name */
    private long f4065m;

    /* renamed from: n, reason: collision with root package name */
    private float f4066n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4067o;

    /* renamed from: p, reason: collision with root package name */
    private c.a f4068p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f4069q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f4070r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f4071s;
    private float t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4072u;

    /* renamed from: v, reason: collision with root package name */
    private int f4073v;

    /* renamed from: w, reason: collision with root package name */
    private int f4074w;

    /* renamed from: x, reason: collision with root package name */
    private int f4075x;
    private long y;

    public ProgressBar(Context context) {
        super(context);
        this.f4057a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.g = 25L;
        this.h = new Handler(Looper.getMainLooper());
        this.f4063k = false;
        this.f4066n = 0.95f;
        this.f4067o = false;
        this.f4070r = new Rect();
        setWillNotDraw(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z9) {
        return null;
    }

    public float getProgress() {
        return this.f4058b;
    }

    public void initResource(boolean z9) throws Resources.NotFoundException {
        if (z9 || (this.f4061i == null && this.f4069q == null && this.f4071s == null && this.e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f4061i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f4061i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f4069q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f4069q.getIntrinsicHeight());
            }
            this.f4071s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        super.onLayout(z9, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.t = getMeasuredWidth();
    }

    public void onThemeChange() throws Resources.NotFoundException {
        if (this.f4063k) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z9) {
        super.onWindowFocusChanged(z9);
        Drawable drawable = this.f4061i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f4069q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z9) {
        this.f4067o = z9;
        if (z9) {
            return;
        }
        this.f4065m = System.currentTimeMillis();
    }

    public void setProgress(float f, boolean z9) {
        if (!z9 || f < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(c.a aVar) {
        this.f4068p = aVar;
    }

    public void setProgressState(int i10) {
        if (i10 == 5) {
            this.f4073v = 1;
            this.f4074w = 0;
            this.f4075x = 0;
            this.y = 0L;
            return;
        }
        if (i10 == 6) {
            this.f4074w = 1;
            if (this.f4075x == 1) {
                startEndAnimation();
            }
            this.y = 0L;
            return;
        }
        if (i10 == 7) {
            startEndAnimation();
        } else {
            if (i10 != 8) {
                return;
            }
            this.f4075x = 1;
            if (this.f4074w == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        c.a aVar = this.f4068p;
        if (i10 == 0) {
            if (aVar != null) {
                aVar.a(true);
            }
        } else if (aVar != null) {
            aVar.a(false);
        }
    }

    public void setVisible(boolean z9) {
        if (!z9) {
            setVisibility(4);
            return;
        }
        this.f4064l = true;
        this.f4065m = System.currentTimeMillis();
        this.f4060d = 0.0f;
        this.y = 0L;
        this.f4072u = false;
        this.f = 0.0f;
        this.f4058b = 0.0f;
        this.t = getMeasuredWidth();
        this.f4067o = false;
        this.f4073v = 0;
        this.f4074w = 0;
        this.f4075x = 0;
        Drawable drawable = this.f4061i;
        if (drawable != null) {
            this.f4062j = -drawable.getIntrinsicWidth();
        } else {
            this.f4062j = 0;
        }
        Drawable drawable2 = this.f4071s;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        Drawable drawable3 = this.e;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.f4069q;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    public void startEndAnimation() {
        if (this.f4072u) {
            return;
        }
        this.f4072u = true;
        this.f = 0.0f;
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4057a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.g = 25L;
        this.h = new Handler(Looper.getMainLooper());
        this.f4063k = false;
        this.f4066n = 0.95f;
        this.f4067o = false;
        this.f4070r = new Rect();
        setWillNotDraw(false);
    }
}
