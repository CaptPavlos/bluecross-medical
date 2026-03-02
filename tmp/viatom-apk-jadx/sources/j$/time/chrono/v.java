package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class v extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final v f9191c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // j$.time.chrono.l
    public final String d() {
        return "Japanese";
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "japanese";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        if (nVar instanceof x) {
            return (x) nVar;
        }
        return new x(j$.time.h.x(nVar));
    }

    private v() {
    }

    @Override // j$.time.chrono.l
    public final m l(int i10) {
        return y.l(i10);
    }

    public final j$.time.temporal.u f(j$.time.temporal.a aVar) {
        switch (u.f9190a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                j$.time.g.b(aVar, "Unsupported field: ");
                return null;
            case 5:
                y[] yVarArr = y.e;
                int i10 = yVarArr[yVarArr.length - 1].f9199b.f9251a;
                int iMin = 1000000000 - yVarArr[yVarArr.length - 1].f9199b.f9251a;
                int i11 = yVarArr[0].f9199b.f9251a;
                int i12 = 1;
                while (true) {
                    y[] yVarArr2 = y.e;
                    if (i12 >= yVarArr2.length) {
                        return j$.time.temporal.u.f(iMin, 999999999 - i10);
                    }
                    y yVar = yVarArr2[i12];
                    iMin = Math.min(iMin, (yVar.f9199b.f9251a - i11) + 1);
                    i11 = yVar.f9199b.f9251a;
                    i12++;
                }
            case 6:
                y yVar2 = y.f9197d;
                long jMin = j$.time.temporal.a.DAY_OF_YEAR.f9282b.f9306c;
                for (y yVar3 : y.e) {
                    jMin = Math.min(jMin, ((yVar3.f9199b.B() ? 366 : 365) - yVar3.f9199b.A()) + 1);
                    if (yVar3.i() != null) {
                        jMin = Math.min(jMin, yVar3.i().f9199b.A() - 1);
                    }
                }
                return j$.time.temporal.u.f(jMin, j$.time.temporal.a.DAY_OF_YEAR.f9282b.f9307d);
            case 7:
                return j$.time.temporal.u.e(x.f9193d.f9251a, 999999999L);
            case 8:
                long j10 = y.f9197d.f9198a;
                y[] yVarArr3 = y.e;
                return j$.time.temporal.u.e(j10, yVarArr3[yVarArr3.length - 1].f9198a);
            default:
                return aVar.f9282b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
