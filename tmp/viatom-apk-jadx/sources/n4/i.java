package n4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f11370a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11371b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f11372c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f11373d;
    public final TextView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(View view, g5.j jVar, g5.a aVar) {
        super(view);
        aVar.getClass();
        this.f11370a = jVar;
        this.f11371b = aVar;
        this.f11372c = (ImageView) view.findViewById(R.id.iv_feature_home);
        TextView textView = (TextView) view.findViewById(R.id.tv_tag_feature_home);
        this.f11373d = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_name_feature_home);
        this.e = textView2;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11719r);
    }
}
