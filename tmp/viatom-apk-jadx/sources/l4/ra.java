package l4;

import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.activities.UserCommentsActivity;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ra implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserCommentsActivity f10801a;

    public ra(UserCommentsActivity userCommentsActivity) {
        this.f10801a = userCommentsActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        UserCommentsActivity userCommentsActivity = this.f10801a;
        if (z9) {
            int i10 = UserCommentsActivity.L;
            userCommentsActivity.n0().f6955b.setVisibility(0);
        } else {
            if (mVar instanceof v5.l) {
                va vaVar = (va) ((v5.l) mVar).f13168a;
                h5.e1 e1Var = vaVar.f10927a;
                ArrayList arrayList = vaVar.f10928b;
                h5.e1 e1Var2 = vaVar.f10927a;
                if (e1Var == null || !vaVar.f10929c) {
                    int i11 = UserCommentsActivity.L;
                    userCommentsActivity.n0().e.setTypeface(o4.b.f11720s);
                    userCommentsActivity.n0().e.setVisibility(0);
                } else {
                    h5.e1 e1VarH = h5.c1.h(userCommentsActivity);
                    if (kotlin.jvm.internal.l.a(e1VarH != null ? e1VarH.f8512a : null, e1Var2.f8512a)) {
                        int i12 = UserCommentsActivity.L;
                        userCommentsActivity.n0().f.setText(userCommentsActivity.getString(R.string.public_profile_my_reviews));
                    } else {
                        int i13 = UserCommentsActivity.L;
                        TextView textView = userCommentsActivity.n0().f;
                        String string = userCommentsActivity.getString(R.string.user_reviews);
                        string.getClass();
                        textView.setText(String.format(string, Arrays.copyOf(new Object[]{e1Var2.f8515d}, 1)));
                    }
                    if (!arrayList.isEmpty()) {
                        n4.a1 a1Var = userCommentsActivity.J;
                        if (a1Var == null) {
                            userCommentsActivity.J = new n4.a1(arrayList, userCommentsActivity.K);
                            userCommentsActivity.n0().f6956c.setAdapter(userCommentsActivity.J);
                        } else {
                            a1Var.f11296a.addAll(arrayList);
                            a1Var.notifyDataSetChanged();
                        }
                    }
                    n4.a1 a1Var2 = userCommentsActivity.J;
                    if (a1Var2 != null) {
                        a1Var2.f11298c = false;
                        a1Var2.notifyItemRemoved(a1Var2.getItemCount());
                    }
                }
                userCommentsActivity.n0().f6955b.setVisibility(8);
            } else if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}
