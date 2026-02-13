package c0;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import i0.y;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f970a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f971b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f972c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f973d;
    public final String e;
    public final Account f;
    public final String g;
    public final HashMap h;

    /* renamed from: i, reason: collision with root package name */
    public String f974i;

    public b(GoogleSignInOptions googleSignInOptions) {
        this.f970a = new HashSet();
        this.h = new HashMap();
        y.g(googleSignInOptions);
        this.f970a = new HashSet(googleSignInOptions.f1839b);
        this.f971b = googleSignInOptions.e;
        this.f972c = googleSignInOptions.f;
        this.f973d = googleSignInOptions.f1841d;
        this.e = googleSignInOptions.g;
        this.f = googleSignInOptions.f1840c;
        this.g = googleSignInOptions.h;
        this.h = GoogleSignInOptions.c(googleSignInOptions.f1842i);
        this.f974i = googleSignInOptions.f1843j;
    }

    public b() {
        this.f970a = new HashSet();
        this.h = new HashMap();
    }
}
