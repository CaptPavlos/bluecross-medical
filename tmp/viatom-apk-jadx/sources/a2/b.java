package a2;

import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import l2.d;
import y2.c;
import z1.a2;
import z1.b0;
import z1.b1;
import z1.b2;
import z1.c0;
import z1.c1;
import z1.c2;
import z1.d0;
import z1.d2;
import z1.e;
import z1.e0;
import z1.e1;
import z1.e2;
import z1.f;
import z1.f0;
import z1.f1;
import z1.f2;
import z1.g;
import z1.g0;
import z1.g1;
import z1.g2;
import z1.h;
import z1.h0;
import z1.h2;
import z1.i;
import z1.i1;
import z1.i2;
import z1.j;
import z1.j0;
import z1.j1;
import z1.j2;
import z1.k;
import z1.k0;
import z1.k2;
import z1.l;
import z1.l0;
import z1.l2;
import z1.m;
import z1.m2;
import z1.n;
import z1.n0;
import z1.n2;
import z1.o;
import z1.o1;
import z1.p;
import z1.p0;
import z1.p1;
import z1.q;
import z1.q0;
import z1.q1;
import z1.r;
import z1.r0;
import z1.r1;
import z1.s;
import z1.s0;
import z1.s1;
import z1.t;
import z1.t0;
import z1.t1;
import z1.u;
import z1.u0;
import z1.u1;
import z1.v;
import z1.v0;
import z1.v1;
import z1.w;
import z1.w0;
import z1.w1;
import z1.x;
import z1.x0;
import z1.x1;
import z1.y;
import z1.y0;
import z1.y1;
import z1.z;
import z1.z0;
import z1.z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final c f21a;

    static {
        d dVar = new d();
        z1.d dVar2 = z1.d.f14183a;
        dVar.a(n2.class, dVar2);
        dVar.a(b0.class, dVar2);
        j jVar = j.f14251a;
        dVar.a(m2.class, jVar);
        dVar.a(j0.class, jVar);
        g gVar = g.f14218a;
        dVar.a(u1.class, gVar);
        dVar.a(k0.class, gVar);
        h hVar = h.f14225a;
        dVar.a(t1.class, hVar);
        dVar.a(l0.class, hVar);
        z zVar = z.f14395a;
        dVar.a(l2.class, zVar);
        dVar.a(j1.class, zVar);
        y yVar = y.f14387a;
        dVar.a(k2.class, yVar);
        dVar.a(i1.class, yVar);
        i iVar = i.f14232a;
        dVar.a(v1.class, iVar);
        dVar.a(n0.class, iVar);
        t tVar = t.f14353a;
        dVar.a(j2.class, tVar);
        dVar.a(p0.class, tVar);
        k kVar = k.f14269a;
        dVar.a(d2.class, kVar);
        dVar.a(q0.class, kVar);
        m mVar = m.f14288a;
        dVar.a(b2.class, mVar);
        dVar.a(r0.class, mVar);
        p pVar = p.f14321a;
        dVar.a(a2.class, pVar);
        dVar.a(v0.class, pVar);
        q qVar = q.f14329a;
        dVar.a(z1.class, qVar);
        dVar.a(x0.class, qVar);
        n nVar = n.f14302a;
        dVar.a(x1.class, nVar);
        dVar.a(t0.class, nVar);
        z1.b bVar = z1.b.f14155a;
        dVar.a(p1.class, bVar);
        dVar.a(d0.class, bVar);
        z1.a aVar = z1.a.f14138a;
        dVar.a(o1.class, aVar);
        dVar.a(e0.class, aVar);
        o oVar = o.f14313a;
        dVar.a(y1.class, oVar);
        dVar.a(u0.class, oVar);
        l lVar = l.f14280a;
        dVar.a(w1.class, lVar);
        dVar.a(s0.class, lVar);
        z1.c cVar = z1.c.f14173a;
        dVar.a(q1.class, cVar);
        dVar.a(f0.class, cVar);
        r rVar = r.f14337a;
        dVar.a(c2.class, rVar);
        dVar.a(z0.class, rVar);
        s sVar = s.f14345a;
        dVar.a(e2.class, sVar);
        dVar.a(b1.class, sVar);
        u uVar = u.f14362a;
        dVar.a(f2.class, uVar);
        dVar.a(c1.class, uVar);
        x xVar = x.f14381a;
        dVar.a(i2.class, xVar);
        dVar.a(g1.class, xVar);
        v vVar = v.f14367a;
        dVar.a(h2.class, vVar);
        dVar.a(e1.class, vVar);
        w wVar = w.f14374a;
        dVar.a(g2.class, wVar);
        dVar.a(f1.class, wVar);
        e eVar = e.f14201a;
        dVar.a(s1.class, eVar);
        dVar.a(g0.class, eVar);
        f fVar = f.f14211a;
        dVar.a(r1.class, fVar);
        dVar.a(h0.class, fVar);
        dVar.f10197d = true;
        f21a = new c(dVar, 21);
    }

    public static x0 a(JsonReader jsonReader) throws IOException {
        w0 w0Var = new w0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    w0Var.f14380d = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 2);
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        androidx.window.layout.c.k("Null symbol");
                        return null;
                    }
                    w0Var.f14378b = strNextString;
                    break;
                case "pc":
                    w0Var.f14377a = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 1);
                    break;
                case "file":
                    w0Var.f14379c = jsonReader.nextString();
                    break;
                case "importance":
                    w0Var.e = jsonReader.nextInt();
                    w0Var.f = (byte) (w0Var.f | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return w0Var.a();
    }

    public static f0 b(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
                if (strNextString == null) {
                    androidx.window.layout.c.k("Null key");
                    return null;
                }
            } else if (strNextName.equals("value")) {
                strNextString2 = jsonReader.nextString();
                if (strNextString2 == null) {
                    androidx.window.layout.c.k("Null value");
                    return null;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (strNextString != null && strNextString2 != null) {
            return new f0(strNextString, strNextString2);
        }
        StringBuilder sb = new StringBuilder();
        if (strNextString == null) {
            sb.append(" key");
        }
        if (strNextString2 == null) {
            sb.append(" value");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }

    public static d0 c(JsonReader jsonReader) throws IOException {
        c0 c0Var = new c0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "buildIdMappingForArch":
                    c0Var.f14180i = d(jsonReader, new a(0));
                    break;
                case "pid":
                    c0Var.f14176a = jsonReader.nextInt();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 1);
                    break;
                case "pss":
                    c0Var.e = jsonReader.nextLong();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 8);
                    break;
                case "rss":
                    c0Var.f = jsonReader.nextLong();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 16);
                    break;
                case "timestamp":
                    c0Var.g = jsonReader.nextLong();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 32);
                    break;
                case "processName":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        androidx.window.layout.c.k("Null processName");
                        return null;
                    }
                    c0Var.f14177b = strNextString;
                    break;
                case "reasonCode":
                    c0Var.f14178c = jsonReader.nextInt();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 2);
                    break;
                case "traceFile":
                    c0Var.h = jsonReader.nextString();
                    break;
                case "importance":
                    c0Var.f14179d = jsonReader.nextInt();
                    c0Var.f14181j = (byte) (c0Var.f14181j | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return c0Var.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x023d, code lost:
    
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0242, code lost:
    
        if (r3 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0244, code lost:
    
        r2.append(" rolloutId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0249, code lost:
    
        if (r4 != null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x024b, code lost:
    
        r2.append(" variantId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0250, code lost:
    
        androidx.window.layout.c.g(r1.i.e(r2, "Missing required properties:"));
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List d(android.util.JsonReader r22, a2.a r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b.d(android.util.JsonReader, a2.a):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x027f, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0284, code lost:
    
        if (r6 != null) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0286, code lost:
    
        r0.append(" name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x028b, code lost:
    
        if (r7 != null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x028d, code lost:
    
        r0.append(" code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0294, code lost:
    
        if ((r4 & 1) != 0) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0296, code lost:
    
        r0.append(" address");
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x029b, code lost:
    
        androidx.window.layout.c.g(r1.i.e(r0, "Missing required properties:"));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Type inference failed for: r19v1, types: [z1.p0] */
    /* JADX WARN: Type inference failed for: r23v1, types: [z1.t0] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [z1.p1] */
    /* JADX WARN: Type inference failed for: r24v2, types: [z1.d0] */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r25v1, types: [z1.u0] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.p0 e(android.util.JsonReader r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b.e(android.util.JsonReader):z1.p0");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.t0 f(android.util.JsonReader r12) throws java.io.IOException {
        /*
            r12.beginObject()
            r0 = 0
            r1 = 0
            r2 = r0
            r8 = r2
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
        Lb:
            boolean r3 = r12.hasNext()
            r9 = 1
            if (r3 == 0) goto L90
            java.lang.String r3 = r12.nextName()
            r3.getClass()
            int r10 = r3.hashCode()
            r11 = -1
            switch(r10) {
                case -1266514778: goto L4d;
                case -934964668: goto L44;
                case 3575610: goto L39;
                case 91997906: goto L2e;
                case 581754413: goto L23;
                default: goto L21;
            }
        L21:
            r9 = r11
            goto L57
        L23:
            java.lang.String r9 = "overflowCount"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L2c
            goto L21
        L2c:
            r9 = 4
            goto L57
        L2e:
            java.lang.String r9 = "causedBy"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L37
            goto L21
        L37:
            r9 = 3
            goto L57
        L39:
            java.lang.String r9 = "type"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L42
            goto L21
        L42:
            r9 = 2
            goto L57
        L44:
            java.lang.String r10 = "reason"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L57
            goto L21
        L4d:
            java.lang.String r9 = "frames"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L56
            goto L21
        L56:
            r9 = r0
        L57:
            switch(r9) {
                case 0: goto L7d;
                case 1: goto L78;
                case 2: goto L6b;
                case 3: goto L66;
                case 4: goto L5e;
                default: goto L5a;
            }
        L5a:
            r12.skipValue()
            goto Lb
        L5e:
            int r8 = r12.nextInt()
            r2 = r2 | 1
            byte r2 = (byte) r2
            goto Lb
        L66:
            z1.t0 r7 = f(r12)
            goto Lb
        L6b:
            java.lang.String r4 = r12.nextString()
            if (r4 == 0) goto L72
            goto Lb
        L72:
            java.lang.String r12 = "Null type"
            androidx.window.layout.c.k(r12)
            return r1
        L78:
            java.lang.String r5 = r12.nextString()
            goto Lb
        L7d:
            a2.a r3 = new a2.a
            r6 = 5
            r3.<init>(r6)
            java.util.List r6 = d(r12, r3)
            if (r6 == 0) goto L8a
            goto Lb
        L8a:
            java.lang.String r12 = "Null frames"
            androidx.window.layout.c.k(r12)
            return r1
        L90:
            r12.endObject()
            if (r2 != r9) goto La0
            if (r4 == 0) goto La0
            if (r6 != 0) goto L9a
            goto La0
        L9a:
            z1.t0 r3 = new z1.t0
            r3.<init>(r4, r5, r6, r7, r8)
            return r3
        La0:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            if (r4 != 0) goto Lac
            java.lang.String r0 = " type"
            r12.append(r0)
        Lac:
            if (r6 != 0) goto Lb3
            java.lang.String r0 = " frames"
            r12.append(r0)
        Lb3:
            r0 = r2 & 1
            if (r0 != 0) goto Lbc
            java.lang.String r0 = " overflowCount"
            r12.append(r0)
        Lbc:
            java.lang.String r0 = "Missing required properties:"
            java.lang.String r12 = r1.i.e(r12, r0)
            androidx.window.layout.c.g(r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b.f(android.util.JsonReader):z1.t0");
    }

    public static z0 g(JsonReader jsonReader) throws IOException {
        y0 y0Var = new y0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "pid":
                    y0Var.f14392b = jsonReader.nextInt();
                    y0Var.e = (byte) (y0Var.e | 1);
                    break;
                case "processName":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        androidx.window.layout.c.k("Null processName");
                        return null;
                    }
                    y0Var.f14391a = strNextString;
                    break;
                case "defaultProcess":
                    y0Var.f14394d = jsonReader.nextBoolean();
                    y0Var.e = (byte) (y0Var.e | 4);
                    break;
                case "importance":
                    y0Var.f14393c = jsonReader.nextInt();
                    y0Var.e = (byte) (y0Var.e | 2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return y0Var.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.b0 h(android.util.JsonReader r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b.h(android.util.JsonReader):z1.b0");
    }

    public static b0 i(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0 b0VarH = h(jsonReader);
                jsonReader.close();
                return b0VarH;
            } finally {
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }
}
