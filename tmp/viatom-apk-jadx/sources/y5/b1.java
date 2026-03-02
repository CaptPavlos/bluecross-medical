package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RollbackActivity;
import l4.z3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.o f13815a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13816b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13817c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13818d;
    public final ImageView e;

    public b1(View view, g5.o oVar) {
        super(view);
        this.f13815a = oVar;
        View viewFindViewById = view.findViewById(R.id.tv_name_rollback_item);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13816b = textView;
        View viewFindViewById2 = view.findViewById(R.id.tv_version_rollback_item);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.f13817c = textView2;
        View viewFindViewById3 = view.findViewById(R.id.tv_size_rollback_item);
        viewFindViewById3.getClass();
        TextView textView3 = (TextView) viewFindViewById3;
        this.f13818d = textView3;
        View viewFindViewById4 = view.findViewById(R.id.iv_icon_rollback_item);
        viewFindViewById4.getClass();
        ImageView imageView = (ImageView) viewFindViewById4;
        this.e = imageView;
        final int i10 = 0;
        view.setOnClickListener(new View.OnClickListener(this) { // from class: y5.a1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b1 f13803b;

            {
                this.f13803b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                n4.j0 j0Var;
                int bindingAdapterPosition2;
                n4.j0 j0Var2;
                int i11 = i10;
                b1 b1Var = this.f13803b;
                switch (i11) {
                    case 0:
                        g5.o oVar2 = b1Var.f13815a;
                        if (oVar2 != null && (bindingAdapterPosition = b1Var.getBindingAdapterPosition()) != -1) {
                            RollbackActivity rollbackActivity = (RollbackActivity) oVar2;
                            rollbackActivity.getClass();
                            float f = UptodownApp.E;
                            if (k4.c.s() && (j0Var = rollbackActivity.W) != null && bindingAdapterPosition < j0Var.f11384a.size()) {
                                n4.j0 j0Var3 = rollbackActivity.W;
                                j0Var3.getClass();
                                if (((h5.f) j0Var3.f11384a.get(bindingAdapterPosition)).f8541w != 0) {
                                    n4.j0 j0Var4 = rollbackActivity.W;
                                    j0Var4.getClass();
                                    Object obj = j0Var4.f11384a.get(bindingAdapterPosition);
                                    obj.getClass();
                                    h5.f fVar = (h5.f) obj;
                                    new c1.l(rollbackActivity, fVar.f8541w, new z3(rollbackActivity, fVar), LifecycleOwnerKt.getLifecycleScope(rollbackActivity));
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        g5.o oVar3 = b1Var.f13815a;
                        if (oVar3 != null && (bindingAdapterPosition2 = b1Var.getBindingAdapterPosition()) != -1) {
                            RollbackActivity rollbackActivity2 = (RollbackActivity) oVar3;
                            rollbackActivity2.getClass();
                            float f10 = UptodownApp.E;
                            if (k4.c.s() && (j0Var2 = rollbackActivity2.W) != null && bindingAdapterPosition2 < j0Var2.f11384a.size()) {
                                n4.j0 j0Var5 = rollbackActivity2.W;
                                j0Var5.getClass();
                                if (((h5.f) j0Var5.f11384a.get(bindingAdapterPosition2)).f8541w != 0) {
                                    n4.j0 j0Var6 = rollbackActivity2.W;
                                    j0Var6.getClass();
                                    rollbackActivity2.Y(((h5.f) j0Var6.f11384a.get(bindingAdapterPosition2)).f8541w);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.a1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b1 f13803b;

            {
                this.f13803b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                n4.j0 j0Var;
                int bindingAdapterPosition2;
                n4.j0 j0Var2;
                int i112 = i11;
                b1 b1Var = this.f13803b;
                switch (i112) {
                    case 0:
                        g5.o oVar2 = b1Var.f13815a;
                        if (oVar2 != null && (bindingAdapterPosition = b1Var.getBindingAdapterPosition()) != -1) {
                            RollbackActivity rollbackActivity = (RollbackActivity) oVar2;
                            rollbackActivity.getClass();
                            float f = UptodownApp.E;
                            if (k4.c.s() && (j0Var = rollbackActivity.W) != null && bindingAdapterPosition < j0Var.f11384a.size()) {
                                n4.j0 j0Var3 = rollbackActivity.W;
                                j0Var3.getClass();
                                if (((h5.f) j0Var3.f11384a.get(bindingAdapterPosition)).f8541w != 0) {
                                    n4.j0 j0Var4 = rollbackActivity.W;
                                    j0Var4.getClass();
                                    Object obj = j0Var4.f11384a.get(bindingAdapterPosition);
                                    obj.getClass();
                                    h5.f fVar = (h5.f) obj;
                                    new c1.l(rollbackActivity, fVar.f8541w, new z3(rollbackActivity, fVar), LifecycleOwnerKt.getLifecycleScope(rollbackActivity));
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        g5.o oVar3 = b1Var.f13815a;
                        if (oVar3 != null && (bindingAdapterPosition2 = b1Var.getBindingAdapterPosition()) != -1) {
                            RollbackActivity rollbackActivity2 = (RollbackActivity) oVar3;
                            rollbackActivity2.getClass();
                            float f10 = UptodownApp.E;
                            if (k4.c.s() && (j0Var2 = rollbackActivity2.W) != null && bindingAdapterPosition2 < j0Var2.f11384a.size()) {
                                n4.j0 j0Var5 = rollbackActivity2.W;
                                j0Var5.getClass();
                                if (((h5.f) j0Var5.f11384a.get(bindingAdapterPosition2)).f8541w != 0) {
                                    n4.j0 j0Var6 = rollbackActivity2.W;
                                    j0Var6.getClass();
                                    rollbackActivity2.Y(((h5.f) j0Var6.f11384a.get(bindingAdapterPosition2)).f8541w);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
    }
}
