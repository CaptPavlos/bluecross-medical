package l4;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c4 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f10285a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f10286b;

    /* renamed from: c, reason: collision with root package name */
    public final u7.m0 f10287c;

    /* renamed from: d, reason: collision with root package name */
    public String f10288d;
    public final u7.m0 e;

    public c4() {
        u7.m0 m0VarA = u7.i0.a(v5.j.f13166a);
        this.f10285a = m0VarA;
        this.f10286b = m0VarA;
        this.f10287c = u7.i0.a(Boolean.FALSE);
        this.e = u7.i0.a(0);
    }

    public static final ArrayList a(c4 c4Var, ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            h5.f fVar = (h5.f) obj;
            String str2 = fVar.f8525b;
            boolean zD0 = true;
            if (str2 == null || str2.length() == 0) {
                String str3 = fVar.f8526c;
                if (str3 != null && str3.length() != 0) {
                    String str4 = fVar.f8526c;
                    str4.getClass();
                    zD0 = o7.m.d0(str4, str, true);
                }
            } else {
                String str5 = fVar.f8525b;
                str5.getClass();
                zD0 = o7.m.d0(str5, str, true);
            }
            if (zD0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
