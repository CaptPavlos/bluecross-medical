package l4;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ListsActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10483a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f10484b;

    public /* synthetic */ i1(ListsActivity listsActivity, int i10) {
        this.f10483a = i10;
        this.f10484b = listsActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v54, types: [j4.d0] */
    /* JADX WARN: Type inference failed for: r8v20, types: [j4.g] */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) throws Resources.NotFoundException {
        int i10 = this.f10483a;
        s6.w wVar = s6.w.f12711a;
        ListsActivity listsActivity = this.f10484b;
        int i11 = 1;
        ViewGroup viewGroup = null;
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
                        int i12 = ListsActivity.K;
                        if (!listsActivity.p0().f10707c) {
                            m1 m1Var = (m1) ((v5.l) mVar).f13168a;
                            if (m1Var.f10616a.isEmpty()) {
                                ((ImageView) listsActivity.o0().e.f1642c).setImageDrawable(ContextCompat.getDrawable(listsActivity, R.drawable.shape_bg_placeholder));
                            } else {
                                Iterator it = m1Var.f10616a.iterator();
                                int i13 = 0;
                                while (it.hasNext()) {
                                    int i14 = i13 + 1;
                                    h5.i1 i1Var = (h5.i1) it.next();
                                    if (i13 == 0) {
                                        j4.d0 d0VarE = j4.y.d().e(i1Var.a());
                                        d0VarE.f(R.drawable.shape_bg_placeholder);
                                        float f = UptodownApp.E;
                                        d0VarE.g(k4.c.y(listsActivity));
                                        d0VarE.e((ImageView) listsActivity.o0().e.f1642c, null);
                                    } else {
                                        String str = i1Var.f8618c;
                                        if (str != null && str.length() != 0) {
                                            String strA = i1Var.a();
                                            strA.getClass();
                                            listsActivity.n0(strA, (LinearLayout) listsActivity.o0().e.f1643d, i13);
                                        }
                                    }
                                    i13 = i14;
                                }
                            }
                            listsActivity.p0().f10707c = true;
                            ((TextView) listsActivity.o0().e.g).setText(listsActivity.q0(m1Var.f10617b));
                            ((RelativeLayout) listsActivity.o0().e.f).setVisibility(0);
                            ((ProgressBar) listsActivity.o0().e.e).setVisibility(8);
                            listsActivity.o0().f.setVisibility(8);
                            ((LinearLayout) listsActivity.o0().e.f1641b).setOnClickListener(new h1(listsActivity, i11));
                            break;
                        }
                    }
                }
                break;
            case 1:
                v5.m mVar2 = (v5.m) obj;
                if (!(mVar2 instanceof v5.j)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!(mVar2 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        int i15 = ListsActivity.K;
                        if (!listsActivity.p0().f) {
                            m1 m1Var2 = (m1) ((v5.l) mVar2).f13168a;
                            if (m1Var2.f10616a.isEmpty()) {
                                ((ImageView) listsActivity.o0().f7394d.f1642c).setImageDrawable(ContextCompat.getDrawable(listsActivity, R.drawable.shape_bg_placeholder));
                            } else {
                                Iterator it2 = m1Var2.f10616a.iterator();
                                int i16 = 0;
                                while (it2.hasNext()) {
                                    int i17 = i16 + 1;
                                    h5.i1 i1Var2 = (h5.i1) it2.next();
                                    if (i16 == 0) {
                                        j4.d0 d0VarE2 = j4.y.d().e(i1Var2.a());
                                        d0VarE2.f(R.drawable.shape_bg_placeholder);
                                        float f10 = UptodownApp.E;
                                        d0VarE2.g(k4.c.y(listsActivity));
                                        d0VarE2.e((ImageView) listsActivity.o0().f7394d.f1642c, null);
                                    } else {
                                        String str2 = i1Var2.f8618c;
                                        if (str2 != null && str2.length() != 0) {
                                            String strA2 = i1Var2.a();
                                            strA2.getClass();
                                            listsActivity.n0(strA2, (LinearLayout) listsActivity.o0().f7394d.f1643d, i16);
                                        }
                                    }
                                    i16 = i17;
                                }
                            }
                            listsActivity.p0().f = true;
                            ((TextView) listsActivity.o0().f7394d.g).setText(listsActivity.q0(m1Var2.f10617b));
                            ((RelativeLayout) listsActivity.o0().f7394d.f).setVisibility(0);
                            ((ProgressBar) listsActivity.o0().f7394d.e).setVisibility(8);
                            listsActivity.o0().f.setVisibility(8);
                            ((LinearLayout) listsActivity.o0().f7394d.f1641b).setOnClickListener(new h1(listsActivity, 2));
                            break;
                        }
                    }
                }
                break;
            case 2:
                v5.m mVar3 = (v5.m) obj;
                if (!(mVar3 instanceof v5.j)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!(mVar3 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        int i18 = ListsActivity.K;
                        if (!listsActivity.p0().f10709i) {
                            n1 n1Var = (n1) ((v5.l) mVar3).f13168a;
                            if (n1Var.f10645a.isEmpty()) {
                                ((ImageView) listsActivity.o0().f7393c.f1642c).setImageDrawable(ContextCompat.getDrawable(listsActivity, R.drawable.shape_bg_placeholder));
                            } else {
                                Iterator it3 = n1Var.f10645a.iterator();
                                int i19 = 0;
                                while (it3.hasNext()) {
                                    int i20 = i19 + 1;
                                    h5.g0 g0Var = (h5.g0) it3.next();
                                    if (i19 == 0) {
                                        j4.d0 d0VarE3 = j4.y.d().e(g0Var.f8560c);
                                        d0VarE3.f(R.drawable.shape_bg_placeholder);
                                        float f11 = UptodownApp.E;
                                        d0VarE3.g(k4.c.y(listsActivity));
                                        d0VarE3.e((ImageView) listsActivity.o0().f7393c.f1642c, null);
                                    } else {
                                        String str3 = g0Var.f8560c;
                                        if (str3 != null && str3.length() != 0) {
                                            String str4 = g0Var.f8560c;
                                            str4.getClass();
                                            listsActivity.n0(str4, (LinearLayout) listsActivity.o0().f7393c.f1643d, i19);
                                        }
                                    }
                                    i19 = i20;
                                }
                            }
                            listsActivity.p0().f10709i = true;
                            ((TextView) listsActivity.o0().f7393c.g).setText(listsActivity.q0(n1Var.f10646b));
                            ((RelativeLayout) listsActivity.o0().f7393c.f).setVisibility(0);
                            ((ProgressBar) listsActivity.o0().f7393c.e).setVisibility(8);
                            listsActivity.o0().f.setVisibility(8);
                            ((LinearLayout) listsActivity.o0().f7393c.f1641b).setOnClickListener(new h1(listsActivity, 3));
                            break;
                        }
                    }
                }
                break;
            default:
                v5.m mVar4 = (v5.m) obj;
                if (!(mVar4 instanceof v5.j)) {
                    if (!(mVar4 instanceof v5.l)) {
                        if (!(mVar4 instanceof v5.k)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        int i21 = ListsActivity.K;
                        if (!listsActivity.p0().f10712l) {
                            Object obj2 = ((v5.l) mVar4).f13168a;
                            if (!((Collection) obj2).isEmpty()) {
                                Iterator it4 = ((ArrayList) obj2).iterator();
                                it4.getClass();
                                while (it4.hasNext()) {
                                    Object next = it4.next();
                                    next.getClass();
                                    h5.u uVar = (h5.u) next;
                                    c2.d dVarC = c2.d.c(listsActivity.getLayoutInflater().inflate(R.layout.lists_item, viewGroup, false));
                                    LinearLayout linearLayout = (LinearLayout) dVarC.f1641b;
                                    TextView textView = (TextView) dVarC.g;
                                    TextView textView2 = (TextView) dVarC.h;
                                    textView2.setTypeface(o4.b.f11719r);
                                    textView2.setText(uVar.f8751b);
                                    Iterator it5 = uVar.f8752c.iterator();
                                    int i22 = 0;
                                    ?? r82 = viewGroup;
                                    while (it5.hasNext()) {
                                        int i23 = i22 + 1;
                                        String str5 = (String) it5.next();
                                        if (i22 == 0) {
                                            ?? E = j4.y.d().e(str5);
                                            E.f(R.drawable.shape_bg_placeholder);
                                            float f12 = UptodownApp.E;
                                            E.g(k4.c.y(listsActivity));
                                            E.e((ImageView) dVarC.f1642c, r82);
                                        } else if (str5.length() > 0) {
                                            listsActivity.n0(str5, (LinearLayout) dVarC.f1643d, i22);
                                        }
                                        i22 = i23;
                                        r82 = 0;
                                    }
                                    listsActivity.p0().f10712l = true;
                                    textView.setText(listsActivity.q0(uVar.f8753d));
                                    textView.setTypeface(o4.b.f11720s);
                                    ((RelativeLayout) dVarC.f).setVisibility(0);
                                    ((ProgressBar) dVarC.e).setVisibility(8);
                                    listsActivity.o0().f.setVisibility(8);
                                    linearLayout.setOnClickListener(new b5.a(23, uVar, listsActivity));
                                    listsActivity.o0().f7392b.addView(linearLayout);
                                    viewGroup = null;
                                }
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
