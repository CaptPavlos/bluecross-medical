package w7;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");
    public static final e2.a g = new e2.a("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f13544a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13545b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13546c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f13547d;

    public m(int i10, boolean z9) {
        this.f13544a = i10;
        this.f13545b = z9;
        int i11 = i10 - 1;
        this.f13546c = i11;
        this.f13547d = new AtomicReferenceArray(i10);
        if (i11 > 1073741823) {
            androidx.window.layout.c.g("Check failed.");
            throw null;
        }
        if ((i10 & i11) == 0) {
            return;
        }
        androidx.window.layout.c.g("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j10) != 0) {
                return (2305843009213693952L & j10) != 0 ? 2 : 1;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f13546c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            boolean z9 = this.f13545b;
            AtomicReferenceArray atomicReferenceArray = this.f13547d;
            if (z9 || atomicReferenceArray.get(i11 & i12) == null) {
                if (f.compareAndSet(this, j10, ((-1152921503533105153L) & j10) | (((i11 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i11 & i12, obj);
                    m mVarC = this;
                    while ((atomicLongFieldUpdater.get(mVarC) & 1152921504606846976L) != 0) {
                        mVarC = mVarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = mVarC.f13547d;
                        int i13 = mVarC.f13546c & i11;
                        Object obj2 = atomicReferenceArray2.get(i13);
                        if ((obj2 instanceof l) && ((l) obj2).f13543a == i11) {
                            atomicReferenceArray2.set(i13, obj);
                        } else {
                            mVarC = null;
                        }
                        if (mVarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i14 = this.f13544a;
                if (i14 < 1024 || ((i11 - i10) & 1073741823) > (i14 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        do {
            atomicLongFieldUpdater = f;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, 2305843009213693952L | j10));
        return true;
    }

    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j11 = 1152921504606846976L | j10;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j10, j11)) {
                j10 = j11;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f13544a * 2, mVar.f13545b);
            int i10 = (int) (1073741823 & j10);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            while (true) {
                int i12 = mVar.f13546c;
                int i13 = i10 & i12;
                if (i13 == (i12 & i11)) {
                    break;
                }
                Object lVar = mVar.f13547d.get(i13);
                if (lVar == null) {
                    lVar = new l(i10);
                }
                mVar3.f13547d.set(mVar3.f13546c & i10, lVar);
                i10++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j10);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = w7.m.f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            e2.a r0 = w7.m.g
            return r0
        L15:
            r11 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r11
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r13 = 30
            long r4 = r4 >> r13
            int r4 = (int) r4
            int r5 = r1.f13546c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.f13547d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.f13545b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof w7.l
            if (r7 == 0) goto L42
        L41:
            return r14
        L42:
            int r0 = r0 + 1
            r7 = 1073741823(0x3fffffff, float:1.9999999)
            r0 = r0 & r7
            r7 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r7
            r20 = r7
            long r7 = (long) r0
            long r18 = r18 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = w7.m.f
            r28 = r18
            r18 = r4
            r19 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L66
            r15.set(r13, r14)
            return r18
        L66:
            r1 = r30
            if (r19 == 0) goto L2
        L6a:
            long r24 = r6.get(r1)
            long r2 = r24 & r11
            int r0 = (int) r2
            long r2 = r24 & r16
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 == 0) goto L7d
            w7.m r0 = r1.c()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = w7.m.f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.f13547d
            int r2 = r2.f13546c
            r0 = r0 & r2
            r1.set(r0, r14)
            r1 = r14
        L96:
            if (r1 != 0) goto L6a
            return r18
        L99:
            r1 = r2
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.m.d():java.lang.Object");
    }
}
