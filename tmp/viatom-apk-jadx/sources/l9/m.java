package l9;

import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final e6.c f11140a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11141b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f11142c;

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f11143d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final View f11144i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(View view, e6.c cVar, Integer num, Integer num2, Typeface typeface) {
        super(view);
        cVar.getClass();
        this.f11140a = cVar;
        this.f11141b = num;
        this.f11142c = num2;
        this.f11143d = typeface;
        View viewFindViewById = view.findViewById(R.id.cl_item_container);
        viewFindViewById.getClass();
        this.e = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_stack_more_info);
        viewFindViewById2.getClass();
        this.f = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_stack_selected_state);
        viewFindViewById3.getClass();
        this.g = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_stack_name);
        viewFindViewById4.getClass();
        this.h = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.line_item);
        viewFindViewById5.getClass();
        this.f11144i = viewFindViewById5;
    }
}
