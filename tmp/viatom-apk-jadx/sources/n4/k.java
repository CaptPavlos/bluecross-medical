package n4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f11400b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f11401c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f11402d;
    public final ImageView e;
    public final ProgressBar f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f11403i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f11404j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f11405k;

    /* JADX WARN: Illegal instructions before constructor call */
    public k(View view, g5.c cVar, g5.a aVar) {
        cVar.getClass();
        aVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f11400b = cVar;
        this.f11401c = aVar;
        this.f11402d = (ImageView) view.findViewById(R.id.iv_home_card_featured_item);
        this.e = (ImageView) view.findViewById(R.id.iv_logo_home_card_featured_item);
        View viewFindViewById = view.findViewById(R.id.pb_progress_home_card_featured_item);
        viewFindViewById.getClass();
        this.f = (ProgressBar) viewFindViewById;
        TextView textView = (TextView) view.findViewById(R.id.tv_name_home_card_featured_item);
        this.g = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc_home_card_featured_item);
        this.h = textView2;
        this.f11403i = (TextView) view.findViewById(R.id.tv_status_home_card_featured_item);
        View viewFindViewById2 = view.findViewById(R.id.tv_progress_home_card_featured_item);
        viewFindViewById2.getClass();
        TextView textView3 = (TextView) viewFindViewById2;
        this.f11404j = textView3;
        View viewFindViewById3 = view.findViewById(R.id.tv_verified_home_card_featured_item);
        viewFindViewById3.getClass();
        View viewFindViewById4 = view.findViewById(R.id.ll_progress_home_card_featured_item);
        viewFindViewById4.getClass();
        this.f11405k = (LinearLayout) viewFindViewById4;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById3).setTypeface(o4.b.f11720s);
    }
}
