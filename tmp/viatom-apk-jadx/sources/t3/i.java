package t3;

import java.net.URL;
import z1.t1;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f12788a;

    /* renamed from: b, reason: collision with root package name */
    public final URL f12789b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12790c;

    public i(String str, URL url, String str2) {
        this.f12788a = str;
        this.f12789b = url;
        this.f12790c = str2;
    }

    public static i a(String str, URL url, String str2) {
        t1.c(str, "VendorKey is null or empty");
        t1.c(str2, "VerificationParameters is null or empty");
        return new i(str, url, str2);
    }
}
