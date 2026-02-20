package x5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import e5.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends f4.a {

    /* renamed from: a, reason: collision with root package name */
    public final View f13701a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13702b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f13703c;

    public c(View view, e4.e eVar) {
        eVar.getClass();
        this.f13701a = view;
        View viewFindViewById = view.findViewById(R.id.v_player_panel_home);
        viewFindViewById.getClass();
        View viewFindViewById2 = view.findViewById(R.id.iv_player_panel_feature);
        viewFindViewById2.getClass();
        ImageView imageView = (ImageView) viewFindViewById2;
        this.f13702b = imageView;
        View viewFindViewById3 = view.findViewById(R.id.iv_player_control);
        viewFindViewById3.getClass();
        this.f13703c = (ImageView) viewFindViewById3;
        ((i4.g) eVar).a(new h4.f());
        imageView.setOnClickListener(new s(eVar, 28));
        viewFindViewById.setOnClickListener(new s(eVar, 28));
    }

    @Override // f4.a
    public final void d(e4.e eVar, e4.d dVar) {
        eVar.getClass();
        ImageView imageView = this.f13703c;
        e4.d dVar2 = e4.d.f7658d;
        ImageView imageView2 = this.f13702b;
        if (dVar == dVar2) {
            imageView2.setVisibility(8);
            imageView.setVisibility(8);
            return;
        }
        imageView2.setVisibility(0);
        float f = UptodownApp.E;
        Context context = this.f13701a.getContext();
        context.getClass();
        if (k4.c.e(context)) {
            return;
        }
        imageView.setVisibility(0);
    }
}
