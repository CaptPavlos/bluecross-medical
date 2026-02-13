package l9;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f11134a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f11135b;

    public k(View view, Typeface typeface) {
        super(view);
        this.f11134a = typeface;
        View viewFindViewById = view.findViewById(R.id.tv_publisher_link_name);
        viewFindViewById.getClass();
        this.f11135b = (TextView) viewFindViewById;
    }
}
