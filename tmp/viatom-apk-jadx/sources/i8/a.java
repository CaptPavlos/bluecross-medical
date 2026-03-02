package i8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import g8.f0;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements h8.i, f8.e, f8.c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9059a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f9060b;

    /* renamed from: c, reason: collision with root package name */
    public final h8.b f9061c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9062d;
    public final h8.h e;

    public a(h8.b bVar, String str) {
        this.f9061c = bVar;
        this.f9062d = str;
        this.e = bVar.f8826a;
    }

    @Override // h8.i
    public final h8.k a() {
        return c();
    }

    public abstract h8.k b(String str);

    @Override // f8.e
    public f8.c beginStructure(e8.e eVar) {
        eVar.getClass();
        h8.k kVarC = c();
        a4 kind = eVar.getKind();
        boolean zA = kotlin.jvm.internal.l.a(kind, e8.i.f7974d);
        h8.b bVar = this.f9061c;
        if (zA || (kind instanceof e8.c)) {
            String strA = eVar.a();
            if (kVarC instanceof h8.d) {
                return new p(bVar, (h8.d) kVarC);
            }
            throw l.e("Expected " + y.a(h8.d.class).c() + ", but had " + y.a(kVarC.getClass()).c() + " as the serialized body of " + strA + " at element: " + r(), kVarC.toString(), -1);
        }
        if (!kotlin.jvm.internal.l.a(kind, e8.i.e)) {
            String strA2 = eVar.a();
            if (kVarC instanceof h8.t) {
                return new o(bVar, (h8.t) kVarC, this.f9062d, 8);
            }
            throw l.e("Expected " + y.a(h8.t.class).c() + ", but had " + y.a(kVarC.getClass()).c() + " as the serialized body of " + strA2 + " at element: " + r(), kVarC.toString(), -1);
        }
        e8.e eVarF = l.f(eVar.h(0), bVar.f8827b);
        a4 kind2 = eVarF.getKind();
        if (!(kind2 instanceof e8.d) && !kotlin.jvm.internal.l.a(kind2, e8.h.f7972c)) {
            bVar.f8826a.getClass();
            throw l.c(eVarF);
        }
        String strA3 = eVar.a();
        if (kVarC instanceof h8.t) {
            return new q(bVar, (h8.t) kVarC);
        }
        throw l.e("Expected " + y.a(h8.t.class).c() + ", but had " + y.a(kVarC.getClass()).c() + " as the serialized body of " + strA3 + " at element: " + r(), kVarC.toString(), -1);
    }

    public final h8.k c() {
        h8.k kVarB;
        String str = (String) t6.l.j0(this.f9059a);
        return (str == null || (kVarB = b(str)) == null) ? p() : kVarB;
    }

    public final boolean d(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of boolean at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            g8.y yVar = h8.l.f8839a;
            String strC = xVar.c();
            String[] strArr = w.f9099a;
            strC.getClass();
            Boolean bool = strC.equalsIgnoreCase("true") ? Boolean.TRUE : strC.equalsIgnoreCase("false") ? Boolean.FALSE : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            t(xVar, TypedValues.Custom.S_BOOLEAN, str);
            throw null;
        } catch (IllegalArgumentException unused) {
            t(xVar, TypedValues.Custom.S_BOOLEAN, str);
            throw null;
        }
    }

    @Override // f8.e
    public final boolean decodeBoolean() {
        return d(q());
    }

    @Override // f8.c
    public final boolean decodeBooleanElement(e8.e eVar, int i10) {
        eVar.getClass();
        return d(o(eVar, i10));
    }

    @Override // f8.e
    public final byte decodeByte() {
        return e(q());
    }

    @Override // f8.c
    public final byte decodeByteElement(e8.e eVar, int i10) {
        eVar.getClass();
        return e(o(eVar, i10));
    }

    @Override // f8.e
    public final char decodeChar() {
        return f(q());
    }

    @Override // f8.c
    public final char decodeCharElement(e8.e eVar, int i10) {
        eVar.getClass();
        return f(o(eVar, i10));
    }

    @Override // f8.c
    public final int decodeCollectionSize(e8.e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // f8.e
    public final double decodeDouble() {
        return g(q());
    }

    @Override // f8.c
    public final double decodeDoubleElement(e8.e eVar, int i10) {
        eVar.getClass();
        return g(o(eVar, i10));
    }

    @Override // f8.e
    public final float decodeFloat() {
        return h(q());
    }

    @Override // f8.c
    public final float decodeFloatElement(e8.e eVar, int i10) {
        eVar.getClass();
        return h(o(eVar, i10));
    }

    @Override // f8.e
    public final f8.e decodeInline(e8.e eVar) {
        eVar.getClass();
        if (t6.l.j0(this.f9059a) != null) {
            return i(q(), eVar);
        }
        return new n(this.f9061c, p(), this.f9062d).decodeInline(eVar);
    }

    @Override // f8.c
    public final f8.e decodeInlineElement(e8.e eVar, int i10) {
        eVar.getClass();
        return i(o(eVar, i10), ((f0) eVar).h(i10));
    }

    @Override // f8.e
    public final int decodeInt() {
        return j(q());
    }

    @Override // f8.c
    public final int decodeIntElement(e8.e eVar, int i10) {
        eVar.getClass();
        return j(o(eVar, i10));
    }

    @Override // f8.e
    public final long decodeLong() {
        return k(q());
    }

    @Override // f8.c
    public final long decodeLongElement(e8.e eVar, int i10) {
        eVar.getClass();
        return k(o(eVar, i10));
    }

    @Override // f8.e
    public boolean decodeNotNullMark() {
        return !(c() instanceof h8.q);
    }

    @Override // f8.e
    public final Void decodeNull() {
        return null;
    }

    @Override // f8.c
    public final Object decodeNullableSerializableElement(e8.e eVar, int i10, c8.a aVar, Object obj) {
        eVar.getClass();
        aVar.getClass();
        this.f9059a.add(o(eVar, i10));
        Object objDecodeSerializableValue = (aVar.getDescriptor().c() || decodeNotNullMark()) ? decodeSerializableValue(aVar) : null;
        if (!this.f9060b) {
            q();
        }
        this.f9060b = false;
        return objDecodeSerializableValue;
    }

    @Override // f8.c
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // f8.c
    public final Object decodeSerializableElement(e8.e eVar, int i10, c8.a aVar, Object obj) {
        eVar.getClass();
        aVar.getClass();
        this.f9059a.add(o(eVar, i10));
        aVar.getClass();
        Object objDecodeSerializableValue = decodeSerializableValue(aVar);
        if (!this.f9060b) {
            q();
        }
        this.f9060b = false;
        return objDecodeSerializableValue;
    }

    @Override // f8.e
    public final Object decodeSerializableValue(c8.a aVar) {
        aVar.getClass();
        if (!(aVar instanceof g8.b)) {
            return aVar.deserialize(this);
        }
        h8.b bVar = this.f9061c;
        bVar.f8826a.getClass();
        c8.d dVar = (c8.d) ((g8.b) aVar);
        String strH = l.h(dVar.getDescriptor(), bVar);
        h8.k kVarC = c();
        String strA = dVar.getDescriptor().a();
        if (!(kVarC instanceof h8.t)) {
            throw l.e("Expected " + y.a(h8.t.class).c() + ", but had " + y.a(kVarC.getClass()).c() + " as the serialized body of " + strA + " at element: " + r(), kVarC.toString(), -1);
        }
        h8.t tVar = (h8.t) kVarC;
        h8.k kVar = (h8.k) tVar.get(strH);
        String strC = null;
        if (kVar != null) {
            h8.x xVarB = h8.l.b(kVar);
            if (!(xVarB instanceof h8.q)) {
                strC = xVarB.c();
            }
        }
        try {
            return l.m(bVar, strH, tVar, l5.u((g8.b) aVar, this, strC));
        } catch (c8.f e) {
            String message = e.getMessage();
            message.getClass();
            throw l.e(message, tVar.toString(), -1);
        }
    }

    @Override // f8.e
    public final short decodeShort() {
        return l(q());
    }

    @Override // f8.c
    public final short decodeShortElement(e8.e eVar, int i10) {
        eVar.getClass();
        return l(o(eVar, i10));
    }

    @Override // f8.e
    public final String decodeString() {
        return m(q());
    }

    @Override // f8.c
    public final String decodeStringElement(e8.e eVar, int i10) {
        eVar.getClass();
        return m(o(eVar, i10));
    }

    public final byte e(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of byte at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            int iA = h8.l.a(xVar);
            Byte bValueOf = (-128 > iA || iA > 127) ? null : Byte.valueOf((byte) iA);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            t(xVar, "byte", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            t(xVar, "byte", str);
            throw null;
        }
    }

    @Override // f8.c
    public void endStructure(e8.e eVar) {
        eVar.getClass();
    }

    public final char f(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of char at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            String strC = xVar.c();
            strC.getClass();
            int length = strC.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return strC.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            t(xVar, "char", str);
            throw null;
        }
    }

    public final double g(Object obj) throws NumberFormatException {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of double at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            g8.y yVar = h8.l.f8839a;
            double d8 = Double.parseDouble(xVar.c());
            this.f9061c.f8826a.getClass();
            if (Double.isInfinite(d8) || Double.isNaN(d8)) {
                throw l.a(Double.valueOf(d8), str, c().toString());
            }
            return d8;
        } catch (IllegalArgumentException unused) {
            t(xVar, "double", str);
            throw null;
        }
    }

    @Override // f8.c
    public final j8.f getSerializersModule() {
        return this.f9061c.f8827b;
    }

    public final float h(Object obj) throws NumberFormatException {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of float at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            g8.y yVar = h8.l.f8839a;
            float f = Float.parseFloat(xVar.c());
            this.f9061c.f8826a.getClass();
            if (Float.isInfinite(f) || Float.isNaN(f)) {
                throw l.a(Float.valueOf(f), str, c().toString());
            }
            return f;
        } catch (IllegalArgumentException unused) {
            t(xVar, TypedValues.Custom.S_FLOAT, str);
            throw null;
        }
    }

    public final f8.e i(Object obj, e8.e eVar) {
        String str = (String) obj;
        str.getClass();
        eVar.getClass();
        if (!v.a(eVar)) {
            this.f9059a.add(str);
            return this;
        }
        h8.k kVarB = b(str);
        String strA = eVar.a();
        if (kVarB instanceof h8.x) {
            String strC = ((h8.x) kVarB).c();
            h8.b bVar = this.f9061c;
            bVar.getClass();
            strC.getClass();
            bVar.f8826a.getClass();
            return new g(new a6.f(strC), bVar);
        }
        throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of " + strA + " at element: " + s(str), kVarB.toString(), -1);
    }

    public final int j(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (kVarB instanceof h8.x) {
            h8.x xVar = (h8.x) kVarB;
            try {
                return h8.l.a(xVar);
            } catch (IllegalArgumentException unused) {
                t(xVar, "int", str);
                throw null;
            }
        }
        throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of int at element: " + s(str), kVarB.toString(), -1);
    }

    public final long k(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (kVarB instanceof h8.x) {
            h8.x xVar = (h8.x) kVarB;
            try {
                g8.y yVar = h8.l.f8839a;
                try {
                    return new a6.f(xVar.c()).k();
                } catch (h e) {
                    throw new NumberFormatException(e.getMessage());
                }
            } catch (IllegalArgumentException unused) {
                t(xVar, "long", str);
                throw null;
            }
        }
        throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of long at element: " + s(str), kVarB.toString(), -1);
    }

    public final short l(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of short at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        try {
            int iA = h8.l.a(xVar);
            Short shValueOf = (-32768 > iA || iA > 32767) ? null : Short.valueOf((short) iA);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            t(xVar, "short", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            t(xVar, "short", str);
            throw null;
        }
    }

    public final String m(Object obj) {
        String str = (String) obj;
        str.getClass();
        h8.k kVarB = b(str);
        if (!(kVarB instanceof h8.x)) {
            throw l.e("Expected " + y.a(h8.x.class).c() + ", but had " + y.a(kVarB.getClass()).c() + " as the serialized body of string at element: " + s(str), kVarB.toString(), -1);
        }
        h8.x xVar = (h8.x) kVarB;
        if (!(xVar instanceof h8.n)) {
            StringBuilder sbY = a3.a.y("Expected string value for a non-null key '", str, "', got null literal instead at element: ");
            sbY.append(s(str));
            throw l.e(sbY.toString(), c().toString(), -1);
        }
        h8.n nVar = (h8.n) xVar;
        if (nVar.f8842a) {
            return nVar.f8843b;
        }
        this.f9061c.f8826a.getClass();
        throw l.e("String literal for key '" + str + "' should be quoted at element: " + s(str) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", c().toString(), -1);
    }

    public String n(e8.e eVar, int i10) {
        eVar.getClass();
        return eVar.f(i10);
    }

    public final String o(e8.e eVar, int i10) {
        eVar.getClass();
        String strN = n(eVar, i10);
        strN.getClass();
        return strN;
    }

    public abstract h8.k p();

    public final Object q() {
        ArrayList arrayList = this.f9059a;
        Object objRemove = arrayList.remove(t6.m.P(arrayList));
        this.f9060b = true;
        return objRemove;
    }

    public final String r() {
        ArrayList arrayList = this.f9059a;
        return arrayList.isEmpty() ? "$" : t6.l.h0(arrayList, ".", "$.", null, null, 60);
    }

    public final String s(String str) {
        str.getClass();
        return r() + '.' + str;
    }

    public final void t(h8.x xVar, String str, String str2) {
        throw l.e("Failed to parse literal '" + xVar + "' as " + (o7.u.c0(str, "i", false) ? "an " : "a ").concat(str) + " value at element: " + s(str2), c().toString(), -1);
    }
}
