package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14062a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f14063b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f14064c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14065d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(View view, Context context) {
        super(view);
        context.getClass();
        this.f14062a = context;
        View viewFindViewById = view.findViewById(R.id.iv_logo_app);
        viewFindViewById.getClass();
        this.f14063b = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_app_name);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f14064c = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_app_version);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f14065d = textView2;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
    }
}
