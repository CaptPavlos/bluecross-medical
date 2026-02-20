package t6;

import androidx.graphics.shapes.MeasuredPolygon;
import com.google.android.gms.internal.measurement.a4;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class l extends r {
    public static boolean a0(Iterable iterable, Object obj) {
        int iIndexOf;
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i10 < 0) {
                    m.U();
                    throw null;
                }
                if (kotlin.jvm.internal.l.a(obj, next)) {
                    iIndexOf = i10;
                    break;
                }
                i10++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static Object b0(Iterable iterable, int i10) {
        iterable.getClass();
        boolean z9 = iterable instanceof List;
        if (z9) {
            return ((List) iterable).get(i10);
        }
        androidx.room.support.b bVar = new androidx.room.support.b(i10, 5);
        if (z9) {
            List list = (List) iterable;
            if (i10 >= 0 && i10 < list.size()) {
                return list.get(i10);
            }
            bVar.invoke(Integer.valueOf(i10));
            throw null;
        }
        if (i10 < 0) {
            bVar.invoke(Integer.valueOf(i10));
            throw null;
        }
        int i11 = 0;
        for (Object obj : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return obj;
            }
            i11 = i12;
        }
        bVar.invoke(Integer.valueOf(i10));
        throw null;
    }

    public static Object c0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        com.google.gson.internal.a.o("List is empty.");
        return null;
    }

    public static Object d0(MeasuredPolygon measuredPolygon, int i10) {
        measuredPolygon.getClass();
        if (i10 < 0 || i10 >= measuredPolygon.size()) {
            return null;
        }
        return measuredPolygon.get(i10);
    }

    public static int e0(List list, Object obj) {
        list.getClass();
        return list.indexOf(obj);
    }

    public static final void f0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, g7.l lVar) {
        iterable.getClass();
        sb.append(charSequence2);
        int i10 = 0;
        for (Object obj : iterable) {
            i10++;
            if (i10 > 1) {
                sb.append(charSequence);
            }
            a4.g(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String h0(Iterable iterable, String str, String str2, String str3, g7.l lVar, int i10) {
        if ((i10 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i10 & 2) != 0 ? "" : str2;
        String str6 = (i10 & 4) != 0 ? "" : str3;
        if ((i10 & 32) != 0) {
            lVar = null;
        }
        iterable.getClass();
        StringBuilder sb = new StringBuilder();
        f0(iterable, sb, str4, str5, str6, "...", lVar);
        return sb.toString();
    }

    public static Object i0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return a3.a.e(1, list);
        }
        com.google.gson.internal.a.o("List is empty.");
        return null;
    }

    public static Object j0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return a3.a.e(1, list);
    }

    public static Comparable k0(Iterable iterable) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList l0(Iterable iterable, Collection collection) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            r.X(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List m0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listS0 = s0(iterable);
            if (((ArrayList) listS0).size() > 1) {
                Collections.sort(listS0);
            }
            return listS0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return r0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List n0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listS0 = s0(iterable);
            q.W(listS0, comparator);
            return listS0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return r0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List o0(ArrayList arrayList, int i10) {
        if (i10 < 0) {
            z8.f.b(a3.a.g(i10, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i10 == 0) {
            return t.f12808a;
        }
        if (i10 >= arrayList.size()) {
            return r0(arrayList);
        }
        if (i10 == 1) {
            return a4.u(c0(arrayList));
        }
        ArrayList arrayList2 = new ArrayList(i10);
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            arrayList2.add(obj);
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return m.S(arrayList2);
    }

    public static final void p0(Iterable iterable, AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] q0(Collection collection) {
        collection.getClass();
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Number) it.next()).intValue();
            i10++;
        }
        return iArr;
    }

    public static List r0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return m.S(s0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return t.f12808a;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return a4.u(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List s0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        p0(iterable, arrayList);
        return arrayList;
    }

    public static Set t0(Collection collection) {
        collection.getClass();
        if (collection instanceof Collection) {
            return new LinkedHashSet(collection);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        p0(collection, linkedHashSet);
        return linkedHashSet;
    }

    public static Set u0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(collection.size()));
                    p0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                setSingleton.getClass();
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            p0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                setSingleton2.getClass();
                return setSingleton2;
            }
        }
        return v.f12810a;
    }
}
