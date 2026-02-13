package m3;

import com.google.android.gms.internal.measurement.u6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11180d;
    public final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List list, int i10) {
        super(true);
        this.f11180d = i10;
        switch (i10) {
            case 2:
                super(true);
                this.e = list.size();
                setValue(list);
                break;
            default:
                this.e = list.size();
                setValue(list);
                break;
        }
    }

    @Override // m3.a
    public final void a(String str) {
        switch (this.f11180d) {
            case 0:
                try {
                    this.f11178c = n3.d.a(str);
                    return;
                } catch (Exception e) {
                    throw new o3.a(e);
                }
            case 1:
                try {
                    this.f11178c = Integer.valueOf(n3.e.a(str));
                    return;
                } catch (Exception e3) {
                    throw new o3.a(e3);
                }
            default:
                try {
                    this.f11178c = n3.f.a(this.e, str);
                    return;
                } catch (Exception e7) {
                    throw new o3.a(e7);
                }
        }
    }

    @Override // m3.a
    public final String b() {
        switch (this.f11180d) {
            case 0:
                try {
                    return n3.d.b(this.e, (List) this.f11178c);
                } catch (Exception e) {
                    throw new u6(e);
                }
            case 1:
                try {
                    return n3.e.b(((Integer) this.f11178c).intValue(), this.e);
                } catch (Exception e3) {
                    throw new u6(e3);
                }
            default:
                try {
                    return n3.f.b(this.e, (List) this.f11178c);
                } catch (Exception e7) {
                    throw new u6(e7);
                }
        }
    }

    @Override // m3.a
    public final String c(int i10, String str) throws g {
        switch (this.f11180d) {
            case 0:
                try {
                    return str.substring(i10, this.e + i10);
                } catch (Exception e) {
                    throw new g(e);
                }
            case 1:
                try {
                    return str.substring(i10, this.e + i10);
                } catch (Exception e3) {
                    throw new g(e3);
                }
            default:
                try {
                    return str.substring(i10, (2 * this.e) + i10);
                } catch (Exception e7) {
                    throw new g(e7);
                }
        }
    }

    @Override // m3.a, m3.b
    public Object getValue() {
        switch (this.f11180d) {
            case 0:
                return new ArrayList((Collection) this.f11178c);
            case 1:
            default:
                return super.getValue();
            case 2:
                return new ArrayList((Collection) this.f11178c);
        }
    }

    @Override // m3.a, m3.b
    public void setValue(Object obj) {
        switch (this.f11180d) {
            case 0:
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                while (true) {
                    int i10 = this.e;
                    if (size >= i10) {
                        int size2 = arrayList.size();
                        List listSubList = arrayList;
                        if (size2 > i10) {
                            listSubList = arrayList.subList(0, i10);
                        }
                        super.setValue(listSubList);
                        break;
                    } else {
                        arrayList.add(Boolean.FALSE);
                        size++;
                    }
                }
            case 1:
            default:
                super.setValue(obj);
                break;
            case 2:
                ArrayList arrayList2 = new ArrayList((List) obj);
                int size3 = arrayList2.size();
                while (true) {
                    int i11 = this.e;
                    if (size3 >= i11) {
                        int size4 = arrayList2.size();
                        List listSubList2 = arrayList2;
                        if (size4 > i11) {
                            listSubList2 = arrayList2.subList(0, i11);
                        }
                        super.setValue(listSubList2);
                        break;
                    } else {
                        arrayList2.add(0);
                        size3++;
                    }
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i10, Integer num) {
        super(true);
        this.f11180d = 1;
        this.e = i10;
        setValue(num);
    }
}
