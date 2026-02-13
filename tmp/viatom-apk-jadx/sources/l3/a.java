package l3;

import com.google.android.gms.internal.measurement.u6;
import java.util.List;
import m3.g;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10202a = new a();

    public static void a(String str, List list, p3.a aVar) {
        int length = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str2 = (String) list.get(i10);
            if (!aVar.f11878a.containsKey(str2)) {
                throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Field not found: '", str2, "'"));
            }
            m3.a aVar2 = (m3.a) aVar.f11878a.get(str2);
            try {
                String strC = aVar2.c(length, str);
                aVar2.a(strC);
                length += strC.length();
            } catch (g e) {
                if (aVar2.f11176a) {
                    u.l(a3.a.i("Unable to decode ", str2), e);
                    return;
                }
                return;
            } catch (Exception e3) {
                u.l(a3.a.i("Unable to decode ", str2), e3);
                return;
            }
        }
    }

    public static String b(p3.a aVar, List list) {
        String strConcat = "";
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = (String) list.get(i10);
            if (!aVar.f11878a.containsKey(str)) {
                throw new u6(androidx.constraintlayout.core.widgets.analyzer.a.x("Field not found: '", str, "'"));
            }
            strConcat = strConcat.concat(((m3.a) aVar.f11878a.get(str)).b());
        }
        return strConcat;
    }
}
