package b5;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f849a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f850b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f851c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f852d;
    public final TextView e;
    public final CheckBox f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view, x4 x4Var) {
        super(view);
        x4Var.getClass();
        this.f849a = x4Var;
        View viewFindViewById = view.findViewById(R.id.iv_icon_file_item);
        viewFindViewById.getClass();
        this.f850b = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_file_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f851c = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_date_file_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f852d = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_size_file_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.e = textView3;
        View viewFindViewById5 = view.findViewById(R.id.cb_checked_file_item);
        viewFindViewById5.getClass();
        this.f = (CheckBox) viewFindViewById5;
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
    }
}
