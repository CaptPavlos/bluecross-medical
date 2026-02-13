package y5;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d5.n f13941a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f13942b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13943c;

    /* JADX WARN: Illegal instructions before constructor call */
    public n(d5.n nVar, d0.i iVar) {
        iVar.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) nVar.f7240b;
        super(relativeLayout);
        this.f13941a = nVar;
        this.f13942b = iVar;
        this.f13943c = relativeLayout.getContext();
        ((UsernameTextView) nVar.f7244j).setTypeface(o4.b.f11719r);
        ((TextView) nVar.g).setTypeface(o4.b.f11720s);
        ((TextView) nVar.h).setTypeface(o4.b.f11720s);
    }

    public final void a(h5.v vVar, d5.n nVar) {
        ImageView imageView = (ImageView) nVar.e;
        ImageView imageView2 = (ImageView) nVar.f;
        ImageView imageView3 = (ImageView) nVar.f7243i;
        ImageView imageView4 = (ImageView) nVar.f7244j;
        int i10 = vVar.g;
        ImageView imageView5 = (ImageView) nVar.f7242d;
        Context context = this.f13943c;
        if (i10 == 1) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
            if (vVar.f8766m >= 1) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
            }
            if (vVar.f8766m >= 2) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
            }
            if (vVar.f8766m >= 3) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
            }
            if (vVar.f8766m >= 4) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
            }
            if (vVar.f8766m == 5) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
                return;
            }
            return;
        }
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        if (vVar.f8766m >= 1) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (vVar.f8766m >= 2) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (vVar.f8766m >= 3) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (vVar.f8766m >= 4) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (vVar.f8766m == 5) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
    }
}
