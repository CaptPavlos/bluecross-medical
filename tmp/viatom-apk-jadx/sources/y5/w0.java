package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14052a;

    /* renamed from: b, reason: collision with root package name */
    public final n5 f14053b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14054c;

    /* renamed from: d, reason: collision with root package name */
    public final UsernameTextView f14055d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    public final LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f14056i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f14057j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f14058k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f14059l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(View view, Context context, n5 n5Var) {
        super(view);
        context.getClass();
        n5Var.getClass();
        this.f14052a = context;
        this.f14053b = n5Var;
        View viewFindViewById = view.findViewById(R.id.iv_avatar_review);
        viewFindViewById.getClass();
        this.f14054c = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_username_review);
        viewFindViewById2.getClass();
        UsernameTextView usernameTextView = (UsernameTextView) viewFindViewById2;
        this.f14055d = usernameTextView;
        View viewFindViewById3 = view.findViewById(R.id.iv_author_verified_review);
        viewFindViewById3.getClass();
        this.e = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_date_review);
        viewFindViewById4.getClass();
        TextView textView = (TextView) viewFindViewById4;
        this.f = textView;
        View viewFindViewById5 = view.findViewById(R.id.tv_body_review);
        viewFindViewById5.getClass();
        TextView textView2 = (TextView) viewFindViewById5;
        this.g = textView2;
        View viewFindViewById6 = view.findViewById(R.id.ll_likes_review);
        viewFindViewById6.getClass();
        this.h = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.iv_likes_counter_review);
        viewFindViewById7.getClass();
        this.f14056i = (ImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.tv_likes_counter_review);
        viewFindViewById8.getClass();
        TextView textView3 = (TextView) viewFindViewById8;
        this.f14057j = textView3;
        View viewFindViewById9 = view.findViewById(R.id.iv_turbo_mark_review);
        viewFindViewById9.getClass();
        ImageView imageView = (ImageView) viewFindViewById9;
        this.f14058k = imageView;
        View viewFindViewById10 = view.findViewById(R.id.iv_follow_user_review);
        viewFindViewById10.getClass();
        this.f14059l = (ImageView) viewFindViewById10;
        usernameTextView.setTypeface(o4.b.f11719r);
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        imageView.setVisibility(8);
    }
}
