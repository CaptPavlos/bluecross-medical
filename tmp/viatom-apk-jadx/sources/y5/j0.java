package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.j f13895b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f13896c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f13897d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f13898i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13899j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f13900k;

    /* renamed from: l, reason: collision with root package name */
    public String f13901l;

    /* JADX WARN: Illegal instructions before constructor call */
    public j0(View view, g5.j jVar, g5.a aVar) {
        jVar.getClass();
        aVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f13895b = jVar;
        this.f13896c = aVar;
        View viewFindViewById = view.findViewById(R.id.pb_progress_gallery_featured_item);
        viewFindViewById.getClass();
        this.f13897d = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_logo_gallery_featured_item);
        viewFindViewById2.getClass();
        this.e = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.iv_feature_gallery_featured_item);
        viewFindViewById3.getClass();
        this.f = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_name_gallery_featured_item);
        viewFindViewById4.getClass();
        TextView textView = (TextView) viewFindViewById4;
        this.g = textView;
        View viewFindViewById5 = view.findViewById(R.id.tv_desc_gallery_featured_item);
        viewFindViewById5.getClass();
        TextView textView2 = (TextView) viewFindViewById5;
        this.h = textView2;
        View viewFindViewById6 = view.findViewById(R.id.tv_status_gallery_featured_item);
        viewFindViewById6.getClass();
        TextView textView3 = (TextView) viewFindViewById6;
        this.f13898i = textView3;
        View viewFindViewById7 = view.findViewById(R.id.tv_progress_gallery_featured_item);
        viewFindViewById7.getClass();
        TextView textView4 = (TextView) viewFindViewById7;
        this.f13899j = textView4;
        View viewFindViewById8 = view.findViewById(R.id.tv_verified_gallery_featured_item);
        viewFindViewById8.getClass();
        View viewFindViewById9 = view.findViewById(R.id.ll_progress_gallery_featured_item);
        viewFindViewById9.getClass();
        this.f13900k = (LinearLayout) viewFindViewById9;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById8).setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
    }
}
