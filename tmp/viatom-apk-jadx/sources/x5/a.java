package x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import j4.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13700a;

    public a(Context context) {
        this.f13700a = context;
    }

    @Override // j4.i0
    public final Bitmap a(Bitmap bitmap) {
        bitmap.getClass();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = height / 3;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
        bitmapCreateBitmap.getClass();
        if (bitmap.getConfig() != null) {
            Bitmap.Config config = bitmap.getConfig();
            config.getClass();
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f = height - i10;
        float f10 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f, 0.0f, f10, 0, ContextCompat.getColor(this.f13700a, R.color.background_color), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, f, width, f10, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    @Override // j4.i0
    public final String key() {
        return "bottomGradient";
    }
}
