package p8;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import l4.x4;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f12096a = new x4(this, 16);

    /* renamed from: b, reason: collision with root package name */
    public final r8.f f12097b;

    public g(File file, long j10) {
        Pattern pattern = r8.f.f12475u;
        if (j10 <= 0) {
            com.google.gson.internal.a.n("maxSize <= 0");
            throw null;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        byte[] bArr = q8.c.f12289a;
        this.f12097b = new r8.f(file, j10, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, linkedBlockingQueue, new q8.b("OkHttp DiskLruCache", true)));
    }

    public static int a(z8.b0 b0Var) throws IOException {
        byte b10;
        try {
            z8.i iVar = b0Var.f14457b;
            b0Var.require(1L);
            long j10 = 0;
            while (true) {
                long j11 = j10 + 1;
                if (!b0Var.request(j11)) {
                    break;
                }
                b10 = iVar.b(j10);
                if ((b10 < 48 || b10 > 57) && (j10 != 0 || b10 != 45)) {
                    break;
                }
                j10 = j11;
            }
            if (j10 == 0) {
                t1.k(16);
                t1.k(16);
                String string = Integer.toString(b10, 16);
                string.getClass();
                throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
            }
            long decimalLong = iVar.readDecimalLong();
            String utf8LineStrict = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                return (int) decimalLong;
            }
            throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            com.google.gson.internal.a.m(e.getMessage());
            return 0;
        }
    }

    public final void b(z zVar) throws NoSuchAlgorithmException {
        r8.f fVar = this.f12097b;
        String str = zVar.f12205a.f12158i;
        z8.l lVar = z8.l.f14487d;
        z8.l lVarU = r0.f.u(str);
        MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        messageDigest.update(lVarU.f14488a, 0, lVarU.e());
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        String strF = new z8.l(bArrDigest).f();
        synchronized (fVar) {
            fVar.f();
            fVar.a();
            r8.f.p(strF);
            r8.d dVar = (r8.d) fVar.f12482k.get(strF);
            if (dVar == null) {
                return;
            }
            fVar.n(dVar);
            if (fVar.f12480i <= fVar.g) {
                fVar.f12487p = false;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12097b.close();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.f12097b.flush();
    }
}
