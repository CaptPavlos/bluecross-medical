package u5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f12925a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12926b;

    public e(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.iv_icon);
        viewFindViewById.getClass();
        this.f12925a = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_name);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f12926b = textView;
        textView.setTypeface(o4.b.f11719r);
    }
}
