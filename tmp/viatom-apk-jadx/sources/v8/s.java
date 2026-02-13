package v8;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import z8.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements Closeable {
    public static final Logger e = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final z8.k f13267a;

    /* renamed from: b, reason: collision with root package name */
    public final r f13268b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13269c;

    /* renamed from: d, reason: collision with root package name */
    public final c f13270d;

    public s(b0 b0Var, boolean z9) {
        this.f13267a = b0Var;
        this.f13269c = z9;
        r rVar = new r(b0Var);
        this.f13268b = rVar;
        this.f13270d = new c(rVar);
    }

    public static int a(int i10, byte b10, short s9) {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s9 <= i10) {
            return (short) (i10 - s9);
        }
        e.c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s9), Integer.valueOf(i10));
        throw null;
    }

    public static int j(z8.k kVar) {
        return (kVar.readByte() & 255) | ((kVar.readByte() & 255) << 16) | ((kVar.readByte() & 255) << 8);
    }

    public final boolean b(boolean z9, o oVar) throws IOException {
        int i10;
        try {
            this.f13267a.require(9L);
            int iJ = j(this.f13267a);
            if (iJ < 0 || iJ > 16384) {
                e.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iJ));
                throw null;
            }
            byte b10 = (byte) (this.f13267a.readByte() & 255);
            if (z9 && b10 != 4) {
                e.c("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
                throw null;
            }
            byte b11 = (byte) (this.f13267a.readByte() & 255);
            int i11 = this.f13267a.readInt();
            int i12 = Integer.MAX_VALUE & i11;
            Logger logger = e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, i12, iJ, b10, b11));
            }
            switch (b10) {
                case 0:
                    e(oVar, iJ, b11, i12);
                    return true;
                case 1:
                    i(oVar, iJ, b11, i12);
                    return true;
                case 2:
                    if (iJ != 5) {
                        e.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iJ));
                        throw null;
                    }
                    if (i12 == 0) {
                        e.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    z8.k kVar = this.f13267a;
                    kVar.readInt();
                    kVar.readByte();
                    return true;
                case 3:
                    if (iJ != 4) {
                        e.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iJ));
                        throw null;
                    }
                    if (i12 == 0) {
                        e.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int i13 = this.f13267a.readInt();
                    int[] iArrE = c.i.e(11);
                    int length = iArrE.length;
                    int i14 = 0;
                    while (true) {
                        if (i14 < length) {
                            i10 = iArrE[i14];
                            if (r1.i.a(i10) != i13) {
                                i14++;
                            }
                        } else {
                            i10 = 0;
                        }
                    }
                    if (i10 == 0) {
                        e.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i13));
                        throw null;
                    }
                    q qVar = (q) oVar.f13244c;
                    if (i12 != 0 && (i11 & 1) == 0) {
                        qVar.f13252i.execute(new j(qVar, new Object[]{qVar.f13251d, Integer.valueOf(i12)}, i12, i10));
                        return true;
                    }
                    w wVarF = qVar.f(i12);
                    if (wVarF != null) {
                        wVarF.j(i10);
                    }
                    return true;
                case 4:
                    m(oVar, iJ, b11, i12);
                    return true;
                case 5:
                    l(oVar, iJ, b11, i12);
                    return true;
                case 6:
                    k(oVar, iJ, b11, i12);
                    return true;
                case 7:
                    f(oVar, iJ, i12);
                    return true;
                case 8:
                    if (iJ != 4) {
                        e.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iJ));
                        throw null;
                    }
                    long j10 = this.f13267a.readInt() & 2147483647L;
                    if (j10 == 0) {
                        e.c("windowSizeIncrement was 0", Long.valueOf(j10));
                        throw null;
                    }
                    q qVar2 = (q) oVar.f13244c;
                    if (i12 == 0) {
                        synchronized (qVar2) {
                            q qVar3 = (q) oVar.f13244c;
                            qVar3.f13256m += j10;
                            qVar3.notifyAll();
                        }
                        return true;
                    }
                    w wVarD = qVar2.d(i12);
                    if (wVarD != null) {
                        synchronized (wVarD) {
                            wVarD.f13281b += j10;
                            if (j10 > 0) {
                                wVarD.notifyAll();
                            }
                        }
                        return true;
                    }
                    return true;
                default:
                    this.f13267a.skip(iJ);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f13267a.close();
    }

    public final void d(o oVar) {
        if (this.f13269c) {
            if (b(true, oVar)) {
                return;
            }
            e.c("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        z8.l lVar = e.f13216a;
        z8.l byteString = this.f13267a.readByteString(lVar.f14488a.length);
        Level level = Level.FINE;
        Logger logger = e;
        if (logger.isLoggable(level)) {
            String strF = byteString.f();
            byte[] bArr = q8.c.f12289a;
            Locale locale = Locale.US;
            logger.fine("<< CONNECTION " + strF);
        }
        if (lVar.equals(byteString)) {
            return;
        }
        e.c("Expected a connection header but was %s", byteString.r());
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0115, code lost:
    
        if (r8 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0117, code lost:
    
        r4.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(v8.o r17, int r18, byte r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.s.e(v8.o, int, byte, int):void");
    }

    public final void f(o oVar, int i10, int i11) {
        int i12;
        w[] wVarArr;
        if (i10 < 8) {
            e.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            throw null;
        }
        if (i11 != 0) {
            e.c("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int i13 = this.f13267a.readInt();
        int i14 = this.f13267a.readInt();
        int i15 = i10 - 8;
        int[] iArrE = c.i.e(11);
        int length = iArrE.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                i12 = 0;
                break;
            }
            i12 = iArrE[i16];
            if (r1.i.a(i12) == i14) {
                break;
            } else {
                i16++;
            }
        }
        if (i12 == 0) {
            e.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i14));
            throw null;
        }
        z8.l byteString = z8.l.f14487d;
        if (i15 > 0) {
            byteString = this.f13267a.readByteString(i15);
        }
        byteString.e();
        synchronized (((q) oVar.f13244c)) {
            wVarArr = (w[]) ((q) oVar.f13244c).f13250c.values().toArray(new w[((q) oVar.f13244c).f13250c.size()]);
            ((q) oVar.f13244c).g = true;
        }
        for (w wVar : wVarArr) {
            if (wVar.f13282c > i13 && wVar.f()) {
                wVar.j(5);
                ((q) oVar.f13244c).f(wVar.f13282c);
            }
        }
    }

    public final ArrayList h(int i10, short s9, byte b10, int i11) throws IOException {
        r rVar = this.f13268b;
        rVar.e = i10;
        rVar.f13264b = i10;
        rVar.f = s9;
        rVar.f13265c = b10;
        rVar.f13266d = i11;
        c cVar = this.f13270d;
        b0 b0Var = cVar.f13211b;
        ArrayList arrayList = cVar.f13210a;
        while (!b0Var.exhausted()) {
            byte b11 = b0Var.readByte();
            int i12 = b11 & 255;
            if (i12 == 128) {
                com.google.gson.internal.a.m("index == 0");
                return null;
            }
            if ((b11 & 128) == 128) {
                int iE = cVar.e(i12, 127);
                int i13 = iE - 1;
                if (i13 >= 0) {
                    b[] bVarArr = d.f13214a;
                    if (i13 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i13]);
                    }
                }
                int length = cVar.f + 1 + (i13 - d.f13214a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.e;
                    if (length < bVarArr2.length) {
                        arrayList.add(bVarArr2[length]);
                    }
                }
                com.google.gson.internal.a.m(a3.a.f(iE, "Header index too large "));
                return null;
            }
            if (i12 == 64) {
                z8.l lVarD = cVar.d();
                d.a(lVarD);
                cVar.c(new b(lVarD, cVar.d()));
            } else if ((b11 & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i12, 63) - 1), cVar.d()));
            } else if ((b11 & 32) == 32) {
                int iE2 = cVar.e(i12, 31);
                cVar.f13213d = iE2;
                if (iE2 < 0 || iE2 > cVar.f13212c) {
                    p8.u.n(cVar.f13213d, "Invalid dynamic table size update ");
                    return null;
                }
                int i14 = cVar.h;
                if (iE2 < i14) {
                    if (iE2 == 0) {
                        Arrays.fill(cVar.e, (Object) null);
                        cVar.f = cVar.e.length - 1;
                        cVar.g = 0;
                        cVar.h = 0;
                    } else {
                        cVar.a(i14 - iE2);
                    }
                }
            } else if (i12 == 16 || i12 == 0) {
                z8.l lVarD2 = cVar.d();
                d.a(lVarD2);
                arrayList.add(new b(lVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i12, 15) - 1), cVar.d()));
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList.clear();
        return arrayList2;
    }

    public final void i(o oVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z9 = (b10 & 1) != 0;
        short s9 = (b10 & 8) != 0 ? (short) (this.f13267a.readByte() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            z8.k kVar = this.f13267a;
            kVar.readInt();
            kVar.readByte();
            i10 -= 5;
        }
        ArrayList arrayListH = h(a(i10, b10, s9), s9, b10, i11);
        q qVar = (q) oVar.f13244c;
        if (i11 != 0 && (i11 & 1) == 0) {
            try {
                qVar.f13252i.execute(new j(qVar, new Object[]{qVar.f13251d, Integer.valueOf(i11)}, i11, arrayListH, z9));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (qVar) {
            try {
                w wVarD = ((q) oVar.f13244c).d(i11);
                if (wVarD != null) {
                    wVarD.i(arrayListH);
                    if (z9) {
                        wVarD.h();
                        return;
                    }
                    return;
                }
                q qVar2 = (q) oVar.f13244c;
                if (qVar2.g) {
                    return;
                }
                if (i11 <= qVar2.e) {
                    return;
                }
                if (i11 % 2 == qVar2.f % 2) {
                    return;
                }
                w wVar = new w(i11, qVar2, false, z9, arrayListH);
                q qVar3 = (q) oVar.f13244c;
                qVar3.e = i11;
                qVar3.f13250c.put(Integer.valueOf(i11), wVar);
                q.f13247u.execute(new o(oVar, new Object[]{((q) oVar.f13244c).f13251d, Integer.valueOf(i11)}, wVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(o oVar, int i10, byte b10, int i11) {
        if (i10 != 8) {
            e.c("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            throw null;
        }
        if (i11 != 0) {
            e.c("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int i12 = this.f13267a.readInt();
        int i13 = this.f13267a.readInt();
        boolean z9 = (b10 & 1) != 0;
        q qVar = (q) oVar.f13244c;
        if (!z9) {
            try {
                qVar.h.execute(new n(qVar, true, i12, i13));
            } catch (RejectedExecutionException unused) {
            }
        } else {
            synchronized (qVar) {
                q qVar2 = (q) oVar.f13244c;
                qVar2.f13254k = false;
                qVar2.notifyAll();
            }
        }
    }

    public final void l(o oVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s9 = (b10 & 8) != 0 ? (short) (this.f13267a.readByte() & 255) : (short) 0;
        int i12 = this.f13267a.readInt() & Integer.MAX_VALUE;
        ArrayList arrayListH = h(a(i10 - 4, b10, s9), s9, b10, i11);
        q qVar = (q) oVar.f13244c;
        synchronized (qVar) {
            try {
                if (qVar.t.contains(Integer.valueOf(i12))) {
                    qVar.j(i12, 2);
                    return;
                }
                qVar.t.add(Integer.valueOf(i12));
                try {
                    qVar.f13252i.execute(new j(qVar, new Object[]{qVar.f13251d, Integer.valueOf(i12)}, i12, arrayListH));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(o oVar, int i10, byte b10, int i11) {
        long j10;
        w[] wVarArr = null;
        if (i11 != 0) {
            e.c("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b10 & 1) != 0) {
            if (i10 == 0) {
                return;
            }
            e.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        }
        if (i10 % 6 != 0) {
            e.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            throw null;
        }
        h0.a0 a0Var = new h0.a0(4);
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.f13267a.readShort() & 65535;
            int i14 = this.f13267a.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    e.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    e.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                    throw null;
                }
            } else {
                if (i14 < 0) {
                    e.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    throw null;
                }
                i13 = 7;
            }
            a0Var.i(i13, i14);
        }
        synchronized (((q) oVar.f13244c)) {
            try {
                int iC = ((q) oVar.f13244c).f13258o.c();
                h0.a0 a0Var2 = ((q) oVar.f13244c).f13258o;
                a0Var2.getClass();
                for (int i15 = 0; i15 < 10; i15++) {
                    if (((1 << i15) & a0Var.f8352b) != 0) {
                        a0Var2.i(i15, ((int[]) a0Var.f8353c)[i15]);
                    }
                }
                try {
                    q qVar = (q) oVar.f13244c;
                    qVar.h.execute(new o(oVar, new Object[]{qVar.f13251d}, a0Var));
                } catch (RejectedExecutionException unused) {
                }
                int iC2 = ((q) oVar.f13244c).f13258o.c();
                if (iC2 == -1 || iC2 == iC) {
                    j10 = 0;
                } else {
                    j10 = iC2 - iC;
                    q qVar2 = (q) oVar.f13244c;
                    if (!qVar2.f13259p) {
                        qVar2.f13256m += j10;
                        if (j10 > 0) {
                            qVar2.notifyAll();
                        }
                        ((q) oVar.f13244c).f13259p = true;
                    }
                    if (!((q) oVar.f13244c).f13250c.isEmpty()) {
                        wVarArr = (w[]) ((q) oVar.f13244c).f13250c.values().toArray(new w[((q) oVar.f13244c).f13250c.size()]);
                    }
                }
                q.f13247u.execute(new p(oVar, ((q) oVar.f13244c).f13251d));
            } finally {
            }
        }
        if (wVarArr == null || j10 == 0) {
            return;
        }
        for (w wVar : wVarArr) {
            synchronized (wVar) {
                wVar.f13281b += j10;
                if (j10 > 0) {
                    wVar.notifyAll();
                }
            }
        }
    }
}
