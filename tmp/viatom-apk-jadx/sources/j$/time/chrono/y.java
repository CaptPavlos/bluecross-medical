package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class y implements m, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final y f9197d;
    public static final y[] e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a, reason: collision with root package name */
    public final transient int f9198a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.h f9199b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f9200c;

    @Override // j$.time.temporal.n
    public final /* synthetic */ boolean c(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.o(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ int e(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.l(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.s(this, aVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ long q(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.m(this, qVar);
    }

    static {
        y yVar = new y(-1, j$.time.h.D(1868, 1, 1), "Meiji");
        f9197d = yVar;
        e = new y[]{yVar, new y(0, j$.time.h.D(1912, 7, 30), "Taisho"), new y(1, j$.time.h.D(1926, 12, 25), "Showa"), new y(2, j$.time.h.D(1989, 1, 8), "Heisei"), new y(3, j$.time.h.D(2019, 5, 1), "Reiwa")};
    }

    public final y i() {
        if (this == e[r0.length - 1]) {
            return null;
        }
        return l(this.f9198a + 1);
    }

    public y(int i10, j$.time.h hVar, String str) {
        this.f9198a = i10;
        this.f9199b = hVar;
        this.f9200c = str;
    }

    public static y l(int i10) {
        int i11 = i10 + 1;
        if (i11 >= 0) {
            y[] yVarArr = e;
            if (i11 < yVarArr.length) {
                return yVarArr[i11];
            }
        }
        j$.time.g.d("Invalid era: ", i10);
        return null;
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(getValue(), j$.time.temporal.a.ERA);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.chrono.y d(j$.time.h r5) {
        /*
            j$.time.h r0 = j$.time.chrono.x.f9193d
            boolean r1 = j$.time.c.b(r0)
            r2 = 1
            if (r1 == 0) goto L13
            r5.getClass()
            int r0 = r5.v(r0)
            if (r0 >= 0) goto L21
            goto L1f
        L13:
            long r3 = r5.r()
            long r0 = r0.r()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L21
        L1f:
            r0 = r2
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 != 0) goto L3c
            j$.time.chrono.y[] r0 = j$.time.chrono.y.e
            int r0 = r0.length
            int r0 = r0 - r2
        L28:
            if (r0 < 0) goto L3a
            j$.time.chrono.y[] r1 = j$.time.chrono.y.e
            r1 = r1[r0]
            j$.time.h r2 = r1.f9199b
            int r2 = r5.compareTo(r2)
            if (r2 < 0) goto L37
            return r1
        L37:
            int r0 = r0 + (-1)
            goto L28
        L3a:
            r5 = 0
            return r5
        L3c:
            j$.time.b r5 = new j$.time.b
            java.lang.String r0 = "JapaneseDate before Meiji 6 are not supported"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.y.d(j$.time.h):j$.time.chrono.y");
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return this.f9198a;
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        if (qVar != aVar) {
            return j$.time.temporal.r.d(this, qVar);
        }
        return v.f9191c.f(aVar);
    }

    public final String toString() {
        return this.f9200c;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 5, this);
    }
}
