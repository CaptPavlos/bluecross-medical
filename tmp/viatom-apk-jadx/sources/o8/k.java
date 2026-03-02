package o8;

import com.inmobi.cmp.data.model.ChoiceColor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f11820a;

    /* renamed from: b, reason: collision with root package name */
    public final ChoiceColor f11821b;

    /* renamed from: c, reason: collision with root package name */
    public final ChoiceColor f11822c;

    public k(String str, ChoiceColor choiceColor, ChoiceColor choiceColor2) {
        this.f11820a = str;
        this.f11821b = choiceColor;
        this.f11822c = choiceColor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11820a.equals(kVar.f11820a) && kotlin.jvm.internal.l.a(this.f11821b, kVar.f11821b) && kotlin.jvm.internal.l.a(this.f11822c, kVar.f11822c);
    }

    public final int hashCode() {
        int iHashCode = this.f11820a.hashCode() * 31;
        ChoiceColor choiceColor = this.f11821b;
        int iHashCode2 = (iHashCode + (choiceColor == null ? 0 : choiceColor.hashCode())) * 31;
        ChoiceColor choiceColor2 = this.f11822c;
        return iHashCode2 + (choiceColor2 != null ? choiceColor2.hashCode() : 0);
    }

    public final String toString() {
        return "ThemeConfig(themeMode=" + this.f11820a + ", lightModeColors=" + this.f11821b + ", darkModeColors=" + this.f11822c + ')';
    }
}
