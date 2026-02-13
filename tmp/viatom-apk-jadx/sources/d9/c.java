package d9;

import android.graphics.Typeface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f7469a;

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f7470b;

    public c(Typeface typeface, Typeface typeface2) {
        this.f7469a = typeface;
        this.f7470b = typeface2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f7469a, cVar.f7469a) && kotlin.jvm.internal.l.a(this.f7470b, cVar.f7470b);
    }

    public final int hashCode() {
        Typeface typeface = this.f7469a;
        int iHashCode = (typeface == null ? 0 : typeface.hashCode()) * 31;
        Typeface typeface2 = this.f7470b;
        return iHashCode + (typeface2 != null ? typeface2.hashCode() : 0);
    }

    public final String toString() {
        return "ChoiceFonts(bold=" + this.f7469a + ", regular=" + this.f7470b + ')';
    }
}
