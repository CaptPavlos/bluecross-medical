package v7;

import java.util.Arrays;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public d[] f13174a;

    /* renamed from: b, reason: collision with root package name */
    public int f13175b;

    /* renamed from: c, reason: collision with root package name */
    public int f13176c;

    public final d b() {
        d dVarC;
        synchronized (this) {
            try {
                d[] dVarArrD = this.f13174a;
                if (dVarArrD == null) {
                    dVarArrD = d();
                    this.f13174a = dVarArrD;
                } else if (this.f13175b >= dVarArrD.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrD, dVarArrD.length * 2);
                    this.f13174a = (d[]) objArrCopyOf;
                    dVarArrD = (d[]) objArrCopyOf;
                }
                int i10 = this.f13176c;
                do {
                    dVarC = dVarArrD[i10];
                    if (dVarC == null) {
                        dVarC = c();
                        dVarArrD[i10] = dVarC;
                    }
                    i10++;
                    if (i10 >= dVarArrD.length) {
                        i10 = 0;
                    }
                } while (!dVarC.a(this));
                this.f13176c = i10;
                this.f13175b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarC;
    }

    public abstract d c();

    public abstract d[] d();

    public final void e(d dVar) {
        int i10;
        w6.c[] cVarArrB;
        synchronized (this) {
            try {
                int i11 = this.f13175b - 1;
                this.f13175b = i11;
                if (i11 == 0) {
                    this.f13176c = 0;
                }
                dVar.getClass();
                cVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (w6.c cVar : cVarArrB) {
            if (cVar != null) {
                cVar.resumeWith(w.f12711a);
            }
        }
    }
}
