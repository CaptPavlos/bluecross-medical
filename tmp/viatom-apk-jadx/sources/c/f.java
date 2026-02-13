package c;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class f extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final b f953a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f954b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f955c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f956d;
    public final Integer e;
    public final Typeface f;
    public final TextView g;
    public final SwitchCompat h;

    /* renamed from: i, reason: collision with root package name */
    public final View f957i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View view, b bVar, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface) {
        super(view);
        bVar.getClass();
        this.f953a = bVar;
        this.f954b = num;
        this.f955c = num2;
        this.f956d = num3;
        this.e = num4;
        this.f = typeface;
        View viewFindViewById = view.findViewById(R.id.tv_switch_name);
        viewFindViewById.getClass();
        this.g = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.switch_item);
        viewFindViewById2.getClass();
        this.h = (SwitchCompat) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.line_item);
        viewFindViewById3.getClass();
        this.f957i = viewFindViewById3;
    }
}
