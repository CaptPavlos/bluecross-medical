package a3;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.WishlistActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import l4.ac;
import l4.c5;
import l4.f5;
import l4.fc;
import l4.m5;
import l4.n5;
import l4.o4;
import l4.o8;
import l4.oc;
import l4.q5;
import l4.t4;
import l4.x4;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f66b;

    public /* synthetic */ f1(Object obj, int i10) {
        this.f65a = i10;
        this.f66b = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x0335, code lost:
    
        if (r1 == r12) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03bf, code lost:
    
        if (r7.y.z(r6, r2, r4) == r12) goto L190;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(v5.m r21, w6.c r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.f1.a(v5.m, w6.c):java.lang.Object");
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10;
        String strO;
        int i11;
        String string;
        boolean z9;
        String str;
        String str2;
        String str3;
        String strO2;
        String strO3;
        int i12 = this.f65a;
        v5.k kVar = v5.k.f13167a;
        v5.j jVar = v5.j.f13166a;
        s6.w wVar = s6.w.f12711a;
        Object obj2 = this.f66b;
        int i13 = 0;
        switch (i12) {
            case 0:
                o0 o0Var = (o0) obj;
                k1 k1Var = (k1) obj2;
                o0Var.getClass();
                k1Var.h = o0Var;
                Object objA = k1.a(k1Var, o0Var.f145a.f161a, h1.f82a, cVar);
                if (objA == x6.a.f13718a) {
                    break;
                }
                break;
            case 1:
                v5.m mVar = (v5.m) obj;
                e5.m1 m1Var = (e5.m1) obj2;
                if ((m1Var.getActivity() instanceof MainActivity) && !kotlin.jvm.internal.l.a(mVar, jVar)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var = (h5.d1) ((v5.l) mVar).f13168a;
                        if (d1Var.f8503b != 1) {
                            int i14 = d1Var.f8504c;
                            if (i14 != 401) {
                                if (i14 != 409) {
                                    FragmentActivity activity = m1Var.getActivity();
                                    activity.getClass();
                                    String string2 = m1Var.getString(R.string.error_generico);
                                    string2.getClass();
                                    ((MainActivity) activity).C(string2);
                                    break;
                                } else {
                                    FragmentActivity activity2 = m1Var.getActivity();
                                    activity2.getClass();
                                    String string3 = m1Var.getString(R.string.already_following);
                                    string3.getClass();
                                    ((MainActivity) activity2).C(string3);
                                    break;
                                }
                            } else {
                                FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                fragmentActivityRequireActivity.getClass();
                                String string4 = m1Var.getString(R.string.login_required_follow_title);
                                string4.getClass();
                                String string5 = m1Var.getString(R.string.login_required_follow_msg);
                                string5.getClass();
                                a.a.q((MainActivity) fragmentActivityRequireActivity, string4, string5);
                                break;
                            }
                        } else {
                            FragmentActivity activity3 = m1Var.getActivity();
                            activity3.getClass();
                            String string6 = m1Var.getString(R.string.follow_succesfully);
                            string6.getClass();
                            ((MainActivity) activity3).C(string6);
                            break;
                        }
                    }
                }
                break;
            case 2:
                v5.m mVar2 = (v5.m) obj;
                FeedActivity feedActivity = (FeedActivity) obj2;
                if (!kotlin.jvm.internal.l.a(mVar2, jVar)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar2, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var2 = (h5.d1) ((v5.l) mVar2).f13168a;
                        if (d1Var2.f8503b != 1) {
                            int i15 = d1Var2.f8504c;
                            if (i15 != 401) {
                                if (i15 != 409) {
                                    String string7 = feedActivity.getString(R.string.error_generico);
                                    string7.getClass();
                                    feedActivity.C(string7);
                                    break;
                                } else {
                                    String string8 = feedActivity.getString(R.string.already_following);
                                    string8.getClass();
                                    feedActivity.C(string8);
                                    break;
                                }
                            } else {
                                String string9 = feedActivity.getString(R.string.login_required_follow_title);
                                string9.getClass();
                                String string10 = feedActivity.getString(R.string.login_required_follow_msg);
                                string10.getClass();
                                a.a.q(feedActivity, string9, string10);
                                break;
                            }
                        } else {
                            String string11 = feedActivity.getString(R.string.follow_succesfully);
                            string11.getClass();
                            feedActivity.C(string11);
                            break;
                        }
                    }
                }
                break;
            case 3:
                v5.m mVar3 = (v5.m) obj;
                FollowListActivity followListActivity = (FollowListActivity) obj2;
                int i16 = FollowListActivity.L;
                if (followListActivity.o0().e && !kotlin.jvm.internal.l.a(mVar3, jVar)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar3, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.d1 d1Var3 = (h5.d1) ((v5.l) mVar3).f13168a;
                        if (d1Var3.f8503b != 1) {
                            int i17 = d1Var3.f8504c;
                            if (i17 == 401) {
                                String string12 = followListActivity.getString(R.string.login_required_follow_title);
                                string12.getClass();
                                String string13 = followListActivity.getString(R.string.login_required_follow_msg);
                                string13.getClass();
                                a.a.q(followListActivity, string12, string13);
                            } else if (i17 == 409) {
                                String string14 = followListActivity.getString(R.string.already_following);
                                string14.getClass();
                                followListActivity.C(string14);
                            } else {
                                String string15 = followListActivity.getString(R.string.error_generico);
                                string15.getClass();
                                followListActivity.C(string15);
                            }
                        } else if (d1Var3.f8505d == 1) {
                            String string16 = followListActivity.getString(R.string.follow_succesfully);
                            string16.getClass();
                            followListActivity.C(string16);
                        } else {
                            String string17 = followListActivity.getString(R.string.unfollow_succesfully);
                            string17.getClass();
                            followListActivity.C(string17);
                        }
                        followListActivity.o0().e = false;
                        break;
                    }
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                v5.m mVar4 = (v5.m) obj;
                MyDownloads myDownloads = (MyDownloads) obj2;
                if (!(mVar4 instanceof v5.j)) {
                    if (!(mVar4 instanceof v5.l)) {
                        if (!(mVar4 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        int i18 = MyDownloads.O;
                        myDownloads.p0().f6903b.setVisibility(8);
                        ((RelativeLayout) myDownloads.p0().f6904c.f7134b).setVisibility(0);
                        o4 o4Var = (o4) ((v5.l) mVar4).f13168a;
                        ArrayList arrayList = o4Var.f10686a;
                        ArrayList arrayList2 = o4Var.f10687b;
                        if (!myDownloads.isFinishing()) {
                            if (myDownloads.J == null) {
                                myDownloads.J = new n4.b(myDownloads.N);
                                myDownloads.p0().e.setAdapter(myDownloads.J);
                            }
                            n4.b bVar = myDownloads.J;
                            bVar.getClass();
                            bVar.f11300b = new ArrayList();
                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                bVar.f11300b.addAll(arrayList2);
                            }
                            if (!arrayList.isEmpty()) {
                                bVar.f11300b.addAll(arrayList);
                            }
                            bVar.f11302d = new boolean[bVar.f11300b.size()];
                            bVar.notifyDataSetChanged();
                        }
                        if (!myDownloads.isFinishing()) {
                            if (o4Var.f10686a.size() == 0 && arrayList2.size() == 0) {
                                myDownloads.p0().h.setVisibility(0);
                                i10 = 8;
                                myDownloads.p0().e.setVisibility(8);
                            } else {
                                i10 = 8;
                                myDownloads.p0().h.setVisibility(8);
                                myDownloads.p0().e.setVisibility(0);
                            }
                            myDownloads.p0().f6903b.setVisibility(i10);
                            break;
                        }
                    }
                } else {
                    int i19 = MyDownloads.O;
                    myDownloads.p0().f6903b.setVisibility(0);
                    break;
                }
                break;
            case 7:
                v5.m mVar5 = (v5.m) obj;
                MyStatsActivity myStatsActivity = (MyStatsActivity) obj2;
                if (!kotlin.jvm.internal.l.a(mVar5, jVar)) {
                    if (!(mVar5 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar5, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.f1 f1Var = ((t4) ((v5.l) mVar5).f13168a).f10843a;
                        int i20 = MyStatsActivity.K;
                        if (f1Var.f8546a != null) {
                            StringBuilder sb = new StringBuilder();
                            String str4 = f1Var.f8546a;
                            str4.getClass();
                            sb.append(str4);
                            strO = a.o(sb, UptodownApp.M, ":webp");
                        } else {
                            strO = null;
                        }
                        if (strO != null && strO.length() != 0) {
                            j4.y yVarD = j4.y.d();
                            String str5 = f1Var.f8546a;
                            j4.d0 d0VarE = yVarD.e(str5 != null ? a.o(a.v(str5), UptodownApp.G, ":webp") : null);
                            float f = UptodownApp.E;
                            d0VarE.g(k4.c.z(myStatsActivity));
                            d0VarE.e(myStatsActivity.n0().f6935b, null);
                            myStatsActivity.n0().f6935b.setBackground(ContextCompat.getDrawable(myStatsActivity, R.drawable.shadow_user_icon));
                        }
                        if (f1Var.f8547b == 1) {
                            ImageView imageView = myStatsActivity.n0().f6935b;
                            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
                            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_small_avatar_turbo));
                            imageView.setPadding(dimension, dimension, dimension, dimension);
                        }
                        int iV = t1.v(myStatsActivity, 0, "stats_downloads");
                        int iV2 = t1.v(myStatsActivity, 0, "stats_installs");
                        int iV3 = t1.v(myStatsActivity, 0, "stats_updates");
                        long jW = t1.w(0L, myStatsActivity, "stats_time");
                        myStatsActivity.n0().f6952x.setText(v5.c.c(iV + f1Var.f8550i));
                        int color = ContextCompat.getColor(myStatsActivity, R.color.turbo_main);
                        int color2 = ContextCompat.getColor(myStatsActivity, R.color.main_blue);
                        TextView textView = myStatsActivity.n0().f6952x;
                        String string18 = textView.getText().toString();
                        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView.getPaint().measureText(myStatsActivity.n0().f6952x.getText().toString()), textView.getHeight(), new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                        SpannableString spannableString = new SpannableString(string18);
                        spannableString.setSpan(new v5.b(linearGradient, myStatsActivity.getResources().getDimension(R.dimen.font_size_46)), 0, myStatsActivity.n0().f6952x.length(), 33);
                        textView.setText(spannableString);
                        myStatsActivity.n0().h.setText(v5.c.c(iV2 + f1Var.f8551j));
                        myStatsActivity.n0().f6953z.setText(v5.c.c(iV3 + f1Var.f8552k));
                        myStatsActivity.n0().t.setText(String.valueOf(f1Var.f8548c));
                        myStatsActivity.n0().f6941l.setText(String.valueOf(f1Var.f8549d));
                        myStatsActivity.n0().f6947r.setText(String.valueOf(f1Var.e));
                        myStatsActivity.n0().f6939j.setText(String.valueOf(f1Var.f));
                        myStatsActivity.n0().f6945p.setText(String.valueOf(f1Var.g));
                        myStatsActivity.n0().f6943n.setText(String.valueOf(f1Var.h));
                        long j10 = jW + f1Var.f8553l;
                        TextView textView2 = myStatsActivity.n0().f6949u;
                        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
                        long j11 = 3600;
                        long j12 = (j10 % 86400) / j11;
                        long j13 = (j10 % j11) / 60;
                        if (j12 <= 0 || j13 <= 0) {
                            i11 = 0;
                            if (j12 > 0) {
                                string = myStatsActivity.getString(R.string.time_format_hours_only, Long.valueOf(j12));
                                string.getClass();
                            } else if (j13 > 0) {
                                string = myStatsActivity.getString(R.string.time_format_minutes_only, Long.valueOf(j13));
                                string.getClass();
                            } else {
                                string = myStatsActivity.getString(R.string.time_format_minutes_only, 0);
                                string.getClass();
                            }
                        } else {
                            i11 = 0;
                            string = myStatsActivity.getString(R.string.time_format_hours_minutes, Long.valueOf(j12), Long.valueOf(j13));
                            string.getClass();
                        }
                        textView2.setText(string);
                        myStatsActivity.n0().f6937d.setVisibility(i11);
                        myStatsActivity.n0().B.setBackground(ContextCompat.getDrawable(myStatsActivity, R.drawable.shape_bg_gradient_my_stats));
                        myStatsActivity.n0().B.setVisibility(i11);
                        myStatsActivity.n0().f6936c.setVisibility(8);
                        break;
                    }
                }
                break;
            case 8:
                v5.m mVar6 = (v5.m) obj;
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj2;
                if (!(mVar6 instanceof v5.j)) {
                    if (!(mVar6 instanceof v5.l)) {
                        if (!(mVar6 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = ((c5) ((v5.l) mVar6).f13168a).f10289a;
                        int i21 = NotificationsRegistryActivity.M;
                        boolean zIsEmpty = arrayList3.isEmpty();
                        n4.q qVar = notificationsRegistryActivity.K;
                        if (zIsEmpty) {
                            if (qVar != null) {
                                qVar.f11460a = new ArrayList();
                            }
                            n4.q qVar2 = notificationsRegistryActivity.K;
                            if (qVar2 != null) {
                                qVar2.notifyDataSetChanged();
                            }
                            z9 = false;
                            notificationsRegistryActivity.p0().e.setVisibility(0);
                        } else {
                            if (qVar == null) {
                                notificationsRegistryActivity.K = new n4.q(arrayList3, notificationsRegistryActivity, notificationsRegistryActivity.L);
                                notificationsRegistryActivity.p0().f7016c.setAdapter(notificationsRegistryActivity.K);
                            } else {
                                qVar.f11460a = arrayList3;
                                if (qVar != null) {
                                    qVar.notifyDataSetChanged();
                                }
                            }
                            notificationsRegistryActivity.p0().e.setVisibility(8);
                            z9 = false;
                        }
                        notificationsRegistryActivity.J = z9;
                        notificationsRegistryActivity.p0().f7015b.setVisibility(8);
                        break;
                    }
                } else {
                    int i22 = NotificationsRegistryActivity.M;
                    notificationsRegistryActivity.p0().f7015b.setVisibility(0);
                    break;
                }
                break;
            case 9:
                v5.m mVar7 = (v5.m) obj;
                OrganizationActivity organizationActivity = (OrganizationActivity) obj2;
                if (!kotlin.jvm.internal.l.a(mVar7, jVar)) {
                    if (!(mVar7 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar7, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        } else {
                            n4.b0 b0Var = organizationActivity.J;
                            if (b0Var != null) {
                                b0Var.a(false);
                                break;
                            }
                        }
                    } else {
                        q5 q5Var = (q5) ((v5.l) mVar7).f13168a;
                        boolean z10 = q5Var.f10762b;
                        h5.d0 d0Var = q5Var.f10761a;
                        if (z10) {
                            n4.b0 b0Var2 = organizationActivity.J;
                            b0Var2.getClass();
                            ArrayList arrayList4 = d0Var.f8501l;
                            if (arrayList4 != null && !arrayList4.isEmpty()) {
                                b0Var2.f11305c.size();
                                Iterator it = arrayList4.iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    next.getClass();
                                    n4.t tVar = new n4.t();
                                    tVar.f11484a = (h5.h) next;
                                    tVar.f11485b = 5;
                                    b0Var2.f11305c.add(tVar);
                                    b0Var2.notifyItemInserted(t6.m.P(b0Var2.f11305c));
                                }
                            }
                        } else {
                            int i23 = OrganizationActivity.K;
                            if (!organizationActivity.o0().h) {
                                d5.g0 g0VarN0 = organizationActivity.n0();
                                TextView textView3 = g0VarN0.f7071o;
                                TextView textView4 = g0VarN0.f7070n;
                                TextView textView5 = g0VarN0.f7068l;
                                ImageView imageView2 = g0VarN0.e;
                                ImageView imageView3 = g0VarN0.f7063c;
                                ImageView imageView4 = g0VarN0.f;
                                TextView textView6 = g0VarN0.f7072p;
                                TextView textView7 = g0VarN0.f7069m;
                                textView3.setText(d0Var.f8494a);
                                String str6 = d0Var.f;
                                if (str6 == null || str6.length() == 0 || (str2 = d0Var.h) == null || str2.length() == 0 || (str3 = d0Var.g) == null || str3.length() == 0) {
                                    organizationActivity.n0().h.setVisibility(8);
                                } else {
                                    String str7 = d0Var.f;
                                    if (str7 != null && str7.length() != 0) {
                                        j4.y yVarD2 = j4.y.d();
                                        if (d0Var.f != null) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(d0Var.f);
                                            strO3 = a.o(sb2, UptodownApp.H, ":webp");
                                        } else {
                                            strO3 = null;
                                        }
                                        j4.d0 d0VarE2 = yVarD2.e(strO3);
                                        float f10 = UptodownApp.E;
                                        d0VarE2.g(k4.c.x(organizationActivity));
                                        d0VarE2.e(g0VarN0.f7062b, null);
                                    }
                                    String str8 = d0Var.g;
                                    if (str8 != null && str8.length() != 0) {
                                        j4.y yVarD3 = j4.y.d();
                                        if (d0Var.g != null) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append(d0Var.g);
                                            strO2 = a.o(sb3, UptodownApp.G, ":webp");
                                        } else {
                                            strO2 = null;
                                        }
                                        j4.d0 d0VarE3 = yVarD3.e(strO2);
                                        float f11 = UptodownApp.E;
                                        d0VarE3.g(k4.c.y(organizationActivity));
                                        d0VarE3.e(g0VarN0.f7064d, null);
                                    }
                                    textView7.setTypeface(o4.b.f11719r);
                                    textView7.setText(d0Var.f8494a);
                                    textView6.setTypeface(o4.b.f11719r);
                                    textView6.setOnClickListener(new m5(d0Var, organizationActivity));
                                    String str9 = d0Var.f8496c;
                                    if (str9 != null && str9.length() != 0) {
                                        imageView4.setVisibility(0);
                                        imageView4.setOnClickListener(new m5(organizationActivity, d0Var, 1));
                                    }
                                    String str10 = d0Var.f8497d;
                                    if (str10 != null && str10.length() != 0) {
                                        imageView3.setVisibility(0);
                                        imageView3.setOnClickListener(new m5(organizationActivity, d0Var, 2));
                                    }
                                    String str11 = d0Var.e;
                                    if (str11 != null && str11.length() != 0) {
                                        imageView2.setVisibility(0);
                                        imageView2.setOnClickListener(new m5(organizationActivity, d0Var, 3));
                                    }
                                    textView5.setTypeface(o4.b.f11720s);
                                    textView5.setText(d0Var.h);
                                    textView4.setTypeface(o4.b.f11719r);
                                    textView4.setOnClickListener(new f5(2, d0Var, g0VarN0));
                                }
                                organizationActivity.o0().h = true;
                            }
                            if (organizationActivity.J == null && (str = d0Var.f8494a) != null && str.length() != 0) {
                                n5 n5Var = new n5(organizationActivity, 0);
                                String str12 = d0Var.f8494a;
                                str12.getClass();
                                n4.b0 b0Var3 = new n4.b0();
                                b0Var3.f11303a = n5Var;
                                b0Var3.f11304b = str12;
                                b0Var3.f11305c = new ArrayList();
                                organizationActivity.J = b0Var3;
                                organizationActivity.n0().f7065i.setAdapter(organizationActivity.J);
                            }
                            n4.b0 b0Var4 = organizationActivity.J;
                            if (b0Var4 != null) {
                                h5.h hVar = d0Var.f8498i;
                                ArrayList arrayList5 = d0Var.f8499j;
                                ArrayList arrayList6 = d0Var.f8500k;
                                ArrayList arrayList7 = d0Var.f8501l;
                                ArrayList arrayList8 = new ArrayList();
                                b0Var4.f11305c = arrayList8;
                                if (hVar != null) {
                                    n4.t tVar2 = new n4.t();
                                    tVar2.f11484a = hVar;
                                    tVar2.f11485b = 1;
                                    arrayList8.add(tVar2);
                                }
                                if (arrayList5 != null && !arrayList5.isEmpty()) {
                                    n4.t tVar3 = new n4.t();
                                    tVar3.f11484a = arrayList5;
                                    tVar3.f11485b = 2;
                                    b0Var4.f11305c.add(tVar3);
                                }
                                if (arrayList6 != null && !arrayList6.isEmpty()) {
                                    n4.t tVar4 = new n4.t();
                                    tVar4.f11484a = arrayList6;
                                    tVar4.f11485b = 3;
                                    b0Var4.f11305c.add(tVar4);
                                }
                                if (arrayList7 != null && !arrayList7.isEmpty()) {
                                    n4.t tVar5 = new n4.t();
                                    tVar5.f11484a = arrayList7;
                                    tVar5.f11485b = 4;
                                    b0Var4.f11305c.add(tVar5);
                                    Iterator it2 = arrayList7.iterator();
                                    it2.getClass();
                                    while (it2.hasNext()) {
                                        Object next2 = it2.next();
                                        next2.getClass();
                                        n4.t tVar6 = new n4.t();
                                        tVar6.f11484a = (h5.h) next2;
                                        tVar6.f11485b = 5;
                                        b0Var4.f11305c.add(tVar6);
                                    }
                                }
                            }
                        }
                        int i24 = OrganizationActivity.K;
                        organizationActivity.n0().g.setVisibility(8);
                        organizationActivity.n0().f7066j.setVisibility(0);
                        n4.b0 b0Var5 = organizationActivity.J;
                        if (b0Var5 != null) {
                            b0Var5.a(false);
                            break;
                        }
                    }
                } else if (organizationActivity.J == null) {
                    organizationActivity.n0().g.setVisibility(0);
                    break;
                }
                break;
            case 10:
                break;
            case 11:
                v5.m mVar8 = (v5.m) obj;
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) obj2;
                if (!(mVar8 instanceof v5.j)) {
                    if (!(mVar8 instanceof v5.l)) {
                        if (!(mVar8 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        ArrayList arrayList9 = (ArrayList) ((v5.l) mVar8).f13168a;
                        n4.d0 d0Var2 = preregistrationActivity.J;
                        if (d0Var2 == null) {
                            preregistrationActivity.J = new n4.d0(arrayList9, preregistrationActivity, preregistrationActivity.K);
                            preregistrationActivity.n0().f7204d.setAdapter(preregistrationActivity.J);
                        } else {
                            arrayList9.getClass();
                            d0Var2.a(arrayList9);
                        }
                        if (arrayList9.isEmpty()) {
                            preregistrationActivity.n0().g.setVisibility(0);
                        }
                        preregistrationActivity.n0().f.setVisibility(0);
                        preregistrationActivity.n0().f7204d.setVisibility(0);
                        preregistrationActivity.n0().f7203c.setVisibility(8);
                        break;
                    }
                } else if (preregistrationActivity.J == null) {
                    preregistrationActivity.n0().f7203c.setVisibility(0);
                    break;
                }
                break;
            case 12:
                v5.m mVar9 = (v5.m) obj;
                PublicListActivity publicListActivity = (PublicListActivity) obj2;
                if (!(mVar9 instanceof v5.j)) {
                    if (!(mVar9 instanceof v5.l)) {
                        if (!(mVar9 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        } else {
                            int i25 = PublicListActivity.Y;
                            publicListActivity.B0().f7218b.setVisibility(8);
                            n4.d1 d1Var4 = publicListActivity.W;
                            if (d1Var4 != null) {
                                d1Var4.d(false);
                                n4.d1 d1Var5 = publicListActivity.W;
                                d1Var5.getClass();
                                if (d1Var5.f11324a.isEmpty()) {
                                    publicListActivity.B0().e.setVisibility(0);
                                    break;
                                }
                            }
                        }
                    } else {
                        ArrayList arrayList10 = (ArrayList) ((v5.l) mVar9).f13168a;
                        if (arrayList10.size() == 0) {
                            int i26 = PublicListActivity.Y;
                            publicListActivity.B0().e.setVisibility(0);
                        } else {
                            n4.d1 d1Var6 = publicListActivity.W;
                            if (d1Var6 == null) {
                                publicListActivity.W = new n4.d1(arrayList10, publicListActivity, publicListActivity.X);
                                publicListActivity.B0().f7219c.setAdapter(publicListActivity.W);
                            } else {
                                d1Var6.f11324a.addAll(arrayList10);
                                d1Var6.notifyDataSetChanged();
                                n4.d1 d1Var7 = publicListActivity.W;
                                if (d1Var7 != null) {
                                    d1Var7.d(false);
                                }
                            }
                        }
                        int i27 = PublicListActivity.Y;
                        publicListActivity.B0().f7218b.setVisibility(8);
                        break;
                    }
                } else if (publicListActivity.W == null) {
                    publicListActivity.B0().f7218b.setVisibility(0);
                    break;
                }
                break;
            case 13:
                v5.m mVar10 = (v5.m) obj;
                RollbackActivity rollbackActivity = (RollbackActivity) obj2;
                if (!(mVar10 instanceof v5.j)) {
                    if (!(mVar10 instanceof v5.l)) {
                        if (!(mVar10 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        } else {
                            int i28 = RollbackActivity.Y;
                            rollbackActivity.B0().f7368b.setVisibility(8);
                            rollbackActivity.B0().f.setVisibility(0);
                            rollbackActivity.B0().f.setText(rollbackActivity.getString(R.string.no_results));
                            break;
                        }
                    } else {
                        ArrayList arrayList11 = ((o8) ((v5.l) mVar10).f13168a).f10694a;
                        n4.j0 j0Var = rollbackActivity.W;
                        if (j0Var == null) {
                            rollbackActivity.W = new n4.j0(arrayList11, rollbackActivity, rollbackActivity);
                            rollbackActivity.B0().f7369c.setAdapter(rollbackActivity.W);
                        } else {
                            j0Var.f11384a = new ArrayList(arrayList11);
                            j0Var.notifyDataSetChanged();
                        }
                        rollbackActivity.B0().g.setVisibility(0);
                        rollbackActivity.B0().f7368b.setVisibility(8);
                        break;
                    }
                } else {
                    int i29 = RollbackActivity.Y;
                    rollbackActivity.B0().f7368b.setVisibility(0);
                    break;
                }
            case 14:
                v5.m mVar11 = (v5.m) obj;
                SecurityActivity securityActivity = (SecurityActivity) obj2;
                if (!(mVar11 instanceof v5.j)) {
                    if (!(mVar11 instanceof v5.l)) {
                        if (!(mVar11 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        ArrayList arrayList12 = (ArrayList) ((v5.l) mVar11).f13168a;
                        if (arrayList12.isEmpty()) {
                            int i30 = SecurityActivity.Z;
                            securityActivity.B0().f7397c.setVisibility(0);
                            securityActivity.B0().f7398d.setVisibility(8);
                            TextView textView8 = securityActivity.B0().g;
                            long jW2 = t1.w(0L, securityActivity, "last_analysis_timestamp");
                            textView8.setText(securityActivity.getString(R.string.uptodown_last_analysis, String.valueOf(jW2 > 0 ? new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(jW2)) : null)));
                        } else {
                            int i31 = SecurityActivity.Z;
                            securityActivity.B0().f7398d.setVisibility(0);
                            securityActivity.B0().f7397c.setVisibility(8);
                            n4.m0 m0Var = securityActivity.W;
                            if (m0Var == null) {
                                n5 n5Var2 = securityActivity.Y;
                                x4 x4Var = securityActivity.X;
                                x4Var.getClass();
                                securityActivity.W = new n4.m0(arrayList12, securityActivity, n5Var2, x4Var);
                                securityActivity.B0().f7398d.setAdapter(securityActivity.W);
                            } else {
                                m0Var.f11437d = new ArrayList();
                                m0Var.a().add("uptodown_protect");
                                m0Var.a().addAll(arrayList12);
                                m0Var.notifyDataSetChanged();
                            }
                        }
                        securityActivity.B0().f7396b.setVisibility(8);
                        break;
                    }
                } else {
                    int i32 = SecurityActivity.Z;
                    securityActivity.B0().f7396b.setVisibility(0);
                    break;
                }
                break;
            case 15:
                break;
            case 16:
                v5.m mVar12 = (v5.m) obj;
                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) obj2;
                if (mVar12 instanceof v5.l) {
                    h5.s0 s0Var = (h5.s0) ((v5.l) mVar12).f13168a;
                    if (s0Var.f8734b != 1) {
                        if (s0Var.f8735c != 401) {
                            String string19 = userCommentsActivity.getString(R.string.error_generico);
                            string19.getClass();
                            userCommentsActivity.C(string19);
                            break;
                        } else {
                            String string20 = userCommentsActivity.getString(R.string.login_required_like_title);
                            string20.getClass();
                            String string21 = userCommentsActivity.getString(R.string.login_required_like_msg);
                            string21.getClass();
                            a.a.q(userCommentsActivity, string20, string21);
                            break;
                        }
                    } else {
                        n4.a1 a1Var = userCommentsActivity.J;
                        if (a1Var != null) {
                            h5.t0 t0Var = s0Var.f8733a;
                            t0Var.getClass();
                            ArrayList arrayList13 = a1Var.f11296a;
                            Iterator it3 = arrayList13.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    int i33 = i13 + 1;
                                    if (((h5.t0) it3.next()).f8739a != t0Var.f8739a) {
                                        i13 = i33;
                                    }
                                } else {
                                    i13 = -1;
                                }
                            }
                            arrayList13.set(i13, t0Var);
                            a1Var.notifyItemChanged(i13);
                            break;
                        }
                    }
                }
                break;
            case 17:
                v5.m mVar13 = (v5.m) obj;
                UsernameEditActivity usernameEditActivity = (UsernameEditActivity) obj2;
                if (!(mVar13 instanceof v5.j)) {
                    if (!(mVar13 instanceof v5.l)) {
                        if (!(mVar13 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        ac acVar = (ac) ((v5.l) mVar13).f13168a;
                        int i34 = acVar.f10232a;
                        String str13 = acVar.f10234c;
                        if (i34 != 0 && !acVar.f10233b) {
                            String string22 = usernameEditActivity.getString(R.string.username_edit_complete);
                            string22.getClass();
                            usernameEditActivity.C(string22);
                            usernameEditActivity.setResult(10);
                            usernameEditActivity.finish();
                        } else if (str13 == null || str13.length() == 0) {
                            String string23 = usernameEditActivity.getString(R.string.error_generico);
                            string23.getClass();
                            usernameEditActivity.C(string23);
                        } else {
                            usernameEditActivity.C(str13);
                        }
                        int i35 = UsernameEditActivity.K;
                        usernameEditActivity.n0().f7118j.setVisibility(8);
                        break;
                    }
                } else {
                    int i36 = UsernameEditActivity.K;
                    usernameEditActivity.n0().f7118j.setVisibility(0);
                    break;
                }
                break;
            case 18:
                v5.m mVar14 = (v5.m) obj;
                VirusTotalReport virusTotalReport = (VirusTotalReport) obj2;
                if (!(mVar14 instanceof v5.j)) {
                    if (!(mVar14 instanceof v5.l)) {
                        if (!(mVar14 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else if (((fc) ((v5.l) mVar14).f13168a).f10411a == null) {
                        int i37 = VirusTotalReport.J;
                        virusTotalReport.n0().f7181i.setVisibility(8);
                        virusTotalReport.n0().f7187o.setVisibility(0);
                        virusTotalReport.n0().e.setVisibility(8);
                        break;
                    } else {
                        int i38 = VirusTotalReport.J;
                        virusTotalReport.p0();
                        virusTotalReport.q0();
                        virusTotalReport.r0();
                        break;
                    }
                } else {
                    int i39 = VirusTotalReport.J;
                    virusTotalReport.n0().e.setVisibility(0);
                    break;
                }
                break;
            default:
                v5.m mVar15 = (v5.m) obj;
                WishlistActivity wishlistActivity = (WishlistActivity) obj2;
                if (!(mVar15 instanceof v5.j)) {
                    if (!(mVar15 instanceof v5.l)) {
                        if (!(mVar15 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        } else {
                            n4.d1 d1Var8 = wishlistActivity.W;
                            if (d1Var8 != null) {
                                d1Var8.d(false);
                                break;
                            }
                        }
                    } else {
                        oc ocVar = (oc) ((v5.l) mVar15).f13168a;
                        ArrayList arrayList14 = ocVar.f10700a;
                        n4.d1 d1Var9 = wishlistActivity.W;
                        if (d1Var9 == null) {
                            wishlistActivity.W = new n4.d1(arrayList14, wishlistActivity, wishlistActivity.X);
                            wishlistActivity.B0().f7207c.setAdapter(wishlistActivity.W);
                        } else {
                            d1Var9.f11324a.addAll(arrayList14);
                            d1Var9.notifyDataSetChanged();
                            n4.d1 d1Var10 = wishlistActivity.W;
                            if (d1Var10 != null) {
                                d1Var10.d(false);
                            }
                        }
                        if (ocVar.f10700a.isEmpty()) {
                            wishlistActivity.B0().f.setVisibility(0);
                            wishlistActivity.B0().e.setVisibility(0);
                        }
                        wishlistActivity.B0().f7206b.setVisibility(8);
                        break;
                    }
                } else if (wishlistActivity.W == null) {
                    wishlistActivity.B0().f7206b.setVisibility(0);
                    break;
                }
                break;
        }
        return null;
    }
}
