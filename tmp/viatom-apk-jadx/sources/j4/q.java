package j4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends b {
    public g h;

    @Override // j4.b
    public final void a() {
        this.g = true;
        if (this.h != null) {
            this.h = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j4.b
    public final void b(Bitmap bitmap, int i10) {
        if (bitmap == null) {
            throw new AssertionError("Attempted to complete action with no result!\n" + this);
        }
        ImageView imageView = (ImageView) this.f9919c.get();
        if (imageView == null) {
            return;
        }
        Context context = this.f9917a.f10013b;
        int i11 = z.e;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new z(context, bitmap, drawable, i10));
        g gVar = this.h;
        if (gVar != null) {
            gVar.onSuccess();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j4.b
    public final void c(Exception exc) {
        ImageView imageView = (ImageView) this.f9919c.get();
        if (imageView == null) {
            return;
        }
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.p(exc);
        }
    }
}
