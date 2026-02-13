package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f8311a = new p1();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8312b = new u0("kotlin.uuid.Uuid", e8.d.f7963k);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        String strDecodeString = eVar.decodeString();
        strDecodeString.getClass();
        int length = strDecodeString.length();
        if (length == 32) {
            long jB = o7.c.b(0, 16, strDecodeString);
            long jB2 = o7.c.b(16, 32, strDecodeString);
            if (jB != 0 || jB2 != 0) {
                return new q7.a(jB, jB2);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                sb.append(strDecodeString.length() <= 64 ? strDecodeString : strDecodeString.substring(0, 64).concat("..."));
                sb.append("\" of length ");
                sb.append(strDecodeString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long jB3 = o7.c.b(0, 8, strDecodeString);
            l1.b.r(8, strDecodeString);
            long jB4 = o7.c.b(9, 13, strDecodeString);
            l1.b.r(13, strDecodeString);
            long jB5 = o7.c.b(14, 18, strDecodeString);
            l1.b.r(18, strDecodeString);
            long jB6 = o7.c.b(19, 23, strDecodeString);
            l1.b.r(23, strDecodeString);
            long j10 = (jB4 << 16) | (jB3 << 32) | jB5;
            long jB7 = o7.c.b(24, 36, strDecodeString) | (jB6 << 48);
            if (j10 != 0 || jB7 != 0) {
                return new q7.a(j10, jB7);
            }
        }
        return q7.a.f12283c;
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8312b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        q7.a aVar = (q7.a) obj;
        aVar.getClass();
        fVar.encodeString(aVar.toString());
    }
}
