package m3;

import com.google.android.gms.internal.measurement.u6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.IntSupplier;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends a {

    /* renamed from: d, reason: collision with root package name */
    public final IntSupplier f11181d;

    public e(IntSupplier intSupplier, ArrayList arrayList) {
        super(true);
        this.f11181d = intSupplier;
        setValue(arrayList);
    }

    @Override // m3.a
    public final void a(String str) {
        try {
            this.f11178c = n3.d.a(str);
        } catch (Exception e) {
            throw new o3.a(e);
        }
    }

    @Override // m3.a
    public final String b() {
        try {
            return n3.d.b(this.f11181d.getAsInt(), (List) this.f11178c);
        } catch (Exception e) {
            throw new u6(e);
        }
    }

    @Override // m3.a
    public final String c(int i10, String str) throws g {
        try {
            return str.substring(i10, this.f11181d.getAsInt() + i10);
        } catch (Exception e) {
            throw new g(e);
        }
    }

    @Override // m3.a, m3.b
    public final Object getValue() {
        return new ArrayList((Collection) this.f11178c);
    }

    @Override // m3.a, m3.b
    public final void setValue(Object obj) {
        int asInt = this.f11181d.getAsInt();
        ArrayList arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < asInt; size++) {
            arrayList.add(Boolean.FALSE);
        }
        int size2 = arrayList.size();
        List listSubList = arrayList;
        if (size2 > asInt) {
            listSubList = arrayList.subList(0, asInt);
        }
        super.setValue(listSubList);
    }
}
