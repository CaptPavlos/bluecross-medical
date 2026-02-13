package y5;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d5.j f14025a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14026b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.y f14027c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14028d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(d5.j jVar, Context context, g5.y yVar) {
        super((RelativeLayout) jVar.f7134b);
        context.getClass();
        this.f14025a = jVar;
        this.f14026b = context;
        this.f14027c = yVar;
        this.f14028d = true;
        final int i10 = 0;
        ((RelativeLayout) jVar.g).setOnClickListener(new View.OnClickListener(this) { // from class: y5.t0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u0 f14018b;

            {
                this.f14018b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i10) {
                    case 0:
                        u0 u0Var = this.f14018b;
                        g5.y yVar2 = u0Var.f14027c;
                        if (yVar2 != null && (bindingAdapterPosition = u0Var.getBindingAdapterPosition()) != -1) {
                            yVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        u0 u0Var2 = this.f14018b;
                        g5.y yVar3 = u0Var2.f14027c;
                        if (yVar3 != null && (bindingAdapterPosition2 = u0Var2.getBindingAdapterPosition()) != -1) {
                            yVar3.N(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        TextView textView = (TextView) jVar.f7135c;
        final int i11 = 1;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.t0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u0 f14018b;

            {
                this.f14018b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i11) {
                    case 0:
                        u0 u0Var = this.f14018b;
                        g5.y yVar2 = u0Var.f14027c;
                        if (yVar2 != null && (bindingAdapterPosition = u0Var.getBindingAdapterPosition()) != -1) {
                            yVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        u0 u0Var2 = this.f14018b;
                        g5.y yVar3 = u0Var2.f14027c;
                        if (yVar3 != null && (bindingAdapterPosition2 = u0Var2.getBindingAdapterPosition()) != -1) {
                            yVar3.N(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        ((TextView) jVar.e).setTypeface(o4.b.f11719r);
        textView.setTypeface(o4.b.f11719r);
        ((TextView) jVar.f7136d).setTypeface(o4.b.f11720s);
    }
}
