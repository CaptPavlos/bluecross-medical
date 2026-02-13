package w2;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f13469d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f13470a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13471b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13472c;

    public t(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f13469d.matcher(strSubstring).matches()) {
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
            throw null;
        }
        this.f13470a = strSubstring;
        this.f13471b = str;
        this.f13472c = a3.a.j(str, "!", str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f13470a.equals(tVar.f13470a) && this.f13471b.equals(tVar.f13471b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13471b, this.f13470a});
    }
}
