package v8;

import com.mbridge.msdk.thrid.okhttp.internal.http2.Header;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final z8.l f13205d;
    public static final z8.l e;
    public static final z8.l f;
    public static final z8.l g;
    public static final z8.l h;

    /* renamed from: i, reason: collision with root package name */
    public static final z8.l f13206i;

    /* renamed from: a, reason: collision with root package name */
    public final z8.l f13207a;

    /* renamed from: b, reason: collision with root package name */
    public final z8.l f13208b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13209c;

    static {
        z8.l lVar = z8.l.f14487d;
        f13205d = r0.f.u(":");
        e = r0.f.u(Header.RESPONSE_STATUS_UTF8);
        f = r0.f.u(Header.TARGET_METHOD_UTF8);
        g = r0.f.u(Header.TARGET_PATH_UTF8);
        h = r0.f.u(Header.TARGET_SCHEME_UTF8);
        f13206i = r0.f.u(Header.TARGET_AUTHORITY_UTF8);
    }

    public b(z8.l lVar, z8.l lVar2) {
        this.f13207a = lVar;
        this.f13208b = lVar2;
        this.f13209c = lVar2.e() + lVar.e() + 32;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f13207a.equals(bVar.f13207a) && this.f13208b.equals(bVar.f13208b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13208b.hashCode() + ((this.f13207a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String strR = this.f13207a.r();
        String strR2 = this.f13208b.r();
        byte[] bArr = q8.c.f12289a;
        Locale locale = Locale.US;
        return a3.a.j(strR, ": ", strR2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(z8.l lVar, String str) {
        this(lVar, r0.f.u(str));
        z8.l lVar2 = z8.l.f14487d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(r0.f.u(str), r0.f.u(str2));
        z8.l lVar = z8.l.f14487d;
    }
}
