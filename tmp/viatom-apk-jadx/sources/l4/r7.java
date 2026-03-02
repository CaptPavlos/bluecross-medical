package l4;

import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r7 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10796a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f10797b;

    public /* synthetic */ r7(RepliesActivity repliesActivity, int i10) {
        this.f10796a = i10;
        this.f10797b = repliesActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10;
        int i11 = this.f10796a;
        s6.w wVar = s6.w.f12711a;
        v5.j jVar = v5.j.f13166a;
        RepliesActivity repliesActivity = this.f10797b;
        switch (i11) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar, jVar)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!(mVar instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.s0 s0Var = (h5.s0) ((v5.l) mVar).f13168a;
                        if (s0Var.f8734b != 1) {
                            if (s0Var.f8735c != 401) {
                                String string = repliesActivity.getString(R.string.error_generico);
                                string.getClass();
                                repliesActivity.C(string);
                                break;
                            } else {
                                String string2 = repliesActivity.getString(R.string.login_required_like_title);
                                string2.getClass();
                                String string3 = repliesActivity.getString(R.string.login_required_like_msg);
                                string3.getClass();
                                a.a.q(repliesActivity, string2, string3);
                                break;
                            }
                        } else {
                            repliesActivity.n0().f7283k.f7305o.setText(String.valueOf(s0Var.f8733a.f8744j));
                            break;
                        }
                    }
                }
                break;
            case 1:
                v5.m mVar2 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar2, jVar)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!(mVar2 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.l0 l0Var = (h5.l0) ((v5.l) mVar2).f13168a;
                        if (l0Var.f8648b != 1) {
                            if (l0Var.f8649c != 401) {
                                String string4 = repliesActivity.getString(R.string.error_generico);
                                string4.getClass();
                                repliesActivity.C(string4);
                                break;
                            } else {
                                String string5 = repliesActivity.getString(R.string.login_required_like_title);
                                string5.getClass();
                                String string6 = repliesActivity.getString(R.string.login_required_like_msg);
                                string6.getClass();
                                a.a.q(repliesActivity, string5, string6);
                                break;
                            }
                        } else {
                            n4.h0 h0Var = repliesActivity.J;
                            if (h0Var != null) {
                                h0Var.b(l0Var.f8647a);
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                v5.m mVar3 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar3, jVar)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!(mVar3 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        v7 v7Var = (v7) ((v5.l) mVar3).f13168a;
                        int i12 = v7Var.f10917a;
                        String str = v7Var.e;
                        if (i12 != 1) {
                            int i13 = v7Var.f10918b;
                            if (i13 != 401) {
                                if (i13 != 403) {
                                    if (str != null && str.length() != 0) {
                                        repliesActivity.C(str);
                                        break;
                                    }
                                } else {
                                    String string7 = repliesActivity.getString(R.string.email_validation_msg);
                                    string7.getClass();
                                    repliesActivity.C(string7);
                                    break;
                                }
                            } else {
                                int i14 = RepliesActivity.L;
                                h5.c1.b(repliesActivity);
                                repliesActivity.q0();
                                break;
                            }
                        } else {
                            h5.e1 e1VarH = h5.c1.h(repliesActivity);
                            if (e1VarH != null && e1VarH.f8514c != null) {
                                float f = UptodownApp.E;
                            }
                            repliesActivity.n0().f7278b.setText("");
                            String string8 = repliesActivity.getString(R.string.review_sended);
                            string8.getClass();
                            repliesActivity.C(string8);
                            break;
                        }
                    }
                }
                break;
            default:
                v5.m mVar4 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar4, jVar)) {
                    if (!(mVar4 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar4, v5.k.f13167a)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var = (h5.d1) ((v5.l) mVar4).f13168a;
                        int i15 = d1Var.f8503b;
                        int i16 = d1Var.f8505d;
                        if (i15 != 1) {
                            int i17 = d1Var.f8504c;
                            if (i17 != 401) {
                                if (i17 != 409) {
                                    String string9 = repliesActivity.getString(R.string.error_generico);
                                    string9.getClass();
                                    repliesActivity.C(string9);
                                    break;
                                } else {
                                    String string10 = repliesActivity.getString(R.string.already_following);
                                    string10.getClass();
                                    repliesActivity.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = repliesActivity.getString(R.string.login_required_follow_title);
                                string11.getClass();
                                String string12 = repliesActivity.getString(R.string.login_required_follow_msg);
                                string12.getClass();
                                a.a.q(repliesActivity, string11, string12);
                                break;
                            }
                        } else {
                            String str2 = d1Var.f8502a;
                            n4.h0 h0Var2 = repliesActivity.J;
                            if (h0Var2 != null) {
                                Iterator it = h0Var2.f11363a.iterator();
                                i10 = 0;
                                while (it.hasNext()) {
                                    int i18 = i10 + 1;
                                    if (!kotlin.jvm.internal.l.a(((h5.m0) it.next()).f8659c, str2)) {
                                        i10 = i18;
                                    }
                                }
                                i10 = -1;
                            } else {
                                i10 = -1;
                            }
                            if (i10 != -1) {
                                n4.h0 h0Var3 = repliesActivity.J;
                                h5.m0 m0Var = h0Var3 != null ? (h5.m0) h0Var3.f11363a.get(i10) : null;
                                if (m0Var != null) {
                                    m0Var.f8664l = i16;
                                    n4.h0 h0Var4 = repliesActivity.J;
                                    if (h0Var4 != null) {
                                        h0Var4.b(m0Var);
                                    }
                                }
                            } else if (repliesActivity.o0().f11039m.getValue() != null) {
                                h5.t0 t0Var = (h5.t0) repliesActivity.o0().f11039m.getValue();
                                if (t0Var != null) {
                                    t0Var.f8749o = i16;
                                }
                                Object value = repliesActivity.o0().f11039m.getValue();
                                value.getClass();
                                repliesActivity.s0((h5.t0) value);
                            }
                            if (i16 != 1) {
                                String string13 = repliesActivity.getString(R.string.unfollow_succesfully);
                                string13.getClass();
                                repliesActivity.C(string13);
                                break;
                            } else {
                                String string14 = repliesActivity.getString(R.string.follow_succesfully);
                                string14.getClass();
                                repliesActivity.C(string14);
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return null;
    }
}
