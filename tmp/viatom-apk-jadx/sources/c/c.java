package c;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f942a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f943b;

    /* renamed from: c, reason: collision with root package name */
    public final Typeface f944c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f945d;

    public c(View view, Integer num, Integer num2, Typeface typeface) {
        super(view);
        this.f942a = num;
        this.f943b = num2;
        this.f944c = typeface;
        View viewFindViewById = view.findViewById(R.id.tv_switch_description);
        viewFindViewById.getClass();
        this.f945d = (TextView) viewFindViewById;
    }
}
