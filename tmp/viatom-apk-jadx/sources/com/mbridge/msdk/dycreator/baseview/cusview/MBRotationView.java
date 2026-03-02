package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBRotationView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Runnable f3034a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f3035b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f3036c;

    /* renamed from: d, reason: collision with root package name */
    private int f3037d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f3038i;

    /* renamed from: j, reason: collision with root package name */
    private int f3039j;

    /* renamed from: k, reason: collision with root package name */
    private int f3040k;

    /* renamed from: l, reason: collision with root package name */
    private float f3041l;

    /* renamed from: m, reason: collision with root package name */
    private float f3042m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3043n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3044o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3045p;

    public MBRotationView(Context context) {
        super(context);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.f3038i = 0;
        this.f3040k = 0;
        this.f3041l = 0.5f;
        this.f3042m = 0.9f;
        this.f3043n = true;
        this.f3044o = false;
        this.f3045p = false;
        this.f3034a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    private void a(Canvas canvas, int i10, int i11, int i12) {
        canvas.save();
        this.f3035b.save();
        this.f3036c.reset();
        float f = i10;
        this.f3035b.translate(0.0f, f, 0.0f);
        this.f3035b.rotateX(this.h);
        this.f3035b.translate(0.0f, f, 0.0f);
        if (i10 == 0) {
            boolean z9 = this.f3045p;
            int i13 = this.f3037d;
            if (z9) {
                a(i13, this.f, i12);
            } else {
                a(-i13, -this.f, i12);
            }
        } else if (i10 > 0) {
            a(this.f3037d, this.f, i12);
        } else if (i10 < 0) {
            a(-this.f3037d, -this.f, i12);
        }
        this.f3035b.getMatrix(this.f3036c);
        this.f3035b.restore();
        this.f3036c.preTranslate((-getWidth()) / 2, -i11);
        this.f3036c.postTranslate(getWidth() / 2, i11);
        canvas.concat(this.f3036c);
        View childAt = getChildAt(a(i12));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private void b(Canvas canvas, int i10, int i11, int i12) {
        canvas.save();
        this.f3035b.save();
        this.f3036c.reset();
        float f = i10;
        this.f3035b.translate(f, 0.0f, 0.0f);
        this.f3035b.rotateY(this.h);
        this.f3035b.translate(f, 0.0f, 0.0f);
        if (i10 == 0) {
            boolean z9 = this.f3045p;
            int i13 = this.e;
            if (z9) {
                b(i13, this.f, i12);
            } else {
                b(-i13, -this.f, i12);
            }
        } else if (i10 > 0) {
            b(this.e, this.f, i12);
        } else if (i10 < 0) {
            b(-this.e, -this.f, i12);
        }
        this.f3035b.getMatrix(this.f3036c);
        this.f3035b.restore();
        this.f3036c.preTranslate(-i11, (-getHeight()) / 2);
        this.f3036c.postTranslate(i11, getHeight() / 2);
        canvas.concat(this.f3036c);
        View childAt = getChildAt(a(i12));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f3044o) {
            int height = getHeight() / 2;
            int i10 = ((this.h * this.f3037d) / 2) / this.f;
            a(canvas, i10, height, 0);
            a(canvas, i10, height, 1);
            if (Math.abs(this.h) > this.f / 2) {
                a(canvas, i10, height, 3);
                a(canvas, i10, height, 2);
                return;
            } else {
                a(canvas, i10, height, 2);
                a(canvas, i10, height, 3);
                return;
            }
        }
        int width = getWidth() / 2;
        int i11 = ((this.h * this.e) / 2) / this.f;
        b(canvas, i11, width, 0);
        b(canvas, i11, width, 1);
        if (Math.abs(this.h) > this.f / 2) {
            b(canvas, i11, width, 3);
            b(canvas, i11, width, 2);
        } else {
            b(canvas, i11, width, 2);
            b(canvas, i11, width, 3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        float f = i14;
        float f10 = this.f3041l;
        int i15 = (int) (((1.0f - f10) * f) / 2.0f);
        int i16 = i13 - i11;
        float f11 = i16;
        float f12 = this.f3042m;
        int i17 = (int) (((1.0f - f12) * f11) / 2.0f);
        this.f3037d = (int) (f11 * f12);
        this.e = (int) (f * f10);
        int childCount = getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            childAt.layout(i15, i17, i14 - i15, i16 - i17);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i19 = layoutParams.width;
            int i20 = this.e;
            if (i19 != i20) {
                layoutParams.width = i20;
                layoutParams.height = this.f3037d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z9) {
        if (z9) {
            postDelayed(this.f3034a, 1000 / this.g);
        }
        this.f3043n = z9;
    }

    public void setHeightRatio(float f) {
        this.f3042m = f;
    }

    public void setRotateV(boolean z9) {
        this.f3044o = z9;
        invalidate();
    }

    public void setWidthRatio(float f) {
        this.f3041l = f;
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.f3038i = 0;
        this.f3040k = 0;
        this.f3041l = 0.5f;
        this.f3042m = 0.9f;
        this.f3043n = true;
        this.f3044o = false;
        this.f3045p = false;
        this.f3034a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.f3038i = 0;
        this.f3040k = 0;
        this.f3041l = 0.5f;
        this.f3042m = 0.9f;
        this.f3043n = true;
        this.f3044o = false;
        this.f3045p = false;
        this.f3034a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    private void a(int i10, int i11, int i12) {
        float f = (-i10) / 2.0f;
        if (i12 == 0) {
            this.f3035b.translate(0.0f, f, 0.0f);
            float f10 = -i11;
            this.f3035b.rotateX(f10);
            this.f3035b.translate(0.0f, f, 0.0f);
            this.f3035b.translate(0.0f, f, 0.0f);
            this.f3035b.rotateX(f10);
            this.f3035b.translate(0.0f, f, 0.0f);
            return;
        }
        if (i12 == 1) {
            this.f3035b.translate(0.0f, f, 0.0f);
            this.f3035b.rotateX(i11);
            this.f3035b.translate(0.0f, f, 0.0f);
        } else if (i12 != 2) {
            if (i12 != 3) {
                return;
            }
            this.f3035b.rotateX(0.0f);
        } else {
            this.f3035b.translate(0.0f, f, 0.0f);
            this.f3035b.rotateX(-i11);
            this.f3035b.translate(0.0f, f, 0.0f);
        }
    }

    private void b(int i10, int i11, int i12) {
        if (i12 == 0) {
            float f = (-i10) / 2;
            this.f3035b.translate(f, 0.0f, 0.0f);
            float f10 = -i11;
            this.f3035b.rotateY(f10);
            this.f3035b.translate(f, 0.0f, 0.0f);
            this.f3035b.translate(f, 0.0f, 0.0f);
            this.f3035b.rotateY(f10);
            this.f3035b.translate(f, 0.0f, 0.0f);
            return;
        }
        if (i12 == 1) {
            float f11 = i10 / 2;
            this.f3035b.translate(f11, 0.0f, 0.0f);
            this.f3035b.rotateY(i11);
            this.f3035b.translate(f11, 0.0f, 0.0f);
            return;
        }
        if (i12 != 2) {
            if (i12 != 3) {
                return;
            }
            this.f3035b.rotateY(0.0f);
        } else {
            float f12 = (-i10) / 2;
            this.f3035b.translate(f12, 0.0f, 0.0f);
            this.f3035b.rotateY(-i11);
            this.f3035b.translate(f12, 0.0f, 0.0f);
        }
    }

    private void a() {
        this.f3035b = new Camera();
        this.f3036c = new Matrix();
        setWillNotDraw(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016 A[PHI: r0
      0x0016: PHI (r0v6 int) = (r0v4 int), (r0v7 int) binds: [B:16:0x0020, B:12:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[PHI: r0
      0x0019: PHI (r0v5 int) = (r0v4 int), (r0v7 int) binds: [B:16:0x0020, B:12:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(int r3) {
        /*
            r2 = this;
            r0 = 2
            if (r3 == 0) goto L23
            r1 = 1
            if (r3 == r1) goto L1c
            if (r3 == r0) goto L10
            r0 = 3
            if (r3 == r0) goto Ld
            r3 = 0
            goto L2e
        Ld:
            int r3 = r2.f3038i
            goto L2e
        L10:
            boolean r3 = r2.f3045p
            int r0 = r2.f3038i
            if (r3 == 0) goto L19
        L16:
            int r3 = r0 + (-1)
            goto L2e
        L19:
            int r3 = r0 + 1
            goto L2e
        L1c:
            boolean r3 = r2.f3045p
            int r0 = r2.f3038i
            if (r3 == 0) goto L16
            goto L19
        L23:
            boolean r3 = r2.f3045p
            int r1 = r2.f3038i
            if (r3 == 0) goto L2c
            int r3 = r1 + (-2)
            goto L2e
        L2c:
            int r3 = r1 + 2
        L2e:
            int r0 = r2.getChildCount()
            int r3 = r3 % r0
            if (r3 < 0) goto L36
            return r3
        L36:
            int r0 = r2.getChildCount()
            int r0 = r0 + r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.a(int):int");
    }

    public static /* synthetic */ void a(MBRotationView mBRotationView) {
        int iA;
        if (mBRotationView.getChildCount() == 0) {
            return;
        }
        int i10 = mBRotationView.h - 1;
        mBRotationView.h = i10;
        int i11 = mBRotationView.f3038i;
        mBRotationView.f3039j = i11;
        int i12 = mBRotationView.f;
        int i13 = i11 - (i10 / i12);
        int i14 = i10 % i12;
        mBRotationView.h = i14;
        mBRotationView.f3038i = i13;
        if (Math.abs(i14) > mBRotationView.f / 2) {
            iA = mBRotationView.a(2);
        } else {
            iA = mBRotationView.a(3);
        }
        if (mBRotationView.f3040k != iA) {
            mBRotationView.f3040k = iA;
        }
        mBRotationView.invalidate();
        if (mBRotationView.f3043n) {
            mBRotationView.postDelayed(mBRotationView.f3034a, 1000 / mBRotationView.g);
        }
    }
}
