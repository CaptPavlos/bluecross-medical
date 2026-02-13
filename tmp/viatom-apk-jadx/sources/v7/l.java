package v7;

import e5.u0;
import g7.q;
import l4.i3;
import r7.y;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.c implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final u7.i f13195a;

    /* renamed from: b, reason: collision with root package name */
    public final w6.h f13196b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13197c;

    /* renamed from: d, reason: collision with root package name */
    public w6.h f13198d;
    public w6.c e;

    public l(u7.i iVar, w6.h hVar) {
        super(j.f13193a, w6.i.f13523a);
        this.f13195a = iVar;
        this.f13196b = hVar;
        this.f13197c = ((Number) hVar.fold(0, new u0(11))).intValue();
    }

    public final Object a(w6.c cVar, Object obj) {
        w6.h context = cVar.getContext();
        y.i(context);
        w6.h hVar = this.f13198d;
        if (hVar != context) {
            if (hVar instanceof h) {
                throw new IllegalStateException(o7.n.Q("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((h) hVar).f13192b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new i3(this, 3))).intValue() != this.f13197c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f13196b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f13198d = context;
        }
        this.e = cVar;
        q qVar = n.f13200a;
        u7.i iVar = this.f13195a;
        iVar.getClass();
        Object objInvoke = qVar.invoke(iVar, obj, this);
        if (!kotlin.jvm.internal.l.a(objInvoke, x6.a.f13718a)) {
            this.e = null;
        }
        return objInvoke;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        try {
            Object objA = a(cVar, obj);
            return objA == x6.a.f13718a ? objA : w.f12711a;
        } catch (Throwable th) {
            this.f13198d = new h(th, cVar.getContext());
            throw th;
        }
    }

    @Override // y6.a, y6.d
    public final y6.d getCallerFrame() {
        w6.c cVar = this.e;
        if (cVar instanceof y6.d) {
            return (y6.d) cVar;
        }
        return null;
    }

    @Override // y6.c, w6.c
    public final w6.h getContext() {
        w6.h hVar = this.f13198d;
        return hVar == null ? w6.i.f13523a : hVar;
    }

    @Override // y6.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = s6.k.a(obj);
        if (thA != null) {
            this.f13198d = new h(thA, getContext());
        }
        w6.c cVar = this.e;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return x6.a.f13718a;
    }
}
