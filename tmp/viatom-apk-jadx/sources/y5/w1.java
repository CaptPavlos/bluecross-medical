package y5;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d5.d1 f14060a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f14061b;

    /* JADX WARN: Illegal instructions before constructor call */
    public w1(d5.d1 d1Var, g5.b bVar) {
        bVar.getClass();
        RelativeLayout relativeLayout = d1Var.f6983b;
        super(relativeLayout);
        this.f14060a = d1Var;
        this.f14061b = bVar;
        final int i10 = 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: y5.v1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w1 f14048b;

            {
                this.f14048b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        w1 w1Var = this.f14048b;
                        int bindingAdapterPosition = w1Var.getBindingAdapterPosition();
                        if (bindingAdapterPosition != -1) {
                            w1Var.f14061b.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        w1 w1Var2 = this.f14048b;
                        int bindingAdapterPosition2 = w1Var2.getBindingAdapterPosition();
                        if (bindingAdapterPosition2 != -1) {
                            w1Var2.f14061b.a(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        d1Var.f6984c.setOnClickListener(new View.OnClickListener(this) { // from class: y5.v1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w1 f14048b;

            {
                this.f14048b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case 0:
                        w1 w1Var = this.f14048b;
                        int bindingAdapterPosition = w1Var.getBindingAdapterPosition();
                        if (bindingAdapterPosition != -1) {
                            w1Var.f14061b.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        w1 w1Var2 = this.f14048b;
                        int bindingAdapterPosition2 = w1Var2.getBindingAdapterPosition();
                        if (bindingAdapterPosition2 != -1) {
                            w1Var2.f14061b.a(bindingAdapterPosition2);
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
