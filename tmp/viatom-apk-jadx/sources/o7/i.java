package o7;

import com.google.android.gms.internal.measurement.l5;
import java.util.List;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f11768a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f11769b;

    /* renamed from: c, reason: collision with root package name */
    public h f11770c;

    public i(Matcher matcher, CharSequence charSequence) {
        charSequence.getClass();
        this.f11768a = matcher;
        this.f11769b = charSequence;
    }

    public final List a() {
        if (this.f11770c == null) {
            this.f11770c = new h(this);
        }
        h hVar = this.f11770c;
        hVar.getClass();
        return hVar;
    }

    public final l7.d b() {
        Matcher matcher = this.f11768a;
        return l5.N(matcher.start(), matcher.end());
    }

    public final i c() {
        Matcher matcher = this.f11768a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.f11769b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        matcher2.getClass();
        if (matcher2.find(iEnd)) {
            return new i(matcher2, charSequence);
        }
        return null;
    }
}
