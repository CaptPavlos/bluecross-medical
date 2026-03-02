package q5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.f f12258a;

    /* renamed from: b, reason: collision with root package name */
    public u5.b f12259b;

    public b(g5.f fVar) {
        this.f12258a = fVar;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj != null) {
            h5.h hVar = (h5.h) obj;
            u5.b bVar = (u5.b) viewHolder;
            this.f12259b = bVar;
            Context context = viewHolder.view.getContext();
            context.getClass();
            TextView textView = bVar.f12913b;
            bVar.f12912a.setText(hVar.f8567b);
            String str = hVar.f;
            g5.f fVar = this.f12258a;
            if (str == null || str.length() == 0 || fVar == null) {
                textView.setText(hVar.f);
            } else {
                String str2 = hVar.f;
                str2.getClass();
                textView.setText(l5.C(str2, context, fVar));
            }
            String str3 = hVar.f8580o;
            if (str3 != null) {
                TextView textView2 = bVar.f12914c;
                if (fVar != null) {
                    textView2.setText(l5.C(str3, context, fVar));
                } else {
                    textView2.setText(l5.C(str3, context, new t3.h(5)));
                }
            }
            bVar.a(0);
            bVar.e.setText(hVar.f8568c);
            bVar.f.setText(hVar.f8578n);
            int i10 = hVar.f8582p;
            RelativeLayout relativeLayout = bVar.f12916i;
            if (i10 == 0) {
                relativeLayout.setVisibility(8);
                return;
            }
            TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_valoration_value_tv_app_detail);
            textView3.setTypeface(o4.b.f11720s);
            textView3.setText(String.valueOf(hVar.f8582p / 10.0d));
            TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_num_ratings);
            textView4.setTypeface(o4.b.f11720s);
            textView4.setText(String.valueOf(hVar.f8584q));
            View viewFindViewById = relativeLayout.findViewById(R.id.iv_star1);
            viewFindViewById.getClass();
            ImageView imageView = (ImageView) viewFindViewById;
            View viewFindViewById2 = relativeLayout.findViewById(R.id.iv_star2);
            viewFindViewById2.getClass();
            ImageView imageView2 = (ImageView) viewFindViewById2;
            View viewFindViewById3 = relativeLayout.findViewById(R.id.iv_star3);
            viewFindViewById3.getClass();
            ImageView imageView3 = (ImageView) viewFindViewById3;
            View viewFindViewById4 = relativeLayout.findViewById(R.id.iv_star4);
            viewFindViewById4.getClass();
            ImageView imageView4 = (ImageView) viewFindViewById4;
            View viewFindViewById5 = relativeLayout.findViewById(R.id.iv_star5);
            viewFindViewById5.getClass();
            ImageView imageView5 = (ImageView) viewFindViewById5;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            if (hVar.f8582p > 5) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (hVar.f8582p > 15) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (hVar.f8582p > 25) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (hVar.f8582p > 35) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (hVar.f8582p > 45) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_app_detail, viewGroup, false);
        viewG.getClass();
        return new u5.b(viewG);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
