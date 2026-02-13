package y5;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d5.d1 f14076a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.r f14077b;

    /* JADX WARN: Illegal instructions before constructor call */
    public y1(d5.d1 d1Var, i0.k kVar) {
        RelativeLayout relativeLayout = d1Var.f6983b;
        super(relativeLayout);
        this.f14076a = d1Var;
        this.f14077b = kVar;
        final int i10 = 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: y5.x1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y1 f14070b;

            {
                this.f14070b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i10) {
                    case 0:
                        y1 y1Var = this.f14070b;
                        g5.r rVar = y1Var.f14077b;
                        if (rVar != null && (bindingAdapterPosition = y1Var.getBindingAdapterPosition()) != -1) {
                            rVar.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        y1 y1Var2 = this.f14070b;
                        g5.r rVar2 = y1Var2.f14077b;
                        if (rVar2 != null && (bindingAdapterPosition2 = y1Var2.getBindingAdapterPosition()) != -1) {
                            rVar2.a(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        d1Var.f6985d.setOnClickListener(new View.OnClickListener(this) { // from class: y5.x1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y1 f14070b;

            {
                this.f14070b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i11) {
                    case 0:
                        y1 y1Var = this.f14070b;
                        g5.r rVar = y1Var.f14077b;
                        if (rVar != null && (bindingAdapterPosition = y1Var.getBindingAdapterPosition()) != -1) {
                            rVar.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        y1 y1Var2 = this.f14070b;
                        g5.r rVar2 = y1Var2.f14077b;
                        if (rVar2 != null && (bindingAdapterPosition2 = y1Var2.getBindingAdapterPosition()) != -1) {
                            rVar2.a(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        d1Var.f.setTypeface(o4.b.f11719r);
        d1Var.e.setTypeface(o4.b.f11720s);
    }
}
