package q5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public Context f12266a;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    @Override // androidx.leanback.widget.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.leanback.widget.Presenter.ViewHolder r17, java.lang.Object r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.i.onBindViewHolder(androidx.leanback.widget.Presenter$ViewHolder, java.lang.Object):void");
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_home_card_featured_item, viewGroup, false);
        viewG.getClass();
        Context context = this.f12266a;
        context.getClass();
        u5.c cVar = new u5.c(viewG);
        cVar.f12917a = context;
        View viewFindViewById = viewG.findViewById(R.id.iv_home_card_featured_item);
        viewFindViewById.getClass();
        cVar.f12918b = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewG.findViewById(R.id.iv_logo_home_card_featured_item);
        viewFindViewById2.getClass();
        cVar.f12919c = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewG.findViewById(R.id.tv_name_home_card_featured_item);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        cVar.f12920d = textView;
        View viewFindViewById4 = viewG.findViewById(R.id.tv_desc_home_card_featured_item);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        cVar.e = textView2;
        View viewFindViewById5 = viewG.findViewById(R.id.tv_status_home_card_featured_item);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        cVar.f = textView3;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        return cVar;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
        if (viewHolder instanceof u5.c) {
            u5.c cVar = (u5.c) viewHolder;
            cVar.f12918b.setImageDrawable(null);
            cVar.f12919c.setImageDrawable(null);
            cVar.f12920d.setText((CharSequence) null);
            cVar.e.setText((CharSequence) null);
            cVar.f.setText((CharSequence) null);
        }
    }
}
