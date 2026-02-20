package c;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f938a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f939b;

    /* renamed from: c, reason: collision with root package name */
    public final Typeface f940c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f941d;
    public final View e;

    public a(View view, Integer num, Integer num2, Typeface typeface) {
        super(view);
        this.f938a = num;
        this.f939b = num2;
        this.f940c = typeface;
        View viewFindViewById = view.findViewById(R.id.tv_non_switch_label);
        viewFindViewById.getClass();
        this.f941d = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.item_divider);
        viewFindViewById2.getClass();
        this.e = viewFindViewById2;
    }
}
