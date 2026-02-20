package j4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends BitmapDrawable {
    public static final /* synthetic */ int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f10016a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10017b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10018c;

    /* renamed from: d, reason: collision with root package name */
    public int f10019d;

    static {
        new Paint();
    }

    public z(Context context, Bitmap bitmap, Drawable drawable, int i10) {
        super(context.getResources(), bitmap);
        this.f10019d = 255;
        float f = context.getResources().getDisplayMetrics().density;
        if (i10 != 1) {
            this.f10016a = drawable;
            this.f10018c = true;
            this.f10017b = SystemClock.uptimeMillis();
        }
    }

    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!this.f10018c) {
            super.draw(canvas);
            return;
        }
        float fUptimeMillis = (SystemClock.uptimeMillis() - this.f10017b) / 200.0f;
        if (fUptimeMillis >= 1.0f) {
            this.f10018c = false;
            this.f10016a = null;
            super.draw(canvas);
        } else {
            Drawable drawable = this.f10016a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            super.setAlpha((int) (this.f10019d * fUptimeMillis));
            super.draw(canvas);
            super.setAlpha(this.f10019d);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10016a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f10019d = i10;
        Drawable drawable = this.f10016a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        super.setAlpha(i10);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10016a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
