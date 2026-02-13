package e5;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y1 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7910a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2 f7911b;

    public /* synthetic */ y1(b2 b2Var, int i10) {
        this.f7910a = i10;
        this.f7911b = b2Var;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10 = this.f7910a;
        s6.w wVar = s6.w.f12711a;
        b2 b2Var = this.f7911b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!(mVar instanceof v5.j)) {
                    if (mVar instanceof v5.l) {
                        if (((Boolean) ((v5.l) mVar).f13168a).booleanValue()) {
                            b2Var.a().f7405b.setImageDrawable(ContextCompat.getDrawable(b2Var.requireContext(), R.drawable.vector_favorite_remove));
                            if ((b2Var.getActivity() instanceof l4.w) && b2Var.d().h) {
                                FragmentActivity activity = b2Var.getActivity();
                                activity.getClass();
                                String string = b2Var.getString(R.string.category_added_to_favorites, b2Var.f7688c.f8633b);
                                string.getClass();
                                ((l4.w) activity).C(string);
                            }
                        } else {
                            b2Var.a().f7405b.setImageDrawable(ContextCompat.getDrawable(b2Var.requireContext(), R.drawable.vector_favorite_add));
                            if ((b2Var.getActivity() instanceof l4.w) && b2Var.d().h) {
                                FragmentActivity activity2 = b2Var.getActivity();
                                activity2.getClass();
                                String string2 = b2Var.getString(R.string.category_removed_from_favorites, b2Var.f7688c.f8633b);
                                string2.getClass();
                                ((l4.w) activity2).C(string2);
                            }
                        }
                        if (!b2Var.d().h) {
                            b2Var.d().h = true;
                        }
                    } else if (!(mVar instanceof v5.k)) {
                        androidx.window.layout.c.b();
                        return null;
                    }
                }
                return wVar;
            default:
                v5.m mVar2 = (v5.m) obj;
                if (mVar2 instanceof v5.j) {
                    b2Var.a().f7407d.setVisibility(0);
                } else if (mVar2 instanceof v5.l) {
                    c2 c2Var = (c2) ((v5.l) mVar2).f13168a;
                    boolean z9 = c2Var.f7716b;
                    h5.x0 x0Var = c2Var.f7715a;
                    if (!z9) {
                        n4.p0 p0Var = b2Var.e;
                        if (p0Var != null) {
                            ArrayList arrayList = x0Var.f8789b;
                            int i11 = b2Var.f7688c.f8632a;
                            boolean z10 = (i11 == -3 || i11 == -2) ? false : true;
                            arrayList.getClass();
                            int size = p0Var.f11458k.size();
                            Iterator it = arrayList.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                n4.n0 n0Var = new n4.n0();
                                n0Var.f11441a = (h5.h) next;
                                n0Var.f11442b = 0;
                                if (z10) {
                                    int i12 = p0Var.f11459l + 1;
                                    p0Var.f11459l = i12;
                                    n0Var.f11443c = i12;
                                } else {
                                    n0Var.f11443c = 0;
                                }
                                p0Var.f11458k.add(n0Var);
                            }
                            p0Var.notifyItemRangeInserted(size, p0Var.f11458k.size());
                        }
                    } else if (x0Var.f8789b.isEmpty()) {
                        b2Var.a().e.setVisibility(8);
                        b2Var.a().g.setVisibility(0);
                        b2Var.a().h.setVisibility(0);
                    } else {
                        if (b2Var.getActivity() != null && !b2Var.requireActivity().isFinishing()) {
                            String str = x0Var.f8788a.f8633b;
                            if (str == null || str.length() == 0) {
                                b2Var.f7689d = b2Var.getResources().getString(R.string.top_downloads_title);
                            } else {
                                b2Var.f7689d = x0Var.f8788a.f8633b;
                            }
                            b2Var.a().f7408i.setText(b2Var.f7689d);
                            w1 w1Var = b2Var.f;
                            v1 v1Var = b2Var.h;
                            v1 v1Var2 = b2Var.f7690i;
                            w1 w1Var2 = b2Var.g;
                            h5.k kVar = x0Var.f8788a;
                            b2Var.e = new n4.p0(w1Var, v1Var, v1Var2, w1Var2, kVar.f8634c, x0Var.f8791d, x0Var.e, kVar.f8633b, b2Var.d().g, new v1(b2Var));
                            boolean z11 = x0Var.f8791d != null;
                            b2Var.a().e.addItemDecoration(new x5.k(b2Var.d().g, z11));
                            n4.p0 p0Var2 = b2Var.e;
                            if (p0Var2 != null) {
                                p0Var2.a(x0Var);
                            }
                            b2Var.a().e.setAdapter(b2Var.e);
                            if (z11) {
                                h5.w0 w0Var = x0Var.f8791d;
                                w0Var.getClass();
                                if (w0Var.g != null) {
                                    b2Var.a().f7406c.setVisibility(0);
                                    b2Var.a().f7406c.setOnClickListener(new b5.a(17, x0Var, b2Var));
                                }
                            }
                        }
                        b2Var.a().e.setVisibility(0);
                        b2Var.a().g.setVisibility(8);
                        b2Var.a().h.setVisibility(8);
                    }
                    b2Var.d().e = false;
                    b2Var.a().f7407d.setVisibility(8);
                } else if (!(mVar2 instanceof v5.k)) {
                    androidx.window.layout.c.b();
                    return null;
                }
                return wVar;
        }
    }
}
