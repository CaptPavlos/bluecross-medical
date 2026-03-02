package y5;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final a3.z0 f14022a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f14023b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f14024c;

    /* JADX WARN: Illegal instructions before constructor call */
    public u(a3.z0 z0Var, d0.i iVar) {
        iVar.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) z0Var.f;
        super(relativeLayout);
        this.f14022a = z0Var;
        this.f14023b = iVar;
        this.f14024c = relativeLayout.getContext();
        ((UsernameTextView) z0Var.e).setTypeface(o4.b.f11719r);
        ((TextView) z0Var.f198d).setTypeface(o4.b.f11719r);
    }
}
