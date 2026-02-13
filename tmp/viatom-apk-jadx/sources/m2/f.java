package m2;

import androidx.work.WorkInfo;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements j2.e {
    public static final Charset f = Charset.forName(C.UTF8_NAME);
    public static final j2.c g = new j2.c("key", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(e.class, new a(1))));
    public static final j2.c h = new j2.c("value", com.mbridge.msdk.dycreator.baseview.a.l(com.mbridge.msdk.dycreator.baseview.a.k(e.class, new a(2))));

    /* renamed from: i, reason: collision with root package name */
    public static final l2.a f11166i = new l2.a(1);

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f11167a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f11168b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f11169c;

    /* renamed from: d, reason: collision with root package name */
    public final j2.d f11170d;
    public final h e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, j2.d dVar) {
        this.f11167a = byteArrayOutputStream;
        this.f11168b = map;
        this.f11169c = map2;
        this.f11170d = dVar;
    }

    public static int k(j2.c cVar) {
        e eVar = (e) ((Annotation) cVar.f9910b.get(e.class));
        if (eVar != null) {
            return eVar.tag();
        }
        throw new j2.b("Field has no @Protobuf config");
    }

    @Override // j2.e
    public final j2.e a(j2.c cVar, Object obj) {
        i(cVar, obj, true);
        return this;
    }

    public final void b(j2.c cVar, double d8, boolean z9) throws IOException {
        if (z9 && d8 == 0.0d) {
            return;
        }
        l((k(cVar) << 3) | 1);
        this.f11167a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d8).array());
    }

    public final void c(j2.c cVar, int i10, boolean z9) {
        if (z9 && i10 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f9910b.get(e.class));
        if (eVar == null) {
            throw new j2.b("Field has no @Protobuf config");
        }
        int iOrdinal = eVar.intEncoding().ordinal();
        if (iOrdinal == 0) {
            l(eVar.tag() << 3);
            l(i10);
        } else if (iOrdinal == 1) {
            l(eVar.tag() << 3);
            l((i10 << 1) ^ (i10 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            l((eVar.tag() << 3) | 5);
            this.f11167a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i10).array());
        }
    }

    @Override // j2.e
    public final j2.e d(j2.c cVar, int i10) {
        c(cVar, i10, true);
        return this;
    }

    @Override // j2.e
    public final j2.e e(j2.c cVar, long j10) throws IOException {
        h(cVar, j10, true);
        return this;
    }

    @Override // j2.e
    public final j2.e f(j2.c cVar, double d8) throws IOException {
        b(cVar, d8, true);
        return this;
    }

    @Override // j2.e
    public final j2.e g(j2.c cVar, boolean z9) {
        c(cVar, z9 ? 1 : 0, true);
        return this;
    }

    public final void h(j2.c cVar, long j10, boolean z9) throws IOException {
        if (z9 && j10 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f9910b.get(e.class));
        if (eVar == null) {
            throw new j2.b("Field has no @Protobuf config");
        }
        int iOrdinal = eVar.intEncoding().ordinal();
        if (iOrdinal == 0) {
            l(eVar.tag() << 3);
            m(j10);
        } else if (iOrdinal == 1) {
            l(eVar.tag() << 3);
            m((j10 >> 63) ^ (j10 << 1));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            l((eVar.tag() << 3) | 1);
            this.f11167a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j10).array());
        }
    }

    public final void i(j2.c cVar, Object obj, boolean z9) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z9 && charSequence.length() == 0) {
                return;
            }
            l((k(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            l(bytes.length);
            this.f11167a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                i(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                j(f11166i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            b(cVar, ((Double) obj).doubleValue(), z9);
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z9 && fFloatValue == 0.0f) {
                return;
            }
            l((k(cVar) << 3) | 5);
            this.f11167a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            h(cVar, ((Number) obj).longValue(), z9);
            return;
        }
        if (obj instanceof Boolean) {
            c(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z9);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z9 && bArr.length == 0) {
                return;
            }
            l((k(cVar) << 3) | 2);
            l(bArr.length);
            this.f11167a.write(bArr);
            return;
        }
        j2.d dVar = (j2.d) this.f11168b.get(obj.getClass());
        if (dVar != null) {
            j(dVar, cVar, obj, z9);
            return;
        }
        j2.f fVar = (j2.f) this.f11169c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.e;
            hVar.f11172a = false;
            hVar.f11174c = cVar;
            hVar.f11173b = z9;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            c(cVar, ((c) obj).getNumber(), true);
        } else if (obj instanceof Enum) {
            c(cVar, ((Enum) obj).ordinal(), true);
        } else {
            j(this.f11170d, cVar, obj, z9);
        }
    }

    public final void j(j2.d dVar, j2.c cVar, Object obj, boolean z9) throws IOException {
        b bVar = new b();
        bVar.f11163a = 0L;
        try {
            OutputStream outputStream = this.f11167a;
            this.f11167a = bVar;
            try {
                dVar.a(obj, this);
                this.f11167a = outputStream;
                long j10 = bVar.f11163a;
                bVar.close();
                if (z9 && j10 == 0) {
                    return;
                }
                l((k(cVar) << 3) | 2);
                m(j10);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f11167a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void l(int i10) throws IOException {
        while (true) {
            long j10 = i10 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            OutputStream outputStream = this.f11167a;
            if (j10 == 0) {
                outputStream.write(i10 & 127);
                return;
            } else {
                outputStream.write((i10 & 127) | 128);
                i10 >>>= 7;
            }
        }
    }

    public final void m(long j10) throws IOException {
        while (true) {
            long j11 = (-128) & j10;
            OutputStream outputStream = this.f11167a;
            if (j11 == 0) {
                outputStream.write(((int) j10) & 127);
                return;
            } else {
                outputStream.write((((int) j10) & 127) | 128);
                j10 >>>= 7;
            }
        }
    }
}
