package j$.time.format;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n {
    public static final a f = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public n f9234a;

    /* renamed from: b, reason: collision with root package name */
    public final n f9235b;

    /* renamed from: c, reason: collision with root package name */
    public final List f9236c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9237d;
    public int e;

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.f9290a;
        map.put('Q', hVar);
        map.put('q', hVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.l.f9297a);
    }

    public n() {
        this.f9234a = this;
        this.f9236c = new ArrayList();
        this.e = -1;
        this.f9235b = null;
        this.f9237d = false;
    }

    public n(n nVar) {
        this.f9234a = this;
        this.f9236c = new ArrayList();
        this.e = -1;
        this.f9235b = nVar;
        this.f9237d = true;
    }

    public final void g(j$.time.temporal.q qVar, int i10) {
        Objects.requireNonNull(qVar, "field");
        if (i10 < 1 || i10 > 19) {
            j$.time.g.i("The width must be from 1 to 19 inclusive but was ", i10);
        } else {
            f(new i(qVar, i10, i10, u.NOT_NEGATIVE));
        }
    }

    public final void h(j$.time.temporal.q qVar, int i10, int i11, u uVar) {
        if (i10 == i11 && uVar == u.NOT_NEGATIVE) {
            g(qVar, i11);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(uVar, "signStyle");
        if (i10 < 1 || i10 > 19) {
            j$.time.g.i("The minimum width must be from 1 to 19 inclusive but was ", i10);
            return;
        }
        if (i11 < 1 || i11 > 19) {
            j$.time.g.i("The maximum width must be from 1 to 19 inclusive but was ", i11);
            return;
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
        }
        f(new i(qVar, i10, i11, uVar));
    }

    public final void f(i iVar) {
        i iVarA;
        n nVar = this.f9234a;
        int i10 = nVar.e;
        if (i10 < 0) {
            nVar.e = b(iVar);
            return;
        }
        i iVar2 = (i) ((ArrayList) nVar.f9236c).get(i10);
        int i11 = iVar.f9221b;
        int i12 = iVar.f9222c;
        if (i11 == i12 && iVar.f9223d == u.NOT_NEGATIVE) {
            iVarA = iVar2.b(i12);
            b(iVar.a());
            this.f9234a.e = i10;
        } else {
            iVarA = iVar2.a();
            this.f9234a.e = b(iVar);
        }
        ((ArrayList) this.f9234a.f9236c).set(i10, iVarA);
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        v vVar = v.FULL;
        b(new m(aVar, vVar, new b(new r(0, Collections.singletonMap(vVar, linkedHashMap)))));
    }

    public final void c(char c10) {
        b(new d(c10));
    }

    public final void d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new d(str.charAt(0)));
        } else {
            b(new l(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        e eVar = dateTimeFormatter.f9208a;
        if (eVar.f9218b) {
            eVar = new e(eVar.f9217a, false);
        }
        b(eVar);
    }

    public final void j() {
        n nVar = this.f9234a;
        nVar.e = -1;
        this.f9234a = new n(nVar);
    }

    public final void i() {
        n nVar = this.f9234a;
        if (nVar.f9235b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) nVar.f9236c).size();
        n nVar2 = this.f9234a;
        if (size > 0) {
            e eVar = new e(nVar2.f9236c, nVar2.f9237d);
            this.f9234a = this.f9234a.f9235b;
            b(eVar);
            return;
        }
        this.f9234a = nVar2.f9235b;
    }

    public final int b(f fVar) {
        Objects.requireNonNull(fVar, "pp");
        n nVar = this.f9234a;
        nVar.getClass();
        ((ArrayList) nVar.f9236c).add(fVar);
        this.f9234a.e = -1;
        return ((ArrayList) r2.f9236c).size() - 1;
    }

    public final DateTimeFormatter k(t tVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), tVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, t tVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f9234a.f9235b != null) {
            i();
        }
        e eVar = new e(this.f9236c, false);
        s sVar = s.f9246a;
        return new DateTimeFormatter(eVar, locale, tVar, lVar);
    }
}
