package w7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13539a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13540b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13541c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(j jVar, int i10) {
        while (true) {
            j jVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13540b;
            if (jVarD == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    jVarD = (j) obj;
                    if (!jVarD.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVarD);
                }
            }
            if (jVarD instanceof h) {
                return (((h) jVarD).f13538d & i10) == 0 && jVarD.c(jVar, i10);
            }
            atomicReferenceFieldUpdater.set(jVar, jVarD);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f13539a;
            atomicReferenceFieldUpdater2.set(jVar, this);
            while (!atomicReferenceFieldUpdater2.compareAndSet(jVarD, this, jVar)) {
                if (atomicReferenceFieldUpdater2.get(jVarD) != this) {
                    break;
                }
            }
            jVar.e(this);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r6 = ((w7.p) r6).f13552a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r5.get(r4) == r3) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w7.j d() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = w7.j.f13540b
            java.lang.Object r1 = r0.get(r9)
            w7.j r1 = (w7.j) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = w7.j.f13539a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L1c
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
        L1c:
            return r3
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.g()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            boolean r7 = r6 instanceof w7.p
            if (r7 == 0) goto L4b
            if (r4 == 0) goto L44
            w7.p r6 = (w7.p) r6
            w7.j r6 = r6.f13552a
        L35:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L3d
            r3 = r4
            goto La
        L3d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L35
            goto L0
        L44:
            java.lang.Object r3 = r0.get(r3)
            w7.j r3 = (w7.j) r3
            goto Lb
        L4b:
            r6.getClass()
            r4 = r6
            w7.j r4 = (w7.j) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.j.d():w7.j");
    }

    public final void e(j jVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13540b;
            j jVar2 = (j) atomicReferenceFieldUpdater.get(jVar);
            if (f13539a.get(this) != jVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(jVar, jVar2, this)) {
                if (atomicReferenceFieldUpdater.get(jVar) != jVar2) {
                    break;
                }
            }
            if (g()) {
                jVar.d();
                return;
            }
            return;
        }
    }

    public final j f() {
        Object obj = f13539a.get(this);
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null) {
            return pVar.f13552a;
        }
        obj.getClass();
        return (j) obj;
    }

    public boolean g() {
        return f13539a.get(this) instanceof p;
    }

    public String toString() {
        return new i(this, r7.y.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + r7.y.m(this);
    }
}
