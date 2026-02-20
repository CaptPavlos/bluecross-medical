package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final w2.r f1928a;

    /* renamed from: b, reason: collision with root package name */
    public w2.r f1929b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.x f1930c;

    /* renamed from: d, reason: collision with root package name */
    public final t f1931d;

    public e0() {
        w2.r rVar = new w2.r(8);
        this.f1928a = rVar;
        this.f1929b = ((w2.r) rVar.f13463c).N();
        this.f1930c = new a3.x(13);
        this.f1931d = new t(3);
        final int i10 = 1;
        Callable callable = new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f1869b;

            {
                this.f1869b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i10) {
                    case 0:
                        return new l4(this.f1869b.f1930c);
                    default:
                        return new l4(this.f1869b.f1931d);
                }
            }
        };
        c6 c6Var = (c6) rVar.e;
        ((HashMap) c6Var.f1904a).put("internal.registerCallback", callable);
        final int i11 = 0;
        ((HashMap) c6Var.f1904a).put("internal.eventLogger", new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f1869b;

            {
                this.f1869b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i11) {
                    case 0:
                        return new l4(this.f1869b.f1930c);
                    default:
                        return new l4(this.f1869b.f1931d);
                }
            }
        });
    }

    public final boolean a(b bVar) throws r0 {
        a3.x xVar = this.f1930c;
        try {
            xVar.f181b = bVar;
            xVar.f182c = bVar.clone();
            ((ArrayList) xVar.f183d).clear();
            ((w2.r) this.f1928a.f13464d).P("runtime.counter", new g(Double.valueOf(0.0d)));
            this.f1931d.d(this.f1929b.N(), xVar);
            if (((b) xVar.f182c).equals((b) xVar.f181b)) {
                return !((ArrayList) xVar.f183d).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new r0(th);
        }
    }

    public final void b(w3 w3Var) {
        h hVar;
        try {
            w2.r rVar = this.f1928a;
            this.f1929b = ((w2.r) rVar.f13463c).N();
            if (rVar.K(this.f1929b, (x3[]) w3Var.p().toArray(new x3[0])) instanceof f) {
                throw new IllegalStateException("Program loading failed");
            }
            for (v3 v3Var : w3Var.q().p()) {
                List listQ = v3Var.q();
                String strP = v3Var.p();
                Iterator it = listQ.iterator();
                while (it.hasNext()) {
                    n nVarK = rVar.K(this.f1929b, (x3) it.next());
                    if (!(nVarK instanceof k)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    w2.r rVar2 = this.f1929b;
                    if (rVar2.O(strP)) {
                        n nVarR = rVar2.R(strP);
                        if (!(nVarR instanceof h)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strP)));
                        }
                        hVar = (h) nVarR;
                    } else {
                        hVar = null;
                    }
                    if (hVar == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strP)));
                    }
                    hVar.a(this.f1929b, Collections.singletonList(nVarK));
                }
            }
        } catch (Throwable th) {
            throw new r0(th);
        }
    }
}
