package i8;

import com.google.android.gms.internal.measurement.a4;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.util.Map;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final m f9075a = new m();

    public static final h a(Number number, String str, String str2) {
        str.getClass();
        str2.getClass();
        return d(-1, "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(str2, -1)));
    }

    public static final k b(Number number, String str) {
        return new k("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(str, -1)));
    }

    public static final k c(e8.e eVar) {
        return new k("Value of type '" + eVar.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + eVar.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final h d(int i10, String str) {
        if (i10 >= 0) {
            str = "Unexpected JSON token at offset " + i10 + ": " + str;
        }
        return new h(str);
    }

    public static final h e(String str, CharSequence charSequence, int i10) {
        charSequence.getClass();
        return d(i10, str + "\nJSON input: " + ((Object) k(charSequence, i10)));
    }

    public static final e8.e f(e8.e eVar, j8.f fVar) {
        e8.e eVarF;
        eVar.getClass();
        fVar.getClass();
        if (!kotlin.jvm.internal.l.a(eVar.getKind(), e8.g.f7971c)) {
            return eVar.isInline() ? f(eVar.h(0), fVar) : eVar;
        }
        m7.c cVarT = t1.t(eVar);
        e8.e descriptor = null;
        if (cVarT != null) {
            j8.c cVar = (j8.c) ((j8.d) fVar).f10032a.get(cVarT);
            c8.b bVarA = cVar != null ? cVar.a(t6.t.f12808a) : null;
            c8.b bVar = bVarA instanceof c8.b ? bVarA : null;
            if (bVar != null) {
                descriptor = bVar.getDescriptor();
            }
        }
        return (descriptor == null || (eVarF = f(descriptor, fVar)) == null) ? eVar : eVarF;
    }

    public static final byte g(char c10) {
        if (c10 < '~') {
            return d.f9068b[c10];
        }
        return (byte) 0;
    }

    public static final String h(e8.e eVar, h8.b bVar) {
        eVar.getClass();
        bVar.getClass();
        for (Annotation annotation : eVar.getAnnotations()) {
            if (annotation instanceof h8.g) {
                return ((h8.g) annotation).discriminator();
            }
        }
        return bVar.f8826a.f8837c;
    }

    public static final int i(e8.e eVar, h8.b bVar, String str) {
        eVar.getClass();
        bVar.getClass();
        str.getClass();
        h8.h hVar = bVar.f8826a;
        hVar.getClass();
        l(eVar, bVar);
        int iD = eVar.d(str);
        if (iD != -3 || !hVar.f8838d) {
            return iD;
        }
        y2.c cVar = bVar.f8828c;
        androidx.work.impl.utils.c cVar2 = new androidx.work.impl.utils.c(7, eVar, bVar);
        cVar.getClass();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) cVar.f13781b;
        Map map = (Map) concurrentHashMap.get(eVar);
        m mVar = f9075a;
        Object obj = map != null ? map.get(mVar) : null;
        Object objInvoke = obj != null ? obj : null;
        if (objInvoke == null) {
            objInvoke = cVar2.invoke();
            Object concurrentHashMap2 = concurrentHashMap.get(eVar);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(eVar, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(mVar, objInvoke);
        }
        Integer num = (Integer) ((Map) objInvoke).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final void j(a6.f fVar, String str) {
        fVar.n(fVar.f256b - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence k(CharSequence charSequence, int i10) {
        charSequence.getClass();
        if (charSequence.length() >= 200) {
            if (i10 != -1) {
                int i11 = i10 - 30;
                int i12 = i10 + 30;
                String str = i11 <= 0 ? "" : ".....";
                String str2 = i12 >= charSequence.length() ? "" : ".....";
                StringBuilder sbV = a3.a.v(str);
                if (i11 < 0) {
                    i11 = 0;
                }
                int length = charSequence.length();
                if (i12 > length) {
                    i12 = length;
                }
                sbV.append(charSequence.subSequence(i11, i12).toString());
                sbV.append(str2);
                return sbV.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void l(e8.e eVar, h8.b bVar) {
        eVar.getClass();
        bVar.getClass();
        if (kotlin.jvm.internal.l.a(eVar.getKind(), e8.i.f7973c)) {
            bVar.f8826a.getClass();
        }
    }

    public static final Object m(h8.b bVar, String str, h8.t tVar, c8.a aVar) {
        bVar.getClass();
        str.getClass();
        return new o(bVar, tVar, str, aVar.getDescriptor()).decodeSerializableValue(aVar);
    }

    public static final x n(e8.e eVar, h8.b bVar) {
        eVar.getClass();
        a4 kind = eVar.getKind();
        if (kind instanceof e8.c) {
            return x.f;
        }
        if (kotlin.jvm.internal.l.a(kind, e8.i.f7974d)) {
            return x.f9102d;
        }
        if (!kotlin.jvm.internal.l.a(kind, e8.i.e)) {
            return x.f9101c;
        }
        e8.e eVarF = f(eVar.h(0), bVar.f8827b);
        a4 kind2 = eVarF.getKind();
        if ((kind2 instanceof e8.d) || kotlin.jvm.internal.l.a(kind2, e8.h.f7972c)) {
            return x.e;
        }
        bVar.f8826a.getClass();
        throw c(eVarF);
    }

    public static final void o(a6.f fVar, Number number) {
        a6.f.o(fVar, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final String p(byte b10) {
        return b10 == 1 ? "quotation mark '\"'" : b10 == 2 ? "string escape sequence '\\'" : b10 == 4 ? "comma ','" : b10 == 5 ? "colon ':'" : b10 == 6 ? "start of the object '{'" : b10 == 7 ? "end of the object '}'" : b10 == 8 ? "start of the array '['" : b10 == 9 ? "end of the array ']'" : b10 == 10 ? "end of the input" : b10 == 127 ? "invalid token" : "valid token";
    }
}
