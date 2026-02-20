package y5;

import android.view.View;
import com.uptodown.activities.MyDownloads;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13893a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f13894b;

    public /* synthetic */ j(h hVar, int i10) {
        this.f13893a = i10;
        this.f13894b = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int bindingAdapterPosition;
        MyDownloads myDownloads;
        n4.b bVar;
        boolean z9;
        int bindingAdapterPosition2;
        switch (this.f13893a) {
            case 0:
                k kVar = (k) this.f13894b;
                d0.i iVar = kVar.f13914b;
                if (iVar == null || (bindingAdapterPosition = kVar.getBindingAdapterPosition()) == -1 || (bVar = (myDownloads = (MyDownloads) iVar.f6781b).J) == null || (z9 = bVar.f11301c)) {
                    return false;
                }
                bVar.c(!z9);
                n4.b bVar2 = myDownloads.J;
                bVar2.getClass();
                bVar2.b(bindingAdapterPosition);
                myDownloads.t0();
                myDownloads.L = true;
                myDownloads.p0().e.smoothScrollToPosition(bindingAdapterPosition);
                return false;
            default:
                a2 a2Var = (a2) this.f13894b;
                g5.x xVar = a2Var.f13806d;
                if (xVar == null || (bindingAdapterPosition2 = a2Var.getBindingAdapterPosition()) == -1) {
                    return true;
                }
                view.getClass();
                xVar.b(view, bindingAdapterPosition2);
                return true;
        }
    }
}
