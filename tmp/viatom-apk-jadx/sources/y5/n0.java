package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.NotificationsRegistryActivity;
import l4.e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final d0.i f13944a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13945b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13946c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13947d;
    public final TextView e;
    public final TextView f;
    public final Context g;

    public n0(View view, d0.i iVar) {
        super(view);
        this.f13944a = iVar;
        View viewFindViewById = view.findViewById(R.id.tv_title);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13945b = textView;
        View viewFindViewById2 = view.findViewById(R.id.tv_msg);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.f13946c = textView2;
        View viewFindViewById3 = view.findViewById(R.id.tv_action_01);
        viewFindViewById3.getClass();
        TextView textView3 = (TextView) viewFindViewById3;
        this.f13947d = textView3;
        View viewFindViewById4 = view.findViewById(R.id.tv_action_02);
        viewFindViewById4.getClass();
        TextView textView4 = (TextView) viewFindViewById4;
        this.e = textView4;
        View viewFindViewById5 = view.findViewById(R.id.tv_date);
        viewFindViewById5.getClass();
        TextView textView5 = (TextView) viewFindViewById5;
        this.f = textView5;
        View viewFindViewById6 = view.findViewById(R.id.iv_delete_notification);
        viewFindViewById6.getClass();
        Context context = view.getContext();
        context.getClass();
        this.g = context;
        final int i10 = 0;
        textView3.setOnClickListener(new View.OnClickListener(this) { // from class: y5.m0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f13940b;

            {
                this.f13940b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                n4.q qVar;
                int i11 = i10;
                n0 n0Var = this.f13940b;
                switch (i11) {
                    case 0:
                        d0.i iVar2 = n0Var.f13944a;
                        if (iVar2 != null && (bindingAdapterPosition = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar2.f6781b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        d0.i iVar3 = n0Var.f13944a;
                        if (iVar3 != null && (bindingAdapterPosition2 = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar3.f6781b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        d0.i iVar4 = n0Var.f13944a;
                        if (iVar4 != null && (bindingAdapterPosition3 = n0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) iVar4.f6781b).K) != null && qVar.f11460a.size() > bindingAdapterPosition3) {
                            e5 e5VarQ0 = notificationsRegistryActivity.q0();
                            n4.q qVar2 = notificationsRegistryActivity.K;
                            qVar2.getClass();
                            int i12 = ((h5.b0) qVar2.f11460a.get(bindingAdapterPosition3)).f8472a;
                            e5VarQ0.getClass();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new a6.t(i12, notificationsRegistryActivity, null), 2);
                            n4.q qVar3 = notificationsRegistryActivity.K;
                            qVar3.getClass();
                            qVar3.f11460a.remove(bindingAdapterPosition3);
                            n4.q qVar4 = notificationsRegistryActivity.K;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        textView4.setOnClickListener(new View.OnClickListener(this) { // from class: y5.m0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f13940b;

            {
                this.f13940b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                n4.q qVar;
                int i112 = i11;
                n0 n0Var = this.f13940b;
                switch (i112) {
                    case 0:
                        d0.i iVar2 = n0Var.f13944a;
                        if (iVar2 != null && (bindingAdapterPosition = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar2.f6781b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        d0.i iVar3 = n0Var.f13944a;
                        if (iVar3 != null && (bindingAdapterPosition2 = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar3.f6781b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        d0.i iVar4 = n0Var.f13944a;
                        if (iVar4 != null && (bindingAdapterPosition3 = n0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) iVar4.f6781b).K) != null && qVar.f11460a.size() > bindingAdapterPosition3) {
                            e5 e5VarQ0 = notificationsRegistryActivity.q0();
                            n4.q qVar2 = notificationsRegistryActivity.K;
                            qVar2.getClass();
                            int i12 = ((h5.b0) qVar2.f11460a.get(bindingAdapterPosition3)).f8472a;
                            e5VarQ0.getClass();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new a6.t(i12, notificationsRegistryActivity, null), 2);
                            n4.q qVar3 = notificationsRegistryActivity.K;
                            qVar3.getClass();
                            qVar3.f11460a.remove(bindingAdapterPosition3);
                            n4.q qVar4 = notificationsRegistryActivity.K;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        ((ImageView) viewFindViewById6).setOnClickListener(new View.OnClickListener(this) { // from class: y5.m0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f13940b;

            {
                this.f13940b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                n4.q qVar;
                int i112 = i12;
                n0 n0Var = this.f13940b;
                switch (i112) {
                    case 0:
                        d0.i iVar2 = n0Var.f13944a;
                        if (iVar2 != null && (bindingAdapterPosition = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar2.f6781b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        d0.i iVar3 = n0Var.f13944a;
                        if (iVar3 != null && (bindingAdapterPosition2 = n0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.n0((NotificationsRegistryActivity) iVar3.f6781b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        d0.i iVar4 = n0Var.f13944a;
                        if (iVar4 != null && (bindingAdapterPosition3 = n0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) iVar4.f6781b).K) != null && qVar.f11460a.size() > bindingAdapterPosition3) {
                            e5 e5VarQ0 = notificationsRegistryActivity.q0();
                            n4.q qVar2 = notificationsRegistryActivity.K;
                            qVar2.getClass();
                            int i122 = ((h5.b0) qVar2.f11460a.get(bindingAdapterPosition3)).f8472a;
                            e5VarQ0.getClass();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new a6.t(i122, notificationsRegistryActivity, null), 2);
                            n4.q qVar3 = notificationsRegistryActivity.K;
                            qVar3.getClass();
                            qVar3.f11460a.remove(bindingAdapterPosition3);
                            n4.q qVar4 = notificationsRegistryActivity.K;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
        textView4.setTypeface(o4.b.f11719r);
    }

    public final String a(String str) {
        int iHashCode = str.hashCode();
        Context context = this.g;
        switch (iHashCode) {
            case -1569440520:
                if (!str.equals("positive_apps")) {
                    return "";
                }
                String string = context.getString(R.string.title_positive_apps);
                string.getClass();
                return string;
            case -1335458389:
                if (!str.equals("delete")) {
                    return "";
                }
                String string2 = context.getString(R.string.option_button_delete);
                string2.getClass();
                return string2;
            case -504325460:
                if (!str.equals("open_app")) {
                    return "";
                }
                String string3 = context.getString(R.string.open);
                string3.getClass();
                return string3;
            case -234430262:
                if (!str.equals("updates")) {
                    return "";
                }
                String string4 = context.getString(R.string.updates);
                string4.getClass();
                return string4;
            case 212443764:
                str.equals("no_action");
                return "";
            case 1085191854:
                if (!str.equals("update_uptodown")) {
                    return "";
                }
                String string5 = context.getString(R.string.action_update);
                string5.getClass();
                return string5;
            case 1117687366:
                if (!str.equals("preregister")) {
                    return "";
                }
                String string6 = context.getString(R.string.action_app_details_settings);
                string6.getClass();
                return string6;
            case 1312704747:
                if (!str.equals("downloads")) {
                    return "";
                }
                String string7 = context.getString(R.string.downloads_title);
                string7.getClass();
                return string7;
            case 1957569947:
                if (!str.equals("install")) {
                    return "";
                }
                String string8 = context.getString(R.string.option_button_install);
                string8.getClass();
                return string8;
            default:
                return "";
        }
    }
}
