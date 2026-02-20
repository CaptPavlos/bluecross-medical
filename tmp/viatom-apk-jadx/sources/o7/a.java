package o7;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f11749a;

    static {
        Charset charsetForName = Charset.forName(C.UTF8_NAME);
        charsetForName.getClass();
        f11749a = charsetForName;
        Charset.forName(C.UTF16_NAME).getClass();
        Charset.forName("UTF-16BE").getClass();
        Charset.forName("UTF-16LE").getClass();
        Charset.forName(C.ASCII_NAME).getClass();
        Charset.forName("ISO-8859-1").getClass();
    }
}
