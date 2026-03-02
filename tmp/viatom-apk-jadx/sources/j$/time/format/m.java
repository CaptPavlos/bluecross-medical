package j$.time.format;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class m implements f {

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f9230a;

    /* renamed from: b, reason: collision with root package name */
    public final v f9231b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9232c;

    /* renamed from: d, reason: collision with root package name */
    public volatile i f9233d;

    public m(j$.time.temporal.q qVar, v vVar, b bVar) {
        this.f9230a = qVar;
        this.f9231b = vVar;
        this.f9232c = bVar;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        String strA;
        Long lA = pVar.a(this.f9230a);
        if (lA == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) pVar.f9242a.k(j$.time.temporal.r.f9301b);
        if (lVar == null || lVar == j$.time.chrono.s.f9188c) {
            b bVar = this.f9232c;
            long jLongValue = lA.longValue();
            v vVar = this.f9231b;
            Locale locale = pVar.f9243b.f9209b;
            strA = bVar.f9214a.a(jLongValue, vVar);
        } else {
            b bVar2 = this.f9232c;
            long jLongValue2 = lA.longValue();
            v vVar2 = this.f9231b;
            Locale locale2 = pVar.f9243b.f9209b;
            strA = bVar2.f9214a.a(jLongValue2, vVar2);
        }
        if (strA != null) {
            sb.append(strA);
            return true;
        }
        if (this.f9233d == null) {
            this.f9233d = new i(this.f9230a, 1, 19, u.NORMAL);
        }
        return this.f9233d.e(pVar, sb);
    }

    public final String toString() {
        v vVar = v.FULL;
        v vVar2 = this.f9231b;
        j$.time.temporal.q qVar = this.f9230a;
        if (vVar2 == vVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + vVar2 + ")";
    }
}
