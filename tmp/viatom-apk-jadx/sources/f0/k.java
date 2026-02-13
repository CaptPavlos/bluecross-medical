package f0;

import i0.y;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f8016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8017b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f8018c;

    public /* synthetic */ k(boolean z9, String str, n nVar) {
        this.f8016a = z9;
        this.f8017b = str;
        this.f8018c = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        boolean z9 = this.f8016a;
        String str = this.f8017b;
        n nVar = this.f8018c;
        String str2 = (z9 || !p.b(str, nVar, true, false).f8034a) ? "not allowed" : "debug cert rejected";
        int i10 = 0;
        while (true) {
            if (i10 >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                break;
            }
            i10++;
        }
        y.g(messageDigest);
        byte[] bArrDigest = messageDigest.digest(nVar.f8023k);
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i11 = 0;
        for (byte b10 : bArrDigest) {
            char[] cArr2 = n0.b.f11268b;
            cArr[i11] = cArr2[(b10 & 255) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
            i11 += 2;
        }
        return str2 + ": pkg=" + str + ", sha256=" + new String(cArr) + ", atk=" + z9 + ", ver=12451000.false";
    }
}
