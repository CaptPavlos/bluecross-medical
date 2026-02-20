package f9;

import c1.d0;
import com.google.android.gms.internal.measurement.a4;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public int f8176a;

    /* renamed from: b, reason: collision with root package name */
    public int f8177b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f8178c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f8179d;
    public final Object e;
    public Object f;
    public final Object g;

    public p(Class cls, Class[] clsArr) {
        this.f8178c = null;
        HashSet hashSet = new HashSet();
        this.f8179d = hashSet;
        this.e = new HashSet();
        this.f8176a = 0;
        this.f8177b = 0;
        this.g = new HashSet();
        hashSet.add(q1.q.a(cls));
        for (Class cls2 : clsArr) {
            a4.i(cls2, "Null interface");
            ((HashSet) this.f8179d).add(q1.q.a(cls2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(y6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof f9.o
            if (r0 == 0) goto L13
            r0 = r5
            f9.o r0 = (f9.o) r0
            int r1 = r0.f8175d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8175d = r1
            goto L18
        L13:
            f9.o r0 = new f9.o
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8173b
            int r1 = r0.f8175d
            r2 = 1
            r3 = 42
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            f9.p r0 = r0.f8172a
            s6.a.e(r5)     // Catch: d6.a -> L6f
            goto L53
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L30:
            s6.a.e(r5)
            java.lang.Object r5 = r4.f8179d     // Catch: d6.a -> L6e
            y2.c r5 = (y2.c) r5     // Catch: d6.a -> L6e
            boolean r5 = r5.v()     // Catch: d6.a -> L6e
            if (r5 == 0) goto L56
            java.lang.Object r5 = r4.e     // Catch: d6.a -> L6e
            c1.d0 r5 = (c1.d0) r5     // Catch: d6.a -> L6e
            java.lang.String r1 = r4.b()     // Catch: d6.a -> L6e
            r0.f8172a = r4     // Catch: d6.a -> L6e
            r0.f8175d = r2     // Catch: d6.a -> L6e
            java.lang.Object r5 = r5.k(r1, r0)     // Catch: d6.a -> L6e
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L52
            return r0
        L52:
            r0 = r4
        L53:
            java.lang.String r5 = (java.lang.String) r5     // Catch: d6.a -> L6f
            goto L77
        L56:
            com.inmobi.cmp.ChoiceCmp r5 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: d6.a -> L6e
            com.inmobi.cmp.ChoiceCmpCallback r5 = r5.getCallback()     // Catch: d6.a -> L6e
            if (r5 != 0) goto L5f
            goto L64
        L5f:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L6e
            r5.onCmpError(r0)     // Catch: d6.a -> L6e
        L64:
            java.lang.Object r5 = r4.f     // Catch: d6.a -> L6e
            d0.i r5 = (d0.i) r5     // Catch: d6.a -> L6e
            java.lang.String r5 = r5.t(r3)     // Catch: d6.a -> L6e
            r0 = r4
            goto L77
        L6e:
            r0 = r4
        L6f:
            java.lang.Object r5 = r0.f
            d0.i r5 = (d0.i) r5
            java.lang.String r5 = r5.t(r3)
        L77:
            java.lang.Object r1 = r0.f
            d0.i r1 = (d0.i) r1
            r1.p(r3, r5)
            java.lang.Object r0 = r0.g
            g4.b r0 = (g4.b) r0
            java.lang.Object r5 = r0.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.p.a(y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b() {
        /*
            r4 = this;
            int r0 = r4.f8177b
            int r1 = r4.f8176a
            r2 = 1
            r3 = 2
            if (r1 != r3) goto L2c
            if (r0 == 0) goto L2a
            java.lang.String r1 = m8.e.d(r0)
            int r1 = r1.length()
            if (r1 <= 0) goto L2c
            m8.e.f11254j = r3
            java.lang.String r0 = m8.e.d(r0)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r3 = 0
            r1[r3] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r2)
            java.lang.String r1 = "us-mspa/v1/purposes-state-%s-"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            goto L30
        L2a:
            r0 = 0
            throw r0
        L2c:
            m8.e.f11254j = r2
            java.lang.String r0 = "us-mspa/v1/purposes-national-"
        L30:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "https://cmp.inmobi.com/"
            r1.<init>(r2)
            r1.append(r0)
            java.io.Serializable r0 = r4.f8178c
            java.util.Locale r0 = (java.util.Locale) r0
            java.lang.String r2 = "en"
            java.lang.String r0 = r2.toLowerCase(r0)
            r0.getClass()
            r1.append(r0)
            java.lang.String r0 = ".json"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.p.b():java.lang.String");
    }

    public void c(q1.i iVar) {
        if (((HashSet) this.f8179d).contains(iVar.f12235a)) {
            com.google.gson.internal.a.n("Components are not allowed to depend on interfaces they themselves provide.");
        } else {
            ((HashSet) this.e).add(iVar);
        }
    }

    public q1.a d() {
        if (((q1.d) this.f) != null) {
            return new q1.a((String) this.f8178c, new HashSet((HashSet) this.f8179d), new HashSet((HashSet) this.e), this.f8176a, this.f8177b, (q1.d) this.f, (HashSet) this.g);
        }
        androidx.window.layout.c.g("Missing required property: factory.");
        return null;
    }

    public void e(int i10) {
        if (this.f8176a == 0) {
            this.f8176a = i10;
        } else {
            androidx.window.layout.c.g("Instantiation type has already been set.");
        }
    }

    public p(Locale locale, y2.c cVar, d0 d0Var, d0.i iVar, int i10, int i11, g4.b bVar) {
        if (i10 != 0 && i11 != 0) {
            this.f8178c = locale;
            this.f8179d = cVar;
            this.e = d0Var;
            this.f = iVar;
            this.f8176a = i10;
            this.f8177b = i11;
            this.g = bVar;
            return;
        }
        throw null;
    }

    public p(q1.q qVar, q1.q[] qVarArr) {
        this.f8178c = null;
        HashSet hashSet = new HashSet();
        this.f8179d = hashSet;
        this.e = new HashSet();
        this.f8176a = 0;
        this.f8177b = 0;
        this.g = new HashSet();
        hashSet.add(qVar);
        for (q1.q qVar2 : qVarArr) {
            a4.i(qVar2, "Null interface");
        }
        Collections.addAll((HashSet) this.f8179d, qVarArr);
    }
}
