package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends ShapeDrawable {

    /* renamed from: a, reason: collision with root package name */
    private int f5726a;

    /* renamed from: b, reason: collision with root package name */
    private float f5727b;

    /* renamed from: c, reason: collision with root package name */
    private float f5728c;

    /* renamed from: d, reason: collision with root package name */
    private int f5729d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f5730i;

    /* renamed from: j, reason: collision with root package name */
    private Matrix f5731j;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z9);

        b b(float f);

        b b(Bitmap bitmap);
    }

    private a(C0063a c0063a) {
        super(c0063a.f5732a);
        this.h = false;
        this.f = c0063a.f5733b;
        this.g = c0063a.f5734c;
        this.h = c0063a.f5735d;
        this.f5726a = c0063a.e;
        this.f5729d = c0063a.f;
        this.e = c0063a.g;
        this.f5727b = c0063a.h;
        this.f5728c = c0063a.f5736i;
        Paint paint = new Paint();
        this.f5730i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f5730i.setAntiAlias(true);
        this.f5731j = new Matrix();
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas == null || path == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float fMax = Math.max(this.f5727b / bitmap.getWidth(), this.f5728c / bitmap.getHeight());
            if (this.f5731j == null) {
                this.f5731j = new Matrix();
            }
            this.f5731j.reset();
            this.f5731j.preScale(fMax, fMax);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(this.f5731j);
        this.f5730i.setShader(bitmapShader);
        canvas.drawPath(path, this.f5730i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5726a == 1) {
            float f = this.f5728c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.f5729d + f) - this.e);
            path.lineTo(this.f5727b, (f - this.f5729d) - this.e);
            path.lineTo(this.f5727b, 0.0f);
            if (this.h) {
                try {
                    a(canvas, path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, this.f5729d + f + this.e);
            path2.lineTo(0.0f, this.f5728c);
            path2.lineTo(this.f5727b, this.f5728c);
            path2.lineTo(this.f5727b, (f - this.f5729d) + this.e);
            if (this.h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            Bitmap bitmap2 = this.g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.g);
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        float f10 = this.f5727b / 2.0f;
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.f5728c);
        path3.lineTo((f10 - this.f5729d) - this.e, this.f5728c);
        path3.lineTo((this.f5729d + f10) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path3);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
        Path path4 = new Path();
        path4.moveTo(this.f5729d + f10 + this.e, 0.0f);
        path4.lineTo(this.f5727b, 0.0f);
        path4.lineTo(this.f5727b, this.f5728c);
        path4.lineTo((f10 - this.f5729d) + this.e, this.f5728c);
        if (this.h) {
            try {
                a(canvas, path4);
                return;
            } catch (Exception e13) {
                e13.printStackTrace();
                return;
            }
        }
        Bitmap bitmap4 = this.g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.g);
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.video.dynview.g.a$a, reason: collision with other inner class name */
    public static class C0063a implements b {

        /* renamed from: a, reason: collision with root package name */
        private RectShape f5732a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f5733b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap f5734c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5735d;
        private int e;
        private int f;
        private int g;
        private float h;

        /* renamed from: i, reason: collision with root package name */
        private float f5736i;

        private C0063a() {
            this.f = 100;
            this.g = 10;
            this.f5732a = new RectShape();
        }

        public final a a() {
            return new a(this);
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(Bitmap bitmap) {
            this.f5734c = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(float f) {
            this.f5736i = f;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(Bitmap bitmap) {
            this.f5733b = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(boolean z9) {
            this.f5735d = z9;
            return this;
        }

        public final b a(int i10) {
            this.e = i10;
            return this;
        }

        public final b a(float f) {
            this.h = f;
            return this;
        }
    }

    private void a(Canvas canvas, Path path) {
        this.f5730i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f5730i);
    }

    public static C0063a a() {
        return new C0063a();
    }
}
