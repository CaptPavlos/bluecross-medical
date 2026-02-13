package y1;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements d {

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f13771c = Charset.forName(C.UTF8_NAME);

    /* renamed from: a, reason: collision with root package name */
    public final File f13772a;

    /* renamed from: b, reason: collision with root package name */
    public l f13773b;

    public m(File file) {
        this.f13772a = file;
    }

    @Override // y1.d
    public final void a() throws IOException {
        w1.g.b(this.f13773b, "There was a problem closing the Crashlytics log file.");
        this.f13773b = null;
    }

    public final void b() {
        File file = this.f13772a;
        if (this.f13773b == null) {
            try {
                this.f13773b = new l(file);
            } catch (IOException e) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // y1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() {
        /*
            r7 = this;
            java.io.File r0 = r7.f13772a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r2
            goto L38
        Lc:
            r7.b()
            y1.l r0 = r7.f13773b
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r1}
            int r0 = r0.m()
            byte[] r0 = new byte[r0]
            y1.l r4 = r7.f13773b     // Catch: java.io.IOException -> L29
            y1.f r5 = new y1.f     // Catch: java.io.IOException -> L29
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L29
            r4.e(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            java.lang.String r5 = "A problem occurred while reading the Crashlytics log file."
            java.lang.String r6 = "FirebaseCrashlytics"
            android.util.Log.e(r6, r5, r4)
        L31:
            x4.y r4 = new x4.y
            r3 = r3[r1]
            r4.<init>(r0, r3)
        L38:
            if (r4 != 0) goto L3c
            r3 = r2
            goto L45
        L3c:
            int r0 = r4.f13699b
            byte[] r3 = new byte[r0]
            byte[] r4 = r4.f13698a
            java.lang.System.arraycopy(r4, r1, r3, r1, r0)
        L45:
            if (r3 == 0) goto L4f
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = y1.m.f13771c
            r0.<init>(r3, r1)
            return r0
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.m.c():java.lang.String");
    }

    @Override // y1.d
    public final void e(long j10, String str) {
        b();
        if (this.f13773b == null) {
            return;
        }
        try {
            if (str.length() > 16384) {
                str = "...".concat(str.substring(str.length() - 16384));
            }
            this.f13773b.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f13771c));
            while (!this.f13773b.f() && this.f13773b.m() > 65536) {
                this.f13773b.j();
            }
        } catch (IOException e) {
            Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
        }
    }
}
