package d9;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f7483a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7484b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7485c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7486d;
    public final String e;
    public final List f;

    public e(String str, String str2, String str3, String str4, String str5, List list) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        list.getClass();
        this.f7483a = str;
        this.f7484b = str2;
        this.f7485c = str3;
        this.f7486d = str4;
        this.e = str5;
        this.f = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.l.a(this.f7483a, eVar.f7483a) && kotlin.jvm.internal.l.a(this.f7484b, eVar.f7484b) && kotlin.jvm.internal.l.a(this.f7485c, eVar.f7485c) && kotlin.jvm.internal.l.a(this.f7486d, eVar.f7486d) && kotlin.jvm.internal.l.a(this.e, eVar.e) && kotlin.jvm.internal.l.a(this.f, eVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + a.a.b(this.e, a.a.b(this.f7486d, a.a.b(this.f7485c, a.a.b(this.f7484b, this.f7483a.hashCode() * 31))));
    }

    public final String toString() {
        return "ConsentOrPayUILabels(initScreenSettingsButton=" + this.f7483a + ", action1Label=" + this.f7484b + ", action2Label=" + this.f7485c + ", privacyBody=" + this.f7486d + ", privacyHeader=" + this.e + ", customFooterLink=" + this.f + ')';
    }

    public /* synthetic */ e() {
        this("", "", "", "", "", new ArrayList());
    }
}
