package w7;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import r7.q0;
import r7.r0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13562b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public q0[] f13563a;

    public final void a(q0 q0Var) {
        q0Var.d((r0) this);
        q0[] q0VarArr = this.f13563a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f13562b;
        if (q0VarArr == null) {
            q0VarArr = new q0[4];
            this.f13563a = q0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= q0VarArr.length) {
            q0VarArr = (q0[]) Arrays.copyOf(q0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            this.f13563a = q0VarArr;
        }
        int i10 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i10 + 1);
        q0VarArr[i10] = q0Var;
        q0Var.f12430b = i10;
        d(i10);
    }

    public final void b(q0 q0Var) {
        synchronized (this) {
            if (q0Var.b() != null) {
                c(q0Var.f12430b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r7.q0 c(int r9) {
        /*
            r8 = this;
            r7.q0[] r0 = r8.f13563a
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = w7.x.f13562b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.e(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            r4.getClass()
            r5 = r0[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.e(r9, r2)
            r8.d(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            r7.q0[] r5 = r8.f13563a
            r5.getClass()
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            r6.getClass()
            r7 = r5[r4]
            r7.getClass()
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            r4.getClass()
            r5 = r5[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.e(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            r9.getClass()
            r2 = 0
            r9.d(r2)
            r9.f12430b = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.x.c(int):r7.q0");
    }

    public final void d(int i10) {
        while (i10 > 0) {
            q0[] q0VarArr = this.f13563a;
            q0VarArr.getClass();
            int i11 = (i10 - 1) / 2;
            q0 q0Var = q0VarArr[i11];
            q0Var.getClass();
            q0 q0Var2 = q0VarArr[i10];
            q0Var2.getClass();
            if (q0Var.compareTo(q0Var2) <= 0) {
                return;
            }
            e(i10, i11);
            i10 = i11;
        }
    }

    public final void e(int i10, int i11) {
        q0[] q0VarArr = this.f13563a;
        q0VarArr.getClass();
        q0 q0Var = q0VarArr[i11];
        q0Var.getClass();
        q0 q0Var2 = q0VarArr[i10];
        q0Var2.getClass();
        q0VarArr[i10] = q0Var;
        q0VarArr[i11] = q0Var2;
        q0Var.f12430b = i10;
        q0Var2.f12430b = i11;
    }
}
