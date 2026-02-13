package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class g0 extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final g0 f9162c = new g0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // j$.time.chrono.l
    public final m l(int i10) {
        if (i10 == 0) {
            return j0.BEFORE_BE;
        }
        if (i10 == 1) {
            return j0.BE;
        }
        j$.time.g.d("Invalid era: ", i10);
        return null;
    }

    @Override // j$.time.chrono.l
    public final String d() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        if (nVar instanceof i0) {
            return (i0) nVar;
        }
        return new i0(j$.time.h.x(nVar));
    }

    private g0() {
    }

    public final j$.time.temporal.u f(j$.time.temporal.a aVar) {
        int i10 = f0.f9159a[aVar.ordinal()];
        if (i10 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f9282b;
            return j$.time.temporal.u.e(uVar.f9304a + 6516, uVar.f9307d + 6516);
        }
        if (i10 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f9282b;
            return j$.time.temporal.u.f((-(uVar2.f9304a + 543)) + 1, uVar2.f9307d + 543);
        }
        if (i10 != 3) {
            return aVar.f9282b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f9282b;
        return j$.time.temporal.u.e(uVar3.f9304a + 543, uVar3.f9307d + 543);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
