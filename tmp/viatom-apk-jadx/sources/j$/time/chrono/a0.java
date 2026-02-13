package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a0 extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final a0 f9151c = new a0();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.l
    public final String d() {
        return "Minguo";
    }

    @Override // j$.time.chrono.l
    public final m l(int i10) {
        if (i10 == 0) {
            return d0.BEFORE_ROC;
        }
        if (i10 == 1) {
            return d0.ROC;
        }
        j$.time.g.d("Invalid era: ", i10);
        return null;
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        if (nVar instanceof c0) {
            return (c0) nVar;
        }
        return new c0(j$.time.h.x(nVar));
    }

    public final j$.time.temporal.u f(j$.time.temporal.a aVar) {
        int i10 = z.f9201a[aVar.ordinal()];
        if (i10 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f9282b;
            return j$.time.temporal.u.e(uVar.f9304a - 22932, uVar.f9307d - 22932);
        }
        if (i10 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f9282b;
            return j$.time.temporal.u.f(uVar2.f9307d - 1911, (-uVar2.f9304a) + 1912);
        }
        if (i10 != 3) {
            return aVar.f9282b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f9282b;
        return j$.time.temporal.u.e(uVar3.f9304a - 1911, uVar3.f9307d - 1911);
    }

    private a0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
