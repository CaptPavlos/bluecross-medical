package l4;

import android.app.AlertDialog;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m9 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f10634b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m9(Updates updates, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10633a = i10;
        this.f10634b = updates;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10633a) {
            case 0:
                return new m9(this.f10634b, cVar, 0);
            default:
                return new m9(this.f10634b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10633a) {
            case 0:
                m9 m9Var = (m9) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                m9Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                m9 m9Var2 = (m9) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                m9Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10633a;
        s6.w wVar = s6.w.f12711a;
        Updates updates = this.f10634b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                AlertDialog alertDialog = updates.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(updates);
                d5.j jVarE = d5.j.e(updates.getLayoutInflater());
                TextView textView = (TextView) jVarE.e;
                TextView textView2 = (TextView) jVarE.f7135c;
                TextView textView3 = (TextView) jVarE.f;
                ((TextView) jVarE.g).setTypeface(o4.b.f11719r);
                ((TextView) jVarE.f7136d).setTypeface(o4.b.f11720s);
                textView3.setTypeface(o4.b.f11719r);
                textView2.setTypeface(o4.b.f11719r);
                textView.setTypeface(o4.b.f11719r);
                int i11 = 0;
                textView3.setOnClickListener(new k9(uVar, updates, i11));
                textView2.setOnClickListener(new k9(uVar, updates, 1));
                textView.setOnClickListener(new k9(uVar, updates, 2));
                builder.setView((RelativeLayout) jVarE.f7134b);
                AlertDialog alertDialogCreate = builder.create();
                updates.f10935w = alertDialogCreate;
                alertDialogCreate.getClass();
                alertDialogCreate.setOnDismissListener(new l9(uVar, updates, i11));
                if (!updates.isFinishing() && updates.f10935w != null) {
                    updates.j0();
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                n4.w0 w0Var = updates.X;
                if (w0Var != null) {
                    Integer num = w0Var != null ? new Integer(w0Var.f11506i) : null;
                    num.getClass();
                    w0Var.notifyItemChanged(num.intValue());
                    break;
                }
                break;
        }
        return wVar;
    }
}
