package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s1 extends RecyclerView.ViewHolder {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f14007j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final x4 f14008a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f14009b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14010c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14011d;
    public final TextView e;
    public final RelativeLayout f;
    public final ImageView g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public long f14012i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(View view, x4 x4Var) {
        super(view);
        x4Var.getClass();
        this.f14008a = x4Var;
        View viewFindViewById = view.findViewById(R.id.ll_uptodown_protect);
        viewFindViewById.getClass();
        this.f14009b = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_uptodown_protect);
        viewFindViewById2.getClass();
        View viewFindViewById3 = view.findViewById(R.id.iv_shield);
        viewFindViewById3.getClass();
        this.f14010c = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_title);
        viewFindViewById4.getClass();
        TextView textView = (TextView) viewFindViewById4;
        this.f14011d = textView;
        View viewFindViewById5 = view.findViewById(R.id.tv_msg);
        viewFindViewById5.getClass();
        TextView textView2 = (TextView) viewFindViewById5;
        this.e = textView2;
        View viewFindViewById6 = view.findViewById(R.id.rl_reload);
        viewFindViewById6.getClass();
        this.f = (RelativeLayout) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.iv_reload);
        viewFindViewById7.getClass();
        this.g = (ImageView) viewFindViewById7;
        this.h = 600;
        ((TextView) viewFindViewById2).setTypeface(o4.b.f11719r);
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
    }
}
