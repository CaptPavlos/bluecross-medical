package m8;

import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.l;
import o8.i;
import t6.j;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f11249a = {1, 2, 3, 4};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f11250b = {5};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f11251c = {6};

    /* renamed from: d, reason: collision with root package name */
    public static boolean f11252d = false;
    public static i e = null;
    public static d0.i f = null;
    public static r g = null;
    public static int h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f11253i = false;

    /* renamed from: j, reason: collision with root package name */
    public static int f11254j = 1;

    public static int a(int i10, List list) {
        return (list.hashCode() + i10) * 31;
    }

    public static int b(String str) {
        str.getClass();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        switch (lowerCase.hashCode()) {
            case 3166:
                return !lowerCase.equals(DownloadCommon.DOWNLOAD_REPORT_CANCEL) ? 16 : 1;
            case 3180:
                return !lowerCase.equals("co") ? 16 : 2;
            case 3185:
                return !lowerCase.equals("ct") ? 16 : 3;
            case 3201:
                return !lowerCase.equals(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR) ? 16 : 10;
            case 3270:
                return !lowerCase.equals("fl") ? 16 : 6;
            case 3352:
                return !lowerCase.equals("ia") ? 16 : 11;
            case 3495:
                return !lowerCase.equals("mt") ? 16 : 7;
            case 3511:
                return !lowerCase.equals("ne") ? 16 : 12;
            case 3514:
                return !lowerCase.equals("nh") ? 16 : 13;
            case 3516:
                return !lowerCase.equals("nj") ? 16 : 14;
            case 3555:
                return !lowerCase.equals("or") ? 16 : 8;
            case 3706:
                return !lowerCase.equals("tn") ? 16 : 15;
            case 3716:
                return !lowerCase.equals("tx") ? 16 : 9;
            case 3743:
                return !lowerCase.equals("ut") ? 16 : 4;
            case 3755:
                return !lowerCase.equals("va") ? 16 : 5;
            default:
                return 16;
        }
    }

    public static d0.i c() {
        d0.i iVar = f;
        if (iVar != null) {
            return iVar;
        }
        l.i("sharedStorage");
        throw null;
    }

    public static String d(int i10) {
        if (i10 == 0) {
            throw null;
        }
        switch (c.i.c(i10)) {
            case 0:
                return DownloadCommon.DOWNLOAD_REPORT_CANCEL;
            case 1:
                return "co";
            case 2:
                return "ct";
            case 3:
                return "ut";
            case 4:
                return "va";
            case 5:
                return "fl";
            case 6:
                return "mt";
            case 7:
                return "or";
            case 8:
                return "tx";
            case 9:
                return DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR;
            case 10:
                return "ia";
            case 11:
                return "ne";
            case 12:
                return "nh";
            case 13:
                return "nj";
            case 14:
                return "tn";
            default:
                return "";
        }
    }

    public static LinkedHashMap e(Vector vector) {
        vector.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        vector.forEach(new j.e(linkedHashMap, 1));
        return linkedHashMap;
    }

    public static LinkedHashMap f(Vector vector, Set set) {
        LinkedHashMap linkedHashMap;
        vector.getClass();
        if (set == null) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                linkedHashMap2.put(String.valueOf(iIntValue), Boolean.valueOf(vector.contains(iIntValue)));
            }
            linkedHashMap = linkedHashMap2;
        }
        if (linkedHashMap != null) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        vector.forEach(new j.e(linkedHashMap3, 1));
        return linkedHashMap3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.List] */
    public static void g(a aVar) {
        if (f11252d) {
            return;
        }
        i(aVar);
        ?? r42 = aVar.f11239d;
        if (r42 == 0) {
            return;
        }
        boolean z9 = f11252d;
        r rVar = g;
        d dVar = d.f11248a;
        if (rVar != 0) {
            rVar.k(r42, z9, new m6.a(dVar));
        } else {
            d6.b.b(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
            dVar.invoke(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int h() {
        /*
            int r0 = m8.e.h
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.String r0 = i9.a.f9113m
            int r0 = b(r0)
            o8.i r1 = m8.e.e
            r2 = 0
            java.lang.String r3 = "portalConfig"
            if (r1 == 0) goto L81
            o8.c r1 = r1.f11814b
            java.lang.String r1 = r1.J
            java.lang.String r4 = "NATIONAL"
            boolean r1 = kotlin.jvm.internal.l.a(r1, r4)
            r4 = 16
            if (r1 != 0) goto L7d
            o8.i r1 = m8.e.e
            if (r1 == 0) goto L79
            o8.c r1 = r1.f11814b
            boolean r1 = r1.K
            if (r1 == 0) goto L31
            boolean r1 = j()
            if (r1 == 0) goto L31
            goto L7d
        L31:
            o8.i r1 = m8.e.e
            if (r1 == 0) goto L75
            o8.c r1 = r1.f11814b
            boolean r1 = r1.K
            if (r1 == 0) goto L44
            if (r0 == r4) goto L44
            boolean r1 = j()
            if (r1 != 0) goto L44
            goto L7e
        L44:
            o8.i r1 = m8.e.e
            if (r1 == 0) goto L71
            o8.c r1 = r1.f11814b
            boolean r1 = r1.K
            if (r1 != 0) goto L7e
            if (r0 != r4) goto L7e
            d0.i r1 = c()
            r2 = 69
            java.lang.String r1 = r1.t(r2)
            java.lang.String r2 = "STATE_AND_NATIONAL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7e
            d0.i r0 = c()
            r1 = 70
            java.lang.String r0 = r0.t(r1)
            int r0 = b(r0)
            goto L7e
        L71:
            kotlin.jvm.internal.l.i(r3)
            throw r2
        L75:
            kotlin.jvm.internal.l.i(r3)
            throw r2
        L79:
            kotlin.jvm.internal.l.i(r3)
            throw r2
        L7d:
            r0 = r4
        L7e:
            m8.e.h = r0
            return r0
        L81:
            kotlin.jvm.internal.l.i(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.e.h():int");
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.lang.Iterable, java.lang.Object] */
    public static void i(a aVar) {
        r aVar2;
        ?? r6;
        Object next;
        ?? r62;
        ?? r22;
        aVar.getClass();
        if (f11253i) {
            return;
        }
        if ((j() && f11254j == 1) || (c().t(69).equals("STATE_AND_NATIONAL") && f11254j == 2 && b(c().t(70)) == h())) {
            Vector vectorV = c().v(71);
            if (vectorV != null && (r22 = aVar.f11239d) != 0) {
                for (b bVar : r22) {
                    int iIntValue = bVar.f11240a.intValue();
                    if (vectorV.contains(iIntValue)) {
                        bVar.f11242c = vectorV.get(iIntValue);
                    }
                }
            }
            Vector vectorV2 = c().v(72);
            if (vectorV2 != null && (r6 = aVar.f11239d) != 0) {
                Iterator it = r6.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((b) next).f11240a.intValue() == j.u0(f11250b)) {
                        break;
                    }
                }
                b bVar2 = (b) next;
                if (bVar2 != null && (r62 = bVar2.f) != 0) {
                    for (c cVar : r62) {
                        int iIntValue2 = cVar.f11245b.intValue();
                        if (vectorV2.contains(iIntValue2)) {
                            cVar.f11247d = vectorV2.get(iIntValue2);
                        }
                    }
                }
            }
        }
        switch (c.i.c(h())) {
            case 0:
                aVar2 = new n8.a(0);
                break;
            case 1:
                aVar2 = new n8.a(1);
                break;
            case 2:
                aVar2 = new n8.a(2);
                break;
            case 3:
                aVar2 = new n8.a(13);
                break;
            case 4:
                aVar2 = new n8.a(14);
                break;
            case 5:
                aVar2 = new n8.a(4);
                break;
            case 6:
                aVar2 = new n8.a(6);
                break;
            case 7:
                aVar2 = new n8.a(10);
                break;
            case 8:
                aVar2 = new n8.a(12);
                break;
            case 9:
                aVar2 = new n8.a(3);
                break;
            case 10:
                aVar2 = new n8.a(5);
                break;
            case 11:
                aVar2 = new n8.a(7);
                break;
            case 12:
                aVar2 = new n8.a(8);
                break;
            case 13:
                aVar2 = new n8.a(9);
                break;
            case 14:
                aVar2 = new n8.a(11);
                break;
            default:
                aVar2 = new r(21);
                break;
        }
        g = aVar2;
        f11253i = true;
    }

    public static boolean j() {
        return c().t(69).equals("NATIONAL");
    }
}
