package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.widget.MBImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class RoundImageView extends MBImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f6599a;

    /* renamed from: b, reason: collision with root package name */
    private int f6600b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f6601c;

    /* renamed from: d, reason: collision with root package name */
    private int f6602d;
    private Matrix e;
    private BitmapShader f;
    private int g;
    private RectF h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.e = new Matrix();
        Paint paint = new Paint();
        this.f6601c = paint;
        paint.setAntiAlias(true);
        this.f6600b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f6599a = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            af.b("View", th.getMessage());
            return null;
        }
    }

    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        try {
            if (getDrawable() == null) {
                return;
            }
            try {
                Drawable drawable = getDrawable();
                if (drawable != null && (bitmapA = a(drawable)) != null && !bitmapA.isRecycled()) {
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    this.f = new BitmapShader(bitmapA, tileMode, tileMode);
                    int i10 = this.f6599a;
                    float fMax = 1.0f;
                    if (i10 == 0) {
                        fMax = (this.g * 1.0f) / Math.min(bitmapA.getWidth(), bitmapA.getHeight());
                    } else if (i10 == 1) {
                        fMax = Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
                    }
                    this.e.setScale(fMax, fMax);
                    this.f.setLocalMatrix(this.e);
                    this.f6601c.setShader(this.f);
                }
            } catch (Throwable th) {
                af.b("RoundImageView", th.getMessage());
            }
            if (this.f6599a != 1) {
                int i11 = this.f6602d;
                canvas.drawCircle(i11, i11, i11, this.f6601c);
            } else {
                RectF rectF = this.h;
                int i12 = this.f6600b;
                canvas.drawRoundRect(rectF, i12, i12, this.f6601c);
            }
        } catch (Throwable th2) {
            af.b("RoundImageView", th2.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f6599a == 0) {
            int iMin = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.g = iMin;
            this.f6602d = iMin / 2;
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
        this.f6599a = bundle.getInt("state_type");
        this.f6600b = bundle.getInt("state_border_radius");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f6599a);
        bundle.putInt("state_border_radius", this.f6600b);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f6599a == 1) {
            this.h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i10) {
        int iA = ak.a(getContext(), i10);
        if (this.f6600b != iA) {
            this.f6600b = iA;
            invalidate();
        }
    }

    public void setType(int i10) {
        if (this.f6599a != i10) {
            this.f6599a = i10;
            if (i10 != 1 && i10 != 0) {
                this.f6599a = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Matrix();
        Paint paint = new Paint();
        this.f6601c = paint;
        paint.setAntiAlias(true);
        this.f6600b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f6599a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.e = new Matrix();
        Paint paint = new Paint();
        this.f6601c = paint;
        paint.setAntiAlias(true);
        this.f6600b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f6599a = 1;
    }
}
