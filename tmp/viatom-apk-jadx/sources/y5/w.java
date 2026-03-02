package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends h {

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f14049b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f14050c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f14051d;
    public final TextView e;
    public final TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(View view, g5.b bVar, Context context) {
        super(view);
        context.getClass();
        this.f14049b = bVar;
        this.f14050c = context;
        View viewFindViewById = view.findViewById(R.id.iv_icon_free_up_item);
        viewFindViewById.getClass();
        this.f14051d = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_free_up_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.e = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_size_free_up_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_action_free_up_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.rl_container_free_up_item);
        viewFindViewById5.getClass();
        final int i10 = 0;
        ((RelativeLayout) viewFindViewById5).setOnClickListener(new View.OnClickListener(this) { // from class: y5.v

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w f14043b;

            {
                this.f14043b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i10) {
                    case 0:
                        w wVar = this.f14043b;
                        g5.b bVar2 = wVar.f14049b;
                        if (bVar2 != null && (bindingAdapterPosition = wVar.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        w wVar2 = this.f14043b;
                        g5.b bVar3 = wVar2.f14049b;
                        if (bVar3 != null) {
                            bVar3.a(wVar2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        textView3.setOnClickListener(new View.OnClickListener(this) { // from class: y5.v

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w f14043b;

            {
                this.f14043b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i11) {
                    case 0:
                        w wVar = this.f14043b;
                        g5.b bVar2 = wVar.f14049b;
                        if (bVar2 != null && (bindingAdapterPosition = wVar.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        w wVar2 = this.f14043b;
                        g5.b bVar3 = wVar2.f14049b;
                        if (bVar3 != null) {
                            bVar3.a(wVar2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
    }
}
