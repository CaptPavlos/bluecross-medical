package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public g5.c f11520a;

    /* renamed from: b, reason: collision with root package name */
    public Context f11521b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11522c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11522c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y yVar = (y) viewHolder;
        yVar.getClass();
        Object obj = this.f11522c.get(i10);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        View view = yVar.itemView;
        view.getClass();
        y5.f.b(view, yVar.f11515c, hVar);
        c2.d dVar = yVar.f11514b;
        TextView textView = (TextView) dVar.f;
        TextView textView2 = (TextView) dVar.f1643d;
        y5.f.f(hVar, textView, textView2);
        yVar.d(hVar.f8595w, (TextView) dVar.g, textView2);
        yVar.e((ImageView) dVar.f1642c, hVar.h());
        ((TextView) dVar.h).setText(String.valueOf(hVar.f8582p / 10.0d));
        ((TextView) dVar.e).setText(yVar.f11516d.f11521b.getString(R.string.downloads_counter_multiple, l1.b.G(hVar.f8570i)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.organization_top_item_card, viewGroup, false);
        int i11 = R.id.iv_top_app_logo_organization;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_top_app_logo_organization);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) viewG;
            i11 = R.id.tv_top_app_desc_organization;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_top_app_desc_organization);
            if (textView != null) {
                i11 = R.id.tv_top_app_downloads_counter_organization;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_top_app_downloads_counter_organization);
                if (textView2 != null) {
                    i11 = R.id.tv_top_app_name_organization;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_top_app_name_organization);
                    if (textView3 != null) {
                        i11 = R.id.tv_top_app_status_organization;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_top_app_status_organization);
                        if (textView4 != null) {
                            i11 = R.id.tv_top_app_valoration_organization;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_top_app_valoration_organization);
                            if (textView5 != null) {
                                return new y(this, new c2.d(relativeLayout, imageView, textView, textView2, textView3, textView4, textView5, 5), this.f11520a, this.f11521b);
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewG.getResources().getResourceName(i11)));
        return null;
    }
}
