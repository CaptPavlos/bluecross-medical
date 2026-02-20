package j3;

import com.google.android.gms.internal.measurement.u6;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import p3.d;
import q3.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f9911a;

    /* renamed from: b, reason: collision with root package name */
    public String f9912b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9913c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9914d;

    public static HashMap a(String str) {
        int i10 = 0;
        int i11 = 1;
        if (str != null && !str.isEmpty() && !str.startsWith("DB")) {
            if (!str.startsWith("C")) {
                throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode '", str, "'"));
            }
            HashMap map = new HashMap();
            q3.a aVar = new q3.a(str);
            map.put("tcfeuv2", aVar);
            q3.a aVar2 = new q3.a(i10);
            List list = d.f11880a;
            aVar2.g("SectionIds", Arrays.asList(2));
            map.put("header", aVar);
            return map;
        }
        HashMap map2 = new HashMap();
        if (str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split("~");
            String str2 = strArrSplit[0];
            q3.a aVar3 = new q3.a(i10);
            aVar3.a(str2);
            map2.put("header", aVar3);
            List list2 = (List) aVar3.d("SectionIds");
            while (i10 < list2.size()) {
                if (((Integer) list2.get(i10)).equals(2)) {
                    map2.put("tcfeuv2", new q3.a(strArrSplit[i10 + 1]));
                } else {
                    int i12 = 5;
                    if (((Integer) list2.get(i10)).equals(5)) {
                        String str3 = strArrSplit[i10 + 1];
                        q3.a aVar4 = new q3.a(i11);
                        aVar4.a(str3);
                        map2.put("tcfcav1", aVar4);
                    } else {
                        int i13 = 6;
                        int i14 = 19;
                        if (((Integer) list2.get(i10)).equals(6)) {
                            String str4 = strArrSplit[i10 + 1];
                            q3.a aVar5 = new q3.a(i14);
                            aVar5.a(str4);
                            map2.put("uspv1", aVar5);
                        } else {
                            int i15 = 8;
                            if (((Integer) list2.get(i10)).equals(8)) {
                                String str5 = strArrSplit[i10 + 1];
                                q3.a aVar6 = new q3.a(3);
                                aVar6.a(str5);
                                map2.put("usca", aVar6);
                            } else {
                                int i16 = 7;
                                int i17 = 10;
                                if (((Integer) list2.get(i10)).equals(7)) {
                                    String str6 = strArrSplit[i10 + 1];
                                    q3.a aVar7 = new q3.a(i17);
                                    aVar7.a(str6);
                                    map2.put("usnat", aVar7);
                                } else {
                                    int i18 = 9;
                                    int i19 = 18;
                                    if (((Integer) list2.get(i10)).equals(9)) {
                                        String str7 = strArrSplit[i10 + 1];
                                        q3.a aVar8 = new q3.a(i19);
                                        aVar8.a(str7);
                                        map2.put("usva", aVar8);
                                    } else if (((Integer) list2.get(i10)).equals(10)) {
                                        String str8 = strArrSplit[i10 + 1];
                                        q3.a aVar9 = new q3.a(4);
                                        aVar9.a(str8);
                                        map2.put("usco", aVar9);
                                    } else {
                                        int i20 = 11;
                                        int i21 = 17;
                                        if (((Integer) list2.get(i10)).equals(11)) {
                                            String str9 = strArrSplit[i10 + 1];
                                            q3.a aVar10 = new q3.a(i21);
                                            aVar10.a(str9);
                                            map2.put("usut", aVar10);
                                        } else {
                                            int i22 = 12;
                                            if (((Integer) list2.get(i10)).equals(12)) {
                                                String str10 = strArrSplit[i10 + 1];
                                                q3.a aVar11 = new q3.a(i12);
                                                aVar11.a(str10);
                                                map2.put("usct", aVar11);
                                            } else {
                                                int i23 = 13;
                                                if (((Integer) list2.get(i10)).equals(13)) {
                                                    String str11 = strArrSplit[i10 + 1];
                                                    q3.a aVar12 = new q3.a(i16);
                                                    aVar12.a(str11);
                                                    map2.put("usfl", aVar12);
                                                } else {
                                                    int i24 = 14;
                                                    if (((Integer) list2.get(i10)).equals(14)) {
                                                        String str12 = strArrSplit[i10 + 1];
                                                        q3.a aVar13 = new q3.a(i18);
                                                        aVar13.a(str12);
                                                        map2.put("usmt", aVar13);
                                                    } else {
                                                        int i25 = 15;
                                                        if (((Integer) list2.get(i10)).equals(15)) {
                                                            String str13 = strArrSplit[i10 + 1];
                                                            q3.a aVar14 = new q3.a(i24);
                                                            aVar14.a(str13);
                                                            map2.put("usor", aVar14);
                                                        } else {
                                                            int i26 = 16;
                                                            if (((Integer) list2.get(i10)).equals(16)) {
                                                                String str14 = strArrSplit[i10 + 1];
                                                                q3.a aVar15 = new q3.a(i26);
                                                                aVar15.a(str14);
                                                                map2.put("ustx", aVar15);
                                                            } else if (((Integer) list2.get(i10)).equals(17)) {
                                                                String str15 = strArrSplit[i10 + 1];
                                                                q3.a aVar16 = new q3.a(i13);
                                                                aVar16.a(str15);
                                                                map2.put("usde", aVar16);
                                                            } else if (((Integer) list2.get(i10)).equals(18)) {
                                                                String str16 = strArrSplit[i10 + 1];
                                                                q3.a aVar17 = new q3.a(i15);
                                                                aVar17.a(str16);
                                                                map2.put("usia", aVar17);
                                                            } else if (((Integer) list2.get(i10)).equals(19)) {
                                                                String str17 = strArrSplit[i10 + 1];
                                                                q3.a aVar18 = new q3.a(i20);
                                                                aVar18.a(str17);
                                                                map2.put("usne", aVar18);
                                                            } else if (((Integer) list2.get(i10)).equals(20)) {
                                                                String str18 = strArrSplit[i10 + 1];
                                                                q3.a aVar19 = new q3.a(i22);
                                                                aVar19.a(str18);
                                                                map2.put("usnh", aVar19);
                                                            } else if (((Integer) list2.get(i10)).equals(21)) {
                                                                String str19 = strArrSplit[i10 + 1];
                                                                q3.a aVar20 = new q3.a(i23);
                                                                aVar20.a(str19);
                                                                map2.put("usnj", aVar20);
                                                            } else if (((Integer) list2.get(i10)).equals(22)) {
                                                                String str20 = strArrSplit[i10 + 1];
                                                                q3.a aVar21 = new q3.a(i25);
                                                                aVar21.a(str20);
                                                                map2.put("ustn", aVar21);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i10++;
                i11 = 1;
            }
        }
        return map2;
    }

    public final void b(int i10) {
        String str = (String) b.f12257b.get(Integer.valueOf(i10));
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        if (this.f9911a.containsKey(str)) {
            this.f9911a.remove(str);
            this.f9913c = true;
        }
    }

    public final String c() {
        String str = this.f9912b;
        if (str == null || str.isEmpty() || this.f9913c) {
            HashMap map = this.f9911a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            while (true) {
                List list = b.f12256a;
                if (i10 >= list.size()) {
                    break;
                }
                String str2 = (String) list.get(i10);
                if (map.containsKey(str2)) {
                    q3.a aVar = (q3.a) map.get(str2);
                    arrayList.add(aVar.c());
                    arrayList2.add(Integer.valueOf(aVar.e()));
                }
                i10++;
            }
            q3.a aVar2 = new q3.a(0);
            try {
                aVar2.g("SectionIds", f());
                arrayList.add(0, aVar2.c());
                this.f9912b = (String) Collection.EL.stream(arrayList).collect(Collectors.joining("~"));
                this.f9913c = false;
                this.f9914d = true;
            } catch (o3.b e) {
                throw new u6(e);
            }
        }
        return this.f9912b;
    }

    public final void d() {
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        try {
            new q3.a(0).g("SectionIds", f());
        } catch (o3.b unused) {
        }
    }

    public final q3.a e(String str) {
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        if (this.f9911a.containsKey(str)) {
            return (q3.a) this.f9911a.get(str);
        }
        return null;
    }

    public final ArrayList f() {
        int i10 = 0;
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            List list = b.f12256a;
            if (i10 >= list.size()) {
                return arrayList;
            }
            String str = (String) list.get(i10);
            if (this.f9911a.containsKey(str)) {
                arrayList.add(Integer.valueOf(((q3.a) this.f9911a.get(str)).e()));
            }
            i10++;
        }
    }

    public final boolean g(String str) {
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        return this.f9911a.containsKey(str);
    }

    public final void h(Object obj, String str, String str2) {
        q3.a aVar;
        if (!this.f9914d) {
            this.f9911a = a(this.f9912b);
            this.f9913c = false;
            this.f9914d = true;
        }
        if (this.f9911a.containsKey(str)) {
            aVar = (q3.a) this.f9911a.get(str);
        } else if (str.equals("tcfcav1")) {
            aVar = new q3.a(1);
            this.f9911a.put("tcfcav1", aVar);
        } else if (str.equals("tcfeuv2")) {
            aVar = new q3.a(2);
            this.f9911a.put("tcfeuv2", aVar);
        } else if (str.equals("uspv1")) {
            aVar = new q3.a(19);
            this.f9911a.put("uspv1", aVar);
        } else if (str.equals("usnat")) {
            aVar = new q3.a(10);
            this.f9911a.put("usnat", aVar);
        } else if (str.equals("usca")) {
            aVar = new q3.a(3);
            this.f9911a.put("usca", aVar);
        } else if (str.equals("usva")) {
            aVar = new q3.a(18);
            this.f9911a.put("usva", aVar);
        } else if (str.equals("usco")) {
            aVar = new q3.a(4);
            this.f9911a.put("usco", aVar);
        } else if (str.equals("usut")) {
            aVar = new q3.a(17);
            this.f9911a.put("usut", aVar);
        } else if (str.equals("usct")) {
            aVar = new q3.a(5);
            this.f9911a.put("usct", aVar);
        } else if (str.equals("usfl")) {
            aVar = new q3.a(7);
            this.f9911a.put("usfl", aVar);
        } else if (str.equals("usmt")) {
            aVar = new q3.a(9);
            this.f9911a.put("usmt", aVar);
        } else if (str.equals("usor")) {
            aVar = new q3.a(14);
            this.f9911a.put("usor", aVar);
        } else if (str.equals("ustx")) {
            aVar = new q3.a(16);
            this.f9911a.put("ustx", aVar);
        } else if (str.equals("usde")) {
            aVar = new q3.a(6);
            this.f9911a.put("usde", aVar);
        } else if (str.equals("usia")) {
            aVar = new q3.a(8);
            this.f9911a.put("usia", aVar);
        } else if (str.equals("usne")) {
            aVar = new q3.a(11);
            this.f9911a.put("usne", aVar);
        } else if (str.equals("usnh")) {
            aVar = new q3.a(12);
            this.f9911a.put("usnh", aVar);
        } else if (str.equals("usnj")) {
            aVar = new q3.a(13);
            this.f9911a.put("usnj", aVar);
        } else if (str.equals("ustn")) {
            aVar = new q3.a(15);
            this.f9911a.put("ustn", aVar);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g(str2, obj);
            this.f9913c = true;
            return;
        }
        throw new o3.b(str + "." + str2 + " not found");
    }
}
