package l4;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gallery f11054a;

    public z0(Gallery gallery) {
        this.f11054a = gallery;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f11054a.I;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        String strO;
        y0 y0Var = (y0) viewHolder;
        y0Var.getClass();
        ArrayList arrayList = this.f11054a.I;
        arrayList.getClass();
        Object obj = arrayList.get(i10);
        obj.getClass();
        h5.u0 u0Var = (h5.u0) obj;
        a3.x xVar = y0Var.f11012a;
        ((ProgressBar) xVar.f183d).setVisibility(0);
        x0 x0Var = new x0(y0Var);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) xVar.f182c;
        subsamplingScaleImageView.setTag(x0Var);
        j4.y yVarD = j4.y.d();
        if (u0Var.f8754a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(u0Var.f8754a);
            strO = a3.a.o(sb, UptodownApp.L, ":webp");
        } else {
            strO = null;
        }
        j4.d0 d0VarE = yVarD.e(strO);
        j4.y yVar = d0VarE.f9929a;
        d0VarE.f(R.drawable.shape_bg_placeholder);
        long jNanoTime = System.nanoTime();
        StringBuilder sb2 = j4.l0.f9987a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.window.layout.c.g("Method call should happen from the main thread.");
            return;
        }
        if (d0VarE.f9931c) {
            androidx.window.layout.c.g("Fit cannot be used with a Target.");
            return;
        }
        j4.c0 c0Var = d0VarE.f9930b;
        if (((Uri) c0Var.f9925b) == null && c0Var.f9926c == 0) {
            yVar.a(x0Var);
            d0VarE.d();
        } else {
            j4.c0 c0VarA = d0VarE.a(jNanoTime);
            StringBuilder sb3 = j4.l0.f9987a;
            String strA = j4.l0.a(c0VarA, sb3);
            sb3.setLength(0);
            Bitmap bitmapG = yVar.g(strA);
            if (bitmapG != null) {
                yVar.a(x0Var);
                ((SubsamplingScaleImageView) xVar.f182c).setImage(ImageSource.bitmap(bitmapG));
                ((ProgressBar) xVar.f183d).setVisibility(8);
            } else {
                d0VarE.d();
                yVar.c(new j4.p(yVar, x0Var, c0VarA, strA, 1));
            }
        }
        subsamplingScaleImageView.setOnClickListener(new w0(y0Var.f11013b.f11054a, 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.gallery_item, viewGroup, false);
        int i11 = R.id.iv_imagen;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(viewG, R.id.iv_imagen);
        if (subsamplingScaleImageView != null) {
            i11 = R.id.pb_gallery_item;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewG, R.id.pb_gallery_item);
            if (progressBar != null) {
                return new y0(this, new a3.x((RelativeLayout) viewG, subsamplingScaleImageView, progressBar, 16));
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewG.getResources().getResourceName(i11)));
        return null;
    }
}
