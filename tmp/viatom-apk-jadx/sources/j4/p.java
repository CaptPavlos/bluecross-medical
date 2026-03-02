package j4;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import l4.x0;
import l4.y0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends b {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(y yVar, Object obj, c0 c0Var, String str, int i10) {
        super(yVar, obj, c0Var, str);
        this.h = i10;
    }

    @Override // j4.b
    public final void b(Bitmap bitmap, int i10) {
        switch (this.h) {
            case 0:
                return;
            default:
                if (bitmap == null) {
                    throw new AssertionError("Attempted to complete action with no result!\n" + this);
                }
                x0 x0Var = (x0) d();
                if (x0Var != null) {
                    if (i10 == 0) {
                        throw null;
                    }
                    y0 y0Var = x0Var.f10977a;
                    ((SubsamplingScaleImageView) y0Var.f11012a.f182c).setImage(ImageSource.bitmap(bitmap));
                    ((ProgressBar) y0Var.f11012a.f183d).setVisibility(8);
                    if (bitmap.isRecycled()) {
                        androidx.window.layout.c.g("Target callback must not recycle bitmap!");
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // j4.b
    public final void c(Exception exc) {
        switch (this.h) {
            case 0:
                break;
            default:
                x0 x0Var = (x0) d();
                if (x0Var != null) {
                    exc.getClass();
                    ((ProgressBar) x0Var.f10977a.f11012a.f183d).setVisibility(8);
                    break;
                }
                break;
        }
    }

    private final void f(Exception exc) {
    }

    private final void e(Bitmap bitmap, int i10) {
    }
}
