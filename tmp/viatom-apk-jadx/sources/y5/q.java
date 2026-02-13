package y5;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d5.n f13969a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f13970b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13971c;

    /* JADX WARN: Illegal instructions before constructor call */
    public q(d5.n nVar, d0.i iVar) {
        iVar.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) nVar.f7240b;
        super(relativeLayout);
        this.f13969a = nVar;
        this.f13970b = iVar;
        this.f13971c = relativeLayout.getContext();
        ((UsernameTextView) nVar.f7244j).setTypeface(o4.b.f11719r);
        ((TextView) nVar.g).setTypeface(o4.b.f11720s);
        ((TextView) nVar.f).setTypeface(o4.b.f11720s);
        ((TextView) nVar.h).setTypeface(o4.b.f11719r);
    }
}
