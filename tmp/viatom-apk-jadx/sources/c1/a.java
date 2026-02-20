package c1;

import androidx.collection.ArrayMap;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f981b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f982c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c0 f983d;

    public a(n3 n3Var, k3 k3Var, long j10) {
        this.f980a = 2;
        this.f981b = k3Var;
        this.f982c = j10;
        Objects.requireNonNull(n3Var);
        this.f983d = n3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f980a) {
            case 0:
                z zVar = (z) this.f983d;
                String str = (String) this.f981b;
                zVar.g();
                i0.y.d(str);
                ArrayMap arrayMap = zVar.f1614c;
                boolean zIsEmpty = arrayMap.isEmpty();
                long j10 = this.f982c;
                if (zIsEmpty) {
                    zVar.f1615d = j10;
                }
                Integer num = (Integer) arrayMap.get(str);
                if (num == null) {
                    if (arrayMap.size() < 100) {
                        arrayMap.put(str, 1);
                        zVar.f1613b.put(str, Long.valueOf(j10));
                        break;
                    } else {
                        w0 w0Var = zVar.f1149a.f;
                        u1.m(w0Var);
                        w0Var.f1540i.b("Too many ads visible");
                        break;
                    }
                } else {
                    arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
                    break;
                }
            case 1:
                z zVar2 = (z) this.f983d;
                String str2 = (String) this.f981b;
                zVar2.g();
                i0.y.d(str2);
                ArrayMap arrayMap2 = zVar2.f1614c;
                Integer num2 = (Integer) arrayMap2.get(str2);
                u1 u1Var = zVar2.f1149a;
                if (num2 == null) {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f.c(str2, "Call to endAdUnitExposure for unknown ad unit id");
                    break;
                } else {
                    n3 n3Var = u1Var.f1482l;
                    w0 w0Var3 = u1Var.f;
                    u1.l(n3Var);
                    k3 k3VarM = n3Var.m(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        arrayMap2.put(str2, Integer.valueOf(iIntValue));
                        break;
                    } else {
                        arrayMap2.remove(str2);
                        ArrayMap arrayMap3 = zVar2.f1613b;
                        Long l10 = (Long) arrayMap3.get(str2);
                        long j11 = this.f982c;
                        if (l10 == null) {
                            u1.m(w0Var3);
                            w0Var3.f.b("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = j11 - l10.longValue();
                            arrayMap3.remove(str2);
                            zVar2.l(str2, jLongValue, k3VarM);
                        }
                        if (arrayMap2.isEmpty()) {
                            long j12 = zVar2.f1615d;
                            if (j12 != 0) {
                                zVar2.k(j11 - j12, k3VarM);
                                zVar2.f1615d = 0L;
                                break;
                            } else {
                                u1.m(w0Var3);
                                w0Var3.f.b("First ad exposure time was never set");
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                n3 n3Var2 = (n3) this.f983d;
                n3Var2.k((k3) this.f981b, false, this.f982c);
                n3Var2.e = null;
                x3 x3VarP = n3Var2.f1149a.p();
                x3VarP.g();
                x3VarP.h();
                x3VarP.u(new k1.a(x3VarP, (k3) null));
                break;
        }
    }

    public /* synthetic */ a(z zVar, String str, long j10, int i10) {
        this.f980a = i10;
        this.f981b = str;
        this.f982c = j10;
        this.f983d = zVar;
    }
}
