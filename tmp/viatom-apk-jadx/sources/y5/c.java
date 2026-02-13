package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f13821b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f13822c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f13823d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final ProgressBar f13824i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13825j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f13826k;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(View view, g5.c cVar, g5.a aVar) {
        cVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f13821b = cVar;
        this.f13822c = aVar;
        View viewFindViewById = view.findViewById(R.id.rl_app_info_item);
        viewFindViewById.getClass();
        this.f13823d = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_logo_app_info_item);
        viewFindViewById2.getClass();
        this.e = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_name_app_info_item);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        this.f = textView;
        View viewFindViewById4 = view.findViewById(R.id.tv_desc_app_info_item);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        this.g = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_status_app_info_item);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.h = textView3;
        this.f13824i = (ProgressBar) view.findViewById(R.id.pb_progress_app_info_item);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_progress_app_info_item);
        this.f13825j = textView4;
        TextView textView5 = (TextView) view.findViewById(R.id.tv_verified_app_info_item);
        this.f13826k = (LinearLayout) view.findViewById(R.id.ll_progress_app_info_item);
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        if (textView4 != null) {
            textView4.setTypeface(o4.b.f11720s);
        }
        if (textView5 != null) {
            textView5.setTypeface(o4.b.f11720s);
        }
    }
}
