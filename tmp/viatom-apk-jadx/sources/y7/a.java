package y7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends Thread {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f14100i = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final l f14101a;

    /* renamed from: b, reason: collision with root package name */
    public final x f14102b;

    /* renamed from: c, reason: collision with root package name */
    public b f14103c;

    /* renamed from: d, reason: collision with root package name */
    public long f14104d;
    public long e;
    public int f;
    public boolean g;
    public final /* synthetic */ c h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i10) {
        this.h = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f14101a = new l();
        this.f14102b = new x();
        this.f14103c = b.f14108d;
        this.nextParkedWorker = c.f14111k;
        int iNanoTime = (int) System.nanoTime();
        this.f = iNanoTime == 0 ? 42 : iNanoTime;
        f(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r12 = y7.l.f14131d.get(r9);
        r0 = y7.l.f14130c.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (y7.l.e.get(r9) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = r0 - 1;
        r1 = r9.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r1 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y7.h a(boolean r12) {
        /*
            r11 = this;
            y7.b r0 = r11.f14103c
            y7.c r2 = r11.h
            r7 = 0
            r8 = 1
            y7.l r9 = r11.f14101a
            y7.b r10 = y7.b.f14105a
            if (r0 != r10) goto Le
            goto L84
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = y7.c.f14109i
        L10:
            long r3 = r0.get(r2)
            r5 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r5 = r5 & r3
            r1 = 42
            long r5 = r5 >> r1
            int r1 = (int) r5
            if (r1 != 0) goto L73
            r9.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = y7.l.f14129b
            java.lang.Object r0 = r12.get(r9)
            y7.h r0 = (y7.h) r0
            if (r0 != 0) goto L2e
            goto L41
        L2e:
            boolean r1 = r0.f14122b
            if (r1 != r8) goto L41
        L32:
            boolean r1 = r12.compareAndSet(r9, r0, r7)
            if (r1 == 0) goto L3a
            r7 = r0
            goto L61
        L3a:
            java.lang.Object r1 = r12.get(r9)
            if (r1 == r0) goto L32
            goto L23
        L41:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = y7.l.f14131d
            int r12 = r12.get(r9)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = y7.l.f14130c
            int r0 = r0.get(r9)
        L4d:
            if (r12 == r0) goto L61
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = y7.l.e
            int r1 = r1.get(r9)
            if (r1 != 0) goto L58
            goto L61
        L58:
            int r0 = r0 + (-1)
            y7.h r1 = r9.c(r0, r8)
            if (r1 == 0) goto L4d
            r7 = r1
        L61:
            if (r7 != 0) goto L72
            y7.f r12 = r2.f
            java.lang.Object r12 = r12.d()
            y7.h r12 = (y7.h) r12
            if (r12 != 0) goto L71
            y7.h r12 = r11.i(r8)
        L71:
            return r12
        L72:
            return r7
        L73:
            r5 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r5 = r3 - r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = y7.c.f14109i
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L10
            r11.f14103c = r10
        L84:
            if (r12 == 0) goto Lb8
            int r12 = r2.f14112a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L91
            goto L92
        L91:
            r8 = 0
        L92:
            if (r8 == 0) goto L9b
            y7.h r12 = r11.e()
            if (r12 == 0) goto L9b
            return r12
        L9b:
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = y7.l.f14129b
            java.lang.Object r12 = r12.getAndSet(r9, r7)
            y7.h r12 = (y7.h) r12
            if (r12 != 0) goto Lac
            y7.h r12 = r9.b()
        Lac:
            if (r12 == 0) goto Laf
            return r12
        Laf:
            if (r8 != 0) goto Lbf
            y7.h r12 = r11.e()
            if (r12 == 0) goto Lbf
            return r12
        Lb8:
            y7.h r12 = r11.e()
            if (r12 == 0) goto Lbf
            return r12
        Lbf:
            r12 = 3
            y7.h r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.a.a(boolean):y7.h");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i10) {
        int i11 = this.f;
        int i12 = i11 ^ (i11 << 13);
        int i13 = i12 ^ (i12 >> 17);
        int i14 = i13 ^ (i13 << 5);
        this.f = i14;
        int i15 = i10 - 1;
        return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
    }

    public final h e() {
        int iD = d(2);
        c cVar = this.h;
        f fVar = cVar.f;
        f fVar2 = cVar.e;
        if (iD == 0) {
            h hVar = (h) fVar2.d();
            return hVar != null ? hVar : (h) fVar.d();
        }
        h hVar2 = (h) fVar.d();
        return hVar2 != null ? hVar2 : (h) fVar2.d();
    }

    public final void f(int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h.f14115d);
        sb.append("-worker-");
        sb.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
        setName(sb.toString());
        this.indexInArray = i10;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f14103c;
        boolean z9 = bVar2 == b.f14105a;
        if (z9) {
            c.f14109i.addAndGet(this.h, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f14103c = bVar;
        }
        return z9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        r7 = -2;
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y7.h i(int r26) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.a.i(int):y7.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.a.run():void");
    }
}
