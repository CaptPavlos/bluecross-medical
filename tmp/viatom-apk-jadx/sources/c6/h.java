package c6;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import b9.s;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import f6.o;
import java.util.ArrayList;
import java.util.Iterator;
import t6.j;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m8.a f1809a;

    /* renamed from: b, reason: collision with root package name */
    public final a4.f f1810b;

    /* renamed from: c, reason: collision with root package name */
    public final ChoiceCmpCallback f1811c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1812d = 2;

    public h(m8.a aVar, a4.f fVar, ChoiceCmpCallback choiceCmpCallback) {
        this.f1809a = aVar;
        this.f1810b = fVar;
        this.f1811c = choiceCmpCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Iterable, java.lang.Object] */
    public final LiveData a() {
        if (j.g.f9878a) {
            a4.f fVar = this.f1810b;
            fVar.getClass();
            if (j.g.f9878a) {
                Vector vector = j.g.f9879b;
                vector.setAllOwnedItems();
                d0.i iVar = (d0.i) fVar.f218b;
                Vector vectorV = iVar.v(40);
                if (vectorV != null) {
                    vectorV.forEach(new o(2, vector));
                }
                iVar.n(40, vector);
                ChoiceCmpCallback choiceCmpCallback = (ChoiceCmpCallback) fVar.f219c;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onGoogleBasicConsentChange(j.g.a());
                }
            }
        }
        g gVar = new g(this, 0);
        m8.a aVar = this.f1809a;
        aVar.getClass();
        r rVar = m8.e.g;
        if (rVar != 0) {
            ?? r12 = aVar.f11239d;
            if (r12 != 0) {
                m6.a aVar2 = new m6.a(gVar, 1);
                for (m8.b bVar : r12) {
                    bVar.f11242c = Boolean.FALSE;
                    ?? r52 = bVar.f;
                    if (r52 != 0) {
                        Iterator it = r52.iterator();
                        while (it.hasNext()) {
                            ((m8.c) it.next()).f11247d = Boolean.FALSE;
                        }
                    }
                }
                rVar.k(r12, true, new m6.a(aVar2, 3));
            }
        } else {
            d6.b.b(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
            gVar.invoke(null);
        }
        return s.b(6, 1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList b(int[] iArr) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        ?? r12 = this.f1809a.f11239d;
        if (r12 == 0) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : r12) {
                if (j.f0(iArr, ((m8.b) obj).f11240a.intValue())) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                m8.b bVar = (m8.b) obj2;
                Integer num = bVar.f11240a;
                n6.a aVar = bVar.f11243d;
                int iIntValue = num.intValue();
                String str = aVar.f11561c;
                k8.d dVar = new k8.d(iIntValue, str == null ? "" : str);
                Boolean bool = bVar.f11242c;
                boolean z9 = bVar.g;
                arrayList2.add(new c.h(dVar, bool, z9 ? 4 : 1, 11, (!z9 || str == null) ? "" : str, null, 80));
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    public final void c() {
        ?? r02 = this.f1809a.f11239d;
        if (r02 == 0) {
            return;
        }
        g gVar = new g(this, 1);
        r rVar = m8.e.g;
        if (rVar != 0) {
            rVar.k(r02, true, new m6.a(gVar));
        } else {
            d6.b.b(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
            gVar.invoke(null);
        }
    }
}
