package l4;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q4 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f10757a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f10758b;

    /* renamed from: c, reason: collision with root package name */
    public final u7.m0 f10759c;

    /* renamed from: d, reason: collision with root package name */
    public final u7.m0 f10760d;
    public String e;
    public final u7.m0 f;
    public boolean g;

    public q4() {
        u7.m0 m0VarA = u7.i0.a(v5.j.f13166a);
        this.f10757a = m0VarA;
        this.f10758b = m0VarA;
        this.f10759c = u7.i0.a(new ArrayList());
        this.f10760d = u7.i0.a(new ArrayList());
        this.f = u7.i0.a(1);
    }

    public static final ArrayList a(q4 q4Var, ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            h5.q qVar = (h5.q) obj;
            String str2 = qVar.f8709n;
            boolean zD0 = true;
            if (str2 == null || str2.length() == 0) {
                String str3 = qVar.f8701b;
                if (str3 != null && str3.length() != 0) {
                    String str4 = qVar.f8701b;
                    str4.getClass();
                    zD0 = o7.m.d0(str4, str != null ? str : "", true);
                }
            } else {
                String str5 = qVar.f8709n;
                str5.getClass();
                zD0 = o7.m.d0(str5, str != null ? str : "", true);
            }
            if (zD0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final void b(q4 q4Var, ArrayList arrayList, p4 p4Var) {
        int iOrdinal = p4Var.ordinal();
        if (iOrdinal == 0) {
            if (arrayList.size() > 1) {
                t6.q.W(arrayList, new a9.i(8));
            }
        } else if (iOrdinal == 1) {
            if (arrayList.size() > 1) {
                t6.q.W(arrayList, new a9.i(7));
            }
        } else if (iOrdinal != 2) {
            androidx.window.layout.c.b();
        } else if (arrayList.size() > 1) {
            t6.q.W(arrayList, new a9.i(9));
        }
    }
}
