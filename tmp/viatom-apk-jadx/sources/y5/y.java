package y5;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14071a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14072b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14073c;

    public /* synthetic */ y(int i10, Object obj, Object obj2) {
        this.f14071a = i10;
        this.f14072b = obj;
        this.f14073c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int childAdapterPosition;
        switch (this.f14071a) {
            case 0:
                a0 a0Var = (a0) this.f14072b;
                g5.m mVar = (g5.m) this.f14073c;
                x5.b bVar = a0Var.f;
                n4.j jVar = a0Var.f13801d;
                RecyclerView recyclerView = a0Var.f13800c;
                View viewFindSnapView = bVar.findSnapView(recyclerView.getLayoutManager());
                if (viewFindSnapView != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(viewFindSnapView) % jVar.f11383c.size()) != -1) {
                    Object obj = jVar.f11383c.get(childAdapterPosition);
                    obj.getClass();
                    h5.h hVar = (h5.h) obj;
                    if (hVar.m() && !a0Var.g) {
                        mVar.f(hVar);
                        a0Var.g = true;
                        break;
                    }
                }
                break;
            default:
                ((z5.d) this.f14072b).b((l4.w) this.f14073c);
                break;
        }
    }
}
