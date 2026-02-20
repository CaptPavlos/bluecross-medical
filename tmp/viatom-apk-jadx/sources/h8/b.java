package h8;

import com.google.android.gms.internal.measurement.p4;
import h0.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f8825d = new b();

    /* renamed from: a, reason: collision with root package name */
    public final h f8826a;

    /* renamed from: b, reason: collision with root package name */
    public final j8.f f8827b;

    /* renamed from: c, reason: collision with root package name */
    public final y2.c f8828c;

    public b() {
        h hVar = new h();
        j8.d dVar = j8.h.f10036a;
        this.f8826a = hVar;
        this.f8827b = dVar;
        this.f8828c = new y2.c(17);
    }

    public final Object a(c8.a aVar, String str) {
        aVar.getClass();
        this.f8826a.getClass();
        a6.f fVar = new a6.f(str);
        Object objDecodeSerializableValue = new i8.t(this, i8.x.f9101c, fVar, aVar.getDescriptor(), null).decodeSerializableValue(aVar);
        if (fVar.h() == 10) {
            return objDecodeSerializableValue;
        }
        a6.f.o(fVar, "Expected EOF after parsing, but had " + str.charAt(fVar.f256b - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final String b(c8.g gVar, Object obj) {
        char[] cArr;
        gVar.getClass();
        a0 a0Var = new a0(1);
        i8.c cVar = i8.c.f9064c;
        synchronized (cVar) {
            t6.i iVar = cVar.f9065a;
            cArr = null;
            char[] cArr2 = (char[]) (iVar.isEmpty() ? null : iVar.removeLast());
            if (cArr2 != null) {
                cVar.f9066b -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        a0Var.f8353c = cArr;
        try {
            i8.x xVar = i8.x.f9101c;
            i8.u[] uVarArr = new i8.u[i8.x.h.size()];
            this.f8826a.getClass();
            new i8.u(new p4(a0Var), this, xVar, uVarArr).encodeSerializableValue(gVar, obj);
            return a0Var.toString();
        } finally {
            a0Var.h();
        }
    }
}
