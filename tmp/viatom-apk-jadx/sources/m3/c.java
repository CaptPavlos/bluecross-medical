package m3;

import com.google.android.gms.internal.measurement.l5;
import com.google.android.gms.internal.measurement.u6;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;
import n3.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11179d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ArrayList arrayList, int i10) {
        super(false);
        this.f11179d = i10;
        switch (i10) {
            case 5:
                super(true);
                setValue(arrayList);
                break;
            default:
                setValue(arrayList);
                break;
        }
    }

    @Override // m3.a
    public final void a(String str) throws g {
        switch (this.f11179d) {
            case 0:
                try {
                    ArrayList arrayList = new ArrayList();
                    int length = 12;
                    int iA = n3.e.a(str.substring(0, 12));
                    for (int i10 = 0; i10 < iA; i10++) {
                        int i11 = length + 6;
                        int iA2 = n3.e.a(str.substring(length, i11));
                        int i12 = length + 8;
                        int iA3 = n3.e.a(str.substring(i11, i12));
                        int i13 = length + 20;
                        try {
                            int iA4 = n3.e.a(str.substring(i12, i13));
                            for (int i14 = 0; i14 < iA4; i14++) {
                                i13 = str.charAt(i13) == '1' ? i13 + 33 : i13 + 17;
                            }
                            String strSubstring = str.substring(i12, i13);
                            ArrayList arrayListA = n3.g.a(strSubstring);
                            length = strSubstring.length() + i12;
                            arrayList.add(new f(iA2, iA3, arrayListA));
                        } catch (Exception e) {
                            throw new g(e);
                        }
                    }
                    this.f11178c = arrayList;
                    return;
                } catch (Exception e3) {
                    throw new o3.a(e3);
                }
            case 1:
                try {
                    this.f11178c = Boolean.valueOf(l5.q(str));
                    return;
                } catch (Exception e7) {
                    throw new o3.a(e7);
                }
            case 2:
                try {
                    this.f11178c = n3.a.a(str);
                    return;
                } catch (Exception e10) {
                    throw new o3.a(e10);
                }
            case 3:
                try {
                    this.f11178c = n3.c.a(str);
                    return;
                } catch (Exception e11) {
                    throw new o3.a(e11);
                }
            case 4:
                try {
                    this.f11178c = n3.i.a(str);
                    return;
                } catch (Exception e12) {
                    throw new o3.a(e12);
                }
            default:
                try {
                    this.f11178c = j.a(str);
                    return;
                } catch (Exception e13) {
                    throw new o3.a(e13);
                }
        }
    }

    @Override // m3.a
    public final String b() {
        switch (this.f11179d) {
            case 0:
                try {
                    List<f> list = (List) this.f11178c;
                    StringBuilder sb = new StringBuilder();
                    sb.append(n3.e.b(list.size(), 12));
                    for (f fVar : list) {
                        sb.append(n3.e.b(fVar.f11182a, 6));
                        sb.append(n3.e.b(fVar.f11183b, 2));
                        sb.append(n3.g.b(fVar.f11184c));
                    }
                    return sb.toString();
                } catch (Exception e) {
                    throw new u6(e);
                }
            case 1:
                try {
                    return l5.r((Boolean) this.f11178c);
                } catch (Exception e3) {
                    throw new u6(e3);
                }
            case 2:
                try {
                    ZonedDateTime zonedDateTime = (ZonedDateTime) this.f11178c;
                    Pattern pattern = n3.a.f11281a;
                    return zonedDateTime != null ? n3.h.a(zonedDateTime.toInstant().toEpochMilli() / 100) : n3.h.a(0L);
                } catch (Exception e7) {
                    throw new u6(e7);
                }
            case 3:
                try {
                    return n3.c.b((List) this.f11178c);
                } catch (Exception e10) {
                    throw new u6(e10);
                }
            case 4:
                try {
                    return n3.i.b((String) this.f11178c);
                } catch (Exception e11) {
                    throw new u6(e11);
                }
            default:
                try {
                    return j.b((List) this.f11178c);
                } catch (Exception e12) {
                    throw new u6(e12);
                }
        }
    }

    @Override // m3.a
    public final String c(int i10, String str) throws g {
        switch (this.f11179d) {
            case 0:
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(i10, i10 + 12));
                    int iA = n3.e.a(sb.toString());
                    int length = i10 + sb.length();
                    for (int i11 = 0; i11 < iA; i11++) {
                        String strSubstring = str.substring(length, length + 6);
                        int length2 = length + strSubstring.length();
                        sb.append(strSubstring);
                        String strSubstring2 = str.substring(length2, length2 + 2);
                        int length3 = length2 + strSubstring2.length();
                        sb.append(strSubstring2);
                        int i12 = length3 + 12;
                        try {
                            int iA2 = n3.e.a(str.substring(length3, i12));
                            for (int i13 = 0; i13 < iA2; i13++) {
                                i12 = str.charAt(i12) == '1' ? i12 + 33 : i12 + 17;
                            }
                            String strSubstring3 = str.substring(length3, i12);
                            length = length3 + strSubstring3.length();
                            sb.append(strSubstring3);
                        } catch (Exception e) {
                            throw new g(e);
                        }
                    }
                    return sb.toString();
                } catch (Exception e3) {
                    throw new g(e3);
                }
            case 1:
                try {
                    return str.substring(i10, i10 + 1);
                } catch (Exception e7) {
                    throw new g(e7);
                }
            case 2:
                try {
                    return str.substring(i10, i10 + 36);
                } catch (Exception e10) {
                    throw new g(e10);
                }
            case 3:
                int iIndexOf = i10 + 12;
                try {
                    int iA3 = n3.e.a(str.substring(i10, iIndexOf));
                    for (int i14 = 0; i14 < iA3; i14++) {
                        iIndexOf = (str.charAt(iIndexOf) == '1' ? str.indexOf("11", str.indexOf("11", iIndexOf + 1) + 2) : str.indexOf("11", iIndexOf + 1)) + 2;
                    }
                    return str.substring(i10, iIndexOf);
                } catch (Exception e11) {
                    throw new g(e11);
                }
            case 4:
                try {
                    return str.substring(i10, 12 + i10);
                } catch (Exception e12) {
                    throw new g(e12);
                }
            default:
                int i15 = i10 + 16;
                try {
                    int iA4 = n3.e.a(str.substring(i10, i15));
                    if (str.charAt(i15) != '1') {
                        return str.substring(i10, i10 + 17 + iA4);
                    }
                    int i16 = i10 + 17;
                    String strSubstring4 = str.substring(i10, i16);
                    int i17 = i10 + 29;
                    try {
                        int iA5 = n3.e.a(str.substring(i16, i17));
                        for (int i18 = 0; i18 < iA5; i18++) {
                            i17 = str.charAt(i17) == '1' ? i17 + 33 : i17 + 17;
                        }
                        return strSubstring4.concat(str.substring(i16, i17));
                    } catch (Exception e13) {
                        throw new g(e13);
                    }
                } catch (Exception e14) {
                    throw new g(e14);
                }
        }
    }

    @Override // m3.a, m3.b
    public Object getValue() {
        switch (this.f11179d) {
            case 3:
                return new ArrayList((Collection) this.f11178c);
            case 4:
            default:
                return super.getValue();
            case 5:
                return new ArrayList((Collection) this.f11178c);
        }
    }

    @Override // m3.a, m3.b
    public void setValue(Object obj) {
        switch (this.f11179d) {
            case 3:
                super.setValue(new ArrayList(new TreeSet((List) obj)));
                break;
            case 4:
            default:
                super.setValue(obj);
                break;
            case 5:
                super.setValue(new ArrayList(new TreeSet((List) obj)));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Boolean bool) {
        super(true);
        this.f11179d = 1;
        setValue(bool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ZonedDateTime zonedDateTime) {
        super(true);
        this.f11179d = 2;
        setValue(zonedDateTime);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(true);
        this.f11179d = 4;
        setValue(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(boolean z9) {
        super(z9);
        this.f11179d = 3;
    }
}
