package l4;

import com.uptodown.R;
import com.uptodown.activities.ReviewsActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e8 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10365a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f10366b;

    public /* synthetic */ e8(ReviewsActivity reviewsActivity, int i10) {
        this.f10365a = i10;
        this.f10366b = reviewsActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        h5.t0 t0Var;
        int i10 = this.f10365a;
        v5.k kVar = v5.k.f13167a;
        int i11 = -1;
        s6.w wVar = s6.w.f12711a;
        int i12 = 0;
        v5.j jVar = v5.j.f13166a;
        ReviewsActivity reviewsActivity = this.f10366b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar, jVar)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        i8 i8Var = (i8) ((v5.l) mVar).f13168a;
                        int i13 = i8Var.f10498a;
                        if (i13 != 1) {
                            int i14 = i8Var.f10499b;
                            if (i14 != 403) {
                                if (i13 != 0 || i14 != 0) {
                                    String string = reviewsActivity.getString(R.string.error_generico);
                                    string.getClass();
                                    reviewsActivity.C(string);
                                    break;
                                } else {
                                    String string2 = reviewsActivity.getString(R.string.error_review_already_submitted);
                                    string2.getClass();
                                    reviewsActivity.C(string2);
                                    break;
                                }
                            } else {
                                String string3 = reviewsActivity.getString(R.string.email_validation_msg);
                                string3.getClass();
                                reviewsActivity.C(string3);
                                break;
                            }
                        } else {
                            String string4 = reviewsActivity.getString(R.string.review_sended);
                            string4.getClass();
                            reviewsActivity.C(string4);
                            reviewsActivity.n0().f7350b.setText("");
                            break;
                        }
                    }
                } else {
                    int i15 = ReviewsActivity.M;
                    reviewsActivity.p0().f10565n = true;
                    reviewsActivity.n0().f7354j.setVisibility(0);
                    break;
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
                        h5.s0 s0Var = (h5.s0) ((v5.l) mVar2).f13168a;
                        if (s0Var.f8734b != 1) {
                            if (s0Var.f8735c != 401) {
                                String string5 = reviewsActivity.getString(R.string.error_generico);
                                string5.getClass();
                                reviewsActivity.C(string5);
                                break;
                            } else {
                                String string6 = reviewsActivity.getString(R.string.login_required_like_title);
                                string6.getClass();
                                String string7 = reviewsActivity.getString(R.string.login_required_like_msg);
                                string7.getClass();
                                a.a.q(reviewsActivity, string6, string7);
                                break;
                            }
                        } else {
                            n4.i0 i0Var = reviewsActivity.J;
                            if (i0Var != null) {
                                h5.t0 t0Var2 = s0Var.f8733a;
                                t0Var2.getClass();
                                ArrayList arrayList = i0Var.f11374a;
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        int i16 = i12 + 1;
                                        if (((h5.t0) it.next()).f8739a == t0Var2.f8739a) {
                                            i11 = i12;
                                        } else {
                                            i12 = i16;
                                        }
                                    }
                                }
                                arrayList.set(i11, t0Var2);
                                i0Var.notifyItemChanged(i11);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                v5.m mVar3 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar3, jVar)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar3, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var = (h5.d1) ((v5.l) mVar3).f13168a;
                        int i17 = d1Var.f8503b;
                        int i18 = d1Var.f8505d;
                        if (i17 != 1) {
                            int i19 = d1Var.f8504c;
                            if (i19 != 401) {
                                if (i19 != 409) {
                                    String string8 = reviewsActivity.getString(R.string.error_generico);
                                    string8.getClass();
                                    reviewsActivity.C(string8);
                                    break;
                                } else {
                                    String string9 = reviewsActivity.getString(R.string.already_following);
                                    string9.getClass();
                                    reviewsActivity.C(string9);
                                    break;
                                }
                            } else {
                                String string10 = reviewsActivity.getString(R.string.login_required_follow_title);
                                string10.getClass();
                                String string11 = reviewsActivity.getString(R.string.login_required_follow_msg);
                                string11.getClass();
                                a.a.q(reviewsActivity, string10, string11);
                                break;
                            }
                        } else {
                            String str = d1Var.f8502a;
                            n4.i0 i0Var2 = reviewsActivity.J;
                            if (i0Var2 != null) {
                                Iterator it2 = i0Var2.f11374a.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        int i20 = i12 + 1;
                                        if (kotlin.jvm.internal.l.a(((h5.t0) it2.next()).f8740b, str)) {
                                            i11 = i12;
                                        } else {
                                            i12 = i20;
                                        }
                                    }
                                }
                            }
                            if (i11 >= 0) {
                                n4.i0 i0Var3 = reviewsActivity.J;
                                if (i0Var3 != null && (t0Var = (h5.t0) i0Var3.f11374a.get(i11)) != null) {
                                    t0Var.f8749o = i18;
                                }
                                n4.i0 i0Var4 = reviewsActivity.J;
                                if (i0Var4 != null) {
                                    i0Var4.notifyItemChanged(i11);
                                }
                            }
                            if (i18 != 1) {
                                String string12 = reviewsActivity.getString(R.string.unfollow_succesfully);
                                string12.getClass();
                                reviewsActivity.C(string12);
                                break;
                            } else {
                                String string13 = reviewsActivity.getString(R.string.follow_succesfully);
                                string13.getClass();
                                reviewsActivity.C(string13);
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
