package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.Objects;
import j$.util.a0;
import j$.util.function.Function$CC;
import j$.util.stream.Collectors;
import j$.util.u1;
import j$.util.x;
import j$.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements IntFunction, BinaryOperator, Supplier, BiConsumer, Function, DoubleFunction, ToDoubleFunction, DoubleBinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9212a;

    public /* synthetic */ a(int i10) {
        this.f9212a = i10;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f9212a) {
            case 12:
                ((List) obj).add(obj2);
                break;
            case 17:
                ((u1) obj).a((CharSequence) obj2);
                break;
            case 22:
                ((LinkedHashSet) obj).add(obj2);
                break;
            case 23:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                break;
            default:
                ((x) obj).a((x) obj2);
                break;
        }
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f9212a) {
            case 12:
                break;
            case 17:
                break;
            case 22:
                break;
            case 23:
                break;
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f9212a) {
            case 9:
                break;
            case 15:
                break;
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    /* renamed from: andThen, reason: collision with other method in class */
    public /* synthetic */ Function m237andThen(Function function) {
        switch (this.f9212a) {
        }
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d8) {
        return Double.valueOf(d8);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (this.f9212a) {
            case 16:
                Set set = Collectors.f9498a;
                return obj;
            default:
                return ((u1) obj).toString();
        }
    }

    @Override // java.util.function.DoubleBinaryOperator
    public double applyAsDouble(double d8, double d10) {
        return Math.max(d8, d10);
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f9212a) {
        }
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.f9212a) {
            case 9:
                Map map = (Map) obj;
                Set set = Collectors.f9498a;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    Object objRequireNonNull = Objects.requireNonNull(entry.getValue());
                    Object objT = j$.util.c.t(map, key, objRequireNonNull);
                    if (objT != null) {
                        j$.time.g.g("Duplicate key %s (attempted merging values %s and %s)", new Object[]{key, objT, objRequireNonNull});
                        return null;
                    }
                }
                return map;
            case 15:
                List list = (List) obj;
                Set set2 = Collectors.f9498a;
                list.addAll((List) obj2);
                return list;
            default:
                u1 u1Var = (u1) obj;
                u1 u1Var2 = (u1) obj2;
                u1Var.getClass();
                Objects.requireNonNull(u1Var2);
                if (u1Var2.f9851d != null) {
                    u1Var2.b();
                    u1Var.a(u1Var2.f9851d[0]);
                }
                return u1Var;
        }
    }

    @Override // java.util.function.ToDoubleFunction
    public double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f9212a) {
            case 10:
                return new x();
            case 11:
                return new ArrayList();
            case 13:
                return new y();
            case 14:
                return new a0();
            case 20:
                return new HashMap();
            case 21:
                return new LinkedHashSet();
            default:
                return new double[3];
        }
    }

    public Object a(j$.time.temporal.n nVar) {
        switch (this.f9212a) {
            case 0:
                ZoneId zoneId = (ZoneId) nVar.k(j$.time.temporal.r.f9300a);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 1:
                return (ZoneId) nVar.k(j$.time.temporal.r.f9300a);
            case 2:
                return (j$.time.chrono.l) nVar.k(j$.time.temporal.r.f9301b);
            case 3:
                return (j$.time.temporal.s) nVar.k(j$.time.temporal.r.f9302c);
            case 4:
                j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
                if (nVar.c(aVar)) {
                    return ZoneOffset.C(nVar.e(aVar));
                }
                return null;
            case 5:
                ZoneId zoneId2 = (ZoneId) nVar.k(j$.time.temporal.r.f9300a);
                return zoneId2 != null ? zoneId2 : (ZoneId) nVar.k(j$.time.temporal.r.f9303d);
            case 6:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.EPOCH_DAY;
                if (nVar.c(aVar2)) {
                    return j$.time.h.E(nVar.q(aVar2));
                }
                return null;
            default:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_DAY;
                if (nVar.c(aVar3)) {
                    return j$.time.k.z(nVar.q(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f9212a) {
            case 1:
                return "ZoneId";
            case 2:
                return "Chronology";
            case 3:
                return "Precision";
            case 4:
                return "ZoneOffset";
            case 5:
                return "Zone";
            case 6:
                return "LocalDate";
            case 7:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i10) {
        switch (this.f9212a) {
            case 8:
                return new Object[i10];
            default:
                return new Double[i10];
        }
    }
}
