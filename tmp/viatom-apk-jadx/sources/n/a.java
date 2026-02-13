package n;

import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f11255c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f11256d;
    public static final a e;
    public static final a f;

    /* renamed from: a, reason: collision with root package name */
    public final String f11257a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11258b;

    static {
        String strZ = a4.z("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f11255c = strZ;
        String strZ2 = a4.z("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strZ3 = a4.z("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f11256d = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(new m.c("proto"), new m.c("json"))));
        e = new a(strZ, null);
        f = new a(strZ2, strZ3);
    }

    public a(String str, String str2) {
        this.f11257a = str;
        this.f11258b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName(C.UTF8_NAME));
        if (!str.startsWith("1$")) {
            com.google.gson.internal.a.n("Version marker missing from extras");
            return null;
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            com.google.gson.internal.a.n("Extra is not a valid encoded LegacyFlgDestination");
            return null;
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            com.google.gson.internal.a.n("Missing endpoint in CCTDestination extras");
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
