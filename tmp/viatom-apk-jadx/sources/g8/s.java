package g8;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final s f8323a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8324b = new u0("kotlin.time.Duration", e8.d.f7963k);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        int i10 = p7.a.f12038d;
        String strDecodeString = eVar.decodeString();
        strDecodeString.getClass();
        try {
            return new p7.a(l1.b.g(strDecodeString));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.widgets.analyzer.a.x("Invalid ISO duration string format: '", strDecodeString, "'."), e);
        }
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8324b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        long j10;
        long j11;
        int iG;
        long j12 = ((p7.a) obj).f12039a;
        int i10 = p7.a.f12038d;
        StringBuilder sb = new StringBuilder();
        if (j12 < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z9 = true;
        if (j12 < 0) {
            j10 = ((-(j12 >> 1)) << 1) + (((int) j12) & 1);
            int i11 = p7.b.f12040a;
        } else {
            j10 = j12;
        }
        long jG = p7.a.g(j10, p7.c.HOURS);
        if (p7.a.e(j10)) {
            j11 = 0;
            iG = 0;
        } else {
            j11 = 0;
            iG = (int) (p7.a.g(j10, p7.c.MINUTES) % 60);
        }
        int iG2 = p7.a.e(j10) ? 0 : (int) (p7.a.g(j10, p7.c.SECONDS) % 60);
        int iD = p7.a.d(j10);
        if (p7.a.e(j12)) {
            jG = 9999999999999L;
        }
        boolean z10 = jG != j11;
        boolean z11 = (iG2 == 0 && iD == 0) ? false : true;
        if (iG == 0 && (!z11 || !z10)) {
            z9 = false;
        }
        if (z10) {
            sb.append(jG);
            sb.append('H');
        }
        if (z9) {
            sb.append(iG);
            sb.append('M');
        }
        if (z11 || (!z10 && !z9)) {
            p7.a.b(sb, iG2, iD, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        fVar.encodeString(sb.toString());
    }
}
