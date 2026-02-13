package i8;

import com.google.android.gms.internal.measurement.p4;
import h0.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends f8.b {

    /* renamed from: a, reason: collision with root package name */
    public final p4 f9093a;

    /* renamed from: b, reason: collision with root package name */
    public final h8.b f9094b;

    /* renamed from: c, reason: collision with root package name */
    public final x f9095c;

    /* renamed from: d, reason: collision with root package name */
    public final u[] f9096d;
    public final j8.f e;
    public final h8.h f;
    public boolean g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f9097i;

    public u(p4 p4Var, h8.b bVar, x xVar, u[] uVarArr) {
        p4Var.getClass();
        this.f9093a = p4Var;
        this.f9094b = bVar;
        this.f9095c = xVar;
        this.f9096d = uVarArr;
        this.e = bVar.f8827b;
        this.f = bVar.f8826a;
        int iOrdinal = xVar.ordinal();
        if (uVarArr != null) {
            u uVar = uVarArr[iOrdinal];
            if (uVar == null && uVar == this) {
                return;
            }
            uVarArr[iOrdinal] = this;
        }
    }

    @Override // f8.b, f8.f
    public final f8.d beginStructure(e8.e eVar) {
        u uVar;
        eVar.getClass();
        h8.b bVar = this.f9094b;
        x xVarN = l.n(eVar, bVar);
        char c10 = xVarN.f9103a;
        p4 p4Var = this.f9093a;
        p4Var.d(c10);
        p4Var.f2128a = true;
        String str = this.h;
        if (str != null) {
            String strA = this.f9097i;
            if (strA == null) {
                strA = eVar.a();
            }
            p4Var.b();
            p4Var.h(str);
            p4Var.d(':');
            encodeString(strA);
            this.h = null;
            this.f9097i = null;
        }
        if (this.f9095c == xVarN) {
            return this;
        }
        u[] uVarArr = this.f9096d;
        return (uVarArr == null || (uVar = uVarArr[xVarN.ordinal()]) == null) ? new u(p4Var, bVar, xVarN, uVarArr) : uVar;
    }

    @Override // f8.b, f8.f
    public final void encodeBoolean(boolean z9) {
        if (this.g) {
            encodeString(String.valueOf(z9));
        } else {
            ((a0) this.f9093a.f2129b).j(String.valueOf(z9));
        }
    }

    @Override // f8.b, f8.f
    public final void encodeByte(byte b10) {
        if (this.g) {
            encodeString(String.valueOf((int) b10));
        } else {
            this.f9093a.c(b10);
        }
    }

    @Override // f8.b, f8.f
    public final void encodeChar(char c10) {
        encodeString(String.valueOf(c10));
    }

    @Override // f8.b, f8.f
    public final void encodeDouble(double d8) {
        boolean z9 = this.g;
        p4 p4Var = this.f9093a;
        if (z9) {
            encodeString(String.valueOf(d8));
        } else {
            ((a0) p4Var.f2129b).j(String.valueOf(d8));
        }
        this.f.getClass();
        if (Double.isInfinite(d8) || Double.isNaN(d8)) {
            throw l.b(Double.valueOf(d8), ((a0) p4Var.f2129b).toString());
        }
    }

    @Override // f8.b
    public final boolean encodeElement(e8.e eVar, int i10) {
        eVar.getClass();
        int iOrdinal = this.f9095c.ordinal();
        p4 p4Var = this.f9093a;
        if (iOrdinal == 1) {
            if (!p4Var.f2128a) {
                p4Var.d(',');
            }
            p4Var.b();
            return true;
        }
        boolean z9 = false;
        if (iOrdinal == 2) {
            if (p4Var.f2128a) {
                this.g = true;
                p4Var.b();
                return true;
            }
            if (i10 % 2 == 0) {
                p4Var.d(',');
                p4Var.b();
                z9 = true;
            } else {
                p4Var.d(':');
                p4Var.i();
            }
            this.g = z9;
            return true;
        }
        if (iOrdinal == 3) {
            if (i10 == 0) {
                this.g = true;
            }
            if (i10 == 1) {
                p4Var.d(',');
                p4Var.i();
                this.g = false;
            }
            return true;
        }
        if (!p4Var.f2128a) {
            p4Var.d(',');
        }
        p4Var.b();
        l.l(eVar, this.f9094b);
        encodeString(eVar.f(i10));
        p4Var.d(':');
        p4Var.i();
        return true;
    }

    @Override // f8.b, f8.f
    public final void encodeFloat(float f) {
        boolean z9 = this.g;
        p4 p4Var = this.f9093a;
        if (z9) {
            encodeString(String.valueOf(f));
        } else {
            ((a0) p4Var.f2129b).j(String.valueOf(f));
        }
        this.f.getClass();
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw l.b(Float.valueOf(f), ((a0) p4Var.f2129b).toString());
        }
    }

    @Override // f8.b, f8.f
    public final f8.f encodeInline(e8.e eVar) {
        eVar.getClass();
        boolean zA = v.a(eVar);
        x xVar = this.f9095c;
        h8.b bVar = this.f9094b;
        p4 eVar2 = this.f9093a;
        if (zA) {
            if (!(eVar2 instanceof f)) {
                eVar2 = new f((a0) eVar2.f2129b, this.g);
            }
            return new u(eVar2, bVar, xVar, null);
        }
        if (eVar.isInline() && eVar.equals(h8.l.f8839a)) {
            if (!(eVar2 instanceof e)) {
                eVar2 = new e((a0) eVar2.f2129b, this.g);
            }
            return new u(eVar2, bVar, xVar, null);
        }
        if (this.h == null) {
            return super.encodeInline(eVar);
        }
        this.f9097i = eVar.a();
        return this;
    }

    @Override // f8.b, f8.f
    public final void encodeInt(int i10) {
        if (this.g) {
            encodeString(String.valueOf(i10));
        } else {
            this.f9093a.e(i10);
        }
    }

    @Override // f8.b, f8.f
    public final void encodeLong(long j10) {
        if (this.g) {
            encodeString(String.valueOf(j10));
        } else {
            this.f9093a.f(j10);
        }
    }

    @Override // f8.f
    public final void encodeNull() {
        p4 p4Var = this.f9093a;
        p4Var.getClass();
        ((a0) p4Var.f2129b).j("null");
    }

    @Override // f8.b, f8.d
    public final void encodeNullableSerializableElement(e8.e eVar, int i10, c8.g gVar, Object obj) {
        eVar.getClass();
        gVar.getClass();
        if (obj != null || this.f.f8835a) {
            super.encodeNullableSerializableElement(eVar, i10, gVar, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    @Override // f8.b, f8.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void encodeSerializableValue(c8.g r5, java.lang.Object r6) {
        /*
            r4 = this;
            r5.getClass()
            h8.b r0 = r4.f9094b
            h8.h r1 = r0.f8826a
            r1.getClass()
            boolean r2 = r5 instanceof g8.b
            h8.a r1 = r1.e
            if (r2 == 0) goto L15
            h8.a r3 = h8.a.f8822a
            if (r1 == r3) goto L47
            goto L3e
        L15:
            int r1 = r1.ordinal()
            if (r1 == 0) goto L47
            r3 = 1
            if (r1 == r3) goto L26
            r0 = 2
            if (r1 != r0) goto L22
            goto L47
        L22:
            androidx.window.layout.c.b()
            return
        L26:
            e8.e r1 = r5.getDescriptor()
            com.google.android.gms.internal.measurement.a4 r1 = r1.getKind()
            e8.i r3 = e8.i.f7973c
            boolean r3 = kotlin.jvm.internal.l.a(r1, r3)
            if (r3 != 0) goto L3e
            e8.i r3 = e8.i.f
            boolean r1 = kotlin.jvm.internal.l.a(r1, r3)
            if (r1 == 0) goto L47
        L3e:
            e8.e r1 = r5.getDescriptor()
            java.lang.String r0 = i8.l.h(r1, r0)
            goto L48
        L47:
            r0 = 0
        L48:
            if (r2 == 0) goto La9
            r1 = r5
            g8.b r1 = (g8.b) r1
            if (r6 == 0) goto L9b
            c8.g r1 = com.google.android.gms.internal.measurement.l5.v(r1, r4, r6)
            if (r0 == 0) goto L70
            boolean r5 = r5 instanceof c8.e
            if (r5 != 0) goto L5a
            goto L70
        L5a:
            e8.e r5 = r1.getDescriptor()
            r5.getClass()
            java.util.Set r5 = g8.o0.b(r5)
            boolean r5 = r5.contains(r0)
            if (r5 != 0) goto L6c
            goto L70
        L6c:
            com.google.gson.internal.a.k()
            return
        L70:
            e8.e r5 = r1.getDescriptor()
            com.google.android.gms.internal.measurement.a4 r5 = r5.getKind()
            r5.getClass()
            boolean r2 = r5 instanceof e8.h
            if (r2 != 0) goto L95
            boolean r2 = r5 instanceof e8.d
            if (r2 != 0) goto L8f
            boolean r5 = r5 instanceof e8.c
            if (r5 != 0) goto L89
            r5 = r1
            goto La9
        L89:
            java.lang.String r5 = "Actual serializer for polymorphic cannot be polymorphic itself"
            androidx.window.layout.c.g(r5)
            return
        L8f:
            java.lang.String r5 = "Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            androidx.window.layout.c.g(r5)
            return
        L95:
            java.lang.String r5 = "Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            androidx.window.layout.c.g(r5)
            return
        L9b:
            c8.d r1 = (c8.d) r1
            e8.e r5 = r1.getDescriptor()
            java.lang.String r6 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            java.lang.String r0 = "Value for serializer "
            androidx.core.view.accessibility.a.t(r5, r0, r6)
            return
        La9:
            if (r0 == 0) goto Lb7
            e8.e r1 = r5.getDescriptor()
            java.lang.String r1 = r1.a()
            r4.h = r0
            r4.f9097i = r1
        Lb7:
            r5.serialize(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.u.encodeSerializableValue(c8.g, java.lang.Object):void");
    }

    @Override // f8.b, f8.f
    public final void encodeShort(short s9) {
        if (this.g) {
            encodeString(String.valueOf((int) s9));
        } else {
            this.f9093a.g(s9);
        }
    }

    @Override // f8.b, f8.f
    public final void encodeString(String str) {
        str.getClass();
        this.f9093a.h(str);
    }

    @Override // f8.b, f8.d
    public final void endStructure(e8.e eVar) {
        eVar.getClass();
        p4 p4Var = this.f9093a;
        p4Var.getClass();
        p4Var.f2128a = false;
        p4Var.d(this.f9095c.f9104b);
    }

    @Override // f8.f
    public final j8.f getSerializersModule() {
        return this.e;
    }

    @Override // f8.b, f8.d
    public final boolean shouldEncodeElementDefault(e8.e eVar, int i10) {
        eVar.getClass();
        this.f.getClass();
        return false;
    }
}
