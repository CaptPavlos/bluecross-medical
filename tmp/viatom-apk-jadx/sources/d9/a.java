package d9;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f7461a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7462b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7463c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7464d;
    public final List e;

    public a(String str, String str2, String str3, String str4, List list) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        list.getClass();
        this.f7461a = str;
        this.f7462b = str2;
        this.f7463c = str3;
        this.f7464d = str4;
        this.e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.l.a(this.f7461a, aVar.f7461a) && kotlin.jvm.internal.l.a(this.f7462b, aVar.f7462b) && kotlin.jvm.internal.l.a(this.f7463c, aVar.f7463c) && kotlin.jvm.internal.l.a(this.f7464d, aVar.f7464d) && kotlin.jvm.internal.l.a(this.e, aVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + a.a.b(this.f7464d, a.a.b(this.f7463c, a.a.b(this.f7462b, this.f7461a.hashCode() * 31)));
    }

    public final String toString() {
        return "AdvancedUILabels(initScreenSettingsButton=" + this.f7461a + ", initScreenRejectButton=" + this.f7462b + ", privacyBody=" + this.f7463c + ", privacyHeader=" + this.f7464d + ", customFooterLink=" + this.e + ')';
    }

    public /* synthetic */ a() {
        this("", "", "", "", new ArrayList());
    }
}
