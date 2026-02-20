package y5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f13861a;

    public f1(View view, String str) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.tv_system_apps_title);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13861a = textView;
        textView.setTypeface(o4.b.f11719r);
        textView.setText(str);
    }

    public final void a() {
        this.f13861a.setVisibility(0);
    }
}
