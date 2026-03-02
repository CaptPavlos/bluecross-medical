package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.b f14003a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14004b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14005c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14006d;
    public final TextView e;
    public final TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(View view, g5.b bVar, Context context) {
        super(view);
        context.getClass();
        this.f14003a = bVar;
        this.f14004b = context;
        View viewFindViewById = view.findViewById(R.id.iv_icon_positive);
        viewFindViewById.getClass();
        ImageView imageView = (ImageView) viewFindViewById;
        this.f14005c = imageView;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_app_positive);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f14006d = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_version_app_positive);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.e = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_count_positives);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.f = textView3;
        final int i10 = 0;
        view.setOnClickListener(new View.OnClickListener(this) { // from class: y5.r0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s0 f13984b;

            {
                this.f13984b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i10) {
                    case 0:
                        s0 s0Var = this.f13984b;
                        g5.b bVar2 = s0Var.f14003a;
                        if (bVar2 != null && (bindingAdapterPosition = s0Var.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        s0 s0Var2 = this.f13984b;
                        g5.b bVar3 = s0Var2.f14003a;
                        if (bVar3 != null && (bindingAdapterPosition2 = s0Var2.getBindingAdapterPosition()) != -1) {
                            bVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.r0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s0 f13984b;

            {
                this.f13984b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i11) {
                    case 0:
                        s0 s0Var = this.f13984b;
                        g5.b bVar2 = s0Var.f14003a;
                        if (bVar2 != null && (bindingAdapterPosition = s0Var.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        s0 s0Var2 = this.f13984b;
                        g5.b bVar3 = s0Var2.f14003a;
                        if (bVar3 != null && (bindingAdapterPosition2 = s0Var2.getBindingAdapterPosition()) != -1) {
                            bVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
    }
}
