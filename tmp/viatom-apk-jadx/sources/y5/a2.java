package y5;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a2 extends h {

    /* renamed from: b, reason: collision with root package name */
    public final d5.h1 f13804b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13805c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.x f13806d;

    /* JADX WARN: Illegal instructions before constructor call */
    public a2(d5.h1 h1Var, Context context, g5.x xVar) {
        context.getClass();
        RelativeLayout relativeLayout = h1Var.f7096a;
        relativeLayout.getClass();
        super(relativeLayout);
        this.f13804b = h1Var;
        this.f13805c = context;
        this.f13806d = xVar;
        RelativeLayout relativeLayout2 = h1Var.f7100i;
        final int i10 = 0;
        relativeLayout2.setOnClickListener(new View.OnClickListener(this) { // from class: y5.z1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a2 f14096b;

            {
                this.f14096b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                switch (i10) {
                    case 0:
                        a2 a2Var = this.f14096b;
                        g5.x xVar2 = a2Var.f13806d;
                        if (xVar2 != null && (bindingAdapterPosition = a2Var.getBindingAdapterPosition()) != -1) {
                            xVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        a2 a2Var2 = this.f14096b;
                        g5.x xVar3 = a2Var2.f13806d;
                        if (xVar3 != null) {
                            xVar3.j(a2Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        a2 a2Var3 = this.f14096b;
                        g5.x xVar4 = a2Var3.f13806d;
                        if (xVar4 != null) {
                            xVar4.I(a2Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        relativeLayout2.setOnLongClickListener(new j(this, i11));
        h1Var.g.setOnClickListener(new View.OnClickListener(this) { // from class: y5.z1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a2 f14096b;

            {
                this.f14096b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                switch (i11) {
                    case 0:
                        a2 a2Var = this.f14096b;
                        g5.x xVar2 = a2Var.f13806d;
                        if (xVar2 != null && (bindingAdapterPosition = a2Var.getBindingAdapterPosition()) != -1) {
                            xVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        a2 a2Var2 = this.f14096b;
                        g5.x xVar3 = a2Var2.f13806d;
                        if (xVar3 != null) {
                            xVar3.j(a2Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        a2 a2Var3 = this.f14096b;
                        g5.x xVar4 = a2Var3.f13806d;
                        if (xVar4 != null) {
                            xVar4.I(a2Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        h1Var.f7097b.setOnClickListener(new View.OnClickListener(this) { // from class: y5.z1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a2 f14096b;

            {
                this.f14096b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                switch (i12) {
                    case 0:
                        a2 a2Var = this.f14096b;
                        g5.x xVar2 = a2Var.f13806d;
                        if (xVar2 != null && (bindingAdapterPosition = a2Var.getBindingAdapterPosition()) != -1) {
                            xVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        a2 a2Var2 = this.f14096b;
                        g5.x xVar3 = a2Var2.f13806d;
                        if (xVar3 != null) {
                            xVar3.j(a2Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        a2 a2Var3 = this.f14096b;
                        g5.x xVar4 = a2Var3.f13806d;
                        if (xVar4 != null) {
                            xVar4.I(a2Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        h1Var.f7101j.setTypeface(o4.b.f11719r);
        h1Var.f7103l.setTypeface(o4.b.f11719r);
        h1Var.f7102k.setTypeface(o4.b.f11720s);
        h1Var.f7104m.setTypeface(o4.b.f11720s);
    }

    public final void c(String str) {
        d5.h1 h1Var = this.f13804b;
        a(h1Var.f, h1Var.f7099d);
        TextView textView = h1Var.f7101j;
        l5.E(textView);
        textView.setText(str);
        h1Var.h.setVisibility(8);
    }

    public final void d(h5.q qVar) {
        d5.h1 h1Var = this.f13804b;
        b(h1Var.f, h1Var.f7099d);
        TextView textView = h1Var.f7104m;
        textView.setVisibility(8);
        h1Var.f7102k.setText(this.itemView.getContext().getString(R.string.percent_of_total_size, Integer.valueOf(qVar.i()), l1.b.M(this.f13805c, qVar.k())));
        ProgressBar progressBar = h1Var.f;
        int i10 = qVar.i();
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i10);
        h1Var.h.setVisibility(0);
        h1Var.f7097b.setVisibility(0);
        textView.setVisibility(8);
        h1Var.f7101j.setVisibility(8);
    }

    public final void e() {
        d5.h1 h1Var = this.f13804b;
        b(h1Var.f, h1Var.f7099d);
        h1Var.f.setIndeterminate(true);
        TextView textView = h1Var.f7101j;
        Context context = this.f13805c;
        textView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_status_download_installed));
        textView.setTextColor(ContextCompat.getColor(context, R.color.download_installed_status));
        h1Var.h.setVisibility(0);
        h1Var.f7104m.setText(context.getString(R.string.installing));
    }
}
