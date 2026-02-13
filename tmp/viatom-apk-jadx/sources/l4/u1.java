package l4;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.uptodown.R;
import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u1 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10868a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f10869b;

    public /* synthetic */ u1(LoginActivity loginActivity, int i10) {
        this.f10868a = i10;
        this.f10869b = loginActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10 = this.f10868a;
        s6.w wVar = s6.w.f12711a;
        LoginActivity loginActivity = this.f10869b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!(mVar instanceof v5.j)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!(mVar instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        if (h5.c1.g(loginActivity)) {
                            String str = ((c2) ((v5.l) mVar).f13168a).f10280b;
                            if (str != null) {
                                loginActivity.C(str);
                            }
                            loginActivity.u0();
                            loginActivity.setResult(1);
                        } else {
                            String str2 = ((c2) ((v5.l) mVar).f13168a).f10281c;
                            if (str2 != null) {
                                loginActivity.C(str2);
                            } else {
                                String string = loginActivity.getString(R.string.login_error_message);
                                string.getClass();
                                loginActivity.C(string);
                            }
                        }
                        int i11 = LoginActivity.P;
                        loginActivity.v0().f7401b.setVisibility(8);
                        if (h5.c1.g(loginActivity) && ((c2) ((v5.l) mVar).f13168a).f10280b == null) {
                            loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        }
                    }
                } else {
                    int i12 = LoginActivity.P;
                    loginActivity.v0().f7401b.setVisibility(0);
                }
                break;
            default:
                v5.m mVar2 = (v5.m) obj;
                if (!(mVar2 instanceof v5.j)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!(mVar2 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        d2 d2Var = (d2) ((v5.l) mVar2).f13168a;
                        int i13 = d2Var.f10316a;
                        String str3 = d2Var.f10318c;
                        String str4 = d2Var.f10317b;
                        if (i13 == 1) {
                            if (str4 != null && str4.length() != 0) {
                                loginActivity.C(str4);
                            }
                            int i14 = LoginActivity.P;
                            d5.y yVarV0 = loginActivity.v0();
                            ((EditText) yVarV0.f7403d.f7085i).setText("");
                            b9.h hVar = yVarV0.f7402c;
                            ((EditText) hVar.f884c).setText("");
                            d5.h hVar2 = yVarV0.f7403d;
                            EditText editText = (EditText) hVar2.g;
                            editText.setText("");
                            editText.setEnabled(true);
                            ((EditText) hVar2.h).setText("");
                            ((EditText) hVar.f883b).setText("");
                            ((CheckBox) hVar2.f).setChecked(false);
                            d5.y yVarV02 = loginActivity.v0();
                            yVarV02.f.setText(loginActivity.getString(R.string.title_login));
                            ((LinearLayout) yVarV02.f7402c.f882a).setVisibility(0);
                            ((LinearLayout) yVarV02.f7403d.f7082b).setVisibility(8);
                        } else if (str3 == null || str3.length() == 0) {
                            String string2 = loginActivity.getString(R.string.signup_error_message);
                            string2.getClass();
                            loginActivity.C(string2);
                        } else {
                            loginActivity.C(str3);
                        }
                        int i15 = LoginActivity.P;
                        loginActivity.v0().f7401b.setVisibility(8);
                    }
                } else {
                    int i16 = LoginActivity.P;
                    loginActivity.v0().f7401b.setVisibility(0);
                }
                break;
        }
        return null;
    }
}
