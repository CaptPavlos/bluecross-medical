package androidx.room;

import a3.s;
import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.a4;
import g7.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import s6.w;
import t6.m;
import t6.n;
import t6.r;
import t6.t;
import u6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Match {
        private final List<Integer> resultIndices;
        private final l7.d resultRange;

        public Match(l7.d dVar, List<Integer> list) {
            dVar.getClass();
            list.getClass();
            this.resultRange = dVar;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final l7.d getResultRange() {
            return this.resultRange;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i10) {
            str.getClass();
            this.name = str;
            this.index = i10;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i11 & 2) != 0) {
                i10 = resultColumn.index;
            }
            return resultColumn.copy(str, i10);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i10) {
            str.getClass();
            return new ResultColumn(str, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return l.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ResultColumn(name=");
            sb.append(this.name);
            sb.append(", index=");
            return a3.a.k(sb, this.index, ')');
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i10, g7.l lVar) {
        if (i10 == list.size()) {
            lVar.invoke(t6.l.r0(list2));
            return;
        }
        Iterator<T> it = list.get(i10).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i10 + 1, lVar);
            list2.remove(list2.size() - 1);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i10, g7.l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i10, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, q qVar) {
        int i10 = 0;
        int iHashCode = 0;
        for (String str : strArr) {
            iHashCode += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                qVar.invoke(Integer.valueOf(i10), Integer.valueOf(length), list.subList(i10, length));
            }
            int i11 = i10 + 1;
            int i12 = length + 1;
            if (i12 > list.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - list.get(i10).getName().hashCode()) + list.get(length).getName().hashCode();
            i10 = i11;
            length = i12;
        }
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        int length = strArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            String strSubstring = strArr[i11];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            strArr[i11] = lowerCase;
        }
        int length2 = strArr2.length;
        for (int i12 = 0; i12 < length2; i12++) {
            int length3 = strArr2[i12].length;
            for (int i13 = 0; i13 < length3; i13++) {
                String[] strArr3 = strArr2[i12];
                String lowerCase2 = strArr3[i13].toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                strArr3[i13] = lowerCase2;
            }
        }
        i iVar = new i();
        for (String[] strArr4 : strArr2) {
            r.Y(iVar, strArr4);
        }
        i iVarO = l1.b.o(iVar);
        u6.c cVarL = a4.l();
        int length4 = strArr.length;
        int i14 = 0;
        int i15 = 0;
        while (i14 < length4) {
            String str = strArr[i14];
            int i16 = i15 + 1;
            if (iVarO.f12969a.containsKey(str)) {
                cVarL.add(new ResultColumn(str, i15));
            }
            i14++;
            i15 = i16;
        }
        u6.c cVarH = a4.h(cVarL);
        int length5 = strArr2.length;
        final ArrayList arrayList = new ArrayList(length5);
        for (int i17 = 0; i17 < length5; i17++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr2.length;
        int i18 = 0;
        final int i19 = 0;
        while (i18 < length6) {
            final String[] strArr5 = strArr2[i18];
            int i20 = i19 + 1;
            INSTANCE.rabinKarpSearch(cVarH, strArr5, new q() { // from class: androidx.room.a
                @Override // g7.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AmbiguousColumnResolver.resolve$lambda$16$lambda$7(strArr5, arrayList, i19, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (List) obj3);
                }
            });
            if (((List) arrayList.get(i19)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr5.length);
                int length7 = strArr5.length;
                int i21 = i10;
                while (i21 < length7) {
                    String str2 = strArr5[i21];
                    u6.c cVarL2 = a4.l();
                    ListIterator listIterator = cVarH.listIterator(i10);
                    while (true) {
                        u6.a aVar = (u6.a) listIterator;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (l.a(str2, resultColumn.getName())) {
                            cVarL2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    u6.c cVarH2 = a4.h(cVarL2);
                    if (cVarH2.isEmpty()) {
                        throw new IllegalStateException(androidx.constraintlayout.core.widgets.analyzer.a.x("Column ", str2, " not found in result").toString());
                    }
                    arrayList2.add(cVarH2);
                    i21++;
                    i10 = 0;
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new androidx.work.impl.model.c(arrayList, i19, 4), 6, null);
            }
            i18++;
            i19 = i20;
            i10 = 0;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i22 = 0;
            while (i22 < size) {
                Object obj = arrayList.get(i22);
                i22++;
                if (((List) obj).isEmpty()) {
                    androidx.window.layout.c.g("Failed to find matches for all mappings");
                    return null;
                }
            }
        }
        x xVar = new x();
        xVar.f10138a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new s(xVar, 1), 6, null);
        List<Match> matches = ((Solution) xVar.f10138a).getMatches();
        ArrayList arrayList3 = new ArrayList(n.V(matches, 10));
        Iterator<T> it = matches.iterator();
        while (it.hasNext()) {
            arrayList3.add(t6.l.q0(((Match) it.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w resolve$lambda$16$lambda$15(List list, int i10, List list2) {
        list2.getClass();
        List list3 = list2;
        Iterator it = list3.iterator();
        if (!it.hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        int iIntValue = ((Number) it.next()).intValue();
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            if (iIntValue > iIntValue2) {
                iIntValue = iIntValue2;
            }
        }
        Iterator it2 = list3.iterator();
        if (!it2.hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        int iIntValue3 = ((Number) it2.next()).intValue();
        while (it2.hasNext()) {
            int iIntValue4 = ((Number) it2.next()).intValue();
            if (iIntValue3 < iIntValue4) {
                iIntValue3 = iIntValue4;
            }
        }
        ((List) list.get(i10)).add(new Match(new l7.d(iIntValue, iIntValue3, 1), list2));
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w resolve$lambda$16$lambda$7(String[] strArr, List list, int i10, int i11, int i12, List list2) {
        Object next;
        list2.getClass();
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i13 = 0;
        while (true) {
            w wVar = w.f12711a;
            if (i13 >= length) {
                ((List) list.get(i10)).add(new Match(new l7.d(i11, i12 - 1, 1), arrayList));
                return wVar;
            }
            String str = strArr[i13];
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (l.a(str, ((ResultColumn) next).component1())) {
                    break;
                }
            }
            ResultColumn resultColumn = (ResultColumn) next;
            if (resultColumn == null) {
                return wVar;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
            i13++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w resolve$lambda$19(x xVar, List list) {
        list.getClass();
        Solution solutionBuild = Solution.Companion.build(list);
        if (solutionBuild.compareTo((Solution) xVar.f10138a) < 0) {
            xVar.f10138a = solutionBuild;
        }
        return w.f12711a;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(t.f12808a, Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public Solution(List<Match> list, int i10, int i11) {
            list.getClass();
            this.matches = list;
            this.coverageOffset = i10;
            this.overlaps = i11;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution solution) {
            solution.getClass();
            int iC = l.c(this.overlaps, solution.overlaps);
            return iC != 0 ? iC : l.c(this.coverageOffset, solution.coverageOffset);
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final Solution build(List<Match> list) {
                list.getClass();
                List<Match> list2 = list;
                int i10 = 0;
                int size = 0;
                for (Match match : list2) {
                    size += ((match.getResultRange().f11085b - match.getResultRange().f11084a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list2.iterator();
                if (!it.hasNext()) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                int i11 = ((Match) it.next()).getResultRange().f11084a;
                while (it.hasNext()) {
                    int i12 = ((Match) it.next()).getResultRange().f11084a;
                    if (i11 > i12) {
                        i11 = i12;
                    }
                }
                Iterator<T> it2 = list2.iterator();
                if (!it2.hasNext()) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                int i13 = ((Match) it2.next()).getResultRange().f11085b;
                while (it2.hasNext()) {
                    int i14 = ((Match) it2.next()).getResultRange().f11085b;
                    if (i13 < i14) {
                        i13 = i14;
                    }
                }
                Iterable dVar = new l7.d(i11, i13, 1);
                if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                    Iterator it3 = dVar.iterator();
                    int i15 = 0;
                    while (((l7.c) it3).f11089c) {
                        int iNextInt = ((t6.x) it3).nextInt();
                        Iterator<T> it4 = list2.iterator();
                        int i16 = 0;
                        while (true) {
                            if (it4.hasNext()) {
                                l7.d resultRange = ((Match) it4.next()).getResultRange();
                                if (resultRange.f11084a <= iNextInt && iNextInt <= resultRange.f11085b) {
                                    i16++;
                                }
                                if (i16 > 1) {
                                    i15++;
                                    if (i15 < 0) {
                                        m.T();
                                        throw null;
                                    }
                                }
                            }
                        }
                    }
                    i10 = i15;
                }
                return new Solution(list, size, i10);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }
    }

    public static final int[][] resolve(List<String> list, String[][] strArr) {
        list.getClass();
        strArr.getClass();
        return resolve((String[]) list.toArray(new String[0]), strArr);
    }
}
