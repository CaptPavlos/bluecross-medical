package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Xfermode f3067a;

    /* renamed from: b, reason: collision with root package name */
    private int f3068b;

    /* renamed from: c, reason: collision with root package name */
    private int f3069c;

    /* renamed from: d, reason: collision with root package name */
    private int f3070d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f3071i;

    /* renamed from: j, reason: collision with root package name */
    private int f3072j;

    /* renamed from: k, reason: collision with root package name */
    private float[] f3073k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f3074l;

    /* renamed from: m, reason: collision with root package name */
    private RectF f3075m;

    /* renamed from: n, reason: collision with root package name */
    private RectF f3076n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3077o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3078p;

    /* renamed from: q, reason: collision with root package name */
    private Path f3079q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f3080r;

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3079q = new Path();
        this.f3080r = new Paint();
        this.f3073k = new float[8];
        this.f3074l = new float[8];
        this.f3076n = new RectF();
        this.f3075m = new RectF();
        this.f3067a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f3075m, null, 31);
            int i10 = this.f3068b;
            int i11 = this.f3071i;
            int i12 = this.f3069c;
            canvas.scale(((i10 - (i11 * 2)) * 1.0f) / i10, ((i12 - (i11 * 2)) * 1.0f) / i12, i10 / 2.0f, i12 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f3080r;
            if (paint != null) {
                paint.reset();
                this.f3080r.setAntiAlias(true);
                this.f3080r.setStyle(Paint.Style.FILL);
                this.f3080r.setXfermode(this.f3067a);
            }
            Path path = this.f3079q;
            if (path != null) {
                path.reset();
                this.f3079q.addRoundRect(this.f3075m, this.f3074l, Path.Direction.CCW);
            }
            canvas.drawPath(this.f3079q, this.f3080r);
            Paint paint2 = this.f3080r;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f3077o) {
                int i13 = this.f3071i;
                int i14 = this.f3072j;
                RectF rectF = this.f3076n;
                float[] fArr = this.f3073k;
                try {
                    Path path2 = this.f3079q;
                    if (path2 != null) {
                        path2.reset();
                    }
                    Paint paint3 = this.f3080r;
                    if (paint3 != null) {
                        paint3.setStrokeWidth(i13);
                        this.f3080r.setColor(i14);
                        this.f3080r.setStyle(Paint.Style.STROKE);
                    }
                    Path path3 = this.f3079q;
                    if (path3 != null) {
                        path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                    }
                    canvas.drawPath(this.f3079q, this.f3080r);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            af.a("MBridgeImageView", e3.getMessage());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        super.onSizeChanged(i10, i11, i12, i13);
        this.f3068b = i10;
        this.f3069c = i11;
        boolean z9 = this.f3078p;
        float[] fArr = this.f3073k;
        int i17 = 0;
        if (z9) {
            if (fArr != null) {
                try {
                    if (this.f3074l != null) {
                        while (true) {
                            i14 = 2;
                            if (i17 >= 2) {
                                break;
                            }
                            float[] fArr2 = this.f3073k;
                            int i18 = this.e;
                            fArr2[i17] = i18;
                            this.f3074l[i17] = i18 - (this.f3071i / 2.0f);
                            i17++;
                        }
                        while (true) {
                            i15 = 4;
                            if (i14 >= 4) {
                                break;
                            }
                            float[] fArr3 = this.f3073k;
                            int i19 = this.f;
                            fArr3[i14] = i19;
                            this.f3074l[i14] = i19 - (this.f3071i / 2.0f);
                            i14++;
                        }
                        while (true) {
                            if (i15 >= 6) {
                                break;
                            }
                            float[] fArr4 = this.f3073k;
                            int i20 = this.g;
                            fArr4[i15] = i20;
                            this.f3074l[i15] = i20 - (this.f3071i / 2.0f);
                            i15++;
                        }
                        for (i16 = 6; i16 < 8; i16++) {
                            float[] fArr5 = this.f3073k;
                            int i21 = this.h;
                            fArr5[i16] = i21;
                            this.f3074l[i16] = i21 - (this.f3071i / 2.0f);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (fArr != null && this.f3074l != null) {
            while (true) {
                try {
                    float[] fArr6 = this.f3073k;
                    if (i17 >= fArr6.length) {
                        break;
                    }
                    int i22 = this.f3070d;
                    fArr6[i17] = i22;
                    this.f3074l[i17] = i22 - (this.f3071i / 2.0f);
                    i17++;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        RectF rectF = this.f3076n;
        if (rectF != null) {
            int i23 = this.f3071i;
            rectF.set(i23 / 2.0f, i23 / 2.0f, this.f3068b - (i23 / 2.0f), this.f3069c - (i23 / 2.0f));
        }
        RectF rectF2 = this.f3075m;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, this.f3068b, this.f3069c);
        }
    }

    public void setBorder(int i10, int i11, int i12) {
        this.f3077o = true;
        this.f3071i = i11;
        this.f3072j = i12;
        this.f3070d = i10;
    }

    public void setCornerRadius(int i10) {
        this.f3070d = i10;
    }

    public void setCustomBorder(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f3077o = true;
        this.f3078p = true;
        this.f3071i = i14;
        this.f3072j = i15;
        this.e = i10;
        this.g = i12;
        this.f = i11;
        this.h = i13;
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context) {
        this(context, null);
    }
}
