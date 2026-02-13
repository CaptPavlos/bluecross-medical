package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.k f13933a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13934b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f13935c;

    public l0(View view, String str, g5.k kVar) {
        super(view);
        this.f13933a = kVar;
        View viewFindViewById = view.findViewById(R.id.tv_myappsupdates_title);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13934b = textView;
        this.f13935c = (ImageView) view.findViewById(R.id.iv_myappsupdates_info);
        textView.setTypeface(o4.b.f11719r);
        textView.setText(str);
    }
}
