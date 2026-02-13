package u7;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 extends v7.b implements c0, h, v7.i {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(m0.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public int f13027d;

    public m0(Object obj) {
        this._state$volatile = obj;
    }

    @Override // v7.i
    public final h a(w6.h hVar, int i10, t7.a aVar) {
        return ((((i10 < 0 || i10 >= 2) && i10 != -2) || aVar != t7.a.f12814b) && !((i10 == 0 || i10 == -3) && aVar == t7.a.f12813a)) ? new d((Object) this, hVar, i10, aVar, 1) : this;
    }

    @Override // v7.b
    public final v7.d c() {
        return new n0();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Path cross not found for [B:58:0x00f5, B:59:0x00f6], limit reached: 66 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007c, B:30:0x0084, B:33:0x008b, B:34:0x008f, B:36:0x0092, B:46:0x00b3, B:49:0x00c3, B:50:0x00df, B:56:0x00ef, B:53:0x00e6, B:55:0x00ec, B:38:0x0098, B:42:0x009f, B:21:0x0052, B:24:0x005c, B:27:0x006d), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007c, B:30:0x0084, B:33:0x008b, B:34:0x008f, B:36:0x0092, B:46:0x00b3, B:49:0x00c3, B:50:0x00df, B:56:0x00ef, B:53:0x00e6, B:55:0x00ec, B:38:0x0098, B:42:0x009f, B:21:0x0052, B:24:0x005c, B:27:0x006d), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007c, B:30:0x0084, B:33:0x008b, B:34:0x008f, B:36:0x0092, B:46:0x00b3, B:49:0x00c3, B:50:0x00df, B:56:0x00ef, B:53:0x00e6, B:55:0x00ec, B:38:0x0098, B:42:0x009f, B:21:0x0052, B:24:0x005c, B:27:0x006d), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c2 -> B:28:0x007c). Please report as a decompilation issue!!! */
    @Override // u7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(u7.i r18, w6.c r19) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.m0.collect(u7.i, w6.c):java.lang.Object");
    }

    @Override // v7.b
    public final v7.d[] d() {
        return new n0[2];
    }

    @Override // u7.b0, u7.i
    public final Object emit(Object obj, w6.c cVar) {
        f(obj);
        return s6.w.f12711a;
    }

    public final void f(Object obj) {
        if (obj == null) {
            obj = v7.c.f13178b;
        }
        g(null, obj);
    }

    public final boolean g(Object obj, Object obj2) {
        int i10;
        v7.d[] dVarArr;
        e2.a aVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.l.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.l.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f13027d;
            if ((i11 & 1) != 0) {
                this.f13027d = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f13027d = i12;
            v7.d[] dVarArr2 = this.f13174a;
            while (true) {
                n0[] n0VarArr = (n0[]) dVarArr2;
                if (n0VarArr != null) {
                    for (n0 n0Var : n0VarArr) {
                        if (n0Var != null) {
                            AtomicReference atomicReference = n0Var.f13032a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (aVar = i0.f13007c)) {
                                    e2.a aVar2 = i0.f13006b;
                                    if (obj4 != aVar2) {
                                        while (!atomicReference.compareAndSet(obj4, aVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((r7.g) obj4).resumeWith(s6.w.f12711a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, aVar)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f13027d;
                    if (i10 == i12) {
                        this.f13027d = i12 + 1;
                        return true;
                    }
                    dVarArr = this.f13174a;
                }
                dVarArr2 = dVarArr;
                i12 = i10;
            }
        }
    }

    @Override // u7.k0
    public final Object getValue() {
        e2.a aVar = v7.c.f13178b;
        Object obj = e.get(this);
        if (obj == aVar) {
            return null;
        }
        return obj;
    }
}
