package l4;

import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u6 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10881a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10882b;

    public /* synthetic */ u6(PublicProfileActivity publicProfileActivity, int i10) {
        this.f10881a = i10;
        this.f10882b = publicProfileActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10 = this.f10881a;
        s6.w wVar = s6.w.f12711a;
        v5.j jVar = v5.j.f13166a;
        PublicProfileActivity publicProfileActivity = this.f10882b;
        switch (i10) {
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
                                String string = publicProfileActivity.getString(R.string.error_generico);
                                string.getClass();
                                publicProfileActivity.C(string);
                                break;
                            } else {
                                String string2 = publicProfileActivity.getString(R.string.login_required_like_title);
                                string2.getClass();
                                String string3 = publicProfileActivity.getString(R.string.login_required_like_msg);
                                string3.getClass();
                                a.a.q(publicProfileActivity, string2, string3);
                                break;
                            }
                        } else {
                            int i11 = PublicProfileActivity.K;
                            break;
                        }
                    }
                }
                break;
            default:
                v5.m mVar2 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar2, jVar)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar2, v5.k.f13167a)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var = (h5.d1) ((v5.l) mVar2).f13168a;
                        if (d1Var.f8503b != 1) {
                            int i12 = d1Var.f8504c;
                            if (i12 != 401) {
                                if (i12 != 409) {
                                    String string4 = publicProfileActivity.getString(R.string.error_generico);
                                    string4.getClass();
                                    publicProfileActivity.C(string4);
                                    break;
                                } else {
                                    String string5 = publicProfileActivity.getString(R.string.already_following);
                                    string5.getClass();
                                    publicProfileActivity.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = publicProfileActivity.getString(R.string.login_required_follow_title);
                                string6.getClass();
                                String string7 = publicProfileActivity.getString(R.string.login_required_follow_msg);
                                string7.getClass();
                                a.a.q(publicProfileActivity, string6, string7);
                                break;
                            }
                        } else if (d1Var.f8505d != 1) {
                            int i13 = PublicProfileActivity.K;
                            publicProfileActivity.n0().f7255o.setText(publicProfileActivity.getString(R.string.follow));
                            publicProfileActivity.n0().f7255o.setBackground(ContextCompat.getDrawable(publicProfileActivity, R.drawable.ripple_blue_primary_button));
                            publicProfileActivity.n0().f7255o.setTextColor(ContextCompat.getColor(publicProfileActivity, R.color.white));
                            publicProfileActivity.n0().f7257q.setText(v5.c.c(publicProfileActivity.o0().f10298i));
                            break;
                        } else {
                            int i14 = PublicProfileActivity.K;
                            publicProfileActivity.n0().f7255o.setText(publicProfileActivity.getString(R.string.unfollow));
                            publicProfileActivity.n0().f7255o.setBackground(ContextCompat.getDrawable(publicProfileActivity, R.drawable.ripple_stroke_blue_primary));
                            publicProfileActivity.n0().f7255o.setTextColor(ContextCompat.getColor(publicProfileActivity, R.color.blue_primary));
                            publicProfileActivity.n0().f7257q.setText(v5.c.c(publicProfileActivity.o0().f10298i));
                            break;
                        }
                    }
                }
                break;
        }
        return null;
    }
}
