package l4;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.SearchActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t5 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10844a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10845b;

    public /* synthetic */ t5(w wVar, int i10) {
        this.f10844a = i10;
        this.f10845b = wVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f10844a) {
            case 0:
            case 1:
                break;
            default:
                SearchActivity searchActivity = (SearchActivity) this.f10845b;
                String strValueOf = String.valueOf(editable);
                int i10 = SearchActivity.Q;
                String strB0 = o7.u.b0(strValueOf, "/", "", false);
                int length = strB0.length();
                if (2 > length || length >= 40) {
                    r7.o1 o1Var = searchActivity.J;
                    if (o1Var != null) {
                        o1Var.a(null);
                    }
                    n4.l0 l0Var = searchActivity.K;
                    if (l0Var != null) {
                        l0Var.f11426a = new ArrayList();
                        l0Var.notifyDataSetChanged();
                    }
                } else {
                    searchActivity.q0(2, strB0);
                }
                if (String.valueOf(editable).length() <= 0) {
                    n4.l0 l0Var2 = searchActivity.K;
                    if (l0Var2 != null) {
                        l0Var2.f11426a = new ArrayList();
                        l0Var2.notifyDataSetChanged();
                    }
                    ((ImageView) searchActivity.o0().f7377b.f13464d).setVisibility(8);
                    ((ImageView) searchActivity.o0().f7377b.e).setVisibility(0);
                    break;
                } else {
                    ((ImageView) searchActivity.o0().f7377b.f13464d).setVisibility(0);
                    ((ImageView) searchActivity.o0().f7377b.e).setVisibility(8);
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f10844a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f10844a;
        w wVar = this.f10845b;
        switch (i13) {
            case 0:
                if (charSequence != null) {
                    PasswordEditActivity.n0((PasswordEditActivity) wVar, charSequence.toString());
                    break;
                }
                break;
            case 1:
                if (charSequence != null) {
                    PasswordEditActivity passwordEditActivity = (PasswordEditActivity) wVar;
                    int i14 = PasswordEditActivity.J;
                    PasswordEditActivity.n0(passwordEditActivity, passwordEditActivity.o0().f7090c.getText().toString());
                    break;
                }
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(CharSequence charSequence, int i10, int i11, int i12) {
    }

    private final void d(CharSequence charSequence, int i10, int i11, int i12) {
    }

    private final void e(CharSequence charSequence, int i10, int i11, int i12) {
    }

    private final void f(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
