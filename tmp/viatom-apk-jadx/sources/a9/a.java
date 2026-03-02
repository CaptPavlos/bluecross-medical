package a9;

import java.io.EOFException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f329a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(o7.a.f11749a);
        bytes.getClass();
        f329a = bytes;
    }

    public static final String a(z8.i iVar, long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (iVar.b(j11) == 13) {
                String string = iVar.readString(j11, o7.a.f11749a);
                iVar.skip(2L);
                return string;
            }
        }
        String string2 = iVar.readString(j10, o7.a.f11749a);
        iVar.skip(1L);
        return string2;
    }
}
